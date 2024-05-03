package com.litium.planer.dto;

import com.litium.planer.entity.FiveDF;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class FiveDFDto {
    private Long id;

    private String oilField;

    private String expWater;

    private String medWater;

    private String expPump;

    private String medPump;

    private String expHydro;

    private String medHydro;

    private LocalDate date;

    private LocalDateTime time;

    private String comment;

    public FiveDFDto(FiveDF df) {
        this.id = df.getId();
        this.oilField = df.getOilfield();
        this.expWater = df.getExpWater();
        this.medWater = df.getMedWater();
        this.expPump = df.getExpPump();
        this.medPump = df.getMedPump();
        this.expHydro = df.getExpHydro();
        this.medHydro = df.getMedHydro();
        this.date = df.getDate();
        this.time = df.getTime();
        this.comment = df.getComment();
    }
}
