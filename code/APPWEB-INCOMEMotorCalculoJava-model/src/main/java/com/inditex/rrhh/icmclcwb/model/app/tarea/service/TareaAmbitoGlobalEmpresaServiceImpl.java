package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.ID_EMPRESA_BY_TAREA;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalEmpresaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAmbitoGlobalEmpresaServiceImpl implements TareaAmbitoGlobalEmpresaService {

  @Autowired
  private TareaAmbitoGlobalEmpresaRepositoryCustom tareaAmbitoGlobalEmpresaRepositoryCustom;

  @Autowired
  private TareaAmbitoGlobalEmpresaMapper tareaAmbitoGlobalEmpresaMapper;

  @Override
  public void save(@Valid @NonNull @NotEmpty final List<TareaAmbitoGlobalEmpresaDto> src,
      @Valid @NonNull final TareaDto tarea) {
    this.tareaAmbitoGlobalEmpresaRepositoryCustom.save(
        this.tareaAmbitoGlobalEmpresaMapper
            .tareaAmbitoGlobalEmpresaDtoToTareaAmbitoGlobalEmpresa(src));
  }

  @Override
  @Cacheable(value = ID_EMPRESA_BY_TAREA, key = "{#idTarea}")
  public List<IdEmpresaDto> findIdEmpresaByIdTarea(
      @Valid @NonNull final Long idTarea) {
    return this.tareaAmbitoGlobalEmpresaRepositoryCustom.findIdEmpresaByIdTarea(idTarea);
  }

}
