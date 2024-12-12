/*
 * Copyright (c) 2022. Inditex
 */

package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import static org.mockito.ArgumentMatchers.any;
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.MessagePostProcessor;

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
  void sendWithDelayWithPriorityTest() throws Exception {

    final TareaDto tarea = Mockito.mock(TareaDto.class);
    final TareaPriorityEnum priority = TareaPriorityEnum.MANUAL;
    final long delay = 1L;

    final Message message = Mockito.mock(Message.class);
    doAnswer(invocation -> {
      final MessagePostProcessor processor = invocation.getArgument(1);
      return processor.postProcessMessage(message);
    }).when(this.tareaJmsClient).convertAndSend(any(TareaDto.class), any(MessagePostProcessor.class));

    this.senderTarea.sendWithDelayWithPriority(tarea, delay, priority);

    verify(this.senderTarea, times(1))
        .sendWithDelayWithPriority(Mockito.any(TareaDto.class), Mockito.eq(delay), Mockito.eq(priority));
    verify(this.tareaJmsClient).setPriority(priority.getPriority());
    verify(message).setLongProperty("_AMQ_SCHED_DELIVERY", delay);
    verify(this.tareaJmsClient).convertAndSend(any(TareaDto.class), any(MessagePostProcessor.class));
  }

  @Test
  void sendWithPriorityTest() {
    final TareaDto tarea = Mockito.mock(TareaDto.class);
    final TareaPriorityEnum priority = TareaPriorityEnum.MANUAL;

    this.senderTarea.sendWithPriority(tarea, TareaPriorityEnum.MANUAL);

    verify(this.senderTarea, times(1))
        .sendWithPriority(Mockito.any(TareaDto.class), Mockito.eq(TareaPriorityEnum.MANUAL));
    verify(this.tareaJmsClient).setPriority(priority.getPriority());
    verify(this.tareaJmsClient).convertAndSend(tarea);
  }
}
