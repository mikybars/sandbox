
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
 *         &lt;element name="GETCABECERATIENDAReturn" type="{http://schemas.meta4.com/}GetcabeceratiendaOutput"/>
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
    "getcabeceratiendaReturn"
})
@XmlRootElement(name = "GETCABECERATIENDAResponse")
public class GETCABECERATIENDAResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETCABECERATIENDAReturn", required = true)
    protected GetcabeceratiendaOutput getcabeceratiendaReturn;

    /**
     * Obtiene el valor de la propiedad getcabeceratiendaReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetcabeceratiendaOutput }
     *     
     */
    public GetcabeceratiendaOutput getGETCABECERATIENDAReturn() {
        return getcabeceratiendaReturn;
    }

    /**
     * Define el valor de la propiedad getcabeceratiendaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetcabeceratiendaOutput }
     *     
     */
    public void setGETCABECERATIENDAReturn(GetcabeceratiendaOutput value) {
        this.getcabeceratiendaReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETCABECERATIENDAResponse that = ((GETCABECERATIENDAResponse) object);
        {
            GetcabeceratiendaOutput lhsGETCABECERATIENDAReturn;
            lhsGETCABECERATIENDAReturn = this.getGETCABECERATIENDAReturn();
            GetcabeceratiendaOutput rhsGETCABECERATIENDAReturn;
            rhsGETCABECERATIENDAReturn = that.getGETCABECERATIENDAReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getcabeceratiendaReturn", lhsGETCABECERATIENDAReturn), LocatorUtils.property(thatLocator, "getcabeceratiendaReturn", rhsGETCABECERATIENDAReturn), lhsGETCABECERATIENDAReturn, rhsGETCABECERATIENDAReturn, (this.getcabeceratiendaReturn!= null), (that.getcabeceratiendaReturn!= null))) {
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
            GetcabeceratiendaOutput theGETCABECERATIENDAReturn;
            theGETCABECERATIENDAReturn = this.getGETCABECERATIENDAReturn();
            strategy.appendField(locator, this, "getcabeceratiendaReturn", buffer, theGETCABECERATIENDAReturn, (this.getcabeceratiendaReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetcabeceratiendaOutput theGETCABECERATIENDAReturn;
            theGETCABECERATIENDAReturn = this.getGETCABECERATIENDAReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getcabeceratiendaReturn", theGETCABECERATIENDAReturn), currentHashCode, theGETCABECERATIENDAReturn, (this.getcabeceratiendaReturn!= null));
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
        if (draftCopy instanceof GETCABECERATIENDAResponse) {
            final GETCABECERATIENDAResponse copy = ((GETCABECERATIENDAResponse) draftCopy);
            {
                Boolean getcabeceratiendaReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getcabeceratiendaReturn!= null));
                if (getcabeceratiendaReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetcabeceratiendaOutput sourceGETCABECERATIENDAReturn;
                    sourceGETCABECERATIENDAReturn = this.getGETCABECERATIENDAReturn();
                    GetcabeceratiendaOutput copyGETCABECERATIENDAReturn = ((GetcabeceratiendaOutput) strategy.copy(LocatorUtils.property(locator, "getcabeceratiendaReturn", sourceGETCABECERATIENDAReturn), sourceGETCABECERATIENDAReturn, (this.getcabeceratiendaReturn!= null)));
                    copy.setGETCABECERATIENDAReturn(copyGETCABECERATIENDAReturn);
                } else {
                    if (getcabeceratiendaReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getcabeceratiendaReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETCABECERATIENDAResponse();
    }

}
