package com.inditex.rrhh.icmclcwb.model.app.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.stream.LongStream;

import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

@Component
public class TestUtils {

    private TestUtils() {
    }

    public static void threadSleep() {
        try {
            Random random = new Random();
            LongStream ls = random.longs(1000, 5000);
            long time = ls.findFirst().getAsLong();
            ls.close();
            System.out.println(Thread.currentThread().getName() + " :: Inicio :: Thread.sleep(" + time + ")");
            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName() + " :: Fin :: Thread.sleep(" + time + ")");
        } catch (InterruptedException e) {
            throw new IcmclcwbException("Error en Thread.sleep()");
        }
    }

    public static String decode(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new IcmclcwbException("Error al decodificar el valor ", e);
        }
    }

}
