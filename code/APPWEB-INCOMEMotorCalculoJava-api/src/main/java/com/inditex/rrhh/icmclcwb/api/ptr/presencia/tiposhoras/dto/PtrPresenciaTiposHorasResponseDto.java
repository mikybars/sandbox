package com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PtrPresenciaTiposHorasResponseDto implements Serializable {

  private static final long serialVersionUID = 2859649142501610924L;

  private List<PtrPresenciaTiposHorasResultItemDto> tiposHoras;

}
