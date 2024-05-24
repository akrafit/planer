package com.litium.planer.dto.cell;

import com.litium.planer.entity.cell.ThirtySixCell;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ThirtySixCellDto {
    private Long id;
    private Double value;
    private LocalDate period;
    private LocalDateTime time;

    public ThirtySixCellDto(ThirtySixCell thirtySixCell) {
        this.id = thirtySixCell.getId();
        this.value = thirtySixCell.getValue();
        this.period = thirtySixCell.getPeriod();
        this.time = thirtySixCell.getTime();
    }
}
