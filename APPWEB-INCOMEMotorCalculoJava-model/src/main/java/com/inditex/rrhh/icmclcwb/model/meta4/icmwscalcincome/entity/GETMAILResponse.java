
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
 *         &lt;element name="GETMAILReturn" type="{http://schemas.meta4.com/}GetmailOutput"/&gt;
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
    "getmailReturn"
})
@XmlRootElement(name = "GETMAILResponse")
public class GETMAILResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "GETMAILReturn", required = true)
    protected GetmailOutput getmailReturn;

    /**
     * Obtiene el valor de la propiedad getmailReturn.
     *
     * @return
     *     possible object is
     *     {@link GetmailOutput }
     *
     */
    public GetmailOutput getGETMAILReturn() {
        return getmailReturn;
    }

    /**
     * Define el valor de la propiedad getmailReturn.
     *
     * @param value
     *     allowed object is
     *     {@link GetmailOutput }
     *
     */
    public void setGETMAILReturn(GetmailOutput value) {
        this.getmailReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETMAILResponse that = ((GETMAILResponse) object);
        {
            GetmailOutput lhsGETMAILReturn;
            lhsGETMAILReturn = this.getGETMAILReturn();
            GetmailOutput rhsGETMAILReturn;
            rhsGETMAILReturn = that.getGETMAILReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getmailReturn", lhsGETMAILReturn), LocatorUtils.property(thatLocator, "getmailReturn", rhsGETMAILReturn), lhsGETMAILReturn, rhsGETMAILReturn, (this.getmailReturn!= null), (that.getmailReturn!= null))) {
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
            GetmailOutput theGETMAILReturn;
            theGETMAILReturn = this.getGETMAILReturn();
            strategy.appendField(locator, this, "getmailReturn", buffer, theGETMAILReturn, (this.getmailReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetmailOutput theGETMAILReturn;
            theGETMAILReturn = this.getGETMAILReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getmailReturn", theGETMAILReturn), currentHashCode, theGETMAILReturn, (this.getmailReturn!= null));
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
        if (draftCopy instanceof GETMAILResponse) {
            final GETMAILResponse copy = ((GETMAILResponse) draftCopy);
            {
                Boolean getmailReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getmailReturn!= null));
                if (getmailReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetmailOutput sourceGETMAILReturn;
                    sourceGETMAILReturn = this.getGETMAILReturn();
                    GetmailOutput copyGETMAILReturn = ((GetmailOutput) strategy.copy(LocatorUtils.property(locator, "getmailReturn", sourceGETMAILReturn), sourceGETMAILReturn, (this.getmailReturn!= null)));
                    copy.setGETMAILReturn(copyGETMAILReturn);
                } else {
                    if (getmailReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getmailReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETMAILResponse();
    }

}
