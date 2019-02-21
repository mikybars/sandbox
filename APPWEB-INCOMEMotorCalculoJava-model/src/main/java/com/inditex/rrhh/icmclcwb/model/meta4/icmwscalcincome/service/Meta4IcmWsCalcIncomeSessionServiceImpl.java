package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageableListDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.model.meta4.service.Meta4PageableServiceImpl;

@Service
public class Meta4IcmWsCalcIncomeSessionServiceImpl extends Meta4PageableServiceImpl<PageableListDto<Serializable>>
        implements Meta4IcmWsCalcIncomeSessionService {

    @Autowired
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Autowired
    @Qualifier("getTiendasEmpleadoDto")
    private Meta4PropertiesDto getTiendasEmpleadoDto;

    @Autowired
    @Qualifier("searchTiendasDto")
    private Meta4PropertiesDto searchTiendasDto;

    @Autowired
    @Qualifier("getTiendasDto")
    private Meta4PropertiesDto getTiendasDto;

    @Autowired
    @Qualifier("searchEmpleadosDto")
    private Meta4PropertiesDto searchEmpleadosDto;

    @Autowired
    @Qualifier("getComisionEmpleadoDto")
    private Meta4PropertiesDto getComisionEmpleadoDto;

    @Autowired
    @Qualifier("getEmpleadosDto")
    private Meta4PropertiesDto getEmpleadosDto;

    @Override
    public List<GenericTiendaResultItemDto> getTiendasEmpleado(final TiendasEmpleadoRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, "getTiendasEmpleado",
                getTiendasEmpleadoDto.getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericTiendaResultItemDto> searchTiendas(final SearchTiendasRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, "searchTiendas",
                searchTiendasDto.getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericTiendaResultItemDto> getTiendas(final TiendasRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, "getTiendas",
                getTiendasDto.getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericEmpleadoResultItemDto> searchEmpleados(final SearchEmpleadosRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, "searchEmpleados",
                searchEmpleadosDto.getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericEmpleadoResultItemDto> getComisionEmpleado(final ComisionEmpleadoRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, "getComisionEmpleado",
                getComisionEmpleadoDto.getFilter().getMaxPageSize());
    }

    @Override
    public List<GenericEmpleadoResultItemDto> getEmpleados(final EmpleadosRequestDto request) {
        return getResultItem(request, meta4IcmWsCalcIncomeService, "getEmpleados",
                getEmpleadosDto.getFilter().getMaxPageSize());
    }

    // TODO PoC
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
            item.setId(new StringBuilder("MOCK_").append(periodo).toString());
            item.setFechaInicioPeriodo(localDate.with(TemporalAdjusters.firstDayOfMonth()).atTime(LocalTime.MIN));
            item.setFechaFinPeriodo(localDate.with(TemporalAdjusters.lastDayOfMonth()).atTime(LocalTime.MAX));
            result.add(item);
        }
        return result;
    }

}
