package com.food.map.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/v1/test")
    public String getTest(@RequestParam String url){
        return "Hello Food Job::" + url;
    }
}
