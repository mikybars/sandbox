
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
 * <p>Clase Java para Icm_VentamanualBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_VentamanualBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_VentamanualRecordSet" type="{http://schemas.meta4.com/}Icm_VentamanualRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_VentamanualBlock", propOrder = {
    "icmVentamanualRecordSet"
})
public class IcmVentamanualBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_VentamanualRecordSet", nillable = true)
    protected List<IcmVentamanualRecord> icmVentamanualRecordSet;

    /**
     * Gets the value of the icmVentamanualRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmVentamanualRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmVentamanualRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmVentamanualRecord }
     * 
     * 
     */
    public List<IcmVentamanualRecord> getIcmVentamanualRecordSet() {
        if (icmVentamanualRecordSet == null) {
            icmVentamanualRecordSet = new ArrayList<IcmVentamanualRecord>();
        }
        return this.icmVentamanualRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmVentamanualBlock that = ((IcmVentamanualBlock) object);
        {
            List<IcmVentamanualRecord> lhsIcmVentamanualRecordSet;
            lhsIcmVentamanualRecordSet = (((this.icmVentamanualRecordSet!= null)&&(!this.icmVentamanualRecordSet.isEmpty()))?this.getIcmVentamanualRecordSet():null);
            List<IcmVentamanualRecord> rhsIcmVentamanualRecordSet;
            rhsIcmVentamanualRecordSet = (((that.icmVentamanualRecordSet!= null)&&(!that.icmVentamanualRecordSet.isEmpty()))?that.getIcmVentamanualRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmVentamanualRecordSet", lhsIcmVentamanualRecordSet), LocatorUtils.property(thatLocator, "icmVentamanualRecordSet", rhsIcmVentamanualRecordSet), lhsIcmVentamanualRecordSet, rhsIcmVentamanualRecordSet, ((this.icmVentamanualRecordSet!= null)&&(!this.icmVentamanualRecordSet.isEmpty())), ((that.icmVentamanualRecordSet!= null)&&(!that.icmVentamanualRecordSet.isEmpty())))) {
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
            List<IcmVentamanualRecord> theIcmVentamanualRecordSet;
            theIcmVentamanualRecordSet = (((this.icmVentamanualRecordSet!= null)&&(!this.icmVentamanualRecordSet.isEmpty()))?this.getIcmVentamanualRecordSet():null);
            strategy.appendField(locator, this, "icmVentamanualRecordSet", buffer, theIcmVentamanualRecordSet, ((this.icmVentamanualRecordSet!= null)&&(!this.icmVentamanualRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmVentamanualRecord> theIcmVentamanualRecordSet;
            theIcmVentamanualRecordSet = (((this.icmVentamanualRecordSet!= null)&&(!this.icmVentamanualRecordSet.isEmpty()))?this.getIcmVentamanualRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmVentamanualRecordSet", theIcmVentamanualRecordSet), currentHashCode, theIcmVentamanualRecordSet, ((this.icmVentamanualRecordSet!= null)&&(!this.icmVentamanualRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmVentamanualBlock) {
            final IcmVentamanualBlock copy = ((IcmVentamanualBlock) draftCopy);
            {
                Boolean icmVentamanualRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmVentamanualRecordSet!= null)&&(!this.icmVentamanualRecordSet.isEmpty())));
                if (icmVentamanualRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmVentamanualRecord> sourceIcmVentamanualRecordSet;
                    sourceIcmVentamanualRecordSet = (((this.icmVentamanualRecordSet!= null)&&(!this.icmVentamanualRecordSet.isEmpty()))?this.getIcmVentamanualRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmVentamanualRecord> copyIcmVentamanualRecordSet = ((List<IcmVentamanualRecord> ) strategy.copy(LocatorUtils.property(locator, "icmVentamanualRecordSet", sourceIcmVentamanualRecordSet), sourceIcmVentamanualRecordSet, ((this.icmVentamanualRecordSet!= null)&&(!this.icmVentamanualRecordSet.isEmpty()))));
                    copy.icmVentamanualRecordSet = null;
                    if (copyIcmVentamanualRecordSet!= null) {
                        List<IcmVentamanualRecord> uniqueIcmVentamanualRecordSetl = copy.getIcmVentamanualRecordSet();
                        uniqueIcmVentamanualRecordSetl.addAll(copyIcmVentamanualRecordSet);
                    }
                } else {
                    if (icmVentamanualRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmVentamanualRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmVentamanualBlock();
    }

}
