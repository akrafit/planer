package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.TwentyFourDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TwentyFourDFRepository extends JpaRepository<TwentyFourDF, Long> {
    @Query
    Iterable<TwentyFourDF> findTwentyFourDFByDf(DF df);
}
