
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
 * <p>
 * Clase Java para anonymous complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
public class SINCRONIZACIONResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

    private final static long serialVersionUID = 1L;

    @XmlElement(name = "SINCRONIZACIONReturn", required = true)
    protected SincronizacionOutput sincronizacionReturn;

    /**
     * Obtiene el valor de la propiedad sincronizacionReturn.
     * @return possible object is {@link SincronizacionOutput }
     *
     */
    public SincronizacionOutput getSINCRONIZACIONReturn() {
        return this.sincronizacionReturn;
    }

    /**
     * Define el valor de la propiedad sincronizacionReturn.
     * @param value allowed object is {@link SincronizacionOutput }
     *
     */
    public void setSINCRONIZACIONReturn(final SincronizacionOutput value) {
        this.sincronizacionReturn = value;
    }

    @Override
    public boolean equals(final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object,
            final EqualsStrategy2 strategy) {
        if ((object == null) || (this.getClass() != object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SINCRONIZACIONResponse that = ((SINCRONIZACIONResponse) object);
        {
            final SincronizacionOutput lhsSINCRONIZACIONReturn;
            lhsSINCRONIZACIONReturn = this.getSINCRONIZACIONReturn();
            final SincronizacionOutput rhsSINCRONIZACIONReturn;
            rhsSINCRONIZACIONReturn = that.getSINCRONIZACIONReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sincronizacionReturn", lhsSINCRONIZACIONReturn),
                    LocatorUtils.property(thatLocator, "sincronizacionReturn", rhsSINCRONIZACIONReturn),
                    lhsSINCRONIZACIONReturn, rhsSINCRONIZACIONReturn, (this.sincronizacionReturn != null),
                    (that.sincronizacionReturn != null))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(final Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
        return this.equals(null, null, object, strategy);
    }

    @Override
    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
        final StringBuilder buffer = new StringBuilder();
        this.append(null, buffer, strategy);
        return buffer.toString();
    }

    @Override
    public StringBuilder append(final ObjectLocator locator, final StringBuilder buffer, final ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        this.appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    @Override
    public StringBuilder appendFields(final ObjectLocator locator, final StringBuilder buffer, final ToStringStrategy2 strategy) {
        {
            final SincronizacionOutput theSINCRONIZACIONReturn;
            theSINCRONIZACIONReturn = this.getSINCRONIZACIONReturn();
            strategy.appendField(locator, this, "sincronizacionReturn", buffer, theSINCRONIZACIONReturn,
                    (this.sincronizacionReturn != null));
        }
        return buffer;
    }

    @Override
    public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            final SincronizacionOutput theSINCRONIZACIONReturn;
            theSINCRONIZACIONReturn = this.getSINCRONIZACIONReturn();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "sincronizacionReturn", theSINCRONIZACIONReturn), currentHashCode,
                    theSINCRONIZACIONReturn, (this.sincronizacionReturn != null));
        }
        return currentHashCode;
    }

    @Override
    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
        return this.hashCode(null, strategy);
    }

    @Override
    public Object clone() {
        return this.copyTo(this.createNewInstance());
    }

    @Override
    public Object copyTo(final Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
        return this.copyTo(null, target, strategy);
    }

    @Override
    public Object copyTo(final ObjectLocator locator, final Object target, final CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null) ? this.createNewInstance() : target);
        if (draftCopy instanceof SINCRONIZACIONResponse) {
            final SINCRONIZACIONResponse copy = ((SINCRONIZACIONResponse) draftCopy);
            {
                final Boolean sincronizacionReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.sincronizacionReturn != null));
                if (sincronizacionReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    final SincronizacionOutput sourceSINCRONIZACIONReturn;
                    sourceSINCRONIZACIONReturn = this.getSINCRONIZACIONReturn();
                    final SincronizacionOutput copySINCRONIZACIONReturn = ((SincronizacionOutput) strategy.copy(
                            LocatorUtils.property(locator, "sincronizacionReturn", sourceSINCRONIZACIONReturn),
                            sourceSINCRONIZACIONReturn, (this.sincronizacionReturn != null)));
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

    @Override
    public Object createNewInstance() {
        return new SINCRONIZACIONResponse();
    }

}
