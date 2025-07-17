package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.OrderDetail;
import com.example.WebsiteMHiepBe.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "reviews")
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    public  Review findReviewByOrderDetail(OrderDetail orderDetail);
    // Define any custom query methods if needed
    public long countBy();
}
