package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TrabajoRunDatosAuditoriaDto")
@Data
public class TrabajoRunDatosAuditoriaDto implements Serializable {

    private static final long serialVersionUID = -8465432514188281598L;

    private int tiposHora;

    private int tiendasParametro;

    private int tiendasHistorico;

    private int tiendasPresencia;

    private int tiendasVentaTotalizada;

    private int tiendasPresenciaTotalizada;

    private int empleados;

    private int empleadosVentaDetalle;

    private int empleadosPresenciaDetalle;

    private int empleadosCondiciones;

}
