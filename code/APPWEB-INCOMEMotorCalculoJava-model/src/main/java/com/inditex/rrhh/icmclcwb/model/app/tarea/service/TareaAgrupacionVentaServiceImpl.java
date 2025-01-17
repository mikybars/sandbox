package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionVentaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAgrupacionVentaServiceImpl implements TareaAgrupacionVentaService {

  @Autowired
  private TareaAgrupacionVentaRepositoryCustom tareaAgrupacionVentaRepositoryCustom;

  @Autowired
  private TareaAgrupacionVentaMapper tareaAgrupacionVentaMapper;

  @Override
  public void savePtrVentaTotalizadoResponse(@Valid @NotNull final PtrVentaTotalizadoResponseDto dto,
      @Valid @NotNull final TareaDto tarea,
      @Valid @NotNull final List<TareaAgrupacionCadenasDto> agrupaciones) {
    this.tareaAgrupacionVentaRepositoryCustom.save(
        this.tareaAgrupacionVentaMapper.ventaTotalizadoResponseItemDtoToTareaAgrupacionVenta(
            dto.getVentaTotalizado(), tarea, agrupaciones));
  }

  @Override
  public void savePtrVentaOnlineEntregaDomicilioResponse(
      @Valid @NotNull final PtrVentaOnlineEntregaDomicilioResponseDto dto,
      @Valid @NotNull final TareaDto tarea, @Valid @NotNull final List<TareaAgrupacionCadenasDto> agrupaciones) {
    this.tareaAgrupacionVentaRepositoryCustom.save(
        this.tareaAgrupacionVentaMapper.ventaOnlineEntregaDomicilioResultItemDtoToTareaAgrupacionVenta(
            dto.getVentaOnline(), tarea, agrupaciones));
  }

  @Override
  public void updateActivoVentaOnlineEntregaDomicilio(@Valid @NotNull final TareaDto tarea) {
    this.tareaAgrupacionVentaRepositoryCustom.updateActivo(tarea);
  }

}
