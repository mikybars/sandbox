package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoPersonaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TrabajoAmbitoPersonaServiceImplTest {

  @Mock
  private TrabajoAmbitoPersonaRepository trabajoAmbitoPersonaRepository;

  @Mock
  private TrabajoAmbitoPersonaMapper trabajoAmbitoPersonaMapper;

  @InjectMocks
  private TrabajoAmbitoPersonaServiceImpl trabajoAmbitoPersonaService;

  @Test
  void createTest() {
    final TrabajoDTO trabajo = new TrabajoDTO();

    final List<TrabajoAmbitoPersonaDTO> lista = new ArrayList<>();

    this.trabajoAmbitoPersonaService.create(lista, trabajo);

    verify(this.trabajoAmbitoPersonaMapper).trabajoAmbitoPersonaToTrabajoAmbitoPersonaDto(anyList());
    verify(this.trabajoAmbitoPersonaRepository).saveAll(any(Iterable.class));
    verify(this.trabajoAmbitoPersonaMapper).mergeTrabajoAmbitoPersonaDtoAndTrabajoDtoToTrabajoAmbitoPersona(anyList(),
        any(TrabajoDTO.class));

  }

  @Test
  void findByTrabajoTest() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(2L);

    this.trabajoAmbitoPersonaService.findByTrabajo(trabajo);

    verify(this.trabajoAmbitoPersonaMapper).trabajoAmbitoPersonaToTrabajoAmbitoPersonaDto(anyList());
    verify(this.trabajoAmbitoPersonaRepository).findByTrabajoId(anyLong());
  }
}
