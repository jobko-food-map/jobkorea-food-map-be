package com.food.map.user.service;

import com.food.map.user.dto.User;
import com.food.map.user.mapper.UserMapper;
import com.food.map.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public User get(String userId){
        var entity = repository.findByUserId(userId);
        return mapper.to(entity);
    }

    public List<User> getAll(){
        var entities = repository.findAll();
        return entities.stream()
            .map(mapper::to)
            .toList();
    }

    @Transactional
    public User save(User user){
        var findUser = repository.findByUserId(user.userId());
        if(ObjectUtils.isNotEmpty(findUser)){
            throw new RuntimeException("이미 있는 유저 입니다.");
        }

        var entity = mapper.to(user);
        repository.save(entity);

        return mapper.to(entity);
    }
}
