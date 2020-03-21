package com.koby5i.ordersvc.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString(exclude = {"id", "createdAt","updatedAt"})
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String orderNumber;
    private String orderUUID;
    private String customerId;
    private String customerName;
    private Address address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private List<OrderLine> products;
    private Status status;

    public Order(
            final String orderNumber,
            final String orderUUID,
            final String customerId,
            final String customerName,
            final Address address,
            final LocalDateTime createdAt,
            final LocalDateTime updatedAt,
            final String createdBy,
            final String updatedBy,
            final List<OrderLine>  products,
            final Status status) {

        this.orderNumber = orderNumber;
        this.orderUUID = orderUUID;
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.products = products;
        this.status = status;
    }


    public enum Status {
        NEW, SENT, APPROVED, NOT_APPROVED
    }
}





