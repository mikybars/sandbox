package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaausenciasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfpreciohoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaldesplazrealBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaldesplazrealRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosdesplazBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosdesplazRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadospresenciaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadospresenciaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalflagcalculaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalflagcalculaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresenciamanualBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresenciamanualRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoBlock;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public abstract class IcmWsCalcIncomeMapperDecorator implements IcmWsCalcIncomeMapper {

    @Autowired
    @Qualifier("delegate")
    private IcmWsCalcIncomeMapper delegate;

    @Override
    public IcmParametrosentradaBlock asIcmParametrosentradaBlock(final GenericFilterDto src) {
        final IcmParametrosentradaBlock result = this.delegate.asIcmParametrosentradaBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParametrosentradaRecordSet())) {
            result.getIcmParametrosentradaRecordSet().add(new IcmParametrosentradaRecord());
        }
        return result;
    }

    @Override
    public IcmParametrospaginacionBlock asIcmParametrospaginacionBlock(final PageDto src) {
        final IcmParametrospaginacionBlock result = this.delegate.asIcmParametrospaginacionBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParametrospaginacionRecordSet())) {
            result.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
        }
        return result;
    }

    @Override
    public IcmParamcalconfchdiasBlock asIcmParamcalconfchdiasBlock(final ConfChDiasMinimosFilterDto src) {
        final IcmParamcalconfchdiasBlock result = this.delegate.asIcmParamcalconfchdiasBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParamcalconfchdiasRecordSet())) {
            result.getIcmParamcalconfchdiasRecordSet().add(new IcmParamcalconfchdiasRecord());
        }
        return result;
    }

    @Override
    public IcmParamcalconfpreciohoraBlock asIcmParamcalconfpreciohoraBlock(final ConfPrecioHoraFilterDto src) {
        final IcmParamcalconfpreciohoraBlock result = this.delegate.asIcmParamcalconfpreciohoraBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParamcalconfpreciohoraRecordSet())) {
            result.getIcmParamcalconfpreciohoraRecordSet().add(new IcmParamcalconfpreciohoraRecord());
        }
        return result;
    }

    @Override
    public IcmParamcalconfchventaBlock asIcmParamcalconfchventaBlock(final ConfChTpVentaFilterDto src) {
        final IcmParamcalconfchventaBlock result = this.delegate.asIcmParamcalconfchventaBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParamcalconfchventaRecordSet())) {
            result.getIcmParamcalconfchventaRecordSet().add(new IcmParamcalconfchventaRecord());
        }
        return result;
    }

    @Override
    public IcmParamcalpresupuestosrangoBlock asIcmParamcalpresupuestosrangoBlock(final PresupuestosRangoFilterDto src) {
        final IcmParamcalpresupuestosrangoBlock result = this.delegate.asIcmParamcalpresupuestosrangoBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParamcalpresupuestosrangoRecordSet())) {
            result.getIcmParamcalpresupuestosrangoRecordSet().add(new IcmParamcalpresupuestosrangoRecord());
        }
        return result;
    }

    @Override
    public GenericTiendaResultItemDto asGenericTiendaResultItemDto(final IcmListatiendasRecord src) {
        final GenericTiendaResultItemDto mappedEntity = this.delegate.asGenericTiendaResultItemDto(src);
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
    public List<ConfPrecioHoraResultItemDto> asConfPrecioHoraResultItemDto(
            final List<IcmListaconfpreciohoraRecord> src) {
        final List<ConfPrecioHoraResultItemDto> list = new ArrayList<>();
        for (final IcmListaconfpreciohoraRecord item : src) {
            final ConfPrecioHoraResultItemDto mappedEntity = this.delegate.asConfPrecioHoraResultItemDto(item);
            mappedEntity.setIdTipoHoraComis(Meta4Constants.TRUE.equalsIgnoreCase(item.getTipohoracomis().trim()));
            mappedEntity.setIdTipoHoraIncptpo(Meta4Constants.TRUE.equalsIgnoreCase(item.getTipohoraincptpo().trim()));
            list.add(mappedEntity);

        }
        return list;
    }

    @Override
    public List<GenericTiendaResultItemDto> asGenericTiendaResultItemDtos(final List<IcmListatiendasRecord> src) {
        final List<GenericTiendaResultItemDto> list = new ArrayList<>();
        for (final IcmListatiendasRecord item : src) {
            final GenericTiendaResultItemDto mappedEntity = this.delegate.asGenericTiendaResultItemDto(item);
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
    public GenericEmpleadoResultItemDto asGenericEmpleadoResultItemDto(final IcmListaempleadosRecord src) {
        final GenericEmpleadoResultItemDto mappedEntity = this.delegate.asGenericEmpleadoResultItemDto(src);
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
    public List<GenericEmpleadoResultItemDto> asGenericEmpleadoResultItemDtos(final List<IcmListaempleadosRecord> src) {
        final List<GenericEmpleadoResultItemDto> list = new ArrayList<>();
        for (final IcmListaempleadosRecord item : src) {

            if (CollectionUtils.isNotEmpty(item.getIcmListasecciones().getIcmListaseccionesRecordSet())) {
                item.getIcmListasecciones().getIcmListaseccionesRecordSet().forEach(x -> {
                    final GenericEmpleadoResultItemDto presencia = this.delegate.asGenericEmpleadoResultItemDto(item);
                    presencia.setIdSeccion(x.getIdseccion());
                    presencia.setMinutos(x.getMinutos());
                    this.setDates(item, presencia);
                    list.add(presencia);
                });
            } else {
                final GenericEmpleadoResultItemDto mappedEntity = this.delegate.asGenericEmpleadoResultItemDto(item);
                this.setDates(item, mappedEntity);
                list.add(mappedEntity);
            }
        }
        return list;
    }

    @Override
    public List<AusenciasResultItemDto> asAusenciasResultItemDtos(final List<IcmListaausenciasRecord> src) {
        final List<AusenciasResultItemDto> list = new ArrayList<>();
        for (final IcmListaausenciasRecord item : src) {
            final AusenciasResultItemDto mappedEntity = this.delegate.asAusenciasResultItemDto(item);
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
    public List<GenericEmpleadoResultItemDto> asGenericEmpleadoResultItemDtosSearchEmpleados(
            final List<IcmListaempleadoRecord> src) {
        final List<GenericEmpleadoResultItemDto> list = new ArrayList<>();
        for (final IcmListaempleadoRecord item : src) {
            final GenericEmpleadoResultItemDto presencia = this.delegate
                .asGenericEmpleadoResultItemDtosSearchEmpleados(item);
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


    private void setDates(final IcmListaempleadosRecord item, final GenericEmpleadoResultItemDto presencia) {
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
    public List<TiendaOnlineResultItemDto> asTiendaOnlineResultItemDto(final List<IcmListatiendasRecord> src) {
        final List<TiendaOnlineResultItemDto> tiendas = new ArrayList<>();
        if (src != null) {
            src.forEach(x -> tiendas.add(this.asTiendaOnlineResultItemDto(x)));
        }
        return tiendas;
    }

    @Override
    public IcmParamcalprocesoBlock asIcmParamcalprocesoBlock(final SaveProcesoDto src) {
        final IcmParamcalprocesoBlock result = this.delegate.asIcmParamcalprocesoBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParamcalprocesoRecordSet())) {
            result.getIcmParamcalprocesoRecordSet().add(new IcmParamcalprocesoRecord());
        }
        return result;
    }

    @Override
    public SaveResultDto asSaveResultDto(final IcmResultadoguardadoBlock src) {
        final SaveResultDto result = this.delegate.asSaveResultDto(src);
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
    public IcmParamcalconforigenBlock asIcmParamconfBlock(final ConfiguracionesRequestDto src) {
        final IcmParamcalconforigenBlock result = this.delegate.asIcmParamconfBlock(src);
        if (CollectionUtils.isEmpty(result.getIcmParamcalconforigenRecordSet())) {
            result.getIcmParamcalconforigenRecordSet().add(new IcmParamcalconforigenRecord());
        }
        return result;
    }

    @Override
    public ConfiguracionesResponseDto asConfiguracionesResponseDto(final GetconfiguracionOutput src,
            final String idOrigen) {
        final ConfiguracionesResponseDto result = this.delegate.asConfiguracionesResponseDto(src, idOrigen);
        if ((src.getIcmListaconforigen() != null)
                && CollectionUtils.isNotEmpty(src.getIcmListaconforigen().getIcmListaconforigenRecordSet())) {
            final ArrayList<ConfiguracionItemDto> items = new ArrayList<>();
            src.getIcmListaconforigen()
                .getIcmListaconforigenRecordSet()
                .forEach(x -> {
                    final ConfiguracionItemDto mappedEntity = this.delegate.asConfiguracionItemDto(x, idOrigen);
                    mappedEntity
                        .setIcmCkIncIvaEvalPtpo(Meta4Constants.TRUE.equalsIgnoreCase(x.getChkevalpres().trim()));
                    mappedEntity
                        .setIcmCkVentaImpuestos(Meta4Constants.TRUE.equalsIgnoreCase(x.getChkventaimpuestos().trim()));
                    items.add(mappedEntity);
                });
            result.setItems(items);
        }
        return result;
    }

    @Override
    public IcmParamcalcadenaBlock asIcmParamcalcadenaBlock(final GenericFilterDto src) {
        final List<IcmParamcalcadenaRecord> list = this.asIcmParamcalcadenaRecordList(src);
        final IcmParamcalcadenaBlock result = new IcmParamcalcadenaBlock();
        result.getIcmParamcalcadenaRecordSet().addAll(list);
        return result;
    }


    private List<IcmParamcalcadenaRecord> asIcmParamcalcadenaRecordList(final GenericFilterDto src) {
        final List<IcmParamcalcadenaRecord> result = new ArrayList<>();
        if (src != null) {
            src.getIdsEmpresa().forEach(empresa -> {
                if (CollectionUtils.isNotEmpty(src.getItem())) {
                    src.getItem().forEach(x -> {
                        final IcmParamcalcadenaRecord record = this.delegate.asIcmParamcalcadenaRecord(src);
                        record.setIdempresa(empresa);
                        result.add(record);
                    });
                } else {
                    final IcmParamcalcadenaRecord record = this.delegate.asIcmParamcalcadenaRecord(src);
                    record.setIdempresa(empresa);
                    result.add(record);
                }
            });
        }
        return result;
    }

    @Override
    public IcmParamcalempleadosdesplazBlock asIcmParamcalempleadosdesplazBlock(final GenericFilterDto src) {
        final List<IcmParamcalempleadosdesplazRecord> list = this.asIcmParamcalempleadosdesplazRecordList(src);
        final IcmParamcalempleadosdesplazBlock result = new IcmParamcalempleadosdesplazBlock();
        result.getIcmParamcalempleadosdesplazRecordSet().addAll(list);
        return result;
    }

    private List<IcmParamcalempleadosdesplazRecord> asIcmParamcalempleadosdesplazRecordList(
            final GenericFilterDto src) {
        final List<IcmParamcalempleadosdesplazRecord> result = new ArrayList<>();
        if (src != null) {
            src.getIdsEmpresa().forEach(empresa -> {
                final IcmParamcalempleadosdesplazRecord record = this.delegate.asIcmParamcalempleadosdesplazRecord(src);
                record.setIdempresa(empresa);
                result.add(record);
            });
        }
        return result;
    }

    @Override
    public IcmParamcalempleadospresenciaBlock asIcmParamcalempleadospresenciaBlock(final GenericFilterDto src) {
        final List<IcmParamcalempleadospresenciaRecord> list = this.asIcmParamcalempleadospresenciaRecordList(src);
        final IcmParamcalempleadospresenciaBlock result = new IcmParamcalempleadospresenciaBlock();
        result.getIcmParamcalempleadospresenciaRecordSet().addAll(list);
        return result;
    }

    private List<IcmParamcalempleadospresenciaRecord> asIcmParamcalempleadospresenciaRecordList(
            final GenericFilterDto src) {
        final List<IcmParamcalempleadospresenciaRecord> result = new ArrayList<>();
        if (src != null) {
            src.getIdsEmpresa().forEach(empresa -> {
                final IcmParamcalempleadospresenciaRecord record = this.delegate
                    .asIcmParamcalempleadospresenciaRecord(src);
                record.setIdempresa(empresa);
                result.add(record);
            });
        }
        return result;
    }

    @Override
    public IcmParamcaltiendasBlock asIcmParamcaltiendasBlock(final GenericFilterDto src) {
        final List<IcmParamcaltiendasRecord> list = this.asIcmParamcaltiendasRecordList(src);
        final IcmParamcaltiendasBlock result = new IcmParamcaltiendasBlock();
        result.getIcmParamcaltiendasRecordSet().addAll(list);
        return result;
    }

    private List<IcmParamcaltiendasRecord> asIcmParamcaltiendasRecordList(final GenericFilterDto src) {
        final List<IcmParamcaltiendasRecord> result = new ArrayList<>();
        if (src != null) {
            src.getIdsEmpresa().forEach(empresa -> {
                final IcmParamcaltiendasRecord record = this.delegate.asIcmParamcaltiendasRecord(src);
                record.setIdempresa(empresa);
                result.add(record);
            });
        }
        return result;
    }

    @Override
    public IcmParamcalempleadoBlock asIcmParamcalempleadoBlock(final GenericFilterDto src) {
        final List<IcmParamcalempleadoRecord> list = this.asIcmParamcalempleadoRecordList(src);
        final IcmParamcalempleadoBlock result = this.delegate.asIcmParamcalempleadoBlock(src);
        result.getIcmParamcalempleadoRecordSet().addAll(list);
        return result;
    }

    private List<IcmParamcalempleadoRecord> asIcmParamcalempleadoRecordList(final GenericFilterDto src) {
        final List<IcmParamcalempleadoRecord> result = new ArrayList<>();
        if (src != null) {
            src.getIdsEmpresa().forEach(empresa -> {
                final IcmParamcalempleadoRecord record = this.delegate.asIcmParamcalempleadoRecord(src);
                record.setIdempresa(empresa);
                result.add(record);
            });
        }
        return result;
    }

    @Override
    public IcmParamcalempleadosBlock asIcmParamcalempleadosBlock(final GenericFilterDto src) {
        final List<IcmParamcalempleadosRecord> list = this.asIcmParamcalempleadosRecordList(src);
        final IcmParamcalempleadosBlock result = new IcmParamcalempleadosBlock();
        result.getIcmParamcalempleadosRecordSet().addAll(list);
        return result;
    }

    private List<IcmParamcalempleadosRecord> asIcmParamcalempleadosRecordList(final GenericFilterDto src) {
        final List<IcmParamcalempleadosRecord> result = new ArrayList<>();
        if (src != null) {
            src.getIdsEmpresa().forEach(empresa -> {
                if (CollectionUtils.isNotEmpty(src.getItem())) {
                    src.getItem().forEach(x -> {
                        final IcmParamcalempleadosRecord record = this.delegate.asIcmParamcalempleadosRecord(src);
                        record.setIdempleado(x.getIdEmpleado());
                        record.setIdempleadolocal(x.getIdEmpleadoLocal());
                        record.setIdlugartrabajo(x.getIdLugarTrabajo());
                        record.setIdlugartrabajomtu(x.getIdLugarTrabajoMtu());
                        record.setIdempresa(empresa);
                    });
                } else {
                    final IcmParamcalempleadosRecord record = this.delegate.asIcmParamcalempleadosRecord(src);
                    record.setIdempresa(empresa);
                    result.add(record);
                }
            });
        }
        return result;
    }

    @Override
    public IcmParamcaldesplazrealBlock asIcmParamcaldesplazrealBlock(final DesplazamientoRealFilterDto src) {
        final List<IcmParamcaldesplazrealRecord> list = this.asIcmParamcaldesplazrealRecordList(src);
        final IcmParamcaldesplazrealBlock result = new IcmParamcaldesplazrealBlock();
        result.getIcmParamcaldesplazrealRecordSet().addAll(list);
        return result;
    }

    private List<IcmParamcaldesplazrealRecord> asIcmParamcaldesplazrealRecordList(
            final DesplazamientoRealFilterDto src) {
        final List<IcmParamcaldesplazrealRecord> result = new ArrayList<>();
        if (src != null) {
            if (CollectionUtils.isNotEmpty(src.getItem())) {
                src.getItem().forEach(x -> {
                    final IcmParamcaldesplazrealRecord record = this.delegate.asIcmParamcaldesplazrealRecord(x);
                    result.add(record);
                });
            } else {
                result.add(new IcmParamcaldesplazrealRecord());
            }
        }
        return result;
    }

    @Override
    public IcmParamcalpresupuestoswlocBlock asIcmParamcalpresupuestoswlocBlock(final PresupuestosWlocFilterDto src) {
        final List<IcmParamcalpresupuestoswlocRecord> list = this.asIcmParamcalpresupuestoswlocRecordList(src);
        final IcmParamcalpresupuestoswlocBlock result = this.delegate.asIcmParamcalpresupuestoswlocBlock(src);
        result.getIcmParamcalpresupuestoswlocRecordSet().addAll(list);
        return result;
    }

    private List<IcmParamcalpresupuestoswlocRecord> asIcmParamcalpresupuestoswlocRecordList(
            final PresupuestosWlocFilterDto src) {
        final List<IcmParamcalpresupuestoswlocRecord> result = new ArrayList<>();
        if (src != null) {
            if (CollectionUtils.isNotEmpty(src.getItem())) {
                src.getItem().forEach(x -> {
                    final IcmParamcalpresupuestoswlocRecord record = this.delegate
                        .asIcmParamcalpresupuestoswlocRecord(x);
                    result.add(record);
                });
            } else {
                result.add(new IcmParamcalpresupuestoswlocRecord());
            }
        }
        return result;
    }

    @Override
    public IcmParamcalflagcalculaBlock asIcmParamcalflagcalculaBlock(final GenericFilterDto src) {
        final List<IcmParamcalflagcalculaRecord> list = this.asIcmParamcalflagcalculaRecordList(src);
        final IcmParamcalflagcalculaBlock result = this.delegate.asIcmParamcalflagcalculaBlock(src);
        result.getIcmParamcalflagcalculaRecordSet().addAll(list);
        return result;
    }

    private List<IcmParamcalflagcalculaRecord> asIcmParamcalflagcalculaRecordList(final GenericFilterDto src) {
        final List<IcmParamcalflagcalculaRecord> result = new ArrayList<>();
        if (src != null) {
            src.getItem().forEach(item -> {
                final IcmParamcalflagcalculaRecord record = this.delegate.asIcmParamcalflagcalculaRecord(src);
                record.setIdlugartrabajo(item.getIdLugarTrabajo());
                result.add(record);
            });
        } else {
            result.add(new IcmParamcalflagcalculaRecord());
        }
        return result;
    }

    @Override
    public IcmParamcalpresenciamanualBlock asIcmParamcalpresenciamanualBlock(final GenericFilterDto src) {
        final List<IcmParamcalpresenciamanualRecord> list = this.asIcmParamcalpresenciamanualRecordList(src);
        final IcmParamcalpresenciamanualBlock result = this.delegate.asIcmParamcalpresenciamanualBlock(src);
        result.getIcmParamcalpresenciamanualRecordSet().addAll(list);
        return result;
    }

    private List<IcmParamcalpresenciamanualRecord> asIcmParamcalpresenciamanualRecordList(final GenericFilterDto src) {
        final List<IcmParamcalpresenciamanualRecord> result = new ArrayList<>();
        if (src != null) {
            src.getItem().forEach(item -> {
                final IcmParamcalpresenciamanualRecord record = this.delegate.asIcmParamcalpresenciamanualRecord(src);
                record.setIdlugartrabajo(item.getIdLugarTrabajo());
                result.add(record);
            });
        } else {
            result.add(new IcmParamcalpresenciamanualRecord());
        }
        return result;
    }

}
