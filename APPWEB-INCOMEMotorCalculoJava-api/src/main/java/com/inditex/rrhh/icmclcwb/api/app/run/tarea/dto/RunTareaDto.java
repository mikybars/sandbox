package com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunTareaDto implements Serializable {

    private static final long serialVersionUID = 8443425889094187729L;

    @NotNull
    private TareaDto tarea;

    private final RunTareaRecolectarDto runTareaRecolectar = new RunTareaRecolectarDto();

    private final RunTareaCalcularDto runTareaCalcular = new RunTareaCalcularDto();

}
