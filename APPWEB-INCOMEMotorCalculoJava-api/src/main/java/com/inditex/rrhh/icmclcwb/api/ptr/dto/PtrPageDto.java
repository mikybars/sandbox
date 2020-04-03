package com.inditex.rrhh.icmclcwb.api.ptr.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPageDto {

    private Integer size;

    private PtrPageEnum type;

}
