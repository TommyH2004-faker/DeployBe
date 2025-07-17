
package com.example.WebsiteMHiepBe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private int idReview;

    @Column(name = "content")
    private String content;

    @Column(name = "rating_point")
    private float ratingPoint;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_plastic_item", nullable = false)
    private com.example.WebsiteMHiepBe.entity.PlasticItem plasticItem;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_user", nullable = false)
    private com.example.WebsiteMHiepBe.entity.User user;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_order_detail")
    private com.example.WebsiteMHiepBe.entity.OrderDetail orderDetail;
}