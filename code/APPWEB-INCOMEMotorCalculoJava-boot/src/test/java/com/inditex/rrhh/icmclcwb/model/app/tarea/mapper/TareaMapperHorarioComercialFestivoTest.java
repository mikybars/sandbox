package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Arrays;

import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class TareaMapperHorarioComercialFestivoTest {

  @Spy
  private final TareaMapper tareaMapper = Mappers.getMapper(TareaMapper.class);

  @Test
  public void horarioComercialFestivosRequestDtoToSolrQueryNullRequestTest() {

    final HorarioComercialFestivosRequestDto request = null;

    assertEquals("q=*", this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));

  }

  @Test
  public void horarioComercialFestivosRequestDtoToSolrQueryNoValuesTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();

    assertEquals("q=*", this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  public void horarioComercialFestivosRequestDtoToSolrQueryIdPaisTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setIdPais("11");

    assertEquals("q=idPais:11", this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  public void horarioComercialFestivosRequestDtoToSolrQueryIdCadenaTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setIdCadena("1");

    assertEquals("q=idCadena:1", this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  public void horarioComercialFestivosRequestDtoToSolrQueryIdTiendaTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setIdTienda(Arrays.asList("21", "112"));

    assertEquals("q=(idTienda:21 OR idTienda:112)",
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  public void horarioComercialFestivosRequestDtoToSolrQueryFechasTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setFechaDesde(LocalDate.of(2020, 3, 1));
    request.setFechaHasta(LocalDate.of(2020, 4, 5));

    assertNotNull(this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  public void horarioComercialFestivosRequestDtoToSolrQueryIdPaisAndFechaTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setIdPais("11");
    request.setFechaDesde(LocalDate.of(2020, 3, 1));
    request.setFechaHasta(LocalDate.of(2020, 4, 5));

    assertNotNull(
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  public void horarioComercialFestivosRequestDtoToSolrQueryIdPaisAndIdCadenaTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setIdPais("11");
    request.setIdCadena("2");

    assertEquals("q=idCadena:2 AND idPais:11",
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  public void horarioComercialFestivosRequestDtoToSolrQueryIdTiendaAndIdCadenaTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setIdTienda(Arrays.asList("111", "123"));
    request.setIdCadena("2");

    assertEquals("q=(idTienda:111 OR idTienda:123) AND idCadena:2",
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

  @Test
  public void horarioComercialFestivosRequestDtoToQueryNullTest() {

    assertEquals("q=*",
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(null));

  }

  @Test
  public void horarioComercialFestivosRequestDtoToQueryPaginationTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setStart(12);
    request.setRows(71);

    assertEquals("q=*&rows=71&start=12",
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));

  }

  @Test
  public void horarioComercialFestivosRequestDtoToSolrQueryIdPaisAndFechaAndPaginationTest() {

    final HorarioComercialFestivosRequestDto request = new HorarioComercialFestivosRequestDto();
    request.setIdPais("11");
    request.setFechaDesde(LocalDate.of(2020, 3, 1));
    request.setFechaHasta(LocalDate.of(2020, 4, 5));
    request.setRows(89);
    request.setStart(155);

    assertNotNull(
        this.tareaMapper.horarioComercialFestivosRequestDtoToQuery(request));
  }

}
