package com.litium.planer.dto;

import com.litium.planer.entity.ThirtyOneCell;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ThirtyOneCellDto {
    private Long id;

    private Long value;

    private LocalDate period;

    private LocalDateTime time;

    public ThirtyOneCellDto(ThirtyOneCell thirtyOneCell) {
        this.id = thirtyOneCell.getId();
        this.value = thirtyOneCell.getValue();
        this.period = thirtyOneCell.getPeriod();
        this.time = thirtyOneCell.getTime();
    }
}
