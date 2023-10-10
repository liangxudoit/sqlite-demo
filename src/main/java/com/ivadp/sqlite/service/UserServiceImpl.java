package com.ivadp.sqlite.service;

import com.ivadp.sqlite.entity.User;
import com.ivadp.sqlite.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description 用户业务类
 * @Author xu.liang
 * @Date 2023/9/26 17:03
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int insertBatch(List<User> users) {
        return userMapper.insertBatch(users);
    }

    @Override
    public User selectUser(String id) {
        return userMapper.selectUser(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int deleteUser(String id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
