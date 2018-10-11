
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
 *         &lt;element name="GETESTADOSTIENDASECCIONReturn" type="{http://schemas.meta4.com/}GetestadostiendaseccionOutput"/>
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
    "getestadostiendaseccionReturn"
})
@XmlRootElement(name = "GETESTADOSTIENDASECCIONResponse")
public class GETESTADOSTIENDASECCIONResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETESTADOSTIENDASECCIONReturn", required = true)
    protected GetestadostiendaseccionOutput getestadostiendaseccionReturn;

    /**
     * Obtiene el valor de la propiedad getestadostiendaseccionReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetestadostiendaseccionOutput }
     *     
     */
    public GetestadostiendaseccionOutput getGETESTADOSTIENDASECCIONReturn() {
        return getestadostiendaseccionReturn;
    }

    /**
     * Define el valor de la propiedad getestadostiendaseccionReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetestadostiendaseccionOutput }
     *     
     */
    public void setGETESTADOSTIENDASECCIONReturn(GetestadostiendaseccionOutput value) {
        this.getestadostiendaseccionReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETESTADOSTIENDASECCIONResponse that = ((GETESTADOSTIENDASECCIONResponse) object);
        {
            GetestadostiendaseccionOutput lhsGETESTADOSTIENDASECCIONReturn;
            lhsGETESTADOSTIENDASECCIONReturn = this.getGETESTADOSTIENDASECCIONReturn();
            GetestadostiendaseccionOutput rhsGETESTADOSTIENDASECCIONReturn;
            rhsGETESTADOSTIENDASECCIONReturn = that.getGETESTADOSTIENDASECCIONReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getestadostiendaseccionReturn", lhsGETESTADOSTIENDASECCIONReturn), LocatorUtils.property(thatLocator, "getestadostiendaseccionReturn", rhsGETESTADOSTIENDASECCIONReturn), lhsGETESTADOSTIENDASECCIONReturn, rhsGETESTADOSTIENDASECCIONReturn, (this.getestadostiendaseccionReturn!= null), (that.getestadostiendaseccionReturn!= null))) {
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
            GetestadostiendaseccionOutput theGETESTADOSTIENDASECCIONReturn;
            theGETESTADOSTIENDASECCIONReturn = this.getGETESTADOSTIENDASECCIONReturn();
            strategy.appendField(locator, this, "getestadostiendaseccionReturn", buffer, theGETESTADOSTIENDASECCIONReturn, (this.getestadostiendaseccionReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetestadostiendaseccionOutput theGETESTADOSTIENDASECCIONReturn;
            theGETESTADOSTIENDASECCIONReturn = this.getGETESTADOSTIENDASECCIONReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getestadostiendaseccionReturn", theGETESTADOSTIENDASECCIONReturn), currentHashCode, theGETESTADOSTIENDASECCIONReturn, (this.getestadostiendaseccionReturn!= null));
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
        if (draftCopy instanceof GETESTADOSTIENDASECCIONResponse) {
            final GETESTADOSTIENDASECCIONResponse copy = ((GETESTADOSTIENDASECCIONResponse) draftCopy);
            {
                Boolean getestadostiendaseccionReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getestadostiendaseccionReturn!= null));
                if (getestadostiendaseccionReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetestadostiendaseccionOutput sourceGETESTADOSTIENDASECCIONReturn;
                    sourceGETESTADOSTIENDASECCIONReturn = this.getGETESTADOSTIENDASECCIONReturn();
                    GetestadostiendaseccionOutput copyGETESTADOSTIENDASECCIONReturn = ((GetestadostiendaseccionOutput) strategy.copy(LocatorUtils.property(locator, "getestadostiendaseccionReturn", sourceGETESTADOSTIENDASECCIONReturn), sourceGETESTADOSTIENDASECCIONReturn, (this.getestadostiendaseccionReturn!= null)));
                    copy.setGETESTADOSTIENDASECCIONReturn(copyGETESTADOSTIENDASECCIONReturn);
                } else {
                    if (getestadostiendaseccionReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getestadostiendaseccionReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETESTADOSTIENDASECCIONResponse();
    }

}
