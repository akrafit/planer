package com.litium.planer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litium.planer.entity.SeventeenDF;
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
public class SeventeenDFDto {
    private Long id;
    private Long dfId;
    private Long mvz;
    private String mvzName;
    private String typeOil;
    private String affiliation;
    private String oilName;
    private LocalDate date;
    private String amt;
    private String comment;
    private LocalDateTime time;

    public SeventeenDFDto(SeventeenDF df) {
        this.id = df.getId();
        this.dfId = df.getDf().getId();
        this.mvz = df.getMvz().getId();
        this.mvzName = df.getMvz().getName();
        this.typeOil = df.getTypeOil();
        this.affiliation = df.getAffiliation();
        this.oilName = df.getOilName();
        this.date = df.getDate();
        this.amt = df.getAmt();
        this.comment = df.getComment();
        this.time = df.getTime();
    }
}
