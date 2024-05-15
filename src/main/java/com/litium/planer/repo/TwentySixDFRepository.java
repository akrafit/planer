package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.TwentySixDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TwentySixDFRepository extends JpaRepository<TwentySixDF, Long> {
    @Query
    Iterable<TwentySixDF> findTwentySixDFByDf(DF df);
}
