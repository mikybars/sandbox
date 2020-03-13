package com.inditex.rrhh.icmclcwb.api.app.tarea.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TareaLocalizacionPresupuestoListDto {

    @NotNull
    @ApiModelProperty(value = "Presupuestos", required = true)
    private List<TareaLocalizacionPresupuestoDto> presupuestos;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private LocalDate minFechaInicio;

    public LocalDate getMinFechaInicioPeriodo() {
        if (minFechaInicio == null) {
            LocalDate minDate = LocalDate.now();
            if (presupuestos != null) {
                Optional<TareaLocalizacionPresupuestoDto> optional = presupuestos.stream().min(Comparator.comparing(TareaLocalizacionPresupuestoDto::getFechaInicio));
                if (optional.isPresent()) {
                    minDate = minDate.isBefore(optional.get().getFechaInicio()) ? minDate : optional.get().getFechaInicio();
                }
                minFechaInicio = minDate;
            }
        }
        return minFechaInicio;
    }

    public boolean esAmbitoAmpliado(TareaDto tarea) {
        LocalDate minDate = getMinFechaInicioPeriodo();
        return minDate != null && minDate.isBefore(tarea.getFechaInicioPeriodo());
    }

}
