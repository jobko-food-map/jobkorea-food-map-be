package com.food.map.vote.service;


import com.food.map.report.repository.ReportRepository;
import com.food.map.user.repository.UserRepository;
import com.food.map.vote.dto.Vote;
import com.food.map.vote.mapper.VoteMapper;
import com.food.map.vote.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VoteService {
    private final VoteRepository repository;
    private final UserRepository userRepository;
    private final ReportRepository reportRepository;
    private final VoteMapper mapper;

    public long get(long reportId){
        return repository.countByReportId(reportId);
    }

    @Transactional
    public Vote save(Vote vote){
        String userId = vote.userId();
        var findUser = userRepository.findByUserId(userId);
        if(ObjectUtils.isEmpty(findUser)){
            throw new RuntimeException("유저 정보가 없습니다.");
        }

        long reportId = vote.reportId();
        var findReport = reportRepository.findById(reportId).orElse(null);
        if(ObjectUtils.isEmpty(findReport)){
            throw new RuntimeException("제보 정보가 없습니다.");
        }

        var findVote = repository.findByUserId(userId);
        if(ObjectUtils.isNotEmpty(findVote)){
            throw new RuntimeException("이미 투표 했습니다.");
        }

        var entity = mapper.to(vote);
        repository.save(entity);

        findReport.setCount(vote.isApprove());

        return mapper.to(entity);
    }
}
