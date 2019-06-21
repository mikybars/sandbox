package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TareaAgrupacionConfiguracionDto implements Serializable {

    private static final long serialVersionUID = -8470928612425957019L;

    private Long id;
    private Long idTarea;
    private Long idAgrupacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String idOrigen;
    private Double porcentajeInclusion;

    private TipoVentaEnum tipoConceptoVenta;

}
