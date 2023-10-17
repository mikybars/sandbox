
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
 * <p>Java class for Icm_ListacondicionesbaseBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListacondicionesbaseBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ListacondicionesbaseRecordSet" type="{http://schemas.meta4.com/}Icm_ListacondicionesbaseRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListacondicionesbaseBlock", propOrder = {
    "idestructura",
    "icmListacondicionesbaseRecordSet"
})
public class IcmListacondicionesbaseBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(name = "Icm_ListacondicionesbaseRecordSet", nillable = true)
    protected List<IcmListacondicionesbaseRecord> icmListacondicionesbaseRecordSet;

    /**
     * Gets the value of the idestructura property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdestructura() {
        return idestructura;
    }

    /**
     * Sets the value of the idestructura property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdestructura(String value) {
        this.idestructura = value;
    }

    /**
     * Gets the value of the icmListacondicionesbaseRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListacondicionesbaseRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListacondicionesbaseRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListacondicionesbaseRecord }
     *
     *
     */
    public List<IcmListacondicionesbaseRecord> getIcmListacondicionesbaseRecordSet() {
        if (icmListacondicionesbaseRecordSet == null) {
            icmListacondicionesbaseRecordSet = new ArrayList<IcmListacondicionesbaseRecord>();
        }
        return this.icmListacondicionesbaseRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListacondicionesbaseBlock that = ((IcmListacondicionesbaseBlock) object);
        {
            String lhsIdestructura;
            lhsIdestructura = this.getIdestructura();
            String rhsIdestructura;
            rhsIdestructura = that.getIdestructura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idestructura", lhsIdestructura), LocatorUtils.property(thatLocator, "idestructura", rhsIdestructura), lhsIdestructura, rhsIdestructura, (this.idestructura!= null), (that.idestructura!= null))) {
                return false;
            }
        }
        {
            List<IcmListacondicionesbaseRecord> lhsIcmListacondicionesbaseRecordSet;
            lhsIcmListacondicionesbaseRecordSet = (((this.icmListacondicionesbaseRecordSet!= null)&&(!this.icmListacondicionesbaseRecordSet.isEmpty()))?this.getIcmListacondicionesbaseRecordSet():null);
            List<IcmListacondicionesbaseRecord> rhsIcmListacondicionesbaseRecordSet;
            rhsIcmListacondicionesbaseRecordSet = (((that.icmListacondicionesbaseRecordSet!= null)&&(!that.icmListacondicionesbaseRecordSet.isEmpty()))?that.getIcmListacondicionesbaseRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListacondicionesbaseRecordSet", lhsIcmListacondicionesbaseRecordSet), LocatorUtils.property(thatLocator, "icmListacondicionesbaseRecordSet", rhsIcmListacondicionesbaseRecordSet), lhsIcmListacondicionesbaseRecordSet, rhsIcmListacondicionesbaseRecordSet, ((this.icmListacondicionesbaseRecordSet!= null)&&(!this.icmListacondicionesbaseRecordSet.isEmpty())), ((that.icmListacondicionesbaseRecordSet!= null)&&(!that.icmListacondicionesbaseRecordSet.isEmpty())))) {
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
            String theIdestructura;
            theIdestructura = this.getIdestructura();
            strategy.appendField(locator, this, "idestructura", buffer, theIdestructura, (this.idestructura!= null));
        }
        {
            List<IcmListacondicionesbaseRecord> theIcmListacondicionesbaseRecordSet;
            theIcmListacondicionesbaseRecordSet = (((this.icmListacondicionesbaseRecordSet!= null)&&(!this.icmListacondicionesbaseRecordSet.isEmpty()))?this.getIcmListacondicionesbaseRecordSet():null);
            strategy.appendField(locator, this, "icmListacondicionesbaseRecordSet", buffer, theIcmListacondicionesbaseRecordSet, ((this.icmListacondicionesbaseRecordSet!= null)&&(!this.icmListacondicionesbaseRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theIdestructura;
            theIdestructura = this.getIdestructura();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestructura", theIdestructura), currentHashCode, theIdestructura, (this.idestructura!= null));
        }
        {
            List<IcmListacondicionesbaseRecord> theIcmListacondicionesbaseRecordSet;
            theIcmListacondicionesbaseRecordSet = (((this.icmListacondicionesbaseRecordSet!= null)&&(!this.icmListacondicionesbaseRecordSet.isEmpty()))?this.getIcmListacondicionesbaseRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListacondicionesbaseRecordSet", theIcmListacondicionesbaseRecordSet), currentHashCode, theIcmListacondicionesbaseRecordSet, ((this.icmListacondicionesbaseRecordSet!= null)&&(!this.icmListacondicionesbaseRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmListacondicionesbaseBlock) {
            final IcmListacondicionesbaseBlock copy = ((IcmListacondicionesbaseBlock) draftCopy);
            {
                Boolean idestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idestructura!= null));
                if (idestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdestructura;
                    sourceIdestructura = this.getIdestructura();
                    String copyIdestructura = ((String) strategy.copy(LocatorUtils.property(locator, "idestructura", sourceIdestructura), sourceIdestructura, (this.idestructura!= null)));
                    copy.setIdestructura(copyIdestructura);
                } else {
                    if (idestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idestructura = null;
                    }
                }
            }
            {
                Boolean icmListacondicionesbaseRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListacondicionesbaseRecordSet!= null)&&(!this.icmListacondicionesbaseRecordSet.isEmpty())));
                if (icmListacondicionesbaseRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListacondicionesbaseRecord> sourceIcmListacondicionesbaseRecordSet;
                    sourceIcmListacondicionesbaseRecordSet = (((this.icmListacondicionesbaseRecordSet!= null)&&(!this.icmListacondicionesbaseRecordSet.isEmpty()))?this.getIcmListacondicionesbaseRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListacondicionesbaseRecord> copyIcmListacondicionesbaseRecordSet = ((List<IcmListacondicionesbaseRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListacondicionesbaseRecordSet", sourceIcmListacondicionesbaseRecordSet), sourceIcmListacondicionesbaseRecordSet, ((this.icmListacondicionesbaseRecordSet!= null)&&(!this.icmListacondicionesbaseRecordSet.isEmpty()))));
                    copy.icmListacondicionesbaseRecordSet = null;
                    if (copyIcmListacondicionesbaseRecordSet!= null) {
                        List<IcmListacondicionesbaseRecord> uniqueIcmListacondicionesbaseRecordSetl = copy.getIcmListacondicionesbaseRecordSet();
                        uniqueIcmListacondicionesbaseRecordSetl.addAll(copyIcmListacondicionesbaseRecordSet);
                    }
                } else {
                    if (icmListacondicionesbaseRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListacondicionesbaseRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListacondicionesbaseBlock();
    }

}
