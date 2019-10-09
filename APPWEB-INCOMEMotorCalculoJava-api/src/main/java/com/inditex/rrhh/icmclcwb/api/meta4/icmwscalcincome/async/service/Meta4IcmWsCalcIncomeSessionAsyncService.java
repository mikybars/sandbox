package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;

@Async("meta4Executor")
public interface Meta4IcmWsCalcIncomeSessionAsyncService {

    CompletableFuture<List<GenericTiendaResultItemDto>> getTiendasEmpleado(TiendasEmpleadoRequestDto request);

    CompletableFuture<List<GenericTiendaResultItemDto>> searchTiendas(SearchTiendasRequestDto request);

    CompletableFuture<List<GenericTiendaResultItemDto>> getTiendas(TiendasRequestDto request);

    CompletableFuture<List<GenericEmpleadoResultItemDto>> searchEmpleados(SearchEmpleadosRequestDto request);

    CompletableFuture<List<ComisionEmpleadoResultItemDto>> getComisionEmpleado(ComisionEmpleadoRequestDto request);

    CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleados(EmpleadosRequestDto request);

    CompletableFuture<List<PeriodosResultItemDto>> getPeriodos(PeriodosRequestDto request);

    CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleadosPresencia(EmpleadosPresenciaRequestDto request);

    CompletableFuture<List<GenericEmpleadoResultItemDto>> getPresenciaManual(PresenciaManualRequestDto request);

    CompletableFuture<List<GenericTiendaResultItemDto>> getFestivos(FestivosRequestDto request);

    CompletableFuture<List<GenericEmpleadoResultItemDto>> getCoefJornada(CoefJornadaRequestDto request);

    CompletableFuture<List<GenericTiendaResultItemDto>> getFlagCalcula(FlagCalculaRequestDto request);

    CompletableFuture<List<ConfiguracionVentaOnlineResultItemDto>> getConfiguracionVentaOnline(ConfiguracionVentaOnlineRequestDto request);

    CompletableFuture<List<AgrupOnlineResultItemDto>> getAgrupacionesOnline(AgrupOnlineRequestDto request);

    CompletableFuture<List<TiendaOnlineResultItemDto>> getTiendasOnline(TiendaOnlineRequestDto request);

    CompletableFuture<List<EmpresaResultItemDto>> getEmpresa(EmpresaRequestDto request);

    CompletableFuture<List<OrigenResultItemDto>> getOrigen(OrigenRequestDto request);

    CompletableFuture<List<ConfiguracionProductoVentaResultItemDto>> getConfiguracionProductoVenta(
            ConfiguracionProductoVentaRequestDto request);

    CompletableFuture<List<ComisionEmpleadoResultItemDto>> getEstructurasPoliticas(ComisionEmpleadoRequestDto request);

    CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleadosDesplazamiento(
            EmpleadosDesplazamientoRequestDto request);

}
