package com.food.map.place.repository;

import com.food.map.place.enums.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
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

	@Column(name = "place_id")
	private String placeId;

	@Column(name = "place_name")
	private String placeName;

	@Column(name = "place_desc")
	private String placeDesc;

	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	private Category category;

	@Column(name = "lat")
	private String lat;

	@Column(name = "lng")
	private String lng;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "is_approve")
	private boolean isApprove;
}
