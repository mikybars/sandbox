package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;

import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_PRESENCIA")
@Data
public class TareaLocalizacionPresencia {

    @EmbeddedId
    private TareaLocalizacionPresenciaPk pk;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;

    @NotNull
    @Column(name = "CCL_ID_CADENA", nullable = false, length = 48)
    private String cclIdCadena;

    @NotNull
    @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
    private String cclIdCodOrigen;

    @NotNull
    @Column(name = "CCL_ID_SECCION", nullable = false, length = 4)
    private String cclIdSeccion;

    @NotNull
    @Column(name = "MINUTOS", nullable = false)
    private Long minutos;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
    private TipoDato tipoDato;

    @NotNull
    @Column(name = "ES_ACTIVO", nullable = false)
    private Boolean activo;


}
