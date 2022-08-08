package com.gongzone.storage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 창고 엔티티
 * @author kangdonghyeon
 * @version 1.0
 */


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_storage")
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
	 * @return void
	 */
	
	public void updateStorage(String storageAddress, String storageCategory, String storageDescription) {
		this.storageAddress = storageAddress;
		this.storageCategory = storageCategory;
		this.storageDescription = storageDescription;
	}
	

}
