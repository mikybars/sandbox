package com.inditex.rrhh.icmclcwb.model.primary.service;

import java.util.Arrays;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryService;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryRepositoryCustom;

@Service
@Validated
public class PrimaryServiceImpl implements PrimaryService {

    @Autowired
    private Logger log;
    
    @Autowired
    private PrimaryRepositoryCustom primaryRepositoryCustom;

    @Override
    public Boolean loadDML(@Valid @NotBlank final String path) {
        Boolean result = Boolean.FALSE;
        log.info("Inicio carga path {}", path);
        ClassPathResource resource = new ClassPathResource(path);
        log.info("Fin carga path {}", path);
        if (!resource.exists()) {
            log.error("No existe el path {}", path);
            throw new IcmclcwbException("No existe el path " + path);
        }
        log.info("Inicio load path {}", path);
        result = primaryRepositoryCustom.load(Arrays.asList(resource));
        log.info("Fin load path {} con resultado {}", path, result);
        return result;
    }

}