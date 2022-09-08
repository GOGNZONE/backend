package com.gongzone.bom.dto;

import java.time.LocalDate;

import com.gongzone.bom.entity.BOM;
import com.gongzone.storage.entity.Storage;

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
	private LocalDate bomReceivedDate;
	private String bomFile;
	private Storage storage;
	private BOM bomParent;

}
