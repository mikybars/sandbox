package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.List;
import java.util.stream.IntStream;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SplitListUtils {

  public SplitListUtils() {
  }

  @Value("${icmclcwb.pipe.commision-calculation.message-max-size:5000}")
  private static int maxSize;

  public static List<CommisionCalculationEventList> splitList(CommisionCalculationEventList originalList) {
    final List<CommisionCalculationEvent> events = originalList.getEvents();
    final int totalSize = events.size();

    return IntStream.range(0, (totalSize + maxSize - 1) / maxSize)
        .mapToObj(i -> {
          final CommisionCalculationEventList subList = new CommisionCalculationEventList();
          subList.setEvents(events.subList(i * maxSize, Math.min(totalSize, (i + 1) * maxSize)));
          return subList;
        })
        .toList();
  }
}
