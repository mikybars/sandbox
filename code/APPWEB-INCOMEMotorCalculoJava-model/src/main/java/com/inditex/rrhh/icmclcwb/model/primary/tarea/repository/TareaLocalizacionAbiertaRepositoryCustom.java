package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionAbiertaRepositoryCustom {

  void saveAbierto(@NonNull final TareaDto tareaDto, @NonNull final TrabajoDTO trabajoDto);

  void saveCerrado(@NonNull final TareaDto tareaDto, @NonNull final TrabajoDTO trabajoDto,
      @NonNull List<Integer> idTipoImporteVenta);

  void trasladar(@NonNull final TareaDto tareaDto, @NonNull List<Integer> idTipoImporteVenta);

  void compensar(@NonNull final TareaDto tareaDto, @NonNull List<Integer> idTipoImporteVenta);

  void saveAbiertoSeccion(@NonNull final TareaDto tareaDto, final TrabajoDTO trabajoDto);

  void saveCerradoSeccion(@NonNull final TareaDto tareaDto, final TrabajoDTO trabajoDto,
      @NonNull List<Integer> idTipoImporteVenta);

  void compensarOnlineSeccionCerrada(@NonNull final TareaDto tareaDto, @NonNull final TrabajoDTO trabajoDto);

  void updateActivoTrasladadasSeccion(@NonNull final TareaDto tarea, @NonNull final TrabajoDTO trabajoDto);

  void agruparOnlineSeccionDia(@NonNull final TareaDto tarea, @NonNull final TrabajoDTO trabajoDto);

  void updateActivoTrasladadasTotalizado(@NonNull final TareaDto tarea, @NonNull final TrabajoDTO trabajoDto);

}
