package com.gongzone.bom.dto;

import java.time.LocalDateTime;

import com.gongzone.bom.entity.BOM;

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
public class BOMDTO {
	private Long bomId;
	private String bomName;
	private int bomQuantity;
	private Long bomPrice;
	private String bomStandard;
	private String bomUnit;
	private String bomDescription;
	private LocalDateTime bomReceivedData;
	private String bomFile;
	private String bomRequiredQuntity;
	private Long productionBomId;
	private Long storageId;
	private Long bomParentId;
	
	/**
	 * BomDTO를 BOMEntity로 변환
	 * @param {BOMDTO}
	 * @return BOM
	 */
	public BOM toEntity(BOMDTO bomDTO) {
		BOM bomEntity = BOM.builder()
				.bomId(bomDTO.getBomId())
				.bomName(bomDTO.getBomName())
				.bomQuantity(bomDTO.getBomQuantity())
				.bomPrice(bomDTO.getBomPrice())
				.bomStandard(bomDTO.getBomStandard())
				.bomUnit(bomDTO.getBomUnit())
				.bomDescription(bomDTO.getBomDescription())
				.bomReceivedData(bomDTO.getBomReceivedData())
				.bomFile(bomDTO.getBomFile())
				.bomRequiredQuntity(bomDTO.getBomRequiredQuntity())
				.productionBomId(bomDTO.getProductionBomId())
				.storageId(bomDTO.getStorageId())
				.bomParentId(bomDTO.getBomParentId())
				.build();
				return bomEntity;
				
	}
	
	
	
	
	
	
	
	
}
