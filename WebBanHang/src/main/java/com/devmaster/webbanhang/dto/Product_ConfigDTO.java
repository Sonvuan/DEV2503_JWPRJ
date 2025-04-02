package com.devmaster.webbanhang.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product_ConfigDTO {

    @NotBlank(message = "Giá trị không được để trống")
    @Size(max = 500, message = "Giá trị không được vượt quá 500 ký tự")
    String value;
}
