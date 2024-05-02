package com.litium.planer.dto;

import com.litium.planer.entity.FourDF;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class FourDFDto {
    private Long id;
    private String oilField;

    private String typeGTM;

    private String well;

    private String kp;

    private LocalDate endDate;

    private String wellPurpose;

    private String type;

    private String comment;

    private LocalDateTime time;

    public FourDFDto(FourDF df) {
        this.id = df.getId();
        this.oilField = df.getOilfield();
        this.typeGTM = df.getTypeGTM();
        this.well = df.getWell();
        this.kp = df.getKp();
        this.endDate = df.getEndDate();
        this.wellPurpose = df.getWellPurpose();
        this.type = df.getType();
        this.comment = df.getComment();
        this.time = df.getTime();
    }
}
