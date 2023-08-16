
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
 * <p>Java class for Icm_ParamcaltiposhoraBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ParamcaltiposhoraBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idorigen" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParamcaltiposhoraRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcaltiposhoraRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcaltiposhoraBlock", propOrder = {
    "idorigen",
    "icmParamcaltiposhoraRecordSet"
})
public class IcmParamcaltiposhoraBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true, nillable = true)
    protected String idorigen;
    @XmlElement(name = "Icm_ParamcaltiposhoraRecordSet", nillable = true)
    protected List<IcmParamcaltiposhoraRecord> icmParamcaltiposhoraRecordSet;

    /**
     * Gets the value of the idorigen property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdorigen() {
        return idorigen;
    }

    /**
     * Sets the value of the idorigen property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdorigen(String value) {
        this.idorigen = value;
    }

    /**
     * Gets the value of the icmParamcaltiposhoraRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParamcaltiposhoraRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParamcaltiposhoraRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParamcaltiposhoraRecord }
     *
     *
     */
    public List<IcmParamcaltiposhoraRecord> getIcmParamcaltiposhoraRecordSet() {
        if (icmParamcaltiposhoraRecordSet == null) {
            icmParamcaltiposhoraRecordSet = new ArrayList<IcmParamcaltiposhoraRecord>();
        }
        return this.icmParamcaltiposhoraRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParamcaltiposhoraBlock that = ((IcmParamcaltiposhoraBlock) object);
        {
            String lhsIdorigen;
            lhsIdorigen = this.getIdorigen();
            String rhsIdorigen;
            rhsIdorigen = that.getIdorigen();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idorigen", lhsIdorigen), LocatorUtils.property(thatLocator, "idorigen", rhsIdorigen), lhsIdorigen, rhsIdorigen, (this.idorigen!= null), (that.idorigen!= null))) {
                return false;
            }
        }
        {
            List<IcmParamcaltiposhoraRecord> lhsIcmParamcaltiposhoraRecordSet;
            lhsIcmParamcaltiposhoraRecordSet = (((this.icmParamcaltiposhoraRecordSet!= null)&&(!this.icmParamcaltiposhoraRecordSet.isEmpty()))?this.getIcmParamcaltiposhoraRecordSet():null);
            List<IcmParamcaltiposhoraRecord> rhsIcmParamcaltiposhoraRecordSet;
            rhsIcmParamcaltiposhoraRecordSet = (((that.icmParamcaltiposhoraRecordSet!= null)&&(!that.icmParamcaltiposhoraRecordSet.isEmpty()))?that.getIcmParamcaltiposhoraRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcaltiposhoraRecordSet", lhsIcmParamcaltiposhoraRecordSet), LocatorUtils.property(thatLocator, "icmParamcaltiposhoraRecordSet", rhsIcmParamcaltiposhoraRecordSet), lhsIcmParamcaltiposhoraRecordSet, rhsIcmParamcaltiposhoraRecordSet, ((this.icmParamcaltiposhoraRecordSet!= null)&&(!this.icmParamcaltiposhoraRecordSet.isEmpty())), ((that.icmParamcaltiposhoraRecordSet!= null)&&(!that.icmParamcaltiposhoraRecordSet.isEmpty())))) {
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
            String theIdorigen;
            theIdorigen = this.getIdorigen();
            strategy.appendField(locator, this, "idorigen", buffer, theIdorigen, (this.idorigen!= null));
        }
        {
            List<IcmParamcaltiposhoraRecord> theIcmParamcaltiposhoraRecordSet;
            theIcmParamcaltiposhoraRecordSet = (((this.icmParamcaltiposhoraRecordSet!= null)&&(!this.icmParamcaltiposhoraRecordSet.isEmpty()))?this.getIcmParamcaltiposhoraRecordSet():null);
            strategy.appendField(locator, this, "icmParamcaltiposhoraRecordSet", buffer, theIcmParamcaltiposhoraRecordSet, ((this.icmParamcaltiposhoraRecordSet!= null)&&(!this.icmParamcaltiposhoraRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theIdorigen;
            theIdorigen = this.getIdorigen();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idorigen", theIdorigen), currentHashCode, theIdorigen, (this.idorigen!= null));
        }
        {
            List<IcmParamcaltiposhoraRecord> theIcmParamcaltiposhoraRecordSet;
            theIcmParamcaltiposhoraRecordSet = (((this.icmParamcaltiposhoraRecordSet!= null)&&(!this.icmParamcaltiposhoraRecordSet.isEmpty()))?this.getIcmParamcaltiposhoraRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcaltiposhoraRecordSet", theIcmParamcaltiposhoraRecordSet), currentHashCode, theIcmParamcaltiposhoraRecordSet, ((this.icmParamcaltiposhoraRecordSet!= null)&&(!this.icmParamcaltiposhoraRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParamcaltiposhoraBlock) {
            final IcmParamcaltiposhoraBlock copy = ((IcmParamcaltiposhoraBlock) draftCopy);
            {
                Boolean idorigenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idorigen!= null));
                if (idorigenShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdorigen;
                    sourceIdorigen = this.getIdorigen();
                    String copyIdorigen = ((String) strategy.copy(LocatorUtils.property(locator, "idorigen", sourceIdorigen), sourceIdorigen, (this.idorigen!= null)));
                    copy.setIdorigen(copyIdorigen);
                } else {
                    if (idorigenShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idorigen = null;
                    }
                }
            }
            {
                Boolean icmParamcaltiposhoraRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParamcaltiposhoraRecordSet!= null)&&(!this.icmParamcaltiposhoraRecordSet.isEmpty())));
                if (icmParamcaltiposhoraRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParamcaltiposhoraRecord> sourceIcmParamcaltiposhoraRecordSet;
                    sourceIcmParamcaltiposhoraRecordSet = (((this.icmParamcaltiposhoraRecordSet!= null)&&(!this.icmParamcaltiposhoraRecordSet.isEmpty()))?this.getIcmParamcaltiposhoraRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParamcaltiposhoraRecord> copyIcmParamcaltiposhoraRecordSet = ((List<IcmParamcaltiposhoraRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParamcaltiposhoraRecordSet", sourceIcmParamcaltiposhoraRecordSet), sourceIcmParamcaltiposhoraRecordSet, ((this.icmParamcaltiposhoraRecordSet!= null)&&(!this.icmParamcaltiposhoraRecordSet.isEmpty()))));
                    copy.icmParamcaltiposhoraRecordSet = null;
                    if (copyIcmParamcaltiposhoraRecordSet!= null) {
                        List<IcmParamcaltiposhoraRecord> uniqueIcmParamcaltiposhoraRecordSetl = copy.getIcmParamcaltiposhoraRecordSet();
                        uniqueIcmParamcaltiposhoraRecordSetl.addAll(copyIcmParamcaltiposhoraRecordSet);
                    }
                } else {
                    if (icmParamcaltiposhoraRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcaltiposhoraRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParamcaltiposhoraBlock();
    }

}
