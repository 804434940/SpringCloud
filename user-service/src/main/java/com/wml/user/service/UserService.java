package com.wml.user.service;

import com.wml.user.mapper.UserMapper;
import com.wml.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public User queryById(Integer id ) throws InterruptedException {

        return mapper.selectByPrimaryKey(id);
    }
}
