package com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo RunTareaCalcularDto")
@Data
public class RunTareaCalcularDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

    private Set<Long> tipoCalculo = new HashSet<>();

    private Set<String> empleado = new HashSet<>();

    private Set<AlgoritmoDto> algoritmoCalculoDto = new HashSet<>();

}
