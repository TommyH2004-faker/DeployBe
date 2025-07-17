package com.example.WebsiteMHiepBe.service.order;

import com.example.WebsiteMHiepBe.dao.*;
import com.example.WebsiteMHiepBe.entity.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService{
    private final ObjectMapper objectMapper;
    @Autowired
    private OrderRepositoory orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private PlasticItemReposiroty plasticItemReposiroty;
    @Autowired
    private PaymentRepository paymentRepository;
    public OrderServiceImp(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public ResponseEntity<?> save(JsonNode jsonData) {
        try{

            Order orderData = objectMapper.treeToValue(jsonData, Order.class);
            orderData.setTotalPrice(orderData.getTotalPriceProduct());
            orderData.setDateCreated(Date.valueOf(LocalDate.now()));
            orderData.setStatus("Đang xử lý");

            int idUser = Integer.parseInt(formatStringByJson(String.valueOf(jsonData.get("idUser"))));
            Optional<User> user = userRepository.findById(idUser);
            orderData.setUser(user.get());

            int idPayment = Integer.parseInt(formatStringByJson(String.valueOf(jsonData.get("idPayment"))));
            Optional<Payment> payment = paymentRepository.findById(idPayment);
            orderData.setPayment(payment.get());

            Order newOrder = orderRepository.save(orderData);

            JsonNode jsonNode = jsonData.get("book");
            for (JsonNode node : jsonNode) {
                int quantity = Integer.parseInt(formatStringByJson(String.valueOf(node.get("quantity"))));
                PlasticItem plasticItem = objectMapper.treeToValue(node.get("plasticItem"), PlasticItem.class);
                Optional<PlasticItem> plasticItem1 = plasticItemReposiroty.findById(plasticItem.getIdPlasticItem());
                plasticItem1.get().setQuantity(plasticItem1.get().getQuantity() - quantity);
                plasticItem1.get().setSoldQuantity(plasticItem1.get().getSoldQuantity() + quantity);

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setPlasticItem(plasticItem1.get());
                orderDetail.setQuantity(quantity);
                orderDetail.setOrder(newOrder);
                orderDetail.setPrice(quantity * plasticItem1.get().getSellPrice());
                orderDetail.setReview(false);
                orderDetailRepository.save(orderDetail);
                plasticItemReposiroty.save(plasticItem1.get());
            }

            cartItemRepository.deleteCartItemsByIdUser(user.get().getIdUser());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    public ResponseEntity<?> update(JsonNode jsonData) {
        try{
            int idOrder =  Integer.parseInt(formatStringByJson(String.valueOf(jsonData.get("idOrder"))));
            String status = formatStringByJson(String.valueOf(jsonData.get("status")));
            Optional<Order> order = orderRepository.findById(idOrder);
            order.get().setStatus(status);

            // Lấy ra order detail
            if (status.equals("Bị huỷ")) {
                List<OrderDetail> orderDetailList = orderDetailRepository.findOrderDetailsByOrder(order.get());
                for (OrderDetail orderDetail : orderDetailList) {
                    PlasticItem plasticItemOrderDetail = orderDetail.getPlasticItem();
                    plasticItemOrderDetail.setSoldQuantity(plasticItemOrderDetail.getSoldQuantity() - orderDetail.getQuantity());
                    plasticItemOrderDetail.setQuantity(plasticItemOrderDetail.getQuantity() + orderDetail.getQuantity());
                    plasticItemReposiroty.save(plasticItemOrderDetail);

                }
            }

            orderRepository.save(order.get());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> cancel(JsonNode jsonData) {
        try{
            int idUser = Integer.parseInt(formatStringByJson(String.valueOf(jsonData.get("idUser"))));
            User user = userRepository.findById(idUser).get();

            Order order = orderRepository.findFirstByUserOrderByIdOrderDesc(user);
            order.setStatus("Bị huỷ");

            List<OrderDetail> orderDetailList = orderDetailRepository.findOrderDetailsByOrder(order);
            for (OrderDetail orderDetail : orderDetailList) {
                PlasticItem plasticItemOrderDetail = orderDetail.getPlasticItem();
                plasticItemOrderDetail.setSoldQuantity(plasticItemOrderDetail.getSoldQuantity() - orderDetail.getQuantity());
                plasticItemOrderDetail.setQuantity(plasticItemOrderDetail.getQuantity() + orderDetail.getQuantity());
                plasticItemReposiroty.save(plasticItemOrderDetail);
            }

            orderRepository.save(order);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
    private String formatStringByJson(String json) {
        return json.replaceAll("\"", "");
    }
}
