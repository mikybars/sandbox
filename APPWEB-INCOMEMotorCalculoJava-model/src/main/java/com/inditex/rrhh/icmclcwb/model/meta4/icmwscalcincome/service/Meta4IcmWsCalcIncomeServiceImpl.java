package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasempleado.dto.TiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcoefjornadaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcomisionempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadospresenciaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetfestivosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetperiodosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasempleadoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.IcmWsCalcIncomeMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

@Service
public class Meta4IcmWsCalcIncomeServiceImpl implements Meta4IcmWsCalcIncomeService {
	
	@Autowired
	@Qualifier("meta4ClientPool")
	private Meta4ClientPool meta4ClientPool;
	
    @Autowired
    private IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;
	
    @Override
    public FlagCalculaResponseDto getFlagCalcula(FlagCalculaRequestDto request) {
        FlagCalculaResponseDto result = new FlagCalculaResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetflagcalculaOutput getFlagCalculaOutput = meta4ClientPool.getflagcalcula(param1, param2);
        if (getFlagCalculaOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getFlagCalculaOutput.getReturn()) == 0) {
            if (getFlagCalculaOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getFlagCalculaOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if(getFlagCalculaOutput.getIcmListatiendas() != null
                    && CollectionUtils.isNotEmpty(
                            getFlagCalculaOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
            List<GenericTiendaResultItemDto> items = icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
                    getFlagCalculaOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        } 
                   
        return result;
    }
    
    @Override
    public CoefJornadaResponseDto getCoefJornada(CoefJornadaRequestDto request) {
        CoefJornadaResponseDto result = new CoefJornadaResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetcoefjornadaOutput getCoefJornadaOutput = meta4ClientPool.getcoefjornada(param1, param2);
        if (getCoefJornadaOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getCoefJornadaOutput.getReturn()) == 0 ) {
            if (getCoefJornadaOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getCoefJornadaOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if(getCoefJornadaOutput.getIcmListaempleados() != null
            && CollectionUtils.isNotEmpty(
                    getCoefJornadaOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtos(
                        getCoefJornadaOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
    @Override
    public FestivosResponseDto getFestivos(FestivosRequestDto request) {
        FestivosResponseDto result = new FestivosResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetfestivosOutput getFestivosOutput = meta4ClientPool.getfestivos(param1, param2);
        if (getFestivosOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getFestivosOutput.getReturn()) == 0) {
            if (getFestivosOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getFestivosOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if(getFestivosOutput.getIcmListatiendas() != null  && CollectionUtils.isNotEmpty(
                    getFestivosOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
                    List<GenericTiendaResultItemDto> items = icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
                            getFestivosOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                    result.setData(items);
            } 
        }
        return result;
    }
    
    @Override
    public PresenciaManualResponseDto getPresenciaManual(PresenciaManualRequestDto request) {
        PresenciaManualResponseDto result = new PresenciaManualResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetpresenciamanualOutput getPresenciaManualOutput = meta4ClientPool.getpresenciamanual(param1, param2);
        if (getPresenciaManualOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getPresenciaManualOutput.getReturn()) == 0 ) {
            if (getPresenciaManualOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getPresenciaManualOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if(getPresenciaManualOutput.getIcmListaempleados() != null
                    && CollectionUtils.isNotEmpty(
                            getPresenciaManualOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtos(
                        getPresenciaManualOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
                result.setData(items);
            }
        }  
        return result;
    }
    
    @Override
    public EmpleadosPresenciaResponseDto getEmpleadosPresencia(EmpleadosPresenciaRequestDto request) {
        EmpleadosPresenciaResponseDto result = new EmpleadosPresenciaResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetempleadospresenciaOutput getempleadospresenciaOutput = meta4ClientPool.getempleadospresencia(param1, param2);
        if (getempleadospresenciaOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getempleadospresenciaOutput.getReturn()) == 0 ) {
            if (getempleadospresenciaOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getempleadospresenciaOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if(getempleadospresenciaOutput.getIcmListaempleados() != null
                    && CollectionUtils.isNotEmpty(
                            getempleadospresenciaOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtos(
                        getempleadospresenciaOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
    @Override
    public PeriodosResponseDto getPeriodos(PeriodosRequestDto request) {
        PeriodosResponseDto result = new PeriodosResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetperiodosOutput getperiodosOutput = meta4ClientPool.getperiodos(param1, param2);
        if (getperiodosOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getperiodosOutput.getReturn()) == 0 ) {
            if (getperiodosOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getperiodosOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if(getperiodosOutput.getIcmListaperiodos() != null
                    && CollectionUtils.isNotEmpty(
                            getperiodosOutput.getIcmListaperiodos().getIcmListaperiodosRecordSet())) {
                List<PeriodosResultItemDto> items = icmWsCalcIncomeMapper.asPeriodosResultItemDtos(
                        getperiodosOutput.getIcmListaperiodos().getIcmListaperiodosRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
    @Override
    public TiendasEmpleadoResponseDto getTiendasEmpleado(TiendasEmpleadoRequestDto request) {
        TiendasEmpleadoResponseDto result = new TiendasEmpleadoResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GettiendasempleadoOutput gettiendasempleadoOutput = meta4ClientPool.gettiendasempleado(param1, param2);
        if (gettiendasempleadoOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, gettiendasempleadoOutput.getReturn()) == 0) {
            if (gettiendasempleadoOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(gettiendasempleadoOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (gettiendasempleadoOutput.getIcmListatiendas() != null
                    && gettiendasempleadoOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            gettiendasempleadoOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
                List<GenericTiendaResultItemDto> items = icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
                        gettiendasempleadoOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
    @Override
    public SearchTiendasResponseDto searchTiendas(SearchTiendasRequestDto request){
    	SearchTiendasResponseDto result = new SearchTiendasResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        SearchtiendasOutput searchTiendasOutput = meta4ClientPool.searchtiendas(param1, param2);
        if (searchTiendasOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, searchTiendasOutput.getReturn()) == 0) {
            if (searchTiendasOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(searchTiendasOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (searchTiendasOutput.getIcmListatiendas() != null
                    && searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
                List<GenericTiendaResultItemDto> items = icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
                        searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
    @Override
    public TiendasResponseDto getTiendas(TiendasRequestDto request){
    	TiendasResponseDto result = new TiendasResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GettiendasincomeOutput tiendasOutput = meta4ClientPool.gettiendasincome(param2, param1);
        if (tiendasOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, tiendasOutput.getReturn()) == 0) {
            if (tiendasOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(tiendasOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (tiendasOutput.getIcmListatiendas() != null
                    && tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
                List<GenericTiendaResultItemDto> items = icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
                        tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
    @Override
    public SearchEmpleadosResponseDto searchEmpleados(SearchEmpleadosRequestDto request){
    	SearchEmpleadosResponseDto result = new SearchEmpleadosResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        SearchempleadosOutput searchEmpleadosOutput = meta4ClientPool.searchempleados(param2, param1);
        if (searchEmpleadosOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, searchEmpleadosOutput.getReturn()) == 0) {
            if (searchEmpleadosOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(searchEmpleadosOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (searchEmpleadosOutput.getIcmListaempleados() != null
                    && searchEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            searchEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtos(
                        searchEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
                result.setData(items);
            }
        }
        return result;
    	
    }

    @Override
    public ComisionEmpleadoResponseDto getComisionEmpleado(ComisionEmpleadoRequestDto request) {
    	ComisionEmpleadoResponseDto result = new ComisionEmpleadoResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        GetcomisionempleadoOutput getComisionEmpleadoOutput = meta4ClientPool.getcomisionempleado(param1, null);
        if (getComisionEmpleadoOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getComisionEmpleadoOutput.getReturn()) == 0 ) {
//            if( getComisionEmpleadoOutput.getIcmListaestructuras() != null
//                    && CollectionUtils.isNotEmpty(
//                            getComisionEmpleadoOutput.getIcmListaestructuras().getIcmListaestructurasRecordSet())) {
//                List<ComisionEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asComisionEmpleadoResultItemDtos(
//                        getComisionEmpleadoOutput.getIcmListaestructuras().getIcmListaestructurasRecordSet());
//                result.setData(items);
//            }
        }

    	return result;
    }
    
    
    @Override
    public EmpleadosResponseDto getEmpleados(EmpleadosRequestDto request){
    	EmpleadosResponseDto result = new EmpleadosResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetempleadosOutput getEmpleadosOutput = meta4ClientPool.getempleados(param1, param2);
        if (getEmpleadosOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getEmpleadosOutput.getReturn()) == 0) {
            if (getEmpleadosOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getEmpleadosOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getEmpleadosOutput.getIcmListaempleados() != null
                    && getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet() != null
                    && CollectionUtils.isNotEmpty(
                            getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtos(
                        getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
}