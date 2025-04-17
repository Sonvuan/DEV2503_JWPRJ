package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "news")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME",length = 500)
    String name;

    @Column(name = "DESCRIPTION")
    String description;

    @Column(name = "IMAGE",length = 500)
    String image;

    @Column(name = "CONTENTS")
    String contents;

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

    @ManyToOne
    @JoinColumn(name = "IDNEWSCATEGORY", referencedColumnName = "ID")
    News_Category news_category;
}
