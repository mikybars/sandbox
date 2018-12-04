
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
 *         &lt;element name="GETTPCALCULOPAISCADENAReturn" type="{http://schemas.meta4.com/}GettpcalculopaiscadenaOutput"/>
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
    "gettpcalculopaiscadenaReturn"
})
@XmlRootElement(name = "GETTPCALCULOPAISCADENAResponse")
public class GETTPCALCULOPAISCADENAResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETTPCALCULOPAISCADENAReturn", required = true)
    protected GettpcalculopaiscadenaOutput gettpcalculopaiscadenaReturn;

    /**
     * Obtiene el valor de la propiedad gettpcalculopaiscadenaReturn.
     * 
     * @return
     *     possible object is
     *     {@link GettpcalculopaiscadenaOutput }
     *     
     */
    public GettpcalculopaiscadenaOutput getGETTPCALCULOPAISCADENAReturn() {
        return gettpcalculopaiscadenaReturn;
    }

    /**
     * Define el valor de la propiedad gettpcalculopaiscadenaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GettpcalculopaiscadenaOutput }
     *     
     */
    public void setGETTPCALCULOPAISCADENAReturn(GettpcalculopaiscadenaOutput value) {
        this.gettpcalculopaiscadenaReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETTPCALCULOPAISCADENAResponse that = ((GETTPCALCULOPAISCADENAResponse) object);
        {
            GettpcalculopaiscadenaOutput lhsGETTPCALCULOPAISCADENAReturn;
            lhsGETTPCALCULOPAISCADENAReturn = this.getGETTPCALCULOPAISCADENAReturn();
            GettpcalculopaiscadenaOutput rhsGETTPCALCULOPAISCADENAReturn;
            rhsGETTPCALCULOPAISCADENAReturn = that.getGETTPCALCULOPAISCADENAReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "gettpcalculopaiscadenaReturn", lhsGETTPCALCULOPAISCADENAReturn), LocatorUtils.property(thatLocator, "gettpcalculopaiscadenaReturn", rhsGETTPCALCULOPAISCADENAReturn), lhsGETTPCALCULOPAISCADENAReturn, rhsGETTPCALCULOPAISCADENAReturn, (this.gettpcalculopaiscadenaReturn!= null), (that.gettpcalculopaiscadenaReturn!= null))) {
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
            GettpcalculopaiscadenaOutput theGETTPCALCULOPAISCADENAReturn;
            theGETTPCALCULOPAISCADENAReturn = this.getGETTPCALCULOPAISCADENAReturn();
            strategy.appendField(locator, this, "gettpcalculopaiscadenaReturn", buffer, theGETTPCALCULOPAISCADENAReturn, (this.gettpcalculopaiscadenaReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GettpcalculopaiscadenaOutput theGETTPCALCULOPAISCADENAReturn;
            theGETTPCALCULOPAISCADENAReturn = this.getGETTPCALCULOPAISCADENAReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "gettpcalculopaiscadenaReturn", theGETTPCALCULOPAISCADENAReturn), currentHashCode, theGETTPCALCULOPAISCADENAReturn, (this.gettpcalculopaiscadenaReturn!= null));
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
        if (draftCopy instanceof GETTPCALCULOPAISCADENAResponse) {
            final GETTPCALCULOPAISCADENAResponse copy = ((GETTPCALCULOPAISCADENAResponse) draftCopy);
            {
                Boolean gettpcalculopaiscadenaReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.gettpcalculopaiscadenaReturn!= null));
                if (gettpcalculopaiscadenaReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GettpcalculopaiscadenaOutput sourceGETTPCALCULOPAISCADENAReturn;
                    sourceGETTPCALCULOPAISCADENAReturn = this.getGETTPCALCULOPAISCADENAReturn();
                    GettpcalculopaiscadenaOutput copyGETTPCALCULOPAISCADENAReturn = ((GettpcalculopaiscadenaOutput) strategy.copy(LocatorUtils.property(locator, "gettpcalculopaiscadenaReturn", sourceGETTPCALCULOPAISCADENAReturn), sourceGETTPCALCULOPAISCADENAReturn, (this.gettpcalculopaiscadenaReturn!= null)));
                    copy.setGETTPCALCULOPAISCADENAReturn(copyGETTPCALCULOPAISCADENAReturn);
                } else {
                    if (gettpcalculopaiscadenaReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.gettpcalculopaiscadenaReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETTPCALCULOPAISCADENAResponse();
    }

}
