package com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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

    private static final long serialVersionUID = -2999803240189313755L;

    @NotNull
    private TrabajoDto trabajo;

    private List<TareaDto> tarea;

}
