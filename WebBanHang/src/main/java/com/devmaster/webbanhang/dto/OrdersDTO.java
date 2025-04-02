package com.devmaster.webbanhang.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrdersDTO {

    @NotBlank(message = "Mã đơn hàng không được để trống")
    @Size(max = 10, message = "Mã đơn hàng không được vượt quá 10 ký tự")
    String idOrders;

    @NotNull(message = "Ngày đặt hàng không được để trống")
    @PastOrPresent(message = "Ngày đặt hàng không được lớn hơn ngày hiện tại")
    LocalDate orderDate;
}
