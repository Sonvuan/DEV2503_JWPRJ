package com.devmaster.webbanhang.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transport_method")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transport_Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME",length = 250)
    String name;

    @Column(name = "NOTES")
    String notes;

    @Column(name = "CREATED_DATE")
    LocalDateTime createdDate;

    @Column(name = "UPDATEd_DATE")
    LocalDateTime updatedDate;

    @Column(name = "ISDELETE")
    Boolean isDelete;

    @Column(name = "ISACTIVE")
    Boolean isActive;

    @OneToMany(mappedBy = "transport_method", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    List<Orders> orders;
}
