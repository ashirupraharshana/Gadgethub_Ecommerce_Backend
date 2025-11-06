package com.project.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="cart")
public class Cart {
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private Long id;
   private int userid;
   private int productid;
   private int quantity;
   private double totalprice;
}
