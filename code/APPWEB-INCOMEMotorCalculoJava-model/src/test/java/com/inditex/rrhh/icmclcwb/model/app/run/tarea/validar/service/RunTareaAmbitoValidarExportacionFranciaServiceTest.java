package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.AvisosGuardadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.liquidacion.dto.ErorresGuardadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.planificacion.dto.PlanificacionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.dto.TipoAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ComisRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoCalculoPersonaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoAmbitoEmpresaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaAmbitoValidarExportacionFranciaServiceTest {

    private static final String KO = "KO";

    @Mock
    private ComisRepositoryCustom comisRepositoryCustom;

    @Mock
    private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

    @Mock
    private PeriodoCalculoPersonaRepositoryCustom periodoCalculoPersonaRepositoryCustom;

    @Mock
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Mock
    private ValidacionMapper validacionMapper;

    @Mock
    private Logger log;

    @Mock
    private TareaAmbitoLocalizacionService tareaAmbitoLocalizacionService;

    @Mock
    private TareaAmbitoPersonaService tareaAmbitoPersonaService;

    @Mock
    private TareaFaseAccionService tareaFaseAccionService;

    @Mock
    private ProcesoRepository procesoRepository;

    @Mock
    private ProcesoAmbitoEmpresaRepository procesoAmbitoEmpresaRepository;

    @InjectMocks
    private RunTareaAmbitoValidarExportacionFranciaServiceImpl runTareaAmbitoValidarExportacionFranciaServiceImpl;

    public void execute(final TipoAmbitoDTO tipoAmbito) {

        final RunTareaDto runTareaDto = new RunTareaDto();
        final TareaDto tareaDto = new TareaDto();
        tareaDto.setId(1L);
        final TrabajoDTO trabajo = new TrabajoDTO();
        trabajo.setTipoAmbito(tipoAmbito);
        trabajo.setFechaHoraCreacion(LocalDateTime.now().atOffset(ZoneOffset.UTC));
        trabajo.setFechaInicioPeriodo(LocalDateTime.now().atOffset(ZoneOffset.UTC));
        trabajo.setFechaFinPeriodo(LocalDateTime.now().atOffset(ZoneOffset.UTC));
        runTareaDto.setTarea(tareaDto);
        runTareaDto.setTrabajo(trabajo);
        final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
        final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
        final FaseDto faseDto = new FaseDto();
        faseDto.setId(1);
        final AccionDto accionDto = new AccionDto();
        accionDto.setId(1);

        final PlanificacionResponseDto response = new PlanificacionResponseDto();
        final PlanificacionResultItemDto result = new PlanificacionResultItemDto();
        response.setData(new ArrayList<>());
        result.setResultado(KO);
        result.setAvisos(AvisosGuardadoResultItemDto.builder().resultado(KO).avisos(new ArrayList<>()).build());
        result.setErrores(ErorresGuardadoResultItemDto.builder().resultado(KO).errores(new ArrayList<>()).build());
        response.getData().add(result);

        when(this.meta4IcmWsCalcIncomeService.planificacion(any(PlanificacionRequestDto.class))).thenReturn(response);

        this.runTareaAmbitoValidarExportacionFranciaServiceImpl.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

        verify(this.validacionMapper, timeout(1000).times(1))
            .booleanToValidacionDto(ArgumentMatchers.any(TareaAmbitoDto.class),
                ArgumentMatchers.any(TareaFaseAccionDto.class), any(Boolean.class));
    }

    @Test
    public void executeSociedad() {
        this.execute(TipoAmbitoEnum.SOCIEDAD.getDto());
    }

    @Test
    public void executeOrigen() {
        this.execute(TipoAmbitoEnum.ORIGEN.getDto());
    }

    @Test
    public void executeEmpresa() {
        this.execute(TipoAmbitoEnum.EMPRESA.getDto());
    }

    @Test
    public void executeLocalizacion() {
        when(this.tareaAmbitoLocalizacionService.findByTarea(any(TareaDto.class))).thenReturn(new ArrayList<TareaAmbitoLocalizacionDto>());
        assertThrows(IcmclcwbException.class, () -> {
            this.execute(TipoAmbitoEnum.LOCALIZACION.getDto());
        });
    }

    @Test
    public void executePersona() {
        when(this.tareaAmbitoPersonaService.findByTarea(any(TareaDto.class))).thenReturn(new ArrayList<TareaAmbitoPersonaDto>());
        assertThrows(IcmclcwbException.class, () -> {
            this.execute(TipoAmbitoEnum.PERSONA.getDto());
        });
    }

    @Test
    public void executeNull() {
        assertThrows(IcmclcwbException.class, () -> {
            this.execute(new TipoAmbitoDTO());
        });
    }

}
