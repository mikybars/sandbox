package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoMinutosPresencia;

import lombok.Data;

@Entity
@Table(name = "TAREA_TIENDA_EMPLEADO_PRESENCIA_SECCION")
@Data
public class TareaTiendaEmpleadoPresenciaSeccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TAREA_TIENDA_EMPLEADO_PRESENCIA_SECCION")
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
	
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_MINUTOS_PRESENCIA", nullable = false)
    private TipoMinutosPresencia tipoMinutosPresencia;

}