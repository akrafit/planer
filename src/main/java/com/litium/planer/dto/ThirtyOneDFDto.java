package com.litium.planer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litium.planer.entity.ThirtyOneDF;
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
public class ThirtyOneDFDto {
    private Long id;
    private Long dfId;
    private Long mvz;
    private String mvzName;
    private String target;
    private String nomenclature;
    private String affiliation;
    private String stock;
    private String comment;
    private LocalDateTime time;

    private Map<LocalDate, Long> cellMap;

    public ThirtyOneDFDto(ThirtyOneDF df) {
        this.id = df.getId();
        this.mvz = df.getMvz().getId();
        this.mvzName = df.getMvz().getName();
        this.target = df.getTarget();
        this.nomenclature = df.getNomenclature();
        this.affiliation = df.getAffiliation();
        this.stock = df.getStock();
        this.comment = df.getComment();
        this.time = df.getTime();
    }
}
