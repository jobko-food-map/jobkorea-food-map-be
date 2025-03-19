package com.food.map.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteEntity, Long> {
     VoteEntity findByUserId(String userId);
}
