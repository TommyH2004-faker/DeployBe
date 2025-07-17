package com.example.WebsiteMHiepBe.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plastic_item")
public class PlasticItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plastic_item")
    private int idPlasticItem;

    @Column(name = "name_plastic_item")
    private String namePlasticItem;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "list_price")
    private double listPrice;

    @Column(name = "sell_price")
    private double sellPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "avg_rating")
    private double avgRating;

    @Column(name = "sold_quantity")
    private int soldQuantity;

    @Column(name = "discount_percent")
    private int discountPercent;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "plastic_item_genre", joinColumns = @JoinColumn(name = "id_plastic_item"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
    @Builder.Default

    private List<com.example.WebsiteMHiepBe.entity.Genre> listGenres = new ArrayList<>();

    @OneToMany(mappedBy = "plasticItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<com.example.WebsiteMHiepBe.entity.Image> listImages = new ArrayList<>();

    @OneToMany(mappedBy = "plasticItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<com.example.WebsiteMHiepBe.entity.Review> listReviews = new ArrayList<>();

    @OneToMany(mappedBy = "plasticItem", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @Builder.Default
    private List<com.example.WebsiteMHiepBe.entity.OrderDetail> listOrderDetails = new ArrayList<>();

    @OneToMany(mappedBy = "plasticItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<com.example.WebsiteMHiepBe.entity.FavoriteItem> listFavoriteItems = new ArrayList<>();

    @OneToMany(mappedBy = "plasticItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private List<com.example.WebsiteMHiepBe.entity.CartItem> listCartItems = new ArrayList<>();
}