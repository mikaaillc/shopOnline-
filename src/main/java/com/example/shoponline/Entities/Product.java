package com.example.shoponline.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;//Sınıfın Constructorını üretir.Bu Constructor sınıftaki tüm fieldleri parametre olarak almıştır.
import lombok.Data;
import lombok.NoArgsConstructor;//Parametresiz Constructor üretir.


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "\"Product\"",
        indexes = {
        @Index(name = "fki_categoryId_fk", columnList = "\"categoryId\"")
}
)

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"productId\"", nullable = false)
    private Long id;


    @Column(name = "\"productName\"")
    private String productName;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "price")
    private Double price;

    @Column(name = "\"createDate\"", nullable = false)
    private Timestamp createDate;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "barcode")
    @NotNull
    private String barcode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "\"categoryId\"", nullable = false)
    private Category category;

    @Column(name = "\"userId\"", nullable = false)
    private Long userId;

}