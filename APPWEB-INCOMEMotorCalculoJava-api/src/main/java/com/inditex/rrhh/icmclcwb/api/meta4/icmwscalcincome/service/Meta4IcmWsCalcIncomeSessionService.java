package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineDto;

public interface Meta4IcmWsCalcIncomeSessionService {

	List<GenericTiendaResultItemDto> getTiendasEmpleado(TiendasEmpleadoRequestDto request);

	List<GenericTiendaResultItemDto> searchTiendas(SearchTiendasRequestDto request);

	List<GenericTiendaResultItemDto> getTiendas(TiendasRequestDto request);

	List<GenericEmpleadoResultItemDto> searchEmpleados(SearchEmpleadosRequestDto request);

	List<GenericEmpleadoResultItemDto> getComisionEmpleado(ComisionEmpleadoRequestDto request);

	List<GenericEmpleadoResultItemDto> getEmpleados(EmpleadosRequestDto request);

	List<PeriodoDto> periodo();

    List<TiendaOnlineDto> tiendaOnline();

    List<PeriodosResultItemDto> getPeriodos(PeriodosRequestDto request);

    List<GenericEmpleadoResultItemDto> getEmpleadosPresencia(EmpleadosPresenciaRequestDto request);

    List<GenericEmpleadoResultItemDto> getPresenciaManual(PresenciaManualRequestDto request);

    List<GenericEmpleadoResultItemDto> getCoefJornada(CoefJornadaRequestDto request);

    List<GenericTiendaResultItemDto> getFestivos(FestivosRequestDto request);

    List<GenericTiendaResultItemDto> getFlagCalcula(FlagCalculaRequestDto request);

}