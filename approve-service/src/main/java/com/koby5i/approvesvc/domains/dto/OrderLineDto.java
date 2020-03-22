package com.koby5i.approvesvc.domains.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
//@Getter
//@Setter
@Builder
public class OrderLineDto implements Serializable {
    private String number;
    private String category;
    private String shortName;
    private String description;
    private Integer qty;

//    public OrderLineDto(
//            final String number,
//            final String category,
//            final String shortName,
//            final String description,
//            final Integer qty) {
//        this.number = number;
//        this.category = category;
//        this.shortName = shortName;
//        this.description = description;
//        this.qty = qty;
//    }

}
