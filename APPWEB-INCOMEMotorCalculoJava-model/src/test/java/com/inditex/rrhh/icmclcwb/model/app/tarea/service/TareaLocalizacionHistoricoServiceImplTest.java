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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionHistoricoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionHistoricoRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionHistoricoServiceImplTest {

    @Mock
    private TareaLocalizacionHistoricoRepositoryCustom tareaLocalizacionHistoricoRepositoryCustom;
    
    @Mock
    private TareaLocalizacionHistoricoRepository tareaLocalizacionHistoricoRepository;
    
    @InjectMocks
    private TareaLocalizacionHistoricoServiceImpl tareaLocalizacionHistoricoServiceImpl;
    
    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;
    
    @Mock
    private TareaLocalizacionHistoricoMapper tareaLocalizacionHistoricoMapper;
    
    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<TareaLocalizacionHistoricoDto> genericTiendaResultItemDto = new ArrayList<>();

        tareaLocalizacionHistoricoServiceImpl.save(genericTiendaResultItemDto);
        verify(tareaLocalizacionHistoricoRepositoryCustom, times(1)).save(any(List.class));
    }
    
    
    @Test
    public void mergeTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<GenericTiendaResultItemDto> genericTiendaResultItemDto = new ArrayList<>();

        tareaLocalizacionHistoricoServiceImpl.merge(genericTiendaResultItemDto, tarea);
        verify(tareaLocalizacionHistoricoMapper, times(1)).genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(any(List.class), any(TareaDto.class));
    }
    
    @Test
    public void findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        Long idTarea = 1L;
        String cclIdOrigen = "1";

        tareaLocalizacionHistoricoServiceImpl.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(idTarea, cclIdOrigen);
        verify(tareaLocalizacionHistoricoRepositoryCustom, times(1)).findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(any(Long.class), any(String.class));
    }
    
    @Test
    public void findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbitoTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        Long idTarea = 1L;
        String cclIdOrigen = "1";
        List<Integer> idsTipoDato = mock(List.class);

        tareaLocalizacionHistoricoServiceImpl.findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(idTarea, cclIdOrigen, idsTipoDato);
        verify(tareaLocalizacionHistoricoRepositoryCustom, times(1)).findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(any(Long.class), any(String.class), any(List.class));
    }
    
    @Test
    public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbitoTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        Long idTarea = 1L;
        String cclIdOrigen = "1";
        List<Integer> idsTipoDato = mock(List.class);

        tareaLocalizacionHistoricoServiceImpl.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(idTarea, cclIdOrigen, idsTipoDato);
        verify(tareaLocalizacionHistoricoRepositoryCustom, times(1)).findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(any(Long.class), any(String.class), any(List.class));
    }
        
    @Test
    public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        Long idTarea = 1L;
        String cclIdOrigen = "1";

        tareaLocalizacionHistoricoServiceImpl.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(idTarea, cclIdOrigen);
        verify(tareaLocalizacionHistoricoRepositoryCustom, times(1)).findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(any(Long.class), any(String.class));
    }  
    
    @Test
    public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        Long idTarea = 1L;
        String cclIdOrigen = "1";

        tareaLocalizacionHistoricoServiceImpl.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(idTarea, cclIdOrigen);
        verify(tareaLocalizacionHistoricoRepository, times(1)).findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(any(Long.class), any(String.class));
    }    

    @Test
    public void findIdCadenaDtoByIdTareaAndCclIdOrigenAndVentaConceptoTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        Long idTarea = 1L;
        String cclIdOrigen = "1";
        Long idVentaConcepto = 1L;

        tareaLocalizacionHistoricoServiceImpl.findIdCadenaDtoByIdTareaAndCclIdOrigen(idTarea, cclIdOrigen, idVentaConcepto);
        verify(tareaLocalizacionHistoricoRepositoryCustom, times(1)).getCadenasByTareaAndOrigen(any(Long.class), any(String.class), any(Long.class));
    }    
    
    @Test
    public void findIdCadenaDtoByIdTareaAndCclIdOrigenTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        Long idTarea = 1L;
        String cclIdOrigen = "1";

        tareaLocalizacionHistoricoServiceImpl.findIdCadenaDtoByIdTareaAndCclIdOrigen(idTarea, cclIdOrigen);
        verify(tareaLocalizacionHistoricoRepositoryCustom, times(1)).getCadenasByTareaAndOrigen(any(Long.class), any(String.class));
    }    
    
    @Test
    public void findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacionTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        Long idTarea = 1L;
        String cclCodOrigen = "1";
        List<String> idTipoCalculo = mock(List.class);
        
        tareaLocalizacionHistoricoServiceImpl.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(idTarea, cclCodOrigen, idTipoCalculo);
        verify(tareaLocalizacionHistoricoRepositoryCustom, times(1)).findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(any(Long.class), any(String.class), any(List.class));
    }    
    
    @Test
    public void findTiendasPresupuestosByIdTareaTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        Long idTarea = 1L;
        
        tareaLocalizacionHistoricoServiceImpl.findTiendasPresupuestosByIdTarea(idTarea);
        verify(tareaLocalizacionHistoricoRepositoryCustom, times(1)).findIdLocalizacionLocalDtoPresupuestosByIdTarea(any(Long.class));
    }    
    
}
