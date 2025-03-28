package com.food.map.favorites.controller;

import com.food.map.favorites.dto.FavoritesReq;
import com.food.map.favorites.dto.FavoritesRes;
import com.food.map.favorites.mapper.FavoritesMapper;
import com.food.map.favorites.service.FavoritesService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:*")
public class FavoritesController {
    private final FavoritesService service;
    private final FavoritesMapper mapper;

    @GetMapping("/v1/{userId}/favorites")
    public List<FavoritesRes> find(@PathVariable String userId){
        var list = service.find(userId);
        return list.stream()
            .map(mapper::toRes)
            .toList();
    }

    @PostMapping("/v1/favorites")
    public FavoritesRes save(@Valid @RequestBody FavoritesReq req){
        var favorites = service.save(req);

        return mapper.toRes(favorites);
    }
}
