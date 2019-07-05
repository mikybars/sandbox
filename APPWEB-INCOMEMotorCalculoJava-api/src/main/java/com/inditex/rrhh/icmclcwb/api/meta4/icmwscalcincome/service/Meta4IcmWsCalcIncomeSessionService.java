package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service;

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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;

import java.util.List;

public interface Meta4IcmWsCalcIncomeSessionService {

    List<GenericTiendaResultItemDto> getTiendasEmpleado(TiendasEmpleadoRequestDto request);

    List<GenericTiendaResultItemDto> searchTiendas(SearchTiendasRequestDto request);

    List<GenericTiendaResultItemDto> getTiendas(TiendasRequestDto request);

    List<GenericEmpleadoResultItemDto> searchEmpleados(SearchEmpleadosRequestDto request);

    List<ComisionEmpleadoResultItemDto> getComisionEmpleado(ComisionEmpleadoRequestDto request);

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

    List<ConfiguracionProductoVentaResultItemDto> getConfiguracionProductoVenta(Long idTarea, String idOrigen);

}
