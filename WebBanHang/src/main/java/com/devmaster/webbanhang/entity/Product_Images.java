package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore
    Product product;
}
