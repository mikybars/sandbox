
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
 * <p>Clase Java para Icm_ParamcalsincroBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcalsincroBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_ParamcalsincroRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalsincroRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalsincroBlock", propOrder = {
    "icmParamcalsincroRecordSet"
})
public class IcmParamcalsincroBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Icm_ParamcalsincroRecordSet", nillable = true)
    protected List<IcmParamcalsincroRecord> icmParamcalsincroRecordSet;

    /**
     * Gets the value of the icmParamcalsincroRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParamcalsincroRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParamcalsincroRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParamcalsincroRecord }
     *
     *
     */
    public List<IcmParamcalsincroRecord> getIcmParamcalsincroRecordSet() {
        if (icmParamcalsincroRecordSet == null) {
            icmParamcalsincroRecordSet = new ArrayList<IcmParamcalsincroRecord>();
        }
        return this.icmParamcalsincroRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParamcalsincroBlock that = ((IcmParamcalsincroBlock) object);
        {
            List<IcmParamcalsincroRecord> lhsIcmParamcalsincroRecordSet;
            lhsIcmParamcalsincroRecordSet = (((this.icmParamcalsincroRecordSet!= null)&&(!this.icmParamcalsincroRecordSet.isEmpty()))?this.getIcmParamcalsincroRecordSet():null);
            List<IcmParamcalsincroRecord> rhsIcmParamcalsincroRecordSet;
            rhsIcmParamcalsincroRecordSet = (((that.icmParamcalsincroRecordSet!= null)&&(!that.icmParamcalsincroRecordSet.isEmpty()))?that.getIcmParamcalsincroRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalsincroRecordSet", lhsIcmParamcalsincroRecordSet), LocatorUtils.property(thatLocator, "icmParamcalsincroRecordSet", rhsIcmParamcalsincroRecordSet), lhsIcmParamcalsincroRecordSet, rhsIcmParamcalsincroRecordSet, ((this.icmParamcalsincroRecordSet!= null)&&(!this.icmParamcalsincroRecordSet.isEmpty())), ((that.icmParamcalsincroRecordSet!= null)&&(!that.icmParamcalsincroRecordSet.isEmpty())))) {
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
            List<IcmParamcalsincroRecord> theIcmParamcalsincroRecordSet;
            theIcmParamcalsincroRecordSet = (((this.icmParamcalsincroRecordSet!= null)&&(!this.icmParamcalsincroRecordSet.isEmpty()))?this.getIcmParamcalsincroRecordSet():null);
            strategy.appendField(locator, this, "icmParamcalsincroRecordSet", buffer, theIcmParamcalsincroRecordSet, ((this.icmParamcalsincroRecordSet!= null)&&(!this.icmParamcalsincroRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<IcmParamcalsincroRecord> theIcmParamcalsincroRecordSet;
            theIcmParamcalsincroRecordSet = (((this.icmParamcalsincroRecordSet!= null)&&(!this.icmParamcalsincroRecordSet.isEmpty()))?this.getIcmParamcalsincroRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalsincroRecordSet", theIcmParamcalsincroRecordSet), currentHashCode, theIcmParamcalsincroRecordSet, ((this.icmParamcalsincroRecordSet!= null)&&(!this.icmParamcalsincroRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParamcalsincroBlock) {
            final IcmParamcalsincroBlock copy = ((IcmParamcalsincroBlock) draftCopy);
            {
                Boolean icmParamcalsincroRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParamcalsincroRecordSet!= null)&&(!this.icmParamcalsincroRecordSet.isEmpty())));
                if (icmParamcalsincroRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParamcalsincroRecord> sourceIcmParamcalsincroRecordSet;
                    sourceIcmParamcalsincroRecordSet = (((this.icmParamcalsincroRecordSet!= null)&&(!this.icmParamcalsincroRecordSet.isEmpty()))?this.getIcmParamcalsincroRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParamcalsincroRecord> copyIcmParamcalsincroRecordSet = ((List<IcmParamcalsincroRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParamcalsincroRecordSet", sourceIcmParamcalsincroRecordSet), sourceIcmParamcalsincroRecordSet, ((this.icmParamcalsincroRecordSet!= null)&&(!this.icmParamcalsincroRecordSet.isEmpty()))));
                    copy.icmParamcalsincroRecordSet = null;
                    if (copyIcmParamcalsincroRecordSet!= null) {
                        List<IcmParamcalsincroRecord> uniqueIcmParamcalsincroRecordSetl = copy.getIcmParamcalsincroRecordSet();
                        uniqueIcmParamcalsincroRecordSetl.addAll(copyIcmParamcalsincroRecordSet);
                    }
                } else {
                    if (icmParamcalsincroRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalsincroRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParamcalsincroBlock();
    }

}
