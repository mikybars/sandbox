package com.inditex.rrhh.icmclcwb.api.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "Modelo TrabajoRunCalcularDto")
@Data
public class TrabajoRunCalcularDto implements Serializable {

    private static final long serialVersionUID = -7845168234640449805L;

    private List<Integer> tiposCalculo = new ArrayList<>();

    private List<Integer> idsEmpleados = new ArrayList<>();

}
