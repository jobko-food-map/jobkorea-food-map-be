package com.food.map.place.controller;

import com.food.map.common.PageResponse;
import com.food.map.place.dto.PlaceReq;
import com.food.map.place.dto.PlaceRes;
import com.food.map.place.mapper.PlaceMapper;
import com.food.map.place.service.PlaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:*")
public class PlaceController {
    private final PlaceService service;
    private final PlaceMapper mapper;

    @GetMapping("/v1/place/{id}")
    public PlaceRes getPlace(@PathVariable Long id){
        var place =  service.get(id);
        return mapper.toRes(place);
    }

    @GetMapping("/v1/random")
    public PlaceRes getPlace(){
        var place =  service.getRandom();
        return mapper.toRes(place);
    }

    @GetMapping("/v1/all/place")
    public PageResponse<PlaceRes> getAllPlace(
        @RequestParam int pageNo,
        @RequestParam int pageSize,
        @RequestParam boolean isApprove
    ){
        var list = service.findAll(pageNo, pageSize, isApprove);
        return PageResponse.of(list, mapper::toRes);
    }

    @PostMapping("/v1/place")
    public PlaceRes save(@Valid @RequestBody PlaceReq req){
        var place = mapper.to(req);
        var save = service.save(place);

        return mapper.toRes(save);
    }

    @PutMapping("/v1/{id}/place/resurrection")
    public void resurrection(@PathVariable long id){
        service.resurrection(id);
    }
}
