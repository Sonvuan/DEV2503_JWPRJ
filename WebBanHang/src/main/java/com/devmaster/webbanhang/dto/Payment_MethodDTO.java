package com.devmaster.webbanhang.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment_MethodDTO {

    @NotBlank(message = "Tên phương thức thanh toán không được để trống")
    @Size(max = 250, message = "Tên phương thức thanh toán không được vượt quá 250 ký tự")
    String name;

    @Size(max = 1000, message = "Ghi chú không được vượt quá 1000 ký tự")
    String notes;

    private Boolean isDelete;
    private Boolean isActive;
}
