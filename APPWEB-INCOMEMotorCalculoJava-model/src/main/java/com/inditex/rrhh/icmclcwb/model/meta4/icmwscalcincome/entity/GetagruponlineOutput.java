
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * Clase Java para GetagruponlineOutput complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="GetagruponlineOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}LogMessage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Icm_Listaconfiguracion" type="{http://schemas.meta4.com/}Icm_ListaconfiguracionBlock"/&gt;
 *         &lt;element name="Icm_Parametrospaginacion" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetagruponlineOutput", propOrder = {
        "_return",
        "logMessage",
        "icmListaconfiguracion",
        "icmParametrospaginacion"
})
public class GetagruponlineOutput implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

    private final static long serialVersionUID = 1L;

    @XmlElement(name = "return")
    protected double _return;

    @XmlElement(nillable = true)
    protected List<LogMessage> logMessage;

    @XmlElement(name = "Icm_Listaconfiguracion", required = true, nillable = true)
    protected IcmListaconfiguracionBlock icmListaconfiguracion;

    @XmlElement(name = "Icm_Parametrospaginacion", required = true, nillable = true)
    protected IcmParametrospaginacionBlock icmParametrospaginacion;

    /**
     * Obtiene el valor de la propiedad return.
     *
     */
    public double getReturn() {
        return this._return;
    }

    /**
     * Define el valor de la propiedad return.
     *
     */
    public void setReturn(final double value) {
        this._return = value;
    }

    /**
     * Gets the value of the logMessage property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is why
     * there is not a <CODE>set</CODE> method for the logMessage property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getLogMessage().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link LogMessage }
     *
     *
     */
    public List<LogMessage> getLogMessage() {
        if (this.logMessage == null) {
            this.logMessage = new ArrayList<LogMessage>();
        }
        return this.logMessage;
    }

    /**
     * Obtiene el valor de la propiedad icmListaconfiguracion.
     * @return possible object is {@link IcmListaconfiguracionBlock }
     *
     */
    public IcmListaconfiguracionBlock getIcmListaconfiguracion() {
        return this.icmListaconfiguracion;
    }

    /**
     * Define el valor de la propiedad icmListaconfiguracion.
     * @param value allowed object is {@link IcmListaconfiguracionBlock }
     *
     */
    public void setIcmListaconfiguracion(final IcmListaconfiguracionBlock value) {
        this.icmListaconfiguracion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrospaginacion.
     * @return possible object is {@link IcmParametrospaginacionBlock }
     *
     */
    public IcmParametrospaginacionBlock getIcmParametrospaginacion() {
        return this.icmParametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmParametrospaginacion.
     * @param value allowed object is {@link IcmParametrospaginacionBlock }
     *
     */
    public void setIcmParametrospaginacion(final IcmParametrospaginacionBlock value) {
        this.icmParametrospaginacion = value;
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
        final GetagruponlineOutput that = ((GetagruponlineOutput) object);
        {
            final double lhsReturn;
            lhsReturn = this.getReturn();
            final double rhsReturn;
            rhsReturn = that.getReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "_return", lhsReturn),
                    LocatorUtils.property(thatLocator, "_return", rhsReturn), lhsReturn, rhsReturn, true, true)) {
                return false;
            }
        }
        {
            final List<LogMessage> lhsLogMessage;
            lhsLogMessage = (((this.logMessage != null) && (!this.logMessage.isEmpty())) ? this.getLogMessage() : null);
            final List<LogMessage> rhsLogMessage;
            rhsLogMessage = (((that.logMessage != null) && (!that.logMessage.isEmpty())) ? that.getLogMessage() : null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "logMessage", lhsLogMessage),
                    LocatorUtils.property(thatLocator, "logMessage", rhsLogMessage), lhsLogMessage, rhsLogMessage,
                    ((this.logMessage != null) && (!this.logMessage.isEmpty())),
                    ((that.logMessage != null) && (!that.logMessage.isEmpty())))) {
                return false;
            }
        }
        {
            final IcmListaconfiguracionBlock lhsIcmListaconfiguracion;
            lhsIcmListaconfiguracion = this.getIcmListaconfiguracion();
            final IcmListaconfiguracionBlock rhsIcmListaconfiguracion;
            rhsIcmListaconfiguracion = that.getIcmListaconfiguracion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconfiguracion", lhsIcmListaconfiguracion),
                    LocatorUtils.property(thatLocator, "icmListaconfiguracion", rhsIcmListaconfiguracion),
                    lhsIcmListaconfiguracion, rhsIcmListaconfiguracion, (this.icmListaconfiguracion != null),
                    (that.icmListaconfiguracion != null))) {
                return false;
            }
        }
        {
            final IcmParametrospaginacionBlock lhsIcmParametrospaginacion;
            lhsIcmParametrospaginacion = this.getIcmParametrospaginacion();
            final IcmParametrospaginacionBlock rhsIcmParametrospaginacion;
            rhsIcmParametrospaginacion = that.getIcmParametrospaginacion();
            if (!strategy.equals(
                    LocatorUtils.property(thisLocator, "icmParametrospaginacion", lhsIcmParametrospaginacion),
                    LocatorUtils.property(thatLocator, "icmParametrospaginacion", rhsIcmParametrospaginacion),
                    lhsIcmParametrospaginacion, rhsIcmParametrospaginacion, (this.icmParametrospaginacion != null),
                    (that.icmParametrospaginacion != null))) {
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
            final double theReturn;
            theReturn = this.getReturn();
            strategy.appendField(locator, this, "_return", buffer, theReturn, true);
        }
        {
            final List<LogMessage> theLogMessage;
            theLogMessage = (((this.logMessage != null) && (!this.logMessage.isEmpty())) ? this.getLogMessage() : null);
            strategy.appendField(locator, this, "logMessage", buffer, theLogMessage,
                    ((this.logMessage != null) && (!this.logMessage.isEmpty())));
        }
        {
            final IcmListaconfiguracionBlock theIcmListaconfiguracion;
            theIcmListaconfiguracion = this.getIcmListaconfiguracion();
            strategy.appendField(locator, this, "icmListaconfiguracion", buffer, theIcmListaconfiguracion,
                    (this.icmListaconfiguracion != null));
        }
        {
            final IcmParametrospaginacionBlock theIcmParametrospaginacion;
            theIcmParametrospaginacion = this.getIcmParametrospaginacion();
            strategy.appendField(locator, this, "icmParametrospaginacion", buffer, theIcmParametrospaginacion,
                    (this.icmParametrospaginacion != null));
        }
        return buffer;
    }

    @Override
    public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            final double theReturn;
            theReturn = this.getReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "_return", theReturn), currentHashCode,
                    theReturn, true);
        }
        {
            final List<LogMessage> theLogMessage;
            theLogMessage = (((this.logMessage != null) && (!this.logMessage.isEmpty())) ? this.getLogMessage() : null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "logMessage", theLogMessage),
                    currentHashCode, theLogMessage, ((this.logMessage != null) && (!this.logMessage.isEmpty())));
        }
        {
            final IcmListaconfiguracionBlock theIcmListaconfiguracion;
            theIcmListaconfiguracion = this.getIcmListaconfiguracion();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmListaconfiguracion", theIcmListaconfiguracion), currentHashCode,
                    theIcmListaconfiguracion, (this.icmListaconfiguracion != null));
        }
        {
            final IcmParametrospaginacionBlock theIcmParametrospaginacion;
            theIcmParametrospaginacion = this.getIcmParametrospaginacion();
            currentHashCode = strategy.hashCode(
                    LocatorUtils.property(locator, "icmParametrospaginacion", theIcmParametrospaginacion),
                    currentHashCode, theIcmParametrospaginacion, (this.icmParametrospaginacion != null));
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
        if (draftCopy instanceof GetagruponlineOutput) {
            final GetagruponlineOutput copy = ((GetagruponlineOutput) draftCopy);
            {
                final Boolean _returnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, true);
                if (_returnShouldBeCopiedAndSet == Boolean.TRUE) {
                    final double sourceReturn;
                    sourceReturn = this.getReturn();
                    final double copyReturn = strategy.copy(LocatorUtils.property(locator, "_return", sourceReturn),
                            sourceReturn, true);
                    copy.setReturn(copyReturn);
                } else {
                    if (_returnShouldBeCopiedAndSet == Boolean.FALSE) {
                    }
                }
            }
            {
                final Boolean logMessageShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        ((this.logMessage != null) && (!this.logMessage.isEmpty())));
                if (logMessageShouldBeCopiedAndSet == Boolean.TRUE) {
                    final List<LogMessage> sourceLogMessage;
                    sourceLogMessage = (((this.logMessage != null) && (!this.logMessage.isEmpty()))
                            ? this.getLogMessage() : null);
                    @SuppressWarnings("unchecked") final List<LogMessage> copyLogMessage = ((List<LogMessage>) strategy.copy(
                            LocatorUtils.property(locator, "logMessage", sourceLogMessage), sourceLogMessage,
                            ((this.logMessage != null) && (!this.logMessage.isEmpty()))));
                    copy.logMessage = null;
                    if (copyLogMessage != null) {
                        final List<LogMessage> uniqueLogMessagel = copy.getLogMessage();
                        uniqueLogMessagel.addAll(copyLogMessage);
                    }
                } else {
                    if (logMessageShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.logMessage = null;
                    }
                }
            }
            {
                final Boolean icmListaconfiguracionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmListaconfiguracion != null));
                if (icmListaconfiguracionShouldBeCopiedAndSet == Boolean.TRUE) {
                    final IcmListaconfiguracionBlock sourceIcmListaconfiguracion;
                    sourceIcmListaconfiguracion = this.getIcmListaconfiguracion();
                    final IcmListaconfiguracionBlock copyIcmListaconfiguracion = ((IcmListaconfiguracionBlock) strategy.copy(
                            LocatorUtils.property(locator, "icmListaconfiguracion", sourceIcmListaconfiguracion),
                            sourceIcmListaconfiguracion, (this.icmListaconfiguracion != null)));
                    copy.setIcmListaconfiguracion(copyIcmListaconfiguracion);
                } else {
                    if (icmListaconfiguracionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaconfiguracion = null;
                    }
                }
            }
            {
                final Boolean icmParametrospaginacionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
                        (this.icmParametrospaginacion != null));
                if (icmParametrospaginacionShouldBeCopiedAndSet == Boolean.TRUE) {
                    final IcmParametrospaginacionBlock sourceIcmParametrospaginacion;
                    sourceIcmParametrospaginacion = this.getIcmParametrospaginacion();
                    final IcmParametrospaginacionBlock copyIcmParametrospaginacion = ((IcmParametrospaginacionBlock) strategy
                        .copy(LocatorUtils.property(locator, "icmParametrospaginacion", sourceIcmParametrospaginacion),
                                sourceIcmParametrospaginacion, (this.icmParametrospaginacion != null)));
                    copy.setIcmParametrospaginacion(copyIcmParametrospaginacion);
                } else {
                    if (icmParametrospaginacionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrospaginacion = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    @Override
    public Object createNewInstance() {
        return new GetagruponlineOutput();
    }

}
