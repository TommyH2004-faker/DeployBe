package com.example.WebsiteMHiepBe.dao;

import com.example.WebsiteMHiepBe.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "payments")
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Define any custom query methods if needed
}
