package com.inditex.rrhh.icmclcwb.config.app;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * The Class ObjectMapperCustom.
 */
public class ObjectMapperCustom extends ObjectMapper {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8640529927698069606L;

    /**
     * Instantiates a new object mapper custom.
     */
    public ObjectMapperCustom() {
        super();
        this.registerModule(new ParameterNamesModule());
        this.registerModule(new Jdk8Module());
        this.registerModule(new JavaTimeModule());
        this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    /**
     * Register module.
     *
     * @param module the module
     * @return the object mapper
     */
    @Override
    public final ObjectMapper registerModule(Module module) {
        return super.registerModule(module);
    }

    /**
     * Configure.
     *
     * @param f the f
     * @param state the state
     * @return the object mapper
     */
    @Override
    public final ObjectMapper configure(SerializationFeature f, boolean state) {
        return super.configure(f, state);
    }

}
