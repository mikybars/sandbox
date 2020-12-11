package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.reqprevalidoff.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ReqPreValidOffFilterDto implements Serializable {
    
    private static final long serialVersionUID = -1L;

    private List<ReqPreValidOffFilterParametersDto> item;

}
