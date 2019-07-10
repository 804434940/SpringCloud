package com.wml;

import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class GateWayApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplicaiton.class);
    }


}
