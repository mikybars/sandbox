
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
 *         &lt;element name="GETPRESENCIASEMPLEADOReturn" type="{http://schemas.meta4.com/}GetpresenciasempleadoOutput"/>
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
    "getpresenciasempleadoReturn"
})
@XmlRootElement(name = "GETPRESENCIASEMPLEADOResponse")
public class GETPRESENCIASEMPLEADOResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETPRESENCIASEMPLEADOReturn", required = true)
    protected GetpresenciasempleadoOutput getpresenciasempleadoReturn;

    /**
     * Obtiene el valor de la propiedad getpresenciasempleadoReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetpresenciasempleadoOutput }
     *     
     */
    public GetpresenciasempleadoOutput getGETPRESENCIASEMPLEADOReturn() {
        return getpresenciasempleadoReturn;
    }

    /**
     * Define el valor de la propiedad getpresenciasempleadoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetpresenciasempleadoOutput }
     *     
     */
    public void setGETPRESENCIASEMPLEADOReturn(GetpresenciasempleadoOutput value) {
        this.getpresenciasempleadoReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETPRESENCIASEMPLEADOResponse that = ((GETPRESENCIASEMPLEADOResponse) object);
        {
            GetpresenciasempleadoOutput lhsGETPRESENCIASEMPLEADOReturn;
            lhsGETPRESENCIASEMPLEADOReturn = this.getGETPRESENCIASEMPLEADOReturn();
            GetpresenciasempleadoOutput rhsGETPRESENCIASEMPLEADOReturn;
            rhsGETPRESENCIASEMPLEADOReturn = that.getGETPRESENCIASEMPLEADOReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getpresenciasempleadoReturn", lhsGETPRESENCIASEMPLEADOReturn), LocatorUtils.property(thatLocator, "getpresenciasempleadoReturn", rhsGETPRESENCIASEMPLEADOReturn), lhsGETPRESENCIASEMPLEADOReturn, rhsGETPRESENCIASEMPLEADOReturn, (this.getpresenciasempleadoReturn!= null), (that.getpresenciasempleadoReturn!= null))) {
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
            GetpresenciasempleadoOutput theGETPRESENCIASEMPLEADOReturn;
            theGETPRESENCIASEMPLEADOReturn = this.getGETPRESENCIASEMPLEADOReturn();
            strategy.appendField(locator, this, "getpresenciasempleadoReturn", buffer, theGETPRESENCIASEMPLEADOReturn, (this.getpresenciasempleadoReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetpresenciasempleadoOutput theGETPRESENCIASEMPLEADOReturn;
            theGETPRESENCIASEMPLEADOReturn = this.getGETPRESENCIASEMPLEADOReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getpresenciasempleadoReturn", theGETPRESENCIASEMPLEADOReturn), currentHashCode, theGETPRESENCIASEMPLEADOReturn, (this.getpresenciasempleadoReturn!= null));
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
        if (draftCopy instanceof GETPRESENCIASEMPLEADOResponse) {
            final GETPRESENCIASEMPLEADOResponse copy = ((GETPRESENCIASEMPLEADOResponse) draftCopy);
            {
                Boolean getpresenciasempleadoReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getpresenciasempleadoReturn!= null));
                if (getpresenciasempleadoReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetpresenciasempleadoOutput sourceGETPRESENCIASEMPLEADOReturn;
                    sourceGETPRESENCIASEMPLEADOReturn = this.getGETPRESENCIASEMPLEADOReturn();
                    GetpresenciasempleadoOutput copyGETPRESENCIASEMPLEADOReturn = ((GetpresenciasempleadoOutput) strategy.copy(LocatorUtils.property(locator, "getpresenciasempleadoReturn", sourceGETPRESENCIASEMPLEADOReturn), sourceGETPRESENCIASEMPLEADOReturn, (this.getpresenciasempleadoReturn!= null)));
                    copy.setGETPRESENCIASEMPLEADOReturn(copyGETPRESENCIASEMPLEADOReturn);
                } else {
                    if (getpresenciasempleadoReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getpresenciasempleadoReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETPRESENCIASEMPLEADOResponse();
    }

}
