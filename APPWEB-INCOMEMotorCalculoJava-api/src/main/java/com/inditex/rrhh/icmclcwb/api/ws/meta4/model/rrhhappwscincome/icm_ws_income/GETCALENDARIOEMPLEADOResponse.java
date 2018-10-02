
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
 *         &lt;element name="GETCALENDARIOEMPLEADOReturn" type="{http://schemas.meta4.com/}GetcalendarioempleadoOutput"/>
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
    "getcalendarioempleadoReturn"
})
@XmlRootElement(name = "GETCALENDARIOEMPLEADOResponse")
public class GETCALENDARIOEMPLEADOResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETCALENDARIOEMPLEADOReturn", required = true)
    protected GetcalendarioempleadoOutput getcalendarioempleadoReturn;

    /**
     * Obtiene el valor de la propiedad getcalendarioempleadoReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetcalendarioempleadoOutput }
     *     
     */
    public GetcalendarioempleadoOutput getGETCALENDARIOEMPLEADOReturn() {
        return getcalendarioempleadoReturn;
    }

    /**
     * Define el valor de la propiedad getcalendarioempleadoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetcalendarioempleadoOutput }
     *     
     */
    public void setGETCALENDARIOEMPLEADOReturn(GetcalendarioempleadoOutput value) {
        this.getcalendarioempleadoReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETCALENDARIOEMPLEADOResponse that = ((GETCALENDARIOEMPLEADOResponse) object);
        {
            GetcalendarioempleadoOutput lhsGETCALENDARIOEMPLEADOReturn;
            lhsGETCALENDARIOEMPLEADOReturn = this.getGETCALENDARIOEMPLEADOReturn();
            GetcalendarioempleadoOutput rhsGETCALENDARIOEMPLEADOReturn;
            rhsGETCALENDARIOEMPLEADOReturn = that.getGETCALENDARIOEMPLEADOReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getcalendarioempleadoReturn", lhsGETCALENDARIOEMPLEADOReturn), LocatorUtils.property(thatLocator, "getcalendarioempleadoReturn", rhsGETCALENDARIOEMPLEADOReturn), lhsGETCALENDARIOEMPLEADOReturn, rhsGETCALENDARIOEMPLEADOReturn, (this.getcalendarioempleadoReturn!= null), (that.getcalendarioempleadoReturn!= null))) {
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
            GetcalendarioempleadoOutput theGETCALENDARIOEMPLEADOReturn;
            theGETCALENDARIOEMPLEADOReturn = this.getGETCALENDARIOEMPLEADOReturn();
            strategy.appendField(locator, this, "getcalendarioempleadoReturn", buffer, theGETCALENDARIOEMPLEADOReturn, (this.getcalendarioempleadoReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetcalendarioempleadoOutput theGETCALENDARIOEMPLEADOReturn;
            theGETCALENDARIOEMPLEADOReturn = this.getGETCALENDARIOEMPLEADOReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getcalendarioempleadoReturn", theGETCALENDARIOEMPLEADOReturn), currentHashCode, theGETCALENDARIOEMPLEADOReturn, (this.getcalendarioempleadoReturn!= null));
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
        if (draftCopy instanceof GETCALENDARIOEMPLEADOResponse) {
            final GETCALENDARIOEMPLEADOResponse copy = ((GETCALENDARIOEMPLEADOResponse) draftCopy);
            {
                Boolean getcalendarioempleadoReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getcalendarioempleadoReturn!= null));
                if (getcalendarioempleadoReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetcalendarioempleadoOutput sourceGETCALENDARIOEMPLEADOReturn;
                    sourceGETCALENDARIOEMPLEADOReturn = this.getGETCALENDARIOEMPLEADOReturn();
                    GetcalendarioempleadoOutput copyGETCALENDARIOEMPLEADOReturn = ((GetcalendarioempleadoOutput) strategy.copy(LocatorUtils.property(locator, "getcalendarioempleadoReturn", sourceGETCALENDARIOEMPLEADOReturn), sourceGETCALENDARIOEMPLEADOReturn, (this.getcalendarioempleadoReturn!= null)));
                    copy.setGETCALENDARIOEMPLEADOReturn(copyGETCALENDARIOEMPLEADOReturn);
                } else {
                    if (getcalendarioempleadoReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getcalendarioempleadoReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETCALENDARIOEMPLEADOResponse();
    }

}
