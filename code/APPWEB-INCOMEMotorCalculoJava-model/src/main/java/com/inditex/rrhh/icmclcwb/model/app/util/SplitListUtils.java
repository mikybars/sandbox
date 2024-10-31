package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SplitListUtils {

  @Value("${app.envars.pipe.commission-calculation.message-max-size:5000}")
  private int maxSize;

  public SplitListUtils() {
  }

  public List<CommisionCalculationEventList> splitList(CommisionCalculationEventList originalList) {
    final List<CommisionCalculationEvent> events = originalList.getEvents();
    final int totalSize = events.size();
    log.info("Splitting list of size {} with limit {}", totalSize, this.maxSize);
    return IntStream.range(0, (totalSize + this.maxSize - 1) / this.maxSize)
        .mapToObj(i -> {
          final CommisionCalculationEventList subList = new CommisionCalculationEventList();
          subList.setEvents(events.subList(i * this.maxSize, Math.min(totalSize, (i + 1) * this.maxSize)));
          return subList;
        })
        .toList();
  }

  public List<CommisionCalculationEvent> expandListTo100k(List<CommisionCalculationEvent> originalList) {
    final List<CommisionCalculationEvent> expandedList = new ArrayList<>(originalList);
    while (expandedList.size() <= 100000) {
      expandedList.addAll(new ArrayList<>(originalList));
    }
    return expandedList;
  }
}
