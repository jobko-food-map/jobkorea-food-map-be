package com.food.map.vote.mapper;

import com.food.map.vote.dto.Vote;
import com.food.map.vote.dto.VoteReq;
import com.food.map.vote.dto.VoteRes;
import com.food.map.vote.repository.VoteEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class VoteMapperImpl implements VoteMapper {

    @Override
    public VoteEntity to(Vote source) {
        if ( source == null ) {
            return null;
        }

        VoteEntity.VoteEntityBuilder voteEntity = VoteEntity.builder();

        voteEntity.id( source.id() );
        voteEntity.reportId( source.reportId() );
        voteEntity.userId( source.userId() );
        voteEntity.createdAt( source.createdAt() );

        return voteEntity.build();
    }

    @Override
    public Vote to(VoteEntity source) {
        if ( source == null ) {
            return null;
        }

        Vote.VoteBuilder vote = Vote.builder();

        vote.id( source.getId() );
        vote.userId( source.getUserId() );
        vote.reportId( source.getReportId() );
        vote.createdAt( source.getCreatedAt() );

        return vote.build();
    }

    @Override
    public Vote to(VoteReq source) {
        if ( source == null ) {
            return null;
        }

        Vote.VoteBuilder vote = Vote.builder();

        vote.userId( source.userId() );
        vote.reportId( source.reportId() );
        vote.isApprove( source.isApprove() );

        vote.createdAt( java.time.LocalDateTime.now() );

        return vote.build();
    }

    @Override
    public VoteRes toRes(Vote source) {
        if ( source == null ) {
            return null;
        }

        VoteRes.VoteResBuilder voteRes = VoteRes.builder();

        voteRes.id( source.id() );
        voteRes.reportId( source.reportId() );
        voteRes.userId( source.userId() );
        voteRes.createdAt( source.createdAt() );

        return voteRes.build();
    }
}
