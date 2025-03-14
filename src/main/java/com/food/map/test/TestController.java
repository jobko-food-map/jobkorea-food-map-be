package com.food.map.test;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://localhost:*")
public class TestController {
    private final TestService service;

    @GetMapping("/v1/test")
    public TestEntity getTest(@RequestParam Long id){
        return service.get(id);
    }

    @GetMapping("/v1/all/test")
    public List<TestEntity> getAllTest(){
        return service.getAll();
    }

    @PostMapping("/v1/test")
    public void getTest2(@RequestParam String name){
        service.save(name);
    }
}
