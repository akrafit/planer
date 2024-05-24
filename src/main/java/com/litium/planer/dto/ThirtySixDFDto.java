package com.litium.planer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litium.planer.entity.ThirtySixDF;
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
public class ThirtySixDFDto {
    private Long id;
    private Long dfId;
    private Long mvz;
    private String mvzName;
    private String name;
    private String unit;
    private LocalDateTime time;
    private Map<LocalDate, Double> cellMap;

    public ThirtySixDFDto(ThirtySixDF df) {
        this.id = df.getId();
        this.mvz = df.getMvz().getId();
        this.mvzName = df.getName();
        this.name = df.getName();
        this.unit = df.getUnit();
        this.time = df.getTime();
    }
}
