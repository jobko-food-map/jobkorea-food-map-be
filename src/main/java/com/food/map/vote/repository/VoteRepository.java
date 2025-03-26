package com.food.map.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteEntity, Long> {
     VoteEntity findByUserIdAndReportId(String userId, long reportId);
}
