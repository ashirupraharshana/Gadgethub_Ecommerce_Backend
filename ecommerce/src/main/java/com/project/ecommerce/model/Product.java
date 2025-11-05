package com.project.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int categoryid;
    private String name;
    private String description;
    private String photo;
    private int status;
    private int discount;
    private Date date;
}
