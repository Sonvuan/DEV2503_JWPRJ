package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "product_config")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product_Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Column(name = "VALUE")
    String value;

    // Thiết lập khóa ngoại với bảng Category
    @ManyToOne
    @JoinColumn(name = "IDPRODUCT", referencedColumnName = "ID")
    @JsonIgnore
    Product product;

    // Thiết lập khóa ngoại với bảng Category
    @ManyToOne
    @JoinColumn(name = "IDCONFIG", referencedColumnName = "ID")
    @JsonIgnore
    Configurations configurations;

}
