package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresenciaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionPresenciaServiceImpl implements TareaLocalizacionPresenciaService {

  @Autowired
  private TareaLocalizacionPresenciaRepositoryCustom tareaLocalizacionPresenciaRepositoryCustom;

  @Autowired
  private TareaLocalizacionPresenciaMapper tareaLocalizacionPresenciaMapper;

  @Override
  public void save(@Valid @NotNull @NotEmpty final List<PresenciaManualWlocResultItemDto> src,
      @Valid @NotNull final TareaDto tareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.save(this.tareaLocalizacionPresenciaMapper
        .presenciaManualLocalizacionResultItemDtoToTareaLocalizacionPresencia(src, tareaDto));
  }

  @Override
  public void updateActivoVacio(@Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.updateActivoVacio(runTareaDto);
  }

  @Override
  public void compensar(@Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTareaDto);
  }

  @Override
  public void totalizar(@Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTareaDto);
  }

  @Override
  public void totalizarEcommerce(@Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerce(runTareaDto);
  }

  @Override
  public void totalizarEmpleadosPorVenta(@Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEmpleadosPorVenta(runTareaDto);
  }

  @Override
  public void compensarLocalizacionManual(@Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.compensarLocalizacionManual(runTareaDto);
  }

  @Override
  public void repartirPresenciasSindicalesLocalizacion(
      @Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacion(runTareaDto);
  }

  @Override
  public void repartirPresenciasSindicalesLocalizacionSeccion(
      @Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.repartirPresenciasSindicalesLocalizacionSeccion(runTareaDto);
  }

  @Override
  public void totalizarEcommerceSeccion(
      @Valid @NotNull final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerceSeccion(runTarea);
  }

  @Override
  public void totalizarPresenciasSindicalesLocalizacion(
      @Valid @NotNull final RunTareaDto runTarea) {
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarPresenciasSindicalesLocalizacion(runTarea);
  }

  @Override
  public void totalizarIncluidoChallengePorcentaje(@Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.totalizarIncluidoChallengePorcentaje(runTareaDto);
  }

  @Override
  public void compensarLocalizacionManualIncluidoChallengePorcentaje(@Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.compensarLocalizacionManualIncluidoChallengePorcentaje(runTareaDto);
  }

  @Override
  public void updateSindicalCerrada(@Valid @NotNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPresenciaRepositoryCustom.updateSindicalCerrada(runTareaDto);
  }

}
