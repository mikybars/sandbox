
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
 * <p>Clase Java para Icm_PresenciamanualBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_PresenciamanualBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_PresenciamanualRecordSet" type="{http://schemas.meta4.com/}Icm_PresenciamanualRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_PresenciamanualBlock", propOrder = {
    "icmPresenciamanualRecordSet"
})
public class IcmPresenciamanualBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_PresenciamanualRecordSet", nillable = true)
    protected List<IcmPresenciamanualRecord> icmPresenciamanualRecordSet;

    /**
     * Gets the value of the icmPresenciamanualRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmPresenciamanualRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmPresenciamanualRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmPresenciamanualRecord }
     * 
     * 
     */
    public List<IcmPresenciamanualRecord> getIcmPresenciamanualRecordSet() {
        if (icmPresenciamanualRecordSet == null) {
            icmPresenciamanualRecordSet = new ArrayList<IcmPresenciamanualRecord>();
        }
        return this.icmPresenciamanualRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmPresenciamanualBlock that = ((IcmPresenciamanualBlock) object);
        {
            List<IcmPresenciamanualRecord> lhsIcmPresenciamanualRecordSet;
            lhsIcmPresenciamanualRecordSet = (((this.icmPresenciamanualRecordSet!= null)&&(!this.icmPresenciamanualRecordSet.isEmpty()))?this.getIcmPresenciamanualRecordSet():null);
            List<IcmPresenciamanualRecord> rhsIcmPresenciamanualRecordSet;
            rhsIcmPresenciamanualRecordSet = (((that.icmPresenciamanualRecordSet!= null)&&(!that.icmPresenciamanualRecordSet.isEmpty()))?that.getIcmPresenciamanualRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPresenciamanualRecordSet", lhsIcmPresenciamanualRecordSet), LocatorUtils.property(thatLocator, "icmPresenciamanualRecordSet", rhsIcmPresenciamanualRecordSet), lhsIcmPresenciamanualRecordSet, rhsIcmPresenciamanualRecordSet, ((this.icmPresenciamanualRecordSet!= null)&&(!this.icmPresenciamanualRecordSet.isEmpty())), ((that.icmPresenciamanualRecordSet!= null)&&(!that.icmPresenciamanualRecordSet.isEmpty())))) {
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
            List<IcmPresenciamanualRecord> theIcmPresenciamanualRecordSet;
            theIcmPresenciamanualRecordSet = (((this.icmPresenciamanualRecordSet!= null)&&(!this.icmPresenciamanualRecordSet.isEmpty()))?this.getIcmPresenciamanualRecordSet():null);
            strategy.appendField(locator, this, "icmPresenciamanualRecordSet", buffer, theIcmPresenciamanualRecordSet, ((this.icmPresenciamanualRecordSet!= null)&&(!this.icmPresenciamanualRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmPresenciamanualRecord> theIcmPresenciamanualRecordSet;
            theIcmPresenciamanualRecordSet = (((this.icmPresenciamanualRecordSet!= null)&&(!this.icmPresenciamanualRecordSet.isEmpty()))?this.getIcmPresenciamanualRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPresenciamanualRecordSet", theIcmPresenciamanualRecordSet), currentHashCode, theIcmPresenciamanualRecordSet, ((this.icmPresenciamanualRecordSet!= null)&&(!this.icmPresenciamanualRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmPresenciamanualBlock) {
            final IcmPresenciamanualBlock copy = ((IcmPresenciamanualBlock) draftCopy);
            {
                Boolean icmPresenciamanualRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmPresenciamanualRecordSet!= null)&&(!this.icmPresenciamanualRecordSet.isEmpty())));
                if (icmPresenciamanualRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmPresenciamanualRecord> sourceIcmPresenciamanualRecordSet;
                    sourceIcmPresenciamanualRecordSet = (((this.icmPresenciamanualRecordSet!= null)&&(!this.icmPresenciamanualRecordSet.isEmpty()))?this.getIcmPresenciamanualRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmPresenciamanualRecord> copyIcmPresenciamanualRecordSet = ((List<IcmPresenciamanualRecord> ) strategy.copy(LocatorUtils.property(locator, "icmPresenciamanualRecordSet", sourceIcmPresenciamanualRecordSet), sourceIcmPresenciamanualRecordSet, ((this.icmPresenciamanualRecordSet!= null)&&(!this.icmPresenciamanualRecordSet.isEmpty()))));
                    copy.icmPresenciamanualRecordSet = null;
                    if (copyIcmPresenciamanualRecordSet!= null) {
                        List<IcmPresenciamanualRecord> uniqueIcmPresenciamanualRecordSetl = copy.getIcmPresenciamanualRecordSet();
                        uniqueIcmPresenciamanualRecordSetl.addAll(copyIcmPresenciamanualRecordSet);
                    }
                } else {
                    if (icmPresenciamanualRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmPresenciamanualRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmPresenciamanualBlock();
    }

}
