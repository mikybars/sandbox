
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
 * <p>Clase Java para Icm_EmpleadostiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EmpleadostiendaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_EmpleadostiendaRecordSet" type="{http://schemas.meta4.com/}Icm_EmpleadostiendaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EmpleadostiendaBlock", propOrder = {
    "icmEmpleadostiendaRecordSet"
})
public class IcmEmpleadostiendaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_EmpleadostiendaRecordSet", nillable = true)
    protected List<IcmEmpleadostiendaRecord> icmEmpleadostiendaRecordSet;

    /**
     * Gets the value of the icmEmpleadostiendaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmEmpleadostiendaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmEmpleadostiendaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmEmpleadostiendaRecord }
     * 
     * 
     */
    public List<IcmEmpleadostiendaRecord> getIcmEmpleadostiendaRecordSet() {
        if (icmEmpleadostiendaRecordSet == null) {
            icmEmpleadostiendaRecordSet = new ArrayList<IcmEmpleadostiendaRecord>();
        }
        return this.icmEmpleadostiendaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmEmpleadostiendaBlock that = ((IcmEmpleadostiendaBlock) object);
        {
            List<IcmEmpleadostiendaRecord> lhsIcmEmpleadostiendaRecordSet;
            lhsIcmEmpleadostiendaRecordSet = (((this.icmEmpleadostiendaRecordSet!= null)&&(!this.icmEmpleadostiendaRecordSet.isEmpty()))?this.getIcmEmpleadostiendaRecordSet():null);
            List<IcmEmpleadostiendaRecord> rhsIcmEmpleadostiendaRecordSet;
            rhsIcmEmpleadostiendaRecordSet = (((that.icmEmpleadostiendaRecordSet!= null)&&(!that.icmEmpleadostiendaRecordSet.isEmpty()))?that.getIcmEmpleadostiendaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmEmpleadostiendaRecordSet", lhsIcmEmpleadostiendaRecordSet), LocatorUtils.property(thatLocator, "icmEmpleadostiendaRecordSet", rhsIcmEmpleadostiendaRecordSet), lhsIcmEmpleadostiendaRecordSet, rhsIcmEmpleadostiendaRecordSet, ((this.icmEmpleadostiendaRecordSet!= null)&&(!this.icmEmpleadostiendaRecordSet.isEmpty())), ((that.icmEmpleadostiendaRecordSet!= null)&&(!that.icmEmpleadostiendaRecordSet.isEmpty())))) {
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
            List<IcmEmpleadostiendaRecord> theIcmEmpleadostiendaRecordSet;
            theIcmEmpleadostiendaRecordSet = (((this.icmEmpleadostiendaRecordSet!= null)&&(!this.icmEmpleadostiendaRecordSet.isEmpty()))?this.getIcmEmpleadostiendaRecordSet():null);
            strategy.appendField(locator, this, "icmEmpleadostiendaRecordSet", buffer, theIcmEmpleadostiendaRecordSet, ((this.icmEmpleadostiendaRecordSet!= null)&&(!this.icmEmpleadostiendaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmEmpleadostiendaRecord> theIcmEmpleadostiendaRecordSet;
            theIcmEmpleadostiendaRecordSet = (((this.icmEmpleadostiendaRecordSet!= null)&&(!this.icmEmpleadostiendaRecordSet.isEmpty()))?this.getIcmEmpleadostiendaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmEmpleadostiendaRecordSet", theIcmEmpleadostiendaRecordSet), currentHashCode, theIcmEmpleadostiendaRecordSet, ((this.icmEmpleadostiendaRecordSet!= null)&&(!this.icmEmpleadostiendaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmEmpleadostiendaBlock) {
            final IcmEmpleadostiendaBlock copy = ((IcmEmpleadostiendaBlock) draftCopy);
            {
                Boolean icmEmpleadostiendaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmEmpleadostiendaRecordSet!= null)&&(!this.icmEmpleadostiendaRecordSet.isEmpty())));
                if (icmEmpleadostiendaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmEmpleadostiendaRecord> sourceIcmEmpleadostiendaRecordSet;
                    sourceIcmEmpleadostiendaRecordSet = (((this.icmEmpleadostiendaRecordSet!= null)&&(!this.icmEmpleadostiendaRecordSet.isEmpty()))?this.getIcmEmpleadostiendaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmEmpleadostiendaRecord> copyIcmEmpleadostiendaRecordSet = ((List<IcmEmpleadostiendaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmEmpleadostiendaRecordSet", sourceIcmEmpleadostiendaRecordSet), sourceIcmEmpleadostiendaRecordSet, ((this.icmEmpleadostiendaRecordSet!= null)&&(!this.icmEmpleadostiendaRecordSet.isEmpty()))));
                    copy.icmEmpleadostiendaRecordSet = null;
                    if (copyIcmEmpleadostiendaRecordSet!= null) {
                        List<IcmEmpleadostiendaRecord> uniqueIcmEmpleadostiendaRecordSetl = copy.getIcmEmpleadostiendaRecordSet();
                        uniqueIcmEmpleadostiendaRecordSetl.addAll(copyIcmEmpleadostiendaRecordSet);
                    }
                } else {
                    if (icmEmpleadostiendaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmEmpleadostiendaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmEmpleadostiendaBlock();
    }

}
