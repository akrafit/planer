package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.ThirtyFourDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThirtyFourDFRepository extends JpaRepository<ThirtyFourDF,Long> {
    @Query
    Iterable<ThirtyFourDF> findThirtyFourDFByDf(DF df);
}
