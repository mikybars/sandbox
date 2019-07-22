package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TAREA_LOCALIZACION_PRESENCIA")
@Data
public class TareaLocalizacionPresencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_LOCALIZACION_PRESENCIA")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;

    @NotNull
    @Column(name = "FECHA", nullable = false)
    private Date fecha;

    @NotNull
    @Column(name = "ID_CADENA", nullable = false)
    private String idCadena;

    @NotNull
    @Column(name = "ID_LOCALIZACION", nullable = false)
    private String idLocalizacion;

    @NotNull
    @Column(name = "ID_SECCION", nullable = false)
    private String idSeccion;

    @NotNull
    @Column(name = "MINUTOS", nullable = false)
    private Long minutos;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
    private TipoDato tipoDato;

    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;


}
