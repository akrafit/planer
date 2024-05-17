package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.EightDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EightDFRepository extends JpaRepository<EightDF, Long> {
    @Query
    Iterable<EightDF> findEightDFByDf(DF df);
}
