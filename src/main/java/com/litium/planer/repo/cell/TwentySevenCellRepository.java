package com.litium.planer.repo.cell;

import com.litium.planer.entity.cell.TwentySevenCell;
import com.litium.planer.entity.TwentySvenDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface TwentySevenCellRepository extends JpaRepository<TwentySevenCell, Long> {

    @Query
    Optional<TwentySevenCell> findTwentySevenCellByPeriodAndDf(LocalDate period, TwentySvenDF twentySvenDF);
}
