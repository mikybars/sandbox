
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
 * <p>Clase Java para Icm_CabeceratiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CabeceratiendaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_CabeceratiendaRecordSet" type="{http://schemas.meta4.com/}Icm_CabeceratiendaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CabeceratiendaBlock", propOrder = {
    "icmCabeceratiendaRecordSet"
})
public class IcmCabeceratiendaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_CabeceratiendaRecordSet", nillable = true)
    protected List<IcmCabeceratiendaRecord> icmCabeceratiendaRecordSet;

    /**
     * Gets the value of the icmCabeceratiendaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCabeceratiendaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCabeceratiendaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCabeceratiendaRecord }
     * 
     * 
     */
    public List<IcmCabeceratiendaRecord> getIcmCabeceratiendaRecordSet() {
        if (icmCabeceratiendaRecordSet == null) {
            icmCabeceratiendaRecordSet = new ArrayList<IcmCabeceratiendaRecord>();
        }
        return this.icmCabeceratiendaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmCabeceratiendaBlock that = ((IcmCabeceratiendaBlock) object);
        {
            List<IcmCabeceratiendaRecord> lhsIcmCabeceratiendaRecordSet;
            lhsIcmCabeceratiendaRecordSet = (((this.icmCabeceratiendaRecordSet!= null)&&(!this.icmCabeceratiendaRecordSet.isEmpty()))?this.getIcmCabeceratiendaRecordSet():null);
            List<IcmCabeceratiendaRecord> rhsIcmCabeceratiendaRecordSet;
            rhsIcmCabeceratiendaRecordSet = (((that.icmCabeceratiendaRecordSet!= null)&&(!that.icmCabeceratiendaRecordSet.isEmpty()))?that.getIcmCabeceratiendaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCabeceratiendaRecordSet", lhsIcmCabeceratiendaRecordSet), LocatorUtils.property(thatLocator, "icmCabeceratiendaRecordSet", rhsIcmCabeceratiendaRecordSet), lhsIcmCabeceratiendaRecordSet, rhsIcmCabeceratiendaRecordSet, ((this.icmCabeceratiendaRecordSet!= null)&&(!this.icmCabeceratiendaRecordSet.isEmpty())), ((that.icmCabeceratiendaRecordSet!= null)&&(!that.icmCabeceratiendaRecordSet.isEmpty())))) {
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
            List<IcmCabeceratiendaRecord> theIcmCabeceratiendaRecordSet;
            theIcmCabeceratiendaRecordSet = (((this.icmCabeceratiendaRecordSet!= null)&&(!this.icmCabeceratiendaRecordSet.isEmpty()))?this.getIcmCabeceratiendaRecordSet():null);
            strategy.appendField(locator, this, "icmCabeceratiendaRecordSet", buffer, theIcmCabeceratiendaRecordSet, ((this.icmCabeceratiendaRecordSet!= null)&&(!this.icmCabeceratiendaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmCabeceratiendaRecord> theIcmCabeceratiendaRecordSet;
            theIcmCabeceratiendaRecordSet = (((this.icmCabeceratiendaRecordSet!= null)&&(!this.icmCabeceratiendaRecordSet.isEmpty()))?this.getIcmCabeceratiendaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCabeceratiendaRecordSet", theIcmCabeceratiendaRecordSet), currentHashCode, theIcmCabeceratiendaRecordSet, ((this.icmCabeceratiendaRecordSet!= null)&&(!this.icmCabeceratiendaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmCabeceratiendaBlock) {
            final IcmCabeceratiendaBlock copy = ((IcmCabeceratiendaBlock) draftCopy);
            {
                Boolean icmCabeceratiendaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmCabeceratiendaRecordSet!= null)&&(!this.icmCabeceratiendaRecordSet.isEmpty())));
                if (icmCabeceratiendaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmCabeceratiendaRecord> sourceIcmCabeceratiendaRecordSet;
                    sourceIcmCabeceratiendaRecordSet = (((this.icmCabeceratiendaRecordSet!= null)&&(!this.icmCabeceratiendaRecordSet.isEmpty()))?this.getIcmCabeceratiendaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmCabeceratiendaRecord> copyIcmCabeceratiendaRecordSet = ((List<IcmCabeceratiendaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmCabeceratiendaRecordSet", sourceIcmCabeceratiendaRecordSet), sourceIcmCabeceratiendaRecordSet, ((this.icmCabeceratiendaRecordSet!= null)&&(!this.icmCabeceratiendaRecordSet.isEmpty()))));
                    copy.icmCabeceratiendaRecordSet = null;
                    if (copyIcmCabeceratiendaRecordSet!= null) {
                        List<IcmCabeceratiendaRecord> uniqueIcmCabeceratiendaRecordSetl = copy.getIcmCabeceratiendaRecordSet();
                        uniqueIcmCabeceratiendaRecordSetl.addAll(copyIcmCabeceratiendaRecordSet);
                    }
                } else {
                    if (icmCabeceratiendaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCabeceratiendaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmCabeceratiendaBlock();
    }

}
