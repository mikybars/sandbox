
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
 *         &lt;element name="SAVEPLANTILLACONDICIONESReturn" type="{http://schemas.meta4.com/}SaveplantillacondicionesOutput"/>
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
    "saveplantillacondicionesReturn"
})
@XmlRootElement(name = "SAVEPLANTILLACONDICIONESResponse")
public class SAVEPLANTILLACONDICIONESResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "SAVEPLANTILLACONDICIONESReturn", required = true)
    protected SaveplantillacondicionesOutput saveplantillacondicionesReturn;

    /**
     * Obtiene el valor de la propiedad saveplantillacondicionesReturn.
     * 
     * @return
     *     possible object is
     *     {@link SaveplantillacondicionesOutput }
     *     
     */
    public SaveplantillacondicionesOutput getSAVEPLANTILLACONDICIONESReturn() {
        return saveplantillacondicionesReturn;
    }

    /**
     * Define el valor de la propiedad saveplantillacondicionesReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link SaveplantillacondicionesOutput }
     *     
     */
    public void setSAVEPLANTILLACONDICIONESReturn(SaveplantillacondicionesOutput value) {
        this.saveplantillacondicionesReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SAVEPLANTILLACONDICIONESResponse that = ((SAVEPLANTILLACONDICIONESResponse) object);
        {
            SaveplantillacondicionesOutput lhsSAVEPLANTILLACONDICIONESReturn;
            lhsSAVEPLANTILLACONDICIONESReturn = this.getSAVEPLANTILLACONDICIONESReturn();
            SaveplantillacondicionesOutput rhsSAVEPLANTILLACONDICIONESReturn;
            rhsSAVEPLANTILLACONDICIONESReturn = that.getSAVEPLANTILLACONDICIONESReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "saveplantillacondicionesReturn", lhsSAVEPLANTILLACONDICIONESReturn), LocatorUtils.property(thatLocator, "saveplantillacondicionesReturn", rhsSAVEPLANTILLACONDICIONESReturn), lhsSAVEPLANTILLACONDICIONESReturn, rhsSAVEPLANTILLACONDICIONESReturn, (this.saveplantillacondicionesReturn!= null), (that.saveplantillacondicionesReturn!= null))) {
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
            SaveplantillacondicionesOutput theSAVEPLANTILLACONDICIONESReturn;
            theSAVEPLANTILLACONDICIONESReturn = this.getSAVEPLANTILLACONDICIONESReturn();
            strategy.appendField(locator, this, "saveplantillacondicionesReturn", buffer, theSAVEPLANTILLACONDICIONESReturn, (this.saveplantillacondicionesReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            SaveplantillacondicionesOutput theSAVEPLANTILLACONDICIONESReturn;
            theSAVEPLANTILLACONDICIONESReturn = this.getSAVEPLANTILLACONDICIONESReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saveplantillacondicionesReturn", theSAVEPLANTILLACONDICIONESReturn), currentHashCode, theSAVEPLANTILLACONDICIONESReturn, (this.saveplantillacondicionesReturn!= null));
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
        if (draftCopy instanceof SAVEPLANTILLACONDICIONESResponse) {
            final SAVEPLANTILLACONDICIONESResponse copy = ((SAVEPLANTILLACONDICIONESResponse) draftCopy);
            {
                Boolean saveplantillacondicionesReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.saveplantillacondicionesReturn!= null));
                if (saveplantillacondicionesReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    SaveplantillacondicionesOutput sourceSAVEPLANTILLACONDICIONESReturn;
                    sourceSAVEPLANTILLACONDICIONESReturn = this.getSAVEPLANTILLACONDICIONESReturn();
                    SaveplantillacondicionesOutput copySAVEPLANTILLACONDICIONESReturn = ((SaveplantillacondicionesOutput) strategy.copy(LocatorUtils.property(locator, "saveplantillacondicionesReturn", sourceSAVEPLANTILLACONDICIONESReturn), sourceSAVEPLANTILLACONDICIONESReturn, (this.saveplantillacondicionesReturn!= null)));
                    copy.setSAVEPLANTILLACONDICIONESReturn(copySAVEPLANTILLACONDICIONESReturn);
                } else {
                    if (saveplantillacondicionesReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.saveplantillacondicionesReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SAVEPLANTILLACONDICIONESResponse();
    }

}
