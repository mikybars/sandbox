package com.inditex.rrhh.icmclcwb.model.primary.calcular.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "TIPO_GRUPO_DATO")
@Data
public class TipoGrupoDato {

    @Id
    @Column(name = "ID_TIPO_GRUPO_DATO")
    private /* BigInteger */ Long id;

    @NotBlank
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @NotBlank
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TIPO_GRUPO_DATO_TIPO_DATO", joinColumns = {
            @JoinColumn(name = "ID_TIPO_GRUPO_DATO") }, inverseJoinColumns = { @JoinColumn(name = "ID_TIPO_DATO") })
    private Set<TipoDato> tipoDato;

}
