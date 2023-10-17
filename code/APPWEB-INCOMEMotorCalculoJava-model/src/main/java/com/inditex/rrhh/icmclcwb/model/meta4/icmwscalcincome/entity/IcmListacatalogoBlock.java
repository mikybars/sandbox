
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
 * <p>Java class for Icm_ListacatalogoBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListacatalogoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListacatalogoRecordSet" type="{http://schemas.meta4.com/}Icm_ListacatalogoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListacatalogoBlock", propOrder = {
    "icmListacatalogoRecordSet"
})
public class IcmListacatalogoBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ListacatalogoRecordSet", nillable = true)
    protected List<IcmListacatalogoRecord> icmListacatalogoRecordSet;

    /**
     * Gets the value of the icmListacatalogoRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListacatalogoRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListacatalogoRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListacatalogoRecord }
     *
     *
     */
    public List<IcmListacatalogoRecord> getIcmListacatalogoRecordSet() {
        if (icmListacatalogoRecordSet == null) {
            icmListacatalogoRecordSet = new ArrayList<IcmListacatalogoRecord>();
        }
        return this.icmListacatalogoRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListacatalogoBlock that = ((IcmListacatalogoBlock) object);
        {
            List<IcmListacatalogoRecord> lhsIcmListacatalogoRecordSet;
            lhsIcmListacatalogoRecordSet = (((this.icmListacatalogoRecordSet!= null)&&(!this.icmListacatalogoRecordSet.isEmpty()))?this.getIcmListacatalogoRecordSet():null);
            List<IcmListacatalogoRecord> rhsIcmListacatalogoRecordSet;
            rhsIcmListacatalogoRecordSet = (((that.icmListacatalogoRecordSet!= null)&&(!that.icmListacatalogoRecordSet.isEmpty()))?that.getIcmListacatalogoRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListacatalogoRecordSet", lhsIcmListacatalogoRecordSet), LocatorUtils.property(thatLocator, "icmListacatalogoRecordSet", rhsIcmListacatalogoRecordSet), lhsIcmListacatalogoRecordSet, rhsIcmListacatalogoRecordSet, ((this.icmListacatalogoRecordSet!= null)&&(!this.icmListacatalogoRecordSet.isEmpty())), ((that.icmListacatalogoRecordSet!= null)&&(!that.icmListacatalogoRecordSet.isEmpty())))) {
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
            List<IcmListacatalogoRecord> theIcmListacatalogoRecordSet;
            theIcmListacatalogoRecordSet = (((this.icmListacatalogoRecordSet!= null)&&(!this.icmListacatalogoRecordSet.isEmpty()))?this.getIcmListacatalogoRecordSet():null);
            strategy.appendField(locator, this, "icmListacatalogoRecordSet", buffer, theIcmListacatalogoRecordSet, ((this.icmListacatalogoRecordSet!= null)&&(!this.icmListacatalogoRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmListacatalogoRecord> theIcmListacatalogoRecordSet;
            theIcmListacatalogoRecordSet = (((this.icmListacatalogoRecordSet!= null)&&(!this.icmListacatalogoRecordSet.isEmpty()))?this.getIcmListacatalogoRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListacatalogoRecordSet", theIcmListacatalogoRecordSet), currentHashCode, theIcmListacatalogoRecordSet, ((this.icmListacatalogoRecordSet!= null)&&(!this.icmListacatalogoRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmListacatalogoBlock) {
            final IcmListacatalogoBlock copy = ((IcmListacatalogoBlock) draftCopy);
            {
                Boolean icmListacatalogoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListacatalogoRecordSet!= null)&&(!this.icmListacatalogoRecordSet.isEmpty())));
                if (icmListacatalogoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListacatalogoRecord> sourceIcmListacatalogoRecordSet;
                    sourceIcmListacatalogoRecordSet = (((this.icmListacatalogoRecordSet!= null)&&(!this.icmListacatalogoRecordSet.isEmpty()))?this.getIcmListacatalogoRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListacatalogoRecord> copyIcmListacatalogoRecordSet = ((List<IcmListacatalogoRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListacatalogoRecordSet", sourceIcmListacatalogoRecordSet), sourceIcmListacatalogoRecordSet, ((this.icmListacatalogoRecordSet!= null)&&(!this.icmListacatalogoRecordSet.isEmpty()))));
                    copy.icmListacatalogoRecordSet = null;
                    if (copyIcmListacatalogoRecordSet!= null) {
                        List<IcmListacatalogoRecord> uniqueIcmListacatalogoRecordSetl = copy.getIcmListacatalogoRecordSet();
                        uniqueIcmListacatalogoRecordSetl.addAll(copyIcmListacatalogoRecordSet);
                    }
                } else {
                    if (icmListacatalogoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListacatalogoRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListacatalogoBlock();
    }

}
