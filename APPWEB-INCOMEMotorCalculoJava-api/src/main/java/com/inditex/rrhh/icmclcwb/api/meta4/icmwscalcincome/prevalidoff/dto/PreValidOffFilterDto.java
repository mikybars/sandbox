package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.prevalidoff.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PreValidOffFilterDto implements Serializable {

    private List<PreValidOffFilterParametersDto> item;

}
