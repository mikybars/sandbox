
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
 *         &lt;element name="SAVEVALORESCONDICIONESReturn" type="{http://schemas.meta4.com/}SavevalorescondicionesOutput"/>
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
    "savevalorescondicionesReturn"
})
@XmlRootElement(name = "SAVEVALORESCONDICIONESResponse")
public class SAVEVALORESCONDICIONESResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "SAVEVALORESCONDICIONESReturn", required = true)
    protected SavevalorescondicionesOutput savevalorescondicionesReturn;

    /**
     * Obtiene el valor de la propiedad savevalorescondicionesReturn.
     * 
     * @return
     *     possible object is
     *     {@link SavevalorescondicionesOutput }
     *     
     */
    public SavevalorescondicionesOutput getSAVEVALORESCONDICIONESReturn() {
        return savevalorescondicionesReturn;
    }

    /**
     * Define el valor de la propiedad savevalorescondicionesReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link SavevalorescondicionesOutput }
     *     
     */
    public void setSAVEVALORESCONDICIONESReturn(SavevalorescondicionesOutput value) {
        this.savevalorescondicionesReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SAVEVALORESCONDICIONESResponse that = ((SAVEVALORESCONDICIONESResponse) object);
        {
            SavevalorescondicionesOutput lhsSAVEVALORESCONDICIONESReturn;
            lhsSAVEVALORESCONDICIONESReturn = this.getSAVEVALORESCONDICIONESReturn();
            SavevalorescondicionesOutput rhsSAVEVALORESCONDICIONESReturn;
            rhsSAVEVALORESCONDICIONESReturn = that.getSAVEVALORESCONDICIONESReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "savevalorescondicionesReturn", lhsSAVEVALORESCONDICIONESReturn), LocatorUtils.property(thatLocator, "savevalorescondicionesReturn", rhsSAVEVALORESCONDICIONESReturn), lhsSAVEVALORESCONDICIONESReturn, rhsSAVEVALORESCONDICIONESReturn, (this.savevalorescondicionesReturn!= null), (that.savevalorescondicionesReturn!= null))) {
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
            SavevalorescondicionesOutput theSAVEVALORESCONDICIONESReturn;
            theSAVEVALORESCONDICIONESReturn = this.getSAVEVALORESCONDICIONESReturn();
            strategy.appendField(locator, this, "savevalorescondicionesReturn", buffer, theSAVEVALORESCONDICIONESReturn, (this.savevalorescondicionesReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            SavevalorescondicionesOutput theSAVEVALORESCONDICIONESReturn;
            theSAVEVALORESCONDICIONESReturn = this.getSAVEVALORESCONDICIONESReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "savevalorescondicionesReturn", theSAVEVALORESCONDICIONESReturn), currentHashCode, theSAVEVALORESCONDICIONESReturn, (this.savevalorescondicionesReturn!= null));
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
        if (draftCopy instanceof SAVEVALORESCONDICIONESResponse) {
            final SAVEVALORESCONDICIONESResponse copy = ((SAVEVALORESCONDICIONESResponse) draftCopy);
            {
                Boolean savevalorescondicionesReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.savevalorescondicionesReturn!= null));
                if (savevalorescondicionesReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    SavevalorescondicionesOutput sourceSAVEVALORESCONDICIONESReturn;
                    sourceSAVEVALORESCONDICIONESReturn = this.getSAVEVALORESCONDICIONESReturn();
                    SavevalorescondicionesOutput copySAVEVALORESCONDICIONESReturn = ((SavevalorescondicionesOutput) strategy.copy(LocatorUtils.property(locator, "savevalorescondicionesReturn", sourceSAVEVALORESCONDICIONESReturn), sourceSAVEVALORESCONDICIONESReturn, (this.savevalorescondicionesReturn!= null)));
                    copy.setSAVEVALORESCONDICIONESReturn(copySAVEVALORESCONDICIONESReturn);
                } else {
                    if (savevalorescondicionesReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.savevalorescondicionesReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SAVEVALORESCONDICIONESResponse();
    }

}
