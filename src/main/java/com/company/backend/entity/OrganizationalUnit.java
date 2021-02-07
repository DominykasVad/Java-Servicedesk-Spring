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
@Table(name = "organizational_units")
public class OrganizationalUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ou_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "organizationalUnit", cascade = CascadeType.PERSIST)
    private Set<Location> locations;

    @OneToMany(mappedBy = "organizationalUnit", cascade = CascadeType.PERSIST)
    private Set<ConfigurationItem> configurationItems;

    @OneToMany(mappedBy = "organizationalUnit", cascade = CascadeType.PERSIST)
    private Set<ServiceRequest> serviceRequests;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
