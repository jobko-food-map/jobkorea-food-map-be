package com.food.map.report.mapper;

import com.food.map.report.dto.Report;
import com.food.map.report.dto.ReportReq;
import com.food.map.report.dto.ReportRes;
import com.food.map.report.repository.ReportEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public ReportEntity to(Report source) {
        if ( source == null ) {
            return null;
        }

        ReportEntity.ReportEntityBuilder reportEntity = ReportEntity.builder();

        reportEntity.id( source.id() );
        reportEntity.placeId( source.placeId() );
        reportEntity.placeName( source.placeName() );
        reportEntity.placeDesc( source.placeDesc() );
        reportEntity.category( source.category() );
        reportEntity.lat( source.lat() );
        reportEntity.lng( source.lng() );
        reportEntity.userId( source.userId() );
        reportEntity.createdAt( source.createdAt() );

        return reportEntity.build();
    }

    @Override
    public Report to(ReportEntity source) {
        if ( source == null ) {
            return null;
        }

        Report.ReportBuilder report = Report.builder();

        report.id( source.getId() );
        report.createdAt( source.getCreatedAt() );
        report.userId( source.getUserId() );
        report.placeId( source.getPlaceId() );
        report.placeName( source.getPlaceName() );
        report.placeDesc( source.getPlaceDesc() );
        report.category( source.getCategory() );
        report.lat( source.getLat() );
        report.lng( source.getLng() );

        return report.build();
    }

    @Override
    public ReportEntity to(ReportReq source) {
        if ( source == null ) {
            return null;
        }

        ReportEntity.ReportEntityBuilder reportEntity = ReportEntity.builder();

        reportEntity.placeId( source.placeId() );
        reportEntity.placeName( source.placeName() );
        reportEntity.placeDesc( source.placeDesc() );
        reportEntity.category( source.category() );
        reportEntity.lat( source.lat() );
        reportEntity.lng( source.lng() );
        reportEntity.userId( source.userId() );

        reportEntity.createdAt( java.time.LocalDateTime.now() );

        return reportEntity.build();
    }

    @Override
    public ReportRes toRes(Report source) {
        if ( source == null ) {
            return null;
        }

        ReportRes.ReportResBuilder reportRes = ReportRes.builder();

        reportRes.id( source.id() );
        reportRes.placeId( source.placeId() );
        reportRes.placeName( source.placeName() );
        reportRes.placeDesc( source.placeDesc() );
        reportRes.category( source.category() );
        reportRes.lat( source.lat() );
        reportRes.lng( source.lng() );
        reportRes.createdAt( source.createdAt() );

        return reportRes.build();
    }
}
