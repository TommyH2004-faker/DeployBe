package com.example.WebsiteMHiepBe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_detail")
    private long idOrderDetail;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "is_review")
    private boolean isReview;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "id_plastic_item", nullable = false)
    private com.example.WebsiteMHiepBe.entity.PlasticItem plasticItem;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_order", nullable = false)
    private com.example.WebsiteMHiepBe.entity.Order order;
}