package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Deprecated
@Entity
@Table(name = "TAREA_TIENDA_SECCION_PRESENCIA")
@Data
public class TareaTiendaSeccionPresencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TAREA_TIENDA_SECCION_PRESENCIA")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TAREA", nullable = false)
	private /* BigInteger */ Tarea tarea;
	
	@NotNull
	@Column(name = "FECHA", nullable = false)
	private Date fecha;
	
	@NotNull
	@Column(name = "ID_TIENDA", nullable = false)
	private String idTienda;
	
	@NotNull
	@Column(name = "ID_SECCION", nullable = false)
	private String idSeccion;
	
	@NotNull
	@Column(name = "MINUTOS", nullable = false)
	private /* BigInteger */ Long minutos;

}