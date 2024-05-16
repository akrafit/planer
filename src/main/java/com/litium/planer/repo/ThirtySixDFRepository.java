package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.ThirtySixDF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ThirtySixDFRepository extends JpaRepository<ThirtySixDF,Long> {
    @Query
    Iterable<ThirtySixDF> findThirtySixDFByDf(DF df);
}
