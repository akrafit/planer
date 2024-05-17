package com.litium.planer.repo.cell;

import com.litium.planer.entity.EightDF;
import com.litium.planer.entity.cell.EightCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface EightCellRepository extends JpaRepository<EightCell, Long> {
    @Query
    Optional<EightCell> findEightCellByPeriodAndDf(LocalDate period, EightDF twentySvenDF);
}
