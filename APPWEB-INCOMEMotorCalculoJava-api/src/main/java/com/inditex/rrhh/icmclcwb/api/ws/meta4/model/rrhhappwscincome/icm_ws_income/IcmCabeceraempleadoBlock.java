
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
 * <p>Clase Java para Icm_CabeceraempleadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CabeceraempleadoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_CabeceraempleadoRecordSet" type="{http://schemas.meta4.com/}Icm_CabeceraempleadoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CabeceraempleadoBlock", propOrder = {
    "icmCabeceraempleadoRecordSet"
})
public class IcmCabeceraempleadoBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_CabeceraempleadoRecordSet", nillable = true)
    protected List<IcmCabeceraempleadoRecord> icmCabeceraempleadoRecordSet;

    /**
     * Gets the value of the icmCabeceraempleadoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCabeceraempleadoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCabeceraempleadoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCabeceraempleadoRecord }
     * 
     * 
     */
    public List<IcmCabeceraempleadoRecord> getIcmCabeceraempleadoRecordSet() {
        if (icmCabeceraempleadoRecordSet == null) {
            icmCabeceraempleadoRecordSet = new ArrayList<IcmCabeceraempleadoRecord>();
        }
        return this.icmCabeceraempleadoRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmCabeceraempleadoBlock that = ((IcmCabeceraempleadoBlock) object);
        {
            List<IcmCabeceraempleadoRecord> lhsIcmCabeceraempleadoRecordSet;
            lhsIcmCabeceraempleadoRecordSet = (((this.icmCabeceraempleadoRecordSet!= null)&&(!this.icmCabeceraempleadoRecordSet.isEmpty()))?this.getIcmCabeceraempleadoRecordSet():null);
            List<IcmCabeceraempleadoRecord> rhsIcmCabeceraempleadoRecordSet;
            rhsIcmCabeceraempleadoRecordSet = (((that.icmCabeceraempleadoRecordSet!= null)&&(!that.icmCabeceraempleadoRecordSet.isEmpty()))?that.getIcmCabeceraempleadoRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCabeceraempleadoRecordSet", lhsIcmCabeceraempleadoRecordSet), LocatorUtils.property(thatLocator, "icmCabeceraempleadoRecordSet", rhsIcmCabeceraempleadoRecordSet), lhsIcmCabeceraempleadoRecordSet, rhsIcmCabeceraempleadoRecordSet, ((this.icmCabeceraempleadoRecordSet!= null)&&(!this.icmCabeceraempleadoRecordSet.isEmpty())), ((that.icmCabeceraempleadoRecordSet!= null)&&(!that.icmCabeceraempleadoRecordSet.isEmpty())))) {
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
            List<IcmCabeceraempleadoRecord> theIcmCabeceraempleadoRecordSet;
            theIcmCabeceraempleadoRecordSet = (((this.icmCabeceraempleadoRecordSet!= null)&&(!this.icmCabeceraempleadoRecordSet.isEmpty()))?this.getIcmCabeceraempleadoRecordSet():null);
            strategy.appendField(locator, this, "icmCabeceraempleadoRecordSet", buffer, theIcmCabeceraempleadoRecordSet, ((this.icmCabeceraempleadoRecordSet!= null)&&(!this.icmCabeceraempleadoRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmCabeceraempleadoRecord> theIcmCabeceraempleadoRecordSet;
            theIcmCabeceraempleadoRecordSet = (((this.icmCabeceraempleadoRecordSet!= null)&&(!this.icmCabeceraempleadoRecordSet.isEmpty()))?this.getIcmCabeceraempleadoRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCabeceraempleadoRecordSet", theIcmCabeceraempleadoRecordSet), currentHashCode, theIcmCabeceraempleadoRecordSet, ((this.icmCabeceraempleadoRecordSet!= null)&&(!this.icmCabeceraempleadoRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmCabeceraempleadoBlock) {
            final IcmCabeceraempleadoBlock copy = ((IcmCabeceraempleadoBlock) draftCopy);
            {
                Boolean icmCabeceraempleadoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmCabeceraempleadoRecordSet!= null)&&(!this.icmCabeceraempleadoRecordSet.isEmpty())));
                if (icmCabeceraempleadoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmCabeceraempleadoRecord> sourceIcmCabeceraempleadoRecordSet;
                    sourceIcmCabeceraempleadoRecordSet = (((this.icmCabeceraempleadoRecordSet!= null)&&(!this.icmCabeceraempleadoRecordSet.isEmpty()))?this.getIcmCabeceraempleadoRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmCabeceraempleadoRecord> copyIcmCabeceraempleadoRecordSet = ((List<IcmCabeceraempleadoRecord> ) strategy.copy(LocatorUtils.property(locator, "icmCabeceraempleadoRecordSet", sourceIcmCabeceraempleadoRecordSet), sourceIcmCabeceraempleadoRecordSet, ((this.icmCabeceraempleadoRecordSet!= null)&&(!this.icmCabeceraempleadoRecordSet.isEmpty()))));
                    copy.icmCabeceraempleadoRecordSet = null;
                    if (copyIcmCabeceraempleadoRecordSet!= null) {
                        List<IcmCabeceraempleadoRecord> uniqueIcmCabeceraempleadoRecordSetl = copy.getIcmCabeceraempleadoRecordSet();
                        uniqueIcmCabeceraempleadoRecordSetl.addAll(copyIcmCabeceraempleadoRecordSet);
                    }
                } else {
                    if (icmCabeceraempleadoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCabeceraempleadoRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmCabeceraempleadoBlock();
    }

}
