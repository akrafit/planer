package com.litium.planer.repo;

import com.litium.planer.entity.User2DF;
import com.litium.planer.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface User2DFRepository extends JpaRepository<User2DF, Long> {
    @Query
    Iterable<User2DF> findUser2DFByUser(UserEntity user);
}
