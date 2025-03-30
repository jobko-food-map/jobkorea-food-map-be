package com.food.map.vote.repository;

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

@Table(name = "vote")
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "report_id")
	private Long reportId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "approve")
	private boolean isApprove;
}
