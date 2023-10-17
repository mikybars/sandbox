
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
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GETCONFIGURACIONReturn" type="{http://schemas.meta4.com/}GetconfiguracionOutput"/&gt;
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
    "getconfiguracionReturn"
})
@XmlRootElement(name = "GETCONFIGURACIONResponse")
public class GETCONFIGURACIONResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "GETCONFIGURACIONReturn", required = true)
    protected GetconfiguracionOutput getconfiguracionReturn;

    /**
     * Gets the value of the getconfiguracionReturn property.
     *
     * @return
     *     possible object is
     *     {@link GetconfiguracionOutput }
     *
     */
    public GetconfiguracionOutput getGETCONFIGURACIONReturn() {
        return getconfiguracionReturn;
    }

    /**
     * Sets the value of the getconfiguracionReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link GetconfiguracionOutput }
     *
     */
    public void setGETCONFIGURACIONReturn(GetconfiguracionOutput value) {
        this.getconfiguracionReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETCONFIGURACIONResponse that = ((GETCONFIGURACIONResponse) object);
        {
            GetconfiguracionOutput lhsGETCONFIGURACIONReturn;
            lhsGETCONFIGURACIONReturn = this.getGETCONFIGURACIONReturn();
            GetconfiguracionOutput rhsGETCONFIGURACIONReturn;
            rhsGETCONFIGURACIONReturn = that.getGETCONFIGURACIONReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getconfiguracionReturn", lhsGETCONFIGURACIONReturn), LocatorUtils.property(thatLocator, "getconfiguracionReturn", rhsGETCONFIGURACIONReturn), lhsGETCONFIGURACIONReturn, rhsGETCONFIGURACIONReturn, (this.getconfiguracionReturn!= null), (that.getconfiguracionReturn!= null))) {
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
            GetconfiguracionOutput theGETCONFIGURACIONReturn;
            theGETCONFIGURACIONReturn = this.getGETCONFIGURACIONReturn();
            strategy.appendField(locator, this, "getconfiguracionReturn", buffer, theGETCONFIGURACIONReturn, (this.getconfiguracionReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetconfiguracionOutput theGETCONFIGURACIONReturn;
            theGETCONFIGURACIONReturn = this.getGETCONFIGURACIONReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getconfiguracionReturn", theGETCONFIGURACIONReturn), currentHashCode, theGETCONFIGURACIONReturn, (this.getconfiguracionReturn!= null));
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
        if (draftCopy instanceof GETCONFIGURACIONResponse) {
            final GETCONFIGURACIONResponse copy = ((GETCONFIGURACIONResponse) draftCopy);
            {
                Boolean getconfiguracionReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getconfiguracionReturn!= null));
                if (getconfiguracionReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetconfiguracionOutput sourceGETCONFIGURACIONReturn;
                    sourceGETCONFIGURACIONReturn = this.getGETCONFIGURACIONReturn();
                    GetconfiguracionOutput copyGETCONFIGURACIONReturn = ((GetconfiguracionOutput) strategy.copy(LocatorUtils.property(locator, "getconfiguracionReturn", sourceGETCONFIGURACIONReturn), sourceGETCONFIGURACIONReturn, (this.getconfiguracionReturn!= null)));
                    copy.setGETCONFIGURACIONReturn(copyGETCONFIGURACIONReturn);
                } else {
                    if (getconfiguracionReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getconfiguracionReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETCONFIGURACIONResponse();
    }

}
