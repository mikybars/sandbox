
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
 * <p>Clase Java para Icm_CondicionesventaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CondicionesventaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_CondicionesventaRecordSet" type="{http://schemas.meta4.com/}Icm_CondicionesventaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CondicionesventaBlock", propOrder = {
    "icmCondicionesventaRecordSet"
})
public class IcmCondicionesventaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_CondicionesventaRecordSet", nillable = true)
    protected List<IcmCondicionesventaRecord> icmCondicionesventaRecordSet;

    /**
     * Gets the value of the icmCondicionesventaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCondicionesventaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCondicionesventaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCondicionesventaRecord }
     * 
     * 
     */
    public List<IcmCondicionesventaRecord> getIcmCondicionesventaRecordSet() {
        if (icmCondicionesventaRecordSet == null) {
            icmCondicionesventaRecordSet = new ArrayList<IcmCondicionesventaRecord>();
        }
        return this.icmCondicionesventaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmCondicionesventaBlock that = ((IcmCondicionesventaBlock) object);
        {
            List<IcmCondicionesventaRecord> lhsIcmCondicionesventaRecordSet;
            lhsIcmCondicionesventaRecordSet = (((this.icmCondicionesventaRecordSet!= null)&&(!this.icmCondicionesventaRecordSet.isEmpty()))?this.getIcmCondicionesventaRecordSet():null);
            List<IcmCondicionesventaRecord> rhsIcmCondicionesventaRecordSet;
            rhsIcmCondicionesventaRecordSet = (((that.icmCondicionesventaRecordSet!= null)&&(!that.icmCondicionesventaRecordSet.isEmpty()))?that.getIcmCondicionesventaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCondicionesventaRecordSet", lhsIcmCondicionesventaRecordSet), LocatorUtils.property(thatLocator, "icmCondicionesventaRecordSet", rhsIcmCondicionesventaRecordSet), lhsIcmCondicionesventaRecordSet, rhsIcmCondicionesventaRecordSet, ((this.icmCondicionesventaRecordSet!= null)&&(!this.icmCondicionesventaRecordSet.isEmpty())), ((that.icmCondicionesventaRecordSet!= null)&&(!that.icmCondicionesventaRecordSet.isEmpty())))) {
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
            List<IcmCondicionesventaRecord> theIcmCondicionesventaRecordSet;
            theIcmCondicionesventaRecordSet = (((this.icmCondicionesventaRecordSet!= null)&&(!this.icmCondicionesventaRecordSet.isEmpty()))?this.getIcmCondicionesventaRecordSet():null);
            strategy.appendField(locator, this, "icmCondicionesventaRecordSet", buffer, theIcmCondicionesventaRecordSet, ((this.icmCondicionesventaRecordSet!= null)&&(!this.icmCondicionesventaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmCondicionesventaRecord> theIcmCondicionesventaRecordSet;
            theIcmCondicionesventaRecordSet = (((this.icmCondicionesventaRecordSet!= null)&&(!this.icmCondicionesventaRecordSet.isEmpty()))?this.getIcmCondicionesventaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCondicionesventaRecordSet", theIcmCondicionesventaRecordSet), currentHashCode, theIcmCondicionesventaRecordSet, ((this.icmCondicionesventaRecordSet!= null)&&(!this.icmCondicionesventaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmCondicionesventaBlock) {
            final IcmCondicionesventaBlock copy = ((IcmCondicionesventaBlock) draftCopy);
            {
                Boolean icmCondicionesventaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmCondicionesventaRecordSet!= null)&&(!this.icmCondicionesventaRecordSet.isEmpty())));
                if (icmCondicionesventaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmCondicionesventaRecord> sourceIcmCondicionesventaRecordSet;
                    sourceIcmCondicionesventaRecordSet = (((this.icmCondicionesventaRecordSet!= null)&&(!this.icmCondicionesventaRecordSet.isEmpty()))?this.getIcmCondicionesventaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmCondicionesventaRecord> copyIcmCondicionesventaRecordSet = ((List<IcmCondicionesventaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmCondicionesventaRecordSet", sourceIcmCondicionesventaRecordSet), sourceIcmCondicionesventaRecordSet, ((this.icmCondicionesventaRecordSet!= null)&&(!this.icmCondicionesventaRecordSet.isEmpty()))));
                    copy.icmCondicionesventaRecordSet = null;
                    if (copyIcmCondicionesventaRecordSet!= null) {
                        List<IcmCondicionesventaRecord> uniqueIcmCondicionesventaRecordSetl = copy.getIcmCondicionesventaRecordSet();
                        uniqueIcmCondicionesventaRecordSetl.addAll(copyIcmCondicionesventaRecordSet);
                    }
                } else {
                    if (icmCondicionesventaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCondicionesventaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmCondicionesventaBlock();
    }

}
