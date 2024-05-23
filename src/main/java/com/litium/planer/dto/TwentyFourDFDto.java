package com.litium.planer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litium.planer.entity.TwentyFourDF;
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
public class TwentyFourDFDto {
    private Long id;
    private Long dfId;
    private Long mvz;
    private String mvzName;
    private String name;
    private String comment;
    private LocalDateTime time;
    private Map<LocalDate, Long> cellMap;

    public TwentyFourDFDto(TwentyFourDF df) {
        this.id = df.getId();
        this.mvz = df.getMvz().getId();
        this.mvzName = df.getMvz().getName();
        this.name = df.getName();
        this.comment = df.getComment();
        this.time = df.getTime();
    }
}
