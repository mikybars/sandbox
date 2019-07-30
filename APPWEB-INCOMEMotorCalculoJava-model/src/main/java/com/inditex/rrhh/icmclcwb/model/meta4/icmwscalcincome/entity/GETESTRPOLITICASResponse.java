
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
 *         &lt;element name="GETESTRPOLITICASReturn" type="{http://schemas.meta4.com/}GetestrpoliticasOutput"/>
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
    "getestrpoliticasReturn"
})
@XmlRootElement(name = "GETESTRPOLITICASResponse")
public class GETESTRPOLITICASResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "GETESTRPOLITICASReturn", required = true)
    protected GetestrpoliticasOutput getestrpoliticasReturn;

    /**
     * Obtiene el valor de la propiedad getestrpoliticasReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetestrpoliticasOutput }
     *     
     */
    public GetestrpoliticasOutput getGETESTRPOLITICASReturn() {
        return getestrpoliticasReturn;
    }

    /**
     * Define el valor de la propiedad getestrpoliticasReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetestrpoliticasOutput }
     *     
     */
    public void setGETESTRPOLITICASReturn(GetestrpoliticasOutput value) {
        this.getestrpoliticasReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GETESTRPOLITICASResponse that = ((GETESTRPOLITICASResponse) object);
        {
            GetestrpoliticasOutput lhsGETESTRPOLITICASReturn;
            lhsGETESTRPOLITICASReturn = this.getGETESTRPOLITICASReturn();
            GetestrpoliticasOutput rhsGETESTRPOLITICASReturn;
            rhsGETESTRPOLITICASReturn = that.getGETESTRPOLITICASReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "getestrpoliticasReturn", lhsGETESTRPOLITICASReturn), LocatorUtils.property(thatLocator, "getestrpoliticasReturn", rhsGETESTRPOLITICASReturn), lhsGETESTRPOLITICASReturn, rhsGETESTRPOLITICASReturn, (this.getestrpoliticasReturn!= null), (that.getestrpoliticasReturn!= null))) {
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
            GetestrpoliticasOutput theGETESTRPOLITICASReturn;
            theGETESTRPOLITICASReturn = this.getGETESTRPOLITICASReturn();
            strategy.appendField(locator, this, "getestrpoliticasReturn", buffer, theGETESTRPOLITICASReturn, (this.getestrpoliticasReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            GetestrpoliticasOutput theGETESTRPOLITICASReturn;
            theGETESTRPOLITICASReturn = this.getGETESTRPOLITICASReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "getestrpoliticasReturn", theGETESTRPOLITICASReturn), currentHashCode, theGETESTRPOLITICASReturn, (this.getestrpoliticasReturn!= null));
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
        if (draftCopy instanceof GETESTRPOLITICASResponse) {
            final GETESTRPOLITICASResponse copy = ((GETESTRPOLITICASResponse) draftCopy);
            {
                Boolean getestrpoliticasReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.getestrpoliticasReturn!= null));
                if (getestrpoliticasReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    GetestrpoliticasOutput sourceGETESTRPOLITICASReturn;
                    sourceGETESTRPOLITICASReturn = this.getGETESTRPOLITICASReturn();
                    GetestrpoliticasOutput copyGETESTRPOLITICASReturn = ((GetestrpoliticasOutput) strategy.copy(LocatorUtils.property(locator, "getestrpoliticasReturn", sourceGETESTRPOLITICASReturn), sourceGETESTRPOLITICASReturn, (this.getestrpoliticasReturn!= null)));
                    copy.setGETESTRPOLITICASReturn(copyGETESTRPOLITICASReturn);
                } else {
                    if (getestrpoliticasReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.getestrpoliticasReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GETESTRPOLITICASResponse();
    }

}
