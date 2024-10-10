package com.inditex.rrhh.icmclcwb.pipe;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.rrhh.icmclcwb.event.pipe.CommisionCalculationEventsProducer;

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

  private CommisionCalculationEvent event;

  @BeforeEach
  void setUp() {
    this.event = new CommisionCalculationEvent();
  }

  @Test
  void sendMessage_withValidPayloadAndHeaders_returnsTrue() {
    doReturn(true).when(this.eventsProducer).CommisionCalculation(this.event);
    assertTrue(this.producer.sendMessage(this.event));
    verify(this.eventsProducer).CommisionCalculation(this.event);
  }
}
