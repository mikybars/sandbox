package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.Message;

@ExtendWith(MockitoExtension.class)
class ReceiverTareaTest {

  @InjectMocks
  ReceiverTarea receiverTarea;

  @Mock
  RunService runService;

  @Test
  void when_tarea_message_received_expect_run_service_called() {
    final Long tareaId = 99L;
    final TareaDto tareaDto = mock(TareaDto.class);
    final Message<TareaDto> message = mock(Message.class);
    when(message.getPayload()).thenReturn(tareaDto);
    when(tareaDto.getId()).thenReturn(tareaId);

    this.receiverTarea.onMessageTareaListener(message);

    verify(this.runService).runTarea(tareaId);
  }
}
