package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.Order;
import com.example.WebsiteMHiepBe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "orders")
public interface OrderRepositoory extends JpaRepository<Order, Integer> {
    public Order findFirstByUserOrderByIdOrderDesc(User user);
    // Define any custom query methods if needed
}
