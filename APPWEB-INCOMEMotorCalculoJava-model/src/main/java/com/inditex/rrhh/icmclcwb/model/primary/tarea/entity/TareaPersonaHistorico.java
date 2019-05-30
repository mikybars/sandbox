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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "TAREA_PERSONA_HISTORICO")
@Data
public class TareaPersonaHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TAREA_PERSONA_HISTORICO")
	private /* BigInteger */ Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TAREA", nullable = false)
	private /* BigInteger */ Tarea tarea;

	@NotBlank
	@Column(name = "ID_PERSONA", nullable = false)
	private String idPersona;

	@NotBlank
	@Column(name = "OR_PERSONA", nullable = false)
	private String orPersona;

	@NotBlank
	@Column(name = "ID_PERSONA_LOCAL", nullable = false)
	private String idPersonaLocal;

	@NotBlank
	@Column(name = "CCL_ID_COD_ORIGEN", nullable = false)
	private String idLocalizacion;

	@NotBlank
	@Column(name = "STD_ID_WORK_LOCAT", nullable = false)
	private String idLocalizacionMeta4;
	
    @NotBlank
    @Column(name = "ID_ORIGEN", nullable = false)
    private String idOrigen;
    
    @NotBlank
    @Column(name = "ID_SECCION", nullable = false)
    private String idSeccion;

	@NotNull
	@Column(name = "FECHA_INICIO", nullable = false)
	private Date fechaInicio;

	@NotNull
	@Column(name = "FECHA_FIN", nullable = false)
	private Date fechaFin;
	
    @NotNull
    @Column(name = "FECHA_INICIO_SECCION", nullable = false)
    private Date fechaInicioSeccion;

    @NotNull
    @Column(name = "FECHA_FIN_SECCION", nullable = false)
    private Date fechaFinSeccion;
	     
	 
    @NotBlank
    @Column(name = "ID_EMPRESA", nullable = false)
    private String idEmpresa;

}