package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "genres")
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    // Define any custom query methods if needed
}
