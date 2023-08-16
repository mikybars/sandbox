
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
 *         &lt;element name="M4LoadObjectReturn" type="{http://schemas.meta4.com/}M4LoadobjectOutput"/&gt;
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
    "m4LoadObjectReturn"
})
@XmlRootElement(name = "M4LoadObjectResponse")
public class M4LoadObjectResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "M4LoadObjectReturn", required = true)
    protected M4LoadobjectOutput m4LoadObjectReturn;

    /**
     * Gets the value of the m4LoadObjectReturn property.
     *
     * @return
     *     possible object is
     *     {@link M4LoadobjectOutput }
     *
     */
    public M4LoadobjectOutput getM4LoadObjectReturn() {
        return m4LoadObjectReturn;
    }

    /**
     * Sets the value of the m4LoadObjectReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link M4LoadobjectOutput }
     *
     */
    public void setM4LoadObjectReturn(M4LoadobjectOutput value) {
        this.m4LoadObjectReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final M4LoadObjectResponse that = ((M4LoadObjectResponse) object);
        {
            M4LoadobjectOutput lhsM4LoadObjectReturn;
            lhsM4LoadObjectReturn = this.getM4LoadObjectReturn();
            M4LoadobjectOutput rhsM4LoadObjectReturn;
            rhsM4LoadObjectReturn = that.getM4LoadObjectReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "m4LoadObjectReturn", lhsM4LoadObjectReturn), LocatorUtils.property(thatLocator, "m4LoadObjectReturn", rhsM4LoadObjectReturn), lhsM4LoadObjectReturn, rhsM4LoadObjectReturn, (this.m4LoadObjectReturn!= null), (that.m4LoadObjectReturn!= null))) {
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
            M4LoadobjectOutput theM4LoadObjectReturn;
            theM4LoadObjectReturn = this.getM4LoadObjectReturn();
            strategy.appendField(locator, this, "m4LoadObjectReturn", buffer, theM4LoadObjectReturn, (this.m4LoadObjectReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            M4LoadobjectOutput theM4LoadObjectReturn;
            theM4LoadObjectReturn = this.getM4LoadObjectReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "m4LoadObjectReturn", theM4LoadObjectReturn), currentHashCode, theM4LoadObjectReturn, (this.m4LoadObjectReturn!= null));
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
        if (draftCopy instanceof M4LoadObjectResponse) {
            final M4LoadObjectResponse copy = ((M4LoadObjectResponse) draftCopy);
            {
                Boolean m4LoadObjectReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.m4LoadObjectReturn!= null));
                if (m4LoadObjectReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    M4LoadobjectOutput sourceM4LoadObjectReturn;
                    sourceM4LoadObjectReturn = this.getM4LoadObjectReturn();
                    M4LoadobjectOutput copyM4LoadObjectReturn = ((M4LoadobjectOutput) strategy.copy(LocatorUtils.property(locator, "m4LoadObjectReturn", sourceM4LoadObjectReturn), sourceM4LoadObjectReturn, (this.m4LoadObjectReturn!= null)));
                    copy.setM4LoadObjectReturn(copyM4LoadObjectReturn);
                } else {
                    if (m4LoadObjectReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.m4LoadObjectReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new M4LoadObjectResponse();
    }

}
