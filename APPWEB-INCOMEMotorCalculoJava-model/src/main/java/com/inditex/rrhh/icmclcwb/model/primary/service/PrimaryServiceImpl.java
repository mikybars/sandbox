package com.inditex.rrhh.icmclcwb.model.primary.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.primary.service.PrimaryService;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryRepositoryCustom;

@Service
@Validated
public class PrimaryServiceImpl implements PrimaryService {

    @Autowired
    private PrimaryRepositoryCustom primaryRepositoryCustom;

    @Override
    public Boolean loadDML() {
        ArrayList<Resource> resource = new ArrayList<>();
        resource.add(new ClassPathResource("import-primary-dml.sql"));
        return primaryRepositoryCustom.load(resource);
    }

}