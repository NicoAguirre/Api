package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "user")
public class User extends PanacheEntity{
    @Column(unique = true)
    
    @Username
    public String username;

    @Password
    public String password;
    
    @Roles
    public String roles;

}
