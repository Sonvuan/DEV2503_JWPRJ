package com.devmaster.webbanhang.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrdersDTO {

    Long id_Customer;

    Long id_PaymentMethod;

    Long id_TransportMethod;

    @NotBlank(message = "Mã đơn hàng không được để trống")
    @Size(max = 10, message = "Mã đơn hàng không được vượt quá 10 ký tự")
    String idOrders;


    @DecimalMin(value = "0.0", message = "Tổng tiền phải lớn hơn hoặc bằng 0")
    Long totalMoney;

    @Size(max = 5000, message = "Ghi chú quá dài")
    String notes;

    @NotBlank(message = "Họ tên người nhận không được để trống")
    @Size(max = 250, message = "Họ tên người nhận không vượt quá 250 ký tự")
    String nameReciver;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 500, message = "Địa chỉ không vượt quá 500 ký tự")
    String address;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    @Size(max = 150, message = "Email không vượt quá 150 ký tự")
    String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "0[0-9]{9}", message = "Số điện thoại phải có 10 chữ số và bắt đầu bằng 0")
    String phone;


    Boolean isDelete;


    Boolean isActive;

}
