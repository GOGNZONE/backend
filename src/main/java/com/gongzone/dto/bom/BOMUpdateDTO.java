package com.gongzone.dto.bom;

import com.gongzone.entity.bom.BOM;
import com.gongzone.entity.storage.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * BOM업데이트 DTO
 * @author kangdonghyeon
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BOMUpdateDTO {
	private String bomName;
	private int bomQuantity;
	private Long bomPrice;
	private String bomStandard;
	private String bomUnit;
	private String bomDescription;
	private String bomFile;
	private int bomRequiredQuntity;
	private Storage storage;
	private BOM bomParent;
	
	public BOM toEntity(BOM bom) {
		BOM bomEntity = BOM.builder()
				.bomName(bomName)
				.bomQuantity(bomQuantity)
				.bomPrice(bomPrice)
				.bomStandard(bomStandard)
				.bomUnit(bomUnit)
				.bomDescription(bomDescription)
				.bomFile(bomFile)
				.storage(storage)
				.bomParent(bomParent)
				.build();
		return bomEntity;
	}
}
