package com.food.map.report.service;


import com.food.map.report.dto.Report;
import com.food.map.report.dto.ReportReq;
import com.food.map.report.mapper.ReportMapper;
import com.food.map.report.repository.ReportCustomRepository;
import com.food.map.report.repository.ReportRepository;
import com.food.map.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportService {
    private final ReportRepository repository;
    private final ReportCustomRepository customRepository;
    private final UserRepository userRepository;
    private final ReportMapper mapper;
    private final ReportRepository reportRepository;

    public Page<Report> findAll(int pageNo, int pageSize){
        var pageable = PageRequest.of(pageNo, pageSize);
        var entities = customRepository.findAll(pageable);
        var content = entities.getContent()
            .stream()
            .map(mapper::to)
            .toList();

        return PageableExecutionUtils.getPage(content, pageable, entities::getTotalElements);
    }

    @Transactional
    public Report save(ReportReq report){
        var findUser = userRepository.findByUserId(report.userId());
        if(ObjectUtils.isEmpty(findUser)){
            throw new RuntimeException("없는 유저 입니다.");
        }

        var findReport = reportRepository.findByPlaceId(report.placeId());
        if(ObjectUtils.isNotEmpty(findReport)){
            throw new RuntimeException("이미 제보 했습니다.");
        }

        var entity = mapper.to(report);
        repository.save(entity);

        return mapper.to(entity);
    }
}
