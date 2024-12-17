package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoOrigenMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoOrigenRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TrabajoAmbitoOrigenServiceImplTest {
  @Mock
  private TrabajoAmbitoOrigenRepository trabajoAmbitoOrigenRepository;

  @Mock
  private TrabajoAmbitoOrigenMapper trabajoAmbitoOrigenMapper;

  @InjectMocks
  private TrabajoAmbitoOrigenServiceImpl trabajoAmbitoOrigenService;

  @Test
  void createTest() {
    final List<TrabajoAmbitoOrigenDTO> trabajoAmbitoOrigen = new ArrayList<>();
    final TrabajoDTO trabajo = new TrabajoDTO();

    this.trabajoAmbitoOrigenService.create(trabajoAmbitoOrigen, trabajo);

    verify(this.trabajoAmbitoOrigenMapper).trabajoAmbitoOrigenToTrabajoAmbitoOrigenDto(anyList());
    verify(this.trabajoAmbitoOrigenRepository).saveAll(any(Iterable.class));
    verify(this.trabajoAmbitoOrigenMapper).mergeTrabajoAmbitoOrigenDtoAndTrabajoDtoToTrabajoAmbitoOrigen(anyList(), any(TrabajoDTO.class));
  }

  @Test
  void findByTrabajoTest() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(1L);
    this.trabajoAmbitoOrigenService.findByTrabajo(trabajo);

    verify(this.trabajoAmbitoOrigenMapper).trabajoAmbitoOrigenToTrabajoAmbitoOrigenDto(anyList());
    verify(this.trabajoAmbitoOrigenRepository).findByTrabajoId(anyLong());
  }

}
