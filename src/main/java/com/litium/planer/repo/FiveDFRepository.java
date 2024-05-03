package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.FiveDF;
import com.litium.planer.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FiveDFRepository extends JpaRepository<FiveDF, Long> {


    @Query
    Iterable<FiveDF> findFiveDFByDfAndUser(DF df, UserEntity user);

    @Query
    Iterable<FiveDF> findFiveDFByDf(DF df);
}
