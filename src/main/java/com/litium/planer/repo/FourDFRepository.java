package com.litium.planer.repo;

import com.litium.planer.entity.DF;
import com.litium.planer.entity.FourDF;
import com.litium.planer.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FourDFRepository  extends JpaRepository<FourDF, Long> {


    @Query
    Iterable<FourDF> findFourDFByDfAndUser(DF df, UserEntity user);
    @Query
    Iterable<FourDF> findFourDFByDf(DF df);
}
