package com.inditex.rrhh.icmclcwb.model.primary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryVentasMonacoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableVentasMonacoRepositoryCustom;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

public class PrimaryVentasMonacoAsyncServiceImpl implements PrimaryVentasMonacoAsyncService {

    @Autowired
    private TareaLocalizacionVentaMapper tareaLocalizacionVentaMapper;

    @Autowired
    private PrimaryTemporaryTableVentasMonacoRepositoryCustom primaryTemporaryTableVentasMonacoRepositoryCustom;

    @Autowired
    private TipoDatoService tipoDatoService;

    @Override
    public int deleteTempMonacoPtr() {
        return this.primaryTemporaryTableVentasMonacoRepositoryCustom.deleteTempMonacoPtr();
    }

    @Override
    public int createTempMonacoPtr() {
        return this.primaryTemporaryTableVentasMonacoRepositoryCustom.createTempMonacoPtr();
    }

    @Override
    public void mergeIntoTareaLocalizacionVenta() {
        this.primaryTemporaryTableVentasMonacoRepositoryCustom.mergeIntoTareaLocalizacionVenta();
    }

    @Override
    public CompletableFuture<Void> save(
        @Valid @NotNull @NotEmpty final List<VentaManualWlocResultItemDto> src,
        @Valid @NotNull final TareaDto tareaDto) {
        this.saveRepository(src, tareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    private void saveRepository(
        @Valid @NotNull @NotEmpty final List<VentaManualWlocResultItemDto> src,
        @Valid @NotNull final TareaDto tareaDto) {

        this.primaryTemporaryTableVentasMonacoRepositoryCustom.insertTempMonacoPtr(this.tareaLocalizacionVentaMapper
            .genericTiendaResultItemDtoToTareaLocalizacionVenta(src, tareaDto));

    }

    @Override
    public CompletableFuture<Void> savePtrVentaTotalizadoResponse(
        @Valid @NotNull final PtrVentaTotalizadoResponseDto dto,
        @Valid @NotNull final TareaDto tarea) {
        this.savePtrVentaTotalizado(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    private List<TareaLocalizacionVentaDto> savePtrVentaTotalizado(
        @Valid @NotNull final PtrVentaTotalizadoResponseDto dto,
        @Valid @NotNull final TareaDto tarea) {
        final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                this.primaryTemporaryTableVentasMonacoRepositoryCustom.insertTempMonacoPtr(this.tareaLocalizacionVentaMapper
                    .ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(dto.getVentaTotalizado(), tarea,
                        TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId()))));
        }
        return result;
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodResponse(
        @Valid @NotNull final PtrVentaOnlineIpodResponseDto dto,
        @Valid @NotNull final TareaDto tarea) {
        this.savePtrVentaOnlineIpod(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    private List<TareaLocalizacionVentaDto> savePtrVentaOnlineIpod(
        @Valid @NotNull final PtrVentaOnlineIpodResponseDto dto,
        @Valid @NotNull final TareaDto tarea) {
        final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                this.primaryTemporaryTableVentasMonacoRepositoryCustom.insertTempMonacoPtr(this.tareaLocalizacionVentaMapper
                    .ventaOnlineIpodResponseItemDtoToTareaLocalizacionVenta(dto.getVentaOnline(), tarea,
                        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId()))));
        }
        return result;
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlinePickingResponse(
        @Valid @NotNull final PtrVentaOnlinePickingResponseDto dto,
        @Valid @NotNull final TareaDto tarea) {
        this.savePtrVentaOnlinePicking(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    private List<TareaLocalizacionVentaDto> savePtrVentaOnlinePicking(
        @Valid @NotNull final PtrVentaOnlinePickingResponseDto dto, @Valid @NotNull final TareaDto tarea) {
        final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                this.primaryTemporaryTableVentasMonacoRepositoryCustom.insertTempMonacoPtr(this.tareaLocalizacionVentaMapper
                    .ventaOnlinePickingResponseItemDtoToTareaLocalizacionVenta(dto.getVentaOnline(), tarea,
                        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId()))));
        }
        return result;
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(
        @Valid @NotNull final PtrVentaOnlineEntregaTiendaResponseDto dto,
        @Valid @NotNull final TareaDto tarea) {
        this.savePtrVentaOnlineEntregaTienda(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    private List<TareaLocalizacionVentaDto> savePtrVentaOnlineEntregaTienda(
        @Valid @NotNull final PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid @NotNull final TareaDto tarea) {
        final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dto.getVentaOnline())) {
            result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                this.primaryTemporaryTableVentasMonacoRepositoryCustom.insertTempMonacoPtr(this.tareaLocalizacionVentaMapper
                    .ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVenta(dto.getVentaOnline(),
                        tarea, TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
                        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId()))));
        }
        return result;
    }


    @Override
    public CompletableFuture<Void> savePtrVentaTotalizadoResponseRepartoOnline(
        @Valid @NotNull final PtrVentaTotalizadoResponseDto dto, @Valid @NotNull final TareaDto tarea) {
        this.savePtrVentaTotalizadoRepartoOnline(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    private List<TareaLocalizacionVentaDto> savePtrVentaTotalizadoRepartoOnline(
        @Valid @NotNull final PtrVentaTotalizadoResponseDto dto, @Valid @NotNull final TareaDto tarea) {
        final List<TareaLocalizacionVentaDto> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(dto.getVentaTotalizado())) {
            result.addAll(this.tareaLocalizacionVentaMapper.tareaLocalizacionVentaToTareaLocalizacionVentaDto(
                this.primaryTemporaryTableVentasMonacoRepositoryCustom.insertTempMonacoPtr(this.tareaLocalizacionVentaMapper
                    .ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(dto.getVentaTotalizado(), tarea,
                        TipoDatoEnum.VENTA_FISICA_LOCALIZACION_REPARTO_ONLINE.getId()))));
        }
        return result;
    }

    @Override
    public void updateActivoVentaOnlineIpod(@Valid @NotNull final TareaDto tarea) {
        final List<IdTipoDatoDto> tipos = this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId());
        this.primaryTemporaryTableVentasMonacoRepositoryCustom.updateActivo(tarea, TipoVentaConceptoEnum.IPOD,
            tipos.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    }

    @Override
    public void updateActivoVentaOnlinePicking(@Valid @NotNull final TareaDto tarea) {
        final List<IdTipoDatoDto> tipos = this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId());
        this.primaryTemporaryTableVentasMonacoRepositoryCustom.updateActivo(tarea, TipoVentaConceptoEnum.SINT,
            tipos.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    }

    @Override
    public void updateActivoVentaOnlineEntregaTienda(@Valid @NotNull final TareaDto tarea) {
        final List<IdTipoDatoDto> tipos = this.tipoDatoService
            .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId());
        this.primaryTemporaryTableVentasMonacoRepositoryCustom.updateActivo(tarea, TipoVentaConceptoEnum.ENTREGA_TIENDA,
            tipos.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));
    }

}
