package com.example.WebsiteMHiepBe.Controller;

import com.example.WebsiteMHiepBe.dao.FavoriteItemRepository;
import com.example.WebsiteMHiepBe.dao.PlasticItemReposiroty;
import com.example.WebsiteMHiepBe.dao.UserRepository;
import com.example.WebsiteMHiepBe.entity.FavoriteItem;
import com.example.WebsiteMHiepBe.entity.PlasticItem;
import com.example.WebsiteMHiepBe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/favorite-plastic")
public class FavoritePlasticController {
    @Autowired
    private PlasticItemReposiroty plasticItemReposiroty;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriteItemRepository favoriteItemRepository;
    @GetMapping("/get-favorite-plastic/{idUser}")
    public ResponseEntity<?> getAllPlasticByIdUser(@PathVariable Integer idUser){
        try{
            User user = userRepository.findById(idUser).get();
            List<FavoriteItem> favoriteItemList = favoriteItemRepository.findFavoriteItemsByUser(user);
            List<Integer> idPlasticListOfFavoriteIte = new ArrayList<>();
            for(FavoriteItem favoriteItem : favoriteItemList) {
                idPlasticListOfFavoriteIte.add(favoriteItem.getPlasticItem().getIdPlasticItem());
            }
            return ResponseEntity.ok().body(idPlasticListOfFavoriteIte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/add-plastic")
    public ResponseEntity<?> save(@RequestBody FavoriteItem favoriteItem) {
        try {
            int idPlastic = favoriteItem.getPlasticItem().getIdPlasticItem();
            int idUser = favoriteItem.getUser().getIdUser();

            PlasticItem plasticItem = plasticItemReposiroty.findById(idPlastic).orElse(null);
            User user = userRepository.findById(idUser).orElse(null);

            if (plasticItem == null || user == null) {
                return ResponseEntity.badRequest().body("Invalid plastic item or user ID");
            }

            FavoriteItem newFavoriteItem = FavoriteItem.builder()
                    .plasticItem(plasticItem)
                    .user(user)
                    .build();

            favoriteItemRepository.save(newFavoriteItem);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete-plastic")
    public ResponseEntity<?> remove(@RequestBody FavoriteItem favoriteItem) {
        try {
            int idPlastic = favoriteItem.getPlasticItem().getIdPlasticItem();
            int idUser = favoriteItem.getUser().getIdUser();

            PlasticItem plasticItem = plasticItemReposiroty.findById(idPlastic).orElse(null);
            User user = userRepository.findById(idUser).orElse(null);

            if (plasticItem == null || user == null) {
                return ResponseEntity.badRequest().body("Invalid plastic item or user ID");
            }

            FavoriteItem existingFavoriteItem = favoriteItemRepository.findByPlasticItemAndUser(plasticItem, user);
            if (existingFavoriteItem != null) {
                favoriteItemRepository.delete(existingFavoriteItem);
            } else {
                return ResponseEntity.badRequest().body("Favorite item not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
