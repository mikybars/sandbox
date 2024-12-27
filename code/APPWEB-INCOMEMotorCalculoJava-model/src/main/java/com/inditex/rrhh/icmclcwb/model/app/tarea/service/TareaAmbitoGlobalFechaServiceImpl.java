package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.FECHA_AMBITO_BY_TAREA_AND_ID_TIPO_DATO;

import java.util.Collections;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalFechaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalFechaRepositoryCustom;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAmbitoGlobalFechaServiceImpl implements TareaAmbitoGlobalFechaService {

  @Autowired
  private TareaAmbitoGlobalFechaRepositoryCustom tareaAmbitoGlobalFechaRepositoryCustom;

  @Autowired
  private TareaAmbitoGlobalFechaMapper tareaAmbitoGlobalFechaMapper;

  @Override
  public void save(@Valid @NonNull final TareaAmbitoGlobalFechaDto src, @Valid @NonNull final TareaDto tarea) {
    this.tareaAmbitoGlobalFechaRepositoryCustom.save(
        this.tareaAmbitoGlobalFechaMapper.tareaAmbitoGlobalFechaDtoToTareaAmbitoGlobalFecha(Collections.singletonList(src),
            tarea));
  }

  @Override
  @Cacheable(value = FECHA_AMBITO_BY_TAREA_AND_ID_TIPO_DATO, key = "{#idTarea, #idTipoDato}")
  public PeriodoDto findFechaAmbitoDtoByIdTareaAndIdTipoDato(
      @Valid @NonNull final Long idTarea, @NonNull final Integer idTipoDato) {
    return this.tareaAmbitoGlobalFechaRepositoryCustom.findFechaAmbitoDtoByIdTareaAndIdTipoDato(idTarea,
        idTipoDato);
  }

}
