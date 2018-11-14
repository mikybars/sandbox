package com.inditex.rrhh.icmclcwb.model.primary.entity.poc;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "INCOME_POC_EJECUCION", schema = "DESARROLLO_RRHH")
@Data
public class PocEjecucion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EJECUCION")
	private /* BigInteger */ Long id;

	@NotNull
	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fechaCreacion;
	
	@NotBlank
	@Column(name = "SISTEMA", nullable = false)
	private String sistema;
	
	@NotNull
	@Column(name = "ID_SISTEMA_EJECUCION", nullable = false)
	private /* BigInteger */ Long idSistemaEjecucion;
	
	@NotBlank
	@Column(name = "PERIODO", nullable = false)
	private String periodo;
	
	@NotBlank
	@Column(name = "ID_PAIS", nullable = false)
	private String idPaisOrigen;

	@NotBlank
	@Column(name = "ID_EMPRESA", nullable = false)
	private String idEmpresa;

	@Column(name = "TIENDAS", nullable = true)
	private String tiendas;

}