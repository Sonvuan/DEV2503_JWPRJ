package com.devmaster.webbanhang.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "product_images")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product_Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME",length = 250)
    String name;

    @Column(name = "URLIMG", length = 250)
    String urlimg;

    @ManyToOne
    @JoinColumn(name ="IDPRODUCT", referencedColumnName = "ID" )
    Product product;
}
