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
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionesbaseBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionesbaseRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionesdestinoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListacondicionesdestinoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaconfpreciohoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListapresenciamanwlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaseccionesBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmListaseccionesRecord;
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

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class IcmWsCalcIncomeMapperDecoratorTest {

  @Mock
  @Qualifier("delegate")
  IcmWsCalcIncomeMapper delegate;

  @InjectMocks
  IcmWsCalcIncomeMapperDecorator icmWsCalcIncomeMapperDecorator = this.getClassMock();

  final GenericFilterDto genericFilterDto = Instancio.create(GenericFilterDto.class);

  final PageDto pageDto = Instancio.create(PageDto.class);

  final ConfChDiasMinimosFilterDto confChDiasMinimosFilterDto = Instancio.create(ConfChDiasMinimosFilterDto.class);

  final ConfPrecioHoraFilterDto confPrecioHoraFilterDto = Instancio.create(ConfPrecioHoraFilterDto.class);

  final ConfChTpVentaFilterDto confChTpVentaFilterDto = Instancio.create(ConfChTpVentaFilterDto.class);

  final PresupuestosRangoFilterDto presupuestosRangoFilterDto = Instancio.create(PresupuestosRangoFilterDto.class);

  final IcmListatiendasRecord icmListatiendasRecord = Instancio.create(IcmListatiendasRecord.class);

  final List<IcmListaconfpreciohoraRecord> icmListaconfpreciohoraRecordList = Instancio.ofList(IcmListaconfpreciohoraRecord.class).create();

  final List<IcmListatiendasRecord> icmListatiendasRecordList = Instancio.ofList(IcmListatiendasRecord.class).create();

  final IcmListaempleadosRecord icmListaempleadosRecord = Instancio.create(IcmListaempleadosRecord.class);

  final List<IcmListaempleadosRecord> icmListaempleadosRecordList = Instancio.ofList(IcmListaempleadosRecord.class).create();

  final List<IcmListaausenciasRecord> icmListaausenciasRecordList = Instancio.ofList(IcmListaausenciasRecord.class).create();

  final List<IcmListaempleadoRecord> icmListaempleadoRecordList = Instancio.ofList(IcmListaempleadoRecord.class).create();

  final SaveProcesoDto saveProcesoDto = Instancio.create(SaveProcesoDto.class);

  final IcmResultadoguardadoBlock icmResultadoguardadoBlock = Instancio.create(IcmResultadoguardadoBlock.class);

  final ConfiguracionesRequestDto configuracionesRequestDto = Instancio.create(ConfiguracionesRequestDto.class);

  final GetconfiguracionOutput getconfiguracionOutput = Instancio.create(GetconfiguracionOutput.class);

  final String idOrigen = Instancio.create(String.class);

  final SearchTiendasFilterDto searchTiendasFilterDto = Instancio.create(SearchTiendasFilterDto.class);

  final PresenciaManualWlocFilterDto presenciaManualWlocFilterDto = Instancio.create(PresenciaManualWlocFilterDto.class);

  final VentaManualWlocFilterDto ventaManualWlocFilterDto = Instancio.create(VentaManualWlocFilterDto.class);

  final SearchEmpleadosFilterDto searchEmpleadosFilterDto = Instancio.create(SearchEmpleadosFilterDto.class);

  final DesplazamientoRealFilterDto desplazamientoRealFilterDto = Instancio.create(DesplazamientoRealFilterDto.class);

  final PresupuestosWlocFilterDto presupuestosWlocFilterDto = Instancio.create(PresupuestosWlocFilterDto.class);

  final List<IcmListapresenciamanwlocRecord> icmListapresenciamanwlocRecordList =
      Instancio.ofList(IcmListapresenciamanwlocRecord.class).create();

  final List<IcmListaventamanwlocRecord> icmListaventamanwlocRecordList = Instancio.ofList(IcmListaventamanwlocRecord.class).create();

  final SincronizacionFilterDto sincronizacionFilterDto = Instancio.create(SincronizacionFilterDto.class);

  final SistemaDestinoRequestDto sistemaDestinoRequestDto = Instancio.create(SistemaDestinoRequestDto.class);

  final GetsistdestinoOutput getsistdestinoOutput = Instancio.create(GetsistdestinoOutput.class);

  final GetcatalogoOutput getcatalogoOutput = Instancio.create(GetcatalogoOutput.class);

  final IcmListacondicionesbaseRecord icmListacondicionesbaseRecord = Instancio.create(IcmListacondicionesbaseRecord.class);

  final List<IcmListacondicionesbaseRecord> icmListacondicionesbaseRecordList =
      Instancio.ofList(IcmListacondicionesbaseRecord.class).create();

  final IcmListacondicionesdestinoRecord icmListacondicionesdestinoRecord = Instancio.create(IcmListacondicionesdestinoRecord.class);

  final List<IcmListacondicionesdestinoRecord> icmListacondicionesdestinoRecordList =
      Instancio.ofList(IcmListacondicionesdestinoRecord.class).create();

  final IcmListaestructuraRecord icmListaestructuraRecord = Instancio.create(IcmListaestructuraRecord.class);

  final List<IcmListaestructuraRecord> icmListaestructuraRecordlist = Instancio.ofList(IcmListaestructuraRecord.class).create();

  final TiposHoraRequestDto tiposHoraRequestDto = Instancio.create(TiposHoraRequestDto.class);

  final UsuarioRequestDto usuarioRequestDto = Instancio.create(UsuarioRequestDto.class);

  final GettiposhoraOutput gettiposhoraOutput = Instancio.create(GettiposhoraOutput.class);

  final GetmailOutput getmailOutput = Instancio.create(GetmailOutput.class);

  final LiquidacionFilterDto liquidacionFilterDto = Instancio.create(LiquidacionFilterDto.class);

  final PlanificacionFilterDto planificacionFilterDto = Instancio.create(PlanificacionFilterDto.class);

  private IcmWsCalcIncomeMapperDecorator getClassMock() {
    return Mockito.mock(IcmWsCalcIncomeMapperDecorator.class, Mockito.CALLS_REAL_METHODS);
  }

  @BeforeEach
  void init() {

    final List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList =
        Instancio.ofList(ListaValoresDestinoResultItemDto.class).create();
    final List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDtoList =
        Instancio.ofList(ListaValoresBaseResultItemDto.class).create();

    final IcmParametrosentradaBlock icmParametrosentradaBlock =
        Instancio.create(IcmParametrosentradaBlock.class);
    final IcmParamcalempleadosdesplazRecord icmParamcalempleadosdesplazRecord =
        Instancio.create(IcmParamcalempleadosdesplazRecord.class);
    final IcmParamcalcadenaRecord icmParamcalcadenaRecord =
        Instancio.create(IcmParamcalcadenaRecord.class);
    final IcmParamcalconforigenBlock icmParamcalconforigenBlock =
        Instancio.create(IcmParamcalconforigenBlock.class);
    final SaveResultDto saveResultDto =
        Instancio.create(SaveResultDto.class);
    final IcmParamcalprocesoBlock icmParamcalprocesoBlock =
        Instancio.create(IcmParamcalprocesoBlock.class);
    final GenericTiendaResultItemDto genericTiendaResultItemDto =
        Instancio.create(GenericTiendaResultItemDto.class);
    final IcmParamcalpresupuestosrangoBlock icmParamcalpresupuestosrangoBlock =
        Instancio.create(IcmParamcalpresupuestosrangoBlock.class);
    final IcmParamcalconfchventaBlock icmParamcalconfchventaBlock =
        Instancio.create(IcmParamcalconfchventaBlock.class);
    final IcmParamcalconfpreciohoraBlock icmParamcalconfpreciohoraBlock =
        Instancio.create(IcmParamcalconfpreciohoraBlock.class);
    final IcmParamcalconfchdiasBlock icmParamcalconfchdiasBlock =
        Instancio.create(IcmParamcalconfchdiasBlock.class);
    final IcmParametrospaginacionBlock icmParametrospaginacionBlock =
        Instancio.create(IcmParametrospaginacionBlock.class);

    final IcmParamcalusuarioBlock icmParamcalusuarioBlock =
        Instancio.create(IcmParamcalusuarioBlock.class);
    final IcmParamcaltiposhoraBlock icmParamcaltiposhoraBlock =
        Instancio.create(IcmParamcaltiposhoraBlock.class);
    final ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto =
        Instancio.create(ListaCondicionesDestinoResultItemDto.class);
    final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto =
        Instancio.create(ListaCondicionesBaseResultItemDto.class);
    final SistemaDestinoResponseDto sistemaDestinoResponseDto =
        Instancio.create(SistemaDestinoResponseDto.class);
    final IcmParamcalsistdestinoBlock icmParamcalsistdestinoBlock =
        Instancio.create(IcmParamcalsistdestinoBlock.class);
    final IcmParamcalpresenciamanualRecord icmParamcalpresenciamanualRecord =
        Instancio.create(IcmParamcalpresenciamanualRecord.class);
    final IcmParamcalpresenciamanualBlock icmParamcalpresenciamanualBlock =
        Instancio.create(IcmParamcalpresenciamanualBlock.class);
    final IcmParamcalflagcalculaBlock icmParamcalflagcalculaBlock =
        Instancio.create(IcmParamcalflagcalculaBlock.class);
    final IcmParamcalflagcalculaRecord icmParamcalflagcalculaRecord =
        Instancio.create(IcmParamcalflagcalculaRecord.class);
    final IcmParamcalempleadosRecord icmParamcalempleadosRecord =
        Instancio.create(IcmParamcalempleadosRecord.class);
    final IcmParamcaltiendasRecord icmParamcaltiendasRecord =
        Instancio.create(IcmParamcaltiendasRecord.class);
    final IcmParamcalempleadospresenciaRecord icmParamcalempleadospresenciaRecord =
        Instancio.create(IcmParamcalempleadospresenciaRecord.class);

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

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asIcmParametrosentradaBlockGetIcmParametrosentradaRecordSetIsEmptyTest(
      final IcmParametrosentradaBlock icmParametrosentradaBlock) {

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

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asIcmParametrospaginacionBlockGetIcmParametrospaginacionRecordSetIsNullTest(
      final IcmParametrospaginacionBlock icmParametrospaginacionBlock) {

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

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asIcmParamcalconfchdiasBlockGetIcmParametrospaginacionRecordSetIsNullTest(
      final IcmParamcalconfchdiasBlock cmParamcalconfchdiasBlock) {

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

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asIcmParamcalconfpreciohoraBlockGetIcmParametrospaginacionRecordSetIsNullTest(
      final IcmParamcalconfpreciohoraBlock icmParamcalconfpreciohoraBlock) {

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

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asIcmParamcalpresupuestosrangoBlockGetIcmParametrospaginacionRecordSetIsNullTest(
      final IcmParamcalconfchventaBlock icmParamcalconfchventaBlock) {

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

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asIcmParamcalpresupuestosrangoBlockGetIcmParametrospaginacionRecordSetIsNullTest(
      final IcmParamcalpresupuestosrangoBlock icmParamcalpresupuestosrangoBlock) {

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
  void initAsConfPrecioHoraResultItemDtoTest() {
    final ConfPrecioHoraResultItemDto confPrecioHoraResultItemDto =
        Instancio.create(ConfPrecioHoraResultItemDto.class);
    doReturn(confPrecioHoraResultItemDto).when(this.delegate).asConfPrecioHoraResultItemDto(this.icmListaconfpreciohoraRecordList.get(0));
    doReturn(confPrecioHoraResultItemDto).when(this.delegate).asConfPrecioHoraResultItemDto(this.icmListaconfpreciohoraRecordList.get(1));
  }

  @Test
  void asConfPrecioHoraResultItemDtoTest() {
    final ConfPrecioHoraResultItemDto conf = ConfPrecioHoraResultItemDto.builder().build();
    doReturn(conf).when(this.delegate).asConfPrecioHoraResultItemDto(any(IcmListaconfpreciohoraRecord.class));

    final List<ConfPrecioHoraResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asConfPrecioHoraResultItemDto(this.icmListaconfpreciohoraRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @BeforeEach
  void initAsGenericTiendaResultItemDtosTest() {
    final GenericTiendaResultItemDto genericTiendaResultItemDto =
        Instancio.create(GenericTiendaResultItemDto.class);
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
    final IcmListatiendasRecord icmListatiendasRecord = new IcmListatiendasRecord();
    icmListatiendasRecord.setFechainicio("2000-01-01T00:00:00.000Z");
    icmListatiendasRecord.setFechafin("2000-02-01T00:00:00.000Z");
    icmListatiendasRecord.setEscomisionable("1");
    icmListatiendasRecord.setCalcula("1");

    doReturn(new GenericTiendaResultItemDto()).when(this.delegate).asGenericTiendaResultItemDto(any(IcmListatiendasRecord.class));

    final List<GenericTiendaResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asGenericTiendaResultItemDtos(List.of(icmListatiendasRecord));

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void asGenericTiendaResultItemDtosFechaIniFinEmptyTest() {
    final IcmListatiendasRecord item = new IcmListatiendasRecord();
    item.setFechainicio("2000-01-02T00:00:00.000Z");
    item.setFechafin("2000-01-02T00:00:00.000Z");
    item.setEscomisionable("1");
    item.setCalcula("1");
    doReturn(new GenericTiendaResultItemDto()).when(this.delegate).asGenericTiendaResultItemDto(any(IcmListatiendasRecord.class));
    final List<GenericTiendaResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asGenericTiendaResultItemDtos(List.of(item));

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @BeforeEach
  void initAsGenericEmpleadoResultItemDtosTest() {
    final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto =
        Instancio.create(GenericEmpleadoResultItemDto.class);
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
  void initAsGenericEmpleadoResultItemDtos() {

    final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto =
        Instancio.create(GenericEmpleadoResultItemDto.class);
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
    final IcmListaempleadosRecord icmListaempleadoRecord = new IcmListaempleadosRecord();
    icmListaempleadoRecord.setFechainicio("2000-01-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechafin("2000-02-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechainiciosec("2000-01-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechafinsec("2000-02-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechainiciocom("2000-01-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechafincom("2000-02-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechainiciopar("2000-01-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechafinpar("2000-02-01T00:00:00.000Z");
    icmListaempleadoRecord.setIcmListasecciones(new IcmListaseccionesBlock());
    icmListaempleadoRecord.getIcmListasecciones().getIcmListaseccionesRecordSet().add(new IcmListaseccionesRecord());
    final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto = new GenericEmpleadoResultItemDto();
    doReturn(genericEmpleadoResultItemDto).when(this.delegate)
        .asGenericEmpleadoResultItemDtosSearchEmpleados(any(IcmListaempleadoRecord.class));
    doReturn(genericEmpleadoResultItemDto).when(this.delegate)
        .asGenericEmpleadoResultItemDto(any(IcmListaempleadosRecord.class));
    final List<GenericEmpleadoResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asGenericEmpleadoResultItemDtos(List.of(icmListaempleadoRecord));

    assertNotNull(result);
    assertFalse(result.isEmpty());

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asGenericEmpleadoResultItemDtosTest2(final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto) {
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
  void initAsAusenciasResultItemDtosTest() {
    final AusenciasResultItemDto ausenciasResultItemDto =
        Instancio.create(AusenciasResultItemDto.class);
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
    final IcmListaausenciasRecord ausenciasResultItemDto = new IcmListaausenciasRecord();
    // Instanciamos estas variables con un valor que concuerde en el converter a fecha
    ausenciasResultItemDto.setFechainicio("2000-01-01T00:00:00.000Z");
    ausenciasResultItemDto.setFechafin("2000-02-01T00:00:00.000Z");
    doReturn(new AusenciasResultItemDto()).when(this.delegate).asAusenciasResultItemDto(any(IcmListaausenciasRecord.class));

    final List<AusenciasResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asAusenciasResultItemDtos(List.of(ausenciasResultItemDto));

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @Test
  void asAusenciasResultItemDtosFechasEmptyTest() {

    final List<IcmListaausenciasRecord> lista = new ArrayList<IcmListaausenciasRecord>();
    lista.add(new IcmListaausenciasRecord());
    lista.add(new IcmListaausenciasRecord());

    lista.get(0).setFechainicio("");
    lista.get(0).setFechafin("");
    lista.get(1).setFechainicio("");
    lista.get(1).setFechafin("");

    doReturn(new AusenciasResultItemDto()).when(this.delegate).asAusenciasResultItemDto(this.icmListaausenciasRecordList.get(0));

    final List<AusenciasResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asAusenciasResultItemDtos(lista);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @BeforeEach
  void initAsGenericEmpleadoResultItemDtosSearchEmpleadosTest() {
    final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto =
        Instancio.create(GenericEmpleadoResultItemDto.class);
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
    final IcmListaempleadoRecord icmListaempleadoRecord = new IcmListaempleadoRecord();
    icmListaempleadoRecord.setFechainicio("2000-01-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechafin("2000-02-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechainiciosec("2000-01-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechafinsec("2000-02-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechainicioloc("2000-01-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechafinloc("2000-02-01T00:00:00.000Z");
    icmListaempleadoRecord.setFechaantiguedad("2000-01-01T00:00:00.000Z");

    final GenericEmpleadoResultItemDto genericEmpleadoResultItemDto = new GenericEmpleadoResultItemDto();
    doReturn(genericEmpleadoResultItemDto).when(this.delegate)
        .asGenericEmpleadoResultItemDtosSearchEmpleados(any(IcmListaempleadoRecord.class));

    final List<GenericEmpleadoResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asGenericEmpleadoResultItemDtosSearchEmpleados(List.of(icmListaempleadoRecord));

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

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asIcmParamcalprocesoBlockGetIcmParamcalprocesoRecordSetIsEmptyTest(final IcmParamcalprocesoBlock icmParamcalprocesoBlock) {

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

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asIcmParamconfBlockGetIcmParamcalconforigenRecordSetIsEmptyTest(
      final IcmParamcalconforigenBlock icmParamcalconforigenBlock) {

    final IcmParamcalconforigenBlock spiedVar = Mockito.spy(icmParamcalconforigenBlock);
    doReturn(spiedVar).when(this.delegate).asIcmParamconfBlock(this.configuracionesRequestDto);
    doReturn(new ArrayList<IcmParamcalconforigenRecord>()).when(spiedVar).getIcmParamcalconforigenRecordSet();

    final IcmParamcalconforigenBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamconfBlock(this.configuracionesRequestDto);

    assertNotNull(result);
  }

  @BeforeEach
  void initAsConfiguracionesResponseDtoTest() {
    final ConfiguracionesResponseDto configuracionesResponseDto = Instancio.create(ConfiguracionesResponseDto.class);
    final ConfiguracionItemDto configuracionItemDto = Instancio.create(ConfiguracionItemDto.class);

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
  void initAsIcmParamcalempleadoBlockTest() {
    final IcmParamcalempleadoRecord icmParamcalempleadoRecord = Instancio.create(IcmParamcalempleadoRecord.class);
    final IcmParamcalempleadoBlock icmParamcalempleadoBlock = Instancio.create(IcmParamcalempleadoBlock.class);

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
  void initAsIcmParamcalempleadoBlockTest2() {
    final IcmParamcalempleadoBlock icmParamcalempleadoBlock = Instancio.create(IcmParamcalempleadoBlock.class);
    final IcmParamcalempleadoRecord icmParamcalempleadoRecord = Instancio.create(IcmParamcalempleadoRecord.class);

    doReturn(icmParamcalempleadoRecord).when(this.delegate).asIcmParamcalempleadoRecord(this.genericFilterDto);
    doReturn(icmParamcalempleadoBlock).when(this.delegate).asIcmParamcalempleadoBlock(this.genericFilterDto);
  }

  @Test
  void asIcmParamcalempleadoBlockTest2() {
    final IcmParamcalempleadoBlock result = this.icmWsCalcIncomeMapperDecorator
        .asIcmParamcalempleadoBlock(this.genericFilterDto);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asIcmParamcalempleadoBlockNullTest(final IcmParamcalempleadoBlock icmParamcalempleadoBlock) {

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
  void initAsIcmParamcaldesplazrealBlockTest() {
    final IcmParamcaldesplazrealRecord icmParamcaldesplazrealRecord = Instancio.create(IcmParamcaldesplazrealRecord.class);

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
  void initAsIcmParamcalpresupuestoswlocBlockTest() {
    final IcmParamcalpresupuestoswlocRecord icmParamcalpresupuestoswlocRecord = Instancio.create(IcmParamcalpresupuestoswlocRecord.class);
    final IcmParamcalpresupuestoswlocBlock icmParamcalpresupuestoswlocBlock = Instancio.create(IcmParamcalpresupuestoswlocBlock.class);

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
  void initAsPresenciaManualWlocResultItemDtoTest() {
    final PresenciaManualWlocResultItemDto presenciaManualWlocResultItemDto = Instancio.create(PresenciaManualWlocResultItemDto.class);

    doReturn(presenciaManualWlocResultItemDto).when(this.delegate)
        .asPresenciaManualWlocResultItemDto(this.icmListapresenciamanwlocRecordList.get(0));
    doReturn(presenciaManualWlocResultItemDto).when(this.delegate)
        .asPresenciaManualWlocResultItemDto(this.icmListapresenciamanwlocRecordList.get(1));
  }

  @Test
  void asPresenciaManualWlocResultItemDtoTest() {
    doReturn(new PresenciaManualWlocResultItemDto()).when(this.delegate)
        .asPresenciaManualWlocResultItemDto(any(IcmListapresenciamanwlocRecord.class));
    final List<PresenciaManualWlocResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asPresenciaManualWlocResultItemDto(this.icmListapresenciamanwlocRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asPresenciaManualWlocResultItemDtoElseTest(final PresenciaManualWlocResultItemDto presenciaManualWlocResultItemDto) {

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
  void initAsVentaManualWlocResultItemDtoTest() {
    final VentaManualWlocResultItemDto ventaManualWlocResultItemDto = Instancio.create(VentaManualWlocResultItemDto.class);

    doReturn(ventaManualWlocResultItemDto).when(this.delegate).asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList.get(0));
    doReturn(ventaManualWlocResultItemDto).when(this.delegate).asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList.get(1));
  }

  @Test
  void asVentaManualWlocResultItemDtoTest() {
    doReturn(new VentaManualWlocResultItemDto()).when(this.delegate).asVentaManualWlocResultItemDto(any(IcmListaventamanwlocRecord.class));

    final List<VentaManualWlocResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asVentaManualWlocResultItemDto(this.icmListaventamanwlocRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asVentaManualWlocResultItemDtoElseTest(final VentaManualWlocResultItemDto ventaManualWlocResultItemDto) {

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
  void initAsIcmParamcalsincroBlockTest() {
    final IcmParamcalsincroRecord icmParamcalsincroRecord = Instancio.create(IcmParamcalsincroRecord.class);

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
  void initAsCatalogoResponseDtoTest() {
    final CatalogoResponseDto catalogoResponseDto = Instancio.create(CatalogoResponseDto.class);
    final CatalogoResultItemDto catalogoResultItemDto = Instancio.create(CatalogoResultItemDto.class);

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
  void initAsListaCondicionesBaseResultItemDtoTest2() {
    final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto = Instancio.create(ListaCondicionesBaseResultItemDto.class);
    final List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDtoList =
        Instancio.ofList(ListaValoresBaseResultItemDto.class).create();

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
    final ListaCondicionesBaseResultItemDto condiciones = new ListaCondicionesBaseResultItemDto();
    condiciones.setIcmListaValoresBase(new ArrayList<>());
    condiciones.getIcmListaValoresBase().add(new ListaValoresBaseResultItemDto());
    doReturn(condiciones).when(this.delegate)
        .asListaCondicionesBaseResultItemDto(any(IcmListacondicionesbaseRecord.class));

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
  void initAsListaCondicionesDestinoResultItemDtoTest2() {

    final ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto =
        Instancio.create(ListaCondicionesDestinoResultItemDto.class);
    final List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList =
        Instancio.ofList(ListaValoresDestinoResultItemDto.class).create();

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
    final ListaCondicionesDestinoResultItemDto lista = new ListaCondicionesDestinoResultItemDto();
    lista.setIcmListaValoresDestino(new ArrayList<>());
    lista.getIcmListaValoresDestino().add(new ListaValoresDestinoResultItemDto());
    doReturn(lista).when(this.delegate)
        .asListaCondicionesDestinoResultItemDto(any(IcmListacondicionesdestinoRecord.class));

    final List<ListaCondicionesDestinoResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asListaCondicionesDestinoResultItemDto(this.icmListacondicionesdestinoRecordList);

    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @BeforeEach
  void initAsEstructurasComResultItemDtoTest() {

    final ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto =
        Instancio.create(ListaCondicionesDestinoResultItemDto.class);
    final List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList =
        Instancio.ofList(ListaValoresDestinoResultItemDto.class).create();

    final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto =
        Instancio.create(ListaCondicionesBaseResultItemDto.class);
    final List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDtoList =
        Instancio.ofList(ListaValoresBaseResultItemDto.class).create();

    final EstructurasComResultItemDto estructurasComResultItemDto =
        Instancio.create(EstructurasComResultItemDto.class);

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
  void initAsEstructurasComResultItemDtosTest() {

    final ListaCondicionesDestinoResultItemDto listaCondicionesDestinoResultItemDto =
        Instancio.create(ListaCondicionesDestinoResultItemDto.class);
    final List<ListaValoresDestinoResultItemDto> listaValoresDestinoResultItemDtoList =
        Instancio.ofList(ListaValoresDestinoResultItemDto.class).create();

    final ListaCondicionesBaseResultItemDto listaCondicionesBaseResultItemDto =
        Instancio.create(ListaCondicionesBaseResultItemDto.class);
    final List<ListaValoresBaseResultItemDto> listaValoresBaseResultItemDto =
        Instancio.ofList(ListaValoresBaseResultItemDto.class).create();

    final EstructurasComResultItemDto estructurasComResultItemDto =
        Instancio.create(EstructurasComResultItemDto.class);

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
    final IcmListaestructuraRecord icmListatiendasRecord = new IcmListaestructuraRecord();
    icmListatiendasRecord.setFechainicio("2000-01-01T00:00:00.000Z");
    icmListatiendasRecord.setFechafin("2000-02-01T00:00:00.000Z");
    icmListatiendasRecord.setIcmListacondicionesbase(new IcmListacondicionesbaseBlock());
    icmListatiendasRecord.setIcmListacondicionesdestino(new IcmListacondicionesdestinoBlock());
    icmListatiendasRecord.getIcmListacondicionesbase().getIcmListacondicionesbaseRecordSet().add(new IcmListacondicionesbaseRecord());
    icmListatiendasRecord.getIcmListacondicionesdestino().getIcmListacondicionesdestinoRecordSet()
        .add(new IcmListacondicionesdestinoRecord());

    final EstructurasComResultItemDto estructura = EstructurasComResultItemDto.builder().build();
    estructura.setIcmListaCondicionesBase(new ArrayList<>());
    estructura.setIcmListaCondicionesDestino(new ArrayList<>());
    estructura.getIcmListaCondicionesBase().add(new ListaCondicionesBaseResultItemDto());
    estructura.getIcmListaCondicionesDestino().add(new ListaCondicionesDestinoResultItemDto());
    estructura.getIcmListaCondicionesBase().get(0).setIcmListaValoresBase(new ArrayList<>());
    estructura.getIcmListaCondicionesDestino().get(0).setIcmListaValoresDestino(new ArrayList<>());

    doReturn(estructura).when(this.delegate).asEstructurasComResultItemDto(any(IcmListaestructuraRecord.class));

    final List<EstructurasComResultItemDto> result = this.icmWsCalcIncomeMapperDecorator
        .asEstructurasComResultItemDtos(List.of(icmListatiendasRecord));

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
  void initAsTiposHoraResponseDto() {
    final TiposHoraResponseDto tiposHoraResponseDto =
        Instancio.create(TiposHoraResponseDto.class);
    final TiposHoraResultItemDto tiposHoraResultItemDto =
        Instancio.create(TiposHoraResultItemDto.class);
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
  void initAsUsuarioResponseDto() {
    final UsuarioResponseDto usuarioResponseDto =
        Instancio.create(UsuarioResponseDto.class);
    final UsuarioResultItemDto usuarioResultItemDto =
        Instancio.create(UsuarioResultItemDto.class);
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

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asClaseResponseDtoTest(final GetclasesOutput getclasesOutput) {
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

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asClaseResponseDtoNullBlockTest(final GetclasesOutput getclasesOutput) {
    getclasesOutput.setIcmListaclases(null);
    when(this.delegate.asClaseResponseDto(any(GetclasesOutput.class))).thenReturn(new ClaseResponseDto());
    final ClaseResponseDto result = this.icmWsCalcIncomeMapperDecorator.asClaseResponseDto(getclasesOutput);
    assertNotNull(result);
    assertNotNull(result.getItems());
    assertTrue(result.getItems().isEmpty());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asClaseResultItemDtoTest(final IcmListaclasesRecord record, final ClaseResultItemDto item) {
    when(this.delegate.asClaseResultItemDto(any(IcmListaclasesRecord.class))).thenReturn(item);
    record.setEstadosil("2,3,15");
    final ClaseResultItemDto result = this.icmWsCalcIncomeMapperDecorator.asClaseResultItemDto(record);

    verify(this.delegate).asClaseResultItemDto(record);
    assertNotNull(result);
    assertEquals(item, result);
    assertNotNull(item.getIdsEstadoSil());
    assertEquals(Arrays.asList("2", "3", "15"), item.getIdsEstadoSil());
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void asIcmParamcalorigenBlockTest(final ClaseRequestDto request, final IcmParamcalorigenRecord record) {
    when(this.delegate.asIcmParamcalorigenBlock(any(ClaseRequestDto.class))).thenReturn(new IcmParamcalorigenBlock());
    when(this.delegate.asIcmParamcalorigenRecord(any(ClaseRequestDto.class))).thenReturn(record);
    final IcmParamcalorigenBlock result = this.icmWsCalcIncomeMapperDecorator.asIcmParamcalorigenBlock(request);

    verify(this.delegate).asIcmParamcalorigenBlock(request);
    verify(this.delegate).asIcmParamcalorigenRecord(request);
    assertEquals(1, result.getIcmParamcalorigenRecordSet().size());
    assertEquals(record, result.getIcmParamcalorigenRecordSet().get(0));
  }

  @BeforeEach
  void initAsIcmParamcalliquidacionBlockTest() {
    final IcmParamcalliquidacionRecord icmParamcalliquidacionRecord =
        Instancio.create(IcmParamcalliquidacionRecord.class);
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
  void initAsIcmParamcalplanificacionBlockTest() {
    final IcmParamcalplanificadorRecord icmParamcalplanificadorRecord =
        Instancio.create(IcmParamcalplanificadorRecord.class);
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
