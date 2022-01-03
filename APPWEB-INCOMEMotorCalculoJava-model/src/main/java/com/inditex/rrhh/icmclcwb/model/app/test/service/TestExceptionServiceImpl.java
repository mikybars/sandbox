package com.inditex.rrhh.icmclcwb.model.app.test.service;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.test.service.TestExceptionService;
import com.inditex.rrhh.icmclcwb.model.app.util.TestUtils;

import org.springframework.stereotype.Service;

@Service
public class TestExceptionServiceImpl implements TestExceptionService {

  @Override
  public void icmclcwbException() {
    TestUtils.threadSleep();
    throw new IcmclcwbException("Asynchronous error");
  }

}
