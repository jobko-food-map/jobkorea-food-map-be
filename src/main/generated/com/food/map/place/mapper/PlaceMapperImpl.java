package com.food.map.place.mapper;

import com.food.map.place.dto.Place;
import com.food.map.place.dto.PlaceReq;
import com.food.map.place.repository.PlaceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class PlaceMapperImpl implements PlaceMapper {

    @Override
    public PlaceEntity to(Place source) {
        if ( source == null ) {
            return null;
        }

        PlaceEntity.PlaceEntityBuilder placeEntity = PlaceEntity.builder();

        placeEntity.id( source.id() );
        placeEntity.placeName( source.placeName() );
        placeEntity.placeDesc( source.placeDesc() );
        placeEntity.category( source.category() );
        placeEntity.locationX( source.locationX() );
        placeEntity.locationY( source.locationY() );

        return placeEntity.build();
    }

    @Override
    public Place to(PlaceEntity source) {
        if ( source == null ) {
            return null;
        }

        Place.PlaceBuilder place = Place.builder();

        place.id( source.getId() );
        place.placeName( source.getPlaceName() );
        place.placeDesc( source.getPlaceDesc() );
        place.category( source.getCategory() );
        place.locationX( source.getLocationX() );
        place.locationY( source.getLocationY() );

        return place.build();
    }

    @Override
    public Place to(PlaceReq source) {
        if ( source == null ) {
            return null;
        }

        Place.PlaceBuilder place = Place.builder();

        place.placeName( source.placeName() );
        place.placeDesc( source.placeDesc() );
        place.category( source.category() );
        place.locationX( source.locationX() );
        place.locationY( source.locationY() );

        return place.build();
    }
}
