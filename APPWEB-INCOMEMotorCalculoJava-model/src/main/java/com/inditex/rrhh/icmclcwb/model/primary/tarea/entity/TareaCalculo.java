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

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.Algoritmo;

import lombok.Data;

@Entity
@Table(name = "TAREA_CALCULO")
@Data
public class TareaCalculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_CALCULO")
    private /* BigInteger */ Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private /* BigInteger */ Tarea tarea;

    @NotNull
    @Column(name = "FECHA", nullable = false)
    private Date fecha;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_ALGORITMO", nullable = false)
    private /* BigInteger */ Algoritmo algoritmo;

    @NotNull
    @Column(name = "IMPORTE_SIN_IMPUESTOS", nullable = false)
    private /* BigInteger */ Double importeSinImpuestos;

    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false)
    private /* BigInteger */ Double importeConImpuestos;

    @NotBlank
    @Column(name = "ID_LOCALIZACION", nullable = false)
    private String idLocalizacion;
    
    @NotBlank
    @Column(name = "ID_PERSONA", nullable = false)
    private String idPersona;

    @NotBlank
    @Column(name = "OR_PERSONA", nullable = false)
    private String orPersona;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA_PERSONA_ESTRUCTURA", nullable = false)
    private /* BigInteger */ TareaPersonaEstructura personaEstructura;

    @OneToOne
    @JoinColumn(name = "ID_TAREA_LOCALIZACION_PRESENCIA", nullable = true)
    private /* BigInteger */ TareaLocalizacionPresencia localizacionPresencia;

    @OneToOne
    @JoinColumn(name = "ID_TAREA_LOCALIZACION_PERSONA_PRESENCIA", nullable = true)
    private /* BigInteger */ TareaLocalizacionPersonaPresencia localizacionPersonaPresencia;

    @OneToOne
    @JoinColumn(name = "ID_TAREA_LOCALIZACION_VENTA", nullable = true)
    private /* BigInteger */ TareaLocalizacionVenta localizacionVenta;

    @OneToOne
    @JoinColumn(name = "ID_TAREA_LOCALIZACION_PERSONA_VENTA", nullable = true)
    private /* BigInteger */ TareaLocalizacionPersonaVenta localizacionPersonaVenta;

}
