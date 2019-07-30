
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

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
 *         &lt;element name="GETESTRCOMISIONReturn" type="{http://schemas.meta4.com/}GetestrcomisionOutput"/>
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
    "getestrcomisionReturn"
})
@XmlRootElement(name = "GETESTRCOMISIONResponse")
public class GETESTRCOMISIONResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETESTRCOMISIONReturn", required = true)
    protected GetestrcomisionOutput getestrcomisionReturn;

    /**
     * Obtiene el valor de la propiedad getestrcomisionReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetestrcomisionOutput }
     *     
     */
    public GetestrcomisionOutput getGETESTRCOMISIONReturn() {
        return getestrcomisionReturn;
    }

    /**
     * Define el valor de la propiedad getestrcomisionReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetestrcomisionOutput }
     *     
     */
    public void setGETESTRCOMISIONReturn(GetestrcomisionOutput value) {
        this.getestrcomisionReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETESTRCOMISIONResponse that = ((GETESTRCOMISIONResponse) object);
        {
            GetestrcomisionOutput lhsGETESTRCOMISIONReturn;
            lhsGETESTRCOMISIONReturn = this.getGETESTRCOMISIONReturn();
            GetestrcomisionOutput rhsGETESTRCOMISIONReturn;
            rhsGETESTRCOMISIONReturn = that.getGETESTRCOMISIONReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getestrcomisionReturn", lhsGETESTRCOMISIONReturn), LocatorUtils.property(thatLocator, "getestrcomisionReturn", rhsGETESTRCOMISIONReturn), lhsGETESTRCOMISIONReturn, rhsGETESTRCOMISIONReturn, (this.getestrcomisionReturn!= null), (that.getestrcomisionReturn!= null))) {
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
            GetestrcomisionOutput theGETESTRCOMISIONReturn;
            theGETESTRCOMISIONReturn = this.getGETESTRCOMISIONReturn();
            strategy.appendField(locator, this, "getestrcomisionReturn", buffer, theGETESTRCOMISIONReturn, (this.getestrcomisionReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetestrcomisionOutput theGETESTRCOMISIONReturn;
            theGETESTRCOMISIONReturn = this.getGETESTRCOMISIONReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getestrcomisionReturn", theGETESTRCOMISIONReturn), currentHashCode, theGETESTRCOMISIONReturn, (this.getestrcomisionReturn!= null));
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
        if (draftCopy instanceof GETESTRCOMISIONResponse) {
            final GETESTRCOMISIONResponse copy = ((GETESTRCOMISIONResponse) draftCopy);
            {
                Boolean getestrcomisionReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getestrcomisionReturn!= null));
                if (getestrcomisionReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetestrcomisionOutput sourceGETESTRCOMISIONReturn;
                    sourceGETESTRCOMISIONReturn = this.getGETESTRCOMISIONReturn();
                    GetestrcomisionOutput copyGETESTRCOMISIONReturn = ((GetestrcomisionOutput) strategy.copy(LocatorUtils.property(locator, "getestrcomisionReturn", sourceGETESTRCOMISIONReturn), sourceGETESTRCOMISIONReturn, (this.getestrcomisionReturn!= null)));
                    copy.setGETESTRCOMISIONReturn(copyGETESTRCOMISIONReturn);
                } else {
                    if (getestrcomisionReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getestrcomisionReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETESTRCOMISIONResponse();
    }

}
