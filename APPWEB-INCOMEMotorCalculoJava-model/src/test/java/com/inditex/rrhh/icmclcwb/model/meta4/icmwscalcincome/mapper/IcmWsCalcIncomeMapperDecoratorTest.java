package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResultItemDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresBaseResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.ListaValoresDestinoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionFilterDto;
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
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaseccionesBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaseccionespresenciasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaseccionesventaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListatiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaventamanwlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasBlock;
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
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenRecord;
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
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiposhoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalusuarioBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmResultadoguardadoBlock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class IcmWsCalcIncomeMapperDecoratorTest {

  @Mock
  @Qualifier("delegate")
  IcmWsCalcIncomeMapper delegate;

  @InjectMocks
  IcmWsCalcIncomeMapperDecorator icmWsCalcIncomeMapperDecorator = this.getClassMock();

  @Random
  GenericFilterDto genericFilterDto;

  @Random
  PageDto pageDto;

  @Random
  ConfChDiasMinimosFilterDto confChDiasMinimosFilterDto;

  @Random
  ConfPrecioHoraFilterDto confPrecioHoraFilterDto;

  @Random
  ConfChTpVentaFilterDto confChTpVentaFilterDto;

  @Random
  PresupuestosRangoFilterDto presupuestosRangoFilterDto;

  @Random
  IcmListatiendasRecord icmListatiendasRecord;

  @Random(type = IcmListaconfpreciohoraRecord.class, size = 2)
  List<IcmListaconfpreciohoraRecord> icmListaconfpreciohoraRecordList;

  @Random(type = IcmListatiendasRecord.class, size = 2)
  List<IcmListatiendasRecord> icmListatiendasRecordList;

  @Random
  IcmListaempleadosRecord icmListaempleadosRecord;

  @Random(type = IcmListaempleadosRecord.class, size = 2)
  List<IcmListaempleadosRecord> icmListaempleadosRecordList;

  @Random(type = IcmListaausenciasRecord.class, size = 2)
  List<IcmListaausenciasRecord> icmListaausenciasRecordList;

  @Random(type = IcmListaempleadoRecord.class, size = 2)
  List<IcmListaempleadoRecord> icmListaempleadoRecordList;

  @Random
  SaveProcesoDto saveProcesoDto;

  @Random
  IcmResultadoguardadoBlock icmResultadoguardadoBlock;

  @Random
  ConfiguracionesRequestDto configuracionesRequestDto;

  @Random
  GetconfiguracionOutput getconfiguracionOutput;

  @Random
  String idOrigen;

  @Random
  SearchTiendasFilterDto searchTiendasFilterDto;

  @Random
  PresenciaManualWlocFilterDto presenciaManualWlocFilterDto;

  @Random
  VentaManualWlocFilterDto ventaManualWlocFilterDto;

  @Random
  SearchEmpleadosFilterDto searchEmpleadosFilterDto;

  @Random
  DesplazamientoRealFilterDto desplazamientoRealFilterDto;

  @Random
  PresupuestosWlocFilterDto presupuestosWlocFilterDto;

  @Random(type = IcmListapresenciamanwlocRecord.class, size = 2)
  List<IcmListapresenciamanwlocRecord> icmListapresenciamanwlocRecordList;

  @Random(type = IcmListaventamanwlocRecord.class, size = 2)
  List<IcmListaventamanwlocRecord> icmListaventamanwlocRecordList;

  @Random
  SincronizacionFilterDto sincronizacionFilterDto;

  @Random
  SistemaDestinoRequestDto sistemaDestinoRequestDto;

  @Random
  GetsistdestinoOutput getsistdestinoOutput;

  @Random
  GetcatalogoOutput getcatalogoOutput;

  @Random
  IcmListacondicionesbaseRecord icmListacondicionesbaseRecord;

  @Random(type = IcmListacondicionesbaseRecord.class, size = 2)
  List<IcmListacondicionesbaseRecord> icmListacondicionesbaseRecordList;

  @Random
  IcmListacondicionesdestinoRecord icmListacondicionesdestinoRecord;

  @Random(type = IcmListacondicionesdestinoRecord.class, size = 2)
  List<IcmListacondicionesdestinoRecord> icmListacondicionesdestinoRecordList;

  @Random
  IcmListaestructuraRecord icmListaestructuraRecord;

  @Random(type = IcmListaestructuraRecord.class, size = 2)
  List<IcmListaestructuraRecord> icmListaestructuraRecordlist;

  @Random
  TiposHoraRequestDto tiposHoraRequestDto;

  @Random
  UsuarioRequestDto usuarioRequestDto;

  @Random
  GettiposhoraOutput gettiposhoraOutput;

  @Random
  GetmailOutput getmailOutput;

  @Random
  LiquidacionFilterDto liquidacionFilterDto;

  @Random
  PlanificacionFilterDto planificacionFilterDto;

  private IcmWsCalcIncomeMapperDecorator getClassMock() {
    return Mockito.mock(IcmWsCalcIncomeMapperDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @BeforeEach
  void init(@Random final IcmParametrosentradaBlock icmParametrosentradaBlock,
      @Random final IcmParametrospaginacionBlock icmParametrospaginacionBlock,
      @Random final IcmParamcalconfchdiasBlock icmParamcalconfchdiasBlock,
      @Random final IcmParamcalconfpreciohoraBlock icmParamcalconfpreciohoraBlock,
      @Random final IcmParamcalconfchventaBlock icmParamcalconfchventaBlock,
      @Random final IcmParamcalpresupuestosrangoBlock icmParamcalpresupuestosrangoBlock,
      @Random final GenericTiendaResultItemDto genericTiendaResultItemDto,
      @Random final IcmParamcalprocesoBlock icmParamcalprocesoBlock,
      @Random final SaveResultDto saveResultDto, @Random final IcmParamcalconforigenBlock icmParamcalconforigenBlock,
      @Random final IcmParamcalcadenaRecord icmParamcalcadenaRecord,
      @Random final IcmParamcalempleadosdesplazRecord icmParamcalempleadosdesplazRecord,
      @Random final IcmParamcalempleadospresenciaRecord icmParamcalempleadospresenciaRecord,
      @Random final IcmParamcaltiendasRecord icmParamcaltiendasRecord,
      @Random final IcmParamcalempleadosRecord icmParamcalempleadosRecord,
      @Random final IcmParamcalflagcalculaRecord icmParamcalflagcalculaRecord,
      @Random final IcmParamcalflagcalculaBlock icmParamcalflagcalculaBlock,
      @Random final IcmParamcalpresenciamanualBlock icmParamcalpresenciamanualBlock,
      @Random final IcmParamcalpresenciamanualRecord icmParamcalpresenciamanualRecord,
      @Random final IcmParamcalsistdestinoBlock icmParamcalsistdestinoBlock,
      @Random final SistemaDestinoResponseDto sistemaDestinoResponseDto,
      @Random(type = ListaValoresBaseResultItemDto.class,
          size = 2) final List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDtoList,
      @Random final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto,
      @Random(type = ListaValoresDestinoResultItemDto.class,
          size = 2) final List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList,
      @Random final ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto,
      @Random final IcmParamcaltiposhoraBlock icmParamcaltiposhoraBlock,
      @Random final IcmParamcalusuarioBlock icmParamcalusuarioBlock) {

    // Instanciamos estas variables con un valor que concuerde en el converter a fecha
    this.icmListatiendasRecord.setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListatiendasRecord.setFechafin("2000-01-02T00:00:00.000Z");

    doReturn(icmParametrosentradaBlock).when(this.delegate).asIcmParametrosentradaBlock(this.genericFilterDto);
    doReturn(icmParametrospaginacionBlock).when(this.delegate).asIcmParametrospaginacionBlock(this.pageDto);
    doReturn(icmParamcalconfchdiasBlock).when(this.delegate).asIcmParamcalconfchdiasBlock(this.confChDiasMinimosFilterDto);
    doReturn(icmParamcalconfpreciohoraBlock).when(this.delegate).asIcmParamcalconfpreciohoraBlock(this.confPrecioHoraFilterDto);
    doReturn(icmParamcalconfchventaBlock).when(this.delegate).asIcmParamcalconfchventaBlock(this.confChTpVentaFilterDto);
    doReturn(icmParamcalpresupuestosrangoBlock).when(this.delegate).asIcmParamcalpresupuestosrangoBlock(this.presupuestosRangoFilterDto);
    doReturn(genericTiendaResultItemDto).when(this.delegate).asGenericTiendaResultItemDto(this.icmListatiendasRecord);
    doReturn(icmParamcalprocesoBlock).when(this.delegate).asIcmParamcalprocesoBlock(this.saveProcesoDto);
    doReturn(saveResultDto).when(this.delegate).asSaveResultDto(this.icmResultadoguardadoBlock);
    doReturn(icmParamcalconforigenBlock).when(this.delegate).asIcmParamconfBlock(this.configuracionesRequestDto);
    doReturn(icmParamcalcadenaRecord).when(this.delegate).asIcmParamcalcadenaRecord(this.genericFilterDto);
    doReturn(icmParamcalempleadosdesplazRecord).when(this.delegate).asIcmParamcalempleadosdesplazRecord(this.genericFilterDto);
    doReturn(icmParamcalempleadospresenciaRecord).when(this.delegate).asIcmParamcalempleadospresenciaRecord(this.genericFilterDto);
    doReturn(icmParamcaltiendasRecord).when(this.delegate).asIcmParamcaltiendasRecord(this.genericFilterDto);
    doReturn(icmParamcaltiendasRecord).when(this.delegate).asIcmParamcaltiendasRecord(this.searchTiendasFilterDto);
    doReturn(icmParamcaltiendasRecord).when(this.delegate).asIcmParamcaltiendasRecord(this.presenciaManualWlocFilterDto);
    doReturn(icmParamcaltiendasRecord).when(this.delegate).asIcmParamcaltiendasRecord(this.ventaManualWlocFilterDto);
    doReturn(icmParamcalempleadosRecord).when(this.delegate).asIcmParamcalempleadosRecord(this.genericFilterDto);
    doReturn(icmParamcalflagcalculaRecord).when(this.delegate).asIcmParamcalflagcalculaRecord(this.genericFilterDto);
    doReturn(icmParamcalflagcalculaBlock).when(this.delegate).asIcmParamcalflagcalculaBlock(this.genericFilterDto);
    doReturn(icmParamcalpresenciamanualBlock).when(this.delegate).asIcmParamcalpresenciamanualBlock(this.genericFilterDto);
    doReturn(icmParamcalpresenciamanualRecord).when(this.delegate).asIcmParamcalpresenciamanualRecord(this.genericFilterDto);
    doReturn(icmParamcalsistdestinoBlock).when(this.delegate).asIcmParamcalsistdestinoBlock(this.sistemaDestinoRequestDto);
    doReturn(sistemaDestinoResponseDto).when(this.delegate).asSistemaDestinoResponseDto(this.getsistdestinoOutput);
    doReturn(listaCondicionesBaseResultItemDto).when(this.delegate).asListaCondicionesBaseResultItemDto(this.icmListacondicionesbaseRecord);
    doReturn(listaValoresBaseResultItemDtoList).when(this.delegate).asListaValoresBaseResultItemDtoFromIcmListavaloresbasemanRecord(
        this.icmListacondicionesbaseRecord.getIcmListavaloresbaseman().getIcmListavaloresbasemanRecordSet());
    doReturn(listaCondicionesDestinoResultItemDto).when(this.delegate)
        .asListaCondicionesDestinoResultItemDto(this.icmListacondicionesdestinoRecord);
    doReturn(listaValoresDestinoResultItemDtoList).when(this.delegate)
        .asListaValoresDestinoResultItemDtoFromIcmListavaloresdestinomanRecord(
            this.icmListacondicionesdestinoRecord.getIcmListavaloresdestinoman().getIcmListavaloresdestinomanRecordSet());
    doReturn(icmParamcaltiposhoraBlock).when(this.delegate).asIcmParamcaltiposhoraBlock(this.tiposHoraRequestDto);
    doReturn(icmParamcalusuarioBlock).when(this.delegate).asIcmParamcalusuarioBlock(this.usuarioRequestDto);

  }

  @Test
  void asIcmParametrosentradaBlockTest() {
    final IcmParametrosentradaBlock result = this.icmWsCalcIncomeMapperDecorator.asIcmParametrosentradaBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParametrosentradaBlockGetIcmParametrosentradaRecordSetIsEmptyTest(
      @Random final IcmParametrosentradaBlock icmParametrosentradaBlock) {

    final IcmParametrosentradaBlock spiedVar = Mockito.spy(icmParametrosentradaBlock);

    doReturn(spiedVar).when(this.delegate).asIcmParametrosentradaBlock(this.genericFilterDto);
    doReturn(new ArrayList<IcmParametrosentradaRecord>()).when(spiedVar).getIcmParametrosentradaRecordSet();

    final IcmParametrosentradaBlock result = this.icmWsCalcIncomeMapperDecorator.asIcmParametrosentradaBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParametrospaginacionBlockTest() {
    final IcmParametrospaginacionBlock result = this.icmWsCalcIncomeMapperDecorator.asIcmParametrospaginacionBlock(this.pageDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParametrospaginacionBlockGetIcmParametrospaginacionRecordSetIsNullTest(
      @Random final IcmParametrospaginacionBlock icmParametrospaginacionBlock) {

    final IcmParametrospaginacionBlock spìedVar = Mockito.spy(icmParametrospaginacionBlock);

    doReturn(spìedVar).when(this.delegate).asIcmParametrospaginacionBlock(this.pageDto);
    doReturn(new ArrayList<IcmParametrospaginacionRecord>()).when(spìedVar).getIcmParametrospaginacionRecordSet();

    final IcmParametrospaginacionBlock result = this.icmWsCalcIncomeMapperDecorator.asIcmParametrospaginacionBlock(this.pageDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalconfchdiasBlockTest() {
    final IcmParamcalconfchdiasBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalconfchdiasBlock(this.confChDiasMinimosFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalconfchdiasBlockGetIcmParametrospaginacionRecordSetIsNullTest(
      @Random final IcmParamcalconfchdiasBlock cmParamcalconfchdiasBlock) {

    final IcmParamcalconfchdiasBlock spìedVar = Mockito.spy(cmParamcalconfchdiasBlock);

    doReturn(spìedVar).when(this.delegate).asIcmParamcalconfchdiasBlock(this.confChDiasMinimosFilterDto);
    doReturn(new ArrayList<IcmParamcalconfpreciohoraRecord>()).when(spìedVar).getIcmParamcalconfchdiasRecordSet();

    final IcmParamcalconfchdiasBlock result =
        this.icmWsCalcIncomeMapperDecorator.asIcmParamcalconfchdiasBlock(this.confChDiasMinimosFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalconfpreciohoraBlockTest() {
    final IcmParamcalconfpreciohoraBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalconfpreciohoraBlock(this.confPrecioHoraFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalconfpreciohoraBlockGetIcmParametrospaginacionRecordSetIsNullTest(
      @Random final IcmParamcalconfpreciohoraBlock icmParamcalconfpreciohoraBlock) {

    final IcmParamcalconfpreciohoraBlock spìedVar = Mockito.spy(icmParamcalconfpreciohoraBlock);

    doReturn(spìedVar).when(this.delegate).asIcmParamcalconfpreciohoraBlock(this.confPrecioHoraFilterDto);
    doReturn(new ArrayList<IcmParamcalconfpreciohoraRecord>()).when(spìedVar).getIcmParamcalconfpreciohoraRecordSet();

    final IcmParamcalconfpreciohoraBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalconfpreciohoraBlock(this.confPrecioHoraFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalconfchventaBlockTest() {
    final IcmParamcalconfchventaBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalconfchventaBlock(this.confChTpVentaFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalpresupuestosrangoBlockGetIcmParametrospaginacionRecordSetIsNullTest(
      @Random final IcmParamcalconfchventaBlock icmParamcalconfchventaBlock) {

    final IcmParamcalconfchventaBlock spìedVar = Mockito.spy(icmParamcalconfchventaBlock);

    doReturn(spìedVar).when(this.delegate).asIcmParamcalconfchventaBlock(this.confChTpVentaFilterDto);
    doReturn(new ArrayList<IcmParamcalconfchventaRecord>()).when(spìedVar).getIcmParamcalconfchventaRecordSet();

    final IcmParamcalconfchventaBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalconfchventaBlock(this.confChTpVentaFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalpresupuestosrangoBlockTest() {
    final IcmParamcalpresupuestosrangoBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalpresupuestosrangoBlock(this.presupuestosRangoFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalpresupuestosrangoBlockGetIcmParametrospaginacionRecordSetIsNullTest(
      @Random final IcmParamcalpresupuestosrangoBlock icmParamcalpresupuestosrangoBlock) {

    final IcmParamcalpresupuestosrangoBlock spìedVar = Mockito.spy(icmParamcalpresupuestosrangoBlock);

    doReturn(spìedVar).when(this.delegate).asIcmParamcalpresupuestosrangoBlock(this.presupuestosRangoFilterDto);
    doReturn(new ArrayList<IcmParamcalpresupuestosrangoRecord>()).when(spìedVar).getIcmParamcalpresupuestosrangoRecordSet();

    final IcmParamcalpresupuestosrangoBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalpresupuestosrangoBlock(this.presupuestosRangoFilterDto);

    assertNotNull(result);
  }

  @Test
  void asGenericTiendaResultItemDtoTest() {
    final GenericTiendaResultItemDto result = this.icmWsCalcIncomeMapperDecorator
        .asGenericTiendaResultItemDto(this.icmListatiendasRecord);

    assertNotNull(result);
  }

  @Test
  void asGenericTiendaResultItemDtoFechasNullTest() {

    this.icmListatiendasRecord.setFechainicio("");
    this.icmListatiendasRecord.setFechafin("");

    final GenericTiendaResultItemDto result = this.icmWsCalcIncomeMapperDecorator
        .asGenericTiendaResultItemDto(this.icmListatiendasRecord);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsConfPrecioHoraResultItemDtoTest(@Random final ConfPrecioHoraResultItemDto confPrecioHoraResultItemDto) {
    doReturn(confPrecioHoraResultItemDto).when(this.delegate).asConfPrecioHoraResultItemDto(this.icmListaconfpreciohoraRecordList.get(0));
    doReturn(confPrecioHoraResultItemDto).when(this.delegate).asConfPrecioHoraResultItemDto(this.icmListaconfpreciohoraRecordList.get(1));
  }

  @Test
  void asConfPrecioHoraResultItemDtoTest() {
    final List<ConfPrecioHoraResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asConfPrecioHoraResultItemDto(this.icmListaconfpreciohoraRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @BeforeEach
  void initAsGenericTiendaResultItemDtosTest(@Random final GenericTiendaResultItemDto genericTiendaResultItemDto) {
    // Instanciamos estas variables con un valor que concuerde en el converter a fecha
    this.icmListatiendasRecordList.get(0).setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListatiendasRecordList.get(0).setFechafin("2000-01-02T00:00:00.000Z");
    this.icmListatiendasRecordList.get(1).setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListatiendasRecordList.get(1).setFechafin("2000-01-02T00:00:00.000Z");

    doReturn(genericTiendaResultItemDto).when(this.delegate).asGenericTiendaResultItemDto(this.icmListatiendasRecordList.get(0));
    doReturn(genericTiendaResultItemDto).when(this.delegate).asGenericTiendaResultItemDto(this.icmListatiendasRecordList.get(1));
  }

  @Test
  void asGenericTiendaResultItemDtosTest() {
    final List<GenericTiendaResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asGenericTiendaResultItemDtos(this.icmListatiendasRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void asGenericTiendaResultItemDtosFechaIniFinEmptyTest() {

    this.icmListatiendasRecordList.get(0).setFechainicio("");
    this.icmListatiendasRecordList.get(0).setFechafin("");
    this.icmListatiendasRecordList.get(1).setFechainicio("");
    this.icmListatiendasRecordList.get(1).setFechafin("");

    final List<GenericTiendaResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asGenericTiendaResultItemDtos(this.icmListatiendasRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @BeforeEach
  void initAsGenericTiendaResultItemDtosTest(@Random final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto) {
    // Instanciamos estas variables con un valor que concuerde en el converter a fecha
    this.icmListaempleadosRecord.setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecord.setFechafin("2000-01-02T00:00:00.000Z");
    this.icmListaempleadosRecord.setFechainiciosec("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecord.setFechafinsec("2000-01-02T00:00:00.000Z");
    this.icmListaempleadosRecord.setFechainiciocom("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecord.setFechafincom("2000-01-02T00:00:00.000Z");
    this.icmListaempleadosRecord.setFechainiciopar("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecord.setFechafinpar("2000-01-02T00:00:00.000Z");
    this.icmListaempleadosRecord.setFecha("2000-01-01T00:00:00.000Z");

    doReturn(genericEmpleadoResultItemDto).when(this.delegate).asGenericEmpleadoResultItemDto(this.icmListaempleadosRecord);
  }

  @Test
  void asGenericEmpleadoResultItemDtoTest() {
    final GenericEmpleadoResultItemDto result = this.icmWsCalcIncomeMapperDecorator
        .asGenericEmpleadoResultItemDto(this.icmListaempleadosRecord);

    assertNotNull(result);
  }

  @Test
  void asGenericEmpleadoResultItemDtoFechasEmptyTest() {
    this.icmListaempleadosRecord.setFechainicio("");
    this.icmListaempleadosRecord.setFechafin("");
    this.icmListaempleadosRecord.setFechainiciosec("");
    this.icmListaempleadosRecord.setFechafinsec("");
    this.icmListaempleadosRecord.setFechainiciocom("");
    this.icmListaempleadosRecord.setFechafincom("");
    this.icmListaempleadosRecord.setFechainiciopar("");
    this.icmListaempleadosRecord.setFechafinpar("");
    this.icmListaempleadosRecord.setFecha("");

    final GenericEmpleadoResultItemDto result = this.icmWsCalcIncomeMapperDecorator
        .asGenericEmpleadoResultItemDto(this.icmListaempleadosRecord);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsGenericEmpleadoResultItemDtos(@Random final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto) {
    // Instanciamos estas variables con un valor que concuerde en el converter a fecha
    this.icmListaempleadosRecordList.get(0).setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(0).setFechafin("2000-02-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(0).setFechainiciocom("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(0).setFechafincom("2000-02-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(0).setFechainiciopar("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(0).setFechafinpar("2000-02-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(0).setFechainiciosec("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(0).setFechafinsec("2000-02-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(0).setFecha("2000-01-01T00:00:00.000Z");

    this.icmListaempleadosRecordList.get(1).setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(1).setFechafin("2000-02-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(1).setFechainiciocom("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(1).setFechafincom("2000-02-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(1).setFechainiciopar("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(1).setFechafinpar("2000-02-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(1).setFechainiciosec("2000-01-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(1).setFechafinsec("2000-02-01T00:00:00.000Z");
    this.icmListaempleadosRecordList.get(1).setFecha("2000-01-01T00:00:00.000Z");

    doReturn(genericEmpleadoResultItemDto).when(this.delegate).asGenericEmpleadoResultItemDto(this.icmListaempleadosRecordList.get(0));
    doReturn(genericEmpleadoResultItemDto).when(this.delegate).asGenericEmpleadoResultItemDto(this.icmListaempleadosRecordList.get(1));
  }

  @Test
  void asGenericEmpleadoResultItemDtosTest() {
    final List<GenericEmpleadoResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asGenericEmpleadoResultItemDtos(this.icmListaempleadosRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());

  }

  @Test
  void asGenericEmpleadoResultItemDtosTest2(@Random final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto) {
    final IcmListaempleadosRecord spiedIcmListaempleadosRecord = Mockito.spy(this.icmListaempleadosRecordList.get(0));
    final IcmListaseccionesBlock spiedIcmListaseccionesBlock = Mockito.spy(spiedIcmListaempleadosRecord.getIcmListasecciones());
    Mockito.when(spiedIcmListaseccionesBlock.getIcmListaseccionesRecordSet()).thenReturn(Collections.emptyList());
    spiedIcmListaempleadosRecord.setIcmListasecciones(spiedIcmListaseccionesBlock);
    this.icmListaempleadosRecordList.clear();
    this.icmListaempleadosRecordList.add(spiedIcmListaempleadosRecord);

    doReturn(genericEmpleadoResultItemDto).when(this.delegate).asGenericEmpleadoResultItemDto(spiedIcmListaempleadosRecord);

    final List<GenericEmpleadoResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asGenericEmpleadoResultItemDtos(this.icmListaempleadosRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());

  }

  @BeforeEach
  void initAsAusenciasResultItemDtosTest(@Random final AusenciasResultItemDto ausenciasResultItemDto) {
    // Instanciamos estas variables con un valor que concuerde en el converter a fecha
    this.icmListaausenciasRecordList.get(0).setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListaausenciasRecordList.get(0).setFechafin("2000-02-01T00:00:00.000Z");

    this.icmListaausenciasRecordList.get(1).setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListaausenciasRecordList.get(1).setFechafin("2000-02-01T00:00:00.000Z");

    doReturn(ausenciasResultItemDto).when(this.delegate).asAusenciasResultItemDto(this.icmListaausenciasRecordList.get(0));
    doReturn(ausenciasResultItemDto).when(this.delegate).asAusenciasResultItemDto(this.icmListaausenciasRecordList.get(1));
  }

  @Test
  void asAusenciasResultItemDtosTest() {
    final List<AusenciasResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asAusenciasResultItemDtos(this.icmListaausenciasRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void asAusenciasResultItemDtosFechasEmptyTest() {

    this.icmListaausenciasRecordList.get(0).setFechainicio("");
    this.icmListaausenciasRecordList.get(0).setFechafin("");
    this.icmListaausenciasRecordList.get(1).setFechainicio("");
    this.icmListaausenciasRecordList.get(1).setFechafin("");

    final List<AusenciasResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asAusenciasResultItemDtos(this.icmListaausenciasRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @BeforeEach
  void initAsGenericEmpleadoResultItemDtosSearchEmpleadosTest(@Random final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto) {
    // Instanciamos estas variables con un valor que concuerde en el converter a fecha
    this.icmListaempleadoRecordList.get(0).setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechafin("2000-02-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechainiciosec("2000-01-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechafinsec("2000-02-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechainicioloc("2000-01-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechafinloc("2000-02-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechaantiguedad("2000-01-01T00:00:00.000Z");

    this.icmListaempleadoRecordList.get(1).setFechainicio("");
    this.icmListaempleadoRecordList.get(1).setFechafin("");
    this.icmListaempleadoRecordList.get(1).setFechainiciosec("");
    this.icmListaempleadoRecordList.get(1).setFechafinsec("");
    this.icmListaempleadoRecordList.get(1).setFechainicioloc("");
    this.icmListaempleadoRecordList.get(1).setFechafinloc("");
    this.icmListaempleadoRecordList.get(1).setFechaantiguedad("");

    doReturn(genericEmpleadoResultItemDto).when(this.delegate)
        .asGenericEmpleadoResultItemDtosSearchEmpleados(this.icmListaempleadoRecordList.get(0));
    doReturn(genericEmpleadoResultItemDto).when(this.delegate)
        .asGenericEmpleadoResultItemDtosSearchEmpleados(this.icmListaempleadoRecordList.get(1));
  }

  @Test
  void asGenericEmpleadoResultItemDtosSearchEmpleadosTest() {
    final List<GenericEmpleadoResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asGenericEmpleadoResultItemDtosSearchEmpleados(this.icmListaempleadoRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void asTiendaOnlineResultItemDtoTest() {
    final List<TiendaOnlineResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asTiendaOnlineResultItemDto(this.icmListatiendasRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void asTiendaOnlineResultItemDtoNullTest() {
    final List<TiendaOnlineResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asTiendaOnlineResultItemDto((List<IcmListatiendasRecord>) null);

    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  void asIcmParamcalprocesoBlockTest() {
    final IcmParamcalprocesoBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalprocesoBlock(this.saveProcesoDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalprocesoBlockGetIcmParamcalprocesoRecordSetIsEmptyTest(@Random final IcmParamcalprocesoBlock icmParamcalprocesoBlock) {

    final IcmParamcalprocesoBlock spiedVar = Mockito.spy(icmParamcalprocesoBlock);
    doReturn(spiedVar).when(this.delegate).asIcmParamcalprocesoBlock(this.saveProcesoDto);
    doReturn(new ArrayList<IcmParamcalprocesoRecord>()).when(spiedVar).getIcmParamcalprocesoRecordSet();

    final IcmParamcalprocesoBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalprocesoBlock(this.saveProcesoDto);

    assertNotNull(result);
  }

  @Test
  void asSaveResultDtoTest() {
    final SaveResultDto result = this.icmWsCalcIncomeMapperDecorator
        .asSaveResultDto(this.icmResultadoguardadoBlock);

    assertNotNull(result);
  }

  @Test
  void asIcmParamconfBlockTest() {
    final IcmParamcalconforigenBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamconfBlock(this.configuracionesRequestDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamconfBlockGetIcmParamcalconforigenRecordSetIsEmptyTest(
      @Random final IcmParamcalconforigenBlock icmParamcalconforigenBlock) {

    final IcmParamcalconforigenBlock spiedVar = Mockito.spy(icmParamcalconforigenBlock);
    doReturn(spiedVar).when(this.delegate).asIcmParamconfBlock(this.configuracionesRequestDto);
    doReturn(new ArrayList<IcmParamcalconforigenRecord>()).when(spiedVar).getIcmParamcalconforigenRecordSet();

    final IcmParamcalconforigenBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamconfBlock(this.configuracionesRequestDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsConfiguracionesResponseDtoTest(@Random final ConfiguracionesResponseDto configuracionesResponseDto,
      @Random final ConfiguracionItemDto configuracionItemDto) {
    doReturn(configuracionesResponseDto).when(this.delegate)
        .asConfiguracionesResponseDto(this.getconfiguracionOutput, this.idOrigen);

    this.getconfiguracionOutput.getIcmListaconforigen()
        .getIcmListaconforigenRecordSet()
        .forEach(x -> {
          doReturn(configuracionItemDto).when(this.delegate)
              .asConfiguracionItemDto(x, this.idOrigen);
        });
  }

  @Test
  void asConfiguracionesResponseDtoTest() {
    final ConfiguracionesResponseDto result = this.icmWsCalcIncomeMapperDecorator
        .asConfiguracionesResponseDto(this.getconfiguracionOutput, this.idOrigen);

    assertNotNull(result);
  }

  @Test
  void asConfiguracionesResponseDtoGetIcmListaconforigenIsNullTest() {

    this.getconfiguracionOutput.setIcmListaconforigen(null);

    final ConfiguracionesResponseDto result = this.icmWsCalcIncomeMapperDecorator
        .asConfiguracionesResponseDto(this.getconfiguracionOutput, this.idOrigen);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalcadenaBlockTest() {
    final IcmParamcalcadenaBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalcadenaBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalempleadosdesplazBlock() {
    final IcmParamcalempleadosdesplazBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalempleadosdesplazBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalempleadospresenciaBlockTest() {
    final IcmParamcalempleadospresenciaBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalempleadospresenciaBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcaltiendasBlockTest() {
    final IcmParamcaltiendasBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaltiendasBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcaltiendasBlockTest2() {
    final IcmParamcaltiendasBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaltiendasBlock(this.searchTiendasFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcaltiendasBlockTest3() {
    final IcmParamcaltiendasBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaltiendasBlock(this.presenciaManualWlocFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcaltiendasBlockNullTest3() {
    final IcmParamcaltiendasBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaltiendasBlock((PresenciaManualWlocFilterDto) null);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcaltiendasBlockTest4() {
    final IcmParamcaltiendasBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaltiendasBlock(this.ventaManualWlocFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcaltiendasBlockNullTest4() {
    final IcmParamcaltiendasBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaltiendasBlock((VentaManualWlocFilterDto) null);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcaltiendasBlockNullTest() {
    final IcmParamcaltiendasBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaltiendasBlock((GenericFilterDto) null);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsIcmParamcalempleadoBlockTest(@Random final IcmParamcalempleadoRecord icmParamcalempleadoRecord,
      @Random final IcmParamcalempleadoBlock icmParamcalempleadoBlock) {
    doReturn(icmParamcalempleadoRecord).when(this.delegate).asIcmParamcalempleadoRecord(this.searchEmpleadosFilterDto);
    doReturn(icmParamcalempleadoBlock).when(this.delegate).asIcmParamcalempleadoBlock(this.searchEmpleadosFilterDto);
  }

  @Test
  void asIcmParamcalempleadoBlockTest() {
    final IcmParamcalempleadoBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalempleadoBlock(this.searchEmpleadosFilterDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsIcmParamcalempleadoBlockTest2(@Random final IcmParamcalempleadoBlock icmParamcalempleadoBlock,
      @Random final IcmParamcalempleadoRecord icmParamcalempleadoRecord) {
    doReturn(icmParamcalempleadoRecord).when(this.delegate).asIcmParamcalempleadoRecord(this.genericFilterDto);
    doReturn(icmParamcalempleadoBlock).when(this.delegate).asIcmParamcalempleadoBlock(this.genericFilterDto);
  }

  @Test
  void asIcmParamcalempleadoBlockTest2() {
    final IcmParamcalempleadoBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalempleadoBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalempleadoBlockNullTest(@Random final IcmParamcalempleadoBlock icmParamcalempleadoBlock) {

    doReturn(icmParamcalempleadoBlock).when(this.delegate).asIcmParamcalempleadoBlock((GenericFilterDto) null);

    final IcmParamcalempleadoBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalempleadoBlock((GenericFilterDto) null);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalempleadosBlock() {
    final IcmParamcalempleadosBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalempleadosBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsIcmParamcaldesplazrealBlockTest(@Random final IcmParamcaldesplazrealRecord icmParamcaldesplazrealRecord) {
    this.desplazamientoRealFilterDto.getItem().forEach(x -> {
      doReturn(icmParamcaldesplazrealRecord).when(this.delegate).asIcmParamcaldesplazrealRecord(x);
    });
  }

  @Test
  void asIcmParamcaldesplazrealBlockTest() {
    final IcmParamcaldesplazrealBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaldesplazrealBlock(this.desplazamientoRealFilterDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsIcmParamcalpresupuestoswlocBlockTest(@Random final IcmParamcalpresupuestoswlocRecord icmParamcalpresupuestoswlocRecord,
      @Random final IcmParamcalpresupuestoswlocBlock icmParamcalpresupuestoswlocBlock) {
    this.presupuestosWlocFilterDto.getItem().forEach(x -> {
      doReturn(icmParamcalpresupuestoswlocRecord).when(this.delegate).asIcmParamcalpresupuestoswlocRecord(x);
    });

    doReturn(icmParamcalpresupuestoswlocBlock).when(this.delegate).asIcmParamcalpresupuestoswlocBlock(this.presupuestosWlocFilterDto);

  }

  @Test
  void asIcmParamcalpresupuestoswlocBlockTest() {
    final IcmParamcalpresupuestoswlocBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalpresupuestoswlocBlock(this.presupuestosWlocFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalflagcalculaBlockTest() {
    final IcmParamcalflagcalculaBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalflagcalculaBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalpresenciamanualBlockTest() {
    final IcmParamcalpresenciamanualBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalpresenciamanualBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsPresenciaManualWlocResultItemDtoTest(@Random final PresenciaManualWlocResultItemDto presenciaManualWlocResultItemDto) {
    doReturn(presenciaManualWlocResultItemDto).when(this.delegate)
        .asPresenciaManualWlocResultItemDto(this.icmListapresenciamanwlocRecordList.get(0));
    doReturn(presenciaManualWlocResultItemDto).when(this.delegate)
        .asPresenciaManualWlocResultItemDto(this.icmListapresenciamanwlocRecordList.get(1));
  }

  @Test
  void asPresenciaManualWlocResultItemDtoTest() {
    final List<PresenciaManualWlocResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asPresenciaManualWlocResultItemDto(this.icmListapresenciamanwlocRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void asPresenciaManualWlocResultItemDtoElseTest(@Random final PresenciaManualWlocResultItemDto presenciaManualWlocResultItemDto) {

    final IcmListapresenciamanwlocRecord spiedItem = Mockito.spy(this.icmListapresenciamanwlocRecordList.get(0));
    final IcmListaseccionespresenciasBlock spiedItem2 = Mockito.spy(spiedItem.getIcmListaseccionespresencias());
    Mockito.when(spiedItem2.getIcmListaseccionespresenciasRecordSet()).thenReturn(Collections.emptyList());
    spiedItem.setIcmListaseccionespresencias(spiedItem2);
    this.icmListapresenciamanwlocRecordList.clear();
    this.icmListapresenciamanwlocRecordList.add(spiedItem);

    doReturn(presenciaManualWlocResultItemDto).when(this.delegate).asPresenciaManualWlocResultItemDto(spiedItem);

    final List<PresenciaManualWlocResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asPresenciaManualWlocResultItemDto(this.icmListapresenciamanwlocRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @BeforeEach
  void initAsVentaManualWlocResultItemDtoTest(@Random final VentaManualWlocResultItemDto ventaManualWlocResultItemDto) {
    doReturn(ventaManualWlocResultItemDto).when(this.delegate).asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList.get(0));
    doReturn(ventaManualWlocResultItemDto).when(this.delegate).asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList.get(1));
  }

  @Test
  void asVentaManualWlocResultItemDtoTest() {
    final List<VentaManualWlocResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void asVentaManualWlocResultItemDtoElseTest(@Random final VentaManualWlocResultItemDto ventaManualWlocResultItemDto) {

    final IcmListaventamanwlocRecord spiedItem = Mockito.spy(this.icmListaventamanwlocRecordList.get(0));
    final IcmListaseccionesventaBlock spiedItem2 = Mockito.spy(spiedItem.getIcmListaseccionesventa());
    Mockito.when(spiedItem2.getIcmListaseccionesventaRecordSet()).thenReturn(Collections.emptyList());
    spiedItem.setIcmListaseccionesventa(spiedItem2);
    this.icmListaventamanwlocRecordList.clear();
    this.icmListaventamanwlocRecordList.add(spiedItem);

    doReturn(ventaManualWlocResultItemDto).when(this.delegate).asVentaManualWlocResultItemDto(spiedItem);

    final List<VentaManualWlocResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @BeforeEach
  void initAsIcmParamcalsincroBlockTest(@Random final IcmParamcalsincroRecord icmParamcalsincroRecord) {
    for (int i = 0; i < this.sincronizacionFilterDto.getItems().size(); i++) {
      doReturn(icmParamcalsincroRecord).when(this.delegate).asIcmParamcalsincroRecord(this.sincronizacionFilterDto.getItems().get(i));
    }
  }

  @Test
  void asIcmParamcalsincroBlockTest() {
    final IcmParamcalsincroBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalsincroBlock(this.sincronizacionFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParamcalsistdestinoBlockTest() {
    final IcmParamcalsistdestinoBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalsistdestinoBlock(this.sistemaDestinoRequestDto);

    assertNotNull(result);
  }

  @Test
  void asSistemaDestinoResponseDtoTest() {
    final SistemaDestinoResponseDto result = this.icmWsCalcIncomeMapperDecorator
        .asSistemaDestinoResponseDto(this.getsistdestinoOutput);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsCatalogoResponseDtoTest(@Random final CatalogoResponseDto catalogoResponseDto,
      @Random final CatalogoResultItemDto catalogoResultItemDto) {
    doReturn(catalogoResponseDto).when(this.delegate).asCatalogoResponseDto(this.getcatalogoOutput);

    this.getcatalogoOutput.getIcmListacatalogo()
        .getIcmListacatalogoRecordSet()
        .stream()
        .map(record -> doReturn(catalogoResultItemDto).when(this.delegate).asCatalogoResponseItemDto(record));
  }

  @Test
  void asCatalogoResponseDtoTest() {
    final CatalogoResponseDto result = this.icmWsCalcIncomeMapperDecorator
        .asCatalogoResponseDto(this.getcatalogoOutput);

    assertNotNull(result);
  }

  @Test
  void asListaCondicionesBaseResultItemDtoTest() {
    final ListaCondicionesBaseResultItemDto result = this.icmWsCalcIncomeMapperDecorator
        .asListaCondicionesBaseResultItemDto(this.icmListacondicionesbaseRecord);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsListaCondicionesBaseResultItemDtoTest2(@Random final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto,
      @Random(type = ListaValoresBaseResultItemDto.class,
          size = 2) final List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDtoList) {
    doReturn(listaCondicionesBaseResultItemDto).when(this.delegate)
        .asListaCondicionesBaseResultItemDto(this.icmListacondicionesbaseRecordList.get(0));
    doReturn(listaValoresBaseResultItemDtoList).when(this.delegate)
        .asListaValoresBaseResultItemDtoFromIcmListavaloresbasemanRecord(this.icmListacondicionesbaseRecordList.get(0)
            .getIcmListavaloresbaseman().getIcmListavaloresbasemanRecordSet());

    doReturn(listaCondicionesBaseResultItemDto).when(this.delegate)
        .asListaCondicionesBaseResultItemDto(this.icmListacondicionesbaseRecordList.get(1));
    doReturn(listaValoresBaseResultItemDtoList).when(this.delegate)
        .asListaValoresBaseResultItemDtoFromIcmListavaloresbasemanRecord(this.icmListacondicionesbaseRecordList.get(1)
            .getIcmListavaloresbaseman().getIcmListavaloresbasemanRecordSet());
  }

  @Test
  void asListaCondicionesBaseResultItemDtoTest2() {
    final List<ListaCondicionesBaseResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asListaCondicionesBaseResultItemDto(this.icmListacondicionesbaseRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void asListaCondicionesBaseResultItemDtoGetIcmListavaloresbasemanIsNullTest() {

    this.icmListacondicionesbaseRecord.setIcmListavaloresbaseman(null);

    final ListaCondicionesBaseResultItemDto result = this.icmWsCalcIncomeMapperDecorator
        .asListaCondicionesBaseResultItemDto(this.icmListacondicionesbaseRecord);

    assertNotNull(result);
  }

  @Test
  void asListaCondicionesDestinoResultItemDtoTest() {
    final ListaCondicionesDestinoResultItemDto result = this.icmWsCalcIncomeMapperDecorator
        .asListaCondicionesDestinoResultItemDto(this.icmListacondicionesdestinoRecord);

    assertNotNull(result);
  }

  @Test
  void asListaCondicionesDestinoResultItemDtoGetIcmListavaloresdestinomanIsNullTest() {

    this.icmListacondicionesdestinoRecord.setIcmListavaloresdestinoman(null);

    final ListaCondicionesDestinoResultItemDto result = this.icmWsCalcIncomeMapperDecorator
        .asListaCondicionesDestinoResultItemDto(this.icmListacondicionesdestinoRecord);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsListaCondicionesDestinoResultItemDtoTest2(
      @Random(type = ListaValoresDestinoResultItemDto.class,
          size = 2) final List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList,
      @Random final ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto) {

    doReturn(listaCondicionesDestinoResultItemDto).when(this.delegate)
        .asListaCondicionesDestinoResultItemDto(this.icmListacondicionesdestinoRecordList.get(0));
    doReturn(listaValoresDestinoResultItemDtoList).when(this.delegate)
        .asListaValoresDestinoResultItemDtoFromIcmListavaloresdestinomanRecord(
            this.icmListacondicionesdestinoRecordList.get(0).getIcmListavaloresdestinoman().getIcmListavaloresdestinomanRecordSet());

    doReturn(listaCondicionesDestinoResultItemDto).when(this.delegate)
        .asListaCondicionesDestinoResultItemDto(this.icmListacondicionesdestinoRecordList.get(1));
    doReturn(listaValoresDestinoResultItemDtoList).when(this.delegate)
        .asListaValoresDestinoResultItemDtoFromIcmListavaloresdestinomanRecord(
            this.icmListacondicionesdestinoRecordList.get(1).getIcmListavaloresdestinoman().getIcmListavaloresdestinomanRecordSet());
  }

  @Test
  void asListaCondicionesDestinoResultItemDtoTest2() {
    final List<ListaCondicionesDestinoResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asListaCondicionesDestinoResultItemDto(this.icmListacondicionesdestinoRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @BeforeEach
  void initAsEstructurasComResultItemDtoTest(@Random final EstructurasComResultItemDto estructurasComResultItemDto,
      @Random final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto,
      @Random(type = ListaValoresBaseResultItemDto.class,
          size = 2) final List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDtoList,
      @Random final ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto,
      @Random(type = ListaValoresDestinoResultItemDto.class,
          size = 2) final List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList) {

    doReturn(estructurasComResultItemDto).when(this.delegate)
        .asEstructurasComResultItemDto(this.icmListaestructuraRecord);

    for (int i = 0; i < this.icmListaestructuraRecord.getIcmListacondicionesbase().getIcmListacondicionesbaseRecordSet().size(); i++) {
      doReturn(listaCondicionesBaseResultItemDto).when(this.delegate)
          .asListaCondicionesBaseResultItemDto(
              this.icmListaestructuraRecord.getIcmListacondicionesbase().getIcmListacondicionesbaseRecordSet().get(i));
      doReturn(listaValoresBaseResultItemDtoList).when(this.delegate)
          .asListaValoresBaseResultItemDtoFromIcmListavaloresbasemanRecord(
              this.icmListaestructuraRecord.getIcmListacondicionesbase().getIcmListacondicionesbaseRecordSet().get(i)
                  .getIcmListavaloresbaseman().getIcmListavaloresbasemanRecordSet());
    }

    for (int i = 0; i < this.icmListaestructuraRecord.getIcmListacondicionesdestino().getIcmListacondicionesdestinoRecordSet()
        .size(); i++) {
      doReturn(listaCondicionesDestinoResultItemDto).when(this.delegate)
          .asListaCondicionesDestinoResultItemDto(
              this.icmListaestructuraRecord.getIcmListacondicionesdestino().getIcmListacondicionesdestinoRecordSet().get(i));
      doReturn(listaValoresDestinoResultItemDtoList).when(this.delegate)
          .asListaValoresDestinoResultItemDtoFromIcmListavaloresdestinomanRecord(
              this.icmListaestructuraRecord.getIcmListacondicionesdestino().getIcmListacondicionesdestinoRecordSet().get(i)
                  .getIcmListavaloresdestinoman().getIcmListavaloresdestinomanRecordSet());
    }

  }

  @Test
  void asEstructurasComResultItemDtoTest() {
    final EstructurasComResultItemDto result = this.icmWsCalcIncomeMapperDecorator
        .asEstructurasComResultItemDto(this.icmListaestructuraRecord);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsEstructurasComResultItemDtosTest(@Random final EstructurasComResultItemDto estructurasComResultItemDto,
      @Random final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto,
      @Random(type = ListaValoresBaseResultItemDto.class, size = 2) final List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDto,
      @Random(type = ListaValoresDestinoResultItemDto.class,
          size = 2) final List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList,
      @Random final ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto) {

    // get(0)
    doReturn(estructurasComResultItemDto).when(this.delegate).asEstructurasComResultItemDto(this.icmListaestructuraRecordlist.get(0));

    for (int i = 0; i < this.icmListaestructuraRecordlist.get(0).getIcmListacondicionesbase().getIcmListacondicionesbaseRecordSet()
        .size(); i++) {
      doReturn(listaCondicionesBaseResultItemDto).when(this.delegate).asListaCondicionesBaseResultItemDto(
          this.icmListaestructuraRecordlist.get(0).getIcmListacondicionesbase()
              .getIcmListacondicionesbaseRecordSet().get(i));
      doReturn(listaValoresBaseResultItemDto).when(this.delegate).asListaValoresBaseResultItemDtoFromIcmListavaloresbasemanRecord(
          this.icmListaestructuraRecordlist.get(0).getIcmListacondicionesbase()
              .getIcmListacondicionesbaseRecordSet().get(i).getIcmListavaloresbaseman().getIcmListavaloresbasemanRecordSet());
    }

    for (int i = 0; i < this.icmListaestructuraRecordlist.get(0).getIcmListacondicionesdestino().getIcmListacondicionesdestinoRecordSet()
        .size(); i++) {
      doReturn(listaCondicionesDestinoResultItemDto).when(this.delegate).asListaCondicionesDestinoResultItemDto(
          this.icmListaestructuraRecordlist.get(0).getIcmListacondicionesdestino()
              .getIcmListacondicionesdestinoRecordSet().get(i));
      doReturn(listaValoresDestinoResultItemDtoList).when(this.delegate)
          .asListaValoresDestinoResultItemDtoFromIcmListavaloresdestinomanRecord(
              this.icmListaestructuraRecordlist.get(0).getIcmListacondicionesdestino()
                  .getIcmListacondicionesdestinoRecordSet().get(i).getIcmListavaloresdestinoman().getIcmListavaloresdestinomanRecordSet());
    }

    // get(1)
    doReturn(estructurasComResultItemDto).when(this.delegate).asEstructurasComResultItemDto(this.icmListaestructuraRecordlist.get(1));

    for (int i = 0; i < this.icmListaestructuraRecordlist.get(1).getIcmListacondicionesbase().getIcmListacondicionesbaseRecordSet()
        .size(); i++) {
      doReturn(listaCondicionesBaseResultItemDto).when(this.delegate).asListaCondicionesBaseResultItemDto(
          this.icmListaestructuraRecordlist.get(1).getIcmListacondicionesbase()
              .getIcmListacondicionesbaseRecordSet().get(i));
      doReturn(listaValoresBaseResultItemDto).when(this.delegate).asListaValoresBaseResultItemDtoFromIcmListavaloresbasemanRecord(
          this.icmListaestructuraRecordlist.get(1).getIcmListacondicionesbase()
              .getIcmListacondicionesbaseRecordSet().get(i).getIcmListavaloresbaseman().getIcmListavaloresbasemanRecordSet());
    }

    for (int i = 0; i < this.icmListaestructuraRecordlist.get(1).getIcmListacondicionesdestino().getIcmListacondicionesdestinoRecordSet()
        .size(); i++) {
      doReturn(listaCondicionesDestinoResultItemDto).when(this.delegate).asListaCondicionesDestinoResultItemDto(
          this.icmListaestructuraRecordlist.get(1).getIcmListacondicionesdestino()
              .getIcmListacondicionesdestinoRecordSet().get(i));
      doReturn(listaValoresDestinoResultItemDtoList).when(this.delegate)
          .asListaValoresDestinoResultItemDtoFromIcmListavaloresdestinomanRecord(
              this.icmListaestructuraRecordlist.get(1).getIcmListacondicionesdestino()
                  .getIcmListacondicionesdestinoRecordSet().get(i).getIcmListavaloresdestinoman().getIcmListavaloresdestinomanRecordSet());
    }

  }

  @Test
  void asEstructurasComResultItemDtosTest() {
    final List<EstructurasComResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asEstructurasComResultItemDtos(this.icmListaestructuraRecordlist);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void asIcmParamcaltiposhoraBlockTest() {
    final IcmParamcaltiposhoraBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaltiposhoraBlock(this.tiposHoraRequestDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsTiposHoraResponseDto(@Random final TiposHoraResponseDto tiposHoraResponseDto,
      @Random final TiposHoraResultItemDto tiposHoraResultItemDto) {
    doReturn(tiposHoraResponseDto).when(this.delegate).asTiposHoraResponseDto(this.gettiposhoraOutput);

    for (int i = 0; i < this.gettiposhoraOutput.getIcmListatiposhora().getIcmListatiposhoraRecordSet().size(); i++) {
      doReturn(tiposHoraResultItemDto).when(this.delegate).asTiposHoraResultItemDto(
          this.gettiposhoraOutput.getIcmListatiposhora().getIcmListatiposhoraRecordSet().get(i));
    }
  }

  @Test
  void asTiposHoraResponseDto() {
    final TiposHoraResponseDto result = this.icmWsCalcIncomeMapperDecorator
        .asTiposHoraResponseDto(this.gettiposhoraOutput);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsUsuarioResponseDto(@Random final UsuarioResponseDto usuarioResponseDto,
      @Random final UsuarioResultItemDto usuarioResultItemDto) {
    doReturn(usuarioResponseDto).when(this.delegate).asUsuarioResponseDto(this.getmailOutput);

    for (int i = 0; i < this.getmailOutput.getIcmListamail().getIcmListamailRecordSet().size(); i++) {
      doReturn(usuarioResultItemDto).when(this.delegate).asUsuarioResultItemDto(
          this.getmailOutput.getIcmListamail().getIcmListamailRecordSet().get(i));
    }
  }

  @Test
  void asIcmParamcalusuarioBlockTest() {
    final IcmParamcalusuarioBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalusuarioBlock(this.usuarioRequestDto);

    assertNotNull(result);
  }

  @Test
  void asUsuarioResponseDto() {
    final UsuarioResponseDto result = this.icmWsCalcIncomeMapperDecorator
        .asUsuarioResponseDto(this.getmailOutput);

    assertNotNull(result);
  }

  @Test
  void asClaseResponseDtoTest(@Random final GetclasesOutput getclasesOutput) {
    when(this.delegate.asClaseResponseDto(any(GetclasesOutput.class))).thenReturn(new ClaseResponseDto());
    final ClaseResponseDto result = this.icmWsCalcIncomeMapperDecorator.asClaseResponseDto(getclasesOutput);
    verify(this.delegate, times(1)).asClaseResponseDto(getclasesOutput);
    getclasesOutput.getIcmListaclases().getIcmListaclasesRecordSet().forEach(x -> {
      verify(this.delegate, times(1)).asClaseResultItemDto(x);
    });
    assertNotNull(result);
    assertNotNull(result.getItems());
    assertEquals(getclasesOutput.getIcmListaclases().getIcmListaclasesRecordSet().size(), result.getItems().size());
  }

  @Test
  void asClaseResponseDtoNullBlockTest(@Random final GetclasesOutput getclasesOutput) {
    getclasesOutput.setIcmListaclases(null);
    when(this.delegate.asClaseResponseDto(any(GetclasesOutput.class))).thenReturn(new ClaseResponseDto());
    final ClaseResponseDto result = this.icmWsCalcIncomeMapperDecorator.asClaseResponseDto(getclasesOutput);
    assertNotNull(result);
    assertNotNull(result.getItems());
    assertTrue(result.getItems().isEmpty());
  }

  @Test
  void asClaseResultItemDtoTest(@Random final IcmListaclasesRecord record, @Random final ClaseResultItemDto item) {
    when(this.delegate.asClaseResultItemDto(any(IcmListaclasesRecord.class))).thenReturn(item);
    record.setEstadosil("2,3,15");
    final ClaseResultItemDto result = this.icmWsCalcIncomeMapperDecorator.asClaseResultItemDto(record);

    verify(this.delegate).asClaseResultItemDto(record);
    assertNotNull(result);
    assertEquals(item, result);
    assertNotNull(item.getIdsEstadoSil());
    assertEquals(Arrays.asList("2", "3", "15"), item.getIdsEstadoSil());
  }

  @Test
  void asIcmParamcalorigenBlockTest(@Random final ClaseRequestDto request, @Random final IcmParamcalorigenRecord record) {
    when(this.delegate.asIcmParamcalorigenBlock(any(ClaseRequestDto.class))).thenReturn(new IcmParamcalorigenBlock());
    when(this.delegate.asIcmParamcalorigenRecord(any(ClaseRequestDto.class))).thenReturn(record);
    final IcmParamcalorigenBlock result = this.icmWsCalcIncomeMapperDecorator.asIcmParamcalorigenBlock(request);

    verify(this.delegate).asIcmParamcalorigenBlock(request);
    verify(this.delegate).asIcmParamcalorigenRecord(request);
    assertEquals(1, result.getIcmParamcalorigenRecordSet().size());
    assertEquals(record, result.getIcmParamcalorigenRecordSet().get(0));
  }

  @BeforeEach
  void initAsIcmParamcalliquidacionBlockTest(@Random final IcmParamcalliquidacionRecord icmParamcalliquidacionRecord) {
    for (int i = 0; i < this.liquidacionFilterDto.getItems().size(); i++) {
      doReturn(icmParamcalliquidacionRecord).when(this.delegate)
          .asIcmParamcalliquidacionRecord(this.liquidacionFilterDto.getItems().get(i));
    }
  }

  @Test
  void asIcmParamcalliquidacionBlockTest() {
    final IcmParamcalliquidacionBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalliquidacionBlock(this.liquidacionFilterDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsIcmParamcalplanificacionBlockTest(@Random final IcmParamcalplanificadorRecord icmParamcalplanificadorRecord) {
    for (int i = 0; i < this.planificacionFilterDto.getItems().size(); i++) {
      doReturn(icmParamcalplanificadorRecord).when(this.delegate)
          .asIcmParamcalplanificadorRecord(this.planificacionFilterDto.getItems().get(i));
    }
  }

  @Test
  void asIcmParamcalplanificacionBlockTest() {
    final IcmParamcalplanificadorBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalplanificadorBlock(this.planificacionFilterDto);

    assertNotNull(result);
  }
}
