package com.food.map.vote.mapper;

import com.food.map.vote.dto.Vote;
import com.food.map.vote.dto.VoteReq;
import com.food.map.vote.dto.VoteRes;
import com.food.map.vote.repository.VoteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VoteMapper {
    VoteEntity to(Vote source);

    @Mapping(ignore = true, target = "isApprove")
    Vote to(VoteEntity source);

    @Mapping(ignore = true, target = "id")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Vote to(VoteReq source);

    VoteRes toRes(Vote source);
}
