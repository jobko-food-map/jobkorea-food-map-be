package com.food.map.place.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
public class PlaceCustomRepository extends QuerydslRepositorySupport {

    private static final QPlaceEntity qPlaceEntity = QPlaceEntity.placeEntity;

    public PlaceCustomRepository() {
        super(QPlaceEntity.class);
    }

    public Page<PlaceEntity> findAll(Pageable pageable, boolean isApprove){
        var query = from(qPlaceEntity)
            .where(qPlaceEntity.isApprove.eq(isApprove))
            .orderBy(qPlaceEntity.createdAt.desc());

        var paging = getQuerydsl().applyPagination(pageable, query).fetch();
        return PageableExecutionUtils.getPage(paging, pageable, query::fetchCount);
    }
}
