package com.inditex.rrhh.icmclcwb.model.app.util;

import java.io.IOException;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Component;

@Component
public class FileUtils {

  private FileUtils() {
  }

  public static Resource getResource(ResourceLoader resourceLoader, String path) {
    Resource resource = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
        .getResource("classpath:" + path);
    if (!resource.exists()) {
      throw new IcmclcwbException("No existe el path " + path);
    }
    return resource;
  }

  public static Resource[] getResources(ResourceLoader resourceLoader, String path) throws IOException {
    Resource[] resource = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
        .getResources("classpath:" + path);
    if (resource.length == 0) {
      throw new IcmclcwbException("No existe el path " + path);
    }
    return resource;
  }

}
