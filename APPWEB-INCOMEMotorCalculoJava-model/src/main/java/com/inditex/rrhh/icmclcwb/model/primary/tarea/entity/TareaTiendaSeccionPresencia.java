package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TAREA_TIENDA_SECCION_PRESENCIA")
@Data
public class TareaTiendaSeccionPresencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_TIENDA_SECCION_PRESENCIA")
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
    @Column(name = "ID_SECCION", nullable = false)
    private String idSeccion;

    @NotNull
    @Column(name = "MINUTOS", nullable = false)
    private /* BigInteger */ Long minutos;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DATO", nullable = false)
    private TipoDato tipoDato;

    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;


}
