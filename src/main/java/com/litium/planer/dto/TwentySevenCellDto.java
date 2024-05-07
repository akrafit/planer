package com.litium.planer.dto;

import com.litium.planer.entity.TwentySevenCell;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TwentySevenCellDto {
    private Long id;

    private Long value;

    private LocalDate period;

    private LocalDateTime time;

    public TwentySevenCellDto(TwentySevenCell twentySevenCell) {
        this.id = twentySevenCell.getId();
        this.value = twentySevenCell.getValue();
        this.period = twentySevenCell.getPeriod();
        this.time = twentySevenCell.getTime();
    }
}
