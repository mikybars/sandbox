package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

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

@Entity
@Table(name = "PROCESO_TIENDA_EMPLEADO_PRESENCIA_SECCION")
@Data
public class ProcesoTiendaEmpleadoPresenciaSeccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROCESO_TIENDA_EMPLEADO_PRESENCIA_SECCION")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_PROCESO", nullable = false)
	private /* BigInteger */ Proceso proceso;
	
	@NotNull
	@Column(name = "FECHA", nullable = false)
	private Date fecha;
	
	@NotNull
	@Column(name = "ID_TIENDA", nullable = false)
	private String idTienda;
	
	@NotNull
	@Column(name = "ID_EMPLEADO", nullable = false)
	private String idEmpleado;
	
	@NotNull
	@Column(name = "MINUTOS_SECCION_1", nullable = false)
	private /* BigInteger */ Long minutos1;
	
	@NotNull
	@Column(name = "MINUTOS_SECCION_2", nullable = false)
	private /* BigInteger */ Long minutos2;
	
	@NotNull
	@Column(name = "MINUTOS_SECCION_3", nullable = false)
	private /* BigInteger */ Long minutos3;
	
	@NotNull
    @Column(name = "ID_TIPO_HORA", nullable = false)
    private /* BigInteger */ String idTipoHora;

}