package com.gongzone.entity.production;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 생산 이력 엔티티
 * @author Hanju Park
 * @version 1.0
 * */
@Entity
@Table(name = "t_production_history")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(ProductionHistoryId.class)
@Schema(description = "생산 이력")
public class ProductionHistory {
	
	@Id
	@Column(name = "production_history_id")
	@Schema(description = "생산 이력 코드")
	private Long productionHistoryId;
	
	@Column(name="production_history_type")
	@NotNull(message = "production history type cannot be null")
	@Schema(description = "유형", nullable = false)
	private Byte productionHistoryType;
	
	@CreatedDate
	@Column(name="production_history_correction_date")
	@NotNull(message = "production history correction date cannot be null")
	@Schema(description = "생산 데이터 수정 일자", nullable = false)
	private String productionHistoryCorrectionDate;
	
	@Column(name="production_history_description", columnDefinition = "TEXT")
	@Schema(description = "생산 이력 비고")
	private String productionHistoryDescription;
	
	@Id
	@ManyToOne
	@JoinColumn(name="fk_production_id")
	@JsonIgnore
	@Schema(description = "변경 이력이 있는 상품에 대한 정보", nullable = false)
	private Production production;
	
}
