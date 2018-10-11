package com.inditex.rrhh.icmclcwb.api.app.service;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.stream.XMLStreamException;

public interface IncomeService {
    void pruebaXMLSQLServerFicheroCompleto(final String path) throws IOException;
    
    void pruebaXMLDB2FicheroCompleto(final String path) throws IOException;
    
    void pruebaXMLSQLServerFicheroPartes(final String path) throws IOException, XMLStreamException, ParseException;

	void pruebaXMLDB2FicheroPartes(final String path) throws IOException, XMLStreamException, ParseException;

	void pruebaJSONSQLServerFicheroCompleto(final String path) throws IOException;

	void pruebaJSONDB2FicheroCompleto(final String path) throws IOException;

	void pruebaJSONSQLServerFicheroPartes(String path) throws IOException, XMLStreamException, ParseException;

	void pruebaJSONDB2FicheroPartes(String path) throws IOException, XMLStreamException, ParseException;
    
}
