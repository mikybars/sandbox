
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
 *         &lt;element name="SAVEVENTAMANUALReturn" type="{http://schemas.meta4.com/}SaveventamanualOutput"/>
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
    "saveventamanualReturn"
})
@XmlRootElement(name = "SAVEVENTAMANUALResponse")
public class SAVEVENTAMANUALResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "SAVEVENTAMANUALReturn", required = true)
    protected SaveventamanualOutput saveventamanualReturn;

    /**
     * Obtiene el valor de la propiedad saveventamanualReturn.
     * 
     * @return
     *     possible object is
     *     {@link SaveventamanualOutput }
     *     
     */
    public SaveventamanualOutput getSAVEVENTAMANUALReturn() {
        return saveventamanualReturn;
    }

    /**
     * Define el valor de la propiedad saveventamanualReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveventamanualOutput }
     *     
     */
    public void setSAVEVENTAMANUALReturn(SaveventamanualOutput value) {
        this.saveventamanualReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SAVEVENTAMANUALResponse that = ((SAVEVENTAMANUALResponse) object);
        {
            SaveventamanualOutput lhsSAVEVENTAMANUALReturn;
            lhsSAVEVENTAMANUALReturn = this.getSAVEVENTAMANUALReturn();
            SaveventamanualOutput rhsSAVEVENTAMANUALReturn;
            rhsSAVEVENTAMANUALReturn = that.getSAVEVENTAMANUALReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "saveventamanualReturn", lhsSAVEVENTAMANUALReturn), LocatorUtils.property(thatLocator, "saveventamanualReturn", rhsSAVEVENTAMANUALReturn), lhsSAVEVENTAMANUALReturn, rhsSAVEVENTAMANUALReturn, (this.saveventamanualReturn!= null), (that.saveventamanualReturn!= null))) {
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
            SaveventamanualOutput theSAVEVENTAMANUALReturn;
            theSAVEVENTAMANUALReturn = this.getSAVEVENTAMANUALReturn();
            strategy.appendField(locator, this, "saveventamanualReturn", buffer, theSAVEVENTAMANUALReturn, (this.saveventamanualReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            SaveventamanualOutput theSAVEVENTAMANUALReturn;
            theSAVEVENTAMANUALReturn = this.getSAVEVENTAMANUALReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saveventamanualReturn", theSAVEVENTAMANUALReturn), currentHashCode, theSAVEVENTAMANUALReturn, (this.saveventamanualReturn!= null));
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
        if (draftCopy instanceof SAVEVENTAMANUALResponse) {
            final SAVEVENTAMANUALResponse copy = ((SAVEVENTAMANUALResponse) draftCopy);
            {
                Boolean saveventamanualReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.saveventamanualReturn!= null));
                if (saveventamanualReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    SaveventamanualOutput sourceSAVEVENTAMANUALReturn;
                    sourceSAVEVENTAMANUALReturn = this.getSAVEVENTAMANUALReturn();
                    SaveventamanualOutput copySAVEVENTAMANUALReturn = ((SaveventamanualOutput) strategy.copy(LocatorUtils.property(locator, "saveventamanualReturn", sourceSAVEVENTAMANUALReturn), sourceSAVEVENTAMANUALReturn, (this.saveventamanualReturn!= null)));
                    copy.setSAVEVENTAMANUALReturn(copySAVEVENTAMANUALReturn);
                } else {
                    if (saveventamanualReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.saveventamanualReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SAVEVENTAMANUALResponse();
    }

}
