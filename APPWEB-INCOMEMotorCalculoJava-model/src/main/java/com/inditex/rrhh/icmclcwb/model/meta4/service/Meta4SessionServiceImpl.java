package com.inditex.rrhh.icmclcwb.model.meta4.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.poc.PocTiendaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.poc.PocTiendaRepository;

@Service
public class Meta4SessionServiceImpl implements Meta4SessionService {

    @Autowired
    private Meta4IcmWsIncomeService meta4IcmWsIncomeService;

    @Autowired
    @Qualifier("getEmpleadosTiendaDto")
    private Meta4PropertiesDto getEmpleadosTiendaDto;

    @Autowired
    @Qualifier("getValoresCondicionesDto")
    private Meta4PropertiesDto getValoresCondicionesDto;

    @Autowired
    private PocTiendaRepository pocTiendaRepository;

    @Autowired
    private PocTiendaMapper pocTiendaMapper;

    @Override
    public List<EmpleadosTiendaResultItemDto> getEmpleadosTienda(final EmpleadosTiendaRequestDto request)
            throws Exception {
    	return getResultItem(request, meta4IcmWsIncomeService, "getEmpleadosTienda", getEmpleadosTiendaDto.getFilter().getMaxPageSize());
    }

    @Override
    public List<EmpleadosEstructuraResultItemDto> getEmpleadosEstructura(final EmpleadosEstructuraRequestDto request)
            throws Exception {
    	return getResultItem(request, meta4IcmWsIncomeService, "getEmpleadosEstructura", 10);
    }

    @Override
    public List<ValoresCondicionesResultItemDto> getValoresCondiciones(final ValoresCondicionesRequestDto request)
            throws Exception {
    	return getResultItem(request, meta4IcmWsIncomeService, "getValoresCondiciones", getValoresCondicionesDto.getFilter().getMaxPageSize());
    }

	private <T extends PageableDto<?>, U extends PageableListDto, Z extends Object> List<Z> getResultItem(final T request, 
			Object service, String methodName, Integer maxPageSize) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
       
        List<Z> result = new ArrayList<>();
        boolean hasNext = false;
        do {
        	
			Method method = service.getClass().getMethod(methodName, request.getClass());
	        U response = (U) method.invoke(service, request);
			
			if (response != null) {
			    if (CollectionUtils.isNotEmpty(response.getData())) {
			        result.addAll(response.getData());
			    }
			    if (response.getPage() != null && response.getPage().hasNext() && (result.size() < maxPageSize )) {
			        hasNext = true;
			        request.setPage(response.getPage().next());
			    }else{
			        request.setPage(response.getPage());
				}
			}
        } while(hasNext);
		
        return result;
	}

    @Override
    public List<PeriodoDto> periodo() {
        List<PeriodoDto> result = new ArrayList<>();
        Random random = new Random();
        LongStream lsPeriodos = random.longs(2, 3);
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
        return result;
    }

    @Override
    public List<PocTiendaDto> getTiendas(final TrabajoDto trabajo) {
        List<String> tiendas = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
            trabajo.getTiendas().forEach(item -> tiendas.add(item.getIdTienda()));
        }
        return pocTiendaMapper.pocTiendaToPocTiendaDto(pocTiendaRepository
                .findByIdPaisOrigenAndIdEmpresaAndIdIn(trabajo.getIdPaisOrigen(), trabajo.getIdEmpresa(), tiendas));
    }

}