package com.food.map.report.mapper;

import com.food.map.report.dto.Report;
import com.food.map.report.dto.ReportReq;
import com.food.map.report.dto.ReportRes;
import com.food.map.report.repository.ReportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ReportMapper {
    ReportEntity to(Report source);

    Report to(ReportEntity source);

    @Mapping(ignore = true, target = "id")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    ReportEntity to(ReportReq source);

    ReportRes toRes(Report source);
}
