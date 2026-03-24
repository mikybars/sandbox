package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class TareaMapperHorarioComercialFestivoTest {

  @Spy
  private final TareaMapper tareaMapper = Mappers.getMapper(TareaMapper.class);

  @Test
  public void horarioComercialFestivosRequestDtoToQueryParamsNullRequestTest() {

    final HorarioComercialFestivosRequestDto request = null;

    assertEquals("storeIds=", this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));

  }

  @Test
  public void horarioComercialFestivosRequestDtoToQueryParamsNoValuesTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();

    assertEquals("storeIds=", this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  public void horarioComercialFestivosRequestDtoToQueryParamsIdTiendaUniqueTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setIdTienda(List.of("21"));

    assertEquals("storeIds=21",
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  void horarioComercialFestivosRequestDtoToQueryParamsIdTiendaTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setIdTienda(Arrays.asList("21", "112"));

    assertEquals("storeIds=21,112",
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  void horarioComercialFestivosRequestDtoToQueryParamsDatesTest() {

    final LocalDate startDate = LocalDate.of(2020, 3, 1);
    final LocalDate endDate = LocalDate.of(2020, 4, 5);
    final String expectedResult = "storeIds=&startDate=2020-03-01&endDate=2020-04-06"; // endDate is incremented by 1 day in the mapper to
                                                                                       // make the end date inclusive
    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setFechaDesde(startDate);
    request.setFechaHasta(endDate);

    assertEquals(expectedResult,
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  void horarioComercialFestivosRequestDtoToQueryParamsAllParamsTest() {

    final List<String> storeIds = Arrays.asList("21", "112");
    final LocalDate startDate = LocalDate.of(2020, 3, 1);
    final LocalDate endDate = LocalDate.of(2020, 4, 5);
    final String expectedResult = "storeIds=21,112&startDate=2020-03-01&endDate=2020-04-06"; // endDate is incremented by 1 day in the
                                                                                             // mapper to make the end date inclusive

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setFechaDesde(startDate);
    request.setFechaHasta(endDate);
    request.setIdTienda(storeIds);

    assertEquals(expectedResult,
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

}
