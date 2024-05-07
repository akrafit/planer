package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.TwentySvenDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TwentySevenDFRepository extends JpaRepository<TwentySvenDF, Long> {
    @Query
    Iterable<TwentySvenDF> findTwentySvenDFByDf(DF df);
}
