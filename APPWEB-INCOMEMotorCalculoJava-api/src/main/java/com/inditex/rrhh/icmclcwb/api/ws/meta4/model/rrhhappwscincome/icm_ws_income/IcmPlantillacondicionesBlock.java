
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
 * <p>Clase Java para Icm_PlantillacondicionesBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_PlantillacondicionesBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_PlantillacondicionesRecordSet" type="{http://schemas.meta4.com/}Icm_PlantillacondicionesRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_PlantillacondicionesBlock", propOrder = {
    "icmPlantillacondicionesRecordSet"
})
public class IcmPlantillacondicionesBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "Icm_PlantillacondicionesRecordSet", nillable = true)
    protected List<IcmPlantillacondicionesRecord> icmPlantillacondicionesRecordSet;

    /**
     * Gets the value of the icmPlantillacondicionesRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmPlantillacondicionesRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmPlantillacondicionesRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmPlantillacondicionesRecord }
     * 
     * 
     */
    public List<IcmPlantillacondicionesRecord> getIcmPlantillacondicionesRecordSet() {
        if (icmPlantillacondicionesRecordSet == null) {
            icmPlantillacondicionesRecordSet = new ArrayList<IcmPlantillacondicionesRecord>();
        }
        return this.icmPlantillacondicionesRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmPlantillacondicionesBlock that = ((IcmPlantillacondicionesBlock) object);
        {
            List<IcmPlantillacondicionesRecord> lhsIcmPlantillacondicionesRecordSet;
            lhsIcmPlantillacondicionesRecordSet = (((this.icmPlantillacondicionesRecordSet!= null)&&(!this.icmPlantillacondicionesRecordSet.isEmpty()))?this.getIcmPlantillacondicionesRecordSet():null);
            List<IcmPlantillacondicionesRecord> rhsIcmPlantillacondicionesRecordSet;
            rhsIcmPlantillacondicionesRecordSet = (((that.icmPlantillacondicionesRecordSet!= null)&&(!that.icmPlantillacondicionesRecordSet.isEmpty()))?that.getIcmPlantillacondicionesRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmPlantillacondicionesRecordSet", lhsIcmPlantillacondicionesRecordSet), LocatorUtils.property(thatLocator, "icmPlantillacondicionesRecordSet", rhsIcmPlantillacondicionesRecordSet), lhsIcmPlantillacondicionesRecordSet, rhsIcmPlantillacondicionesRecordSet, ((this.icmPlantillacondicionesRecordSet!= null)&&(!this.icmPlantillacondicionesRecordSet.isEmpty())), ((that.icmPlantillacondicionesRecordSet!= null)&&(!that.icmPlantillacondicionesRecordSet.isEmpty())))) {
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
            List<IcmPlantillacondicionesRecord> theIcmPlantillacondicionesRecordSet;
            theIcmPlantillacondicionesRecordSet = (((this.icmPlantillacondicionesRecordSet!= null)&&(!this.icmPlantillacondicionesRecordSet.isEmpty()))?this.getIcmPlantillacondicionesRecordSet():null);
            strategy.appendField(locator, this, "icmPlantillacondicionesRecordSet", buffer, theIcmPlantillacondicionesRecordSet, ((this.icmPlantillacondicionesRecordSet!= null)&&(!this.icmPlantillacondicionesRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmPlantillacondicionesRecord> theIcmPlantillacondicionesRecordSet;
            theIcmPlantillacondicionesRecordSet = (((this.icmPlantillacondicionesRecordSet!= null)&&(!this.icmPlantillacondicionesRecordSet.isEmpty()))?this.getIcmPlantillacondicionesRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmPlantillacondicionesRecordSet", theIcmPlantillacondicionesRecordSet), currentHashCode, theIcmPlantillacondicionesRecordSet, ((this.icmPlantillacondicionesRecordSet!= null)&&(!this.icmPlantillacondicionesRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmPlantillacondicionesBlock) {
            final IcmPlantillacondicionesBlock copy = ((IcmPlantillacondicionesBlock) draftCopy);
            {
                Boolean icmPlantillacondicionesRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmPlantillacondicionesRecordSet!= null)&&(!this.icmPlantillacondicionesRecordSet.isEmpty())));
                if (icmPlantillacondicionesRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmPlantillacondicionesRecord> sourceIcmPlantillacondicionesRecordSet;
                    sourceIcmPlantillacondicionesRecordSet = (((this.icmPlantillacondicionesRecordSet!= null)&&(!this.icmPlantillacondicionesRecordSet.isEmpty()))?this.getIcmPlantillacondicionesRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmPlantillacondicionesRecord> copyIcmPlantillacondicionesRecordSet = ((List<IcmPlantillacondicionesRecord> ) strategy.copy(LocatorUtils.property(locator, "icmPlantillacondicionesRecordSet", sourceIcmPlantillacondicionesRecordSet), sourceIcmPlantillacondicionesRecordSet, ((this.icmPlantillacondicionesRecordSet!= null)&&(!this.icmPlantillacondicionesRecordSet.isEmpty()))));
                    copy.icmPlantillacondicionesRecordSet = null;
                    if (copyIcmPlantillacondicionesRecordSet!= null) {
                        List<IcmPlantillacondicionesRecord> uniqueIcmPlantillacondicionesRecordSetl = copy.getIcmPlantillacondicionesRecordSet();
                        uniqueIcmPlantillacondicionesRecordSetl.addAll(copyIcmPlantillacondicionesRecordSet);
                    }
                } else {
                    if (icmPlantillacondicionesRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmPlantillacondicionesRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmPlantillacondicionesBlock();
    }

}
