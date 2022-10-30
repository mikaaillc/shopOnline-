package com.example.shoponline.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"UserRoleMapping\"")
public class UserRoleMapping {
    @Id
    @Column(name = "\"UserRoleMappingId\"", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"userId\"", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"roleId\"", nullable = false)
    private Role role;



}