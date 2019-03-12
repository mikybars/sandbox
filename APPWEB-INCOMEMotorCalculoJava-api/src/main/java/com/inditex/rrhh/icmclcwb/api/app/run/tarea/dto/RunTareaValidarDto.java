package com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class RunTareaValidarDto implements Serializable {

    private static final long serialVersionUID = -3950518148213548040L;

    private Set<String> duplicated = new HashSet<>();

    private Integer count;
    
    private Class<?> type;
    
}
