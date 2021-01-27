package com.company.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "organizational_units")
public class OrganizationalUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private Long id;

    @Column(name = "ou_name", nullable = false, unique = true)
    private String name;

    @OneToOne(mappedBy = "organizationalUnit")
    private Company company;

    @OneToMany(mappedBy = "organizationalUnit", cascade = CascadeType.PERSIST)
    private Set<Location> locations;

    @OneToMany(mappedBy = "organizationalUnit", cascade = CascadeType.PERSIST)
    private Set<ConfigurationItem> configurationItems;

}
