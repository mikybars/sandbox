package com.inditex.rrhh.icmclcwb.api.app;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import com.inditex.rrhh.icmclcwb.api.app.dto.TipoAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoConstraintValidator;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoAmbitoOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.dto.TipoAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoEmpresaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoLocalizacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoOrigenDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoAmbitoPersonaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import javax.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
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

  @BeforeEach
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
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.SOCIEDAD.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoSociedadEmpresaNotEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.SOCIEDAD.getId());
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testRunTrabajoSociedad() {
    final RunTrabajoDto runTrabajo = new RunTrabajoDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.SOCIEDAD.getId());
    trabajo.setTipoAmbito(tipoAmbito);
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
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.ORIGEN.getId());
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList());
    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoOrigenEmpresaNotEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.ORIGEN.getId());
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testRunTrabajoOrigen() {
    final RunTrabajoDto runTrabajo = new RunTrabajoDto();
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.ORIGEN.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    runTrabajo.setTrabajo(trabajo);
    assertThat(this.trabajoValidator.isValid(runTrabajo, this.constraintValidatorContext), is(true));
  }

  @Test
  public void testTrabajoEmpresa() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.EMPRESA.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(true));
  }

  @Test
  public void testTrabajoEmpresaOrigenEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.EMPRESA.getId());
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList());
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoEmpresaOrigenEmpresaEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.EMPRESA.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList());
    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoEmpresaLocalizacionNotEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.EMPRESA.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    final TrabajoAmbitoLocalizacionDTO trabajoAmbitoLocalizacion = new TrabajoAmbitoLocalizacionDTO();
    trabajoAmbitoLocalizacion.stdIdWorkLocat(STD_ID_WORK_LOCAT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    trabajo.setLocalizacion(
        Arrays.asList(trabajoAmbitoLocalizacion));
    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoEmpresaPersonaNotEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.EMPRESA.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    final TrabajoAmbitoPersonaDTO trabajoAmbitoPersona = new TrabajoAmbitoPersonaDTO();
    trabajoAmbitoPersona.stdIdLegEnt(CCL_ID_PERSON);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    trabajo.setPersona(Arrays.asList(trabajoAmbitoPersona));
    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoLocalizacion() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.LOCALIZACION.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    final TrabajoAmbitoLocalizacionDTO trabajoAmbitoLocalizacion = new TrabajoAmbitoLocalizacionDTO();
    trabajoAmbitoLocalizacion.stdIdWorkLocat(STD_ID_WORK_LOCAT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    trabajo.setLocalizacion(
        Arrays.asList(trabajoAmbitoLocalizacion));

    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(true));
  }

  @Test
  public void testTrabajoLocalizacionOrigenEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.LOCALIZACION.getId());
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    final TrabajoAmbitoLocalizacionDTO trabajoAmbitoLocalizacion = new TrabajoAmbitoLocalizacionDTO();
    trabajoAmbitoLocalizacion.stdIdWorkLocat(STD_ID_WORK_LOCAT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList());
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    trabajo.setLocalizacion(
        Arrays.asList(trabajoAmbitoLocalizacion));

    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoLocalizacionEmpresaEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.LOCALIZACION.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    final TrabajoAmbitoLocalizacionDTO trabajoAmbitoLocalizacion = new TrabajoAmbitoLocalizacionDTO();
    trabajoAmbitoLocalizacion.stdIdWorkLocat(STD_ID_WORK_LOCAT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList());
    trabajo.setLocalizacion(
        Arrays.asList(trabajoAmbitoLocalizacion));

    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoLocalizacionLocalizacionEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.LOCALIZACION.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    trabajo.setLocalizacion(Arrays.asList());

    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoLocalizacionExistsPersona() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.LOCALIZACION.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    final TrabajoAmbitoLocalizacionDTO trabajoAmbitoLocalizacion = new TrabajoAmbitoLocalizacionDTO();
    trabajoAmbitoLocalizacion.stdIdWorkLocat(STD_ID_WORK_LOCAT);
    final TrabajoAmbitoPersonaDTO trabajoAmbitoPersona = new TrabajoAmbitoPersonaDTO();
    trabajoAmbitoPersona.stdIdLegEnt(CCL_ID_PERSON);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    trabajo.setLocalizacion(
        Arrays.asList(trabajoAmbitoLocalizacion));
    trabajo.setPersona(Arrays.asList(trabajoAmbitoPersona));

    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoPersona() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.PERSONA.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    final TrabajoAmbitoPersonaDTO trabajoAmbitoPersona = new TrabajoAmbitoPersonaDTO();
    trabajoAmbitoPersona.stdIdLegEnt(CCL_ID_PERSON);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    trabajo.setPersona(Arrays.asList(trabajoAmbitoPersona));

    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(true));
  }

  @Test
  public void testTrabajoPersonaOrigenEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.LOCALIZACION.getId());
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    final TrabajoAmbitoPersonaDTO trabajoAmbitoPersona = new TrabajoAmbitoPersonaDTO();
    trabajoAmbitoPersona.stdIdLegEnt(CCL_ID_PERSON);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList());
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    trabajo.setPersona(Arrays.asList(trabajoAmbitoPersona));

    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoPersonaEmpresaEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.LOCALIZACION.getId());
    final TrabajoAmbitoPersonaDTO trabajoAmbitoPersona = new TrabajoAmbitoPersonaDTO();
    trabajoAmbitoPersona.stdIdLegEnt(CCL_ID_PERSON);
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList());
    trabajo.setPersona(Arrays.asList(trabajoAmbitoPersona));

    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoPersonaPersonaEmpty() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.LOCALIZACION.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    trabajo.setPersona(Arrays.asList());

    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

  @Test
  public void testTrabajoPersonaContainsLocalizacion() {
    final TrabajoDTO trabajo = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.LOCALIZACION.getId());
    final TrabajoAmbitoOrigenDTO trabajoAmbitoOrigen = new TrabajoAmbitoOrigenDTO();
    trabajoAmbitoOrigen.setCclIdOrigen(CCL_ID_ORIGEN);
    final TrabajoAmbitoEmpresaDTO trabajoAmbitoEmpresa = new TrabajoAmbitoEmpresaDTO();
    trabajoAmbitoEmpresa.stdIdLegEnt(STD_ID_LEG_ENT);
    final TrabajoAmbitoPersonaDTO trabajoAmbitoPersona = new TrabajoAmbitoPersonaDTO();
    trabajoAmbitoPersona.stdIdLegEnt(CCL_ID_PERSON);
    final TrabajoAmbitoLocalizacionDTO trabajoAmbitoLocalizacion = new TrabajoAmbitoLocalizacionDTO();
    trabajoAmbitoLocalizacion.stdIdWorkLocat(STD_ID_WORK_LOCAT);
    trabajo.setTipoAmbito(tipoAmbito);
    trabajo.setIdOrganization(ID_ORGANIZATION);
    trabajo.setOrigen(Arrays.asList(trabajoAmbitoOrigen));
    trabajo.setEmpresa(Arrays.asList(trabajoAmbitoEmpresa));
    trabajo.setPersona(Arrays.asList(trabajoAmbitoPersona));
    trabajo.setLocalizacion(
        Arrays.asList(trabajoAmbitoLocalizacion));

    assertThat(this.trabajoValidator.isValid(trabajo, this.constraintValidatorContext), is(false));
  }

}
