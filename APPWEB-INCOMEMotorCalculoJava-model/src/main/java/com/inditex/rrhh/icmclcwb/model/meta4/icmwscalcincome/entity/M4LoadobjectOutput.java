
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
 *         &lt;element name="Icm_Listacadenas" type="{http://schemas.meta4.com/}Icm_ListacadenasBlock"/>
 *         &lt;element name="Icm_Listatiendas" type="{http://schemas.meta4.com/}Icm_ListatiendasBlock"/>
 *         &lt;element name="Icm_Listaempresas" type="{http://schemas.meta4.com/}Icm_ListaempresasBlock"/>
 *         &lt;element name="Icm_Listaorigenes" type="{http://schemas.meta4.com/}Icm_ListaorigenesBlock"/>
 *         &lt;element name="Icm_Listaperiodos" type="{http://schemas.meta4.com/}Icm_ListaperiodosBlock"/>
 *         &lt;element name="Icm_Listaempleados" type="{http://schemas.meta4.com/}Icm_ListaempleadosBlock"/>
 *         &lt;element name="Icm_Listavalidacion" type="{http://schemas.meta4.com/}Icm_ListavalidacionBlock"/>
 *         &lt;element name="Icm_Listaestructuras" type="{http://schemas.meta4.com/}Icm_ListaestructurasBlock"/>
 *         &lt;element name="Icm_Parametrosentrada" type="{http://schemas.meta4.com/}Icm_ParametrosentradaBlock"/>
 *         &lt;element name="Icm_Listaconfiguracion" type="{http://schemas.meta4.com/}Icm_ListaconfiguracionBlock"/>
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
    "icmListacadenas",
    "icmListatiendas",
    "icmListaempresas",
    "icmListaorigenes",
    "icmListaperiodos",
    "icmListaempleados",
    "icmListavalidacion",
    "icmListaestructuras",
    "icmParametrosentrada",
    "icmListaconfiguracion",
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
    @XmlElement(name = "Icm_Listacadenas", required = true, nillable = true)
    protected IcmListacadenasBlock icmListacadenas;
    @XmlElement(name = "Icm_Listatiendas", required = true, nillable = true)
    protected IcmListatiendasBlock icmListatiendas;
    @XmlElement(name = "Icm_Listaempresas", required = true, nillable = true)
    protected IcmListaempresasBlock icmListaempresas;
    @XmlElement(name = "Icm_Listaorigenes", required = true, nillable = true)
    protected IcmListaorigenesBlock icmListaorigenes;
    @XmlElement(name = "Icm_Listaperiodos", required = true, nillable = true)
    protected IcmListaperiodosBlock icmListaperiodos;
    @XmlElement(name = "Icm_Listaempleados", required = true, nillable = true)
    protected IcmListaempleadosBlock icmListaempleados;
    @XmlElement(name = "Icm_Listavalidacion", required = true, nillable = true)
    protected IcmListavalidacionBlock icmListavalidacion;
    @XmlElement(name = "Icm_Listaestructuras", required = true, nillable = true)
    protected IcmListaestructurasBlock icmListaestructuras;
    @XmlElement(name = "Icm_Parametrosentrada", required = true, nillable = true)
    protected IcmParametrosentradaBlock icmParametrosentrada;
    @XmlElement(name = "Icm_Listaconfiguracion", required = true, nillable = true)
    protected IcmListaconfiguracionBlock icmListaconfiguracion;
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
     * Obtiene el valor de la propiedad icmListavalidacion.
     * 
     * @return
     *     possible object is
     *     {@link IcmListavalidacionBlock }
     *     
     */
    public IcmListavalidacionBlock getIcmListavalidacion() {
        return icmListavalidacion;
    }

    /**
     * Define el valor de la propiedad icmListavalidacion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListavalidacionBlock }
     *     
     */
    public void setIcmListavalidacion(IcmListavalidacionBlock value) {
        this.icmListavalidacion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmListaestructuras.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaestructurasBlock }
     *     
     */
    public IcmListaestructurasBlock getIcmListaestructuras() {
        return icmListaestructuras;
    }

    /**
     * Define el valor de la propiedad icmListaestructuras.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaestructurasBlock }
     *     
     */
    public void setIcmListaestructuras(IcmListaestructurasBlock value) {
        this.icmListaestructuras = value;
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
            IcmListaempleadosBlock lhsIcmListaempleados;
            lhsIcmListaempleados = this.getIcmListaempleados();
            IcmListaempleadosBlock rhsIcmListaempleados;
            rhsIcmListaempleados = that.getIcmListaempleados();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaempleados", lhsIcmListaempleados), LocatorUtils.property(thatLocator, "icmListaempleados", rhsIcmListaempleados), lhsIcmListaempleados, rhsIcmListaempleados, (this.icmListaempleados!= null), (that.icmListaempleados!= null))) {
                return false;
            }
        }
        {
            IcmListavalidacionBlock lhsIcmListavalidacion;
            lhsIcmListavalidacion = this.getIcmListavalidacion();
            IcmListavalidacionBlock rhsIcmListavalidacion;
            rhsIcmListavalidacion = that.getIcmListavalidacion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListavalidacion", lhsIcmListavalidacion), LocatorUtils.property(thatLocator, "icmListavalidacion", rhsIcmListavalidacion), lhsIcmListavalidacion, rhsIcmListavalidacion, (this.icmListavalidacion!= null), (that.icmListavalidacion!= null))) {
                return false;
            }
        }
        {
            IcmListaestructurasBlock lhsIcmListaestructuras;
            lhsIcmListaestructuras = this.getIcmListaestructuras();
            IcmListaestructurasBlock rhsIcmListaestructuras;
            rhsIcmListaestructuras = that.getIcmListaestructuras();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaestructuras", lhsIcmListaestructuras), LocatorUtils.property(thatLocator, "icmListaestructuras", rhsIcmListaestructuras), lhsIcmListaestructuras, rhsIcmListaestructuras, (this.icmListaestructuras!= null), (that.icmListaestructuras!= null))) {
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
            IcmListaconfiguracionBlock lhsIcmListaconfiguracion;
            lhsIcmListaconfiguracion = this.getIcmListaconfiguracion();
            IcmListaconfiguracionBlock rhsIcmListaconfiguracion;
            rhsIcmListaconfiguracion = that.getIcmListaconfiguracion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconfiguracion", lhsIcmListaconfiguracion), LocatorUtils.property(thatLocator, "icmListaconfiguracion", rhsIcmListaconfiguracion), lhsIcmListaconfiguracion, rhsIcmListaconfiguracion, (this.icmListaconfiguracion!= null), (that.icmListaconfiguracion!= null))) {
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
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
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
            IcmListaempleadosBlock theIcmListaempleados;
            theIcmListaempleados = this.getIcmListaempleados();
            strategy.appendField(locator, this, "icmListaempleados", buffer, theIcmListaempleados, (this.icmListaempleados!= null));
        }
        {
            IcmListavalidacionBlock theIcmListavalidacion;
            theIcmListavalidacion = this.getIcmListavalidacion();
            strategy.appendField(locator, this, "icmListavalidacion", buffer, theIcmListavalidacion, (this.icmListavalidacion!= null));
        }
        {
            IcmListaestructurasBlock theIcmListaestructuras;
            theIcmListaestructuras = this.getIcmListaestructuras();
            strategy.appendField(locator, this, "icmListaestructuras", buffer, theIcmListaestructuras, (this.icmListaestructuras!= null));
        }
        {
            IcmParametrosentradaBlock theIcmParametrosentrada;
            theIcmParametrosentrada = this.getIcmParametrosentrada();
            strategy.appendField(locator, this, "icmParametrosentrada", buffer, theIcmParametrosentrada, (this.icmParametrosentrada!= null));
        }
        {
            IcmListaconfiguracionBlock theIcmListaconfiguracion;
            theIcmListaconfiguracion = this.getIcmListaconfiguracion();
            strategy.appendField(locator, this, "icmListaconfiguracion", buffer, theIcmListaconfiguracion, (this.icmListaconfiguracion!= null));
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
            IcmListaempleadosBlock theIcmListaempleados;
            theIcmListaempleados = this.getIcmListaempleados();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaempleados", theIcmListaempleados), currentHashCode, theIcmListaempleados, (this.icmListaempleados!= null));
        }
        {
            IcmListavalidacionBlock theIcmListavalidacion;
            theIcmListavalidacion = this.getIcmListavalidacion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListavalidacion", theIcmListavalidacion), currentHashCode, theIcmListavalidacion, (this.icmListavalidacion!= null));
        }
        {
            IcmListaestructurasBlock theIcmListaestructuras;
            theIcmListaestructuras = this.getIcmListaestructuras();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaestructuras", theIcmListaestructuras), currentHashCode, theIcmListaestructuras, (this.icmListaestructuras!= null));
        }
        {
            IcmParametrosentradaBlock theIcmParametrosentrada;
            theIcmParametrosentrada = this.getIcmParametrosentrada();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrosentrada", theIcmParametrosentrada), currentHashCode, theIcmParametrosentrada, (this.icmParametrosentrada!= null));
        }
        {
            IcmListaconfiguracionBlock theIcmListaconfiguracion;
            theIcmListaconfiguracion = this.getIcmListaconfiguracion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaconfiguracion", theIcmListaconfiguracion), currentHashCode, theIcmListaconfiguracion, (this.icmListaconfiguracion!= null));
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
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE;
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
                Boolean icmListavalidacionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListavalidacion!= null));
                if (icmListavalidacionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListavalidacionBlock sourceIcmListavalidacion;
                    sourceIcmListavalidacion = this.getIcmListavalidacion();
                    IcmListavalidacionBlock copyIcmListavalidacion = ((IcmListavalidacionBlock) strategy.copy(LocatorUtils.property(locator, "icmListavalidacion", sourceIcmListavalidacion), sourceIcmListavalidacion, (this.icmListavalidacion!= null)));
                    copy.setIcmListavalidacion(copyIcmListavalidacion);
                } else {
                    if (icmListavalidacionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListavalidacion = null;
                    }
                }
            }
            {
                Boolean icmListaestructurasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListaestructuras!= null));
                if (icmListaestructurasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaestructurasBlock sourceIcmListaestructuras;
                    sourceIcmListaestructuras = this.getIcmListaestructuras();
                    IcmListaestructurasBlock copyIcmListaestructuras = ((IcmListaestructurasBlock) strategy.copy(LocatorUtils.property(locator, "icmListaestructuras", sourceIcmListaestructuras), sourceIcmListaestructuras, (this.icmListaestructuras!= null)));
                    copy.setIcmListaestructuras(copyIcmListaestructuras);
                } else {
                    if (icmListaestructurasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaestructuras = null;
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
