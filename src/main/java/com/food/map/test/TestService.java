package com.food.map.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository repository;

    public TestEntity get( Long id){
        return repository.findById(id).orElse(null);
    }

    public void save( String name){
        var entity = TestEntity.builder()
            .name(name)
            .build();
        repository.save(entity);
    }
}
