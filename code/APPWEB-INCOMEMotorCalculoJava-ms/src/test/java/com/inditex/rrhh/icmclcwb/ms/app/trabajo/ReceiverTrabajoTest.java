package com.inditex.rrhh.icmclcwb.ms.app.trabajo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.Message;

@ExtendWith(MockitoExtension.class)
class ReceiverTrabajoTest {

  @InjectMocks
  ReceiverTrabajo receiverTrabajo;

  @Mock
  RunService runService;

  @Test
  void when_trabajo_message_received_expect_run_service_called() {
    final Long trabajoId = 42L;
    final TrabajoDTO trabajoDTO = mock(TrabajoDTO.class);
    final Message<TrabajoDTO> message = mock(Message.class);
    when(message.getPayload()).thenReturn(trabajoDTO);
    when(trabajoDTO.getId()).thenReturn(trabajoId);

    this.receiverTrabajo.onMessageTrabajoListener(message);

    verify(this.runService).runTrabajo(trabajoId);
  }
}
