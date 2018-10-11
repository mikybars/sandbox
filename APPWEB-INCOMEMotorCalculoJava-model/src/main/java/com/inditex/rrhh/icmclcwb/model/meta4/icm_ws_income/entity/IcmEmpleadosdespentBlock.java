
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
 * <p>Clase Java para Icm_EmpleadosdespentBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EmpleadosdespentBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_EmpleadosdespentRecordSet" type="{http://schemas.meta4.com/}Icm_EmpleadosdespentRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EmpleadosdespentBlock", propOrder = {
    "icmEmpleadosdespentRecordSet"
})
public class IcmEmpleadosdespentBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_EmpleadosdespentRecordSet", nillable = true)
    protected List<IcmEmpleadosdespentRecord> icmEmpleadosdespentRecordSet;

    /**
     * Gets the value of the icmEmpleadosdespentRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmEmpleadosdespentRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmEmpleadosdespentRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmEmpleadosdespentRecord }
     * 
     * 
     */
    public List<IcmEmpleadosdespentRecord> getIcmEmpleadosdespentRecordSet() {
        if (icmEmpleadosdespentRecordSet == null) {
            icmEmpleadosdespentRecordSet = new ArrayList<IcmEmpleadosdespentRecord>();
        }
        return this.icmEmpleadosdespentRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmEmpleadosdespentBlock that = ((IcmEmpleadosdespentBlock) object);
        {
            List<IcmEmpleadosdespentRecord> lhsIcmEmpleadosdespentRecordSet;
            lhsIcmEmpleadosdespentRecordSet = (((this.icmEmpleadosdespentRecordSet!= null)&&(!this.icmEmpleadosdespentRecordSet.isEmpty()))?this.getIcmEmpleadosdespentRecordSet():null);
            List<IcmEmpleadosdespentRecord> rhsIcmEmpleadosdespentRecordSet;
            rhsIcmEmpleadosdespentRecordSet = (((that.icmEmpleadosdespentRecordSet!= null)&&(!that.icmEmpleadosdespentRecordSet.isEmpty()))?that.getIcmEmpleadosdespentRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmEmpleadosdespentRecordSet", lhsIcmEmpleadosdespentRecordSet), LocatorUtils.property(thatLocator, "icmEmpleadosdespentRecordSet", rhsIcmEmpleadosdespentRecordSet), lhsIcmEmpleadosdespentRecordSet, rhsIcmEmpleadosdespentRecordSet, ((this.icmEmpleadosdespentRecordSet!= null)&&(!this.icmEmpleadosdespentRecordSet.isEmpty())), ((that.icmEmpleadosdespentRecordSet!= null)&&(!that.icmEmpleadosdespentRecordSet.isEmpty())))) {
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
            List<IcmEmpleadosdespentRecord> theIcmEmpleadosdespentRecordSet;
            theIcmEmpleadosdespentRecordSet = (((this.icmEmpleadosdespentRecordSet!= null)&&(!this.icmEmpleadosdespentRecordSet.isEmpty()))?this.getIcmEmpleadosdespentRecordSet():null);
            strategy.appendField(locator, this, "icmEmpleadosdespentRecordSet", buffer, theIcmEmpleadosdespentRecordSet, ((this.icmEmpleadosdespentRecordSet!= null)&&(!this.icmEmpleadosdespentRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmEmpleadosdespentRecord> theIcmEmpleadosdespentRecordSet;
            theIcmEmpleadosdespentRecordSet = (((this.icmEmpleadosdespentRecordSet!= null)&&(!this.icmEmpleadosdespentRecordSet.isEmpty()))?this.getIcmEmpleadosdespentRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmEmpleadosdespentRecordSet", theIcmEmpleadosdespentRecordSet), currentHashCode, theIcmEmpleadosdespentRecordSet, ((this.icmEmpleadosdespentRecordSet!= null)&&(!this.icmEmpleadosdespentRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmEmpleadosdespentBlock) {
            final IcmEmpleadosdespentBlock copy = ((IcmEmpleadosdespentBlock) draftCopy);
            {
                Boolean icmEmpleadosdespentRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmEmpleadosdespentRecordSet!= null)&&(!this.icmEmpleadosdespentRecordSet.isEmpty())));
                if (icmEmpleadosdespentRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmEmpleadosdespentRecord> sourceIcmEmpleadosdespentRecordSet;
                    sourceIcmEmpleadosdespentRecordSet = (((this.icmEmpleadosdespentRecordSet!= null)&&(!this.icmEmpleadosdespentRecordSet.isEmpty()))?this.getIcmEmpleadosdespentRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmEmpleadosdespentRecord> copyIcmEmpleadosdespentRecordSet = ((List<IcmEmpleadosdespentRecord> ) strategy.copy(LocatorUtils.property(locator, "icmEmpleadosdespentRecordSet", sourceIcmEmpleadosdespentRecordSet), sourceIcmEmpleadosdespentRecordSet, ((this.icmEmpleadosdespentRecordSet!= null)&&(!this.icmEmpleadosdespentRecordSet.isEmpty()))));
                    copy.icmEmpleadosdespentRecordSet = null;
                    if (copyIcmEmpleadosdespentRecordSet!= null) {
                        List<IcmEmpleadosdespentRecord> uniqueIcmEmpleadosdespentRecordSetl = copy.getIcmEmpleadosdespentRecordSet();
                        uniqueIcmEmpleadosdespentRecordSetl.addAll(copyIcmEmpleadosdespentRecordSet);
                    }
                } else {
                    if (icmEmpleadosdespentRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmEmpleadosdespentRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmEmpleadosdespentBlock();
    }

}
