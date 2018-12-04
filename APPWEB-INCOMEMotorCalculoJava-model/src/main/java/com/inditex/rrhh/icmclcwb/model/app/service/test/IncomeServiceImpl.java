package com.inditex.rrhh.icmclcwb.model.app.service.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.test.VentaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.test.IncomeService;
import com.inditex.rrhh.icmclcwb.model.repository.test.DB2Repository;
import com.inditex.rrhh.icmclcwb.model.repository.test.SQLServerRepository;

@Service
@Validated
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	private Logger logger;

	@Autowired
	private SQLServerRepository sQLServerRepository;

	@Autowired
	private DB2Repository dB2Repository;

	@Override
	public void pruebaXMLSQLServerFicheroCompleto(final String path) throws IOException {
		java.util.Date time1 = new java.util.Date();

		final File ficheroXML = new File(path);
		final String contenidoFichero = FileUtils.readFileToString(ficheroXML, "UTF-8");

		logger.info("Parseo del fichero realizado en: {}", getLogTiempo(time1));
		time1 = new java.util.Date();

		sQLServerRepository.crearTemporalTest1();
		sQLServerRepository.insertarDatosXMLCompleto(contenidoFichero);

		logger.info("Inserccion de datos en el modelo de datos realizado en: {}", getLogTiempo(time1));
		time1 = new java.util.Date();

		final List<VentaDto> ventas1 = sQLServerRepository.getDatosXMLCompleto();
		final List<VentaDto> ventas2 = sQLServerRepository.getDatosJoinXMLCompleto();
	    logger.info("Numero resultados ventas1: {}", Integer.valueOf(ventas1.size()));
		logger.info("Numero resultados ventas2: {}", Integer.valueOf(ventas2.size()));
		logger.info("Resto del proceso realizado en: {}", getLogTiempo(time1));
	}

	@Override
	public void pruebaXMLSQLServerFicheroPartes(final String path) throws IOException, XMLStreamException, ParseException {
		sQLServerRepository.crearTemporalTest2();

		java.util.Date time1 = new java.util.Date();
		final File ficheroXML = new File(path);
		final FileInputStream fis = FileUtils.openInputStream(ficheroXML);
		final XMLInputFactory factory = XMLInputFactory.newInstance();
		final XMLEventReader eventReader = factory.createXMLEventReader(fis);
		final SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		final List<VentaDto> ventas = new ArrayList<>();
		VentaDto venta = null;
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();
			if (event.isStartElement()) {
				final StartElement startElement = event.asStartElement();

				if (startElement.getName().getLocalPart().equals("ventaTotalizado")) {
					venta = new VentaDto();
				} else if (startElement.getName().getLocalPart().equals("fecha")) {
					event = eventReader.nextEvent();
					venta.setFecha(formatoFecha.parse(event.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equals("pais")) {
					event = eventReader.nextEvent();
					venta.setIdPais(Integer.valueOf(event.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equals("cadena")) {
					event = eventReader.nextEvent();
					venta.setIdCadena(Integer.valueOf(event.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equals("tienda")) {
					event = eventReader.nextEvent();
					venta.setIdTienda(Integer.valueOf(event.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equals("importeSinIVA")) {
					event = eventReader.nextEvent();
					venta.setImporteSinIva(Float.valueOf(event.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equals("importeConIVA")) {
					event = eventReader.nextEvent();
					venta.setImporteConIva(Float.valueOf(event.asCharacters().getData()));
				}
			}

			if (event.isEndElement()) {
				final EndElement endElement = event.asEndElement();
				if (endElement.getName().getLocalPart().equals("ventaTotalizado")) {
					ventas.add(venta);
				}
			}

			if (ventas.size() == 50000) {
				// Procesado de 100 elementos collection
				sQLServerRepository.insertarDatosXMLTrozos(ventas);
				ventas.clear();
			}
		}

		if (ventas.size() < 50000) {
			sQLServerRepository.insertarDatosXMLTrozos(ventas);
			ventas.clear();
		}

		logger.info("Parse e inserccion de datos en el modelo de datos realizado en: {}", getLogTiempo(time1));
		time1 = new java.util.Date();

		final List<VentaDto> ventas1 = sQLServerRepository.getDatosXMLTrozos();
		final List<VentaDto> ventas2 = sQLServerRepository.getDatosJoinXMLTrozos();
		logger.info("Numero resultados ventas1: {}", Integer.valueOf(ventas1.size()));
		logger.info("Numero resultados ventas2: {}", Integer.valueOf(ventas2.size()));
		logger.info("Resto del proceso realizado en: {}", getLogTiempo(time1));
	}

	@Override
	public void pruebaXMLDB2FicheroCompleto(final String path) throws IOException {
		java.util.Date time1 = new java.util.Date();

		final File ficheroXML = new File(path);
		final String contenidoFichero = FileUtils.readFileToString(ficheroXML, "UTF-8");

		logger.info("Parseo del fichero realizado en: {}", getLogTiempo(time1));
		time1 = new java.util.Date();

		dB2Repository.crearTemporalTest1();
		dB2Repository.insertarDatosXMLCompleto(contenidoFichero);

		logger.info("Inserccion de datos en el modelo de datos realizado en: {}", getLogTiempo(time1));
		time1 = new java.util.Date();

		final List<VentaDto> ventas1 = dB2Repository.getDatosXMLCompleto();
		final List<VentaDto> ventas2 = dB2Repository.getDatosJoinXMLCompleto();
		logger.info("Numero resultados ventas1: {}", Integer.valueOf(ventas1.size()));
		logger.info("Numero resultados ventas2: {}", Integer.valueOf(ventas2.size()));

		logger.info("Resto del proceso realizado en: {}", getLogTiempo(time1));
	}

	private String getLogTiempo(final java.util.Date fechaInicio) {
		final Long milliseconds = (((new java.util.Date()).getTime()) - fechaInicio.getTime());
		return milliseconds + " ms";
	}

	@Override
	public void pruebaXMLDB2FicheroPartes(final String path) throws IOException, XMLStreamException, ParseException {
		dB2Repository.crearTemporalTest2();

		java.util.Date time1 = new java.util.Date();
		final File ficheroXML = new File(path);
		final FileInputStream fis = FileUtils.openInputStream(ficheroXML);
		final XMLInputFactory factory = XMLInputFactory.newInstance();
		final XMLEventReader eventReader = factory.createXMLEventReader(fis);
		final SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		final List<VentaDto> ventas = new ArrayList<>();
		VentaDto venta = null;
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();
			if (event.isStartElement()) {
				final StartElement startElement = event.asStartElement();

				if (startElement.getName().getLocalPart().equals("ventaTotalizado")) {
					venta = new VentaDto();
				} else if (startElement.getName().getLocalPart().equals("fecha")) {
					event = eventReader.nextEvent();
					venta.setFecha(formatoFecha.parse(event.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equals("pais")) {
					event = eventReader.nextEvent();
					venta.setIdPais(Integer.valueOf(event.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equals("cadena")) {
					event = eventReader.nextEvent();
					venta.setIdCadena(Integer.valueOf(event.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equals("tienda")) {
					event = eventReader.nextEvent();
					venta.setIdTienda(Integer.valueOf(event.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equals("importeSinIVA")) {
					event = eventReader.nextEvent();
					venta.setImporteSinIva(Float.valueOf(event.asCharacters().getData()));
				} else if (startElement.getName().getLocalPart().equals("importeConIVA")) {
					event = eventReader.nextEvent();
					venta.setImporteConIva(Float.valueOf(event.asCharacters().getData()));
				}
			}

			if (event.isEndElement()) {
				final EndElement endElement = event.asEndElement();
				if (endElement.getName().getLocalPart().equals("ventaTotalizado")) {
					ventas.add(venta);
				}
			}

			if (ventas.size() == 50000) {
				// Procesado de 100 elementos collection
				dB2Repository.insertarDatosXMLTrozos(ventas);
				ventas.clear();
			}
		}

		if (ventas.size() < 50000) {
			dB2Repository.insertarDatosXMLTrozos(ventas);
			ventas.clear();
		}

		logger.info("Parse e inserccion de datos en el modelo de datos realizado en: {}", getLogTiempo(time1));
		time1 = new java.util.Date();

		final List<VentaDto> ventas1 = dB2Repository.getDatosXMLTrozos();
		final List<VentaDto> ventas2 = dB2Repository.getDatosJoinXMLTrozos();
		logger.info("Numero resultados ventas1: {}", Integer.valueOf(ventas1.size()));
		logger.info("Numero resultados ventas2: {}", Integer.valueOf(ventas2.size()));
		logger.info("Resto del proceso realizado en: {}", getLogTiempo(time1));
	}

	@Override
	public void pruebaJSONSQLServerFicheroCompleto(String path) throws IOException {
		java.util.Date time1 = new java.util.Date();

		final File ficheroXML = new File(path);
		final String contenidoFichero = FileUtils.readFileToString(ficheroXML, "UTF-8");

		logger.info("Parseo del fichero realizado en: {}", getLogTiempo(time1));
		time1 = new java.util.Date();

		sQLServerRepository.crearTemporalTest1();
		sQLServerRepository.insertarDatosJSONCompleto(contenidoFichero);

		logger.info("Inserccion de datos en el modelo de datos realizado en: {}", getLogTiempo(time1));
		time1 = new java.util.Date();

		final List<VentaDto> ventas1 = sQLServerRepository.getDatosJSONCompleto();
		final List<VentaDto> ventas2 = sQLServerRepository.getDatosJoinJSONCompleto();
		logger.info("Numero resultados ventas1: {}", Integer.valueOf(ventas1.size()));
		logger.info("Numero resultados ventas2: {}", Integer.valueOf(ventas2.size()));

		logger.info("Resto del proceso realizado en: {}", getLogTiempo(time1));
	}

	@Override
	public void pruebaJSONDB2FicheroCompleto(String path) throws IOException {
		java.util.Date time1 = new java.util.Date();

		final File ficheroXML = new File(path);
		final String contenidoFichero = FileUtils.readFileToString(ficheroXML, "UTF-8");

		logger.info("Parseo del fichero realizado en: {}", getLogTiempo(time1));
		time1 = new java.util.Date();

		dB2Repository.crearTemporalTest1();
		dB2Repository.insertarDatosJSONCompleto(contenidoFichero);

		logger.info("Inserccion de datos en el modelo de datos realizado en: {}", getLogTiempo(time1));
		time1 = new java.util.Date();

		final List<VentaDto> ventas1 = dB2Repository.getDatosJSONCompleto();
		final List<VentaDto> ventas2 = dB2Repository.getDatosJoinJSONCompleto();
		logger.info("Numero resultados ventas1: {}", Integer.valueOf(ventas1.size()));
		logger.info("Numero resultados ventas2: {}", Integer.valueOf(ventas2.size()));

		logger.info("Resto del proceso realizado en: {}", getLogTiempo(time1));
	}

	@Override
	public void pruebaJSONSQLServerFicheroPartes(String path) throws IOException, XMLStreamException, ParseException {
		// Completar
		
	}

	@Override
	public void pruebaJSONDB2FicheroPartes(String path) throws IOException, XMLStreamException, ParseException {
		// Completar
		
	}
}
