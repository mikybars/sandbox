
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
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ICM_PARAMCALVENTACONGELADA" type="{http://schemas.meta4.com/}Icm_ParamcalventacongeladaBlock"/&gt;
 *         &lt;element name="ICM_PARAMETROSPAGINACION" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
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
    "icmparamcalventacongelada",
    "icmparametrospaginacion"
})
@XmlRootElement(name = "GETVENTACONGELADA")
public class GETVENTACONGELADA implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ICM_PARAMCALVENTACONGELADA", required = true)
    protected IcmParamcalventacongeladaBlock icmparamcalventacongelada;
    @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
    protected IcmParametrospaginacionBlock icmparametrospaginacion;

    /**
     * Gets the value of the icmparamcalventacongelada property.
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
     * Sets the value of the icmparamcalventacongelada property.
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
     * Gets the value of the icmparametrospaginacion property.
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
     * Sets the value of the icmparametrospaginacion property.
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
        final GETVENTACONGELADA that = ((GETVENTACONGELADA) object);
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
            IcmParamcalventacongeladaBlock theICMPARAMCALVENTACONGELADA;
            theICMPARAMCALVENTACONGELADA = this.getICMPARAMCALVENTACONGELADA();
            strategy.appendField(locator, this, "icmparamcalventacongelada", buffer, theICMPARAMCALVENTACONGELADA, (this.icmparamcalventacongelada!= null));
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
            IcmParamcalventacongeladaBlock theICMPARAMCALVENTACONGELADA;
            theICMPARAMCALVENTACONGELADA = this.getICMPARAMCALVENTACONGELADA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalventacongelada", theICMPARAMCALVENTACONGELADA), currentHashCode, theICMPARAMCALVENTACONGELADA, (this.icmparamcalventacongelada!= null));
        }
        {
            IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrospaginacion", theICMPARAMETROSPAGINACION), currentHashCode, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null));
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
        if (draftCopy instanceof GETVENTACONGELADA) {
            final GETVENTACONGELADA copy = ((GETVENTACONGELADA) draftCopy);
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
        return new GETVENTACONGELADA();
    }

}
