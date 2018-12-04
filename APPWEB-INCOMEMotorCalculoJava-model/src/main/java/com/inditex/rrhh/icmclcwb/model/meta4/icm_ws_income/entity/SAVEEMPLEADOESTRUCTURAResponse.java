
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
 *         &lt;element name="SAVEEMPLEADOESTRUCTURAReturn" type="{http://schemas.meta4.com/}SaveempleadoestructuraOutput"/>
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
    "saveempleadoestructuraReturn"
})
@XmlRootElement(name = "SAVEEMPLEADOESTRUCTURAResponse")
public class SAVEEMPLEADOESTRUCTURAResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "SAVEEMPLEADOESTRUCTURAReturn", required = true)
    protected SaveempleadoestructuraOutput saveempleadoestructuraReturn;

    /**
     * Obtiene el valor de la propiedad saveempleadoestructuraReturn.
     * 
     * @return
     *     possible object is
     *     {@link SaveempleadoestructuraOutput }
     *     
     */
    public SaveempleadoestructuraOutput getSAVEEMPLEADOESTRUCTURAReturn() {
        return saveempleadoestructuraReturn;
    }

    /**
     * Define el valor de la propiedad saveempleadoestructuraReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveempleadoestructuraOutput }
     *     
     */
    public void setSAVEEMPLEADOESTRUCTURAReturn(SaveempleadoestructuraOutput value) {
        this.saveempleadoestructuraReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SAVEEMPLEADOESTRUCTURAResponse that = ((SAVEEMPLEADOESTRUCTURAResponse) object);
        {
            SaveempleadoestructuraOutput lhsSAVEEMPLEADOESTRUCTURAReturn;
            lhsSAVEEMPLEADOESTRUCTURAReturn = this.getSAVEEMPLEADOESTRUCTURAReturn();
            SaveempleadoestructuraOutput rhsSAVEEMPLEADOESTRUCTURAReturn;
            rhsSAVEEMPLEADOESTRUCTURAReturn = that.getSAVEEMPLEADOESTRUCTURAReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "saveempleadoestructuraReturn", lhsSAVEEMPLEADOESTRUCTURAReturn), LocatorUtils.property(thatLocator, "saveempleadoestructuraReturn", rhsSAVEEMPLEADOESTRUCTURAReturn), lhsSAVEEMPLEADOESTRUCTURAReturn, rhsSAVEEMPLEADOESTRUCTURAReturn, (this.saveempleadoestructuraReturn!= null), (that.saveempleadoestructuraReturn!= null))) {
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
            SaveempleadoestructuraOutput theSAVEEMPLEADOESTRUCTURAReturn;
            theSAVEEMPLEADOESTRUCTURAReturn = this.getSAVEEMPLEADOESTRUCTURAReturn();
            strategy.appendField(locator, this, "saveempleadoestructuraReturn", buffer, theSAVEEMPLEADOESTRUCTURAReturn, (this.saveempleadoestructuraReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            SaveempleadoestructuraOutput theSAVEEMPLEADOESTRUCTURAReturn;
            theSAVEEMPLEADOESTRUCTURAReturn = this.getSAVEEMPLEADOESTRUCTURAReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saveempleadoestructuraReturn", theSAVEEMPLEADOESTRUCTURAReturn), currentHashCode, theSAVEEMPLEADOESTRUCTURAReturn, (this.saveempleadoestructuraReturn!= null));
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
        if (draftCopy instanceof SAVEEMPLEADOESTRUCTURAResponse) {
            final SAVEEMPLEADOESTRUCTURAResponse copy = ((SAVEEMPLEADOESTRUCTURAResponse) draftCopy);
            {
                Boolean saveempleadoestructuraReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.saveempleadoestructuraReturn!= null));
                if (saveempleadoestructuraReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    SaveempleadoestructuraOutput sourceSAVEEMPLEADOESTRUCTURAReturn;
                    sourceSAVEEMPLEADOESTRUCTURAReturn = this.getSAVEEMPLEADOESTRUCTURAReturn();
                    SaveempleadoestructuraOutput copySAVEEMPLEADOESTRUCTURAReturn = ((SaveempleadoestructuraOutput) strategy.copy(LocatorUtils.property(locator, "saveempleadoestructuraReturn", sourceSAVEEMPLEADOESTRUCTURAReturn), sourceSAVEEMPLEADOESTRUCTURAReturn, (this.saveempleadoestructuraReturn!= null)));
                    copy.setSAVEEMPLEADOESTRUCTURAReturn(copySAVEEMPLEADOESTRUCTURAReturn);
                } else {
                    if (saveempleadoestructuraReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.saveempleadoestructuraReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SAVEEMPLEADOESTRUCTURAResponse();
    }

}
