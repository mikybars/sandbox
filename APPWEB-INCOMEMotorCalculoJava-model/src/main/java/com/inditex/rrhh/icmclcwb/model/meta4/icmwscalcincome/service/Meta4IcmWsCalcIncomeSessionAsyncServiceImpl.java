package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionOrganizacionItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesOrganizacionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeSessionAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

@Service
public class Meta4IcmWsCalcIncomeSessionAsyncServiceImpl implements Meta4IcmWsCalcIncomeSessionAsyncService {

    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Override
    public CompletableFuture<List<GenericTiendaResultItemDto>> getFlagCalcula(FlagCalculaRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getFlagCalcula(request));
    }
    
    @Override
    public CompletableFuture<List<GenericEmpleadoResultItemDto>> getCoefJornada(CoefJornadaRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getCoefJornada(request));
    }
    
    @Override
    public CompletableFuture<List<GenericTiendaResultItemDto>> getFestivos(FestivosRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getFestivos(request));
    }
    
    @Override
    public CompletableFuture<List<GenericEmpleadoResultItemDto>> getPresenciaManual(PresenciaManualRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getPresenciaManual(request));
    }
    
    @Override
    public CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleadosPresencia(EmpleadosPresenciaRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getEmpleadosPresencia(request));
    }
    
    @Override
    public CompletableFuture<List<PeriodosResultItemDto>> getPeriodos(PeriodosRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
    }
    
    @Override
    public CompletableFuture<List<GenericTiendaResultItemDto>> getTiendasEmpleado(TiendasEmpleadoRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getTiendasEmpleado(request));
    }
    
    @Override
    public CompletableFuture<List<GenericTiendaResultItemDto>> searchTiendas(SearchTiendasRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.searchTiendas(request));
    }

    @Override
    public CompletableFuture<List<GenericTiendaResultItemDto>> getTiendas(TiendasRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getTiendas(request));
    }
    
    @Override
    public CompletableFuture<List<GenericEmpleadoResultItemDto>> searchEmpleados(SearchEmpleadosRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.searchEmpleados(request));
    }
    
    @Override
    public CompletableFuture<List<EstructurasComResultItemDto>> getEstructurasCom(
            EstructurasComRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getEstructurasCom(request));
    }
    
    @Override
    public CompletableFuture<List<EstructurasPolResultItemDto>> getEstructurasPol(
            EstructurasPolRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getEstructurasPol(request));
    }
    
    @Override
    public CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleados(EmpleadosRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getEmpleados(request));
    }

    @Override
    public CompletableFuture<List<ConfiguracionVentaOnlineResultItemDto>> getConfiguracionVentaOnline(ConfiguracionVentaOnlineRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getConfiguracionVentaOnline(request));
    }

    @Override
    public CompletableFuture<List<AgrupOnlineResultItemDto>> getAgrupacionesOnline(AgrupOnlineRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getAgrupacionesOnline(request));
    }

    @Override
    public CompletableFuture<List<TiendaOnlineResultItemDto>> getTiendasOnline(TiendaOnlineRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.tiendaOnline(request));
    }
    
    @Override
    public CompletableFuture<List<EmpresaResultItemDto>> getEmpresa(EmpresaRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getEmpresa(request));
    }
    
    @Override
    public CompletableFuture<List<OrigenResultItemDto>> getOrigen(OrigenRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getOrigen(request));
    }
    
    @Override
    public CompletableFuture<List<AusenciasResultItemDto>> getAusencias(AusenciasRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getAusencias(request));
    }
    
    @Override
    public CompletableFuture<List<ConfiguracionProductoVentaResultItemDto>> getConfiguracionProductoVenta(ConfiguracionProductoVentaRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getConfiguracionProductoVenta(request));
    }
    
    @Override
    public CompletableFuture<List<GenericEmpleadoResultItemDto>> getEmpleadosDesplazamiento(
            EmpleadosDesplazamientoRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getEmpleadosDesplazamiento(request));
    }

    @Override
    public CompletableFuture<List<ConfiguracionOrganizacionItemDto>> getConfiguracionesOrganizacion(ConfiguracionesOrganizacionRequestDto request) {
        return CompletableFuture.completedFuture(meta4IcmWsCalcIncomeSessionService.getConfiguracionesOrganizacion(request));
    }
}
