package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.Feedbacks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "feedbacks")
public interface FeedbacksRepoository extends JpaRepository<Feedbacks, Integer> {
    // Define any custom query methods if needed
}
