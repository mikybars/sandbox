package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaCondicionesDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.AvisosGuardadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.AvisosGuardadoResultItemParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.ErorresGuardadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.ErroresGuardadoResultItemParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcatalogoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetclasesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetmailOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetsistdestinoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiposhoraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaausenciasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaclasesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionesbaseRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionesdestinoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfpreciohoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresenciamanwlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaventamanwlocRecord;
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
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalliquidacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalliquidacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalplanificadorBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalplanificadorRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresenciamanualBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresenciamanualRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsincroBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsincroRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsistdestinoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsistdestinoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiposhoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiposhoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalusuarioBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalusuarioRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoRecord;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
            mappedEntity
                .setIcmCkRedJornada(Meta4Constants.TRUE.equalsIgnoreCase(x.getChkredjornada().trim()));
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

  @Override
  public IcmParamcaltiendasBlock asIcmParamcaltiendasBlock(final SearchTiendasFilterDto src) {
    final List<IcmParamcaltiendasRecord> list = this.asIcmParamcaltiendasRecordList(src);
    final IcmParamcaltiendasBlock result = new IcmParamcaltiendasBlock();
    result.getIcmParamcaltiendasRecordSet().addAll(list);
    return result;
  }

  @Override
  public IcmParamcaltiendasBlock asIcmParamcaltiendasBlock(final PresenciaManualWlocFilterDto src) {
    final List<IcmParamcaltiendasRecord> list = this.asIcmParamcaltiendasRecordList(src);
    final IcmParamcaltiendasBlock result = new IcmParamcaltiendasBlock();
    result.getIcmParamcaltiendasRecordSet().addAll(list);
    return result;
  }

  @Override
  public IcmParamcaltiendasBlock asIcmParamcaltiendasBlock(final VentaManualWlocFilterDto src) {
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

  private List<IcmParamcaltiendasRecord> asIcmParamcaltiendasRecordList(final SearchTiendasFilterDto src) {
    final List<IcmParamcaltiendasRecord> result = new ArrayList<>();
    if (src != null) {
      if (CollectionUtils.isNotEmpty(src.getIdsEmpresa())) {
        src.getIdsEmpresa().forEach(empresa -> {
          final IcmParamcaltiendasRecord record = this.delegate.asIcmParamcaltiendasRecord(src);
          record.setIdempresa(empresa);
          result.add(record);
        });
      }
      if (CollectionUtils.isNotEmpty(src.getIdsCadena())) {
        src.getIdsCadena().forEach(cadena -> {
          final IcmParamcaltiendasRecord record = this.delegate.asIcmParamcaltiendasRecord(src);
          record.setIdcadena(cadena);
          result.add(record);
        });
      }

    }
    return result;
  }

  private List<IcmParamcaltiendasRecord> asIcmParamcaltiendasRecordList(final PresenciaManualWlocFilterDto src) {
    final List<IcmParamcaltiendasRecord> result = new ArrayList<>();
    if (src != null) {
      src.getItem().forEach(item -> {
        final IcmParamcaltiendasRecord record = this.delegate.asIcmParamcaltiendasRecord(src);
        record.setIdempresa(item.getIdEmpresa());
        record.setIdorigen(src.getIdOrigen());
        record.setIdlugartrabajo(item.getIdLugarTrabajo());
        record.setIdlugartrabajomtu(item.getIdLugarTrabajoMtu());
        result.add(record);
      });
    }
    return result;
  }

  private List<IcmParamcaltiendasRecord> asIcmParamcaltiendasRecordList(final VentaManualWlocFilterDto src) {
    final List<IcmParamcaltiendasRecord> result = new ArrayList<>();
    if (src != null) {
      src.getItem().forEach(item -> {
        final IcmParamcaltiendasRecord record = this.delegate.asIcmParamcaltiendasRecord(src);
        record.setIdempresa(item.getIdEmpresa());
        record.setIdlugartrabajo(item.getIdLugarTrabajo());
        record.setIdlugartrabajomtu(item.getIdLugarTrabajoMtu());
        result.add(record);
      });
    }
    return result;
  }

  @Override
  public IcmParamcalempleadoBlock asIcmParamcalempleadoBlock(final SearchEmpleadosFilterDto src) {
    final List<IcmParamcalempleadoRecord> list = this.asIcmParamcalempleadosRecordList(src);
    final IcmParamcalempleadoBlock result = this.delegate.asIcmParamcalempleadoBlock(src);
    result.getIcmParamcalempleadoRecordSet().addAll(list);
    return result;
  }

  @Override
  public IcmParamcalempleadoBlock asIcmParamcalempleadoBlock(final GenericFilterDto src) {
    final List<IcmParamcalempleadoRecord> list = this.asIcmParamcalempleadoRecordList(src);
    final IcmParamcalempleadoBlock result = this.delegate.asIcmParamcalempleadoBlock(src);
    result.getIcmParamcalempleadoRecordSet().addAll(list);
    return result;
  }

  private List<IcmParamcalempleadoRecord> asIcmParamcalempleadosRecordList(final SearchEmpleadosFilterDto src) {
    final List<IcmParamcalempleadoRecord> result = new ArrayList<>();
    if (src != null) {
      if (CollectionUtils.isNotEmpty(src.getIdsEmpresa())) {
        src.getIdsEmpresa().forEach(empresa -> {
          final IcmParamcalempleadoRecord record = this.delegate.asIcmParamcalempleadoRecord(src);
          record.setIdempresa(empresa);
          result.add(record);
        });
      }
      if (CollectionUtils.isNotEmpty(src.getIdsCadena())) {
        src.getIdsCadena().forEach(cadena -> {
          final IcmParamcalempleadoRecord record = this.delegate.asIcmParamcalempleadoRecord(src);
          record.setIdcadena(cadena);
          result.add(record);
        });
      }

    }
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

  @Override
  public List<PresenciaManualWlocResultItemDto> asPresenciaManualWlocResultItemDto(
      final List<IcmListapresenciamanwlocRecord> src) {
    final List<PresenciaManualWlocResultItemDto> list = new ArrayList<>();
    for (final IcmListapresenciamanwlocRecord item : src) {

      if (CollectionUtils
          .isNotEmpty(item.getIcmListaseccionespresencias().getIcmListaseccionespresenciasRecordSet())) {
        item.getIcmListaseccionespresencias().getIcmListaseccionespresenciasRecordSet().forEach(x -> {
          final PresenciaManualWlocResultItemDto presencia = this.delegate
              .asPresenciaManualWlocResultItemDto(item);
          presencia.setIdSeccion(x.getIdseccion());
          presencia.setMinutos(x.getMinutos());
          list.add(presencia);
        });
      } else {
        final PresenciaManualWlocResultItemDto mappedEntity = this.delegate
            .asPresenciaManualWlocResultItemDto(item);
        list.add(mappedEntity);
      }
    }
    return list;
  }

  @Override
  public List<VentaManualWlocResultItemDto> asVentaManualWlocResultItemDto(
      final List<IcmListaventamanwlocRecord> src) {
    final List<VentaManualWlocResultItemDto> list = new ArrayList<>();
    for (final IcmListaventamanwlocRecord item : src) {

      if (CollectionUtils
          .isNotEmpty(item.getIcmListaseccionesventa().getIcmListaseccionesventaRecordSet())) {
        item.getIcmListaseccionesventa().getIcmListaseccionesventaRecordSet().forEach(x -> {
          final VentaManualWlocResultItemDto venta = this.delegate
              .asVentaManualWlocResultItemDto(item);
          venta.setIdSeccion(x.getIdseccion());
          venta.setImporte(x.getImporte());
          list.add(venta);
        });
      } else {
        final VentaManualWlocResultItemDto mappedEntity = this.delegate
            .asVentaManualWlocResultItemDto(item);
        list.add(mappedEntity);
      }
    }
    return list;
  }

  @Override
  public IcmParamcalsincroBlock asIcmParamcalsincroBlock(final SincronizacionFilterDto src) {
    final List<IcmParamcalsincroRecord> list = this.asIcmParamcalsincroRecordList(src);
    final IcmParamcalsincroBlock result = new IcmParamcalsincroBlock();
    result.getIcmParamcalsincroRecordSet().addAll(list);
    return result;
  }

  private List<IcmParamcalsincroRecord> asIcmParamcalsincroRecordList(final SincronizacionFilterDto src) {
    final List<IcmParamcalsincroRecord> result = new ArrayList<>();
    if (src != null) {
      src.getItems().forEach(item -> {
        final IcmParamcalsincroRecord record = this.delegate.asIcmParamcalsincroRecord(item);
        record.setIdempleado(item.getIdEmpleado());
        record.setIdorigen(item.getIdOrigen());
        result.add(record);
      });
    }
    return result;
  }

  @Override
  public IcmParamcalsistdestinoBlock asIcmParamcalsistdestinoBlock(
      final SistemaDestinoRequestDto src) {
    final IcmParamcalsistdestinoBlock result = this.delegate.asIcmParamcalsistdestinoBlock(src);
    result.getIcmParamcalsistdestinoRecordSet().add(new IcmParamcalsistdestinoRecord());
    return result;
  }

  @Override
  public SistemaDestinoResponseDto asSistemaDestinoResponseDto(
      final GetsistdestinoOutput src) {
    final SistemaDestinoResponseDto result = this.delegate.asSistemaDestinoResponseDto(src);
    if ((src.getIcmListasistdestino() != null)
        && CollectionUtils.isNotEmpty(src.getIcmListasistdestino().getIcmListasistdestinoRecordSet())) {
      result.setIdSistemaDestino(
          src.getIcmListasistdestino().getIcmListasistdestinoRecordSet().get(0).getIdsistema());
    }
    return result;
  }

  @Override
  public CatalogoResponseDto asCatalogoResponseDto(
      final GetcatalogoOutput src) {
    final CatalogoResponseDto result = this.delegate.asCatalogoResponseDto(src);
    if ((src.getIcmListacatalogo() != null)
        && CollectionUtils.isNotEmpty(src.getIcmListacatalogo().getIcmListacatalogoRecordSet())) {
      result.setItems(src.getIcmListacatalogo()
          .getIcmListacatalogoRecordSet()
          .stream()
          .map(record -> this.delegate.asCatalogoResponseItemDto(record))
          .collect(Collectors.toList()));
    }
    return result;
  }

  @Override
  public ListaCondicionesBaseResultItemDto asListaCondicionesBaseResultItemDto(
      final IcmListacondicionesbaseRecord src) {

    final ListaCondicionesBaseResultItemDto condiciones = this.delegate
        .asListaCondicionesBaseResultItemDto(src);
    if ((src.getIcmListavaloresbaseman() != null)
        &&
        CollectionUtils.isNotEmpty(src.getIcmListavaloresbaseman().getIcmListavaloresbasemanRecordSet())) {
      condiciones.getIcmListaValoresBase()
          .addAll(this.delegate
              .asListaValoresBaseResultItemDtoFromIcmListavaloresbasemanRecord(
                  src.getIcmListavaloresbaseman().getIcmListavaloresbasemanRecordSet()));
    }
    return condiciones;

  }

  @Override
  public List<ListaCondicionesBaseResultItemDto> asListaCondicionesBaseResultItemDto(
      final List<IcmListacondicionesbaseRecord> src) {
    final List<ListaCondicionesBaseResultItemDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(x -> result.add(this.asListaCondicionesBaseResultItemDto(x)));
    }
    return result;
  }

  @Override
  public ListaCondicionesDestinoResultItemDto asListaCondicionesDestinoResultItemDto(
      final IcmListacondicionesdestinoRecord src) {

    final ListaCondicionesDestinoResultItemDto condiciones = this.delegate
        .asListaCondicionesDestinoResultItemDto(src);
    if ((src.getIcmListavaloresdestinoman() != null)
        &&
        CollectionUtils
            .isNotEmpty(src.getIcmListavaloresdestinoman().getIcmListavaloresdestinomanRecordSet())) {
      condiciones.getIcmListaValoresDestino()
          .addAll(this.delegate.asListaValoresDestinoResultItemDtoFromIcmListavaloresdestinomanRecord(
              src.getIcmListavaloresdestinoman().getIcmListavaloresdestinomanRecordSet()));
    }
    return condiciones;

  }

  @Override
  public List<ListaCondicionesDestinoResultItemDto> asListaCondicionesDestinoResultItemDto(
      final List<IcmListacondicionesdestinoRecord> src) {
    final List<ListaCondicionesDestinoResultItemDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(x -> result.add(this.asListaCondicionesDestinoResultItemDto(x)));
    }
    return result;
  }

  @Override
  public EstructurasComResultItemDto asEstructurasComResultItemDto(final IcmListaestructuraRecord src) {
    final EstructurasComResultItemDto result = this.delegate.asEstructurasComResultItemDto(src);
    result.setIcmListaCondicionesBase(this.asListaCondicionesBaseResultItemDto(
        src.getIcmListacondicionesbase().getIcmListacondicionesbaseRecordSet()));
    result.setIcmListaCondicionesDestino(this.asListaCondicionesDestinoResultItemDto(
        src.getIcmListacondicionesdestino().getIcmListacondicionesdestinoRecordSet()));
    return result;
  }

  @Override
  public List<EstructurasComResultItemDto> asEstructurasComResultItemDtos(final List<IcmListaestructuraRecord> src) {
    final List<EstructurasComResultItemDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(x -> result.add(this.asEstructurasComResultItemDto(x)));
    }
    return result;
  }

  @Override
  public IcmParamcaltiposhoraBlock asIcmParamcaltiposhoraBlock(
      final TiposHoraRequestDto request) {
    final IcmParamcaltiposhoraBlock result = this.delegate.asIcmParamcaltiposhoraBlock(request);
    if (CollectionUtils.isNotEmpty(request.getIdsEmpresa())) {
      result.getIcmParamcaltiposhoraRecordSet().addAll(request.getIdsEmpresa().stream().map(empresa -> {
        final IcmParamcaltiposhoraRecord record = new IcmParamcaltiposhoraRecord();
        record.setIdempresa(empresa);
        return record;
      }).collect(Collectors.toList()));
    } else {
      result.getIcmParamcaltiposhoraRecordSet().add(new IcmParamcaltiposhoraRecord());
    }
    return result;
  }

  @Override
  public TiposHoraResponseDto asTiposHoraResponseDto(
      final GettiposhoraOutput tiposhora) {
    final TiposHoraResponseDto result = this.delegate.asTiposHoraResponseDto(tiposhora);
    final List<TiposHoraResultItemDto> items = new ArrayList<>();
    if (tiposhora.getIcmListatiposhora() != null
        && CollectionUtils.isNotEmpty(tiposhora.getIcmListatiposhora().getIcmListatiposhoraRecordSet())) {
      tiposhora.getIcmListatiposhora()
          .getIcmListatiposhoraRecordSet()
          .forEach(x -> items.add(this.delegate.asTiposHoraResultItemDto(x)));
    }
    result.setItems(items);
    return result;
  }

  @Override
  public IcmParamcalusuarioBlock asIcmParamcalusuarioBlock(
      final UsuarioRequestDto request) {
    final IcmParamcalusuarioBlock result = this.delegate.asIcmParamcalusuarioBlock(request);
    if (StringUtils.isNotEmpty(request.getIdUsuario())) {
      final IcmParamcalusuarioRecord record = new IcmParamcalusuarioRecord();
      record.setIdusuario(request.getIdUsuario());
      result.getIcmParamcalusuarioRecordSet().add(record);
    } else {
      result.getIcmParamcalusuarioRecordSet().add(new IcmParamcalusuarioRecord());
    }
    return result;
  }

  @Override
  public UsuarioResponseDto asUsuarioResponseDto(final GetmailOutput src) {
    final UsuarioResponseDto result = this.delegate.asUsuarioResponseDto(src);
    final List<UsuarioResultItemDto> items = new ArrayList<>();
    if (src.getIcmListamail() != null
        && CollectionUtils.isNotEmpty(src.getIcmListamail().getIcmListamailRecordSet())) {
      src.getIcmListamail()
          .getIcmListamailRecordSet()
          .forEach(x -> items.add(this.delegate.asUsuarioResultItemDto(x)));
    }
    result.setItems(items);
    return result;
  }

  @Override
  public IcmParamcalorigenBlock asIcmParamcalorigenBlock(
      final ClaseRequestDto src) {
    final IcmParamcalorigenBlock result = this.delegate.asIcmParamcalorigenBlock(src);
    result.getIcmParamcalorigenRecordSet().add(this.delegate.asIcmParamcalorigenRecord(src));
    return result;
  }

  @Override
  public ClaseResponseDto asClaseResponseDto(
      final GetclasesOutput src) {
    final ClaseResponseDto result = this.delegate.asClaseResponseDto(src);
    final List<ClaseResultItemDto> items = new ArrayList<>();
    if (src.getIcmListaclases() != null
        && CollectionUtils.isNotEmpty(src.getIcmListaclases().getIcmListaclasesRecordSet())) {
      src.getIcmListaclases().getIcmListaclasesRecordSet().forEach(x -> items.add(this.delegate.asClaseResultItemDto(x)));
    }
    result.setItems(items);
    return result;
  }

  @Override
  public ClaseResultItemDto asClaseResultItemDto(final IcmListaclasesRecord src) {
    final ClaseResultItemDto result = this.delegate.asClaseResultItemDto(src);
    if (StringUtils.isNotBlank(src.getEstadosil())) {
      result.setIdsEstadoSil(Arrays.asList(src.getEstadosil().split(Meta4Constants.COMMA_SEPARATOR)));
    }
    return result;
  }

  @Override
  public IcmParamcalliquidacionBlock asIcmParamcalliquidacionBlock(final LiquidacionFilterDto src) {
    final List<IcmParamcalliquidacionRecord> list = this.asIcmParamcalliquidacionRecordList(src);
    final IcmParamcalliquidacionBlock result = new IcmParamcalliquidacionBlock();
    result.getIcmParamcalliquidacionRecordSet().addAll(list);
    return result;
  }

  private List<IcmParamcalliquidacionRecord> asIcmParamcalliquidacionRecordList(final LiquidacionFilterDto src) {
    final List<IcmParamcalliquidacionRecord> result = new ArrayList<>();
    if (src != null) {
      src.getItems().forEach(item -> {
        final IcmParamcalliquidacionRecord record = this.delegate.asIcmParamcalliquidacionRecord(item);
        result.add(record);
      });
    }
    return result;
  }

  @Override
  public IcmParamcalplanificadorBlock asIcmParamcalplanificadorBlock(final PlanificacionFilterDto src) {
    final List<IcmParamcalplanificadorRecord> list = this.asIcmParamcalplanificadorBlockList(src);
    final IcmParamcalplanificadorBlock result = new IcmParamcalplanificadorBlock();
    result.getIcmParamcalplanificadorRecordSet().addAll(list);
    return result;
  }

  private List<IcmParamcalplanificadorRecord> asIcmParamcalplanificadorBlockList(final PlanificacionFilterDto src) {
    final List<IcmParamcalplanificadorRecord> result = new ArrayList<>();
    if (src != null) {
      src.getItems().forEach(item -> {
        final IcmParamcalplanificadorRecord record = this.delegate.asIcmParamcalplanificadorRecord(item);
        result.add(record);
      });
    }
    return result;
  }

  @Override
  public LiquidacionResultItemDto asLiquidacionResultItemDto(final IcmResultadoguardadoRecord src) {
    final LiquidacionResultItemDto result = this.delegate.asLiquidacionResultItemDto(src);
    final List<ErroresGuardadoResultItemParametersDto> errores = new ArrayList<>();
    final List<AvisosGuardadoResultItemParametersDto> avisos = new ArrayList<>();

    result.setAvisos(AvisosGuardadoResultItemDto.builder().resultado(src.getIcmAvisosguardado().getResultado()).build());
    result.setErrores(ErorresGuardadoResultItemDto.builder().resultado(src.getIcmErroresguardado().getResultado()).build());

    if (src.getIcmAvisosguardado() != null
        && CollectionUtils.isNotEmpty(src.getIcmAvisosguardado().getIcmAvisosguardadoRecordSet())) {
      src.getIcmAvisosguardado()
          .getIcmAvisosguardadoRecordSet()
          .forEach(x -> avisos.add(this.delegate.asAvisosGuardadoResultItemParametersDto(x)));
    }
    result.getErrores().setErrores(errores);
    result.getAvisos().setAvisos(avisos);

    return result;
  }

  @Override
  public List<LiquidacionResultItemDto> asLiquidacionResultItemDto(final List<IcmResultadoguardadoRecord> src) {
    final List<LiquidacionResultItemDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(x -> result.add(this.asLiquidacionResultItemDto(x)));
    }
    return result;
  }

  @Override
  public PlanificacionResultItemDto asPlanificacionResultItemDto(final IcmResultadoguardadoRecord src) {
    final PlanificacionResultItemDto result = this.delegate.asPlanificacionResultItemDto(src);
    final List<ErroresGuardadoResultItemParametersDto> errores = new ArrayList<>();
    final List<AvisosGuardadoResultItemParametersDto> avisos = new ArrayList<>();

    result.setAvisos(AvisosGuardadoResultItemDto.builder().resultado(src.getIcmAvisosguardado().getResultado()).build());
    result.setErrores(ErorresGuardadoResultItemDto.builder().resultado(src.getIcmErroresguardado().getResultado()).build());

    if (src.getIcmAvisosguardado() != null
        && CollectionUtils.isNotEmpty(src.getIcmAvisosguardado().getIcmAvisosguardadoRecordSet())) {
      src.getIcmAvisosguardado()
          .getIcmAvisosguardadoRecordSet()
          .forEach(x -> avisos.add(this.delegate.asAvisosGuardadoResultItemParametersDto(x)));
    }
    result.getErrores().setErrores(errores);
    result.getAvisos().setAvisos(avisos);

    return result;
  }

  @Override
  public List<PlanificacionResultItemDto> asPlanificacionResultItemDto(final List<IcmResultadoguardadoRecord> src) {
    final List<PlanificacionResultItemDto> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(x -> result.add(this.asPlanificacionResultItemDto(x)));
    }
    return result;
  }

}
