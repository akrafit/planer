package com.litium.planer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "df4")
public class FourDF {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String oilfield;

    private String typeGTM;

    private String well;

    private String kp;

    private LocalDate endDate;

    private String wellPurpose;


}
