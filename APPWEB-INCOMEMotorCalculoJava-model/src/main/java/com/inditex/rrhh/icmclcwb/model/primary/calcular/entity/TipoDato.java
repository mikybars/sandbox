package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TIPO_DATO")
@Data
public class TipoDato {

    @Id
    @Column(name = "ID_TIPO_DATO")
    private /* BigInteger */ Long id;

    @NotBlank
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @NotBlank
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @NotBlank
    @Column(name = "PROCESADO", nullable = false)
    private Boolean procesado;

    @OneToOne
    @JoinColumn(name = "ID_TIPO_PRESENCIA", nullable = true)
    private /* BigInteger */ TipoPresencia tipoPresencia;

    @OneToOne
    @JoinColumn(name = "ID_TIPO_VENTA", nullable = true)
    private /* BigInteger */ TipoPresencia tipoVenta;

}
