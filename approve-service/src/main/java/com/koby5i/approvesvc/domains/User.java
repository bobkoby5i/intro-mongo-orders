package com.koby5i.approvesvc.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

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
    private String customerId;
    private String customerName;
    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private List<String> authorities;


    public User(
            final String username,
            final String password,
            final String customerId,
            final String customerName,
            final Boolean enabled,
            final Boolean accountNonExpired,
            final Boolean accountNonLocked,
            final Boolean credentialsNonExpired,
            final List<String> authorities) {
        this.username = username;
        this.password = password;
        this.customerId = customerId;
        this.customerName = customerName;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.authorities = authorities;
    }
}


