package com.inditex.rrhh.icmclcwb.model.primary.entity;

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
@Table(name = "INCOME_TRABAJO_TIENDA_ESTADO", schema = "DESARROLLO_RRHH")
@Data
public class TrabajoTiendaEstado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRABAJO_TIENDA_ESTADO")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TRABAJO", nullable = false)
	private /* BigInteger */ Trabajo trabajo;
	
	@NotBlank
	@Column(name = "CCL_ID_COD_ORIGEN", nullable = false)
	private String idTienda;

	@NotBlank
	@Column(name = "STD_ID_WORK_LOCAT", nullable = false)
	private String idTiendaMeta4;

//	@NotBlank
//	@Column(name = "STD_ID_COUNTRY", nullable = false)
	@Column(name = "STD_ID_COUNTRY")
	private String idPais;

//	@NotBlank
//	@Column(name = "CCL_ID_ORIGEN", nullable = false)
    @Column(name = "CCL_ID_ORIGEN")
	private String idPaisOrigen;

//	@NotBlank
//	@Column(name = "STD_ID_LEG_ENT", nullable = false)
    @Column(name = "STD_ID_LEG_ENT")
	private String idEmpresa;

//	@NotBlank
//	@Column(name = "CCL_ID_CADENA", nullable = false)
    @Column(name = "CCL_ID_CADENA")
	private String idCadena;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_ESTADO_TRABAJO_TIENDA", nullable = false)
	private /* BigInteger */ EstadoTrabajoTienda estado;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TIPO_TRABAJO_TIENDA", nullable = false)
	private /* BigInteger */ TipoTrabajoTienda tipo;

}