package com.inditex.rrhh.icmclcwb.model.primary.service;

import java.util.Arrays;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
    private PrimaryRepositoryCustom primaryRepositoryCustom;

    @Override
    public Boolean loadDML(@Valid @NotBlank final String path) {
        ClassPathResource resource = new ClassPathResource(path);
        if (!resource.exists()) {
            throw new IcmclcwbException("No existe el path");
        }
        return primaryRepositoryCustom.load(Arrays.asList(resource));
    }

}