package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

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

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPresupuesto;

import lombok.Data;

@Entity
@Table(name = "TAREA_LOCALIZACION_PRESUPUESTO_VENTA")
@Data
public class TareaLocalizacionPresupuestoVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_LOCALIZACION_PRESUPUESTO_VENTA")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;

    @NotBlank
    @Column(name = "STD_ID_WORK_LOCAT", nullable = false, length = 48)
    private String stdIdWorkLocat;

    @NotBlank
    @Column(name = "CCL_ID_COD_ORIGEN", nullable = false, length = 48)
    private String cclIdCodOrigen;

    @NotBlank
    @Column(name = "CCL_ID_SECCION", nullable = false, length = 48)
    private String cclIdSeccion;
    
    @NotNull
    @Column(name = "ICM_ORDINAL", nullable = false)
    private Integer ordinal;

    @NotNull
    @Column(name = "IMPORTE_SIN_IMPUESTOS", nullable = false)
    private Double importeSinImpuestos;

    @NotNull
    @Column(name = "IMPORTE_CON_IMPUESTOS", nullable = false)
    private Double importeConImpuestos;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_PRESUPUESTO", nullable = false)
    private TipoPresupuesto tipoPresupuesto;

    @NotBlank
    @Column(name = "ICM_ID_CONCEPTO_VENTA", nullable = false)
    private String icmIdConceptoVenta;
    
    @NotBlank
    @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
    private String cclIdOrigen;
    
    @NotNull
    @Column(name = "ES_ACTIVO", nullable = false)
    private Boolean activo;
    
}
