package com.inditex.rrhh.icmclcwb.api.app.run.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo RunTrabajoCalcularDto")
@Data
public class RunTrabajoCalcularDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

    private Set<Long> tiposCalculo = new HashSet<>();

    private Set<Long> idsEmpleados = new HashSet<>();

}
