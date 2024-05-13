package com.litium.planer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.litium.planer.entity.TwentySvenDF;
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
public class TwentySvenDFDto {
    private Long id;
    private Long dfId;
    private Long mvz;

    private String mvzName;
    private String type;
    private String vid;
    private String nameChar;
    private String valueChar;
    private String specialChar;
    private String purpose;
    private LocalDateTime time;

    private Map<LocalDate, Long> cellMap;

    public TwentySvenDFDto(TwentySvenDF df) {
        this.id = df.getId();
        this.mvz = df.getMvz().getId();
        this.type = df.getType();
        this.vid = df.getVid();
        this.nameChar = df.getNameChar();
        this.valueChar = df.getValueChar();
        this.specialChar = df.getSpecialChar();
        this.purpose = df.getPurpose();
        this.time = df.getTime();
    }
}
