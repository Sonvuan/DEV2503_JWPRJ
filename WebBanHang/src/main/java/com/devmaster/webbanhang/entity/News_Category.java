package com.devmaster.webbanhang.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "news_category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class News_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long id;

    @Column(name = "NAME",length = 500)
    String name;

    @Column(name = "NOTES")
    String notes;

    @Column(name = "ICON",length = 250)
    String icon;


    @ManyToOne
    @JoinColumn(name = "IDPARENT")
    News_Category parentNews_Category;

    @Column(name = "SLUG", length = 160)
    String slug;

    @Column(name = "META_TITLE", length = 100)
    String metaTitle;

    @Column(name = "META_KEYWORD", length = 500)
    String metaKeyword;

    @Column(name = "META_DESCRIPTION", length = 500)
    String metaDescription;

    @Column(name = "CREATED_DATE")
    LocalDateTime createdDate;

    @Column(name = "UPDATE_DATE")
    LocalDateTime updateDate;

    @Column(name = "CREATED_BY")
    Long createdBy;

    @Column(name = "UPDATE_BY")
    Long updateBy;

    @Column(name = "ISDELETE")
    Boolean isDelete;

    @Column(name = "ISACTIVE")
    Boolean isActive;

    // ánh xạ
    @OneToMany(mappedBy = "news_category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<News> news;
}
