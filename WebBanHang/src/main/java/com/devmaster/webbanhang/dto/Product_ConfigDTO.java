package com.devmaster.webbanhang.dto;

import com.devmaster.webbanhang.entity.Configurations;
import com.devmaster.webbanhang.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product_ConfigDTO {
    Long id_Product;
    Long id_Configuration;

    @NotBlank(message = "Giá trị không được để trống")
    @Size(max = 500, message = "Giá trị không được vượt quá 500 ký tự")
    String value;
}
