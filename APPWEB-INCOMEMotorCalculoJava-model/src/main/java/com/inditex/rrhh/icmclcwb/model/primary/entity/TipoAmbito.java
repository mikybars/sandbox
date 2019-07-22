package com.inditex.rrhh.icmclcwb.model.primary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TIPO_AMBITO")
@Data
public class TipoAmbito {

	@Id
	@Column(name = "ID_TIPO_AMBITO")
	private Long id;

	@NotBlank
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

}