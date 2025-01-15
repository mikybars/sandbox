package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionVentaServiceImpl implements TareaLocalizacionVentaService {

  @Autowired
  private TareaLocalizacionVentaRepositoryCustom tareaLocalizacionVentaRepositoryCustom;

  @Autowired
  private TareaLocalizacionVentaMapper tareaLocalizacionVentaMapper;

  @Autowired
  private TipoDatoService tipoDatoService;

  @Override
  public List<TareaLocalizacionVentaDto> savePtrVentaTotalizadoResponse(
      @Valid @NotNull final PtrVentaTotalizadoResponseDto dto,
      @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
      result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
          this.tareaLocalizacionVentaRepositoryCustom.save(this.tareaLocalizacionVentaMapper
              .ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(dto.getVentaTotalizado(), tarea,
                  TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId(),
                  TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId()))));
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionVentaDto> savePtrVentaTotalizadoResponseRepartoOnline(
      @Valid @NotNull final PtrVentaTotalizadoResponseDto dto, @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
      result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
          this.tareaLocalizacionVentaRepositoryCustom.save(this.tareaLocalizacionVentaMapper
              .ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(dto.getVentaTotalizado(), tarea,
                  TipoDatoEnum.VENTA_FISICA_LOCALIZACION_REPARTO_ONLINE.getId()))));
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionVentaDto> savePtrVentaOnlineIpodResponse(
      @Valid @NotNull final PtrVentaOnlineIpodResponseDto dto,
      @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
      result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
          this.tareaLocalizacionVentaRepositoryCustom.save(this.tareaLocalizacionVentaMapper
              .ventaOnlineIpodResponseItemDtoToTareaLocalizacionVenta(dto.getVentaOnline(), tarea,
                  TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
                  TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId()))));
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionVentaDto> savePtrVentaOnlinePickingResponse(
      @Valid @NotNull final PtrVentaOnlinePickingResponseDto dto, @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
      result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
          this.tareaLocalizacionVentaRepositoryCustom.save(this.tareaLocalizacionVentaMapper
              .ventaOnlinePickingResponseItemDtoToTareaLocalizacionVenta(dto.getVentaOnline(), tarea,
                  TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
                  TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId()))));
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionVentaDto> savePtrVentaOnlineEntregaTiendaResponse(
      @Valid @NotNull final PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
      result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
          this.tareaLocalizacionVentaRepositoryCustom.save(this.tareaLocalizacionVentaMapper
              .ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVenta(dto.getVentaOnline(),
                  tarea, TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
                  TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId()))));
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionVentaDto> savePtrVentaOnlineEntregaDomicilioResponse(
      @Valid @NotNull final PtrVentaOnlineEntregaDomicilioResponseDto dto, @Valid @NotNull final TareaDto tarea) {
    final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
      result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
          this.tareaLocalizacionVentaRepositoryCustom.save(this.tareaLocalizacionVentaMapper
              .ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionVenta(dto.getVentaOnline(),
                  tarea,
                  TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId(),
                  TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId()))));
    }
    return result;
  }

  @Override
  public void updateActivoVentaOnlineIpod(@Valid @NotNull final TareaDto tarea) {
    final List<IdTipoDatoDto> tipos = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId());
    this.tareaLocalizacionVentaRepositoryCustom.updateActivo(tarea, TipoVentaConceptoEnum.IPOD,
        tipos.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
  }

  @Override
  public void updateActivoVentaOnlinePicking(@Valid @NotNull final TareaDto tarea) {
    final List<IdTipoDatoDto> tipos = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId());
    this.tareaLocalizacionVentaRepositoryCustom.updateActivo(tarea, TipoVentaConceptoEnum.SINT,
        tipos.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
  }

  @Override
  public void updateActivoVentaOnlineEntregaTienda(@Valid @NotNull final TareaDto tarea) {
    final List<IdTipoDatoDto> tipos = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId());
    this.tareaLocalizacionVentaRepositoryCustom.updateActivo(tarea, TipoVentaConceptoEnum.ENTREGA_TIENDA,
        tipos.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
  }

  @Override
  public void save(@Valid @NotNull @NotEmpty final List<VentaManualWlocResultItemDto> src,
      @Valid @NotNull final TareaDto tareaDto) {
    this.tareaLocalizacionVentaRepositoryCustom.save(this.tareaLocalizacionVentaMapper
        .genericTiendaResultItemDtoToTareaLocalizacionVenta(src, tareaDto));
  }

}
