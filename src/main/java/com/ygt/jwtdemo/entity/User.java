package com.ygt.jwtdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * 实体类
 */
@Entity(name = "user")
@Getter
@Setter
public class User {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    private String Id;
    /**
     * 用户名
     */
    @Column(name = "userName")
    private String userName;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     * 最近一次登录时间
     */
    @Column(name = "lastLoginTime")
    private Timestamp lastLoginTime;
}
