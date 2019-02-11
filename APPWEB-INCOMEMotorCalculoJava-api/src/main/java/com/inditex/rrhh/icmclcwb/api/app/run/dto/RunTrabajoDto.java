package com.inditex.rrhh.icmclcwb.api.app.run.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunTrabajoDto implements Serializable {

    private static final long serialVersionUID = 8443425889094187729L;

    @NotNull
    private TrabajoDto trabajoDto;

    private final RunTrabajoRecolectarDto runTrabajoRecolectar = new RunTrabajoRecolectarDto();

    private final RunTrabajoCalcularDto runTrabajoCalcular = new RunTrabajoCalcularDto();

}
