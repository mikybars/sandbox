package com.inditex.rrhh.icmclcwb.pipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.List;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;
import com.inditex.rrhh.icmclcwb.event.pipe.CommisionCalculationEventsProducer;
import com.inditex.rrhh.icmclcwb.event.pipe.Header;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class CommisionCalculationProducerTest {

  @InjectMocks
  private CommisionCalculationProducer producer;

  @Mock
  private CommisionCalculationEventsProducer eventsProducer;

  private CommisionCalculationEventList eventList;

  @BeforeEach
  void setUp() {
    final CommisionCalculationEvent event1 = CommisionCalculationEvent.newBuilder()
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
        .build();

    final CommisionCalculationEvent event2 = CommisionCalculationEvent.newBuilder()
        .setIcmIdPeriodo(2L)
        .setCclIdOrigen(3L)
        .setStdIdLegEnt(4L)
        .setCclIdPerson(5L)
        .setStdOrHrPeriod(6L)
        .setIdEstado(7)
        .setFechaInicioPeriodo(LocalDate.now().minusDays(1))
        .setFechaFinPeriodo(LocalDate.now())
        .setFecha(LocalDate.now().minusDays(1))
        .setTiendaCalculo(8L)
        .setFechaInicioEstructura(LocalDate.now().minusDays(1))
        .setFechaFinEstructura(LocalDate.now())
        .setCclIdSeccion(9L)
        .setBanda(10L)
        .setValor(11.0f)
        .setIcmIdTpComision("comision2")
        .setIcmIdTpCalculo("calculo2")
        .setIcmGrupoManual("manual2")
        .setIdTipoOpcionCalculo(12L)
        .setCclIdCodOrigenDestino(13L)
        .setCodTipoHora(14L)
        .setMinutos(15L)
        .setCodTiendaPresenciaEmpleado(16L)
        .setCodSeccionPresenciaEmpleado(17L)
        .setMinutosTienda(18L)
        .setCodTiendaPresencia(19L)
        .setCodSeccionPresencia(20L)
        .setImporteTotal(21.0f)
        .setImporteTotalSinAjuste(22.0f)
        .setImporteAjusteTotal(23.0f)
        .setImporteFisica(24.0f)
        .setImporteFisicaSinAjuste(25.0f)
        .setImporteAjusteFisica(26.0f)
        .setImporteOnlineIpod(27.0f)
        .setImporteOnlineIpodSinAjuste(28.0f)
        .setImporteAjusteOnlineIpod(29.0f)
        .setImporteOnlineSint(30.0f)
        .setImporteOnlineSintSinAjuste(31.0f)
        .setImporteAjusteOnlineSint(32.0f)
        .setImporteOnlineEntregaTienda(33.0f)
        .setImporteOnlineEntregaTiendaSinAjuste(34.0f)
        .setImporteAjusteOnlineEntregaTienda(35.0f)
        .setImporteOnlineEntregaDomicilio(36.0f)
        .setImporteOnlineEntregaDomicilioSinAjuste(37.0f)
        .setImporteAjusteOnlineEntregaDomicilio(38.0f)
        .setVentaTotal(39.0f)
        .setVentaFisica(40.0f)
        .setVentaOnlineIpod(41.0f)
        .setVentaOnlineSint(42.0f)
        .setVentaOnlineEntregaTienda(43.0f)
        .setVentaOnlineEntregaDomicilio(44.0f)
        .setObjetivo(45.0f)
        .setExcepcionada(46)
        .setCongelada(47)
        .setChallengeVentaTotal(48.0f)
        .setChallengeVentaCaja(49.0f)
        .setChallengeDevoluciones(50.0f)
        .setChallengeVentaOnlineIpod(51.0f)
        .setChallengeVentaOnlinePicking(52.0f)
        .setChallengeVentaOnlineEntregaTienda(53.0f)
        .setImporteVentaFisicaIndividual(54.0f)
        .setImporteDevolucionFisicaIndividual(55.0f)
        .setImporteVentaOnlineIpod(56.0f)
        .setImporteDevolucionIndividualIpod(57.0f)
        .setCoeficienteReduccionJornada(58.0f)
        .build();

    this.eventList = CommisionCalculationEventList.newBuilder()
        .setEvents(List.of(event1, event2))
        .build();
  }

  @Test
  void sendMessage() {
    doReturn(true).when(this.eventsProducer).CommisionCalculation(this.eventList);
    assertTrue(this.producer.sendMessage(this.eventList));
    verify(this.eventsProducer).CommisionCalculation(this.eventList);
  }

  @Test
  void sendMessageFails() {
    doReturn(false).when(this.eventsProducer).CommisionCalculation(this.eventList);
    assertFalse(this.producer.sendMessage(this.eventList));
    verify(this.eventsProducer).CommisionCalculation(this.eventList);
  }

  @Test
  void sendMessageThrowsException() {
    doThrow(new RuntimeException("Test Exception")).when(this.eventsProducer).CommisionCalculation(this.eventList);
    final RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
      this.producer.sendMessage(this.eventList);
    });
    assertEquals("Test Exception", exception.getMessage());
    verify(this.eventsProducer).CommisionCalculation(this.eventList);
  }

  @Test
  void sendMessageWithHeaders() {
    final Header header = new Header("key", "value");
    doReturn(true).when(this.eventsProducer).CommisionCalculation(this.eventList, header);
    assertTrue(this.producer.sendMessage(this.eventList, header));
    verify(this.eventsProducer).CommisionCalculation(this.eventList, header);
  }
}
