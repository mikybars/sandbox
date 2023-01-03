
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
 *         &lt;element name="SINCRONIZACIONReturn" type="{http://schemas.meta4.com/}SincronizacionOutput"/&gt;
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
    "sincronizacionReturn"
})
@XmlRootElement(name = "SINCRONIZACIONResponse")
public class SINCRONIZACIONResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "SINCRONIZACIONReturn", required = true)
    protected SincronizacionOutput sincronizacionReturn;

    /**
     * Obtiene el valor de la propiedad sincronizacionReturn.
     *
     * @return
     *     possible object is
     *     {@link SincronizacionOutput }
     *
     */
    public SincronizacionOutput getSINCRONIZACIONReturn() {
        return sincronizacionReturn;
    }

    /**
     * Define el valor de la propiedad sincronizacionReturn.
     *
     * @param value
     *     allowed object is
     *     {@link SincronizacionOutput }
     *
     */
    public void setSINCRONIZACIONReturn(SincronizacionOutput value) {
        this.sincronizacionReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SINCRONIZACIONResponse that = ((SINCRONIZACIONResponse) object);
        {
            SincronizacionOutput lhsSINCRONIZACIONReturn;
            lhsSINCRONIZACIONReturn = this.getSINCRONIZACIONReturn();
            SincronizacionOutput rhsSINCRONIZACIONReturn;
            rhsSINCRONIZACIONReturn = that.getSINCRONIZACIONReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sincronizacionReturn", lhsSINCRONIZACIONReturn), LocatorUtils.property(thatLocator, "sincronizacionReturn", rhsSINCRONIZACIONReturn), lhsSINCRONIZACIONReturn, rhsSINCRONIZACIONReturn, (this.sincronizacionReturn!= null), (that.sincronizacionReturn!= null))) {
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
            SincronizacionOutput theSINCRONIZACIONReturn;
            theSINCRONIZACIONReturn = this.getSINCRONIZACIONReturn();
            strategy.appendField(locator, this, "sincronizacionReturn", buffer, theSINCRONIZACIONReturn, (this.sincronizacionReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            SincronizacionOutput theSINCRONIZACIONReturn;
            theSINCRONIZACIONReturn = this.getSINCRONIZACIONReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sincronizacionReturn", theSINCRONIZACIONReturn), currentHashCode, theSINCRONIZACIONReturn, (this.sincronizacionReturn!= null));
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
        if (draftCopy instanceof SINCRONIZACIONResponse) {
            final SINCRONIZACIONResponse copy = ((SINCRONIZACIONResponse) draftCopy);
            {
                Boolean sincronizacionReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.sincronizacionReturn!= null));
                if (sincronizacionReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    SincronizacionOutput sourceSINCRONIZACIONReturn;
                    sourceSINCRONIZACIONReturn = this.getSINCRONIZACIONReturn();
                    SincronizacionOutput copySINCRONIZACIONReturn = ((SincronizacionOutput) strategy.copy(LocatorUtils.property(locator, "sincronizacionReturn", sourceSINCRONIZACIONReturn), sourceSINCRONIZACIONReturn, (this.sincronizacionReturn!= null)));
                    copy.setSINCRONIZACIONReturn(copySINCRONIZACIONReturn);
                } else {
                    if (sincronizacionReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.sincronizacionReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SINCRONIZACIONResponse();
    }

}
