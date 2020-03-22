package com.koby5i.approvesvc.domains.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
@ToString(exclude = {"id", "createdAt","updatedAt"})
public class ProductDto implements Serializable {
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

//    public ProductDto(
//            final String number,
//            final String category,
//            final String shortName,
//            final String uom,
//            final String description,
//            final Integer active,
//            final LocalDateTime createdAt,
//            final LocalDateTime updatedAt,
//            final String createdBy,
//            final String updatedBy) {
//        this.number = number;
//        this.category = category;
//        this.shortName = shortName;
//        this.uom = uom;
//        this.description = description;
//        this.active = active;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.createdBy = createdBy;
//        this.updatedBy = updatedBy;
//    }
}
