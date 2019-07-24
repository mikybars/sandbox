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
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @NotNull
    @Column(name = "CCL_ID_CADENA", nullable = false, length = 48)
    private String idCadena;

    @NotNull
    @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
    private String idLocalizacion;

    @NotNull
    @Column(name = "CCL_ID_SECCION", nullable = false, length = 4)
    private String idSeccion;

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
