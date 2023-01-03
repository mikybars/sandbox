
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
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
 * <p>Clase Java para Icm_ListaventacongeladaBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ListaventacongeladaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListaventacongeladaRecordSet" type="{http://schemas.meta4.com/}Icm_ListaventacongeladaRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListaventacongeladaBlock", propOrder = {
    "icmListaventacongeladaRecordSet"
})
public class IcmListaventacongeladaBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ListaventacongeladaRecordSet", nillable = true)
    protected List<IcmListaventacongeladaRecord> icmListaventacongeladaRecordSet;

    /**
     * Gets the value of the icmListaventacongeladaRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListaventacongeladaRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListaventacongeladaRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListaventacongeladaRecord }
     *
     *
     */
    public List<IcmListaventacongeladaRecord> getIcmListaventacongeladaRecordSet() {
        if (icmListaventacongeladaRecordSet == null) {
            icmListaventacongeladaRecordSet = new ArrayList<IcmListaventacongeladaRecord>();
        }
        return this.icmListaventacongeladaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListaventacongeladaBlock that = ((IcmListaventacongeladaBlock) object);
        {
            List<IcmListaventacongeladaRecord> lhsIcmListaventacongeladaRecordSet;
            lhsIcmListaventacongeladaRecordSet = (((this.icmListaventacongeladaRecordSet!= null)&&(!this.icmListaventacongeladaRecordSet.isEmpty()))?this.getIcmListaventacongeladaRecordSet():null);
            List<IcmListaventacongeladaRecord> rhsIcmListaventacongeladaRecordSet;
            rhsIcmListaventacongeladaRecordSet = (((that.icmListaventacongeladaRecordSet!= null)&&(!that.icmListaventacongeladaRecordSet.isEmpty()))?that.getIcmListaventacongeladaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListaventacongeladaRecordSet", lhsIcmListaventacongeladaRecordSet), LocatorUtils.property(thatLocator, "icmListaventacongeladaRecordSet", rhsIcmListaventacongeladaRecordSet), lhsIcmListaventacongeladaRecordSet, rhsIcmListaventacongeladaRecordSet, ((this.icmListaventacongeladaRecordSet!= null)&&(!this.icmListaventacongeladaRecordSet.isEmpty())), ((that.icmListaventacongeladaRecordSet!= null)&&(!that.icmListaventacongeladaRecordSet.isEmpty())))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
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
            List<IcmListaventacongeladaRecord> theIcmListaventacongeladaRecordSet;
            theIcmListaventacongeladaRecordSet = (((this.icmListaventacongeladaRecordSet!= null)&&(!this.icmListaventacongeladaRecordSet.isEmpty()))?this.getIcmListaventacongeladaRecordSet():null);
            strategy.appendField(locator, this, "icmListaventacongeladaRecordSet", buffer, theIcmListaventacongeladaRecordSet, ((this.icmListaventacongeladaRecordSet!= null)&&(!this.icmListaventacongeladaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmListaventacongeladaRecord> theIcmListaventacongeladaRecordSet;
            theIcmListaventacongeladaRecordSet = (((this.icmListaventacongeladaRecordSet!= null)&&(!this.icmListaventacongeladaRecordSet.isEmpty()))?this.getIcmListaventacongeladaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListaventacongeladaRecordSet", theIcmListaventacongeladaRecordSet), currentHashCode, theIcmListaventacongeladaRecordSet, ((this.icmListaventacongeladaRecordSet!= null)&&(!this.icmListaventacongeladaRecordSet.isEmpty())));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof IcmListaventacongeladaBlock) {
            final IcmListaventacongeladaBlock copy = ((IcmListaventacongeladaBlock) draftCopy);
            {
                Boolean icmListaventacongeladaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListaventacongeladaRecordSet!= null)&&(!this.icmListaventacongeladaRecordSet.isEmpty())));
                if (icmListaventacongeladaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListaventacongeladaRecord> sourceIcmListaventacongeladaRecordSet;
                    sourceIcmListaventacongeladaRecordSet = (((this.icmListaventacongeladaRecordSet!= null)&&(!this.icmListaventacongeladaRecordSet.isEmpty()))?this.getIcmListaventacongeladaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListaventacongeladaRecord> copyIcmListaventacongeladaRecordSet = ((List<IcmListaventacongeladaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListaventacongeladaRecordSet", sourceIcmListaventacongeladaRecordSet), sourceIcmListaventacongeladaRecordSet, ((this.icmListaventacongeladaRecordSet!= null)&&(!this.icmListaventacongeladaRecordSet.isEmpty()))));
                    copy.icmListaventacongeladaRecordSet = null;
                    if (copyIcmListaventacongeladaRecordSet!= null) {
                        List<IcmListaventacongeladaRecord> uniqueIcmListaventacongeladaRecordSetl = copy.getIcmListaventacongeladaRecordSet();
                        uniqueIcmListaventacongeladaRecordSetl.addAll(copyIcmListaventacongeladaRecordSet);
                    }
                } else {
                    if (icmListaventacongeladaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListaventacongeladaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListaventacongeladaBlock();
    }

}
