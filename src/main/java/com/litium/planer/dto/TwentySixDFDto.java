package com.litium.planer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litium.planer.entity.TwentySixDF;
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
public class TwentySixDFDto {
    private Long id;
    private Long dfId;
    private Long mvz;
    private String mvzName;
    private String type;
    private String nomenclature;
    private String typeCar;
    private String valueCar;
    private String typeWork;
    private String purpose;
    private String startPoint;
    private String endPoint;
    private String comment;
    private LocalDateTime time;
    private Map<LocalDate, Long> cellMap;

    public TwentySixDFDto(TwentySixDF df) {
    }
}
