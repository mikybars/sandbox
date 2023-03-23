package com.inditex.rrhh.icmclcwb.model.primary.tarea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
