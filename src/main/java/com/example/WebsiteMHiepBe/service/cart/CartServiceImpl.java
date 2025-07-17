package com.example.WebsiteMHiepBe.service.cart;

import com.example.WebsiteMHiepBe.dao.CartItemRepository;
import com.example.WebsiteMHiepBe.dao.PlasticItemReposiroty;
import com.example.WebsiteMHiepBe.dao.UserRepository;
import com.example.WebsiteMHiepBe.entity.CartItem;
import com.example.WebsiteMHiepBe.entity.PlasticItem;
import com.example.WebsiteMHiepBe.entity.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements  CartService{
private final ObjectMapper objectMapper ;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public PlasticItemReposiroty plasticItemRepository;
    @Autowired
    public CartItemRepository cartItemRepository;
    public CartServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

/*   @Override
    public ResponseEntity<?> save(JsonNode jsonNode) {
        try {
            int idUser = 0;
            List<CartItem> cartItemList = new ArrayList<>();
            for(JsonNode jsonDatum : jsonNode) {
                CartItem cartItem = objectMapper.treeToValue(jsonDatum, CartItem.class);
                idUser = Integer.parseInt(formatStringByJson(String.valueOf(jsonDatum.get("idUser"))));
                cartItemList.add(cartItem);
            }
            Optional<User> user = userRepository.findById(idUser);
            List<CartItem> cartItemList1 = user.get().getListCartItems();

            for( CartItem cartItem :cartItemList1){
                boolean isHad = false;
                for (CartItem cartItemData : cartItemList) {
                    if (cartItem.getPlasticItem().getIdPlasticItem() == cartItemData.getPlasticItem().getIdPlasticItem()) {
                        cartItem.setQuantity(cartItem.getQuantity() + cartItemData.getQuantity());
                        isHad = true;
                        break;
                    }
                }
                if (!isHad) {
                    CartItem newCartItem = new CartItem();
                    newCartItem.setUser(user.get());
                    newCartItem.setQuantity(cartItem.getQuantity());
                    newCartItem.setPlasticItem(cartItem.getPlasticItem());
                    cartItemList1.add(newCartItem);
                }
            }
            user.get().setListCartItems(cartItemList1);
            User newUser = userRepository.save(user.get());
            if(cartItemList1.size()==1){
                List<CartItem> cartItemList2 = newUser.getListCartItems();
                return ResponseEntity.ok(cartItemList2.get(cartItemList1.size()-1).getIdCart());
            }
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }*/
/* @Override
 public ResponseEntity<?> save(JsonNode jsonNode) {
     try {
         int idUser = 0;
         List<CartItem> newCartItems = new ArrayList<>();

         // Duyệt dữ liệu từ frontend
         for (JsonNode itemNode : jsonNode) {
             idUser = itemNode.get("idUser").asInt();
             CartItem newItem = objectMapper.treeToValue(itemNode, CartItem.class);
             newCartItems.add(newItem);
         }

         Optional<User> optionalUser = userRepository.findById(idUser);
         if (optionalUser.isEmpty()) {
             return ResponseEntity.badRequest().body("User không tồn tại");
         }

         User user = optionalUser.get();
         List<CartItem> currentCart = user.getListCartItems();

         for (CartItem newItem : newCartItems) {
             boolean isExist = false;
             for (CartItem oldItem : currentCart) {
                 if (oldItem.getPlasticItem().getIdPlasticItem() == newItem.getPlasticItem().getIdPlasticItem()) {
                     oldItem.setQuantity(oldItem.getQuantity() + newItem.getQuantity());
                     isExist = true;
                     break;
                 }
             }

             if (!isExist) {
                 CartItem freshItem = new CartItem();
                 freshItem.setUser(user);
                 freshItem.setPlasticItem(newItem.getPlasticItem());
                 freshItem.setQuantity(newItem.getQuantity());
                 currentCart.add(freshItem);
             }
         }

         user.setListCartItems(currentCart);
         User savedUser = userRepository.save(user);

         // Nếu thêm mới 1 sản phẩm thì trả về idCart đó
         if (newCartItems.size() == 1) {
             List<CartItem> cartItems = savedUser.getListCartItems();
             CartItem lastItem = cartItems.get(cartItems.size() - 1);
             return ResponseEntity.ok(lastItem.getIdCart());
         }

         return ResponseEntity.ok().build();

     } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body("Lỗi khi lưu giỏ hàng");
     }
 }*/
@Override
@Transactional
public ResponseEntity<?> save(JsonNode jsonNode) {
    try {
        int idUser = 0;
        List<CartItem> newCartItems = new ArrayList<>();

        for (JsonNode itemNode : jsonNode) {
            idUser = itemNode.get("idUser").asInt();

            JsonNode plasticNode = itemNode.get("plastic"); // <- đúng với FE
            if (plasticNode == null || plasticNode.get("idPlasticItem") == null) {
                return ResponseEntity.badRequest().body("Thiếu plastic.idPlasticItem trong dữ liệu");
            }

            int idPlasticItem = plasticNode.get("idPlasticItem").asInt();
            int quantity = itemNode.get("quantity").asInt();

            Optional<PlasticItem> optionalPlasticItem = plasticItemRepository.findById(idPlasticItem);
            if (optionalPlasticItem.isEmpty()) {
                return ResponseEntity.badRequest().body("Không tìm thấy sản phẩm với id: " + idPlasticItem);
            }

            PlasticItem plasticItem = optionalPlasticItem.get();

            CartItem newItem = new CartItem();
            newItem.setPlasticItem(plasticItem);
            newItem.setQuantity(quantity);
            newCartItems.add(newItem);
        }



        Optional<User> optionalUser = userRepository.findById(idUser);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.badRequest().body("User không tồn tại");
        }

        User user = optionalUser.get();
        List<CartItem> currentCart = user.getListCartItems();

        for (CartItem newItem : newCartItems) {
            boolean isExist = false;

            for (CartItem oldItem : currentCart) {
                if (oldItem.getPlasticItem().getIdPlasticItem() == newItem.getPlasticItem().getIdPlasticItem()) {
                    oldItem.setQuantity(oldItem.getQuantity() + newItem.getQuantity());
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                CartItem freshItem = new CartItem();
                freshItem.setUser(user);
                freshItem.setPlasticItem(newItem.getPlasticItem());
                freshItem.setQuantity(newItem.getQuantity());
                currentCart.add(freshItem);
            }
        }

        user.setListCartItems(currentCart);
        User savedUser = userRepository.save(user);

        if (newCartItems.size() == 1) {
            List<CartItem> cartItems = savedUser.getListCartItems();
            CartItem lastItem = cartItems.get(cartItems.size() - 1);
            return ResponseEntity.ok(lastItem.getIdCart());
        }

        return ResponseEntity.ok().build();

    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body("Lỗi khi lưu giỏ hàng");
    }
}


    @Override
    public ResponseEntity<?> update(JsonNode jsonNode) {
        try{
            int idCart=Integer.parseInt(formatStringByJson(String.valueOf(jsonNode.get("idCart"))));
            int quantity = Integer.parseInt(formatStringByJson(String.valueOf(jsonNode.get("quantity"))));
            Optional<CartItem> cartItemOptional = cartItemRepository.findById(idCart);
            cartItemRepository.save(cartItemOptional.get());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(cartItemRepository.findAll());
    }
    private String formatStringByJson(String json) {
        return json.replaceAll("\"", "");
    }
}
