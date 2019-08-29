package com.inditex.rrhh.icmclcwb.model.app.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;

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

}
