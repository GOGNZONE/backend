package com.gongzone.entity.bom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gongzone.bom.dto.BOMUpdateDTO;
import com.gongzone.entity.storage.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * BOM 엔티티
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
	@JsonIgnore
	private String bomName;
	
	@Column(name="bom_quantity",length=6)
	@NotNull
	@ColumnDefault("0")
	@JsonIgnore
	private int bomQuantity;
	
	@Column(name="bom_price")
	@NotNull
	@ColumnDefault("0")
	@JsonIgnore
	private Long bomPrice;
	
	@Column(name="bom_standard",length=10)
	@ColumnDefault("NULL")
	@JsonIgnore
	private String bomStandard;
	
	@Column(name="bom_unit",length=10)
	@ColumnDefault("NULL")
	@JsonIgnore
	private String bomUnit;
	
	@Column(name="bom_description")
	@ColumnDefault("NULL")
	@JsonIgnore
	private String bomDescription;
	
	@Column(name="bom_received_date")
	@NotNull
	@JsonIgnore
//	@CreatedDate
	private LocalDate bomReceivedDate;
	
	@Column(name="bom_file")
	@NotNull
	@JsonIgnore
	private String bomFile;
		
	@JoinColumn(name="fk_stroage_id")
	@ManyToOne(targetEntity = Storage.class)
	@NotNull
	@JsonIgnore
	private Storage storage;
	
	
	
	@ManyToOne
//	(fetch = FetchType.LAZY)
    @JoinColumn(name = "bom_parent_id", referencedColumnName = "bom_id")
	@JsonIgnore
	private BOM bomParent;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bomParent")
	@JsonIgnore
    final List<BOM> children = new ArrayList<>();
	
	
	/**
	 * BOM 수정
	 * @param {bomDTO}
	 * @return void
	 */
	
	public void updateBOM(BOMUpdateDTO updateDto) {
		this.bomName = updateDto.getBomName();
		this.bomQuantity = updateDto.getBomQuantity();
		this.bomPrice = updateDto.getBomPrice();
		this.bomStandard = updateDto.getBomStandard();
		this.bomUnit = updateDto.getBomUnit();
		this.bomDescription = updateDto.getBomDescription();
		this.bomFile = updateDto.getBomFile();
		
	}

}
