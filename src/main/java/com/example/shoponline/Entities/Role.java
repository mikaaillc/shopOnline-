package com.example.shoponline.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"Roles\"")
public class Role {
    @Id
    @Column(name = "\"roleId\"", nullable = false)
    private Long id;

    @Lob
    @Column(name = "role")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}