package com.koby5i.approvesvc.domains.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class AddressDto implements Serializable {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String phone;

    public AddressDto(
            final String addressLine1,
            final String addressLine2,
            final String city,
            final String state,
            final String country,
            final String zipCode,
            final String phone) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
    }
}


