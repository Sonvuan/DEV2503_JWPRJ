package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME", length = 250)
    String name;

    @Column(name = "USERNAME",length = 50)
    String username;

    @Column(name = "PASSWORD",length = 32)
    String password;

    @Column(name = "ADDRESS",length = 500)
    String address;

    @Column(name = "EMAIL",length = 150)
    String email;

    @Column(name = "PHONE",length = 50)
    String phone;

    @Column(name = "AVATAR",length = 250)
    String avatar;

    @Column(name = "CREATED_DATE")
    LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    LocalDateTime updatedDate;

    @Column(name = "CREATED_BY")
    Long createdBy;

    @Column(name = "UPDATED_BY")
    Long updatedBy;

    @Column(name = "ISDELETE")
    Boolean isDelete;

    @Column(name = "ISACTIVE")
    Boolean isActive;

    // @PrePersist sẽ được gọi khi thêm mới đối tượng
    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now;
        this.updatedDate = now; // Đặt ngày giờ cập nhật khi thêm mới
    }

    // @PreUpdate sẽ được gọi khi cập nhật đối tượng
    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now(); // Cập nhật ngày giờ mỗi khi có sự thay đổi
    }


    // Ánh xạ quan hệ với Product (Một Category có nhiều Product)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Orders> orders;
}
