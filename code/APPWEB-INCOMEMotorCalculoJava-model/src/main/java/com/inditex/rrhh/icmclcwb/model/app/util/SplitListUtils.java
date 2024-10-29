package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.List;
import java.util.stream.IntStream;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SplitListUtils {

  @Value("${app.envars.pipe.commission-calculation.message-max-size:5000}")
  private int maxSize;

  public SplitListUtils() {
  }

  public List<CommisionCalculationEventList> splitList(CommisionCalculationEventList originalList) {
    final List<CommisionCalculationEvent> events = originalList.getEvents();
    final int totalSize = events.size();

    return IntStream.range(0, (totalSize + this.maxSize - 1) / this.maxSize)
        .mapToObj(i -> {
          final CommisionCalculationEventList subList = new CommisionCalculationEventList();
          subList.setEvents(events.subList(i * this.maxSize, Math.min(totalSize, (i + 1) * this.maxSize)));
          return subList;
        })
        .toList();
  }
}
