package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;

public interface Meta4IcmWsCalcIncomeSessionService {

	List<GenericTiendaResultItemDto> getTiendasEmpleado(TiendasEmpleadoRequestDto request);

	List<GenericTiendaResultItemDto> searchTiendas(SearchTiendasRequestDto request);

	List<GenericTiendaResultItemDto> getTiendas(TiendasRequestDto request);

	List<GenericEmpleadoResultItemDto> searchEmpleados(SearchEmpleadosRequestDto request);

	List<GenericEmpleadoResultItemDto> getComisionEmpleado(ComisionEmpleadoRequestDto request);

	List<GenericEmpleadoResultItemDto> getEmpleados(EmpleadosRequestDto request);

	List<PeriodoDto> periodo();

}