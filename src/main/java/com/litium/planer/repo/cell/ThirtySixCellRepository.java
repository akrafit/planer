package com.litium.planer.repo.cell;

import com.litium.planer.entity.ThirtySixDF;
import com.litium.planer.entity.cell.ThirtySixCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface ThirtySixCellRepository extends JpaRepository<ThirtySixCell, Long> {

    @Query
    Optional<ThirtySixCell> findThirtySixCellByPeriodAndDf(LocalDate period, ThirtySixDF thirtySixDF);
}
