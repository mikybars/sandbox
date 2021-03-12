package com.inditex.rrhh.icmclcwb.model.app.util;

import com.inditex.rrhh.icmclcwb.api.app.exception.ReactorIcmclcwbException;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class ReactorUtils {

    private ReactorUtils() {
    }

    public static void await(final CountDownLatch latch) {
        try {
            latch.await();
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ReactorIcmclcwbException("Error ReactorUtils.ReactorUtils()", e);
        }
    }

    public static void countDown(final CountDownLatch latch) {
        latch.countDown();
    }

}
