package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.Collections;
import java.util.List;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResultItemDto;
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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcatalogoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetsistdestinoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiposhoraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaausenciasRecord;
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
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraBlock;
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
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsincroBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsincroRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsistdestinoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiposhoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
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
public class IcmWsCalcIncomeMapperDecoratorTest {

  @Mock
  @Qualifier("delegate")
  IcmWsCalcIncomeMapper delegate;

  @InjectMocks
  IcmWsCalcIncomeMapperDecorator icmWsCalcIncomeMapperDecorator = getClassMock();

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
  GettiposhoraOutput gettiposhoraOutput;

  private IcmWsCalcIncomeMapperDecorator getClassMock() {
    return Mockito.mock(IcmWsCalcIncomeMapperDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @BeforeEach
  void init(@Random IcmParametrosentradaBlock icmParametrosentradaBlock,
      @Random IcmParametrospaginacionBlock icmParametrospaginacionBlock,
      @Random IcmParamcalconfchdiasBlock icmParamcalconfchdiasBlock,
      @Random IcmParamcalconfpreciohoraBlock icmParamcalconfpreciohoraBlock,
      @Random IcmParamcalconfchventaBlock icmParamcalconfchventaBlock,
      @Random IcmParamcalpresupuestosrangoBlock icmParamcalpresupuestosrangoBlock,
      @Random GenericTiendaResultItemDto genericTiendaResultItemDto,
      @Random IcmParamcalprocesoBlock icmParamcalprocesoBlock,
      @Random SaveResultDto saveResultDto, @Random IcmParamcalconforigenBlock icmParamcalconforigenBlock,
      @Random IcmParamcalcadenaRecord icmParamcalcadenaRecord,
      @Random IcmParamcalempleadosdesplazRecord icmParamcalempleadosdesplazRecord,
      @Random IcmParamcalempleadospresenciaRecord icmParamcalempleadospresenciaRecord,
      @Random IcmParamcaltiendasRecord icmParamcaltiendasRecord,
      @Random IcmParamcalempleadosRecord icmParamcalempleadosRecord,
      @Random IcmParamcalflagcalculaRecord icmParamcalflagcalculaRecord,
      @Random IcmParamcalflagcalculaBlock icmParamcalflagcalculaBlock,
      @Random IcmParamcalpresenciamanualBlock icmParamcalpresenciamanualBlock,
      @Random IcmParamcalpresenciamanualRecord icmParamcalpresenciamanualRecord,
      @Random IcmParamcalsistdestinoBlock icmParamcalsistdestinoBlock,
      @Random SistemaDestinoResponseDto sistemaDestinoResponseDto,
      @Random(type = ListaValoresBaseResultItemDto.class, size = 2) List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDtoList,
      @Random ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto,
      @Random(type = ListaValoresDestinoResultItemDto.class,
          size = 2) List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList,
      @Random ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto,
      @Random IcmParamcaltiposhoraBlock icmParamcaltiposhoraBlock) {

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
  }

  @Test
  void asIcmParametrosentradaBlockTest() {
    final IcmParametrosentradaBlock result = this.icmWsCalcIncomeMapperDecorator.asIcmParametrosentradaBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @Test
  void asIcmParametrospaginacionBlockTest() {
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
  void asIcmParamcalconfpreciohoraBlockTest() {
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
  void asIcmParamcalpresupuestosrangoBlockTest() {
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

  @BeforeEach
  void initAsConfPrecioHoraResultItemDtoTest(@Random ConfPrecioHoraResultItemDto confPrecioHoraResultItemDto) {
    doReturn(confPrecioHoraResultItemDto).when(this.delegate).asConfPrecioHoraResultItemDto(this.icmListaconfpreciohoraRecordList.get(0));
    doReturn(confPrecioHoraResultItemDto).when(this.delegate).asConfPrecioHoraResultItemDto(this.icmListaconfpreciohoraRecordList.get(1));
  }

  @Test
  void asConfPrecioHoraResultItemDtoTest() {
    final List<ConfPrecioHoraResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asConfPrecioHoraResultItemDto(this.icmListaconfpreciohoraRecordList);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @BeforeEach
  void initAsGenericTiendaResultItemDtosTest(@Random GenericTiendaResultItemDto genericTiendaResultItemDto) {
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
    assertTrue(!result.isEmpty());
  }

  @BeforeEach
  void initAsGenericTiendaResultItemDtosTest(@Random GenericEmpleadoResultItemDto genericEmpleadoResultItemDto) {
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

  @BeforeEach
  void initAsGenericEmpleadoResultItemDtos(@Random GenericEmpleadoResultItemDto genericEmpleadoResultItemDto) {
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
    assertTrue(!result.isEmpty());

  }

  @Test
  void asGenericEmpleadoResultItemDtosTest2(@Random GenericEmpleadoResultItemDto genericEmpleadoResultItemDto) {
    IcmListaempleadosRecord spiedIcmListaempleadosRecord = Mockito.spy(this.icmListaempleadosRecordList.get(0));
    IcmListaseccionesBlock spiedIcmListaseccionesBlock = Mockito.spy(spiedIcmListaempleadosRecord.getIcmListasecciones());
    Mockito.when(spiedIcmListaseccionesBlock.getIcmListaseccionesRecordSet()).thenReturn(Collections.emptyList());
    spiedIcmListaempleadosRecord.setIcmListasecciones(spiedIcmListaseccionesBlock);
    this.icmListaempleadosRecordList.clear();
    this.icmListaempleadosRecordList.add(spiedIcmListaempleadosRecord);

    doReturn(genericEmpleadoResultItemDto).when(this.delegate).asGenericEmpleadoResultItemDto(spiedIcmListaempleadosRecord);

    final List<GenericEmpleadoResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asGenericEmpleadoResultItemDtos(this.icmListaempleadosRecordList);

    assertNotNull(result);
    assertTrue(!result.isEmpty());

  }

  @BeforeEach
  void initAsAusenciasResultItemDtosTest(@Random AusenciasResultItemDto ausenciasResultItemDto) {
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
    assertTrue(!result.isEmpty());
  }

  @BeforeEach
  void initAsGenericEmpleadoResultItemDtosSearchEmpleadosTest(@Random GenericEmpleadoResultItemDto genericEmpleadoResultItemDto) {
    // Instanciamos estas variables con un valor que concuerde en el converter a fecha
    this.icmListaempleadoRecordList.get(0).setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechafin("2000-02-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechainiciosec("2000-01-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechafinsec("2000-02-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechainicioloc("2000-01-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechafinloc("2000-02-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(0).setFechaantiguedad("2000-01-01T00:00:00.000Z");

    this.icmListaempleadoRecordList.get(1).setFechainicio("2000-01-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(1).setFechafin("2000-02-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(1).setFechainiciosec("2000-01-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(1).setFechafinsec("2000-02-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(1).setFechainicioloc("2000-01-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(1).setFechafinloc("2000-02-01T00:00:00.000Z");
    this.icmListaempleadoRecordList.get(1).setFechaantiguedad("2000-01-01T00:00:00.000Z");

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
    assertTrue(!result.isEmpty());
  }

  @Test
  void asTiendaOnlineResultItemDtoTest() {
    final List<TiendaOnlineResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asTiendaOnlineResultItemDto(this.icmListatiendasRecordList);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @Test
  void asIcmParamcalprocesoBlockTest() {
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

  @BeforeEach
  void initAsConfiguracionesResponseDtoTest(@Random ConfiguracionesResponseDto configuracionesResponseDto,
      @Random ConfiguracionItemDto configuracionItemDto) {
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
  void asIcmParamcaltiendasBlockTest4() {
    final IcmParamcaltiendasBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaltiendasBlock(this.ventaManualWlocFilterDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsIcmParamcalempleadoBlockTest(@Random IcmParamcalempleadoRecord icmParamcalempleadoRecord,
      @Random IcmParamcalempleadoBlock icmParamcalempleadoBlock) {
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
  void initAsIcmParamcalempleadoBlockTest2(@Random IcmParamcalempleadoBlock icmParamcalempleadoBlock,
      @Random IcmParamcalempleadoRecord icmParamcalempleadoRecord) {
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
  void asIcmParamcalempleadosBlock() {
    final IcmParamcalempleadosBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalempleadosBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsIcmParamcaldesplazrealBlockTest(@Random IcmParamcaldesplazrealRecord icmParamcaldesplazrealRecord) {
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
  void initAsIcmParamcalpresupuestoswlocBlockTest(@Random IcmParamcalpresupuestoswlocRecord icmParamcalpresupuestoswlocRecord,
      @Random IcmParamcalpresupuestoswlocBlock icmParamcalpresupuestoswlocBlock) {
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
  void initAsPresenciaManualWlocResultItemDtoTest(@Random PresenciaManualWlocResultItemDto presenciaManualWlocResultItemDto) {
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
    assertTrue(!result.isEmpty());
  }

  @Test
  void asPresenciaManualWlocResultItemDtoElseTest(@Random PresenciaManualWlocResultItemDto presenciaManualWlocResultItemDto) {

    IcmListapresenciamanwlocRecord spiedItem = Mockito.spy(this.icmListapresenciamanwlocRecordList.get(0));
    IcmListaseccionespresenciasBlock spiedItem2 = Mockito.spy(spiedItem.getIcmListaseccionespresencias());
    Mockito.when(spiedItem2.getIcmListaseccionespresenciasRecordSet()).thenReturn(Collections.emptyList());
    spiedItem.setIcmListaseccionespresencias(spiedItem2);
    this.icmListapresenciamanwlocRecordList.clear();
    this.icmListapresenciamanwlocRecordList.add(spiedItem);

    doReturn(presenciaManualWlocResultItemDto).when(this.delegate).asPresenciaManualWlocResultItemDto(spiedItem);

    final List<PresenciaManualWlocResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asPresenciaManualWlocResultItemDto(this.icmListapresenciamanwlocRecordList);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @BeforeEach
  void initAsVentaManualWlocResultItemDtoTest(@Random VentaManualWlocResultItemDto ventaManualWlocResultItemDto) {
    doReturn(ventaManualWlocResultItemDto).when(this.delegate).asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList.get(0));
    doReturn(ventaManualWlocResultItemDto).when(this.delegate).asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList.get(1));
  }

  @Test
  void asVentaManualWlocResultItemDtoTest() {
    final List<VentaManualWlocResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @Test
  void asVentaManualWlocResultItemDtoElseTest(@Random VentaManualWlocResultItemDto ventaManualWlocResultItemDto) {

    IcmListaventamanwlocRecord spiedItem = Mockito.spy(this.icmListaventamanwlocRecordList.get(0));
    IcmListaseccionesventaBlock spiedItem2 = Mockito.spy(spiedItem.getIcmListaseccionesventa());
    Mockito.when(spiedItem2.getIcmListaseccionesventaRecordSet()).thenReturn(Collections.emptyList());
    spiedItem.setIcmListaseccionesventa(spiedItem2);
    this.icmListaventamanwlocRecordList.clear();
    this.icmListaventamanwlocRecordList.add(spiedItem);

    doReturn(ventaManualWlocResultItemDto).when(this.delegate).asVentaManualWlocResultItemDto(spiedItem);

    final List<VentaManualWlocResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList);

    assertNotNull(result);
    assertTrue(!result.isEmpty());
  }

  @BeforeEach
  void initAsIcmParamcalsincroBlockTest(@Random IcmParamcalsincroRecord icmParamcalsincroRecord) {
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
  void initAsCatalogoResponseDtoTest(@Random CatalogoResponseDto catalogoResponseDto,
      @Random CatalogoResultItemDto catalogoResultItemDto) {
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
  void initAsListaCondicionesBaseResultItemDtoTest2(@Random ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto,
      @Random(type = ListaValoresBaseResultItemDto.class, size = 2) List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDtoList) {
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
    assertTrue(!result.isEmpty());
  }

  @Test
  void asListaCondicionesDestinoResultItemDtoTest() {
    final ListaCondicionesDestinoResultItemDto result = this.icmWsCalcIncomeMapperDecorator
        .asListaCondicionesDestinoResultItemDto(this.icmListacondicionesdestinoRecord);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsListaCondicionesDestinoResultItemDtoTest2(
      @Random(type = ListaValoresDestinoResultItemDto.class,
          size = 2) List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList,
      @Random ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto) {

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
    assertTrue(!result.isEmpty());
  }

  @BeforeEach
  void initAsEstructurasComResultItemDtoTest(@Random EstructurasComResultItemDto estructurasComResultItemDto,
      @Random ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto,
      @Random(type = ListaValoresBaseResultItemDto.class, size = 2) List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDtoList,
      @Random ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto,
      @Random(type = ListaValoresDestinoResultItemDto.class,
          size = 2) List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList) {

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
  void initAsEstructurasComResultItemDtosTest(@Random EstructurasComResultItemDto estructurasComResultItemDto,
      @Random ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto,
      @Random(type = ListaValoresBaseResultItemDto.class, size = 2) List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDto,
      @Random(type = ListaValoresDestinoResultItemDto.class,
          size = 2) List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList,
      @Random ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto) {

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
    assertTrue(!result.isEmpty());
  }

  @Test
  void asIcmParamcaltiposhoraBlockTest() {
    final IcmParamcaltiposhoraBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcaltiposhoraBlock(this.tiposHoraRequestDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsTiposHoraResponseDto(@Random TiposHoraResponseDto tiposHoraResponseDto,
      @Random TiposHoraResultItemDto tiposHoraResultItemDto) {
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

}
