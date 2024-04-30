package com.litium.planer.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "pass")
    private String passwordOpen;
    @Column(name = "name")
    private String name;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private STATUS status;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private ROLE role;

}
