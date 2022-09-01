package com.gongzone.production.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gongzone.client.entity.Client;
import com.gongzone.production.dto.ProductionUpdateDto;
import com.gongzone.release.entity.Release;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 생산 엔티티
 * @author Hanju Park
 * @version 1.0
 * */
@Entity
@Table(name = "t_production")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "생산")
public class Production {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "production_id")
	@Schema(description = "생산 제품 코드")
	private Long productionId;
	
	@Column(name = "production_name", length = 30)
	@NotNull(message = "production name cannot be null")
	@Schema(description = "생산 제품명", nullable = false)
	private String productionName;
	
	@Column(name = "production_brand_name", length = 30)
	@Schema(description = "생산 제품 브랜드명")
	private String productionBrandName;
	
	@Column(name = "production_price")
	@NotNull(message = "production price cannot be null")
	@ColumnDefault("0")
	@Schema(description = "생산 제품 단가", defaultValue = "0", nullable = false)
	private Long productionPrice;
	
	@Column(name = "production_quantity")
	@NotNull(message = "production quantity cannot be null")
	@ColumnDefault("1")
	@Schema(description = "생산 제품 수량(제작수량)", defaultValue = "1", nullable = false)
	private int productionQuantity;
	
	@Column(name = "production_file", length = 80)
	@Schema(description = "생산 제품 파일")
	private String productionFile;
	
	@Column(name = "production_standard", length = 10)
	@Schema(description = "생산 제품 규격 → 크기", example = "이불(S,SS,Q,K)")
	private String productionStandard;
	
	@Column(name = "production_unit", length = 10)
	@Schema(description = "생산 제품 규격 단위", example = "개, yard 등")
	private String productionUnit;
	
	@Column(name = "production_description", columnDefinition = "TEXT")
	@Schema(description = "생산 제품 비고")
	private String productionDescription;
	
	@Column(name = "production_date")
	@NotNull(message = "production date cannot be null")
	@Schema(description = "생산 제품 생성 일자", nullable = false)
	private String productionDate;
	
	@ManyToOne
	@JoinColumn(name = "fk_client_id", nullable = true)
	@JsonIgnore
	@Schema(description = "거래처 정보")
	private Client client;
	
	@OneToMany(mappedBy = "production")
	@Schema(description = "생산 제품에 대한 출고내역")
	List<Release> releases = new ArrayList<>();
	
	/**
	 * 생산 품목 수정 메서드
	 * @param { productionUpdateDto }
	 * @return void
	 * */
	public void updateProduction(ProductionUpdateDto productionUpdateDto) {
		this.productionName = productionUpdateDto.getProductionName();
		this.productionBrandName = productionUpdateDto.getProductionBrandName();
		this.productionPrice = productionUpdateDto.getProductionPrice();
		this.productionQuantity = productionUpdateDto.getProductionQuantity();
		this.productionFile = productionUpdateDto.getProductionFile();
		this.productionStandard = productionUpdateDto.getProductionStandard();
		this.productionUnit = productionUpdateDto.getProductionUnit();
		this.productionDescription = productionUpdateDto.getProductionDescription();
//		this.productionReleasedDate = productionUpdateDto.getProductionReleasedDate();
	}
	
}