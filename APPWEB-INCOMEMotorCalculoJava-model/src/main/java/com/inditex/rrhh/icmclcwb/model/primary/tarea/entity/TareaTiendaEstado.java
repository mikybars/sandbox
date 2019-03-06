package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TAREA_TIENDA_ESTADO")
@Data
public class TareaTiendaEstado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TAREA_TIENDA_ESTADO")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TAREA", nullable = false)
	private /* BigInteger */ Tarea tarea;

	@NotBlank
	@Column(name = "CCL_ID_COD_ORIGEN", nullable = false)
	private String idTienda;

	@NotBlank
	@Column(name = "STD_ID_WORK_LOCAT", nullable = false)
	private String idTiendaMeta4;

	@NotBlank
	@Column(name = "STD_ID_COUNTRY", nullable = false)
	private String idPais;

	@NotBlank
	@Column(name = "CCL_ID_ORIGEN", nullable = false)
	private String idPaisOrigen;

	@NotBlank
	@Column(name = "STD_ID_LEG_ENT", nullable = false)
	private String idEmpresa;

	@NotBlank
	@Column(name = "CCL_ID_CADENA", nullable = false)
	private String idCadena;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TIPO_TAREA_TIENDA", nullable = false)
	private /* BigInteger */ TipoTareaTienda tipo;

}