package com.inditex.rrhh.icmclcwb.model.app.run.tarea.ambito.recolectar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.LocalizacionesAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.recolectar.properties.dto.RecolectarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionproductoventa.dto.ConfiguracionProductoVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.ptr.util.PtrPropertiesConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrAgruparSeccionEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupSellerTypeEnum;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.ptr.dto.PtrPropertiesDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Service
@Validated
public class RunTareaAmbitoRecolectarPtrVentaEmpleadoServiceImpl
        implements RunTareaAmbitoRecolectarPtrVentaEmpleadoService {

    @Autowired
    private Logger log;

    @Autowired
    private PtrVentaEmpleadoAsyncService ptrVentaEmpleadoAsyncService;

    @Autowired
    private TareaLocalizacionPersonaVentaAsyncService tareaLocalizacionPersonaVentaAsyncService;

    @Autowired
    private TareaPersonaHistoricoService tareaPersonaHistoricoService;

    @Autowired
    private TareaLocalizacionHistoricoService tareaLocalizacionHistoricoService;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Autowired
    private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;

    @Autowired
    private TareaLocalizacionPersonaVentaMapper tareaLocalizacionPersonaVentaMapper;

    @Autowired
    @Qualifier(value = "recolectarProperties")
    private RecolectarPropertiesDto recolectarProperties;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    @Qualifier("ventaEmpleadoProperties")
    protected Map<String, PtrPropertiesDto> ventaEmpleadoProperties;

    @Override
    public void ventaFisicaLocalizacionPersonaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfPersist = new ArrayList<>();
        try {
            final TrabajoDto trabajo = runTarea.getTrabajo();
            final TareaDto tarea = runTarea.getTarea();
            List<Integer> localizaciones = tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(tarea.getId(),
                tareaAmbito.getCclIdOrigen(), TipoCalculoEnum.POR_VENTA.getId()).stream().map(IdLocalizacionLocalDto::getId).map(Integer::valueOf).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(localizaciones)) {

                if (TipoAmbitoEnum.PERSONA.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())
                    || TipoAmbitoEnum.LOCALIZACION.getId().equals(runTarea.getTrabajo().getTipoAmbito().getId())) {
                    LocalizacionesAmbitoDto localizacionesAmbito = new LocalizacionesAmbitoDto(
                        runTarea.getTrabajo().getTipoAmbito().getId());
                    localizacionesAmbito.setLocalizaciones(
                        tareaLocalizacionHistoricoService.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
                            runTarea.getTarea().getId(), tareaAmbito.getCclIdOrigen()));
                    localizaciones = new ArrayList<>(CollectionUtils.intersection(localizaciones, localizacionesAmbito.getLocalizaciones()));
                }

                PtrVentaIndividualDetalleRequestDto paramVentaFisica =
                    tareaMapper.mergeTrabajoDtoAndTareaDtoAndTareaAmbitoDtoToPtrVentaIndividualDetalleRequestDto(trabajo, tarea, tareaAmbito, recolectarProperties);
                paramVentaFisica.setAgrupacion(PtrGroupSellerTypeEnum.OPERACION_FECHA_VENDEDOR_TIENDA_SECCION);
                paramVentaFisica.setAgruparSeccion(PtrAgruparSeccionEnum.TRUE.getValue());
                paramVentaFisica.setTienda(localizaciones);
                paramVentaFisica.setProducto(meta4IcmWsCalcIncomeSessionService
                    .getConfiguracionProductoVenta(tarea.getId(), tareaAmbito.getCclIdOrigen()).stream()
                    .map(ConfiguracionProductoVentaResultItemDto::getIdProducto).collect(Collectors.toList()));

                CompletableFuture<PtrVentaIndividualDetalleResponseDto> cfData =
                    ptrVentaEmpleadoAsyncService.ventaIndividualDetalle(paramVentaFisica);
                AsyncUtils.exceptionally(cfData, cf, cfPersist);

                PtrVentaIndividualDetalleResponseDto data = AsyncUtils.get(cfData);

                if (CollectionUtils.isNotEmpty(data.getVentaIndividualDetalle())) {
                    AsyncUtils.checkAsyncAvaliable(cfPersist,
                        ventaEmpleadoProperties.get(PtrPropertiesConstants.VENTA_INDIVIDUAL_DETALLE).getFilter().getMaxPageSize());
                    AsyncUtils.exceptionally(
                        tareaLocalizacionPersonaVentaAsyncService.savePtrVentaIndividualDetalleResultItem(data.getVentaIndividualDetalle(), tarea), cf, cfPersist);
                }
            }
            AsyncUtils.waitAllOfIsOk(cf, cf);
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }
}
