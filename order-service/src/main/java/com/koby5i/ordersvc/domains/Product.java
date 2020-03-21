package com.koby5i.ordersvc.domains;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


//@Data
@Getter
@Setter
@ToString(exclude = {"id", "createdAt","updatedAt"})
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String number;
    private String category;
    private String shortName;
    private String uom;
    private String description;
    private Integer active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;

    public Product(
            final String number,
            final String category,
            final String shortName,
            final String uom,
            final String description,
            final Integer active,
            final LocalDateTime createdAt,
            final LocalDateTime updatedAt,
            final String createdBy,
            final String updatedBy) {
        this.number = number;
        this.category = category;
        this.shortName = shortName;
        this.uom = uom;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
