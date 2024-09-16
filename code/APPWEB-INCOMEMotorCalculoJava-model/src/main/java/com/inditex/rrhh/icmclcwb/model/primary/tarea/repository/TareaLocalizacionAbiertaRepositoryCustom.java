package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.constraints.NotNull;

public interface TareaLocalizacionAbiertaRepositoryCustom {

  void saveAbierto(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDTO trabajoDto);

  void saveCerrado(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDTO trabajoDto,
      @NotNull List<Integer> idTipoImporteVenta);

  void trasladar(@NotNull final TareaDto tareaDto, @NotNull List<Integer> idTipoImporteVenta);

  void compensar(@NotNull final TareaDto tareaDto, @NotNull List<Integer> idTipoImporteVenta);

  void saveAbiertoSeccion(@NotNull final TareaDto tareaDto, final TrabajoDTO trabajoDto);

  void saveCerradoSeccion(@NotNull final TareaDto tareaDto, final TrabajoDTO trabajoDto,
      @NotNull List<Integer> idTipoImporteVenta);

  void compensarOnlineSeccionCerrada(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDTO trabajoDto);

  void updateActivoTrasladadasSeccion(@NotNull final TareaDto tarea, @NotNull final TrabajoDTO trabajoDto);

  void agruparOnlineSeccionDia(@NotNull final TareaDto tarea, @NotNull final TrabajoDTO trabajoDto);

  void updateActivoTrasladadasTotalizado(@NotNull final TareaDto tarea, @NotNull final TrabajoDTO trabajoDto);

}
