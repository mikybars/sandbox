package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoLocalizacionRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TrabajoAmbitoLocalizacionServiceImplTest {
  @Mock
  private TrabajoAmbitoLocalizacionRepository trabajoAmbitoLocalizacionRepository;

  @Mock
  private TrabajoAmbitoLocalizacionMapper trabajoAmbitoLocalizacionMapper;

  @InjectMocks
  private TrabajoAmbitoLocalizacionServiceImpl trabajoAmbitoLocalizacionService;

  @Test
  void createTest() {
    final List<TrabajoAmbitoLocalizacionDTO> trabajoAmbitoLocalizacion = new ArrayList<>();
    final TrabajoDTO trabajo = new TrabajoDTO();

    this.trabajoAmbitoLocalizacionService.create(trabajoAmbitoLocalizacion, trabajo);

    verify(this.trabajoAmbitoLocalizacionMapper).trabajoAmbitoLocalizacionToTrabajoAmbitoLocalizacionDto(anyList());
    verify(this.trabajoAmbitoLocalizacionRepository).saveAll(any(Iterable.class));
    verify(this.trabajoAmbitoLocalizacionMapper).mergeTrabajoAmbitoLocalizacionDtoAndTrabajoDtoToTrabajoAmbitoLocalizacion(anyList(), any(
        TrabajoDTO.class));
  }

  @Test
  void findByTrabajoTest() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(2L);

    this.trabajoAmbitoLocalizacionService.findByTrabajo(trabajo);

    verify(this.trabajoAmbitoLocalizacionMapper).trabajoAmbitoLocalizacionToTrabajoAmbitoLocalizacionDto(anyList());
    verify(this.trabajoAmbitoLocalizacionRepository).findByTrabajoId(any(Long.class));
  }
}
