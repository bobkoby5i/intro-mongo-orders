package com.koby5i.approvesvc.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"id"})
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private Boolean active;
    private String customerName;
    private String customerId;
    private List<String> authorities;

    public User(
            final String username,
            final String password,
            final Boolean active,
            final String customerName,
            final String customerId,
            final List<String> authorities) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.customerId = customerId;
        this.customerName = customerName;
        this.authorities = authorities;
    }
}

