package com.litium.planer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litium.planer.entity.EightDF;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class EightDFDto {
    private Long id;
    private Long dfId;
    private String user;
    private String name;
    private String typeWater;
    private String oilfield;
    private String well;
    private LocalDateTime time;
    private Map<LocalDate, Double> cellMap;

    public EightDFDto(EightDF df) {
        this.id = df.getId();
        this.user = df.getUser().getName();
        this.name = df.getName();
        this.typeWater = df.getTypeWater();
        this.oilfield = df.getOilfield();
        this.well = df.getWell();
        this.time = df.getTime();
    }
}
