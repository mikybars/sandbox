package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraPoliticaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraPoliticaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraPoliticaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaPersonaEstructuraPoliticaServiceImpl implements TareaPersonaEstructuraPoliticaService {

  @Autowired
  private TareaPersonaEstructuraPoliticaRepositoryCustom tareaPersonaEstructuraPoliticaRepositoryCustom;

  @Autowired
  private TareaPersonaEstructuraPoliticaMapper tareaPersonaEstructuraPoliticaMapper;

  @Override
  public List<TareaPersonaEstructuraPoliticaDto> save(
      @Valid @NotNull @NotEmpty final List<ComisionEmpleadoResultItemDto> tareaEmpleadoEstructuraPolitica,
      @Valid @NotNull final TareaDto tarea) {
    return this.tareaPersonaEstructuraPoliticaMapper
        .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
            this.tareaPersonaEstructuraPoliticaRepositoryCustom.save(this.tareaPersonaEstructuraPoliticaMapper
                .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(tareaEmpleadoEstructuraPolitica,
                    tarea)));
  }

  @Override
  public List<TareaPersonaEstructuraPoliticaDto> saveEstructurasPolResultItemDto(
      @Valid @NotNull @NotEmpty final List<EstructurasPolResultItemDto> estructurasPolResultItemDto,
      @Valid @NotNull final TareaDto tarea) {
    return this.tareaPersonaEstructuraPoliticaMapper
        .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
            this.tareaPersonaEstructuraPoliticaRepositoryCustom.save(this.tareaPersonaEstructuraPoliticaMapper
                .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(estructurasPolResultItemDto,
                    tarea)));
  }

  @Override
  public Boolean existePolitica(
      @Valid @NotNull final TareaDto tarea, @Valid @NotNull @NotEmpty final List<TipoPoliticaEnum> politicas) {
    return this.tareaPersonaEstructuraPoliticaRepositoryCustom.existePolitica(tarea, politicas);
  }

}
