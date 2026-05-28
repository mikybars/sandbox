package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.coefjornada.dto.CoefJornadaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazamientosmultiempresa.dto.DesplazamientosMultiempresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.desplazreal.dto.DesplazamientoRealResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleados.dto.EmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadosdesplazamiento.dto.EmpleadosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empleadospresencia.dto.EmpleadosPresenciaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.empresas.dto.EmpresaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estadowloc.dto.EstadoWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.festivos.dto.FestivosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.flagcalcula.dto.FlagCalculaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.LiquidacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.origenes.dto.OrigenResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanual.dto.PresenciaManualResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestosrango.dto.PresupuestosRangoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presupuestoswloc.dto.PresupuestosWlocResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.dto.SaveResultDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchtiendas.dto.SearchTiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sistdestino.dto.SistemaDestinoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendas.dto.TiendasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.usuario.dto.UsuarioResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResponseDto;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.util.MigrationDispatcher;
import com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.service.CalculoComisionesService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Meta4IcmWsCalcIncomeFacadeService implements Meta4IcmWsCalcIncomeService {

  private final SoapMeta4IcmWsCalcIncomeService soapService;

  private final PeopleAclService peopleAclService;

  private final MigrationDispatcher migrationDispatcher;

  private final CalculoComisionesService calculoComisionesService;

  @Override
  public SearchTiendasResponseDto searchTiendas(SearchTiendasRequestDto request) {
    return this.soapService.searchTiendas(request);
  }

  @Override
  public TiendasResponseDto getTiendas(TiendasRequestDto request) {
    return this.migrationDispatcher.dispatch("getTiendas",
        () -> this.peopleAclService.getTiendas(request),
        () -> this.soapService.getTiendas(request),
        request);
  }

  @Override
  public SearchEmpleadosResponseDto searchEmpleados(SearchEmpleadosRequestDto request) {
    return this.soapService.searchEmpleados(request);
  }

  @Override
  public EmpleadosResponseDto getEmpleados(EmpleadosRequestDto request) {
    return this.soapService.getEmpleados(request);
  }

  @Override
  public PresenciaManualResponseDto getPresenciaManual(PresenciaManualRequestDto request) {
    return this.migrationDispatcher.dispatch(
        "getPresenciaManual",
        () -> this.peopleAclService.getPresenciaManual(request),
        () -> this.soapService.getPresenciaManual(request),
        request);
  }

  @Override
  public EmpleadosPresenciaResponseDto getEmpleadosPresencia(EmpleadosPresenciaRequestDto request) {
    return this.migrationDispatcher.dispatch(
        "getEmpleadosPresencia",
        () -> this.peopleAclService.getEmpleadosPresencia(request),
        () -> this.soapService.getEmpleadosPresencia(request),
        request);
  }

  @Override
  public PeriodosResponseDto getPeriodos(PeriodosRequestDto request) {
    return this.migrationDispatcher.dispatch(
        "getPeriodos",
        () -> this.peopleAclService.searchPeriodos(request),
        () -> this.soapService.getPeriodos(request),
        request);
  }

  @Override
  public FestivosResponseDto getFestivos(FestivosRequestDto request) {
    return this.soapService.getFestivos(request);
  }

  @Override
  public CoefJornadaResponseDto getCoefJornada(CoefJornadaRequestDto request) {
    return this.migrationDispatcher.dispatch("getCoefJornada",
        () -> this.peopleAclService.getCoefJornada(request),
        () -> this.soapService.getCoefJornada(request),
        request);
  }

  @Override
  public FlagCalculaResponseDto getFlagCalcula(FlagCalculaRequestDto request) {
    return this.migrationDispatcher.dispatch("getFlagCalcula",
        () -> this.peopleAclService.getFlagCalcula(request),
        () -> this.soapService.getFlagCalcula(request),
        request);
  }

  @Override
  public AgrupOnlineResponseDto getAgrupOnline(AgrupOnlineRequestDto request) {
    return this.soapService.getAgrupOnline(request);
  }

  @Override
  public ConfiguracionVentaOnlineResponseDto getConfVentaOnline(ConfiguracionVentaOnlineRequestDto request) {
    return this.migrationDispatcher.dispatch("getConfVentaOnline",
        () -> this.peopleAclService.getConfVentaOnline(request),
        () -> this.soapService.getConfVentaOnline(request),
        request);
  }

  @Override
  public TiendaOnlineResponseDto getTiendasOnline(TiendaOnlineRequestDto request) {
    return this.migrationDispatcher.dispatch("getTiendasOnline",
        () -> this.peopleAclService.searchTiendasOnline(request),
        () -> this.soapService.getTiendasOnline(request),
        request);
  }

  @Override
  public ConfiguracionProductoVentaResponseDto getConfiguracionProductoVenta(ConfiguracionProductoVentaRequestDto request) {
    return this.migrationDispatcher.dispatch(
        "getConfiguracionProductoVenta",
        () -> this.peopleAclService.getConfiguracionProductoVenta(request),
        () -> this.soapService.getConfiguracionProductoVenta(request),
        request);
  }

  @Override
  public CadenaResponseDto getCadena(CadenaRequestDto request) {
    return this.soapService.getCadena(request);
  }

  @Override
  public EmpresaResponseDto getEmpresa(EmpresaRequestDto request) {
    return this.migrationDispatcher.dispatch("getEmpresa",
        () -> this.peopleAclService.searchEmpresas(request),
        () -> this.soapService.getEmpresa(request),
        request);
  }

  @Override
  public OrigenResponseDto getOrigen(OrigenRequestDto request) {
    return this.migrationDispatcher.dispatch("getOrigen",
        () -> this.peopleAclService.searchOrigenes(request),
        () -> this.soapService.getOrigen(request),
        request);
  }

  @Override
  public EmpleadosDesplazamientoResponseDto getEmpleadosDesplazamiento(EmpleadosDesplazamientoRequestDto request) {
    return this.migrationDispatcher.dispatch("getEmpleadosDesplazamiento",
        () -> this.peopleAclService.getEmpleadosDesplazamiento(request),
        () -> this.soapService.getEmpleadosDesplazamiento(request),
        request);
  }

  @Override
  public SaveResultDto saveProceso(SaveProcesoDto request) {
    return this.soapService.saveProceso(request);
  }

  @Override
  public EstructurasComResponseDto getEstructurasCom(EstructurasComRequestDto request) {
    return this.soapService.getEstructurasCom(request);
  }

  @Override
  public EstructurasPolResponseDto getEstructurasPol(EstructurasPolRequestDto request) {
    return this.soapService.getEstructurasPol(request);
  }

  @Override
  public AusenciasResponseDto getAusencias(AusenciasRequestDto request) {
    return this.migrationDispatcher.dispatch("getAusencias",
        () -> this.peopleAclService.getAusencias(request),
        () -> this.soapService.getAusencias(request),
        request);
  }

  @Override
  public ConfiguracionesResponseDto getConfiguracion(ConfiguracionesRequestDto request) {
    return this.soapService.getConfiguracion(request);
  }

  @Override
  public ConfChDiasMinimosResponseDto getConfChallengeDiasMinimos(ConfChDiasMinimosRequestDto request) {
    return this.soapService.getConfChallengeDiasMinimos(request);
  }

  @Override
  public PresupuestosWlocResponseDto getPresupuestosWloc(PresupuestosWlocRequestDto request) {
    return this.migrationDispatcher.dispatch("getPresupuestosWloc",
        () -> this.peopleAclService.getPresupuestosWloc(request),
        () -> this.soapService.getPresupuestosWloc(request),
        request);
  }

  @Override
  public ConfPrecioHoraResponseDto getConfPrecioHora(ConfPrecioHoraRequestDto request) {
    return this.soapService.getConfPrecioHora(request);
  }

  @Override
  public ConfChTpVentaResponseDto getConfChallengeTpVenta(ConfChTpVentaRequestDto request) {
    return this.soapService.getConfChallengeTpVenta(request);
  }

  @Override
  public PresupuestosRangoResponseDto getPresupuestosRango(PresupuestosRangoRequestDto request) {
    return this.soapService.getPresupuestosRango(request);
  }

  @Override
  public VentaCongeladaResponseDto getVentaCongelada(VentaCongeladaRequestDto request) {
    return this.migrationDispatcher.dispatch("getVentaCongelada",
        () -> this.peopleAclService.getVentaCongelada(request),
        () -> this.soapService.getVentaCongelada(request),
        request);
  }

  @Override
  public DesplazamientoRealResponseDto getDesplazReal(DesplazamientoRealRequestDto request) {
    return this.migrationDispatcher.dispatch(
        "getDesplazReal",
        () -> this.peopleAclService.getDesplazReal(request),
        () -> this.soapService.getDesplazReal(request),
        request);
  }

  @Override
  public DesplazamientosMultiempresaResponseDto getDesplazamientosMultiempresa(DesplazamientosMultiempresaRequestDto request) {
    return this.migrationDispatcher.dispatch("getDesplazamientosMultiempresa",
        () -> this.peopleAclService.searchDesplazamientosMultiempresa(request),
        () -> this.soapService.getDesplazamientosMultiempresa(request),
        request);
  }

  @Override
  public PresenciaManualWlocResponseDto getPresenciaManualWloc(PresenciaManualWlocRequestDto request) {
    return this.migrationDispatcher.dispatch(
        "getPresenciaManualWloc",
        () -> this.peopleAclService.getPresenciaManualWloc(request),
        () -> this.soapService.getPresenciaManualWloc(request),
        request);
  }

  @Override
  public VentaManualWlocResponseDto getVentaManualWloc(VentaManualWlocRequestDto request) {
    return this.soapService.getVentaManualWloc(request);
  }

  @Override
  public SincronizacionResponseDto sincronizacion(SincronizacionRequestDto request) {
    return this.soapService.sincronizacion(request);
  }

  @Override
  public MotivosDesplazamientoResponseDto getMotivosDesplazamiento(MotivosDesplazamientoRequestDto request) {
    return this.soapService.getMotivosDesplazamiento(request);
  }

  @Override
  public SistemaDestinoResponseDto getSistemaDestino(SistemaDestinoRequestDto request) {
    return this.migrationDispatcher.dispatch(
        "getSistemaDestino",
        () -> this.peopleAclService.searchSistemasDestino(request),
        () -> this.soapService.getSistemaDestino(request),
        request);
  }

  @Override
  public CatalogoResponseDto getCatalogo(CatalogoRequestDto request) {
    return this.soapService.getCatalogo(request);
  }

  @Override
  public TiposHoraResponseDto getTiposHora(TiposHoraRequestDto request) {
    return this.soapService.getTiposHora(request);
  }

  @Override
  public UsuarioResponseDto getMail(UsuarioRequestDto request) {
    return this.soapService.getMail(request);
  }

  @Override
  public ClaseResponseDto getClases(ClaseRequestDto request) {
    return this.soapService.getClases(request);
  }

  @Override
  public LiquidacionResponseDto liquidacion(LiquidacionRequestDto request) {
    return this.soapService.liquidacion(request);
  }

  @Override
  public PlanificacionResponseDto planificacion(PlanificacionRequestDto request) {
    return this.soapService.planificacion(request);
  }

  @Override
  public EstadoWlocResponseDto getEstadoWloc(EstadoWlocRequestDto request) {
    return this.soapService.getEstadoWloc(request);
  }

  @Override
  public CalculoComisionesResponseDto buscarCalculoComisiones(CalculoComisionesFilterDto request) {
    return this.calculoComisionesService.buscarCalculoComisiones(request);
  }

}
