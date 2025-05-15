package com.food.map.favorites.controller;

import com.food.map.favorites.dto.FavoritesReq;
import com.food.map.favorites.dto.FavoritesRes;
import com.food.map.favorites.mapper.FavoritesMapper;
import com.food.map.favorites.service.FavoritesService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> save(@Valid @RequestBody FavoritesReq req) {
        try {
            var favorites = service.save(req);
            return ResponseEntity.ok(mapper.toRes(favorites));
        } catch (DuplicateFavoriteException e) {
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse("이미 저장된 즐겨찾기입니다."));
        }
    }
}

