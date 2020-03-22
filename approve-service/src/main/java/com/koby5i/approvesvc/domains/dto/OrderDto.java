package com.koby5i.approvesvc.domains.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
@ToString(exclude = {"id", "createdAt","updatedAt"})
public class OrderDto implements Serializable {
    private String id;
    private String orderNumber;
    private String orderUUID;
    private String customerId;
    private String customerName;
    private AddressDto address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private List<OrderLineDto> products;
    private Status status;

//    public OrderDto(
//            final String orderNumber,
//            final String orderUUID,
//            final String customerId,
//            final String customerName,
//            final AddressDto address,
//            final LocalDateTime createdAt,
//            final LocalDateTime updatedAt,
//            final String createdBy,
//            final String updatedBy,
//            final List<OrderLineDto>  products,
//            final Status status) {
//
//        this.orderNumber = orderNumber;
//        this.orderUUID = orderUUID;
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.address = address;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.createdBy = createdBy;
//        this.updatedBy = updatedBy;
//        this.products = products;
//        this.status = status;
//    }


    public enum Status {
        NEW, SENT, APPROVED, NOT_APPROVED
    }
}





