
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

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
 * <p>Clase Java para M4LoadobjectOutput complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="M4LoadobjectOutput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}LogMessage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Icm_Ws_Tools" type="{http://schemas.meta4.com/}Icm_Ws_ToolsBlock"/>
 *         &lt;element name="Icm_Listaconf" type="{http://schemas.meta4.com/}Icm_ListaconfBlock"/>
 *         &lt;element name="Icm_Paramconf" type="{http://schemas.meta4.com/}Icm_ParamconfBlock"/>
 *         &lt;element name="Icm_Listacadenas" type="{http://schemas.meta4.com/}Icm_ListacadenasBlock"/>
 *         &lt;element name="Icm_Listatiendas" type="{http://schemas.meta4.com/}Icm_ListatiendasBlock"/>
 *         &lt;element name="Icm_Listaempleado" type="{http://schemas.meta4.com/}Icm_ListaempleadoBlock"/>
 *         &lt;element name="Icm_Listaempresas" type="{http://schemas.meta4.com/}Icm_ListaempresasBlock"/>
 *         &lt;element name="Icm_Listaorigenes" type="{http://schemas.meta4.com/}Icm_ListaorigenesBlock"/>
 *         &lt;element name="Icm_Listaperiodos" type="{http://schemas.meta4.com/}Icm_ListaperiodosBlock"/>
 *         &lt;element name="Icm_Listaausencias" type="{http://schemas.meta4.com/}Icm_ListaausenciasBlock"/>
 *         &lt;element name="Icm_Listaempleados" type="{http://schemas.meta4.com/}Icm_ListaempleadosBlock"/>
 *         &lt;element name="Icm_Listapoliticas" type="{http://schemas.meta4.com/}Icm_ListapoliticasBlock"/>
 *         &lt;element name="Icm_Paramcalorigen" type="{http://schemas.meta4.com/}Icm_ParamcalorigenBlock"/>
 *         &lt;element name="Icm_Listaestructura" type="{http://schemas.meta4.com/}Icm_ListaestructuraBlock"/>
 *         &lt;element name="Icm_Paramcalperiodo" type="{http://schemas.meta4.com/}Icm_ParamcalperiodoBlock"/>
 *         &lt;element name="Icm_Paramcalproceso" type="{http://schemas.meta4.com/}Icm_ParamcalprocesoBlock"/>
 *         &lt;element name="Icm_Paramcalempleado" type="{http://schemas.meta4.com/}Icm_ParamcalempleadoBlock"/>
 *         &lt;element name="Icm_Paramcalsociedad" type="{http://schemas.meta4.com/}Icm_ParamcalsociedadBlock"/>
 *         &lt;element name="Icm_Parametrosentrada" type="{http://schemas.meta4.com/}Icm_ParametrosentradaBlock"/>
 *         &lt;element name="Icm_Resultadoguardado" type="{http://schemas.meta4.com/}Icm_ResultadoguardadoBlock"/>
 *         &lt;element name="Icm_Listaconfiguracion" type="{http://schemas.meta4.com/}Icm_ListaconfiguracionBlock"/>
 *         &lt;element name="Icm_Paramcalestructura" type="{http://schemas.meta4.com/}Icm_ParamcalestructuraBlock"/>
 *         &lt;element name="Icm_Ws_Calc_Operaciones" type="{http://schemas.meta4.com/}Icm_Ws_Calc_OperacionesBlock"/>
 *         &lt;element name="Icm_Parametrospaginacion" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "M4LoadobjectOutput", propOrder = {
    "_return",
    "logMessage",
    "icmWsTools",
    "icmListaconf",
    "icmParamconf",
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
    "icmListaestructura",
    "icmParamcalperiodo",
    "icmParamcalproceso",
    "icmParamcalempleado",
    "icmParamcalsociedad",
    "icmParametrosentrada",
    "icmResultadoguardado",
    "icmListaconfiguracion",
    "icmParamcalestructura",
    "icmWsCalcOperaciones",
    "icmParametrospaginacion"
})
public class M4LoadobjectOutput implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "return")
    protected double _return;
    @XmlElement(nillable = true)
    protected List<LogMessage> logMessage;
    @XmlElement(name = "Icm_Ws_Tools", required = true, nillable = true)
    protected IcmWsToolsBlock icmWsTools;
    @XmlElement(name = "Icm_Listaconf", required = true, nillable = true)
    protected IcmListaconfBlock icmListaconf;
    @XmlElement(name = "Icm_Paramconf", required = true, nillable = true)
    protected IcmParamconfBlock icmParamconf;
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
    @XmlElement(name = "Icm_Listaestructura", required = true, nillable = true)
    protected IcmListaestructuraBlock icmListaestructura;
    @XmlElement(name = "Icm_Paramcalperiodo", required = true, nillable = true)
    protected IcmParamcalperiodoBlock icmParamcalperiodo;
    @XmlElement(name = "Icm_Paramcalproceso", required = true, nillable = true)
    protected IcmParamcalprocesoBlock icmParamcalproceso;
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
    @XmlElement(name = "Icm_Paramcalestructura", required = true, nillable = true)
    protected IcmParamcalestructuraBlock icmParamcalestructura;
    @XmlElement(name = "Icm_Ws_Calc_Operaciones", required = true, nillable = true)
    protected IcmWsCalcOperacionesBlock icmWsCalcOperaciones;
    @XmlElement(name = "Icm_Parametrospaginacion", required = true, nillable = true)
    protected IcmParametrospaginacionBlock icmParametrospaginacion;

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
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessage }
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
     * 
     * @return
     *     possible object is
     *     {@link IcmWsToolsBlock }
     *     
     */
    public IcmWsToolsBlock getIcmWsTools() {
        return icmWsTools;
    }

    /**
     * Define el valor de la propiedad icmWsTools.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmWsToolsBlock }
     *     
     */
    public void setIcmWsTools(IcmWsToolsBlock value) {
        this.icmWsTools = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaconf.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaconfBlock }
     *     
     */
    public IcmListaconfBlock getIcmListaconf() {
        return icmListaconf;
    }

    /**
     * Define el valor de la propiedad icmListaconf.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaconfBlock }
     *     
     */
    public void setIcmListaconf(IcmListaconfBlock value) {
        this.icmListaconf = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamconf.
     * 
     * @return
     *     possible object is
     *     {@link IcmParamconfBlock }
     *     
     */
    public IcmParamconfBlock getIcmParamconf() {
        return icmParamconf;
    }

    /**
     * Define el valor de la propiedad icmParamconf.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParamconfBlock }
     *     
     */
    public void setIcmParamconf(IcmParamconfBlock value) {
        this.icmParamconf = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListacadenas.
     * 
     * @return
     *     possible object is
     *     {@link IcmListacadenasBlock }
     *     
     */
    public IcmListacadenasBlock getIcmListacadenas() {
        return icmListacadenas;
    }

    /**
     * Define el valor de la propiedad icmListacadenas.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListacadenasBlock }
     *     
     */
    public void setIcmListacadenas(IcmListacadenasBlock value) {
        this.icmListacadenas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListatiendas.
     * 
     * @return
     *     possible object is
     *     {@link IcmListatiendasBlock }
     *     
     */
    public IcmListatiendasBlock getIcmListatiendas() {
        return icmListatiendas;
    }

    /**
     * Define el valor de la propiedad icmListatiendas.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListatiendasBlock }
     *     
     */
    public void setIcmListatiendas(IcmListatiendasBlock value) {
        this.icmListatiendas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaempleadoBlock }
     *     
     */
    public IcmListaempleadoBlock getIcmListaempleado() {
        return icmListaempleado;
    }

    /**
     * Define el valor de la propiedad icmListaempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaempleadoBlock }
     *     
     */
    public void setIcmListaempleado(IcmListaempleadoBlock value) {
        this.icmListaempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaempresas.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaempresasBlock }
     *     
     */
    public IcmListaempresasBlock getIcmListaempresas() {
        return icmListaempresas;
    }

    /**
     * Define el valor de la propiedad icmListaempresas.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaempresasBlock }
     *     
     */
    public void setIcmListaempresas(IcmListaempresasBlock value) {
        this.icmListaempresas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaorigenes.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaorigenesBlock }
     *     
     */
    public IcmListaorigenesBlock getIcmListaorigenes() {
        return icmListaorigenes;
    }

    /**
     * Define el valor de la propiedad icmListaorigenes.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaorigenesBlock }
     *     
     */
    public void setIcmListaorigenes(IcmListaorigenesBlock value) {
        this.icmListaorigenes = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaperiodos.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaperiodosBlock }
     *     
     */
    public IcmListaperiodosBlock getIcmListaperiodos() {
        return icmListaperiodos;
    }

    /**
     * Define el valor de la propiedad icmListaperiodos.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaperiodosBlock }
     *     
     */
    public void setIcmListaperiodos(IcmListaperiodosBlock value) {
        this.icmListaperiodos = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaausencias.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaausenciasBlock }
     *     
     */
    public IcmListaausenciasBlock getIcmListaausencias() {
        return icmListaausencias;
    }

    /**
     * Define el valor de la propiedad icmListaausencias.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaausenciasBlock }
     *     
     */
    public void setIcmListaausencias(IcmListaausenciasBlock value) {
        this.icmListaausencias = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaempleados.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaempleadosBlock }
     *     
     */
    public IcmListaempleadosBlock getIcmListaempleados() {
        return icmListaempleados;
    }

    /**
     * Define el valor de la propiedad icmListaempleados.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaempleadosBlock }
     *     
     */
    public void setIcmListaempleados(IcmListaempleadosBlock value) {
        this.icmListaempleados = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListapoliticas.
     * 
     * @return
     *     possible object is
     *     {@link IcmListapoliticasBlock }
     *     
     */
    public IcmListapoliticasBlock getIcmListapoliticas() {
        return icmListapoliticas;
    }

    /**
     * Define el valor de la propiedad icmListapoliticas.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListapoliticasBlock }
     *     
     */
    public void setIcmListapoliticas(IcmListapoliticasBlock value) {
        this.icmListapoliticas = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalorigen.
     * 
     * @return
     *     possible object is
     *     {@link IcmParamcalorigenBlock }
     *     
     */
    public IcmParamcalorigenBlock getIcmParamcalorigen() {
        return icmParamcalorigen;
    }

    /**
     * Define el valor de la propiedad icmParamcalorigen.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParamcalorigenBlock }
     *     
     */
    public void setIcmParamcalorigen(IcmParamcalorigenBlock value) {
        this.icmParamcalorigen = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaestructura.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaestructuraBlock }
     *     
     */
    public IcmListaestructuraBlock getIcmListaestructura() {
        return icmListaestructura;
    }

    /**
     * Define el valor de la propiedad icmListaestructura.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaestructuraBlock }
     *     
     */
    public void setIcmListaestructura(IcmListaestructuraBlock value) {
        this.icmListaestructura = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalperiodo.
     * 
     * @return
     *     possible object is
     *     {@link IcmParamcalperiodoBlock }
     *     
     */
    public IcmParamcalperiodoBlock getIcmParamcalperiodo() {
        return icmParamcalperiodo;
    }

    /**
     * Define el valor de la propiedad icmParamcalperiodo.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParamcalperiodoBlock }
     *     
     */
    public void setIcmParamcalperiodo(IcmParamcalperiodoBlock value) {
        this.icmParamcalperiodo = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalproceso.
     * 
     * @return
     *     possible object is
     *     {@link IcmParamcalprocesoBlock }
     *     
     */
    public IcmParamcalprocesoBlock getIcmParamcalproceso() {
        return icmParamcalproceso;
    }

    /**
     * Define el valor de la propiedad icmParamcalproceso.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParamcalprocesoBlock }
     *     
     */
    public void setIcmParamcalproceso(IcmParamcalprocesoBlock value) {
        this.icmParamcalproceso = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmParamcalempleadoBlock }
     *     
     */
    public IcmParamcalempleadoBlock getIcmParamcalempleado() {
        return icmParamcalempleado;
    }

    /**
     * Define el valor de la propiedad icmParamcalempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParamcalempleadoBlock }
     *     
     */
    public void setIcmParamcalempleado(IcmParamcalempleadoBlock value) {
        this.icmParamcalempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalsociedad.
     * 
     * @return
     *     possible object is
     *     {@link IcmParamcalsociedadBlock }
     *     
     */
    public IcmParamcalsociedadBlock getIcmParamcalsociedad() {
        return icmParamcalsociedad;
    }

    /**
     * Define el valor de la propiedad icmParamcalsociedad.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParamcalsociedadBlock }
     *     
     */
    public void setIcmParamcalsociedad(IcmParamcalsociedadBlock value) {
        this.icmParamcalsociedad = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrosentrada.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosentradaBlock }
     *     
     */
    public IcmParametrosentradaBlock getIcmParametrosentrada() {
        return icmParametrosentrada;
    }

    /**
     * Define el valor de la propiedad icmParametrosentrada.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosentradaBlock }
     *     
     */
    public void setIcmParametrosentrada(IcmParametrosentradaBlock value) {
        this.icmParametrosentrada = value;
    }

    /**
     * Obtiene el valor de la propiedad icmResultadoguardado.
     * 
     * @return
     *     possible object is
     *     {@link IcmResultadoguardadoBlock }
     *     
     */
    public IcmResultadoguardadoBlock getIcmResultadoguardado() {
        return icmResultadoguardado;
    }

    /**
     * Define el valor de la propiedad icmResultadoguardado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmResultadoguardadoBlock }
     *     
     */
    public void setIcmResultadoguardado(IcmResultadoguardadoBlock value) {
        this.icmResultadoguardado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaconfiguracion.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaconfiguracionBlock }
     *     
     */
    public IcmListaconfiguracionBlock getIcmListaconfiguracion() {
        return icmListaconfiguracion;
    }

    /**
     * Define el valor de la propiedad icmListaconfiguracion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaconfiguracionBlock }
     *     
     */
    public void setIcmListaconfiguracion(IcmListaconfiguracionBlock value) {
        this.icmListaconfiguracion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParamcalestructura.
     * 
     * @return
     *     possible object is
     *     {@link IcmParamcalestructuraBlock }
     *     
     */
    public IcmParamcalestructuraBlock getIcmParamcalestructura() {
        return icmParamcalestructura;
    }

    /**
     * Define el valor de la propiedad icmParamcalestructura.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParamcalestructuraBlock }
     *     
     */
    public void setIcmParamcalestructura(IcmParamcalestructuraBlock value) {
        this.icmParamcalestructura = value;
    }

    /**
     * Obtiene el valor de la propiedad icmWsCalcOperaciones.
     * 
     * @return
     *     possible object is
     *     {@link IcmWsCalcOperacionesBlock }
     *     
     */
    public IcmWsCalcOperacionesBlock getIcmWsCalcOperaciones() {
        return icmWsCalcOperaciones;
    }

    /**
     * Define el valor de la propiedad icmWsCalcOperaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmWsCalcOperacionesBlock }
     *     
     */
    public void setIcmWsCalcOperaciones(IcmWsCalcOperacionesBlock value) {
        this.icmWsCalcOperaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrospaginacion.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public IcmParametrospaginacionBlock getIcmParametrospaginacion() {
        return icmParametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmParametrospaginacion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public void setIcmParametrospaginacion(IcmParametrospaginacionBlock value) {
        this.icmParametrospaginacion = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
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
            if (!strategy.equals(LocatorUtils.property(thisLocator, "_return", lhsReturn), LocatorUtils.property(thatLocator, "_return", rhsReturn), lhsReturn, rhsReturn, true, true)) {
                return false;
            }
        }
        {
            List<LogMessage> lhsLogMessage;
            lhsLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
            List<LogMessage> rhsLogMessage;
            rhsLogMessage = (((that.logMessage!= null)&&(!that.logMessage.isEmpty()))?that.getLogMessage():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "logMessage", lhsLogMessage), LocatorUtils.property(thatLocator, "logMessage", rhsLogMessage), lhsLogMessage, rhsLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())), ((that.logMessage!= null)&&(!that.logMessage.isEmpty())))) {
                return false;
            }
        }
        {
            IcmWsToolsBlock lhsIcmWsTools;
            lhsIcmWsTools = this.getIcmWsTools();
            IcmWsToolsBlock rhsIcmWsTools;
            rhsIcmWsTools = that.getIcmWsTools();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmWsTools", lhsIcmWsTools), LocatorUtils.property(thatLocator, "icmWsTools", rhsIcmWsTools), lhsIcmWsTools, rhsIcmWsTools, (this.icmWsTools!= null), (that.icmWsTools!= null))) {
                return false;
            }
        }
        {
            IcmListaconfBlock lhsIcmListaconf;
            lhsIcmListaconf = this.getIcmListaconf();
            IcmListaconfBlock rhsIcmListaconf;
            rhsIcmListaconf = that.getIcmListaconf();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconf", lhsIcmListaconf), LocatorUtils.property(thatLocator, "icmListaconf", rhsIcmListaconf), lhsIcmListaconf, rhsIcmListaconf, (this.icmListaconf!= null), (that.icmListaconf!= null))) {
                return false;
            }
        }
        {
            IcmParamconfBlock lhsIcmParamconf;
            lhsIcmParamconf = this.getIcmParamconf();
            IcmParamconfBlock rhsIcmParamconf;
            rhsIcmParamconf = that.getIcmParamconf();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamconf", lhsIcmParamconf), LocatorUtils.property(thatLocator, "icmParamconf", rhsIcmParamconf), lhsIcmParamconf, rhsIcmParamconf, (this.icmParamconf!= null), (that.icmParamconf!= null))) {
                return false;
            }
        }
        {
            IcmListacadenasBlock lhsIcmListacadenas;
            lhsIcmListacadenas = this.getIcmListacadenas();
            IcmListacadenasBlock rhsIcmListacadenas;
            rhsIcmListacadenas = that.getIcmListacadenas();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListacadenas", lhsIcmListacadenas), LocatorUtils.property(thatLocator, "icmListacadenas", rhsIcmListacadenas), lhsIcmListacadenas, rhsIcmListacadenas, (this.icmListacadenas!= null), (that.icmListacadenas!= null))) {
                return false;
            }
        }
        {
            IcmListatiendasBlock lhsIcmListatiendas;
            lhsIcmListatiendas = this.getIcmListatiendas();
            IcmListatiendasBlock rhsIcmListatiendas;
            rhsIcmListatiendas = that.getIcmListatiendas();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListatiendas", lhsIcmListatiendas), LocatorUtils.property(thatLocator, "icmListatiendas", rhsIcmListatiendas), lhsIcmListatiendas, rhsIcmListatiendas, (this.icmListatiendas!= null), (that.icmListatiendas!= null))) {
                return false;
            }
        }
        {
            IcmListaempleadoBlock lhsIcmListaempleado;
            lhsIcmListaempleado = this.getIcmListaempleado();
            IcmListaempleadoBlock rhsIcmListaempleado;
            rhsIcmListaempleado = that.getIcmListaempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaempleado", lhsIcmListaempleado), LocatorUtils.property(thatLocator, "icmListaempleado", rhsIcmListaempleado), lhsIcmListaempleado, rhsIcmListaempleado, (this.icmListaempleado!= null), (that.icmListaempleado!= null))) {
                return false;
            }
        }
        {
            IcmListaempresasBlock lhsIcmListaempresas;
            lhsIcmListaempresas = this.getIcmListaempresas();
            IcmListaempresasBlock rhsIcmListaempresas;
            rhsIcmListaempresas = that.getIcmListaempresas();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaempresas", lhsIcmListaempresas), LocatorUtils.property(thatLocator, "icmListaempresas", rhsIcmListaempresas), lhsIcmListaempresas, rhsIcmListaempresas, (this.icmListaempresas!= null), (that.icmListaempresas!= null))) {
                return false;
            }
        }
        {
            IcmListaorigenesBlock lhsIcmListaorigenes;
            lhsIcmListaorigenes = this.getIcmListaorigenes();
            IcmListaorigenesBlock rhsIcmListaorigenes;
            rhsIcmListaorigenes = that.getIcmListaorigenes();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaorigenes", lhsIcmListaorigenes), LocatorUtils.property(thatLocator, "icmListaorigenes", rhsIcmListaorigenes), lhsIcmListaorigenes, rhsIcmListaorigenes, (this.icmListaorigenes!= null), (that.icmListaorigenes!= null))) {
                return false;
            }
        }
        {
            IcmListaperiodosBlock lhsIcmListaperiodos;
            lhsIcmListaperiodos = this.getIcmListaperiodos();
            IcmListaperiodosBlock rhsIcmListaperiodos;
            rhsIcmListaperiodos = that.getIcmListaperiodos();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaperiodos", lhsIcmListaperiodos), LocatorUtils.property(thatLocator, "icmListaperiodos", rhsIcmListaperiodos), lhsIcmListaperiodos, rhsIcmListaperiodos, (this.icmListaperiodos!= null), (that.icmListaperiodos!= null))) {
                return false;
            }
        }
        {
            IcmListaausenciasBlock lhsIcmListaausencias;
            lhsIcmListaausencias = this.getIcmListaausencias();
            IcmListaausenciasBlock rhsIcmListaausencias;
            rhsIcmListaausencias = that.getIcmListaausencias();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaausencias", lhsIcmListaausencias), LocatorUtils.property(thatLocator, "icmListaausencias", rhsIcmListaausencias), lhsIcmListaausencias, rhsIcmListaausencias, (this.icmListaausencias!= null), (that.icmListaausencias!= null))) {
                return false;
            }
        }
        {
            IcmListaempleadosBlock lhsIcmListaempleados;
            lhsIcmListaempleados = this.getIcmListaempleados();
            IcmListaempleadosBlock rhsIcmListaempleados;
            rhsIcmListaempleados = that.getIcmListaempleados();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaempleados", lhsIcmListaempleados), LocatorUtils.property(thatLocator, "icmListaempleados", rhsIcmListaempleados), lhsIcmListaempleados, rhsIcmListaempleados, (this.icmListaempleados!= null), (that.icmListaempleados!= null))) {
                return false;
            }
        }
        {
            IcmListapoliticasBlock lhsIcmListapoliticas;
            lhsIcmListapoliticas = this.getIcmListapoliticas();
            IcmListapoliticasBlock rhsIcmListapoliticas;
            rhsIcmListapoliticas = that.getIcmListapoliticas();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListapoliticas", lhsIcmListapoliticas), LocatorUtils.property(thatLocator, "icmListapoliticas", rhsIcmListapoliticas), lhsIcmListapoliticas, rhsIcmListapoliticas, (this.icmListapoliticas!= null), (that.icmListapoliticas!= null))) {
                return false;
            }
        }
        {
            IcmParamcalorigenBlock lhsIcmParamcalorigen;
            lhsIcmParamcalorigen = this.getIcmParamcalorigen();
            IcmParamcalorigenBlock rhsIcmParamcalorigen;
            rhsIcmParamcalorigen = that.getIcmParamcalorigen();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalorigen", lhsIcmParamcalorigen), LocatorUtils.property(thatLocator, "icmParamcalorigen", rhsIcmParamcalorigen), lhsIcmParamcalorigen, rhsIcmParamcalorigen, (this.icmParamcalorigen!= null), (that.icmParamcalorigen!= null))) {
                return false;
            }
        }
        {
            IcmListaestructuraBlock lhsIcmListaestructura;
            lhsIcmListaestructura = this.getIcmListaestructura();
            IcmListaestructuraBlock rhsIcmListaestructura;
            rhsIcmListaestructura = that.getIcmListaestructura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaestructura", lhsIcmListaestructura), LocatorUtils.property(thatLocator, "icmListaestructura", rhsIcmListaestructura), lhsIcmListaestructura, rhsIcmListaestructura, (this.icmListaestructura!= null), (that.icmListaestructura!= null))) {
                return false;
            }
        }
        {
            IcmParamcalperiodoBlock lhsIcmParamcalperiodo;
            lhsIcmParamcalperiodo = this.getIcmParamcalperiodo();
            IcmParamcalperiodoBlock rhsIcmParamcalperiodo;
            rhsIcmParamcalperiodo = that.getIcmParamcalperiodo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalperiodo", lhsIcmParamcalperiodo), LocatorUtils.property(thatLocator, "icmParamcalperiodo", rhsIcmParamcalperiodo), lhsIcmParamcalperiodo, rhsIcmParamcalperiodo, (this.icmParamcalperiodo!= null), (that.icmParamcalperiodo!= null))) {
                return false;
            }
        }
        {
            IcmParamcalprocesoBlock lhsIcmParamcalproceso;
            lhsIcmParamcalproceso = this.getIcmParamcalproceso();
            IcmParamcalprocesoBlock rhsIcmParamcalproceso;
            rhsIcmParamcalproceso = that.getIcmParamcalproceso();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalproceso", lhsIcmParamcalproceso), LocatorUtils.property(thatLocator, "icmParamcalproceso", rhsIcmParamcalproceso), lhsIcmParamcalproceso, rhsIcmParamcalproceso, (this.icmParamcalproceso!= null), (that.icmParamcalproceso!= null))) {
                return false;
            }
        }
        {
            IcmParamcalempleadoBlock lhsIcmParamcalempleado;
            lhsIcmParamcalempleado = this.getIcmParamcalempleado();
            IcmParamcalempleadoBlock rhsIcmParamcalempleado;
            rhsIcmParamcalempleado = that.getIcmParamcalempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalempleado", lhsIcmParamcalempleado), LocatorUtils.property(thatLocator, "icmParamcalempleado", rhsIcmParamcalempleado), lhsIcmParamcalempleado, rhsIcmParamcalempleado, (this.icmParamcalempleado!= null), (that.icmParamcalempleado!= null))) {
                return false;
            }
        }
        {
            IcmParamcalsociedadBlock lhsIcmParamcalsociedad;
            lhsIcmParamcalsociedad = this.getIcmParamcalsociedad();
            IcmParamcalsociedadBlock rhsIcmParamcalsociedad;
            rhsIcmParamcalsociedad = that.getIcmParamcalsociedad();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalsociedad", lhsIcmParamcalsociedad), LocatorUtils.property(thatLocator, "icmParamcalsociedad", rhsIcmParamcalsociedad), lhsIcmParamcalsociedad, rhsIcmParamcalsociedad, (this.icmParamcalsociedad!= null), (that.icmParamcalsociedad!= null))) {
                return false;
            }
        }
        {
            IcmParametrosentradaBlock lhsIcmParametrosentrada;
            lhsIcmParametrosentrada = this.getIcmParametrosentrada();
            IcmParametrosentradaBlock rhsIcmParametrosentrada;
            rhsIcmParametrosentrada = that.getIcmParametrosentrada();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrosentrada", lhsIcmParametrosentrada), LocatorUtils.property(thatLocator, "icmParametrosentrada", rhsIcmParametrosentrada), lhsIcmParametrosentrada, rhsIcmParametrosentrada, (this.icmParametrosentrada!= null), (that.icmParametrosentrada!= null))) {
                return false;
            }
        }
        {
            IcmResultadoguardadoBlock lhsIcmResultadoguardado;
            lhsIcmResultadoguardado = this.getIcmResultadoguardado();
            IcmResultadoguardadoBlock rhsIcmResultadoguardado;
            rhsIcmResultadoguardado = that.getIcmResultadoguardado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmResultadoguardado", lhsIcmResultadoguardado), LocatorUtils.property(thatLocator, "icmResultadoguardado", rhsIcmResultadoguardado), lhsIcmResultadoguardado, rhsIcmResultadoguardado, (this.icmResultadoguardado!= null), (that.icmResultadoguardado!= null))) {
                return false;
            }
        }
        {
            IcmListaconfiguracionBlock lhsIcmListaconfiguracion;
            lhsIcmListaconfiguracion = this.getIcmListaconfiguracion();
            IcmListaconfiguracionBlock rhsIcmListaconfiguracion;
            rhsIcmListaconfiguracion = that.getIcmListaconfiguracion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconfiguracion", lhsIcmListaconfiguracion), LocatorUtils.property(thatLocator, "icmListaconfiguracion", rhsIcmListaconfiguracion), lhsIcmListaconfiguracion, rhsIcmListaconfiguracion, (this.icmListaconfiguracion!= null), (that.icmListaconfiguracion!= null))) {
                return false;
            }
        }
        {
            IcmParamcalestructuraBlock lhsIcmParamcalestructura;
            lhsIcmParamcalestructura = this.getIcmParamcalestructura();
            IcmParamcalestructuraBlock rhsIcmParamcalestructura;
            rhsIcmParamcalestructura = that.getIcmParamcalestructura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalestructura", lhsIcmParamcalestructura), LocatorUtils.property(thatLocator, "icmParamcalestructura", rhsIcmParamcalestructura), lhsIcmParamcalestructura, rhsIcmParamcalestructura, (this.icmParamcalestructura!= null), (that.icmParamcalestructura!= null))) {
                return false;
            }
        }
        {
            IcmWsCalcOperacionesBlock lhsIcmWsCalcOperaciones;
            lhsIcmWsCalcOperaciones = this.getIcmWsCalcOperaciones();
            IcmWsCalcOperacionesBlock rhsIcmWsCalcOperaciones;
            rhsIcmWsCalcOperaciones = that.getIcmWsCalcOperaciones();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmWsCalcOperaciones", lhsIcmWsCalcOperaciones), LocatorUtils.property(thatLocator, "icmWsCalcOperaciones", rhsIcmWsCalcOperaciones), lhsIcmWsCalcOperaciones, rhsIcmWsCalcOperaciones, (this.icmWsCalcOperaciones!= null), (that.icmWsCalcOperaciones!= null))) {
                return false;
            }
        }
        {
            IcmParametrospaginacionBlock lhsIcmParametrospaginacion;
            lhsIcmParametrospaginacion = this.getIcmParametrospaginacion();
            IcmParametrospaginacionBlock rhsIcmParametrospaginacion;
            rhsIcmParametrospaginacion = that.getIcmParametrospaginacion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrospaginacion", lhsIcmParametrospaginacion), LocatorUtils.property(thatLocator, "icmParametrospaginacion", rhsIcmParametrospaginacion), lhsIcmParametrospaginacion, rhsIcmParametrospaginacion, (this.icmParametrospaginacion!= null), (that.icmParametrospaginacion!= null))) {
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
            theLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
            strategy.appendField(locator, this, "logMessage", buffer, theLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())));
        }
        {
            IcmWsToolsBlock theIcmWsTools;
            theIcmWsTools = this.getIcmWsTools();
            strategy.appendField(locator, this, "icmWsTools", buffer, theIcmWsTools, (this.icmWsTools!= null));
        }
        {
            IcmListaconfBlock theIcmListaconf;
            theIcmListaconf = this.getIcmListaconf();
            strategy.appendField(locator, this, "icmListaconf", buffer, theIcmListaconf, (this.icmListaconf!= null));
        }
        {
            IcmParamconfBlock theIcmParamconf;
            theIcmParamconf = this.getIcmParamconf();
            strategy.appendField(locator, this, "icmParamconf", buffer, theIcmParamconf, (this.icmParamconf!= null));
        }
        {
            IcmListacadenasBlock theIcmListacadenas;
            theIcmListacadenas = this.getIcmListacadenas();
            strategy.appendField(locator, this, "icmListacadenas", buffer, theIcmListacadenas, (this.icmListacadenas!= null));
        }
        {
            IcmListatiendasBlock theIcmListatiendas;
            theIcmListatiendas = this.getIcmListatiendas();
            strategy.appendField(locator, this, "icmListatiendas", buffer, theIcmListatiendas, (this.icmListatiendas!= null));
        }
        {
            IcmListaempleadoBlock theIcmListaempleado;
            theIcmListaempleado = this.getIcmListaempleado();
            strategy.appendField(locator, this, "icmListaempleado", buffer, theIcmListaempleado, (this.icmListaempleado!= null));
        }
        {
            IcmListaempresasBlock theIcmListaempresas;
            theIcmListaempresas = this.getIcmListaempresas();
            strategy.appendField(locator, this, "icmListaempresas", buffer, theIcmListaempresas, (this.icmListaempresas!= null));
        }
        {
            IcmListaorigenesBlock theIcmListaorigenes;
            theIcmListaorigenes = this.getIcmListaorigenes();
            strategy.appendField(locator, this, "icmListaorigenes", buffer, theIcmListaorigenes, (this.icmListaorigenes!= null));
        }
        {
            IcmListaperiodosBlock theIcmListaperiodos;
            theIcmListaperiodos = this.getIcmListaperiodos();
            strategy.appendField(locator, this, "icmListaperiodos", buffer, theIcmListaperiodos, (this.icmListaperiodos!= null));
        }
        {
            IcmListaausenciasBlock theIcmListaausencias;
            theIcmListaausencias = this.getIcmListaausencias();
            strategy.appendField(locator, this, "icmListaausencias", buffer, theIcmListaausencias, (this.icmListaausencias!= null));
        }
        {
            IcmListaempleadosBlock theIcmListaempleados;
            theIcmListaempleados = this.getIcmListaempleados();
            strategy.appendField(locator, this, "icmListaempleados", buffer, theIcmListaempleados, (this.icmListaempleados!= null));
        }
        {
            IcmListapoliticasBlock theIcmListapoliticas;
            theIcmListapoliticas = this.getIcmListapoliticas();
            strategy.appendField(locator, this, "icmListapoliticas", buffer, theIcmListapoliticas, (this.icmListapoliticas!= null));
        }
        {
            IcmParamcalorigenBlock theIcmParamcalorigen;
            theIcmParamcalorigen = this.getIcmParamcalorigen();
            strategy.appendField(locator, this, "icmParamcalorigen", buffer, theIcmParamcalorigen, (this.icmParamcalorigen!= null));
        }
        {
            IcmListaestructuraBlock theIcmListaestructura;
            theIcmListaestructura = this.getIcmListaestructura();
            strategy.appendField(locator, this, "icmListaestructura", buffer, theIcmListaestructura, (this.icmListaestructura!= null));
        }
        {
            IcmParamcalperiodoBlock theIcmParamcalperiodo;
            theIcmParamcalperiodo = this.getIcmParamcalperiodo();
            strategy.appendField(locator, this, "icmParamcalperiodo", buffer, theIcmParamcalperiodo, (this.icmParamcalperiodo!= null));
        }
        {
            IcmParamcalprocesoBlock theIcmParamcalproceso;
            theIcmParamcalproceso = this.getIcmParamcalproceso();
            strategy.appendField(locator, this, "icmParamcalproceso", buffer, theIcmParamcalproceso, (this.icmParamcalproceso!= null));
        }
        {
            IcmParamcalempleadoBlock theIcmParamcalempleado;
            theIcmParamcalempleado = this.getIcmParamcalempleado();
            strategy.appendField(locator, this, "icmParamcalempleado", buffer, theIcmParamcalempleado, (this.icmParamcalempleado!= null));
        }
        {
            IcmParamcalsociedadBlock theIcmParamcalsociedad;
            theIcmParamcalsociedad = this.getIcmParamcalsociedad();
            strategy.appendField(locator, this, "icmParamcalsociedad", buffer, theIcmParamcalsociedad, (this.icmParamcalsociedad!= null));
        }
        {
            IcmParametrosentradaBlock theIcmParametrosentrada;
            theIcmParametrosentrada = this.getIcmParametrosentrada();
            strategy.appendField(locator, this, "icmParametrosentrada", buffer, theIcmParametrosentrada, (this.icmParametrosentrada!= null));
        }
        {
            IcmResultadoguardadoBlock theIcmResultadoguardado;
            theIcmResultadoguardado = this.getIcmResultadoguardado();
            strategy.appendField(locator, this, "icmResultadoguardado", buffer, theIcmResultadoguardado, (this.icmResultadoguardado!= null));
        }
        {
            IcmListaconfiguracionBlock theIcmListaconfiguracion;
            theIcmListaconfiguracion = this.getIcmListaconfiguracion();
            strategy.appendField(locator, this, "icmListaconfiguracion", buffer, theIcmListaconfiguracion, (this.icmListaconfiguracion!= null));
        }
        {
            IcmParamcalestructuraBlock theIcmParamcalestructura;
            theIcmParamcalestructura = this.getIcmParamcalestructura();
            strategy.appendField(locator, this, "icmParamcalestructura", buffer, theIcmParamcalestructura, (this.icmParamcalestructura!= null));
        }
        {
            IcmWsCalcOperacionesBlock theIcmWsCalcOperaciones;
            theIcmWsCalcOperaciones = this.getIcmWsCalcOperaciones();
            strategy.appendField(locator, this, "icmWsCalcOperaciones", buffer, theIcmWsCalcOperaciones, (this.icmWsCalcOperaciones!= null));
        }
        {
            IcmParametrospaginacionBlock theIcmParametrospaginacion;
            theIcmParametrospaginacion = this.getIcmParametrospaginacion();
            strategy.appendField(locator, this, "icmParametrospaginacion", buffer, theIcmParametrospaginacion, (this.icmParametrospaginacion!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            double theReturn;
            theReturn = this.getReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "_return", theReturn), currentHashCode, theReturn, true);
        }
        {
            List<LogMessage> theLogMessage;
            theLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "logMessage", theLogMessage), currentHashCode, theLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())));
        }
        {
            IcmWsToolsBlock theIcmWsTools;
            theIcmWsTools = this.getIcmWsTools();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmWsTools", theIcmWsTools), currentHashCode, theIcmWsTools, (this.icmWsTools!= null));
        }
        {
            IcmListaconfBlock theIcmListaconf;
            theIcmListaconf = this.getIcmListaconf();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaconf", theIcmListaconf), currentHashCode, theIcmListaconf, (this.icmListaconf!= null));
        }
        {
            IcmParamconfBlock theIcmParamconf;
            theIcmParamconf = this.getIcmParamconf();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamconf", theIcmParamconf), currentHashCode, theIcmParamconf, (this.icmParamconf!= null));
        }
        {
            IcmListacadenasBlock theIcmListacadenas;
            theIcmListacadenas = this.getIcmListacadenas();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListacadenas", theIcmListacadenas), currentHashCode, theIcmListacadenas, (this.icmListacadenas!= null));
        }
        {
            IcmListatiendasBlock theIcmListatiendas;
            theIcmListatiendas = this.getIcmListatiendas();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListatiendas", theIcmListatiendas), currentHashCode, theIcmListatiendas, (this.icmListatiendas!= null));
        }
        {
            IcmListaempleadoBlock theIcmListaempleado;
            theIcmListaempleado = this.getIcmListaempleado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaempleado", theIcmListaempleado), currentHashCode, theIcmListaempleado, (this.icmListaempleado!= null));
        }
        {
            IcmListaempresasBlock theIcmListaempresas;
            theIcmListaempresas = this.getIcmListaempresas();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaempresas", theIcmListaempresas), currentHashCode, theIcmListaempresas, (this.icmListaempresas!= null));
        }
        {
            IcmListaorigenesBlock theIcmListaorigenes;
            theIcmListaorigenes = this.getIcmListaorigenes();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaorigenes", theIcmListaorigenes), currentHashCode, theIcmListaorigenes, (this.icmListaorigenes!= null));
        }
        {
            IcmListaperiodosBlock theIcmListaperiodos;
            theIcmListaperiodos = this.getIcmListaperiodos();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaperiodos", theIcmListaperiodos), currentHashCode, theIcmListaperiodos, (this.icmListaperiodos!= null));
        }
        {
            IcmListaausenciasBlock theIcmListaausencias;
            theIcmListaausencias = this.getIcmListaausencias();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaausencias", theIcmListaausencias), currentHashCode, theIcmListaausencias, (this.icmListaausencias!= null));
        }
        {
            IcmListaempleadosBlock theIcmListaempleados;
            theIcmListaempleados = this.getIcmListaempleados();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaempleados", theIcmListaempleados), currentHashCode, theIcmListaempleados, (this.icmListaempleados!= null));
        }
        {
            IcmListapoliticasBlock theIcmListapoliticas;
            theIcmListapoliticas = this.getIcmListapoliticas();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListapoliticas", theIcmListapoliticas), currentHashCode, theIcmListapoliticas, (this.icmListapoliticas!= null));
        }
        {
            IcmParamcalorigenBlock theIcmParamcalorigen;
            theIcmParamcalorigen = this.getIcmParamcalorigen();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalorigen", theIcmParamcalorigen), currentHashCode, theIcmParamcalorigen, (this.icmParamcalorigen!= null));
        }
        {
            IcmListaestructuraBlock theIcmListaestructura;
            theIcmListaestructura = this.getIcmListaestructura();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaestructura", theIcmListaestructura), currentHashCode, theIcmListaestructura, (this.icmListaestructura!= null));
        }
        {
            IcmParamcalperiodoBlock theIcmParamcalperiodo;
            theIcmParamcalperiodo = this.getIcmParamcalperiodo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalperiodo", theIcmParamcalperiodo), currentHashCode, theIcmParamcalperiodo, (this.icmParamcalperiodo!= null));
        }
        {
            IcmParamcalprocesoBlock theIcmParamcalproceso;
            theIcmParamcalproceso = this.getIcmParamcalproceso();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalproceso", theIcmParamcalproceso), currentHashCode, theIcmParamcalproceso, (this.icmParamcalproceso!= null));
        }
        {
            IcmParamcalempleadoBlock theIcmParamcalempleado;
            theIcmParamcalempleado = this.getIcmParamcalempleado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalempleado", theIcmParamcalempleado), currentHashCode, theIcmParamcalempleado, (this.icmParamcalempleado!= null));
        }
        {
            IcmParamcalsociedadBlock theIcmParamcalsociedad;
            theIcmParamcalsociedad = this.getIcmParamcalsociedad();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalsociedad", theIcmParamcalsociedad), currentHashCode, theIcmParamcalsociedad, (this.icmParamcalsociedad!= null));
        }
        {
            IcmParametrosentradaBlock theIcmParametrosentrada;
            theIcmParametrosentrada = this.getIcmParametrosentrada();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrosentrada", theIcmParametrosentrada), currentHashCode, theIcmParametrosentrada, (this.icmParametrosentrada!= null));
        }
        {
            IcmResultadoguardadoBlock theIcmResultadoguardado;
            theIcmResultadoguardado = this.getIcmResultadoguardado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmResultadoguardado", theIcmResultadoguardado), currentHashCode, theIcmResultadoguardado, (this.icmResultadoguardado!= null));
        }
        {
            IcmListaconfiguracionBlock theIcmListaconfiguracion;
            theIcmListaconfiguracion = this.getIcmListaconfiguracion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaconfiguracion", theIcmListaconfiguracion), currentHashCode, theIcmListaconfiguracion, (this.icmListaconfiguracion!= null));
        }
        {
            IcmParamcalestructuraBlock theIcmParamcalestructura;
            theIcmParamcalestructura = this.getIcmParamcalestructura();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalestructura", theIcmParamcalestructura), currentHashCode, theIcmParamcalestructura, (this.icmParamcalestructura!= null));
        }
        {
            IcmWsCalcOperacionesBlock theIcmWsCalcOperaciones;
            theIcmWsCalcOperaciones = this.getIcmWsCalcOperaciones();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmWsCalcOperaciones", theIcmWsCalcOperaciones), currentHashCode, theIcmWsCalcOperaciones, (this.icmWsCalcOperaciones!= null));
        }
        {
            IcmParametrospaginacionBlock theIcmParametrospaginacion;
            theIcmParametrospaginacion = this.getIcmParametrospaginacion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrospaginacion", theIcmParametrospaginacion), currentHashCode, theIcmParametrospaginacion, (this.icmParametrospaginacion!= null));
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
        if (draftCopy instanceof M4LoadobjectOutput) {
            final M4LoadobjectOutput copy = ((M4LoadobjectOutput) draftCopy);
            {
                Boolean _returnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, true);
                if (_returnShouldBeCopiedAndSet == Boolean.TRUE) {
                    double sourceReturn;
                    sourceReturn = this.getReturn();
                    double copyReturn = strategy.copy(LocatorUtils.property(locator, "_return", sourceReturn), sourceReturn, true);
                    copy.setReturn(copyReturn);
                } else {
                    if (_returnShouldBeCopiedAndSet == Boolean.FALSE) {
                    }
                }
            }
            {
                Boolean logMessageShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())));
                if (logMessageShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<LogMessage> sourceLogMessage;
                    sourceLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
                    @SuppressWarnings("unchecked")
                    List<LogMessage> copyLogMessage = ((List<LogMessage> ) strategy.copy(LocatorUtils.property(locator, "logMessage", sourceLogMessage), sourceLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty()))));
                    copy.logMessage = null;
                    if (copyLogMessage!= null) {
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
                Boolean icmWsToolsShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmWsTools!= null));
                if (icmWsToolsShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmWsToolsBlock sourceIcmWsTools;
                    sourceIcmWsTools = this.getIcmWsTools();
                    IcmWsToolsBlock copyIcmWsTools = ((IcmWsToolsBlock) strategy.copy(LocatorUtils.property(locator, "icmWsTools", sourceIcmWsTools), sourceIcmWsTools, (this.icmWsTools!= null)));
                    copy.setIcmWsTools(copyIcmWsTools);
                } else {
                    if (icmWsToolsShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmWsTools = null;
                    }
                }
            }
            {
                Boolean icmListaconfShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListaconf!= null));
                if (icmListaconfShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconfBlock sourceIcmListaconf;
                    sourceIcmListaconf = this.getIcmListaconf();
                    IcmListaconfBlock copyIcmListaconf = ((IcmListaconfBlock) strategy.copy(LocatorUtils.property(locator, "icmListaconf", sourceIcmListaconf), sourceIcmListaconf, (this.icmListaconf!= null)));
                    copy.setIcmListaconf(copyIcmListaconf);
                } else {
                    if (icmListaconfShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaconf = null;
                    }
                }
            }
            {
                Boolean icmParamconfShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParamconf!= null));
                if (icmParamconfShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamconfBlock sourceIcmParamconf;
                    sourceIcmParamconf = this.getIcmParamconf();
                    IcmParamconfBlock copyIcmParamconf = ((IcmParamconfBlock) strategy.copy(LocatorUtils.property(locator, "icmParamconf", sourceIcmParamconf), sourceIcmParamconf, (this.icmParamconf!= null)));
                    copy.setIcmParamconf(copyIcmParamconf);
                } else {
                    if (icmParamconfShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamconf = null;
                    }
                }
            }
            {
                Boolean icmListacadenasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListacadenas!= null));
                if (icmListacadenasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListacadenasBlock sourceIcmListacadenas;
                    sourceIcmListacadenas = this.getIcmListacadenas();
                    IcmListacadenasBlock copyIcmListacadenas = ((IcmListacadenasBlock) strategy.copy(LocatorUtils.property(locator, "icmListacadenas", sourceIcmListacadenas), sourceIcmListacadenas, (this.icmListacadenas!= null)));
                    copy.setIcmListacadenas(copyIcmListacadenas);
                } else {
                    if (icmListacadenasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListacadenas = null;
                    }
                }
            }
            {
                Boolean icmListatiendasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListatiendas!= null));
                if (icmListatiendasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListatiendasBlock sourceIcmListatiendas;
                    sourceIcmListatiendas = this.getIcmListatiendas();
                    IcmListatiendasBlock copyIcmListatiendas = ((IcmListatiendasBlock) strategy.copy(LocatorUtils.property(locator, "icmListatiendas", sourceIcmListatiendas), sourceIcmListatiendas, (this.icmListatiendas!= null)));
                    copy.setIcmListatiendas(copyIcmListatiendas);
                } else {
                    if (icmListatiendasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListatiendas = null;
                    }
                }
            }
            {
                Boolean icmListaempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListaempleado!= null));
                if (icmListaempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaempleadoBlock sourceIcmListaempleado;
                    sourceIcmListaempleado = this.getIcmListaempleado();
                    IcmListaempleadoBlock copyIcmListaempleado = ((IcmListaempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmListaempleado", sourceIcmListaempleado), sourceIcmListaempleado, (this.icmListaempleado!= null)));
                    copy.setIcmListaempleado(copyIcmListaempleado);
                } else {
                    if (icmListaempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaempleado = null;
                    }
                }
            }
            {
                Boolean icmListaempresasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListaempresas!= null));
                if (icmListaempresasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaempresasBlock sourceIcmListaempresas;
                    sourceIcmListaempresas = this.getIcmListaempresas();
                    IcmListaempresasBlock copyIcmListaempresas = ((IcmListaempresasBlock) strategy.copy(LocatorUtils.property(locator, "icmListaempresas", sourceIcmListaempresas), sourceIcmListaempresas, (this.icmListaempresas!= null)));
                    copy.setIcmListaempresas(copyIcmListaempresas);
                } else {
                    if (icmListaempresasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaempresas = null;
                    }
                }
            }
            {
                Boolean icmListaorigenesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListaorigenes!= null));
                if (icmListaorigenesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaorigenesBlock sourceIcmListaorigenes;
                    sourceIcmListaorigenes = this.getIcmListaorigenes();
                    IcmListaorigenesBlock copyIcmListaorigenes = ((IcmListaorigenesBlock) strategy.copy(LocatorUtils.property(locator, "icmListaorigenes", sourceIcmListaorigenes), sourceIcmListaorigenes, (this.icmListaorigenes!= null)));
                    copy.setIcmListaorigenes(copyIcmListaorigenes);
                } else {
                    if (icmListaorigenesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaorigenes = null;
                    }
                }
            }
            {
                Boolean icmListaperiodosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListaperiodos!= null));
                if (icmListaperiodosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaperiodosBlock sourceIcmListaperiodos;
                    sourceIcmListaperiodos = this.getIcmListaperiodos();
                    IcmListaperiodosBlock copyIcmListaperiodos = ((IcmListaperiodosBlock) strategy.copy(LocatorUtils.property(locator, "icmListaperiodos", sourceIcmListaperiodos), sourceIcmListaperiodos, (this.icmListaperiodos!= null)));
                    copy.setIcmListaperiodos(copyIcmListaperiodos);
                } else {
                    if (icmListaperiodosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaperiodos = null;
                    }
                }
            }
            {
                Boolean icmListaausenciasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListaausencias!= null));
                if (icmListaausenciasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaausenciasBlock sourceIcmListaausencias;
                    sourceIcmListaausencias = this.getIcmListaausencias();
                    IcmListaausenciasBlock copyIcmListaausencias = ((IcmListaausenciasBlock) strategy.copy(LocatorUtils.property(locator, "icmListaausencias", sourceIcmListaausencias), sourceIcmListaausencias, (this.icmListaausencias!= null)));
                    copy.setIcmListaausencias(copyIcmListaausencias);
                } else {
                    if (icmListaausenciasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaausencias = null;
                    }
                }
            }
            {
                Boolean icmListaempleadosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListaempleados!= null));
                if (icmListaempleadosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaempleadosBlock sourceIcmListaempleados;
                    sourceIcmListaempleados = this.getIcmListaempleados();
                    IcmListaempleadosBlock copyIcmListaempleados = ((IcmListaempleadosBlock) strategy.copy(LocatorUtils.property(locator, "icmListaempleados", sourceIcmListaempleados), sourceIcmListaempleados, (this.icmListaempleados!= null)));
                    copy.setIcmListaempleados(copyIcmListaempleados);
                } else {
                    if (icmListaempleadosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaempleados = null;
                    }
                }
            }
            {
                Boolean icmListapoliticasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListapoliticas!= null));
                if (icmListapoliticasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListapoliticasBlock sourceIcmListapoliticas;
                    sourceIcmListapoliticas = this.getIcmListapoliticas();
                    IcmListapoliticasBlock copyIcmListapoliticas = ((IcmListapoliticasBlock) strategy.copy(LocatorUtils.property(locator, "icmListapoliticas", sourceIcmListapoliticas), sourceIcmListapoliticas, (this.icmListapoliticas!= null)));
                    copy.setIcmListapoliticas(copyIcmListapoliticas);
                } else {
                    if (icmListapoliticasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListapoliticas = null;
                    }
                }
            }
            {
                Boolean icmParamcalorigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParamcalorigen!= null));
                if (icmParamcalorigenShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalorigenBlock sourceIcmParamcalorigen;
                    sourceIcmParamcalorigen = this.getIcmParamcalorigen();
                    IcmParamcalorigenBlock copyIcmParamcalorigen = ((IcmParamcalorigenBlock) strategy.copy(LocatorUtils.property(locator, "icmParamcalorigen", sourceIcmParamcalorigen), sourceIcmParamcalorigen, (this.icmParamcalorigen!= null)));
                    copy.setIcmParamcalorigen(copyIcmParamcalorigen);
                } else {
                    if (icmParamcalorigenShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalorigen = null;
                    }
                }
            }
            {
                Boolean icmListaestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListaestructura!= null));
                if (icmListaestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaestructuraBlock sourceIcmListaestructura;
                    sourceIcmListaestructura = this.getIcmListaestructura();
                    IcmListaestructuraBlock copyIcmListaestructura = ((IcmListaestructuraBlock) strategy.copy(LocatorUtils.property(locator, "icmListaestructura", sourceIcmListaestructura), sourceIcmListaestructura, (this.icmListaestructura!= null)));
                    copy.setIcmListaestructura(copyIcmListaestructura);
                } else {
                    if (icmListaestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaestructura = null;
                    }
                }
            }
            {
                Boolean icmParamcalperiodoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParamcalperiodo!= null));
                if (icmParamcalperiodoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalperiodoBlock sourceIcmParamcalperiodo;
                    sourceIcmParamcalperiodo = this.getIcmParamcalperiodo();
                    IcmParamcalperiodoBlock copyIcmParamcalperiodo = ((IcmParamcalperiodoBlock) strategy.copy(LocatorUtils.property(locator, "icmParamcalperiodo", sourceIcmParamcalperiodo), sourceIcmParamcalperiodo, (this.icmParamcalperiodo!= null)));
                    copy.setIcmParamcalperiodo(copyIcmParamcalperiodo);
                } else {
                    if (icmParamcalperiodoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalperiodo = null;
                    }
                }
            }
            {
                Boolean icmParamcalprocesoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParamcalproceso!= null));
                if (icmParamcalprocesoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalprocesoBlock sourceIcmParamcalproceso;
                    sourceIcmParamcalproceso = this.getIcmParamcalproceso();
                    IcmParamcalprocesoBlock copyIcmParamcalproceso = ((IcmParamcalprocesoBlock) strategy.copy(LocatorUtils.property(locator, "icmParamcalproceso", sourceIcmParamcalproceso), sourceIcmParamcalproceso, (this.icmParamcalproceso!= null)));
                    copy.setIcmParamcalproceso(copyIcmParamcalproceso);
                } else {
                    if (icmParamcalprocesoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalproceso = null;
                    }
                }
            }
            {
                Boolean icmParamcalempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParamcalempleado!= null));
                if (icmParamcalempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalempleadoBlock sourceIcmParamcalempleado;
                    sourceIcmParamcalempleado = this.getIcmParamcalempleado();
                    IcmParamcalempleadoBlock copyIcmParamcalempleado = ((IcmParamcalempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmParamcalempleado", sourceIcmParamcalempleado), sourceIcmParamcalempleado, (this.icmParamcalempleado!= null)));
                    copy.setIcmParamcalempleado(copyIcmParamcalempleado);
                } else {
                    if (icmParamcalempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalempleado = null;
                    }
                }
            }
            {
                Boolean icmParamcalsociedadShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParamcalsociedad!= null));
                if (icmParamcalsociedadShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalsociedadBlock sourceIcmParamcalsociedad;
                    sourceIcmParamcalsociedad = this.getIcmParamcalsociedad();
                    IcmParamcalsociedadBlock copyIcmParamcalsociedad = ((IcmParamcalsociedadBlock) strategy.copy(LocatorUtils.property(locator, "icmParamcalsociedad", sourceIcmParamcalsociedad), sourceIcmParamcalsociedad, (this.icmParamcalsociedad!= null)));
                    copy.setIcmParamcalsociedad(copyIcmParamcalsociedad);
                } else {
                    if (icmParamcalsociedadShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalsociedad = null;
                    }
                }
            }
            {
                Boolean icmParametrosentradaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParametrosentrada!= null));
                if (icmParametrosentradaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosentradaBlock sourceIcmParametrosentrada;
                    sourceIcmParametrosentrada = this.getIcmParametrosentrada();
                    IcmParametrosentradaBlock copyIcmParametrosentrada = ((IcmParametrosentradaBlock) strategy.copy(LocatorUtils.property(locator, "icmParametrosentrada", sourceIcmParametrosentrada), sourceIcmParametrosentrada, (this.icmParametrosentrada!= null)));
                    copy.setIcmParametrosentrada(copyIcmParametrosentrada);
                } else {
                    if (icmParametrosentradaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrosentrada = null;
                    }
                }
            }
            {
                Boolean icmResultadoguardadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmResultadoguardado!= null));
                if (icmResultadoguardadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmResultadoguardadoBlock sourceIcmResultadoguardado;
                    sourceIcmResultadoguardado = this.getIcmResultadoguardado();
                    IcmResultadoguardadoBlock copyIcmResultadoguardado = ((IcmResultadoguardadoBlock) strategy.copy(LocatorUtils.property(locator, "icmResultadoguardado", sourceIcmResultadoguardado), sourceIcmResultadoguardado, (this.icmResultadoguardado!= null)));
                    copy.setIcmResultadoguardado(copyIcmResultadoguardado);
                } else {
                    if (icmResultadoguardadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmResultadoguardado = null;
                    }
                }
            }
            {
                Boolean icmListaconfiguracionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListaconfiguracion!= null));
                if (icmListaconfiguracionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaconfiguracionBlock sourceIcmListaconfiguracion;
                    sourceIcmListaconfiguracion = this.getIcmListaconfiguracion();
                    IcmListaconfiguracionBlock copyIcmListaconfiguracion = ((IcmListaconfiguracionBlock) strategy.copy(LocatorUtils.property(locator, "icmListaconfiguracion", sourceIcmListaconfiguracion), sourceIcmListaconfiguracion, (this.icmListaconfiguracion!= null)));
                    copy.setIcmListaconfiguracion(copyIcmListaconfiguracion);
                } else {
                    if (icmListaconfiguracionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaconfiguracion = null;
                    }
                }
            }
            {
                Boolean icmParamcalestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParamcalestructura!= null));
                if (icmParamcalestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalestructuraBlock sourceIcmParamcalestructura;
                    sourceIcmParamcalestructura = this.getIcmParamcalestructura();
                    IcmParamcalestructuraBlock copyIcmParamcalestructura = ((IcmParamcalestructuraBlock) strategy.copy(LocatorUtils.property(locator, "icmParamcalestructura", sourceIcmParamcalestructura), sourceIcmParamcalestructura, (this.icmParamcalestructura!= null)));
                    copy.setIcmParamcalestructura(copyIcmParamcalestructura);
                } else {
                    if (icmParamcalestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalestructura = null;
                    }
                }
            }
            {
                Boolean icmWsCalcOperacionesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmWsCalcOperaciones!= null));
                if (icmWsCalcOperacionesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmWsCalcOperacionesBlock sourceIcmWsCalcOperaciones;
                    sourceIcmWsCalcOperaciones = this.getIcmWsCalcOperaciones();
                    IcmWsCalcOperacionesBlock copyIcmWsCalcOperaciones = ((IcmWsCalcOperacionesBlock) strategy.copy(LocatorUtils.property(locator, "icmWsCalcOperaciones", sourceIcmWsCalcOperaciones), sourceIcmWsCalcOperaciones, (this.icmWsCalcOperaciones!= null)));
                    copy.setIcmWsCalcOperaciones(copyIcmWsCalcOperaciones);
                } else {
                    if (icmWsCalcOperacionesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmWsCalcOperaciones = null;
                    }
                }
            }
            {
                Boolean icmParametrospaginacionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmParametrospaginacion!= null));
                if (icmParametrospaginacionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospaginacionBlock sourceIcmParametrospaginacion;
                    sourceIcmParametrospaginacion = this.getIcmParametrospaginacion();
                    IcmParametrospaginacionBlock copyIcmParametrospaginacion = ((IcmParametrospaginacionBlock) strategy.copy(LocatorUtils.property(locator, "icmParametrospaginacion", sourceIcmParametrospaginacion), sourceIcmParametrospaginacion, (this.icmParametrospaginacion!= null)));
                    copy.setIcmParametrospaginacion(copyIcmParametrospaginacion);
                } else {
                    if (icmParametrospaginacionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrospaginacion = null;
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
