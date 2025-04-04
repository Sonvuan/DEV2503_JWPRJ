package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "IDORDERS", length = 10, unique = true)
    String idOrders;

    @Column(name = "ORDERS_DATE")
    LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "IDCUSTOMER",referencedColumnName = "ID")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "IDPAYMENT",referencedColumnName = "ID")
    Payment_Method payment_method;

    @ManyToOne
    @JoinColumn(name = "IDTRANSPROT",referencedColumnName = "ID")
    Transport_Method transport_method;

    // ánh xạ
    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Orders_Details> orders_details;

}
