package com.inditex.rrhh.icmclcwb.api.app;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Arrays;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoConstraintValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

@RunWith(MockitoJUnitRunner.class)
public class TrabajoConstraintValidatorTest {

    private static final String ID_ORGANIZATION = "AT";
    private static final String CCL_ID_ORIGEN = "38";

    @Mock
    private Logger log;
    
    private ConstraintValidatorContext constraintValidatorContext;
    private TrabajoConstraintValidator trabajoValidator;
    
    @Before
    public void setUp() {
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
        trabajoValidator = new TrabajoConstraintValidator();
    }

    @Test
    public void testTrabajoSociedad() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.SOCIEDAD.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(true));
    }
    
    @Test
    public void testRunTrabajoSociedad() {
        RunTrabajoDto runTrabajo = new RunTrabajoDto();
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.SOCIEDAD.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        runTrabajo.setTrabajo(trabajo);
        assertThat(trabajoValidator.isValid(runTrabajo, constraintValidatorContext), is(true));
    }
    
    @Test
    public void testTrabajoOrigen() {
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.ORIGEN.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        assertThat(trabajoValidator.isValid(trabajo, constraintValidatorContext), is(true));
    }
    
    @Test
    public void testRunTrabajoOrigen() {
        RunTrabajoDto runTrabajo = new RunTrabajoDto();
        TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.ORIGEN.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        runTrabajo.setTrabajo(trabajo);
        assertThat(trabajoValidator.isValid(runTrabajo, constraintValidatorContext), is(true));
    }
    
}
