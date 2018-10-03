
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
 *         &lt;element name="GETPRESENCIASTIENDAReturn" type="{http://schemas.meta4.com/}GetpresenciastiendaOutput"/>
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
    "getpresenciastiendaReturn"
})
@XmlRootElement(name = "GETPRESENCIASTIENDAResponse")
public class GETPRESENCIASTIENDAResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETPRESENCIASTIENDAReturn", required = true)
    protected GetpresenciastiendaOutput getpresenciastiendaReturn;

    /**
     * Obtiene el valor de la propiedad getpresenciastiendaReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetpresenciastiendaOutput }
     *     
     */
    public GetpresenciastiendaOutput getGETPRESENCIASTIENDAReturn() {
        return getpresenciastiendaReturn;
    }

    /**
     * Define el valor de la propiedad getpresenciastiendaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetpresenciastiendaOutput }
     *     
     */
    public void setGETPRESENCIASTIENDAReturn(GetpresenciastiendaOutput value) {
        this.getpresenciastiendaReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETPRESENCIASTIENDAResponse that = ((GETPRESENCIASTIENDAResponse) object);
        {
            GetpresenciastiendaOutput lhsGETPRESENCIASTIENDAReturn;
            lhsGETPRESENCIASTIENDAReturn = this.getGETPRESENCIASTIENDAReturn();
            GetpresenciastiendaOutput rhsGETPRESENCIASTIENDAReturn;
            rhsGETPRESENCIASTIENDAReturn = that.getGETPRESENCIASTIENDAReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getpresenciastiendaReturn", lhsGETPRESENCIASTIENDAReturn), LocatorUtils.property(thatLocator, "getpresenciastiendaReturn", rhsGETPRESENCIASTIENDAReturn), lhsGETPRESENCIASTIENDAReturn, rhsGETPRESENCIASTIENDAReturn, (this.getpresenciastiendaReturn!= null), (that.getpresenciastiendaReturn!= null))) {
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
            GetpresenciastiendaOutput theGETPRESENCIASTIENDAReturn;
            theGETPRESENCIASTIENDAReturn = this.getGETPRESENCIASTIENDAReturn();
            strategy.appendField(locator, this, "getpresenciastiendaReturn", buffer, theGETPRESENCIASTIENDAReturn, (this.getpresenciastiendaReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetpresenciastiendaOutput theGETPRESENCIASTIENDAReturn;
            theGETPRESENCIASTIENDAReturn = this.getGETPRESENCIASTIENDAReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getpresenciastiendaReturn", theGETPRESENCIASTIENDAReturn), currentHashCode, theGETPRESENCIASTIENDAReturn, (this.getpresenciastiendaReturn!= null));
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
        if (draftCopy instanceof GETPRESENCIASTIENDAResponse) {
            final GETPRESENCIASTIENDAResponse copy = ((GETPRESENCIASTIENDAResponse) draftCopy);
            {
                Boolean getpresenciastiendaReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getpresenciastiendaReturn!= null));
                if (getpresenciastiendaReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetpresenciastiendaOutput sourceGETPRESENCIASTIENDAReturn;
                    sourceGETPRESENCIASTIENDAReturn = this.getGETPRESENCIASTIENDAReturn();
                    GetpresenciastiendaOutput copyGETPRESENCIASTIENDAReturn = ((GetpresenciastiendaOutput) strategy.copy(LocatorUtils.property(locator, "getpresenciastiendaReturn", sourceGETPRESENCIASTIENDAReturn), sourceGETPRESENCIASTIENDAReturn, (this.getpresenciastiendaReturn!= null)));
                    copy.setGETPRESENCIASTIENDAReturn(copyGETPRESENCIASTIENDAReturn);
                } else {
                    if (getpresenciastiendaReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getpresenciastiendaReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETPRESENCIASTIENDAResponse();
    }

}
