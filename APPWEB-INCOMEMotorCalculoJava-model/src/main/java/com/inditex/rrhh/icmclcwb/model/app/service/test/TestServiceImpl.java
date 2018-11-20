package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestExceptionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestExceptionService;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TestServiceImpl implements TestService {

    @Autowired
    private TestExceptionService testExceptionService;

    @Autowired
    private TestExceptionAsyncService testExceptionAsyncService;

    @Override
    public RelojDto reloj() {
        return new RelojDto();
    }

    @Override
    public SsoDto sso() {
        return SsoDto.builder().result(SsoUtils.getUserSSO().toString()).build();
    }

    @Override
    public void errorSync() throws Exception {
        testExceptionService.applicationException();
    }

    @Override
    public void errorAsync() throws Exception {
        CompletableFuture<Void> cfErrorAsync1 = testExceptionAsyncService.applicationException();
        AsyncUtils.exceptionally(cfErrorAsync1, new ArrayList<>());

        CompletableFuture<Void> cfErrorAsync2 = testExceptionAsyncService.applicationException();
        AsyncUtils.exceptionally(cfErrorAsync2, new ArrayList<>());

        CompletableFuture<Void> cfErrorAsyncAllOf = CompletableFuture.allOf(cfErrorAsync1, cfErrorAsync2);
        AsyncUtils.exceptionally(cfErrorAsyncAllOf, new ArrayList<>());
    }

}