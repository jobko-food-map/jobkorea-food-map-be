package com.food.map.vote.controller;

import com.food.map.vote.dto.VoteReq;
import com.food.map.vote.dto.VoteRes;
import com.food.map.vote.mapper.VoteMapper;
import com.food.map.vote.service.VoteService;
import jakarta.validation.Valid;
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
public class VoteController {
    private final VoteService service;
    private final VoteMapper mapper;

    @GetMapping("/v1/vote/{reportId}")
    public long getVote(@PathVariable long reportId){
        return service.get(reportId);
    }

    @PostMapping("/v1/vote")
    public VoteRes save(@Valid @RequestBody VoteReq req){
        var user = mapper.to(req);
        var save = service.save(user);

        return mapper.toRes(save);
    }
}
