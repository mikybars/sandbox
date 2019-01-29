
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
 *         &lt;element name="GETCOMISIONEMPLEADOReturn" type="{http://schemas.meta4.com/}GetcomisionempleadoOutput"/>
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
    "getcomisionempleadoReturn"
})
@XmlRootElement(name = "GETCOMISIONEMPLEADOResponse")
public class GETCOMISIONEMPLEADOResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETCOMISIONEMPLEADOReturn", required = true)
    protected GetcomisionempleadoOutput getcomisionempleadoReturn;

    /**
     * Obtiene el valor de la propiedad getcomisionempleadoReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetcomisionempleadoOutput }
     *     
     */
    public GetcomisionempleadoOutput getGETCOMISIONEMPLEADOReturn() {
        return getcomisionempleadoReturn;
    }

    /**
     * Define el valor de la propiedad getcomisionempleadoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetcomisionempleadoOutput }
     *     
     */
    public void setGETCOMISIONEMPLEADOReturn(GetcomisionempleadoOutput value) {
        this.getcomisionempleadoReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETCOMISIONEMPLEADOResponse that = ((GETCOMISIONEMPLEADOResponse) object);
        {
            GetcomisionempleadoOutput lhsGETCOMISIONEMPLEADOReturn;
            lhsGETCOMISIONEMPLEADOReturn = this.getGETCOMISIONEMPLEADOReturn();
            GetcomisionempleadoOutput rhsGETCOMISIONEMPLEADOReturn;
            rhsGETCOMISIONEMPLEADOReturn = that.getGETCOMISIONEMPLEADOReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getcomisionempleadoReturn", lhsGETCOMISIONEMPLEADOReturn), LocatorUtils.property(thatLocator, "getcomisionempleadoReturn", rhsGETCOMISIONEMPLEADOReturn), lhsGETCOMISIONEMPLEADOReturn, rhsGETCOMISIONEMPLEADOReturn, (this.getcomisionempleadoReturn!= null), (that.getcomisionempleadoReturn!= null))) {
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
            GetcomisionempleadoOutput theGETCOMISIONEMPLEADOReturn;
            theGETCOMISIONEMPLEADOReturn = this.getGETCOMISIONEMPLEADOReturn();
            strategy.appendField(locator, this, "getcomisionempleadoReturn", buffer, theGETCOMISIONEMPLEADOReturn, (this.getcomisionempleadoReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetcomisionempleadoOutput theGETCOMISIONEMPLEADOReturn;
            theGETCOMISIONEMPLEADOReturn = this.getGETCOMISIONEMPLEADOReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getcomisionempleadoReturn", theGETCOMISIONEMPLEADOReturn), currentHashCode, theGETCOMISIONEMPLEADOReturn, (this.getcomisionempleadoReturn!= null));
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
        if (draftCopy instanceof GETCOMISIONEMPLEADOResponse) {
            final GETCOMISIONEMPLEADOResponse copy = ((GETCOMISIONEMPLEADOResponse) draftCopy);
            {
                Boolean getcomisionempleadoReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getcomisionempleadoReturn!= null));
                if (getcomisionempleadoReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetcomisionempleadoOutput sourceGETCOMISIONEMPLEADOReturn;
                    sourceGETCOMISIONEMPLEADOReturn = this.getGETCOMISIONEMPLEADOReturn();
                    GetcomisionempleadoOutput copyGETCOMISIONEMPLEADOReturn = ((GetcomisionempleadoOutput) strategy.copy(LocatorUtils.property(locator, "getcomisionempleadoReturn", sourceGETCOMISIONEMPLEADOReturn), sourceGETCOMISIONEMPLEADOReturn, (this.getcomisionempleadoReturn!= null)));
                    copy.setGETCOMISIONEMPLEADOReturn(copyGETCOMISIONEMPLEADOReturn);
                } else {
                    if (getcomisionempleadoReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getcomisionempleadoReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETCOMISIONEMPLEADOResponse();
    }

}
