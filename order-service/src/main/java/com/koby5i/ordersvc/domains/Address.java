package com.koby5i.ordersvc.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String phone;

    public Address(
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


