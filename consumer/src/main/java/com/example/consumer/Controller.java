package com.example.consumer;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "executeHystrixHandle")
    @RequestMapping("/api/test/myfirst/get")
    public String consumer(){
        return this.restTemplate.getForObject("http://localhost:8765/producer/myfirst", String.class);
    }
    public String executeHystrixHandle() {
        return  "服务器繁忙，负载过高";
    }
}
