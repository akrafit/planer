package com.litium.planer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litium.planer.entity.ThirtyFourDF;
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
public class ThirtyFourDFDto {
    private Long id;
    private Long dfId;
    private Long mvz;
    private String mvzName;
    private String bosom;
    private String type;
    private String target;
    private String place;
    private String mark;
    private String amt;
    private LocalDate period;
    private LocalDateTime time;

    public ThirtyFourDFDto(ThirtyFourDF df) {
        this.id = df.getId();
        this.mvzName = df.getMvz().getName();
        this.bosom = df.getBosom();
        this.type = df.getType();
        this.target = df.getTarget();
        this.place = df.getPlace();
        this.mark = df.getMark();
        this.amt = df.getAmt();
        this.period = df.getPeriod();
        this.time = df.getTime();
    }
}
