package com.inditex.rrhh.icmclcwb.model.repository.test;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.test.VentaDto;

public interface SQLServerRepository {

	void crearTemporalTest1();

	void crearTemporalTest2();

	void crearTemporalTest3();

	void insertarDatosXMLCompleto(final String contenidoFichero);

	void insertarDatosXMLTrozos(final List<VentaDto> ventas);

	List<VentaDto> getDatosXMLCompleto();

	List<VentaDto> getDatosJoinXMLCompleto();
	
	List<VentaDto> getDatosXMLTrozos();

	List<VentaDto> getDatosJoinXMLTrozos();

	void insertarDatosJSONCompleto(final String contenidoFichero);

	List<VentaDto> getDatosJSONCompleto();

	List<VentaDto> getDatosJoinJSONCompleto();

}
