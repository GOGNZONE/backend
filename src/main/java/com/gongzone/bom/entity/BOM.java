package com.gongzone.bom.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.gongzone.bom.dto.BOMUpdateDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * BOM 엔티티
 * fk 매핑전
 * @version 1.0
 * @author kangdonghyeon
 *
 */
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_bom")
public class BOM {
	@Id
	@Column(name="bom_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bomId;
	
	@Column(name="bom_name", length=30)
	@NotNull
	private String bomName;
	
	@Column(name="bom_quantity",length=6)
	@NotNull
	@ColumnDefault("0")
	private int bomQuantity;
	
	@Column(name="bom_price")
	@NotNull
	@ColumnDefault("0")
	private Long bomPrice;
	
	@Column(name="bom_standard",length=10)
	@ColumnDefault("NULL")
	private String bomStandard;
	
	@Column(name="bom_unit",length=10)
	@ColumnDefault("NULL")
	private String bomUnit;
	
	@Column(name="bom_description")
	@ColumnDefault("NULL")
	private String bomDescription;
	
	@Column(name="bom_received_data")
	@NotNull
	@CreatedDate
	private LocalDateTime bomReceivedData;
	
	@Column(name="bom_file")
	@NotNull
	private String bomFile;
	
	@Column(name="bom_required_quantity",length=6)
	@ColumnDefault("0")
	@NotNull
	private int bomRequiredQuntity;
	
	@Column(name="fk_production_bom_id")
	@NotNull
	private Long productionBomId;
	
	@Column(name="fk_stroage_id")
	@NotNull
	private Long storageId;
	
	@Column(name="bom_parent_id")
	private Long bomParentId;
	
	/**
	 * BOM 수정
	 * @param {bomDTO}
	 * @return 값을 업데이트만 하기때문에 void
	 */
	
	public void updateBOM(BOMUpdateDTO updateDto) {
		this.bomName = updateDto.getBomName();
		this.bomQuantity = updateDto.getBomQuantity();
		this.bomPrice = updateDto.getBomPrice();
		this.bomStandard = updateDto.getBomStandard();
		this.bomUnit = updateDto.getBomUnit();
		this.bomDescription = updateDto.getBomDescription();
		this.bomFile = updateDto.getBomFile();
		this.bomRequiredQuntity = updateDto.getBomRequiredQuntity();
		
	}

}
