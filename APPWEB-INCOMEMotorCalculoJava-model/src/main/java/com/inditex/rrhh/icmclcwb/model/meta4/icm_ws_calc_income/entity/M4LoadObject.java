
package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_calc_income.entity;

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
 *         &lt;element name="ICM_LISTATIENDAS" type="{http://schemas.meta4.com/}Icm_ListatiendasBlock"/>
 *         &lt;element name="ICM_LISTAEMPLEADOS" type="{http://schemas.meta4.com/}Icm_ListaempleadosBlock"/>
 *         &lt;element name="ICM_PARAMETROSENTRADA" type="{http://schemas.meta4.com/}Icm_ParametrosentradaBlock"/>
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
    "icmlistatiendas",
    "icmlistaempleados",
    "icmparametrosentrada",
    "icmwscalcoperaciones",
    "icmparametrospaginacion"
})
@XmlRootElement(name = "M4LoadObject")
public class M4LoadObject implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ICM_WS_TOOLS", required = true)
    protected IcmWsToolsBlock icmwstools;
    @XmlElement(name = "ICM_LISTATIENDAS", required = true)
    protected IcmListatiendasBlock icmlistatiendas;
    @XmlElement(name = "ICM_LISTAEMPLEADOS", required = true)
    protected IcmListaempleadosBlock icmlistaempleados;
    @XmlElement(name = "ICM_PARAMETROSENTRADA", required = true)
    protected IcmParametrosentradaBlock icmparametrosentrada;
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
            IcmListatiendasBlock lhsICMLISTATIENDAS;
            lhsICMLISTATIENDAS = this.getICMLISTATIENDAS();
            IcmListatiendasBlock rhsICMLISTATIENDAS;
            rhsICMLISTATIENDAS = that.getICMLISTATIENDAS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmlistatiendas", lhsICMLISTATIENDAS), LocatorUtils.property(thatLocator, "icmlistatiendas", rhsICMLISTATIENDAS), lhsICMLISTATIENDAS, rhsICMLISTATIENDAS, (this.icmlistatiendas!= null), (that.icmlistatiendas!= null))) {
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
            IcmParametrosentradaBlock lhsICMPARAMETROSENTRADA;
            lhsICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            IcmParametrosentradaBlock rhsICMPARAMETROSENTRADA;
            rhsICMPARAMETROSENTRADA = that.getICMPARAMETROSENTRADA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrosentrada", lhsICMPARAMETROSENTRADA), LocatorUtils.property(thatLocator, "icmparametrosentrada", rhsICMPARAMETROSENTRADA), lhsICMPARAMETROSENTRADA, rhsICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null), (that.icmparametrosentrada!= null))) {
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
            IcmListatiendasBlock theICMLISTATIENDAS;
            theICMLISTATIENDAS = this.getICMLISTATIENDAS();
            strategy.appendField(locator, this, "icmlistatiendas", buffer, theICMLISTATIENDAS, (this.icmlistatiendas!= null));
        }
        {
            IcmListaempleadosBlock theICMLISTAEMPLEADOS;
            theICMLISTAEMPLEADOS = this.getICMLISTAEMPLEADOS();
            strategy.appendField(locator, this, "icmlistaempleados", buffer, theICMLISTAEMPLEADOS, (this.icmlistaempleados!= null));
        }
        {
            IcmParametrosentradaBlock theICMPARAMETROSENTRADA;
            theICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            strategy.appendField(locator, this, "icmparametrosentrada", buffer, theICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null));
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
            IcmListatiendasBlock theICMLISTATIENDAS;
            theICMLISTATIENDAS = this.getICMLISTATIENDAS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistatiendas", theICMLISTATIENDAS), currentHashCode, theICMLISTATIENDAS, (this.icmlistatiendas!= null));
        }
        {
            IcmListaempleadosBlock theICMLISTAEMPLEADOS;
            theICMLISTAEMPLEADOS = this.getICMLISTAEMPLEADOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmlistaempleados", theICMLISTAEMPLEADOS), currentHashCode, theICMLISTAEMPLEADOS, (this.icmlistaempleados!= null));
        }
        {
            IcmParametrosentradaBlock theICMPARAMETROSENTRADA;
            theICMPARAMETROSENTRADA = this.getICMPARAMETROSENTRADA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrosentrada", theICMPARAMETROSENTRADA), currentHashCode, theICMPARAMETROSENTRADA, (this.icmparametrosentrada!= null));
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
