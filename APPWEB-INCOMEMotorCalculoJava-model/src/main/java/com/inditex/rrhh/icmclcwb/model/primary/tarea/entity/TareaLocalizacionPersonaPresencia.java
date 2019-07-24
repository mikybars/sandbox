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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_PERSONA_PRESENCIA")
@Data
public class TareaLocalizacionPersonaPresencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_LOCALIZACION_PERSONA_PRESENCIA")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;
    
    @NotBlank
    @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
    private String idLocalizacion;

    @NotBlank
    @Column(name = "CCL_ID_CADENA", nullable = false, length = 48)
    private String idCadena;

    @NotBlank
    @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
    private String idPersona;
    
    @NotBlank
    @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
    private String idOrigen;
    
    @NotBlank
    @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
    private String idEmpresa;
    
    @NotBlank
    @Column(name = "CCL_ID_SECCION", nullable = false, length = 4)
    private String idSeccion;
    
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @NotNull
    @Column(name = "MINUTOS", nullable = false)
    private Integer minutos;
    
    @NotNull
    @Column(name = "ICM_ID_TP_HORA", nullable = false, length = 48)
    private String idTipoHora;
    
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
    private TipoDato tipoDato;
    
    @NotNull
    @Column(name = "ES_ACTIVO", nullable = false)
    private Boolean activo;
    
}
