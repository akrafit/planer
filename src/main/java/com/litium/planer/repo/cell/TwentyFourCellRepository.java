package com.litium.planer.repo.cell;

import com.litium.planer.entity.TwentyFourDF;
import com.litium.planer.entity.cell.TwentyFourCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface TwentyFourCellRepository extends JpaRepository<TwentyFourCell, Long> {
    @Query
    Optional<TwentyFourCell> findTwentyFourCellByPeriodAndDf(LocalDate period, TwentyFourDF twentyFourDF);
}
