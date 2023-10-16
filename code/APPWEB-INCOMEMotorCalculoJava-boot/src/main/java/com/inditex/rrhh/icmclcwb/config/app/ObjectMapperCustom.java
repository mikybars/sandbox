package com.inditex.rrhh.icmclcwb.config.app;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class ObjectMapperCustom extends ObjectMapper {

  private static final long serialVersionUID = -8640529927698069606L;

  public ObjectMapperCustom() {
    super();
    this.registerModule(new ParameterNamesModule());
    this.registerModule(new Jdk8Module());
    this.registerModule(new JavaTimeModule());
    this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
  }

  @Override
  public final ObjectMapper registerModule(Module module) {
    return super.registerModule(module);
  }

  @Override
  public final ObjectMapper configure(SerializationFeature f, boolean state) {
    return super.configure(f, state);
  }

}
