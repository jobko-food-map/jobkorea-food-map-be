package com.food.map.favorites.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<FavoritesEntity, Long> {
    List<FavoritesEntity> findByUserId(String userId);
}
