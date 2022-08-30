package com.gongzone.release.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gongzone.production.entity.Production;
import com.gongzone.release.dto.ReleaseInsertUpdateDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 출고 엔티티
 * @author Hanju Park
 * @version 1.0
 * */
@Entity
@Table(name = "t_release")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(ReleaseId.class)
public class Release {
	
	@Id
	@Column(name = "release_id")
	private Long releaseId;
	
	@Column(name = "release_date")
	@NotNull(message = "release date cannot be null")
	private String releaseDate;
	
	@Column(name = "release_description", columnDefinition = "TEXT")
	private String releaseDescription;
	
	@Column(name = "release_quantity")
	@NotNull(message = "release quantity cannot be null")
	@ColumnDefault("0")
	private int releaseQuantity;
	
	@Column(name = "release_total_price")
	@NotNull(message = "release total price cannot be null")
	@ColumnDefault("0")
	private Long releaseTotalPrice;
	
	@Column(name = "release_type", length = 10)
	@NotNull(message = "release type cannot be null")
	@ColumnDefault("'배송'")
	private String releaseType;
	
	@Id
	@ManyToOne
	@JoinColumn(name="fk_production_id")
	@JsonIgnore
	private Production production;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_delivery_id", nullable = true)
	private Delivery delivery;
	

	/**
	 * 출고 현황 수정 메서드
	 * @param { releaseDto }
	 * @return void
	 * */
	public void updateRelease(ReleaseInsertUpdateDto releaseInsertUpdateDto) {
		this.releaseDate = releaseInsertUpdateDto.getReleaseDate();
		this.releaseQuantity = releaseInsertUpdateDto.getReleaseQuantity();
		this.releaseTotalPrice = releaseInsertUpdateDto.getReleaseTotalPrice();
		this.releaseDescription = releaseInsertUpdateDto.getReleaseDescription();
	}
	
}