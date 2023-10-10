package com.ivadp.sqlite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ivadp.sqlite.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author xu.liang
 * @Date 2023/9/25 15:21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    int insertUser(User user);

    int insertBatch(List<User> users);

    User selectUser(String id);

    List<User> selectAll();

    int deleteUser(String id);

    int updateUser(User user);

}
