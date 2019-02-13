package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import org.springframework.core.io.Resource;

public interface PrimaryRepositoryCustom {

    Boolean load(List<Resource> resource);

}
