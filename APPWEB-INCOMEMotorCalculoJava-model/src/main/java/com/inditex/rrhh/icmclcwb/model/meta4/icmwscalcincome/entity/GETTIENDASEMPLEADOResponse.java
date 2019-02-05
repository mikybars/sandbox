
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

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
 *         &lt;element name="GETTIENDASEMPLEADOReturn" type="{http://schemas.meta4.com/}GettiendasempleadoOutput"/>
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
    "gettiendasempleadoReturn"
})
@XmlRootElement(name = "GETTIENDASEMPLEADOResponse")
public class GETTIENDASEMPLEADOResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETTIENDASEMPLEADOReturn", required = true)
    protected GettiendasempleadoOutput gettiendasempleadoReturn;

    /**
     * Obtiene el valor de la propiedad gettiendasempleadoReturn.
     * 
     * @return
     *     possible object is
     *     {@link GettiendasempleadoOutput }
     *     
     */
    public GettiendasempleadoOutput getGETTIENDASEMPLEADOReturn() {
        return gettiendasempleadoReturn;
    }

    /**
     * Define el valor de la propiedad gettiendasempleadoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GettiendasempleadoOutput }
     *     
     */
    public void setGETTIENDASEMPLEADOReturn(GettiendasempleadoOutput value) {
        this.gettiendasempleadoReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETTIENDASEMPLEADOResponse that = ((GETTIENDASEMPLEADOResponse) object);
        {
            GettiendasempleadoOutput lhsGETTIENDASEMPLEADOReturn;
            lhsGETTIENDASEMPLEADOReturn = this.getGETTIENDASEMPLEADOReturn();
            GettiendasempleadoOutput rhsGETTIENDASEMPLEADOReturn;
            rhsGETTIENDASEMPLEADOReturn = that.getGETTIENDASEMPLEADOReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "gettiendasempleadoReturn", lhsGETTIENDASEMPLEADOReturn), LocatorUtils.property(thatLocator, "gettiendasempleadoReturn", rhsGETTIENDASEMPLEADOReturn), lhsGETTIENDASEMPLEADOReturn, rhsGETTIENDASEMPLEADOReturn, (this.gettiendasempleadoReturn!= null), (that.gettiendasempleadoReturn!= null))) {
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
            GettiendasempleadoOutput theGETTIENDASEMPLEADOReturn;
            theGETTIENDASEMPLEADOReturn = this.getGETTIENDASEMPLEADOReturn();
            strategy.appendField(locator, this, "gettiendasempleadoReturn", buffer, theGETTIENDASEMPLEADOReturn, (this.gettiendasempleadoReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GettiendasempleadoOutput theGETTIENDASEMPLEADOReturn;
            theGETTIENDASEMPLEADOReturn = this.getGETTIENDASEMPLEADOReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "gettiendasempleadoReturn", theGETTIENDASEMPLEADOReturn), currentHashCode, theGETTIENDASEMPLEADOReturn, (this.gettiendasempleadoReturn!= null));
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
        if (draftCopy instanceof GETTIENDASEMPLEADOResponse) {
            final GETTIENDASEMPLEADOResponse copy = ((GETTIENDASEMPLEADOResponse) draftCopy);
            {
                Boolean gettiendasempleadoReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.gettiendasempleadoReturn!= null));
                if (gettiendasempleadoReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GettiendasempleadoOutput sourceGETTIENDASEMPLEADOReturn;
                    sourceGETTIENDASEMPLEADOReturn = this.getGETTIENDASEMPLEADOReturn();
                    GettiendasempleadoOutput copyGETTIENDASEMPLEADOReturn = ((GettiendasempleadoOutput) strategy.copy(LocatorUtils.property(locator, "gettiendasempleadoReturn", sourceGETTIENDASEMPLEADOReturn), sourceGETTIENDASEMPLEADOReturn, (this.gettiendasempleadoReturn!= null)));
                    copy.setGETTIENDASEMPLEADOReturn(copyGETTIENDASEMPLEADOReturn);
                } else {
                    if (gettiendasempleadoReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.gettiendasempleadoReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETTIENDASEMPLEADOResponse();
    }

}
