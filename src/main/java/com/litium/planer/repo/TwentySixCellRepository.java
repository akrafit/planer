package com.litium.planer.repo;

import com.litium.planer.entity.TwentySixCell;
import com.litium.planer.entity.TwentySixDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface TwentySixCellRepository extends JpaRepository<TwentySixCell, Long> {

    @Query
    Optional<TwentySixCell> findTwentySixCellByPeriodAndDf(LocalDate period, TwentySixDF twentySixDF);
}
