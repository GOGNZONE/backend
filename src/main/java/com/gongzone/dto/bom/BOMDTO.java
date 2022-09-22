package com.gongzone.dto.bom;

import java.time.LocalDate;

import com.gongzone.entity.bom.BOM;
import com.gongzone.entity.storage.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
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
	private LocalDate bomReceivedDate;
	private String bomFile;
	private Storage storage;
	private BOM bomParent;

	public static class BomRequest {
		private Long bomId;
		private String bomName;
		private int bomQuantity;
		private Long bomPrice;
		private String bomStandard;
		private String bomUnit;
		private String bomDescription;
		private LocalDate bomReceivedDate;
		private String bomFile;
		private Storage storage;
		private BOM bomParent;
		
		/* DTO -> Entity */
		public BOM toEntity() {
			BOM bomEntity = BOM.builder()
					.bomId(bomId)
					.bomName(bomName)
					.bomQuantity(bomQuantity)
					.bomPrice(bomPrice)
					.bomStandard(bomStandard)
					.bomUnit(bomUnit)
					.bomDescription(bomDescription)
					.bomReceivedDate(bomReceivedDate)
					.bomFile(bomFile)
					.storage(storage)
					.bomParent(bomParent)
					.build();
			return bomEntity;
		}
	}
	
	@Getter
	public static class BomResponse {
		private Long bomId;
		private String bomName;
		private int bomQuantity;
		private Long bomPrice;
		private String bomStandard;
		private String bomUnit;
		private String bomDescription;
		private LocalDate bomReceivedDate;
		private String bomFile;
		private Storage storage;
		private BOM bomParent;
		
		public BomResponse(BOM bom) {
			this.bomId = bom.getBomId();
			this.bomName = bom.getBomName();
			this.bomQuantity = bom.getBomQuantity();
			this.bomPrice = bom.getBomPrice();
			this.bomStandard = bom.getBomStandard();
			this.bomUnit = bom.getBomUnit();
			this.bomDescription = bom.getBomDescription();
			this.bomReceivedDate = bom.getBomReceivedDate();
			this.bomFile = bom.getBomFile();
			this.storage = bom.getStorage();
			this.bomParent = bom.getBomParent();
		}
	}
}
