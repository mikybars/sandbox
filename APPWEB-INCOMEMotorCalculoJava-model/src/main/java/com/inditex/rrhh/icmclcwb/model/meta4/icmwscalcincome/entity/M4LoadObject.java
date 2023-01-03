
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.CopyTo2;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Clase Java para anonymous complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ICM_WS_TOOLS" type="{http://schemas.meta4.com/}Icm_Ws_ToolsBlock"/&gt;
 *         &lt;element name="ICM_LISTAMAIL" type="{http://schemas.meta4.com/}Icm_ListamailBlock"/&gt;
 *         &lt;element name="ICM_LISTACLASES" type="{http://schemas.meta4.com/}Icm_ListaclasesBlock"/&gt;
 *         &lt;element name="ICM_LISTASINCRO" type="{http://schemas.meta4.com/}Icm_ListasincroBlock"/&gt;
 *         &lt;element name="ICM_LISTACADENAS" type="{http://schemas.meta4.com/}Icm_ListacadenasBlock"/&gt;
 *         &lt;element name="ICM_LISTAMOTIVOS" type="{http://schemas.meta4.com/}Icm_ListamotivosBlock"/&gt;
 *         &lt;element name="ICM_LISTATIENDAS" type="{http://schemas.meta4.com/}Icm_ListatiendasBlock"/&gt;
 *         &lt;element name="ICM_LISTACATALOGO" type="{http://schemas.meta4.com/}Icm_ListacatalogoBlock"/&gt;
 *         &lt;element name="ICM_LISTAEMPLEADO" type="{http://schemas.meta4.com/}Icm_ListaempleadoBlock"/&gt;
 *         &lt;element name="ICM_LISTAEMPRESAS" type="{http://schemas.meta4.com/}Icm_ListaempresasBlock"/&gt;
 *         &lt;element name="ICM_LISTAORIGENES" type="{http://schemas.meta4.com/}Icm_ListaorigenesBlock"/&gt;
 *         &lt;element name="ICM_LISTAPERIODOS" type="{http://schemas.meta4.com/}Icm_ListaperiodosBlock"/&gt;
 *         &lt;element name="ICM_LISTAAUSENCIAS" type="{http://schemas.meta4.com/}Icm_ListaausenciasBlock"/&gt;
 *         &lt;element name="ICM_LISTAEMPLEADOS" type="{http://schemas.meta4.com/}Icm_ListaempleadosBlock"/&gt;
 *         &lt;element name="ICM_LISTAPOLITICAS" type="{http://schemas.meta4.com/}Icm_ListapoliticasBlock"/&gt;
 *         &lt;element name="ICM_LISTATIPOSHORA" type="{http://schemas.meta4.com/}Icm_ListatiposhoraBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALCADENA" type="{http://schemas.meta4.com/}Icm_ParamcalcadenaBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALORIGEN" type="{http://schemas.meta4.com/}Icm_ParamcalorigenBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALSINCRO" type="{http://schemas.meta4.com/}Icm_ParamcalsincroBlock"/&gt;
 *         &lt;element name="ICM_LISTACONFCHDIAS" type="{http://schemas.meta4.com/}Icm_ListaconfchdiasBlock"/&gt;
 *         &lt;element name="ICM_LISTACONFORIGEN" type="{http://schemas.meta4.com/}Icm_ListaconforigenBlock"/&gt;
 *         &lt;element name="ICM_LISTAESTRUCTURA" type="{http://schemas.meta4.com/}Icm_ListaestructuraBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALMOTIVOS" type="{http://schemas.meta4.com/}Icm_ParamcalmotivosBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALPERIODO" type="{http://schemas.meta4.com/}Icm_ParamcalperiodoBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALPROCESO" type="{http://schemas.meta4.com/}Icm_ParamcalprocesoBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALTIENDAS" type="{http://schemas.meta4.com/}Icm_ParamcaltiendasBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALUSUARIO" type="{http://schemas.meta4.com/}Icm_ParamcalusuarioBlock"/&gt;
 *         &lt;element name="ICM_LISTACONFCHVENTA" type="{http://schemas.meta4.com/}Icm_ListaconfchventaBlock"/&gt;
 *         &lt;element name="ICM_LISTADESPLAZREAL" type="{http://schemas.meta4.com/}Icm_ListadesplazrealBlock"/&gt;
 *         &lt;element name="ICM_LISTASISTDESTINO" type="{http://schemas.meta4.com/}Icm_ListasistdestinoBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALCATALOGO" type="{http://schemas.meta4.com/}Icm_ParamcalcatalogoBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALEMPLEADO" type="{http://schemas.meta4.com/}Icm_ParamcalempleadoBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALSOCIEDAD" type="{http://schemas.meta4.com/}Icm_ParamcalsociedadBlock"/&gt;
 *         &lt;element name="ICM_LISTAMULTIEMPRESA" type="{http://schemas.meta4.com/}Icm_ListamultiempresaBlock"/&gt;
 *         &lt;element name="ICM_LISTAVENTAMANWLOC" type="{http://schemas.meta4.com/}Icm_ListaventamanwlocBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALEMPLEADOS" type="{http://schemas.meta4.com/}Icm_ParamcalempleadosBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALTIPOSHORA" type="{http://schemas.meta4.com/}Icm_ParamcaltiposhoraBlock"/&gt;
 *         &lt;element name="ICM_PARAMETROSENTRADA" type="{http://schemas.meta4.com/}Icm_ParametrosentradaBlock"/&gt;
 *         &lt;element name="ICM_RESULTADOGUARDADO" type="{http://schemas.meta4.com/}Icm_ResultadoguardadoBlock"/&gt;
 *         &lt;element name="ICM_LISTACONFIGURACION" type="{http://schemas.meta4.com/}Icm_ListaconfiguracionBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALCONFCHDIAS" type="{http://schemas.meta4.com/}Icm_ParamcalconfchdiasBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALCONFORIGEN" type="{http://schemas.meta4.com/}Icm_ParamcalconforigenBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALESTRUCTURA" type="{http://schemas.meta4.com/}Icm_ParamcalestructuraBlock"/&gt;
 *         &lt;element name="ICM_LISTACONFPRECIOHORA" type="{http://schemas.meta4.com/}Icm_ListaconfpreciohoraBlock"/&gt;
 *         &lt;element name="ICM_LISTAVENTACONGELADA" type="{http://schemas.meta4.com/}Icm_ListaventacongeladaBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALCONFCHVENTA" type="{http://schemas.meta4.com/}Icm_ParamcalconfchventaBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALDESPLAZREAL" type="{http://schemas.meta4.com/}Icm_ParamcaldesplazrealBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALFLAGCALCULA" type="{http://schemas.meta4.com/}Icm_ParamcalflagcalculaBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALLIQUIDACION" type="{http://schemas.meta4.com/}Icm_ParamcalliquidacionBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALSISTDESTINO" type="{http://schemas.meta4.com/}Icm_ParamcalsistdestinoBlock"/&gt;
 *         &lt;element name="ICM_WS_CALC_OPERACIONES" type="{http://schemas.meta4.com/}Icm_Ws_Calc_OperacionesBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALMULTIEMPRESA" type="{http://schemas.meta4.com/}Icm_ParamcalmultiempresaBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALPLANIFICADOR" type="{http://schemas.meta4.com/}Icm_ParamcalplanificadorBlock"/&gt;
 *         &lt;element name="ICM_PARAMETROSPAGINACION" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
 *         &lt;element name="ICM_LISTAPRESENCIAMANWLOC" type="{http://schemas.meta4.com/}Icm_ListapresenciamanwlocBlock"/&gt;
 *         &lt;element name="ICM_LISTAPRESUPUESTOSWLOC" type="{http://schemas.meta4.com/}Icm_ListapresupuestoswlocBlock"/&gt;
 *         &lt;element name="ICM_LISTAPRESUPUESTOSRANGO" type="{http://schemas.meta4.com/}Icm_ListapresupuestosrangoBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALCONFPRECIOHORA" type="{http://schemas.meta4.com/}Icm_ParamcalconfpreciohoraBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALVENTACONGELADA" type="{http://schemas.meta4.com/}Icm_ParamcalventacongeladaBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALPRESENCIAMANUAL" type="{http://schemas.meta4.com/}Icm_ParamcalpresenciamanualBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALEMPLEADOSDESPLAZ" type="{http://schemas.meta4.com/}Icm_ParamcalempleadosdesplazBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALPRESUPUESTOSWLOC" type="{http://schemas.meta4.com/}Icm_ParamcalpresupuestoswlocBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALPRESUPUESTOSRANGO" type="{http://schemas.meta4.com/}Icm_ParamcalpresupuestosrangoBlock"/&gt;
 *         &lt;element name="ICM_PARAMCALEMPLEADOSPRESENCIA" type="{http://schemas.meta4.com/}Icm_ParamcalempleadospresenciaBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "icmwstools",
    "icmlistamail",
    "icmlistaclases",
    "icmlistasincro",
    "icmlistacadenas",
    "icmlistamotivos",
    "icmlistatiendas",
    "icmlistacatalogo",
    "icmlistaempleado",
    "icmlistaempresas",
    "icmlistaorigenes",
    "icmlistaperiodos",
    "icmlistaausencias",
    "icmlistaempleados",
    "icmlistapoliticas",
    "icmlistatiposhora",
    "icmparamcalcadena",
    "icmparamcalorigen",
    "icmparamcalsincro",
    "icmlistaconfchdias",
    "icmlistaconforigen",
    "icmlistaestructura",
    "icmparamcalmotivos",
    "icmparamcalperiodo",
    "icmparamcalproceso",
    "icmparamcaltiendas",
    "icmparamcalusuario",
    "icmlistaconfchventa",
    "icmlistadesplazreal",
    "icmlistasistdestino",
    "icmparamcalcatalogo",
    "icmparamcalempleado",
    "icmparamcalsociedad",
    "icmlistamultiempresa",
    "icmlistaventamanwloc",
    "icmparamcalempleados",
    "icmparamcaltiposhora",
    "icmparametrosentrada",
    "icmresultadoguardado",
    "icmlistaconfiguracion",
    "icmparamcalconfchdias",
    "icmparamcalconforigen",
    "icmparamcalestructura",
    "icmlistaconfpreciohora",
    "icmlistaventacongelada",
    "icmparamcalconfchventa",
    "icmparamcaldesplazreal",
    "icmparamcalflagcalcula",
    "icmparamcalliquidacion",
    "icmparamcalsistdestino",
    "icmwscalcoperaciones",
    "icmparamcalmultiempresa",
    "icmparamcalplanificador",
    "icmparametrospaginacion",
    "icmlistapresenciamanwloc",
    "icmlistapresupuestoswloc",
    "icmlistapresupuestosrango",
    "icmparamcalconfpreciohora",
    "icmparamcalventacongelada",
    "icmparamcalpresenciamanual",
    "icmparamcalempleadosdesplaz",
    "icmparamcalpresupuestoswloc",
    "icmparamcalpresupuestosrango",
    "icmparamcalempleadospresencia"
})
@XmlRootElement(name = "M4LoadObject")
public class M4LoadObject implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ICM_WS_TOOLS", required = true)
    protected IcmWsToolsBlock icmwstools;
    @XmlElement(name = "ICM_LISTAMAIL", required = true)
    protected IcmListamailBlock icmlistamail;
    @XmlElement(name = "ICM_LISTACLASES", required = true)
    protected IcmListaclasesBlock icmlistaclases;
    @XmlElement(name = "ICM_LISTASINCRO", required = true)
    protected IcmListasincroBlock icmlistasincro;
    @XmlElement(name = "ICM_LISTACADENAS", required = true)
    protected IcmListacadenasBlock icmlistacadenas;
    @XmlElement(name = "ICM_LISTAMOTIVOS", required = true)
    protected IcmListamotivosBlock icmlistamotivos;
    @XmlElement(name = "ICM_LISTATIENDAS", required = true)
    protected IcmListatiendasBlock icmlistatiendas;
    @XmlElement(name = "ICM_LISTACATALOGO", required = true)
    protected IcmListacatalogoBlock icmlistacatalogo;
    @XmlElement(name = "ICM_LISTAEMPLEADO", required = true)
    protected IcmListaempleadoBlock icmlistaempleado;
    @XmlElement(name = "ICM_LISTAEMPRESAS", required = true)
    protected IcmListaempresasBlock icmlistaempresas;
    @XmlElement(name = "ICM_LISTAORIGENES", required = true)
    protected IcmListaorigenesBlock icmlistaorigenes;
    @XmlElement(name = "ICM_LISTAPERIODOS", required = true)
    protected IcmListaperiodosBlock icmlistaperiodos;
    @XmlElement(name = "ICM_LISTAAUSENCIAS", required = true)
    protected IcmListaausenciasBlock icmlistaausencias;
    @XmlElement(name = "ICM_LISTAEMPLEADOS", required = true)
    protected IcmListaempleadosBlock icmlistaempleados;
    @XmlElement(name = "ICM_LISTAPOLITICAS", required = true)
    protected IcmListapoliticasBlock icmlistapoliticas;
    @XmlElement(name = "ICM_LISTATIPOSHORA", required = true)
    protected IcmListatiposhoraBlock icmlistatiposhora;
    @XmlElement(name = "ICM_PARAMCALCADENA", required = true)
    protected IcmParamcalcadenaBlock icmparamcalcadena;
    @XmlElement(name = "ICM_PARAMCALORIGEN", required = true)
    protected IcmParamcalorigenBlock icmparamcalorigen;
    @XmlElement(name = "ICM_PARAMCALSINCRO", required = true)
    protected IcmParamcalsincroBlock icmparamcalsincro;
    @XmlElement(name = "ICM_LISTACONFCHDIAS", required = true)
    protected IcmListaconfchdiasBlock icmlistaconfchdias;
    @XmlElement(name = "ICM_LISTACONFORIGEN", required = true)
    protected IcmListaconforigenBlock icmlistaconforigen;
    @XmlElement(name = "ICM_LISTAESTRUCTURA", required = true)
    protected IcmListaestructuraBlock icmlistaestructura;
    @XmlElement(name = "ICM_PARAMCALMOTIVOS", required = true)
    protected IcmParamcalmotivosBlock icmparamcalmotivos;
    @XmlElement(name = "ICM_PARAMCALPERIODO", required = true)
    protected IcmParamcalperiodoBlock icmparamcalperiodo;
    @XmlElement(name = "ICM_PARAMCALPROCESO", required = true)
    protected IcmParamcalprocesoBlock icmparamcalproceso;
    @XmlElement(name = "ICM_PARAMCALTIENDAS", required = true)
    protected IcmParamcaltiendasBlock icmparamcaltiendas;
    @XmlElement(name = "ICM_PARAMCALUSUARIO", required = true)
    protected IcmParamcalusuarioBlock icmparamcalusuario;
    @XmlElement(name = "ICM_LISTACONFCHVENTA", required = true)
    protected IcmListaconfchventaBlock icmlistaconfchventa;
    @XmlElement(name = "ICM_LISTADESPLAZREAL", required = true)
    protected IcmListadesplazrealBlock icmlistadesplazreal;
    @XmlElement(name = "ICM_LISTASISTDESTINO", required = true)
    protected IcmListasistdestinoBlock icmlistasistdestino;
    @XmlElement(name = "ICM_PARAMCALCATALOGO", required = true)
    protected IcmParamcalcatalogoBlock icmparamcalcatalogo;
    @XmlElement(name = "ICM_PARAMCALEMPLEADO", required = true)
    protected IcmParamcalempleadoBlock icmparamcalempleado;
    @XmlElement(name = "ICM_PARAMCALSOCIEDAD", required = true)
    protected IcmParamcalsociedadBlock icmparamcalsociedad;
    @XmlElement(name = "ICM_LISTAMULTIEMPRESA", required = true)
    protected IcmListamultiempresaBlock icmlistamultiempresa;
    @XmlElement(name = "ICM_LISTAVENTAMANWLOC", required = true)
    protected IcmListaventamanwlocBlock icmlistaventamanwloc;
    @XmlElement(name = "ICM_PARAMCALEMPLEADOS", required = true)
    protected IcmParamcalempleadosBlock icmparamcalempleados;
    @XmlElement(name = "ICM_PARAMCALTIPOSHORA", required = true)
    protected IcmParamcaltiposhoraBlock icmparamcaltiposhora;
    @XmlElement(name = "ICM_PARAMETROSENTRADA", required = true)
    protected IcmParametrosentradaBlock icmparametrosentrada;
    @XmlElement(name = "ICM_RESULTADOGUARDADO", required = true)
    protected IcmResultadoguardadoBlock icmresultadoguardado;
    @XmlElement(name = "ICM_LISTACONFIGURACION", required = true)
    protected IcmListaconfiguracionBlock icmlistaconfiguracion;
    @XmlElement(name = "ICM_PARAMCALCONFCHDIAS", required = true)
    protected IcmParamcalconfchdiasBlock icmparamcalconfchdias;
    @XmlElement(name = "ICM_PARAMCALCONFORIGEN", required = true)
    protected IcmParamcalconforigenBlock icmparamcalconforigen;
    @XmlElement(name = "ICM_PARAMCALESTRUCTURA", required = true)
    protected IcmParamcalestructuraBlock icmparamcalestructura;
    @XmlElement(name = "ICM_LISTACONFPRECIOHORA", required = true)
    protected IcmListaconfpreciohoraBlock icmlistaconfpreciohora;
    @XmlElement(name = "ICM_LISTAVENTACONGELADA", required = true)
    protected IcmListaventacongeladaBlock icmlistaventacongelada;
    @XmlElement(name = "ICM_PARAMCALCONFCHVENTA", required = true)
    protected IcmParamcalconfchventaBlock icmparamcalconfchventa;
    @XmlElement(name = "ICM_PARAMCALDESPLAZREAL", required = true)
    protected IcmParamcaldesplazrealBlock icmparamcaldesplazreal;
    @XmlElement(name = "ICM_PARAMCALFLAGCALCULA", required = true)
    protected IcmParamcalflagcalculaBlock icmparamcalflagcalcula;
    @XmlElement(name = "ICM_PARAMCALLIQUIDACION", required = true)
    protected IcmParamcalliquidacionBlock icmparamcalliquidacion;
    @XmlElement(name = "ICM_PARAMCALSISTDESTINO", required = true)
    protected IcmParamcalsistdestinoBlock icmparamcalsistdestino;
    @XmlElement(name = "ICM_WS_CALC_OPERACIONES", required = true)
    protected IcmWsCalcOperacionesBlock icmwscalcoperaciones;
    @XmlElement(name = "ICM_PARAMCALMULTIEMPRESA", required = true)
    protected IcmParamcalmultiempresaBlock icmparamcalmultiempresa;
    @XmlElement(name = "ICM_PARAMCALPLANIFICADOR", required = true)
    protected IcmParamcalplanificadorBlock icmparamcalplanificador;
    @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
    protected IcmParametrospaginacionBlock icmparametrospaginacion;
    @XmlElement(name = "ICM_LISTAPRESENCIAMANWLOC", required = true)
    protected IcmListapresenciamanwlocBlock icmlistapresenciamanwloc;
    @XmlElement(name = "ICM_LISTAPRESUPUESTOSWLOC", required = true)
    protected IcmListapresupuestoswlocBlock icmlistapresupuestoswloc;
    @XmlElement(name = "ICM_LISTAPRESUPUESTOSRANGO", required = true)
    protected IcmListapresupuestosrangoBlock icmlistapresupuestosrango;
    @XmlElement(name = "ICM_PARAMCALCONFPRECIOHORA", required = true)
    protected IcmParamcalconfpreciohoraBlock icmparamcalconfpreciohora;
    @XmlElement(name = "ICM_PARAMCALVENTACONGELADA", required = true)
    protected IcmParamcalventacongeladaBlock icmparamcalventacongelada;
    @XmlElement(name = "ICM_PARAMCALPRESENCIAMANUAL", required = true)
    protected IcmParamcalpresenciamanualBlock icmparamcalpresenciamanual;
    @XmlElement(name = "ICM_PARAMCALEMPLEADOSDESPLAZ", required = true)
    protected IcmParamcalempleadosdesplazBlock icmparamcalempleadosdesplaz;
    @XmlElement(name = "ICM_PARAMCALPRESUPUESTOSWLOC", required = true)
    protected IcmParamcalpresupuestoswlocBlock icmparamcalpresupuestoswloc;
    @XmlElement(name = "ICM_PARAMCALPRESUPUESTOSRANGO", required = true)
    protected IcmParamcalpresupuestosrangoBlock icmparamcalpresupuestosrango;
    @XmlElement(name = "ICM_PARAMCALEMPLEADOSPRESENCIA", required = true)
    protected IcmParamcalempleadospresenciaBlock icmparamcalempleadospresencia;

    /**
     * Obtiene el valor de la propiedad icmwstools.
     *
     * @return
     *     possible object is
     *     {@link IcmWsToolsBlock }
     *
     */
    public IcmWsToolsBlock getICMWSTOOLS() {
        return icmwstools;
    }

    /**
     * Define el valor de la propiedad icmwstools.
     *
     * @param value
     *     allowed object is
     *     {@link IcmWsToolsBlock }
     *
     */
    public void setICMWSTOOLS(IcmWsToolsBlock value) {
        this.icmwstools = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistamail.
     *
     * @return
     *     possible object is
     *     {@link IcmListamailBlock }
     *
     */
    public IcmListamailBlock getICMLISTAMAIL() {
        return icmlistamail;
    }

    /**
     * Define el valor de la propiedad icmlistamail.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListamailBlock }
     *
     */
    public void setICMLISTAMAIL(IcmListamailBlock value) {
        this.icmlistamail = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaclases.
     *
     * @return
     *     possible object is
     *     {@link IcmListaclasesBlock }
     *
     */
    public IcmListaclasesBlock getICMLISTACLASES() {
        return icmlistaclases;
    }

    /**
     * Define el valor de la propiedad icmlistaclases.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaclasesBlock }
     *
     */
    public void setICMLISTACLASES(IcmListaclasesBlock value) {
        this.icmlistaclases = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistasincro.
     *
     * @return
     *     possible object is
     *     {@link IcmListasincroBlock }
     *
     */
    public IcmListasincroBlock getICMLISTASINCRO() {
        return icmlistasincro;
    }

    /**
     * Define el valor de la propiedad icmlistasincro.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListasincroBlock }
     *
     */
    public void setICMLISTASINCRO(IcmListasincroBlock value) {
        this.icmlistasincro = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistacadenas.
     *
     * @return
     *     possible object is
     *     {@link IcmListacadenasBlock }
     *
     */
    public IcmListacadenasBlock getICMLISTACADENAS() {
        return icmlistacadenas;
    }

    /**
     * Define el valor de la propiedad icmlistacadenas.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListacadenasBlock }
     *
     */
    public void setICMLISTACADENAS(IcmListacadenasBlock value) {
        this.icmlistacadenas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistamotivos.
     *
     * @return
     *     possible object is
     *     {@link IcmListamotivosBlock }
     *
     */
    public IcmListamotivosBlock getICMLISTAMOTIVOS() {
        return icmlistamotivos;
    }

    /**
     * Define el valor de la propiedad icmlistamotivos.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListamotivosBlock }
     *
     */
    public void setICMLISTAMOTIVOS(IcmListamotivosBlock value) {
        this.icmlistamotivos = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistatiendas.
     *
     * @return
     *     possible object is
     *     {@link IcmListatiendasBlock }
     *
     */
    public IcmListatiendasBlock getICMLISTATIENDAS() {
        return icmlistatiendas;
    }

    /**
     * Define el valor de la propiedad icmlistatiendas.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListatiendasBlock }
     *
     */
    public void setICMLISTATIENDAS(IcmListatiendasBlock value) {
        this.icmlistatiendas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistacatalogo.
     *
     * @return
     *     possible object is
     *     {@link IcmListacatalogoBlock }
     *
     */
    public IcmListacatalogoBlock getICMLISTACATALOGO() {
        return icmlistacatalogo;
    }

    /**
     * Define el valor de la propiedad icmlistacatalogo.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListacatalogoBlock }
     *
     */
    public void setICMLISTACATALOGO(IcmListacatalogoBlock value) {
        this.icmlistacatalogo = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaempleado.
     *
     * @return
     *     possible object is
     *     {@link IcmListaempleadoBlock }
     *
     */
    public IcmListaempleadoBlock getICMLISTAEMPLEADO() {
        return icmlistaempleado;
    }

    /**
     * Define el valor de la propiedad icmlistaempleado.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaempleadoBlock }
     *
     */
    public void setICMLISTAEMPLEADO(IcmListaempleadoBlock value) {
        this.icmlistaempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaempresas.
     *
     * @return
     *     possible object is
     *     {@link IcmListaempresasBlock }
     *
     */
    public IcmListaempresasBlock getICMLISTAEMPRESAS() {
        return icmlistaempresas;
    }

    /**
     * Define el valor de la propiedad icmlistaempresas.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaempresasBlock }
     *
     */
    public void setICMLISTAEMPRESAS(IcmListaempresasBlock value) {
        this.icmlistaempresas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaorigenes.
     *
     * @return
     *     possible object is
     *     {@link IcmListaorigenesBlock }
     *
     */
    public IcmListaorigenesBlock getICMLISTAORIGENES() {
        return icmlistaorigenes;
    }

    /**
     * Define el valor de la propiedad icmlistaorigenes.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaorigenesBlock }
     *
     */
    public void setICMLISTAORIGENES(IcmListaorigenesBlock value) {
        this.icmlistaorigenes = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaperiodos.
     *
     * @return
     *     possible object is
     *     {@link IcmListaperiodosBlock }
     *
     */
    public IcmListaperiodosBlock getICMLISTAPERIODOS() {
        return icmlistaperiodos;
    }

    /**
     * Define el valor de la propiedad icmlistaperiodos.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaperiodosBlock }
     *
     */
    public void setICMLISTAPERIODOS(IcmListaperiodosBlock value) {
        this.icmlistaperiodos = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaausencias.
     *
     * @return
     *     possible object is
     *     {@link IcmListaausenciasBlock }
     *
     */
    public IcmListaausenciasBlock getICMLISTAAUSENCIAS() {
        return icmlistaausencias;
    }

    /**
     * Define el valor de la propiedad icmlistaausencias.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaausenciasBlock }
     *
     */
    public void setICMLISTAAUSENCIAS(IcmListaausenciasBlock value) {
        this.icmlistaausencias = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaempleados.
     *
     * @return
     *     possible object is
     *     {@link IcmListaempleadosBlock }
     *
     */
    public IcmListaempleadosBlock getICMLISTAEMPLEADOS() {
        return icmlistaempleados;
    }

    /**
     * Define el valor de la propiedad icmlistaempleados.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaempleadosBlock }
     *
     */
    public void setICMLISTAEMPLEADOS(IcmListaempleadosBlock value) {
        this.icmlistaempleados = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistapoliticas.
     *
     * @return
     *     possible object is
     *     {@link IcmListapoliticasBlock }
     *
     */
    public IcmListapoliticasBlock getICMLISTAPOLITICAS() {
        return icmlistapoliticas;
    }

    /**
     * Define el valor de la propiedad icmlistapoliticas.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListapoliticasBlock }
     *
     */
    public void setICMLISTAPOLITICAS(IcmListapoliticasBlock value) {
        this.icmlistapoliticas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistatiposhora.
     *
     * @return
     *     possible object is
     *     {@link IcmListatiposhoraBlock }
     *
     */
    public IcmListatiposhoraBlock getICMLISTATIPOSHORA() {
        return icmlistatiposhora;
    }

    /**
     * Define el valor de la propiedad icmlistatiposhora.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListatiposhoraBlock }
     *
     */
    public void setICMLISTATIPOSHORA(IcmListatiposhoraBlock value) {
        this.icmlistatiposhora = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalcadena.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalcadenaBlock }
     *
     */
    public IcmParamcalcadenaBlock getICMPARAMCALCADENA() {
        return icmparamcalcadena;
    }

    /**
     * Define el valor de la propiedad icmparamcalcadena.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalcadenaBlock }
     *
     */
    public void setICMPARAMCALCADENA(IcmParamcalcadenaBlock value) {
        this.icmparamcalcadena = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalorigen.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalorigenBlock }
     *
     */
    public IcmParamcalorigenBlock getICMPARAMCALORIGEN() {
        return icmparamcalorigen;
    }

    /**
     * Define el valor de la propiedad icmparamcalorigen.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalorigenBlock }
     *
     */
    public void setICMPARAMCALORIGEN(IcmParamcalorigenBlock value) {
        this.icmparamcalorigen = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalsincro.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalsincroBlock }
     *
     */
    public IcmParamcalsincroBlock getICMPARAMCALSINCRO() {
        return icmparamcalsincro;
    }

    /**
     * Define el valor de la propiedad icmparamcalsincro.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalsincroBlock }
     *
     */
    public void setICMPARAMCALSINCRO(IcmParamcalsincroBlock value) {
        this.icmparamcalsincro = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaconfchdias.
     *
     * @return
     *     possible object is
     *     {@link IcmListaconfchdiasBlock }
     *
     */
    public IcmListaconfchdiasBlock getICMLISTACONFCHDIAS() {
        return icmlistaconfchdias;
    }

    /**
     * Define el valor de la propiedad icmlistaconfchdias.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaconfchdiasBlock }
     *
     */
    public void setICMLISTACONFCHDIAS(IcmListaconfchdiasBlock value) {
        this.icmlistaconfchdias = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaconforigen.
     *
     * @return
     *     possible object is
     *     {@link IcmListaconforigenBlock }
     *
     */
    public IcmListaconforigenBlock getICMLISTACONFORIGEN() {
        return icmlistaconforigen;
    }

    /**
     * Define el valor de la propiedad icmlistaconforigen.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaconforigenBlock }
     *
     */
    public void setICMLISTACONFORIGEN(IcmListaconforigenBlock value) {
        this.icmlistaconforigen = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaestructura.
     *
     * @return
     *     possible object is
     *     {@link IcmListaestructuraBlock }
     *
     */
    public IcmListaestructuraBlock getICMLISTAESTRUCTURA() {
        return icmlistaestructura;
    }

    /**
     * Define el valor de la propiedad icmlistaestructura.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaestructuraBlock }
     *
     */
    public void setICMLISTAESTRUCTURA(IcmListaestructuraBlock value) {
        this.icmlistaestructura = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalmotivos.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalmotivosBlock }
     *
     */
    public IcmParamcalmotivosBlock getICMPARAMCALMOTIVOS() {
        return icmparamcalmotivos;
    }

    /**
     * Define el valor de la propiedad icmparamcalmotivos.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalmotivosBlock }
     *
     */
    public void setICMPARAMCALMOTIVOS(IcmParamcalmotivosBlock value) {
        this.icmparamcalmotivos = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalperiodo.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalperiodoBlock }
     *
     */
    public IcmParamcalperiodoBlock getICMPARAMCALPERIODO() {
        return icmparamcalperiodo;
    }

    /**
     * Define el valor de la propiedad icmparamcalperiodo.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalperiodoBlock }
     *
     */
    public void setICMPARAMCALPERIODO(IcmParamcalperiodoBlock value) {
        this.icmparamcalperiodo = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalproceso.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalprocesoBlock }
     *
     */
    public IcmParamcalprocesoBlock getICMPARAMCALPROCESO() {
        return icmparamcalproceso;
    }

    /**
     * Define el valor de la propiedad icmparamcalproceso.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalprocesoBlock }
     *
     */
    public void setICMPARAMCALPROCESO(IcmParamcalprocesoBlock value) {
        this.icmparamcalproceso = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcaltiendas.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcaltiendasBlock }
     *
     */
    public IcmParamcaltiendasBlock getICMPARAMCALTIENDAS() {
        return icmparamcaltiendas;
    }

    /**
     * Define el valor de la propiedad icmparamcaltiendas.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcaltiendasBlock }
     *
     */
    public void setICMPARAMCALTIENDAS(IcmParamcaltiendasBlock value) {
        this.icmparamcaltiendas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalusuario.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalusuarioBlock }
     *
     */
    public IcmParamcalusuarioBlock getICMPARAMCALUSUARIO() {
        return icmparamcalusuario;
    }

    /**
     * Define el valor de la propiedad icmparamcalusuario.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalusuarioBlock }
     *
     */
    public void setICMPARAMCALUSUARIO(IcmParamcalusuarioBlock value) {
        this.icmparamcalusuario = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaconfchventa.
     *
     * @return
     *     possible object is
     *     {@link IcmListaconfchventaBlock }
     *
     */
    public IcmListaconfchventaBlock getICMLISTACONFCHVENTA() {
        return icmlistaconfchventa;
    }

    /**
     * Define el valor de la propiedad icmlistaconfchventa.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaconfchventaBlock }
     *
     */
    public void setICMLISTACONFCHVENTA(IcmListaconfchventaBlock value) {
        this.icmlistaconfchventa = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistadesplazreal.
     *
     * @return
     *     possible object is
     *     {@link IcmListadesplazrealBlock }
     *
     */
    public IcmListadesplazrealBlock getICMLISTADESPLAZREAL() {
        return icmlistadesplazreal;
    }

    /**
     * Define el valor de la propiedad icmlistadesplazreal.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListadesplazrealBlock }
     *
     */
    public void setICMLISTADESPLAZREAL(IcmListadesplazrealBlock value) {
        this.icmlistadesplazreal = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistasistdestino.
     *
     * @return
     *     possible object is
     *     {@link IcmListasistdestinoBlock }
     *
     */
    public IcmListasistdestinoBlock getICMLISTASISTDESTINO() {
        return icmlistasistdestino;
    }

    /**
     * Define el valor de la propiedad icmlistasistdestino.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListasistdestinoBlock }
     *
     */
    public void setICMLISTASISTDESTINO(IcmListasistdestinoBlock value) {
        this.icmlistasistdestino = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalcatalogo.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalcatalogoBlock }
     *
     */
    public IcmParamcalcatalogoBlock getICMPARAMCALCATALOGO() {
        return icmparamcalcatalogo;
    }

    /**
     * Define el valor de la propiedad icmparamcalcatalogo.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalcatalogoBlock }
     *
     */
    public void setICMPARAMCALCATALOGO(IcmParamcalcatalogoBlock value) {
        this.icmparamcalcatalogo = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalempleado.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalempleadoBlock }
     *
     */
    public IcmParamcalempleadoBlock getICMPARAMCALEMPLEADO() {
        return icmparamcalempleado;
    }

    /**
     * Define el valor de la propiedad icmparamcalempleado.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalempleadoBlock }
     *
     */
    public void setICMPARAMCALEMPLEADO(IcmParamcalempleadoBlock value) {
        this.icmparamcalempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalsociedad.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalsociedadBlock }
     *
     */
    public IcmParamcalsociedadBlock getICMPARAMCALSOCIEDAD() {
        return icmparamcalsociedad;
    }

    /**
     * Define el valor de la propiedad icmparamcalsociedad.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalsociedadBlock }
     *
     */
    public void setICMPARAMCALSOCIEDAD(IcmParamcalsociedadBlock value) {
        this.icmparamcalsociedad = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistamultiempresa.
     *
     * @return
     *     possible object is
     *     {@link IcmListamultiempresaBlock }
     *
     */
    public IcmListamultiempresaBlock getICMLISTAMULTIEMPRESA() {
        return icmlistamultiempresa;
    }

    /**
     * Define el valor de la propiedad icmlistamultiempresa.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListamultiempresaBlock }
     *
     */
    public void setICMLISTAMULTIEMPRESA(IcmListamultiempresaBlock value) {
        this.icmlistamultiempresa = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaventamanwloc.
     *
     * @return
     *     possible object is
     *     {@link IcmListaventamanwlocBlock }
     *
     */
    public IcmListaventamanwlocBlock getICMLISTAVENTAMANWLOC() {
        return icmlistaventamanwloc;
    }

    /**
     * Define el valor de la propiedad icmlistaventamanwloc.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaventamanwlocBlock }
     *
     */
    public void setICMLISTAVENTAMANWLOC(IcmListaventamanwlocBlock value) {
        this.icmlistaventamanwloc = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalempleados.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalempleadosBlock }
     *
     */
    public IcmParamcalempleadosBlock getICMPARAMCALEMPLEADOS() {
        return icmparamcalempleados;
    }

    /**
     * Define el valor de la propiedad icmparamcalempleados.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalempleadosBlock }
     *
     */
    public void setICMPARAMCALEMPLEADOS(IcmParamcalempleadosBlock value) {
        this.icmparamcalempleados = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcaltiposhora.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcaltiposhoraBlock }
     *
     */
    public IcmParamcaltiposhoraBlock getICMPARAMCALTIPOSHORA() {
        return icmparamcaltiposhora;
    }

    /**
     * Define el valor de la propiedad icmparamcaltiposhora.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcaltiposhoraBlock }
     *
     */
    public void setICMPARAMCALTIPOSHORA(IcmParamcaltiposhoraBlock value) {
        this.icmparamcaltiposhora = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrosentrada.
     *
     * @return
     *     possible object is
     *     {@link IcmParametrosentradaBlock }
     *
     */
    public IcmParametrosentradaBlock getICMPARAMETROSENTRADA() {
        return icmparametrosentrada;
    }

    /**
     * Define el valor de la propiedad icmparametrosentrada.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParametrosentradaBlock }
     *
     */
    public void setICMPARAMETROSENTRADA(IcmParametrosentradaBlock value) {
        this.icmparametrosentrada = value;
    }

    /**
     * Obtiene el valor de la propiedad icmresultadoguardado.
     *
     * @return
     *     possible object is
     *     {@link IcmResultadoguardadoBlock }
     *
     */
    public IcmResultadoguardadoBlock getICMRESULTADOGUARDADO() {
        return icmresultadoguardado;
    }

    /**
     * Define el valor de la propiedad icmresultadoguardado.
     *
     * @param value
     *     allowed object is
     *     {@link IcmResultadoguardadoBlock }
     *
     */
    public void setICMRESULTADOGUARDADO(IcmResultadoguardadoBlock value) {
        this.icmresultadoguardado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaconfiguracion.
     *
     * @return
     *     possible object is
     *     {@link IcmListaconfiguracionBlock }
     *
     */
    public IcmListaconfiguracionBlock getICMLISTACONFIGURACION() {
        return icmlistaconfiguracion;
    }

    /**
     * Define el valor de la propiedad icmlistaconfiguracion.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaconfiguracionBlock }
     *
     */
    public void setICMLISTACONFIGURACION(IcmListaconfiguracionBlock value) {
        this.icmlistaconfiguracion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalconfchdias.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalconfchdiasBlock }
     *
     */
    public IcmParamcalconfchdiasBlock getICMPARAMCALCONFCHDIAS() {
        return icmparamcalconfchdias;
    }

    /**
     * Define el valor de la propiedad icmparamcalconfchdias.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalconfchdiasBlock }
     *
     */
    public void setICMPARAMCALCONFCHDIAS(IcmParamcalconfchdiasBlock value) {
        this.icmparamcalconfchdias = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalconforigen.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalconforigenBlock }
     *
     */
    public IcmParamcalconforigenBlock getICMPARAMCALCONFORIGEN() {
        return icmparamcalconforigen;
    }

    /**
     * Define el valor de la propiedad icmparamcalconforigen.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalconforigenBlock }
     *
     */
    public void setICMPARAMCALCONFORIGEN(IcmParamcalconforigenBlock value) {
        this.icmparamcalconforigen = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalestructura.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalestructuraBlock }
     *
     */
    public IcmParamcalestructuraBlock getICMPARAMCALESTRUCTURA() {
        return icmparamcalestructura;
    }

    /**
     * Define el valor de la propiedad icmparamcalestructura.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalestructuraBlock }
     *
     */
    public void setICMPARAMCALESTRUCTURA(IcmParamcalestructuraBlock value) {
        this.icmparamcalestructura = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaconfpreciohora.
     *
     * @return
     *     possible object is
     *     {@link IcmListaconfpreciohoraBlock }
     *
     */
    public IcmListaconfpreciohoraBlock getICMLISTACONFPRECIOHORA() {
        return icmlistaconfpreciohora;
    }

    /**
     * Define el valor de la propiedad icmlistaconfpreciohora.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaconfpreciohoraBlock }
     *
     */
    public void setICMLISTACONFPRECIOHORA(IcmListaconfpreciohoraBlock value) {
        this.icmlistaconfpreciohora = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistaventacongelada.
     *
     * @return
     *     possible object is
     *     {@link IcmListaventacongeladaBlock }
     *
     */
    public IcmListaventacongeladaBlock getICMLISTAVENTACONGELADA() {
        return icmlistaventacongelada;
    }

    /**
     * Define el valor de la propiedad icmlistaventacongelada.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListaventacongeladaBlock }
     *
     */
    public void setICMLISTAVENTACONGELADA(IcmListaventacongeladaBlock value) {
        this.icmlistaventacongelada = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalconfchventa.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalconfchventaBlock }
     *
     */
    public IcmParamcalconfchventaBlock getICMPARAMCALCONFCHVENTA() {
        return icmparamcalconfchventa;
    }

    /**
     * Define el valor de la propiedad icmparamcalconfchventa.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalconfchventaBlock }
     *
     */
    public void setICMPARAMCALCONFCHVENTA(IcmParamcalconfchventaBlock value) {
        this.icmparamcalconfchventa = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcaldesplazreal.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcaldesplazrealBlock }
     *
     */
    public IcmParamcaldesplazrealBlock getICMPARAMCALDESPLAZREAL() {
        return icmparamcaldesplazreal;
    }

    /**
     * Define el valor de la propiedad icmparamcaldesplazreal.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcaldesplazrealBlock }
     *
     */
    public void setICMPARAMCALDESPLAZREAL(IcmParamcaldesplazrealBlock value) {
        this.icmparamcaldesplazreal = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalflagcalcula.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalflagcalculaBlock }
     *
     */
    public IcmParamcalflagcalculaBlock getICMPARAMCALFLAGCALCULA() {
        return icmparamcalflagcalcula;
    }

    /**
     * Define el valor de la propiedad icmparamcalflagcalcula.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalflagcalculaBlock }
     *
     */
    public void setICMPARAMCALFLAGCALCULA(IcmParamcalflagcalculaBlock value) {
        this.icmparamcalflagcalcula = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalliquidacion.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalliquidacionBlock }
     *
     */
    public IcmParamcalliquidacionBlock getICMPARAMCALLIQUIDACION() {
        return icmparamcalliquidacion;
    }

    /**
     * Define el valor de la propiedad icmparamcalliquidacion.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalliquidacionBlock }
     *
     */
    public void setICMPARAMCALLIQUIDACION(IcmParamcalliquidacionBlock value) {
        this.icmparamcalliquidacion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalsistdestino.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalsistdestinoBlock }
     *
     */
    public IcmParamcalsistdestinoBlock getICMPARAMCALSISTDESTINO() {
        return icmparamcalsistdestino;
    }

    /**
     * Define el valor de la propiedad icmparamcalsistdestino.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalsistdestinoBlock }
     *
     */
    public void setICMPARAMCALSISTDESTINO(IcmParamcalsistdestinoBlock value) {
        this.icmparamcalsistdestino = value;
    }

    /**
     * Obtiene el valor de la propiedad icmwscalcoperaciones.
     *
     * @return
     *     possible object is
     *     {@link IcmWsCalcOperacionesBlock }
     *
     */
    public IcmWsCalcOperacionesBlock getICMWSCALCOPERACIONES() {
        return icmwscalcoperaciones;
    }

    /**
     * Define el valor de la propiedad icmwscalcoperaciones.
     *
     * @param value
     *     allowed object is
     *     {@link IcmWsCalcOperacionesBlock }
     *
     */
    public void setICMWSCALCOPERACIONES(IcmWsCalcOperacionesBlock value) {
        this.icmwscalcoperaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalmultiempresa.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalmultiempresaBlock }
     *
     */
    public IcmParamcalmultiempresaBlock getICMPARAMCALMULTIEMPRESA() {
        return icmparamcalmultiempresa;
    }

    /**
     * Define el valor de la propiedad icmparamcalmultiempresa.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalmultiempresaBlock }
     *
     */
    public void setICMPARAMCALMULTIEMPRESA(IcmParamcalmultiempresaBlock value) {
        this.icmparamcalmultiempresa = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalplanificador.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalplanificadorBlock }
     *
     */
    public IcmParamcalplanificadorBlock getICMPARAMCALPLANIFICADOR() {
        return icmparamcalplanificador;
    }

    /**
     * Define el valor de la propiedad icmparamcalplanificador.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalplanificadorBlock }
     *
     */
    public void setICMPARAMCALPLANIFICADOR(IcmParamcalplanificadorBlock value) {
        this.icmparamcalplanificador = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrospaginacion.
     *
     * @return
     *     possible object is
     *     {@link IcmParametrospaginacionBlock }
     *
     */
    public IcmParametrospaginacionBlock getICMPARAMETROSPAGINACION() {
        return icmparametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmparametrospaginacion.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaginacionBlock }
     *
     */
    public void setICMPARAMETROSPAGINACION(IcmParametrospaginacionBlock value) {
        this.icmparametrospaginacion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistapresenciamanwloc.
     *
     * @return
     *     possible object is
     *     {@link IcmListapresenciamanwlocBlock }
     *
     */
    public IcmListapresenciamanwlocBlock getICMLISTAPRESENCIAMANWLOC() {
        return icmlistapresenciamanwloc;
    }

    /**
     * Define el valor de la propiedad icmlistapresenciamanwloc.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListapresenciamanwlocBlock }
     *
     */
    public void setICMLISTAPRESENCIAMANWLOC(IcmListapresenciamanwlocBlock value) {
        this.icmlistapresenciamanwloc = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistapresupuestoswloc.
     *
     * @return
     *     possible object is
     *     {@link IcmListapresupuestoswlocBlock }
     *
     */
    public IcmListapresupuestoswlocBlock getICMLISTAPRESUPUESTOSWLOC() {
        return icmlistapresupuestoswloc;
    }

    /**
     * Define el valor de la propiedad icmlistapresupuestoswloc.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListapresupuestoswlocBlock }
     *
     */
    public void setICMLISTAPRESUPUESTOSWLOC(IcmListapresupuestoswlocBlock value) {
        this.icmlistapresupuestoswloc = value;
    }

    /**
     * Obtiene el valor de la propiedad icmlistapresupuestosrango.
     *
     * @return
     *     possible object is
     *     {@link IcmListapresupuestosrangoBlock }
     *
     */
    public IcmListapresupuestosrangoBlock getICMLISTAPRESUPUESTOSRANGO() {
        return icmlistapresupuestosrango;
    }

    /**
     * Define el valor de la propiedad icmlistapresupuestosrango.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListapresupuestosrangoBlock }
     *
     */
    public void setICMLISTAPRESUPUESTOSRANGO(IcmListapresupuestosrangoBlock value) {
        this.icmlistapresupuestosrango = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalconfpreciohora.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalconfpreciohoraBlock }
     *
     */
    public IcmParamcalconfpreciohoraBlock getICMPARAMCALCONFPRECIOHORA() {
        return icmparamcalconfpreciohora;
    }

    /**
     * Define el valor de la propiedad icmparamcalconfpreciohora.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalconfpreciohoraBlock }
     *
     */
    public void setICMPARAMCALCONFPRECIOHORA(IcmParamcalconfpreciohoraBlock value) {
        this.icmparamcalconfpreciohora = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalventacongelada.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalventacongeladaBlock }
     *
     */
    public IcmParamcalventacongeladaBlock getICMPARAMCALVENTACONGELADA() {
        return icmparamcalventacongelada;
    }

    /**
     * Define el valor de la propiedad icmparamcalventacongelada.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalventacongeladaBlock }
     *
     */
    public void setICMPARAMCALVENTACONGELADA(IcmParamcalventacongeladaBlock value) {
        this.icmparamcalventacongelada = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalpresenciamanual.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalpresenciamanualBlock }
     *
     */
    public IcmParamcalpresenciamanualBlock getICMPARAMCALPRESENCIAMANUAL() {
        return icmparamcalpresenciamanual;
    }

    /**
     * Define el valor de la propiedad icmparamcalpresenciamanual.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalpresenciamanualBlock }
     *
     */
    public void setICMPARAMCALPRESENCIAMANUAL(IcmParamcalpresenciamanualBlock value) {
        this.icmparamcalpresenciamanual = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalempleadosdesplaz.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalempleadosdesplazBlock }
     *
     */
    public IcmParamcalempleadosdesplazBlock getICMPARAMCALEMPLEADOSDESPLAZ() {
        return icmparamcalempleadosdesplaz;
    }

    /**
     * Define el valor de la propiedad icmparamcalempleadosdesplaz.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalempleadosdesplazBlock }
     *
     */
    public void setICMPARAMCALEMPLEADOSDESPLAZ(IcmParamcalempleadosdesplazBlock value) {
        this.icmparamcalempleadosdesplaz = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalpresupuestoswloc.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalpresupuestoswlocBlock }
     *
     */
    public IcmParamcalpresupuestoswlocBlock getICMPARAMCALPRESUPUESTOSWLOC() {
        return icmparamcalpresupuestoswloc;
    }

    /**
     * Define el valor de la propiedad icmparamcalpresupuestoswloc.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalpresupuestoswlocBlock }
     *
     */
    public void setICMPARAMCALPRESUPUESTOSWLOC(IcmParamcalpresupuestoswlocBlock value) {
        this.icmparamcalpresupuestoswloc = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalpresupuestosrango.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalpresupuestosrangoBlock }
     *
     */
    public IcmParamcalpresupuestosrangoBlock getICMPARAMCALPRESUPUESTOSRANGO() {
        return icmparamcalpresupuestosrango;
    }

    /**
     * Define el valor de la propiedad icmparamcalpresupuestosrango.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalpresupuestosrangoBlock }
     *
     */
    public void setICMPARAMCALPRESUPUESTOSRANGO(IcmParamcalpresupuestosrangoBlock value) {
        this.icmparamcalpresupuestosrango = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparamcalempleadospresencia.
     *
     * @return
     *     possible object is
     *     {@link IcmParamcalempleadospresenciaBlock }
     *
     */
    public IcmParamcalempleadospresenciaBlock getICMPARAMCALEMPLEADOSPRESENCIA() {
        return icmparamcalempleadospresencia;
    }

    /**
     * Define el valor de la propiedad icmparamcalempleadospresencia.
     *
     * @param value
     *     allowed object is
     *     {@link IcmParamcalempleadospresenciaBlock }
     *
     */
    public void setICMPARAMCALEMPLEADOSPRESENCIA(IcmParamcalempleadospresenciaBlock value) {
        this.icmparamcalempleadospresencia = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final M4LoadObject that = ((M4LoadObject) object);
        {
            IcmWsToolsBlock lhsICMWSTOOLS;
            lhsICMWSTOOLS = this.getICMWSTOOLS();
            IcmWsToolsBlock rhsICMWSTOOLS;
            rhsICMWSTOOLS = that.getICMWSTOOLS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmwstools", lhsICMWSTOOLS), LocatorUtils.property(thatLocator, "icmwstools", rhsICMWSTOOLS), lhsICMWSTOOLS, rhsICMWSTOOLS, (this.icmwstools!= null), (that.icmwstools!= null))) {
                return false;
            }
        }
        {
            IcmListamailBlock lhsICMLISTAMAIL;
            lhsICMLISTAMAIL = this.getICMLISTAMAIL();
            IcmListamailBlock rhsICMLISTAMAIL;
            rhsICMLISTAMAIL = that.getICMLISTAMAIL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistamail", lhsICMLISTAMAIL), LocatorUtils.property(thatLocator, "icmlistamail", rhsICMLISTAMAIL), lhsICMLISTAMAIL, rhsICMLISTAMAIL, (this.icmlistamail!= null), (that.icmlistamail!= null))) {
                return false;
            }
        }
        {
            IcmListaclasesBlock lhsICMLISTACLASES;
            lhsICMLISTACLASES = this.getICMLISTACLASES();
            IcmListaclasesBlock rhsICMLISTACLASES;
            rhsICMLISTACLASES = that.getICMLISTACLASES();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaclases", lhsICMLISTACLASES), LocatorUtils.property(thatLocator, "icmlistaclases", rhsICMLISTACLASES), lhsICMLISTACLASES, rhsICMLISTACLASES, (this.icmlistaclases!= null), (that.icmlistaclases!= null))) {
                return false;
            }
        }
        {
            IcmListasincroBlock lhsICMLISTASINCRO;
            lhsICMLISTASINCRO = this.getICMLISTASINCRO();
            IcmListasincroBlock rhsICMLISTASINCRO;
            rhsICMLISTASINCRO = that.getICMLISTASINCRO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistasincro", lhsICMLISTASINCRO), LocatorUtils.property(thatLocator, "icmlistasincro", rhsICMLISTASINCRO), lhsICMLISTASINCRO, rhsICMLISTASINCRO, (this.icmlistasincro!= null), (that.icmlistasincro!= null))) {
                return false;
            }
        }
        {
            IcmListacadenasBlock lhsICMLISTACADENAS;
            lhsICMLISTACADENAS = this.getICMLISTACADENAS();
            IcmListacadenasBlock rhsICMLISTACADENAS;
            rhsICMLISTACADENAS = that.getICMLISTACADENAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistacadenas", lhsICMLISTACADENAS), LocatorUtils.property(thatLocator, "icmlistacadenas", rhsICMLISTACADENAS), lhsICMLISTACADENAS, rhsICMLISTACADENAS, (this.icmlistacadenas!= null), (that.icmlistacadenas!= null))) {
                return false;
            }
        }
        {
            IcmListamotivosBlock lhsICMLISTAMOTIVOS;
            lhsICMLISTAMOTIVOS = this.getICMLISTAMOTIVOS();
            IcmListamotivosBlock rhsICMLISTAMOTIVOS;
            rhsICMLISTAMOTIVOS = that.getICMLISTAMOTIVOS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistamotivos", lhsICMLISTAMOTIVOS), LocatorUtils.property(thatLocator, "icmlistamotivos", rhsICMLISTAMOTIVOS), lhsICMLISTAMOTIVOS, rhsICMLISTAMOTIVOS, (this.icmlistamotivos!= null), (that.icmlistamotivos!= null))) {
                return false;
            }
        }
        {
            IcmListatiendasBlock lhsICMLISTATIENDAS;
            lhsICMLISTATIENDAS = this.getICMLISTATIENDAS();
            IcmListatiendasBlock rhsICMLISTATIENDAS;
            rhsICMLISTATIENDAS = that.getICMLISTATIENDAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistatiendas", lhsICMLISTATIENDAS), LocatorUtils.property(thatLocator, "icmlistatiendas", rhsICMLISTATIENDAS), lhsICMLISTATIENDAS, rhsICMLISTATIENDAS, (this.icmlistatiendas!= null), (that.icmlistatiendas!= null))) {
                return false;
            }
        }
        {
            IcmListacatalogoBlock lhsICMLISTACATALOGO;
            lhsICMLISTACATALOGO = this.getICMLISTACATALOGO();
            IcmListacatalogoBlock rhsICMLISTACATALOGO;
            rhsICMLISTACATALOGO = that.getICMLISTACATALOGO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistacatalogo", lhsICMLISTACATALOGO), LocatorUtils.property(thatLocator, "icmlistacatalogo", rhsICMLISTACATALOGO), lhsICMLISTACATALOGO, rhsICMLISTACATALOGO, (this.icmlistacatalogo!= null), (that.icmlistacatalogo!= null))) {
                return false;
            }
        }
        {
            IcmListaempleadoBlock lhsICMLISTAEMPLEADO;
            lhsICMLISTAEMPLEADO = this.getICMLISTAEMPLEADO();
            IcmListaempleadoBlock rhsICMLISTAEMPLEADO;
            rhsICMLISTAEMPLEADO = that.getICMLISTAEMPLEADO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaempleado", lhsICMLISTAEMPLEADO), LocatorUtils.property(thatLocator, "icmlistaempleado", rhsICMLISTAEMPLEADO), lhsICMLISTAEMPLEADO, rhsICMLISTAEMPLEADO, (this.icmlistaempleado!= null), (that.icmlistaempleado!= null))) {
                return false;
            }
        }
        {
            IcmListaempresasBlock lhsICMLISTAEMPRESAS;
            lhsICMLISTAEMPRESAS = this.getICMLISTAEMPRESAS();
            IcmListaempresasBlock rhsICMLISTAEMPRESAS;
            rhsICMLISTAEMPRESAS = that.getICMLISTAEMPRESAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaempresas", lhsICMLISTAEMPRESAS), LocatorUtils.property(thatLocator, "icmlistaempresas", rhsICMLISTAEMPRESAS), lhsICMLISTAEMPRESAS, rhsICMLISTAEMPRESAS, (this.icmlistaempresas!= null), (that.icmlistaempresas!= null))) {
                return false;
            }
        }
        {
            IcmListaorigenesBlock lhsICMLISTAORIGENES;
            lhsICMLISTAORIGENES = this.getICMLISTAORIGENES();
            IcmListaorigenesBlock rhsICMLISTAORIGENES;
            rhsICMLISTAORIGENES = that.getICMLISTAORIGENES();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaorigenes", lhsICMLISTAORIGENES), LocatorUtils.property(thatLocator, "icmlistaorigenes", rhsICMLISTAORIGENES), lhsICMLISTAORIGENES, rhsICMLISTAORIGENES, (this.icmlistaorigenes!= null), (that.icmlistaorigenes!= null))) {
                return false;
            }
        }
        {
            IcmListaperiodosBlock lhsICMLISTAPERIODOS;
            lhsICMLISTAPERIODOS = this.getICMLISTAPERIODOS();
            IcmListaperiodosBlock rhsICMLISTAPERIODOS;
            rhsICMLISTAPERIODOS = that.getICMLISTAPERIODOS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaperiodos", lhsICMLISTAPERIODOS), LocatorUtils.property(thatLocator, "icmlistaperiodos", rhsICMLISTAPERIODOS), lhsICMLISTAPERIODOS, rhsICMLISTAPERIODOS, (this.icmlistaperiodos!= null), (that.icmlistaperiodos!= null))) {
                return false;
            }
        }
        {
            IcmListaausenciasBlock lhsICMLISTAAUSENCIAS;
            lhsICMLISTAAUSENCIAS = this.getICMLISTAAUSENCIAS();
            IcmListaausenciasBlock rhsICMLISTAAUSENCIAS;
            rhsICMLISTAAUSENCIAS = that.getICMLISTAAUSENCIAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaausencias", lhsICMLISTAAUSENCIAS), LocatorUtils.property(thatLocator, "icmlistaausencias", rhsICMLISTAAUSENCIAS), lhsICMLISTAAUSENCIAS, rhsICMLISTAAUSENCIAS, (this.icmlistaausencias!= null), (that.icmlistaausencias!= null))) {
                return false;
            }
        }
        {
            IcmListaempleadosBlock lhsICMLISTAEMPLEADOS;
            lhsICMLISTAEMPLEADOS = this.getICMLISTAEMPLEADOS();
            IcmListaempleadosBlock rhsICMLISTAEMPLEADOS;
            rhsICMLISTAEMPLEADOS = that.getICMLISTAEMPLEADOS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaempleados", lhsICMLISTAEMPLEADOS), LocatorUtils.property(thatLocator, "icmlistaempleados", rhsICMLISTAEMPLEADOS), lhsICMLISTAEMPLEADOS, rhsICMLISTAEMPLEADOS, (this.icmlistaempleados!= null), (that.icmlistaempleados!= null))) {
                return false;
            }
        }
        {
            IcmListapoliticasBlock lhsICMLISTAPOLITICAS;
            lhsICMLISTAPOLITICAS = this.getICMLISTAPOLITICAS();
            IcmListapoliticasBlock rhsICMLISTAPOLITICAS;
            rhsICMLISTAPOLITICAS = that.getICMLISTAPOLITICAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistapoliticas", lhsICMLISTAPOLITICAS), LocatorUtils.property(thatLocator, "icmlistapoliticas", rhsICMLISTAPOLITICAS), lhsICMLISTAPOLITICAS, rhsICMLISTAPOLITICAS, (this.icmlistapoliticas!= null), (that.icmlistapoliticas!= null))) {
                return false;
            }
        }
        {
            IcmListatiposhoraBlock lhsICMLISTATIPOSHORA;
            lhsICMLISTATIPOSHORA = this.getICMLISTATIPOSHORA();
            IcmListatiposhoraBlock rhsICMLISTATIPOSHORA;
            rhsICMLISTATIPOSHORA = that.getICMLISTATIPOSHORA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistatiposhora", lhsICMLISTATIPOSHORA), LocatorUtils.property(thatLocator, "icmlistatiposhora", rhsICMLISTATIPOSHORA), lhsICMLISTATIPOSHORA, rhsICMLISTATIPOSHORA, (this.icmlistatiposhora!= null), (that.icmlistatiposhora!= null))) {
                return false;
            }
        }
        {
            IcmParamcalcadenaBlock lhsICMPARAMCALCADENA;
            lhsICMPARAMCALCADENA = this.getICMPARAMCALCADENA();
            IcmParamcalcadenaBlock rhsICMPARAMCALCADENA;
            rhsICMPARAMCALCADENA = that.getICMPARAMCALCADENA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalcadena", lhsICMPARAMCALCADENA), LocatorUtils.property(thatLocator, "icmparamcalcadena", rhsICMPARAMCALCADENA), lhsICMPARAMCALCADENA, rhsICMPARAMCALCADENA, (this.icmparamcalcadena!= null), (that.icmparamcalcadena!= null))) {
                return false;
            }
        }
        {
            IcmParamcalorigenBlock lhsICMPARAMCALORIGEN;
            lhsICMPARAMCALORIGEN = this.getICMPARAMCALORIGEN();
            IcmParamcalorigenBlock rhsICMPARAMCALORIGEN;
            rhsICMPARAMCALORIGEN = that.getICMPARAMCALORIGEN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalorigen", lhsICMPARAMCALORIGEN), LocatorUtils.property(thatLocator, "icmparamcalorigen", rhsICMPARAMCALORIGEN), lhsICMPARAMCALORIGEN, rhsICMPARAMCALORIGEN, (this.icmparamcalorigen!= null), (that.icmparamcalorigen!= null))) {
                return false;
            }
        }
        {
            IcmParamcalsincroBlock lhsICMPARAMCALSINCRO;
            lhsICMPARAMCALSINCRO = this.getICMPARAMCALSINCRO();
            IcmParamcalsincroBlock rhsICMPARAMCALSINCRO;
            rhsICMPARAMCALSINCRO = that.getICMPARAMCALSINCRO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalsincro", lhsICMPARAMCALSINCRO), LocatorUtils.property(thatLocator, "icmparamcalsincro", rhsICMPARAMCALSINCRO), lhsICMPARAMCALSINCRO, rhsICMPARAMCALSINCRO, (this.icmparamcalsincro!= null), (that.icmparamcalsincro!= null))) {
                return false;
            }
        }
        {
            IcmListaconfchdiasBlock lhsICMLISTACONFCHDIAS;
            lhsICMLISTACONFCHDIAS = this.getICMLISTACONFCHDIAS();
            IcmListaconfchdiasBlock rhsICMLISTACONFCHDIAS;
            rhsICMLISTACONFCHDIAS = that.getICMLISTACONFCHDIAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaconfchdias", lhsICMLISTACONFCHDIAS), LocatorUtils.property(thatLocator, "icmlistaconfchdias", rhsICMLISTACONFCHDIAS), lhsICMLISTACONFCHDIAS, rhsICMLISTACONFCHDIAS, (this.icmlistaconfchdias!= null), (that.icmlistaconfchdias!= null))) {
                return false;
            }
        }
        {
            IcmListaconforigenBlock lhsICMLISTACONFORIGEN;
            lhsICMLISTACONFORIGEN = this.getICMLISTACONFORIGEN();
            IcmListaconforigenBlock rhsICMLISTACONFORIGEN;
            rhsICMLISTACONFORIGEN = that.getICMLISTACONFORIGEN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaconforigen", lhsICMLISTACONFORIGEN), LocatorUtils.property(thatLocator, "icmlistaconforigen", rhsICMLISTACONFORIGEN), lhsICMLISTACONFORIGEN, rhsICMLISTACONFORIGEN, (this.icmlistaconforigen!= null), (that.icmlistaconforigen!= null))) {
                return false;
            }
        }
        {
            IcmListaestructuraBlock lhsICMLISTAESTRUCTURA;
            lhsICMLISTAESTRUCTURA = this.getICMLISTAESTRUCTURA();
            IcmListaestructuraBlock rhsICMLISTAESTRUCTURA;
            rhsICMLISTAESTRUCTURA = that.getICMLISTAESTRUCTURA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaestructura", lhsICMLISTAESTRUCTURA), LocatorUtils.property(thatLocator, "icmlistaestructura", rhsICMLISTAESTRUCTURA), lhsICMLISTAESTRUCTURA, rhsICMLISTAESTRUCTURA, (this.icmlistaestructura!= null), (that.icmlistaestructura!= null))) {
                return false;
            }
        }
        {
            IcmParamcalmotivosBlock lhsICMPARAMCALMOTIVOS;
            lhsICMPARAMCALMOTIVOS = this.getICMPARAMCALMOTIVOS();
            IcmParamcalmotivosBlock rhsICMPARAMCALMOTIVOS;
            rhsICMPARAMCALMOTIVOS = that.getICMPARAMCALMOTIVOS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalmotivos", lhsICMPARAMCALMOTIVOS), LocatorUtils.property(thatLocator, "icmparamcalmotivos", rhsICMPARAMCALMOTIVOS), lhsICMPARAMCALMOTIVOS, rhsICMPARAMCALMOTIVOS, (this.icmparamcalmotivos!= null), (that.icmparamcalmotivos!= null))) {
                return false;
            }
        }
        {
            IcmParamcalperiodoBlock lhsICMPARAMCALPERIODO;
            lhsICMPARAMCALPERIODO = this.getICMPARAMCALPERIODO();
            IcmParamcalperiodoBlock rhsICMPARAMCALPERIODO;
            rhsICMPARAMCALPERIODO = that.getICMPARAMCALPERIODO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalperiodo", lhsICMPARAMCALPERIODO), LocatorUtils.property(thatLocator, "icmparamcalperiodo", rhsICMPARAMCALPERIODO), lhsICMPARAMCALPERIODO, rhsICMPARAMCALPERIODO, (this.icmparamcalperiodo!= null), (that.icmparamcalperiodo!= null))) {
                return false;
            }
        }
        {
            IcmParamcalprocesoBlock lhsICMPARAMCALPROCESO;
            lhsICMPARAMCALPROCESO = this.getICMPARAMCALPROCESO();
            IcmParamcalprocesoBlock rhsICMPARAMCALPROCESO;
            rhsICMPARAMCALPROCESO = that.getICMPARAMCALPROCESO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalproceso", lhsICMPARAMCALPROCESO), LocatorUtils.property(thatLocator, "icmparamcalproceso", rhsICMPARAMCALPROCESO), lhsICMPARAMCALPROCESO, rhsICMPARAMCALPROCESO, (this.icmparamcalproceso!= null), (that.icmparamcalproceso!= null))) {
                return false;
            }
        }
        {
            IcmParamcaltiendasBlock lhsICMPARAMCALTIENDAS;
            lhsICMPARAMCALTIENDAS = this.getICMPARAMCALTIENDAS();
            IcmParamcaltiendasBlock rhsICMPARAMCALTIENDAS;
            rhsICMPARAMCALTIENDAS = that.getICMPARAMCALTIENDAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcaltiendas", lhsICMPARAMCALTIENDAS), LocatorUtils.property(thatLocator, "icmparamcaltiendas", rhsICMPARAMCALTIENDAS), lhsICMPARAMCALTIENDAS, rhsICMPARAMCALTIENDAS, (this.icmparamcaltiendas!= null), (that.icmparamcaltiendas!= null))) {
                return false;
            }
        }
        {
            IcmParamcalusuarioBlock lhsICMPARAMCALUSUARIO;
            lhsICMPARAMCALUSUARIO = this.getICMPARAMCALUSUARIO();
            IcmParamcalusuarioBlock rhsICMPARAMCALUSUARIO;
            rhsICMPARAMCALUSUARIO = that.getICMPARAMCALUSUARIO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalusuario", lhsICMPARAMCALUSUARIO), LocatorUtils.property(thatLocator, "icmparamcalusuario", rhsICMPARAMCALUSUARIO), lhsICMPARAMCALUSUARIO, rhsICMPARAMCALUSUARIO, (this.icmparamcalusuario!= null), (that.icmparamcalusuario!= null))) {
                return false;
            }
        }
        {
            IcmListaconfchventaBlock lhsICMLISTACONFCHVENTA;
            lhsICMLISTACONFCHVENTA = this.getICMLISTACONFCHVENTA();
            IcmListaconfchventaBlock rhsICMLISTACONFCHVENTA;
            rhsICMLISTACONFCHVENTA = that.getICMLISTACONFCHVENTA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaconfchventa", lhsICMLISTACONFCHVENTA), LocatorUtils.property(thatLocator, "icmlistaconfchventa", rhsICMLISTACONFCHVENTA), lhsICMLISTACONFCHVENTA, rhsICMLISTACONFCHVENTA, (this.icmlistaconfchventa!= null), (that.icmlistaconfchventa!= null))) {
                return false;
            }
        }
        {
            IcmListadesplazrealBlock lhsICMLISTADESPLAZREAL;
            lhsICMLISTADESPLAZREAL = this.getICMLISTADESPLAZREAL();
            IcmListadesplazrealBlock rhsICMLISTADESPLAZREAL;
            rhsICMLISTADESPLAZREAL = that.getICMLISTADESPLAZREAL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistadesplazreal", lhsICMLISTADESPLAZREAL), LocatorUtils.property(thatLocator, "icmlistadesplazreal", rhsICMLISTADESPLAZREAL), lhsICMLISTADESPLAZREAL, rhsICMLISTADESPLAZREAL, (this.icmlistadesplazreal!= null), (that.icmlistadesplazreal!= null))) {
                return false;
            }
        }
        {
            IcmListasistdestinoBlock lhsICMLISTASISTDESTINO;
            lhsICMLISTASISTDESTINO = this.getICMLISTASISTDESTINO();
            IcmListasistdestinoBlock rhsICMLISTASISTDESTINO;
            rhsICMLISTASISTDESTINO = that.getICMLISTASISTDESTINO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistasistdestino", lhsICMLISTASISTDESTINO), LocatorUtils.property(thatLocator, "icmlistasistdestino", rhsICMLISTASISTDESTINO), lhsICMLISTASISTDESTINO, rhsICMLISTASISTDESTINO, (this.icmlistasistdestino!= null), (that.icmlistasistdestino!= null))) {
                return false;
            }
        }
        {
            IcmParamcalcatalogoBlock lhsICMPARAMCALCATALOGO;
            lhsICMPARAMCALCATALOGO = this.getICMPARAMCALCATALOGO();
            IcmParamcalcatalogoBlock rhsICMPARAMCALCATALOGO;
            rhsICMPARAMCALCATALOGO = that.getICMPARAMCALCATALOGO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalcatalogo", lhsICMPARAMCALCATALOGO), LocatorUtils.property(thatLocator, "icmparamcalcatalogo", rhsICMPARAMCALCATALOGO), lhsICMPARAMCALCATALOGO, rhsICMPARAMCALCATALOGO, (this.icmparamcalcatalogo!= null), (that.icmparamcalcatalogo!= null))) {
                return false;
            }
        }
        {
            IcmParamcalempleadoBlock lhsICMPARAMCALEMPLEADO;
            lhsICMPARAMCALEMPLEADO = this.getICMPARAMCALEMPLEADO();
            IcmParamcalempleadoBlock rhsICMPARAMCALEMPLEADO;
            rhsICMPARAMCALEMPLEADO = that.getICMPARAMCALEMPLEADO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalempleado", lhsICMPARAMCALEMPLEADO), LocatorUtils.property(thatLocator, "icmparamcalempleado", rhsICMPARAMCALEMPLEADO), lhsICMPARAMCALEMPLEADO, rhsICMPARAMCALEMPLEADO, (this.icmparamcalempleado!= null), (that.icmparamcalempleado!= null))) {
                return false;
            }
        }
        {
            IcmParamcalsociedadBlock lhsICMPARAMCALSOCIEDAD;
            lhsICMPARAMCALSOCIEDAD = this.getICMPARAMCALSOCIEDAD();
            IcmParamcalsociedadBlock rhsICMPARAMCALSOCIEDAD;
            rhsICMPARAMCALSOCIEDAD = that.getICMPARAMCALSOCIEDAD();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalsociedad", lhsICMPARAMCALSOCIEDAD), LocatorUtils.property(thatLocator, "icmparamcalsociedad", rhsICMPARAMCALSOCIEDAD), lhsICMPARAMCALSOCIEDAD, rhsICMPARAMCALSOCIEDAD, (this.icmparamcalsociedad!= null), (that.icmparamcalsociedad!= null))) {
                return false;
            }
        }
        {
            IcmListamultiempresaBlock lhsICMLISTAMULTIEMPRESA;
            lhsICMLISTAMULTIEMPRESA = this.getICMLISTAMULTIEMPRESA();
            IcmListamultiempresaBlock rhsICMLISTAMULTIEMPRESA;
            rhsICMLISTAMULTIEMPRESA = that.getICMLISTAMULTIEMPRESA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistamultiempresa", lhsICMLISTAMULTIEMPRESA), LocatorUtils.property(thatLocator, "icmlistamultiempresa", rhsICMLISTAMULTIEMPRESA), lhsICMLISTAMULTIEMPRESA, rhsICMLISTAMULTIEMPRESA, (this.icmlistamultiempresa!= null), (that.icmlistamultiempresa!= null))) {
                return false;
            }
        }
        {
            IcmListaventamanwlocBlock lhsICMLISTAVENTAMANWLOC;
            lhsICMLISTAVENTAMANWLOC = this.getICMLISTAVENTAMANWLOC();
            IcmListaventamanwlocBlock rhsICMLISTAVENTAMANWLOC;
            rhsICMLISTAVENTAMANWLOC = that.getICMLISTAVENTAMANWLOC();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaventamanwloc", lhsICMLISTAVENTAMANWLOC), LocatorUtils.property(thatLocator, "icmlistaventamanwloc", rhsICMLISTAVENTAMANWLOC), lhsICMLISTAVENTAMANWLOC, rhsICMLISTAVENTAMANWLOC, (this.icmlistaventamanwloc!= null), (that.icmlistaventamanwloc!= null))) {
                return false;
            }
        }
        {
            IcmParamcalempleadosBlock lhsICMPARAMCALEMPLEADOS;
            lhsICMPARAMCALEMPLEADOS = this.getICMPARAMCALEMPLEADOS();
            IcmParamcalempleadosBlock rhsICMPARAMCALEMPLEADOS;
            rhsICMPARAMCALEMPLEADOS = that.getICMPARAMCALEMPLEADOS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalempleados", lhsICMPARAMCALEMPLEADOS), LocatorUtils.property(thatLocator, "icmparamcalempleados", rhsICMPARAMCALEMPLEADOS), lhsICMPARAMCALEMPLEADOS, rhsICMPARAMCALEMPLEADOS, (this.icmparamcalempleados!= null), (that.icmparamcalempleados!= null))) {
                return false;
            }
        }
        {
            IcmParamcaltiposhoraBlock lhsICMPARAMCALTIPOSHORA;
            lhsICMPARAMCALTIPOSHORA = this.getICMPARAMCALTIPOSHORA();
            IcmParamcaltiposhoraBlock rhsICMPARAMCALTIPOSHORA;
            rhsICMPARAMCALTIPOSHORA = that.getICMPARAMCALTIPOSHORA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcaltiposhora", lhsICMPARAMCALTIPOSHORA), LocatorUtils.property(thatLocator, "icmparamcaltiposhora", rhsICMPARAMCALTIPOSHORA), lhsICMPARAMCALTIPOSHORA, rhsICMPARAMCALTIPOSHORA, (this.icmparamcaltiposhora!= null), (that.icmparamcaltiposhora!= null))) {
                return false;
            }
        }
        {
            IcmParametrosentradaBlock lhsICMPARAMETROSENTRADA;
            lhsICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            IcmParametrosentradaBlock rhsICMPARAMETROSENTRADA;
            rhsICMPARAMETROSENTRADA = that.getICMPARAMETROSENTRADA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrosentrada", lhsICMPARAMETROSENTRADA), LocatorUtils.property(thatLocator, "icmparametrosentrada", rhsICMPARAMETROSENTRADA), lhsICMPARAMETROSENTRADA, rhsICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null), (that.icmparametrosentrada!= null))) {
                return false;
            }
        }
        {
            IcmResultadoguardadoBlock lhsICMRESULTADOGUARDADO;
            lhsICMRESULTADOGUARDADO = this.getICMRESULTADOGUARDADO();
            IcmResultadoguardadoBlock rhsICMRESULTADOGUARDADO;
            rhsICMRESULTADOGUARDADO = that.getICMRESULTADOGUARDADO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmresultadoguardado", lhsICMRESULTADOGUARDADO), LocatorUtils.property(thatLocator, "icmresultadoguardado", rhsICMRESULTADOGUARDADO), lhsICMRESULTADOGUARDADO, rhsICMRESULTADOGUARDADO, (this.icmresultadoguardado!= null), (that.icmresultadoguardado!= null))) {
                return false;
            }
        }
        {
            IcmListaconfiguracionBlock lhsICMLISTACONFIGURACION;
            lhsICMLISTACONFIGURACION = this.getICMLISTACONFIGURACION();
            IcmListaconfiguracionBlock rhsICMLISTACONFIGURACION;
            rhsICMLISTACONFIGURACION = that.getICMLISTACONFIGURACION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaconfiguracion", lhsICMLISTACONFIGURACION), LocatorUtils.property(thatLocator, "icmlistaconfiguracion", rhsICMLISTACONFIGURACION), lhsICMLISTACONFIGURACION, rhsICMLISTACONFIGURACION, (this.icmlistaconfiguracion!= null), (that.icmlistaconfiguracion!= null))) {
                return false;
            }
        }
        {
            IcmParamcalconfchdiasBlock lhsICMPARAMCALCONFCHDIAS;
            lhsICMPARAMCALCONFCHDIAS = this.getICMPARAMCALCONFCHDIAS();
            IcmParamcalconfchdiasBlock rhsICMPARAMCALCONFCHDIAS;
            rhsICMPARAMCALCONFCHDIAS = that.getICMPARAMCALCONFCHDIAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalconfchdias", lhsICMPARAMCALCONFCHDIAS), LocatorUtils.property(thatLocator, "icmparamcalconfchdias", rhsICMPARAMCALCONFCHDIAS), lhsICMPARAMCALCONFCHDIAS, rhsICMPARAMCALCONFCHDIAS, (this.icmparamcalconfchdias!= null), (that.icmparamcalconfchdias!= null))) {
                return false;
            }
        }
        {
            IcmParamcalconforigenBlock lhsICMPARAMCALCONFORIGEN;
            lhsICMPARAMCALCONFORIGEN = this.getICMPARAMCALCONFORIGEN();
            IcmParamcalconforigenBlock rhsICMPARAMCALCONFORIGEN;
            rhsICMPARAMCALCONFORIGEN = that.getICMPARAMCALCONFORIGEN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalconforigen", lhsICMPARAMCALCONFORIGEN), LocatorUtils.property(thatLocator, "icmparamcalconforigen", rhsICMPARAMCALCONFORIGEN), lhsICMPARAMCALCONFORIGEN, rhsICMPARAMCALCONFORIGEN, (this.icmparamcalconforigen!= null), (that.icmparamcalconforigen!= null))) {
                return false;
            }
        }
        {
            IcmParamcalestructuraBlock lhsICMPARAMCALESTRUCTURA;
            lhsICMPARAMCALESTRUCTURA = this.getICMPARAMCALESTRUCTURA();
            IcmParamcalestructuraBlock rhsICMPARAMCALESTRUCTURA;
            rhsICMPARAMCALESTRUCTURA = that.getICMPARAMCALESTRUCTURA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalestructura", lhsICMPARAMCALESTRUCTURA), LocatorUtils.property(thatLocator, "icmparamcalestructura", rhsICMPARAMCALESTRUCTURA), lhsICMPARAMCALESTRUCTURA, rhsICMPARAMCALESTRUCTURA, (this.icmparamcalestructura!= null), (that.icmparamcalestructura!= null))) {
                return false;
            }
        }
        {
            IcmListaconfpreciohoraBlock lhsICMLISTACONFPRECIOHORA;
            lhsICMLISTACONFPRECIOHORA = this.getICMLISTACONFPRECIOHORA();
            IcmListaconfpreciohoraBlock rhsICMLISTACONFPRECIOHORA;
            rhsICMLISTACONFPRECIOHORA = that.getICMLISTACONFPRECIOHORA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaconfpreciohora", lhsICMLISTACONFPRECIOHORA), LocatorUtils.property(thatLocator, "icmlistaconfpreciohora", rhsICMLISTACONFPRECIOHORA), lhsICMLISTACONFPRECIOHORA, rhsICMLISTACONFPRECIOHORA, (this.icmlistaconfpreciohora!= null), (that.icmlistaconfpreciohora!= null))) {
                return false;
            }
        }
        {
            IcmListaventacongeladaBlock lhsICMLISTAVENTACONGELADA;
            lhsICMLISTAVENTACONGELADA = this.getICMLISTAVENTACONGELADA();
            IcmListaventacongeladaBlock rhsICMLISTAVENTACONGELADA;
            rhsICMLISTAVENTACONGELADA = that.getICMLISTAVENTACONGELADA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaventacongelada", lhsICMLISTAVENTACONGELADA), LocatorUtils.property(thatLocator, "icmlistaventacongelada", rhsICMLISTAVENTACONGELADA), lhsICMLISTAVENTACONGELADA, rhsICMLISTAVENTACONGELADA, (this.icmlistaventacongelada!= null), (that.icmlistaventacongelada!= null))) {
                return false;
            }
        }
        {
            IcmParamcalconfchventaBlock lhsICMPARAMCALCONFCHVENTA;
            lhsICMPARAMCALCONFCHVENTA = this.getICMPARAMCALCONFCHVENTA();
            IcmParamcalconfchventaBlock rhsICMPARAMCALCONFCHVENTA;
            rhsICMPARAMCALCONFCHVENTA = that.getICMPARAMCALCONFCHVENTA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalconfchventa", lhsICMPARAMCALCONFCHVENTA), LocatorUtils.property(thatLocator, "icmparamcalconfchventa", rhsICMPARAMCALCONFCHVENTA), lhsICMPARAMCALCONFCHVENTA, rhsICMPARAMCALCONFCHVENTA, (this.icmparamcalconfchventa!= null), (that.icmparamcalconfchventa!= null))) {
                return false;
            }
        }
        {
            IcmParamcaldesplazrealBlock lhsICMPARAMCALDESPLAZREAL;
            lhsICMPARAMCALDESPLAZREAL = this.getICMPARAMCALDESPLAZREAL();
            IcmParamcaldesplazrealBlock rhsICMPARAMCALDESPLAZREAL;
            rhsICMPARAMCALDESPLAZREAL = that.getICMPARAMCALDESPLAZREAL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcaldesplazreal", lhsICMPARAMCALDESPLAZREAL), LocatorUtils.property(thatLocator, "icmparamcaldesplazreal", rhsICMPARAMCALDESPLAZREAL), lhsICMPARAMCALDESPLAZREAL, rhsICMPARAMCALDESPLAZREAL, (this.icmparamcaldesplazreal!= null), (that.icmparamcaldesplazreal!= null))) {
                return false;
            }
        }
        {
            IcmParamcalflagcalculaBlock lhsICMPARAMCALFLAGCALCULA;
            lhsICMPARAMCALFLAGCALCULA = this.getICMPARAMCALFLAGCALCULA();
            IcmParamcalflagcalculaBlock rhsICMPARAMCALFLAGCALCULA;
            rhsICMPARAMCALFLAGCALCULA = that.getICMPARAMCALFLAGCALCULA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalflagcalcula", lhsICMPARAMCALFLAGCALCULA), LocatorUtils.property(thatLocator, "icmparamcalflagcalcula", rhsICMPARAMCALFLAGCALCULA), lhsICMPARAMCALFLAGCALCULA, rhsICMPARAMCALFLAGCALCULA, (this.icmparamcalflagcalcula!= null), (that.icmparamcalflagcalcula!= null))) {
                return false;
            }
        }
        {
            IcmParamcalliquidacionBlock lhsICMPARAMCALLIQUIDACION;
            lhsICMPARAMCALLIQUIDACION = this.getICMPARAMCALLIQUIDACION();
            IcmParamcalliquidacionBlock rhsICMPARAMCALLIQUIDACION;
            rhsICMPARAMCALLIQUIDACION = that.getICMPARAMCALLIQUIDACION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalliquidacion", lhsICMPARAMCALLIQUIDACION), LocatorUtils.property(thatLocator, "icmparamcalliquidacion", rhsICMPARAMCALLIQUIDACION), lhsICMPARAMCALLIQUIDACION, rhsICMPARAMCALLIQUIDACION, (this.icmparamcalliquidacion!= null), (that.icmparamcalliquidacion!= null))) {
                return false;
            }
        }
        {
            IcmParamcalsistdestinoBlock lhsICMPARAMCALSISTDESTINO;
            lhsICMPARAMCALSISTDESTINO = this.getICMPARAMCALSISTDESTINO();
            IcmParamcalsistdestinoBlock rhsICMPARAMCALSISTDESTINO;
            rhsICMPARAMCALSISTDESTINO = that.getICMPARAMCALSISTDESTINO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalsistdestino", lhsICMPARAMCALSISTDESTINO), LocatorUtils.property(thatLocator, "icmparamcalsistdestino", rhsICMPARAMCALSISTDESTINO), lhsICMPARAMCALSISTDESTINO, rhsICMPARAMCALSISTDESTINO, (this.icmparamcalsistdestino!= null), (that.icmparamcalsistdestino!= null))) {
                return false;
            }
        }
        {
            IcmWsCalcOperacionesBlock lhsICMWSCALCOPERACIONES;
            lhsICMWSCALCOPERACIONES = this.getICMWSCALCOPERACIONES();
            IcmWsCalcOperacionesBlock rhsICMWSCALCOPERACIONES;
            rhsICMWSCALCOPERACIONES = that.getICMWSCALCOPERACIONES();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmwscalcoperaciones", lhsICMWSCALCOPERACIONES), LocatorUtils.property(thatLocator, "icmwscalcoperaciones", rhsICMWSCALCOPERACIONES), lhsICMWSCALCOPERACIONES, rhsICMWSCALCOPERACIONES, (this.icmwscalcoperaciones!= null), (that.icmwscalcoperaciones!= null))) {
                return false;
            }
        }
        {
            IcmParamcalmultiempresaBlock lhsICMPARAMCALMULTIEMPRESA;
            lhsICMPARAMCALMULTIEMPRESA = this.getICMPARAMCALMULTIEMPRESA();
            IcmParamcalmultiempresaBlock rhsICMPARAMCALMULTIEMPRESA;
            rhsICMPARAMCALMULTIEMPRESA = that.getICMPARAMCALMULTIEMPRESA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalmultiempresa", lhsICMPARAMCALMULTIEMPRESA), LocatorUtils.property(thatLocator, "icmparamcalmultiempresa", rhsICMPARAMCALMULTIEMPRESA), lhsICMPARAMCALMULTIEMPRESA, rhsICMPARAMCALMULTIEMPRESA, (this.icmparamcalmultiempresa!= null), (that.icmparamcalmultiempresa!= null))) {
                return false;
            }
        }
        {
            IcmParamcalplanificadorBlock lhsICMPARAMCALPLANIFICADOR;
            lhsICMPARAMCALPLANIFICADOR = this.getICMPARAMCALPLANIFICADOR();
            IcmParamcalplanificadorBlock rhsICMPARAMCALPLANIFICADOR;
            rhsICMPARAMCALPLANIFICADOR = that.getICMPARAMCALPLANIFICADOR();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalplanificador", lhsICMPARAMCALPLANIFICADOR), LocatorUtils.property(thatLocator, "icmparamcalplanificador", rhsICMPARAMCALPLANIFICADOR), lhsICMPARAMCALPLANIFICADOR, rhsICMPARAMCALPLANIFICADOR, (this.icmparamcalplanificador!= null), (that.icmparamcalplanificador!= null))) {
                return false;
            }
        }
        {
            IcmParametrospaginacionBlock lhsICMPARAMETROSPAGINACION;
            lhsICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            IcmParametrospaginacionBlock rhsICMPARAMETROSPAGINACION;
            rhsICMPARAMETROSPAGINACION = that.getICMPARAMETROSPAGINACION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrospaginacion", lhsICMPARAMETROSPAGINACION), LocatorUtils.property(thatLocator, "icmparametrospaginacion", rhsICMPARAMETROSPAGINACION), lhsICMPARAMETROSPAGINACION, rhsICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null), (that.icmparametrospaginacion!= null))) {
                return false;
            }
        }
        {
            IcmListapresenciamanwlocBlock lhsICMLISTAPRESENCIAMANWLOC;
            lhsICMLISTAPRESENCIAMANWLOC = this.getICMLISTAPRESENCIAMANWLOC();
            IcmListapresenciamanwlocBlock rhsICMLISTAPRESENCIAMANWLOC;
            rhsICMLISTAPRESENCIAMANWLOC = that.getICMLISTAPRESENCIAMANWLOC();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistapresenciamanwloc", lhsICMLISTAPRESENCIAMANWLOC), LocatorUtils.property(thatLocator, "icmlistapresenciamanwloc", rhsICMLISTAPRESENCIAMANWLOC), lhsICMLISTAPRESENCIAMANWLOC, rhsICMLISTAPRESENCIAMANWLOC, (this.icmlistapresenciamanwloc!= null), (that.icmlistapresenciamanwloc!= null))) {
                return false;
            }
        }
        {
            IcmListapresupuestoswlocBlock lhsICMLISTAPRESUPUESTOSWLOC;
            lhsICMLISTAPRESUPUESTOSWLOC = this.getICMLISTAPRESUPUESTOSWLOC();
            IcmListapresupuestoswlocBlock rhsICMLISTAPRESUPUESTOSWLOC;
            rhsICMLISTAPRESUPUESTOSWLOC = that.getICMLISTAPRESUPUESTOSWLOC();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistapresupuestoswloc", lhsICMLISTAPRESUPUESTOSWLOC), LocatorUtils.property(thatLocator, "icmlistapresupuestoswloc", rhsICMLISTAPRESUPUESTOSWLOC), lhsICMLISTAPRESUPUESTOSWLOC, rhsICMLISTAPRESUPUESTOSWLOC, (this.icmlistapresupuestoswloc!= null), (that.icmlistapresupuestoswloc!= null))) {
                return false;
            }
        }
        {
            IcmListapresupuestosrangoBlock lhsICMLISTAPRESUPUESTOSRANGO;
            lhsICMLISTAPRESUPUESTOSRANGO = this.getICMLISTAPRESUPUESTOSRANGO();
            IcmListapresupuestosrangoBlock rhsICMLISTAPRESUPUESTOSRANGO;
            rhsICMLISTAPRESUPUESTOSRANGO = that.getICMLISTAPRESUPUESTOSRANGO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistapresupuestosrango", lhsICMLISTAPRESUPUESTOSRANGO), LocatorUtils.property(thatLocator, "icmlistapresupuestosrango", rhsICMLISTAPRESUPUESTOSRANGO), lhsICMLISTAPRESUPUESTOSRANGO, rhsICMLISTAPRESUPUESTOSRANGO, (this.icmlistapresupuestosrango!= null), (that.icmlistapresupuestosrango!= null))) {
                return false;
            }
        }
        {
            IcmParamcalconfpreciohoraBlock lhsICMPARAMCALCONFPRECIOHORA;
            lhsICMPARAMCALCONFPRECIOHORA = this.getICMPARAMCALCONFPRECIOHORA();
            IcmParamcalconfpreciohoraBlock rhsICMPARAMCALCONFPRECIOHORA;
            rhsICMPARAMCALCONFPRECIOHORA = that.getICMPARAMCALCONFPRECIOHORA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalconfpreciohora", lhsICMPARAMCALCONFPRECIOHORA), LocatorUtils.property(thatLocator, "icmparamcalconfpreciohora", rhsICMPARAMCALCONFPRECIOHORA), lhsICMPARAMCALCONFPRECIOHORA, rhsICMPARAMCALCONFPRECIOHORA, (this.icmparamcalconfpreciohora!= null), (that.icmparamcalconfpreciohora!= null))) {
                return false;
            }
        }
        {
            IcmParamcalventacongeladaBlock lhsICMPARAMCALVENTACONGELADA;
            lhsICMPARAMCALVENTACONGELADA = this.getICMPARAMCALVENTACONGELADA();
            IcmParamcalventacongeladaBlock rhsICMPARAMCALVENTACONGELADA;
            rhsICMPARAMCALVENTACONGELADA = that.getICMPARAMCALVENTACONGELADA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalventacongelada", lhsICMPARAMCALVENTACONGELADA), LocatorUtils.property(thatLocator, "icmparamcalventacongelada", rhsICMPARAMCALVENTACONGELADA), lhsICMPARAMCALVENTACONGELADA, rhsICMPARAMCALVENTACONGELADA, (this.icmparamcalventacongelada!= null), (that.icmparamcalventacongelada!= null))) {
                return false;
            }
        }
        {
            IcmParamcalpresenciamanualBlock lhsICMPARAMCALPRESENCIAMANUAL;
            lhsICMPARAMCALPRESENCIAMANUAL = this.getICMPARAMCALPRESENCIAMANUAL();
            IcmParamcalpresenciamanualBlock rhsICMPARAMCALPRESENCIAMANUAL;
            rhsICMPARAMCALPRESENCIAMANUAL = that.getICMPARAMCALPRESENCIAMANUAL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalpresenciamanual", lhsICMPARAMCALPRESENCIAMANUAL), LocatorUtils.property(thatLocator, "icmparamcalpresenciamanual", rhsICMPARAMCALPRESENCIAMANUAL), lhsICMPARAMCALPRESENCIAMANUAL, rhsICMPARAMCALPRESENCIAMANUAL, (this.icmparamcalpresenciamanual!= null), (that.icmparamcalpresenciamanual!= null))) {
                return false;
            }
        }
        {
            IcmParamcalempleadosdesplazBlock lhsICMPARAMCALEMPLEADOSDESPLAZ;
            lhsICMPARAMCALEMPLEADOSDESPLAZ = this.getICMPARAMCALEMPLEADOSDESPLAZ();
            IcmParamcalempleadosdesplazBlock rhsICMPARAMCALEMPLEADOSDESPLAZ;
            rhsICMPARAMCALEMPLEADOSDESPLAZ = that.getICMPARAMCALEMPLEADOSDESPLAZ();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalempleadosdesplaz", lhsICMPARAMCALEMPLEADOSDESPLAZ), LocatorUtils.property(thatLocator, "icmparamcalempleadosdesplaz", rhsICMPARAMCALEMPLEADOSDESPLAZ), lhsICMPARAMCALEMPLEADOSDESPLAZ, rhsICMPARAMCALEMPLEADOSDESPLAZ, (this.icmparamcalempleadosdesplaz!= null), (that.icmparamcalempleadosdesplaz!= null))) {
                return false;
            }
        }
        {
            IcmParamcalpresupuestoswlocBlock lhsICMPARAMCALPRESUPUESTOSWLOC;
            lhsICMPARAMCALPRESUPUESTOSWLOC = this.getICMPARAMCALPRESUPUESTOSWLOC();
            IcmParamcalpresupuestoswlocBlock rhsICMPARAMCALPRESUPUESTOSWLOC;
            rhsICMPARAMCALPRESUPUESTOSWLOC = that.getICMPARAMCALPRESUPUESTOSWLOC();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalpresupuestoswloc", lhsICMPARAMCALPRESUPUESTOSWLOC), LocatorUtils.property(thatLocator, "icmparamcalpresupuestoswloc", rhsICMPARAMCALPRESUPUESTOSWLOC), lhsICMPARAMCALPRESUPUESTOSWLOC, rhsICMPARAMCALPRESUPUESTOSWLOC, (this.icmparamcalpresupuestoswloc!= null), (that.icmparamcalpresupuestoswloc!= null))) {
                return false;
            }
        }
        {
            IcmParamcalpresupuestosrangoBlock lhsICMPARAMCALPRESUPUESTOSRANGO;
            lhsICMPARAMCALPRESUPUESTOSRANGO = this.getICMPARAMCALPRESUPUESTOSRANGO();
            IcmParamcalpresupuestosrangoBlock rhsICMPARAMCALPRESUPUESTOSRANGO;
            rhsICMPARAMCALPRESUPUESTOSRANGO = that.getICMPARAMCALPRESUPUESTOSRANGO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalpresupuestosrango", lhsICMPARAMCALPRESUPUESTOSRANGO), LocatorUtils.property(thatLocator, "icmparamcalpresupuestosrango", rhsICMPARAMCALPRESUPUESTOSRANGO), lhsICMPARAMCALPRESUPUESTOSRANGO, rhsICMPARAMCALPRESUPUESTOSRANGO, (this.icmparamcalpresupuestosrango!= null), (that.icmparamcalpresupuestosrango!= null))) {
                return false;
            }
        }
        {
            IcmParamcalempleadospresenciaBlock lhsICMPARAMCALEMPLEADOSPRESENCIA;
            lhsICMPARAMCALEMPLEADOSPRESENCIA = this.getICMPARAMCALEMPLEADOSPRESENCIA();
            IcmParamcalempleadospresenciaBlock rhsICMPARAMCALEMPLEADOSPRESENCIA;
            rhsICMPARAMCALEMPLEADOSPRESENCIA = that.getICMPARAMCALEMPLEADOSPRESENCIA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalempleadospresencia", lhsICMPARAMCALEMPLEADOSPRESENCIA), LocatorUtils.property(thatLocator, "icmparamcalempleadospresencia", rhsICMPARAMCALEMPLEADOSPRESENCIA), lhsICMPARAMCALEMPLEADOSPRESENCIA, rhsICMPARAMCALEMPLEADOSPRESENCIA, (this.icmparamcalempleadospresencia!= null), (that.icmparamcalempleadospresencia!= null))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        {
            IcmWsToolsBlock theICMWSTOOLS;
            theICMWSTOOLS = this.getICMWSTOOLS();
            strategy.appendField(locator, this, "icmwstools", buffer, theICMWSTOOLS, (this.icmwstools!= null));
        }
        {
            IcmListamailBlock theICMLISTAMAIL;
            theICMLISTAMAIL = this.getICMLISTAMAIL();
            strategy.appendField(locator, this, "icmlistamail", buffer, theICMLISTAMAIL, (this.icmlistamail!= null));
        }
        {
            IcmListaclasesBlock theICMLISTACLASES;
            theICMLISTACLASES = this.getICMLISTACLASES();
            strategy.appendField(locator, this, "icmlistaclases", buffer, theICMLISTACLASES, (this.icmlistaclases!= null));
        }
        {
            IcmListasincroBlock theICMLISTASINCRO;
            theICMLISTASINCRO = this.getICMLISTASINCRO();
            strategy.appendField(locator, this, "icmlistasincro", buffer, theICMLISTASINCRO, (this.icmlistasincro!= null));
        }
        {
            IcmListacadenasBlock theICMLISTACADENAS;
            theICMLISTACADENAS = this.getICMLISTACADENAS();
            strategy.appendField(locator, this, "icmlistacadenas", buffer, theICMLISTACADENAS, (this.icmlistacadenas!= null));
        }
        {
            IcmListamotivosBlock theICMLISTAMOTIVOS;
            theICMLISTAMOTIVOS = this.getICMLISTAMOTIVOS();
            strategy.appendField(locator, this, "icmlistamotivos", buffer, theICMLISTAMOTIVOS, (this.icmlistamotivos!= null));
        }
        {
            IcmListatiendasBlock theICMLISTATIENDAS;
            theICMLISTATIENDAS = this.getICMLISTATIENDAS();
            strategy.appendField(locator, this, "icmlistatiendas", buffer, theICMLISTATIENDAS, (this.icmlistatiendas!= null));
        }
        {
            IcmListacatalogoBlock theICMLISTACATALOGO;
            theICMLISTACATALOGO = this.getICMLISTACATALOGO();
            strategy.appendField(locator, this, "icmlistacatalogo", buffer, theICMLISTACATALOGO, (this.icmlistacatalogo!= null));
        }
        {
            IcmListaempleadoBlock theICMLISTAEMPLEADO;
            theICMLISTAEMPLEADO = this.getICMLISTAEMPLEADO();
            strategy.appendField(locator, this, "icmlistaempleado", buffer, theICMLISTAEMPLEADO, (this.icmlistaempleado!= null));
        }
        {
            IcmListaempresasBlock theICMLISTAEMPRESAS;
            theICMLISTAEMPRESAS = this.getICMLISTAEMPRESAS();
            strategy.appendField(locator, this, "icmlistaempresas", buffer, theICMLISTAEMPRESAS, (this.icmlistaempresas!= null));
        }
        {
            IcmListaorigenesBlock theICMLISTAORIGENES;
            theICMLISTAORIGENES = this.getICMLISTAORIGENES();
            strategy.appendField(locator, this, "icmlistaorigenes", buffer, theICMLISTAORIGENES, (this.icmlistaorigenes!= null));
        }
        {
            IcmListaperiodosBlock theICMLISTAPERIODOS;
            theICMLISTAPERIODOS = this.getICMLISTAPERIODOS();
            strategy.appendField(locator, this, "icmlistaperiodos", buffer, theICMLISTAPERIODOS, (this.icmlistaperiodos!= null));
        }
        {
            IcmListaausenciasBlock theICMLISTAAUSENCIAS;
            theICMLISTAAUSENCIAS = this.getICMLISTAAUSENCIAS();
            strategy.appendField(locator, this, "icmlistaausencias", buffer, theICMLISTAAUSENCIAS, (this.icmlistaausencias!= null));
        }
        {
            IcmListaempleadosBlock theICMLISTAEMPLEADOS;
            theICMLISTAEMPLEADOS = this.getICMLISTAEMPLEADOS();
            strategy.appendField(locator, this, "icmlistaempleados", buffer, theICMLISTAEMPLEADOS, (this.icmlistaempleados!= null));
        }
        {
            IcmListapoliticasBlock theICMLISTAPOLITICAS;
            theICMLISTAPOLITICAS = this.getICMLISTAPOLITICAS();
            strategy.appendField(locator, this, "icmlistapoliticas", buffer, theICMLISTAPOLITICAS, (this.icmlistapoliticas!= null));
        }
        {
            IcmListatiposhoraBlock theICMLISTATIPOSHORA;
            theICMLISTATIPOSHORA = this.getICMLISTATIPOSHORA();
            strategy.appendField(locator, this, "icmlistatiposhora", buffer, theICMLISTATIPOSHORA, (this.icmlistatiposhora!= null));
        }
        {
            IcmParamcalcadenaBlock theICMPARAMCALCADENA;
            theICMPARAMCALCADENA = this.getICMPARAMCALCADENA();
            strategy.appendField(locator, this, "icmparamcalcadena", buffer, theICMPARAMCALCADENA, (this.icmparamcalcadena!= null));
        }
        {
            IcmParamcalorigenBlock theICMPARAMCALORIGEN;
            theICMPARAMCALORIGEN = this.getICMPARAMCALORIGEN();
            strategy.appendField(locator, this, "icmparamcalorigen", buffer, theICMPARAMCALORIGEN, (this.icmparamcalorigen!= null));
        }
        {
            IcmParamcalsincroBlock theICMPARAMCALSINCRO;
            theICMPARAMCALSINCRO = this.getICMPARAMCALSINCRO();
            strategy.appendField(locator, this, "icmparamcalsincro", buffer, theICMPARAMCALSINCRO, (this.icmparamcalsincro!= null));
        }
        {
            IcmListaconfchdiasBlock theICMLISTACONFCHDIAS;
            theICMLISTACONFCHDIAS = this.getICMLISTACONFCHDIAS();
            strategy.appendField(locator, this, "icmlistaconfchdias", buffer, theICMLISTACONFCHDIAS, (this.icmlistaconfchdias!= null));
        }
        {
            IcmListaconforigenBlock theICMLISTACONFORIGEN;
            theICMLISTACONFORIGEN = this.getICMLISTACONFORIGEN();
            strategy.appendField(locator, this, "icmlistaconforigen", buffer, theICMLISTACONFORIGEN, (this.icmlistaconforigen!= null));
        }
        {
            IcmListaestructuraBlock theICMLISTAESTRUCTURA;
            theICMLISTAESTRUCTURA = this.getICMLISTAESTRUCTURA();
            strategy.appendField(locator, this, "icmlistaestructura", buffer, theICMLISTAESTRUCTURA, (this.icmlistaestructura!= null));
        }
        {
            IcmParamcalmotivosBlock theICMPARAMCALMOTIVOS;
            theICMPARAMCALMOTIVOS = this.getICMPARAMCALMOTIVOS();
            strategy.appendField(locator, this, "icmparamcalmotivos", buffer, theICMPARAMCALMOTIVOS, (this.icmparamcalmotivos!= null));
        }
        {
            IcmParamcalperiodoBlock theICMPARAMCALPERIODO;
            theICMPARAMCALPERIODO = this.getICMPARAMCALPERIODO();
            strategy.appendField(locator, this, "icmparamcalperiodo", buffer, theICMPARAMCALPERIODO, (this.icmparamcalperiodo!= null));
        }
        {
            IcmParamcalprocesoBlock theICMPARAMCALPROCESO;
            theICMPARAMCALPROCESO = this.getICMPARAMCALPROCESO();
            strategy.appendField(locator, this, "icmparamcalproceso", buffer, theICMPARAMCALPROCESO, (this.icmparamcalproceso!= null));
        }
        {
            IcmParamcaltiendasBlock theICMPARAMCALTIENDAS;
            theICMPARAMCALTIENDAS = this.getICMPARAMCALTIENDAS();
            strategy.appendField(locator, this, "icmparamcaltiendas", buffer, theICMPARAMCALTIENDAS, (this.icmparamcaltiendas!= null));
        }
        {
            IcmParamcalusuarioBlock theICMPARAMCALUSUARIO;
            theICMPARAMCALUSUARIO = this.getICMPARAMCALUSUARIO();
            strategy.appendField(locator, this, "icmparamcalusuario", buffer, theICMPARAMCALUSUARIO, (this.icmparamcalusuario!= null));
        }
        {
            IcmListaconfchventaBlock theICMLISTACONFCHVENTA;
            theICMLISTACONFCHVENTA = this.getICMLISTACONFCHVENTA();
            strategy.appendField(locator, this, "icmlistaconfchventa", buffer, theICMLISTACONFCHVENTA, (this.icmlistaconfchventa!= null));
        }
        {
            IcmListadesplazrealBlock theICMLISTADESPLAZREAL;
            theICMLISTADESPLAZREAL = this.getICMLISTADESPLAZREAL();
            strategy.appendField(locator, this, "icmlistadesplazreal", buffer, theICMLISTADESPLAZREAL, (this.icmlistadesplazreal!= null));
        }
        {
            IcmListasistdestinoBlock theICMLISTASISTDESTINO;
            theICMLISTASISTDESTINO = this.getICMLISTASISTDESTINO();
            strategy.appendField(locator, this, "icmlistasistdestino", buffer, theICMLISTASISTDESTINO, (this.icmlistasistdestino!= null));
        }
        {
            IcmParamcalcatalogoBlock theICMPARAMCALCATALOGO;
            theICMPARAMCALCATALOGO = this.getICMPARAMCALCATALOGO();
            strategy.appendField(locator, this, "icmparamcalcatalogo", buffer, theICMPARAMCALCATALOGO, (this.icmparamcalcatalogo!= null));
        }
        {
            IcmParamcalempleadoBlock theICMPARAMCALEMPLEADO;
            theICMPARAMCALEMPLEADO = this.getICMPARAMCALEMPLEADO();
            strategy.appendField(locator, this, "icmparamcalempleado", buffer, theICMPARAMCALEMPLEADO, (this.icmparamcalempleado!= null));
        }
        {
            IcmParamcalsociedadBlock theICMPARAMCALSOCIEDAD;
            theICMPARAMCALSOCIEDAD = this.getICMPARAMCALSOCIEDAD();
            strategy.appendField(locator, this, "icmparamcalsociedad", buffer, theICMPARAMCALSOCIEDAD, (this.icmparamcalsociedad!= null));
        }
        {
            IcmListamultiempresaBlock theICMLISTAMULTIEMPRESA;
            theICMLISTAMULTIEMPRESA = this.getICMLISTAMULTIEMPRESA();
            strategy.appendField(locator, this, "icmlistamultiempresa", buffer, theICMLISTAMULTIEMPRESA, (this.icmlistamultiempresa!= null));
        }
        {
            IcmListaventamanwlocBlock theICMLISTAVENTAMANWLOC;
            theICMLISTAVENTAMANWLOC = this.getICMLISTAVENTAMANWLOC();
            strategy.appendField(locator, this, "icmlistaventamanwloc", buffer, theICMLISTAVENTAMANWLOC, (this.icmlistaventamanwloc!= null));
        }
        {
            IcmParamcalempleadosBlock theICMPARAMCALEMPLEADOS;
            theICMPARAMCALEMPLEADOS = this.getICMPARAMCALEMPLEADOS();
            strategy.appendField(locator, this, "icmparamcalempleados", buffer, theICMPARAMCALEMPLEADOS, (this.icmparamcalempleados!= null));
        }
        {
            IcmParamcaltiposhoraBlock theICMPARAMCALTIPOSHORA;
            theICMPARAMCALTIPOSHORA = this.getICMPARAMCALTIPOSHORA();
            strategy.appendField(locator, this, "icmparamcaltiposhora", buffer, theICMPARAMCALTIPOSHORA, (this.icmparamcaltiposhora!= null));
        }
        {
            IcmParametrosentradaBlock theICMPARAMETROSENTRADA;
            theICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            strategy.appendField(locator, this, "icmparametrosentrada", buffer, theICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null));
        }
        {
            IcmResultadoguardadoBlock theICMRESULTADOGUARDADO;
            theICMRESULTADOGUARDADO = this.getICMRESULTADOGUARDADO();
            strategy.appendField(locator, this, "icmresultadoguardado", buffer, theICMRESULTADOGUARDADO, (this.icmresultadoguardado!= null));
        }
        {
            IcmListaconfiguracionBlock theICMLISTACONFIGURACION;
            theICMLISTACONFIGURACION = this.getICMLISTACONFIGURACION();
            strategy.appendField(locator, this, "icmlistaconfiguracion", buffer, theICMLISTACONFIGURACION, (this.icmlistaconfiguracion!= null));
        }
        {
            IcmParamcalconfchdiasBlock theICMPARAMCALCONFCHDIAS;
            theICMPARAMCALCONFCHDIAS = this.getICMPARAMCALCONFCHDIAS();
            strategy.appendField(locator, this, "icmparamcalconfchdias", buffer, theICMPARAMCALCONFCHDIAS, (this.icmparamcalconfchdias!= null));
        }
        {
            IcmParamcalconforigenBlock theICMPARAMCALCONFORIGEN;
            theICMPARAMCALCONFORIGEN = this.getICMPARAMCALCONFORIGEN();
            strategy.appendField(locator, this, "icmparamcalconforigen", buffer, theICMPARAMCALCONFORIGEN, (this.icmparamcalconforigen!= null));
        }
        {
            IcmParamcalestructuraBlock theICMPARAMCALESTRUCTURA;
            theICMPARAMCALESTRUCTURA = this.getICMPARAMCALESTRUCTURA();
            strategy.appendField(locator, this, "icmparamcalestructura", buffer, theICMPARAMCALESTRUCTURA, (this.icmparamcalestructura!= null));
        }
        {
            IcmListaconfpreciohoraBlock theICMLISTACONFPRECIOHORA;
            theICMLISTACONFPRECIOHORA = this.getICMLISTACONFPRECIOHORA();
            strategy.appendField(locator, this, "icmlistaconfpreciohora", buffer, theICMLISTACONFPRECIOHORA, (this.icmlistaconfpreciohora!= null));
        }
        {
            IcmListaventacongeladaBlock theICMLISTAVENTACONGELADA;
            theICMLISTAVENTACONGELADA = this.getICMLISTAVENTACONGELADA();
            strategy.appendField(locator, this, "icmlistaventacongelada", buffer, theICMLISTAVENTACONGELADA, (this.icmlistaventacongelada!= null));
        }
        {
            IcmParamcalconfchventaBlock theICMPARAMCALCONFCHVENTA;
            theICMPARAMCALCONFCHVENTA = this.getICMPARAMCALCONFCHVENTA();
            strategy.appendField(locator, this, "icmparamcalconfchventa", buffer, theICMPARAMCALCONFCHVENTA, (this.icmparamcalconfchventa!= null));
        }
        {
            IcmParamcaldesplazrealBlock theICMPARAMCALDESPLAZREAL;
            theICMPARAMCALDESPLAZREAL = this.getICMPARAMCALDESPLAZREAL();
            strategy.appendField(locator, this, "icmparamcaldesplazreal", buffer, theICMPARAMCALDESPLAZREAL, (this.icmparamcaldesplazreal!= null));
        }
        {
            IcmParamcalflagcalculaBlock theICMPARAMCALFLAGCALCULA;
            theICMPARAMCALFLAGCALCULA = this.getICMPARAMCALFLAGCALCULA();
            strategy.appendField(locator, this, "icmparamcalflagcalcula", buffer, theICMPARAMCALFLAGCALCULA, (this.icmparamcalflagcalcula!= null));
        }
        {
            IcmParamcalliquidacionBlock theICMPARAMCALLIQUIDACION;
            theICMPARAMCALLIQUIDACION = this.getICMPARAMCALLIQUIDACION();
            strategy.appendField(locator, this, "icmparamcalliquidacion", buffer, theICMPARAMCALLIQUIDACION, (this.icmparamcalliquidacion!= null));
        }
        {
            IcmParamcalsistdestinoBlock theICMPARAMCALSISTDESTINO;
            theICMPARAMCALSISTDESTINO = this.getICMPARAMCALSISTDESTINO();
            strategy.appendField(locator, this, "icmparamcalsistdestino", buffer, theICMPARAMCALSISTDESTINO, (this.icmparamcalsistdestino!= null));
        }
        {
            IcmWsCalcOperacionesBlock theICMWSCALCOPERACIONES;
            theICMWSCALCOPERACIONES = this.getICMWSCALCOPERACIONES();
            strategy.appendField(locator, this, "icmwscalcoperaciones", buffer, theICMWSCALCOPERACIONES, (this.icmwscalcoperaciones!= null));
        }
        {
            IcmParamcalmultiempresaBlock theICMPARAMCALMULTIEMPRESA;
            theICMPARAMCALMULTIEMPRESA = this.getICMPARAMCALMULTIEMPRESA();
            strategy.appendField(locator, this, "icmparamcalmultiempresa", buffer, theICMPARAMCALMULTIEMPRESA, (this.icmparamcalmultiempresa!= null));
        }
        {
            IcmParamcalplanificadorBlock theICMPARAMCALPLANIFICADOR;
            theICMPARAMCALPLANIFICADOR = this.getICMPARAMCALPLANIFICADOR();
            strategy.appendField(locator, this, "icmparamcalplanificador", buffer, theICMPARAMCALPLANIFICADOR, (this.icmparamcalplanificador!= null));
        }
        {
            IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            strategy.appendField(locator, this, "icmparametrospaginacion", buffer, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null));
        }
        {
            IcmListapresenciamanwlocBlock theICMLISTAPRESENCIAMANWLOC;
            theICMLISTAPRESENCIAMANWLOC = this.getICMLISTAPRESENCIAMANWLOC();
            strategy.appendField(locator, this, "icmlistapresenciamanwloc", buffer, theICMLISTAPRESENCIAMANWLOC, (this.icmlistapresenciamanwloc!= null));
        }
        {
            IcmListapresupuestoswlocBlock theICMLISTAPRESUPUESTOSWLOC;
            theICMLISTAPRESUPUESTOSWLOC = this.getICMLISTAPRESUPUESTOSWLOC();
            strategy.appendField(locator, this, "icmlistapresupuestoswloc", buffer, theICMLISTAPRESUPUESTOSWLOC, (this.icmlistapresupuestoswloc!= null));
        }
        {
            IcmListapresupuestosrangoBlock theICMLISTAPRESUPUESTOSRANGO;
            theICMLISTAPRESUPUESTOSRANGO = this.getICMLISTAPRESUPUESTOSRANGO();
            strategy.appendField(locator, this, "icmlistapresupuestosrango", buffer, theICMLISTAPRESUPUESTOSRANGO, (this.icmlistapresupuestosrango!= null));
        }
        {
            IcmParamcalconfpreciohoraBlock theICMPARAMCALCONFPRECIOHORA;
            theICMPARAMCALCONFPRECIOHORA = this.getICMPARAMCALCONFPRECIOHORA();
            strategy.appendField(locator, this, "icmparamcalconfpreciohora", buffer, theICMPARAMCALCONFPRECIOHORA, (this.icmparamcalconfpreciohora!= null));
        }
        {
            IcmParamcalventacongeladaBlock theICMPARAMCALVENTACONGELADA;
            theICMPARAMCALVENTACONGELADA = this.getICMPARAMCALVENTACONGELADA();
            strategy.appendField(locator, this, "icmparamcalventacongelada", buffer, theICMPARAMCALVENTACONGELADA, (this.icmparamcalventacongelada!= null));
        }
        {
            IcmParamcalpresenciamanualBlock theICMPARAMCALPRESENCIAMANUAL;
            theICMPARAMCALPRESENCIAMANUAL = this.getICMPARAMCALPRESENCIAMANUAL();
            strategy.appendField(locator, this, "icmparamcalpresenciamanual", buffer, theICMPARAMCALPRESENCIAMANUAL, (this.icmparamcalpresenciamanual!= null));
        }
        {
            IcmParamcalempleadosdesplazBlock theICMPARAMCALEMPLEADOSDESPLAZ;
            theICMPARAMCALEMPLEADOSDESPLAZ = this.getICMPARAMCALEMPLEADOSDESPLAZ();
            strategy.appendField(locator, this, "icmparamcalempleadosdesplaz", buffer, theICMPARAMCALEMPLEADOSDESPLAZ, (this.icmparamcalempleadosdesplaz!= null));
        }
        {
            IcmParamcalpresupuestoswlocBlock theICMPARAMCALPRESUPUESTOSWLOC;
            theICMPARAMCALPRESUPUESTOSWLOC = this.getICMPARAMCALPRESUPUESTOSWLOC();
            strategy.appendField(locator, this, "icmparamcalpresupuestoswloc", buffer, theICMPARAMCALPRESUPUESTOSWLOC, (this.icmparamcalpresupuestoswloc!= null));
        }
        {
            IcmParamcalpresupuestosrangoBlock theICMPARAMCALPRESUPUESTOSRANGO;
            theICMPARAMCALPRESUPUESTOSRANGO = this.getICMPARAMCALPRESUPUESTOSRANGO();
            strategy.appendField(locator, this, "icmparamcalpresupuestosrango", buffer, theICMPARAMCALPRESUPUESTOSRANGO, (this.icmparamcalpresupuestosrango!= null));
        }
        {
            IcmParamcalempleadospresenciaBlock theICMPARAMCALEMPLEADOSPRESENCIA;
            theICMPARAMCALEMPLEADOSPRESENCIA = this.getICMPARAMCALEMPLEADOSPRESENCIA();
            strategy.appendField(locator, this, "icmparamcalempleadospresencia", buffer, theICMPARAMCALEMPLEADOSPRESENCIA, (this.icmparamcalempleadospresencia!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            IcmWsToolsBlock theICMWSTOOLS;
            theICMWSTOOLS = this.getICMWSTOOLS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmwstools", theICMWSTOOLS), currentHashCode, theICMWSTOOLS, (this.icmwstools!= null));
        }
        {
            IcmListamailBlock theICMLISTAMAIL;
            theICMLISTAMAIL = this.getICMLISTAMAIL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistamail", theICMLISTAMAIL), currentHashCode, theICMLISTAMAIL, (this.icmlistamail!= null));
        }
        {
            IcmListaclasesBlock theICMLISTACLASES;
            theICMLISTACLASES = this.getICMLISTACLASES();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaclases", theICMLISTACLASES), currentHashCode, theICMLISTACLASES, (this.icmlistaclases!= null));
        }
        {
            IcmListasincroBlock theICMLISTASINCRO;
            theICMLISTASINCRO = this.getICMLISTASINCRO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistasincro", theICMLISTASINCRO), currentHashCode, theICMLISTASINCRO, (this.icmlistasincro!= null));
        }
        {
            IcmListacadenasBlock theICMLISTACADENAS;
            theICMLISTACADENAS = this.getICMLISTACADENAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistacadenas", theICMLISTACADENAS), currentHashCode, theICMLISTACADENAS, (this.icmlistacadenas!= null));
        }
        {
            IcmListamotivosBlock theICMLISTAMOTIVOS;
            theICMLISTAMOTIVOS = this.getICMLISTAMOTIVOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistamotivos", theICMLISTAMOTIVOS), currentHashCode, theICMLISTAMOTIVOS, (this.icmlistamotivos!= null));
        }
        {
            IcmListatiendasBlock theICMLISTATIENDAS;
            theICMLISTATIENDAS = this.getICMLISTATIENDAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistatiendas", theICMLISTATIENDAS), currentHashCode, theICMLISTATIENDAS, (this.icmlistatiendas!= null));
        }
        {
            IcmListacatalogoBlock theICMLISTACATALOGO;
            theICMLISTACATALOGO = this.getICMLISTACATALOGO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistacatalogo", theICMLISTACATALOGO), currentHashCode, theICMLISTACATALOGO, (this.icmlistacatalogo!= null));
        }
        {
            IcmListaempleadoBlock theICMLISTAEMPLEADO;
            theICMLISTAEMPLEADO = this.getICMLISTAEMPLEADO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaempleado", theICMLISTAEMPLEADO), currentHashCode, theICMLISTAEMPLEADO, (this.icmlistaempleado!= null));
        }
        {
            IcmListaempresasBlock theICMLISTAEMPRESAS;
            theICMLISTAEMPRESAS = this.getICMLISTAEMPRESAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaempresas", theICMLISTAEMPRESAS), currentHashCode, theICMLISTAEMPRESAS, (this.icmlistaempresas!= null));
        }
        {
            IcmListaorigenesBlock theICMLISTAORIGENES;
            theICMLISTAORIGENES = this.getICMLISTAORIGENES();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaorigenes", theICMLISTAORIGENES), currentHashCode, theICMLISTAORIGENES, (this.icmlistaorigenes!= null));
        }
        {
            IcmListaperiodosBlock theICMLISTAPERIODOS;
            theICMLISTAPERIODOS = this.getICMLISTAPERIODOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaperiodos", theICMLISTAPERIODOS), currentHashCode, theICMLISTAPERIODOS, (this.icmlistaperiodos!= null));
        }
        {
            IcmListaausenciasBlock theICMLISTAAUSENCIAS;
            theICMLISTAAUSENCIAS = this.getICMLISTAAUSENCIAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaausencias", theICMLISTAAUSENCIAS), currentHashCode, theICMLISTAAUSENCIAS, (this.icmlistaausencias!= null));
        }
        {
            IcmListaempleadosBlock theICMLISTAEMPLEADOS;
            theICMLISTAEMPLEADOS = this.getICMLISTAEMPLEADOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaempleados", theICMLISTAEMPLEADOS), currentHashCode, theICMLISTAEMPLEADOS, (this.icmlistaempleados!= null));
        }
        {
            IcmListapoliticasBlock theICMLISTAPOLITICAS;
            theICMLISTAPOLITICAS = this.getICMLISTAPOLITICAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistapoliticas", theICMLISTAPOLITICAS), currentHashCode, theICMLISTAPOLITICAS, (this.icmlistapoliticas!= null));
        }
        {
            IcmListatiposhoraBlock theICMLISTATIPOSHORA;
            theICMLISTATIPOSHORA = this.getICMLISTATIPOSHORA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistatiposhora", theICMLISTATIPOSHORA), currentHashCode, theICMLISTATIPOSHORA, (this.icmlistatiposhora!= null));
        }
        {
            IcmParamcalcadenaBlock theICMPARAMCALCADENA;
            theICMPARAMCALCADENA = this.getICMPARAMCALCADENA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalcadena", theICMPARAMCALCADENA), currentHashCode, theICMPARAMCALCADENA, (this.icmparamcalcadena!= null));
        }
        {
            IcmParamcalorigenBlock theICMPARAMCALORIGEN;
            theICMPARAMCALORIGEN = this.getICMPARAMCALORIGEN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalorigen", theICMPARAMCALORIGEN), currentHashCode, theICMPARAMCALORIGEN, (this.icmparamcalorigen!= null));
        }
        {
            IcmParamcalsincroBlock theICMPARAMCALSINCRO;
            theICMPARAMCALSINCRO = this.getICMPARAMCALSINCRO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalsincro", theICMPARAMCALSINCRO), currentHashCode, theICMPARAMCALSINCRO, (this.icmparamcalsincro!= null));
        }
        {
            IcmListaconfchdiasBlock theICMLISTACONFCHDIAS;
            theICMLISTACONFCHDIAS = this.getICMLISTACONFCHDIAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaconfchdias", theICMLISTACONFCHDIAS), currentHashCode, theICMLISTACONFCHDIAS, (this.icmlistaconfchdias!= null));
        }
        {
            IcmListaconforigenBlock theICMLISTACONFORIGEN;
            theICMLISTACONFORIGEN = this.getICMLISTACONFORIGEN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaconforigen", theICMLISTACONFORIGEN), currentHashCode, theICMLISTACONFORIGEN, (this.icmlistaconforigen!= null));
        }
        {
            IcmListaestructuraBlock theICMLISTAESTRUCTURA;
            theICMLISTAESTRUCTURA = this.getICMLISTAESTRUCTURA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaestructura", theICMLISTAESTRUCTURA), currentHashCode, theICMLISTAESTRUCTURA, (this.icmlistaestructura!= null));
        }
        {
            IcmParamcalmotivosBlock theICMPARAMCALMOTIVOS;
            theICMPARAMCALMOTIVOS = this.getICMPARAMCALMOTIVOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalmotivos", theICMPARAMCALMOTIVOS), currentHashCode, theICMPARAMCALMOTIVOS, (this.icmparamcalmotivos!= null));
        }
        {
            IcmParamcalperiodoBlock theICMPARAMCALPERIODO;
            theICMPARAMCALPERIODO = this.getICMPARAMCALPERIODO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalperiodo", theICMPARAMCALPERIODO), currentHashCode, theICMPARAMCALPERIODO, (this.icmparamcalperiodo!= null));
        }
        {
            IcmParamcalprocesoBlock theICMPARAMCALPROCESO;
            theICMPARAMCALPROCESO = this.getICMPARAMCALPROCESO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalproceso", theICMPARAMCALPROCESO), currentHashCode, theICMPARAMCALPROCESO, (this.icmparamcalproceso!= null));
        }
        {
            IcmParamcaltiendasBlock theICMPARAMCALTIENDAS;
            theICMPARAMCALTIENDAS = this.getICMPARAMCALTIENDAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcaltiendas", theICMPARAMCALTIENDAS), currentHashCode, theICMPARAMCALTIENDAS, (this.icmparamcaltiendas!= null));
        }
        {
            IcmParamcalusuarioBlock theICMPARAMCALUSUARIO;
            theICMPARAMCALUSUARIO = this.getICMPARAMCALUSUARIO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalusuario", theICMPARAMCALUSUARIO), currentHashCode, theICMPARAMCALUSUARIO, (this.icmparamcalusuario!= null));
        }
        {
            IcmListaconfchventaBlock theICMLISTACONFCHVENTA;
            theICMLISTACONFCHVENTA = this.getICMLISTACONFCHVENTA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaconfchventa", theICMLISTACONFCHVENTA), currentHashCode, theICMLISTACONFCHVENTA, (this.icmlistaconfchventa!= null));
        }
        {
            IcmListadesplazrealBlock theICMLISTADESPLAZREAL;
            theICMLISTADESPLAZREAL = this.getICMLISTADESPLAZREAL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistadesplazreal", theICMLISTADESPLAZREAL), currentHashCode, theICMLISTADESPLAZREAL, (this.icmlistadesplazreal!= null));
        }
        {
            IcmListasistdestinoBlock theICMLISTASISTDESTINO;
            theICMLISTASISTDESTINO = this.getICMLISTASISTDESTINO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistasistdestino", theICMLISTASISTDESTINO), currentHashCode, theICMLISTASISTDESTINO, (this.icmlistasistdestino!= null));
        }
        {
            IcmParamcalcatalogoBlock theICMPARAMCALCATALOGO;
            theICMPARAMCALCATALOGO = this.getICMPARAMCALCATALOGO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalcatalogo", theICMPARAMCALCATALOGO), currentHashCode, theICMPARAMCALCATALOGO, (this.icmparamcalcatalogo!= null));
        }
        {
            IcmParamcalempleadoBlock theICMPARAMCALEMPLEADO;
            theICMPARAMCALEMPLEADO = this.getICMPARAMCALEMPLEADO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalempleado", theICMPARAMCALEMPLEADO), currentHashCode, theICMPARAMCALEMPLEADO, (this.icmparamcalempleado!= null));
        }
        {
            IcmParamcalsociedadBlock theICMPARAMCALSOCIEDAD;
            theICMPARAMCALSOCIEDAD = this.getICMPARAMCALSOCIEDAD();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalsociedad", theICMPARAMCALSOCIEDAD), currentHashCode, theICMPARAMCALSOCIEDAD, (this.icmparamcalsociedad!= null));
        }
        {
            IcmListamultiempresaBlock theICMLISTAMULTIEMPRESA;
            theICMLISTAMULTIEMPRESA = this.getICMLISTAMULTIEMPRESA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistamultiempresa", theICMLISTAMULTIEMPRESA), currentHashCode, theICMLISTAMULTIEMPRESA, (this.icmlistamultiempresa!= null));
        }
        {
            IcmListaventamanwlocBlock theICMLISTAVENTAMANWLOC;
            theICMLISTAVENTAMANWLOC = this.getICMLISTAVENTAMANWLOC();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaventamanwloc", theICMLISTAVENTAMANWLOC), currentHashCode, theICMLISTAVENTAMANWLOC, (this.icmlistaventamanwloc!= null));
        }
        {
            IcmParamcalempleadosBlock theICMPARAMCALEMPLEADOS;
            theICMPARAMCALEMPLEADOS = this.getICMPARAMCALEMPLEADOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalempleados", theICMPARAMCALEMPLEADOS), currentHashCode, theICMPARAMCALEMPLEADOS, (this.icmparamcalempleados!= null));
        }
        {
            IcmParamcaltiposhoraBlock theICMPARAMCALTIPOSHORA;
            theICMPARAMCALTIPOSHORA = this.getICMPARAMCALTIPOSHORA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcaltiposhora", theICMPARAMCALTIPOSHORA), currentHashCode, theICMPARAMCALTIPOSHORA, (this.icmparamcaltiposhora!= null));
        }
        {
            IcmParametrosentradaBlock theICMPARAMETROSENTRADA;
            theICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrosentrada", theICMPARAMETROSENTRADA), currentHashCode, theICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null));
        }
        {
            IcmResultadoguardadoBlock theICMRESULTADOGUARDADO;
            theICMRESULTADOGUARDADO = this.getICMRESULTADOGUARDADO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmresultadoguardado", theICMRESULTADOGUARDADO), currentHashCode, theICMRESULTADOGUARDADO, (this.icmresultadoguardado!= null));
        }
        {
            IcmListaconfiguracionBlock theICMLISTACONFIGURACION;
            theICMLISTACONFIGURACION = this.getICMLISTACONFIGURACION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaconfiguracion", theICMLISTACONFIGURACION), currentHashCode, theICMLISTACONFIGURACION, (this.icmlistaconfiguracion!= null));
        }
        {
            IcmParamcalconfchdiasBlock theICMPARAMCALCONFCHDIAS;
            theICMPARAMCALCONFCHDIAS = this.getICMPARAMCALCONFCHDIAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalconfchdias", theICMPARAMCALCONFCHDIAS), currentHashCode, theICMPARAMCALCONFCHDIAS, (this.icmparamcalconfchdias!= null));
        }
        {
            IcmParamcalconforigenBlock theICMPARAMCALCONFORIGEN;
            theICMPARAMCALCONFORIGEN = this.getICMPARAMCALCONFORIGEN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalconforigen", theICMPARAMCALCONFORIGEN), currentHashCode, theICMPARAMCALCONFORIGEN, (this.icmparamcalconforigen!= null));
        }
        {
            IcmParamcalestructuraBlock theICMPARAMCALESTRUCTURA;
            theICMPARAMCALESTRUCTURA = this.getICMPARAMCALESTRUCTURA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalestructura", theICMPARAMCALESTRUCTURA), currentHashCode, theICMPARAMCALESTRUCTURA, (this.icmparamcalestructura!= null));
        }
        {
            IcmListaconfpreciohoraBlock theICMLISTACONFPRECIOHORA;
            theICMLISTACONFPRECIOHORA = this.getICMLISTACONFPRECIOHORA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaconfpreciohora", theICMLISTACONFPRECIOHORA), currentHashCode, theICMLISTACONFPRECIOHORA, (this.icmlistaconfpreciohora!= null));
        }
        {
            IcmListaventacongeladaBlock theICMLISTAVENTACONGELADA;
            theICMLISTAVENTACONGELADA = this.getICMLISTAVENTACONGELADA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaventacongelada", theICMLISTAVENTACONGELADA), currentHashCode, theICMLISTAVENTACONGELADA, (this.icmlistaventacongelada!= null));
        }
        {
            IcmParamcalconfchventaBlock theICMPARAMCALCONFCHVENTA;
            theICMPARAMCALCONFCHVENTA = this.getICMPARAMCALCONFCHVENTA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalconfchventa", theICMPARAMCALCONFCHVENTA), currentHashCode, theICMPARAMCALCONFCHVENTA, (this.icmparamcalconfchventa!= null));
        }
        {
            IcmParamcaldesplazrealBlock theICMPARAMCALDESPLAZREAL;
            theICMPARAMCALDESPLAZREAL = this.getICMPARAMCALDESPLAZREAL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcaldesplazreal", theICMPARAMCALDESPLAZREAL), currentHashCode, theICMPARAMCALDESPLAZREAL, (this.icmparamcaldesplazreal!= null));
        }
        {
            IcmParamcalflagcalculaBlock theICMPARAMCALFLAGCALCULA;
            theICMPARAMCALFLAGCALCULA = this.getICMPARAMCALFLAGCALCULA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalflagcalcula", theICMPARAMCALFLAGCALCULA), currentHashCode, theICMPARAMCALFLAGCALCULA, (this.icmparamcalflagcalcula!= null));
        }
        {
            IcmParamcalliquidacionBlock theICMPARAMCALLIQUIDACION;
            theICMPARAMCALLIQUIDACION = this.getICMPARAMCALLIQUIDACION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalliquidacion", theICMPARAMCALLIQUIDACION), currentHashCode, theICMPARAMCALLIQUIDACION, (this.icmparamcalliquidacion!= null));
        }
        {
            IcmParamcalsistdestinoBlock theICMPARAMCALSISTDESTINO;
            theICMPARAMCALSISTDESTINO = this.getICMPARAMCALSISTDESTINO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalsistdestino", theICMPARAMCALSISTDESTINO), currentHashCode, theICMPARAMCALSISTDESTINO, (this.icmparamcalsistdestino!= null));
        }
        {
            IcmWsCalcOperacionesBlock theICMWSCALCOPERACIONES;
            theICMWSCALCOPERACIONES = this.getICMWSCALCOPERACIONES();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmwscalcoperaciones", theICMWSCALCOPERACIONES), currentHashCode, theICMWSCALCOPERACIONES, (this.icmwscalcoperaciones!= null));
        }
        {
            IcmParamcalmultiempresaBlock theICMPARAMCALMULTIEMPRESA;
            theICMPARAMCALMULTIEMPRESA = this.getICMPARAMCALMULTIEMPRESA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalmultiempresa", theICMPARAMCALMULTIEMPRESA), currentHashCode, theICMPARAMCALMULTIEMPRESA, (this.icmparamcalmultiempresa!= null));
        }
        {
            IcmParamcalplanificadorBlock theICMPARAMCALPLANIFICADOR;
            theICMPARAMCALPLANIFICADOR = this.getICMPARAMCALPLANIFICADOR();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalplanificador", theICMPARAMCALPLANIFICADOR), currentHashCode, theICMPARAMCALPLANIFICADOR, (this.icmparamcalplanificador!= null));
        }
        {
            IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrospaginacion", theICMPARAMETROSPAGINACION), currentHashCode, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null));
        }
        {
            IcmListapresenciamanwlocBlock theICMLISTAPRESENCIAMANWLOC;
            theICMLISTAPRESENCIAMANWLOC = this.getICMLISTAPRESENCIAMANWLOC();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistapresenciamanwloc", theICMLISTAPRESENCIAMANWLOC), currentHashCode, theICMLISTAPRESENCIAMANWLOC, (this.icmlistapresenciamanwloc!= null));
        }
        {
            IcmListapresupuestoswlocBlock theICMLISTAPRESUPUESTOSWLOC;
            theICMLISTAPRESUPUESTOSWLOC = this.getICMLISTAPRESUPUESTOSWLOC();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistapresupuestoswloc", theICMLISTAPRESUPUESTOSWLOC), currentHashCode, theICMLISTAPRESUPUESTOSWLOC, (this.icmlistapresupuestoswloc!= null));
        }
        {
            IcmListapresupuestosrangoBlock theICMLISTAPRESUPUESTOSRANGO;
            theICMLISTAPRESUPUESTOSRANGO = this.getICMLISTAPRESUPUESTOSRANGO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistapresupuestosrango", theICMLISTAPRESUPUESTOSRANGO), currentHashCode, theICMLISTAPRESUPUESTOSRANGO, (this.icmlistapresupuestosrango!= null));
        }
        {
            IcmParamcalconfpreciohoraBlock theICMPARAMCALCONFPRECIOHORA;
            theICMPARAMCALCONFPRECIOHORA = this.getICMPARAMCALCONFPRECIOHORA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalconfpreciohora", theICMPARAMCALCONFPRECIOHORA), currentHashCode, theICMPARAMCALCONFPRECIOHORA, (this.icmparamcalconfpreciohora!= null));
        }
        {
            IcmParamcalventacongeladaBlock theICMPARAMCALVENTACONGELADA;
            theICMPARAMCALVENTACONGELADA = this.getICMPARAMCALVENTACONGELADA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalventacongelada", theICMPARAMCALVENTACONGELADA), currentHashCode, theICMPARAMCALVENTACONGELADA, (this.icmparamcalventacongelada!= null));
        }
        {
            IcmParamcalpresenciamanualBlock theICMPARAMCALPRESENCIAMANUAL;
            theICMPARAMCALPRESENCIAMANUAL = this.getICMPARAMCALPRESENCIAMANUAL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalpresenciamanual", theICMPARAMCALPRESENCIAMANUAL), currentHashCode, theICMPARAMCALPRESENCIAMANUAL, (this.icmparamcalpresenciamanual!= null));
        }
        {
            IcmParamcalempleadosdesplazBlock theICMPARAMCALEMPLEADOSDESPLAZ;
            theICMPARAMCALEMPLEADOSDESPLAZ = this.getICMPARAMCALEMPLEADOSDESPLAZ();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalempleadosdesplaz", theICMPARAMCALEMPLEADOSDESPLAZ), currentHashCode, theICMPARAMCALEMPLEADOSDESPLAZ, (this.icmparamcalempleadosdesplaz!= null));
        }
        {
            IcmParamcalpresupuestoswlocBlock theICMPARAMCALPRESUPUESTOSWLOC;
            theICMPARAMCALPRESUPUESTOSWLOC = this.getICMPARAMCALPRESUPUESTOSWLOC();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalpresupuestoswloc", theICMPARAMCALPRESUPUESTOSWLOC), currentHashCode, theICMPARAMCALPRESUPUESTOSWLOC, (this.icmparamcalpresupuestoswloc!= null));
        }
        {
            IcmParamcalpresupuestosrangoBlock theICMPARAMCALPRESUPUESTOSRANGO;
            theICMPARAMCALPRESUPUESTOSRANGO = this.getICMPARAMCALPRESUPUESTOSRANGO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalpresupuestosrango", theICMPARAMCALPRESUPUESTOSRANGO), currentHashCode, theICMPARAMCALPRESUPUESTOSRANGO, (this.icmparamcalpresupuestosrango!= null));
        }
        {
            IcmParamcalempleadospresenciaBlock theICMPARAMCALEMPLEADOSPRESENCIA;
            theICMPARAMCALEMPLEADOSPRESENCIA = this.getICMPARAMCALEMPLEADOSPRESENCIA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalempleadospresencia", theICMPARAMCALEMPLEADOSPRESENCIA), currentHashCode, theICMPARAMCALEMPLEADOSPRESENCIA, (this.icmparamcalempleadospresencia!= null));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof M4LoadObject) {
            final M4LoadObject copy = ((M4LoadObject) draftCopy);
            {
                Boolean icmwstoolsShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmwstools!= null));
                if (icmwstoolsShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmWsToolsBlock sourceICMWSTOOLS;
                    sourceICMWSTOOLS = this.getICMWSTOOLS();
                    IcmWsToolsBlock copyICMWSTOOLS = ((IcmWsToolsBlock) strategy.copy(LocatorUtils.property(locator, "icmwstools", sourceICMWSTOOLS), sourceICMWSTOOLS, (this.icmwstools!= null)));
                    copy.setICMWSTOOLS(copyICMWSTOOLS);
                } else {
                    if (icmwstoolsShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmwstools = null;
                    }
                }
            }
            {
                Boolean icmlistamailShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistamail!= null));
                if (icmlistamailShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListamailBlock sourceICMLISTAMAIL;
                    sourceICMLISTAMAIL = this.getICMLISTAMAIL();
                    IcmListamailBlock copyICMLISTAMAIL = ((IcmListamailBlock) strategy.copy(LocatorUtils.property(locator, "icmlistamail", sourceICMLISTAMAIL), sourceICMLISTAMAIL, (this.icmlistamail!= null)));
                    copy.setICMLISTAMAIL(copyICMLISTAMAIL);
                } else {
                    if (icmlistamailShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistamail = null;
                    }
                }
            }
            {
                Boolean icmlistaclasesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaclases!= null));
                if (icmlistaclasesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaclasesBlock sourceICMLISTACLASES;
                    sourceICMLISTACLASES = this.getICMLISTACLASES();
                    IcmListaclasesBlock copyICMLISTACLASES = ((IcmListaclasesBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaclases", sourceICMLISTACLASES), sourceICMLISTACLASES, (this.icmlistaclases!= null)));
                    copy.setICMLISTACLASES(copyICMLISTACLASES);
                } else {
                    if (icmlistaclasesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaclases = null;
                    }
                }
            }
            {
                Boolean icmlistasincroShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistasincro!= null));
                if (icmlistasincroShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListasincroBlock sourceICMLISTASINCRO;
                    sourceICMLISTASINCRO = this.getICMLISTASINCRO();
                    IcmListasincroBlock copyICMLISTASINCRO = ((IcmListasincroBlock) strategy.copy(LocatorUtils.property(locator, "icmlistasincro", sourceICMLISTASINCRO), sourceICMLISTASINCRO, (this.icmlistasincro!= null)));
                    copy.setICMLISTASINCRO(copyICMLISTASINCRO);
                } else {
                    if (icmlistasincroShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistasincro = null;
                    }
                }
            }
            {
                Boolean icmlistacadenasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistacadenas!= null));
                if (icmlistacadenasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListacadenasBlock sourceICMLISTACADENAS;
                    sourceICMLISTACADENAS = this.getICMLISTACADENAS();
                    IcmListacadenasBlock copyICMLISTACADENAS = ((IcmListacadenasBlock) strategy.copy(LocatorUtils.property(locator, "icmlistacadenas", sourceICMLISTACADENAS), sourceICMLISTACADENAS, (this.icmlistacadenas!= null)));
                    copy.setICMLISTACADENAS(copyICMLISTACADENAS);
                } else {
                    if (icmlistacadenasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistacadenas = null;
                    }
                }
            }
            {
                Boolean icmlistamotivosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistamotivos!= null));
                if (icmlistamotivosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListamotivosBlock sourceICMLISTAMOTIVOS;
                    sourceICMLISTAMOTIVOS = this.getICMLISTAMOTIVOS();
                    IcmListamotivosBlock copyICMLISTAMOTIVOS = ((IcmListamotivosBlock) strategy.copy(LocatorUtils.property(locator, "icmlistamotivos", sourceICMLISTAMOTIVOS), sourceICMLISTAMOTIVOS, (this.icmlistamotivos!= null)));
                    copy.setICMLISTAMOTIVOS(copyICMLISTAMOTIVOS);
                } else {
                    if (icmlistamotivosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistamotivos = null;
                    }
                }
            }
            {
                Boolean icmlistatiendasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistatiendas!= null));
                if (icmlistatiendasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListatiendasBlock sourceICMLISTATIENDAS;
                    sourceICMLISTATIENDAS = this.getICMLISTATIENDAS();
                    IcmListatiendasBlock copyICMLISTATIENDAS = ((IcmListatiendasBlock) strategy.copy(LocatorUtils.property(locator, "icmlistatiendas", sourceICMLISTATIENDAS), sourceICMLISTATIENDAS, (this.icmlistatiendas!= null)));
                    copy.setICMLISTATIENDAS(copyICMLISTATIENDAS);
                } else {
                    if (icmlistatiendasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistatiendas = null;
                    }
                }
            }
            {
                Boolean icmlistacatalogoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistacatalogo!= null));
                if (icmlistacatalogoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListacatalogoBlock sourceICMLISTACATALOGO;
                    sourceICMLISTACATALOGO = this.getICMLISTACATALOGO();
                    IcmListacatalogoBlock copyICMLISTACATALOGO = ((IcmListacatalogoBlock) strategy.copy(LocatorUtils.property(locator, "icmlistacatalogo", sourceICMLISTACATALOGO), sourceICMLISTACATALOGO, (this.icmlistacatalogo!= null)));
                    copy.setICMLISTACATALOGO(copyICMLISTACATALOGO);
                } else {
                    if (icmlistacatalogoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistacatalogo = null;
                    }
                }
            }
            {
                Boolean icmlistaempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaempleado!= null));
                if (icmlistaempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaempleadoBlock sourceICMLISTAEMPLEADO;
                    sourceICMLISTAEMPLEADO = this.getICMLISTAEMPLEADO();
                    IcmListaempleadoBlock copyICMLISTAEMPLEADO = ((IcmListaempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaempleado", sourceICMLISTAEMPLEADO), sourceICMLISTAEMPLEADO, (this.icmlistaempleado!= null)));
                    copy.setICMLISTAEMPLEADO(copyICMLISTAEMPLEADO);
                } else {
                    if (icmlistaempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaempleado = null;
                    }
                }
            }
            {
                Boolean icmlistaempresasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaempresas!= null));
                if (icmlistaempresasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaempresasBlock sourceICMLISTAEMPRESAS;
                    sourceICMLISTAEMPRESAS = this.getICMLISTAEMPRESAS();
                    IcmListaempresasBlock copyICMLISTAEMPRESAS = ((IcmListaempresasBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaempresas", sourceICMLISTAEMPRESAS), sourceICMLISTAEMPRESAS, (this.icmlistaempresas!= null)));
                    copy.setICMLISTAEMPRESAS(copyICMLISTAEMPRESAS);
                } else {
                    if (icmlistaempresasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaempresas = null;
                    }
                }
            }
            {
                Boolean icmlistaorigenesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaorigenes!= null));
                if (icmlistaorigenesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaorigenesBlock sourceICMLISTAORIGENES;
                    sourceICMLISTAORIGENES = this.getICMLISTAORIGENES();
                    IcmListaorigenesBlock copyICMLISTAORIGENES = ((IcmListaorigenesBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaorigenes", sourceICMLISTAORIGENES), sourceICMLISTAORIGENES, (this.icmlistaorigenes!= null)));
                    copy.setICMLISTAORIGENES(copyICMLISTAORIGENES);
                } else {
                    if (icmlistaorigenesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaorigenes = null;
                    }
                }
            }
            {
                Boolean icmlistaperiodosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaperiodos!= null));
                if (icmlistaperiodosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaperiodosBlock sourceICMLISTAPERIODOS;
                    sourceICMLISTAPERIODOS = this.getICMLISTAPERIODOS();
                    IcmListaperiodosBlock copyICMLISTAPERIODOS = ((IcmListaperiodosBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaperiodos", sourceICMLISTAPERIODOS), sourceICMLISTAPERIODOS, (this.icmlistaperiodos!= null)));
                    copy.setICMLISTAPERIODOS(copyICMLISTAPERIODOS);
                } else {
                    if (icmlistaperiodosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaperiodos = null;
                    }
                }
            }
            {
                Boolean icmlistaausenciasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaausencias!= null));
                if (icmlistaausenciasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaausenciasBlock sourceICMLISTAAUSENCIAS;
                    sourceICMLISTAAUSENCIAS = this.getICMLISTAAUSENCIAS();
                    IcmListaausenciasBlock copyICMLISTAAUSENCIAS = ((IcmListaausenciasBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaausencias", sourceICMLISTAAUSENCIAS), sourceICMLISTAAUSENCIAS, (this.icmlistaausencias!= null)));
                    copy.setICMLISTAAUSENCIAS(copyICMLISTAAUSENCIAS);
                } else {
                    if (icmlistaausenciasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaausencias = null;
                    }
                }
            }
            {
                Boolean icmlistaempleadosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaempleados!= null));
                if (icmlistaempleadosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaempleadosBlock sourceICMLISTAEMPLEADOS;
                    sourceICMLISTAEMPLEADOS = this.getICMLISTAEMPLEADOS();
                    IcmListaempleadosBlock copyICMLISTAEMPLEADOS = ((IcmListaempleadosBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaempleados", sourceICMLISTAEMPLEADOS), sourceICMLISTAEMPLEADOS, (this.icmlistaempleados!= null)));
                    copy.setICMLISTAEMPLEADOS(copyICMLISTAEMPLEADOS);
                } else {
                    if (icmlistaempleadosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaempleados = null;
                    }
                }
            }
            {
                Boolean icmlistapoliticasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistapoliticas!= null));
                if (icmlistapoliticasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListapoliticasBlock sourceICMLISTAPOLITICAS;
                    sourceICMLISTAPOLITICAS = this.getICMLISTAPOLITICAS();
                    IcmListapoliticasBlock copyICMLISTAPOLITICAS = ((IcmListapoliticasBlock) strategy.copy(LocatorUtils.property(locator, "icmlistapoliticas", sourceICMLISTAPOLITICAS), sourceICMLISTAPOLITICAS, (this.icmlistapoliticas!= null)));
                    copy.setICMLISTAPOLITICAS(copyICMLISTAPOLITICAS);
                } else {
                    if (icmlistapoliticasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistapoliticas = null;
                    }
                }
            }
            {
                Boolean icmlistatiposhoraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistatiposhora!= null));
                if (icmlistatiposhoraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListatiposhoraBlock sourceICMLISTATIPOSHORA;
                    sourceICMLISTATIPOSHORA = this.getICMLISTATIPOSHORA();
                    IcmListatiposhoraBlock copyICMLISTATIPOSHORA = ((IcmListatiposhoraBlock) strategy.copy(LocatorUtils.property(locator, "icmlistatiposhora", sourceICMLISTATIPOSHORA), sourceICMLISTATIPOSHORA, (this.icmlistatiposhora!= null)));
                    copy.setICMLISTATIPOSHORA(copyICMLISTATIPOSHORA);
                } else {
                    if (icmlistatiposhoraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistatiposhora = null;
                    }
                }
            }
            {
                Boolean icmparamcalcadenaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalcadena!= null));
                if (icmparamcalcadenaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalcadenaBlock sourceICMPARAMCALCADENA;
                    sourceICMPARAMCALCADENA = this.getICMPARAMCALCADENA();
                    IcmParamcalcadenaBlock copyICMPARAMCALCADENA = ((IcmParamcalcadenaBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalcadena", sourceICMPARAMCALCADENA), sourceICMPARAMCALCADENA, (this.icmparamcalcadena!= null)));
                    copy.setICMPARAMCALCADENA(copyICMPARAMCALCADENA);
                } else {
                    if (icmparamcalcadenaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalcadena = null;
                    }
                }
            }
            {
                Boolean icmparamcalorigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalorigen!= null));
                if (icmparamcalorigenShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalorigenBlock sourceICMPARAMCALORIGEN;
                    sourceICMPARAMCALORIGEN = this.getICMPARAMCALORIGEN();
                    IcmParamcalorigenBlock copyICMPARAMCALORIGEN = ((IcmParamcalorigenBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalorigen", sourceICMPARAMCALORIGEN), sourceICMPARAMCALORIGEN, (this.icmparamcalorigen!= null)));
                    copy.setICMPARAMCALORIGEN(copyICMPARAMCALORIGEN);
                } else {
                    if (icmparamcalorigenShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalorigen = null;
                    }
                }
            }
            {
                Boolean icmparamcalsincroShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalsincro!= null));
                if (icmparamcalsincroShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalsincroBlock sourceICMPARAMCALSINCRO;
                    sourceICMPARAMCALSINCRO = this.getICMPARAMCALSINCRO();
                    IcmParamcalsincroBlock copyICMPARAMCALSINCRO = ((IcmParamcalsincroBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalsincro", sourceICMPARAMCALSINCRO), sourceICMPARAMCALSINCRO, (this.icmparamcalsincro!= null)));
                    copy.setICMPARAMCALSINCRO(copyICMPARAMCALSINCRO);
                } else {
                    if (icmparamcalsincroShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalsincro = null;
                    }
                }
            }
            {
                Boolean icmlistaconfchdiasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaconfchdias!= null));
                if (icmlistaconfchdiasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconfchdiasBlock sourceICMLISTACONFCHDIAS;
                    sourceICMLISTACONFCHDIAS = this.getICMLISTACONFCHDIAS();
                    IcmListaconfchdiasBlock copyICMLISTACONFCHDIAS = ((IcmListaconfchdiasBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaconfchdias", sourceICMLISTACONFCHDIAS), sourceICMLISTACONFCHDIAS, (this.icmlistaconfchdias!= null)));
                    copy.setICMLISTACONFCHDIAS(copyICMLISTACONFCHDIAS);
                } else {
                    if (icmlistaconfchdiasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaconfchdias = null;
                    }
                }
            }
            {
                Boolean icmlistaconforigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaconforigen!= null));
                if (icmlistaconforigenShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconforigenBlock sourceICMLISTACONFORIGEN;
                    sourceICMLISTACONFORIGEN = this.getICMLISTACONFORIGEN();
                    IcmListaconforigenBlock copyICMLISTACONFORIGEN = ((IcmListaconforigenBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaconforigen", sourceICMLISTACONFORIGEN), sourceICMLISTACONFORIGEN, (this.icmlistaconforigen!= null)));
                    copy.setICMLISTACONFORIGEN(copyICMLISTACONFORIGEN);
                } else {
                    if (icmlistaconforigenShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaconforigen = null;
                    }
                }
            }
            {
                Boolean icmlistaestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaestructura!= null));
                if (icmlistaestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaestructuraBlock sourceICMLISTAESTRUCTURA;
                    sourceICMLISTAESTRUCTURA = this.getICMLISTAESTRUCTURA();
                    IcmListaestructuraBlock copyICMLISTAESTRUCTURA = ((IcmListaestructuraBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaestructura", sourceICMLISTAESTRUCTURA), sourceICMLISTAESTRUCTURA, (this.icmlistaestructura!= null)));
                    copy.setICMLISTAESTRUCTURA(copyICMLISTAESTRUCTURA);
                } else {
                    if (icmlistaestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaestructura = null;
                    }
                }
            }
            {
                Boolean icmparamcalmotivosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalmotivos!= null));
                if (icmparamcalmotivosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalmotivosBlock sourceICMPARAMCALMOTIVOS;
                    sourceICMPARAMCALMOTIVOS = this.getICMPARAMCALMOTIVOS();
                    IcmParamcalmotivosBlock copyICMPARAMCALMOTIVOS = ((IcmParamcalmotivosBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalmotivos", sourceICMPARAMCALMOTIVOS), sourceICMPARAMCALMOTIVOS, (this.icmparamcalmotivos!= null)));
                    copy.setICMPARAMCALMOTIVOS(copyICMPARAMCALMOTIVOS);
                } else {
                    if (icmparamcalmotivosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalmotivos = null;
                    }
                }
            }
            {
                Boolean icmparamcalperiodoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalperiodo!= null));
                if (icmparamcalperiodoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalperiodoBlock sourceICMPARAMCALPERIODO;
                    sourceICMPARAMCALPERIODO = this.getICMPARAMCALPERIODO();
                    IcmParamcalperiodoBlock copyICMPARAMCALPERIODO = ((IcmParamcalperiodoBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalperiodo", sourceICMPARAMCALPERIODO), sourceICMPARAMCALPERIODO, (this.icmparamcalperiodo!= null)));
                    copy.setICMPARAMCALPERIODO(copyICMPARAMCALPERIODO);
                } else {
                    if (icmparamcalperiodoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalperiodo = null;
                    }
                }
            }
            {
                Boolean icmparamcalprocesoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalproceso!= null));
                if (icmparamcalprocesoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalprocesoBlock sourceICMPARAMCALPROCESO;
                    sourceICMPARAMCALPROCESO = this.getICMPARAMCALPROCESO();
                    IcmParamcalprocesoBlock copyICMPARAMCALPROCESO = ((IcmParamcalprocesoBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalproceso", sourceICMPARAMCALPROCESO), sourceICMPARAMCALPROCESO, (this.icmparamcalproceso!= null)));
                    copy.setICMPARAMCALPROCESO(copyICMPARAMCALPROCESO);
                } else {
                    if (icmparamcalprocesoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalproceso = null;
                    }
                }
            }
            {
                Boolean icmparamcaltiendasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcaltiendas!= null));
                if (icmparamcaltiendasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcaltiendasBlock sourceICMPARAMCALTIENDAS;
                    sourceICMPARAMCALTIENDAS = this.getICMPARAMCALTIENDAS();
                    IcmParamcaltiendasBlock copyICMPARAMCALTIENDAS = ((IcmParamcaltiendasBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcaltiendas", sourceICMPARAMCALTIENDAS), sourceICMPARAMCALTIENDAS, (this.icmparamcaltiendas!= null)));
                    copy.setICMPARAMCALTIENDAS(copyICMPARAMCALTIENDAS);
                } else {
                    if (icmparamcaltiendasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcaltiendas = null;
                    }
                }
            }
            {
                Boolean icmparamcalusuarioShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalusuario!= null));
                if (icmparamcalusuarioShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalusuarioBlock sourceICMPARAMCALUSUARIO;
                    sourceICMPARAMCALUSUARIO = this.getICMPARAMCALUSUARIO();
                    IcmParamcalusuarioBlock copyICMPARAMCALUSUARIO = ((IcmParamcalusuarioBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalusuario", sourceICMPARAMCALUSUARIO), sourceICMPARAMCALUSUARIO, (this.icmparamcalusuario!= null)));
                    copy.setICMPARAMCALUSUARIO(copyICMPARAMCALUSUARIO);
                } else {
                    if (icmparamcalusuarioShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalusuario = null;
                    }
                }
            }
            {
                Boolean icmlistaconfchventaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaconfchventa!= null));
                if (icmlistaconfchventaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconfchventaBlock sourceICMLISTACONFCHVENTA;
                    sourceICMLISTACONFCHVENTA = this.getICMLISTACONFCHVENTA();
                    IcmListaconfchventaBlock copyICMLISTACONFCHVENTA = ((IcmListaconfchventaBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaconfchventa", sourceICMLISTACONFCHVENTA), sourceICMLISTACONFCHVENTA, (this.icmlistaconfchventa!= null)));
                    copy.setICMLISTACONFCHVENTA(copyICMLISTACONFCHVENTA);
                } else {
                    if (icmlistaconfchventaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaconfchventa = null;
                    }
                }
            }
            {
                Boolean icmlistadesplazrealShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistadesplazreal!= null));
                if (icmlistadesplazrealShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListadesplazrealBlock sourceICMLISTADESPLAZREAL;
                    sourceICMLISTADESPLAZREAL = this.getICMLISTADESPLAZREAL();
                    IcmListadesplazrealBlock copyICMLISTADESPLAZREAL = ((IcmListadesplazrealBlock) strategy.copy(LocatorUtils.property(locator, "icmlistadesplazreal", sourceICMLISTADESPLAZREAL), sourceICMLISTADESPLAZREAL, (this.icmlistadesplazreal!= null)));
                    copy.setICMLISTADESPLAZREAL(copyICMLISTADESPLAZREAL);
                } else {
                    if (icmlistadesplazrealShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistadesplazreal = null;
                    }
                }
            }
            {
                Boolean icmlistasistdestinoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistasistdestino!= null));
                if (icmlistasistdestinoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListasistdestinoBlock sourceICMLISTASISTDESTINO;
                    sourceICMLISTASISTDESTINO = this.getICMLISTASISTDESTINO();
                    IcmListasistdestinoBlock copyICMLISTASISTDESTINO = ((IcmListasistdestinoBlock) strategy.copy(LocatorUtils.property(locator, "icmlistasistdestino", sourceICMLISTASISTDESTINO), sourceICMLISTASISTDESTINO, (this.icmlistasistdestino!= null)));
                    copy.setICMLISTASISTDESTINO(copyICMLISTASISTDESTINO);
                } else {
                    if (icmlistasistdestinoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistasistdestino = null;
                    }
                }
            }
            {
                Boolean icmparamcalcatalogoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalcatalogo!= null));
                if (icmparamcalcatalogoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalcatalogoBlock sourceICMPARAMCALCATALOGO;
                    sourceICMPARAMCALCATALOGO = this.getICMPARAMCALCATALOGO();
                    IcmParamcalcatalogoBlock copyICMPARAMCALCATALOGO = ((IcmParamcalcatalogoBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalcatalogo", sourceICMPARAMCALCATALOGO), sourceICMPARAMCALCATALOGO, (this.icmparamcalcatalogo!= null)));
                    copy.setICMPARAMCALCATALOGO(copyICMPARAMCALCATALOGO);
                } else {
                    if (icmparamcalcatalogoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalcatalogo = null;
                    }
                }
            }
            {
                Boolean icmparamcalempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalempleado!= null));
                if (icmparamcalempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalempleadoBlock sourceICMPARAMCALEMPLEADO;
                    sourceICMPARAMCALEMPLEADO = this.getICMPARAMCALEMPLEADO();
                    IcmParamcalempleadoBlock copyICMPARAMCALEMPLEADO = ((IcmParamcalempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalempleado", sourceICMPARAMCALEMPLEADO), sourceICMPARAMCALEMPLEADO, (this.icmparamcalempleado!= null)));
                    copy.setICMPARAMCALEMPLEADO(copyICMPARAMCALEMPLEADO);
                } else {
                    if (icmparamcalempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalempleado = null;
                    }
                }
            }
            {
                Boolean icmparamcalsociedadShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalsociedad!= null));
                if (icmparamcalsociedadShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalsociedadBlock sourceICMPARAMCALSOCIEDAD;
                    sourceICMPARAMCALSOCIEDAD = this.getICMPARAMCALSOCIEDAD();
                    IcmParamcalsociedadBlock copyICMPARAMCALSOCIEDAD = ((IcmParamcalsociedadBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalsociedad", sourceICMPARAMCALSOCIEDAD), sourceICMPARAMCALSOCIEDAD, (this.icmparamcalsociedad!= null)));
                    copy.setICMPARAMCALSOCIEDAD(copyICMPARAMCALSOCIEDAD);
                } else {
                    if (icmparamcalsociedadShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalsociedad = null;
                    }
                }
            }
            {
                Boolean icmlistamultiempresaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistamultiempresa!= null));
                if (icmlistamultiempresaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListamultiempresaBlock sourceICMLISTAMULTIEMPRESA;
                    sourceICMLISTAMULTIEMPRESA = this.getICMLISTAMULTIEMPRESA();
                    IcmListamultiempresaBlock copyICMLISTAMULTIEMPRESA = ((IcmListamultiempresaBlock) strategy.copy(LocatorUtils.property(locator, "icmlistamultiempresa", sourceICMLISTAMULTIEMPRESA), sourceICMLISTAMULTIEMPRESA, (this.icmlistamultiempresa!= null)));
                    copy.setICMLISTAMULTIEMPRESA(copyICMLISTAMULTIEMPRESA);
                } else {
                    if (icmlistamultiempresaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistamultiempresa = null;
                    }
                }
            }
            {
                Boolean icmlistaventamanwlocShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaventamanwloc!= null));
                if (icmlistaventamanwlocShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaventamanwlocBlock sourceICMLISTAVENTAMANWLOC;
                    sourceICMLISTAVENTAMANWLOC = this.getICMLISTAVENTAMANWLOC();
                    IcmListaventamanwlocBlock copyICMLISTAVENTAMANWLOC = ((IcmListaventamanwlocBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaventamanwloc", sourceICMLISTAVENTAMANWLOC), sourceICMLISTAVENTAMANWLOC, (this.icmlistaventamanwloc!= null)));
                    copy.setICMLISTAVENTAMANWLOC(copyICMLISTAVENTAMANWLOC);
                } else {
                    if (icmlistaventamanwlocShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaventamanwloc = null;
                    }
                }
            }
            {
                Boolean icmparamcalempleadosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalempleados!= null));
                if (icmparamcalempleadosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalempleadosBlock sourceICMPARAMCALEMPLEADOS;
                    sourceICMPARAMCALEMPLEADOS = this.getICMPARAMCALEMPLEADOS();
                    IcmParamcalempleadosBlock copyICMPARAMCALEMPLEADOS = ((IcmParamcalempleadosBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalempleados", sourceICMPARAMCALEMPLEADOS), sourceICMPARAMCALEMPLEADOS, (this.icmparamcalempleados!= null)));
                    copy.setICMPARAMCALEMPLEADOS(copyICMPARAMCALEMPLEADOS);
                } else {
                    if (icmparamcalempleadosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalempleados = null;
                    }
                }
            }
            {
                Boolean icmparamcaltiposhoraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcaltiposhora!= null));
                if (icmparamcaltiposhoraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcaltiposhoraBlock sourceICMPARAMCALTIPOSHORA;
                    sourceICMPARAMCALTIPOSHORA = this.getICMPARAMCALTIPOSHORA();
                    IcmParamcaltiposhoraBlock copyICMPARAMCALTIPOSHORA = ((IcmParamcaltiposhoraBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcaltiposhora", sourceICMPARAMCALTIPOSHORA), sourceICMPARAMCALTIPOSHORA, (this.icmparamcaltiposhora!= null)));
                    copy.setICMPARAMCALTIPOSHORA(copyICMPARAMCALTIPOSHORA);
                } else {
                    if (icmparamcaltiposhoraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcaltiposhora = null;
                    }
                }
            }
            {
                Boolean icmparametrosentradaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrosentrada!= null));
                if (icmparametrosentradaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosentradaBlock sourceICMPARAMETROSENTRADA;
                    sourceICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
                    IcmParametrosentradaBlock copyICMPARAMETROSENTRADA = ((IcmParametrosentradaBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrosentrada", sourceICMPARAMETROSENTRADA), sourceICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null)));
                    copy.setICMPARAMETROSENTRADA(copyICMPARAMETROSENTRADA);
                } else {
                    if (icmparametrosentradaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrosentrada = null;
                    }
                }
            }
            {
                Boolean icmresultadoguardadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmresultadoguardado!= null));
                if (icmresultadoguardadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmResultadoguardadoBlock sourceICMRESULTADOGUARDADO;
                    sourceICMRESULTADOGUARDADO = this.getICMRESULTADOGUARDADO();
                    IcmResultadoguardadoBlock copyICMRESULTADOGUARDADO = ((IcmResultadoguardadoBlock) strategy.copy(LocatorUtils.property(locator, "icmresultadoguardado", sourceICMRESULTADOGUARDADO), sourceICMRESULTADOGUARDADO, (this.icmresultadoguardado!= null)));
                    copy.setICMRESULTADOGUARDADO(copyICMRESULTADOGUARDADO);
                } else {
                    if (icmresultadoguardadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmresultadoguardado = null;
                    }
                }
            }
            {
                Boolean icmlistaconfiguracionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaconfiguracion!= null));
                if (icmlistaconfiguracionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconfiguracionBlock sourceICMLISTACONFIGURACION;
                    sourceICMLISTACONFIGURACION = this.getICMLISTACONFIGURACION();
                    IcmListaconfiguracionBlock copyICMLISTACONFIGURACION = ((IcmListaconfiguracionBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaconfiguracion", sourceICMLISTACONFIGURACION), sourceICMLISTACONFIGURACION, (this.icmlistaconfiguracion!= null)));
                    copy.setICMLISTACONFIGURACION(copyICMLISTACONFIGURACION);
                } else {
                    if (icmlistaconfiguracionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaconfiguracion = null;
                    }
                }
            }
            {
                Boolean icmparamcalconfchdiasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalconfchdias!= null));
                if (icmparamcalconfchdiasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalconfchdiasBlock sourceICMPARAMCALCONFCHDIAS;
                    sourceICMPARAMCALCONFCHDIAS = this.getICMPARAMCALCONFCHDIAS();
                    IcmParamcalconfchdiasBlock copyICMPARAMCALCONFCHDIAS = ((IcmParamcalconfchdiasBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalconfchdias", sourceICMPARAMCALCONFCHDIAS), sourceICMPARAMCALCONFCHDIAS, (this.icmparamcalconfchdias!= null)));
                    copy.setICMPARAMCALCONFCHDIAS(copyICMPARAMCALCONFCHDIAS);
                } else {
                    if (icmparamcalconfchdiasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalconfchdias = null;
                    }
                }
            }
            {
                Boolean icmparamcalconforigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalconforigen!= null));
                if (icmparamcalconforigenShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalconforigenBlock sourceICMPARAMCALCONFORIGEN;
                    sourceICMPARAMCALCONFORIGEN = this.getICMPARAMCALCONFORIGEN();
                    IcmParamcalconforigenBlock copyICMPARAMCALCONFORIGEN = ((IcmParamcalconforigenBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalconforigen", sourceICMPARAMCALCONFORIGEN), sourceICMPARAMCALCONFORIGEN, (this.icmparamcalconforigen!= null)));
                    copy.setICMPARAMCALCONFORIGEN(copyICMPARAMCALCONFORIGEN);
                } else {
                    if (icmparamcalconforigenShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalconforigen = null;
                    }
                }
            }
            {
                Boolean icmparamcalestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalestructura!= null));
                if (icmparamcalestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalestructuraBlock sourceICMPARAMCALESTRUCTURA;
                    sourceICMPARAMCALESTRUCTURA = this.getICMPARAMCALESTRUCTURA();
                    IcmParamcalestructuraBlock copyICMPARAMCALESTRUCTURA = ((IcmParamcalestructuraBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalestructura", sourceICMPARAMCALESTRUCTURA), sourceICMPARAMCALESTRUCTURA, (this.icmparamcalestructura!= null)));
                    copy.setICMPARAMCALESTRUCTURA(copyICMPARAMCALESTRUCTURA);
                } else {
                    if (icmparamcalestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalestructura = null;
                    }
                }
            }
            {
                Boolean icmlistaconfpreciohoraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaconfpreciohora!= null));
                if (icmlistaconfpreciohoraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconfpreciohoraBlock sourceICMLISTACONFPRECIOHORA;
                    sourceICMLISTACONFPRECIOHORA = this.getICMLISTACONFPRECIOHORA();
                    IcmListaconfpreciohoraBlock copyICMLISTACONFPRECIOHORA = ((IcmListaconfpreciohoraBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaconfpreciohora", sourceICMLISTACONFPRECIOHORA), sourceICMLISTACONFPRECIOHORA, (this.icmlistaconfpreciohora!= null)));
                    copy.setICMLISTACONFPRECIOHORA(copyICMLISTACONFPRECIOHORA);
                } else {
                    if (icmlistaconfpreciohoraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaconfpreciohora = null;
                    }
                }
            }
            {
                Boolean icmlistaventacongeladaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaventacongelada!= null));
                if (icmlistaventacongeladaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaventacongeladaBlock sourceICMLISTAVENTACONGELADA;
                    sourceICMLISTAVENTACONGELADA = this.getICMLISTAVENTACONGELADA();
                    IcmListaventacongeladaBlock copyICMLISTAVENTACONGELADA = ((IcmListaventacongeladaBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaventacongelada", sourceICMLISTAVENTACONGELADA), sourceICMLISTAVENTACONGELADA, (this.icmlistaventacongelada!= null)));
                    copy.setICMLISTAVENTACONGELADA(copyICMLISTAVENTACONGELADA);
                } else {
                    if (icmlistaventacongeladaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaventacongelada = null;
                    }
                }
            }
            {
                Boolean icmparamcalconfchventaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalconfchventa!= null));
                if (icmparamcalconfchventaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalconfchventaBlock sourceICMPARAMCALCONFCHVENTA;
                    sourceICMPARAMCALCONFCHVENTA = this.getICMPARAMCALCONFCHVENTA();
                    IcmParamcalconfchventaBlock copyICMPARAMCALCONFCHVENTA = ((IcmParamcalconfchventaBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalconfchventa", sourceICMPARAMCALCONFCHVENTA), sourceICMPARAMCALCONFCHVENTA, (this.icmparamcalconfchventa!= null)));
                    copy.setICMPARAMCALCONFCHVENTA(copyICMPARAMCALCONFCHVENTA);
                } else {
                    if (icmparamcalconfchventaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalconfchventa = null;
                    }
                }
            }
            {
                Boolean icmparamcaldesplazrealShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcaldesplazreal!= null));
                if (icmparamcaldesplazrealShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcaldesplazrealBlock sourceICMPARAMCALDESPLAZREAL;
                    sourceICMPARAMCALDESPLAZREAL = this.getICMPARAMCALDESPLAZREAL();
                    IcmParamcaldesplazrealBlock copyICMPARAMCALDESPLAZREAL = ((IcmParamcaldesplazrealBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcaldesplazreal", sourceICMPARAMCALDESPLAZREAL), sourceICMPARAMCALDESPLAZREAL, (this.icmparamcaldesplazreal!= null)));
                    copy.setICMPARAMCALDESPLAZREAL(copyICMPARAMCALDESPLAZREAL);
                } else {
                    if (icmparamcaldesplazrealShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcaldesplazreal = null;
                    }
                }
            }
            {
                Boolean icmparamcalflagcalculaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalflagcalcula!= null));
                if (icmparamcalflagcalculaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalflagcalculaBlock sourceICMPARAMCALFLAGCALCULA;
                    sourceICMPARAMCALFLAGCALCULA = this.getICMPARAMCALFLAGCALCULA();
                    IcmParamcalflagcalculaBlock copyICMPARAMCALFLAGCALCULA = ((IcmParamcalflagcalculaBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalflagcalcula", sourceICMPARAMCALFLAGCALCULA), sourceICMPARAMCALFLAGCALCULA, (this.icmparamcalflagcalcula!= null)));
                    copy.setICMPARAMCALFLAGCALCULA(copyICMPARAMCALFLAGCALCULA);
                } else {
                    if (icmparamcalflagcalculaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalflagcalcula = null;
                    }
                }
            }
            {
                Boolean icmparamcalliquidacionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalliquidacion!= null));
                if (icmparamcalliquidacionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalliquidacionBlock sourceICMPARAMCALLIQUIDACION;
                    sourceICMPARAMCALLIQUIDACION = this.getICMPARAMCALLIQUIDACION();
                    IcmParamcalliquidacionBlock copyICMPARAMCALLIQUIDACION = ((IcmParamcalliquidacionBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalliquidacion", sourceICMPARAMCALLIQUIDACION), sourceICMPARAMCALLIQUIDACION, (this.icmparamcalliquidacion!= null)));
                    copy.setICMPARAMCALLIQUIDACION(copyICMPARAMCALLIQUIDACION);
                } else {
                    if (icmparamcalliquidacionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalliquidacion = null;
                    }
                }
            }
            {
                Boolean icmparamcalsistdestinoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalsistdestino!= null));
                if (icmparamcalsistdestinoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalsistdestinoBlock sourceICMPARAMCALSISTDESTINO;
                    sourceICMPARAMCALSISTDESTINO = this.getICMPARAMCALSISTDESTINO();
                    IcmParamcalsistdestinoBlock copyICMPARAMCALSISTDESTINO = ((IcmParamcalsistdestinoBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalsistdestino", sourceICMPARAMCALSISTDESTINO), sourceICMPARAMCALSISTDESTINO, (this.icmparamcalsistdestino!= null)));
                    copy.setICMPARAMCALSISTDESTINO(copyICMPARAMCALSISTDESTINO);
                } else {
                    if (icmparamcalsistdestinoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalsistdestino = null;
                    }
                }
            }
            {
                Boolean icmwscalcoperacionesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmwscalcoperaciones!= null));
                if (icmwscalcoperacionesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmWsCalcOperacionesBlock sourceICMWSCALCOPERACIONES;
                    sourceICMWSCALCOPERACIONES = this.getICMWSCALCOPERACIONES();
                    IcmWsCalcOperacionesBlock copyICMWSCALCOPERACIONES = ((IcmWsCalcOperacionesBlock) strategy.copy(LocatorUtils.property(locator, "icmwscalcoperaciones", sourceICMWSCALCOPERACIONES), sourceICMWSCALCOPERACIONES, (this.icmwscalcoperaciones!= null)));
                    copy.setICMWSCALCOPERACIONES(copyICMWSCALCOPERACIONES);
                } else {
                    if (icmwscalcoperacionesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmwscalcoperaciones = null;
                    }
                }
            }
            {
                Boolean icmparamcalmultiempresaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalmultiempresa!= null));
                if (icmparamcalmultiempresaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalmultiempresaBlock sourceICMPARAMCALMULTIEMPRESA;
                    sourceICMPARAMCALMULTIEMPRESA = this.getICMPARAMCALMULTIEMPRESA();
                    IcmParamcalmultiempresaBlock copyICMPARAMCALMULTIEMPRESA = ((IcmParamcalmultiempresaBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalmultiempresa", sourceICMPARAMCALMULTIEMPRESA), sourceICMPARAMCALMULTIEMPRESA, (this.icmparamcalmultiempresa!= null)));
                    copy.setICMPARAMCALMULTIEMPRESA(copyICMPARAMCALMULTIEMPRESA);
                } else {
                    if (icmparamcalmultiempresaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalmultiempresa = null;
                    }
                }
            }
            {
                Boolean icmparamcalplanificadorShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalplanificador!= null));
                if (icmparamcalplanificadorShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalplanificadorBlock sourceICMPARAMCALPLANIFICADOR;
                    sourceICMPARAMCALPLANIFICADOR = this.getICMPARAMCALPLANIFICADOR();
                    IcmParamcalplanificadorBlock copyICMPARAMCALPLANIFICADOR = ((IcmParamcalplanificadorBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalplanificador", sourceICMPARAMCALPLANIFICADOR), sourceICMPARAMCALPLANIFICADOR, (this.icmparamcalplanificador!= null)));
                    copy.setICMPARAMCALPLANIFICADOR(copyICMPARAMCALPLANIFICADOR);
                } else {
                    if (icmparamcalplanificadorShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalplanificador = null;
                    }
                }
            }
            {
                Boolean icmparametrospaginacionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrospaginacion!= null));
                if (icmparametrospaginacionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospaginacionBlock sourceICMPARAMETROSPAGINACION;
                    sourceICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
                    IcmParametrospaginacionBlock copyICMPARAMETROSPAGINACION = ((IcmParametrospaginacionBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrospaginacion", sourceICMPARAMETROSPAGINACION), sourceICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null)));
                    copy.setICMPARAMETROSPAGINACION(copyICMPARAMETROSPAGINACION);
                } else {
                    if (icmparametrospaginacionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrospaginacion = null;
                    }
                }
            }
            {
                Boolean icmlistapresenciamanwlocShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistapresenciamanwloc!= null));
                if (icmlistapresenciamanwlocShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListapresenciamanwlocBlock sourceICMLISTAPRESENCIAMANWLOC;
                    sourceICMLISTAPRESENCIAMANWLOC = this.getICMLISTAPRESENCIAMANWLOC();
                    IcmListapresenciamanwlocBlock copyICMLISTAPRESENCIAMANWLOC = ((IcmListapresenciamanwlocBlock) strategy.copy(LocatorUtils.property(locator, "icmlistapresenciamanwloc", sourceICMLISTAPRESENCIAMANWLOC), sourceICMLISTAPRESENCIAMANWLOC, (this.icmlistapresenciamanwloc!= null)));
                    copy.setICMLISTAPRESENCIAMANWLOC(copyICMLISTAPRESENCIAMANWLOC);
                } else {
                    if (icmlistapresenciamanwlocShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistapresenciamanwloc = null;
                    }
                }
            }
            {
                Boolean icmlistapresupuestoswlocShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistapresupuestoswloc!= null));
                if (icmlistapresupuestoswlocShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListapresupuestoswlocBlock sourceICMLISTAPRESUPUESTOSWLOC;
                    sourceICMLISTAPRESUPUESTOSWLOC = this.getICMLISTAPRESUPUESTOSWLOC();
                    IcmListapresupuestoswlocBlock copyICMLISTAPRESUPUESTOSWLOC = ((IcmListapresupuestoswlocBlock) strategy.copy(LocatorUtils.property(locator, "icmlistapresupuestoswloc", sourceICMLISTAPRESUPUESTOSWLOC), sourceICMLISTAPRESUPUESTOSWLOC, (this.icmlistapresupuestoswloc!= null)));
                    copy.setICMLISTAPRESUPUESTOSWLOC(copyICMLISTAPRESUPUESTOSWLOC);
                } else {
                    if (icmlistapresupuestoswlocShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistapresupuestoswloc = null;
                    }
                }
            }
            {
                Boolean icmlistapresupuestosrangoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistapresupuestosrango!= null));
                if (icmlistapresupuestosrangoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListapresupuestosrangoBlock sourceICMLISTAPRESUPUESTOSRANGO;
                    sourceICMLISTAPRESUPUESTOSRANGO = this.getICMLISTAPRESUPUESTOSRANGO();
                    IcmListapresupuestosrangoBlock copyICMLISTAPRESUPUESTOSRANGO = ((IcmListapresupuestosrangoBlock) strategy.copy(LocatorUtils.property(locator, "icmlistapresupuestosrango", sourceICMLISTAPRESUPUESTOSRANGO), sourceICMLISTAPRESUPUESTOSRANGO, (this.icmlistapresupuestosrango!= null)));
                    copy.setICMLISTAPRESUPUESTOSRANGO(copyICMLISTAPRESUPUESTOSRANGO);
                } else {
                    if (icmlistapresupuestosrangoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistapresupuestosrango = null;
                    }
                }
            }
            {
                Boolean icmparamcalconfpreciohoraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalconfpreciohora!= null));
                if (icmparamcalconfpreciohoraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalconfpreciohoraBlock sourceICMPARAMCALCONFPRECIOHORA;
                    sourceICMPARAMCALCONFPRECIOHORA = this.getICMPARAMCALCONFPRECIOHORA();
                    IcmParamcalconfpreciohoraBlock copyICMPARAMCALCONFPRECIOHORA = ((IcmParamcalconfpreciohoraBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalconfpreciohora", sourceICMPARAMCALCONFPRECIOHORA), sourceICMPARAMCALCONFPRECIOHORA, (this.icmparamcalconfpreciohora!= null)));
                    copy.setICMPARAMCALCONFPRECIOHORA(copyICMPARAMCALCONFPRECIOHORA);
                } else {
                    if (icmparamcalconfpreciohoraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalconfpreciohora = null;
                    }
                }
            }
            {
                Boolean icmparamcalventacongeladaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalventacongelada!= null));
                if (icmparamcalventacongeladaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalventacongeladaBlock sourceICMPARAMCALVENTACONGELADA;
                    sourceICMPARAMCALVENTACONGELADA = this.getICMPARAMCALVENTACONGELADA();
                    IcmParamcalventacongeladaBlock copyICMPARAMCALVENTACONGELADA = ((IcmParamcalventacongeladaBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalventacongelada", sourceICMPARAMCALVENTACONGELADA), sourceICMPARAMCALVENTACONGELADA, (this.icmparamcalventacongelada!= null)));
                    copy.setICMPARAMCALVENTACONGELADA(copyICMPARAMCALVENTACONGELADA);
                } else {
                    if (icmparamcalventacongeladaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalventacongelada = null;
                    }
                }
            }
            {
                Boolean icmparamcalpresenciamanualShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalpresenciamanual!= null));
                if (icmparamcalpresenciamanualShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalpresenciamanualBlock sourceICMPARAMCALPRESENCIAMANUAL;
                    sourceICMPARAMCALPRESENCIAMANUAL = this.getICMPARAMCALPRESENCIAMANUAL();
                    IcmParamcalpresenciamanualBlock copyICMPARAMCALPRESENCIAMANUAL = ((IcmParamcalpresenciamanualBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalpresenciamanual", sourceICMPARAMCALPRESENCIAMANUAL), sourceICMPARAMCALPRESENCIAMANUAL, (this.icmparamcalpresenciamanual!= null)));
                    copy.setICMPARAMCALPRESENCIAMANUAL(copyICMPARAMCALPRESENCIAMANUAL);
                } else {
                    if (icmparamcalpresenciamanualShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalpresenciamanual = null;
                    }
                }
            }
            {
                Boolean icmparamcalempleadosdesplazShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalempleadosdesplaz!= null));
                if (icmparamcalempleadosdesplazShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalempleadosdesplazBlock sourceICMPARAMCALEMPLEADOSDESPLAZ;
                    sourceICMPARAMCALEMPLEADOSDESPLAZ = this.getICMPARAMCALEMPLEADOSDESPLAZ();
                    IcmParamcalempleadosdesplazBlock copyICMPARAMCALEMPLEADOSDESPLAZ = ((IcmParamcalempleadosdesplazBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalempleadosdesplaz", sourceICMPARAMCALEMPLEADOSDESPLAZ), sourceICMPARAMCALEMPLEADOSDESPLAZ, (this.icmparamcalempleadosdesplaz!= null)));
                    copy.setICMPARAMCALEMPLEADOSDESPLAZ(copyICMPARAMCALEMPLEADOSDESPLAZ);
                } else {
                    if (icmparamcalempleadosdesplazShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalempleadosdesplaz = null;
                    }
                }
            }
            {
                Boolean icmparamcalpresupuestoswlocShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalpresupuestoswloc!= null));
                if (icmparamcalpresupuestoswlocShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalpresupuestoswlocBlock sourceICMPARAMCALPRESUPUESTOSWLOC;
                    sourceICMPARAMCALPRESUPUESTOSWLOC = this.getICMPARAMCALPRESUPUESTOSWLOC();
                    IcmParamcalpresupuestoswlocBlock copyICMPARAMCALPRESUPUESTOSWLOC = ((IcmParamcalpresupuestoswlocBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalpresupuestoswloc", sourceICMPARAMCALPRESUPUESTOSWLOC), sourceICMPARAMCALPRESUPUESTOSWLOC, (this.icmparamcalpresupuestoswloc!= null)));
                    copy.setICMPARAMCALPRESUPUESTOSWLOC(copyICMPARAMCALPRESUPUESTOSWLOC);
                } else {
                    if (icmparamcalpresupuestoswlocShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalpresupuestoswloc = null;
                    }
                }
            }
            {
                Boolean icmparamcalpresupuestosrangoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalpresupuestosrango!= null));
                if (icmparamcalpresupuestosrangoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalpresupuestosrangoBlock sourceICMPARAMCALPRESUPUESTOSRANGO;
                    sourceICMPARAMCALPRESUPUESTOSRANGO = this.getICMPARAMCALPRESUPUESTOSRANGO();
                    IcmParamcalpresupuestosrangoBlock copyICMPARAMCALPRESUPUESTOSRANGO = ((IcmParamcalpresupuestosrangoBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalpresupuestosrango", sourceICMPARAMCALPRESUPUESTOSRANGO), sourceICMPARAMCALPRESUPUESTOSRANGO, (this.icmparamcalpresupuestosrango!= null)));
                    copy.setICMPARAMCALPRESUPUESTOSRANGO(copyICMPARAMCALPRESUPUESTOSRANGO);
                } else {
                    if (icmparamcalpresupuestosrangoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalpresupuestosrango = null;
                    }
                }
            }
            {
                Boolean icmparamcalempleadospresenciaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparamcalempleadospresencia!= null));
                if (icmparamcalempleadospresenciaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalempleadospresenciaBlock sourceICMPARAMCALEMPLEADOSPRESENCIA;
                    sourceICMPARAMCALEMPLEADOSPRESENCIA = this.getICMPARAMCALEMPLEADOSPRESENCIA();
                    IcmParamcalempleadospresenciaBlock copyICMPARAMCALEMPLEADOSPRESENCIA = ((IcmParamcalempleadospresenciaBlock) strategy.copy(LocatorUtils.property(locator, "icmparamcalempleadospresencia", sourceICMPARAMCALEMPLEADOSPRESENCIA), sourceICMPARAMCALEMPLEADOSPRESENCIA, (this.icmparamcalempleadospresencia!= null)));
                    copy.setICMPARAMCALEMPLEADOSPRESENCIA(copyICMPARAMCALEMPLEADOSPRESENCIA);
                } else {
                    if (icmparamcalempleadospresenciaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalempleadospresencia = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new M4LoadObject();
    }

}
