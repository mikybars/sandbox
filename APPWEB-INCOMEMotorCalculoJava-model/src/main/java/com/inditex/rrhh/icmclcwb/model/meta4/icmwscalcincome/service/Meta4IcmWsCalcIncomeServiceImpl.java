package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetagruponlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetausenciasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcadenaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcoefjornadaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfprodventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfventaonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosdesplazOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadospresenciaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempresasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructurascomOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructuraspolOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetfestivosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetorigenesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetperiodosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SaveprocesoOutput;
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
    public AgrupOnlineResponseDto getAgrupOnline(AgrupOnlineRequestDto request) {
        AgrupOnlineResponseDto result = new AgrupOnlineResponseDto();
        IcmParamcalorigenBlock param1 = icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetagruponlineOutput getAgrupOnlineOutput = meta4ClientPool.getagruponline(param1, param2);
        if (getAgrupOnlineOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getAgrupOnlineOutput.getReturn()) == 0) {
            if (getAgrupOnlineOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getAgrupOnlineOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getAgrupOnlineOutput.getIcmListaconfiguracion() != null && CollectionUtils
                    .isNotEmpty(getAgrupOnlineOutput.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet())) {
                List<AgrupOnlineResultItemDto> items = icmWsCalcIncomeMapper.asAgrupOnlineResultItemDtos(
                        getAgrupOnlineOutput.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet());
                result.setData(items);
            }
        }

        return result;
    }

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
            if (getFlagCalculaOutput.getIcmListatiendas() != null && CollectionUtils
                    .isNotEmpty(getFlagCalculaOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
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
                && Double.compare(NumberUtils.DOUBLE_ZERO, getCoefJornadaOutput.getReturn()) == 0) {
            if (getCoefJornadaOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getCoefJornadaOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getCoefJornadaOutput.getIcmListaempleados() != null && CollectionUtils
                    .isNotEmpty(getCoefJornadaOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
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
        if (getFestivosOutput != null && Double.compare(NumberUtils.DOUBLE_ZERO, getFestivosOutput.getReturn()) == 0) {
            if (getFestivosOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getFestivosOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getFestivosOutput.getIcmListatiendas() != null && CollectionUtils
                    .isNotEmpty(getFestivosOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
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
                && Double.compare(NumberUtils.DOUBLE_ZERO, getPresenciaManualOutput.getReturn()) == 0) {
            if (getPresenciaManualOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getPresenciaManualOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getPresenciaManualOutput.getIcmListaempleados() != null && CollectionUtils
                    .isNotEmpty(getPresenciaManualOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
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
                && Double.compare(NumberUtils.DOUBLE_ZERO, getempleadospresenciaOutput.getReturn()) == 0) {
            if (getempleadospresenciaOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper
                        .asPageDto(getempleadospresenciaOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getempleadospresenciaOutput.getIcmListaempleados() != null && CollectionUtils
                    .isNotEmpty(getempleadospresenciaOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
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
        IcmParamcalperiodoBlock param1 = icmWsCalcIncomeMapper.asIcmParamcalperiodoBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetperiodosOutput getperiodosOutput = meta4ClientPool.getperiodos(param1, param2);
        if (getperiodosOutput != null && Double.compare(NumberUtils.DOUBLE_ZERO, getperiodosOutput.getReturn()) == 0) {
            if (getperiodosOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getperiodosOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getperiodosOutput.getIcmListaperiodos() != null && CollectionUtils
                    .isNotEmpty(getperiodosOutput.getIcmListaperiodos().getIcmListaperiodosRecordSet())) {
                List<PeriodosResultItemDto> items = icmWsCalcIncomeMapper.asPeriodosResultItemDtos(
                        getperiodosOutput.getIcmListaperiodos().getIcmListaperiodosRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public SearchTiendasResponseDto searchTiendas(SearchTiendasRequestDto request) {
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
                    && searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null && CollectionUtils
                            .isNotEmpty(searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
                List<GenericTiendaResultItemDto> items = icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
                        searchTiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public TiendasResponseDto getTiendas(TiendasRequestDto request) {
        TiendasResponseDto result = new TiendasResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GettiendasincomeOutput tiendasOutput = meta4ClientPool.gettiendasincome(param2, param1);
        if (tiendasOutput != null && Double.compare(NumberUtils.DOUBLE_ZERO, tiendasOutput.getReturn()) == 0) {
            if (tiendasOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(tiendasOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (tiendasOutput.getIcmListatiendas() != null
                    && tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet() != null
                    && CollectionUtils.isNotEmpty(tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet())) {
                List<GenericTiendaResultItemDto> items = icmWsCalcIncomeMapper.asGenericTiendaResultItemDtos(
                        tiendasOutput.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public SearchEmpleadosResponseDto searchEmpleados(SearchEmpleadosRequestDto request) {
        SearchEmpleadosResponseDto result = new SearchEmpleadosResponseDto();
        IcmParamcalempleadoBlock param1 = icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        SearchempleadosOutput searchEmpleadosOutput = meta4ClientPool.searchempleados(param2, param1);
        if (searchEmpleadosOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, searchEmpleadosOutput.getReturn()) == 0) {
            if (searchEmpleadosOutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(searchEmpleadosOutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (searchEmpleadosOutput.getIcmListaempleado() != null
                    && searchEmpleadosOutput.getIcmListaempleado().getIcmListaempleadoRecordSet() != null
                    && CollectionUtils
                            .isNotEmpty(searchEmpleadosOutput.getIcmListaempleado().getIcmListaempleadoRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtosSearchEmpleados(
                        searchEmpleadosOutput.getIcmListaempleado().getIcmListaempleadoRecordSet());
                result.setData(items);
            }
        }
        return result;

    }
  
    @Override
    public EstructurasComResponseDto getEstructurasCom(EstructurasComRequestDto request) {
        EstructurasComResponseDto result = new EstructurasComResponseDto();
        IcmParamcalestructuraBlock param1 = icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(request.getData());
        GetestructurascomOutput getEstructurasComOutput = meta4ClientPool.getestructurascom(param1);
        if (getEstructurasComOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getEstructurasComOutput.getReturn()) == 0) {
            if (getEstructurasComOutput.getIcmListaestructura() != null && CollectionUtils
                    .isNotEmpty(getEstructurasComOutput.getIcmListaestructura().getIcmListaestructuraRecordSet())) {
                List<EstructurasComResultItemDto> items = icmWsCalcIncomeMapper.asEstructurasComResultItemDtos(
                        getEstructurasComOutput.getIcmListaestructura().getIcmListaestructuraRecordSet());
                result.setData(items);
            }
        }

        return result;
    }
    
    @Override
    public EstructurasPolResponseDto getEstructurasPol(EstructurasPolRequestDto request) {
        EstructurasPolResponseDto result = new EstructurasPolResponseDto();
        IcmParamcalestructuraBlock param1 = icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(request.getData());
        GetestructuraspolOutput getEstructurasPolOutput = meta4ClientPool.getestructuraspol(param1);
        if (getEstructurasPolOutput != null
                && Double.compare(NumberUtils.DOUBLE_ZERO, getEstructurasPolOutput.getReturn()) == 0) {
            if (getEstructurasPolOutput.getIcmListapoliticas() != null && CollectionUtils
                    .isNotEmpty(getEstructurasPolOutput.getIcmListapoliticas().getIcmListapoliticasRecordSet())) {
                List<EstructurasPolResultItemDto> items = icmWsCalcIncomeMapper.asEstructurasPolResultItemDto(
                        getEstructurasPolOutput.getIcmListapoliticas().getIcmListapoliticasRecordSet());
                result.setData(items);
            }
        }

        return result;
    }

    @Override
    public EmpleadosResponseDto getEmpleados(EmpleadosRequestDto request) {
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
                    && CollectionUtils
                            .isNotEmpty(getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtos(
                        getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public ConfiguracionVentaOnlineResponseDto getConfVentaOnline(ConfiguracionVentaOnlineRequestDto request) {
        ConfiguracionVentaOnlineResponseDto result = new ConfiguracionVentaOnlineResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetconfventaonlineOutput getconfventaonline = meta4ClientPool.getconfventaonline(param1, param2);
        if (getconfventaonline != null) {
            if (getconfventaonline.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getconfventaonline.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getconfventaonline.getIcmListaconfiguracion() != null
                    && getconfventaonline.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet() != null) {
                List<ConfiguracionVentaOnlineResultItemDto> items = icmWsCalcIncomeMapper
                        .asConfiguracionVentaOnlineResultItemDto(
                                getconfventaonline.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public TiendaOnlineResponseDto getTiendasOnline(TiendaOnlineRequestDto request) {
        TiendaOnlineResponseDto result = new TiendaOnlineResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GettiendasonlineOutput gettiendasonline = meta4ClientPool.gettiendasonline(param2, param1);
        if (gettiendasonline != null) {
            if (gettiendasonline.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(gettiendasonline.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (gettiendasonline.getIcmListatiendas() != null
                    && gettiendasonline.getIcmListatiendas().getIcmListatiendasRecordSet() != null) {
                List<TiendaOnlineResultItemDto> items = icmWsCalcIncomeMapper.asTiendaOnlineResultItemDto(
                        gettiendasonline.getIcmListatiendas().getIcmListatiendasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public ConfiguracionProductoVentaResponseDto getConfiguracionProductoVenta(
            ConfiguracionProductoVentaRequestDto request) {
        ConfiguracionProductoVentaResponseDto result = new ConfiguracionProductoVentaResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetconfprodventaOutput getconfprodventaoutput = meta4ClientPool.getconfprodventa(param1, param2);
        if (getconfprodventaoutput != null) {
            if (getconfprodventaoutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getconfprodventaoutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getconfprodventaoutput.getIcmListaconfiguracion() != null
                    && getconfprodventaoutput.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet() != null) {
                List<ConfiguracionProductoVentaResultItemDto> items = icmWsCalcIncomeMapper
                        .asConfiguracionProductoVentaResultItemDto(
                                getconfprodventaoutput.getIcmListaconfiguracion().getIcmListaconfiguracionRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public CadenaResponseDto getCadena(CadenaRequestDto request) {
        CadenaResponseDto result = new CadenaResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetcadenaOutput getcadenaoutput = meta4ClientPool.getcadena(param1, param2);
        if (getcadenaoutput != null) {
            if (getcadenaoutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getcadenaoutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getcadenaoutput.getIcmListacadenas() != null
                    && getcadenaoutput.getIcmListacadenas().getIcmListacadenasRecordSet() != null) {
                List<CadenaResultItemDto> items = icmWsCalcIncomeMapper
                        .asCadenaResultItemDto(getcadenaoutput.getIcmListacadenas().getIcmListacadenasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public EmpresaResponseDto getEmpresa(EmpresaRequestDto request) {
        EmpresaResponseDto result = new EmpresaResponseDto();
        IcmParamcalorigenBlock param1 = icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetempresasOutput getempresasoutput = meta4ClientPool.getempresas(param1, param2);
        if (getempresasoutput != null) {
            if (getempresasoutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getempresasoutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getempresasoutput.getIcmListaempresas() != null
                    && getempresasoutput.getIcmListaempresas().getIcmListaempresasRecordSet() != null) {
                List<EmpresaResultItemDto> items = icmWsCalcIncomeMapper
                        .asEmpresaResultItemDto(getempresasoutput.getIcmListaempresas().getIcmListaempresasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public OrigenResponseDto getOrigen(OrigenRequestDto request) {
        OrigenResponseDto result = new OrigenResponseDto();
        IcmParamcalsociedadBlock param1 = icmWsCalcIncomeMapper.asIcmParamcalsociedadBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetorigenesOutput getorigenesoutput = meta4ClientPool.getorigenes(param1, param2);
        if (getorigenesoutput != null) {
            if (getorigenesoutput.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getorigenesoutput.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getorigenesoutput.getIcmListaorigenes() != null
                    && getorigenesoutput.getIcmListaorigenes().getIcmListaorigenesRecordSet() != null) {
                List<OrigenResultItemDto> items = icmWsCalcIncomeMapper
                        .asOrigenResultItemDto(getorigenesoutput.getIcmListaorigenes().getIcmListaorigenesRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public EmpleadosDesplazamientoResponseDto getEmpleadosDesplazamiento(EmpleadosDesplazamientoRequestDto request) {
        EmpleadosDesplazamientoResponseDto result = new EmpleadosDesplazamientoResponseDto();
        IcmParametrosentradaBlock param1 = icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetempleadosdesplazOutput getempldesplaz = meta4ClientPool.getempleadosdesplaz(param2, param1);
        if (getempldesplaz != null) {
            if (getempldesplaz.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getempldesplaz.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getempldesplaz.getIcmListaempleados() != null && CollectionUtils
                    .isNotEmpty(getempldesplaz.getIcmListaempleados().getIcmListaempleadosRecordSet())) {
                List<GenericEmpleadoResultItemDto> items = icmWsCalcIncomeMapper.asGenericEmpleadoResultItemDtos(
                        getempldesplaz.getIcmListaempleados().getIcmListaempleadosRecordSet());
                result.setData(items);
            }
        }
        return result;
    }
    
    @Override
    public AusenciasResponseDto getAusencias(AusenciasRequestDto request) {
        AusenciasResponseDto result = new AusenciasResponseDto();
        IcmParamcalempleadoBlock param1 = icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(request.getData());
        IcmParametrospaginacionBlock param2 = icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(request.getPage());
        GetausenciasOutput getausencias = meta4ClientPool.getausencias(param2, param1);
        if (getausencias != null) {
            if (getausencias.getIcmParametrospaginacion() != null) {
                PageDto page = icmWsCalcIncomeMapper.asPageDto(getausencias.getIcmParametrospaginacion());
                result.setPage(page);
            }
            if (getausencias.getIcmListaausencias() != null && CollectionUtils
                    .isNotEmpty(getausencias.getIcmListaausencias().getIcmListaausenciasRecordSet())) {
                List<AusenciasResultItemDto> items = icmWsCalcIncomeMapper.asAusenciasResultItemDtos(
                        getausencias.getIcmListaausencias().getIcmListaausenciasRecordSet());
                result.setData(items);
            }
        }
        return result;
    }

    @Override
    public SaveResultDto saveProceso(SaveProcesoDto request) {
        SaveprocesoOutput saveProcesoOutput = meta4ClientPool.saveproceso(icmWsCalcIncomeMapper.asIcmParamcalprocesoBlock(request));
        return icmWsCalcIncomeMapper.asSaveResultDto(saveProcesoOutput.getIcmResultadoguardado());
    }

    @Override
    public ConfiguracionesResponseDto getConfiguracion(ConfiguracionesRequestDto request) {
        GetconfiguracionOutput configuracionOutput = meta4ClientPool.getconfiguracion(icmWsCalcIncomeMapper.asIcmParamconfBlock(request));
        return icmWsCalcIncomeMapper.asConfiguracionesResponseDto(configuracionOutput, request.getIdOrigen());
    }
    
}
