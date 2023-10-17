
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
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SEARCHEMPLEADOSReturn" type="{http://schemas.meta4.com/}SearchempleadosOutput"/&gt;
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
    "searchempleadosReturn"
})
@XmlRootElement(name = "SEARCHEMPLEADOSResponse")
public class SEARCHEMPLEADOSResponse implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "SEARCHEMPLEADOSReturn", required = true)
    protected SearchempleadosOutput searchempleadosReturn;

    /**
     * Gets the value of the searchempleadosReturn property.
     *
     * @return
     *     possible object is
     *     {@link SearchempleadosOutput }
     *
     */
    public SearchempleadosOutput getSEARCHEMPLEADOSReturn() {
        return searchempleadosReturn;
    }

    /**
     * Sets the value of the searchempleadosReturn property.
     *
     * @param value
     *     allowed object is
     *     {@link SearchempleadosOutput }
     *
     */
    public void setSEARCHEMPLEADOSReturn(SearchempleadosOutput value) {
        this.searchempleadosReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SEARCHEMPLEADOSResponse that = ((SEARCHEMPLEADOSResponse) object);
        {
            SearchempleadosOutput lhsSEARCHEMPLEADOSReturn;
            lhsSEARCHEMPLEADOSReturn = this.getSEARCHEMPLEADOSReturn();
            SearchempleadosOutput rhsSEARCHEMPLEADOSReturn;
            rhsSEARCHEMPLEADOSReturn = that.getSEARCHEMPLEADOSReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "searchempleadosReturn", lhsSEARCHEMPLEADOSReturn), LocatorUtils.property(thatLocator, "searchempleadosReturn", rhsSEARCHEMPLEADOSReturn), lhsSEARCHEMPLEADOSReturn, rhsSEARCHEMPLEADOSReturn, (this.searchempleadosReturn!= null), (that.searchempleadosReturn!= null))) {
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
            SearchempleadosOutput theSEARCHEMPLEADOSReturn;
            theSEARCHEMPLEADOSReturn = this.getSEARCHEMPLEADOSReturn();
            strategy.appendField(locator, this, "searchempleadosReturn", buffer, theSEARCHEMPLEADOSReturn, (this.searchempleadosReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            SearchempleadosOutput theSEARCHEMPLEADOSReturn;
            theSEARCHEMPLEADOSReturn = this.getSEARCHEMPLEADOSReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "searchempleadosReturn", theSEARCHEMPLEADOSReturn), currentHashCode, theSEARCHEMPLEADOSReturn, (this.searchempleadosReturn!= null));
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
        if (draftCopy instanceof SEARCHEMPLEADOSResponse) {
            final SEARCHEMPLEADOSResponse copy = ((SEARCHEMPLEADOSResponse) draftCopy);
            {
                Boolean searchempleadosReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.searchempleadosReturn!= null));
                if (searchempleadosReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    SearchempleadosOutput sourceSEARCHEMPLEADOSReturn;
                    sourceSEARCHEMPLEADOSReturn = this.getSEARCHEMPLEADOSReturn();
                    SearchempleadosOutput copySEARCHEMPLEADOSReturn = ((SearchempleadosOutput) strategy.copy(LocatorUtils.property(locator, "searchempleadosReturn", sourceSEARCHEMPLEADOSReturn), sourceSEARCHEMPLEADOSReturn, (this.searchempleadosReturn!= null)));
                    copy.setSEARCHEMPLEADOSReturn(copySEARCHEMPLEADOSReturn);
                } else {
                    if (searchempleadosReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.searchempleadosReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SEARCHEMPLEADOSResponse();
    }

}
