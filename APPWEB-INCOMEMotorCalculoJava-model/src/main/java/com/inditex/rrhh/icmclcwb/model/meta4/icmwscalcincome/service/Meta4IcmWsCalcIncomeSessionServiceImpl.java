package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.meta4.service.Meta4PageableServiceImpl;

@Service
public class Meta4IcmWsCalcIncomeSessionServiceImpl extends Meta4PageableServiceImpl<PageableListDto<Serializable>>
        implements Meta4IcmWsCalcIncomeSessionService {
    
    @Autowired
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Override
    public List<GenericTiendaResultItemDto> getFlagCalcula(final FlagCalculaRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.FLAG_CALCULA,
                meta4Properties.get(Meta4PropertiesConstants.FLAG_CALCULA).getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericTiendaResultItemDto> getFestivos(final FestivosRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.FESTIVOS,
                meta4Properties.get(Meta4PropertiesConstants.FESTIVOS).getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericEmpleadoResultItemDto> getCoefJornada(final CoefJornadaRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.COEF_JORNADA,
                meta4Properties.get(Meta4PropertiesConstants.COEF_JORNADA).getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericEmpleadoResultItemDto> getPresenciaManual(final PresenciaManualRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.PRESENCIA_MANUAL,
                meta4Properties.get(Meta4PropertiesConstants.PRESENCIA_MANUAL).getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericEmpleadoResultItemDto> getEmpleadosPresencia(final EmpleadosPresenciaRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.EMPLEADOS_PRESENCIA,
                meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_PRESENCIA).getFilter().getMaxPageSize());
    }

    @Override
    public List<PeriodosResultItemDto> getPeriodos(final PeriodosRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.PERIODOS,
                meta4Properties.get(Meta4PropertiesConstants.PERIODOS).getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericTiendaResultItemDto> getTiendasEmpleado(final TiendasEmpleadoRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.TIENDAS_EMPLEADO,
                meta4Properties.get(Meta4PropertiesConstants.TIENDAS_EMPLEADO).getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericTiendaResultItemDto> searchTiendas(final SearchTiendasRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.SEARCH_TIENDAS,
                meta4Properties.get(Meta4PropertiesConstants.SEARCH_TIENDAS).getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericTiendaResultItemDto> getTiendas(final TiendasRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.TIENDAS,
                meta4Properties.get(Meta4PropertiesConstants.TIENDAS).getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericEmpleadoResultItemDto> searchEmpleados(final SearchEmpleadosRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.SEARCH_EMPLEADOS,
                meta4Properties.get(Meta4PropertiesConstants.SEARCH_EMPLEADOS).getFilter().getMaxPageSize());
    }

    @Override
    public List<EstructurasComResultItemDto> getEstructurasCom(final EstructurasComRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.ESTRUCTURAS_COM,
                meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_COM).getFilter().getMaxPageSize());
    }
    
    @Override
    public List<EstructurasPolResultItemDto> getEstructurasPol(final EstructurasPolRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.ESTRUCTURAS_POL,
                meta4Properties.get(Meta4PropertiesConstants.ESTRUCTURAS_POL).getFilter().getMaxPageSize());
    }
    
    @Override
    public List<GenericEmpleadoResultItemDto> getEmpleados(final EmpleadosRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.EMPLEADOS,
                meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS).getFilter().getMaxPageSize());
    }

    @Override
    public List<ConfiguracionVentaOnlineResultItemDto> getConfiguracionVentaOnline(final ConfiguracionVentaOnlineRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.CONF_VENTA_ONLINE,
            meta4Properties.get(Meta4PropertiesConstants.CONF_VENTA_ONLINE).getFilter().getMaxPageSize());
    }

    @Override
    public List<AgrupOnlineResultItemDto> getAgrupacionesOnline(AgrupOnlineRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.AGRUPACION_ONLINE,
            meta4Properties.get(Meta4PropertiesConstants.AGRUPACION_ONLINE).getFilter().getMaxPageSize());
    }

    @Override
    public List<TiendaOnlineResultItemDto> tiendaOnline(TiendaOnlineRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.TIENDAS_ONLINE,
            meta4Properties.get(Meta4PropertiesConstants.TIENDAS_ONLINE).getFilter().getMaxPageSize());
    }
    
    @Override
    public List<EmpresaResultItemDto> getEmpresa(EmpresaRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.EMPRESA,
            meta4Properties.get(Meta4PropertiesConstants.EMPRESA).getFilter().getMaxPageSize());
    }
    
    @Override
    public List<OrigenResultItemDto> getOrigen(OrigenRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.ORIGEN,
            meta4Properties.get(Meta4PropertiesConstants.ORIGEN).getFilter().getMaxPageSize());
    }
    
    @Override
    public List<AusenciasResultItemDto> getAusencias(AusenciasRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.AUSENCIAS,
            meta4Properties.get(Meta4PropertiesConstants.AUSENCIAS).getFilter().getMaxPageSize());
    }
    
    @Override
    public List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(ConfiguracionProductoVentaRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.CONF_PRODUCTO_VENTA,
            meta4Properties.get(Meta4PropertiesConstants.CONF_PRODUCTO_VENTA).getFilter().getMaxPageSize());
    }
    
    @Cacheable(value = "itx.icmlcwb.id_producto_by_id_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
    @Override
    public List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(Long idTarea, String cclIdOrigen) {
        GenericFilterDto filter = new GenericFilterDto();
        filter.setIdOrigen(cclIdOrigen);
        ConfiguracionProductoVentaRequestDto productoRequest = new ConfiguracionProductoVentaRequestDto();
        productoRequest.setData(filter);
        productoRequest.setPage(meta4Properties.get(Meta4PropertiesConstants.CONF_PRODUCTO_VENTA).getPage());
        return getResultItem(productoRequest, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.CONF_PRODUCTO_VENTA,
                meta4Properties.get(Meta4PropertiesConstants.CONF_PRODUCTO_VENTA).getFilter().getMaxPageSize());
        
    }
       
    @Override
    public List<GenericEmpleadoResultItemDto> getEmpleadosDesplazamiento(final EmpleadosDesplazamientoRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO,
                meta4Properties.get(Meta4PropertiesConstants.EMPLEADOS_DESPLAZAMIENTO).getFilter().getMaxPageSize());
    }

    @Override
    public void saveProceso(SaveProcesoDto request) {
        SaveResultDto saveResult = meta4IcmWsCalcIncomeService.saveProceso(request);
        if (saveResult.getResultadoError() || !saveResult.getResultadoOk()) {
            StringBuilder sb = new StringBuilder("Error al guardar el proceso: \n");
            saveResult.getData().forEach(x ->
                sb.append(x.getLiteral()).append(" ").append(x.getRegistroAfectado()).append('\n'));
            throw new IcmclcwbException(sb.toString());
        }
    }

    @Override
    public List<ConfiguracionItemDto> getConfiguraciones(ConfiguracionesRequestDto request) {
        return meta4IcmWsCalcIncomeService.getConfiguracion(request).getItems();
    }
    
    @Override
    public List<ConfChDiasMinimosResultItemDto> getConfChallengeDiasMinimos(ConfChDiasMinimosRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.CONFCHALLENGEDIASMINIMOS,
            meta4Properties.get(Meta4PropertiesConstants.CONFCHALLENGEDIASMINIMOS).getFilter().getMaxPageSize());
    }
    
    @Override
    public List<PresupuestosWlocResultItemDto> getPresupuestosWloc(PresupuestosWlocRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.PRESUPUESTOSWLOC,
            meta4Properties.get(Meta4PropertiesConstants.PRESUPUESTOSWLOC).getFilter().getMaxPageSize());
    }
    
    @Override
    public List<ConfPrecioHoraResultItemDto> getConfPrecioHora(ConfPrecioHoraRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.CONFPRECIOHORA,
            meta4Properties.get(Meta4PropertiesConstants.CONFPRECIOHORA).getFilter().getMaxPageSize());
    }
    
    @Override
    public List<ConfChTpVentaResultItemDto> getConfChallengeTpVenta(ConfChTpVentaRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.CONFCHALLENGETPVENTA,
            meta4Properties.get(Meta4PropertiesConstants.CONFCHALLENGETPVENTA).getFilter().getMaxPageSize());
    }
    
    @Override
    public List<PresupuestosRangoResultItemDto> getPresupuestosRango(PresupuestosRangoRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.PRESUPUESTOSRANGO,
            meta4Properties.get(Meta4PropertiesConstants.PRESUPUESTOSRANGO).getFilter().getMaxPageSize());
    }
    
}
