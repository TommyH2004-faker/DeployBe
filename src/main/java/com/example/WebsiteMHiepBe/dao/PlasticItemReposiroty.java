package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.PlasticItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "plastic-items")
public interface PlasticItemReposiroty extends JpaRepository<PlasticItem, Integer> {
    // Define any custom query methods if needed
    Page<PlasticItem> findByNamePlasticItemContaining(@RequestParam("namePlastic") String namePlastic, Pageable pageable);
    Page<PlasticItem>findByListGenres_IdGenre(@RequestParam("idGenre") Integer idGenre, Pageable pageable);
    Page<PlasticItem>  findByNamePlasticItemContainingAndListGenres_IdGenre(
            @RequestParam("namePlastic") String namePlastic,
            @RequestParam("idGenre") Integer idGenre,
            Pageable pageable);
}
