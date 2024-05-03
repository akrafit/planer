package com.litium.planer.entity;

import com.litium.planer.model.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "df5")
public class FiveDF {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "df_id")
    private DF df;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String oilfield;

    private String expWater;

    private String medWater;

    private String expPump;

    private String medPump;

    private String expHydro;

    private String medHydro;

    private LocalDate date;

    private LocalDateTime time;

    private String comment;


}
