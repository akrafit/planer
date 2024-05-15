package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.ThirtyOneDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThirtyOneDFRepository extends JpaRepository<ThirtyOneDF, Long> {
    @Query
    Iterable<ThirtyOneDF> findThirtyOneDFByDf(DF df);
}
