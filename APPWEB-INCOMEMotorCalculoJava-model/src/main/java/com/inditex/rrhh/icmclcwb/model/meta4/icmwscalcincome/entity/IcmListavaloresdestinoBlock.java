
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
 * <p>Java class for Icm_ListavaloresdestinoBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icm_ListavaloresdestinoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idestructuradestino" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ListavaloresdestinoRecordSet" type="{http://schemas.meta4.com/}Icm_ListavaloresdestinoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ListavaloresdestinoBlock", propOrder = {
    "idestructuradestino",
    "icmListavaloresdestinoRecordSet"
})
public class IcmListavaloresdestinoBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true, nillable = true)
    protected String idestructuradestino;
    @XmlElement(name = "Icm_ListavaloresdestinoRecordSet", nillable = true)
    protected List<IcmListavaloresdestinoRecord> icmListavaloresdestinoRecordSet;

    /**
     * Gets the value of the idestructuradestino property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdestructuradestino() {
        return idestructuradestino;
    }

    /**
     * Sets the value of the idestructuradestino property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdestructuradestino(String value) {
        this.idestructuradestino = value;
    }

    /**
     * Gets the value of the icmListavaloresdestinoRecordSet property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmListavaloresdestinoRecordSet property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmListavaloresdestinoRecordSet().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmListavaloresdestinoRecord }
     *
     *
     */
    public List<IcmListavaloresdestinoRecord> getIcmListavaloresdestinoRecordSet() {
        if (icmListavaloresdestinoRecordSet == null) {
            icmListavaloresdestinoRecordSet = new ArrayList<IcmListavaloresdestinoRecord>();
        }
        return this.icmListavaloresdestinoRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmListavaloresdestinoBlock that = ((IcmListavaloresdestinoBlock) object);
        {
            String lhsIdestructuradestino;
            lhsIdestructuradestino = this.getIdestructuradestino();
            String rhsIdestructuradestino;
            rhsIdestructuradestino = that.getIdestructuradestino();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idestructuradestino", lhsIdestructuradestino), LocatorUtils.property(thatLocator, "idestructuradestino", rhsIdestructuradestino), lhsIdestructuradestino, rhsIdestructuradestino, (this.idestructuradestino!= null), (that.idestructuradestino!= null))) {
                return false;
            }
        }
        {
            List<IcmListavaloresdestinoRecord> lhsIcmListavaloresdestinoRecordSet;
            lhsIcmListavaloresdestinoRecordSet = (((this.icmListavaloresdestinoRecordSet!= null)&&(!this.icmListavaloresdestinoRecordSet.isEmpty()))?this.getIcmListavaloresdestinoRecordSet():null);
            List<IcmListavaloresdestinoRecord> rhsIcmListavaloresdestinoRecordSet;
            rhsIcmListavaloresdestinoRecordSet = (((that.icmListavaloresdestinoRecordSet!= null)&&(!that.icmListavaloresdestinoRecordSet.isEmpty()))?that.getIcmListavaloresdestinoRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmListavaloresdestinoRecordSet", lhsIcmListavaloresdestinoRecordSet), LocatorUtils.property(thatLocator, "icmListavaloresdestinoRecordSet", rhsIcmListavaloresdestinoRecordSet), lhsIcmListavaloresdestinoRecordSet, rhsIcmListavaloresdestinoRecordSet, ((this.icmListavaloresdestinoRecordSet!= null)&&(!this.icmListavaloresdestinoRecordSet.isEmpty())), ((that.icmListavaloresdestinoRecordSet!= null)&&(!that.icmListavaloresdestinoRecordSet.isEmpty())))) {
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
            String theIdestructuradestino;
            theIdestructuradestino = this.getIdestructuradestino();
            strategy.appendField(locator, this, "idestructuradestino", buffer, theIdestructuradestino, (this.idestructuradestino!= null));
        }
        {
            List<IcmListavaloresdestinoRecord> theIcmListavaloresdestinoRecordSet;
            theIcmListavaloresdestinoRecordSet = (((this.icmListavaloresdestinoRecordSet!= null)&&(!this.icmListavaloresdestinoRecordSet.isEmpty()))?this.getIcmListavaloresdestinoRecordSet():null);
            strategy.appendField(locator, this, "icmListavaloresdestinoRecordSet", buffer, theIcmListavaloresdestinoRecordSet, ((this.icmListavaloresdestinoRecordSet!= null)&&(!this.icmListavaloresdestinoRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theIdestructuradestino;
            theIdestructuradestino = this.getIdestructuradestino();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestructuradestino", theIdestructuradestino), currentHashCode, theIdestructuradestino, (this.idestructuradestino!= null));
        }
        {
            List<IcmListavaloresdestinoRecord> theIcmListavaloresdestinoRecordSet;
            theIcmListavaloresdestinoRecordSet = (((this.icmListavaloresdestinoRecordSet!= null)&&(!this.icmListavaloresdestinoRecordSet.isEmpty()))?this.getIcmListavaloresdestinoRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmListavaloresdestinoRecordSet", theIcmListavaloresdestinoRecordSet), currentHashCode, theIcmListavaloresdestinoRecordSet, ((this.icmListavaloresdestinoRecordSet!= null)&&(!this.icmListavaloresdestinoRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmListavaloresdestinoBlock) {
            final IcmListavaloresdestinoBlock copy = ((IcmListavaloresdestinoBlock) draftCopy);
            {
                Boolean idestructuradestinoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idestructuradestino!= null));
                if (idestructuradestinoShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdestructuradestino;
                    sourceIdestructuradestino = this.getIdestructuradestino();
                    String copyIdestructuradestino = ((String) strategy.copy(LocatorUtils.property(locator, "idestructuradestino", sourceIdestructuradestino), sourceIdestructuradestino, (this.idestructuradestino!= null)));
                    copy.setIdestructuradestino(copyIdestructuradestino);
                } else {
                    if (idestructuradestinoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idestructuradestino = null;
                    }
                }
            }
            {
                Boolean icmListavaloresdestinoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmListavaloresdestinoRecordSet!= null)&&(!this.icmListavaloresdestinoRecordSet.isEmpty())));
                if (icmListavaloresdestinoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmListavaloresdestinoRecord> sourceIcmListavaloresdestinoRecordSet;
                    sourceIcmListavaloresdestinoRecordSet = (((this.icmListavaloresdestinoRecordSet!= null)&&(!this.icmListavaloresdestinoRecordSet.isEmpty()))?this.getIcmListavaloresdestinoRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmListavaloresdestinoRecord> copyIcmListavaloresdestinoRecordSet = ((List<IcmListavaloresdestinoRecord> ) strategy.copy(LocatorUtils.property(locator, "icmListavaloresdestinoRecordSet", sourceIcmListavaloresdestinoRecordSet), sourceIcmListavaloresdestinoRecordSet, ((this.icmListavaloresdestinoRecordSet!= null)&&(!this.icmListavaloresdestinoRecordSet.isEmpty()))));
                    copy.icmListavaloresdestinoRecordSet = null;
                    if (copyIcmListavaloresdestinoRecordSet!= null) {
                        List<IcmListavaloresdestinoRecord> uniqueIcmListavaloresdestinoRecordSetl = copy.getIcmListavaloresdestinoRecordSet();
                        uniqueIcmListavaloresdestinoRecordSetl.addAll(copyIcmListavaloresdestinoRecordSet);
                    }
                } else {
                    if (icmListavaloresdestinoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmListavaloresdestinoRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmListavaloresdestinoBlock();
    }

}
