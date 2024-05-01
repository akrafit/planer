package com.litium.planer.model;


import com.litium.planer.entity.FourDF;
import com.litium.planer.entity.User2DF;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


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
    private Status status;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private List<FourDF> fourDFList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private List<User2DF> user2DFS;
}
