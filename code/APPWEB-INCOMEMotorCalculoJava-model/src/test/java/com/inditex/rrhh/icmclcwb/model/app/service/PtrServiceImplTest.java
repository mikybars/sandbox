
package com.inditex.rrhh.icmclcwb.model.app.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.ptr.repository.PtrRepositoryCustom;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class PtrServiceImplTest {

  @Mock
  private PtrRepositoryCustom ptrRepositoryCustom;

  @Mock
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @InjectMocks
  private PtrServiceImpl ptrServiceImpl;

  final RunTareaDto runTareaDto = Instancio.create(RunTareaDto.class);

  final TareaAmbitoDto tareaAmbito = Instancio.create(TareaAmbitoDto.class);

  private static final String ORIGEN = "11";

  private static final long ID_TAREA = 1L;

  @Test
  public void findPresenciasOrigenAndFecha() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    this.ptrServiceImpl.findPresenciasOrigenAndFecha(runTareaDto, tareaAmbitoDto);
    verify(this.ptrRepositoryCustom, times(1))
        .findPresenciasOrigenAndFecha(any(TareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  public void findPresenciasOrigenAndFechaEs() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    runTareaDto.setTarea(tarea);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ORIGEN);
    final CatalogoResultItemDto item = new CatalogoResultItemDto();
    item.setIdCatalogo("1");
    final List<CatalogoResultItemDto> list = new ArrayList<>();
    list.add(item);
    final CatalogoResponseDto response = new CatalogoResponseDto();
    response.setItems(list);
    when(this.meta4IcmWsCalcIncomeService.getCatalogo(
        ArgumentMatchers.any(CatalogoRequestDto.class)))
            .thenReturn(response);

    this.ptrServiceImpl.findPresenciasOrigenAndFechaEs(runTareaDto, tareaAmbitoDto);

    verify(this.ptrRepositoryCustom, times(1))
        .findPresenciasOrigenAndFechaEs(any(TareaDto.class), any(TareaAmbitoDto.class), any(Integer.class));
  }

  @Test
  void findPresenciasOrigenAndFechaEsExceptionTest() {

    this.tareaAmbito.setCclIdOrigen("11");

    doReturn(null).when(this.meta4IcmWsCalcIncomeService).getCatalogo(CatalogoRequestDto
        .builder().cclIdOrigen(this.tareaAmbito.getCclIdOrigen())
        .items(Collections.singletonList(CatalogoRequestItemDto
            .builder().stdIdLegEnt(this.runTareaDto.getTarea().getStdIdLegEnt()).build()))
        .build());

    assertThrows(IcmclcwbException.class, () -> {
      this.ptrServiceImpl.findPresenciasOrigenAndFechaEs(this.runTareaDto, this.tareaAmbito);
    });
  }

}
