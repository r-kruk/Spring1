package com.github.rkruk.spring.demo.model.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="adverts")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Advert {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "posted")
    private LocalDateTime posted;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @Column(name = "owner_id", insertable = false, updatable = false)
    private Long userId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return id.equals(advert.id) &&
                userId.equals(advert.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


