package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionVentaIntegraDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseAccionVentaIntegraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionVentaIntegra;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionVentaIntegraRepositoryCustom;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaFaseAccionVentaIntegraServiceImplTest {

  @Mock
  private TareaFaseAccionVentaIntegraMapper tareaFaseAccionVentaIntegraMapper;

  @Mock
  private TareaFaseAccionVentaIntegraRepositoryCustom tareaFaseAccionVentaIntegraRepository;

  @InjectMocks
  private TareaFaseAccionVentaIntegraServiceImpl tareaFaseAccionVentaIntegraService;

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void saveTest(final List<TareaFaseAccionVentaIntegraDto> src,
      final List<TareaFaseAccionVentaIntegra> mapperResult) {
    Mockito.doReturn(mapperResult).when(this.tareaFaseAccionVentaIntegraMapper)
        .tareaFaseAccionVentaIntegraDtoToTareaFaseAccionVentaIntegra(src);
    Mockito.doNothing().when(this.tareaFaseAccionVentaIntegraRepository).save(mapperResult);

    this.tareaFaseAccionVentaIntegraService.save(src);

    verify(this.tareaFaseAccionVentaIntegraRepository, timeout(1000).times(1))
        .save(mapperResult);

  }
}
