package com.inditex.rrhh.icmclcwb.model.primary.proceso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "PROCESO_AMBITO_EMPRESA")
@Data
public class ProcesoAmbitoEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROCESO_AMBITO_EMPRESA")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_PROCESO", nullable = false)
    private Proceso proceso;

    @NotNull
    @Column(name = "CCL_ID_ORIGEN", nullable = false, length = 48)
    private String cclIdOrigen;

    @NotNull
    @Column(name = "STD_ID_LEG_ENT", nullable = false, length = 48)
    private String stdIdLegEnt;

}
