package com.wml.consumer.web;


import com.wml.consumer.client.UserClient;
import com.wml.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
//@DefaultProperties(defaultFallback = "queryByIdFallback")
public class ConsumerController {

   // @Autowired
   // private RestTemplate restTemplate;

    // @Autowired
     //private RibbonLoadBalancerClient client;
    @Autowired
    private DiscoveryClient discoveryClient;


   //  @HystrixCommand(fallbackMethod = "queryByIdFallback")//失败容错指令,两个方法返回值和参数必输一致
//     @HystrixCommand(commandProperties = {
//             @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//     })
//     @HystrixCommand(commandProperties = {
//             @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
//             @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//休眠
//             @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
//
//     })
     //@HystrixCommand()
    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Integer id){
       return userClient.queryById(id);
    }
//      @GetMapping("{id}")
//     public String queryById(@PathVariable("id") Integer id){
//
//         String url="http://user-service/user/"+id ;
//         String user = restTemplate.getForObject(url, String.class);
//         return user;
//    }
    public String queryByIdFallback(){
        return "服务器拥挤";
    }


//    public String queryByIdFallback( Integer id){
//        return "服务器拥挤";
//    }

//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Integer id){
//       //根据服务id获取实例
//       // List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        //从实例中取出ip和端口
//       // ServiceInstance instance = instances.get(0);
//
//        //随机、轮询、哈希
//      //  ServiceInstance instance = client.choose("user-service");
//        //String url="http://"+instance.getHost()+":"+instance.getPort() +"/user/"+id;
//       String url="http://user-service/user/"+id ;
//       User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }
}
