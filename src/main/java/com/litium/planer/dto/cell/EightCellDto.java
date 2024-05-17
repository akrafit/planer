package com.litium.planer.dto.cell;

import com.litium.planer.entity.cell.EightCell;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EightCellDto {
    private Long id;

    private Long value;

    private LocalDate period;

    private LocalDateTime time;

    public EightCellDto(EightCell eightCell) {
        this.id = eightCell.getId();
        this.value = eightCell.getValue();
        this.period = eightCell.getPeriod();
        this.time = eightCell.getTime();
    }
}
