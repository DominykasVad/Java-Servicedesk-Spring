package com.company.backend.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ou_id")
    private OrganizationalUnit organizationalUnit;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
