
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GETTIPOSHORAReturn" type="{http://schemas.meta4.com/}GettiposhoraOutput"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "gettiposhoraReturn"
})
@XmlRootElement(name = "GETTIPOSHORAResponse")
public class GETTIPOSHORAResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "GETTIPOSHORAReturn", required = true)
    protected GettiposhoraOutput gettiposhoraReturn;

    /**
     * Obtiene el valor de la propiedad gettiposhoraReturn.
     *
     * @return
     *     possible object is
     *     {@link GettiposhoraOutput }
     *
     */
    public GettiposhoraOutput getGETTIPOSHORAReturn() {
        return gettiposhoraReturn;
    }

    /**
     * Define el valor de la propiedad gettiposhoraReturn.
     *
     * @param value
     *     allowed object is
     *     {@link GettiposhoraOutput }
     *
     */
    public void setGETTIPOSHORAReturn(GettiposhoraOutput value) {
        this.gettiposhoraReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETTIPOSHORAResponse that = ((GETTIPOSHORAResponse) object);
        {
            GettiposhoraOutput lhsGETTIPOSHORAReturn;
            lhsGETTIPOSHORAReturn = this.getGETTIPOSHORAReturn();
            GettiposhoraOutput rhsGETTIPOSHORAReturn;
            rhsGETTIPOSHORAReturn = that.getGETTIPOSHORAReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "gettiposhoraReturn", lhsGETTIPOSHORAReturn), LocatorUtils.property(thatLocator, "gettiposhoraReturn", rhsGETTIPOSHORAReturn), lhsGETTIPOSHORAReturn, rhsGETTIPOSHORAReturn, (this.gettiposhoraReturn!= null), (that.gettiposhoraReturn!= null))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
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
            GettiposhoraOutput theGETTIPOSHORAReturn;
            theGETTIPOSHORAReturn = this.getGETTIPOSHORAReturn();
            strategy.appendField(locator, this, "gettiposhoraReturn", buffer, theGETTIPOSHORAReturn, (this.gettiposhoraReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GettiposhoraOutput theGETTIPOSHORAReturn;
            theGETTIPOSHORAReturn = this.getGETTIPOSHORAReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "gettiposhoraReturn", theGETTIPOSHORAReturn), currentHashCode, theGETTIPOSHORAReturn, (this.gettiposhoraReturn!= null));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof GETTIPOSHORAResponse) {
            final GETTIPOSHORAResponse copy = ((GETTIPOSHORAResponse) draftCopy);
            {
                Boolean gettiposhoraReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.gettiposhoraReturn!= null));
                if (gettiposhoraReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GettiposhoraOutput sourceGETTIPOSHORAReturn;
                    sourceGETTIPOSHORAReturn = this.getGETTIPOSHORAReturn();
                    GettiposhoraOutput copyGETTIPOSHORAReturn = ((GettiposhoraOutput) strategy.copy(LocatorUtils.property(locator, "gettiposhoraReturn", sourceGETTIPOSHORAReturn), sourceGETTIPOSHORAReturn, (this.gettiposhoraReturn!= null)));
                    copy.setGETTIPOSHORAReturn(copyGETTIPOSHORAReturn);
                } else {
                    if (gettiposhoraReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.gettiposhoraReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETTIPOSHORAResponse();
    }

}
