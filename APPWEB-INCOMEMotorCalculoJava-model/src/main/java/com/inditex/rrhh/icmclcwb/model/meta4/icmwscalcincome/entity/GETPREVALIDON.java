
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
 * <p>
 * Clase Java para anonymous complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ICM_PARAMCALVALON" type="{http://schemas.meta4.com/}Icm_ParamcalvalonBlock"/&gt;
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
        "icmparamcalvalon"
})
@XmlRootElement(name = "GETPREVALIDON")
public class GETPREVALIDON implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

    private final static long serialVersionUID = 1L;

    @XmlElement(name = "ICM_PARAMCALVALON", required = true)
    protected IcmParamcalvalonBlock icmparamcalvalon;

    /**
     * Obtiene el valor de la propiedad icmparamcalvalon.
     * @return possible object is {@link IcmParamcalvalonBlock }
     *
     */
    public IcmParamcalvalonBlock getICMPARAMCALVALON() {
        return icmparamcalvalon;
    }

    /**
     * Define el valor de la propiedad icmparamcalvalon.
     * @param value allowed object is {@link IcmParamcalvalonBlock }
     *
     */
    public void setICMPARAMCALVALON(IcmParamcalvalonBlock value) {
        this.icmparamcalvalon = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object,
            EqualsStrategy2 strategy) {
        if ((object == null) || (this.getClass() != object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETPREVALIDON that = ((GETPREVALIDON) object);
        {
            IcmParamcalvalonBlock lhsICMPARAMCALVALON;
            lhsICMPARAMCALVALON = this.getICMPARAMCALVALON();
            IcmParamcalvalonBlock rhsICMPARAMCALVALON;
            rhsICMPARAMCALVALON = that.getICMPARAMCALVALON();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalvalon", lhsICMPARAMCALVALON),
                    LocatorUtils.property(thatLocator, "icmparamcalvalon", rhsICMPARAMCALVALON), lhsICMPARAMCALVALON,
                    rhsICMPARAMCALVALON, (this.icmparamcalvalon != null), (that.icmparamcalvalon != null))) {
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
            IcmParamcalvalonBlock theICMPARAMCALVALON;
            theICMPARAMCALVALON = this.getICMPARAMCALVALON();
            strategy.appendField(locator, this, "icmparamcalvalon", buffer, theICMPARAMCALVALON,
                    (this.icmparamcalvalon != null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            IcmParamcalvalonBlock theICMPARAMCALVALON;
            theICMPARAMCALVALON = this.getICMPARAMCALVALON();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalvalon", theICMPARAMCALVALON),
                    currentHashCode, theICMPARAMCALVALON, (this.icmparamcalvalon != null));
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
        if (draftCopy instanceof GETPREVALIDON) {
            final GETPREVALIDON copy = ((GETPREVALIDON) draftCopy);
            {
                Boolean icmparamcalvalonShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmparamcalvalon != null));
                if (icmparamcalvalonShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParamcalvalonBlock sourceICMPARAMCALVALON;
                    sourceICMPARAMCALVALON = this.getICMPARAMCALVALON();
                    IcmParamcalvalonBlock copyICMPARAMCALVALON = ((IcmParamcalvalonBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmparamcalvalon", sourceICMPARAMCALVALON),
                            sourceICMPARAMCALVALON, (this.icmparamcalvalon != null)));
                    copy.setICMPARAMCALVALON(copyICMPARAMCALVALON);
                } else {
                    if (icmparamcalvalonShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparamcalvalon = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETPREVALIDON();
    }

}
