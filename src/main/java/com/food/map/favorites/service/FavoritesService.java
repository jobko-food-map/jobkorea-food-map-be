package com.food.map.favorites.service;


import com.food.map.favorites.dto.Favorites;
import com.food.map.favorites.dto.FavoritesReq;
import com.food.map.favorites.mapper.FavoritesMapper;
import com.food.map.favorites.repository.FavoritesRepository;
import com.food.map.place.repository.PlaceRepository;
import com.food.map.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FavoritesService {
    private final FavoritesRepository repository;
    private final FavoritesMapper mapper;

    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;

    public List<Favorites> find(String userId){
        var entities = repository.findByUserId(userId);
        return entities.stream()
            .map(mapper::to)
            .toList();
    }

    @Transactional
    public Favorites save(FavoritesReq req){
        var findUser = userRepository.findByUserId(req.userId());
        if(ObjectUtils.isEmpty(findUser)){
            throw new IllegalArgumentException("사용자 정보가 없습니다.");
        }

        var findPlace = placeRepository.findById(req.placeId());
        if(ObjectUtils.isEmpty(findPlace)){
            throw new IllegalArgumentException("플레이스 정보가 없습니다.");
        }

        var entity = mapper.to(req);
        repository.save(entity);

        return mapper.to(entity);
    }
}
