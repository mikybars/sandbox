package com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service;

import java.util.List;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendacomisionable.dto.TiendaComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendacomisionable.dto.TiendaComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDto;

@Deprecated
public interface Meta4IcmWsIncomeSessionService {

    List<EmpleadosTiendaResultItemDto> getEmpleadosTienda(final EmpleadosTiendaRequestDto request) throws Exception;

    List<EmpleadosEstructuraResultItemDto> getEmpleadosEstructura(final EmpleadosEstructuraRequestDto request)
            throws Exception;

    List<ValoresCondicionesResultItemDto> getValoresCondiciones(final ValoresCondicionesRequestDto request) throws Exception;

	List<TiendaComisionableResultItemDto> getTiendaComisionable(final TiendaComisionableRequestDto request) throws Exception;

    List<PeriodoDto> periodo();

    List<PocTiendaDto> getTiendas(final TrabajoDto trabajo);


}