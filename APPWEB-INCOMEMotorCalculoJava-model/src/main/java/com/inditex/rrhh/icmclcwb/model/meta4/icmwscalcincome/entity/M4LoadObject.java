
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ICM_WS_TOOLS" type="{http://schemas.meta4.com/}Icm_Ws_ToolsBlock"/>
 *         &lt;element name="ICM_LISTACADENAS" type="{http://schemas.meta4.com/}Icm_ListacadenasBlock"/>
 *         &lt;element name="ICM_LISTATIENDAS" type="{http://schemas.meta4.com/}Icm_ListatiendasBlock"/>
 *         &lt;element name="ICM_LISTAPERIODOS" type="{http://schemas.meta4.com/}Icm_ListaperiodosBlock"/>
 *         &lt;element name="ICM_LISTAEMPLEADOS" type="{http://schemas.meta4.com/}Icm_ListaempleadosBlock"/>
 *         &lt;element name="ICM_LISTAESTRUCTURAS" type="{http://schemas.meta4.com/}Icm_ListaestructurasBlock"/>
 *         &lt;element name="ICM_PARAMETROSENTRADA" type="{http://schemas.meta4.com/}Icm_ParametrosentradaBlock"/>
 *         &lt;element name="ICM_LISTACONFIGURACION" type="{http://schemas.meta4.com/}Icm_ListaconfiguracionBlock"/>
 *         &lt;element name="ICM_WS_CALC_OPERACIONES" type="{http://schemas.meta4.com/}Icm_Ws_Calc_OperacionesBlock"/>
 *         &lt;element name="ICM_PARAMETROSPAGINACION" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "icmwstools",
    "icmlistacadenas",
    "icmlistatiendas",
    "icmlistaperiodos",
    "icmlistaempleados",
    "icmlistaestructuras",
    "icmparametrosentrada",
    "icmlistaconfiguracion",
    "icmwscalcoperaciones",
    "icmparametrospaginacion"
})
@XmlRootElement(name = "M4LoadObject")
public class M4LoadObject implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ICM_WS_TOOLS", required = true)
    protected IcmWsToolsBlock icmwstools;
    @XmlElement(name = "ICM_LISTACADENAS", required = true)
    protected IcmListacadenasBlock icmlistacadenas;
    @XmlElement(name = "ICM_LISTATIENDAS", required = true)
    protected IcmListatiendasBlock icmlistatiendas;
    @XmlElement(name = "ICM_LISTAPERIODOS", required = true)
    protected IcmListaperiodosBlock icmlistaperiodos;
    @XmlElement(name = "ICM_LISTAEMPLEADOS", required = true)
    protected IcmListaempleadosBlock icmlistaempleados;
    @XmlElement(name = "ICM_LISTAESTRUCTURAS", required = true)
    protected IcmListaestructurasBlock icmlistaestructuras;
    @XmlElement(name = "ICM_PARAMETROSENTRADA", required = true)
    protected IcmParametrosentradaBlock icmparametrosentrada;
    @XmlElement(name = "ICM_LISTACONFIGURACION", required = true)
    protected IcmListaconfiguracionBlock icmlistaconfiguracion;
    @XmlElement(name = "ICM_WS_CALC_OPERACIONES", required = true)
    protected IcmWsCalcOperacionesBlock icmwscalcoperaciones;
    @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
    protected IcmParametrospaginacionBlock icmparametrospaginacion;

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
     * Obtiene el valor de la propiedad icmlistaestructuras.
     * 
     * @return
     *     possible object is
     *     {@link IcmListaestructurasBlock }
     *     
     */
    public IcmListaestructurasBlock getICMLISTAESTRUCTURAS() {
        return icmlistaestructuras;
    }

    /**
     * Define el valor de la propiedad icmlistaestructuras.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmListaestructurasBlock }
     *     
     */
    public void setICMLISTAESTRUCTURAS(IcmListaestructurasBlock value) {
        this.icmlistaestructuras = value;
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
            IcmListacadenasBlock lhsICMLISTACADENAS;
            lhsICMLISTACADENAS = this.getICMLISTACADENAS();
            IcmListacadenasBlock rhsICMLISTACADENAS;
            rhsICMLISTACADENAS = that.getICMLISTACADENAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistacadenas", lhsICMLISTACADENAS), LocatorUtils.property(thatLocator, "icmlistacadenas", rhsICMLISTACADENAS), lhsICMLISTACADENAS, rhsICMLISTACADENAS, (this.icmlistacadenas!= null), (that.icmlistacadenas!= null))) {
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
            IcmListaperiodosBlock lhsICMLISTAPERIODOS;
            lhsICMLISTAPERIODOS = this.getICMLISTAPERIODOS();
            IcmListaperiodosBlock rhsICMLISTAPERIODOS;
            rhsICMLISTAPERIODOS = that.getICMLISTAPERIODOS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaperiodos", lhsICMLISTAPERIODOS), LocatorUtils.property(thatLocator, "icmlistaperiodos", rhsICMLISTAPERIODOS), lhsICMLISTAPERIODOS, rhsICMLISTAPERIODOS, (this.icmlistaperiodos!= null), (that.icmlistaperiodos!= null))) {
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
            IcmListaestructurasBlock lhsICMLISTAESTRUCTURAS;
            lhsICMLISTAESTRUCTURAS = this.getICMLISTAESTRUCTURAS();
            IcmListaestructurasBlock rhsICMLISTAESTRUCTURAS;
            rhsICMLISTAESTRUCTURAS = that.getICMLISTAESTRUCTURAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaestructuras", lhsICMLISTAESTRUCTURAS), LocatorUtils.property(thatLocator, "icmlistaestructuras", rhsICMLISTAESTRUCTURAS), lhsICMLISTAESTRUCTURAS, rhsICMLISTAESTRUCTURAS, (this.icmlistaestructuras!= null), (that.icmlistaestructuras!= null))) {
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
            IcmListaconfiguracionBlock lhsICMLISTACONFIGURACION;
            lhsICMLISTACONFIGURACION = this.getICMLISTACONFIGURACION();
            IcmListaconfiguracionBlock rhsICMLISTACONFIGURACION;
            rhsICMLISTACONFIGURACION = that.getICMLISTACONFIGURACION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistaconfiguracion", lhsICMLISTACONFIGURACION), LocatorUtils.property(thatLocator, "icmlistaconfiguracion", rhsICMLISTACONFIGURACION), lhsICMLISTACONFIGURACION, rhsICMLISTACONFIGURACION, (this.icmlistaconfiguracion!= null), (that.icmlistaconfiguracion!= null))) {
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
            IcmParametrospaginacionBlock lhsICMPARAMETROSPAGINACION;
            lhsICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            IcmParametrospaginacionBlock rhsICMPARAMETROSPAGINACION;
            rhsICMPARAMETROSPAGINACION = that.getICMPARAMETROSPAGINACION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrospaginacion", lhsICMPARAMETROSPAGINACION), LocatorUtils.property(thatLocator, "icmparametrospaginacion", rhsICMPARAMETROSPAGINACION), lhsICMPARAMETROSPAGINACION, rhsICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null), (that.icmparametrospaginacion!= null))) {
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
            IcmWsToolsBlock theICMWSTOOLS;
            theICMWSTOOLS = this.getICMWSTOOLS();
            strategy.appendField(locator, this, "icmwstools", buffer, theICMWSTOOLS, (this.icmwstools!= null));
        }
        {
            IcmListacadenasBlock theICMLISTACADENAS;
            theICMLISTACADENAS = this.getICMLISTACADENAS();
            strategy.appendField(locator, this, "icmlistacadenas", buffer, theICMLISTACADENAS, (this.icmlistacadenas!= null));
        }
        {
            IcmListatiendasBlock theICMLISTATIENDAS;
            theICMLISTATIENDAS = this.getICMLISTATIENDAS();
            strategy.appendField(locator, this, "icmlistatiendas", buffer, theICMLISTATIENDAS, (this.icmlistatiendas!= null));
        }
        {
            IcmListaperiodosBlock theICMLISTAPERIODOS;
            theICMLISTAPERIODOS = this.getICMLISTAPERIODOS();
            strategy.appendField(locator, this, "icmlistaperiodos", buffer, theICMLISTAPERIODOS, (this.icmlistaperiodos!= null));
        }
        {
            IcmListaempleadosBlock theICMLISTAEMPLEADOS;
            theICMLISTAEMPLEADOS = this.getICMLISTAEMPLEADOS();
            strategy.appendField(locator, this, "icmlistaempleados", buffer, theICMLISTAEMPLEADOS, (this.icmlistaempleados!= null));
        }
        {
            IcmListaestructurasBlock theICMLISTAESTRUCTURAS;
            theICMLISTAESTRUCTURAS = this.getICMLISTAESTRUCTURAS();
            strategy.appendField(locator, this, "icmlistaestructuras", buffer, theICMLISTAESTRUCTURAS, (this.icmlistaestructuras!= null));
        }
        {
            IcmParametrosentradaBlock theICMPARAMETROSENTRADA;
            theICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            strategy.appendField(locator, this, "icmparametrosentrada", buffer, theICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null));
        }
        {
            IcmListaconfiguracionBlock theICMLISTACONFIGURACION;
            theICMLISTACONFIGURACION = this.getICMLISTACONFIGURACION();
            strategy.appendField(locator, this, "icmlistaconfiguracion", buffer, theICMLISTACONFIGURACION, (this.icmlistaconfiguracion!= null));
        }
        {
            IcmWsCalcOperacionesBlock theICMWSCALCOPERACIONES;
            theICMWSCALCOPERACIONES = this.getICMWSCALCOPERACIONES();
            strategy.appendField(locator, this, "icmwscalcoperaciones", buffer, theICMWSCALCOPERACIONES, (this.icmwscalcoperaciones!= null));
        }
        {
            IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            strategy.appendField(locator, this, "icmparametrospaginacion", buffer, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null));
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
            IcmListacadenasBlock theICMLISTACADENAS;
            theICMLISTACADENAS = this.getICMLISTACADENAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistacadenas", theICMLISTACADENAS), currentHashCode, theICMLISTACADENAS, (this.icmlistacadenas!= null));
        }
        {
            IcmListatiendasBlock theICMLISTATIENDAS;
            theICMLISTATIENDAS = this.getICMLISTATIENDAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistatiendas", theICMLISTATIENDAS), currentHashCode, theICMLISTATIENDAS, (this.icmlistatiendas!= null));
        }
        {
            IcmListaperiodosBlock theICMLISTAPERIODOS;
            theICMLISTAPERIODOS = this.getICMLISTAPERIODOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaperiodos", theICMLISTAPERIODOS), currentHashCode, theICMLISTAPERIODOS, (this.icmlistaperiodos!= null));
        }
        {
            IcmListaempleadosBlock theICMLISTAEMPLEADOS;
            theICMLISTAEMPLEADOS = this.getICMLISTAEMPLEADOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaempleados", theICMLISTAEMPLEADOS), currentHashCode, theICMLISTAEMPLEADOS, (this.icmlistaempleados!= null));
        }
        {
            IcmListaestructurasBlock theICMLISTAESTRUCTURAS;
            theICMLISTAESTRUCTURAS = this.getICMLISTAESTRUCTURAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaestructuras", theICMLISTAESTRUCTURAS), currentHashCode, theICMLISTAESTRUCTURAS, (this.icmlistaestructuras!= null));
        }
        {
            IcmParametrosentradaBlock theICMPARAMETROSENTRADA;
            theICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrosentrada", theICMPARAMETROSENTRADA), currentHashCode, theICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null));
        }
        {
            IcmListaconfiguracionBlock theICMLISTACONFIGURACION;
            theICMLISTACONFIGURACION = this.getICMLISTACONFIGURACION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaconfiguracion", theICMLISTACONFIGURACION), currentHashCode, theICMLISTACONFIGURACION, (this.icmlistaconfiguracion!= null));
        }
        {
            IcmWsCalcOperacionesBlock theICMWSCALCOPERACIONES;
            theICMWSCALCOPERACIONES = this.getICMWSCALCOPERACIONES();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmwscalcoperaciones", theICMWSCALCOPERACIONES), currentHashCode, theICMWSCALCOPERACIONES, (this.icmwscalcoperaciones!= null));
        }
        {
            IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrospaginacion", theICMPARAMETROSPAGINACION), currentHashCode, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null));
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
                Boolean icmlistaestructurasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmlistaestructuras!= null));
                if (icmlistaestructurasShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListaestructurasBlock sourceICMLISTAESTRUCTURAS;
                    sourceICMLISTAESTRUCTURAS = this.getICMLISTAESTRUCTURAS();
                    IcmListaestructurasBlock copyICMLISTAESTRUCTURAS = ((IcmListaestructurasBlock) strategy.copy(LocatorUtils.property(locator, "icmlistaestructuras", sourceICMLISTAESTRUCTURAS), sourceICMLISTAESTRUCTURAS, (this.icmlistaestructuras!= null)));
                    copy.setICMLISTAESTRUCTURAS(copyICMLISTAESTRUCTURAS);
                } else {
                    if (icmlistaestructurasShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmlistaestructuras = null;
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
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new M4LoadObject();
    }

}
