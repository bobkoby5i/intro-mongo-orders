package com.koby5i.ordersvc.domains;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
public class OrderLine {
    private String number;
    private String category;
    private String shortName;
    private String description;
    private Integer qty;

    public OrderLine(
            final String number,
            final String category,
            final String shortName,
            final String description,
            final Integer qty) {
        this.number = number;
        this.category = category;
        this.shortName = shortName;
        this.description = description;
        this.qty = qty;
    }

}
