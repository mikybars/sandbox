
package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity;

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
 *         &lt;element name="GETPRESUPUESTOSReturn" type="{http://schemas.meta4.com/}GetpresupuestosOutput"/>
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
    "getpresupuestosReturn"
})
@XmlRootElement(name = "GETPRESUPUESTOSResponse")
public class GETPRESUPUESTOSResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETPRESUPUESTOSReturn", required = true)
    protected GetpresupuestosOutput getpresupuestosReturn;

    /**
     * Obtiene el valor de la propiedad getpresupuestosReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetpresupuestosOutput }
     *     
     */
    public GetpresupuestosOutput getGETPRESUPUESTOSReturn() {
        return getpresupuestosReturn;
    }

    /**
     * Define el valor de la propiedad getpresupuestosReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetpresupuestosOutput }
     *     
     */
    public void setGETPRESUPUESTOSReturn(GetpresupuestosOutput value) {
        this.getpresupuestosReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETPRESUPUESTOSResponse that = ((GETPRESUPUESTOSResponse) object);
        {
            GetpresupuestosOutput lhsGETPRESUPUESTOSReturn;
            lhsGETPRESUPUESTOSReturn = this.getGETPRESUPUESTOSReturn();
            GetpresupuestosOutput rhsGETPRESUPUESTOSReturn;
            rhsGETPRESUPUESTOSReturn = that.getGETPRESUPUESTOSReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getpresupuestosReturn", lhsGETPRESUPUESTOSReturn), LocatorUtils.property(thatLocator, "getpresupuestosReturn", rhsGETPRESUPUESTOSReturn), lhsGETPRESUPUESTOSReturn, rhsGETPRESUPUESTOSReturn, (this.getpresupuestosReturn!= null), (that.getpresupuestosReturn!= null))) {
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
            GetpresupuestosOutput theGETPRESUPUESTOSReturn;
            theGETPRESUPUESTOSReturn = this.getGETPRESUPUESTOSReturn();
            strategy.appendField(locator, this, "getpresupuestosReturn", buffer, theGETPRESUPUESTOSReturn, (this.getpresupuestosReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetpresupuestosOutput theGETPRESUPUESTOSReturn;
            theGETPRESUPUESTOSReturn = this.getGETPRESUPUESTOSReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getpresupuestosReturn", theGETPRESUPUESTOSReturn), currentHashCode, theGETPRESUPUESTOSReturn, (this.getpresupuestosReturn!= null));
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
        if (draftCopy instanceof GETPRESUPUESTOSResponse) {
            final GETPRESUPUESTOSResponse copy = ((GETPRESUPUESTOSResponse) draftCopy);
            {
                Boolean getpresupuestosReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getpresupuestosReturn!= null));
                if (getpresupuestosReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetpresupuestosOutput sourceGETPRESUPUESTOSReturn;
                    sourceGETPRESUPUESTOSReturn = this.getGETPRESUPUESTOSReturn();
                    GetpresupuestosOutput copyGETPRESUPUESTOSReturn = ((GetpresupuestosOutput) strategy.copy(LocatorUtils.property(locator, "getpresupuestosReturn", sourceGETPRESUPUESTOSReturn), sourceGETPRESUPUESTOSReturn, (this.getpresupuestosReturn!= null)));
                    copy.setGETPRESUPUESTOSReturn(copyGETPRESUPUESTOSReturn);
                } else {
                    if (getpresupuestosReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getpresupuestosReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETPRESUPUESTOSResponse();
    }

}
