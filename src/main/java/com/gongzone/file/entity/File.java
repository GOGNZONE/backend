package com.gongzone.file.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 파일 엔티티
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
public class File {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="file_id")
	private Long fileId;
	
	@Column(name="file_path", length=30)
	private String filePath;
	private Long fkClientId;
	private Long fkProductionId;
	private Long fkBomId;
	private Long fkOrderId;
}
