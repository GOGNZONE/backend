package com.gongzone.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.gongzone.dto.BomDTO;

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
	private LocalDateTime bomReceivedData;
	
	@Column(name="bom_file")
	@NotNull
	private String bomFile;
	
	@Column(name="bom_required_quantity",length=6)
	@ColumnDefault("0")
	@NotNull
	private String bomRequiredQuntity;
	
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
	
	public void updateBOM(BomDTO bomDTO) {
		this.bomName = bomDTO.getBomName();
		this.bomQuantity = bomDTO.getBomQuantity();
		this.bomPrice = bomDTO.getBomPrice();
		this.bomStandard = bomDTO.getBomStandard();
		this.bomUnit = bomDTO.getBomUnit();
		this.bomDescription = bomDTO.getBomDescription();
		this.bomReceivedData = bomDTO.getBomReceivedData();
		this.bomFile = bomDTO.getBomFile();
		this.bomRequiredQuntity = bomDTO.getBomRequiredQuntity();
		
	}

	
	
}
