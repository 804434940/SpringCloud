package com.wml.consumer.client;

import com.wml.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = UserClientFallBack.class )//服务名
public interface UserClient {
    /**
     * 请求路径
     */
    @GetMapping("user/{id}")
    User queryById(@PathVariable("id")Integer id) ;
}
