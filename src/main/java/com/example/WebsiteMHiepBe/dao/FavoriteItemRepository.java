package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.FavoriteItem;
import com.example.WebsiteMHiepBe.entity.PlasticItem;
import com.example.WebsiteMHiepBe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "favorite-items")
public interface FavoriteItemRepository  extends JpaRepository<FavoriteItem, Integer> {
    public  List<FavoriteItem> findFavoriteItemsByUser(User user);

    public FavoriteItem findByPlasticItemAndUser(PlasticItem plasticItem, User user);
    // Define any custom query methods if needed
}
