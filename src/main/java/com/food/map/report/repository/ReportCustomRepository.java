package com.food.map.report.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
public class ReportCustomRepository extends QuerydslRepositorySupport {

    private static final QReportEntity qReportEntity = QReportEntity.reportEntity;

    public ReportCustomRepository() {
        super(QReportEntity.class);
    }

    public Page<ReportEntity> findAll(Pageable pageable){
        var query = from(qReportEntity)
            .orderBy(qReportEntity.createdAt.desc());

        var paging = getQuerydsl().applyPagination(pageable, query).fetch();
        return PageableExecutionUtils.getPage(paging, pageable, query::fetchCount);
    }
}
