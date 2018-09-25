package com.inditex.rrhh.icmclcwb.model.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.dto.VentaDTO;

public interface DB2Repository {
	void crearTemporalTest1();

	void crearTemporalTest2();

	void crearTemporalTest3();

	void insertarDatosXMLCompleto(final String contenidoFichero);

	void insertarDatosXMLTrozos(final List<VentaDTO> ventas);

	List<VentaDTO> getDatosXMLCompleto();

	List<VentaDTO> getDatosJoinXMLCompleto();
	
	List<VentaDTO> getDatosXMLTrozos();

	List<VentaDTO> getDatosJoinXMLTrozos();

	void insertarDatosJSONCompleto(final String contenidoFichero);

	List<VentaDTO> getDatosJSONCompleto();

	List<VentaDTO> getDatosJoinJSONCompleto();

}
