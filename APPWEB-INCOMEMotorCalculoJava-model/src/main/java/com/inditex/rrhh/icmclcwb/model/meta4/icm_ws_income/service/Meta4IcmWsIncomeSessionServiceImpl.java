package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.service;

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
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadosestructura.dto.EmpleadosEstructuraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service.Meta4IcmWsIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.service.Meta4IcmWsIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendacomisionable.dto.TiendaComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.tiendacomisionable.dto.TiendaComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.valorescondiciones.dto.ValoresCondicionesResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.mapper.poc.PocTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.service.Meta4PageableServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.repository.poc.PocTiendaRepository;

@Service
public class Meta4IcmWsIncomeSessionServiceImpl extends Meta4PageableServiceImpl implements Meta4IcmWsIncomeSessionService {

    @Autowired
    private Meta4IcmWsIncomeService meta4IcmWsIncomeService;

    @Autowired
    @Qualifier("getEmpleadosTiendaDto")
    private Meta4PropertiesDto getEmpleadosTiendaDto;

    @Autowired
    @Qualifier("getValoresCondicionesDto")
    private Meta4PropertiesDto getValoresCondicionesDto;
    
    @Autowired
    @Qualifier("getEmpleadosEstructuraDto")
    private Meta4PropertiesDto getEmpleadosEstructuraDto;
    
    @Autowired
    @Qualifier("getTiendaComisionableDto")
    private Meta4PropertiesDto getTiendaComisionableDto;
    
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
    	return getResultItem(request, meta4IcmWsIncomeService, "getEmpleadosEstructura", getEmpleadosEstructuraDto.getFilter().getMaxPageSize());
    }

    @Override
    public List<ValoresCondicionesResultItemDto> getValoresCondiciones(final ValoresCondicionesRequestDto request)
            throws Exception {
    	return getResultItem(request, meta4IcmWsIncomeService, "getValoresCondiciones", getValoresCondicionesDto.getFilter().getMaxPageSize());
    }
    
    @Override
    public List<TiendaComisionableResultItemDto> getTiendaComisionable(final TiendaComisionableRequestDto request)
            throws Exception {
    	return getResultItem(request, meta4IcmWsIncomeService, "getTiendaComisionable", getTiendaComisionableDto.getFilter().getMaxPageSize());
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