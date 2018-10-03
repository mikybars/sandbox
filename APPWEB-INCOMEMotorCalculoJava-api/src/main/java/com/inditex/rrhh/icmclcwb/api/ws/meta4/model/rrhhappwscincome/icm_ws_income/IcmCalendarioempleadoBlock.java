
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
 * <p>Clase Java para Icm_CalendarioempleadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CalendarioempleadoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_CalendarioempleadoRecordSet" type="{http://schemas.meta4.com/}Icm_CalendarioempleadoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CalendarioempleadoBlock", propOrder = {
    "icmCalendarioempleadoRecordSet"
})
public class IcmCalendarioempleadoBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_CalendarioempleadoRecordSet", nillable = true)
    protected List<IcmCalendarioempleadoRecord> icmCalendarioempleadoRecordSet;

    /**
     * Gets the value of the icmCalendarioempleadoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCalendarioempleadoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCalendarioempleadoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCalendarioempleadoRecord }
     * 
     * 
     */
    public List<IcmCalendarioempleadoRecord> getIcmCalendarioempleadoRecordSet() {
        if (icmCalendarioempleadoRecordSet == null) {
            icmCalendarioempleadoRecordSet = new ArrayList<IcmCalendarioempleadoRecord>();
        }
        return this.icmCalendarioempleadoRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmCalendarioempleadoBlock that = ((IcmCalendarioempleadoBlock) object);
        {
            List<IcmCalendarioempleadoRecord> lhsIcmCalendarioempleadoRecordSet;
            lhsIcmCalendarioempleadoRecordSet = (((this.icmCalendarioempleadoRecordSet!= null)&&(!this.icmCalendarioempleadoRecordSet.isEmpty()))?this.getIcmCalendarioempleadoRecordSet():null);
            List<IcmCalendarioempleadoRecord> rhsIcmCalendarioempleadoRecordSet;
            rhsIcmCalendarioempleadoRecordSet = (((that.icmCalendarioempleadoRecordSet!= null)&&(!that.icmCalendarioempleadoRecordSet.isEmpty()))?that.getIcmCalendarioempleadoRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCalendarioempleadoRecordSet", lhsIcmCalendarioempleadoRecordSet), LocatorUtils.property(thatLocator, "icmCalendarioempleadoRecordSet", rhsIcmCalendarioempleadoRecordSet), lhsIcmCalendarioempleadoRecordSet, rhsIcmCalendarioempleadoRecordSet, ((this.icmCalendarioempleadoRecordSet!= null)&&(!this.icmCalendarioempleadoRecordSet.isEmpty())), ((that.icmCalendarioempleadoRecordSet!= null)&&(!that.icmCalendarioempleadoRecordSet.isEmpty())))) {
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
            List<IcmCalendarioempleadoRecord> theIcmCalendarioempleadoRecordSet;
            theIcmCalendarioempleadoRecordSet = (((this.icmCalendarioempleadoRecordSet!= null)&&(!this.icmCalendarioempleadoRecordSet.isEmpty()))?this.getIcmCalendarioempleadoRecordSet():null);
            strategy.appendField(locator, this, "icmCalendarioempleadoRecordSet", buffer, theIcmCalendarioempleadoRecordSet, ((this.icmCalendarioempleadoRecordSet!= null)&&(!this.icmCalendarioempleadoRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmCalendarioempleadoRecord> theIcmCalendarioempleadoRecordSet;
            theIcmCalendarioempleadoRecordSet = (((this.icmCalendarioempleadoRecordSet!= null)&&(!this.icmCalendarioempleadoRecordSet.isEmpty()))?this.getIcmCalendarioempleadoRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCalendarioempleadoRecordSet", theIcmCalendarioempleadoRecordSet), currentHashCode, theIcmCalendarioempleadoRecordSet, ((this.icmCalendarioempleadoRecordSet!= null)&&(!this.icmCalendarioempleadoRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmCalendarioempleadoBlock) {
            final IcmCalendarioempleadoBlock copy = ((IcmCalendarioempleadoBlock) draftCopy);
            {
                Boolean icmCalendarioempleadoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmCalendarioempleadoRecordSet!= null)&&(!this.icmCalendarioempleadoRecordSet.isEmpty())));
                if (icmCalendarioempleadoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmCalendarioempleadoRecord> sourceIcmCalendarioempleadoRecordSet;
                    sourceIcmCalendarioempleadoRecordSet = (((this.icmCalendarioempleadoRecordSet!= null)&&(!this.icmCalendarioempleadoRecordSet.isEmpty()))?this.getIcmCalendarioempleadoRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmCalendarioempleadoRecord> copyIcmCalendarioempleadoRecordSet = ((List<IcmCalendarioempleadoRecord> ) strategy.copy(LocatorUtils.property(locator, "icmCalendarioempleadoRecordSet", sourceIcmCalendarioempleadoRecordSet), sourceIcmCalendarioempleadoRecordSet, ((this.icmCalendarioempleadoRecordSet!= null)&&(!this.icmCalendarioempleadoRecordSet.isEmpty()))));
                    copy.icmCalendarioempleadoRecordSet = null;
                    if (copyIcmCalendarioempleadoRecordSet!= null) {
                        List<IcmCalendarioempleadoRecord> uniqueIcmCalendarioempleadoRecordSetl = copy.getIcmCalendarioempleadoRecordSet();
                        uniqueIcmCalendarioempleadoRecordSetl.addAll(copyIcmCalendarioempleadoRecordSet);
                    }
                } else {
                    if (icmCalendarioempleadoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCalendarioempleadoRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmCalendarioempleadoBlock();
    }

}
