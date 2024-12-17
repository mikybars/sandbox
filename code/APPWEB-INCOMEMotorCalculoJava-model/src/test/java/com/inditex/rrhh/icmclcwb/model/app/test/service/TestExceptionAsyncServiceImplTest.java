package com.inditex.rrhh.icmclcwb.model.app.test.service;

import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TestExceptionAsyncServiceImplTest {
  @Mock
  private TestExceptionService testExceptionService;

  @InjectMocks
  private TestExceptionAsyncServiceImpl testExceptionAsyncService;

  @Test
  void icmclcwbExceptionTest() {
    this.testExceptionAsyncService.icmclcwbException();
    verify(this.testExceptionService).icmclcwbException();
  }

}
