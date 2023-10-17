
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
 * <p>Java class for GetsistdestinoOutput complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GetsistdestinoOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}LogMessage" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Icm_Listasistdestino" type="{http://schemas.meta4.com/}Icm_ListasistdestinoBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetsistdestinoOutput", propOrder = {
    "_return",
    "logMessage",
    "icmListasistdestino"
})
public class GetsistdestinoOutput implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "return")
    protected double _return;
    @XmlElement(nillable = true)
    protected List<LogMessage> logMessage;
    @XmlElement(name = "Icm_Listasistdestino", required = true, nillable = true)
    protected IcmListasistdestinoBlock icmListasistdestino;

    /**
     * Gets the value of the return property.
     *
     */
    public double getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     *
     */
    public void setReturn(double value) {
        this._return = value;
    }

    /**
     * Gets the value of the logMessage property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessage property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessage().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessage }
     *
     *
     */
    public List<LogMessage> getLogMessage() {
        if (logMessage == null) {
            logMessage = new ArrayList<LogMessage>();
        }
        return this.logMessage;
    }

    /**
     * Gets the value of the icmListasistdestino property.
     *
     * @return
     *     possible object is
     *     {@link IcmListasistdestinoBlock }
     *
     */
    public IcmListasistdestinoBlock getIcmListasistdestino() {
        return icmListasistdestino;
    }

    /**
     * Sets the value of the icmListasistdestino property.
     *
     * @param value
     *     allowed object is
     *     {@link IcmListasistdestinoBlock }
     *
     */
    public void setIcmListasistdestino(IcmListasistdestinoBlock value) {
        this.icmListasistdestino = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetsistdestinoOutput that = ((GetsistdestinoOutput) object);
        {
            double lhsReturn;
            lhsReturn = this.getReturn();
            double rhsReturn;
            rhsReturn = that.getReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "_return", lhsReturn), LocatorUtils.property(thatLocator, "_return", rhsReturn), lhsReturn, rhsReturn, true, true)) {
                return false;
            }
        }
        {
            List<LogMessage> lhsLogMessage;
            lhsLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
            List<LogMessage> rhsLogMessage;
            rhsLogMessage = (((that.logMessage!= null)&&(!that.logMessage.isEmpty()))?that.getLogMessage():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "logMessage", lhsLogMessage), LocatorUtils.property(thatLocator, "logMessage", rhsLogMessage), lhsLogMessage, rhsLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())), ((that.logMessage!= null)&&(!that.logMessage.isEmpty())))) {
                return false;
            }
        }
        {
            IcmListasistdestinoBlock lhsIcmListasistdestino;
            lhsIcmListasistdestino = this.getIcmListasistdestino();
            IcmListasistdestinoBlock rhsIcmListasistdestino;
            rhsIcmListasistdestino = that.getIcmListasistdestino();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListasistdestino", lhsIcmListasistdestino), LocatorUtils.property(thatLocator, "icmListasistdestino", rhsIcmListasistdestino), lhsIcmListasistdestino, rhsIcmListasistdestino, (this.icmListasistdestino!= null), (that.icmListasistdestino!= null))) {
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
            double theReturn;
            theReturn = this.getReturn();
            strategy.appendField(locator, this, "_return", buffer, theReturn, true);
        }
        {
            List<LogMessage> theLogMessage;
            theLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
            strategy.appendField(locator, this, "logMessage", buffer, theLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())));
        }
        {
            IcmListasistdestinoBlock theIcmListasistdestino;
            theIcmListasistdestino = this.getIcmListasistdestino();
            strategy.appendField(locator, this, "icmListasistdestino", buffer, theIcmListasistdestino, (this.icmListasistdestino!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            double theReturn;
            theReturn = this.getReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "_return", theReturn), currentHashCode, theReturn, true);
        }
        {
            List<LogMessage> theLogMessage;
            theLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "logMessage", theLogMessage), currentHashCode, theLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())));
        }
        {
            IcmListasistdestinoBlock theIcmListasistdestino;
            theIcmListasistdestino = this.getIcmListasistdestino();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListasistdestino", theIcmListasistdestino), currentHashCode, theIcmListasistdestino, (this.icmListasistdestino!= null));
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
        if (draftCopy instanceof GetsistdestinoOutput) {
            final GetsistdestinoOutput copy = ((GetsistdestinoOutput) draftCopy);
            {
                Boolean _returnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, true);
                if (_returnShouldBeCopiedAndSet == Boolean.TRUE) {
                    double sourceReturn;
                    sourceReturn = this.getReturn();
                    double copyReturn = strategy.copy(LocatorUtils.property(locator, "_return", sourceReturn), sourceReturn, true);
                    copy.setReturn(copyReturn);
                } else {
                    if (_returnShouldBeCopiedAndSet == Boolean.FALSE) {
                    }
                }
            }
            {
                Boolean logMessageShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.logMessage!= null)&&(!this.logMessage.isEmpty())));
                if (logMessageShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<LogMessage> sourceLogMessage;
                    sourceLogMessage = (((this.logMessage!= null)&&(!this.logMessage.isEmpty()))?this.getLogMessage():null);
                    @SuppressWarnings("unchecked")
                    List<LogMessage> copyLogMessage = ((List<LogMessage> ) strategy.copy(LocatorUtils.property(locator, "logMessage", sourceLogMessage), sourceLogMessage, ((this.logMessage!= null)&&(!this.logMessage.isEmpty()))));
                    copy.logMessage = null;
                    if (copyLogMessage!= null) {
                        List<LogMessage> uniqueLogMessagel = copy.getLogMessage();
                        uniqueLogMessagel.addAll(copyLogMessage);
                    }
                } else {
                    if (logMessageShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.logMessage = null;
                    }
                }
            }
            {
                Boolean icmListasistdestinoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmListasistdestino!= null));
                if (icmListasistdestinoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmListasistdestinoBlock sourceIcmListasistdestino;
                    sourceIcmListasistdestino = this.getIcmListasistdestino();
                    IcmListasistdestinoBlock copyIcmListasistdestino = ((IcmListasistdestinoBlock) strategy.copy(LocatorUtils.property(locator, "icmListasistdestino", sourceIcmListasistdestino), sourceIcmListasistdestino, (this.icmListasistdestino!= null)));
                    copy.setIcmListasistdestino(copyIcmListasistdestino);
                } else {
                    if (icmListasistdestinoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListasistdestino = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new GetsistdestinoOutput();
    }

}
