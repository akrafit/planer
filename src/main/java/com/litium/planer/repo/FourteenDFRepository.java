package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.FourteenDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FourteenDFRepository extends JpaRepository<FourteenDF, Long> {
    @Query
    Iterable<FourteenDF> findFourteenDFByDf(DF df);
}
