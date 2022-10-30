package com.example.shoponline.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"Category\"")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"categoryId\"", nullable = false)
    private Long id;

    @Column(name = "\"categoryName\"")
    private String categoryName;

    @Column(name = "active")
    private Boolean active;


}