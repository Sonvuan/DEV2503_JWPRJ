package com.devmaster.webbanhang.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME", length = 500)
    String name;

    @Column(name = "DESCRIPTION0")
    String description;

    @Column(name ="NOTES")
    String notes;

    @Column(name = "IMAGE",length = 500)
    String image;


    @Column(name = "CONTENTS")
    String contents;

    @Column(name = "PRICE")
    Double price;

    @Column(name = "QUANTITY")
    Integer quantity;

    @Column(name = "SLUG",length = 160)
    String slug;

    @Column(name = "META_TITLE",length = 100)
    String metaTitle;

    @Column(name = "META_KEYWORD",length = 500)
    String metaKeyword;

    @Column(name = "META_DESCRIPTION",length = 500)
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

    // Thiết lập khóa ngoại với bảng Category
    @ManyToOne
    @JoinColumn(name = "IDCATEGORY", referencedColumnName = "ID")
    Category category;

    // ánh xạ
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Product_Config> product_configs;

    // ánh xạ
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Product_Images> product_images;

    // ánh ạ
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Orders_Details> orders_details;
}
