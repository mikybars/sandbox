
package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity;

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
 * <p>Clase Java para Icm_BandaspresupuestosBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_BandaspresupuestosBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_BandaspresupuestosRecordSet" type="{http://schemas.meta4.com/}Icm_BandaspresupuestosRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_BandaspresupuestosBlock", propOrder = {
    "icmBandaspresupuestosRecordSet"
})
public class IcmBandaspresupuestosBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_BandaspresupuestosRecordSet", nillable = true)
    protected List<IcmBandaspresupuestosRecord> icmBandaspresupuestosRecordSet;

    /**
     * Gets the value of the icmBandaspresupuestosRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmBandaspresupuestosRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmBandaspresupuestosRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmBandaspresupuestosRecord }
     * 
     * 
     */
    public List<IcmBandaspresupuestosRecord> getIcmBandaspresupuestosRecordSet() {
        if (icmBandaspresupuestosRecordSet == null) {
            icmBandaspresupuestosRecordSet = new ArrayList<IcmBandaspresupuestosRecord>();
        }
        return this.icmBandaspresupuestosRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmBandaspresupuestosBlock that = ((IcmBandaspresupuestosBlock) object);
        {
            List<IcmBandaspresupuestosRecord> lhsIcmBandaspresupuestosRecordSet;
            lhsIcmBandaspresupuestosRecordSet = (((this.icmBandaspresupuestosRecordSet!= null)&&(!this.icmBandaspresupuestosRecordSet.isEmpty()))?this.getIcmBandaspresupuestosRecordSet():null);
            List<IcmBandaspresupuestosRecord> rhsIcmBandaspresupuestosRecordSet;
            rhsIcmBandaspresupuestosRecordSet = (((that.icmBandaspresupuestosRecordSet!= null)&&(!that.icmBandaspresupuestosRecordSet.isEmpty()))?that.getIcmBandaspresupuestosRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmBandaspresupuestosRecordSet", lhsIcmBandaspresupuestosRecordSet), LocatorUtils.property(thatLocator, "icmBandaspresupuestosRecordSet", rhsIcmBandaspresupuestosRecordSet), lhsIcmBandaspresupuestosRecordSet, rhsIcmBandaspresupuestosRecordSet, ((this.icmBandaspresupuestosRecordSet!= null)&&(!this.icmBandaspresupuestosRecordSet.isEmpty())), ((that.icmBandaspresupuestosRecordSet!= null)&&(!that.icmBandaspresupuestosRecordSet.isEmpty())))) {
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
            List<IcmBandaspresupuestosRecord> theIcmBandaspresupuestosRecordSet;
            theIcmBandaspresupuestosRecordSet = (((this.icmBandaspresupuestosRecordSet!= null)&&(!this.icmBandaspresupuestosRecordSet.isEmpty()))?this.getIcmBandaspresupuestosRecordSet():null);
            strategy.appendField(locator, this, "icmBandaspresupuestosRecordSet", buffer, theIcmBandaspresupuestosRecordSet, ((this.icmBandaspresupuestosRecordSet!= null)&&(!this.icmBandaspresupuestosRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmBandaspresupuestosRecord> theIcmBandaspresupuestosRecordSet;
            theIcmBandaspresupuestosRecordSet = (((this.icmBandaspresupuestosRecordSet!= null)&&(!this.icmBandaspresupuestosRecordSet.isEmpty()))?this.getIcmBandaspresupuestosRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmBandaspresupuestosRecordSet", theIcmBandaspresupuestosRecordSet), currentHashCode, theIcmBandaspresupuestosRecordSet, ((this.icmBandaspresupuestosRecordSet!= null)&&(!this.icmBandaspresupuestosRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmBandaspresupuestosBlock) {
            final IcmBandaspresupuestosBlock copy = ((IcmBandaspresupuestosBlock) draftCopy);
            {
                Boolean icmBandaspresupuestosRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmBandaspresupuestosRecordSet!= null)&&(!this.icmBandaspresupuestosRecordSet.isEmpty())));
                if (icmBandaspresupuestosRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmBandaspresupuestosRecord> sourceIcmBandaspresupuestosRecordSet;
                    sourceIcmBandaspresupuestosRecordSet = (((this.icmBandaspresupuestosRecordSet!= null)&&(!this.icmBandaspresupuestosRecordSet.isEmpty()))?this.getIcmBandaspresupuestosRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmBandaspresupuestosRecord> copyIcmBandaspresupuestosRecordSet = ((List<IcmBandaspresupuestosRecord> ) strategy.copy(LocatorUtils.property(locator, "icmBandaspresupuestosRecordSet", sourceIcmBandaspresupuestosRecordSet), sourceIcmBandaspresupuestosRecordSet, ((this.icmBandaspresupuestosRecordSet!= null)&&(!this.icmBandaspresupuestosRecordSet.isEmpty()))));
                    copy.icmBandaspresupuestosRecordSet = null;
                    if (copyIcmBandaspresupuestosRecordSet!= null) {
                        List<IcmBandaspresupuestosRecord> uniqueIcmBandaspresupuestosRecordSetl = copy.getIcmBandaspresupuestosRecordSet();
                        uniqueIcmBandaspresupuestosRecordSetl.addAll(copyIcmBandaspresupuestosRecordSet);
                    }
                } else {
                    if (icmBandaspresupuestosRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmBandaspresupuestosRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmBandaspresupuestosBlock();
    }

}
