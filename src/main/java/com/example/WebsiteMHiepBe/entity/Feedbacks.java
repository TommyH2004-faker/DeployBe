package com.example.WebsiteMHiepBe.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "feedback")
public class Feedbacks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feedback")
    private int idFeedback; // Feedback ID

    @Column(name = "title")
    private String title; // Feedback title

    @Column(name = "comment")
    private String comment; // Feedback comment

    @Column(name = "date_created")
    private Date dateCreated; // Date created

    @Column(name = "is_readed")
    private boolean isReaded; // Read status

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}