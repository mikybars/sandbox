package com.inditex.rrhh.icmclcwb.model.primary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "ESTADO_TRABAJO", schema = "INCOME")
@Data
public class JobStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESTADO_TRABAJO")
	private /* BigInteger */ Long id;

	@NotBlank
	@Column(name = "DESCRIPCION", nullable = false)
	private String usuario;

}