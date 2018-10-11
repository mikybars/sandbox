
package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity;

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
 *         &lt;element name="ICM_PARAMETROSPLANTILLA" type="{http://schemas.meta4.com/}Icm_ParametrosplantillaBlock"/>
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
    "icmparametrosplantilla",
    "icmparametrospaginacion"
})
@XmlRootElement(name = "GETVALORESCONDICIONES")
public class GETVALORESCONDICIONES implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ICM_PARAMETROSPLANTILLA", required = true)
    protected IcmParametrosplantillaBlock icmparametrosplantilla;
    @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
    protected IcmParametrospaginacionBlock icmparametrospaginacion;

    /**
     * Obtiene el valor de la propiedad icmparametrosplantilla.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosplantillaBlock }
     *     
     */
    public IcmParametrosplantillaBlock getICMPARAMETROSPLANTILLA() {
        return icmparametrosplantilla;
    }

    /**
     * Define el valor de la propiedad icmparametrosplantilla.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosplantillaBlock }
     *     
     */
    public void setICMPARAMETROSPLANTILLA(IcmParametrosplantillaBlock value) {
        this.icmparametrosplantilla = value;
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
        final GETVALORESCONDICIONES that = ((GETVALORESCONDICIONES) object);
        {
            IcmParametrosplantillaBlock lhsICMPARAMETROSPLANTILLA;
            lhsICMPARAMETROSPLANTILLA = this.getICMPARAMETROSPLANTILLA();
            IcmParametrosplantillaBlock rhsICMPARAMETROSPLANTILLA;
            rhsICMPARAMETROSPLANTILLA = that.getICMPARAMETROSPLANTILLA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrosplantilla", lhsICMPARAMETROSPLANTILLA), LocatorUtils.property(thatLocator, "icmparametrosplantilla", rhsICMPARAMETROSPLANTILLA), lhsICMPARAMETROSPLANTILLA, rhsICMPARAMETROSPLANTILLA, (this.icmparametrosplantilla!= null), (that.icmparametrosplantilla!= null))) {
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
            IcmParametrosplantillaBlock theICMPARAMETROSPLANTILLA;
            theICMPARAMETROSPLANTILLA = this.getICMPARAMETROSPLANTILLA();
            strategy.appendField(locator, this, "icmparametrosplantilla", buffer, theICMPARAMETROSPLANTILLA, (this.icmparametrosplantilla!= null));
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
            IcmParametrosplantillaBlock theICMPARAMETROSPLANTILLA;
            theICMPARAMETROSPLANTILLA = this.getICMPARAMETROSPLANTILLA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrosplantilla", theICMPARAMETROSPLANTILLA), currentHashCode, theICMPARAMETROSPLANTILLA, (this.icmparametrosplantilla!= null));
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
        if (draftCopy instanceof GETVALORESCONDICIONES) {
            final GETVALORESCONDICIONES copy = ((GETVALORESCONDICIONES) draftCopy);
            {
                Boolean icmparametrosplantillaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrosplantilla!= null));
                if (icmparametrosplantillaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosplantillaBlock sourceICMPARAMETROSPLANTILLA;
                    sourceICMPARAMETROSPLANTILLA = this.getICMPARAMETROSPLANTILLA();
                    IcmParametrosplantillaBlock copyICMPARAMETROSPLANTILLA = ((IcmParametrosplantillaBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrosplantilla", sourceICMPARAMETROSPLANTILLA), sourceICMPARAMETROSPLANTILLA, (this.icmparametrosplantilla!= null)));
                    copy.setICMPARAMETROSPLANTILLA(copyICMPARAMETROSPLANTILLA);
                } else {
                    if (icmparametrosplantillaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrosplantilla = null;
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
        return new GETVALORESCONDICIONES();
    }

}
