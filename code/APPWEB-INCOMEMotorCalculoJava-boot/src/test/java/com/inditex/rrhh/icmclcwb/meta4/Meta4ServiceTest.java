package com.inditex.rrhh.icmclcwb.meta4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4TestConstants;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetagruponlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetausenciasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcadenaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcatalogoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetcoefjornadaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfchdiasminimosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfchtpventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfiguracionOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfpreciohoraOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfprodventaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetconfventaonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetdesplazrealOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadosdesplazOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempleadospresenciaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetempresasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetestructuraspolOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetfestivosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetflagcalculaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetorigenesOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetperiodosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresenciamanualOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresupuestosrangoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetpresupuestoswlocOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetsistdestinoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasincomeOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GettiendasonlineOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.GetventacongeladaOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcadenaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcatalogoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalcatalogoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchdiasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfchventaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconforigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalconfpreciohoraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaldesplazrealBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaldesplazrealRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosdesplazBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadosdesplazRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadospresenciaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalempleadospresenciaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalestructuraRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalflagcalculaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalflagcalculaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalorigenRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalperiodoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresenciamanualBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresenciamanualRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestosrangoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalpresupuestoswlocRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalprocesoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsistdestinoBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsistdestinoRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalsociedadRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcaltiendasRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalventacongeladaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParamcalventacongeladaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrosentradaRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionBlock;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmParametrospaginacionRecord;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SaveprocesoOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchempleadosOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.SearchtiendasOutput;
import com.inditex.rrhh.icmclcwb.model.meta4.pool.Meta4ClientPool;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@Disabled("No están funcionando los servicios Meta4 en DES")
public class Meta4ServiceTest {

  @Autowired
  @Qualifier("meta4ClientPool")
  private Meta4ClientPool meta4ClientPool;

  @Test
  public void getOrigenes() {
    final IcmParamcalsociedadRecord record = new IcmParamcalsociedadRecord();
    record.setIdsociedad(Meta4TestConstants.ID_SOCIEDAD);
    final IcmParamcalsociedadBlock param1 = new IcmParamcalsociedadBlock();
    param1.getIcmParamcalsociedadRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetorigenesOutput getorigenesOutput = this.meta4ClientPool.getorigenes(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getorigenesOutput.getReturn()));
  }

  @Test
  public void getEmpleadosDesplaz() {
    final IcmParamcalempleadosdesplazRecord record = new IcmParamcalempleadosdesplazRecord();
    record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    record.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    final IcmParamcalempleadosdesplazBlock param1 = new IcmParamcalempleadosdesplazBlock();
    param1.getIcmParamcalempleadosdesplazRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetempleadosdesplazOutput getempleadosdesplazOutput = this.meta4ClientPool.getempleadosdesplaz(param2,
        param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getempleadosdesplazOutput.getReturn()));
  }

  @Test
  public void getEmpresas() {
    final IcmParamcalorigenRecord record = new IcmParamcalorigenRecord();
    record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    final IcmParamcalorigenBlock param1 = new IcmParamcalorigenBlock();
    param1.getIcmParamcalorigenRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetempresasOutput getempresasOutput = this.meta4ClientPool.getempresas(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getempresasOutput.getReturn()));
  }

  @Test
  public void getCadena() {
    final IcmParamcalcadenaRecord record = new IcmParamcalcadenaRecord();
    final IcmParamcalcadenaBlock param1 = new IcmParamcalcadenaBlock();
    record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    record.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParamcalcadenaRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetcadenaOutput getcadenaOutput = this.meta4ClientPool.getcadena(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getcadenaOutput.getReturn()));
  }

  @Test
  public void getConfProdVenta() {
    final IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    final IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParametrosentradaRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetconfprodventaOutput getconfprodventaOutput = this.meta4ClientPool.getconfprodventa(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getconfprodventaOutput.getReturn()));
  }

  @Test
  public void getConfVentaOnline() {
    final IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    final IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParametrosentradaRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetconfventaonlineOutput getconfventaonlineoutput = this.meta4ClientPool.getconfventaonline(param1,
        param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getconfventaonlineoutput.getReturn()));
  }

  @Test
  public void getAgrupOnline() {
    final IcmParamcalorigenRecord record = new IcmParamcalorigenRecord();
    record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    final IcmParamcalorigenBlock param1 = new IcmParamcalorigenBlock();
    param1.getIcmParamcalorigenRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetagruponlineOutput getagrupOnlineOutput = this.meta4ClientPool.getagruponline(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getagrupOnlineOutput.getReturn()));
  }

  @Test
  public void getCoefJornada() {
    final IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    final IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
    param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParametrosentradaRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetcoefjornadaOutput getcoefjornadaOutput = this.meta4ClientPool.getcoefjornada(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getcoefjornadaOutput.getReturn()));
  }

  @Test
  public void getFlagCalcula() {
    final IcmParamcalflagcalculaRecord record = new IcmParamcalflagcalculaRecord();
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    record.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    record.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    final IcmParamcalflagcalculaBlock param1 = new IcmParamcalflagcalculaBlock();
    param1.getIcmParamcalflagcalculaRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetflagcalculaOutput getflagcalculaOutput = this.meta4ClientPool.getflagcalcula(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getflagcalculaOutput.getReturn()));
  }

  @Test
  public void getFestivos() {
    final IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    final IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
    param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParametrosentradaRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetfestivosOutput getfestivosOutput = this.meta4ClientPool.getfestivos(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getfestivosOutput.getReturn()));
  }

  @Test
  public void getPeriodos() {
    final IcmParamcalperiodoRecord record = new IcmParamcalperiodoRecord();
    record.setAbierto(Meta4Constants.TRUE);
    record.setActivo(Meta4Constants.TRUE);
    record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    record.setVigente(Meta4Constants.TRUE);
    record.setIdsociedad(Meta4TestConstants.ID_SOCIEDAD);
    final IcmParamcalperiodoBlock param1 = new IcmParamcalperiodoBlock();
    param1.getIcmParamcalperiodoRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetperiodosOutput getperiodosOutput = this.meta4ClientPool.getperiodos(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getperiodosOutput.getReturn()));
  }

  @Test
  public void getPresenciaManual() {
    final IcmParamcalpresenciamanualRecord record = new IcmParamcalpresenciamanualRecord();
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    record.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    record.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    final IcmParamcalpresenciamanualBlock param1 = new IcmParamcalpresenciamanualBlock();
    param1.getIcmParamcalpresenciamanualRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetpresenciamanualOutput getpresenciamanualOutput = this.meta4ClientPool.getpresenciamanual(param1,
        param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getpresenciamanualOutput.getReturn()));
  }

  @Test
  public void getEmpleadosPresencia() {
    final IcmParamcalempleadospresenciaRecord record = new IcmParamcalempleadospresenciaRecord();
    final IcmParamcalempleadospresenciaBlock param1 = new IcmParamcalempleadospresenciaBlock();
    record.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    record.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    param1.getIcmParamcalempleadospresenciaRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetempleadospresenciaOutput getempleadospresenciaOutput = this.meta4ClientPool
        .getempleadospresencia(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getempleadospresenciaOutput.getReturn()));
  }

  @Test
  public void searchTiendas() {
    final IcmParamcaltiendasBlock param1 = new IcmParamcaltiendasBlock();
    final IcmParamcaltiendasRecord record = new IcmParamcaltiendasRecord();
    record.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    record.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    param1.getIcmParamcaltiendasRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
    param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
    param2.setIdbusqueda(StringUtils.EMPTY);
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final SearchtiendasOutput searchTiendasOutput = this.meta4ClientPool.searchtiendas(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(searchTiendasOutput.getReturn()));
  }

  @Test
  public void getTiendas() {
    final IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    final IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
    param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParametrosentradaRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
    param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
    param2.setIdbusqueda(StringUtils.EMPTY);
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GettiendasincomeOutput getTiendasIncome = this.meta4ClientPool.gettiendasincome(param2, param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getTiendasIncome.getReturn()));
  }

  @Test
  public void getTiendasOnline() {
    final IcmParametrosentradaRecord record = new IcmParametrosentradaRecord();
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    final IcmParametrosentradaBlock param1 = new IcmParametrosentradaBlock();
    param1.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParametrosentradaRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
    param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
    param2.setIdbusqueda(StringUtils.EMPTY);
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GettiendasonlineOutput getTiendasOnlineIncome = this.meta4ClientPool.gettiendasonline(param2, param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getTiendasOnlineIncome.getReturn()));
  }

  @Test
  public void searchEmpleados() {
    final IcmParamcalempleadoRecord record = new IcmParamcalempleadoRecord();
    record.setIdempleado(Meta4TestConstants.ID_PERSONA);
    record.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    final IcmParamcalempleadoBlock param1 = new IcmParamcalempleadoBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParamcalempleadoRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
    param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
    param2.setIdbusqueda(StringUtils.EMPTY);
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final SearchempleadosOutput searchEmpleadosOutput = this.meta4ClientPool.searchempleados(param2, param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(searchEmpleadosOutput.getReturn()));
  }

  @Test
  public void getAusencias() {
    final IcmParamcalempleadoRecord record = new IcmParamcalempleadoRecord();
    record.setIdempleado(Meta4TestConstants.ID_PERSONA);
    record.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    final IcmParamcalempleadoBlock param1 = new IcmParamcalempleadoBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParamcalempleadoRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
    param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
    param2.setIdbusqueda(StringUtils.EMPTY);
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetausenciasOutput getAusenciasOutput = this.meta4ClientPool.getausencias(param2, param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getAusenciasOutput.getReturn()));
  }

  @Test
  public void getConfChDiasMinimos() {
    final IcmParamcalconfchdiasRecord record = new IcmParamcalconfchdiasRecord();
    final IcmParamcalconfchdiasBlock param1 = new IcmParamcalconfchdiasBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParamcalconfchdiasRecordSet().add(record);
    final GetconfchdiasminimosOutput getAusenciasOutput = this.meta4ClientPool.getconfchdiasminimos(param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getAusenciasOutput.getReturn()));
  }

  @Test
  public void getPresupuestosWloc() {
    final IcmParamcalpresupuestoswlocRecord record = new IcmParamcalpresupuestoswlocRecord();
    final IcmParamcalpresupuestoswlocBlock param1 = new IcmParamcalpresupuestoswlocBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParamcalpresupuestoswlocRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
    param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
    param2.setIdbusqueda(StringUtils.EMPTY);
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetpresupuestoswlocOutput getpresupuestoswlocOutput = this.meta4ClientPool.getpresupuestoswloc(param1,
        param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getpresupuestoswlocOutput.getReturn()));
  }

  @Test
  public void getConfPrecioHora() {
    final IcmParamcalconfpreciohoraRecord record = new IcmParamcalconfpreciohoraRecord();
    final IcmParamcalconfpreciohoraBlock param1 = new IcmParamcalconfpreciohoraBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParamcalconfpreciohoraRecordSet().add(record);
    final GetconfpreciohoraOutput getconfpreciohoraOutput = this.meta4ClientPool.getconfpreciohora(param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getconfpreciohoraOutput.getReturn()));
  }

  @Test
  public void getConfChTpVenta() {
    final IcmParamcalconfchventaRecord record = new IcmParamcalconfchventaRecord();
    final IcmParamcalconfchventaBlock param1 = new IcmParamcalconfchventaBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParamcalconfchventaRecordSet().add(record);
    final GetconfchtpventaOutput getconfchtpventaOutput = this.meta4ClientPool.getconfchtpventa(param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getconfchtpventaOutput.getReturn()));
  }

  @Test
  public void getPresupuestosRango() {
    final IcmParamcalpresupuestosrangoRecord record = new IcmParamcalpresupuestosrangoRecord();
    final IcmParamcalpresupuestosrangoBlock param1 = new IcmParamcalpresupuestosrangoBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParamcalpresupuestosrangoRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
    param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
    param2.setIdbusqueda(StringUtils.EMPTY);
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetpresupuestosrangoOutput getpresupuestosrangoOutput = this.meta4ClientPool.getpresupuestosrango(param2,
        param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getpresupuestosrangoOutput.getReturn()));
  }

  @Test
  public void getVentaCongelada() {
    final IcmParamcalventacongeladaRecord record = new IcmParamcalventacongeladaRecord();
    final IcmParamcalventacongeladaBlock param1 = new IcmParamcalventacongeladaBlock();
    param1.setFechafin(Meta4TestConstants.FECHA_FIN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParamcalventacongeladaRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
    param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
    param2.setIdbusqueda(StringUtils.EMPTY);
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetventacongeladaOutput getventacongeladaOutput = this.meta4ClientPool.getventacongelada(param2, param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getventacongeladaOutput.getReturn()));
  }

  // TODO Mirar este test
  @Test
  @Disabled
  public void getConfiguracion() {
    final IcmParamcalconforigenRecord record = new IcmParamcalconforigenRecord();
    final IcmParamcalconforigenBlock param1 = new IcmParamcalconforigenBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    param1.getIcmParamcalconforigenRecordSet().add(record);
    final GetconfiguracionOutput getConfiguracionOutput = this.meta4ClientPool.getconfiguracion(param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getConfiguracionOutput.getReturn()));
  }

  @Test
  public void saveProceso() {
    final IcmParamcalprocesoRecord record = new IcmParamcalprocesoRecord();
    final IcmParamcalprocesoBlock param1 = new IcmParamcalprocesoBlock();
    param1.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    param1.getIcmParamcalprocesoRecordSet().add(record);
    final SaveprocesoOutput saveProcesoOutput = this.meta4ClientPool.saveproceso(param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(saveProcesoOutput.getReturn()));
  }

  // @Test
  // public void getEstructurasCom() {
  // final IcmParamcalestructuraRecord record = new IcmParamcalestructuraRecord();
  // record.setIdempleado("AT1010154");
  // record.setOrempleado("1");
  // final IcmParamcalestructuraBlock param1 = new IcmParamcalestructuraBlock();
  // param1.setIdorigen("38");
  // param1.setFechainicio("2015-01-01");
  // param1.setFechafin("2015-08-31");
  // param1.getIcmParamcalestructuraRecordSet().add(record);
  // final GetestructurascomOutput getComisionEmpleadoOutput =
  // this.meta4ClientPool.getestructurascom(param1);
  // assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getComisionEmpleadoOutput.getReturn()));
  // }

  // @Test
  // // @Ignore("Sirve para buscar e imprimir en consola estructuras a partir de localizacion /
  // origen")
  // public void comprobarEstructurasTiendasOrigen() {
  //
  // final IcmParamcalestructuraBlock paramEstructura = new IcmParamcalestructuraBlock();
  // paramEstructura.setFechainicio("2017-01-01");
  // paramEstructura.setFechafin("2018-12-31");
  // final IcmParamcalempleadosBlock param1 = new IcmParamcalempleadosBlock();
  //
  // final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
  // param2.setNumeroregistrospagina("50");
  // param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
  // param2.setIdbusqueda(StringUtils.EMPTY);
  // param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
  // final List<String> lista = Arrays.asList("T1413", "T3188", "T3189", "T3273", "T3275", "T3323",
  // "T3355", "T3474",
  // "T3511", "T3682", "T3787", "T4330", "T4331", "T4352", "T4481", "T4578", "T8194", "T8195",
  // "T8779",
  // "T9092", "T9263", "T9930", "T9974");
  // for (final String tienda : lista) {
  // final IcmParamcalempleadosRecord record4 = new IcmParamcalempleadosRecord();
  // record4.setFechainicio("2017-01-01");
  // record4.setFechafin("2018-12-31");
  // param1.getIcmParamcalempleadosRecordSet().clear();
  // record4.setIdlugartrabajo(tienda);
  // param1.getIcmParamcalempleadosRecordSet().add(record4);
  // final GetempleadosOutput getEmpleadosOutput = this.meta4ClientPool.getempleados(param1, param2);
  // final List<IcmListaempleadosRecord> emprec = new ArrayList<>();
  // emprec.addAll(getEmpleadosOutput.getIcmListaempleados().getIcmListaempleadosRecordSet());
  // record4.setIdorigen("39");
  // param1.getIcmParamcalempleadosRecordSet().clear();
  // final List<IcmParamcalestructuraRecord> entradas2 = emprec.stream().map(obj -> {
  // final IcmParamcalestructuraRecord obj2 = new IcmParamcalestructuraRecord();
  // obj2.setIdempleado(obj.getIdempleado());
  // obj2.setOrempleado(obj.getOrempleado());
  // return obj2;
  // }).collect(Collectors.toList());
  // paramEstructura.getIcmParamcalestructuraRecordSet().addAll(entradas2);
  // if (emprec.size() > 0) {
  // final GetestructurascomOutput getComisionEmpleadoOutput = this.meta4ClientPool
  // .getestructurascom(paramEstructura);
  // final List<IcmListaestructuraRecord> recordset =
  // getComisionEmpleadoOutput.getIcmListaestructura()
  // .getIcmListaestructuraRecordSet();
  // for (final IcmListaestructuraRecord record2 : recordset) {
  // System.out.println("tienda:" + tienda + " idempleado: " + record2.getIdempleado()
  // + " idempleadolocal: " + record2.getIdempleadolocal() + " estructura: "
  // + record2.getIdestructura());
  // }
  // }
  // }
  // }

  @Test
  public void getEmpleados() {

    final IcmParamcalempleadosRecord record = new IcmParamcalempleadosRecord();
    record.setFechainicio(Meta4TestConstants.FECHA_INICIO);
    record.setIdorigen(Meta4TestConstants.ID_ORIGEN);
    record.setIdempresa(Meta4TestConstants.ID_EMPRESA);
    record.setIdlugartrabajo(Meta4TestConstants.ID_LOCALIZACION);
    final IcmParamcalempleadosBlock param1 = new IcmParamcalempleadosBlock();
    param1.getIcmParamcalempleadosRecordSet().add(record);
    final IcmParametrospaginacionBlock param2 = new IcmParametrospaginacionBlock();
    param2.setNumeroregistrospagina(Meta4TestConstants.NUM_REGISTROS_PAGINA);
    param2.setNumeropagina(Meta4TestConstants.NUM_PAGINA);
    param2.setIdbusqueda(StringUtils.EMPTY);
    param2.getIcmParametrospaginacionRecordSet().add(new IcmParametrospaginacionRecord());
    final GetempleadosOutput getEmpleadosOutput = this.meta4ClientPool.getempleados(param1, param2);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getEmpleadosOutput.getReturn()));
  }

  @Test
  public void getEstructurasPol() {
    final IcmParamcalestructuraRecord record = new IcmParamcalestructuraRecord();
    record.setIdempleado("AT1010154");
    record.setOrempleado("1");
    final IcmParamcalestructuraBlock param1 = new IcmParamcalestructuraBlock();
    param1.setIdorigen("38");
    param1.setFechainicio("2015-01-01");
    param1.setFechafin("2015-08-31");
    param1.getIcmParamcalestructuraRecordSet().add(record);
    final GetestructuraspolOutput getestrpoliticas = this.meta4ClientPool.getestructuraspol(param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getestrpoliticas.getReturn()));
  }

  @Test
  public void getDesplazReal() {
    final IcmParamcaldesplazrealRecord record = new IcmParamcaldesplazrealRecord();
    record.setIdempleado("AT1010154");
    record.setOrempleado("1");
    final IcmParamcaldesplazrealBlock param1 = new IcmParamcaldesplazrealBlock();
    param1.getIcmParamcaldesplazrealRecordSet().add(record);
    final GetdesplazrealOutput getdesplazrealOutput = this.meta4ClientPool.getdesplazreal(param1);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getdesplazrealOutput.getReturn()));
  }

  @Test
  public void getSisDestino() {

    final IcmParamcalsistdestinoBlock param = new IcmParamcalsistdestinoBlock();
    param.setIdorigen("38");
    param.getIcmParamcalsistdestinoRecordSet().add(new IcmParamcalsistdestinoRecord());
    final GetsistdestinoOutput getsisdestinoOutput = this.meta4ClientPool.getsisdestino(param);
    assertNotNull(getsisdestinoOutput);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getsisdestinoOutput.getReturn()));

  }

  @Test
  public void getCatalogo() {

    final IcmParamcalcatalogoBlock param = new IcmParamcalcatalogoBlock();
    param.setIdorigen("11");
    final IcmParamcalcatalogoRecord record = new IcmParamcalcatalogoRecord();
    record.setIdempresa("8");
    param.getIcmParamcalcatalogoRecordSet().add(record);
    final GetcatalogoOutput getcatalogoOutput = this.meta4ClientPool.getcatalogo(param);
    assertNotNull(getcatalogoOutput);
    assertEquals(NumberUtils.DOUBLE_ZERO, Double.valueOf(getcatalogoOutput.getReturn()));

  }

}
