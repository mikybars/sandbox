package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaMigrarComisionDto;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class TareaMigrarMapperTest {

  private final TareaMigrarMapper tareaMigrarMapper = Mappers.getMapper(TareaMigrarMapper.class);

  static Stream<List<TareaMigrarComisionDto>> provideTestData() {
    return Stream.of(
        List.of(TareaMigrarComisionDto.builder()
            .icmIdPeriodo(1L)
            .cclIdOrigen(2L)
            .stdIdLegEnt(3L)
            .cclIdPerson(4L)
            .stdOrHrPeriod(5L)
            .idEstado(6)
            .fechaInicioPeriodo(LocalDate.now())
            .fechaFinPeriodo(LocalDate.now().plusDays(1))
            .fecha(LocalDate.now())
            .tiendaCalculo(7L)
            .fechaInicioEstructura(LocalDate.now())
            .fechaFinEstructura(LocalDate.now().plusDays(1))
            .cclIdSeccion(8L)
            .banda(9L)
            .valor(10.0f)
            .icmIdTpComision("comision")
            .icmIdTpCalculo("calculo")
            .icmGrupoManual("manual")
            .idTipoOpcionCalculo(11L)
            .cclIdCodOrigenDestino(12L)
            .codTipoHora(13L)
            .minutos(14L)
            .codTiendaPresenciaEmpleado(15L)
            .codSeccionPresenciaEmpleado(16L)
            .minutosTienda(17L)
            .codTiendaPresencia(18L)
            .codSeccionPresencia(19L)
            .importeTotal(20.0f)
            .importeTotalSinAjuste(21.0f)
            .importeAjusteTotal(22.0f)
            .importeFisica(23.0f)
            .importeFisicaSinAjuste(24.0f)
            .importeAjusteFisica(25.0f)
            .importeOnlineIpod(26.0f)
            .importeOnlineIpodSinAjuste(27.0f)
            .importeAjusteOnlineIpod(28.0f)
            .importeOnlineSint(29.0f)
            .importeOnlineSintSinAjuste(30.0f)
            .importeAjusteOnlineSint(31.0f)
            .importeOnlineEntregaTienda(32.0f)
            .importeOnlineEntregaTiendaSinAjuste(33.0f)
            .importeAjusteOnlineEntregaTienda(34.0f)
            .importeOnlineEntregaDomicilio(35.0f)
            .importeOnlineEntregaDomicilioSinAjuste(36.0f)
            .importeAjusteOnlineEntregaDomicilio(37.0f)
            .ventaTotal(38.0f)
            .ventaFisica(39.0f)
            .ventaOnlineIpod(40.0f)
            .ventaOnlineSint(41.0f)
            .ventaOnlineEntregaTienda(42.0f)
            .ventaOnlineEntregaDomicilio(43.0f)
            .objetivo(44.0f)
            .excepcionada(45)
            .congelada(46)
            .challengeVentaTotal(47.0f)
            .challengeVentaCaja(48.0f)
            .challengeDevoluciones(49.0f)
            .challengeVentaOnlineIpod(50.0f)
            .challengeVentaOnlinePicking(51.0f)
            .challengeVentaOnlineEntregaTienda(52.0f)
            .importeVentaFisicaIndividual(53.0f)
            .importeDevolucionFisicaIndividual(54.0f)
            .importeVentaOnlineIpod(55.0f)
            .importeDevolucionIndividualIpod(56.0f)
            .coeficienteReduccionJornada(57.0f)
            .build()));
  }

  static Stream<CommisionCalculationEventList> provideEventListData() {
    return Stream.of(
        CommisionCalculationEventList.newBuilder()
            .setEvents(List.of(
                CommisionCalculationEvent.newBuilder()
                    .setIcmIdPeriodo(1L)
                    .setCclIdOrigen(2L)
                    .setStdIdLegEnt(3L)
                    .setCclIdPerson(4L)
                    .setStdOrHrPeriod(5L)
                    .setIdEstado(6)
                    .setFechaInicioPeriodo(LocalDate.now())
                    .setFechaFinPeriodo(LocalDate.now().plusDays(1))
                    .setFecha(LocalDate.now())
                    .setTiendaCalculo(7L)
                    .setFechaInicioEstructura(LocalDate.now())
                    .setFechaFinEstructura(LocalDate.now().plusDays(1))
                    .setCclIdSeccion(8L)
                    .setBanda(9L)
                    .setValor(10.0f)
                    .setIcmIdTpComision("comision")
                    .setIcmIdTpCalculo("calculo")
                    .setIcmGrupoManual("manual")
                    .setIdTipoOpcionCalculo(11L)
                    .setCclIdCodOrigenDestino(12L)
                    .setCodTipoHora(13L)
                    .setMinutos(14L)
                    .setCodTiendaPresenciaEmpleado(15L)
                    .setCodSeccionPresenciaEmpleado(16L)
                    .setMinutosTienda(17L)
                    .setCodTiendaPresencia(18L)
                    .setCodSeccionPresencia(19L)
                    .setImporteTotal(20.0f)
                    .setImporteTotalSinAjuste(21.0f)
                    .setImporteAjusteTotal(22.0f)
                    .setImporteFisica(23.0f)
                    .setImporteFisicaSinAjuste(24.0f)
                    .setImporteAjusteFisica(25.0f)
                    .setImporteOnlineIpod(26.0f)
                    .setImporteOnlineIpodSinAjuste(27.0f)
                    .setImporteAjusteOnlineIpod(28.0f)
                    .setImporteOnlineSint(29.0f)
                    .setImporteOnlineSintSinAjuste(30.0f)
                    .setImporteAjusteOnlineSint(31.0f)
                    .setImporteOnlineEntregaTienda(32.0f)
                    .setImporteOnlineEntregaTiendaSinAjuste(33.0f)
                    .setImporteAjusteOnlineEntregaTienda(34.0f)
                    .setImporteOnlineEntregaDomicilio(35.0f)
                    .setImporteOnlineEntregaDomicilioSinAjuste(36.0f)
                    .setImporteAjusteOnlineEntregaDomicilio(37.0f)
                    .setVentaTotal(38.0f)
                    .setVentaFisica(39.0f)
                    .setVentaOnlineIpod(40.0f)
                    .setVentaOnlineSint(41.0f)
                    .setVentaOnlineEntregaTienda(42.0f)
                    .setVentaOnlineEntregaDomicilio(43.0f)
                    .setObjetivo(44.0f)
                    .setExcepcionada(45)
                    .setCongelada(46)
                    .setChallengeVentaTotal(47.0f)
                    .setChallengeVentaCaja(48.0f)
                    .setChallengeDevoluciones(49.0f)
                    .setChallengeVentaOnlineIpod(50.0f)
                    .setChallengeVentaOnlinePicking(51.0f)
                    .setChallengeVentaOnlineEntregaTienda(52.0f)
                    .setImporteVentaFisicaIndividual(53.0f)
                    .setImporteDevolucionFisicaIndividual(54.0f)
                    .setImporteVentaOnlineIpod(55.0f)
                    .setImporteDevolucionIndividualIpod(56.0f)
                    .setCoeficienteReduccionJornada(57.0f)
                    .build()))
            .build());
  }

  @ParameterizedTest
  @MethodSource("provideTestData")
  public void testTareaMigrarComisionDtoListToCommisionCalculationEventList(List<TareaMigrarComisionDto> dtoList) {
    final CommisionCalculationEventList result = this.tareaMigrarMapper.tareaMigrarComisionDtoListToCommisionCalculationEventList(dtoList);

    assertNotNull(result);
    assertEquals(1, result.getEvents().size());
    assertEquals(provideEventListData().findFirst().get().getEvents().get(0), result.getEvents().get(0));
  }
}
