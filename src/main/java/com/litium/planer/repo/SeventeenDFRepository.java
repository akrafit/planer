package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.SeventeenDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeventeenDFRepository extends JpaRepository<SeventeenDF, Long> {

    @Query
    Iterable<SeventeenDF> findSeventeenDFByDf(DF df);
}
