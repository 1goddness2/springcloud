package com.example.producer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProducerController {
    @RequestMapping("/producer/myfirst")
    public String produce(){    
        return "my first springcloud";
    }
}
