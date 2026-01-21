package com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TIPO_VENTA_LOCALIZACION_SIMULACION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoVentaLocalizacionSimulacion {

  @Id
  @Column(name = "ID_TIPO_VENTA_LOCALIZACION_SIMULACION")
  private Long id;

  @NotBlank
  @Column(name = "NOMBRE", length = /* TAMANO_NOMBRE */ 128, nullable = false)
  private String nombre;

  @NotBlank
  @Column(name = "DESCRIPCION", length = /* TAMANO_DESC */ 255, nullable = false)
  private String descripcion;

}
