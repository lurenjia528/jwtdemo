package com.ygt.jwtdemo.controller;

import com.ygt.jwtdemo.Reponse.UserResponse;
import com.ygt.jwtdemo.entity.User;
import com.ygt.jwtdemo.repository.UserRepository;
import com.ygt.jwtdemo.util.Constants;
import com.ygt.jwtdemo.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserRepository userRepository;

    //注册或登录
    @RequestMapping("/login")
    @Transactional
    public UserResponse login(User user) {
        String username = user.getUserName();
        String password = user.getPassword();
        //TODO  检验参数的完整性
        UserResponse userResponse = new UserResponse();
        //检验username是否存在
        User tUser = userRepository.findOneByUserName(username);
        user.setLastLoginTime(new Timestamp(new Date().getTime()));
        if (tUser != null) {
            //检验密码是否正确
            if (!tUser.getPassword().equals(password)) {
                userResponse.setErrorNum(Constants.ERR_NUM_PWD_ERR);
                userResponse.setErrorMsg(Constants.ERR_MSG_PWD_ERR);
                return userResponse;
            }
            System.out.println(user.getLastLoginTime());
            userRepository.updateLastLoginTimeByUserName(user.getLastLoginTime(), username);
        } else {
            try {
                tUser = userRepository.save(user);
            } catch (Exception e) {
                userResponse.setErrorNum(Constants.ERR_NUM_SERVER_ERR);
                userResponse.setErrorMsg(Constants.ERR_MSG_SERVER_ERR);
                return userResponse;
            }
        }
        userResponse.setErrorNum(Constants.ERR_NUM_OK);
        userResponse.setErrorMsg(Constants.ERR_MSG_OK);
        userResponse.setUserName(username);
        userResponse.setUserId(tUser.getId());
        userResponse.setToken(JwtUtil.generateToken(username, user.getLastLoginTime()));
        return userResponse;
    }
}
