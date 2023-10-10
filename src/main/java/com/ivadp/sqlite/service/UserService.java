package com.ivadp.sqlite.service;

import com.ivadp.sqlite.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description 用户业务类
 * @Author xu.liang
 * @Date 2023/9/26 17:02
 */
public interface UserService {

    int insertUser(User user);

    int insertBatch(List<User> users);

    User selectUser(String id);

    List<User> selectAll();

    int deleteUser(String id);

    int updateUser(User user);
}
