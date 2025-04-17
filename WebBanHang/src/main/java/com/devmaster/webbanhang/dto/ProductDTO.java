package com.devmaster.webbanhang.dto;

import com.devmaster.webbanhang.entity.Category;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {
    Long id;


    Long id_Category;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(max = 500, message = "Tên sản phẩm không được vượt quá 500 ký tự")
    String name;

    @Size(max = 1000, message = "Mô tả sản phẩm không được vượt quá 1000 ký tự")
    String description;

    @Size(max = 1000, message = "Ghi chú sản phẩm không được vượt quá 1000 ký tự")
    String notes;

    @NotBlank(message = "Hình ảnh sản phẩm không được để trống")
    @Size(max = 500, message = "Đường dẫn hình ảnh không được vượt quá 500 ký tự")
    String image;

    @Size(max = 2000, message = "Nội dung sản phẩm không được vượt quá 2000 ký tự")
    String contents;

    @NotNull(message = "Giá sản phẩm không được để trống")
    @DecimalMin(value = "0.01", message = "Giá sản phẩm phải lớn hơn 0")
    Double price;

    @NotNull(message = "Số lượng sản phẩm không được để trống")
    @Min(value = 0, message = "Số lượng sản phẩm phải lớn hơn hoặc bằng 0")
    Integer quantity;

    @NotBlank(message = "Slug không được để trống")
    @Size(max = 160, message = "Slug không được vượt quá 160 ký tự")
    String slug;

    @Size(max = 100, message = "Meta title không được vượt quá 100 ký tự")
    String metaTitle;

    @Size(max = 500, message = "Meta keyword không được vượt quá 500 ký tự")
    String metaKeyword;

    @Size(max = 500, message = "Meta description không được vượt quá 500 ký tự")
    String metaDescription;

    @NotNull(message = "Người tạo không được để trống")
    private Long createdBy;

    @NotNull(message = "Người cập nhật không được để trống")
    private Long updateBy;

    private Boolean isDelete;
    private Boolean isActive;
}
