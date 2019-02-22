package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "ESTADO_PROCESO")
@Data
public class EstadoProceso {

	@Id
	@Column(name = "ID_ESTADO_PROCESO")
	private /* BigInteger */ Long id;

	@NotBlank
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

}