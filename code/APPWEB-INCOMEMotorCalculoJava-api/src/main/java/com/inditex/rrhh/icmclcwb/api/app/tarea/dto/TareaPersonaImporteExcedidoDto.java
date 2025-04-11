package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import java.io.Serial;
import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TareaPersonaImporteExcedidoDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long cclIdPerson;
}
