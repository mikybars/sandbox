package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "TIPO_VENTA")
@Data
public class TipoVenta {

    @Id
    @Column(name = "ID_TIPO_VENTA")
    private /* BigInteger */ Long id;

    @NotBlank
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @NotBlank
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @NotBlank
    @Column(name = "CODIGO", nullable = false)
    private String codigo;

    @NotNull
    @Column(name = "PESO", nullable = false)
    private /* BigInteger */ Long peso;
    
    @NotNull
    @Column(name = "ONLINE", nullable = false)
    private Boolean online;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tiposVentaOnlineEntregaDomicilio")
    private Set<TipoDato> tiposDatoVentaEntregaDomicilio;

}
