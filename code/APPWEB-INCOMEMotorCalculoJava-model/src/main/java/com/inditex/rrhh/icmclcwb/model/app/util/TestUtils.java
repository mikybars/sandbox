package com.inditex.rrhh.icmclcwb.model.app.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.LongStream;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

import org.springframework.stereotype.Component;

@Component
public class TestUtils {

  private TestUtils() {
  }

  public static void threadSleep() {
    try {
      final Random random = SecureRandom.getInstanceStrong();
      final LongStream ls = random.longs(1000, 5000);
      final long time = ls.findFirst().getAsLong();
      ls.close();
      System.out.println(Thread.currentThread().getName() + " :: Inicio :: Thread.sleep(" + time + ")");
      Thread.sleep(time);
      System.out.println(Thread.currentThread().getName() + " :: Fin :: Thread.sleep(" + time + ")");
    } catch (final InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new IcmclcwbException("Error en Thread.sleep()");
    } catch (final NoSuchAlgorithmException e) {
      throw new IcmclcwbException("Error en Thread.sleep()");
    }
  }

  public static String decode(final String value) {
    try {
      return URLDecoder.decode(value, StandardCharsets.UTF_8.name());
    } catch (final UnsupportedEncodingException e) {
      throw new IcmclcwbException("Error al decodificar el valor ", e);
    }
  }

}
