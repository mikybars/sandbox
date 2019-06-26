package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
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
    public List<ComisionEmpleadoResultItemDto> getComisionEmpleado(final ComisionEmpleadoRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.COMISION_EMPLEADO,
                meta4Properties.get(Meta4PropertiesConstants.COMISION_EMPLEADO).getFilter().getMaxPageSize());
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

    // TODO PoC
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
    public List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(ConfiguracionProductoVentaRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, Meta4PropertiesConstants.CONF_PRODUCTO_VENTA,
            meta4Properties.get(Meta4PropertiesConstants.CONF_PRODUCTO_VENTA).getFilter().getMaxPageSize());
    }
    

}
