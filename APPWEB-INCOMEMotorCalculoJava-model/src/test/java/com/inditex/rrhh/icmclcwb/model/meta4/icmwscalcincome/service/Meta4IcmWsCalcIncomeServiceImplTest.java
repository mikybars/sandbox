package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioRequestDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetagruponlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcadenaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcatalogoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetclasesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcoefjornadaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfchdiasminimosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfchtpventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfpreciohoraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfprodventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfventaonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetdesplazrealOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosdesplazOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadospresenciaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempresasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestadowlocOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructuraspolOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetfestivosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetmailOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetorigenesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetperiodosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresupuestosrangoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresupuestoswlocOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetsistdestinoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiposhoraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacadenasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacadenasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfchdiasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfchdiasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfchventaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfchventaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfiguracionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfiguracionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfpreciohoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfpreciohoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListadesplazrealBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListadesplazrealRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempresasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempresasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaorigenesBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaorigenesRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaperiodosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaperiodosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapoliticasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapoliticasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresupuestosrangoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresupuestosrangoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresupuestoswlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListasincroBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListasincroRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcatalogoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaldesplazrealBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosdesplazBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadospresenciaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalflagcalculaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalliquidacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalplanificadorBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresenciamanualBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsincroBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsistdestinoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiposhoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalusuarioBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.LiquidacionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.PlanificacionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SaveprocesoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SincronizacionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper.IcmWsCalcIncomeMapper;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class Meta4IcmWsCalcIncomeServiceImplTest {

  @Mock
  private Meta4ClientPool meta4ClientPool;

  @Mock
  private IcmWsCalcIncomeMapper icmWsCalcIncomeMapper;

  @InjectMocks
  private Meta4IcmWsCalcIncomeServiceImpl meta4IcmWsCalcIncomeServiceImpl;

  @Test
  public void getAgrupOnlineTest() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getAgrupOnline(request);
    verify(this.meta4ClientPool, times(1)).getagruponline(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getAgrupOnlineTestNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getAgrupOnline(request);
    verify(this.meta4ClientPool, times(1)).getagruponline(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getAgrupOnlineTestNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getAgrupOnline(request);
    verify(this.meta4ClientPool, times(1)).getagruponline(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getFlagCalculaTest() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getFlagCalcula(request);
    verify(this.meta4ClientPool, times(1)).getflagcalcula(any(IcmParamcalflagcalculaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getFlagCalculaTestNullOutput() {
    final IcmParamcalflagcalculaBlock entrada = new IcmParamcalflagcalculaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalflagcalculaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getflagcalcula(any(IcmParamcalflagcalculaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final FlagCalculaRequestDto request = new FlagCalculaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getFlagCalcula(request);
    verify(this.meta4ClientPool, times(1)).getflagcalcula(any(IcmParamcalflagcalculaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getFlagCalculaTestNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getFlagCalcula(request);
    verify(this.meta4ClientPool, times(1)).getflagcalcula(any(IcmParamcalflagcalculaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getCoefJornadaTest() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getCoefJornada(request);
    verify(this.meta4ClientPool, times(1)).getcoefjornada(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getCoefJornadaTestNullOutput() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getcoefjornada(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final CoefJornadaRequestDto request = new CoefJornadaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getCoefJornada(request);
    verify(this.meta4ClientPool, times(1)).getcoefjornada(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getCoefJornadaTestNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getCoefJornada(request);
    verify(this.meta4ClientPool, times(1)).getcoefjornada(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getFestivos() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getFestivos(request);
    verify(this.meta4ClientPool, times(1)).getfestivos(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getFestivosNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getFestivos(request);
    verify(this.meta4ClientPool, times(1)).getfestivos(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getFestivosNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getFestivos(request);
    verify(this.meta4ClientPool, times(1)).getfestivos(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getPresenciaManual() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPresenciaManual(request);
    verify(this.meta4ClientPool, times(1)).getpresenciamanual(any(IcmParamcalpresenciamanualBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getPresenciaManualNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPresenciaManual(request);
    verify(this.meta4ClientPool, times(1)).getpresenciamanual(any(IcmParamcalpresenciamanualBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getPresenciaManualNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPresenciaManual(request);
    verify(this.meta4ClientPool, times(1)).getpresenciamanual(any(IcmParamcalpresenciamanualBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEmpleadosPresencia() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpleadosPresencia(request);
    verify(this.meta4ClientPool, times(1)).getempleadospresencia(any(IcmParamcalempleadospresenciaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEmpleadosPresenciaNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpleadosPresencia(request);
    verify(this.meta4ClientPool, times(1)).getempleadospresencia(any(IcmParamcalempleadospresenciaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEmpleadosPresenciaNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpleadosPresencia(request);
    verify(this.meta4ClientPool, times(1)).getempleadospresencia(any(IcmParamcalempleadospresenciaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getPeriodos() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPeriodos(request);
    verify(this.meta4ClientPool, times(1)).getperiodos(any(IcmParamcalperiodoBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getPeriodosNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPeriodos(request);
    verify(this.meta4ClientPool, times(1)).getperiodos(any(IcmParamcalperiodoBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getPeriodosNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPeriodos(request);
    verify(this.meta4ClientPool, times(1)).getperiodos(any(IcmParamcalperiodoBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void searchTiendas() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.searchTiendas(request);
    verify(this.meta4ClientPool, times(1)).searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void searchTiendasNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.searchTiendas(request);
    verify(this.meta4ClientPool, times(1)).searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void searchTiendasNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.searchTiendas(request);
    verify(this.meta4ClientPool, times(1)).searchtiendas(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getTiendas() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getTiendas(request);
    verify(this.meta4ClientPool, times(1)).gettiendasincome(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  public void getTiendasNullOutput() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.gettiendasincome(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class))).thenReturn(null);

    final TiendasRequestDto request = new TiendasRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getTiendas(request);
    verify(this.meta4ClientPool, times(1)).gettiendasincome(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  public void getTiendasNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getTiendas(request);
    verify(this.meta4ClientPool, times(1)).gettiendasincome(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  public void searchEmpleados() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.searchEmpleados(request);

    verify(this.meta4ClientPool, times(1)).searchempleados(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class));
  }

  @Test
  public void searchEmpleadosNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.searchEmpleados(request);

    verify(this.meta4ClientPool, times(1)).searchempleados(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class));
  }

  @Test
  public void searchEmpleadosNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.searchEmpleados(request);

    verify(this.meta4ClientPool, times(1)).searchempleados(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadoBlock.class));
  }

  // @Test
  // public void getEstructurasCom() {
  // final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();
  // final IcmListaestructuraBlock block = new IcmListaestructuraBlock();
  // final GetestructurascomOutput output = new GetestructurascomOutput();
  // block.getIcmListaestructuraRecordSet().add(new IcmListaestructuraRecord());
  // output.setReturn(NumberUtils.DOUBLE_ZERO);
  // output.setIcmListaestructura(block);
  //
  // when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class)))
  // .thenReturn(entrada);
  // when(this.meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(output);
  //
  // final EstructurasComRequestDto request = new EstructurasComRequestDto();
  // request.setData(new EstructurasComFilterDto());
  // request.setPage(new PageDto());
  // this.meta4IcmWsCalcIncomeServiceImpl.getEstructurasCom(request);
  // verify(this.meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
  // }
  //
  //
  // @Test
  // public void getEstructurasComNullOutput() {
  // final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();
  //
  // when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class)))
  // .thenReturn(entrada);
  // when(this.meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(null);
  //
  // final EstructurasComRequestDto request = new EstructurasComRequestDto();
  // request.setData(new EstructurasComFilterDto());
  // request.setPage(new PageDto());
  // this.meta4IcmWsCalcIncomeServiceImpl.getEstructurasCom(request);
  // verify(this.meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
  // }
  //
  // @Test
  // public void getEstructurasComNullData() {
  // final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();
  // final GetestructurascomOutput output = new GetestructurascomOutput();
  // output.setReturn(NumberUtils.DOUBLE_ZERO);
  // output.setIcmListaestructura(null);
  //
  // when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(EstructurasComFilterDto.class)))
  // .thenReturn(entrada);
  // when(this.meta4ClientPool.getestructurascom(any(IcmParamcalestructuraBlock.class))).thenReturn(output);
  //
  // final EstructurasComRequestDto request = new EstructurasComRequestDto();
  // request.setData(new EstructurasComFilterDto());
  // request.setPage(new PageDto());
  // this.meta4IcmWsCalcIncomeServiceImpl.getEstructurasCom(request);
  // verify(this.meta4ClientPool, times(1)).getestructurascom(any(IcmParamcalestructuraBlock.class));
  // }

  @Test
  public void getEstructurasPol() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEstructurasPol(request);
    verify(this.meta4ClientPool, times(1)).getestructuraspol(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  public void getEstructurasPolNullOutput() {
    final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.meta4ClientPool.getestructuraspol(any(IcmParamcalestructuraBlock.class))).thenReturn(null);

    final EstructurasPolRequestDto request = new EstructurasPolRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto());
    this.meta4IcmWsCalcIncomeServiceImpl.getEstructurasPol(request);
    verify(this.meta4ClientPool, times(1)).getestructuraspol(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  public void getEstructurasPolNullData() {
    final IcmParamcalestructuraBlock entrada = new IcmParamcalestructuraBlock();
    final GetestructuraspolOutput output = new GetestructuraspolOutput();
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmListapoliticas(null);

    when(this.icmWsCalcIncomeMapper.asIcmParamcalestructuraBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.meta4ClientPool.getestructuraspol(any(IcmParamcalestructuraBlock.class))).thenReturn(output);

    final EstructurasPolRequestDto request = new EstructurasPolRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto());
    this.meta4IcmWsCalcIncomeServiceImpl.getEstructurasPol(request);
    verify(this.meta4ClientPool, times(1)).getestructuraspol(any(IcmParamcalestructuraBlock.class));
  }

  @Test
  public void getEmpleados() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpleados(request);
    verify(this.meta4ClientPool, times(1)).getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEmpleadosNullOutput() {
    final IcmParamcalempleadosBlock entrada = new IcmParamcalempleadosBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalempleadosBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final EmpleadosRequestDto request = new EmpleadosRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpleados(request);
    verify(this.meta4ClientPool, times(1)).getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEmpleadosNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpleados(request);
    verify(this.meta4ClientPool, times(1)).getempleados(any(IcmParamcalempleadosBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getConfVentaOnline() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getConfVentaOnline(request);
    verify(this.meta4ClientPool, times(1)).getconfventaonline(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getConfVentaOnlineNullOutput() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getconfventaonline(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final ConfiguracionVentaOnlineRequestDto request = new ConfiguracionVentaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getConfVentaOnline(request);
    verify(this.meta4ClientPool, times(1)).getconfventaonline(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getConfVentaOnlineNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getConfVentaOnline(request);
    verify(this.meta4ClientPool, times(1)).getconfventaonline(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getTiendasOnline() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();
    final GettiendasonlineOutput output = new GettiendasonlineOutput();
    final IcmListatiendasBlock block = new IcmListatiendasBlock();
    block.getIcmListatiendasRecordSet().add(new IcmListatiendasRecord());
    output.setReturn(NumberUtils.DOUBLE_ZERO);
    output.setIcmParametrospaginacion(paginacion);
    output.setIcmListatiendas(block);

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class))).thenReturn(output);

    final TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getTiendasOnline(request);
    verify(this.meta4ClientPool, times(1)).gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  public void getTiendasOnlineNullOutput() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class))).thenReturn(null);

    final TiendaOnlineRequestDto request = new TiendaOnlineRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getTiendasOnline(request);
    verify(this.meta4ClientPool, times(1)).gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  public void getTiendasOnlineNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getTiendasOnline(request);
    verify(this.meta4ClientPool, times(1)).gettiendasonline(any(IcmParametrospaginacionBlock.class),
        any(IcmParametrosentradaBlock.class));
  }

  @Test
  public void getConfiguracionProductoVenta() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getConfiguracionProductoVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfprodventa(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getConfiguracionProductoVentaNullOutput() {
    final IcmParametrosentradaBlock entrada = new IcmParametrosentradaBlock();
    final IcmParametrospaginacionBlock paginacion = new IcmParametrospaginacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParametrosentradaBlock(any(GenericFilterDto.class))).thenReturn(entrada);
    when(this.icmWsCalcIncomeMapper.asIcmParametrospaginacionBlock(any(PageDto.class))).thenReturn(paginacion);
    when(this.meta4ClientPool.getconfprodventa(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class))).thenReturn(null);

    final ConfiguracionProductoVentaRequestDto request = new ConfiguracionProductoVentaRequestDto();
    request.setData(new GenericFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getConfiguracionProductoVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfprodventa(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getConfiguracionProductoVentaNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getConfiguracionProductoVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfprodventa(any(IcmParametrosentradaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getCadena() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getCadena(request);
    verify(this.meta4ClientPool, times(1)).getcadena(any(IcmParamcalcadenaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getCadenaNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getCadena(request);
    verify(this.meta4ClientPool, times(1)).getcadena(any(IcmParamcalcadenaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getCadenaNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getCadena(request);
    verify(this.meta4ClientPool, times(1)).getcadena(any(IcmParamcalcadenaBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEmpresa() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpresa(request);
    verify(this.meta4ClientPool, times(1)).getempresas(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEmpresaNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpresa(request);
    verify(this.meta4ClientPool, times(1)).getempresas(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEmpresaNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpresa(request);
    verify(this.meta4ClientPool, times(1)).getempresas(any(IcmParamcalorigenBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getOrigen() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getOrigen(request);
    verify(this.meta4ClientPool, times(1)).getorigenes(any(IcmParamcalsociedadBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getOrigenNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getOrigen(request);
    verify(this.meta4ClientPool, times(1)).getorigenes(any(IcmParamcalsociedadBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getOrigenNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getOrigen(request);
    verify(this.meta4ClientPool, times(1)).getorigenes(any(IcmParamcalsociedadBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEmpleadosDesplazamiento() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpleadosDesplazamiento(request);
    verify(this.meta4ClientPool, times(1)).getempleadosdesplaz(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadosdesplazBlock.class));
  }

  @Test
  public void getEmpleadosDesplazamientoNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpleadosDesplazamiento(request);
    verify(this.meta4ClientPool, times(1)).getempleadosdesplaz(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadosdesplazBlock.class));
  }

  @Test
  public void getEmpleadosDesplazamientoNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEmpleadosDesplazamiento(request);
    verify(this.meta4ClientPool, times(1)).getempleadosdesplaz(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalempleadosdesplazBlock.class));
  }

  @Test
  public void saveProceso() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.saveProceso(dto);
    verify(this.meta4ClientPool, times(1)).saveproceso(any(IcmParamcalprocesoBlock.class));
  }

  @Test
  public void getConfChallengeDiasMinimos() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getConfChallengeDiasMinimos(request);
    verify(this.meta4ClientPool, times(1)).getconfchdiasminimos(any(IcmParamcalconfchdiasBlock.class));
  }

  @Test
  public void getConfChallengeDiasMinimosNullOutput() {
    final IcmParamcalconfchdiasBlock entrada = new IcmParamcalconfchdiasBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfchdiasBlock(any(ConfChDiasMinimosFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfchdiasminimos(any(IcmParamcalconfchdiasBlock.class))).thenReturn(null);

    final ConfChDiasMinimosRequestDto request = new ConfChDiasMinimosRequestDto();
    request.setData(new ConfChDiasMinimosFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getConfChallengeDiasMinimos(request);
    verify(this.meta4ClientPool, times(1)).getconfchdiasminimos(any(IcmParamcalconfchdiasBlock.class));
  }

  @Test
  public void getConfChallengeDiasMinimosNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getConfChallengeDiasMinimos(request);
    verify(this.meta4ClientPool, times(1)).getconfchdiasminimos(any(IcmParamcalconfchdiasBlock.class));
  }

  @Test
  public void getPresupuestosWloc() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPresupuestosWloc(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestoswloc(any(IcmParamcalpresupuestoswlocBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getPresupuestosWlocNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPresupuestosWloc(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestoswloc(any(IcmParamcalpresupuestoswlocBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getPresupuestosWlocNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPresupuestosWloc(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestoswloc(any(IcmParamcalpresupuestoswlocBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getConfPrecioHora() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getConfPrecioHora(request);
    verify(this.meta4ClientPool, times(1)).getconfpreciohora(any(IcmParamcalconfpreciohoraBlock.class));
  }

  @Test
  public void getConfPrecioHoraNullOutput() {
    final IcmParamcalconfpreciohoraBlock entrada = new IcmParamcalconfpreciohoraBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfpreciohoraBlock(any(ConfPrecioHoraFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfpreciohora(any(IcmParamcalconfpreciohoraBlock.class))).thenReturn(null);

    final ConfPrecioHoraRequestDto request = new ConfPrecioHoraRequestDto();
    request.setData(new ConfPrecioHoraFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getConfPrecioHora(request);
    verify(this.meta4ClientPool, times(1)).getconfpreciohora(any(IcmParamcalconfpreciohoraBlock.class));
  }

  @Test
  public void getConfPrecioHoraNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getConfPrecioHora(request);
    verify(this.meta4ClientPool, times(1)).getconfpreciohora(any(IcmParamcalconfpreciohoraBlock.class));
  }

  @Test
  public void getConfChallengeTpVenta() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getConfChallengeTpVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfchtpventa(any(IcmParamcalconfchventaBlock.class));
  }

  @Test
  public void getConfChallengeTpVentaNullOutput() {
    final IcmParamcalconfchventaBlock entrada = new IcmParamcalconfchventaBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalconfchventaBlock(any(ConfChTpVentaFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getconfchtpventa(any(IcmParamcalconfchventaBlock.class))).thenReturn(null);

    final ConfChTpVentaRequestDto request = new ConfChTpVentaRequestDto();
    request.setData(new ConfChTpVentaFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getConfChallengeTpVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfchtpventa(any(IcmParamcalconfchventaBlock.class));
  }

  @Test
  public void getConfChallengeTpVentaNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getConfChallengeTpVenta(request);
    verify(this.meta4ClientPool, times(1)).getconfchtpventa(any(IcmParamcalconfchventaBlock.class));
  }

  /**/

  @Test
  public void getPresupuestosRango() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPresupuestosRango(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestosrango(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalpresupuestosrangoBlock.class));
  }

  @Test
  public void getPresupuestosRangoNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPresupuestosRango(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestosrango(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalpresupuestosrangoBlock.class));
  }

  @Test
  public void getPresupuestosRangoNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getPresupuestosRango(request);
    verify(this.meta4ClientPool, times(1)).getpresupuestosrango(any(IcmParametrospaginacionBlock.class),
        any(IcmParamcalpresupuestosrangoBlock.class));
  }

  @Test
  public void getDesplazReal() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getDesplazReal(request);
    verify(this.meta4ClientPool, times(1)).getdesplazreal(any(IcmParamcaldesplazrealBlock.class));
  }

  @Test
  public void getDesplazRealNullOutput() {
    final IcmParamcaldesplazrealBlock entrada = new IcmParamcaldesplazrealBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcaldesplazrealBlock(any(DesplazamientoRealFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getdesplazreal(any(IcmParamcaldesplazrealBlock.class))).thenReturn(null);

    final DesplazamientoRealRequestDto request = new DesplazamientoRealRequestDto();
    request.setData(new DesplazamientoRealFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.getDesplazReal(request);
    verify(this.meta4ClientPool, times(1)).getdesplazreal(any(IcmParamcaldesplazrealBlock.class));
  }

  @Test
  public void sincronizacion() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.sincronizacion(request);
    verify(this.meta4ClientPool, times(1)).sincronizacion(any(IcmParamcalsincroBlock.class));
  }

  @Test
  public void sincronizacionNullOutput() {
    final IcmParamcalsincroBlock entrada = new IcmParamcalsincroBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalsincroBlock(any(SincronizacionFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.sincronizacion(any(IcmParamcalsincroBlock.class))).thenReturn(null);

    final SincronizacionRequestDto request = new SincronizacionRequestDto();
    request.setData(new SincronizacionFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.sincronizacion(request);
    verify(this.meta4ClientPool, times(1)).sincronizacion(any(IcmParamcalsincroBlock.class));
  }

  @Test
  public void sistemaDestino() {

    final IcmParamcalsistdestinoBlock entrada = new IcmParamcalsistdestinoBlock();
    final GetsistdestinoOutput output = new GetsistdestinoOutput();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalsistdestinoBlock(any(SistemaDestinoRequestDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getsisdestino(entrada)).thenReturn(output);
    final SistemaDestinoRequestDto request = SistemaDestinoRequestDto.builder().build();
    this.meta4IcmWsCalcIncomeServiceImpl.getSistemaDestino(request);

    verify(this.meta4ClientPool, times(1)).getsisdestino(entrada);
    verify(this.icmWsCalcIncomeMapper, times(1)).asSistemaDestinoResponseDto(output);
    verify(this.icmWsCalcIncomeMapper, times(1)).asIcmParamcalsistdestinoBlock(request);

  }

  @Test
  public void catalogo() {

    final IcmParamcalcatalogoBlock entrada = new IcmParamcalcatalogoBlock();
    final GetcatalogoOutput output = new GetcatalogoOutput();
    when(this.icmWsCalcIncomeMapper.asIcmParamcalcatalogoBlock(any(CatalogoRequestDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getcatalogo(entrada)).thenReturn(output);
    final CatalogoRequestDto request = CatalogoRequestDto.builder().build();
    this.meta4IcmWsCalcIncomeServiceImpl.getCatalogo(request);

    verify(this.meta4ClientPool, times(1)).getcatalogo(entrada);
    verify(this.icmWsCalcIncomeMapper, times(1)).asCatalogoResponseDto(output);
    verify(this.icmWsCalcIncomeMapper, times(1)).asIcmParamcalcatalogoBlock(request);

  }

  @Test
  public void tiposhoras() {

    final IcmParamcaltiposhoraBlock entrada = new IcmParamcaltiposhoraBlock();
    final GettiposhoraOutput output = new GettiposhoraOutput();
    when(this.icmWsCalcIncomeMapper.asIcmParamcaltiposhoraBlock(any(TiposHoraRequestDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.gettiposhora(entrada)).thenReturn(output);
    final TiposHoraRequestDto request = TiposHoraRequestDto.builder().build();
    this.meta4IcmWsCalcIncomeServiceImpl.getTiposHora(request);

    verify(this.meta4ClientPool, times(1)).gettiposhora(entrada);
    verify(this.icmWsCalcIncomeMapper, times(1)).asTiposHoraResponseDto(output);
    verify(this.icmWsCalcIncomeMapper, times(1)).asIcmParamcaltiposhoraBlock(request);

  }

  @Test
  public void mail() {

    final IcmParamcalusuarioBlock entrada = new IcmParamcalusuarioBlock();
    final GetmailOutput output = new GetmailOutput();
    when(this.icmWsCalcIncomeMapper.asIcmParamcalusuarioBlock(any(UsuarioRequestDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.getmail(entrada)).thenReturn(output);
    final UsuarioRequestDto request = UsuarioRequestDto.builder().build();
    this.meta4IcmWsCalcIncomeServiceImpl.getMail(request);

    verify(this.meta4ClientPool, times(1)).getmail(entrada);
    verify(this.icmWsCalcIncomeMapper, times(1)).asUsuarioResponseDto(output);
    verify(this.icmWsCalcIncomeMapper, times(1)).asIcmParamcalusuarioBlock(request);

  }

  @Test
  void clases(@Random final ClaseRequestDto request, @Random final IcmParamcalorigenBlock param, @Random final GetclasesOutput output,
      @Random final ClaseResponseDto response) {
    when(this.icmWsCalcIncomeMapper.asIcmParamcalorigenBlock(any(ClaseRequestDto.class))).thenReturn(param);
    when(this.meta4ClientPool.getclases(any(IcmParamcalorigenBlock.class))).thenReturn(output);
    when(this.icmWsCalcIncomeMapper.asClaseResponseDto(any(GetclasesOutput.class))).thenReturn(response);

    final ClaseResponseDto result = this.meta4IcmWsCalcIncomeServiceImpl.getClases(request);

    verify(this.icmWsCalcIncomeMapper, times(1)).asIcmParamcalorigenBlock(request);
    verify(this.icmWsCalcIncomeMapper, times(1)).asClaseResponseDto(output);
    verify(this.meta4ClientPool, times(1)).getclases(param);
    assertEquals(response, result);
  }

  @Test
  public void liquidacion() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.liquidacion(request);
    verify(this.meta4ClientPool, times(1)).liquidacion(any(IcmParamcalliquidacionBlock.class));
  }

  @Test
  public void liquidacionNullOutput() {
    final IcmParamcalliquidacionBlock entrada = new IcmParamcalliquidacionBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalliquidacionBlock(any(LiquidacionFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.liquidacion(any(IcmParamcalliquidacionBlock.class))).thenReturn(null);

    final LiquidacionRequestDto request = new LiquidacionRequestDto();
    request.setData(new LiquidacionFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.liquidacion(request);
    verify(this.meta4ClientPool, times(1)).liquidacion(any(IcmParamcalliquidacionBlock.class));
  }

  @Test
  public void planificacion() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.planificacion(request);
    verify(this.meta4ClientPool, times(1)).planificacion(any(IcmParamcalplanificadorBlock.class));
  }

  @Test
  public void planificacionNullOutput() {
    final IcmParamcalplanificadorBlock entrada = new IcmParamcalplanificadorBlock();

    when(this.icmWsCalcIncomeMapper.asIcmParamcalplanificadorBlock(any(PlanificacionFilterDto.class)))
        .thenReturn(entrada);
    when(this.meta4ClientPool.planificacion(any(IcmParamcalplanificadorBlock.class))).thenReturn(null);

    final PlanificacionRequestDto request = new PlanificacionRequestDto();
    request.setData(new PlanificacionFilterDto());
    request.setPage(new PageDto(1, 100));
    this.meta4IcmWsCalcIncomeServiceImpl.planificacion(request);
    verify(this.meta4ClientPool, times(1)).planificacion(any(IcmParamcalplanificadorBlock.class));
  }

  @Test
  public void getEstadoWloc() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEstadoWloc(request);
    verify(this.meta4ClientPool, times(1)).getEstadoWloc(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEstadoWlocNullOutput() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEstadoWloc(request);
    verify(this.meta4ClientPool, times(1)).getEstadoWloc(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

  @Test
  public void getEstadoWlocNullPageNullData() {
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
    this.meta4IcmWsCalcIncomeServiceImpl.getEstadoWloc(request);
    verify(this.meta4ClientPool, times(1)).getEstadoWloc(any(IcmParamcaltiendasBlock.class),
        any(IcmParametrospaginacionBlock.class));
  }

}
