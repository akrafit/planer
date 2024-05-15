package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.ThirtyTwoDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThirtyTwoDFRepository extends JpaRepository<ThirtyTwoDF, Long> {
    @Query
    Iterable<ThirtyTwoDF> findThirtyTwoDFByDf(DF df);
}
