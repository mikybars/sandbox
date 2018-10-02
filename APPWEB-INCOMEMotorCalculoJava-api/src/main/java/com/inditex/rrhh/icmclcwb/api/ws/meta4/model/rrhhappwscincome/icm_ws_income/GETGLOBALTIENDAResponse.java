
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
 *         &lt;element name="GETGLOBALTIENDAReturn" type="{http://schemas.meta4.com/}GetglobaltiendaOutput"/>
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
    "getglobaltiendaReturn"
})
@XmlRootElement(name = "GETGLOBALTIENDAResponse")
public class GETGLOBALTIENDAResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETGLOBALTIENDAReturn", required = true)
    protected GetglobaltiendaOutput getglobaltiendaReturn;

    /**
     * Obtiene el valor de la propiedad getglobaltiendaReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetglobaltiendaOutput }
     *     
     */
    public GetglobaltiendaOutput getGETGLOBALTIENDAReturn() {
        return getglobaltiendaReturn;
    }

    /**
     * Define el valor de la propiedad getglobaltiendaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetglobaltiendaOutput }
     *     
     */
    public void setGETGLOBALTIENDAReturn(GetglobaltiendaOutput value) {
        this.getglobaltiendaReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETGLOBALTIENDAResponse that = ((GETGLOBALTIENDAResponse) object);
        {
            GetglobaltiendaOutput lhsGETGLOBALTIENDAReturn;
            lhsGETGLOBALTIENDAReturn = this.getGETGLOBALTIENDAReturn();
            GetglobaltiendaOutput rhsGETGLOBALTIENDAReturn;
            rhsGETGLOBALTIENDAReturn = that.getGETGLOBALTIENDAReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getglobaltiendaReturn", lhsGETGLOBALTIENDAReturn), LocatorUtils.property(thatLocator, "getglobaltiendaReturn", rhsGETGLOBALTIENDAReturn), lhsGETGLOBALTIENDAReturn, rhsGETGLOBALTIENDAReturn, (this.getglobaltiendaReturn!= null), (that.getglobaltiendaReturn!= null))) {
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
            GetglobaltiendaOutput theGETGLOBALTIENDAReturn;
            theGETGLOBALTIENDAReturn = this.getGETGLOBALTIENDAReturn();
            strategy.appendField(locator, this, "getglobaltiendaReturn", buffer, theGETGLOBALTIENDAReturn, (this.getglobaltiendaReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetglobaltiendaOutput theGETGLOBALTIENDAReturn;
            theGETGLOBALTIENDAReturn = this.getGETGLOBALTIENDAReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getglobaltiendaReturn", theGETGLOBALTIENDAReturn), currentHashCode, theGETGLOBALTIENDAReturn, (this.getglobaltiendaReturn!= null));
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
        if (draftCopy instanceof GETGLOBALTIENDAResponse) {
            final GETGLOBALTIENDAResponse copy = ((GETGLOBALTIENDAResponse) draftCopy);
            {
                Boolean getglobaltiendaReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getglobaltiendaReturn!= null));
                if (getglobaltiendaReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetglobaltiendaOutput sourceGETGLOBALTIENDAReturn;
                    sourceGETGLOBALTIENDAReturn = this.getGETGLOBALTIENDAReturn();
                    GetglobaltiendaOutput copyGETGLOBALTIENDAReturn = ((GetglobaltiendaOutput) strategy.copy(LocatorUtils.property(locator, "getglobaltiendaReturn", sourceGETGLOBALTIENDAReturn), sourceGETGLOBALTIENDAReturn, (this.getglobaltiendaReturn!= null)));
                    copy.setGETGLOBALTIENDAReturn(copyGETGLOBALTIENDAReturn);
                } else {
                    if (getglobaltiendaReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getglobaltiendaReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETGLOBALTIENDAResponse();
    }

}
