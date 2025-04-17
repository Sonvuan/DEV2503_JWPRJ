package com.devmaster.webbanhang.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsDTO {

    Long idNews_Category;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 255, message = "Tên phải từ 2 đến 255 ký tự")
    String name;

    @NotBlank(message = "Mô tả không được để trống")
    @Size(max = 1000, message = "Mô tả không được vượt quá 1000 ký tự")
    String description;

    @NotBlank(message = "Hình ảnh không được để trống")
    @Size(max = 255, message = "Độ dài tối đa của đường dẫn hình ảnh là 255 ký tự")
    String image;

    @NotBlank(message = "Contents không được để trống")
    String contents;

    @NotBlank(message = "Slug không được để trống")
    @Size(max = 160, message = "Slug không được vượt quá 160 ký tự")
    String slug;

    @Size(max = 100, message = "Meta Title không được vượt quá 100 ký tự")
    String metaTitle;

    @Size(max = 300, message = "Meta Keyword không được vượt quá 300 ký tự")
    String metaKeyword;

    @Size(max = 300, message = "Meta Description không được vượt quá 300 ký tự")
    String metaDescription;

    @NotNull(message = "Người tạo không được để trống")
    private Long createdBy;

    @NotNull(message = "Người cập nhật không được để trống")
    private Long updateBy;

    private Boolean isDelete;
    private Boolean isActive;
}
