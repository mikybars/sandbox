package com.inditex.rrhh.icmclcwb.pipe;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;
import com.inditex.rrhh.icmclcwb.event.pipe.CommisionCalculationEventsProducer;
import com.inditex.rrhh.icmclcwb.event.pipe.Header;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommisionCalculationProducer {

  private static final Logger LOG = LoggerFactory.getLogger(CommisionCalculationProducer.class);

  private final CommisionCalculationEventsProducer commisionCalculationEventsProducer;

  public boolean sendMessage(final CommisionCalculationEventList payload, final Header... headers) {
    LOG.info("Sending commision calculation data with size: {}}", payload.events.size());
    return this.commisionCalculationEventsProducer.CommisionCalculation(payload, headers);
  }
}
