package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.RelojDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.test.SsoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.test.TestService;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TestServiceImpl implements TestService {

    @Autowired
    private TestAsyncService testAsyncService;

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
        throw new ApplicationException("Synchronous error");
    }

    @Override
    public void errorAsync() throws Exception {
        CompletableFuture<Void> cfErrorAsync1 = testAsyncService.errorAsync();
        cfErrorAsync1.exceptionally(e -> {
            return null;
        });

        CompletableFuture<Void> cfErrorAsync2 = testAsyncService.errorAsync();
        cfErrorAsync2.exceptionally(e -> {
            return null;
        });

        CompletableFuture.allOf(cfErrorAsync1, cfErrorAsync2).exceptionally(e -> {
            return null;
        });
    }

}