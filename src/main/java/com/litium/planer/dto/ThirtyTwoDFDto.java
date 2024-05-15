package com.litium.planer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litium.planer.entity.Mvz;
import com.litium.planer.entity.ThirtyTwoDF;
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
public class ThirtyTwoDFDto  {

    private Long id;
    private Long dfId;
    private Long mvz;
    private String mvzName;
    private String objectB;
    private LocalDate dateKo;
    private String typeGas;
    private LocalDate date;
    private String amt;
    private String comment;
    private LocalDateTime time;

    public ThirtyTwoDFDto(ThirtyTwoDF df) {
        this.id = df.getId();
        this.dfId = df.getId();
        this.mvz = df.getMvz().getId();
        this.mvzName = df.getMvz().getName();
        this.objectB = df.getObjectB();
        this.dateKo = df.getDateKo();
        this.typeGas = df.getTypeGas();
        this.date = df.getDate();
        this.amt = df.getAmt();
        this.comment = df.getComment();
        this.time = df.getTime();
    }
}
