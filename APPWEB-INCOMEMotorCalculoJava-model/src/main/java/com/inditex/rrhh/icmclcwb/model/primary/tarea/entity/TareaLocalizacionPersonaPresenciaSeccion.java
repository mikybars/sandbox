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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_PERSONA_PRESENCIA_SECCION")
@Data
public class TareaLocalizacionPersonaPresenciaSeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_LOCALIZACION_PERSONA_PRESENCIA_SECCION")
    private /* BigInteger */ Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;
    
    @NotBlank
    @Column(name = "ID_LOCALIZACION", nullable = false)
    private String idLocalizacion;

    @NotBlank
    @Column(name = "ID_PERSONA", nullable = false)
    private String idPersona;
    
    @NotBlank
    @Column(name = "ID_ORIGEN", nullable = false)
    private String idOrigen;
    
    @NotBlank
    @Column(name = "ID_EMPRESA", nullable = false)
    private String idEmpresa;
    
    @NotNull
    @Column(name = "FECHA", nullable = false)
    private Date fecha;
    
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
    @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
    private TipoDato tipoDato;
    
    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;
}
