package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.Image;
import com.example.WebsiteMHiepBe.entity.PlasticItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "images")
public interface ImageRepository extends JpaRepository<Image, Integer> {
     void deleteAllByPlasticItem(PlasticItem plasticItem);


     public  List<Image> findImageByPlasticItem(PlasticItem plasticItem);
     @Modifying
     @Transactional
     @Query("DELETE FROM Image i WHERE i.plasticItem.idPlasticItem = :plasticId  AND i.thumbnail = false")
     void deleteIImagesWithFalseThumnailByPlaticId(@Param("plasticId") int idPlasticItem);
}
