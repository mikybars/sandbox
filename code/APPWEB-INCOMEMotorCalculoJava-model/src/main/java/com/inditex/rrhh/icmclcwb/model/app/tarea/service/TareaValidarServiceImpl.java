package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.exception.ReflectionIcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaValidarRepositoryCustom;

import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaValidarServiceImpl implements TareaValidarService {

  @Autowired
  private TareaValidarRepositoryCustom tareaValidarRepositoryCustom;

  @Autowired
  private TareaService tareaService;

  @Override
  public List<String> checkDuplicatedTiendasHistorico(@NotNull @Positive final Long idTarea) {
    return this.tareaValidarRepositoryCustom.checkDuplicatedTiendasHistorico(idTarea);
  }

  @Override
  public List<String> checkDuplicatedTiposHora(@NotNull @Positive final Long idTarea) {
    return this.tareaValidarRepositoryCustom.checkDuplicatedTiposHora(idTarea);
  }

  @Override
  public Integer countEmpleadosHistorico(@NotNull @Positive final Long idTarea) {
    return this.tareaValidarRepositoryCustom.countEmpleadosHistorico(idTarea);
  }

  @Override
  public Integer countTiendasHistorico(@NotNull @Positive final Long idTarea) {
    return this.tareaValidarRepositoryCustom.countTiendasHistorico(idTarea);
  }

  @Override
  public Integer countEstructuras(@NotNull @Positive final Long idTarea) {
    return this.tareaValidarRepositoryCustom.countEstructuras(idTarea);
  }

  @Override
  public Integer countTiendaPresenciaSeccion(@NotNull @Positive final Long idTarea) {
    return this.tareaValidarRepositoryCustom.countTiendaPresenciaSeccion(idTarea);
  }

  @Override
  public Integer countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive final Long idTarea) {
    return this.tareaValidarRepositoryCustom.countTiendaEmpleadoPresenciaSeccion(idTarea);
  }

  @Override
  public Integer countTiendaVentaSeccion(@NotNull @Positive final Long idTarea) {
    return this.tareaValidarRepositoryCustom.countTiendaVentaSeccion(idTarea);
  }

  @Override
  public List<String> validateAmbito(@NotNull @Positive final Long idTarea) {
    final TareaDto tareaDto = this.tareaService.find(idTarea);
    if (CollectionUtils.isNotEmpty(tareaDto.getLocalizacion())) {
      return this.tareaValidarRepositoryCustom.validateAmbitoLocalizacion(idTarea);
    } else if (CollectionUtils.isNotEmpty(tareaDto.getPersona())) {
      return this.tareaValidarRepositoryCustom.validateAmbitoPersona(idTarea);
    }
    return this.tareaValidarRepositoryCustom.validateAmbitoEmpresa(idTarea);
  }

  @Override
  public List<Map<String, Object>> validateByIdTrabajo(@NotNull @Positive final Long idTrabajo) {
    final List<TareaDto> tareaDto = this.tareaService.findByTrabajoId(idTrabajo);
    return tareaDto.stream().map(TareaDto::getId).map(this::validateByIdTarea).collect(Collectors.toList());
  }

  @Override
  public Map<String, Object> validateByIdTarea(@NotNull @Positive final Long idTarea) {
    try {
      final Map<String, Object> objects = new HashMap<>();
      final Method[] methods = TareaValidarRepositoryCustom.class.getMethods();
      for (final Method method : methods) {
        objects.put(method.getName(), method.invoke(this.tareaValidarRepositoryCustom, idTarea));
      }
      return objects;
    } catch (final IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      throw new ReflectionIcmclcwbException(e.getMessage(), e);
    } catch (final Exception e) {
      throw e;
    }
  }

}
