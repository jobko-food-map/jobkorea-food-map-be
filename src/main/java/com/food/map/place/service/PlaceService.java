package com.food.map.place.service;

import com.food.map.place.dto.Place;
import com.food.map.place.mapper.PlaceMapper;
import com.food.map.place.repository.PlaceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceService {
    private final PlaceRepository repository;
    private final PlaceMapper mapper;

    public Place get(Long id){
        var entity = repository.findById(id)
            .orElse(null);
        return mapper.to(entity);
    }

    public List<Place> getAll(){
        var entities = repository.findAll();
        return entities.stream()
            .map(mapper::to)
            .toList();
    }

    @Transactional
    public Place save(Place place){
        var findPlace = repository.findByPlaceName(place.placeName());
        if(ObjectUtils.isNotEmpty(findPlace)){
            throw new RuntimeException("이미 있는 장소 입니다.");
        }

        var entity = mapper.to(place);
        repository.save(entity);

        return mapper.to(entity);
    }
}
