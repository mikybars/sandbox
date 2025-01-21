package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "MAIL_ENTORNO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MailEntorno {

  @Id
  @NotBlank
  @Column(name = "ENTORNO", nullable = false)
  private String entorno;

  @NotNull
  @Column(name = "ES_ACTIVO", nullable = false)
  private Boolean esActivo;
}
