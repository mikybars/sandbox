
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

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
 *         &lt;element name="ICM_PARAMETROSPAISCADENA" type="{http://schemas.meta4.com/}Icm_ParametrospaiscadenaBlock"/>
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
    "icmparametrospaiscadena",
    "icmparametrospaginacion"
})
@XmlRootElement(name = "GETCONDICIONESVENTA")
public class GETCONDICIONESVENTA implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ICM_PARAMETROSPAISCADENA", required = true)
    protected IcmParametrospaiscadenaBlock icmparametrospaiscadena;
    @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
    protected IcmParametrospaginacionBlock icmparametrospaginacion;

    /**
     * Obtiene el valor de la propiedad icmparametrospaiscadena.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaiscadenaBlock }
     *     
     */
    public IcmParametrospaiscadenaBlock getICMPARAMETROSPAISCADENA() {
        return icmparametrospaiscadena;
    }

    /**
     * Define el valor de la propiedad icmparametrospaiscadena.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaiscadenaBlock }
     *     
     */
    public void setICMPARAMETROSPAISCADENA(IcmParametrospaiscadenaBlock value) {
        this.icmparametrospaiscadena = value;
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
        final GETCONDICIONESVENTA that = ((GETCONDICIONESVENTA) object);
        {
            IcmParametrospaiscadenaBlock lhsICMPARAMETROSPAISCADENA;
            lhsICMPARAMETROSPAISCADENA = this.getICMPARAMETROSPAISCADENA();
            IcmParametrospaiscadenaBlock rhsICMPARAMETROSPAISCADENA;
            rhsICMPARAMETROSPAISCADENA = that.getICMPARAMETROSPAISCADENA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrospaiscadena", lhsICMPARAMETROSPAISCADENA), LocatorUtils.property(thatLocator, "icmparametrospaiscadena", rhsICMPARAMETROSPAISCADENA), lhsICMPARAMETROSPAISCADENA, rhsICMPARAMETROSPAISCADENA, (this.icmparametrospaiscadena!= null), (that.icmparametrospaiscadena!= null))) {
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
            IcmParametrospaiscadenaBlock theICMPARAMETROSPAISCADENA;
            theICMPARAMETROSPAISCADENA = this.getICMPARAMETROSPAISCADENA();
            strategy.appendField(locator, this, "icmparametrospaiscadena", buffer, theICMPARAMETROSPAISCADENA, (this.icmparametrospaiscadena!= null));
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
            IcmParametrospaiscadenaBlock theICMPARAMETROSPAISCADENA;
            theICMPARAMETROSPAISCADENA = this.getICMPARAMETROSPAISCADENA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrospaiscadena", theICMPARAMETROSPAISCADENA), currentHashCode, theICMPARAMETROSPAISCADENA, (this.icmparametrospaiscadena!= null));
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
        if (draftCopy instanceof GETCONDICIONESVENTA) {
            final GETCONDICIONESVENTA copy = ((GETCONDICIONESVENTA) draftCopy);
            {
                Boolean icmparametrospaiscadenaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrospaiscadena!= null));
                if (icmparametrospaiscadenaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospaiscadenaBlock sourceICMPARAMETROSPAISCADENA;
                    sourceICMPARAMETROSPAISCADENA = this.getICMPARAMETROSPAISCADENA();
                    IcmParametrospaiscadenaBlock copyICMPARAMETROSPAISCADENA = ((IcmParametrospaiscadenaBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrospaiscadena", sourceICMPARAMETROSPAISCADENA), sourceICMPARAMETROSPAISCADENA, (this.icmparametrospaiscadena!= null)));
                    copy.setICMPARAMETROSPAISCADENA(copyICMPARAMETROSPAISCADENA);
                } else {
                    if (icmparametrospaiscadenaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrospaiscadena = null;
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
        return new GETCONDICIONESVENTA();
    }

}
