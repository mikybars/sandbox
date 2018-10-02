
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

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
 * <p>Clase Java para Icm_EmpleadosdespsalBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EmpleadosdespsalBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_EmpleadosdespsalRecordSet" type="{http://schemas.meta4.com/}Icm_EmpleadosdespsalRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EmpleadosdespsalBlock", propOrder = {
    "icmEmpleadosdespsalRecordSet"
})
public class IcmEmpleadosdespsalBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_EmpleadosdespsalRecordSet", nillable = true)
    protected List<IcmEmpleadosdespsalRecord> icmEmpleadosdespsalRecordSet;

    /**
     * Gets the value of the icmEmpleadosdespsalRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmEmpleadosdespsalRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmEmpleadosdespsalRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmEmpleadosdespsalRecord }
     * 
     * 
     */
    public List<IcmEmpleadosdespsalRecord> getIcmEmpleadosdespsalRecordSet() {
        if (icmEmpleadosdespsalRecordSet == null) {
            icmEmpleadosdespsalRecordSet = new ArrayList<IcmEmpleadosdespsalRecord>();
        }
        return this.icmEmpleadosdespsalRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmEmpleadosdespsalBlock that = ((IcmEmpleadosdespsalBlock) object);
        {
            List<IcmEmpleadosdespsalRecord> lhsIcmEmpleadosdespsalRecordSet;
            lhsIcmEmpleadosdespsalRecordSet = (((this.icmEmpleadosdespsalRecordSet!= null)&&(!this.icmEmpleadosdespsalRecordSet.isEmpty()))?this.getIcmEmpleadosdespsalRecordSet():null);
            List<IcmEmpleadosdespsalRecord> rhsIcmEmpleadosdespsalRecordSet;
            rhsIcmEmpleadosdespsalRecordSet = (((that.icmEmpleadosdespsalRecordSet!= null)&&(!that.icmEmpleadosdespsalRecordSet.isEmpty()))?that.getIcmEmpleadosdespsalRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmEmpleadosdespsalRecordSet", lhsIcmEmpleadosdespsalRecordSet), LocatorUtils.property(thatLocator, "icmEmpleadosdespsalRecordSet", rhsIcmEmpleadosdespsalRecordSet), lhsIcmEmpleadosdespsalRecordSet, rhsIcmEmpleadosdespsalRecordSet, ((this.icmEmpleadosdespsalRecordSet!= null)&&(!this.icmEmpleadosdespsalRecordSet.isEmpty())), ((that.icmEmpleadosdespsalRecordSet!= null)&&(!that.icmEmpleadosdespsalRecordSet.isEmpty())))) {
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
            List<IcmEmpleadosdespsalRecord> theIcmEmpleadosdespsalRecordSet;
            theIcmEmpleadosdespsalRecordSet = (((this.icmEmpleadosdespsalRecordSet!= null)&&(!this.icmEmpleadosdespsalRecordSet.isEmpty()))?this.getIcmEmpleadosdespsalRecordSet():null);
            strategy.appendField(locator, this, "icmEmpleadosdespsalRecordSet", buffer, theIcmEmpleadosdespsalRecordSet, ((this.icmEmpleadosdespsalRecordSet!= null)&&(!this.icmEmpleadosdespsalRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmEmpleadosdespsalRecord> theIcmEmpleadosdespsalRecordSet;
            theIcmEmpleadosdespsalRecordSet = (((this.icmEmpleadosdespsalRecordSet!= null)&&(!this.icmEmpleadosdespsalRecordSet.isEmpty()))?this.getIcmEmpleadosdespsalRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmEmpleadosdespsalRecordSet", theIcmEmpleadosdespsalRecordSet), currentHashCode, theIcmEmpleadosdespsalRecordSet, ((this.icmEmpleadosdespsalRecordSet!= null)&&(!this.icmEmpleadosdespsalRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmEmpleadosdespsalBlock) {
            final IcmEmpleadosdespsalBlock copy = ((IcmEmpleadosdespsalBlock) draftCopy);
            {
                Boolean icmEmpleadosdespsalRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmEmpleadosdespsalRecordSet!= null)&&(!this.icmEmpleadosdespsalRecordSet.isEmpty())));
                if (icmEmpleadosdespsalRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmEmpleadosdespsalRecord> sourceIcmEmpleadosdespsalRecordSet;
                    sourceIcmEmpleadosdespsalRecordSet = (((this.icmEmpleadosdespsalRecordSet!= null)&&(!this.icmEmpleadosdespsalRecordSet.isEmpty()))?this.getIcmEmpleadosdespsalRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmEmpleadosdespsalRecord> copyIcmEmpleadosdespsalRecordSet = ((List<IcmEmpleadosdespsalRecord> ) strategy.copy(LocatorUtils.property(locator, "icmEmpleadosdespsalRecordSet", sourceIcmEmpleadosdespsalRecordSet), sourceIcmEmpleadosdespsalRecordSet, ((this.icmEmpleadosdespsalRecordSet!= null)&&(!this.icmEmpleadosdespsalRecordSet.isEmpty()))));
                    copy.icmEmpleadosdespsalRecordSet = null;
                    if (copyIcmEmpleadosdespsalRecordSet!= null) {
                        List<IcmEmpleadosdespsalRecord> uniqueIcmEmpleadosdespsalRecordSetl = copy.getIcmEmpleadosdespsalRecordSet();
                        uniqueIcmEmpleadosdespsalRecordSetl.addAll(copyIcmEmpleadosdespsalRecordSet);
                    }
                } else {
                    if (icmEmpleadosdespsalRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmEmpleadosdespsalRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmEmpleadosdespsalBlock();
    }

}
