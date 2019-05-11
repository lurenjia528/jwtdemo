package com.ygt.jwtdemo.repository;

import com.ygt.jwtdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * 用户持久化层
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>, CrudRepository<User,String> {
    User findOneByUserName(String userName);

    @Query(nativeQuery = true, value = "update user set last_login_time = ?1 where user_name = ?2")
    @Modifying
    void updateLastLoginTimeByUserName(Timestamp time, String userName);
}
