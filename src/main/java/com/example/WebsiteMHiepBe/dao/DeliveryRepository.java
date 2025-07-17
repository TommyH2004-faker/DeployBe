package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "deliveries")
public interface DeliveryRepository    extends JpaRepository<Delivery, Integer> {
    // Define any custom query methods if needed
}
