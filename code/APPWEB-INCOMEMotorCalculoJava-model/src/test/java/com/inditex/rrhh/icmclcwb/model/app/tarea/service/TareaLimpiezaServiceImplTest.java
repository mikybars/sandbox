package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.amigafwk.service.aaa.userdetails.heimdal.HeimdalUser;
import com.inditex.amigafwk.service.aaa.userdetails.heimdal.HeimdalUtils;
import com.inditex.amigafwk.service.aaa.userdetails.heimdal.model.HeimdalUserDetails;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLimpiezaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLimpieza;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLimpiezaServiceImplTest {

  @Mock
  private TareaLimpiezaRepositoryCustom tareaLimpiezaRepositoryCustom;

  @Mock
  private TareaLimpiezaRepository tareaLimpiezaRepository;

  @InjectMocks
  private TareaLimpiezaServiceImpl tareaLimpiezaServiceImpl;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TareaLimpiezaMapper tareaLimpiezaMapper;

  @Test
  public void saveTest() {
    final TareaLimpiezaDto limpieza = mock(TareaLimpiezaDto.class);
    when(limpieza.getNombreUsuario()).thenReturn("username");
    final TareaLimpieza limpiezaEntity = mock(TareaLimpieza.class);
    when(this.tareaLimpiezaMapper.tareaLimpiezaDtoToTareaLimpieza(any(TareaLimpiezaDto.class)))
        .thenReturn(mock(TareaLimpieza.class));

    this.tareaLimpiezaServiceImpl.save(limpieza);
    verify(this.tareaLimpiezaRepository, times(1)).save(any(TareaLimpieza.class));
  }

  @Test
  public void saveSeveralTest() {
    final IdTareaDto idTareaDto1 = new IdTareaDto();
    final IdTareaDto idTareaDto2 = new IdTareaDto();
    idTareaDto1.setId(32L);
    idTareaDto2.setId(789L);
    final List<IdTareaDTO> ids = List.of();
    this.tareaLimpiezaServiceImpl.save(ids);
    verify(this.tareaLimpiezaMapper, times(1)).idTareaDtoToTareaLimpiezaDto(ids);
  }

  @Test
  public void saveTestBlank() {
    final TareaLimpiezaDto tareaLimpiezaDto = new TareaLimpiezaDto();
    tareaLimpiezaDto.setNombreUsuario("");

    final HeimdalUserDetails heimdalUserDetails = new HeimdalUserDetails();
    heimdalUserDetails.setLogin("testLogin");
    final HeimdalUser heimdalUser = HeimdalUser.create(heimdalUserDetails, List.of("1", "2"));
    final Authentication authentication = Mockito.mock(Authentication.class);
    when(authentication.getPrincipal())
        .thenReturn(heimdalUser);
    final SecurityContext securityContext = Mockito.mock(SecurityContext.class);
    Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
    SecurityContextHolder.setContext(securityContext);
    final TareaLimpieza tareaLimpieza = new TareaLimpieza();
    when(HeimdalUtils.getHeimdalUser()).thenReturn(heimdalUser);
    when(this.tareaLimpiezaMapper.tareaLimpiezaDtoToTareaLimpieza(any(TareaLimpiezaDto.class))).thenReturn(tareaLimpieza);
    when(this.tareaLimpiezaRepository.save(any(TareaLimpieza.class))).thenReturn(tareaLimpieza);
    when(this.tareaLimpiezaMapper.tareaLimpiezaToTareaLimpiezaDto(any(TareaLimpieza.class))).thenReturn(tareaLimpiezaDto);

    final TareaLimpiezaDto result = this.tareaLimpiezaServiceImpl.save(tareaLimpiezaDto);

    assertEquals("testLogin", result.getNombreUsuario());
    verify(this.tareaLimpiezaRepository, times(1)).save(tareaLimpieza);
    verify(this.tareaLimpiezaMapper, times(1)).tareaLimpiezaDtoToTareaLimpieza(tareaLimpiezaDto);
    verify(this.tareaLimpiezaMapper, times(1)).tareaLimpiezaToTareaLimpiezaDto(tareaLimpieza);
  }

}
