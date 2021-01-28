package com.company.backend.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "configuration_items")
public class ConfigurationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "inventory_number", unique = true)
    private String inventoryNumber;

    @Column(name = "model")
    private String model;

    @Column(name = "vendor")
    private String vendor;

    @ManyToOne
    @JoinColumn(name = "ou_id")
    private OrganizationalUnit organizationalUnit;

    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location currentLocation;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
