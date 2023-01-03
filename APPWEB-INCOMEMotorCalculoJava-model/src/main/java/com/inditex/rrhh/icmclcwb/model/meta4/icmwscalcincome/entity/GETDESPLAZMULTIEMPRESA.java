
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
 *         &lt;element name="ICM_PARAMCALMULTIEMPRESA" type="{http://schemas.meta4.com/}Icm_ParamcalmultiempresaBlock"/&gt;
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
    "icmparamcalmultiempresa"
})
@XmlRootElement(name = "GETDESPLAZMULTIEMPRESA")
public class GETDESPLAZMULTIEMPRESA implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ICM_PARAMCALMULTIEMPRESA", required = true)
    protected IcmParamcalmultiempresaBlock icmparamcalmultiempresa;

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETDESPLAZMULTIEMPRESA that = ((GETDESPLAZMULTIEMPRESA) object);
        {
            IcmParamcalmultiempresaBlock lhsICMPARAMCALMULTIEMPRESA;
            lhsICMPARAMCALMULTIEMPRESA = this.getICMPARAMCALMULTIEMPRESA();
            IcmParamcalmultiempresaBlock rhsICMPARAMCALMULTIEMPRESA;
            rhsICMPARAMCALMULTIEMPRESA = that.getICMPARAMCALMULTIEMPRESA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparamcalmultiempresa", lhsICMPARAMCALMULTIEMPRESA), LocatorUtils.property(thatLocator, "icmparamcalmultiempresa", rhsICMPARAMCALMULTIEMPRESA), lhsICMPARAMCALMULTIEMPRESA, rhsICMPARAMCALMULTIEMPRESA, (this.icmparamcalmultiempresa!= null), (that.icmparamcalmultiempresa!= null))) {
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
            IcmParamcalmultiempresaBlock theICMPARAMCALMULTIEMPRESA;
            theICMPARAMCALMULTIEMPRESA = this.getICMPARAMCALMULTIEMPRESA();
            strategy.appendField(locator, this, "icmparamcalmultiempresa", buffer, theICMPARAMCALMULTIEMPRESA, (this.icmparamcalmultiempresa!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            IcmParamcalmultiempresaBlock theICMPARAMCALMULTIEMPRESA;
            theICMPARAMCALMULTIEMPRESA = this.getICMPARAMCALMULTIEMPRESA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparamcalmultiempresa", theICMPARAMCALMULTIEMPRESA), currentHashCode, theICMPARAMCALMULTIEMPRESA, (this.icmparamcalmultiempresa!= null));
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
        if (draftCopy instanceof GETDESPLAZMULTIEMPRESA) {
            final GETDESPLAZMULTIEMPRESA copy = ((GETDESPLAZMULTIEMPRESA) draftCopy);
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
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETDESPLAZMULTIEMPRESA();
    }

}
