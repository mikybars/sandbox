package com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RunTareaPrevalidarDto implements Serializable {

    private static final long serialVersionUID = -2999803240189313755L;

    @NotNull
    private TareaPrevalidacionDto tareaPrevalidacionDto;

    @NotNull
    private TareaDto tarea;

}
