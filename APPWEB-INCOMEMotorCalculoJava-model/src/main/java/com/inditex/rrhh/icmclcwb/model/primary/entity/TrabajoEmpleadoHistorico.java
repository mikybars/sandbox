package com.inditex.rrhh.icmclcwb.model.primary.entity;

import java.util.Date;

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
@Table(name = "INCOME_TRABAJO_EMPLEADO_HISTORICO", schema = "DESARROLLO_RRHH")
@Data
public class TrabajoEmpleadoHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRABAJO_EMPLEADO_HISTORICO")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TRABAJO", nullable = false)
	private /* BigInteger */ Trabajo trabajo;
	
	@NotNull
    @Column(name = "ID_EMPLEADO", nullable = false)
    private String idEmpleado;

    @NotNull
    @Column(name = "OR_EMPLEADO", nullable = false)
    private String orEmpleado;
    
    @NotNull
    @Column(name = "ID_EMPLEADO_LOCAL", nullable = false)
    private String idEmpleadoLocal;
    
    @NotBlank
    @Column(name = "CCL_ID_COD_ORIGEN", nullable = false)
    private String idTienda;

    @NotBlank
    @Column(name = "STD_ID_WORK_LOCAT", nullable = false)
    private String idTiendaMeta4;
	
	@NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    private Date fechaFin;

}