
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
 * <p>Clase Java para Icm_EstadostiendaseccionBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EstadostiendaseccionBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_EstadostiendaseccionRecordSet" type="{http://schemas.meta4.com/}Icm_EstadostiendaseccionRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EstadostiendaseccionBlock", propOrder = {
    "icmEstadostiendaseccionRecordSet"
})
public class IcmEstadostiendaseccionBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_EstadostiendaseccionRecordSet", nillable = true)
    protected List<IcmEstadostiendaseccionRecord> icmEstadostiendaseccionRecordSet;

    /**
     * Gets the value of the icmEstadostiendaseccionRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmEstadostiendaseccionRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmEstadostiendaseccionRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmEstadostiendaseccionRecord }
     * 
     * 
     */
    public List<IcmEstadostiendaseccionRecord> getIcmEstadostiendaseccionRecordSet() {
        if (icmEstadostiendaseccionRecordSet == null) {
            icmEstadostiendaseccionRecordSet = new ArrayList<IcmEstadostiendaseccionRecord>();
        }
        return this.icmEstadostiendaseccionRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmEstadostiendaseccionBlock that = ((IcmEstadostiendaseccionBlock) object);
        {
            List<IcmEstadostiendaseccionRecord> lhsIcmEstadostiendaseccionRecordSet;
            lhsIcmEstadostiendaseccionRecordSet = (((this.icmEstadostiendaseccionRecordSet!= null)&&(!this.icmEstadostiendaseccionRecordSet.isEmpty()))?this.getIcmEstadostiendaseccionRecordSet():null);
            List<IcmEstadostiendaseccionRecord> rhsIcmEstadostiendaseccionRecordSet;
            rhsIcmEstadostiendaseccionRecordSet = (((that.icmEstadostiendaseccionRecordSet!= null)&&(!that.icmEstadostiendaseccionRecordSet.isEmpty()))?that.getIcmEstadostiendaseccionRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmEstadostiendaseccionRecordSet", lhsIcmEstadostiendaseccionRecordSet), LocatorUtils.property(thatLocator, "icmEstadostiendaseccionRecordSet", rhsIcmEstadostiendaseccionRecordSet), lhsIcmEstadostiendaseccionRecordSet, rhsIcmEstadostiendaseccionRecordSet, ((this.icmEstadostiendaseccionRecordSet!= null)&&(!this.icmEstadostiendaseccionRecordSet.isEmpty())), ((that.icmEstadostiendaseccionRecordSet!= null)&&(!that.icmEstadostiendaseccionRecordSet.isEmpty())))) {
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
            List<IcmEstadostiendaseccionRecord> theIcmEstadostiendaseccionRecordSet;
            theIcmEstadostiendaseccionRecordSet = (((this.icmEstadostiendaseccionRecordSet!= null)&&(!this.icmEstadostiendaseccionRecordSet.isEmpty()))?this.getIcmEstadostiendaseccionRecordSet():null);
            strategy.appendField(locator, this, "icmEstadostiendaseccionRecordSet", buffer, theIcmEstadostiendaseccionRecordSet, ((this.icmEstadostiendaseccionRecordSet!= null)&&(!this.icmEstadostiendaseccionRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmEstadostiendaseccionRecord> theIcmEstadostiendaseccionRecordSet;
            theIcmEstadostiendaseccionRecordSet = (((this.icmEstadostiendaseccionRecordSet!= null)&&(!this.icmEstadostiendaseccionRecordSet.isEmpty()))?this.getIcmEstadostiendaseccionRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmEstadostiendaseccionRecordSet", theIcmEstadostiendaseccionRecordSet), currentHashCode, theIcmEstadostiendaseccionRecordSet, ((this.icmEstadostiendaseccionRecordSet!= null)&&(!this.icmEstadostiendaseccionRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmEstadostiendaseccionBlock) {
            final IcmEstadostiendaseccionBlock copy = ((IcmEstadostiendaseccionBlock) draftCopy);
            {
                Boolean icmEstadostiendaseccionRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmEstadostiendaseccionRecordSet!= null)&&(!this.icmEstadostiendaseccionRecordSet.isEmpty())));
                if (icmEstadostiendaseccionRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmEstadostiendaseccionRecord> sourceIcmEstadostiendaseccionRecordSet;
                    sourceIcmEstadostiendaseccionRecordSet = (((this.icmEstadostiendaseccionRecordSet!= null)&&(!this.icmEstadostiendaseccionRecordSet.isEmpty()))?this.getIcmEstadostiendaseccionRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmEstadostiendaseccionRecord> copyIcmEstadostiendaseccionRecordSet = ((List<IcmEstadostiendaseccionRecord> ) strategy.copy(LocatorUtils.property(locator, "icmEstadostiendaseccionRecordSet", sourceIcmEstadostiendaseccionRecordSet), sourceIcmEstadostiendaseccionRecordSet, ((this.icmEstadostiendaseccionRecordSet!= null)&&(!this.icmEstadostiendaseccionRecordSet.isEmpty()))));
                    copy.icmEstadostiendaseccionRecordSet = null;
                    if (copyIcmEstadostiendaseccionRecordSet!= null) {
                        List<IcmEstadostiendaseccionRecord> uniqueIcmEstadostiendaseccionRecordSetl = copy.getIcmEstadostiendaseccionRecordSet();
                        uniqueIcmEstadostiendaseccionRecordSetl.addAll(copyIcmEstadostiendaseccionRecordSet);
                    }
                } else {
                    if (icmEstadostiendaseccionRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmEstadostiendaseccionRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmEstadostiendaseccionBlock();
    }

}
