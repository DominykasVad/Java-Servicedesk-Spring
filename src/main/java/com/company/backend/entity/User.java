package com.company.backend.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 36)
    @NotBlank
    @Size(min = 2, max = 36)
    private String username;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", nullable = false, unique = true, length = 254)
    @Size(min = 3, max = 254)
    private String email;

    @Column(name = "phone", nullable = false, unique = true, length = 50)
    private String phone;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "owner_id", cascade = CascadeType.PERSIST)
    private Set<ServiceRequest> serviceRequests;

    @OneToMany(mappedBy = "reported_by", cascade = CascadeType.PERSIST)
    private Set<ServiceRequest> reportedServiceRequests;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
