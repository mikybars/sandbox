/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.DocDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HorarioComercialFestivoDocDto extends DocDto implements Serializable {

    private static final long serialVersionUID = 5421128138637048027L;

    private String id;

    private int idTienda;

    private String tienda;

    private int idCadena;

    private String cadena;

    private int idPais;

    private String pais;

    private String fecha;

    private String festivo;

    private String codigo;

}
