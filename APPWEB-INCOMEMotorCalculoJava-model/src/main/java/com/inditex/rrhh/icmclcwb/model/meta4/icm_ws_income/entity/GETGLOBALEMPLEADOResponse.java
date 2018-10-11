
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
 *         &lt;element name="GETGLOBALEMPLEADOReturn" type="{http://schemas.meta4.com/}GetglobalempleadoOutput"/>
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
    "getglobalempleadoReturn"
})
@XmlRootElement(name = "GETGLOBALEMPLEADOResponse")
public class GETGLOBALEMPLEADOResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETGLOBALEMPLEADOReturn", required = true)
    protected GetglobalempleadoOutput getglobalempleadoReturn;

    /**
     * Obtiene el valor de la propiedad getglobalempleadoReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetglobalempleadoOutput }
     *     
     */
    public GetglobalempleadoOutput getGETGLOBALEMPLEADOReturn() {
        return getglobalempleadoReturn;
    }

    /**
     * Define el valor de la propiedad getglobalempleadoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetglobalempleadoOutput }
     *     
     */
    public void setGETGLOBALEMPLEADOReturn(GetglobalempleadoOutput value) {
        this.getglobalempleadoReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETGLOBALEMPLEADOResponse that = ((GETGLOBALEMPLEADOResponse) object);
        {
            GetglobalempleadoOutput lhsGETGLOBALEMPLEADOReturn;
            lhsGETGLOBALEMPLEADOReturn = this.getGETGLOBALEMPLEADOReturn();
            GetglobalempleadoOutput rhsGETGLOBALEMPLEADOReturn;
            rhsGETGLOBALEMPLEADOReturn = that.getGETGLOBALEMPLEADOReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getglobalempleadoReturn", lhsGETGLOBALEMPLEADOReturn), LocatorUtils.property(thatLocator, "getglobalempleadoReturn", rhsGETGLOBALEMPLEADOReturn), lhsGETGLOBALEMPLEADOReturn, rhsGETGLOBALEMPLEADOReturn, (this.getglobalempleadoReturn!= null), (that.getglobalempleadoReturn!= null))) {
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
            GetglobalempleadoOutput theGETGLOBALEMPLEADOReturn;
            theGETGLOBALEMPLEADOReturn = this.getGETGLOBALEMPLEADOReturn();
            strategy.appendField(locator, this, "getglobalempleadoReturn", buffer, theGETGLOBALEMPLEADOReturn, (this.getglobalempleadoReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetglobalempleadoOutput theGETGLOBALEMPLEADOReturn;
            theGETGLOBALEMPLEADOReturn = this.getGETGLOBALEMPLEADOReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getglobalempleadoReturn", theGETGLOBALEMPLEADOReturn), currentHashCode, theGETGLOBALEMPLEADOReturn, (this.getglobalempleadoReturn!= null));
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
        if (draftCopy instanceof GETGLOBALEMPLEADOResponse) {
            final GETGLOBALEMPLEADOResponse copy = ((GETGLOBALEMPLEADOResponse) draftCopy);
            {
                Boolean getglobalempleadoReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getglobalempleadoReturn!= null));
                if (getglobalempleadoReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetglobalempleadoOutput sourceGETGLOBALEMPLEADOReturn;
                    sourceGETGLOBALEMPLEADOReturn = this.getGETGLOBALEMPLEADOReturn();
                    GetglobalempleadoOutput copyGETGLOBALEMPLEADOReturn = ((GetglobalempleadoOutput) strategy.copy(LocatorUtils.property(locator, "getglobalempleadoReturn", sourceGETGLOBALEMPLEADOReturn), sourceGETGLOBALEMPLEADOReturn, (this.getglobalempleadoReturn!= null)));
                    copy.setGETGLOBALEMPLEADOReturn(copyGETGLOBALEMPLEADOReturn);
                } else {
                    if (getglobalempleadoReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getglobalempleadoReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETGLOBALEMPLEADOResponse();
    }

}
