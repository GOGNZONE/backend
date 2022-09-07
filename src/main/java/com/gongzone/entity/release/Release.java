package com.gongzone.entity.release;

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
import com.gongzone.entity.production.Production;
import com.gongzone.release.dto.ReleaseInsertUpdateDto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "출고")
public class Release {
	
	@Id
	@Column(name = "release_id")
	@Schema(description = "출고 코드")
	private Long releaseId;
	
	@Column(name = "release_date")
	@NotNull(message = "release date cannot be null")
	@Schema(description = "출고 일자", nullable = false)
	private String releaseDate;
	
	@Column(name = "release_description", columnDefinition = "TEXT")
	@Schema(description = "출고 비고 사항")
	private String releaseDescription;
	
	@Column(name = "release_quantity")
	@NotNull(message = "release quantity cannot be null")
	@ColumnDefault("1")
	@Schema(description = "출고 수량", nullable = false, defaultValue = "1")
	private int releaseQuantity;
	
	@Column(name = "release_total_price")
	@NotNull(message = "release total price cannot be null")
	@ColumnDefault("0")
	@Schema(description = "공급가액(합계)", nullable = false, defaultValue = "0")
	private Long releaseTotalPrice;
	
	@Column(name = "release_type", length = 10)
	@NotNull(message = "release type cannot be null")
	@ColumnDefault("'배송'")
	@Schema(description = "출고 방식", nullable = false, defaultValue = "배송")
	private String releaseType;
	
	@Column(name="release_confirmed")
	@NotNull(message="release confirmed cannot be null")
	@ColumnDefault("0")
	@Schema(description = "출고 확정 여부", defaultValue = "확정전", nullable = false)
	private Byte releaseConfirmed;
	
	@Id
	@ManyToOne
	@JoinColumn(name="fk_production_id")
	@JsonIgnore
	@Schema(description = "출고 대상 상품(상품정보)", nullable = false)
	private Production production;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_delivery_id", nullable = true)
	@Schema(description = "해당 출고 택배 정보")
	private Delivery delivery;
	

	/**
	 * 출고 현황 수정 메서드
	 * @param { releaseInsertUpdateDto }
	 * @return void
	 * */
	public void updateRelease(ReleaseInsertUpdateDto releaseInsertUpdateDto) {
		this.releaseDate = releaseInsertUpdateDto.getReleaseDate();
		this.releaseQuantity = releaseInsertUpdateDto.getReleaseQuantity();
		this.releaseTotalPrice = releaseInsertUpdateDto.getReleaseTotalPrice();
		this.releaseDescription = releaseInsertUpdateDto.getReleaseDescription();
		this.releaseConfirmed = releaseInsertUpdateDto.getReleaseConfirmed();
		this.delivery = releaseInsertUpdateDto.getDelivery();
	}
	
}