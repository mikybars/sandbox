package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciaTiposHorasResponseDto {

    private List<PtrPresenciaTiposHorasResultItemDto> tiposHoras;

}
