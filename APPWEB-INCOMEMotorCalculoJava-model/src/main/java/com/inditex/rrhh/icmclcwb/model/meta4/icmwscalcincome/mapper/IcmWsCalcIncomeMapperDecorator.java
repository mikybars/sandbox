package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamconfBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoBlock;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaausenciasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;

public abstract class IcmWsCalcIncomeMapperDecorator implements IcmWsCalcIncomeMapper {

    @Autowired
    @Qualifier("delegate")
    private IcmWsCalcIncomeMapper delegate;

    @Override
    public IcmParametrosentradaBlock asIcmParametrosentradaBlock(GenericFilterDto src) {
        IcmParametrosentradaBlock result = delegate.asIcmParametrosentradaBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParametrosentradaRecordSet())) {
            result.getIcmParametrosentradaRecordSet().add(new IcmParametrosentradaRecord());
        }
        return result;
    }
    
    @Override
    public IcmParamcalempleadoBlock asIcmParamcalempleadoBlock(GenericFilterDto src) {
        IcmParamcalempleadoBlock result = delegate.asIcmParamcalempleadoBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParamcalempleadoRecordSet())) {
            result.getIcmParamcalempleadoRecordSet().add(new IcmParamcalempleadoRecord());
        }
        return result;
    }

    @Override
    public IcmParametrospaginacionBlock asIcmParametrospaginacionBlock(PageDto src) {
        IcmParametrospaginacionBlock result = delegate.asIcmParametrospaginacionBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParametrospaginacionRecordSet())) {
            result.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        }
        return result;
    }

    @Override
    public GenericTiendaResultItemDto asGenericTiendaResultItemDto(IcmListatiendasRecord src) {
        GenericTiendaResultItemDto mappedEntity = delegate.asGenericTiendaResultItemDto(src);
        mappedEntity.setEsComisionable(Meta4Constants.TRUE.equalsIgnoreCase(src.getEscomisionable().trim()));
        mappedEntity.setCalcula(Meta4Constants.TRUE.equalsIgnoreCase(src.getCalcula().trim()));
        
        if (StringUtils.isNotEmpty(src.getFechainicio())) {
            mappedEntity.setFechaInicio(LocalDateTime.parse(src.getFechainicio(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(src.getFechafin())) {
            mappedEntity.setFechaFin(LocalDateTime.parse(src.getFechafin(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        return mappedEntity;
    }

    @Override
    public List<GenericTiendaResultItemDto> asGenericTiendaResultItemDtos(List<IcmListatiendasRecord> src) {
        List<GenericTiendaResultItemDto> list = new ArrayList<>();
        for (IcmListatiendasRecord item : src) {
            GenericTiendaResultItemDto mappedEntity = delegate.asGenericTiendaResultItemDto(item);
            mappedEntity.setEsComisionable(Meta4Constants.TRUE.equalsIgnoreCase(item.getEscomisionable().trim()));
            mappedEntity.setCalcula(Meta4Constants.TRUE.equalsIgnoreCase(item.getCalcula().trim()));

            if (StringUtils.isNotEmpty(item.getFechainicio())) {
                mappedEntity.setFechaInicio(LocalDateTime.parse(item.getFechainicio(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            if (StringUtils.isNotEmpty(item.getFechafin())) {
                mappedEntity.setFechaFin(java.time.LocalDateTime.parse(item.getFechafin(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            list.add(mappedEntity);
        }
        return list;
    }

    @Override
    public GenericEmpleadoResultItemDto asGenericEmpleadoResultItemDto(IcmListaempleadosRecord src) {
        GenericEmpleadoResultItemDto mappedEntity = delegate.asGenericEmpleadoResultItemDto(src);
        if (StringUtils.isNotEmpty(src.getFechainicio())) {
            mappedEntity.setFechaInicio(LocalDateTime.parse(src.getFechainicio(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(src.getFechafin())) {
            mappedEntity.setFechaFin(LocalDateTime.parse(src.getFechafin(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(src.getFechainiciosec())) {
            mappedEntity.setFechaInicioSec(LocalDateTime.parse(src.getFechainiciosec(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(src.getFechafinsec())) {
            mappedEntity.setFechaFinSec(LocalDateTime.parse(src.getFechafinsec(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(src.getFechainiciocom())) {
            mappedEntity.setFechaInicioCom(LocalDateTime.parse(src.getFechainiciocom(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(src.getFechafincom())) {
            mappedEntity.setFechaFinCom(LocalDateTime.parse(src.getFechafincom(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(src.getFechafinpar())) {
            mappedEntity.setFechaFinPar(LocalDateTime.parse(src.getFechafinpar(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(src.getFechainiciopar())) {
            mappedEntity.setFechaInicioPar(LocalDateTime.parse(src.getFechainiciopar(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(src.getFecha())) {
            mappedEntity.setFecha(
                    LocalDateTime.parse(src.getFecha(), DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        return mappedEntity;
    }

    @Override
    public List<GenericEmpleadoResultItemDto> asGenericEmpleadoResultItemDtos(List<IcmListaempleadosRecord> src) {
        List<GenericEmpleadoResultItemDto> list = new ArrayList<>();
        for (IcmListaempleadosRecord item : src) {

            if (CollectionUtils.isNotEmpty(item.getIcmListasecciones().getIcmListaseccionesRecordSet())) {
                item.getIcmListasecciones().getIcmListaseccionesRecordSet().forEach(x -> {
                    GenericEmpleadoResultItemDto presencia = delegate.asGenericEmpleadoResultItemDto(item);
                    presencia.setIdSeccion(x.getIdseccion());
                    presencia.setMinutos(x.getMinutos());
                    setDates(item, presencia);
                    list.add(presencia);
                });
            } else {
                GenericEmpleadoResultItemDto mappedEntity = delegate.asGenericEmpleadoResultItemDto(item);
                setDates(item, mappedEntity);
                list.add(mappedEntity);
            }
        }
        return list;
    }
    
    @Override
    public List<AusenciasResultItemDto> asAusenciasResultItemDtos(List<IcmListaausenciasRecord> src){
        List<AusenciasResultItemDto> list = new ArrayList<>();
        for (IcmListaausenciasRecord item : src) {
            AusenciasResultItemDto mappedEntity = delegate.asAusenciasResultItemDto(item);
            if (StringUtils.isNotEmpty(item.getFechainicio())) {
                mappedEntity.setFechaInicio(LocalDateTime.parse(item.getFechainicio(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            if (StringUtils.isNotEmpty(item.getFechafin())) {
                mappedEntity.setFechaFin(java.time.LocalDateTime.parse(item.getFechafin(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            list.add(mappedEntity);
        }
        return list;
    }
    
    @Override
    public List<GenericEmpleadoResultItemDto> asGenericEmpleadoResultItemDtosSearchEmpleados(List<IcmListaempleadoRecord> src){
        List<GenericEmpleadoResultItemDto> list = new ArrayList<>();
        for (IcmListaempleadoRecord item : src) {
            GenericEmpleadoResultItemDto presencia = delegate.asGenericEmpleadoResultItemDtosSearchEmpleados(item);
            if (StringUtils.isNotEmpty(item.getFechainicio())) {
                presencia.setFechaInicio(LocalDateTime.parse(item.getFechainicio(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            if (StringUtils.isNotEmpty(item.getFechafin())) {
                presencia.setFechaFin(java.time.LocalDateTime.parse(item.getFechafin(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            if (StringUtils.isNotEmpty(item.getFechainiciosec())) {
                presencia.setFechaInicioSec(LocalDateTime.parse(item.getFechainiciosec(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            if (StringUtils.isNotEmpty(item.getFechafinsec())) {
                presencia.setFechaFinSec(LocalDateTime.parse(item.getFechafinsec(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            if (StringUtils.isNotEmpty(item.getFechainicioloc())) {
                presencia.setFechaInicioLoc(LocalDateTime.parse(item.getFechainicioloc(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            if (StringUtils.isNotEmpty(item.getFechafinloc())) {
                presencia.setFechaFinLoc(LocalDateTime.parse(item.getFechafinloc(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            if (StringUtils.isNotEmpty(item.getFechaantiguedad())) {
                presencia.setFechaAntiguedad(LocalDateTime.parse(item.getFechaantiguedad(),
                        DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
            }
            list.add(presencia);
        }
        return list;
    }


    private void setDates(IcmListaempleadosRecord item, GenericEmpleadoResultItemDto presencia) {
        if (StringUtils.isNotEmpty(item.getFechainicio())) {
            presencia.setFechaInicio(LocalDateTime.parse(item.getFechainicio(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(item.getFechafin())) {
            presencia.setFechaFin(java.time.LocalDateTime.parse(item.getFechafin(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(item.getFechainiciosec())) {
            presencia.setFechaInicioSec(LocalDateTime.parse(item.getFechainiciosec(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(item.getFechafinsec())) {
            presencia.setFechaFinSec(LocalDateTime.parse(item.getFechafinsec(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(item.getFechainiciocom())) {
            presencia.setFechaInicioCom(LocalDateTime.parse(item.getFechainiciocom(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(item.getFechafincom())) {
            presencia.setFechaFinCom(LocalDateTime.parse(item.getFechafincom(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(item.getFechafinpar())) {
            presencia.setFechaFinPar(LocalDateTime.parse(item.getFechafinpar(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(item.getFechainiciopar())) {
            presencia.setFechaInicioPar(LocalDateTime.parse(item.getFechainiciopar(),
                    DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
        if (StringUtils.isNotEmpty(item.getFecha())) {
            presencia.setFecha(
                    LocalDateTime.parse(item.getFecha(), DateTimeFormatter.ofPattern(Meta4Constants.META4_DATE_FULL)));
        }
    }

    @Override
    public List<TiendaOnlineResultItemDto> asTiendaOnlineResultItemDto(List<IcmListatiendasRecord> src) {
        List<TiendaOnlineResultItemDto> tiendas = new ArrayList<>();
        if (src != null) {
            src.forEach(x -> tiendas.add(asTiendaOnlineResultItemDto(x)));
        }
        return tiendas;
    }

    @Override
    public IcmParamcalprocesoBlock asIcmParamcalprocesoBlock(SaveProcesoDto src) {
        IcmParamcalprocesoBlock result = delegate.asIcmParamcalprocesoBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParamcalprocesoRecordSet())) {
            result.getIcmParamcalprocesoRecordSet().add(new IcmParamcalprocesoRecord());
        }
        return result;
    }

    @Override
    public SaveResultDto asSaveResultDto(IcmResultadoguardadoBlock src) {
        SaveResultDto result = delegate.asSaveResultDto(src);
        result.setResultadoOk(
            !src.getIcmResultadoguardadoRecordSet()
                .stream()
                .anyMatch(x -> !Meta4Constants.RESULTADO_OK.equals(x.getIcmAvisosguardado().getResultado())));
        result.setResultadoError(
            src.getIcmResultadoguardadoRecordSet()
                .stream()
                .anyMatch(x -> !Meta4Constants.RESULTADO_OK.equals(x.getIcmErroresguardado().getResultado())));
        return result;
    }

    @Override
    public ConfiguracionesResponseDto asConfiguracionesResponseDto(GetconfiguracionOutput src, String idOrigen) {
        ConfiguracionesResponseDto result = delegate.asConfiguracionesResponseDto(src, idOrigen);
        if (src.getIcmListaconf() != null && CollectionUtils.isNotEmpty(src.getIcmListaconf().getIcmListaconfRecordSet())) {
            ArrayList<ConfiguracionItemDto> items = new ArrayList<>();
            src.getIcmListaconf().getIcmListaconfRecordSet().forEach(x ->
                items.add(delegate.asConfiguracionItemDto(x, idOrigen)));
            result.setItems(items);
        }
        return result;
    }
}
