
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
 *         &lt;element name="GETEMPLEADOSDESPSALReturn" type="{http://schemas.meta4.com/}GetempleadosdespsalOutput"/>
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
    "getempleadosdespsalReturn"
})
@XmlRootElement(name = "GETEMPLEADOSDESPSALResponse")
public class GETEMPLEADOSDESPSALResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETEMPLEADOSDESPSALReturn", required = true)
    protected GetempleadosdespsalOutput getempleadosdespsalReturn;

    /**
     * Obtiene el valor de la propiedad getempleadosdespsalReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetempleadosdespsalOutput }
     *     
     */
    public GetempleadosdespsalOutput getGETEMPLEADOSDESPSALReturn() {
        return getempleadosdespsalReturn;
    }

    /**
     * Define el valor de la propiedad getempleadosdespsalReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetempleadosdespsalOutput }
     *     
     */
    public void setGETEMPLEADOSDESPSALReturn(GetempleadosdespsalOutput value) {
        this.getempleadosdespsalReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETEMPLEADOSDESPSALResponse that = ((GETEMPLEADOSDESPSALResponse) object);
        {
            GetempleadosdespsalOutput lhsGETEMPLEADOSDESPSALReturn;
            lhsGETEMPLEADOSDESPSALReturn = this.getGETEMPLEADOSDESPSALReturn();
            GetempleadosdespsalOutput rhsGETEMPLEADOSDESPSALReturn;
            rhsGETEMPLEADOSDESPSALReturn = that.getGETEMPLEADOSDESPSALReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getempleadosdespsalReturn", lhsGETEMPLEADOSDESPSALReturn), LocatorUtils.property(thatLocator, "getempleadosdespsalReturn", rhsGETEMPLEADOSDESPSALReturn), lhsGETEMPLEADOSDESPSALReturn, rhsGETEMPLEADOSDESPSALReturn, (this.getempleadosdespsalReturn!= null), (that.getempleadosdespsalReturn!= null))) {
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
            GetempleadosdespsalOutput theGETEMPLEADOSDESPSALReturn;
            theGETEMPLEADOSDESPSALReturn = this.getGETEMPLEADOSDESPSALReturn();
            strategy.appendField(locator, this, "getempleadosdespsalReturn", buffer, theGETEMPLEADOSDESPSALReturn, (this.getempleadosdespsalReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetempleadosdespsalOutput theGETEMPLEADOSDESPSALReturn;
            theGETEMPLEADOSDESPSALReturn = this.getGETEMPLEADOSDESPSALReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getempleadosdespsalReturn", theGETEMPLEADOSDESPSALReturn), currentHashCode, theGETEMPLEADOSDESPSALReturn, (this.getempleadosdespsalReturn!= null));
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
        if (draftCopy instanceof GETEMPLEADOSDESPSALResponse) {
            final GETEMPLEADOSDESPSALResponse copy = ((GETEMPLEADOSDESPSALResponse) draftCopy);
            {
                Boolean getempleadosdespsalReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getempleadosdespsalReturn!= null));
                if (getempleadosdespsalReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetempleadosdespsalOutput sourceGETEMPLEADOSDESPSALReturn;
                    sourceGETEMPLEADOSDESPSALReturn = this.getGETEMPLEADOSDESPSALReturn();
                    GetempleadosdespsalOutput copyGETEMPLEADOSDESPSALReturn = ((GetempleadosdespsalOutput) strategy.copy(LocatorUtils.property(locator, "getempleadosdespsalReturn", sourceGETEMPLEADOSDESPSALReturn), sourceGETEMPLEADOSDESPSALReturn, (this.getempleadosdespsalReturn!= null)));
                    copy.setGETEMPLEADOSDESPSALReturn(copyGETEMPLEADOSDESPSALReturn);
                } else {
                    if (getempleadosdespsalReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getempleadosdespsalReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETEMPLEADOSDESPSALResponse();
    }

}
