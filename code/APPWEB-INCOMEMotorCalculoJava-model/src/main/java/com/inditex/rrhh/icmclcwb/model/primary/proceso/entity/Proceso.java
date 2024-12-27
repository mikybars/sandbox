package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoAmbito;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "PROCESO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proceso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_PROCESO")
  private Long id;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_ESTADO_PROCESO", nullable = false)
  private EstadoProceso estadoProceso;

  @NonNull
  @Column(name = "ID_ORGANIZATION", nullable = false, length = 48)
  private String idOrganization;

  @NonNull
  @Column(name = "ICM_ID_PERIODO", nullable = false)
  private Long icmIdPeriodo;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_AMBITO", nullable = false)
  private TipoAmbito tipoAmbito;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_PROCESO", nullable = false)
  private TipoProceso tipoProceso;

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_TIPO_SISTEMA_DESTINO", nullable = false)
  private TipoSistemaDestino tipoSistemaDestino;

  @NonNull
  @Column(name = "FECHA_HORA_CREACION", nullable = false)
  private LocalDateTime fechaHoraCreacion;

  @Column(name = "FECHA_HORA_INICIO_PROCESO", nullable = true)
  private LocalDateTime fechaHoraInicioProceso;

  @Column(name = "FECHA_HORA_FIN_PROCESO", nullable = true)
  private LocalDateTime fechaHoraFinProceso;

  @NonNull
  @Column(name = "FECHA_INICIO_PERIODO", nullable = false)
  private LocalDate fechaInicioPeriodo;

  @NonNull
  @Column(name = "FECHA_FIN_PERIODO", nullable = false)
  private LocalDate fechaFinPeriodo;

  @NonNull
  @Column(name = "NOMBRE_USUARIO", nullable = false, length = 32)
  private String nombreUsuario;

}
