
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
 *         &lt;element name="ICM_PRESUPUESTOS" type="{http://schemas.meta4.com/}Icm_PresupuestosBlock"/>
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
    "icmpresupuestos"
})
@XmlRootElement(name = "SAVEPRESUPUESTOS")
public class SAVEPRESUPUESTOS implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ICM_PRESUPUESTOS", required = true)
    protected IcmPresupuestosBlock icmpresupuestos;

    /**
     * Obtiene el valor de la propiedad icmpresupuestos.
     * 
     * @return
     *     possible object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public IcmPresupuestosBlock getICMPRESUPUESTOS() {
        return icmpresupuestos;
    }

    /**
     * Define el valor de la propiedad icmpresupuestos.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public void setICMPRESUPUESTOS(IcmPresupuestosBlock value) {
        this.icmpresupuestos = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SAVEPRESUPUESTOS that = ((SAVEPRESUPUESTOS) object);
        {
            IcmPresupuestosBlock lhsICMPRESUPUESTOS;
            lhsICMPRESUPUESTOS = this.getICMPRESUPUESTOS();
            IcmPresupuestosBlock rhsICMPRESUPUESTOS;
            rhsICMPRESUPUESTOS = that.getICMPRESUPUESTOS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmpresupuestos", lhsICMPRESUPUESTOS), LocatorUtils.property(thatLocator, "icmpresupuestos", rhsICMPRESUPUESTOS), lhsICMPRESUPUESTOS, rhsICMPRESUPUESTOS, (this.icmpresupuestos!= null), (that.icmpresupuestos!= null))) {
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
            IcmPresupuestosBlock theICMPRESUPUESTOS;
            theICMPRESUPUESTOS = this.getICMPRESUPUESTOS();
            strategy.appendField(locator, this, "icmpresupuestos", buffer, theICMPRESUPUESTOS, (this.icmpresupuestos!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            IcmPresupuestosBlock theICMPRESUPUESTOS;
            theICMPRESUPUESTOS = this.getICMPRESUPUESTOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmpresupuestos", theICMPRESUPUESTOS), currentHashCode, theICMPRESUPUESTOS, (this.icmpresupuestos!= null));
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
        if (draftCopy instanceof SAVEPRESUPUESTOS) {
            final SAVEPRESUPUESTOS copy = ((SAVEPRESUPUESTOS) draftCopy);
            {
                Boolean icmpresupuestosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmpresupuestos!= null));
                if (icmpresupuestosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmPresupuestosBlock sourceICMPRESUPUESTOS;
                    sourceICMPRESUPUESTOS = this.getICMPRESUPUESTOS();
                    IcmPresupuestosBlock copyICMPRESUPUESTOS = ((IcmPresupuestosBlock) strategy.copy(LocatorUtils.property(locator, "icmpresupuestos", sourceICMPRESUPUESTOS), sourceICMPRESUPUESTOS, (this.icmpresupuestos!= null)));
                    copy.setICMPRESUPUESTOS(copyICMPRESUPUESTOS);
                } else {
                    if (icmpresupuestosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmpresupuestos = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SAVEPRESUPUESTOS();
    }

}
