package com.company.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
    private Set<User> employees;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
    private Set<ServiceRequest> serviceRequests;

}
