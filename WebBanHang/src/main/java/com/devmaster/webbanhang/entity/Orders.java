package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    LocalDateTime orderDate;

    @Column(name = "NOTES")
    String notes;

    @Column(name = "TOTAL_MONEY")
    Long totalMoney;

    @Column(name = "NAME_RECIVER", length = 250)
    String nameReciver;

    @Column(name = "ADDRESS", length = 500)
    String address;

    @Column(name = "EMAIL", length = 150)
    String email;

    @Column(name = "PHONE", length = 50)
    String phone;

    @Column(name = "ISDELETE")
    Boolean isDelete;

    @Column(name = "ISACTIVE")
    Boolean isActive;

    @PrePersist
    public void prePersist() {
        this.orderDate = LocalDateTime.now();
      // Đặt ngày giờ cập nhật khi thêm mới
    }

    // @PreUpdate sẽ được gọi khi cập nhật đối tượng
    @PreUpdate
    public void preUpdate() {
        this.orderDate = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "IDCUSTOMER", referencedColumnName = "ID")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "IDPAYMENT", referencedColumnName = "ID")
    Payment_Method payment_method;

    @ManyToOne
    @JoinColumn(name = "IDTRANSPROT", referencedColumnName = "ID")
    Transport_Method transport_method;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Orders_Details> orders_details;
}
