package com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunProcesoDto implements Serializable {

    private static final long serialVersionUID = 8443425889094187729L;

    @NotNull
    private ProcesoDto proceso;

    private final RunProcesoRecolectarDto runProcesoRecolectar = new RunProcesoRecolectarDto();

    private final RunProcesoCalcularDto runProcesoCalcular = new RunProcesoCalcularDto();

}
