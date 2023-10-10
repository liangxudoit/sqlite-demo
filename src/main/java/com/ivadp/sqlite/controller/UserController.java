package com.ivadp.sqlite.controller;

import com.ivadp.sqlite.entity.User;
import com.ivadp.sqlite.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName User
 * @Description 用户控制类
 * @Author xu.liang
 * @Date 2023/9/25 16:08
 */
@RestController
@RequestMapping(value = "user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/testAdd/{count}")
    public long addOne(@PathVariable Long count) {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            saveUser();
        }
        Long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000;
    }

    @GetMapping("/testAddBatch/{count}")
    public long addBatch(@PathVariable Long count) {
        return saveBatchUser(count);
    }

    private long saveBatchUser(long count) {
        Long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ArrayList<User> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
//            executorService.execute(()->{
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setAge(i);
            user.setName("梁" + i);
            user.setSex("男");
            arrayList.add(user);
            if (arrayList.size() > 1000) {
                userService.insertBatch(arrayList);
                arrayList.clear();
            }
//                int insert = userMapper.insert(user);
//            });
        }

        Long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000;
    }

    private String saveUser() {
        int insert = userService.insertUser(getUser());
        if (insert > 0) {
            return "新增成功！！！";
        }
        return null;
    }

    private User getUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().substring(0, 10));
        user.setAge(11);
        user.setName("梁12");
        user.setSex("男");
        return user;
    }

    @PostMapping("/add")
    public String add(@RequestBody User user) {

        user.setId(UUID.randomUUID().toString().substring(0, 10));
        int insert = userService.insertUser(user);
        if (insert > 0) {
            return "新增成功！！！";
        }
        return null;
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.selectAll();
    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable String id) {
        return userService.selectUser(id);
    }

    @PutMapping("/update")
    public int update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
