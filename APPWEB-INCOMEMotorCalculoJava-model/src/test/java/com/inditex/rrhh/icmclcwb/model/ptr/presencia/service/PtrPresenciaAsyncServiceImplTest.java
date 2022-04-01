package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiendaempleado.dto.PtrPresenciaTiendasEmpleadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResponseDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PtrPresenciaAsyncServiceImplTest {

  @Mock
  private PtrPresenciaService ptrPresenciaService;

  @InjectMocks
  private PtrPresenciaAsyncServiceImpl ptrPresenciaAsyncService;

  @Test
  public void presenciasTotalizadoTest() throws ExecutionException, InterruptedException {

    final PtrPresenciaTotalizadoResponseDto response = PtrPresenciaTotalizadoResponseDto
        .builder()
        .presenciasTotalizado(new ArrayList<>())
        .build();
    when(this.ptrPresenciaService.presenciasTotalizado(any(PtrPresenciaTotalizadoRequestDto.class)))
        .thenReturn(response);
    final CompletableFuture<PtrPresenciaTotalizadoResponseDto> cf = this.ptrPresenciaAsyncService
        .presenciasTotalizado(new PtrPresenciaTotalizadoRequestDto());
    assertEquals(response, cf.get());

  }

  @Test
  public void presenciasDetalleTest() throws ExecutionException, InterruptedException {

    final PtrPresenciaDetalleResponseDto response = PtrPresenciaDetalleResponseDto
        .builder()
        .presenciasDetalle(new ArrayList<>())
        .build();
    when(this.ptrPresenciaService.presenciasDetalle(any(PtrPresenciaDetalleRequestDto.class))).thenReturn(response);
    final CompletableFuture<PtrPresenciaDetalleResponseDto> cf = this.ptrPresenciaAsyncService
        .presenciasDetalle(new PtrPresenciaDetalleRequestDto());
    assertEquals(response, cf.get());

  }

  @Test
  public void presenciasTiendasEmpleadoTest() throws ExecutionException, InterruptedException {

    final PtrPresenciaTiendasEmpleadoResponseDto response = PtrPresenciaTiendasEmpleadoResponseDto
        .builder()
        .presenciasTiendasEmpleado(new ArrayList<>())
        .build();
    when(this.ptrPresenciaService.presenciasTiendasEmpleado(any(PtrPresenciaTiendasEmpleadoRequestDto.class)))
        .thenReturn(response);
    final CompletableFuture<PtrPresenciaTiendasEmpleadoResponseDto> cf = this.ptrPresenciaAsyncService
        .presenciasTiendasEmpleado(new PtrPresenciaTiendasEmpleadoRequestDto());
    assertEquals(response, cf.get());

  }

  @Test
  public void presenciasEmpleadosTiendaTest() throws ExecutionException, InterruptedException {

    final PtrPresenciaEmpleadosTiendaResponseDto response = PtrPresenciaEmpleadosTiendaResponseDto
        .builder()
        .presenciasTiendasEmpleado(new ArrayList<>())
        .build();
    when(this.ptrPresenciaService.presenciasEmpleadosTienda(any(PtrPresenciaEmpleadosTiendaRequestDto.class)))
        .thenReturn(response);
    final CompletableFuture<PtrPresenciaEmpleadosTiendaResponseDto> cf = this.ptrPresenciaAsyncService
        .presenciasEmpleadosTienda(new PtrPresenciaEmpleadosTiendaRequestDto());
    assertEquals(response, cf.get());

  }

  @Test
  public void tiposHorasTest() throws ExecutionException, InterruptedException {

    final PtrPresenciaTiposHorasResponseDto response = PtrPresenciaTiposHorasResponseDto
        .builder()
        .tiposHoras(new ArrayList<>())
        .build();
    when(this.ptrPresenciaService.tiposHoras(any(PtrPresenciaTiposHorasRequestDto.class))).thenReturn(response);
    final CompletableFuture<PtrPresenciaTiposHorasResponseDto> cf = this.ptrPresenciaAsyncService
        .tiposHoras(new PtrPresenciaTiposHorasRequestDto());
    assertEquals(response, cf.get());
  }

}
