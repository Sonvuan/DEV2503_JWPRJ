package com.devmaster.webbanhang.dto;

import com.devmaster.webbanhang.entity.Product;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product_ImagesDTO {

    Long id_Product;

    @NotBlank(message = "Tên ảnh không được để trống")
    @Size(max = 250, message = "Tên ảnh không được vượt quá 250 ký tự")
    String name;

    @NotBlank(message = "URL ảnh không được để trống")
    @Size(max = 250, message = "URL ảnh không được vượt quá 250 ký tự")
    @URL(message = "URL ảnh không hợp lệ")
    String urlimg;
}
