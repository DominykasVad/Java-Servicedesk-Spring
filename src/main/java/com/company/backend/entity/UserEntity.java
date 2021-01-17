package com.company.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

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

    @Transient
    private String repeatedPassword;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", nullable = false, unique = true, length = 254)
    @Size(min = 3, max = 254)
    private String email;

    @Column(name = "phome", nullable = false, unique = true, length = 50)
    private String phone;

}
