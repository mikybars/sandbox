package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaAmbitoValidarTiposHoraServiceImplTest {

  public static final String CCL_ID_ORIGEN = "11";

  public static final String CCL_ID_ORIGEN1 = "38";

  public static final String ID_CATALOGO = "1";

  @Mock
  private PtrPresenciaAsyncService ptrPresenciaAsyncService;

  @Mock
  private Meta4IcmWsCalcIncomeAsyncService meta4IcmWsCalcIncomeAsyncService;

  @Mock
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @InjectMocks
  private RunTareaAmbitoValidarTiposHoraServiceImpl runTareaAmbitoValidarTiposHoraServiceImpl;

  @Test
  public void executeEs() {
    final CatalogoResponseDto responseCatalogo = new CatalogoResponseDto();
    responseCatalogo.setItems(new ArrayList<>());
    responseCatalogo.getItems().add(new CatalogoResultItemDto());
    responseCatalogo.getItems().get(0).setIdCatalogo(ID_CATALOGO);
    this.execute(CCL_ID_ORIGEN, responseCatalogo);
  }

  @Test
  public void executeNoEs() {
    final CatalogoResponseDto responseCatalogo = new CatalogoResponseDto();
    responseCatalogo.setItems(new ArrayList<>());
    responseCatalogo.getItems().add(new CatalogoResultItemDto());
    responseCatalogo.getItems().get(0).setIdCatalogo(ID_CATALOGO);
    this.execute(CCL_ID_ORIGEN1, responseCatalogo);
  }

  @Test
  public void executeEsCatalogoResponse() {
    final CatalogoResponseDto responseCatalogo = new CatalogoResponseDto();
    assertThrows(IcmclcwbException.class, () -> {
      this.execute(CCL_ID_ORIGEN, responseCatalogo);
    });

  }

  private void execute(final String cclIdOrigen, final CatalogoResponseDto responseCatalogo) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(cclIdOrigen);
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final FaseDto faseDto = new FaseDto();
    faseDto.setId(1);
    final AccionDto accionDto = new AccionDto();
    accionDto.setId(1);

    final PtrPresenciaTiposHorasResponseDto lista = new PtrPresenciaTiposHorasResponseDto();
    lista.setTiposHoras(new ArrayList<>());
    final CompletableFuture<PtrPresenciaTiposHorasResponseDto> cfPtr = new CompletableFuture<>();
    cfPtr.complete(lista);

    final TiposHoraResponseDto responseDto = TiposHoraResponseDto
        .builder()
        .items(new ArrayList<>())
        .build();
    final CompletableFuture<TiposHoraResponseDto> cfMeta4 = new CompletableFuture<>();
    cfMeta4.complete(responseDto);

    when(this.ptrPresenciaAsyncService.tiposHoras(any(PtrPresenciaTiposHorasRequestDto.class)))
        .thenReturn(cfPtr);
    when(this.meta4IcmWsCalcIncomeAsyncService.getTiposHora(any(TiposHoraRequestDto.class)))
        .thenReturn(cfMeta4);
    when(this.meta4IcmWsCalcIncomeService.getCatalogo(any(CatalogoRequestDto.class)))
        .thenReturn(responseCatalogo);

    this.runTareaAmbitoValidarTiposHoraServiceImpl.execute(runTareaDto, tareaAmbitoDto,
        tareaFaseAccionDto);

    verify(this.ptrPresenciaAsyncService, timeout(1000).times(1))
        .tiposHoras(
            ArgumentMatchers.any(PtrPresenciaTiposHorasRequestDto.class));
    verify(this.meta4IcmWsCalcIncomeAsyncService, timeout(1000).times(1))
        .getTiposHora(ArgumentMatchers.any(TiposHoraRequestDto.class));

  }
}
