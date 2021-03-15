/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.inditex.rrhh.icmclcwb.Application;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author <a href="mailto:">javierev</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
@ActiveProfiles({ "standalone", "test" })
@EnableAutoConfiguration
public class TareaCalculoAjusteBajaItRepositoryCustomImplTest {

    @Autowired
    private TareaCalculoAjusteBajaItRepositoryCustom tareaCalculoAjusteBajaItRepositoryCustom;

    @Autowired
    private TareaService tareaService;

    @Test
    @Ignore
    public void test() {

        final AlgoritmoAjusteDto ajuste = new AlgoritmoAjusteDto();
        ajuste.setId(3);
        final TareaDto tarea = this.tareaService.find(45685L);

        final List<IdPersonaLocalDto> personas = new ArrayList<>();
        personas.add(IdPersonaLocalDto.builder().idPersonaLocal("1664").stdOrHrPeriod("0").build());
        // personas.add(IdPersonaLocalDto.builder().idPersonaLocal("2823").stdOrHrPeriod("0").build());
        // personas.add(IdPersonaLocalDto.builder().idPersonaLocal("849").stdOrHrPeriod("0").build());
        // personas.add(IdPersonaLocalDto.builder().idPersonaLocal("1044").stdOrHrPeriod("0").build());
        // personas.add(IdPersonaLocalDto.builder().idPersonaLocal("1100").stdOrHrPeriod("0").build());
        // personas.add(IdPersonaLocalDto.builder().idPersonaLocal("1190").stdOrHrPeriod("0").build());
        // personas.add(IdPersonaLocalDto.builder().idPersonaLocal("1255").stdOrHrPeriod("0").build());
        // personas.add(IdPersonaLocalDto.builder().idPersonaLocal("1591").stdOrHrPeriod("0").build());
        // personas.add(IdPersonaLocalDto.builder().idPersonaLocal("1666").stdOrHrPeriod("0").build());
        // personas.add(IdPersonaLocalDto.builder().idPersonaLocal("1754").stdOrHrPeriod("0").build());

        this.tareaCalculoAjusteBajaItRepositoryCustom.ajustar(ajuste, tarea, personas);

    }

}
