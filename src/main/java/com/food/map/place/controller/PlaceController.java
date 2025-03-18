package com.food.map.place.controller;

import com.food.map.place.dto.Place;
import com.food.map.place.dto.PlaceReq;
import com.food.map.place.mapper.PlaceMapper;
import com.food.map.place.service.PlaceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:*")
public class PlaceController {
    private final PlaceService service;
    private final PlaceMapper mapper;

    @GetMapping("/v1/place")
    public Place getPlace(@RequestParam Long id){
        return service.get(id);
    }

    @GetMapping("/v1/all/place")
    public List<Place> getAllPlace(){
        return service.getAll();
    }

    @PostMapping("/v1/place")
    public Place save(@RequestBody PlaceReq req){
        var place = mapper.to(req);

       return service.save(place);
    }
}
