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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	private Long id;

	@NotNull
	@OneToOne
	@JoinColumn(name = "ID_TAREA", nullable = false)
	private Tarea tarea;

	@NotBlank
	@Column(name = "STD_ID_HR", nullable = false)
	private String idPersona;

	@NotBlank
	@Column(name = "STD_OR_HR_PERIOD", nullable = false)
	private String orPersona;

	@NotBlank
	@Column(name = "CCL_ID_PERSON", nullable = false)
	private String idPersonaLocal;

	@NotBlank
	@Column(name = "CCL_ID_COD_ORIGEN", nullable = false)
	private String idLocalizacion;

	@NotBlank
	@Column(name = "STD_ID_WORK_LOCAT", nullable = false)
	private String idLocalizacionMeta4;
	
    @NotBlank
    @Column(name = "CCL_ID_ORIGEN", nullable = false)
    private String idOrigen;
    
    @NotBlank
    @Column(name = "CCL_ID_SECCION", nullable = false)
    private String idSeccion;

	@NotNull
	@Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
	private Date fechaInicio;

	@NotNull
	@Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
	private Date fechaFin;
	
    @NotNull
    @Column(name = "FECHA_INICIO_SECCION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicioSeccion;

    @NotNull
    @Column(name = "FECHA_FIN_SECCION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinSeccion;

    @NotBlank
    @Column(name = "STD_ID_LEG_ENT", nullable = false)
    private String idEmpresa;

}
