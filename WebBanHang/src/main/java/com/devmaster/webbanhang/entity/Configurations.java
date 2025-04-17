package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "configurations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Configurations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME",length = 500)
    String name;

    @Column(name = "NOTES")
    String notes;

    @Column(name = "ISDELETE")
    Boolean isDelete;

    @Column(name = "ISACTIVE")
    Boolean isActive;

    @OneToMany(mappedBy = "configurations", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Product_Config> product_configs;
}
