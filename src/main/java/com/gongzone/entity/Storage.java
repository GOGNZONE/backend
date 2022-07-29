package com.gongzone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.gongzone.dto.StorageDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Storage 엔티티
 * @author kangdonghyeon
 * @version 1.0
 */



@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Storage {
	@Id
	@Column(name="storage_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storageId;
	
	
	@Column(name="storage_address", length=80)
	@NotNull
	private String storageAddress;

	@Column(name="storage_category", length=20)
	@NotNull
	private String storageCategory;
	
	@Column(name="storage_description")
	@ColumnDefault("NULL")
	private String storageDescription;
	
	
	/**
	 * Storage 수정
	 * @param {storageAddress, storageCategory, storageDescription}
	 * @return 값을 업데이트만 하기때문에 void
	 */
	
	public void updateStorage(String storageAddress, String storageCategory, String storageDescription) {
		this.storageAddress = storageAddress;
		this.storageCategory = storageCategory;
		this.storageDescription = storageDescription;
	}
	
	/**
	 * StorageEntity를StorageDTO로 변경
	 * @param {StorageEntity}
	 * @return StorageEntity를 StorageDTO로 변경한 값
	 */
	
	
	public StorageDTO toDTO(Storage storageEntity) {
		StorageDTO storageDTO = StorageDTO.builder()
				.storageId(storageEntity.getStorageId())
				.storageAddress(storageEntity.getStorageAddress())
				.storageCategory(storageEntity.getStorageCategory())
				.storageDescription(storageEntity.getStorageDescription())
				.build();
		return storageDTO;
	}
	
	
	
	
	
	
}
