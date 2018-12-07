
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
 * <p>Clase Java para Icm_CondicionesfijasBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CondicionesfijasBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idplantilla" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_CondicionesfijasRecordSet" type="{http://schemas.meta4.com/}Icm_CondicionesfijasRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CondicionesfijasBlock", propOrder = {
    "idplantilla",
    "idestructura",
    "icmCondicionesfijasRecordSet"
})
public class IcmCondicionesfijasBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String idplantilla;
    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(name = "Icm_CondicionesfijasRecordSet", nillable = true)
    protected List<IcmCondicionesfijasRecord> icmCondicionesfijasRecordSet;

    /**
     * Obtiene el valor de la propiedad idplantilla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdplantilla() {
        return idplantilla;
    }

    /**
     * Define el valor de la propiedad idplantilla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdplantilla(String value) {
        this.idplantilla = value;
    }

    /**
     * Obtiene el valor de la propiedad idestructura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdestructura() {
        return idestructura;
    }

    /**
     * Define el valor de la propiedad idestructura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdestructura(String value) {
        this.idestructura = value;
    }

    /**
     * Gets the value of the icmCondicionesfijasRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCondicionesfijasRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCondicionesfijasRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCondicionesfijasRecord }
     * 
     * 
     */
    public List<IcmCondicionesfijasRecord> getIcmCondicionesfijasRecordSet() {
        if (icmCondicionesfijasRecordSet == null) {
            icmCondicionesfijasRecordSet = new ArrayList<IcmCondicionesfijasRecord>();
        }
        return this.icmCondicionesfijasRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmCondicionesfijasBlock that = ((IcmCondicionesfijasBlock) object);
        {
            String lhsIdplantilla;
            lhsIdplantilla = this.getIdplantilla();
            String rhsIdplantilla;
            rhsIdplantilla = that.getIdplantilla();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idplantilla", lhsIdplantilla), LocatorUtils.property(thatLocator, "idplantilla", rhsIdplantilla), lhsIdplantilla, rhsIdplantilla, (this.idplantilla!= null), (that.idplantilla!= null))) {
                return false;
            }
        }
        {
            String lhsIdestructura;
            lhsIdestructura = this.getIdestructura();
            String rhsIdestructura;
            rhsIdestructura = that.getIdestructura();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idestructura", lhsIdestructura), LocatorUtils.property(thatLocator, "idestructura", rhsIdestructura), lhsIdestructura, rhsIdestructura, (this.idestructura!= null), (that.idestructura!= null))) {
                return false;
            }
        }
        {
            List<IcmCondicionesfijasRecord> lhsIcmCondicionesfijasRecordSet;
            lhsIcmCondicionesfijasRecordSet = (((this.icmCondicionesfijasRecordSet!= null)&&(!this.icmCondicionesfijasRecordSet.isEmpty()))?this.getIcmCondicionesfijasRecordSet():null);
            List<IcmCondicionesfijasRecord> rhsIcmCondicionesfijasRecordSet;
            rhsIcmCondicionesfijasRecordSet = (((that.icmCondicionesfijasRecordSet!= null)&&(!that.icmCondicionesfijasRecordSet.isEmpty()))?that.getIcmCondicionesfijasRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCondicionesfijasRecordSet", lhsIcmCondicionesfijasRecordSet), LocatorUtils.property(thatLocator, "icmCondicionesfijasRecordSet", rhsIcmCondicionesfijasRecordSet), lhsIcmCondicionesfijasRecordSet, rhsIcmCondicionesfijasRecordSet, ((this.icmCondicionesfijasRecordSet!= null)&&(!this.icmCondicionesfijasRecordSet.isEmpty())), ((that.icmCondicionesfijasRecordSet!= null)&&(!that.icmCondicionesfijasRecordSet.isEmpty())))) {
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
            String theIdplantilla;
            theIdplantilla = this.getIdplantilla();
            strategy.appendField(locator, this, "idplantilla", buffer, theIdplantilla, (this.idplantilla!= null));
        }
        {
            String theIdestructura;
            theIdestructura = this.getIdestructura();
            strategy.appendField(locator, this, "idestructura", buffer, theIdestructura, (this.idestructura!= null));
        }
        {
            List<IcmCondicionesfijasRecord> theIcmCondicionesfijasRecordSet;
            theIcmCondicionesfijasRecordSet = (((this.icmCondicionesfijasRecordSet!= null)&&(!this.icmCondicionesfijasRecordSet.isEmpty()))?this.getIcmCondicionesfijasRecordSet():null);
            strategy.appendField(locator, this, "icmCondicionesfijasRecordSet", buffer, theIcmCondicionesfijasRecordSet, ((this.icmCondicionesfijasRecordSet!= null)&&(!this.icmCondicionesfijasRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theIdplantilla;
            theIdplantilla = this.getIdplantilla();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idplantilla", theIdplantilla), currentHashCode, theIdplantilla, (this.idplantilla!= null));
        }
        {
            String theIdestructura;
            theIdestructura = this.getIdestructura();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestructura", theIdestructura), currentHashCode, theIdestructura, (this.idestructura!= null));
        }
        {
            List<IcmCondicionesfijasRecord> theIcmCondicionesfijasRecordSet;
            theIcmCondicionesfijasRecordSet = (((this.icmCondicionesfijasRecordSet!= null)&&(!this.icmCondicionesfijasRecordSet.isEmpty()))?this.getIcmCondicionesfijasRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCondicionesfijasRecordSet", theIcmCondicionesfijasRecordSet), currentHashCode, theIcmCondicionesfijasRecordSet, ((this.icmCondicionesfijasRecordSet!= null)&&(!this.icmCondicionesfijasRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmCondicionesfijasBlock) {
            final IcmCondicionesfijasBlock copy = ((IcmCondicionesfijasBlock) draftCopy);
            {
                Boolean idplantillaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idplantilla!= null));
                if (idplantillaShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdplantilla;
                    sourceIdplantilla = this.getIdplantilla();
                    String copyIdplantilla = ((String) strategy.copy(LocatorUtils.property(locator, "idplantilla", sourceIdplantilla), sourceIdplantilla, (this.idplantilla!= null)));
                    copy.setIdplantilla(copyIdplantilla);
                } else {
                    if (idplantillaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idplantilla = null;
                    }
                }
            }
            {
                Boolean idestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idestructura!= null));
                if (idestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdestructura;
                    sourceIdestructura = this.getIdestructura();
                    String copyIdestructura = ((String) strategy.copy(LocatorUtils.property(locator, "idestructura", sourceIdestructura), sourceIdestructura, (this.idestructura!= null)));
                    copy.setIdestructura(copyIdestructura);
                } else {
                    if (idestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idestructura = null;
                    }
                }
            }
            {
                Boolean icmCondicionesfijasRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmCondicionesfijasRecordSet!= null)&&(!this.icmCondicionesfijasRecordSet.isEmpty())));
                if (icmCondicionesfijasRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmCondicionesfijasRecord> sourceIcmCondicionesfijasRecordSet;
                    sourceIcmCondicionesfijasRecordSet = (((this.icmCondicionesfijasRecordSet!= null)&&(!this.icmCondicionesfijasRecordSet.isEmpty()))?this.getIcmCondicionesfijasRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmCondicionesfijasRecord> copyIcmCondicionesfijasRecordSet = ((List<IcmCondicionesfijasRecord> ) strategy.copy(LocatorUtils.property(locator, "icmCondicionesfijasRecordSet", sourceIcmCondicionesfijasRecordSet), sourceIcmCondicionesfijasRecordSet, ((this.icmCondicionesfijasRecordSet!= null)&&(!this.icmCondicionesfijasRecordSet.isEmpty()))));
                    copy.icmCondicionesfijasRecordSet = null;
                    if (copyIcmCondicionesfijasRecordSet!= null) {
                        List<IcmCondicionesfijasRecord> uniqueIcmCondicionesfijasRecordSetl = copy.getIcmCondicionesfijasRecordSet();
                        uniqueIcmCondicionesfijasRecordSetl.addAll(copyIcmCondicionesfijasRecordSet);
                    }
                } else {
                    if (icmCondicionesfijasRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCondicionesfijasRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmCondicionesfijasBlock();
    }

}
