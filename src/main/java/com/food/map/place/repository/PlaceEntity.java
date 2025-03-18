package com.food.map.place.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "place")
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "place_name")
	private String placeName;

	@Column(name = "place_desc")
	private String placeDesc;

	@Column(name = "category")
	private String category;

	@Column(name = "location_x")
	private String locationX;

	@Column(name = "location_y")
	private String locationY;

}
