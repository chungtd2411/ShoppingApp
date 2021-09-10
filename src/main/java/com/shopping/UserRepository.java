package com.shopping;

import com.shopping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository

public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional(rollbackFor=Exception.class)
    boolean existsByEmail(String email);
    User findByEmail(String email);
    @Transactional
    int deleteByEmail(String email);
    @Query("SELECT u from User u where u.name =:name  and u.pw =:pw")
    User login(@Param("name") String name, @Param("pw") String pw);
}
