package com.inditex.rrhh.icmclcwb.model.secondary.entity;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "M4HSW_SOLR_QUEUE")
@Data
public class SolrQueue {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private /* BigInteger */ Long id;

	@Column(name = "SOLR_INDEX", nullable = false)
	@NotBlank
	@Size(max = 1)
	private String index;

	@Column(name = "ITEM_DEF", nullable = false)
	@NotBlank
	@Size(max = 62)
	private String def;

	@Column(name = "ITEM_VALUE", nullable = false)
	@NotBlank
	private Clob value;

	@Column(name = "STATUS", nullable = false)
	@NotBlank
	@Size(max = 5)
	private String status;

	@Column(name = "HSW_ORD", nullable = true)
	private /* BigInteger */ Long orden;

	@Column(name = "DT_ACCESS", nullable = false)
	@NotNull
	private Date fecha;

}