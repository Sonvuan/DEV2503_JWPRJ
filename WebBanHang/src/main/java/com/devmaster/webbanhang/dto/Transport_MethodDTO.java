package com.devmaster.webbanhang.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transport_MethodDTO {

    @NotBlank(message = "Tên phương thức vận chuyển không được để trống")
    @Size(max = 250, message = "Tên phương thức vận chuyển không được vượt quá 250 ký tự")
    String name;

    @Size(max = 1000, message = "Ghi chú không được vượt quá 1000 ký tự")
    String notes;

    Boolean isDelete;
    Boolean isActive;
}
