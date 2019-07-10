package com.wml.consumer.client;

import com.wml.consumer.pojo.User;
import org.springframework.stereotype.Component;

@Component //注入到Spring
public class UserClientFallBack implements UserClient {
    @Override
    public User queryById(Integer id) {
        User user = new User();
        user.setUsername("未知用户！");
        return user;
    }
}
