package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TIPO_VENTA_CONCEPTO")
@Data
public class TipoVentaConcepto {

    @Id
    @Column(name = "ID_TIPO_VENTA_CONCEPTO")
    private Long id;

    @NotBlank
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @NotBlank
    @Column(name = "CODIGO", nullable = false)
    private String codigo;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_TIPO_VENTA", nullable = false)
    private /* BigInteger */ TipoVenta tipoVenta;

}
