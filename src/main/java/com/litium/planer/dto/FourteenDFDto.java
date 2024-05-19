package com.litium.planer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litium.planer.entity.FourteenDF;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class FourteenDFDto {
    private Long id;
    private Long dfId;
    private Long mvz;
    private String mvzName;
    private String oilfield;
    private String well;
    private String usedTon;
    private String coefLost;
    private String procLostPlan;
    private String procLostFact;
    private LocalDate period;
    private String comment;
    private LocalDateTime time;

    public FourteenDFDto(FourteenDF df) {
        this.id = df.getId();
        this.dfId = df.getDf().getId();
        this.mvz = df.getMvz().getId();
        this.mvzName = df.getMvz().getName();
        this.oilfield = df.getOilfield();
        this.well = df.getWell();
        this.usedTon = df.getUsedTon();
        this.coefLost = df.getCoefLost();
        this.procLostPlan = df.getProcLostPlan();
        this.procLostFact = df.getProcLostFact();
        this.period = df.getPeriod();
        this.comment = df.getComment();
        this.time = df.getTime();
    }
}
