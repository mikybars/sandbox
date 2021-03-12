package com.inditex.rrhh.icmclcwb.api.app;

import java.util.Arrays;

import javax.validation.ConstraintValidatorContext;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoConstraintValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrabajoConstraintValidatorTest {

    private static final String CCL_ID_PERSON = "4724";

    private static final String STD_ID_WORK_LOCAT = "T3113";

    private static final String STD_ID_LEG_ENT = "95";

    private static final String ID_ORGANIZATION = "AT";

    private static final String CCL_ID_ORIGEN = "38";

    @Mock
    private Logger log;

    private ConstraintValidatorContext constraintValidatorContext;

    private ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder = mock(
            ConstraintValidatorContext.ConstraintViolationBuilder.class);

    private TrabajoConstraintValidator trabajoValidator;

    @Before
    public void setUp() {
        this.constraintValidatorContext = mock(ConstraintValidatorContext.class);
        this.trabajoValidator = new TrabajoConstraintValidator();
        this.constraintViolationBuilder = mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);
        when(this.constraintValidatorContext.buildConstraintViolationWithTemplate(Mockito.anyString()))
            .thenReturn(this.constraintViolationBuilder);
    }

    @Test
    public void testTrabajoSociedad() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.SOCIEDAD.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(true));
    }

    @Test
    public void testTrabajoSociedadOrigenNotEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.SOCIEDAD.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoSociedadEmpresaNotEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.SOCIEDAD.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testRunTrabajoSociedad() {
        final RunTrabajoDto runTrabajo = new RunTrabajoDto();
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.SOCIEDAD.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        runTrabajo.setTrabajo(trabajo);
        assertThat(this.trabajoValidator.isValid(runTrabajo, this.constraintValidatorContext), is(true));
    }

    @Test
    public void testTrabajoOrigen() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.ORIGEN.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(true));
    }

    @Test
    public void testTrabajoOrigenOrigenEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.ORIGEN.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList());
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoOrigenEmpresaNotEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.ORIGEN.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testRunTrabajoOrigen() {
        final RunTrabajoDto runTrabajo = new RunTrabajoDto();
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.ORIGEN.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        runTrabajo.setTrabajo(trabajo);
        assertThat(this.trabajoValidator.isValid(runTrabajo, this.constraintValidatorContext), is(true));
    }

    @Test
    public void testTrabajoEmpresa() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.EMPRESA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(true));
    }

    @Test
    public void testTrabajoEmpresaOrigenEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.EMPRESA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList());
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoEmpresaOrigenEmpresaEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.EMPRESA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList());
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoEmpresaLocalizacionNotEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.EMPRESA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setLocalizacion(
                Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoEmpresaPersonaNotEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.EMPRESA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));
        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }


    @Test
    public void testTrabajoLocalizacion() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.LOCALIZACION.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setLocalizacion(
                Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));

        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(true));
    }

    @Test
    public void testTrabajoLocalizacionOrigenEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.LOCALIZACION.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList());
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setLocalizacion(
                Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));

        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoLocalizacionEmpresaEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.LOCALIZACION.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList());
        trabajo.setLocalizacion(
                Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));

        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoLocalizacionLocalizacionEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.LOCALIZACION.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setLocalizacion(Arrays.asList());

        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoLocalizacionExistsPersona() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.LOCALIZACION.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setLocalizacion(
                Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));

        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoPersona() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.PERSONA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));

        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(true));
    }

    @Test
    public void testTrabajoPersonaOrigenEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.PERSONA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList());
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));

        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoPersonaEmpresaEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.PERSONA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList());
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));

        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoPersonaPersonaEmpty() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.PERSONA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setPersona(Arrays.asList());

        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

    @Test
    public void testTrabajoPersonaContainsLocalizacion() {
        final TrabajoDto trabajo = new TrabajoDto();
        trabajo.setTipoAmbito(TipoAmbitoDto.builder().id(TipoAmbitoEnum.PERSONA.getId()).build());
        trabajo.setIdOrganization(ID_ORGANIZATION);
        trabajo.setOrigen(Arrays.asList(TrabajoAmbitoOrigenDto.builder().cclIdOrigen(CCL_ID_ORIGEN).build()));
        trabajo.setEmpresa(Arrays.asList(TrabajoAmbitoEmpresaDto.builder().stdIdLegEnt(STD_ID_LEG_ENT).build()));
        trabajo.setPersona(Arrays.asList(TrabajoAmbitoPersonaDto.builder().cclIdPerson(CCL_ID_PERSON).build()));
        trabajo.setLocalizacion(
                Arrays.asList(TrabajoAmbitoLocalizacionDto.builder().stdIdWorkLocat(STD_ID_WORK_LOCAT).build()));

        assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
    }

}
