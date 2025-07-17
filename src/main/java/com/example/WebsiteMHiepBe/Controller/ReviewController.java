package com.example.WebsiteMHiepBe.Controller;


import com.example.WebsiteMHiepBe.dao.*;
import com.example.WebsiteMHiepBe.entity.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RequestMapping("/review")
@RestController
public class ReviewController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepositoory orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private PlasticItemReposiroty plasticItemReposiroty;
    @Autowired
    private ReviewRepository reviewRepository;
    private final ObjectMapper objectMapper;

    public ReviewController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @GetMapping("/get-all-reviews")
    public ResponseEntity<?> getAllReviews() {
        try {
            return ResponseEntity.ok(reviewRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/add-review")
    public ResponseEntity<?> save(@RequestBody JsonNode jsonNode) {
        try{
            int idUser = Integer.parseInt(formatStringByJson(String.valueOf(jsonNode.get("idUser"))));
            int idOrder = Integer.parseInt(formatStringByJson(String.valueOf(jsonNode.get("idOrder"))));
            int idPlasticItem = Integer.parseInt(formatStringByJson(String.valueOf(jsonNode.get("idPlasticItem"))));
            float ratingValue = Float.parseFloat(formatStringByJson(String.valueOf(jsonNode.get("ratingPoint"))));
            String content = formatStringByJson(String.valueOf(jsonNode.get("content")));

            User user = userRepository.findById(idUser).get();
            Order order = orderRepository.findById(idOrder).get();
            PlasticItem plasticItem = plasticItemReposiroty.findById(idPlasticItem).get();
            List<OrderDetail> orderDetailList = orderDetailRepository.findOrderDetailsByOrder(order);



            for (OrderDetail orderDetail : orderDetailList) {
                if (orderDetail.getPlasticItem().getIdPlasticItem() == idPlasticItem) {
                    orderDetail.setReview(true);
                    Review review = new Review();
                    review.setPlasticItem(plasticItem);
                    review.setUser(user);
                    review.setContent(content);
                    review.setRatingPoint(ratingValue);
                    review.setOrderDetail(orderDetail);
                    // Lấy thời gian hiện tại
                    Instant instant = Instant.now();
                    // Chuyển đổi thành timestamp
                    Timestamp timestamp = Timestamp.from(instant);
                    review.setTimestamp(timestamp);
                    orderDetailRepository.save(orderDetail);
                    reviewRepository.save(review);
                    break;
                }
            }

            // Set lại rating trung bình của quyển sách đó
            List<Review> reviewList = reviewRepository.findAll();
            double sum = 0; // Tổng rating
            int n = 0; // Số lượng rating
            for (Review review : reviewList) {
                if (review.getPlasticItem().getIdPlasticItem() == idPlasticItem) {
                    n++;
                    sum += review.getRatingPoint();
                }
            }
            double ratingAvg = sum / n;
            plasticItem.setAvgRating(ratingAvg);
            plasticItemReposiroty.save(plasticItem);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-review")
    public ResponseEntity<?> updateReview(@RequestBody JsonNode jsonNode) {
        try{
            Review reviewRequest = objectMapper.treeToValue(jsonNode, Review.class);
            Review review = reviewRepository.findById(reviewRequest.getIdReview()).get();
            review.setContent(reviewRequest.getContent());
            review.setRatingPoint(reviewRequest.getRatingPoint());

            reviewRepository.save(review);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/get-review")
    public ResponseEntity<?> getReview(@RequestBody JsonNode jsonNode) {
        try{
            int idOrder = Integer.parseInt(formatStringByJson(String.valueOf(jsonNode.get("idOrder"))));

            int idPlasticItem = Integer.parseInt(formatStringByJson(String.valueOf(jsonNode.get("idPlasticItem"))));
            Order order = orderRepository.findById(idOrder).get();
            PlasticItem plasticItem = plasticItemReposiroty.findById(idPlasticItem).get();

            List<OrderDetail> orderDetailList = orderDetailRepository.findOrderDetailsByOrder(order);
            for (OrderDetail orderDetail : orderDetailList) {
                if (orderDetail.getPlasticItem().getIdPlasticItem() ==plasticItem.getIdPlasticItem()) {
                    Review review = reviewRepository.findReviewByOrderDetail(orderDetail);
                    Review reviewResponse = new Review(); // Trả review luôn bị lỗi không được, nên phải dùng cách này
                    reviewResponse.setIdReview(review.getIdReview());
                    reviewResponse.setContent(review.getContent());
                    reviewResponse.setTimestamp(review.getTimestamp());
                    reviewResponse.setRatingPoint(review.getRatingPoint());
                    return ResponseEntity.status(HttpStatus.OK).body(reviewResponse);
                }
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
@GetMapping("/idReview/user")
public ResponseEntity<?> getUserReview(@PathVariable int id) {
    Optional<Review> optionalReview = reviewRepository.findById(id);

    if (optionalReview.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Không tìm thấy review với ID: " + id);
    }

    User user = optionalReview.get().getUser();
    return ResponseEntity.ok(user);
}
    private String formatStringByJson(String json) {
        return json.replaceAll("\"", "");
    }
}
