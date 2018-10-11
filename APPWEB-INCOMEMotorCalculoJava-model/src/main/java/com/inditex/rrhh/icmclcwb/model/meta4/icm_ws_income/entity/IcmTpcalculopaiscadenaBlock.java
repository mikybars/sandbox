
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
 * <p>Clase Java para Icm_TpcalculopaiscadenaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_TpcalculopaiscadenaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_TpcalculopaiscadenaRecordSet" type="{http://schemas.meta4.com/}Icm_TpcalculopaiscadenaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_TpcalculopaiscadenaBlock", propOrder = {
    "icmTpcalculopaiscadenaRecordSet"
})
public class IcmTpcalculopaiscadenaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_TpcalculopaiscadenaRecordSet", nillable = true)
    protected List<IcmTpcalculopaiscadenaRecord> icmTpcalculopaiscadenaRecordSet;

    /**
     * Gets the value of the icmTpcalculopaiscadenaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmTpcalculopaiscadenaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmTpcalculopaiscadenaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmTpcalculopaiscadenaRecord }
     * 
     * 
     */
    public List<IcmTpcalculopaiscadenaRecord> getIcmTpcalculopaiscadenaRecordSet() {
        if (icmTpcalculopaiscadenaRecordSet == null) {
            icmTpcalculopaiscadenaRecordSet = new ArrayList<IcmTpcalculopaiscadenaRecord>();
        }
        return this.icmTpcalculopaiscadenaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmTpcalculopaiscadenaBlock that = ((IcmTpcalculopaiscadenaBlock) object);
        {
            List<IcmTpcalculopaiscadenaRecord> lhsIcmTpcalculopaiscadenaRecordSet;
            lhsIcmTpcalculopaiscadenaRecordSet = (((this.icmTpcalculopaiscadenaRecordSet!= null)&&(!this.icmTpcalculopaiscadenaRecordSet.isEmpty()))?this.getIcmTpcalculopaiscadenaRecordSet():null);
            List<IcmTpcalculopaiscadenaRecord> rhsIcmTpcalculopaiscadenaRecordSet;
            rhsIcmTpcalculopaiscadenaRecordSet = (((that.icmTpcalculopaiscadenaRecordSet!= null)&&(!that.icmTpcalculopaiscadenaRecordSet.isEmpty()))?that.getIcmTpcalculopaiscadenaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmTpcalculopaiscadenaRecordSet", lhsIcmTpcalculopaiscadenaRecordSet), LocatorUtils.property(thatLocator, "icmTpcalculopaiscadenaRecordSet", rhsIcmTpcalculopaiscadenaRecordSet), lhsIcmTpcalculopaiscadenaRecordSet, rhsIcmTpcalculopaiscadenaRecordSet, ((this.icmTpcalculopaiscadenaRecordSet!= null)&&(!this.icmTpcalculopaiscadenaRecordSet.isEmpty())), ((that.icmTpcalculopaiscadenaRecordSet!= null)&&(!that.icmTpcalculopaiscadenaRecordSet.isEmpty())))) {
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
            List<IcmTpcalculopaiscadenaRecord> theIcmTpcalculopaiscadenaRecordSet;
            theIcmTpcalculopaiscadenaRecordSet = (((this.icmTpcalculopaiscadenaRecordSet!= null)&&(!this.icmTpcalculopaiscadenaRecordSet.isEmpty()))?this.getIcmTpcalculopaiscadenaRecordSet():null);
            strategy.appendField(locator, this, "icmTpcalculopaiscadenaRecordSet", buffer, theIcmTpcalculopaiscadenaRecordSet, ((this.icmTpcalculopaiscadenaRecordSet!= null)&&(!this.icmTpcalculopaiscadenaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmTpcalculopaiscadenaRecord> theIcmTpcalculopaiscadenaRecordSet;
            theIcmTpcalculopaiscadenaRecordSet = (((this.icmTpcalculopaiscadenaRecordSet!= null)&&(!this.icmTpcalculopaiscadenaRecordSet.isEmpty()))?this.getIcmTpcalculopaiscadenaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmTpcalculopaiscadenaRecordSet", theIcmTpcalculopaiscadenaRecordSet), currentHashCode, theIcmTpcalculopaiscadenaRecordSet, ((this.icmTpcalculopaiscadenaRecordSet!= null)&&(!this.icmTpcalculopaiscadenaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmTpcalculopaiscadenaBlock) {
            final IcmTpcalculopaiscadenaBlock copy = ((IcmTpcalculopaiscadenaBlock) draftCopy);
            {
                Boolean icmTpcalculopaiscadenaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmTpcalculopaiscadenaRecordSet!= null)&&(!this.icmTpcalculopaiscadenaRecordSet.isEmpty())));
                if (icmTpcalculopaiscadenaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmTpcalculopaiscadenaRecord> sourceIcmTpcalculopaiscadenaRecordSet;
                    sourceIcmTpcalculopaiscadenaRecordSet = (((this.icmTpcalculopaiscadenaRecordSet!= null)&&(!this.icmTpcalculopaiscadenaRecordSet.isEmpty()))?this.getIcmTpcalculopaiscadenaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmTpcalculopaiscadenaRecord> copyIcmTpcalculopaiscadenaRecordSet = ((List<IcmTpcalculopaiscadenaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmTpcalculopaiscadenaRecordSet", sourceIcmTpcalculopaiscadenaRecordSet), sourceIcmTpcalculopaiscadenaRecordSet, ((this.icmTpcalculopaiscadenaRecordSet!= null)&&(!this.icmTpcalculopaiscadenaRecordSet.isEmpty()))));
                    copy.icmTpcalculopaiscadenaRecordSet = null;
                    if (copyIcmTpcalculopaiscadenaRecordSet!= null) {
                        List<IcmTpcalculopaiscadenaRecord> uniqueIcmTpcalculopaiscadenaRecordSetl = copy.getIcmTpcalculopaiscadenaRecordSet();
                        uniqueIcmTpcalculopaiscadenaRecordSetl.addAll(copyIcmTpcalculopaiscadenaRecordSet);
                    }
                } else {
                    if (icmTpcalculopaiscadenaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmTpcalculopaiscadenaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmTpcalculopaiscadenaBlock();
    }

}
