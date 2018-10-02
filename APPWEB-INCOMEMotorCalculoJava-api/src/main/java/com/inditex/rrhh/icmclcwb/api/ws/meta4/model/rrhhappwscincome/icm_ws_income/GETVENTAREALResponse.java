
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
 *         &lt;element name="GETVENTAREALReturn" type="{http://schemas.meta4.com/}GetventarealOutput"/>
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
    "getventarealReturn"
})
@XmlRootElement(name = "GETVENTAREALResponse")
public class GETVENTAREALResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETVENTAREALReturn", required = true)
    protected GetventarealOutput getventarealReturn;

    /**
     * Obtiene el valor de la propiedad getventarealReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetventarealOutput }
     *     
     */
    public GetventarealOutput getGETVENTAREALReturn() {
        return getventarealReturn;
    }

    /**
     * Define el valor de la propiedad getventarealReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetventarealOutput }
     *     
     */
    public void setGETVENTAREALReturn(GetventarealOutput value) {
        this.getventarealReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETVENTAREALResponse that = ((GETVENTAREALResponse) object);
        {
            GetventarealOutput lhsGETVENTAREALReturn;
            lhsGETVENTAREALReturn = this.getGETVENTAREALReturn();
            GetventarealOutput rhsGETVENTAREALReturn;
            rhsGETVENTAREALReturn = that.getGETVENTAREALReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getventarealReturn", lhsGETVENTAREALReturn), LocatorUtils.property(thatLocator, "getventarealReturn", rhsGETVENTAREALReturn), lhsGETVENTAREALReturn, rhsGETVENTAREALReturn, (this.getventarealReturn!= null), (that.getventarealReturn!= null))) {
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
            GetventarealOutput theGETVENTAREALReturn;
            theGETVENTAREALReturn = this.getGETVENTAREALReturn();
            strategy.appendField(locator, this, "getventarealReturn", buffer, theGETVENTAREALReturn, (this.getventarealReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetventarealOutput theGETVENTAREALReturn;
            theGETVENTAREALReturn = this.getGETVENTAREALReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getventarealReturn", theGETVENTAREALReturn), currentHashCode, theGETVENTAREALReturn, (this.getventarealReturn!= null));
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
        if (draftCopy instanceof GETVENTAREALResponse) {
            final GETVENTAREALResponse copy = ((GETVENTAREALResponse) draftCopy);
            {
                Boolean getventarealReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getventarealReturn!= null));
                if (getventarealReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetventarealOutput sourceGETVENTAREALReturn;
                    sourceGETVENTAREALReturn = this.getGETVENTAREALReturn();
                    GetventarealOutput copyGETVENTAREALReturn = ((GetventarealOutput) strategy.copy(LocatorUtils.property(locator, "getventarealReturn", sourceGETVENTAREALReturn), sourceGETVENTAREALReturn, (this.getventarealReturn!= null)));
                    copy.setGETVENTAREALReturn(copyGETVENTAREALReturn);
                } else {
                    if (getventarealReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getventarealReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETVENTAREALResponse();
    }

}
