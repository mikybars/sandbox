package com.inditex.rrhh.icmclcwb.model.app.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v1.CommisionCalculationEventList;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationDelete;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationDeleteEvent;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationUpdate;
import com.inditex.icmclcwb.commisioncalculation.model.v3.CommisionCalculationUpdateEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(SpringExtension.class)
class SplitListUtilsTest {

  private SplitListUtils splitListUtils;

  @BeforeEach
  public void setUp() {
    this.splitListUtils = new SplitListUtils();
    ReflectionTestUtils.setField(this.splitListUtils, "maxSize", 2);
  }

  @Test
  void testSplitList() {
    final CommisionCalculationEvent event1 = new CommisionCalculationEvent();
    final CommisionCalculationEvent event2 = new CommisionCalculationEvent();
    final CommisionCalculationEvent event3 = new CommisionCalculationEvent();

    final CommisionCalculationEventList originalList = new CommisionCalculationEventList();
    originalList.setEvents(Arrays.asList(event1, event2, event3));

    final List<CommisionCalculationEventList> result = this.splitListUtils.splitList(originalList);

    assertEquals(2, result.size());
    assertEquals(2, result.get(0).getEvents().size());
    assertEquals(1, result.get(1).getEvents().size());
  }

  @Test
  void testSplitCommisionCalculationUpdateEventList() {
    final CommisionCalculationUpdateEvent event1 = new CommisionCalculationUpdateEvent();
    final CommisionCalculationUpdateEvent event2 = new CommisionCalculationUpdateEvent();
    final CommisionCalculationUpdateEvent event3 = new CommisionCalculationUpdateEvent();

    final List<CommisionCalculationUpdateEvent> originalList = Arrays.asList(event1, event2, event3);

    final List<CommisionCalculationUpdate> result = this.splitListUtils.splitCommisionCalculationUpdateEventList(0L, originalList);

    assertEquals(2, result.size());
    assertEquals(2, result.get(0).getEventsUpdate().size());
    assertEquals(1, result.get(1).getEventsUpdate().size());
  }

  @Test
  void testSplitCommisionCalculationDeleteEventList() {
    final CommisionCalculationDeleteEvent event1 = new CommisionCalculationDeleteEvent();
    final CommisionCalculationDeleteEvent event2 = new CommisionCalculationDeleteEvent();
    final CommisionCalculationDeleteEvent event3 = new CommisionCalculationDeleteEvent();

    final List<CommisionCalculationDeleteEvent> originalList = Arrays.asList(event1, event2, event3);

    final List<CommisionCalculationDelete> result = this.splitListUtils.splitCommisionCalculationDeleteEventList(0L, originalList);

    assertEquals(2, result.size());
    assertEquals(2, result.get(0).getEventsDelete().size());
    assertEquals(1, result.get(1).getEventsDelete().size());
  }
}
