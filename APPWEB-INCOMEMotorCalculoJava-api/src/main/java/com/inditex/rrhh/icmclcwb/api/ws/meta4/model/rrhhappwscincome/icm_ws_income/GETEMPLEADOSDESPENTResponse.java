
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
 *         &lt;element name="GETEMPLEADOSDESPENTReturn" type="{http://schemas.meta4.com/}GetempleadosdespentOutput"/>
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
    "getempleadosdespentReturn"
})
@XmlRootElement(name = "GETEMPLEADOSDESPENTResponse")
public class GETEMPLEADOSDESPENTResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETEMPLEADOSDESPENTReturn", required = true)
    protected GetempleadosdespentOutput getempleadosdespentReturn;

    /**
     * Obtiene el valor de la propiedad getempleadosdespentReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetempleadosdespentOutput }
     *     
     */
    public GetempleadosdespentOutput getGETEMPLEADOSDESPENTReturn() {
        return getempleadosdespentReturn;
    }

    /**
     * Define el valor de la propiedad getempleadosdespentReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetempleadosdespentOutput }
     *     
     */
    public void setGETEMPLEADOSDESPENTReturn(GetempleadosdespentOutput value) {
        this.getempleadosdespentReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETEMPLEADOSDESPENTResponse that = ((GETEMPLEADOSDESPENTResponse) object);
        {
            GetempleadosdespentOutput lhsGETEMPLEADOSDESPENTReturn;
            lhsGETEMPLEADOSDESPENTReturn = this.getGETEMPLEADOSDESPENTReturn();
            GetempleadosdespentOutput rhsGETEMPLEADOSDESPENTReturn;
            rhsGETEMPLEADOSDESPENTReturn = that.getGETEMPLEADOSDESPENTReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getempleadosdespentReturn", lhsGETEMPLEADOSDESPENTReturn), LocatorUtils.property(thatLocator, "getempleadosdespentReturn", rhsGETEMPLEADOSDESPENTReturn), lhsGETEMPLEADOSDESPENTReturn, rhsGETEMPLEADOSDESPENTReturn, (this.getempleadosdespentReturn!= null), (that.getempleadosdespentReturn!= null))) {
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
            GetempleadosdespentOutput theGETEMPLEADOSDESPENTReturn;
            theGETEMPLEADOSDESPENTReturn = this.getGETEMPLEADOSDESPENTReturn();
            strategy.appendField(locator, this, "getempleadosdespentReturn", buffer, theGETEMPLEADOSDESPENTReturn, (this.getempleadosdespentReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetempleadosdespentOutput theGETEMPLEADOSDESPENTReturn;
            theGETEMPLEADOSDESPENTReturn = this.getGETEMPLEADOSDESPENTReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getempleadosdespentReturn", theGETEMPLEADOSDESPENTReturn), currentHashCode, theGETEMPLEADOSDESPENTReturn, (this.getempleadosdespentReturn!= null));
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
        if (draftCopy instanceof GETEMPLEADOSDESPENTResponse) {
            final GETEMPLEADOSDESPENTResponse copy = ((GETEMPLEADOSDESPENTResponse) draftCopy);
            {
                Boolean getempleadosdespentReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getempleadosdespentReturn!= null));
                if (getempleadosdespentReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetempleadosdespentOutput sourceGETEMPLEADOSDESPENTReturn;
                    sourceGETEMPLEADOSDESPENTReturn = this.getGETEMPLEADOSDESPENTReturn();
                    GetempleadosdespentOutput copyGETEMPLEADOSDESPENTReturn = ((GetempleadosdespentOutput) strategy.copy(LocatorUtils.property(locator, "getempleadosdespentReturn", sourceGETEMPLEADOSDESPENTReturn), sourceGETEMPLEADOSDESPENTReturn, (this.getempleadosdespentReturn!= null)));
                    copy.setGETEMPLEADOSDESPENTReturn(copyGETEMPLEADOSDESPENTReturn);
                } else {
                    if (getempleadosdespentReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getempleadosdespentReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETEMPLEADOSDESPENTResponse();
    }

}
