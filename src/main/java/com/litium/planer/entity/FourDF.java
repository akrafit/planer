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
@Table(name = "df4")
public class FourDF {
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

    private String typeGTM;

    private String well;

    private String kp;

    private LocalDate endDate;

    private String wellPurpose;

    private String type;

    private String comment;

    private LocalDateTime time;


}
