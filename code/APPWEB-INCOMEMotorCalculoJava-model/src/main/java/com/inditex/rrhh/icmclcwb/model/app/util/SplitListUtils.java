package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.List;
import java.util.stream.IntStream;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationDelete;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationDeleteEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationDeletePK;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationUpdate;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationUpdateEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationUpdatePK;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SplitListUtils {

  @Value("${app.envars.pipe.commission-calculation.message-max-size:2000}")
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

  public List<CommisionCalculationUpdate> splitCommisionCalculationUpdateEventList(Long idTarea,
      List<CommisionCalculationUpdateEvent> originalList) {
    final int totalSize = originalList.size();
    return IntStream.range(0, (totalSize + this.maxSize - 1) / this.maxSize)
        .mapToObj(i -> {
          final CommisionCalculationUpdate subList = new CommisionCalculationUpdate();
          subList.setEventsUpdate(originalList.subList(i * this.maxSize, Math.min(totalSize, (i + 1) * this.maxSize)));
          subList.setPrimaryKeys(new CommisionCalculationUpdatePK(idTarea, (long) i));
          return subList;
        })
        .toList();
  }

  public List<CommisionCalculationDelete> splitCommisionCalculationDeleteEventList(Long idTarea,
      List<CommisionCalculationDeleteEvent> originalList) {
    final int totalSize = originalList.size();
    return IntStream.range(0, (totalSize + this.maxSize - 1) / this.maxSize)
        .mapToObj(i -> {
          final CommisionCalculationDelete subList = new CommisionCalculationDelete();
          subList.setEventsDelete(originalList.subList(i * this.maxSize, Math.min(totalSize, (i + 1) * this.maxSize)));
          subList.setPrimaryKeys(new CommisionCalculationDeletePK(idTarea, (long) i));
          return subList;
        })
        .toList();
  }
}
