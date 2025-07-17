package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.Order;
import com.example.WebsiteMHiepBe.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "order-details")
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
   public List<OrderDetail> findOrderDetailsByOrder(Order order);
    // Define any custom query methods if needed
}
