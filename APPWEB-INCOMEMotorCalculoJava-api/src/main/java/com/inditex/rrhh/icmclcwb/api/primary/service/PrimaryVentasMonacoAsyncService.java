package com.inditex.rrhh.icmclcwb.api.primary.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface PrimaryVentasMonacoAsyncService {

    int deleteTempMonacoPtr();

    int createTempMonacoPtr();

    void mergeIntoTareaLocalizacionVenta();

    CompletableFuture<Void> save(@Valid @NotNull @NotEmpty List<VentaManualWlocResultItemDto> src,
        @Valid @NotNull TareaDto tareaDto);

    CompletableFuture<Void> savePtrVentaTotalizadoResponse(
        @Valid @NotNull final PtrVentaTotalizadoResponseDto dto,
        @Valid @NotNull final TareaDto tarea);

    CompletableFuture<Void> savePtrVentaOnlineIpodResponse(
        @Valid @NotNull final PtrVentaOnlineIpodResponseDto dto,
        @Valid @NotNull final TareaDto tarea);

    CompletableFuture<Void> savePtrVentaOnlinePickingResponse(
        @Valid @NotNull final PtrVentaOnlinePickingResponseDto dto, @Valid @NotNull final TareaDto tarea);

    CompletableFuture<Void> savePtrVentaOnlineEntregaTiendaResponse(
        @Valid @NotNull final PtrVentaOnlineEntregaTiendaResponseDto dto, @Valid @NotNull final TareaDto tarea);

    CompletableFuture<Void> savePtrVentaTotalizadoResponseRepartoOnline(
        @Valid @NotNull final PtrVentaTotalizadoResponseDto dto,
        @Valid @NotNull final TareaDto tarea);

    void updateActivoVentaOnlineIpod(@Valid @NotNull final TareaDto tarea);

    void updateActivoVentaOnlinePicking(@Valid @NotNull final TareaDto tarea);

    void updateActivoVentaOnlineEntregaTienda(@Valid @NotNull final TareaDto tarea);

}
