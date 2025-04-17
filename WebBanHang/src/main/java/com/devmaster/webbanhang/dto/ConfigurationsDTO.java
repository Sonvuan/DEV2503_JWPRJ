package com.devmaster.webbanhang.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigurationsDTO {

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 10,message = "Tên không được vượt quá 10 kí tự")
    String name;


    @NotBlank(message = "Ghi chú không được để trống")
    @Size(max = 10,message = "Ghi chú không được vượt quá 10 kí tự")
    String notes;

    private Boolean isDelete;
    private Boolean isActive;

}
