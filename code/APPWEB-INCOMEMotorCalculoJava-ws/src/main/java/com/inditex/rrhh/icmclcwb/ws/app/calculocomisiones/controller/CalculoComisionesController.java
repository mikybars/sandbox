package com.inditex.rrhh.icmclcwb.ws.app.calculocomisiones.controller;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.CalculoComisionesItemDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoComisionesSearchRequestDTO;
import com.inditex.rrhh.icmclcwb.model.app.calculocomisiones.mapper.CalculoComisionesApiMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.service.CalculoComisionesService;
import com.inditex.rrhh.icmclcwb.service.CalculoApi;
import com.inditex.rrhh.icmclcwb.ws.authorization.IsUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CalculoComisionesController implements CalculoApi {

  private final CalculoComisionesService calculoComisionesService;

  private final CalculoComisionesApiMapper mapper;

  @Override
  @IsUser
  public ResponseEntity<List<CalculoComisionesItemDTO>> buscarCalculoComisiones(
      CalculoComisionesSearchRequestDTO calculoComisionesSearchRequestDTO) {
    log.info("🌍 New request for buscarCalculoComisiones endpoint");
    var filter = mapper.toFilterDto(calculoComisionesSearchRequestDTO);
    var response = calculoComisionesService.buscarCalculoComisiones(filter);
    var result = mapper.toItemDtoList(response.getData());
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
