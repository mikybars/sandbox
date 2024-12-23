package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoAmbitoEmpresaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoAmbitoEmpresaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TrabajoAmbitoEmpresaServiceImplTest {
  @Mock
  private TrabajoAmbitoEmpresaRepository trabajoAmbitoEmpresaRepository;

  @Mock
  private TrabajoAmbitoEmpresaMapper trabajoAmbitoEmpresaMapper;

  @InjectMocks
  private TrabajoAmbitoEmpresaServiceImpl trabajoAmbitoEmpresaService;

  @Test
  void createTest() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final List<TrabajoAmbitoEmpresaDTO> lista = new ArrayList<>();

    this.trabajoAmbitoEmpresaService.create(lista, trabajo);

    verify(this.trabajoAmbitoEmpresaMapper).trabajoAmbitoEmpresaToTrabajoAmbitoEmpresaDto(anyList());
    verify(this.trabajoAmbitoEmpresaRepository).saveAll(any(Iterable.class));
    verify(this.trabajoAmbitoEmpresaMapper).mergeTrabajoAmbitoEmpresaDtoAndTrabajoDtoToTrabajoAmbitoEmpresa(anyList(),
        any(TrabajoDTO.class));

  }

  @Test
  void findByTrabajoTest() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(2L);

    this.trabajoAmbitoEmpresaService.findByTrabajo(trabajo);

    verify(this.trabajoAmbitoEmpresaMapper).trabajoAmbitoEmpresaToTrabajoAmbitoEmpresaDto(anyList());
    verify(this.trabajoAmbitoEmpresaRepository).findByTrabajoId(anyLong());
  }
}
