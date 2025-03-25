package com.food.map.report.repository;

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

@Table(name = "report")
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportEntity {

	private static final int MAX_THRESHOLD = 1;

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

	@Column(name = "user_id")
	private String userId;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "reject_count")
	private int rejectCount;

	@Column(name = "approve_count")
	private int approveCount;

	@Column(name = "display")
	private boolean isDisplay;

	public void setCount(boolean isApprove){
		if(isApprove){
			this.approveCount++;
			return;
		}

		this.rejectCount++;
	}

	public void notDisplay(){
		this.isDisplay = false;
	}

	public boolean getApproveThreshold(boolean isApprove){
		return isApprove && Math.subtractExact(this.approveCount, this.rejectCount) >= MAX_THRESHOLD;
	}

	public boolean getRejectThreshold(boolean isApprove){
		return !isApprove && Math.subtractExact(this.rejectCount, this.approveCount) >= MAX_THRESHOLD;
	}
}
