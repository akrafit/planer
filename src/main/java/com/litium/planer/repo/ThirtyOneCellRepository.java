package com.litium.planer.repo;

import com.litium.planer.entity.ThirtyOneCell;
import com.litium.planer.entity.ThirtyOneDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface ThirtyOneCellRepository extends JpaRepository<ThirtyOneCell, Long> {
    @Query
    Optional<ThirtyOneCell> findThirtyOneCellByPeriodAndDf(LocalDate period, ThirtyOneDF df);
}
