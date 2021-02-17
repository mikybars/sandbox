
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
 * <p>Clase Java para Icm_ParamcaltiendasBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcaltiendasBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcaltiendasRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcaltiendasRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcaltiendasBlock", propOrder = {
    "icmParamcaltiendasRecordSet"
})
public class IcmParamcaltiendasBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ParamcaltiendasRecordSet", nillable = true)
    protected List<IcmParamcaltiendasRecord> icmParamcaltiendasRecordSet;

    /**
     * Gets the value of the icmParamcaltiendasRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParamcaltiendasRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParamcaltiendasRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParamcaltiendasRecord }
     *
     *
     */
    public List<IcmParamcaltiendasRecord> getIcmParamcaltiendasRecordSet() {
        if (icmParamcaltiendasRecordSet == null) {
            icmParamcaltiendasRecordSet = new ArrayList<IcmParamcaltiendasRecord>();
        }
        return this.icmParamcaltiendasRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParamcaltiendasBlock that = ((IcmParamcaltiendasBlock) object);
        {
            List<IcmParamcaltiendasRecord> lhsIcmParamcaltiendasRecordSet;
            lhsIcmParamcaltiendasRecordSet = (((this.icmParamcaltiendasRecordSet!= null)&&(!this.icmParamcaltiendasRecordSet.isEmpty()))?this.getIcmParamcaltiendasRecordSet():null);
            List<IcmParamcaltiendasRecord> rhsIcmParamcaltiendasRecordSet;
            rhsIcmParamcaltiendasRecordSet = (((that.icmParamcaltiendasRecordSet!= null)&&(!that.icmParamcaltiendasRecordSet.isEmpty()))?that.getIcmParamcaltiendasRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcaltiendasRecordSet", lhsIcmParamcaltiendasRecordSet), LocatorUtils.property(thatLocator, "icmParamcaltiendasRecordSet", rhsIcmParamcaltiendasRecordSet), lhsIcmParamcaltiendasRecordSet, rhsIcmParamcaltiendasRecordSet, ((this.icmParamcaltiendasRecordSet!= null)&&(!this.icmParamcaltiendasRecordSet.isEmpty())), ((that.icmParamcaltiendasRecordSet!= null)&&(!that.icmParamcaltiendasRecordSet.isEmpty())))) {
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
            List<IcmParamcaltiendasRecord> theIcmParamcaltiendasRecordSet;
            theIcmParamcaltiendasRecordSet = (((this.icmParamcaltiendasRecordSet!= null)&&(!this.icmParamcaltiendasRecordSet.isEmpty()))?this.getIcmParamcaltiendasRecordSet():null);
            strategy.appendField(locator, this, "icmParamcaltiendasRecordSet", buffer, theIcmParamcaltiendasRecordSet, ((this.icmParamcaltiendasRecordSet!= null)&&(!this.icmParamcaltiendasRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmParamcaltiendasRecord> theIcmParamcaltiendasRecordSet;
            theIcmParamcaltiendasRecordSet = (((this.icmParamcaltiendasRecordSet!= null)&&(!this.icmParamcaltiendasRecordSet.isEmpty()))?this.getIcmParamcaltiendasRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcaltiendasRecordSet", theIcmParamcaltiendasRecordSet), currentHashCode, theIcmParamcaltiendasRecordSet, ((this.icmParamcaltiendasRecordSet!= null)&&(!this.icmParamcaltiendasRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParamcaltiendasBlock) {
            final IcmParamcaltiendasBlock copy = ((IcmParamcaltiendasBlock) draftCopy);
            {
                Boolean icmParamcaltiendasRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParamcaltiendasRecordSet!= null)&&(!this.icmParamcaltiendasRecordSet.isEmpty())));
                if (icmParamcaltiendasRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParamcaltiendasRecord> sourceIcmParamcaltiendasRecordSet;
                    sourceIcmParamcaltiendasRecordSet = (((this.icmParamcaltiendasRecordSet!= null)&&(!this.icmParamcaltiendasRecordSet.isEmpty()))?this.getIcmParamcaltiendasRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParamcaltiendasRecord> copyIcmParamcaltiendasRecordSet = ((List<IcmParamcaltiendasRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParamcaltiendasRecordSet", sourceIcmParamcaltiendasRecordSet), sourceIcmParamcaltiendasRecordSet, ((this.icmParamcaltiendasRecordSet!= null)&&(!this.icmParamcaltiendasRecordSet.isEmpty()))));
                    copy.icmParamcaltiendasRecordSet = null;
                    if (copyIcmParamcaltiendasRecordSet!= null) {
                        List<IcmParamcaltiendasRecord> uniqueIcmParamcaltiendasRecordSetl = copy.getIcmParamcaltiendasRecordSet();
                        uniqueIcmParamcaltiendasRecordSetl.addAll(copyIcmParamcaltiendasRecordSet);
                    }
                } else {
                    if (icmParamcaltiendasRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcaltiendasRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParamcaltiendasBlock();
    }

}
