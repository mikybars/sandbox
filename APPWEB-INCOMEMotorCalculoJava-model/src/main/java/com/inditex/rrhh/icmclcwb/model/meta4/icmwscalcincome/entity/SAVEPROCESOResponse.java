
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SAVEPROCESOReturn" type="{http://schemas.meta4.com/}SaveprocesoOutput"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "saveprocesoReturn"
})
@XmlRootElement(name = "SAVEPROCESOResponse")
public class SAVEPROCESOResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "SAVEPROCESOReturn", required = true)
    protected SaveprocesoOutput saveprocesoReturn;

    /**
     * Obtiene el valor de la propiedad saveprocesoReturn.
     *
     * @return
     *     possible object is
     *     {@link SaveprocesoOutput }
     *
     */
    public SaveprocesoOutput getSAVEPROCESOReturn() {
        return saveprocesoReturn;
    }

    /**
     * Define el valor de la propiedad saveprocesoReturn.
     *
     * @param value
     *     allowed object is
     *     {@link SaveprocesoOutput }
     *
     */
    public void setSAVEPROCESOReturn(SaveprocesoOutput value) {
        this.saveprocesoReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SAVEPROCESOResponse that = ((SAVEPROCESOResponse) object);
        {
            SaveprocesoOutput lhsSAVEPROCESOReturn;
            lhsSAVEPROCESOReturn = this.getSAVEPROCESOReturn();
            SaveprocesoOutput rhsSAVEPROCESOReturn;
            rhsSAVEPROCESOReturn = that.getSAVEPROCESOReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "saveprocesoReturn", lhsSAVEPROCESOReturn), LocatorUtils.property(thatLocator, "saveprocesoReturn", rhsSAVEPROCESOReturn), lhsSAVEPROCESOReturn, rhsSAVEPROCESOReturn, (this.saveprocesoReturn!= null), (that.saveprocesoReturn!= null))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
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
            SaveprocesoOutput theSAVEPROCESOReturn;
            theSAVEPROCESOReturn = this.getSAVEPROCESOReturn();
            strategy.appendField(locator, this, "saveprocesoReturn", buffer, theSAVEPROCESOReturn, (this.saveprocesoReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            SaveprocesoOutput theSAVEPROCESOReturn;
            theSAVEPROCESOReturn = this.getSAVEPROCESOReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saveprocesoReturn", theSAVEPROCESOReturn), currentHashCode, theSAVEPROCESOReturn, (this.saveprocesoReturn!= null));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof SAVEPROCESOResponse) {
            final SAVEPROCESOResponse copy = ((SAVEPROCESOResponse) draftCopy);
            {
                Boolean saveprocesoReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.saveprocesoReturn!= null));
                if (saveprocesoReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    SaveprocesoOutput sourceSAVEPROCESOReturn;
                    sourceSAVEPROCESOReturn = this.getSAVEPROCESOReturn();
                    SaveprocesoOutput copySAVEPROCESOReturn = ((SaveprocesoOutput) strategy.copy(LocatorUtils.property(locator, "saveprocesoReturn", sourceSAVEPROCESOReturn), sourceSAVEPROCESOReturn, (this.saveprocesoReturn!= null)));
                    copy.setSAVEPROCESOReturn(copySAVEPROCESOReturn);
                } else {
                    if (saveprocesoReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.saveprocesoReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SAVEPROCESOResponse();
    }

}
