package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.Algoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoCalculo;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoComision;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "TAREA_CALCULO")
@Data
public class TareaCalculo {

  @EmbeddedId
  private TareaCalculoPk pk;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TAREA", nullable = false)
  private Tarea tarea;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_ALGORITMO", nullable = false)
  private Algoritmo algoritmo;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_CALCULO", nullable = false)
  private TipoCalculo tipoCalculo;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_COMISION", nullable = false)
  private TipoComision tipoComision;

  @NonNull
  @Column(name = "IMPORTE", nullable = false, precision = 23, scale = 8)
  private BigDecimal importe;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT_PAGO", nullable = false, length = 48)
  private String stdIdWorkLocatPago;

  @NotBlank
  @Column(name = "STD_ID_WORK_LOCAT", nullable = false, length = 48)
  private String stdIdWorkLocat;

  @NotBlank
  @Column(name = "CCL_ID_PERSON", nullable = false, length = 48)
  private String cclIdPerson;

  @NotBlank
  @Column(name = "STD_OR_HR_PERIOD", nullable = false, length = 48)
  private String stdOrHrPeriod;

  @NonNull
  @OneToOne
  @JoinColumns({
      @JoinColumn(name = "ID_TAREA_PERSONA_ESTRUCTURA", referencedColumnName = "ID_TAREA_PERSONA_ESTRUCTURA",
          insertable = false, updatable = false),
      @JoinColumn(name = "FECHA_INICIO_PERIODO", referencedColumnName = "FECHA_INICIO_PERIODO",
          insertable = false, updatable = false)})
  private TareaPersonaEstructura personaEstructura;

  @OneToOne
  @JoinColumns({
      @JoinColumn(name = "ID_TAREA_LOCALIZACION_PRESENCIA",
          referencedColumnName = "ID_TAREA_LOCALIZACION_PRESENCIA", insertable = false, updatable = false),
      @JoinColumn(name = "FECHA_INICIO_PERIODO", referencedColumnName = "FECHA_INICIO_PERIODO",
          insertable = false, updatable = false)})
  private TareaLocalizacionPresencia localizacionPresencia;

  @OneToOne
  @JoinColumns({
      @JoinColumn(name = "ID_TAREA_LOCALIZACION_PERSONA_PRESENCIA",
          referencedColumnName = "ID_TAREA_LOCALIZACION_PERSONA_PRESENCIA", insertable = false,
          updatable = false),
      @JoinColumn(name = "FECHA_INICIO_PERIODO", referencedColumnName = "FECHA_INICIO_PERIODO",
          insertable = false, updatable = false)})
  private TareaLocalizacionPersonaPresencia localizacionPersonaPresencia;

  @OneToOne
  @JoinColumns({
      @JoinColumn(name = "ID_TAREA_LOCALIZACION_VENTA", referencedColumnName = "ID_TAREA_LOCALIZACION_VENTA",
          insertable = false, updatable = false),
      @JoinColumn(name = "FECHA_INICIO_PERIODO", referencedColumnName = "FECHA_INICIO_PERIODO",
          insertable = false, updatable = false)})
  private TareaLocalizacionVenta localizacionVenta;

  @OneToOne
  @JoinColumns({
      @JoinColumn(name = "ID_TAREA_LOCALIZACION_PERSONA_VENTA",
          referencedColumnName = "ID_TAREA_LOCALIZACION_PERSONA_VENTA", insertable = false,
          updatable = false),
      @JoinColumn(name = "FECHA_INICIO_PERIODO", referencedColumnName = "FECHA_INICIO_PERIODO",
          insertable = false, updatable = false)})
  private TareaLocalizacionPersonaVenta localizacionPersonaVenta;

  @NonNull
  @Column(name = "FECHA", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @NonNull
  @Column(name = "ES_MANUAL", nullable = false)
  private Boolean manual;

}
