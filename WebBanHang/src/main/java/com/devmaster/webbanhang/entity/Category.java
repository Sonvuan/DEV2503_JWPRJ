package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME", length = 500)
    String name;

    @Column(name = "NOTES", columnDefinition = "TEXT")
    String notes;

    @Column(name = "ICON", length = 250)
    String icon;


    @Column(name = "SLUG", length = 160)
    String slug;

    @Column(name = "META_TITLE", length = 100)
    String metaTitle;

    @Column(name = "META_KEYWORD", length = 300)
    String metaKeyword;

    @Column(name = "META_DESCRIPTION", length = 300)
    String metaDescription;

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

    // Quan hệ cha
    @ManyToOne
    @JoinColumn(name = "IDPARENT")  // Trỏ đến chính bảng Category
            Category parent;

    // Ánh xạ quan hệ với Product (Một Category có nhiều Product)
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Product> products;
}
