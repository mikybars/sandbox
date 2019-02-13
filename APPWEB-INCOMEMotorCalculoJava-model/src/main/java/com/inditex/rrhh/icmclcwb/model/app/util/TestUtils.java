package com.inditex.rrhh.icmclcwb.model.app.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

@Component
public class TestUtils {

    private TestUtils() {
    }

    public static void threadSleep() {
//      Random random = new Random();
//      LongStream ls = random.longs(1000, 5000);
//      long time = ls.findFirst().getAsLong();
//      ls.close();
//      Thread.sleep(time);
    }
    
    public static String decode(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new IcmclcwbException("Error al decodificar el valor ", e);
        }
    }

}
