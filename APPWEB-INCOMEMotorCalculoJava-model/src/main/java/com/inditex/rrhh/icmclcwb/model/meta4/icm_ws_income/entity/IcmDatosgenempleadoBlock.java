
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
 * <p>Clase Java para Icm_DatosgenempleadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_DatosgenempleadoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_DatosgenempleadoRecordSet" type="{http://schemas.meta4.com/}Icm_DatosgenempleadoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_DatosgenempleadoBlock", propOrder = {
    "icmDatosgenempleadoRecordSet"
})
public class IcmDatosgenempleadoBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_DatosgenempleadoRecordSet", nillable = true)
    protected List<IcmDatosgenempleadoRecord> icmDatosgenempleadoRecordSet;

    /**
     * Gets the value of the icmDatosgenempleadoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmDatosgenempleadoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmDatosgenempleadoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmDatosgenempleadoRecord }
     * 
     * 
     */
    public List<IcmDatosgenempleadoRecord> getIcmDatosgenempleadoRecordSet() {
        if (icmDatosgenempleadoRecordSet == null) {
            icmDatosgenempleadoRecordSet = new ArrayList<IcmDatosgenempleadoRecord>();
        }
        return this.icmDatosgenempleadoRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmDatosgenempleadoBlock that = ((IcmDatosgenempleadoBlock) object);
        {
            List<IcmDatosgenempleadoRecord> lhsIcmDatosgenempleadoRecordSet;
            lhsIcmDatosgenempleadoRecordSet = (((this.icmDatosgenempleadoRecordSet!= null)&&(!this.icmDatosgenempleadoRecordSet.isEmpty()))?this.getIcmDatosgenempleadoRecordSet():null);
            List<IcmDatosgenempleadoRecord> rhsIcmDatosgenempleadoRecordSet;
            rhsIcmDatosgenempleadoRecordSet = (((that.icmDatosgenempleadoRecordSet!= null)&&(!that.icmDatosgenempleadoRecordSet.isEmpty()))?that.getIcmDatosgenempleadoRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmDatosgenempleadoRecordSet", lhsIcmDatosgenempleadoRecordSet), LocatorUtils.property(thatLocator, "icmDatosgenempleadoRecordSet", rhsIcmDatosgenempleadoRecordSet), lhsIcmDatosgenempleadoRecordSet, rhsIcmDatosgenempleadoRecordSet, ((this.icmDatosgenempleadoRecordSet!= null)&&(!this.icmDatosgenempleadoRecordSet.isEmpty())), ((that.icmDatosgenempleadoRecordSet!= null)&&(!that.icmDatosgenempleadoRecordSet.isEmpty())))) {
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
            List<IcmDatosgenempleadoRecord> theIcmDatosgenempleadoRecordSet;
            theIcmDatosgenempleadoRecordSet = (((this.icmDatosgenempleadoRecordSet!= null)&&(!this.icmDatosgenempleadoRecordSet.isEmpty()))?this.getIcmDatosgenempleadoRecordSet():null);
            strategy.appendField(locator, this, "icmDatosgenempleadoRecordSet", buffer, theIcmDatosgenempleadoRecordSet, ((this.icmDatosgenempleadoRecordSet!= null)&&(!this.icmDatosgenempleadoRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmDatosgenempleadoRecord> theIcmDatosgenempleadoRecordSet;
            theIcmDatosgenempleadoRecordSet = (((this.icmDatosgenempleadoRecordSet!= null)&&(!this.icmDatosgenempleadoRecordSet.isEmpty()))?this.getIcmDatosgenempleadoRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmDatosgenempleadoRecordSet", theIcmDatosgenempleadoRecordSet), currentHashCode, theIcmDatosgenempleadoRecordSet, ((this.icmDatosgenempleadoRecordSet!= null)&&(!this.icmDatosgenempleadoRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmDatosgenempleadoBlock) {
            final IcmDatosgenempleadoBlock copy = ((IcmDatosgenempleadoBlock) draftCopy);
            {
                Boolean icmDatosgenempleadoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmDatosgenempleadoRecordSet!= null)&&(!this.icmDatosgenempleadoRecordSet.isEmpty())));
                if (icmDatosgenempleadoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmDatosgenempleadoRecord> sourceIcmDatosgenempleadoRecordSet;
                    sourceIcmDatosgenempleadoRecordSet = (((this.icmDatosgenempleadoRecordSet!= null)&&(!this.icmDatosgenempleadoRecordSet.isEmpty()))?this.getIcmDatosgenempleadoRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmDatosgenempleadoRecord> copyIcmDatosgenempleadoRecordSet = ((List<IcmDatosgenempleadoRecord> ) strategy.copy(LocatorUtils.property(locator, "icmDatosgenempleadoRecordSet", sourceIcmDatosgenempleadoRecordSet), sourceIcmDatosgenempleadoRecordSet, ((this.icmDatosgenempleadoRecordSet!= null)&&(!this.icmDatosgenempleadoRecordSet.isEmpty()))));
                    copy.icmDatosgenempleadoRecordSet = null;
                    if (copyIcmDatosgenempleadoRecordSet!= null) {
                        List<IcmDatosgenempleadoRecord> uniqueIcmDatosgenempleadoRecordSetl = copy.getIcmDatosgenempleadoRecordSet();
                        uniqueIcmDatosgenempleadoRecordSetl.addAll(copyIcmDatosgenempleadoRecordSet);
                    }
                } else {
                    if (icmDatosgenempleadoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmDatosgenempleadoRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmDatosgenempleadoBlock();
    }

}
