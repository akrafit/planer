package com.litium.planer.entity;

import com.litium.planer.model.TypeDF;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "df")
public class DF {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String form;

    private String period;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private TypeDF type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "df_id", nullable = false, insertable = false, updatable = false)
    private List<User2DF> user2DFS;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "df_id", nullable = false, insertable = false, updatable = false)
    private List<FourDF> fourDFList;



}
