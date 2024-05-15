package com.litium.planer.dto;

import com.litium.planer.entity.TwentySixCell;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TwentySixCellDto {
    private Long id;

    private Long value;

    private LocalDate period;

    private LocalDateTime time;

    public TwentySixCellDto(TwentySixCell twentySixCell) {
        this.id = twentySixCell.getId();
        this.value = twentySixCell.getValue();
        this.period = twentySixCell.getPeriod();
        this.time = twentySixCell.getTime();
    }
}
