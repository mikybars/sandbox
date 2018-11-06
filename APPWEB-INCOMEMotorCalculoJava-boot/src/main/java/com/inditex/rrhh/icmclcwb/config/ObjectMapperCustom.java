package com.inditex.rrhh.icmclcwb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class ObjectMapperCustom extends ObjectMapper {
	
	private static final long serialVersionUID = -8640529927698069606L;

	public ObjectMapperCustom() {
		super();
		registerModule(new ParameterNamesModule());
		registerModule(new Jdk8Module());
		JavaTimeModule timeModule = new JavaTimeModule();
//		timeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE));
//		timeModule.addSerializer(LocalDateTime.class,
//				new LocalDateTimeSerializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//		timeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_LOCAL_DATE));
//		timeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		registerModule(timeModule);
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}



}
