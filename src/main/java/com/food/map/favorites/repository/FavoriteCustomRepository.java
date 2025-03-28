package com.food.map.favorites.repository;

import com.food.map.place.repository.QPlaceEntity;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class FavoriteCustomRepository extends QuerydslRepositorySupport {

    private static final QFavoritesEntity qFavoritesEntity = QFavoritesEntity.favoritesEntity;
    private static final QPlaceEntity qPlaceEntity = QPlaceEntity.placeEntity;

    public FavoriteCustomRepository() {
        super(QFavoritesEntity.class);
    }

    public List<FavoritesEntity> findByUserId(String userId) {
        return from(qFavoritesEntity)
            .join(qPlaceEntity).on(qFavoritesEntity.placeId.eq(qPlaceEntity.id))
            .where(qFavoritesEntity.userId.eq(userId))
            .fetch();
    }
}
