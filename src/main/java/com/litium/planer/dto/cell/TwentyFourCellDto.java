package com.litium.planer.dto.cell;

import com.litium.planer.entity.cell.TwentyFourCell;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TwentyFourCellDto {
    private Long id;
    private Long value;
    private LocalDate period;
    private LocalDateTime time;

    public TwentyFourCellDto(TwentyFourCell twentyFourCell) {
        this.id = twentyFourCell.getId();
        this.value = twentyFourCell.getValue();
        this.period = twentyFourCell.getPeriod();
        this.time = twentyFourCell.getTime();
    }
}
