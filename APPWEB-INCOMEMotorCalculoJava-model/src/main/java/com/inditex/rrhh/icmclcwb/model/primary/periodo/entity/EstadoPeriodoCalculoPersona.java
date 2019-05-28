package com.inditex.rrhh.icmclcwb.model.primary.periodo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ESTADO_PERIODO_CALCULO_PERSONA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstadoPeriodoCalculoPersona {

    @Id
    @Column(name = "ID_ESTADO_PERIODO_CALCULO_PERSONA")
    private /* BigInteger */ Long id;

    @NotBlank
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
}
