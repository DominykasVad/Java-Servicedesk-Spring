package com.company.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ou_id")
    OrganizationalUnit organizationalUnit;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "currentLocation", cascade = CascadeType.PERSIST)
    private Set<ConfigurationItem> configurationItems;
}
