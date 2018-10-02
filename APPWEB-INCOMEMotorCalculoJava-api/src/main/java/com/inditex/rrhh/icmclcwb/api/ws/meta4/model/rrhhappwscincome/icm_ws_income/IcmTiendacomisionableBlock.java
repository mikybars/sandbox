
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
 * <p>Clase Java para Icm_TiendacomisionableBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_TiendacomisionableBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_TiendacomisionableRecordSet" type="{http://schemas.meta4.com/}Icm_TiendacomisionableRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_TiendacomisionableBlock", propOrder = {
    "icmTiendacomisionableRecordSet"
})
public class IcmTiendacomisionableBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_TiendacomisionableRecordSet", nillable = true)
    protected List<IcmTiendacomisionableRecord> icmTiendacomisionableRecordSet;

    /**
     * Gets the value of the icmTiendacomisionableRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmTiendacomisionableRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmTiendacomisionableRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmTiendacomisionableRecord }
     * 
     * 
     */
    public List<IcmTiendacomisionableRecord> getIcmTiendacomisionableRecordSet() {
        if (icmTiendacomisionableRecordSet == null) {
            icmTiendacomisionableRecordSet = new ArrayList<IcmTiendacomisionableRecord>();
        }
        return this.icmTiendacomisionableRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmTiendacomisionableBlock that = ((IcmTiendacomisionableBlock) object);
        {
            List<IcmTiendacomisionableRecord> lhsIcmTiendacomisionableRecordSet;
            lhsIcmTiendacomisionableRecordSet = (((this.icmTiendacomisionableRecordSet!= null)&&(!this.icmTiendacomisionableRecordSet.isEmpty()))?this.getIcmTiendacomisionableRecordSet():null);
            List<IcmTiendacomisionableRecord> rhsIcmTiendacomisionableRecordSet;
            rhsIcmTiendacomisionableRecordSet = (((that.icmTiendacomisionableRecordSet!= null)&&(!that.icmTiendacomisionableRecordSet.isEmpty()))?that.getIcmTiendacomisionableRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmTiendacomisionableRecordSet", lhsIcmTiendacomisionableRecordSet), LocatorUtils.property(thatLocator, "icmTiendacomisionableRecordSet", rhsIcmTiendacomisionableRecordSet), lhsIcmTiendacomisionableRecordSet, rhsIcmTiendacomisionableRecordSet, ((this.icmTiendacomisionableRecordSet!= null)&&(!this.icmTiendacomisionableRecordSet.isEmpty())), ((that.icmTiendacomisionableRecordSet!= null)&&(!that.icmTiendacomisionableRecordSet.isEmpty())))) {
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
            List<IcmTiendacomisionableRecord> theIcmTiendacomisionableRecordSet;
            theIcmTiendacomisionableRecordSet = (((this.icmTiendacomisionableRecordSet!= null)&&(!this.icmTiendacomisionableRecordSet.isEmpty()))?this.getIcmTiendacomisionableRecordSet():null);
            strategy.appendField(locator, this, "icmTiendacomisionableRecordSet", buffer, theIcmTiendacomisionableRecordSet, ((this.icmTiendacomisionableRecordSet!= null)&&(!this.icmTiendacomisionableRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmTiendacomisionableRecord> theIcmTiendacomisionableRecordSet;
            theIcmTiendacomisionableRecordSet = (((this.icmTiendacomisionableRecordSet!= null)&&(!this.icmTiendacomisionableRecordSet.isEmpty()))?this.getIcmTiendacomisionableRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmTiendacomisionableRecordSet", theIcmTiendacomisionableRecordSet), currentHashCode, theIcmTiendacomisionableRecordSet, ((this.icmTiendacomisionableRecordSet!= null)&&(!this.icmTiendacomisionableRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmTiendacomisionableBlock) {
            final IcmTiendacomisionableBlock copy = ((IcmTiendacomisionableBlock) draftCopy);
            {
                Boolean icmTiendacomisionableRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmTiendacomisionableRecordSet!= null)&&(!this.icmTiendacomisionableRecordSet.isEmpty())));
                if (icmTiendacomisionableRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmTiendacomisionableRecord> sourceIcmTiendacomisionableRecordSet;
                    sourceIcmTiendacomisionableRecordSet = (((this.icmTiendacomisionableRecordSet!= null)&&(!this.icmTiendacomisionableRecordSet.isEmpty()))?this.getIcmTiendacomisionableRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmTiendacomisionableRecord> copyIcmTiendacomisionableRecordSet = ((List<IcmTiendacomisionableRecord> ) strategy.copy(LocatorUtils.property(locator, "icmTiendacomisionableRecordSet", sourceIcmTiendacomisionableRecordSet), sourceIcmTiendacomisionableRecordSet, ((this.icmTiendacomisionableRecordSet!= null)&&(!this.icmTiendacomisionableRecordSet.isEmpty()))));
                    copy.icmTiendacomisionableRecordSet = null;
                    if (copyIcmTiendacomisionableRecordSet!= null) {
                        List<IcmTiendacomisionableRecord> uniqueIcmTiendacomisionableRecordSetl = copy.getIcmTiendacomisionableRecordSet();
                        uniqueIcmTiendacomisionableRecordSetl.addAll(copyIcmTiendacomisionableRecordSet);
                    }
                } else {
                    if (icmTiendacomisionableRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmTiendacomisionableRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmTiendacomisionableBlock();
    }

}
