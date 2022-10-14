package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, unique = true, nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean nonLocked;

    @Column(nullable = false)
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role")
    @Column(name = "role", length = 40)
    private List<RoleEnum> roles;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNonLocked() {
        return nonLocked;
    }

    public void setNonLocked(boolean nonLocked) {
        this.nonLocked = nonLocked;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }
}
