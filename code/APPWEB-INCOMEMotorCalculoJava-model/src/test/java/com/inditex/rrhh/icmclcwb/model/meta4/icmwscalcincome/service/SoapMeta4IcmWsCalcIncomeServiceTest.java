package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultErrorDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.*;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.IcmWsCalcIncomeMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

import org.apache.commons.lang3.math.NumberUtils;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class SoapMeta4IcmWsCalcIncomeServiceTest {

  @Mock
  private Meta4ClientPool meta4ClientPool;

  @Mock
  private IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;

  @InjectMocks
  private SoapMeta4IcmWsCalcIncomeService soapMeta4IcmWsCalcIncomeService;

  @Test
  void getAgrupOnlineTest() {
    final IcmParamcalorigenBlock origen = new IcmParamcalorigenBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaconfiguracionBlock block = new IcmListaconfiguracionBlock();
    final GetagruponlineOutput output = new GetagruponlineOutput();
    block.getIcmListaconfiguracionRecordSet().add(new IcmListaconfiguracionRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaconfiguracion(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(origen);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getagruponline(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getAgrupOnline(request);
    verify(this.meta4ClientPool, times(1)).getagruponline(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getAgrupOnlineTestNullOutput() {
    final IcmParamcalorigenBlock origen = new IcmParamcalorigenBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(origen);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getagruponline(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(null);

    final AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getAgrupOnline(request);
    verify(this.meta4ClientPool, times(1)).getagruponline(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getAgrupOnlineTestNullPageNullData() {
    final IcmParamcalorigenBlock origen = new IcmParamcalorigenBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaconfiguracionBlock block = new IcmListaconfiguracionBlock();
    final GetagruponlineOutput output = new GetagruponlineOutput();
    block.getIcmListaconfiguracionRecordSet().add(new IcmListaconfiguracionRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaconfiguracion(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(origen);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getagruponline(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final AgrupOnlineRequestDto request = new AgrupOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getAgrupOnline(request);
    verify(this.meta4ClientPool, times(1)).getagruponline(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getFlagCalculaTest() {
    final IcmParamcalflagcalculaBlock entrada = new IcmParamcalflagcalculaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListatiendasBlock block = new IcmListatiendasBlock();
    final GetflagcalculaOutput output = new GetflagcalculaOutput();
    block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListatiendas(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalflagcalculaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getflagcalcula(any(IcmParamcalflagcalculaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final FlagCalculaRequestDto request = new FlagCalculaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getFlagCalcula(request);
    verify(this.meta4ClientPool, times(1)).getflagcalcula(any(IcmParamcalflagcalculaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getFlagCalculaTestNullOutput() {
    final IcmParamcalflagcalculaBlock entrada = new IcmParamcalflagcalculaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalflagcalculaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getflagcalcula(any(IcmParamcalflagcalculaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final FlagCalculaRequestDto request = new FlagCalculaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getFlagCalcula(request);
    verify(this.meta4ClientPool, times(1)).getflagcalcula(any(IcmParamcalflagcalculaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getFlagCalculaTestNullPageNullData() {
    final IcmParamcalflagcalculaBlock entrada = new IcmParamcalflagcalculaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListatiendasBlock block = new IcmListatiendasBlock();
    final GetflagcalculaOutput output = new GetflagcalculaOutput();
    block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListatiendas(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalflagcalculaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getflagcalcula(any(IcmParamcalflagcalculaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final FlagCalculaRequestDto request = new FlagCalculaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getFlagCalcula(request);
    verify(this.meta4ClientPool, times(1)).getflagcalcula(any(IcmParamcalflagcalculaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getCoefJornadaTest() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaempleadosBlock block = new IcmListaempleadosBlock();
    final GetcoefjornadaOutput output = new GetcoefjornadaOutput();
    block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaempleados(block);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getcoefjornada(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final CoefJornadaRequestDto request = new CoefJornadaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getCoefJornada(request);
    verify(this.meta4ClientPool, times(1)).getcoefjornada(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getCoefJornadaTestNullOutput() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getcoefjornada(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final CoefJornadaRequestDto request = new CoefJornadaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getCoefJornada(request);
    verify(this.meta4ClientPool, times(1)).getcoefjornada(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getCoefJornadaTestNullPageNullData() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaempleadosBlock block = new IcmListaempleadosBlock();
    final GetcoefjornadaOutput output = new GetcoefjornadaOutput();
    block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaempleados(null);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getcoefjornada(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final CoefJornadaRequestDto request = new CoefJornadaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getCoefJornada(request);
    verify(this.meta4ClientPool, times(1)).getcoefjornada(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getFestivos() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListatiendasBlock block = new IcmListatiendasBlock();
    final GetfestivosOutput output = new GetfestivosOutput();
    block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListatiendas(block);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getfestivos(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final FestivosRequestDto request = new FestivosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getFestivos(request);
    verify(this.meta4ClientPool, times(1)).getfestivos(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getFestivosNullOutput() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListatiendasBlock block = new IcmListatiendasBlock();
    block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getfestivos(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(null);

    final FestivosRequestDto request = new FestivosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getFestivos(request);
    verify(this.meta4ClientPool, times(1)).getfestivos(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getFestivosNullPageNullData() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListatiendasBlock block = new IcmListatiendasBlock();
    final GetfestivosOutput output = new GetfestivosOutput();
    block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListatiendas(null);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getfestivos(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final FestivosRequestDto request = new FestivosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getFestivos(request);
    verify(this.meta4ClientPool, times(1)).getfestivos(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getPresenciaManual() {
    final IcmParamcalpresenciamanualBlock entrada = new IcmParamcalpresenciamanualBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaempleadosBlock block = new IcmListaempleadosBlock();
    final GetpresenciamanualOutput output = new GetpresenciamanualOutput();
    block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaempleados(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalpresenciamanualBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresenciamanual(any(IcmParamcalpresenciamanualBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final PresenciaManualRequestDto request = new PresenciaManualRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresenciaManual(request);
    verify(this.meta4ClientPool, times(1)).getpresenciamanual(any(IcmParamcalpresenciamanualBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getPresenciaManualNullOutput() {
    final IcmParamcalpresenciamanualBlock entrada = new IcmParamcalpresenciamanualBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaempleadosBlock block = new IcmListaempleadosBlock();
    block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());

    when(this.icmWsCalcIncomeMapper.asIcmParamcalpresenciamanualBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresenciamanual(any(IcmParamcalpresenciamanualBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final PresenciaManualRequestDto request = new PresenciaManualRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresenciaManual(request);
    verify(this.meta4ClientPool, times(1)).getpresenciamanual(any(IcmParamcalpresenciamanualBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getPresenciaManualNullPageNullData() {
    final IcmParamcalpresenciamanualBlock entrada = new IcmParamcalpresenciamanualBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetpresenciamanualOutput output = new GetpresenciamanualOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaempleados(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalpresenciamanualBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresenciamanual(any(IcmParamcalpresenciamanualBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final PresenciaManualRequestDto request = new PresenciaManualRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresenciaManual(request);
    verify(this.meta4ClientPool, times(1)).getpresenciamanual(any(IcmParamcalpresenciamanualBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEmpleadosPresencia() {
    final IcmParamcalempleadospresenciaBlock entrada = new IcmParamcalempleadospresenciaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaempleadosBlock block = new IcmListaempleadosBlock();
    final GetempleadospresenciaOutput output = new GetempleadospresenciaOutput();
    block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaempleados(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadospresenciaBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempleadospresencia(any(IcmParamcalempleadospresenciaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpleadosPresencia(request);
    verify(this.meta4ClientPool, times(1)).getempleadospresencia(any(IcmParamcalempleadospresenciaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEmpleadosPresenciaNullOutput() {
    final IcmParamcalempleadospresenciaBlock entrada = new IcmParamcalempleadospresenciaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaempleadosBlock block = new IcmListaempleadosBlock();
    block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadospresenciaBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempleadospresencia(any(IcmParamcalempleadospresenciaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpleadosPresencia(request);
    verify(this.meta4ClientPool, times(1)).getempleadospresencia(any(IcmParamcalempleadospresenciaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEmpleadosPresenciaNullPageNullData() {
    final IcmParamcalempleadospresenciaBlock entrada = new IcmParamcalempleadospresenciaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetempleadospresenciaOutput output = new GetempleadospresenciaOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaempleados(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadospresenciaBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempleadospresencia(any(IcmParamcalempleadospresenciaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final EmpleadosPresenciaRequestDto request = new EmpleadosPresenciaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpleadosPresencia(request);
    verify(this.meta4ClientPool, times(1)).getempleadospresencia(any(IcmParamcalempleadospresenciaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getPeriodos() {
    final IcmParamcalperiodoBlock entrada = new IcmParamcalperiodoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaperiodosBlock block = new IcmListaperiodosBlock();
    final GetperiodosOutput output = new GetperiodosOutput();
    block.getIcmListaperiodosRecordSet().add(new IcmListaperiodosRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaperiodos(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalperiodoBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getperiodos(any(IcmParamcalperiodoBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final PeriodosRequestDto request = new PeriodosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPeriodos(request);
    verify(this.meta4ClientPool, times(1)).getperiodos(any(IcmParamcalperiodoBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getPeriodosNullOutput() {
    final IcmParamcalperiodoBlock entrada = new IcmParamcalperiodoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalperiodoBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getperiodos(any(IcmParamcalperiodoBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(null);

    final PeriodosRequestDto request = new PeriodosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPeriodos(request);
    verify(this.meta4ClientPool, times(1)).getperiodos(any(IcmParamcalperiodoBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getPeriodosNullPageNullData() {
    final IcmParamcalperiodoBlock entrada = new IcmParamcalperiodoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaperiodosBlock block = new IcmListaperiodosBlock();
    final GetperiodosOutput output = new GetperiodosOutput();
    block.getIcmListaperiodosRecordSet().add(new IcmListaperiodosRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaperiodos(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalperiodoBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getperiodos(any(IcmParamcalperiodoBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final PeriodosRequestDto request = new PeriodosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPeriodos(request);
    verify(this.meta4ClientPool, times(1)).getperiodos(any(IcmParamcalperiodoBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void searchTiendas() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListatiendasBlock block = new IcmListatiendasBlock();
    final SearchtiendasOutput output = new SearchtiendasOutput();
    block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListatiendas(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(SearchTiendasFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final SearchTiendasRequestDto request = new SearchTiendasRequestDto();
    request.setData(new SearchTiendasFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.searchTiendas(request);
    verify(this.meta4ClientPool, times(1)).searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void searchTiendasNullOutput() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(SearchTiendasFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final SearchTiendasRequestDto request = new SearchTiendasRequestDto();
    request.setData(new SearchTiendasFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.searchTiendas(request);
    verify(this.meta4ClientPool, times(1)).searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void searchTiendasNullPageNullData() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final SearchtiendasOutput output = new SearchtiendasOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListatiendas(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(SearchTiendasFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final SearchTiendasRequestDto request = new SearchTiendasRequestDto();
    request.setData(new SearchTiendasFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.searchTiendas(request);
    verify(this.meta4ClientPool, times(1)).searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getTiendas() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListatiendasBlock block = new IcmListatiendasBlock();
    final GettiendasincomeOutput output = new GettiendasincomeOutput();
    block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListatiendas(block);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.gettiendasincome(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class))).thenReturn(output);

    final TiendasRequestDto request = new TiendasRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getTiendas(request);
    verify(this.meta4ClientPool, times(1)).gettiendasincome(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  void getTiendasNullOutput() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.gettiendasincome(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class))).thenReturn(null);

    final TiendasRequestDto request = new TiendasRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getTiendas(request);
    verify(this.meta4ClientPool, times(1)).gettiendasincome(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  void getTiendasNullPageNullData() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GettiendasincomeOutput output = new GettiendasincomeOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListatiendas(null);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.gettiendasincome(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class))).thenReturn(output);

    final TiendasRequestDto request = new TiendasRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getTiendas(request);
    verify(this.meta4ClientPool, times(1)).gettiendasincome(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  void searchEmpleados() {
    final IcmParamcalempleadoBlock entrada = new IcmParamcalempleadoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListaempleadoBlock block = new IcmListaempleadoBlock();
    final SearchempleadosOutput output = new SearchempleadosOutput();
    block.getIcmListaempleadoRecordSet().add(new IcmListaempleadoRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaempleado(block);
    entrada.getIcmParamcalempleadoRecordSet().add(new IcmParamcalempleadoRecord());

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(any(SearchEmpleadosFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.searchempleados(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class))).thenReturn(output);

    final SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
    request.setData(new SearchEmpleadosFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.searchEmpleados(request);

    verify(this.meta4ClientPool, times(1)).searchempleados(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class));
  }

  @Test
  void searchEmpleadosNullOutput() {
    final IcmParamcalempleadoBlock entrada = new IcmParamcalempleadoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    entrada.getIcmParamcalempleadoRecordSet().add(new IcmParamcalempleadoRecord());

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(any(SearchEmpleadosFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.searchempleados(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class))).thenReturn(null);

    final SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
    request.setData(new SearchEmpleadosFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.searchEmpleados(request);

    verify(this.meta4ClientPool, times(1)).searchempleados(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class));
  }

  @Test
  void searchEmpleadosNullPageNullData() {
    final IcmParamcalempleadoBlock entrada = new IcmParamcalempleadoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final SearchempleadosOutput output = new SearchempleadosOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaempleado(null);
    entrada.getIcmParamcalempleadoRecordSet().add(new IcmParamcalempleadoRecord());

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(any(SearchEmpleadosFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.searchempleados(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class))).thenReturn(output);

    final SearchEmpleadosRequestDto request = new SearchEmpleadosRequestDto();
    request.setData(new SearchEmpleadosFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.searchEmpleados(request);

    verify(this.meta4ClientPool, times(1)).searchempleados(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class));
  }

  @Test
  void getEstructurasCom() {
    final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();
    final IcmListaestructuraBlock block = new IcmListaestructuraBlock();
    final GetestructurascomOutput output = new GetestructurascomOutput();
    block.getIcmListaestructuraRecordSet().add(new IcmListaestructuraRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListaestructura(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

    final EstructurasComRequestDto request = new EstructurasComRequestDto();
    request.setData(new EstructurasComFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.getEstructurasCom(request);
    verify(this.meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  void getEstructurasComNullOutput() {
    final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(null);

    final EstructurasComRequestDto request = new EstructurasComRequestDto();
    request.setData(new EstructurasComFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.getEstructurasCom(request);
    verify(this.meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  void getEstructurasComNullData() {
    final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();
    final GetestructurascomOutput output = new GetestructurascomOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListaestructura(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

    final EstructurasComRequestDto request = new EstructurasComRequestDto();
    request.setData(new EstructurasComFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.getEstructurasCom(request);
    verify(this.meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  void getEstructurasComReturnNotZero() {
    final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();
    final GetestructurascomOutput output = new GetestructurascomOutput();
    output.setReturn(1.0d);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

    final EstructurasComRequestDto request = new EstructurasComRequestDto();
    request.setData(new EstructurasComFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.getEstructurasCom(request);
    verify(this.meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  void getEstructurasComEmptyRecordSet() {
    final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();
    final IcmListaestructuraBlock block = new IcmListaestructuraBlock();
    final GetestructurascomOutput output = new GetestructurascomOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListaestructura(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

    final EstructurasComRequestDto request = new EstructurasComRequestDto();
    request.setData(new EstructurasComFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.getEstructurasCom(request);
    verify(this.meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  void getEstructurasPol() {
    final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();
    final IcmListapoliticasBlock block = new IcmListapoliticasBlock();
    final GetestructuraspolOutput output = new GetestructuraspolOutput();
    block.getIcmListapoliticasRecordSet().add(new IcmListapoliticasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListapoliticas(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.meta4ClientPool.getestructuraspol(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

    final EstructurasPolRequestDto request = new EstructurasPolRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.getEstructurasPol(request);
    verify(this.meta4ClientPool, times(1)).getestructuraspol(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  void getEstructurasPolNullOutput() {
    final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.meta4ClientPool.getestructuraspol(any(IcmParamcalestructuraBlock.class))).thenReturn(null);

    final EstructurasPolRequestDto request = new EstructurasPolRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.getEstructurasPol(request);
    verify(this.meta4ClientPool, times(1)).getestructuraspol(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  void getEstructurasPolNullData() {
    final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();
    final GetestructuraspolOutput output = new GetestructuraspolOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListapoliticas(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.meta4ClientPool.getestructuraspol(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

    final EstructurasPolRequestDto request = new EstructurasPolRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto());
    this.soapMeta4IcmWsCalcIncomeService.getEstructurasPol(request);
    verify(this.meta4ClientPool, times(1)).getestructuraspol(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  void getEmpleados() {
    final IcmParamcalempleadosBlock entrada = new IcmParamcalempleadosBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetempleadosOutput output = new GetempleadosOutput();
    final IcmListaempleadosBlock block = new IcmListaempleadosBlock();
    block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaempleados(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadosBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final EmpleadosRequestDto request = new EmpleadosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpleados(request);
    verify(this.meta4ClientPool, times(1)).getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEmpleadosNullOutput() {
    final IcmParamcalempleadosBlock entrada = new IcmParamcalempleadosBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadosBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final EmpleadosRequestDto request = new EmpleadosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpleados(request);
    verify(this.meta4ClientPool, times(1)).getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEmpleadosNullPageNullData() {
    final IcmParamcalempleadosBlock entrada = new IcmParamcalempleadosBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetempleadosOutput output = new GetempleadosOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaempleados(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadosBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final EmpleadosRequestDto request = new EmpleadosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpleados(request);
    verify(this.meta4ClientPool, times(1)).getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getConfVentaOnline() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetconfventaonlineOutput output = new GetconfventaonlineOutput();
    final IcmListaconfiguracionBlock block = new IcmListaconfiguracionBlock();
    block.getIcmListaconfiguracionRecordSet().add(new IcmListaconfiguracionRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaconfiguracion(block);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getconfventaonline(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfVentaOnline(request);
    verify(this.meta4ClientPool, times(1)).getconfventaonline(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getConfVentaOnlineNullOutput() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getconfventaonline(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfVentaOnline(request);
    verify(this.meta4ClientPool, times(1)).getconfventaonline(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getConfVentaOnlineNullPageNullData() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetconfventaonlineOutput output = new GetconfventaonlineOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaconfiguracion(null);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getconfventaonline(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfVentaOnline(request);
    verify(this.meta4ClientPool, times(1)).getconfventaonline(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void whenGettiendasonlineReturnsOutputWithDataExpectMappedResponse() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final IcmListatiendasBlock block = new IcmListatiendasBlock();
    block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
    final GettiendasonlineOutput output = new GettiendasonlineOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListatiendas(block);
    final PageDto mappedPage = new PageDto(1, 100);
    final List<TiendaOnlineResultItemDto> mappedItems = List.of(new TiendaOnlineResultItemDto());
    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class))).thenReturn(output);
    when(this.icmWsCalcIncomeMapper.asPageDto(paginacion)).thenReturn(mappedPage);
    when(this.icmWsCalcIncomeMapper.asTiendaOnlineResultItemDto(block.getIcmListatiendasRecordSet()))
        .thenReturn(mappedItems);
    final TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));

    final TiendaOnlineResponseDto result = this.soapMeta4IcmWsCalcIncomeService.getTiendasOnline(request);

    assertThat(result).isNotNull();
    assertThat(result.getPage()).isSameAs(mappedPage);
    assertThat(result.getData()).isSameAs(mappedItems);
    verify(this.meta4ClientPool, times(1)).gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  void whenGettiendasonlineReturnsNullExpectEmptyResponse() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class))).thenReturn(null);
    final TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));

    final TiendaOnlineResponseDto result = this.soapMeta4IcmWsCalcIncomeService.getTiendasOnline(request);

    assertThat(result).isNotNull();
    assertThat(result.getPage()).isNull();
    assertThat(result.getData()).isNull();
    verify(this.meta4ClientPool, times(1)).gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  void whenGettiendasonlineReturnsOutputWithNullPageAndNullListExpectEmptyResponse() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GettiendasonlineOutput output = new GettiendasonlineOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListatiendas(null);
    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class))).thenReturn(output);
    final TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));

    final TiendaOnlineResponseDto result = this.soapMeta4IcmWsCalcIncomeService.getTiendasOnline(request);

    assertThat(result).isNotNull();
    assertThat(result.getPage()).isNull();
    assertThat(result.getData()).isNull();
    verify(this.meta4ClientPool, times(1)).gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  void getConfiguracionProductoVenta() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetconfprodventaOutput output = new GetconfprodventaOutput();
    final IcmListaconfiguracionBlock block = new IcmListaconfiguracionBlock();
    block.getIcmListaconfiguracionRecordSet().add(new IcmListaconfiguracionRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaconfiguracion(block);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getconfprodventa(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfiguracionProductoVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfprodventa(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getConfiguracionProductoVentaNullOutput() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getconfprodventa(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfiguracionProductoVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfprodventa(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getConfiguracionProductoVentaNullPageNullData() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetconfprodventaOutput output = new GetconfprodventaOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaconfiguracion(null);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getconfprodventa(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfiguracionProductoVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfprodventa(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getCadena() {
    final IcmParamcalcadenaBlock entrada = new IcmParamcalcadenaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetcadenaOutput output = new GetcadenaOutput();
    final IcmListacadenasBlock block = new IcmListacadenasBlock();
    block.getIcmListacadenasRecordSet().add(new IcmListacadenasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListacadenas(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalcadenaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getcadena(any(IcmParamcalcadenaBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final CadenaRequestDto request = new CadenaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getCadena(request);
    verify(this.meta4ClientPool, times(1)).getcadena(any(IcmParamcalcadenaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getCadenaNullOutput() {
    final IcmParamcalcadenaBlock entrada = new IcmParamcalcadenaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalcadenaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getcadena(any(IcmParamcalcadenaBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(null);

    final CadenaRequestDto request = new CadenaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getCadena(request);
    verify(this.meta4ClientPool, times(1)).getcadena(any(IcmParamcalcadenaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getCadenaNullPageNullData() {
    final IcmParamcalcadenaBlock entrada = new IcmParamcalcadenaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetcadenaOutput output = new GetcadenaOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListacadenas(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalcadenaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getcadena(any(IcmParamcalcadenaBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final CadenaRequestDto request = new CadenaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getCadena(request);
    verify(this.meta4ClientPool, times(1)).getcadena(any(IcmParamcalcadenaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEmpresa() {
    final IcmParamcalorigenBlock entrada = new IcmParamcalorigenBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetempresasOutput output = new GetempresasOutput();
    final IcmListaempresasBlock block = new IcmListaempresasBlock();
    block.getIcmListaempresasRecordSet().add(new IcmListaempresasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaempresas(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempresas(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final EmpresaRequestDto request = new EmpresaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpresa(request);
    verify(this.meta4ClientPool, times(1)).getempresas(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEmpresaNullOutput() {
    final IcmParamcalorigenBlock entrada = new IcmParamcalorigenBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempresas(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(null);

    final EmpresaRequestDto request = new EmpresaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpresa(request);
    verify(this.meta4ClientPool, times(1)).getempresas(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEmpresaNullPageNullData() {
    final IcmParamcalorigenBlock entrada = new IcmParamcalorigenBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetempresasOutput output = new GetempresasOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaempresas(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempresas(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final EmpresaRequestDto request = new EmpresaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpresa(request);
    verify(this.meta4ClientPool, times(1)).getempresas(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getOrigen() {
    final IcmParamcalsociedadBlock entrada = new IcmParamcalsociedadBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetorigenesOutput output = new GetorigenesOutput();
    final IcmListaorigenesBlock block = new IcmListaorigenesBlock();
    block.getIcmListaorigenesRecordSet().add(new IcmListaorigenesRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaorigenes(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalsociedadBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getorigenes(any(IcmParamcalsociedadBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final OrigenRequestDto request = new OrigenRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getOrigen(request);
    verify(this.meta4ClientPool, times(1)).getorigenes(any(IcmParamcalsociedadBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getOrigenNullOutput() {
    final IcmParamcalsociedadBlock entrada = new IcmParamcalsociedadBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalsociedadBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getorigenes(any(IcmParamcalsociedadBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(null);

    final OrigenRequestDto request = new OrigenRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getOrigen(request);
    verify(this.meta4ClientPool, times(1)).getorigenes(any(IcmParamcalsociedadBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getOrigenNullPageNullData() {
    final IcmParamcalsociedadBlock entrada = new IcmParamcalsociedadBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetorigenesOutput output = new GetorigenesOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaorigenes(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalsociedadBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getorigenes(any(IcmParamcalsociedadBlock.class),
        any(IcmParametrospaginacionBlock.class)))
            .thenReturn(output);

    final OrigenRequestDto request = new OrigenRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getOrigen(request);
    verify(this.meta4ClientPool, times(1)).getorigenes(any(IcmParamcalsociedadBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEmpleadosDesplazamiento() {
    final IcmParamcalempleadosdesplazBlock entrada = new IcmParamcalempleadosdesplazBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetempleadosdesplazOutput output = new GetempleadosdesplazOutput();
    final IcmListaempleadosBlock block = new IcmListaempleadosBlock();
    block.getIcmListaempleadosRecordSet().add(new IcmListaempleadosRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaempleados(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadosdesplazBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempleadosdesplaz(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadosdesplazBlock.class))).thenReturn(output);

    final EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpleadosDesplazamiento(request);
    verify(this.meta4ClientPool, times(1)).getempleadosdesplaz(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadosdesplazBlock.class));
  }

  @Test
  void getEmpleadosDesplazamientoNullOutput() {
    final IcmParamcalempleadosdesplazBlock entrada = new IcmParamcalempleadosdesplazBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadosdesplazBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempleadosdesplaz(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadosdesplazBlock.class))).thenReturn(null);

    final EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpleadosDesplazamiento(request);
    verify(this.meta4ClientPool, times(1)).getempleadosdesplaz(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadosdesplazBlock.class));
  }

  @Test
  void getEmpleadosDesplazamientoNullPageNullData() {
    final IcmParamcalempleadosdesplazBlock entrada = new IcmParamcalempleadosdesplazBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetempleadosdesplazOutput output = new GetempleadosdesplazOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaempleados(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadosdesplazBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempleadosdesplaz(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadosdesplazBlock.class))).thenReturn(output);

    final EmpleadosDesplazamientoRequestDto request = new EmpleadosDesplazamientoRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEmpleadosDesplazamiento(request);
    verify(this.meta4ClientPool, times(1)).getempleadosdesplaz(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadosdesplazBlock.class));
  }

  @Test
  void saveProceso() {
    final IcmParamcalprocesoBlock entrada = new IcmParamcalprocesoBlock();
    final SaveprocesoOutput output = new SaveprocesoOutput();
    final SaveResultDto result = new SaveResultDto();
    result.setResultadoError(Boolean.FALSE);
    result.setResultadoOk(Boolean.TRUE);
    output.setIcmResultadoguardado(new IcmResultadoguardadoBlock());
    // output.set
    when(this.icmWsCalcIncomeMapper.asSaveResultDto(any(IcmResultadoguardadoBlock.class))).thenReturn(result);
    when(this.icmWsCalcIncomeMapper.asIcmParamcalprocesoBlock(any(SaveProcesoDto.class))).thenReturn(entrada);

    when(this.meta4ClientPool.saveproceso(any(IcmParamcalprocesoBlock.class))).thenReturn(output);

    final SaveProcesoDto dto = mock(SaveProcesoDto.class);
    this.soapMeta4IcmWsCalcIncomeService.saveProceso(dto);
    verify(this.meta4ClientPool, times(1)).saveproceso(any(IcmParamcalprocesoBlock.class));
  }

  @Test
  void getConfChallengeDiasMinimos() {
    final IcmParamcalconfchdiasBlock entrada = new IcmParamcalconfchdiasBlock();
    final GetconfchdiasminimosOutput output = new GetconfchdiasminimosOutput();
    final IcmListaconfchdiasBlock block = new IcmListaconfchdiasBlock();
    block.getIcmListaconfchdiasRecordSet().add(new IcmListaconfchdiasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListaconfchdias(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfchdiasBlock(any(ConfChDiasMinimosFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfchdiasminimos(any(IcmParamcalconfchdiasBlock.class))).thenReturn(output);

    final ConfChDiasMinimosRequestDto request = new ConfChDiasMinimosRequestDto();
    request.setData(new ConfChDiasMinimosFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfChallengeDiasMinimos(request);
    verify(this.meta4ClientPool, times(1)).getconfchdiasminimos(any(IcmParamcalconfchdiasBlock.class));
  }

  @Test
  void getConfChallengeDiasMinimosNullOutput() {
    final IcmParamcalconfchdiasBlock entrada = new IcmParamcalconfchdiasBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfchdiasBlock(any(ConfChDiasMinimosFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfchdiasminimos(any(IcmParamcalconfchdiasBlock.class))).thenReturn(null);

    final ConfChDiasMinimosRequestDto request = new ConfChDiasMinimosRequestDto();
    request.setData(new ConfChDiasMinimosFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfChallengeDiasMinimos(request);
    verify(this.meta4ClientPool, times(1)).getconfchdiasminimos(any(IcmParamcalconfchdiasBlock.class));
  }

  @Test
  void getConfChallengeDiasMinimosNullPageNullData() {
    final IcmParamcalconfchdiasBlock entrada = new IcmParamcalconfchdiasBlock();
    final GetconfchdiasminimosOutput output = new GetconfchdiasminimosOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListaconfchdias(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfchdiasBlock(any(ConfChDiasMinimosFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfchdiasminimos(any(IcmParamcalconfchdiasBlock.class))).thenReturn(output);

    final ConfChDiasMinimosRequestDto request = new ConfChDiasMinimosRequestDto();
    request.setData(new ConfChDiasMinimosFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfChallengeDiasMinimos(request);
    verify(this.meta4ClientPool, times(1)).getconfchdiasminimos(any(IcmParamcalconfchdiasBlock.class));
  }

  @Test
  void getPresupuestosWloc() {
    final IcmParamcalpresupuestoswlocBlock entrada = new IcmParamcalpresupuestoswlocBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetpresupuestoswlocOutput output = new GetpresupuestoswlocOutput();
    final IcmListapresupuestoswlocBlock block = new IcmListapresupuestoswlocBlock();
    block.getIcmListapresupuestoswlocRecordSet().add(new IcmListapresupuestoswlocRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListapresupuestoswloc(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalpresupuestoswlocBlock(any(PresupuestosWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresupuestoswloc(any(IcmParamcalpresupuestoswlocBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final PresupuestosWlocRequestDto request = new PresupuestosWlocRequestDto();
    request.setData(new PresupuestosWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresupuestosWloc(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestoswloc(any(IcmParamcalpresupuestoswlocBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getPresupuestosWlocNullOutput() {
    final IcmParamcalpresupuestoswlocBlock entrada = new IcmParamcalpresupuestoswlocBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalpresupuestoswlocBlock(any(PresupuestosWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresupuestoswloc(any(IcmParamcalpresupuestoswlocBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final PresupuestosWlocRequestDto request = new PresupuestosWlocRequestDto();
    request.setData(new PresupuestosWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresupuestosWloc(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestoswloc(any(IcmParamcalpresupuestoswlocBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getPresupuestosWlocNullPageNullData() {
    final IcmParamcalpresupuestoswlocBlock entrada = new IcmParamcalpresupuestoswlocBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetpresupuestoswlocOutput output = new GetpresupuestoswlocOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListapresupuestoswloc(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalpresupuestoswlocBlock(any(PresupuestosWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresupuestoswloc(any(IcmParamcalpresupuestoswlocBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final PresupuestosWlocRequestDto request = new PresupuestosWlocRequestDto();
    request.setData(new PresupuestosWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresupuestosWloc(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestoswloc(any(IcmParamcalpresupuestoswlocBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getConfPrecioHora() {
    final IcmParamcalconfpreciohoraBlock entrada = new IcmParamcalconfpreciohoraBlock();
    final GetconfpreciohoraOutput output = new GetconfpreciohoraOutput();
    final IcmListaconfpreciohoraBlock block = new IcmListaconfpreciohoraBlock();
    block.getIcmListaconfpreciohoraRecordSet().add(new IcmListaconfpreciohoraRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListaconfpreciohora(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfpreciohoraBlock(any(ConfPrecioHoraFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfpreciohora(any(IcmParamcalconfpreciohoraBlock.class))).thenReturn(output);

    final ConfPrecioHoraRequestDto request = new ConfPrecioHoraRequestDto();
    request.setData(new ConfPrecioHoraFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfPrecioHora(request);
    verify(this.meta4ClientPool, times(1)).getconfpreciohora(any(IcmParamcalconfpreciohoraBlock.class));
  }

  @Test
  void getConfPrecioHoraNullOutput() {
    final IcmParamcalconfpreciohoraBlock entrada = new IcmParamcalconfpreciohoraBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfpreciohoraBlock(any(ConfPrecioHoraFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfpreciohora(any(IcmParamcalconfpreciohoraBlock.class))).thenReturn(null);

    final ConfPrecioHoraRequestDto request = new ConfPrecioHoraRequestDto();
    request.setData(new ConfPrecioHoraFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfPrecioHora(request);
    verify(this.meta4ClientPool, times(1)).getconfpreciohora(any(IcmParamcalconfpreciohoraBlock.class));
  }

  @Test
  void getConfPrecioHoraNullPageNullData() {
    final IcmParamcalconfpreciohoraBlock entrada = new IcmParamcalconfpreciohoraBlock();
    final GetconfpreciohoraOutput output = new GetconfpreciohoraOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListaconfpreciohora(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfpreciohoraBlock(any(ConfPrecioHoraFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfpreciohora(any(IcmParamcalconfpreciohoraBlock.class))).thenReturn(output);

    final ConfPrecioHoraRequestDto request = new ConfPrecioHoraRequestDto();
    request.setData(new ConfPrecioHoraFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfPrecioHora(request);
    verify(this.meta4ClientPool, times(1)).getconfpreciohora(any(IcmParamcalconfpreciohoraBlock.class));
  }

  @Test
  void getConfChallengeTpVenta() {
    final IcmParamcalconfchventaBlock entrada = new IcmParamcalconfchventaBlock();
    final GetconfchtpventaOutput output = new GetconfchtpventaOutput();
    final IcmListaconfchventaBlock block = new IcmListaconfchventaBlock();
    block.getIcmListaconfchventaRecordSet().add(new IcmListaconfchventaRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListaconfchventa(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfchventaBlock(any(ConfChTpVentaFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfchtpventa(any(IcmParamcalconfchventaBlock.class))).thenReturn(output);

    final ConfChTpVentaRequestDto request = new ConfChTpVentaRequestDto();
    request.setData(new ConfChTpVentaFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfChallengeTpVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfchtpventa(any(IcmParamcalconfchventaBlock.class));
  }

  @Test
  void getConfChallengeTpVentaNullOutput() {
    final IcmParamcalconfchventaBlock entrada = new IcmParamcalconfchventaBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfchventaBlock(any(ConfChTpVentaFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfchtpventa(any(IcmParamcalconfchventaBlock.class))).thenReturn(null);

    final ConfChTpVentaRequestDto request = new ConfChTpVentaRequestDto();
    request.setData(new ConfChTpVentaFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfChallengeTpVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfchtpventa(any(IcmParamcalconfchventaBlock.class));
  }

  @Test
  void getConfChallengeTpVentaNullPageNullData() {
    final IcmParamcalconfchventaBlock entrada = new IcmParamcalconfchventaBlock();
    final GetconfchtpventaOutput output = new GetconfchtpventaOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListaconfchventa(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfchventaBlock(any(ConfChTpVentaFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfchtpventa(any(IcmParamcalconfchventaBlock.class))).thenReturn(output);

    final ConfChTpVentaRequestDto request = new ConfChTpVentaRequestDto();
    request.setData(new ConfChTpVentaFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getConfChallengeTpVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfchtpventa(any(IcmParamcalconfchventaBlock.class));
  }

  /**/

  @Test
  void getPresupuestosRango() {
    final IcmParamcalpresupuestosrangoBlock entrada = new IcmParamcalpresupuestosrangoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetpresupuestosrangoOutput output = new GetpresupuestosrangoOutput();
    final IcmListapresupuestosrangoBlock block = new IcmListapresupuestosrangoBlock();
    block.getIcmListapresupuestosrangoRecordSet().add(new IcmListapresupuestosrangoRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListapresupuestosrango(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalpresupuestosrangoBlock(any(PresupuestosRangoFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresupuestosrango(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalpresupuestosrangoBlock.class))).thenReturn(output);

    final PresupuestosRangoRequestDto request = new PresupuestosRangoRequestDto();
    request.setData(new PresupuestosRangoFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresupuestosRango(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestosrango(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalpresupuestosrangoBlock.class));
  }

  @Test
  void getPresupuestosRangoNullOutput() {
    final IcmParamcalpresupuestosrangoBlock entrada = new IcmParamcalpresupuestosrangoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalpresupuestosrangoBlock(any(PresupuestosRangoFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresupuestosrango(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalpresupuestosrangoBlock.class))).thenReturn(null);

    final PresupuestosRangoRequestDto request = new PresupuestosRangoRequestDto();
    request.setData(new PresupuestosRangoFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresupuestosRango(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestosrango(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalpresupuestosrangoBlock.class));
  }

  @Test
  void getPresupuestosRangoNullPageNullData() {
    final IcmParamcalpresupuestosrangoBlock entrada = new IcmParamcalpresupuestosrangoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetpresupuestosrangoOutput output = new GetpresupuestosrangoOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListapresupuestosrango(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalpresupuestosrangoBlock(any(PresupuestosRangoFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresupuestosrango(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalpresupuestosrangoBlock.class))).thenReturn(output);

    final PresupuestosRangoRequestDto request = new PresupuestosRangoRequestDto();
    request.setData(new PresupuestosRangoFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresupuestosRango(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestosrango(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalpresupuestosrangoBlock.class));
  }

  @Test
  void getDesplazReal() {
    final IcmParamcaldesplazrealBlock entrada = new IcmParamcaldesplazrealBlock();
    final GetdesplazrealOutput output = new GetdesplazrealOutput();
    final IcmListadesplazrealBlock block = new IcmListadesplazrealBlock();
    block.getIcmListadesplazrealRecordSet().add(new IcmListadesplazrealRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListadesplazreal(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaldesplazrealBlock(any(DesplazamientoRealFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getdesplazreal(any(IcmParamcaldesplazrealBlock.class))).thenReturn(output);

    final DesplazamientoRealRequestDto request = new DesplazamientoRealRequestDto();
    request.setData(new DesplazamientoRealFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getDesplazReal(request);
    verify(this.meta4ClientPool, times(1)).getdesplazreal(any(IcmParamcaldesplazrealBlock.class));
  }

  @Test
  void getDesplazRealNullOutput() {
    final IcmParamcaldesplazrealBlock entrada = new IcmParamcaldesplazrealBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcaldesplazrealBlock(any(DesplazamientoRealFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getdesplazreal(any(IcmParamcaldesplazrealBlock.class))).thenReturn(null);

    final DesplazamientoRealRequestDto request = new DesplazamientoRealRequestDto();
    request.setData(new DesplazamientoRealFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getDesplazReal(request);
    verify(this.meta4ClientPool, times(1)).getdesplazreal(any(IcmParamcaldesplazrealBlock.class));
  }

  @Test
  void sincronizacion() {
    final IcmParamcalsincroBlock entrada = new IcmParamcalsincroBlock();
    final SincronizacionOutput output = new SincronizacionOutput();
    final IcmListasincroBlock block = new IcmListasincroBlock();
    block.getIcmListasincroRecordSet().add(new IcmListasincroRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListasincro(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalsincroBlock(any(SincronizacionFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.sincronizacion(any(IcmParamcalsincroBlock.class))).thenReturn(output);

    final SincronizacionRequestDto request = new SincronizacionRequestDto();
    request.setData(new SincronizacionFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.sincronizacion(request);
    verify(this.meta4ClientPool, times(1)).sincronizacion(any(IcmParamcalsincroBlock.class));
  }

  @Test
  void sincronizacionNullOutput() {
    final IcmParamcalsincroBlock entrada = new IcmParamcalsincroBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalsincroBlock(any(SincronizacionFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.sincronizacion(any(IcmParamcalsincroBlock.class))).thenReturn(null);

    final SincronizacionRequestDto request = new SincronizacionRequestDto();
    request.setData(new SincronizacionFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.sincronizacion(request);
    verify(this.meta4ClientPool, times(1)).sincronizacion(any(IcmParamcalsincroBlock.class));
  }

  @Test
  void sistemaDestino() {

    final IcmParamcalsistdestinoBlock entrada = new IcmParamcalsistdestinoBlock();
    final GetsistdestinoOutput output = new GetsistdestinoOutput();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalsistdestinoBlock(any(SistemaDestinoRequestDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getsisdestino(entrada)).thenReturn(output);
    final SistemaDestinoRequestDto request = SistemaDestinoRequestDto.builder().build();
    this.soapMeta4IcmWsCalcIncomeService.getSistemaDestino(request);

    verify(this.meta4ClientPool, times(1)).getsisdestino(entrada);
    verify(this.icmWsCalcIncomeMapper, times(1)).asSistemaDestinoResponseDto(output);
    verify(this.icmWsCalcIncomeMapper, times(1)).asIcmParamcalsistdestinoBlock(request);

  }

  @Test
  void catalogo() {

    final IcmParamcalcatalogoBlock entrada = new IcmParamcalcatalogoBlock();
    final GetcatalogoOutput output = new GetcatalogoOutput();
    when(this.icmWsCalcIncomeMapper.asIcmParamcalcatalogoBlock(any(CatalogoRequestDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getcatalogo(entrada)).thenReturn(output);
    final CatalogoRequestDto request = CatalogoRequestDto.builder().build();
    this.soapMeta4IcmWsCalcIncomeService.getCatalogo(request);

    verify(this.meta4ClientPool, times(1)).getcatalogo(entrada);
    verify(this.icmWsCalcIncomeMapper, times(1)).asCatalogoResponseDto(output);
    verify(this.icmWsCalcIncomeMapper, times(1)).asIcmParamcalcatalogoBlock(request);

  }

  @Test
  void tiposhoras() {

    final IcmParamcaltiposhoraBlock entrada = new IcmParamcaltiposhoraBlock();
    final GettiposhoraOutput output = new GettiposhoraOutput();
    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiposhoraBlock(any(TiposHoraRequestDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.gettiposhora(entrada)).thenReturn(output);
    final TiposHoraRequestDto request = TiposHoraRequestDto.builder().build();
    this.soapMeta4IcmWsCalcIncomeService.getTiposHora(request);

    verify(this.meta4ClientPool, times(1)).gettiposhora(entrada);
    verify(this.icmWsCalcIncomeMapper, times(1)).asTiposHoraResponseDto(output);
    verify(this.icmWsCalcIncomeMapper, times(1)).asIcmParamcaltiposhoraBlock(request);

  }

  @Test
  void mail() {

    final IcmParamcalusuarioBlock entrada = new IcmParamcalusuarioBlock();
    final GetmailOutput output = new GetmailOutput();
    when(this.icmWsCalcIncomeMapper.asIcmParamcalusuarioBlock(any(UsuarioRequestDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getmail(entrada)).thenReturn(output);
    final UsuarioRequestDto request = UsuarioRequestDto.builder().build();
    this.soapMeta4IcmWsCalcIncomeService.getMail(request);

    verify(this.meta4ClientPool, times(1)).getmail(entrada);
    verify(this.icmWsCalcIncomeMapper, times(1)).asUsuarioResponseDto(output);
    verify(this.icmWsCalcIncomeMapper, times(1)).asIcmParamcalusuarioBlock(request);

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void clases(final ClaseRequestDto request, final IcmParamcalorigenBlock param, final GetclasesOutput output,
      final ClaseResponseDto response) {
    when(this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(ClaseRequestDto.class))).thenReturn(param);
    when(this.meta4ClientPool.getclases(any(IcmParamcalorigenBlock.class))).thenReturn(output);
    when(this.icmWsCalcIncomeMapper.asClaseResponseDto(any(GetclasesOutput.class))).thenReturn(response);

    final ClaseResponseDto result = this.soapMeta4IcmWsCalcIncomeService.getClases(request);

    verify(this.icmWsCalcIncomeMapper, times(1)).asIcmParamcalorigenBlock(request);
    verify(this.icmWsCalcIncomeMapper, times(1)).asClaseResponseDto(output);
    verify(this.meta4ClientPool, times(1)).getclases(param);
    assertEquals(response, result);
  }

  @Test
  void liquidacion() {
    final IcmParamcalliquidacionBlock entrada = new IcmParamcalliquidacionBlock();
    final LiquidacionOutput output = new LiquidacionOutput();
    final IcmResultadoguardadoBlock block = new IcmResultadoguardadoBlock();
    block.getIcmResultadoguardadoRecordSet().add(new IcmResultadoguardadoRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmResultadoguardado(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalliquidacionBlock(any(LiquidacionFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.liquidacion(any(IcmParamcalliquidacionBlock.class))).thenReturn(output);

    final LiquidacionRequestDto request = new LiquidacionRequestDto();
    request.setData(new LiquidacionFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.liquidacion(request);
    verify(this.meta4ClientPool, times(1)).liquidacion(any(IcmParamcalliquidacionBlock.class));
  }

  @Test
  void liquidacionNullOutput() {
    final IcmParamcalliquidacionBlock entrada = new IcmParamcalliquidacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalliquidacionBlock(any(LiquidacionFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.liquidacion(any(IcmParamcalliquidacionBlock.class))).thenReturn(null);

    final LiquidacionRequestDto request = new LiquidacionRequestDto();
    request.setData(new LiquidacionFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.liquidacion(request);
    verify(this.meta4ClientPool, times(1)).liquidacion(any(IcmParamcalliquidacionBlock.class));
  }

  @Test
  void planificacion() {
    final IcmParamcalplanificadorBlock entrada = new IcmParamcalplanificadorBlock();
    final PlanificacionOutput output = new PlanificacionOutput();
    final IcmResultadoguardadoBlock block = new IcmResultadoguardadoBlock();
    block.getIcmResultadoguardadoRecordSet().add(new IcmResultadoguardadoRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmResultadoguardado(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalplanificadorBlock(any(PlanificacionFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.planificacion(any(IcmParamcalplanificadorBlock.class))).thenReturn(output);

    final PlanificacionRequestDto request = new PlanificacionRequestDto();
    request.setData(new PlanificacionFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.planificacion(request);
    verify(this.meta4ClientPool, times(1)).planificacion(any(IcmParamcalplanificadorBlock.class));
  }

  @Test
  void planificacionNullOutput() {
    final IcmParamcalplanificadorBlock entrada = new IcmParamcalplanificadorBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalplanificadorBlock(any(PlanificacionFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.planificacion(any(IcmParamcalplanificadorBlock.class))).thenReturn(null);

    final PlanificacionRequestDto request = new PlanificacionRequestDto();
    request.setData(new PlanificacionFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.planificacion(request);
    verify(this.meta4ClientPool, times(1)).planificacion(any(IcmParamcalplanificadorBlock.class));
  }

  @Test
  void getEstadoWloc() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetestadowlocOutput output = new GetestadowlocOutput();
    final IcmListaestadoBlock block = new IcmListaestadoBlock();
    block.getIcmListaestadoRecordSet().add(new IcmListaestadoRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaestado(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(EstadoWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getEstadoWloc(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final EstadoWlocRequestDto request = new EstadoWlocRequestDto();
    request.setData(new EstadoWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEstadoWloc(request);
    verify(this.meta4ClientPool, times(1)).getEstadoWloc(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEstadoWlocNullOutput() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(EstadoWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getEstadoWloc(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final EstadoWlocRequestDto request = new EstadoWlocRequestDto();
    request.setData(new EstadoWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEstadoWloc(request);
    verify(this.meta4ClientPool, times(1)).getEstadoWloc(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getEstadoWlocNullPageNullData() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetestadowlocOutput output = new GetestadowlocOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaestado(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(EstadoWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getEstadoWloc(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(output);

    final EstadoWlocRequestDto request = new EstadoWlocRequestDto();
    request.setData(new EstadoWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getEstadoWloc(request);
    verify(this.meta4ClientPool, times(1)).getEstadoWloc(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  void getAusencias() {
    final IcmParamcalempleadoBlock entrada = new IcmParamcalempleadoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetausenciasOutput output = new GetausenciasOutput();
    final IcmListaausenciasBlock block = new IcmListaausenciasBlock();
    block.getIcmListaausenciasRecordSet().add(new IcmListaausenciasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaausencias(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getausencias(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class))).thenReturn(output);

    final AusenciasRequestDto request = new AusenciasRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getAusencias(request);
    verify(this.meta4ClientPool, times(1)).getausencias(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class));
  }

  @Test
  void getAusenciasNullOutput() {
    final IcmParamcalempleadoBlock entrada = new IcmParamcalempleadoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getausencias(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class))).thenReturn(null);

    final AusenciasRequestDto request = new AusenciasRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getAusencias(request);
    verify(this.meta4ClientPool, times(1)).getausencias(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class));
  }

  @Test
  void getAusenciasNullPageNullData() {
    final IcmParamcalempleadoBlock entrada = new IcmParamcalempleadoBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetausenciasOutput output = new GetausenciasOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaausencias(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadoBlock(any(GenericFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getausencias(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class))).thenReturn(output);

    final AusenciasRequestDto request = new AusenciasRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getAusencias(request);
    verify(this.meta4ClientPool, times(1)).getausencias(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class));
  }

  @Test
  void getConfiguracion() {
    final IcmParamcalconforigenBlock entrada = new IcmParamcalconforigenBlock();
    final GetconfiguracionOutput output = new GetconfiguracionOutput();
    final ConfiguracionesResponseDto expected = new ConfiguracionesResponseDto();

    when(this.icmWsCalcIncomeMapper.asIcmParamconfBlock(any(ConfiguracionesRequestDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfiguracion(any(IcmParamcalconforigenBlock.class))).thenReturn(output);
    when(this.icmWsCalcIncomeMapper.asConfiguracionesResponseDto(any(GetconfiguracionOutput.class), any()))
        .thenReturn(expected);

    final ConfiguracionesRequestDto request = ConfiguracionesRequestDto.builder().idOrigen("ORIG").build();
    final ConfiguracionesResponseDto result = this.soapMeta4IcmWsCalcIncomeService.getConfiguracion(request);
    assertThat(result).isSameAs(expected);
    verify(this.meta4ClientPool, times(1)).getconfiguracion(any(IcmParamcalconforigenBlock.class));
  }

  @Test
  void saveProcesoResultadoError() {
    final IcmParamcalprocesoBlock entrada = new IcmParamcalprocesoBlock();
    final SaveprocesoOutput output = new SaveprocesoOutput();
    final SaveResultDto result = new SaveResultDto();
    result.setResultadoError(Boolean.TRUE);
    result.setResultadoOk(Boolean.TRUE);
    final SaveResultErrorDto errorItem = new SaveResultErrorDto();
    errorItem.setLiteral("error literal");
    errorItem.setRegistroAfectado("REC1");
    result.setData(List.of(errorItem));
    output.setIcmResultadoguardado(new IcmResultadoguardadoBlock());
    when(this.icmWsCalcIncomeMapper.asSaveResultDto(any(IcmResultadoguardadoBlock.class))).thenReturn(result);
    when(this.icmWsCalcIncomeMapper.asIcmParamcalprocesoBlock(any(SaveProcesoDto.class))).thenReturn(entrada);
    when(this.meta4ClientPool.saveproceso(any(IcmParamcalprocesoBlock.class))).thenReturn(output);

    final SaveProcesoDto dto = mock(SaveProcesoDto.class);
    final ThrowingCallable call = () -> this.soapMeta4IcmWsCalcIncomeService.saveProceso(dto);

    assertThatThrownBy(call).isInstanceOf(IcmclcwbException.class)
        .hasMessageContaining("Error al guardar el proceso");
  }

  @Test
  void saveProcesoResultadoOkFalse() {
    final IcmParamcalprocesoBlock entrada = new IcmParamcalprocesoBlock();
    final SaveprocesoOutput output = new SaveprocesoOutput();
    final SaveResultDto result = new SaveResultDto();
    result.setResultadoError(Boolean.FALSE);
    result.setResultadoOk(Boolean.FALSE);
    result.setData(List.of());
    output.setIcmResultadoguardado(new IcmResultadoguardadoBlock());
    when(this.icmWsCalcIncomeMapper.asSaveResultDto(any(IcmResultadoguardadoBlock.class))).thenReturn(result);
    when(this.icmWsCalcIncomeMapper.asIcmParamcalprocesoBlock(any(SaveProcesoDto.class))).thenReturn(entrada);
    when(this.meta4ClientPool.saveproceso(any(IcmParamcalprocesoBlock.class))).thenReturn(output);

    final SaveProcesoDto dto = mock(SaveProcesoDto.class);
    final ThrowingCallable call = () -> this.soapMeta4IcmWsCalcIncomeService.saveProceso(dto);

    assertThatThrownBy(call).isInstanceOf(IcmclcwbException.class)
        .hasMessageContaining("Error al guardar el proceso");
  }

  @Test
  void getVentaCongelada() {
    final IcmParamcalventacongeladaBlock entrada = new IcmParamcalventacongeladaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetventacongeladaOutput output = new GetventacongeladaOutput();
    final IcmListaventacongeladaBlock block = new IcmListaventacongeladaBlock();
    block.getIcmListaventacongeladaRecordSet().add(new IcmListaventacongeladaRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaventacongelada(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalventacongeladaBlock(any(VentaCongeladaFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getventacongelada(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalventacongeladaBlock.class))).thenReturn(output);

    final VentaCongeladaRequestDto request = new VentaCongeladaRequestDto();
    request.setData(new VentaCongeladaFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getVentaCongelada(request);
    verify(this.meta4ClientPool, times(1)).getventacongelada(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalventacongeladaBlock.class));
  }

  @Test
  void getVentaCongeladaNullOutput() {
    final IcmParamcalventacongeladaBlock entrada = new IcmParamcalventacongeladaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalventacongeladaBlock(any(VentaCongeladaFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getventacongelada(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalventacongeladaBlock.class))).thenReturn(null);

    final VentaCongeladaRequestDto request = new VentaCongeladaRequestDto();
    request.setData(new VentaCongeladaFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getVentaCongelada(request);
    verify(this.meta4ClientPool, times(1)).getventacongelada(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalventacongeladaBlock.class));
  }

  @Test
  void getVentaCongeladaNullPageNullData() {
    final IcmParamcalventacongeladaBlock entrada = new IcmParamcalventacongeladaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetventacongeladaOutput output = new GetventacongeladaOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaventacongelada(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalventacongeladaBlock(any(VentaCongeladaFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getventacongelada(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalventacongeladaBlock.class))).thenReturn(output);

    final VentaCongeladaRequestDto request = new VentaCongeladaRequestDto();
    request.setData(new VentaCongeladaFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getVentaCongelada(request);
    verify(this.meta4ClientPool, times(1)).getventacongelada(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalventacongeladaBlock.class));
  }

  @Test
  void getDesplazamientosMultiempresa() {
    final IcmParamcalmultiempresaRecord multiEmpresaParamRecord = new IcmParamcalmultiempresaRecord();
    final GetdesplazmultiempresaOutput output = new GetdesplazmultiempresaOutput();
    final IcmListamultiempresaBlock block = new IcmListamultiempresaBlock();
    block.getIcmListamultiempresaRecordSet().add(new IcmListamultiempresaRecord());
    output.setIcmListamultiempresa(block);

    when(this.icmWsCalcIncomeMapper
        .asIcmParamcalmultiempresaRecord(any(DesplazamientosMultiempresaRequestItemDto.class)))
            .thenReturn(multiEmpresaParamRecord);
    when(this.meta4ClientPool.getDesplazamientoMultiempresa(any(IcmParamcalmultiempresaBlock.class)))
        .thenReturn(output);

    final DesplazamientosMultiempresaRequestDto request = new DesplazamientosMultiempresaRequestDto();
    request.setData(mock(DesplazamientosMultiempresaRequestItemDto.class));
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getDesplazamientosMultiempresa(request);
    verify(this.meta4ClientPool, times(1)).getDesplazamientoMultiempresa(any(IcmParamcalmultiempresaBlock.class));
  }

  @Test
  void getDesplazamientosMultiempresaNullList() {
    final IcmParamcalmultiempresaRecord icmParamCalMultiEmpresaRecord = new IcmParamcalmultiempresaRecord();
    final GetdesplazmultiempresaOutput output = new GetdesplazmultiempresaOutput();
    output.setIcmListamultiempresa(null);

    when(this.icmWsCalcIncomeMapper
        .asIcmParamcalmultiempresaRecord(any(DesplazamientosMultiempresaRequestItemDto.class)))
            .thenReturn(icmParamCalMultiEmpresaRecord);
    when(this.meta4ClientPool.getDesplazamientoMultiempresa(any(IcmParamcalmultiempresaBlock.class)))
        .thenReturn(output);

    final DesplazamientosMultiempresaRequestDto request = new DesplazamientosMultiempresaRequestDto();
    request.setData(mock(DesplazamientosMultiempresaRequestItemDto.class));
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getDesplazamientosMultiempresa(request);
    verify(this.meta4ClientPool, times(1)).getDesplazamientoMultiempresa(any(IcmParamcalmultiempresaBlock.class));
  }

  @Test
  void getDesplazamientosMultiempresaEmptyRecordSet() {
    final IcmParamcalmultiempresaRecord icmParamCalMultiEmpresaRecord = new IcmParamcalmultiempresaRecord();
    final GetdesplazmultiempresaOutput output = new GetdesplazmultiempresaOutput();
    output.setIcmListamultiempresa(new IcmListamultiempresaBlock());

    when(this.icmWsCalcIncomeMapper
        .asIcmParamcalmultiempresaRecord(any(DesplazamientosMultiempresaRequestItemDto.class)))
            .thenReturn(icmParamCalMultiEmpresaRecord);
    when(this.meta4ClientPool.getDesplazamientoMultiempresa(any(IcmParamcalmultiempresaBlock.class)))
        .thenReturn(output);

    final DesplazamientosMultiempresaRequestDto request = new DesplazamientosMultiempresaRequestDto();
    request.setData(mock(DesplazamientosMultiempresaRequestItemDto.class));
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getDesplazamientosMultiempresa(request);
    verify(this.meta4ClientPool, times(1)).getDesplazamientoMultiempresa(any(IcmParamcalmultiempresaBlock.class));
  }

  @Test
  void getPresenciaManualWloc() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetpresenciamanualwlocOutput output = new GetpresenciamanualwlocOutput();
    final IcmListapresenciamanwlocBlock block = new IcmListapresenciamanwlocBlock();
    block.getIcmListapresenciamanwlocRecordSet().add(new IcmListapresenciamanwlocRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListapresenciamanwloc(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(PresenciaManualWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresenciamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class))).thenReturn(output);

    final PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
    request.setData(new PresenciaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresenciaManualWloc(request);
    verify(this.meta4ClientPool, times(1)).getpresenciamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class));
  }

  @Test
  void getPresenciaManualWlocNullOutput() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(PresenciaManualWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresenciamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class))).thenReturn(null);

    final PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
    request.setData(new PresenciaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresenciaManualWloc(request);
    verify(this.meta4ClientPool, times(1)).getpresenciamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class));
  }

  @Test
  void getPresenciaManualWlocReturnNotZero() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetpresenciamanualwlocOutput output = new GetpresenciamanualwlocOutput();
    output.setReturn(1.0d);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(PresenciaManualWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresenciamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class))).thenReturn(output);

    final PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
    request.setData(new PresenciaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresenciaManualWloc(request);
    verify(this.meta4ClientPool, times(1)).getpresenciamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class));
  }

  @Test
  void getPresenciaManualWlocNullPageNullData() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetpresenciamanualwlocOutput output = new GetpresenciamanualwlocOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListapresenciamanwloc(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(PresenciaManualWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getpresenciamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class))).thenReturn(output);

    final PresenciaManualWlocRequestDto request = new PresenciaManualWlocRequestDto();
    request.setData(new PresenciaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getPresenciaManualWloc(request);
    verify(this.meta4ClientPool, times(1)).getpresenciamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class));
  }

  @Test
  void getVentaManualWloc() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetventamanualwlocOutput output = new GetventamanualwlocOutput();
    final IcmListaventamanwlocBlock block = new IcmListaventamanwlocBlock();
    block.getIcmListaventamanwlocRecordSet().add(new IcmListaventamanwlocRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListaventamanwloc(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(VentaManualWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getventamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class))).thenReturn(output);

    final VentaManualWlocRequestDto request = new VentaManualWlocRequestDto();
    request.setData(new VentaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getVentaManualWloc(request);
    verify(this.meta4ClientPool, times(1)).getventamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class));
  }

  @Test
  void getVentaManualWlocNullOutput() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(VentaManualWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getventamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class))).thenReturn(null);

    final VentaManualWlocRequestDto request = new VentaManualWlocRequestDto();
    request.setData(new VentaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getVentaManualWloc(request);
    verify(this.meta4ClientPool, times(1)).getventamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class));
  }

  @Test
  void getVentaManualWlocReturnNotZero() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetventamanualwlocOutput output = new GetventamanualwlocOutput();
    output.setReturn(1.0d);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(VentaManualWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getventamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class))).thenReturn(output);

    final VentaManualWlocRequestDto request = new VentaManualWlocRequestDto();
    request.setData(new VentaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getVentaManualWloc(request);
    verify(this.meta4ClientPool, times(1)).getventamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class));
  }

  @Test
  void getVentaManualWlocNullPageNullData() {
    final IcmParamcaltiendasBlock entrada = new IcmParamcaltiendasBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GetventamanualwlocOutput output = new GetventamanualwlocOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(null);
    output.setIcmListaventamanwloc(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiendasBlock(any(VentaManualWlocFilterDto.class)))
        .thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getventamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class))).thenReturn(output);

    final VentaManualWlocRequestDto request = new VentaManualWlocRequestDto();
    request.setData(new VentaManualWlocFilterDto());
    request.setPage(new PageDto(1, 100));
    this.soapMeta4IcmWsCalcIncomeService.getVentaManualWloc(request);
    verify(this.meta4ClientPool, times(1)).getventamanualwloc(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcaltiendasBlock.class));
  }

  @Test
  void getMotivosDesplazamiento() {
    final IcmParamcalmotivosBlock entrada = new IcmParamcalmotivosBlock();
    final GetmotivosdesplazamientoOutput output = new GetmotivosdesplazamientoOutput();
    final IcmListamotivosBlock block = new IcmListamotivosBlock();
    block.getIcmListamotivosRecordSet().add(new IcmListamotivosRecord());
    output.setIcmListamotivos(block);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalmotivosBlock(any(MotivosDesplazamientoRequestDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getmotivosdesplazamiento(any(IcmParamcalmotivosBlock.class)))
        .thenReturn(output);

    final MotivosDesplazamientoRequestDto request = MotivosDesplazamientoRequestDto.builder()
        .items(List.of(mock(MotivosDesplazamientoRequestItemDto.class)))
        .build();
    this.soapMeta4IcmWsCalcIncomeService.getMotivosDesplazamiento(request);
    verify(this.meta4ClientPool, times(1)).getmotivosdesplazamiento(any(IcmParamcalmotivosBlock.class));
  }

}
