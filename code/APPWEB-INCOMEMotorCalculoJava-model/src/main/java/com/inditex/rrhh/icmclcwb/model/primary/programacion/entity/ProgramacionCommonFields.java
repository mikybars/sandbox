package com.inditex.rrhh.icmclcwb.model.primary.programacion.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.NonNull;

@EqualsAndHashCode
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramacionCommonFields {

  @NonNull
  @OneToOne
  @JoinColumn(name = "ID_PROGRAMACION_AMBITO", nullable = false)
  private ProgramacionAmbito programacionAmbito;
}
