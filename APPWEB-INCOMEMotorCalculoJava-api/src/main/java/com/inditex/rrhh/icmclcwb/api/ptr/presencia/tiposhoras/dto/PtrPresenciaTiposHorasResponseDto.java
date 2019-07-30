package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PtrPresenciaTiposHorasResponseDto implements Serializable {

    private static final long serialVersionUID = 2859649142501610924L;

    private List<PtrPresenciaTiposHorasResultItemDto> tiposHoras;

}
