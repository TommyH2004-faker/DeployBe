package com.example.WebsiteMHiepBe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private int idImage;

    @Column(name = "name_image")
    private String nameImage;

    @Column(name = "is_thumbnail")
    private boolean thumbnail;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "data_image", columnDefinition = "LONGTEXT")
    @Lob
    private String dataImage;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_plastic_item", nullable = false)
    private com.example.WebsiteMHiepBe.entity.PlasticItem plasticItem;
}