package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaHistoricoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaHistoricoRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaPersonaHistoricoServiceImplTest {

    @Mock
    private TareaPersonaHistoricoRepositoryCustom tareaPersonaHistoricoRepositoryCustom;
    
    @Mock
    private TareaPersonaHistoricoRepository tareaPersonaHistoricoRepository;
    
    @InjectMocks
    private TareaPersonaHistoricoServiceImpl tareaPersonaHistoricoServiceImpl;
    
    @Mock
    private TareaPersonaHistoricoMapper tareaPersonaHistoricoMapper;
    
    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;
    
    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<TareaPersonaHistoricoDto> personas = new ArrayList<>();

        tareaPersonaHistoricoServiceImpl.save(personas);
        verify(tareaPersonaHistoricoRepositoryCustom, times(1)).save(any(List.class));
    }
    
    @Test
    public void mergeTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<GenericEmpleadoResultItemDto> personas = new ArrayList<>();

        tareaPersonaHistoricoServiceImpl.merge(personas, tarea);
        verify(tareaPersonaHistoricoMapper, times(1)).genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(any(List.class), any(TareaDto.class));
    }
    
    @Test
    public void findIdPersonaByIdTareaAndIdOrigenInAmbitoTest() {
        String cclIdOrigen = "1";
        Long idTarea = 1L;

        tareaPersonaHistoricoServiceImpl.findIdPersonaByIdTareaAndIdOrigenInAmbito(idTarea, cclIdOrigen);
        verify(tareaPersonaHistoricoRepositoryCustom, times(1)).findIdPersonaByIdTareaAndIdOrigenInAmbito(any(Long.class), any(String.class));
    }
    
    @Test
    public void findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbitoTest() {
        String cclIdOrigen = "1";
        Long idTarea = 1L;

        tareaPersonaHistoricoServiceImpl.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(idTarea, cclIdOrigen);
        verify(tareaPersonaHistoricoRepositoryCustom, times(1)).findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(any(Long.class), any(String.class));
    }
    
    @Test
    public void findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbitoTest() {
        String cclIdOrigen = "1";
        Long idTarea = 1L;
        List<Integer> idsTipoDato = mock(List.class);

        tareaPersonaHistoricoServiceImpl.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea, cclIdOrigen, idsTipoDato);
        verify(tareaPersonaHistoricoRepositoryCustom, times(1)).findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(any(Long.class), any(String.class), any(List.class));
    }
    
    @Test
    public void findPeriodoByIdTareaDtoTest() {
        Long idTarea = 1L;
        tareaPersonaHistoricoServiceImpl.findPeriodoByIdTareaDto(idTarea);
        verify(tareaPersonaHistoricoRepositoryCustom, times(1)).findPeriodoDtoByIdTarea(any(Long.class));
    }
    
    @Test
    public void findIdPersonaHistoricoDtoGrupoFechasByIdTareaTest() {
        Long idTarea = 1L;
        tareaPersonaHistoricoServiceImpl.findIdPersonaHistoricoDtoGrupoFechasByIdTarea(idTarea);
        verify(tareaPersonaHistoricoRepositoryCustom, times(1)).findIdPersonaHistoricoDtoGrupoFechasByIdTarea(any(Long.class));
    }
    
    @Test
    public void findIdPersonaLocalCompensacionChallengeByIdTareaTest() {
        Long idTarea = 1L;
        tareaPersonaHistoricoServiceImpl.findIdPersonaLocalCompensacionChallengeByIdTarea(idTarea);
        verify(tareaPersonaHistoricoRepositoryCustom, times(1)).findIdPersonaLocalCompensacionChallengeByIdTarea(any(Long.class));
    }
    
    @Test
    public void findIdPersonaHistoricoByIdTareaAndIdOrigenTest() {
        Long idTarea = 1L;
        String cclIdOrigen = "1";
        tareaPersonaHistoricoServiceImpl.findIdPersonaHistoricoByIdTareaAndIdOrigen(idTarea, cclIdOrigen);
        verify(tareaPersonaHistoricoRepository, times(1)).findIdPersonaHistoricoByIdTareaAndIdOrigen(any(Long.class), any(String.class));
    }
    
}
