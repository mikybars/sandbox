package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TIPO_PRESENCIA_CONCEPTO")
@Data
public class TipoPresenciaConcepto {

    @Id
    @Column(name = "ID_TIPO_PRESENCIA_CONCEPTO")
    private Long id;

    @NotBlank
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @NotBlank
    @Column(name = "CODIGO")
    private String codigo;

    @OneToOne
    @JoinColumn(name = "ID_TIPO_PRESENCIA", nullable = false)
    private TipoPresencia tipoVenta;

}
