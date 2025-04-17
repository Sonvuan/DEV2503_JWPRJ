package com.devmaster.webbanhang.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDTO {

    // ID của danh mục cha (nếu có)
    Long idParent;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 10, message = "Tên không được vượt quá 10 ký tự")
    private String name;

    @Size(max = 20, message = "Tên không được vượt quá 20 ký tự")
    private String notes;

    @Size(max = 250, message = "icon không được vượt quá 250 ký tự")
    private String icon;

    @Size(max = 160, message = "slug không được vượt quá 160 ký tự")
    private String slug;

    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(max = 50, message = "Tiêu đề không được vượt quá 50 ký tự")
    private String metaTitle;

    @NotBlank(message = "Meta keyword không được để trống")
    @Size(max = 50, message = " Từ khoá không được vượt quá 50 ký tự")
    private String metaKeyword;

    @NotBlank(message = "Meta description không được để trống")
    @Size(max = 50, message = "Mô tả không được vượt quá 50 ký tự")
    private String metaDescription;

    @NotNull(message = "Người tạo không được để trống")
    private Long createdBy;

    @NotNull(message = "Người cập nhật không được để trống")
    private Long updateBy;

    private Boolean isDelete;
    private Boolean isActive;

}
