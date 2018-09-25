package com.inditex.rrhh.icmclcwb.api.dto;

import java.util.Date;

public class VentaDTO {
	private Date fecha;
	private Integer idPais;
	private Integer idCadena;
	private Integer idTienda;
	private Float importeSinIva;
	private Float importeConIva;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public Integer getIdCadena() {
		return idCadena;
	}

	public void setIdCadena(Integer idCadena) {
		this.idCadena = idCadena;
	}

	public Integer getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}

	public Float getImporteSinIva() {
		return importeSinIva;
	}

	public void setImporteSinIva(Float importeSinIva) {
		this.importeSinIva = importeSinIva;
	}

	public Float getImporteConIva() {
		return importeConIva;
	}

	public void setImporteConIva(Float importeConIva) {
		this.importeConIva = importeConIva;
	}

}
