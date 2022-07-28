package com.gongzone.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * BOM DTO
 * @author kangdonghyeon
 * @version 1.0
 */



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BomDTO {
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
}
