package com.inditex.rrhh.icmclcwb.model.meta4.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.annotation.Meta4Session;
import com.inditex.rrhh.icmclcwb.model.app.service.test.PaginationPropertiesFactory;

@Service
public class Meta4SessionServiceImpl implements Meta4SessionService {

	@Autowired
	private Logger LOG;

	@Autowired
	private Meta4IcmWsIncomeService meta4IcmWsIncomeService;

	@Meta4Session
	@Override
	public List<EmpleadosTiendaResultItemDto> getEmpleadosTienda(TrabajoDto trabajo) throws Exception {
		List<EmpleadosTiendaResultItemDto> result = new ArrayList<>();

		// TODO Hay que recuperar las tiendas de BBDD no del objeto de trabajo
		for (TiendaDto tienda : trabajo.getTienda()) {
			EmpleadosTiendaRequestDto request = new EmpleadosTiendaRequestDto();

			request.setPage(PaginationPropertiesFactory.getProperties(new Object() {
			}.getClass().getEnclosingMethod().getName()));

			EmpleadosTiendaFilterDto data = new EmpleadosTiendaFilterDto();
			data.setFechaInicio(trabajo.getFechaInicioPeriodo());
			data.setFechaFin(trabajo.getFechaFinPeriodo());
			data.setIdLugarTrabajo("T" + tienda);
			request.setData(data);

			boolean hasNext = false;
			do {
				hasNext = false;
				EmpleadosTiendaResponseDto response = meta4IcmWsIncomeService.getEmpleadosTienda(request);
				if (response != null) {
					if (CollectionUtils.isNotEmpty(response.getData())) {
						result.addAll(response.getData());
					}
					if (response.getPage() != null && response.getPage().hasNext()) {
						hasNext = true;
						request.setPage(response.getPage().next());
					}
				}
			} while (hasNext);
		}

		return result;
	}

	@Meta4Session
	@Override
	public List<EmpleadosTiendaResultItemDto> getEmpleadosTienda(EmpleadosTiendaRequestDto request) throws Exception {
		List<EmpleadosTiendaResultItemDto> result = new ArrayList<>();

		boolean hasNext = false;
		do {
			hasNext = false;
			EmpleadosTiendaResponseDto response = meta4IcmWsIncomeService.getEmpleadosTienda(request);
			if (response != null) {
				if (CollectionUtils.isNotEmpty(response.getData())) {
					result.addAll(response.getData());
				}
				if (response.getPage() != null && response.getPage().hasNext()) {
					hasNext = true;
					request.setPage(response.getPage().next());
				}
			}
		} while (hasNext);

		return result;
	}

	@Meta4Session
	@Override
	public List<EmpleadosEstructuraResultItemDto> getEmpleadosEstructura(EmpleadosEstructuraRequestDto request)
			throws Exception {
		List<EmpleadosEstructuraResultItemDto> result = new ArrayList<>();

		EmpleadosEstructuraResponseDto response = meta4IcmWsIncomeService.getEmpleadosEstructura(request);

		if (response != null) {
			if (CollectionUtils.isNotEmpty(response.getData())) {
				result.addAll(response.getData());
			}
		}

		return result;
	}

	@Meta4Session
	@Override
	public List<ValoresCondicionesResultItemDto> getValoresCondiciones(ValoresCondicionesRequestDto request)
			throws Exception {
		List<ValoresCondicionesResultItemDto> result = new ArrayList<>();

		boolean hasNext = false;
		do {
			hasNext = false;
			ValoresCondicionesResponseDto response = meta4IcmWsIncomeService.getValoresCondiciones(request);
			if (response != null) {
				if (CollectionUtils.isNotEmpty(response.getData())) {
					result.addAll(response.getData());
				}
				if (response.getPage() != null && response.getPage().hasNext()) {
					hasNext = true;
					request.setPage(response.getPage().next());
				}
			}
		} while (hasNext);

		return result;
	}

	@Override
	public List<PeriodoDto> periodo() {
		LOG.info("Inicio :: Meta4Service.periodo()");
		List<PeriodoDto> result = new ArrayList<>();
		Random random = new Random();
		LongStream lsPeriodos = random.longs(1, 3);
		long periodos = lsPeriodos.findFirst().getAsLong();
		lsPeriodos.close();
		for (int periodo = 1; periodo <= periodos; periodo++) {
			PeriodoDto item = new PeriodoDto();
			IntStream isMes = random.ints(1, 12);
			int mes = isMes.findFirst().getAsInt();
			isMes.close();
			LocalDate localDate = LocalDate.of(2017, mes, 1);
			item.setFechaInicioPeriodo(localDate.with(TemporalAdjusters.firstDayOfMonth()).atTime(LocalTime.MIN));
			item.setFechaFinPeriodo(localDate.with(TemporalAdjusters.lastDayOfMonth()).atTime(LocalTime.MAX));
			result.add(item);
		}
		LOG.info("Inicio :: Meta4Service.periodo(): {}", result);
		return result;
	}

}