package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "orders_detail")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Orders_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "PRICE")
    Double price;

    @Column(name = "QTY")
    Integer qty;

    @Column(name = "TOTAL")
    Double total;

    @Column(name = "RETURN_QTY")
    Integer returnQty;

    @ManyToOne
    @JoinColumn(name = "IDORD",referencedColumnName = "ID")
    Orders orders;

    @ManyToOne
    @JoinColumn(name = "IDPRODUCT",referencedColumnName = "ID")
    @JsonManagedReference
    Product product;

}
