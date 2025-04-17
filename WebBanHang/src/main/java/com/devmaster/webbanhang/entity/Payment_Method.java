package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payment_method")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment_Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long id;

    @Column(name = "NAME",length = 250)
    String name;

    @Column(name = "NOTES")
    String notes;

    @Column(name = "CREATED_DATE")
    LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    LocalDateTime updatedDate;

    @Column(name = "ISDELETE")
    Boolean isDelete;

    @Column(name = "ISACTIVE")
    Boolean isActive;

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


    @OneToMany(mappedBy = "payment_method", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Orders> orders;
}
