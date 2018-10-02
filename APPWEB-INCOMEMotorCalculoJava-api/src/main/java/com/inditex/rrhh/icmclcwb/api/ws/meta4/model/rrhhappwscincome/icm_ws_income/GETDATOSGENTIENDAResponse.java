
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
 *         &lt;element name="GETDATOSGENTIENDAReturn" type="{http://schemas.meta4.com/}GetdatosgentiendaOutput"/>
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
    "getdatosgentiendaReturn"
})
@XmlRootElement(name = "GETDATOSGENTIENDAResponse")
public class GETDATOSGENTIENDAResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETDATOSGENTIENDAReturn", required = true)
    protected GetdatosgentiendaOutput getdatosgentiendaReturn;

    /**
     * Obtiene el valor de la propiedad getdatosgentiendaReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetdatosgentiendaOutput }
     *     
     */
    public GetdatosgentiendaOutput getGETDATOSGENTIENDAReturn() {
        return getdatosgentiendaReturn;
    }

    /**
     * Define el valor de la propiedad getdatosgentiendaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetdatosgentiendaOutput }
     *     
     */
    public void setGETDATOSGENTIENDAReturn(GetdatosgentiendaOutput value) {
        this.getdatosgentiendaReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETDATOSGENTIENDAResponse that = ((GETDATOSGENTIENDAResponse) object);
        {
            GetdatosgentiendaOutput lhsGETDATOSGENTIENDAReturn;
            lhsGETDATOSGENTIENDAReturn = this.getGETDATOSGENTIENDAReturn();
            GetdatosgentiendaOutput rhsGETDATOSGENTIENDAReturn;
            rhsGETDATOSGENTIENDAReturn = that.getGETDATOSGENTIENDAReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getdatosgentiendaReturn", lhsGETDATOSGENTIENDAReturn), LocatorUtils.property(thatLocator, "getdatosgentiendaReturn", rhsGETDATOSGENTIENDAReturn), lhsGETDATOSGENTIENDAReturn, rhsGETDATOSGENTIENDAReturn, (this.getdatosgentiendaReturn!= null), (that.getdatosgentiendaReturn!= null))) {
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
            GetdatosgentiendaOutput theGETDATOSGENTIENDAReturn;
            theGETDATOSGENTIENDAReturn = this.getGETDATOSGENTIENDAReturn();
            strategy.appendField(locator, this, "getdatosgentiendaReturn", buffer, theGETDATOSGENTIENDAReturn, (this.getdatosgentiendaReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetdatosgentiendaOutput theGETDATOSGENTIENDAReturn;
            theGETDATOSGENTIENDAReturn = this.getGETDATOSGENTIENDAReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getdatosgentiendaReturn", theGETDATOSGENTIENDAReturn), currentHashCode, theGETDATOSGENTIENDAReturn, (this.getdatosgentiendaReturn!= null));
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
        if (draftCopy instanceof GETDATOSGENTIENDAResponse) {
            final GETDATOSGENTIENDAResponse copy = ((GETDATOSGENTIENDAResponse) draftCopy);
            {
                Boolean getdatosgentiendaReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getdatosgentiendaReturn!= null));
                if (getdatosgentiendaReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetdatosgentiendaOutput sourceGETDATOSGENTIENDAReturn;
                    sourceGETDATOSGENTIENDAReturn = this.getGETDATOSGENTIENDAReturn();
                    GetdatosgentiendaOutput copyGETDATOSGENTIENDAReturn = ((GetdatosgentiendaOutput) strategy.copy(LocatorUtils.property(locator, "getdatosgentiendaReturn", sourceGETDATOSGENTIENDAReturn), sourceGETDATOSGENTIENDAReturn, (this.getdatosgentiendaReturn!= null)));
                    copy.setGETDATOSGENTIENDAReturn(copyGETDATOSGENTIENDAReturn);
                } else {
                    if (getdatosgentiendaReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getdatosgentiendaReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETDATOSGENTIENDAResponse();
    }

}
