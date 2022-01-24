
package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.AccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Accion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.AccionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.AccionRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AccionServiceImplTest {

  @Mock
  private AccionRepositoryCustom accionRepositoryCustom;

  @Mock
  private AccionRepository accionRepository;

  @Mock
  private AccionMapper accionMapper;

  @InjectMocks
  private AccionServiceImpl accionServiceImpl;

  @Test
  public void findAccionDtoById() {
    final Integer id = 1;

    when(this.accionRepository.findById(any(Integer.class)))
        .thenReturn(Optional.of(new Accion()));
    this.accionServiceImpl.findAccionDtoById(id);
    verify(this.accionRepository, times(1))
        .findById(any(Integer.class));
  }

  @Test
  public void findByIdAccionAndIdOrigenAndStdIdLegEnt() {
    final Integer idAccion = 1;
    final String cclIdOrigen = "1";
    final String stdIdLegEnt = "1";

    this.accionServiceImpl.findByIdAccionAndIdOrigenAndStdIdLegEnt(idAccion, cclIdOrigen, stdIdLegEnt);
    verify(this.accionRepositoryCustom, times(1))
        .findByIdAccionAndIdOrigenAndStdIdLegEnt(any(Integer.class), any(String.class), any(String.class));
  }

}
