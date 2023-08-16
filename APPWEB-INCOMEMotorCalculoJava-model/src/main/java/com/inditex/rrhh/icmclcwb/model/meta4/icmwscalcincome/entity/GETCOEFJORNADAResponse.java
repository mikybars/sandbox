
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
 *         &lt;element name="GETCOEFJORNADAReturn" type="{http://schemas.meta4.com/}GetcoefjornadaOutput"/&gt;
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
    "getcoefjornadaReturn"
})
@XmlRootElement(name = "GETCOEFJORNADAResponse")
public class GETCOEFJORNADAResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "GETCOEFJORNADAReturn", required = true)
    protected GetcoefjornadaOutput getcoefjornadaReturn;

    /**
     * Gets the value of the getcoefjornadaReturn property.
     *
     * @return
     *     possible object is
     *     {@link GetcoefjornadaOutput }
     *
     */
    public GetcoefjornadaOutput getGETCOEFJORNADAReturn() {
        return getcoefjornadaReturn;
    }

    /**
     * Sets the value of the getcoefjornadaReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link GetcoefjornadaOutput }
     *
     */
    public void setGETCOEFJORNADAReturn(GetcoefjornadaOutput value) {
        this.getcoefjornadaReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETCOEFJORNADAResponse that = ((GETCOEFJORNADAResponse) object);
        {
            GetcoefjornadaOutput lhsGETCOEFJORNADAReturn;
            lhsGETCOEFJORNADAReturn = this.getGETCOEFJORNADAReturn();
            GetcoefjornadaOutput rhsGETCOEFJORNADAReturn;
            rhsGETCOEFJORNADAReturn = that.getGETCOEFJORNADAReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getcoefjornadaReturn", lhsGETCOEFJORNADAReturn), LocatorUtils.property(thatLocator, "getcoefjornadaReturn", rhsGETCOEFJORNADAReturn), lhsGETCOEFJORNADAReturn, rhsGETCOEFJORNADAReturn, (this.getcoefjornadaReturn!= null), (that.getcoefjornadaReturn!= null))) {
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
            GetcoefjornadaOutput theGETCOEFJORNADAReturn;
            theGETCOEFJORNADAReturn = this.getGETCOEFJORNADAReturn();
            strategy.appendField(locator, this, "getcoefjornadaReturn", buffer, theGETCOEFJORNADAReturn, (this.getcoefjornadaReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetcoefjornadaOutput theGETCOEFJORNADAReturn;
            theGETCOEFJORNADAReturn = this.getGETCOEFJORNADAReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getcoefjornadaReturn", theGETCOEFJORNADAReturn), currentHashCode, theGETCOEFJORNADAReturn, (this.getcoefjornadaReturn!= null));
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
        if (draftCopy instanceof GETCOEFJORNADAResponse) {
            final GETCOEFJORNADAResponse copy = ((GETCOEFJORNADAResponse) draftCopy);
            {
                Boolean getcoefjornadaReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getcoefjornadaReturn!= null));
                if (getcoefjornadaReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetcoefjornadaOutput sourceGETCOEFJORNADAReturn;
                    sourceGETCOEFJORNADAReturn = this.getGETCOEFJORNADAReturn();
                    GetcoefjornadaOutput copyGETCOEFJORNADAReturn = ((GetcoefjornadaOutput) strategy.copy(LocatorUtils.property(locator, "getcoefjornadaReturn", sourceGETCOEFJORNADAReturn), sourceGETCOEFJORNADAReturn, (this.getcoefjornadaReturn!= null)));
                    copy.setGETCOEFJORNADAReturn(copyGETCOEFJORNADAReturn);
                } else {
                    if (getcoefjornadaReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getcoefjornadaReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETCOEFJORNADAResponse();
    }

}
