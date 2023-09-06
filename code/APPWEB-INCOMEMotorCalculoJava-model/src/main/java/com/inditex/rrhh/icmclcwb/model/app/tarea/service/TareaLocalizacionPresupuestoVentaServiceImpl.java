package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoVentaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoVentaRepositoryCustom;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionPresupuestoVentaServiceImpl implements TareaLocalizacionPresupuestoVentaService {

  @Autowired
  private TareaLocalizacionPresupuestoVentaRepositoryCustom tareaLocalizacionPresupuestoVentaRepositoryCustom;

  @Autowired
  private TareaLocalizacionPresupuestoVentaMapper tareaLocalizacionPresupuestoVentaMapper;

  @Override
  public List<TareaLocalizacionPresupuestoVentaDto> save(
      @Valid @NotNull @NotEmpty final List<TareaLocalizacionPresupuestoVentaDto> tareaLocalizacionPresupuestoVenta) {
    return this.tareaLocalizacionPresupuestoVentaMapper
        .tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
            this.tareaLocalizacionPresupuestoVentaRepositoryCustom
                .save(this.tareaLocalizacionPresupuestoVentaMapper
                    .tareaLocalizacionPresupuestoVentaDtoToTareaLocalizacionPresupuestoVenta(
                        tareaLocalizacionPresupuestoVenta)));
  }

  @Override
  public List<TareaLocalizacionPresupuestoVentaDto> save(
      @Valid @NotNull @NotEmpty final List<VentaCongeladaResultItemDto> ventaCongelada,
      @Valid @NotNull final TareaDto tarea) {
    return this.tareaLocalizacionPresupuestoVentaMapper
        .tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
            this.tareaLocalizacionPresupuestoVentaRepositoryCustom
                .save(this.tareaLocalizacionPresupuestoVentaMapper
                    .ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVenta(ventaCongelada, tarea)));
  }

  @Override
  public List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaTotalizadoResponse(
      @Valid @NotNull final PtrVentaTotalizadoResponseDto dto,
      @Valid @NotNull final IdLocalizacionLocalPresupuestoDto iter,
      @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
      result.addAll(this.tareaLocalizacionPresupuestoVentaMapper
          .tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
              this.tareaLocalizacionPresupuestoVentaRepositoryCustom
                  .save(this.tareaLocalizacionPresupuestoVentaMapper
                      .ventaTotalizadoResponseItemDtoToTareaLocalizacionPresupuestoVenta(
                          dto.getVentaTotalizado(),
                          iter, tarea))));
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineIpodResponse(
      @Valid @NotNull final PtrVentaOnlineIpodResponseDto dto,
      @Valid @NotNull final IdLocalizacionLocalPresupuestoDto iter,
      @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
      result.addAll(this.tareaLocalizacionPresupuestoVentaMapper
          .tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
              this.tareaLocalizacionPresupuestoVentaRepositoryCustom
                  .save(this.tareaLocalizacionPresupuestoVentaMapper
                      .ventaOnlineIpodResponseItemDtoToTareaLocalizacionPresupuestoVenta(dto.getVentaOnline(),
                          iter, tarea))));
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlinePickingResponse(
      @Valid @NotNull final PtrVentaOnlinePickingResponseDto dto,
      @Valid @NotNull final IdLocalizacionLocalPresupuestoDto iter,
      @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
      result.addAll(this.tareaLocalizacionPresupuestoVentaMapper
          .tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
              this.tareaLocalizacionPresupuestoVentaRepositoryCustom
                  .save(this.tareaLocalizacionPresupuestoVentaMapper
                      .ventaOnlinePickingResponseItemDtoToTareaLocalizacionPresupuestoVenta(
                          dto.getVentaOnline(),
                          iter, tarea))));
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineEntregaTiendaResponse(
      @Valid @NotNull final PtrVentaOnlineEntregaTiendaResponseDto dto,
      @Valid @NotNull final IdLocalizacionLocalPresupuestoDto iter,
      @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
      result.addAll(this.tareaLocalizacionPresupuestoVentaMapper
          .tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
              this.tareaLocalizacionPresupuestoVentaRepositoryCustom
                  .save(this.tareaLocalizacionPresupuestoVentaMapper
                      .ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionPresupuestoVenta(
                          dto.getVentaOnline(), iter, tarea))));
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionPresupuestoVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
      @Valid @NotNull final PtrVentaOnlineEntregaDomicilioResponseDto dto,
      @Valid @NotNull final IdLocalizacionLocalPresupuestoDto iter,
      @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionPresupuestoVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
      result.addAll(this.tareaLocalizacionPresupuestoVentaMapper
          .tareaLocalizacionPresupuestoVentaToTareaLocalizacionPresupuestoVentaDto(
              this.tareaLocalizacionPresupuestoVentaRepositoryCustom
                  .save(this.tareaLocalizacionPresupuestoVentaMapper
                      .ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVenta(
                          dto.getVentaOnline(), iter, tarea))));
    }
    return result;
  }

}
