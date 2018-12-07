
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
 * <p>Clase Java para Icm_PresupuestosBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_PresupuestosBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_PresupuestosRecordSet" type="{http://schemas.meta4.com/}Icm_PresupuestosRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_PresupuestosBlock", propOrder = {
    "icmPresupuestosRecordSet"
})
public class IcmPresupuestosBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_PresupuestosRecordSet", nillable = true)
    protected List<IcmPresupuestosRecord> icmPresupuestosRecordSet;

    /**
     * Gets the value of the icmPresupuestosRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmPresupuestosRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmPresupuestosRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmPresupuestosRecord }
     * 
     * 
     */
    public List<IcmPresupuestosRecord> getIcmPresupuestosRecordSet() {
        if (icmPresupuestosRecordSet == null) {
            icmPresupuestosRecordSet = new ArrayList<IcmPresupuestosRecord>();
        }
        return this.icmPresupuestosRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmPresupuestosBlock that = ((IcmPresupuestosBlock) object);
        {
            List<IcmPresupuestosRecord> lhsIcmPresupuestosRecordSet;
            lhsIcmPresupuestosRecordSet = (((this.icmPresupuestosRecordSet!= null)&&(!this.icmPresupuestosRecordSet.isEmpty()))?this.getIcmPresupuestosRecordSet():null);
            List<IcmPresupuestosRecord> rhsIcmPresupuestosRecordSet;
            rhsIcmPresupuestosRecordSet = (((that.icmPresupuestosRecordSet!= null)&&(!that.icmPresupuestosRecordSet.isEmpty()))?that.getIcmPresupuestosRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPresupuestosRecordSet", lhsIcmPresupuestosRecordSet), LocatorUtils.property(thatLocator, "icmPresupuestosRecordSet", rhsIcmPresupuestosRecordSet), lhsIcmPresupuestosRecordSet, rhsIcmPresupuestosRecordSet, ((this.icmPresupuestosRecordSet!= null)&&(!this.icmPresupuestosRecordSet.isEmpty())), ((that.icmPresupuestosRecordSet!= null)&&(!that.icmPresupuestosRecordSet.isEmpty())))) {
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
            List<IcmPresupuestosRecord> theIcmPresupuestosRecordSet;
            theIcmPresupuestosRecordSet = (((this.icmPresupuestosRecordSet!= null)&&(!this.icmPresupuestosRecordSet.isEmpty()))?this.getIcmPresupuestosRecordSet():null);
            strategy.appendField(locator, this, "icmPresupuestosRecordSet", buffer, theIcmPresupuestosRecordSet, ((this.icmPresupuestosRecordSet!= null)&&(!this.icmPresupuestosRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmPresupuestosRecord> theIcmPresupuestosRecordSet;
            theIcmPresupuestosRecordSet = (((this.icmPresupuestosRecordSet!= null)&&(!this.icmPresupuestosRecordSet.isEmpty()))?this.getIcmPresupuestosRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPresupuestosRecordSet", theIcmPresupuestosRecordSet), currentHashCode, theIcmPresupuestosRecordSet, ((this.icmPresupuestosRecordSet!= null)&&(!this.icmPresupuestosRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmPresupuestosBlock) {
            final IcmPresupuestosBlock copy = ((IcmPresupuestosBlock) draftCopy);
            {
                Boolean icmPresupuestosRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmPresupuestosRecordSet!= null)&&(!this.icmPresupuestosRecordSet.isEmpty())));
                if (icmPresupuestosRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmPresupuestosRecord> sourceIcmPresupuestosRecordSet;
                    sourceIcmPresupuestosRecordSet = (((this.icmPresupuestosRecordSet!= null)&&(!this.icmPresupuestosRecordSet.isEmpty()))?this.getIcmPresupuestosRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmPresupuestosRecord> copyIcmPresupuestosRecordSet = ((List<IcmPresupuestosRecord> ) strategy.copy(LocatorUtils.property(locator, "icmPresupuestosRecordSet", sourceIcmPresupuestosRecordSet), sourceIcmPresupuestosRecordSet, ((this.icmPresupuestosRecordSet!= null)&&(!this.icmPresupuestosRecordSet.isEmpty()))));
                    copy.icmPresupuestosRecordSet = null;
                    if (copyIcmPresupuestosRecordSet!= null) {
                        List<IcmPresupuestosRecord> uniqueIcmPresupuestosRecordSetl = copy.getIcmPresupuestosRecordSet();
                        uniqueIcmPresupuestosRecordSetl.addAll(copyIcmPresupuestosRecordSet);
                    }
                } else {
                    if (icmPresupuestosRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmPresupuestosRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmPresupuestosBlock();
    }

}
