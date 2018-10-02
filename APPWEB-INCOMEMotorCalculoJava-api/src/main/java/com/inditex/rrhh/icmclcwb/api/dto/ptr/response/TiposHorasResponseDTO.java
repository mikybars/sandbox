package com.inditex.rrhh.icmclcwb.api.dto.ptr.response;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO;
import com.inditex.rrhh.icmclcwb.api.dto.ptr.request.TiposHorasRequestDTO.TiposHorasRequestDTOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TiposHorasResponseDTO {

	private Integer origen;
	private Integer tipoHora;
	private Boolean excluidoDenom;
	private Boolean excluidoCalculo;
	public Integer getOrigen() {
		return origen;
	}
	public void setOrigen(Integer origen) {
		this.origen = origen;
	}
	public Integer getTipoHora() {
		return tipoHora;
	}
	public void setTipoHora(Integer tipoHora) {
		this.tipoHora = tipoHora;
	}
	public Boolean getExcluidoDenom() {
		return excluidoDenom;
	}
	public void setExcluidoDenom(Boolean excluidoDenom) {
		this.excluidoDenom = excluidoDenom;
	}
	public Boolean getExcluidoCalculo() {
		return excluidoCalculo;
	}
	public void setExcluidoCalculo(Boolean excluidoCalculo) {
		this.excluidoCalculo = excluidoCalculo;
	}
	

}
