package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jspecify.annotations.NonNull;

@Entity
@Table(name = "REGLA_EMPLEADO_EXTERNO_META4")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReglaEmpleadoExternoMeta4 {

  @EmbeddedId
  private ReglaEmpleadoExternoMeta4Pk pk;

  @NotBlank
  @Column(name = "ID_ORGANIZATION", nullable = false)
  private String idOrganization;

  @NonNull
  @Column(name = "ES_ACTIVO")
  private Boolean esActivo;

}
