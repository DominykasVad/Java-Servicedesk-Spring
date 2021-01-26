package com.company.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false, length = 254)
    @Size(min = 3, max = 254)
    private String email;

    @Column(name = "phome", nullable = false, length = 50)
    private String phone;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "company")
    @ManyToOne
    private CompanyEntity company;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
