
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
 *         &lt;element name="GETTIENDASINCOMEReturn" type="{http://schemas.meta4.com/}GettiendasincomeOutput"/>
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
    "gettiendasincomeReturn"
})
@XmlRootElement(name = "GETTIENDASINCOMEResponse")
public class GETTIENDASINCOMEResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETTIENDASINCOMEReturn", required = true)
    protected GettiendasincomeOutput gettiendasincomeReturn;

    /**
     * Obtiene el valor de la propiedad gettiendasincomeReturn.
     * 
     * @return
     *     possible object is
     *     {@link GettiendasincomeOutput }
     *     
     */
    public GettiendasincomeOutput getGETTIENDASINCOMEReturn() {
        return gettiendasincomeReturn;
    }

    /**
     * Define el valor de la propiedad gettiendasincomeReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GettiendasincomeOutput }
     *     
     */
    public void setGETTIENDASINCOMEReturn(GettiendasincomeOutput value) {
        this.gettiendasincomeReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETTIENDASINCOMEResponse that = ((GETTIENDASINCOMEResponse) object);
        {
            GettiendasincomeOutput lhsGETTIENDASINCOMEReturn;
            lhsGETTIENDASINCOMEReturn = this.getGETTIENDASINCOMEReturn();
            GettiendasincomeOutput rhsGETTIENDASINCOMEReturn;
            rhsGETTIENDASINCOMEReturn = that.getGETTIENDASINCOMEReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "gettiendasincomeReturn", lhsGETTIENDASINCOMEReturn), LocatorUtils.property(thatLocator, "gettiendasincomeReturn", rhsGETTIENDASINCOMEReturn), lhsGETTIENDASINCOMEReturn, rhsGETTIENDASINCOMEReturn, (this.gettiendasincomeReturn!= null), (that.gettiendasincomeReturn!= null))) {
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
            GettiendasincomeOutput theGETTIENDASINCOMEReturn;
            theGETTIENDASINCOMEReturn = this.getGETTIENDASINCOMEReturn();
            strategy.appendField(locator, this, "gettiendasincomeReturn", buffer, theGETTIENDASINCOMEReturn, (this.gettiendasincomeReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GettiendasincomeOutput theGETTIENDASINCOMEReturn;
            theGETTIENDASINCOMEReturn = this.getGETTIENDASINCOMEReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "gettiendasincomeReturn", theGETTIENDASINCOMEReturn), currentHashCode, theGETTIENDASINCOMEReturn, (this.gettiendasincomeReturn!= null));
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
        if (draftCopy instanceof GETTIENDASINCOMEResponse) {
            final GETTIENDASINCOMEResponse copy = ((GETTIENDASINCOMEResponse) draftCopy);
            {
                Boolean gettiendasincomeReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.gettiendasincomeReturn!= null));
                if (gettiendasincomeReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GettiendasincomeOutput sourceGETTIENDASINCOMEReturn;
                    sourceGETTIENDASINCOMEReturn = this.getGETTIENDASINCOMEReturn();
                    GettiendasincomeOutput copyGETTIENDASINCOMEReturn = ((GettiendasincomeOutput) strategy.copy(LocatorUtils.property(locator, "gettiendasincomeReturn", sourceGETTIENDASINCOMEReturn), sourceGETTIENDASINCOMEReturn, (this.gettiendasincomeReturn!= null)));
                    copy.setGETTIENDASINCOMEReturn(copyGETTIENDASINCOMEReturn);
                } else {
                    if (gettiendasincomeReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.gettiendasincomeReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETTIENDASINCOMEResponse();
    }

}
