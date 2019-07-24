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

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.Algoritmo;

import lombok.Data;

@Entity
@Table(name = "TAREA_CALCULO")
@Data
public class TareaCalculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_CALCULO")
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
    @OneToOne
    @JoinColumn(name = "ID_ALGORITMO", nullable = false)
    private Algoritmo algoritmo;

    @NotNull
    @Column(name = "IMPORTE_SIN_IMPUESTOS", nullable = false, length = 23, precision = 8)
    private Double importeSinImpuestos;

    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false, length = 23, precision = 8)
    private Double importeConImpuestos;

    @NotBlank
    @Column(name = "STR_ID_WORK_LOCAT", nullable = false, length = 48)
    private String idLocalizacion;
    
    @NotBlank
    @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
    private String idPersona;

    @NotBlank
    @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
    private String orPersona;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA_PERSONA_ESTRUCTURA", nullable = false)
    private TareaPersonaEstructura personaEstructura;

    @OneToOne
    @JoinColumn(name = "ID_TAREA_LOCALIZACION_PRESENCIA", nullable = true)
    private TareaLocalizacionPresencia localizacionPresencia;

    @OneToOne
    @JoinColumn(name = "ID_TAREA_LOCALIZACION_PERSONA_PRESENCIA", nullable = true)
    private TareaLocalizacionPersonaPresencia localizacionPersonaPresencia;

    @OneToOne
    @JoinColumn(name = "ID_TAREA_LOCALIZACION_VENTA", nullable = true)
    private TareaLocalizacionVenta localizacionVenta;

    @OneToOne
    @JoinColumn(name = "ID_TAREA_LOCALIZACION_PERSONA_VENTA", nullable = true)
    private TareaLocalizacionPersonaVenta localizacionPersonaVenta;

}
