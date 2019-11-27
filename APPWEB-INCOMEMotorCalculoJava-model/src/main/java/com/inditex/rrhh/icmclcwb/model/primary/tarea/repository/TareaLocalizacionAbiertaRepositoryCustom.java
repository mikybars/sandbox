package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TareaLocalizacionAbiertaRepositoryCustom {

    void saveAbierto(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDto trabajoDto);

    void saveCerrado(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDto trabajoDto, @NotNull List<Integer> idTipoImporteVenta);

    void trasladar(@NotNull final TareaDto tareaDto, @NotNull List<Integer> idTipoImporteVenta);

    void compensar(@NotNull final TareaDto tareaDto, @NotNull List<Integer> idTipoImporteVenta);

    void saveAbiertoSeccion(@NotNull final TareaDto tareaDto, final TrabajoDto trabajoDto);

    void saveCerradoSeccion(@NotNull final TareaDto tareaDto, final TrabajoDto trabajoDto,
            @NotNull List<Integer> idTipoImporteVenta);

    void compensarOnlineSeccionCerrada(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDto trabajoDto);

    void updateActivoTrasladadasSeccion(@NotNull final TareaDto tarea, @NotNull final TrabajoDto trabajoDto);

    void agruparOnlineSeccionDia(@NotNull final TareaDto tarea, @NotNull final TrabajoDto trabajoDto);

    void updateActivoTrasladadasTotalizado(@NotNull final TareaDto tarea, @NotNull final TrabajoDto trabajoDto);

}
