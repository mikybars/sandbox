package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoEmpresaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoOrigenService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoAmbitoPersonaService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4FilterPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.save.proceso.dto.SaveProcesoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4PropertiesConstants;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.ms.app.trabajo.SenderTrabajo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrabajoServiceImplTest {

    @Mock
    private SenderTrabajo senderTrabajo;

    @Mock
    private TrabajoMapper trabajoMapper;

    @Mock
    private PeriodoMapper periodoMapper;

    @Mock
    private TrabajoRepository trabajoRepository;

    @Mock
    private TrabajoAmbitoOrigenService trabajoAmbitoOrigenService;

    @Mock
    private TrabajoAmbitoEmpresaService trabajoAmbitoEmpresaService;

    @Mock
    private TrabajoAmbitoLocalizacionService trabajoAmbitoLocalizacionService;

    @Mock
    private TrabajoAmbitoPersonaService trabajoAmbitoPersonaService;

    @Mock
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Mock
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Mock
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @InjectMocks
    private TrabajoServiceImpl trabajoServiceImpl;

    @Test
    public void find() {
        when(this.trabajoRepository.findById(any(Long.class))).thenReturn(Optional.of(new Trabajo()));
        when(this.trabajoMapper.trabajoToTrabajoDto(any(Trabajo.class))).thenReturn(new TrabajoDto());
        this.trabajoServiceImpl.find(1L);
        verify(this.trabajoAmbitoOrigenService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDto.class));
        verify(this.trabajoAmbitoEmpresaService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDto.class));
        verify(this.trabajoAmbitoLocalizacionService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDto.class));
        verify(this.trabajoAmbitoPersonaService, timeout(1000).times(1)).findByTrabajo(any(TrabajoDto.class));
    }

    @Test
    public void create() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setNombreUsuario("test");
        trabajo.setIcmIdPeriodo(1L);
        trabajo.setFechaInicioPeriodo(LocalDate.of(2017, 01, 01));
        trabajo.setFechaFinPeriodo(LocalDate.of(2017, 01, 01));
        trabajo.setIdOrganization("test");
        trabajo.setTipoAmbito(new TipoAmbitoDto());
        final PageDto page = new PageDto(1, 100);
        final Meta4PropertiesDto properties = new Meta4PropertiesDto();
        final Meta4FilterPropertiesDto filter = new Meta4FilterPropertiesDto();
        filter.setMaxPageSize(1);
        filter.setMaxPersistenceSize(1);
        properties.setFilter(filter);
        properties.setPage(page);

        when(this.trabajoMapper.trabajoDtoToTrabajo(any(TrabajoDto.class))).thenReturn(new Trabajo());
        when(this.trabajoRepository.save(any(Trabajo.class))).thenReturn(new Trabajo());
        when(this.trabajoMapper.trabajoToTrabajoDto(any(Trabajo.class))).thenReturn(new TrabajoDto());
        when(this.trabajoMapper.trabajoDtoToSaveProcesoDto(any(TrabajoDto.class))).thenReturn(new SaveProcesoDto());
        when(this.meta4Properties.get(Meta4PropertiesConstants.PERIODOS)).thenReturn(properties);
        when(this.meta4IcmWsCalcIncomeSessionService.getPeriodos(any(PeriodosRequestDto.class)))
            .thenReturn(Arrays.asList(new PeriodosResultItemDto()));

        this.trabajoServiceImpl.create(trabajo);
        verify(this.meta4IcmWsCalcIncomeService, timeout(1000).times(1)).saveProceso(any(SaveProcesoDto.class));
    }

    @Test
    public void merge() {
        final ProgramacionAmbitoDto ambito = new ProgramacionAmbitoDto();
        final ProgramacionDto programacion = new ProgramacionDto();
        final PeriodoDto periodo = new PeriodoDto();
        when(this.trabajoMapper.mergeProgramacionAmbitoDtoAndProgramacionDtoAndPeriodoDtoToTrabajoDto(
                any(ProgramacionAmbitoDto.class), any(ProgramacionDto.class), any(PeriodoDto.class)))
                    .thenReturn(new TrabajoDto());

        assertNotNull(this.trabajoServiceImpl.merge(programacion, ambito, periodo));
    }

}
