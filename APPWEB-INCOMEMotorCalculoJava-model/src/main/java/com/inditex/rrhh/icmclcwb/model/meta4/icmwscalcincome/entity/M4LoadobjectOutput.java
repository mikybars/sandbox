
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * <p>
 * Clase Java para M4LoadobjectOutput complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="M4LoadobjectOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}LogMessage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Icm_Ws_Tools" type="{http://schemas.meta4.com/}Icm_Ws_ToolsBlock"/&gt;
 *         &lt;element name="Icm_Listacadenas" type="{http://schemas.meta4.com/}Icm_ListacadenasBlock"/&gt;
 *         &lt;element name="Icm_Listatiendas" type="{http://schemas.meta4.com/}Icm_ListatiendasBlock"/&gt;
 *         &lt;element name="Icm_Listaempleado" type="{http://schemas.meta4.com/}Icm_ListaempleadoBlock"/&gt;
 *         &lt;element name="Icm_Listaempresas" type="{http://schemas.meta4.com/}Icm_ListaempresasBlock"/&gt;
 *         &lt;element name="Icm_Listaorigenes" type="{http://schemas.meta4.com/}Icm_ListaorigenesBlock"/&gt;
 *         &lt;element name="Icm_Listaperiodos" type="{http://schemas.meta4.com/}Icm_ListaperiodosBlock"/&gt;
 *         &lt;element name="Icm_Listaausencias" type="{http://schemas.meta4.com/}Icm_ListaausenciasBlock"/&gt;
 *         &lt;element name="Icm_Listaempleados" type="{http://schemas.meta4.com/}Icm_ListaempleadosBlock"/&gt;
 *         &lt;element name="Icm_Listapoliticas" type="{http://schemas.meta4.com/}Icm_ListapoliticasBlock"/&gt;
 *         &lt;element name="Icm_Paramcalorigen" type="{http://schemas.meta4.com/}Icm_ParamcalorigenBlock"/&gt;
 *         &lt;element name="Icm_Listaconfchdias" type="{http://schemas.meta4.com/}Icm_ListaconfchdiasBlock"/&gt;
 *         &lt;element name="Icm_Listaconforigen" type="{http://schemas.meta4.com/}Icm_ListaconforigenBlock"/&gt;
 *         &lt;element name="Icm_Listaestructura" type="{http://schemas.meta4.com/}Icm_ListaestructuraBlock"/&gt;
 *         &lt;element name="Icm_Paramcalperiodo" type="{http://schemas.meta4.com/}Icm_ParamcalperiodoBlock"/&gt;
 *         &lt;element name="Icm_Paramcalproceso" type="{http://schemas.meta4.com/}Icm_ParamcalprocesoBlock"/&gt;
 *         &lt;element name="Icm_Listaconfchventa" type="{http://schemas.meta4.com/}Icm_ListaconfchventaBlock"/&gt;
 *         &lt;element name="Icm_Paramcalempleado" type="{http://schemas.meta4.com/}Icm_ParamcalempleadoBlock"/&gt;
 *         &lt;element name="Icm_Paramcalsociedad" type="{http://schemas.meta4.com/}Icm_ParamcalsociedadBlock"/&gt;
 *         &lt;element name="Icm_Parametrosentrada" type="{http://schemas.meta4.com/}Icm_ParametrosentradaBlock"/&gt;
 *         &lt;element name="Icm_Resultadoguardado" type="{http://schemas.meta4.com/}Icm_ResultadoguardadoBlock"/&gt;
 *         &lt;element name="Icm_Listaconfiguracion" type="{http://schemas.meta4.com/}Icm_ListaconfiguracionBlock"/&gt;
 *         &lt;element name="Icm_Paramcalconfchdias" type="{http://schemas.meta4.com/}Icm_ParamcalconfchdiasBlock"/&gt;
 *         &lt;element name="Icm_Paramcalconforigen" type="{http://schemas.meta4.com/}Icm_ParamcalconforigenBlock"/&gt;
 *         &lt;element name="Icm_Paramcalestructura" type="{http://schemas.meta4.com/}Icm_ParamcalestructuraBlock"/&gt;
 *         &lt;element name="Icm_Listaconfpreciohora" type="{http://schemas.meta4.com/}Icm_ListaconfpreciohoraBlock"/&gt;
 *         &lt;element name="Icm_Listaventacongelada" type="{http://schemas.meta4.com/}Icm_ListaventacongeladaBlock"/&gt;
 *         &lt;element name="Icm_Paramcalconfchventa" type="{http://schemas.meta4.com/}Icm_ParamcalconfchventaBlock"/&gt;
 *         &lt;element name="Icm_Ws_Calc_Operaciones" type="{http://schemas.meta4.com/}Icm_Ws_Calc_OperacionesBlock"/&gt;
 *         &lt;element name="Icm_Parametrospaginacion" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
 *         &lt;element name="Icm_Listapresupuestoswloc" type="{http://schemas.meta4.com/}Icm_ListapresupuestoswlocBlock"/&gt;
 *         &lt;element name="Icm_Listapresupuestosrango" type="{http://schemas.meta4.com/}Icm_ListapresupuestosrangoBlock"/&gt;
 *         &lt;element name="Icm_Paramcalconfpreciohora" type="{http://schemas.meta4.com/}Icm_ParamcalconfpreciohoraBlock"/&gt;
 *         &lt;element name="Icm_Paramcalventacongelada" type="{http://schemas.meta4.com/}Icm_ParamcalventacongeladaBlock"/&gt;
 *         &lt;element name="Icm_Paramcalpresupuestoswloc" type="{http://schemas.meta4.com/}Icm_ParamcalpresupuestoswlocBlock"/&gt;
 *         &lt;element name="Icm_Paramcalpresupuestosrango" type="{http://schemas.meta4.com/}Icm_ParamcalpresupuestosrangoBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "M4LoadobjectOutput", propOrder = {
        "_return",
        "logMessage",
        "icmWsTools",
        "icmListacadenas",
        "icmListatiendas",
        "icmListaempleado",
        "icmListaempresas",
        "icmListaorigenes",
        "icmListaperiodos",
        "icmListaausencias",
        "icmListaempleados",
        "icmListapoliticas",
        "icmParamcalorigen",
        "icmListaconfchdias",
        "icmListaconforigen",
        "icmListaestructura",
        "icmParamcalperiodo",
        "icmParamcalproceso",
        "icmListaconfchventa",
        "icmParamcalempleado",
        "icmParamcalsociedad",
        "icmParametrosentrada",
        "icmResultadoguardado",
        "icmListaconfiguracion",
        "icmParamcalconfchdias",
        "icmParamcalconforigen",
        "icmParamcalestructura",
        "icmListaconfpreciohora",
        "icmListaventacongelada",
        "icmParamcalconfchventa",
        "icmWsCalcOperaciones",
        "icmParametrospaginacion",
        "icmListapresupuestoswloc",
        "icmListapresupuestosrango",
        "icmParamcalconfpreciohora",
        "icmParamcalventacongelada",
        "icmParamcalpresupuestoswloc",
        "icmParamcalpresupuestosrango"
})
public class M4LoadobjectOutput implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

    private final static long serialVersionUID = 1L;

    @XmlElement(name = "return")
    protected double _return;

    @XmlElement(nillable = true)
    protected List<LogMessage> logMessage;

    @XmlElement(name = "Icm_Ws_Tools", required = true, nillable = true)
    protected IcmWsToolsBlock icmWsTools;

    @XmlElement(name = "Icm_Listacadenas", required = true, nillable = true)
    protected IcmListacadenasBlock icmListacadenas;

    @XmlElement(name = "Icm_Listatiendas", required = true, nillable = true)
    protected IcmListatiendasBlock icmListatiendas;

    @XmlElement(name = "Icm_Listaempleado", required = true, nillable = true)
    protected IcmListaempleadoBlock icmListaempleado;

    @XmlElement(name = "Icm_Listaempresas", required = true, nillable = true)
    protected IcmListaempresasBlock icmListaempresas;

    @XmlElement(name = "Icm_Listaorigenes", required = true, nillable = true)
    protected IcmListaorigenesBlock icmListaorigenes;

    @XmlElement(name = "Icm_Listaperiodos", required = true, nillable = true)
    protected IcmListaperiodosBlock icmListaperiodos;

    @XmlElement(name = "Icm_Listaausencias", required = true, nillable = true)
    protected IcmListaausenciasBlock icmListaausencias;

    @XmlElement(name = "Icm_Listaempleados", required = true, nillable = true)
    protected IcmListaempleadosBlock icmListaempleados;

    @XmlElement(name = "Icm_Listapoliticas", required = true, nillable = true)
    protected IcmListapoliticasBlock icmListapoliticas;

    @XmlElement(name = "Icm_Paramcalorigen", required = true, nillable = true)
    protected IcmParamcalorigenBlock icmParamcalorigen;

    @XmlElement(name = "Icm_Listaconfchdias", required = true, nillable = true)
    protected IcmListaconfchdiasBlock icmListaconfchdias;

    @XmlElement(name = "Icm_Listaconforigen", required = true, nillable = true)
    protected IcmListaconforigenBlock icmListaconforigen;

    @XmlElement(name = "Icm_Listaestructura", required = true, nillable = true)
    protected IcmListaestructuraBlock icmListaestructura;

    @XmlElement(name = "Icm_Paramcalperiodo", required = true, nillable = true)
    protected IcmParamcalperiodoBlock icmParamcalperiodo;

    @XmlElement(name = "Icm_Paramcalproceso", required = true, nillable = true)
    protected IcmParamcalprocesoBlock icmParamcalproceso;

    @XmlElement(name = "Icm_Listaconfchventa", required = true, nillable = true)
    protected IcmListaconfchventaBlock icmListaconfchventa;

    @XmlElement(name = "Icm_Paramcalempleado", required = true, nillable = true)
    protected IcmParamcalempleadoBlock icmParamcalempleado;

    @XmlElement(name = "Icm_Paramcalsociedad", required = true, nillable = true)
    protected IcmParamcalsociedadBlock icmParamcalsociedad;

    @XmlElement(name = "Icm_Parametrosentrada", required = true, nillable = true)
    protected IcmParametrosentradaBlock icmParametrosentrada;

    @XmlElement(name = "Icm_Resultadoguardado", required = true, nillable = true)
    protected IcmResultadoguardadoBlock icmResultadoguardado;

    @XmlElement(name = "Icm_Listaconfiguracion", required = true, nillable = true)
    protected IcmListaconfiguracionBlock icmListaconfiguracion;

    @XmlElement(name = "Icm_Paramcalconfchdias", required = true, nillable = true)
    protected IcmParamcalconfchdiasBlock icmParamcalconfchdias;

    @XmlElement(name = "Icm_Paramcalconforigen", required = true, nillable = true)
    protected IcmParamcalconforigenBlock icmParamcalconforigen;

    @XmlElement(name = "Icm_Paramcalestructura", required = true, nillable = true)
    protected IcmParamcalestructuraBlock icmParamcalestructura;

    @XmlElement(name = "Icm_Listaconfpreciohora", required = true, nillable = true)
    protected IcmListaconfpreciohoraBlock icmListaconfpreciohora;

    @XmlElement(name = "Icm_Listaventacongelada", required = true, nillable = true)
    protected IcmListaventacongeladaBlock icmListaventacongelada;

    @XmlElement(name = "Icm_Paramcalconfchventa", required = true, nillable = true)
    protected IcmParamcalconfchventaBlock icmParamcalconfchventa;

    @XmlElement(name = "Icm_Ws_Calc_Operaciones", required = true, nillable = true)
    protected IcmWsCalcOperacionesBlock icmWsCalcOperaciones;

    @XmlElement(name = "Icm_Parametrospaginacion", required = true, nillable = true)
    protected IcmParametrospaginacionBlock icmParametrospaginacion;

    @XmlElement(name = "Icm_Listapresupuestoswloc", required = true, nillable = true)
    protected IcmListapresupuestoswlocBlock icmListapresupuestoswloc;

    @XmlElement(name = "Icm_Listapresupuestosrango", required = true, nillable = true)
    protected IcmListapresupuestosrangoBlock icmListapresupuestosrango;

    @XmlElement(name = "Icm_Paramcalconfpreciohora", required = true, nillable = true)
    protected IcmParamcalconfpreciohoraBlock icmParamcalconfpreciohora;

    @XmlElement(name = "Icm_Paramcalventacongelada", required = true, nillable = true)
    protected IcmParamcalventacongeladaBlock icmParamcalventacongelada;

    @XmlElement(name = "Icm_Paramcalpresupuestoswloc", required = true, nillable = true)
    protected IcmParamcalpresupuestoswlocBlock icmParamcalpresupuestoswloc;

    @XmlElement(name = "Icm_Paramcalpresupuestosrango", required = true, nillable = true)
    protected IcmParamcalpresupuestosrangoBlock icmParamcalpresupuestosrango;

    /**
     * Obtiene el valor de la propiedad return.
     *
     */
    public double getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     *
     */
    public void setReturn(double value) {
        this._return = value;
    }

    /**
     * Gets the value of the logMessage property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is why
     * there is not a <CODE>set</CODE> method for the logMessage property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getLogMessage().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link LogMessage }
     *
     *
     */
    public List<LogMessage> getLogMessage() {
        if (logMessage == null) {
            logMessage = new ArrayList<LogMessage>();
        }
        return this.logMessage;
    }

    /**
     * Obtiene el valor de la propiedad icmWsTools.
     * @return possible object is {@link IcmWsToolsBlock }
     *
     */
    public IcmWsToolsBlock getIcmWsTools() {
        return icmWsTools;
    }

    /**
     * Define el valor de la propiedad icmWsTools.
     * @param value allowed object is {@link IcmWsToolsBlock }
     *
     */
    public void setIcmWsTools(IcmWsToolsBlock value) {
        this.icmWsTools = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListacadenas.
     * @return possible object is {@link IcmListacadenasBlock }
     *
     */
    public IcmListacadenasBlock getIcmListacadenas() {
        return icmListacadenas;
    }

    /**
     * Define el valor de la propiedad icmListacadenas.
     * @param value allowed object is {@link IcmListacadenasBlock }
     *
     */
    public void setIcmListacadenas(IcmListacadenasBlock value) {
        this.icmListacadenas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListatiendas.
     * @return possible object is {@link IcmListatiendasBlock }
     *
     */
    public IcmListatiendasBlock getIcmListatiendas() {
        return icmListatiendas;
    }

    /**
     * Define el valor de la propiedad icmListatiendas.
     * @param value allowed object is {@link IcmListatiendasBlock }
     *
     */
    public void setIcmListatiendas(IcmListatiendasBlock value) {
        this.icmListatiendas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaempleado.
     * @return possible object is {@link IcmListaempleadoBlock }
     *
     */
    public IcmListaempleadoBlock getIcmListaempleado() {
        return icmListaempleado;
    }

    /**
     * Define el valor de la propiedad icmListaempleado.
     * @param value allowed object is {@link IcmListaempleadoBlock }
     *
     */
    public void setIcmListaempleado(IcmListaempleadoBlock value) {
        this.icmListaempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaempresas.
     * @return possible object is {@link IcmListaempresasBlock }
     *
     */
    public IcmListaempresasBlock getIcmListaempresas() {
        return icmListaempresas;
    }

    /**
     * Define el valor de la propiedad icmListaempresas.
     * @param value allowed object is {@link IcmListaempresasBlock }
     *
     */
    public void setIcmListaempresas(IcmListaempresasBlock value) {
        this.icmListaempresas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaorigenes.
     * @return possible object is {@link IcmListaorigenesBlock }
     *
     */
    public IcmListaorigenesBlock getIcmListaorigenes() {
        return icmListaorigenes;
    }

    /**
     * Define el valor de la propiedad icmListaorigenes.
     * @param value allowed object is {@link IcmListaorigenesBlock }
     *
     */
    public void setIcmListaorigenes(IcmListaorigenesBlock value) {
        this.icmListaorigenes = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaperiodos.
     * @return possible object is {@link IcmListaperiodosBlock }
     *
     */
    public IcmListaperiodosBlock getIcmListaperiodos() {
        return icmListaperiodos;
    }

    /**
     * Define el valor de la propiedad icmListaperiodos.
     * @param value allowed object is {@link IcmListaperiodosBlock }
     *
     */
    public void setIcmListaperiodos(IcmListaperiodosBlock value) {
        this.icmListaperiodos = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaausencias.
     * @return possible object is {@link IcmListaausenciasBlock }
     *
     */
    public IcmListaausenciasBlock getIcmListaausencias() {
        return icmListaausencias;
    }

    /**
     * Define el valor de la propiedad icmListaausencias.
     * @param value allowed object is {@link IcmListaausenciasBlock }
     *
     */
    public void setIcmListaausencias(IcmListaausenciasBlock value) {
        this.icmListaausencias = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaempleados.
     * @return possible object is {@link IcmListaempleadosBlock }
     *
     */
    public IcmListaempleadosBlock getIcmListaempleados() {
        return icmListaempleados;
    }

    /**
     * Define el valor de la propiedad icmListaempleados.
     * @param value allowed object is {@link IcmListaempleadosBlock }
     *
     */
    public void setIcmListaempleados(IcmListaempleadosBlock value) {
        this.icmListaempleados = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListapoliticas.
     * @return possible object is {@link IcmListapoliticasBlock }
     *
     */
    public IcmListapoliticasBlock getIcmListapoliticas() {
        return icmListapoliticas;
    }

    /**
     * Define el valor de la propiedad icmListapoliticas.
     * @param value allowed object is {@link IcmListapoliticasBlock }
     *
     */
    public void setIcmListapoliticas(IcmListapoliticasBlock value) {
        this.icmListapoliticas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalorigen.
     * @return possible object is {@link IcmParamcalorigenBlock }
     *
     */
    public IcmParamcalorigenBlock getIcmParamcalorigen() {
        return icmParamcalorigen;
    }

    /**
     * Define el valor de la propiedad icmParamcalorigen.
     * @param value allowed object is {@link IcmParamcalorigenBlock }
     *
     */
    public void setIcmParamcalorigen(IcmParamcalorigenBlock value) {
        this.icmParamcalorigen = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaconfchdias.
     * @return possible object is {@link IcmListaconfchdiasBlock }
     *
     */
    public IcmListaconfchdiasBlock getIcmListaconfchdias() {
        return icmListaconfchdias;
    }

    /**
     * Define el valor de la propiedad icmListaconfchdias.
     * @param value allowed object is {@link IcmListaconfchdiasBlock }
     *
     */
    public void setIcmListaconfchdias(IcmListaconfchdiasBlock value) {
        this.icmListaconfchdias = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaconforigen.
     * @return possible object is {@link IcmListaconforigenBlock }
     *
     */
    public IcmListaconforigenBlock getIcmListaconforigen() {
        return icmListaconforigen;
    }

    /**
     * Define el valor de la propiedad icmListaconforigen.
     * @param value allowed object is {@link IcmListaconforigenBlock }
     *
     */
    public void setIcmListaconforigen(IcmListaconforigenBlock value) {
        this.icmListaconforigen = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaestructura.
     * @return possible object is {@link IcmListaestructuraBlock }
     *
     */
    public IcmListaestructuraBlock getIcmListaestructura() {
        return icmListaestructura;
    }

    /**
     * Define el valor de la propiedad icmListaestructura.
     * @param value allowed object is {@link IcmListaestructuraBlock }
     *
     */
    public void setIcmListaestructura(IcmListaestructuraBlock value) {
        this.icmListaestructura = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalperiodo.
     * @return possible object is {@link IcmParamcalperiodoBlock }
     *
     */
    public IcmParamcalperiodoBlock getIcmParamcalperiodo() {
        return icmParamcalperiodo;
    }

    /**
     * Define el valor de la propiedad icmParamcalperiodo.
     * @param value allowed object is {@link IcmParamcalperiodoBlock }
     *
     */
    public void setIcmParamcalperiodo(IcmParamcalperiodoBlock value) {
        this.icmParamcalperiodo = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalproceso.
     * @return possible object is {@link IcmParamcalprocesoBlock }
     *
     */
    public IcmParamcalprocesoBlock getIcmParamcalproceso() {
        return icmParamcalproceso;
    }

    /**
     * Define el valor de la propiedad icmParamcalproceso.
     * @param value allowed object is {@link IcmParamcalprocesoBlock }
     *
     */
    public void setIcmParamcalproceso(IcmParamcalprocesoBlock value) {
        this.icmParamcalproceso = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaconfchventa.
     * @return possible object is {@link IcmListaconfchventaBlock }
     *
     */
    public IcmListaconfchventaBlock getIcmListaconfchventa() {
        return icmListaconfchventa;
    }

    /**
     * Define el valor de la propiedad icmListaconfchventa.
     * @param value allowed object is {@link IcmListaconfchventaBlock }
     *
     */
    public void setIcmListaconfchventa(IcmListaconfchventaBlock value) {
        this.icmListaconfchventa = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalempleado.
     * @return possible object is {@link IcmParamcalempleadoBlock }
     *
     */
    public IcmParamcalempleadoBlock getIcmParamcalempleado() {
        return icmParamcalempleado;
    }

    /**
     * Define el valor de la propiedad icmParamcalempleado.
     * @param value allowed object is {@link IcmParamcalempleadoBlock }
     *
     */
    public void setIcmParamcalempleado(IcmParamcalempleadoBlock value) {
        this.icmParamcalempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalsociedad.
     * @return possible object is {@link IcmParamcalsociedadBlock }
     *
     */
    public IcmParamcalsociedadBlock getIcmParamcalsociedad() {
        return icmParamcalsociedad;
    }

    /**
     * Define el valor de la propiedad icmParamcalsociedad.
     * @param value allowed object is {@link IcmParamcalsociedadBlock }
     *
     */
    public void setIcmParamcalsociedad(IcmParamcalsociedadBlock value) {
        this.icmParamcalsociedad = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrosentrada.
     * @return possible object is {@link IcmParametrosentradaBlock }
     *
     */
    public IcmParametrosentradaBlock getIcmParametrosentrada() {
        return icmParametrosentrada;
    }

    /**
     * Define el valor de la propiedad icmParametrosentrada.
     * @param value allowed object is {@link IcmParametrosentradaBlock }
     *
     */
    public void setIcmParametrosentrada(IcmParametrosentradaBlock value) {
        this.icmParametrosentrada = value;
    }

    /**
     * Obtiene el valor de la propiedad icmResultadoguardado.
     * @return possible object is {@link IcmResultadoguardadoBlock }
     *
     */
    public IcmResultadoguardadoBlock getIcmResultadoguardado() {
        return icmResultadoguardado;
    }

    /**
     * Define el valor de la propiedad icmResultadoguardado.
     * @param value allowed object is {@link IcmResultadoguardadoBlock }
     *
     */
    public void setIcmResultadoguardado(IcmResultadoguardadoBlock value) {
        this.icmResultadoguardado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaconfiguracion.
     * @return possible object is {@link IcmListaconfiguracionBlock }
     *
     */
    public IcmListaconfiguracionBlock getIcmListaconfiguracion() {
        return icmListaconfiguracion;
    }

    /**
     * Define el valor de la propiedad icmListaconfiguracion.
     * @param value allowed object is {@link IcmListaconfiguracionBlock }
     *
     */
    public void setIcmListaconfiguracion(IcmListaconfiguracionBlock value) {
        this.icmListaconfiguracion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalconfchdias.
     * @return possible object is {@link IcmParamcalconfchdiasBlock }
     *
     */
    public IcmParamcalconfchdiasBlock getIcmParamcalconfchdias() {
        return icmParamcalconfchdias;
    }

    /**
     * Define el valor de la propiedad icmParamcalconfchdias.
     * @param value allowed object is {@link IcmParamcalconfchdiasBlock }
     *
     */
    public void setIcmParamcalconfchdias(IcmParamcalconfchdiasBlock value) {
        this.icmParamcalconfchdias = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalconforigen.
     * @return possible object is {@link IcmParamcalconforigenBlock }
     *
     */
    public IcmParamcalconforigenBlock getIcmParamcalconforigen() {
        return icmParamcalconforigen;
    }

    /**
     * Define el valor de la propiedad icmParamcalconforigen.
     * @param value allowed object is {@link IcmParamcalconforigenBlock }
     *
     */
    public void setIcmParamcalconforigen(IcmParamcalconforigenBlock value) {
        this.icmParamcalconforigen = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalestructura.
     * @return possible object is {@link IcmParamcalestructuraBlock }
     *
     */
    public IcmParamcalestructuraBlock getIcmParamcalestructura() {
        return icmParamcalestructura;
    }

    /**
     * Define el valor de la propiedad icmParamcalestructura.
     * @param value allowed object is {@link IcmParamcalestructuraBlock }
     *
     */
    public void setIcmParamcalestructura(IcmParamcalestructuraBlock value) {
        this.icmParamcalestructura = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaconfpreciohora.
     * @return possible object is {@link IcmListaconfpreciohoraBlock }
     *
     */
    public IcmListaconfpreciohoraBlock getIcmListaconfpreciohora() {
        return icmListaconfpreciohora;
    }

    /**
     * Define el valor de la propiedad icmListaconfpreciohora.
     * @param value allowed object is {@link IcmListaconfpreciohoraBlock }
     *
     */
    public void setIcmListaconfpreciohora(IcmListaconfpreciohoraBlock value) {
        this.icmListaconfpreciohora = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaventacongelada.
     * @return possible object is {@link IcmListaventacongeladaBlock }
     *
     */
    public IcmListaventacongeladaBlock getIcmListaventacongelada() {
        return icmListaventacongelada;
    }

    /**
     * Define el valor de la propiedad icmListaventacongelada.
     * @param value allowed object is {@link IcmListaventacongeladaBlock }
     *
     */
    public void setIcmListaventacongelada(IcmListaventacongeladaBlock value) {
        this.icmListaventacongelada = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalconfchventa.
     * @return possible object is {@link IcmParamcalconfchventaBlock }
     *
     */
    public IcmParamcalconfchventaBlock getIcmParamcalconfchventa() {
        return icmParamcalconfchventa;
    }

    /**
     * Define el valor de la propiedad icmParamcalconfchventa.
     * @param value allowed object is {@link IcmParamcalconfchventaBlock }
     *
     */
    public void setIcmParamcalconfchventa(IcmParamcalconfchventaBlock value) {
        this.icmParamcalconfchventa = value;
    }

    /**
     * Obtiene el valor de la propiedad icmWsCalcOperaciones.
     * @return possible object is {@link IcmWsCalcOperacionesBlock }
     *
     */
    public IcmWsCalcOperacionesBlock getIcmWsCalcOperaciones() {
        return icmWsCalcOperaciones;
    }

    /**
     * Define el valor de la propiedad icmWsCalcOperaciones.
     * @param value allowed object is {@link IcmWsCalcOperacionesBlock }
     *
     */
    public void setIcmWsCalcOperaciones(IcmWsCalcOperacionesBlock value) {
        this.icmWsCalcOperaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrospaginacion.
     * @return possible object is {@link IcmParametrospaginacionBlock }
     *
     */
    public IcmParametrospaginacionBlock getIcmParametrospaginacion() {
        return icmParametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmParametrospaginacion.
     * @param value allowed object is {@link IcmParametrospaginacionBlock }
     *
     */
    public void setIcmParametrospaginacion(IcmParametrospaginacionBlock value) {
        this.icmParametrospaginacion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListapresupuestoswloc.
     * @return possible object is {@link IcmListapresupuestoswlocBlock }
     *
     */
    public IcmListapresupuestoswlocBlock getIcmListapresupuestoswloc() {
        return icmListapresupuestoswloc;
    }

    /**
     * Define el valor de la propiedad icmListapresupuestoswloc.
     * @param value allowed object is {@link IcmListapresupuestoswlocBlock }
     *
     */
    public void setIcmListapresupuestoswloc(IcmListapresupuestoswlocBlock value) {
        this.icmListapresupuestoswloc = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListapresupuestosrango.
     * @return possible object is {@link IcmListapresupuestosrangoBlock }
     *
     */
    public IcmListapresupuestosrangoBlock getIcmListapresupuestosrango() {
        return icmListapresupuestosrango;
    }

    /**
     * Define el valor de la propiedad icmListapresupuestosrango.
     * @param value allowed object is {@link IcmListapresupuestosrangoBlock }
     *
     */
    public void setIcmListapresupuestosrango(IcmListapresupuestosrangoBlock value) {
        this.icmListapresupuestosrango = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalconfpreciohora.
     * @return possible object is {@link IcmParamcalconfpreciohoraBlock }
     *
     */
    public IcmParamcalconfpreciohoraBlock getIcmParamcalconfpreciohora() {
        return icmParamcalconfpreciohora;
    }

    /**
     * Define el valor de la propiedad icmParamcalconfpreciohora.
     * @param value allowed object is {@link IcmParamcalconfpreciohoraBlock }
     *
     */
    public void setIcmParamcalconfpreciohora(IcmParamcalconfpreciohoraBlock value) {
        this.icmParamcalconfpreciohora = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalventacongelada.
     * @return possible object is {@link IcmParamcalventacongeladaBlock }
     *
     */
    public IcmParamcalventacongeladaBlock getIcmParamcalventacongelada() {
        return icmParamcalventacongelada;
    }

    /**
     * Define el valor de la propiedad icmParamcalventacongelada.
     * @param value allowed object is {@link IcmParamcalventacongeladaBlock }
     *
     */
    public void setIcmParamcalventacongelada(IcmParamcalventacongeladaBlock value) {
        this.icmParamcalventacongelada = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalpresupuestoswloc.
     * @return possible object is {@link IcmParamcalpresupuestoswlocBlock }
     *
     */
    public IcmParamcalpresupuestoswlocBlock getIcmParamcalpresupuestoswloc() {
        return icmParamcalpresupuestoswloc;
    }

    /**
     * Define el valor de la propiedad icmParamcalpresupuestoswloc.
     * @param value allowed object is {@link IcmParamcalpresupuestoswlocBlock }
     *
     */
    public void setIcmParamcalpresupuestoswloc(IcmParamcalpresupuestoswlocBlock value) {
        this.icmParamcalpresupuestoswloc = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalpresupuestosrango.
     * @return possible object is {@link IcmParamcalpresupuestosrangoBlock }
     *
     */
    public IcmParamcalpresupuestosrangoBlock getIcmParamcalpresupuestosrango() {
        return icmParamcalpresupuestosrango;
    }

    /**
     * Define el valor de la propiedad icmParamcalpresupuestosrango.
     * @param value allowed object is {@link IcmParamcalpresupuestosrangoBlock }
     *
     */
    public void setIcmParamcalpresupuestosrango(IcmParamcalpresupuestosrangoBlock value) {
        this.icmParamcalpresupuestosrango = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object,
            EqualsStrategy2 strategy) {
        if ((object == null) || (this.getClass() != object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final M4LoadobjectOutput that = ((M4LoadobjectOutput) object);
        {
            double lhsReturn;
            lhsReturn = this.getReturn();
            double rhsReturn;
            rhsReturn = that.getReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "_return", lhsReturn),
                    LocatorUtils.property(thatLocator, "_return", rhsReturn), lhsReturn, rhsReturn, true, true)) {
                return false;
            }
        }
        {
            List<LogMessage> lhsLogMessage;
            lhsLogMessage = (((this.logMessage != null) && (!this.logMessage.isEmpty())) ? this.getLogMessage() : null);
            List<LogMessage> rhsLogMessage;
            rhsLogMessage = (((that.logMessage != null) && (!that.logMessage.isEmpty())) ? that.getLogMessage() : null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "logMessage", lhsLogMessage),
                    LocatorUtils.property(thatLocator, "logMessage", rhsLogMessage), lhsLogMessage, rhsLogMessage,
                    ((this.logMessage != null) && (!this.logMessage.isEmpty())),
                    ((that.logMessage != null) && (!that.logMessage.isEmpty())))) {
                return false;
            }
        }
        {
            IcmWsToolsBlock lhsIcmWsTools;
            lhsIcmWsTools = this.getIcmWsTools();
            IcmWsToolsBlock rhsIcmWsTools;
            rhsIcmWsTools = that.getIcmWsTools();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmWsTools", lhsIcmWsTools),
                    LocatorUtils.property(thatLocator, "icmWsTools", rhsIcmWsTools), lhsIcmWsTools, rhsIcmWsTools,
                    (this.icmWsTools != null), (that.icmWsTools != null))) {
                return false;
            }
        }
        {
            IcmListacadenasBlock lhsIcmListacadenas;
            lhsIcmListacadenas = this.getIcmListacadenas();
            IcmListacadenasBlock rhsIcmListacadenas;
            rhsIcmListacadenas = that.getIcmListacadenas();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListacadenas", lhsIcmListacadenas),
                    LocatorUtils.property(thatLocator, "icmListacadenas", rhsIcmListacadenas), lhsIcmListacadenas,
                    rhsIcmListacadenas, (this.icmListacadenas != null), (that.icmListacadenas != null))) {
                return false;
            }
        }
        {
            IcmListatiendasBlock lhsIcmListatiendas;
            lhsIcmListatiendas = this.getIcmListatiendas();
            IcmListatiendasBlock rhsIcmListatiendas;
            rhsIcmListatiendas = that.getIcmListatiendas();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListatiendas", lhsIcmListatiendas),
                    LocatorUtils.property(thatLocator, "icmListatiendas", rhsIcmListatiendas), lhsIcmListatiendas,
                    rhsIcmListatiendas, (this.icmListatiendas != null), (that.icmListatiendas != null))) {
                return false;
            }
        }
        {
            IcmListaempleadoBlock lhsIcmListaempleado;
            lhsIcmListaempleado = this.getIcmListaempleado();
            IcmListaempleadoBlock rhsIcmListaempleado;
            rhsIcmListaempleado = that.getIcmListaempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaempleado", lhsIcmListaempleado),
                    LocatorUtils.property(thatLocator, "icmListaempleado", rhsIcmListaempleado), lhsIcmListaempleado,
                    rhsIcmListaempleado, (this.icmListaempleado != null), (that.icmListaempleado != null))) {
                return false;
            }
        }
        {
            IcmListaempresasBlock lhsIcmListaempresas;
            lhsIcmListaempresas = this.getIcmListaempresas();
            IcmListaempresasBlock rhsIcmListaempresas;
            rhsIcmListaempresas = that.getIcmListaempresas();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaempresas", lhsIcmListaempresas),
                    LocatorUtils.property(thatLocator, "icmListaempresas", rhsIcmListaempresas), lhsIcmListaempresas,
                    rhsIcmListaempresas, (this.icmListaempresas != null), (that.icmListaempresas != null))) {
                return false;
            }
        }
        {
            IcmListaorigenesBlock lhsIcmListaorigenes;
            lhsIcmListaorigenes = this.getIcmListaorigenes();
            IcmListaorigenesBlock rhsIcmListaorigenes;
            rhsIcmListaorigenes = that.getIcmListaorigenes();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaorigenes", lhsIcmListaorigenes),
                    LocatorUtils.property(thatLocator, "icmListaorigenes", rhsIcmListaorigenes), lhsIcmListaorigenes,
                    rhsIcmListaorigenes, (this.icmListaorigenes != null), (that.icmListaorigenes != null))) {
                return false;
            }
        }
        {
            IcmListaperiodosBlock lhsIcmListaperiodos;
            lhsIcmListaperiodos = this.getIcmListaperiodos();
            IcmListaperiodosBlock rhsIcmListaperiodos;
            rhsIcmListaperiodos = that.getIcmListaperiodos();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaperiodos", lhsIcmListaperiodos),
                    LocatorUtils.property(thatLocator, "icmListaperiodos", rhsIcmListaperiodos), lhsIcmListaperiodos,
                    rhsIcmListaperiodos, (this.icmListaperiodos != null), (that.icmListaperiodos != null))) {
                return false;
            }
        }
        {
            IcmListaausenciasBlock lhsIcmListaausencias;
            lhsIcmListaausencias = this.getIcmListaausencias();
            IcmListaausenciasBlock rhsIcmListaausencias;
            rhsIcmListaausencias = that.getIcmListaausencias();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaausencias", lhsIcmListaausencias),
                    LocatorUtils.property(thatLocator, "icmListaausencias", rhsIcmListaausencias), lhsIcmListaausencias,
                    rhsIcmListaausencias, (this.icmListaausencias != null), (that.icmListaausencias != null))) {
                return false;
            }
        }
        {
            IcmListaempleadosBlock lhsIcmListaempleados;
            lhsIcmListaempleados = this.getIcmListaempleados();
            IcmListaempleadosBlock rhsIcmListaempleados;
            rhsIcmListaempleados = that.getIcmListaempleados();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaempleados", lhsIcmListaempleados),
                    LocatorUtils.property(thatLocator, "icmListaempleados", rhsIcmListaempleados), lhsIcmListaempleados,
                    rhsIcmListaempleados, (this.icmListaempleados != null), (that.icmListaempleados != null))) {
                return false;
            }
        }
        {
            IcmListapoliticasBlock lhsIcmListapoliticas;
            lhsIcmListapoliticas = this.getIcmListapoliticas();
            IcmListapoliticasBlock rhsIcmListapoliticas;
            rhsIcmListapoliticas = that.getIcmListapoliticas();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListapoliticas", lhsIcmListapoliticas),
                    LocatorUtils.property(thatLocator, "icmListapoliticas", rhsIcmListapoliticas), lhsIcmListapoliticas,
                    rhsIcmListapoliticas, (this.icmListapoliticas != null), (that.icmListapoliticas != null))) {
                return false;
            }
        }
        {
            IcmParamcalorigenBlock lhsIcmParamcalorigen;
            lhsIcmParamcalorigen = this.getIcmParamcalorigen();
            IcmParamcalorigenBlock rhsIcmParamcalorigen;
            rhsIcmParamcalorigen = that.getIcmParamcalorigen();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalorigen", lhsIcmParamcalorigen),
                    LocatorUtils.property(thatLocator, "icmParamcalorigen", rhsIcmParamcalorigen), lhsIcmParamcalorigen,
                    rhsIcmParamcalorigen, (this.icmParamcalorigen != null), (that.icmParamcalorigen != null))) {
                return false;
            }
        }
        {
            IcmListaconfchdiasBlock lhsIcmListaconfchdias;
            lhsIcmListaconfchdias = this.getIcmListaconfchdias();
            IcmListaconfchdiasBlock rhsIcmListaconfchdias;
            rhsIcmListaconfchdias = that.getIcmListaconfchdias();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconfchdias", lhsIcmListaconfchdias),
                    LocatorUtils.property(thatLocator, "icmListaconfchdias", rhsIcmListaconfchdias),
                    lhsIcmListaconfchdias, rhsIcmListaconfchdias, (this.icmListaconfchdias != null),
                    (that.icmListaconfchdias != null))) {
                return false;
            }
        }
        {
            IcmListaconforigenBlock lhsIcmListaconforigen;
            lhsIcmListaconforigen = this.getIcmListaconforigen();
            IcmListaconforigenBlock rhsIcmListaconforigen;
            rhsIcmListaconforigen = that.getIcmListaconforigen();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconforigen", lhsIcmListaconforigen),
                    LocatorUtils.property(thatLocator, "icmListaconforigen", rhsIcmListaconforigen),
                    lhsIcmListaconforigen, rhsIcmListaconforigen, (this.icmListaconforigen != null),
                    (that.icmListaconforigen != null))) {
                return false;
            }
        }
        {
            IcmListaestructuraBlock lhsIcmListaestructura;
            lhsIcmListaestructura = this.getIcmListaestructura();
            IcmListaestructuraBlock rhsIcmListaestructura;
            rhsIcmListaestructura = that.getIcmListaestructura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaestructura", lhsIcmListaestructura),
                    LocatorUtils.property(thatLocator, "icmListaestructura", rhsIcmListaestructura),
                    lhsIcmListaestructura, rhsIcmListaestructura, (this.icmListaestructura != null),
                    (that.icmListaestructura != null))) {
                return false;
            }
        }
        {
            IcmParamcalperiodoBlock lhsIcmParamcalperiodo;
            lhsIcmParamcalperiodo = this.getIcmParamcalperiodo();
            IcmParamcalperiodoBlock rhsIcmParamcalperiodo;
            rhsIcmParamcalperiodo = that.getIcmParamcalperiodo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalperiodo", lhsIcmParamcalperiodo),
                    LocatorUtils.property(thatLocator, "icmParamcalperiodo", rhsIcmParamcalperiodo),
                    lhsIcmParamcalperiodo, rhsIcmParamcalperiodo, (this.icmParamcalperiodo != null),
                    (that.icmParamcalperiodo != null))) {
                return false;
            }
        }
        {
            IcmParamcalprocesoBlock lhsIcmParamcalproceso;
            lhsIcmParamcalproceso = this.getIcmParamcalproceso();
            IcmParamcalprocesoBlock rhsIcmParamcalproceso;
            rhsIcmParamcalproceso = that.getIcmParamcalproceso();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalproceso", lhsIcmParamcalproceso),
                    LocatorUtils.property(thatLocator, "icmParamcalproceso", rhsIcmParamcalproceso),
                    lhsIcmParamcalproceso, rhsIcmParamcalproceso, (this.icmParamcalproceso != null),
                    (that.icmParamcalproceso != null))) {
                return false;
            }
        }
        {
            IcmListaconfchventaBlock lhsIcmListaconfchventa;
            lhsIcmListaconfchventa = this.getIcmListaconfchventa();
            IcmListaconfchventaBlock rhsIcmListaconfchventa;
            rhsIcmListaconfchventa = that.getIcmListaconfchventa();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconfchventa", lhsIcmListaconfchventa),
                    LocatorUtils.property(thatLocator, "icmListaconfchventa", rhsIcmListaconfchventa),
                    lhsIcmListaconfchventa, rhsIcmListaconfchventa, (this.icmListaconfchventa != null),
                    (that.icmListaconfchventa != null))) {
                return false;
            }
        }
        {
            IcmParamcalempleadoBlock lhsIcmParamcalempleado;
            lhsIcmParamcalempleado = this.getIcmParamcalempleado();
            IcmParamcalempleadoBlock rhsIcmParamcalempleado;
            rhsIcmParamcalempleado = that.getIcmParamcalempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalempleado", lhsIcmParamcalempleado),
                    LocatorUtils.property(thatLocator, "icmParamcalempleado", rhsIcmParamcalempleado),
                    lhsIcmParamcalempleado, rhsIcmParamcalempleado, (this.icmParamcalempleado != null),
                    (that.icmParamcalempleado != null))) {
                return false;
            }
        }
        {
            IcmParamcalsociedadBlock lhsIcmParamcalsociedad;
            lhsIcmParamcalsociedad = this.getIcmParamcalsociedad();
            IcmParamcalsociedadBlock rhsIcmParamcalsociedad;
            rhsIcmParamcalsociedad = that.getIcmParamcalsociedad();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalsociedad", lhsIcmParamcalsociedad),
                    LocatorUtils.property(thatLocator, "icmParamcalsociedad", rhsIcmParamcalsociedad),
                    lhsIcmParamcalsociedad, rhsIcmParamcalsociedad, (this.icmParamcalsociedad != null),
                    (that.icmParamcalsociedad != null))) {
                return false;
            }
        }
        {
            IcmParametrosentradaBlock lhsIcmParametrosentrada;
            lhsIcmParametrosentrada = this.getIcmParametrosentrada();
            IcmParametrosentradaBlock rhsIcmParametrosentrada;
            rhsIcmParametrosentrada = that.getIcmParametrosentrada();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrosentrada", lhsIcmParametrosentrada),
                    LocatorUtils.property(thatLocator, "icmParametrosentrada", rhsIcmParametrosentrada),
                    lhsIcmParametrosentrada, rhsIcmParametrosentrada, (this.icmParametrosentrada != null),
                    (that.icmParametrosentrada != null))) {
                return false;
            }
        }
        {
            IcmResultadoguardadoBlock lhsIcmResultadoguardado;
            lhsIcmResultadoguardado = this.getIcmResultadoguardado();
            IcmResultadoguardadoBlock rhsIcmResultadoguardado;
            rhsIcmResultadoguardado = that.getIcmResultadoguardado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmResultadoguardado", lhsIcmResultadoguardado),
                    LocatorUtils.property(thatLocator, "icmResultadoguardado", rhsIcmResultadoguardado),
                    lhsIcmResultadoguardado, rhsIcmResultadoguardado, (this.icmResultadoguardado != null),
                    (that.icmResultadoguardado != null))) {
                return false;
            }
        }
        {
            IcmListaconfiguracionBlock lhsIcmListaconfiguracion;
            lhsIcmListaconfiguracion = this.getIcmListaconfiguracion();
            IcmListaconfiguracionBlock rhsIcmListaconfiguracion;
            rhsIcmListaconfiguracion = that.getIcmListaconfiguracion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconfiguracion", lhsIcmListaconfiguracion),
                    LocatorUtils.property(thatLocator, "icmListaconfiguracion", rhsIcmListaconfiguracion),
                    lhsIcmListaconfiguracion, rhsIcmListaconfiguracion, (this.icmListaconfiguracion != null),
                    (that.icmListaconfiguracion != null))) {
                return false;
            }
        }
        {
            IcmParamcalconfchdiasBlock lhsIcmParamcalconfchdias;
            lhsIcmParamcalconfchdias = this.getIcmParamcalconfchdias();
            IcmParamcalconfchdiasBlock rhsIcmParamcalconfchdias;
            rhsIcmParamcalconfchdias = that.getIcmParamcalconfchdias();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalconfchdias", lhsIcmParamcalconfchdias),
                    LocatorUtils.property(thatLocator, "icmParamcalconfchdias", rhsIcmParamcalconfchdias),
                    lhsIcmParamcalconfchdias, rhsIcmParamcalconfchdias, (this.icmParamcalconfchdias != null),
                    (that.icmParamcalconfchdias != null))) {
                return false;
            }
        }
        {
            IcmParamcalconforigenBlock lhsIcmParamcalconforigen;
            lhsIcmParamcalconforigen = this.getIcmParamcalconforigen();
            IcmParamcalconforigenBlock rhsIcmParamcalconforigen;
            rhsIcmParamcalconforigen = that.getIcmParamcalconforigen();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalconforigen", lhsIcmParamcalconforigen),
                    LocatorUtils.property(thatLocator, "icmParamcalconforigen", rhsIcmParamcalconforigen),
                    lhsIcmParamcalconforigen, rhsIcmParamcalconforigen, (this.icmParamcalconforigen != null),
                    (that.icmParamcalconforigen != null))) {
                return false;
            }
        }
        {
            IcmParamcalestructuraBlock lhsIcmParamcalestructura;
            lhsIcmParamcalestructura = this.getIcmParamcalestructura();
            IcmParamcalestructuraBlock rhsIcmParamcalestructura;
            rhsIcmParamcalestructura = that.getIcmParamcalestructura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalestructura", lhsIcmParamcalestructura),
                    LocatorUtils.property(thatLocator, "icmParamcalestructura", rhsIcmParamcalestructura),
                    lhsIcmParamcalestructura, rhsIcmParamcalestructura, (this.icmParamcalestructura != null),
                    (that.icmParamcalestructura != null))) {
                return false;
            }
        }
        {
            IcmListaconfpreciohoraBlock lhsIcmListaconfpreciohora;
            lhsIcmListaconfpreciohora = this.getIcmListaconfpreciohora();
            IcmListaconfpreciohoraBlock rhsIcmListaconfpreciohora;
            rhsIcmListaconfpreciohora = that.getIcmListaconfpreciohora();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmListaconfpreciohora", lhsIcmListaconfpreciohora),
                    LocatorUtils.property(thatLocator, "icmListaconfpreciohora", rhsIcmListaconfpreciohora),
                    lhsIcmListaconfpreciohora, rhsIcmListaconfpreciohora, (this.icmListaconfpreciohora != null),
                    (that.icmListaconfpreciohora != null))) {
                return false;
            }
        }
        {
            IcmListaventacongeladaBlock lhsIcmListaventacongelada;
            lhsIcmListaventacongelada = this.getIcmListaventacongelada();
            IcmListaventacongeladaBlock rhsIcmListaventacongelada;
            rhsIcmListaventacongelada = that.getIcmListaventacongelada();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmListaventacongelada", lhsIcmListaventacongelada),
                    LocatorUtils.property(thatLocator, "icmListaventacongelada", rhsIcmListaventacongelada),
                    lhsIcmListaventacongelada, rhsIcmListaventacongelada, (this.icmListaventacongelada != null),
                    (that.icmListaventacongelada != null))) {
                return false;
            }
        }
        {
            IcmParamcalconfchventaBlock lhsIcmParamcalconfchventa;
            lhsIcmParamcalconfchventa = this.getIcmParamcalconfchventa();
            IcmParamcalconfchventaBlock rhsIcmParamcalconfchventa;
            rhsIcmParamcalconfchventa = that.getIcmParamcalconfchventa();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmParamcalconfchventa", lhsIcmParamcalconfchventa),
                    LocatorUtils.property(thatLocator, "icmParamcalconfchventa", rhsIcmParamcalconfchventa),
                    lhsIcmParamcalconfchventa, rhsIcmParamcalconfchventa, (this.icmParamcalconfchventa != null),
                    (that.icmParamcalconfchventa != null))) {
                return false;
            }
        }
        {
            IcmWsCalcOperacionesBlock lhsIcmWsCalcOperaciones;
            lhsIcmWsCalcOperaciones = this.getIcmWsCalcOperaciones();
            IcmWsCalcOperacionesBlock rhsIcmWsCalcOperaciones;
            rhsIcmWsCalcOperaciones = that.getIcmWsCalcOperaciones();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmWsCalcOperaciones", lhsIcmWsCalcOperaciones),
                    LocatorUtils.property(thatLocator, "icmWsCalcOperaciones", rhsIcmWsCalcOperaciones),
                    lhsIcmWsCalcOperaciones, rhsIcmWsCalcOperaciones, (this.icmWsCalcOperaciones != null),
                    (that.icmWsCalcOperaciones != null))) {
                return false;
            }
        }
        {
            IcmParametrospaginacionBlock lhsIcmParametrospaginacion;
            lhsIcmParametrospaginacion = this.getIcmParametrospaginacion();
            IcmParametrospaginacionBlock rhsIcmParametrospaginacion;
            rhsIcmParametrospaginacion = that.getIcmParametrospaginacion();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmParametrospaginacion", lhsIcmParametrospaginacion),
                    LocatorUtils.property(thatLocator, "icmParametrospaginacion", rhsIcmParametrospaginacion),
                    lhsIcmParametrospaginacion, rhsIcmParametrospaginacion, (this.icmParametrospaginacion != null),
                    (that.icmParametrospaginacion != null))) {
                return false;
            }
        }
        {
            IcmListapresupuestoswlocBlock lhsIcmListapresupuestoswloc;
            lhsIcmListapresupuestoswloc = this.getIcmListapresupuestoswloc();
            IcmListapresupuestoswlocBlock rhsIcmListapresupuestoswloc;
            rhsIcmListapresupuestoswloc = that.getIcmListapresupuestoswloc();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmListapresupuestoswloc", lhsIcmListapresupuestoswloc),
                    LocatorUtils.property(thatLocator, "icmListapresupuestoswloc", rhsIcmListapresupuestoswloc),
                    lhsIcmListapresupuestoswloc, rhsIcmListapresupuestoswloc, (this.icmListapresupuestoswloc != null),
                    (that.icmListapresupuestoswloc != null))) {
                return false;
            }
        }
        {
            IcmListapresupuestosrangoBlock lhsIcmListapresupuestosrango;
            lhsIcmListapresupuestosrango = this.getIcmListapresupuestosrango();
            IcmListapresupuestosrangoBlock rhsIcmListapresupuestosrango;
            rhsIcmListapresupuestosrango = that.getIcmListapresupuestosrango();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmListapresupuestosrango", lhsIcmListapresupuestosrango),
                    LocatorUtils.property(thatLocator, "icmListapresupuestosrango", rhsIcmListapresupuestosrango),
                    lhsIcmListapresupuestosrango, rhsIcmListapresupuestosrango,
                    (this.icmListapresupuestosrango != null), (that.icmListapresupuestosrango != null))) {
                return false;
            }
        }
        {
            IcmParamcalconfpreciohoraBlock lhsIcmParamcalconfpreciohora;
            lhsIcmParamcalconfpreciohora = this.getIcmParamcalconfpreciohora();
            IcmParamcalconfpreciohoraBlock rhsIcmParamcalconfpreciohora;
            rhsIcmParamcalconfpreciohora = that.getIcmParamcalconfpreciohora();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmParamcalconfpreciohora", lhsIcmParamcalconfpreciohora),
                    LocatorUtils.property(thatLocator, "icmParamcalconfpreciohora", rhsIcmParamcalconfpreciohora),
                    lhsIcmParamcalconfpreciohora, rhsIcmParamcalconfpreciohora,
                    (this.icmParamcalconfpreciohora != null), (that.icmParamcalconfpreciohora != null))) {
                return false;
            }
        }
        {
            IcmParamcalventacongeladaBlock lhsIcmParamcalventacongelada;
            lhsIcmParamcalventacongelada = this.getIcmParamcalventacongelada();
            IcmParamcalventacongeladaBlock rhsIcmParamcalventacongelada;
            rhsIcmParamcalventacongelada = that.getIcmParamcalventacongelada();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmParamcalventacongelada", lhsIcmParamcalventacongelada),
                    LocatorUtils.property(thatLocator, "icmParamcalventacongelada", rhsIcmParamcalventacongelada),
                    lhsIcmParamcalventacongelada, rhsIcmParamcalventacongelada,
                    (this.icmParamcalventacongelada != null), (that.icmParamcalventacongelada != null))) {
                return false;
            }
        }
        {
            IcmParamcalpresupuestoswlocBlock lhsIcmParamcalpresupuestoswloc;
            lhsIcmParamcalpresupuestoswloc = this.getIcmParamcalpresupuestoswloc();
            IcmParamcalpresupuestoswlocBlock rhsIcmParamcalpresupuestoswloc;
            rhsIcmParamcalpresupuestoswloc = that.getIcmParamcalpresupuestoswloc();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmParamcalpresupuestoswloc", lhsIcmParamcalpresupuestoswloc),
                    LocatorUtils.property(thatLocator, "icmParamcalpresupuestoswloc", rhsIcmParamcalpresupuestoswloc),
                    lhsIcmParamcalpresupuestoswloc, rhsIcmParamcalpresupuestoswloc,
                    (this.icmParamcalpresupuestoswloc != null), (that.icmParamcalpresupuestoswloc != null))) {
                return false;
            }
        }
        {
            IcmParamcalpresupuestosrangoBlock lhsIcmParamcalpresupuestosrango;
            lhsIcmParamcalpresupuestosrango = this.getIcmParamcalpresupuestosrango();
            IcmParamcalpresupuestosrangoBlock rhsIcmParamcalpresupuestosrango;
            rhsIcmParamcalpresupuestosrango = that.getIcmParamcalpresupuestosrango();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmParamcalpresupuestosrango", lhsIcmParamcalpresupuestosrango),
                    LocatorUtils.property(thatLocator, "icmParamcalpresupuestosrango", rhsIcmParamcalpresupuestosrango),
                    lhsIcmParamcalpresupuestosrango, rhsIcmParamcalpresupuestosrango,
                    (this.icmParamcalpresupuestosrango != null), (that.icmParamcalpresupuestosrango != null))) {
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
            double theReturn;
            theReturn = this.getReturn();
            strategy.appendField(locator, this, "_return", buffer, theReturn, true);
        }
        {
            List<LogMessage> theLogMessage;
            theLogMessage = (((this.logMessage != null) && (!this.logMessage.isEmpty())) ? this.getLogMessage() : null);
            strategy.appendField(locator, this, "logMessage", buffer, theLogMessage,
                    ((this.logMessage != null) && (!this.logMessage.isEmpty())));
        }
        {
            IcmWsToolsBlock theIcmWsTools;
            theIcmWsTools = this.getIcmWsTools();
            strategy.appendField(locator, this, "icmWsTools", buffer, theIcmWsTools, (this.icmWsTools != null));
        }
        {
            IcmListacadenasBlock theIcmListacadenas;
            theIcmListacadenas = this.getIcmListacadenas();
            strategy.appendField(locator, this, "icmListacadenas", buffer, theIcmListacadenas,
                    (this.icmListacadenas != null));
        }
        {
            IcmListatiendasBlock theIcmListatiendas;
            theIcmListatiendas = this.getIcmListatiendas();
            strategy.appendField(locator, this, "icmListatiendas", buffer, theIcmListatiendas,
                    (this.icmListatiendas != null));
        }
        {
            IcmListaempleadoBlock theIcmListaempleado;
            theIcmListaempleado = this.getIcmListaempleado();
            strategy.appendField(locator, this, "icmListaempleado", buffer, theIcmListaempleado,
                    (this.icmListaempleado != null));
        }
        {
            IcmListaempresasBlock theIcmListaempresas;
            theIcmListaempresas = this.getIcmListaempresas();
            strategy.appendField(locator, this, "icmListaempresas", buffer, theIcmListaempresas,
                    (this.icmListaempresas != null));
        }
        {
            IcmListaorigenesBlock theIcmListaorigenes;
            theIcmListaorigenes = this.getIcmListaorigenes();
            strategy.appendField(locator, this, "icmListaorigenes", buffer, theIcmListaorigenes,
                    (this.icmListaorigenes != null));
        }
        {
            IcmListaperiodosBlock theIcmListaperiodos;
            theIcmListaperiodos = this.getIcmListaperiodos();
            strategy.appendField(locator, this, "icmListaperiodos", buffer, theIcmListaperiodos,
                    (this.icmListaperiodos != null));
        }
        {
            IcmListaausenciasBlock theIcmListaausencias;
            theIcmListaausencias = this.getIcmListaausencias();
            strategy.appendField(locator, this, "icmListaausencias", buffer, theIcmListaausencias,
                    (this.icmListaausencias != null));
        }
        {
            IcmListaempleadosBlock theIcmListaempleados;
            theIcmListaempleados = this.getIcmListaempleados();
            strategy.appendField(locator, this, "icmListaempleados", buffer, theIcmListaempleados,
                    (this.icmListaempleados != null));
        }
        {
            IcmListapoliticasBlock theIcmListapoliticas;
            theIcmListapoliticas = this.getIcmListapoliticas();
            strategy.appendField(locator, this, "icmListapoliticas", buffer, theIcmListapoliticas,
                    (this.icmListapoliticas != null));
        }
        {
            IcmParamcalorigenBlock theIcmParamcalorigen;
            theIcmParamcalorigen = this.getIcmParamcalorigen();
            strategy.appendField(locator, this, "icmParamcalorigen", buffer, theIcmParamcalorigen,
                    (this.icmParamcalorigen != null));
        }
        {
            IcmListaconfchdiasBlock theIcmListaconfchdias;
            theIcmListaconfchdias = this.getIcmListaconfchdias();
            strategy.appendField(locator, this, "icmListaconfchdias", buffer, theIcmListaconfchdias,
                    (this.icmListaconfchdias != null));
        }
        {
            IcmListaconforigenBlock theIcmListaconforigen;
            theIcmListaconforigen = this.getIcmListaconforigen();
            strategy.appendField(locator, this, "icmListaconforigen", buffer, theIcmListaconforigen,
                    (this.icmListaconforigen != null));
        }
        {
            IcmListaestructuraBlock theIcmListaestructura;
            theIcmListaestructura = this.getIcmListaestructura();
            strategy.appendField(locator, this, "icmListaestructura", buffer, theIcmListaestructura,
                    (this.icmListaestructura != null));
        }
        {
            IcmParamcalperiodoBlock theIcmParamcalperiodo;
            theIcmParamcalperiodo = this.getIcmParamcalperiodo();
            strategy.appendField(locator, this, "icmParamcalperiodo", buffer, theIcmParamcalperiodo,
                    (this.icmParamcalperiodo != null));
        }
        {
            IcmParamcalprocesoBlock theIcmParamcalproceso;
            theIcmParamcalproceso = this.getIcmParamcalproceso();
            strategy.appendField(locator, this, "icmParamcalproceso", buffer, theIcmParamcalproceso,
                    (this.icmParamcalproceso != null));
        }
        {
            IcmListaconfchventaBlock theIcmListaconfchventa;
            theIcmListaconfchventa = this.getIcmListaconfchventa();
            strategy.appendField(locator, this, "icmListaconfchventa", buffer, theIcmListaconfchventa,
                    (this.icmListaconfchventa != null));
        }
        {
            IcmParamcalempleadoBlock theIcmParamcalempleado;
            theIcmParamcalempleado = this.getIcmParamcalempleado();
            strategy.appendField(locator, this, "icmParamcalempleado", buffer, theIcmParamcalempleado,
                    (this.icmParamcalempleado != null));
        }
        {
            IcmParamcalsociedadBlock theIcmParamcalsociedad;
            theIcmParamcalsociedad = this.getIcmParamcalsociedad();
            strategy.appendField(locator, this, "icmParamcalsociedad", buffer, theIcmParamcalsociedad,
                    (this.icmParamcalsociedad != null));
        }
        {
            IcmParametrosentradaBlock theIcmParametrosentrada;
            theIcmParametrosentrada = this.getIcmParametrosentrada();
            strategy.appendField(locator, this, "icmParametrosentrada", buffer, theIcmParametrosentrada,
                    (this.icmParametrosentrada != null));
        }
        {
            IcmResultadoguardadoBlock theIcmResultadoguardado;
            theIcmResultadoguardado = this.getIcmResultadoguardado();
            strategy.appendField(locator, this, "icmResultadoguardado", buffer, theIcmResultadoguardado,
                    (this.icmResultadoguardado != null));
        }
        {
            IcmListaconfiguracionBlock theIcmListaconfiguracion;
            theIcmListaconfiguracion = this.getIcmListaconfiguracion();
            strategy.appendField(locator, this, "icmListaconfiguracion", buffer, theIcmListaconfiguracion,
                    (this.icmListaconfiguracion != null));
        }
        {
            IcmParamcalconfchdiasBlock theIcmParamcalconfchdias;
            theIcmParamcalconfchdias = this.getIcmParamcalconfchdias();
            strategy.appendField(locator, this, "icmParamcalconfchdias", buffer, theIcmParamcalconfchdias,
                    (this.icmParamcalconfchdias != null));
        }
        {
            IcmParamcalconforigenBlock theIcmParamcalconforigen;
            theIcmParamcalconforigen = this.getIcmParamcalconforigen();
            strategy.appendField(locator, this, "icmParamcalconforigen", buffer, theIcmParamcalconforigen,
                    (this.icmParamcalconforigen != null));
        }
        {
            IcmParamcalestructuraBlock theIcmParamcalestructura;
            theIcmParamcalestructura = this.getIcmParamcalestructura();
            strategy.appendField(locator, this, "icmParamcalestructura", buffer, theIcmParamcalestructura,
                    (this.icmParamcalestructura != null));
        }
        {
            IcmListaconfpreciohoraBlock theIcmListaconfpreciohora;
            theIcmListaconfpreciohora = this.getIcmListaconfpreciohora();
            strategy.appendField(locator, this, "icmListaconfpreciohora", buffer, theIcmListaconfpreciohora,
                    (this.icmListaconfpreciohora != null));
        }
        {
            IcmListaventacongeladaBlock theIcmListaventacongelada;
            theIcmListaventacongelada = this.getIcmListaventacongelada();
            strategy.appendField(locator, this, "icmListaventacongelada", buffer, theIcmListaventacongelada,
                    (this.icmListaventacongelada != null));
        }
        {
            IcmParamcalconfchventaBlock theIcmParamcalconfchventa;
            theIcmParamcalconfchventa = this.getIcmParamcalconfchventa();
            strategy.appendField(locator, this, "icmParamcalconfchventa", buffer, theIcmParamcalconfchventa,
                    (this.icmParamcalconfchventa != null));
        }
        {
            IcmWsCalcOperacionesBlock theIcmWsCalcOperaciones;
            theIcmWsCalcOperaciones = this.getIcmWsCalcOperaciones();
            strategy.appendField(locator, this, "icmWsCalcOperaciones", buffer, theIcmWsCalcOperaciones,
                    (this.icmWsCalcOperaciones != null));
        }
        {
            IcmParametrospaginacionBlock theIcmParametrospaginacion;
            theIcmParametrospaginacion = this.getIcmParametrospaginacion();
            strategy.appendField(locator, this, "icmParametrospaginacion", buffer, theIcmParametrospaginacion,
                    (this.icmParametrospaginacion != null));
        }
        {
            IcmListapresupuestoswlocBlock theIcmListapresupuestoswloc;
            theIcmListapresupuestoswloc = this.getIcmListapresupuestoswloc();
            strategy.appendField(locator, this, "icmListapresupuestoswloc", buffer, theIcmListapresupuestoswloc,
                    (this.icmListapresupuestoswloc != null));
        }
        {
            IcmListapresupuestosrangoBlock theIcmListapresupuestosrango;
            theIcmListapresupuestosrango = this.getIcmListapresupuestosrango();
            strategy.appendField(locator, this, "icmListapresupuestosrango", buffer, theIcmListapresupuestosrango,
                    (this.icmListapresupuestosrango != null));
        }
        {
            IcmParamcalconfpreciohoraBlock theIcmParamcalconfpreciohora;
            theIcmParamcalconfpreciohora = this.getIcmParamcalconfpreciohora();
            strategy.appendField(locator, this, "icmParamcalconfpreciohora", buffer, theIcmParamcalconfpreciohora,
                    (this.icmParamcalconfpreciohora != null));
        }
        {
            IcmParamcalventacongeladaBlock theIcmParamcalventacongelada;
            theIcmParamcalventacongelada = this.getIcmParamcalventacongelada();
            strategy.appendField(locator, this, "icmParamcalventacongelada", buffer, theIcmParamcalventacongelada,
                    (this.icmParamcalventacongelada != null));
        }
        {
            IcmParamcalpresupuestoswlocBlock theIcmParamcalpresupuestoswloc;
            theIcmParamcalpresupuestoswloc = this.getIcmParamcalpresupuestoswloc();
            strategy.appendField(locator, this, "icmParamcalpresupuestoswloc", buffer, theIcmParamcalpresupuestoswloc,
                    (this.icmParamcalpresupuestoswloc != null));
        }
        {
            IcmParamcalpresupuestosrangoBlock theIcmParamcalpresupuestosrango;
            theIcmParamcalpresupuestosrango = this.getIcmParamcalpresupuestosrango();
            strategy.appendField(locator, this, "icmParamcalpresupuestosrango", buffer, theIcmParamcalpresupuestosrango,
                    (this.icmParamcalpresupuestosrango != null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            double theReturn;
            theReturn = this.getReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "_return", theReturn), currentHashCode,
                    theReturn, true);
        }
        {
            List<LogMessage> theLogMessage;
            theLogMessage = (((this.logMessage != null) && (!this.logMessage.isEmpty())) ? this.getLogMessage() : null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "logMessage", theLogMessage),
                    currentHashCode, theLogMessage, ((this.logMessage != null) && (!this.logMessage.isEmpty())));
        }
        {
            IcmWsToolsBlock theIcmWsTools;
            theIcmWsTools = this.getIcmWsTools();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmWsTools", theIcmWsTools),
                    currentHashCode, theIcmWsTools, (this.icmWsTools != null));
        }
        {
            IcmListacadenasBlock theIcmListacadenas;
            theIcmListacadenas = this.getIcmListacadenas();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListacadenas", theIcmListacadenas),
                    currentHashCode, theIcmListacadenas, (this.icmListacadenas != null));
        }
        {
            IcmListatiendasBlock theIcmListatiendas;
            theIcmListatiendas = this.getIcmListatiendas();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListatiendas", theIcmListatiendas),
                    currentHashCode, theIcmListatiendas, (this.icmListatiendas != null));
        }
        {
            IcmListaempleadoBlock theIcmListaempleado;
            theIcmListaempleado = this.getIcmListaempleado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaempleado", theIcmListaempleado),
                    currentHashCode, theIcmListaempleado, (this.icmListaempleado != null));
        }
        {
            IcmListaempresasBlock theIcmListaempresas;
            theIcmListaempresas = this.getIcmListaempresas();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaempresas", theIcmListaempresas),
                    currentHashCode, theIcmListaempresas, (this.icmListaempresas != null));
        }
        {
            IcmListaorigenesBlock theIcmListaorigenes;
            theIcmListaorigenes = this.getIcmListaorigenes();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaorigenes", theIcmListaorigenes),
                    currentHashCode, theIcmListaorigenes, (this.icmListaorigenes != null));
        }
        {
            IcmListaperiodosBlock theIcmListaperiodos;
            theIcmListaperiodos = this.getIcmListaperiodos();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaperiodos", theIcmListaperiodos),
                    currentHashCode, theIcmListaperiodos, (this.icmListaperiodos != null));
        }
        {
            IcmListaausenciasBlock theIcmListaausencias;
            theIcmListaausencias = this.getIcmListaausencias();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListaausencias", theIcmListaausencias), currentHashCode,
                    theIcmListaausencias, (this.icmListaausencias != null));
        }
        {
            IcmListaempleadosBlock theIcmListaempleados;
            theIcmListaempleados = this.getIcmListaempleados();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListaempleados", theIcmListaempleados), currentHashCode,
                    theIcmListaempleados, (this.icmListaempleados != null));
        }
        {
            IcmListapoliticasBlock theIcmListapoliticas;
            theIcmListapoliticas = this.getIcmListapoliticas();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListapoliticas", theIcmListapoliticas), currentHashCode,
                    theIcmListapoliticas, (this.icmListapoliticas != null));
        }
        {
            IcmParamcalorigenBlock theIcmParamcalorigen;
            theIcmParamcalorigen = this.getIcmParamcalorigen();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalorigen", theIcmParamcalorigen), currentHashCode,
                    theIcmParamcalorigen, (this.icmParamcalorigen != null));
        }
        {
            IcmListaconfchdiasBlock theIcmListaconfchdias;
            theIcmListaconfchdias = this.getIcmListaconfchdias();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListaconfchdias", theIcmListaconfchdias), currentHashCode,
                    theIcmListaconfchdias, (this.icmListaconfchdias != null));
        }
        {
            IcmListaconforigenBlock theIcmListaconforigen;
            theIcmListaconforigen = this.getIcmListaconforigen();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListaconforigen", theIcmListaconforigen), currentHashCode,
                    theIcmListaconforigen, (this.icmListaconforigen != null));
        }
        {
            IcmListaestructuraBlock theIcmListaestructura;
            theIcmListaestructura = this.getIcmListaestructura();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListaestructura", theIcmListaestructura), currentHashCode,
                    theIcmListaestructura, (this.icmListaestructura != null));
        }
        {
            IcmParamcalperiodoBlock theIcmParamcalperiodo;
            theIcmParamcalperiodo = this.getIcmParamcalperiodo();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalperiodo", theIcmParamcalperiodo), currentHashCode,
                    theIcmParamcalperiodo, (this.icmParamcalperiodo != null));
        }
        {
            IcmParamcalprocesoBlock theIcmParamcalproceso;
            theIcmParamcalproceso = this.getIcmParamcalproceso();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalproceso", theIcmParamcalproceso), currentHashCode,
                    theIcmParamcalproceso, (this.icmParamcalproceso != null));
        }
        {
            IcmListaconfchventaBlock theIcmListaconfchventa;
            theIcmListaconfchventa = this.getIcmListaconfchventa();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListaconfchventa", theIcmListaconfchventa), currentHashCode,
                    theIcmListaconfchventa, (this.icmListaconfchventa != null));
        }
        {
            IcmParamcalempleadoBlock theIcmParamcalempleado;
            theIcmParamcalempleado = this.getIcmParamcalempleado();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalempleado", theIcmParamcalempleado), currentHashCode,
                    theIcmParamcalempleado, (this.icmParamcalempleado != null));
        }
        {
            IcmParamcalsociedadBlock theIcmParamcalsociedad;
            theIcmParamcalsociedad = this.getIcmParamcalsociedad();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalsociedad", theIcmParamcalsociedad), currentHashCode,
                    theIcmParamcalsociedad, (this.icmParamcalsociedad != null));
        }
        {
            IcmParametrosentradaBlock theIcmParametrosentrada;
            theIcmParametrosentrada = this.getIcmParametrosentrada();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParametrosentrada", theIcmParametrosentrada), currentHashCode,
                    theIcmParametrosentrada, (this.icmParametrosentrada != null));
        }
        {
            IcmResultadoguardadoBlock theIcmResultadoguardado;
            theIcmResultadoguardado = this.getIcmResultadoguardado();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmResultadoguardado", theIcmResultadoguardado), currentHashCode,
                    theIcmResultadoguardado, (this.icmResultadoguardado != null));
        }
        {
            IcmListaconfiguracionBlock theIcmListaconfiguracion;
            theIcmListaconfiguracion = this.getIcmListaconfiguracion();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListaconfiguracion", theIcmListaconfiguracion), currentHashCode,
                    theIcmListaconfiguracion, (this.icmListaconfiguracion != null));
        }
        {
            IcmParamcalconfchdiasBlock theIcmParamcalconfchdias;
            theIcmParamcalconfchdias = this.getIcmParamcalconfchdias();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalconfchdias", theIcmParamcalconfchdias), currentHashCode,
                    theIcmParamcalconfchdias, (this.icmParamcalconfchdias != null));
        }
        {
            IcmParamcalconforigenBlock theIcmParamcalconforigen;
            theIcmParamcalconforigen = this.getIcmParamcalconforigen();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalconforigen", theIcmParamcalconforigen), currentHashCode,
                    theIcmParamcalconforigen, (this.icmParamcalconforigen != null));
        }
        {
            IcmParamcalestructuraBlock theIcmParamcalestructura;
            theIcmParamcalestructura = this.getIcmParamcalestructura();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalestructura", theIcmParamcalestructura), currentHashCode,
                    theIcmParamcalestructura, (this.icmParamcalestructura != null));
        }
        {
            IcmListaconfpreciohoraBlock theIcmListaconfpreciohora;
            theIcmListaconfpreciohora = this.getIcmListaconfpreciohora();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListaconfpreciohora", theIcmListaconfpreciohora),
                    currentHashCode, theIcmListaconfpreciohora, (this.icmListaconfpreciohora != null));
        }
        {
            IcmListaventacongeladaBlock theIcmListaventacongelada;
            theIcmListaventacongelada = this.getIcmListaventacongelada();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListaventacongelada", theIcmListaventacongelada),
                    currentHashCode, theIcmListaventacongelada, (this.icmListaventacongelada != null));
        }
        {
            IcmParamcalconfchventaBlock theIcmParamcalconfchventa;
            theIcmParamcalconfchventa = this.getIcmParamcalconfchventa();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalconfchventa", theIcmParamcalconfchventa),
                    currentHashCode, theIcmParamcalconfchventa, (this.icmParamcalconfchventa != null));
        }
        {
            IcmWsCalcOperacionesBlock theIcmWsCalcOperaciones;
            theIcmWsCalcOperaciones = this.getIcmWsCalcOperaciones();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmWsCalcOperaciones", theIcmWsCalcOperaciones), currentHashCode,
                    theIcmWsCalcOperaciones, (this.icmWsCalcOperaciones != null));
        }
        {
            IcmParametrospaginacionBlock theIcmParametrospaginacion;
            theIcmParametrospaginacion = this.getIcmParametrospaginacion();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParametrospaginacion", theIcmParametrospaginacion),
                    currentHashCode, theIcmParametrospaginacion, (this.icmParametrospaginacion != null));
        }
        {
            IcmListapresupuestoswlocBlock theIcmListapresupuestoswloc;
            theIcmListapresupuestoswloc = this.getIcmListapresupuestoswloc();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListapresupuestoswloc", theIcmListapresupuestoswloc),
                    currentHashCode, theIcmListapresupuestoswloc, (this.icmListapresupuestoswloc != null));
        }
        {
            IcmListapresupuestosrangoBlock theIcmListapresupuestosrango;
            theIcmListapresupuestosrango = this.getIcmListapresupuestosrango();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListapresupuestosrango", theIcmListapresupuestosrango),
                    currentHashCode, theIcmListapresupuestosrango, (this.icmListapresupuestosrango != null));
        }
        {
            IcmParamcalconfpreciohoraBlock theIcmParamcalconfpreciohora;
            theIcmParamcalconfpreciohora = this.getIcmParamcalconfpreciohora();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalconfpreciohora", theIcmParamcalconfpreciohora),
                    currentHashCode, theIcmParamcalconfpreciohora, (this.icmParamcalconfpreciohora != null));
        }
        {
            IcmParamcalventacongeladaBlock theIcmParamcalventacongelada;
            theIcmParamcalventacongelada = this.getIcmParamcalventacongelada();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalventacongelada", theIcmParamcalventacongelada),
                    currentHashCode, theIcmParamcalventacongelada, (this.icmParamcalventacongelada != null));
        }
        {
            IcmParamcalpresupuestoswlocBlock theIcmParamcalpresupuestoswloc;
            theIcmParamcalpresupuestoswloc = this.getIcmParamcalpresupuestoswloc();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalpresupuestoswloc", theIcmParamcalpresupuestoswloc),
                    currentHashCode, theIcmParamcalpresupuestoswloc, (this.icmParamcalpresupuestoswloc != null));
        }
        {
            IcmParamcalpresupuestosrangoBlock theIcmParamcalpresupuestosrango;
            theIcmParamcalpresupuestosrango = this.getIcmParamcalpresupuestosrango();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParamcalpresupuestosrango", theIcmParamcalpresupuestosrango),
                    currentHashCode, theIcmParamcalpresupuestosrango, (this.icmParamcalpresupuestosrango != null));
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
        final Object draftCopy = ((target == null) ? createNewInstance() : target);
        if (draftCopy instanceof M4LoadobjectOutput) {
            final M4LoadobjectOutput copy = ((M4LoadobjectOutput) draftCopy);
            {
                Boolean _returnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, true);
                if (_returnShouldBeCopiedAndSet == Boolean.TRUE) {
                    double sourceReturn;
                    sourceReturn = this.getReturn();
                    double copyReturn = strategy.copy(LocatorUtils.property(locator, "_return", sourceReturn),
                            sourceReturn, true);
                    copy.setReturn(copyReturn);
                } else {
                    if (_returnShouldBeCopiedAndSet == Boolean.FALSE) {
                    }
                }
            }
            {
                Boolean logMessageShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        ((this.logMessage != null) && (!this.logMessage.isEmpty())));
                if (logMessageShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<LogMessage> sourceLogMessage;
                    sourceLogMessage = (((this.logMessage != null) && (!this.logMessage.isEmpty()))
                            ? this.getLogMessage() : null);
                    @SuppressWarnings("unchecked")
                    List<LogMessage> copyLogMessage = ((List<LogMessage>) strategy.copy(
                            LocatorUtils.property(locator, "logMessage", sourceLogMessage), sourceLogMessage,
                            ((this.logMessage != null) && (!this.logMessage.isEmpty()))));
                    copy.logMessage = null;
                    if (copyLogMessage != null) {
                        List<LogMessage> uniqueLogMessagel = copy.getLogMessage();
                        uniqueLogMessagel.addAll(copyLogMessage);
                    }
                } else {
                    if (logMessageShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.logMessage = null;
                    }
                }
            }
            {
                Boolean icmWsToolsShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmWsTools != null));
                if (icmWsToolsShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmWsToolsBlock sourceIcmWsTools;
                    sourceIcmWsTools = this.getIcmWsTools();
                    IcmWsToolsBlock copyIcmWsTools = ((IcmWsToolsBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmWsTools", sourceIcmWsTools), sourceIcmWsTools,
                            (this.icmWsTools != null)));
                    copy.setIcmWsTools(copyIcmWsTools);
                } else {
                    if (icmWsToolsShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmWsTools = null;
                    }
                }
            }
            {
                Boolean icmListacadenasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListacadenas != null));
                if (icmListacadenasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListacadenasBlock sourceIcmListacadenas;
                    sourceIcmListacadenas = this.getIcmListacadenas();
                    IcmListacadenasBlock copyIcmListacadenas = ((IcmListacadenasBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListacadenas", sourceIcmListacadenas),
                            sourceIcmListacadenas, (this.icmListacadenas != null)));
                    copy.setIcmListacadenas(copyIcmListacadenas);
                } else {
                    if (icmListacadenasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListacadenas = null;
                    }
                }
            }
            {
                Boolean icmListatiendasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListatiendas != null));
                if (icmListatiendasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListatiendasBlock sourceIcmListatiendas;
                    sourceIcmListatiendas = this.getIcmListatiendas();
                    IcmListatiendasBlock copyIcmListatiendas = ((IcmListatiendasBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListatiendas", sourceIcmListatiendas),
                            sourceIcmListatiendas, (this.icmListatiendas != null)));
                    copy.setIcmListatiendas(copyIcmListatiendas);
                } else {
                    if (icmListatiendasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListatiendas = null;
                    }
                }
            }
            {
                Boolean icmListaempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaempleado != null));
                if (icmListaempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaempleadoBlock sourceIcmListaempleado;
                    sourceIcmListaempleado = this.getIcmListaempleado();
                    IcmListaempleadoBlock copyIcmListaempleado = ((IcmListaempleadoBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaempleado", sourceIcmListaempleado),
                            sourceIcmListaempleado, (this.icmListaempleado != null)));
                    copy.setIcmListaempleado(copyIcmListaempleado);
                } else {
                    if (icmListaempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaempleado = null;
                    }
                }
            }
            {
                Boolean icmListaempresasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaempresas != null));
                if (icmListaempresasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaempresasBlock sourceIcmListaempresas;
                    sourceIcmListaempresas = this.getIcmListaempresas();
                    IcmListaempresasBlock copyIcmListaempresas = ((IcmListaempresasBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaempresas", sourceIcmListaempresas),
                            sourceIcmListaempresas, (this.icmListaempresas != null)));
                    copy.setIcmListaempresas(copyIcmListaempresas);
                } else {
                    if (icmListaempresasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaempresas = null;
                    }
                }
            }
            {
                Boolean icmListaorigenesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaorigenes != null));
                if (icmListaorigenesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaorigenesBlock sourceIcmListaorigenes;
                    sourceIcmListaorigenes = this.getIcmListaorigenes();
                    IcmListaorigenesBlock copyIcmListaorigenes = ((IcmListaorigenesBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaorigenes", sourceIcmListaorigenes),
                            sourceIcmListaorigenes, (this.icmListaorigenes != null)));
                    copy.setIcmListaorigenes(copyIcmListaorigenes);
                } else {
                    if (icmListaorigenesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaorigenes = null;
                    }
                }
            }
            {
                Boolean icmListaperiodosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaperiodos != null));
                if (icmListaperiodosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaperiodosBlock sourceIcmListaperiodos;
                    sourceIcmListaperiodos = this.getIcmListaperiodos();
                    IcmListaperiodosBlock copyIcmListaperiodos = ((IcmListaperiodosBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaperiodos", sourceIcmListaperiodos),
                            sourceIcmListaperiodos, (this.icmListaperiodos != null)));
                    copy.setIcmListaperiodos(copyIcmListaperiodos);
                } else {
                    if (icmListaperiodosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaperiodos = null;
                    }
                }
            }
            {
                Boolean icmListaausenciasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaausencias != null));
                if (icmListaausenciasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaausenciasBlock sourceIcmListaausencias;
                    sourceIcmListaausencias = this.getIcmListaausencias();
                    IcmListaausenciasBlock copyIcmListaausencias = ((IcmListaausenciasBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaausencias", sourceIcmListaausencias),
                            sourceIcmListaausencias, (this.icmListaausencias != null)));
                    copy.setIcmListaausencias(copyIcmListaausencias);
                } else {
                    if (icmListaausenciasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaausencias = null;
                    }
                }
            }
            {
                Boolean icmListaempleadosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaempleados != null));
                if (icmListaempleadosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaempleadosBlock sourceIcmListaempleados;
                    sourceIcmListaempleados = this.getIcmListaempleados();
                    IcmListaempleadosBlock copyIcmListaempleados = ((IcmListaempleadosBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaempleados", sourceIcmListaempleados),
                            sourceIcmListaempleados, (this.icmListaempleados != null)));
                    copy.setIcmListaempleados(copyIcmListaempleados);
                } else {
                    if (icmListaempleadosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaempleados = null;
                    }
                }
            }
            {
                Boolean icmListapoliticasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListapoliticas != null));
                if (icmListapoliticasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListapoliticasBlock sourceIcmListapoliticas;
                    sourceIcmListapoliticas = this.getIcmListapoliticas();
                    IcmListapoliticasBlock copyIcmListapoliticas = ((IcmListapoliticasBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListapoliticas", sourceIcmListapoliticas),
                            sourceIcmListapoliticas, (this.icmListapoliticas != null)));
                    copy.setIcmListapoliticas(copyIcmListapoliticas);
                } else {
                    if (icmListapoliticasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListapoliticas = null;
                    }
                }
            }
            {
                Boolean icmParamcalorigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalorigen != null));
                if (icmParamcalorigenShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalorigenBlock sourceIcmParamcalorigen;
                    sourceIcmParamcalorigen = this.getIcmParamcalorigen();
                    IcmParamcalorigenBlock copyIcmParamcalorigen = ((IcmParamcalorigenBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmParamcalorigen", sourceIcmParamcalorigen),
                            sourceIcmParamcalorigen, (this.icmParamcalorigen != null)));
                    copy.setIcmParamcalorigen(copyIcmParamcalorigen);
                } else {
                    if (icmParamcalorigenShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalorigen = null;
                    }
                }
            }
            {
                Boolean icmListaconfchdiasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaconfchdias != null));
                if (icmListaconfchdiasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconfchdiasBlock sourceIcmListaconfchdias;
                    sourceIcmListaconfchdias = this.getIcmListaconfchdias();
                    IcmListaconfchdiasBlock copyIcmListaconfchdias = ((IcmListaconfchdiasBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaconfchdias", sourceIcmListaconfchdias),
                            sourceIcmListaconfchdias, (this.icmListaconfchdias != null)));
                    copy.setIcmListaconfchdias(copyIcmListaconfchdias);
                } else {
                    if (icmListaconfchdiasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaconfchdias = null;
                    }
                }
            }
            {
                Boolean icmListaconforigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaconforigen != null));
                if (icmListaconforigenShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconforigenBlock sourceIcmListaconforigen;
                    sourceIcmListaconforigen = this.getIcmListaconforigen();
                    IcmListaconforigenBlock copyIcmListaconforigen = ((IcmListaconforigenBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaconforigen", sourceIcmListaconforigen),
                            sourceIcmListaconforigen, (this.icmListaconforigen != null)));
                    copy.setIcmListaconforigen(copyIcmListaconforigen);
                } else {
                    if (icmListaconforigenShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaconforigen = null;
                    }
                }
            }
            {
                Boolean icmListaestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaestructura != null));
                if (icmListaestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaestructuraBlock sourceIcmListaestructura;
                    sourceIcmListaestructura = this.getIcmListaestructura();
                    IcmListaestructuraBlock copyIcmListaestructura = ((IcmListaestructuraBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaestructura", sourceIcmListaestructura),
                            sourceIcmListaestructura, (this.icmListaestructura != null)));
                    copy.setIcmListaestructura(copyIcmListaestructura);
                } else {
                    if (icmListaestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaestructura = null;
                    }
                }
            }
            {
                Boolean icmParamcalperiodoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalperiodo != null));
                if (icmParamcalperiodoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalperiodoBlock sourceIcmParamcalperiodo;
                    sourceIcmParamcalperiodo = this.getIcmParamcalperiodo();
                    IcmParamcalperiodoBlock copyIcmParamcalperiodo = ((IcmParamcalperiodoBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmParamcalperiodo", sourceIcmParamcalperiodo),
                            sourceIcmParamcalperiodo, (this.icmParamcalperiodo != null)));
                    copy.setIcmParamcalperiodo(copyIcmParamcalperiodo);
                } else {
                    if (icmParamcalperiodoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalperiodo = null;
                    }
                }
            }
            {
                Boolean icmParamcalprocesoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalproceso != null));
                if (icmParamcalprocesoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalprocesoBlock sourceIcmParamcalproceso;
                    sourceIcmParamcalproceso = this.getIcmParamcalproceso();
                    IcmParamcalprocesoBlock copyIcmParamcalproceso = ((IcmParamcalprocesoBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmParamcalproceso", sourceIcmParamcalproceso),
                            sourceIcmParamcalproceso, (this.icmParamcalproceso != null)));
                    copy.setIcmParamcalproceso(copyIcmParamcalproceso);
                } else {
                    if (icmParamcalprocesoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalproceso = null;
                    }
                }
            }
            {
                Boolean icmListaconfchventaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaconfchventa != null));
                if (icmListaconfchventaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconfchventaBlock sourceIcmListaconfchventa;
                    sourceIcmListaconfchventa = this.getIcmListaconfchventa();
                    IcmListaconfchventaBlock copyIcmListaconfchventa = ((IcmListaconfchventaBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaconfchventa", sourceIcmListaconfchventa),
                            sourceIcmListaconfchventa, (this.icmListaconfchventa != null)));
                    copy.setIcmListaconfchventa(copyIcmListaconfchventa);
                } else {
                    if (icmListaconfchventaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaconfchventa = null;
                    }
                }
            }
            {
                Boolean icmParamcalempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalempleado != null));
                if (icmParamcalempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalempleadoBlock sourceIcmParamcalempleado;
                    sourceIcmParamcalempleado = this.getIcmParamcalempleado();
                    IcmParamcalempleadoBlock copyIcmParamcalempleado = ((IcmParamcalempleadoBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmParamcalempleado", sourceIcmParamcalempleado),
                            sourceIcmParamcalempleado, (this.icmParamcalempleado != null)));
                    copy.setIcmParamcalempleado(copyIcmParamcalempleado);
                } else {
                    if (icmParamcalempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalempleado = null;
                    }
                }
            }
            {
                Boolean icmParamcalsociedadShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalsociedad != null));
                if (icmParamcalsociedadShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalsociedadBlock sourceIcmParamcalsociedad;
                    sourceIcmParamcalsociedad = this.getIcmParamcalsociedad();
                    IcmParamcalsociedadBlock copyIcmParamcalsociedad = ((IcmParamcalsociedadBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmParamcalsociedad", sourceIcmParamcalsociedad),
                            sourceIcmParamcalsociedad, (this.icmParamcalsociedad != null)));
                    copy.setIcmParamcalsociedad(copyIcmParamcalsociedad);
                } else {
                    if (icmParamcalsociedadShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalsociedad = null;
                    }
                }
            }
            {
                Boolean icmParametrosentradaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParametrosentrada != null));
                if (icmParametrosentradaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosentradaBlock sourceIcmParametrosentrada;
                    sourceIcmParametrosentrada = this.getIcmParametrosentrada();
                    IcmParametrosentradaBlock copyIcmParametrosentrada = ((IcmParametrosentradaBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmParametrosentrada", sourceIcmParametrosentrada),
                            sourceIcmParametrosentrada, (this.icmParametrosentrada != null)));
                    copy.setIcmParametrosentrada(copyIcmParametrosentrada);
                } else {
                    if (icmParametrosentradaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrosentrada = null;
                    }
                }
            }
            {
                Boolean icmResultadoguardadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmResultadoguardado != null));
                if (icmResultadoguardadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmResultadoguardadoBlock sourceIcmResultadoguardado;
                    sourceIcmResultadoguardado = this.getIcmResultadoguardado();
                    IcmResultadoguardadoBlock copyIcmResultadoguardado = ((IcmResultadoguardadoBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmResultadoguardado", sourceIcmResultadoguardado),
                            sourceIcmResultadoguardado, (this.icmResultadoguardado != null)));
                    copy.setIcmResultadoguardado(copyIcmResultadoguardado);
                } else {
                    if (icmResultadoguardadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmResultadoguardado = null;
                    }
                }
            }
            {
                Boolean icmListaconfiguracionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaconfiguracion != null));
                if (icmListaconfiguracionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconfiguracionBlock sourceIcmListaconfiguracion;
                    sourceIcmListaconfiguracion = this.getIcmListaconfiguracion();
                    IcmListaconfiguracionBlock copyIcmListaconfiguracion = ((IcmListaconfiguracionBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaconfiguracion", sourceIcmListaconfiguracion),
                            sourceIcmListaconfiguracion, (this.icmListaconfiguracion != null)));
                    copy.setIcmListaconfiguracion(copyIcmListaconfiguracion);
                } else {
                    if (icmListaconfiguracionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaconfiguracion = null;
                    }
                }
            }
            {
                Boolean icmParamcalconfchdiasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalconfchdias != null));
                if (icmParamcalconfchdiasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalconfchdiasBlock sourceIcmParamcalconfchdias;
                    sourceIcmParamcalconfchdias = this.getIcmParamcalconfchdias();
                    IcmParamcalconfchdiasBlock copyIcmParamcalconfchdias = ((IcmParamcalconfchdiasBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmParamcalconfchdias", sourceIcmParamcalconfchdias),
                            sourceIcmParamcalconfchdias, (this.icmParamcalconfchdias != null)));
                    copy.setIcmParamcalconfchdias(copyIcmParamcalconfchdias);
                } else {
                    if (icmParamcalconfchdiasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalconfchdias = null;
                    }
                }
            }
            {
                Boolean icmParamcalconforigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalconforigen != null));
                if (icmParamcalconforigenShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalconforigenBlock sourceIcmParamcalconforigen;
                    sourceIcmParamcalconforigen = this.getIcmParamcalconforigen();
                    IcmParamcalconforigenBlock copyIcmParamcalconforigen = ((IcmParamcalconforigenBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmParamcalconforigen", sourceIcmParamcalconforigen),
                            sourceIcmParamcalconforigen, (this.icmParamcalconforigen != null)));
                    copy.setIcmParamcalconforigen(copyIcmParamcalconforigen);
                } else {
                    if (icmParamcalconforigenShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalconforigen = null;
                    }
                }
            }
            {
                Boolean icmParamcalestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalestructura != null));
                if (icmParamcalestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalestructuraBlock sourceIcmParamcalestructura;
                    sourceIcmParamcalestructura = this.getIcmParamcalestructura();
                    IcmParamcalestructuraBlock copyIcmParamcalestructura = ((IcmParamcalestructuraBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmParamcalestructura", sourceIcmParamcalestructura),
                            sourceIcmParamcalestructura, (this.icmParamcalestructura != null)));
                    copy.setIcmParamcalestructura(copyIcmParamcalestructura);
                } else {
                    if (icmParamcalestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalestructura = null;
                    }
                }
            }
            {
                Boolean icmListaconfpreciohoraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaconfpreciohora != null));
                if (icmListaconfpreciohoraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconfpreciohoraBlock sourceIcmListaconfpreciohora;
                    sourceIcmListaconfpreciohora = this.getIcmListaconfpreciohora();
                    IcmListaconfpreciohoraBlock copyIcmListaconfpreciohora = ((IcmListaconfpreciohoraBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmListaconfpreciohora", sourceIcmListaconfpreciohora),
                                sourceIcmListaconfpreciohora, (this.icmListaconfpreciohora != null)));
                    copy.setIcmListaconfpreciohora(copyIcmListaconfpreciohora);
                } else {
                    if (icmListaconfpreciohoraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaconfpreciohora = null;
                    }
                }
            }
            {
                Boolean icmListaventacongeladaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaventacongelada != null));
                if (icmListaventacongeladaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaventacongeladaBlock sourceIcmListaventacongelada;
                    sourceIcmListaventacongelada = this.getIcmListaventacongelada();
                    IcmListaventacongeladaBlock copyIcmListaventacongelada = ((IcmListaventacongeladaBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmListaventacongelada", sourceIcmListaventacongelada),
                                sourceIcmListaventacongelada, (this.icmListaventacongelada != null)));
                    copy.setIcmListaventacongelada(copyIcmListaventacongelada);
                } else {
                    if (icmListaventacongeladaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaventacongelada = null;
                    }
                }
            }
            {
                Boolean icmParamcalconfchventaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalconfchventa != null));
                if (icmParamcalconfchventaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalconfchventaBlock sourceIcmParamcalconfchventa;
                    sourceIcmParamcalconfchventa = this.getIcmParamcalconfchventa();
                    IcmParamcalconfchventaBlock copyIcmParamcalconfchventa = ((IcmParamcalconfchventaBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmParamcalconfchventa", sourceIcmParamcalconfchventa),
                                sourceIcmParamcalconfchventa, (this.icmParamcalconfchventa != null)));
                    copy.setIcmParamcalconfchventa(copyIcmParamcalconfchventa);
                } else {
                    if (icmParamcalconfchventaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalconfchventa = null;
                    }
                }
            }
            {
                Boolean icmWsCalcOperacionesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmWsCalcOperaciones != null));
                if (icmWsCalcOperacionesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmWsCalcOperacionesBlock sourceIcmWsCalcOperaciones;
                    sourceIcmWsCalcOperaciones = this.getIcmWsCalcOperaciones();
                    IcmWsCalcOperacionesBlock copyIcmWsCalcOperaciones = ((IcmWsCalcOperacionesBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmWsCalcOperaciones", sourceIcmWsCalcOperaciones),
                            sourceIcmWsCalcOperaciones, (this.icmWsCalcOperaciones != null)));
                    copy.setIcmWsCalcOperaciones(copyIcmWsCalcOperaciones);
                } else {
                    if (icmWsCalcOperacionesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmWsCalcOperaciones = null;
                    }
                }
            }
            {
                Boolean icmParametrospaginacionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParametrospaginacion != null));
                if (icmParametrospaginacionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospaginacionBlock sourceIcmParametrospaginacion;
                    sourceIcmParametrospaginacion = this.getIcmParametrospaginacion();
                    IcmParametrospaginacionBlock copyIcmParametrospaginacion = ((IcmParametrospaginacionBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmParametrospaginacion", sourceIcmParametrospaginacion),
                                sourceIcmParametrospaginacion, (this.icmParametrospaginacion != null)));
                    copy.setIcmParametrospaginacion(copyIcmParametrospaginacion);
                } else {
                    if (icmParametrospaginacionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrospaginacion = null;
                    }
                }
            }
            {
                Boolean icmListapresupuestoswlocShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListapresupuestoswloc != null));
                if (icmListapresupuestoswlocShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListapresupuestoswlocBlock sourceIcmListapresupuestoswloc;
                    sourceIcmListapresupuestoswloc = this.getIcmListapresupuestoswloc();
                    IcmListapresupuestoswlocBlock copyIcmListapresupuestoswloc = ((IcmListapresupuestoswlocBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmListapresupuestoswloc",
                                sourceIcmListapresupuestoswloc), sourceIcmListapresupuestoswloc,
                                (this.icmListapresupuestoswloc != null)));
                    copy.setIcmListapresupuestoswloc(copyIcmListapresupuestoswloc);
                } else {
                    if (icmListapresupuestoswlocShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListapresupuestoswloc = null;
                    }
                }
            }
            {
                Boolean icmListapresupuestosrangoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListapresupuestosrango != null));
                if (icmListapresupuestosrangoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListapresupuestosrangoBlock sourceIcmListapresupuestosrango;
                    sourceIcmListapresupuestosrango = this.getIcmListapresupuestosrango();
                    IcmListapresupuestosrangoBlock copyIcmListapresupuestosrango = ((IcmListapresupuestosrangoBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmListapresupuestosrango",
                                sourceIcmListapresupuestosrango), sourceIcmListapresupuestosrango,
                                (this.icmListapresupuestosrango != null)));
                    copy.setIcmListapresupuestosrango(copyIcmListapresupuestosrango);
                } else {
                    if (icmListapresupuestosrangoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListapresupuestosrango = null;
                    }
                }
            }
            {
                Boolean icmParamcalconfpreciohoraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalconfpreciohora != null));
                if (icmParamcalconfpreciohoraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalconfpreciohoraBlock sourceIcmParamcalconfpreciohora;
                    sourceIcmParamcalconfpreciohora = this.getIcmParamcalconfpreciohora();
                    IcmParamcalconfpreciohoraBlock copyIcmParamcalconfpreciohora = ((IcmParamcalconfpreciohoraBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmParamcalconfpreciohora",
                                sourceIcmParamcalconfpreciohora), sourceIcmParamcalconfpreciohora,
                                (this.icmParamcalconfpreciohora != null)));
                    copy.setIcmParamcalconfpreciohora(copyIcmParamcalconfpreciohora);
                } else {
                    if (icmParamcalconfpreciohoraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalconfpreciohora = null;
                    }
                }
            }
            {
                Boolean icmParamcalventacongeladaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalventacongelada != null));
                if (icmParamcalventacongeladaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalventacongeladaBlock sourceIcmParamcalventacongelada;
                    sourceIcmParamcalventacongelada = this.getIcmParamcalventacongelada();
                    IcmParamcalventacongeladaBlock copyIcmParamcalventacongelada = ((IcmParamcalventacongeladaBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmParamcalventacongelada",
                                sourceIcmParamcalventacongelada), sourceIcmParamcalventacongelada,
                                (this.icmParamcalventacongelada != null)));
                    copy.setIcmParamcalventacongelada(copyIcmParamcalventacongelada);
                } else {
                    if (icmParamcalventacongeladaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalventacongelada = null;
                    }
                }
            }
            {
                Boolean icmParamcalpresupuestoswlocShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalpresupuestoswloc != null));
                if (icmParamcalpresupuestoswlocShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalpresupuestoswlocBlock sourceIcmParamcalpresupuestoswloc;
                    sourceIcmParamcalpresupuestoswloc = this.getIcmParamcalpresupuestoswloc();
                    IcmParamcalpresupuestoswlocBlock copyIcmParamcalpresupuestoswloc = ((IcmParamcalpresupuestoswlocBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmParamcalpresupuestoswloc",
                                sourceIcmParamcalpresupuestoswloc), sourceIcmParamcalpresupuestoswloc,
                                (this.icmParamcalpresupuestoswloc != null)));
                    copy.setIcmParamcalpresupuestoswloc(copyIcmParamcalpresupuestoswloc);
                } else {
                    if (icmParamcalpresupuestoswlocShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalpresupuestoswloc = null;
                    }
                }
            }
            {
                Boolean icmParamcalpresupuestosrangoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParamcalpresupuestosrango != null));
                if (icmParamcalpresupuestosrangoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalpresupuestosrangoBlock sourceIcmParamcalpresupuestosrango;
                    sourceIcmParamcalpresupuestosrango = this.getIcmParamcalpresupuestosrango();
                    IcmParamcalpresupuestosrangoBlock copyIcmParamcalpresupuestosrango = ((IcmParamcalpresupuestosrangoBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmParamcalpresupuestosrango",
                                sourceIcmParamcalpresupuestosrango), sourceIcmParamcalpresupuestosrango,
                                (this.icmParamcalpresupuestosrango != null)));
                    copy.setIcmParamcalpresupuestosrango(copyIcmParamcalpresupuestosrango);
                } else {
                    if (icmParamcalpresupuestosrangoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalpresupuestosrango = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new M4LoadobjectOutput();
    }

}
