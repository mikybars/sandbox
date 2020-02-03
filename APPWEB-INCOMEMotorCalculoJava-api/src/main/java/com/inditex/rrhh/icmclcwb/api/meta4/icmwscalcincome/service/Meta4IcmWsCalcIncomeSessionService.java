package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

public interface Meta4IcmWsCalcIncomeSessionService {

    List<GenericTiendaResultItemDto> getTiendasEmpleado(TiendasEmpleadoRequestDto request);

    List<GenericTiendaResultItemDto> searchTiendas(SearchTiendasRequestDto request);

    List<GenericTiendaResultItemDto> getTiendas(TiendasRequestDto request);

    List<GenericEmpleadoResultItemDto> searchEmpleados(SearchEmpleadosRequestDto request);

    List<GenericEmpleadoResultItemDto> getEmpleados(EmpleadosRequestDto request);

    List<TiendaOnlineResultItemDto> tiendaOnline(TiendaOnlineRequestDto request);

    List<PeriodosResultItemDto> getPeriodos(PeriodosRequestDto request);

    List<GenericEmpleadoResultItemDto> getEmpleadosPresencia(EmpleadosPresenciaRequestDto request);

    List<GenericEmpleadoResultItemDto> getPresenciaManual(PresenciaManualRequestDto request);

    List<GenericEmpleadoResultItemDto> getCoefJornada(CoefJornadaRequestDto request);

    List<GenericTiendaResultItemDto> getFestivos(FestivosRequestDto request);

    List<GenericTiendaResultItemDto> getFlagCalcula(FlagCalculaRequestDto request);

    List<ConfiguracionVentaOnlineResultItemDto> getConfiguracionVentaOnline(
            final ConfiguracionVentaOnlineRequestDto request);

    List<AgrupOnlineResultItemDto> getAgrupacionesOnline(AgrupOnlineRequestDto request);

    List<EmpresaResultItemDto> getEmpresa(EmpresaRequestDto request);

    List<OrigenResultItemDto> getOrigen(OrigenRequestDto request);

    List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(
            ConfiguracionProductoVentaRequestDto request);

    List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(Long idTarea, String cclIdOrigen);

    List<GenericEmpleadoResultItemDto> getEmpleadosDesplazamiento(EmpleadosDesplazamientoRequestDto request);

    void saveProceso(SaveProcesoDto request);

    List<EstructurasComResultItemDto> getEstructurasCom(EstructurasComRequestDto request);

    List<EstructurasPolResultItemDto> getEstructurasPol(EstructurasPolRequestDto request);

    List<AusenciasResultItemDto> getAusencias(AusenciasRequestDto request);

    List<ConfiguracionItemDto> getConfiguraciones(ConfiguracionesRequestDto request);

}
