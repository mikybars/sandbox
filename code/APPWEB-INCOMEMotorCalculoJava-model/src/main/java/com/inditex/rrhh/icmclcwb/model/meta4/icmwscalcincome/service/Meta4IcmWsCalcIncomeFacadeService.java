package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ausencias.dto.AusenciasResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.cadenas.dto.CadenaResponseDto;
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

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Meta4IcmWsCalcIncomeFacadeService implements Meta4IcmWsCalcIncomeService {

  private final SoapMeta4IcmWsCalcIncomeService soapService;

  private final PeopleAclService peopleAclService;

  private final MigrationDispatcher migrationDispatcher;

  @Override
  public SearchTiendasResponseDto searchTiendas(SearchTiendasRequestDto request) {
    return soapService.searchTiendas(request);
  }

  @Override
  public TiendasResponseDto getTiendas(TiendasRequestDto request) {
    return migrationDispatcher.dispatch("getTiendas",
        () -> peopleAclService.getTiendas(request),
        () -> soapService.getTiendas(request),
        request);
  }

  @Override
  public SearchEmpleadosResponseDto searchEmpleados(SearchEmpleadosRequestDto request) {
    return soapService.searchEmpleados(request);
  }

  @Override
  public EmpleadosResponseDto getEmpleados(EmpleadosRequestDto request) {
    return soapService.getEmpleados(request);
  }

  @Override
  public PresenciaManualResponseDto getPresenciaManual(PresenciaManualRequestDto request) {
    return migrationDispatcher.dispatch(
        "getPresenciaManual",
        () -> peopleAclService.getPresenciaManual(request),
        () -> soapService.getPresenciaManual(request),
        request);
  }

  @Override
  public EmpleadosPresenciaResponseDto getEmpleadosPresencia(EmpleadosPresenciaRequestDto request) {
    return migrationDispatcher.dispatch(
        "getEmpleadosPresencia",
        () -> peopleAclService.getEmpleadosPresencia(request),
        () -> soapService.getEmpleadosPresencia(request),
        request);
  }

  @Override
  public PeriodosResponseDto getPeriodos(PeriodosRequestDto request) {
    return soapService.getPeriodos(request);
  }

  @Override
  public FestivosResponseDto getFestivos(FestivosRequestDto request) {
    return soapService.getFestivos(request);
  }

  @Override
  public CoefJornadaResponseDto getCoefJornada(CoefJornadaRequestDto request) {
    return migrationDispatcher.dispatch("getCoefJornada",
        () -> peopleAclService.getCoefJornada(request),
        () -> soapService.getCoefJornada(request),
        request);
  }

  @Override
  public FlagCalculaResponseDto getFlagCalcula(FlagCalculaRequestDto request) {
    return migrationDispatcher.dispatch("getFlagCalcula",
        () -> peopleAclService.getFlagCalcula(request),
        () -> soapService.getFlagCalcula(request),
        request);
  }

  @Override
  public AgrupOnlineResponseDto getAgrupOnline(AgrupOnlineRequestDto request) {
    return soapService.getAgrupOnline(request);
  }

  @Override
  public ConfiguracionVentaOnlineResponseDto getConfVentaOnline(ConfiguracionVentaOnlineRequestDto request) {
    return migrationDispatcher.dispatch("getConfVentaOnline",
        () -> peopleAclService.getConfVentaOnline(request),
        () -> soapService.getConfVentaOnline(request),
        request);
  }

  @Override
  public TiendaOnlineResponseDto getTiendasOnline(TiendaOnlineRequestDto request) {
    return migrationDispatcher.dispatch("getTiendasOnline",
        () -> peopleAclService.searchTiendasOnline(request),
        () -> soapService.getTiendasOnline(request),
        request);
  }

  @Override
  public ConfiguracionProductoVentaResponseDto getConfiguracionProductoVenta(ConfiguracionProductoVentaRequestDto request) {
    return migrationDispatcher.dispatch(
        "getConfiguracionProductoVenta",
        () -> peopleAclService.getConfiguracionProductoVenta(request),
        () -> soapService.getConfiguracionProductoVenta(request),
        request);
  }

  @Override
  public CadenaResponseDto getCadena(CadenaRequestDto request) {
    return soapService.getCadena(request);
  }

  @Override
  public EmpresaResponseDto getEmpresa(EmpresaRequestDto request) {
    return migrationDispatcher.dispatch("getEmpresa",
        () -> peopleAclService.searchEmpresas(request),
        () -> soapService.getEmpresa(request),
        request);
  }

  @Override
  public OrigenResponseDto getOrigen(OrigenRequestDto request) {
    return migrationDispatcher.dispatch("getOrigen",
        () -> peopleAclService.searchOrigenes(request),
        () -> soapService.getOrigen(request),
        request);
  }

  @Override
  public EmpleadosDesplazamientoResponseDto getEmpleadosDesplazamiento(EmpleadosDesplazamientoRequestDto request) {
    return migrationDispatcher.dispatch("getEmpleadosDesplazamiento",
        () -> peopleAclService.getEmpleadosDesplazamiento(request),
        () -> soapService.getEmpleadosDesplazamiento(request),
        request);
  }

  @Override
  public SaveResultDto saveProceso(SaveProcesoDto request) {
    return soapService.saveProceso(request);
  }

  @Override
  public EstructurasComResponseDto getEstructurasCom(EstructurasComRequestDto request) {
    return soapService.getEstructurasCom(request);
  }

  @Override
  public EstructurasPolResponseDto getEstructurasPol(EstructurasPolRequestDto request) {
    return soapService.getEstructurasPol(request);
  }

  @Override
  public AusenciasResponseDto getAusencias(AusenciasRequestDto request) {
    return migrationDispatcher.dispatch("getAusencias",
        () -> peopleAclService.getAusencias(request),
        () -> soapService.getAusencias(request),
        request);
  }

  @Override
  public ConfiguracionesResponseDto getConfiguracion(ConfiguracionesRequestDto request) {
    return soapService.getConfiguracion(request);
  }

  @Override
  public ConfChDiasMinimosResponseDto getConfChallengeDiasMinimos(ConfChDiasMinimosRequestDto request) {
    return soapService.getConfChallengeDiasMinimos(request);
  }

  @Override
  public PresupuestosWlocResponseDto getPresupuestosWloc(PresupuestosWlocRequestDto request) {
    return soapService.getPresupuestosWloc(request);
  }

  @Override
  public ConfPrecioHoraResponseDto getConfPrecioHora(ConfPrecioHoraRequestDto request) {
    return soapService.getConfPrecioHora(request);
  }

  @Override
  public ConfChTpVentaResponseDto getConfChallengeTpVenta(ConfChTpVentaRequestDto request) {
    return soapService.getConfChallengeTpVenta(request);
  }

  @Override
  public PresupuestosRangoResponseDto getPresupuestosRango(PresupuestosRangoRequestDto request) {
    return soapService.getPresupuestosRango(request);
  }

  @Override
  public VentaCongeladaResponseDto getVentaCongelada(VentaCongeladaRequestDto request) {
    return soapService.getVentaCongelada(request);
  }

  @Override
  public DesplazamientoRealResponseDto getDesplazReal(DesplazamientoRealRequestDto request) {
    return soapService.getDesplazReal(request);
  }

  @Override
  public DesplazamientosMultiempresaResponseDto getDesplazamientosMultiempresa(DesplazamientosMultiempresaRequestDto request) {
    return soapService.getDesplazamientosMultiempresa(request);
  }

  @Override
  public PresenciaManualWlocResponseDto getPresenciaManualWloc(PresenciaManualWlocRequestDto request) {
    return soapService.getPresenciaManualWloc(request);
  }

  @Override
  public VentaManualWlocResponseDto getVentaManualWloc(VentaManualWlocRequestDto request) {
    return soapService.getVentaManualWloc(request);
  }

  @Override
  public SincronizacionResponseDto sincronizacion(SincronizacionRequestDto request) {
    return soapService.sincronizacion(request);
  }

  @Override
  public MotivosDesplazamientoResponseDto getMotivosDesplazamiento(MotivosDesplazamientoRequestDto request) {
    return soapService.getMotivosDesplazamiento(request);
  }

  @Override
  public SistemaDestinoResponseDto getSistemaDestino(SistemaDestinoRequestDto request) {
    return soapService.getSistemaDestino(request);
  }

  @Override
  public CatalogoResponseDto getCatalogo(CatalogoRequestDto request) {
    return soapService.getCatalogo(request);
  }

  @Override
  public TiposHoraResponseDto getTiposHora(TiposHoraRequestDto request) {
    return soapService.getTiposHora(request);
  }

  @Override
  public UsuarioResponseDto getMail(UsuarioRequestDto request) {
    return soapService.getMail(request);
  }

  @Override
  public ClaseResponseDto getClases(ClaseRequestDto request) {
    return soapService.getClases(request);
  }

  @Override
  public LiquidacionResponseDto liquidacion(LiquidacionRequestDto request) {
    return soapService.liquidacion(request);
  }

  @Override
  public PlanificacionResponseDto planificacion(PlanificacionRequestDto request) {
    return soapService.planificacion(request);
  }

  @Override
  public EstadoWlocResponseDto getEstadoWloc(EstadoWlocRequestDto request) {
    return soapService.getEstadoWloc(request);
  }

}
