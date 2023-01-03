
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
 * <p>Clase Java para Icm_ListapresenciamanwlocBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ListapresenciamanwlocBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ListapresenciamanwlocRecordSet" type="{http://schemas.meta4.com/}Icm_ListapresenciamanwlocRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListapresenciamanwlocBlock", propOrder = {
    "icmListapresenciamanwlocRecordSet"
})
public class IcmListapresenciamanwlocBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ListapresenciamanwlocRecordSet", nillable = true)
    protected List<IcmListapresenciamanwlocRecord> icmListapresenciamanwlocRecordSet;

    /**
     * Gets the value of the icmListapresenciamanwlocRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListapresenciamanwlocRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListapresenciamanwlocRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListapresenciamanwlocRecord }
     *
     *
     */
    public List<IcmListapresenciamanwlocRecord> getIcmListapresenciamanwlocRecordSet() {
        if (icmListapresenciamanwlocRecordSet == null) {
            icmListapresenciamanwlocRecordSet = new ArrayList<IcmListapresenciamanwlocRecord>();
        }
        return this.icmListapresenciamanwlocRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListapresenciamanwlocBlock that = ((IcmListapresenciamanwlocBlock) object);
        {
            List<IcmListapresenciamanwlocRecord> lhsIcmListapresenciamanwlocRecordSet;
            lhsIcmListapresenciamanwlocRecordSet = (((this.icmListapresenciamanwlocRecordSet!= null)&&(!this.icmListapresenciamanwlocRecordSet.isEmpty()))?this.getIcmListapresenciamanwlocRecordSet():null);
            List<IcmListapresenciamanwlocRecord> rhsIcmListapresenciamanwlocRecordSet;
            rhsIcmListapresenciamanwlocRecordSet = (((that.icmListapresenciamanwlocRecordSet!= null)&&(!that.icmListapresenciamanwlocRecordSet.isEmpty()))?that.getIcmListapresenciamanwlocRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListapresenciamanwlocRecordSet", lhsIcmListapresenciamanwlocRecordSet), LocatorUtils.property(thatLocator, "icmListapresenciamanwlocRecordSet", rhsIcmListapresenciamanwlocRecordSet), lhsIcmListapresenciamanwlocRecordSet, rhsIcmListapresenciamanwlocRecordSet, ((this.icmListapresenciamanwlocRecordSet!= null)&&(!this.icmListapresenciamanwlocRecordSet.isEmpty())), ((that.icmListapresenciamanwlocRecordSet!= null)&&(!that.icmListapresenciamanwlocRecordSet.isEmpty())))) {
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
            List<IcmListapresenciamanwlocRecord> theIcmListapresenciamanwlocRecordSet;
            theIcmListapresenciamanwlocRecordSet = (((this.icmListapresenciamanwlocRecordSet!= null)&&(!this.icmListapresenciamanwlocRecordSet.isEmpty()))?this.getIcmListapresenciamanwlocRecordSet():null);
            strategy.appendField(locator, this, "icmListapresenciamanwlocRecordSet", buffer, theIcmListapresenciamanwlocRecordSet, ((this.icmListapresenciamanwlocRecordSet!= null)&&(!this.icmListapresenciamanwlocRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmListapresenciamanwlocRecord> theIcmListapresenciamanwlocRecordSet;
            theIcmListapresenciamanwlocRecordSet = (((this.icmListapresenciamanwlocRecordSet!= null)&&(!this.icmListapresenciamanwlocRecordSet.isEmpty()))?this.getIcmListapresenciamanwlocRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListapresenciamanwlocRecordSet", theIcmListapresenciamanwlocRecordSet), currentHashCode, theIcmListapresenciamanwlocRecordSet, ((this.icmListapresenciamanwlocRecordSet!= null)&&(!this.icmListapresenciamanwlocRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmListapresenciamanwlocBlock) {
            final IcmListapresenciamanwlocBlock copy = ((IcmListapresenciamanwlocBlock) draftCopy);
            {
                Boolean icmListapresenciamanwlocRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListapresenciamanwlocRecordSet!= null)&&(!this.icmListapresenciamanwlocRecordSet.isEmpty())));
                if (icmListapresenciamanwlocRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListapresenciamanwlocRecord> sourceIcmListapresenciamanwlocRecordSet;
                    sourceIcmListapresenciamanwlocRecordSet = (((this.icmListapresenciamanwlocRecordSet!= null)&&(!this.icmListapresenciamanwlocRecordSet.isEmpty()))?this.getIcmListapresenciamanwlocRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListapresenciamanwlocRecord> copyIcmListapresenciamanwlocRecordSet = ((List<IcmListapresenciamanwlocRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListapresenciamanwlocRecordSet", sourceIcmListapresenciamanwlocRecordSet), sourceIcmListapresenciamanwlocRecordSet, ((this.icmListapresenciamanwlocRecordSet!= null)&&(!this.icmListapresenciamanwlocRecordSet.isEmpty()))));
                    copy.icmListapresenciamanwlocRecordSet = null;
                    if (copyIcmListapresenciamanwlocRecordSet!= null) {
                        List<IcmListapresenciamanwlocRecord> uniqueIcmListapresenciamanwlocRecordSetl = copy.getIcmListapresenciamanwlocRecordSet();
                        uniqueIcmListapresenciamanwlocRecordSetl.addAll(copyIcmListapresenciamanwlocRecordSet);
                    }
                } else {
                    if (icmListapresenciamanwlocRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListapresenciamanwlocRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListapresenciamanwlocBlock();
    }

}
