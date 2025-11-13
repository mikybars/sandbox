package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPresenciasSinVentasService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaCalculoPresenciasSinVentasServiceImpl implements TareaCalculoPresenciasSinVentasService {

  @Autowired
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @Override
  public List<IdLocalizacionLocalDto> findTiendaPresenciasSinVentas(Long idTarea) {
    return this.tareaCalculoRepositoryCustom.findTiendaPresenciasSinVentas(idTarea);
  }
}
