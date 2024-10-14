package com.inditex.rrhh.icmclcwb.pipe;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;
import com.inditex.rrhh.icmclcwb.event.pipe.CommisionCalculationEventsProducer;
import com.inditex.rrhh.icmclcwb.event.pipe.Header;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommisionCalculationProducer {

  private final CommisionCalculationEventsProducer commisionCalculationEventsProducer;

  public boolean sendMessage(final CommisionCalculationEventList payload, final Header... headers) {
    return this.commisionCalculationEventsProducer.CommisionCalculation(payload, headers);
  }
}
