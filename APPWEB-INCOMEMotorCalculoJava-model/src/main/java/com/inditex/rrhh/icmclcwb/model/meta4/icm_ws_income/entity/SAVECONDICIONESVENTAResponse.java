
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
 *         &lt;element name="SAVECONDICIONESVENTAReturn" type="{http://schemas.meta4.com/}SavecondicionesventaOutput"/>
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
    "savecondicionesventaReturn"
})
@XmlRootElement(name = "SAVECONDICIONESVENTAResponse")
public class SAVECONDICIONESVENTAResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "SAVECONDICIONESVENTAReturn", required = true)
    protected SavecondicionesventaOutput savecondicionesventaReturn;

    /**
     * Obtiene el valor de la propiedad savecondicionesventaReturn.
     * 
     * @return
     *     possible object is
     *     {@link SavecondicionesventaOutput }
     *     
     */
    public SavecondicionesventaOutput getSAVECONDICIONESVENTAReturn() {
        return savecondicionesventaReturn;
    }

    /**
     * Define el valor de la propiedad savecondicionesventaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link SavecondicionesventaOutput }
     *     
     */
    public void setSAVECONDICIONESVENTAReturn(SavecondicionesventaOutput value) {
        this.savecondicionesventaReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SAVECONDICIONESVENTAResponse that = ((SAVECONDICIONESVENTAResponse) object);
        {
            SavecondicionesventaOutput lhsSAVECONDICIONESVENTAReturn;
            lhsSAVECONDICIONESVENTAReturn = this.getSAVECONDICIONESVENTAReturn();
            SavecondicionesventaOutput rhsSAVECONDICIONESVENTAReturn;
            rhsSAVECONDICIONESVENTAReturn = that.getSAVECONDICIONESVENTAReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "savecondicionesventaReturn", lhsSAVECONDICIONESVENTAReturn), LocatorUtils.property(thatLocator, "savecondicionesventaReturn", rhsSAVECONDICIONESVENTAReturn), lhsSAVECONDICIONESVENTAReturn, rhsSAVECONDICIONESVENTAReturn, (this.savecondicionesventaReturn!= null), (that.savecondicionesventaReturn!= null))) {
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
            SavecondicionesventaOutput theSAVECONDICIONESVENTAReturn;
            theSAVECONDICIONESVENTAReturn = this.getSAVECONDICIONESVENTAReturn();
            strategy.appendField(locator, this, "savecondicionesventaReturn", buffer, theSAVECONDICIONESVENTAReturn, (this.savecondicionesventaReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            SavecondicionesventaOutput theSAVECONDICIONESVENTAReturn;
            theSAVECONDICIONESVENTAReturn = this.getSAVECONDICIONESVENTAReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "savecondicionesventaReturn", theSAVECONDICIONESVENTAReturn), currentHashCode, theSAVECONDICIONESVENTAReturn, (this.savecondicionesventaReturn!= null));
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
        if (draftCopy instanceof SAVECONDICIONESVENTAResponse) {
            final SAVECONDICIONESVENTAResponse copy = ((SAVECONDICIONESVENTAResponse) draftCopy);
            {
                Boolean savecondicionesventaReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.savecondicionesventaReturn!= null));
                if (savecondicionesventaReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    SavecondicionesventaOutput sourceSAVECONDICIONESVENTAReturn;
                    sourceSAVECONDICIONESVENTAReturn = this.getSAVECONDICIONESVENTAReturn();
                    SavecondicionesventaOutput copySAVECONDICIONESVENTAReturn = ((SavecondicionesventaOutput) strategy.copy(LocatorUtils.property(locator, "savecondicionesventaReturn", sourceSAVECONDICIONESVENTAReturn), sourceSAVECONDICIONESVENTAReturn, (this.savecondicionesventaReturn!= null)));
                    copy.setSAVECONDICIONESVENTAReturn(copySAVECONDICIONESVENTAReturn);
                } else {
                    if (savecondicionesventaReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.savecondicionesventaReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SAVECONDICIONESVENTAResponse();
    }

}
