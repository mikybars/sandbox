package com.inditex.rrhh.icmclcwb.model.app.simulacion.service;

import java.util.List;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionDto;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.dto.SimulacionLocalizacionBandaExcepcionDto;
import com.inditex.rrhh.icmclcwb.api.app.simulacion.service.SimulacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.model.app.simulacion.mapper.SimulacionLocalizacionBandaExcepcionMapper;
import com.inditex.rrhh.icmclcwb.model.app.simulacion.mapper.SimulacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.Simulacion;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.entity.SimulacionLocalizacionBandaExcepcion;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository.SimulacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository.SimulacionRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.simulacion.repository.SimuladorLocalizacionBandaExcepcionRepository;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class SimulacionServiceImpl implements SimulacionService {

  @Autowired
  private SimulacionRepositoryCustom simulacionRepositoryCustom;

  @Autowired
  private SimulacionRepository simulacionRepository;

  @Autowired
  private SimuladorLocalizacionBandaExcepcionRepository simulacionLocalizacionBandaExcepcionRepository;

  @Autowired
  private SimulacionMapper simulacionMapper;

  @Autowired
  private SimulacionLocalizacionBandaExcepcionMapper simulacionLocalizacionBandaExcepcionMapper;

  @Autowired
  private TareaPersonaEstructuraService tareaPersonaEstructuraService;

  @Override
  public void mergeEmpleadoSimulacion(@NotNull final TareaDto tarea) {
    this.simulacionRepositoryCustom.mergeEmpleadoSimulacion(tarea);
  }

  @Override
  public void mergeEstructurasEmpleadoSimulacion(@NotNull final TareaDto tarea) {
    final List<TareaPersonaEstructuraDto> estructuras = this.simulacionRepositoryCustom.findEstructurasEmpleadoSimulacion(tarea);

    if (estructuras != null && !estructuras.isEmpty()) {
      this.tareaPersonaEstructuraService.saveSimulacion(estructuras, tarea);
    }
  }

  @Override
  public void mergePresenciasEmpleadoSimulacion(@NotNull final TareaDto tarea) {
    this.simulacionRepositoryCustom.mergePresenciasEmpleadoSimulacion(tarea);
  }

  @Override
  public void mergePresenciaEmpleadoUltimoCalculo(@NotNull final TareaDto tarea) {
    this.simulacionRepositoryCustom.mergePresenciaEmpleadoUltimoCalculo(tarea);
  }

  @Override
  public void mergePresenciaTiendaUltimoCalculo(@NotNull final TareaDto tarea) {
    this.simulacionRepositoryCustom.mergePresenciaTiendaUltimoCalculo(tarea);
  }

  @Override
  public void mergeVentaUltimoCalculo(@NotNull final TareaDto tarea) {
    this.simulacionRepositoryCustom.mergeVentaUltimoCalculo(tarea);
  }

  @Override
  public SimulacionDto findbyId(@NotNull final Long id) {
    final Optional<Simulacion> simulacion = this.simulacionRepository.findById(id);

    if (simulacion.isPresent()) {
      // Mapeamos a simulacionDto
      final SimulacionDto simulacionDto = this.simulacionMapper.simulacionToSimulacionDto(simulacion.get());
      // Obtenermos las bandas excepcionadas y si existen las mapeamos a simulacionDto
      final Optional<List<SimulacionLocalizacionBandaExcepcion>> bandaExcepcionSeccion =
          this.simulacionLocalizacionBandaExcepcionRepository.findBySimulacion_Id(id);
      if (bandaExcepcionSeccion.isPresent()) {
        final List<SimulacionLocalizacionBandaExcepcionDto> listBandas =
            this.simulacionLocalizacionBandaExcepcionMapper.simulacionLocalizacionBandaExcepcionToDto(bandaExcepcionSeccion.get());
        simulacionDto.setBandasExcepcionadasSeccion(listBandas);
      }
      return simulacionDto;
    }

    return null;
  }

  @Override
  public void updateBandaExcepcionada(@NotNull final TareaDto tarea, @NotNull final SimulacionDto simulacion) {

    simulacion.getBandasExcepcionadasSeccion().stream().forEach(value -> {
      if (value.getEsExcepcionBanda0()) {
        this.simulacionRepositoryCustom.updateBandaExcepcionada(tarea, 0, value.getCclIdCodOrigen(), value.getCclIdSeccion());
      } else if (value.getEsExcepcionBanda1()) {
        this.simulacionRepositoryCustom.updateBandaExcepcionada(tarea, 1, value.getCclIdCodOrigen(), value.getCclIdSeccion());
      } else if (value.getEsExcepcionBanda2()) {
        this.simulacionRepositoryCustom.updateBandaExcepcionada(tarea, 2, value.getCclIdCodOrigen(), value.getCclIdSeccion());
      }
    });
  }

}
