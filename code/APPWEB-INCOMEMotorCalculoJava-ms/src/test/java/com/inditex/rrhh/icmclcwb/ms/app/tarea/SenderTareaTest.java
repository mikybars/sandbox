/*
 * Copyright (c) 2022. Inditex
 */

package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.amigafwk.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.jms.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Qualifier;

@ExtendWith(MockitoExtension.class)
class SenderTareaTest {

  @Mock
  @Qualifier("tareaJmsClient")
  private JmsClient tareaJmsClient;

  @InjectMocks
  private SenderTarea senderTarea = this.getClassMock();

  private SenderTarea getClassMock() {
    return Mockito.mock(SenderTarea.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void sendWithDelayWithPriorityTest() {

    final TareaDto tarea = Mockito.mock(TareaDto.class);

    this.senderTarea.sendWithDelayWithPriority(tarea, 1L, TareaPriorityEnum.MANUAL);

    verify(this.senderTarea, times(1))
        .sendWithDelayWithPriority(Mockito.any(TareaDto.class), Mockito.eq(1L), Mockito.eq(TareaPriorityEnum.MANUAL));
  }

  @Test
  void sendWithPriorityTest() {
    final TareaDto tarea = Mockito.mock(TareaDto.class);
    this.senderTarea.sendWithPriority(tarea, TareaPriorityEnum.MANUAL);

    verify(this.senderTarea, times(1))
        .sendWithPriority(Mockito.any(TareaDto.class), Mockito.eq(TareaPriorityEnum.MANUAL));
  }

  @Test
  void sendWithDelayWithPriorityShouldSetDelayProperty() throws Exception {
    final TareaDto tarea = new TareaDto();
    final long delay = 5000L;
    final TareaPriorityEnum priority = TareaPriorityEnum.MANUAL;

    doAnswer((Answer<Void>) invocation -> {
      final Message message = invocation.getArgument(1);
      message.setLongProperty("_AMQ_SCHED_DELIVERY", delay);
      return null;
    }).when(this.tareaJmsClient).convertAndSend(eq(tarea), any());

    this.senderTarea.sendWithDelayWithPriority(tarea, delay, priority);

    verify(this.tareaJmsClient).setPriority(priority.getPriority());
    verify(this.tareaJmsClient).convertAndSend(eq(tarea), any());
  }
}
