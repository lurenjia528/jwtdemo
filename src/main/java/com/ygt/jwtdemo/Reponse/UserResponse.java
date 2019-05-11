package com.ygt.jwtdemo.Reponse;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回的实体类
 */
@Getter
@Setter
public class UserResponse {
    /**
     * 用户名
     */
    String userName;
    /**
     * 用户id
     */
    String userId;
    /**
     * token
     */
    String token;
    /**
     * 错误码
     */
    int errorNum;
    /**
     * 错误信息
     */
    String errorMsg;
}
