
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
 * <p>Clase Java para Icm_EmpleadosestructuraBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EmpleadosestructuraBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_EmpleadosestructuraRecordSet" type="{http://schemas.meta4.com/}Icm_EmpleadosestructuraRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EmpleadosestructuraBlock", propOrder = {
    "icmEmpleadosestructuraRecordSet"
})
public class IcmEmpleadosestructuraBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_EmpleadosestructuraRecordSet", nillable = true)
    protected List<IcmEmpleadosestructuraRecord> icmEmpleadosestructuraRecordSet;

    /**
     * Gets the value of the icmEmpleadosestructuraRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmEmpleadosestructuraRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmEmpleadosestructuraRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmEmpleadosestructuraRecord }
     * 
     * 
     */
    public List<IcmEmpleadosestructuraRecord> getIcmEmpleadosestructuraRecordSet() {
        if (icmEmpleadosestructuraRecordSet == null) {
            icmEmpleadosestructuraRecordSet = new ArrayList<IcmEmpleadosestructuraRecord>();
        }
        return this.icmEmpleadosestructuraRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmEmpleadosestructuraBlock that = ((IcmEmpleadosestructuraBlock) object);
        {
            List<IcmEmpleadosestructuraRecord> lhsIcmEmpleadosestructuraRecordSet;
            lhsIcmEmpleadosestructuraRecordSet = (((this.icmEmpleadosestructuraRecordSet!= null)&&(!this.icmEmpleadosestructuraRecordSet.isEmpty()))?this.getIcmEmpleadosestructuraRecordSet():null);
            List<IcmEmpleadosestructuraRecord> rhsIcmEmpleadosestructuraRecordSet;
            rhsIcmEmpleadosestructuraRecordSet = (((that.icmEmpleadosestructuraRecordSet!= null)&&(!that.icmEmpleadosestructuraRecordSet.isEmpty()))?that.getIcmEmpleadosestructuraRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmEmpleadosestructuraRecordSet", lhsIcmEmpleadosestructuraRecordSet), LocatorUtils.property(thatLocator, "icmEmpleadosestructuraRecordSet", rhsIcmEmpleadosestructuraRecordSet), lhsIcmEmpleadosestructuraRecordSet, rhsIcmEmpleadosestructuraRecordSet, ((this.icmEmpleadosestructuraRecordSet!= null)&&(!this.icmEmpleadosestructuraRecordSet.isEmpty())), ((that.icmEmpleadosestructuraRecordSet!= null)&&(!that.icmEmpleadosestructuraRecordSet.isEmpty())))) {
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
            List<IcmEmpleadosestructuraRecord> theIcmEmpleadosestructuraRecordSet;
            theIcmEmpleadosestructuraRecordSet = (((this.icmEmpleadosestructuraRecordSet!= null)&&(!this.icmEmpleadosestructuraRecordSet.isEmpty()))?this.getIcmEmpleadosestructuraRecordSet():null);
            strategy.appendField(locator, this, "icmEmpleadosestructuraRecordSet", buffer, theIcmEmpleadosestructuraRecordSet, ((this.icmEmpleadosestructuraRecordSet!= null)&&(!this.icmEmpleadosestructuraRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmEmpleadosestructuraRecord> theIcmEmpleadosestructuraRecordSet;
            theIcmEmpleadosestructuraRecordSet = (((this.icmEmpleadosestructuraRecordSet!= null)&&(!this.icmEmpleadosestructuraRecordSet.isEmpty()))?this.getIcmEmpleadosestructuraRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmEmpleadosestructuraRecordSet", theIcmEmpleadosestructuraRecordSet), currentHashCode, theIcmEmpleadosestructuraRecordSet, ((this.icmEmpleadosestructuraRecordSet!= null)&&(!this.icmEmpleadosestructuraRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmEmpleadosestructuraBlock) {
            final IcmEmpleadosestructuraBlock copy = ((IcmEmpleadosestructuraBlock) draftCopy);
            {
                Boolean icmEmpleadosestructuraRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmEmpleadosestructuraRecordSet!= null)&&(!this.icmEmpleadosestructuraRecordSet.isEmpty())));
                if (icmEmpleadosestructuraRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmEmpleadosestructuraRecord> sourceIcmEmpleadosestructuraRecordSet;
                    sourceIcmEmpleadosestructuraRecordSet = (((this.icmEmpleadosestructuraRecordSet!= null)&&(!this.icmEmpleadosestructuraRecordSet.isEmpty()))?this.getIcmEmpleadosestructuraRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmEmpleadosestructuraRecord> copyIcmEmpleadosestructuraRecordSet = ((List<IcmEmpleadosestructuraRecord> ) strategy.copy(LocatorUtils.property(locator, "icmEmpleadosestructuraRecordSet", sourceIcmEmpleadosestructuraRecordSet), sourceIcmEmpleadosestructuraRecordSet, ((this.icmEmpleadosestructuraRecordSet!= null)&&(!this.icmEmpleadosestructuraRecordSet.isEmpty()))));
                    copy.icmEmpleadosestructuraRecordSet = null;
                    if (copyIcmEmpleadosestructuraRecordSet!= null) {
                        List<IcmEmpleadosestructuraRecord> uniqueIcmEmpleadosestructuraRecordSetl = copy.getIcmEmpleadosestructuraRecordSet();
                        uniqueIcmEmpleadosestructuraRecordSetl.addAll(copyIcmEmpleadosestructuraRecordSet);
                    }
                } else {
                    if (icmEmpleadosestructuraRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmEmpleadosestructuraRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmEmpleadosestructuraBlock();
    }

}
