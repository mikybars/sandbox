
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
 *         &lt;element name="GETPLANTILLACONDICIONESReturn" type="{http://schemas.meta4.com/}GetplantillacondicionesOutput"/>
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
    "getplantillacondicionesReturn"
})
@XmlRootElement(name = "GETPLANTILLACONDICIONESResponse")
public class GETPLANTILLACONDICIONESResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETPLANTILLACONDICIONESReturn", required = true)
    protected GetplantillacondicionesOutput getplantillacondicionesReturn;

    /**
     * Obtiene el valor de la propiedad getplantillacondicionesReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetplantillacondicionesOutput }
     *     
     */
    public GetplantillacondicionesOutput getGETPLANTILLACONDICIONESReturn() {
        return getplantillacondicionesReturn;
    }

    /**
     * Define el valor de la propiedad getplantillacondicionesReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetplantillacondicionesOutput }
     *     
     */
    public void setGETPLANTILLACONDICIONESReturn(GetplantillacondicionesOutput value) {
        this.getplantillacondicionesReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETPLANTILLACONDICIONESResponse that = ((GETPLANTILLACONDICIONESResponse) object);
        {
            GetplantillacondicionesOutput lhsGETPLANTILLACONDICIONESReturn;
            lhsGETPLANTILLACONDICIONESReturn = this.getGETPLANTILLACONDICIONESReturn();
            GetplantillacondicionesOutput rhsGETPLANTILLACONDICIONESReturn;
            rhsGETPLANTILLACONDICIONESReturn = that.getGETPLANTILLACONDICIONESReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getplantillacondicionesReturn", lhsGETPLANTILLACONDICIONESReturn), LocatorUtils.property(thatLocator, "getplantillacondicionesReturn", rhsGETPLANTILLACONDICIONESReturn), lhsGETPLANTILLACONDICIONESReturn, rhsGETPLANTILLACONDICIONESReturn, (this.getplantillacondicionesReturn!= null), (that.getplantillacondicionesReturn!= null))) {
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
            GetplantillacondicionesOutput theGETPLANTILLACONDICIONESReturn;
            theGETPLANTILLACONDICIONESReturn = this.getGETPLANTILLACONDICIONESReturn();
            strategy.appendField(locator, this, "getplantillacondicionesReturn", buffer, theGETPLANTILLACONDICIONESReturn, (this.getplantillacondicionesReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetplantillacondicionesOutput theGETPLANTILLACONDICIONESReturn;
            theGETPLANTILLACONDICIONESReturn = this.getGETPLANTILLACONDICIONESReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getplantillacondicionesReturn", theGETPLANTILLACONDICIONESReturn), currentHashCode, theGETPLANTILLACONDICIONESReturn, (this.getplantillacondicionesReturn!= null));
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
        if (draftCopy instanceof GETPLANTILLACONDICIONESResponse) {
            final GETPLANTILLACONDICIONESResponse copy = ((GETPLANTILLACONDICIONESResponse) draftCopy);
            {
                Boolean getplantillacondicionesReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getplantillacondicionesReturn!= null));
                if (getplantillacondicionesReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetplantillacondicionesOutput sourceGETPLANTILLACONDICIONESReturn;
                    sourceGETPLANTILLACONDICIONESReturn = this.getGETPLANTILLACONDICIONESReturn();
                    GetplantillacondicionesOutput copyGETPLANTILLACONDICIONESReturn = ((GetplantillacondicionesOutput) strategy.copy(LocatorUtils.property(locator, "getplantillacondicionesReturn", sourceGETPLANTILLACONDICIONESReturn), sourceGETPLANTILLACONDICIONESReturn, (this.getplantillacondicionesReturn!= null)));
                    copy.setGETPLANTILLACONDICIONESReturn(copyGETPLANTILLACONDICIONESReturn);
                } else {
                    if (getplantillacondicionesReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getplantillacondicionesReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETPLANTILLACONDICIONESResponse();
    }

}
