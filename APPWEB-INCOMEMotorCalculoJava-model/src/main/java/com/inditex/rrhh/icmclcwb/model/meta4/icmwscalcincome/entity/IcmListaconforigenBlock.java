
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
 * <p>Java class for Icm_ListaconforigenBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListaconforigenBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListaconforigenRecordSet" type="{http://schemas.meta4.com/}Icm_ListaconforigenRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaconforigenBlock", propOrder = {
    "icmListaconforigenRecordSet"
})
public class IcmListaconforigenBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ListaconforigenRecordSet", nillable = true)
    protected List<IcmListaconforigenRecord> icmListaconforigenRecordSet;

    /**
     * Gets the value of the icmListaconforigenRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListaconforigenRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListaconforigenRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListaconforigenRecord }
     *
     *
     */
    public List<IcmListaconforigenRecord> getIcmListaconforigenRecordSet() {
        if (icmListaconforigenRecordSet == null) {
            icmListaconforigenRecordSet = new ArrayList<IcmListaconforigenRecord>();
        }
        return this.icmListaconforigenRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListaconforigenBlock that = ((IcmListaconforigenBlock) object);
        {
            List<IcmListaconforigenRecord> lhsIcmListaconforigenRecordSet;
            lhsIcmListaconforigenRecordSet = (((this.icmListaconforigenRecordSet!= null)&&(!this.icmListaconforigenRecordSet.isEmpty()))?this.getIcmListaconforigenRecordSet():null);
            List<IcmListaconforigenRecord> rhsIcmListaconforigenRecordSet;
            rhsIcmListaconforigenRecordSet = (((that.icmListaconforigenRecordSet!= null)&&(!that.icmListaconforigenRecordSet.isEmpty()))?that.getIcmListaconforigenRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaconforigenRecordSet", lhsIcmListaconforigenRecordSet), LocatorUtils.property(thatLocator, "icmListaconforigenRecordSet", rhsIcmListaconforigenRecordSet), lhsIcmListaconforigenRecordSet, rhsIcmListaconforigenRecordSet, ((this.icmListaconforigenRecordSet!= null)&&(!this.icmListaconforigenRecordSet.isEmpty())), ((that.icmListaconforigenRecordSet!= null)&&(!that.icmListaconforigenRecordSet.isEmpty())))) {
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
            List<IcmListaconforigenRecord> theIcmListaconforigenRecordSet;
            theIcmListaconforigenRecordSet = (((this.icmListaconforigenRecordSet!= null)&&(!this.icmListaconforigenRecordSet.isEmpty()))?this.getIcmListaconforigenRecordSet():null);
            strategy.appendField(locator, this, "icmListaconforigenRecordSet", buffer, theIcmListaconforigenRecordSet, ((this.icmListaconforigenRecordSet!= null)&&(!this.icmListaconforigenRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmListaconforigenRecord> theIcmListaconforigenRecordSet;
            theIcmListaconforigenRecordSet = (((this.icmListaconforigenRecordSet!= null)&&(!this.icmListaconforigenRecordSet.isEmpty()))?this.getIcmListaconforigenRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaconforigenRecordSet", theIcmListaconforigenRecordSet), currentHashCode, theIcmListaconforigenRecordSet, ((this.icmListaconforigenRecordSet!= null)&&(!this.icmListaconforigenRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmListaconforigenBlock) {
            final IcmListaconforigenBlock copy = ((IcmListaconforigenBlock) draftCopy);
            {
                Boolean icmListaconforigenRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListaconforigenRecordSet!= null)&&(!this.icmListaconforigenRecordSet.isEmpty())));
                if (icmListaconforigenRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListaconforigenRecord> sourceIcmListaconforigenRecordSet;
                    sourceIcmListaconforigenRecordSet = (((this.icmListaconforigenRecordSet!= null)&&(!this.icmListaconforigenRecordSet.isEmpty()))?this.getIcmListaconforigenRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListaconforigenRecord> copyIcmListaconforigenRecordSet = ((List<IcmListaconforigenRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListaconforigenRecordSet", sourceIcmListaconforigenRecordSet), sourceIcmListaconforigenRecordSet, ((this.icmListaconforigenRecordSet!= null)&&(!this.icmListaconforigenRecordSet.isEmpty()))));
                    copy.icmListaconforigenRecordSet = null;
                    if (copyIcmListaconforigenRecordSet!= null) {
                        List<IcmListaconforigenRecord> uniqueIcmListaconforigenRecordSetl = copy.getIcmListaconforigenRecordSet();
                        uniqueIcmListaconforigenRecordSetl.addAll(copyIcmListaconforigenRecordSet);
                    }
                } else {
                    if (icmListaconforigenRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaconforigenRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListaconforigenBlock();
    }

}
