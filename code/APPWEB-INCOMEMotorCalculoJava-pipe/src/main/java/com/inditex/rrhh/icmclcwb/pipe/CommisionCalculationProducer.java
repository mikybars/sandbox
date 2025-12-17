package com.inditex.rrhh.icmclcwb.pipe;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationDelete;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationUpdate;
import com.inditex.rrhh.icmclcwb.event.pipe.CommisionCalculationEventsProducer;
import com.inditex.rrhh.icmclcwb.event.pipe.CommisionCalculationV3EventsProducer;
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

  private final CommisionCalculationV3EventsProducer commisionCalculationV3EventsProducer;

  public boolean sendMessage(final CommisionCalculationEventList payload, final Header... headers) {
    LOG.info("Sending commision calculation data with size: {}}", payload.events.size());
    return this.commisionCalculationEventsProducer.CommisionCalculation(payload, headers);
  }

  public boolean sendMessageV3Update(CommisionCalculationUpdate payload, final Header... headers) {
    LOG.info("Sending commision calculation v3 update data with size: {}}", payload.eventsUpdate.size());
    return this.commisionCalculationV3EventsProducer.CommisionCalculationV3UpdateEventV3(payload, headers);
  }

  public boolean sendMessageV3Delete(CommisionCalculationDelete payload, final Header... headers) {
    LOG.info("Sending commision calculation v3 delete data with size: {}}", payload.eventsDelete.size());
    return this.commisionCalculationV3EventsProducer.CommisionCalculationV3DeleteEventV3(payload, headers);
  }
}
