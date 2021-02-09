package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String characteristics;

    private byte[] image;

    @ManyToMany(mappedBy = "products")
    @Size(min = 1)
    private List<Category> categories;
}
