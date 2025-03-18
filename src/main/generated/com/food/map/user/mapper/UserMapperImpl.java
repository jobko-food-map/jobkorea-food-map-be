package com.food.map.user.mapper;

import com.food.map.user.dto.User;
import com.food.map.user.repository.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity to(User source) {
        if ( source == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( source.id() );
        userEntity.userId( source.userId() );
        userEntity.userName( source.userName() );

        return userEntity.build();
    }

    @Override
    public User to(UserEntity source) {
        if ( source == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( source.getId() != null ) {
            user.id( source.getId() );
        }
        user.userId( source.getUserId() );
        user.userName( source.getUserName() );

        return user.build();
    }
}
