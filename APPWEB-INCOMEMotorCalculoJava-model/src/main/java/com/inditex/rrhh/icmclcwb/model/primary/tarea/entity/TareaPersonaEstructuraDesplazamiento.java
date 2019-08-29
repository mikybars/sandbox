package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoOpcionCalculo;
import lombok.Data;

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
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "TAREA_PERSONA_ESTRUCTURA_DESPLAZAMIENTO")
@Data
public class TareaPersonaEstructuraDesplazamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA_PERSONA_ESTRUCTURA_DESPLAZAMIENTO")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TAREA", nullable = false)
    private Tarea tarea;

    @NotNull
    @Column(name = "ICM_ID_ESTR_COMISION", nullable = false, length = 48)
    private String icmIdEstrComision;

    @NotNull
    @Column(name = "ORDINAL_ESTRUCTURA", nullable = false)
    private Integer ordinalEstructura;

    @NotNull
    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @NotNull
    @Column(name = "FECHA_FIN", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_OPCION_CALCULO_ESTRUCTURA", nullable = false)
    private TipoOpcionCalculo tipoOpcionCalculoEstructura;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_OPCION_CALCULO_EFECTIVA", nullable = false)
    private TipoOpcionCalculo tipoOpcionCalculoEfectiva;

    @NotNull
    @Column(name = "ICM_ID_TP_CALCULO", nullable = false)
    private String icmIdTpCalculo;

    // TODO DBM ICM_ID_PUESTO_DESTINO -> CCL_ID_PUESTO_DESTINO (STD_JOB.STD_ID_JOB_CODE)
    @NotNull
    @Column(name = "ICM_ID_PUESTO_DESTINO", nullable = false)
    private String cclIdPuestoDestino;

    @NotNull
    @Column(name = "CCL_ID_SECCION_DESTINO", nullable = false)
    private String cclIdSeccionDestino;

    @NotNull
    @Column(name = "CCL_ID_COD_ORIGEN_DESTINO", nullable = false)
    private String cclIdCodOrigenDestino;

    // TODO DBM ICM_ID_WLOC_DESTINO -> STD_ID_WORK_LOCAT_DESTINO (STD_WORK_LOCATION.STD_ID_WORK_LOCAT)
    @NotBlank
    @Column(name = "ICM_ID_WLOC_DESTINO", nullable = false, length = 48)
    private String stdIdWorkLocatDestino;

    @NotNull
    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    @NotNull
    @Column(name = "CCL_ID_SECCION_EFECTIVA", nullable = false)
    private String cclIdSeccionEfectiva;

    @NotNull
    @Column(name = "CCL_ID_SECCION_ESTRUCTURA", nullable = false)
    private String cclIdSeccionEstructura;

    @NotNull
    @Column(name = "ICM_ID_TP_REQ_COMISION")
    private String icmIdTpReqCom;

    @NotNull
    @Column(name = "ES_HORAS_ORIGEN", nullable = false)
    private Boolean horasOrigen;

    @NotNull
    @Column(name = "ES_HORAS_DESTINO", nullable = false)
    private Boolean horasDestino;

}
