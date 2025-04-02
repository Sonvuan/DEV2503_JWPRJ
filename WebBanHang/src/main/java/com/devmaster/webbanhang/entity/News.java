package com.devmaster.webbanhang.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "news")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME",length = 500)
    String name;

    @Column(name = "DESCRIPTION")
    String description;

    @Column(name = "IMAGE",length = 500)
    String image;

    @ManyToOne
    @JoinColumn(name = "IDNEWSCATEGORY", referencedColumnName = "ID")
    News_Category news_category;
}
