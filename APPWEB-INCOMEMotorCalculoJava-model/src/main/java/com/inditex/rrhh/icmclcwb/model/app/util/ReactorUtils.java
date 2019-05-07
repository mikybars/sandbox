package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.exception.ReactorIcmclcwbException;

@Component
public class ReactorUtils {

    private ReactorUtils() {
    }

    public static void await(final CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new ReactorIcmclcwbException(e.getMessage(), e);
        }
    }
    
    public static void countDown(final CountDownLatch latch) {
        latch.countDown();
        // TODO Eliminar
        System.out.println("latch.countDown();");
    }

}
