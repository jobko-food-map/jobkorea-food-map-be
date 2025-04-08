package com.food.map.place.service;

import com.food.map.place.dto.Place;
import com.food.map.place.mapper.PlaceMapper;
import com.food.map.place.repository.PlaceCustomRepository;
import com.food.map.place.repository.PlaceRepository;
import com.food.map.report.repository.ReportRepository;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceService {
    private final PlaceRepository repository;
    private final PlaceCustomRepository customRepository;
    private final PlaceMapper mapper;
    private final ReportRepository reportRepository;

    public Place get(Long id){
        var entity = repository.findById(id)
            .orElse(null);
        return mapper.to(entity);
    }

    public Place getRandom(){
        var entities = repository.findByIsApprove(true);
        if(ObjectUtils.isEmpty(entities)){
            return null;
        }

        Collections.shuffle(entities);
        return mapper.to(entities.get(0));
    }

    public Page<Place> findAll(int pageNo, int pageSize, boolean isApprove){
        var pageable = PageRequest.of(pageNo, pageSize);
        var entities = customRepository.findAll(pageable, isApprove);
        var content = entities.getContent()
            .stream()
            .map(mapper::to)
            .toList();

        return PageableExecutionUtils.getPage(content, pageable, entities::getTotalElements);
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

    @Transactional
    public void resurrection(long id){
        var findPlace = repository.findById(id).orElse(null);
        if(ObjectUtils.isEmpty(findPlace) || findPlace.isApprove()){
            throw new RuntimeException("부활시킬 수 없는 장소 입니다.");
        }

        var findReport = reportRepository.findByPlaceId(findPlace.getPlaceId());
        if(ObjectUtils.isEmpty(findReport) || findReport.isDisplay()){
            throw new RuntimeException("부활시킬 수 없는 제보 입니다.");
        }

        findReport.resurrection();
        repository.deleteById(id);
    }
}
