package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.proceso.EstadoProcesoEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.TipoProcesoEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.TipoSistemaDestinoEnum;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarExportacionFranciaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TipoAmbito;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.EstadoProceso;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.Proceso;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoAmbitoEmpresa;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.TipoProceso;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.TipoSistemaDestino;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoAmbitoEmpresaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoRepository;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaAmbitoValidarExportacionFranciaServiceImpl implements RunTareaAmbitoValidarExportacionFranciaService {

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Autowired
    private Logger log;

    @Autowired
    private ValidacionMapper validacionMapper;

    @Autowired
    private ProcesoRepository procesoRepository;

    @Autowired
    private ProcesoAmbitoEmpresaRepository procesoAmbitoEmpresaRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
        @Valid final TareaAmbitoDto tareaAmbito,
        @Valid final TareaFaseAccionDto tareaFaseAccion) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final TrabajoDTO trabajo = runTareaDto.getTrabajo();
        final TareaDto tarea = runTareaDto.getTarea();
        Proceso proceso = new Proceso();
        ProcesoAmbitoEmpresa procesoAmbitoEmpresa = new ProcesoAmbitoEmpresa();
        EstadoProceso estadoProceso = new EstadoProceso();
        TipoAmbito tipoAmbito = new TipoAmbito();
        TipoProceso tipoProceso = new TipoProceso();
        TipoSistemaDestino tipoSistemaDestino = new TipoSistemaDestino();

        try {
            if (TipoAmbitoEnum.SOCIEDAD.getId().equals(trabajo.getTipoAmbito().getId())
                || TipoAmbitoEnum.ORIGEN.getId().equals(trabajo.getTipoAmbito().getId())
                || TipoAmbitoEnum.EMPRESA.getId().equals(trabajo.getTipoAmbito().getId())) {

                estadoProceso.setId(EstadoProcesoEnum.PENDIENTE.getId());
                tipoAmbito.setId(trabajo.getTipoAmbito().getId().intValue());
                tipoProceso.setId(TipoProcesoEnum.EXPORTACION.getId());
                tipoSistemaDestino.setId(TipoSistemaDestinoEnum.SIL.getId());

                proceso.setEstadoProceso(estadoProceso);
                proceso.setIdOrganization(tarea.getIdOrganization());
                proceso.setIcmIdPeriodo(trabajo.getIcmIdPeriodo());
                proceso.setTipoAmbito(tipoAmbito);
                proceso.setTipoProceso(tipoProceso);
                proceso.setTipoSistemaDestino(tipoSistemaDestino);
                proceso.setFechaHoraCreacion(LocalDateTime.now());
                proceso.setFechaInicioPeriodo(trabajo.getFechaInicioPeriodo().toLocalDate());
                proceso.setFechaFinPeriodo(trabajo.getFechaFinPeriodo().toLocalDate());
                proceso.setNombreUsuario(trabajo.getNombreUsuario());

                Proceso precesoCreated = this.procesoRepository.save(proceso);

                procesoAmbitoEmpresa.setProceso(precesoCreated);
                procesoAmbitoEmpresa.setCclIdOrigen(tareaAmbito.getCclIdOrigen());
                procesoAmbitoEmpresa.setStdIdLegEnt(tarea.getStdIdLegEnt());

                this.procesoAmbitoEmpresaRepository.save(procesoAmbitoEmpresa);
            } else {
                throw new IcmclcwbException("El tipo ambito no esta soportado");
            }
        } catch (final Exception e) {
            this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
                EstadoTareaFaseAccionEnum.ERROR.getDto());
            AsyncUtils.cancel(cf);
            throw e;
        }
        return this.validacionMapper.booleanToValidacionDto(tareaAmbito, tareaFaseAccion, true);

    }
}
