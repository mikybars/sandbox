package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrVentaEmpleadoServiceImpl
    implements RunTareaAmbitoRecolectarPtrVentaEmpleadoService {

  @Autowired
  @Qualifier("ventaEmpleadoProperties")
  protected Map<String, PtrPropertiesDto> ventaEmpleadoProperties;

  @Autowired
  private PtrVentaEmpleadoAsyncService ptrVentaEmpleadoAsyncService;

  @Autowired
  private TareaLocalizacionPersonaVentaAsyncService tareaLocalizacionPersonaVentaAsyncService;

  @Autowired
  private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

  @Autowired
  private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

  @Autowired
  private TareaAmbitoGlobalEmpresaService tareaAmbitoGlobalEmpresaService;

  @Autowired
  @Qualifier(value = "recolectarProperties")
  private RecolectarPropertiesDto recolectarProperties;

  @Autowired
  private TareaMapper tareaMapper;

  @Override
  public void ventaFisicaLocalizacionPersonaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito) {
    final List<CompletableFuture<?>> cf = new ArrayList<>();
    final List<CompletableFuture<?>> cfPersist = new ArrayList<>();
    try {
      final TrabajoDTO trabajo = runTarea.getTrabajo();
      final TareaDto tarea = runTarea.getTarea();
      final List<String> empresasAmbito = this.tareaAmbitoGlobalEmpresaService
          .findIdEmpresaByIdTarea(tarea.getId())
          .stream()
          .map(IdEmpresaDto::getStdIdLegEnt)
          .collect(Collectors.toList());
      for (final List<IdLocalizacionLocalDto> iter : StreamUtils.partition(
          this.tareaLocalizacionHistoricoService
              .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntAndTipoCalculoInAmbitoLocalizacion(
                  tarea.getId(),
                  tareaAmbito.getCclIdOrigen(),
                  empresasAmbito,
                  Arrays.asList(TipoCalculoEnum.POR_VENTA.getId(),
                      TipoCalculoEnum.POR_VENTA_INDIVIDUAL.getId())),
          this.ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE)
              .getFilter()
              .getMaxPageSize())) {

        final PtrVentaIndividualDetalleRequestDto paramVentaFisica = this.tareaMapper
            .mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(trabajo,
                tarea,
                tareaAmbito, this.recolectarProperties);
        paramVentaFisica.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_VENDEDOR_TIENDA_SECCION);
        paramVentaFisica.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
        paramVentaFisica
            .setEmpresa(empresasAmbito.stream().map(Integer::parseInt).collect(Collectors.toList()));
        paramVentaFisica.setTienda(iter.stream()
            .map(IdLocalizacionLocalDto::getId)
            .map(Integer::valueOf)
            .collect(Collectors.toList()));
        paramVentaFisica.setProducto(this.meta4IcmWsCalcIncomeSessionService
            .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen())
            .stream()
            .map(ConfiguracionProductoVentaResultItemDto::getIdProducto)
            .collect(Collectors.toList()));

        final CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData = this.ptrVentaEmpleadoAsyncService
            .ventaIndividualDetalle(paramVentaFisica);
        AsyncUtils.exceptionally(cfData, cf, cfPersist);

        final PtrVentaIndividualDetalleResponseDto data = AsyncUtils.get(cfData);

        if (CollectionUtils.isNotEmpty(data.getVentaIndividualDetalle())) {
          AsyncUtils.checkAsyncAvaliable(cfPersist,
              this.ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE)
                  .getFilter()
                  .getMaxPageSize());
          AsyncUtils.exceptionally(
              this.tareaLocalizacionPersonaVentaAsyncService
                  .savePtrVentaIndividualDetalleResultItem(
                      data.getVentaIndividualDetalle(), tarea),
              cf, cfPersist);
        }
      }

      AsyncUtils.waitAllOfIsOk(cf, cf);
    } catch (final Exception e) {
      AsyncUtils.cancel(cf);
      throw e;
    }
  }

}
