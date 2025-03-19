package com.food.map.report.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    List<ReportEntity> findByUserId(String userId);

    ReportEntity findByPlaceId(String placeId);
}
