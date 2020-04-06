package com.inditex.rrhh.icmclcwb.api.ptr.dto;

import com.inditex.rrhh.icmclcwb.api.app.dto.GenericFilterPropertiesDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PtrFilterPropertiesDto extends GenericFilterPropertiesDto {

    public Integer periodSize;

    public PtrPageEnum periodType;

}
