package com.food.map.report.controller;

import com.food.map.common.PageResponse;
import com.food.map.report.dto.ReportReq;
import com.food.map.report.dto.ReportRes;
import com.food.map.report.mapper.ReportMapper;
import com.food.map.report.service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:*")
public class ReportController {
    private final ReportService service;
    private final ReportMapper mapper;

    @GetMapping("/v1/all/report")
    public PageResponse<ReportRes> getReport(@RequestParam int pageNo, @RequestParam int pageSize){
        var list = service.findAll(pageNo, pageSize);
        return PageResponse.of(list, mapper::toRes);
    }

    @PostMapping("/v1/report")
    public ReportRes save(@Valid @RequestBody ReportReq req){
        var report = service.save(req);

        return mapper.toRes(report);
    }
}
