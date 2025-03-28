package com.food.map.favorites.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "favorites")
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoritesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "place_id")
	private Long placeId;

	@Column(name = "created_at")
	private LocalDateTime createdAt;
}
