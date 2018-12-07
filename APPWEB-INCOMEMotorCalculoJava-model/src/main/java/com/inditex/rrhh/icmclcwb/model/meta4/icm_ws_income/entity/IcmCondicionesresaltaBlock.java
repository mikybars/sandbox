
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
 * <p>Clase Java para Icm_CondicionesresaltaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CondicionesresaltaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orcomision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idplantilla" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idestructura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_CondicionesresaltaRecordSet" type="{http://schemas.meta4.com/}Icm_CondicionesresaltaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CondicionesresaltaBlock", propOrder = {
    "orcomision",
    "idplantilla",
    "idestructura",
    "icmCondicionesresaltaRecordSet"
})
public class IcmCondicionesresaltaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String orcomision;
    @XmlElement(required = true, nillable = true)
    protected String idplantilla;
    @XmlElement(required = true, nillable = true)
    protected String idestructura;
    @XmlElement(name = "Icm_CondicionesresaltaRecordSet", nillable = true)
    protected List<IcmCondicionesresaltaRecord> icmCondicionesresaltaRecordSet;

    /**
     * Obtiene el valor de la propiedad orcomision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrcomision() {
        return orcomision;
    }

    /**
     * Define el valor de la propiedad orcomision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrcomision(String value) {
        this.orcomision = value;
    }

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
     * Gets the value of the icmCondicionesresaltaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCondicionesresaltaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCondicionesresaltaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCondicionesresaltaRecord }
     * 
     * 
     */
    public List<IcmCondicionesresaltaRecord> getIcmCondicionesresaltaRecordSet() {
        if (icmCondicionesresaltaRecordSet == null) {
            icmCondicionesresaltaRecordSet = new ArrayList<IcmCondicionesresaltaRecord>();
        }
        return this.icmCondicionesresaltaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmCondicionesresaltaBlock that = ((IcmCondicionesresaltaBlock) object);
        {
            String lhsOrcomision;
            lhsOrcomision = this.getOrcomision();
            String rhsOrcomision;
            rhsOrcomision = that.getOrcomision();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "orcomision", lhsOrcomision), LocatorUtils.property(thatLocator, "orcomision", rhsOrcomision), lhsOrcomision, rhsOrcomision, (this.orcomision!= null), (that.orcomision!= null))) {
                return false;
            }
        }
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
            List<IcmCondicionesresaltaRecord> lhsIcmCondicionesresaltaRecordSet;
            lhsIcmCondicionesresaltaRecordSet = (((this.icmCondicionesresaltaRecordSet!= null)&&(!this.icmCondicionesresaltaRecordSet.isEmpty()))?this.getIcmCondicionesresaltaRecordSet():null);
            List<IcmCondicionesresaltaRecord> rhsIcmCondicionesresaltaRecordSet;
            rhsIcmCondicionesresaltaRecordSet = (((that.icmCondicionesresaltaRecordSet!= null)&&(!that.icmCondicionesresaltaRecordSet.isEmpty()))?that.getIcmCondicionesresaltaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmCondicionesresaltaRecordSet", lhsIcmCondicionesresaltaRecordSet), LocatorUtils.property(thatLocator, "icmCondicionesresaltaRecordSet", rhsIcmCondicionesresaltaRecordSet), lhsIcmCondicionesresaltaRecordSet, rhsIcmCondicionesresaltaRecordSet, ((this.icmCondicionesresaltaRecordSet!= null)&&(!this.icmCondicionesresaltaRecordSet.isEmpty())), ((that.icmCondicionesresaltaRecordSet!= null)&&(!that.icmCondicionesresaltaRecordSet.isEmpty())))) {
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
            String theOrcomision;
            theOrcomision = this.getOrcomision();
            strategy.appendField(locator, this, "orcomision", buffer, theOrcomision, (this.orcomision!= null));
        }
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
            List<IcmCondicionesresaltaRecord> theIcmCondicionesresaltaRecordSet;
            theIcmCondicionesresaltaRecordSet = (((this.icmCondicionesresaltaRecordSet!= null)&&(!this.icmCondicionesresaltaRecordSet.isEmpty()))?this.getIcmCondicionesresaltaRecordSet():null);
            strategy.appendField(locator, this, "icmCondicionesresaltaRecordSet", buffer, theIcmCondicionesresaltaRecordSet, ((this.icmCondicionesresaltaRecordSet!= null)&&(!this.icmCondicionesresaltaRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theOrcomision;
            theOrcomision = this.getOrcomision();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "orcomision", theOrcomision), currentHashCode, theOrcomision, (this.orcomision!= null));
        }
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
            List<IcmCondicionesresaltaRecord> theIcmCondicionesresaltaRecordSet;
            theIcmCondicionesresaltaRecordSet = (((this.icmCondicionesresaltaRecordSet!= null)&&(!this.icmCondicionesresaltaRecordSet.isEmpty()))?this.getIcmCondicionesresaltaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmCondicionesresaltaRecordSet", theIcmCondicionesresaltaRecordSet), currentHashCode, theIcmCondicionesresaltaRecordSet, ((this.icmCondicionesresaltaRecordSet!= null)&&(!this.icmCondicionesresaltaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmCondicionesresaltaBlock) {
            final IcmCondicionesresaltaBlock copy = ((IcmCondicionesresaltaBlock) draftCopy);
            {
                Boolean orcomisionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.orcomision!= null));
                if (orcomisionShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceOrcomision;
                    sourceOrcomision = this.getOrcomision();
                    String copyOrcomision = ((String) strategy.copy(LocatorUtils.property(locator, "orcomision", sourceOrcomision), sourceOrcomision, (this.orcomision!= null)));
                    copy.setOrcomision(copyOrcomision);
                } else {
                    if (orcomisionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.orcomision = null;
                    }
                }
            }
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
                Boolean icmCondicionesresaltaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmCondicionesresaltaRecordSet!= null)&&(!this.icmCondicionesresaltaRecordSet.isEmpty())));
                if (icmCondicionesresaltaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmCondicionesresaltaRecord> sourceIcmCondicionesresaltaRecordSet;
                    sourceIcmCondicionesresaltaRecordSet = (((this.icmCondicionesresaltaRecordSet!= null)&&(!this.icmCondicionesresaltaRecordSet.isEmpty()))?this.getIcmCondicionesresaltaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmCondicionesresaltaRecord> copyIcmCondicionesresaltaRecordSet = ((List<IcmCondicionesresaltaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmCondicionesresaltaRecordSet", sourceIcmCondicionesresaltaRecordSet), sourceIcmCondicionesresaltaRecordSet, ((this.icmCondicionesresaltaRecordSet!= null)&&(!this.icmCondicionesresaltaRecordSet.isEmpty()))));
                    copy.icmCondicionesresaltaRecordSet = null;
                    if (copyIcmCondicionesresaltaRecordSet!= null) {
                        List<IcmCondicionesresaltaRecord> uniqueIcmCondicionesresaltaRecordSetl = copy.getIcmCondicionesresaltaRecordSet();
                        uniqueIcmCondicionesresaltaRecordSetl.addAll(copyIcmCondicionesresaltaRecordSet);
                    }
                } else {
                    if (icmCondicionesresaltaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmCondicionesresaltaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmCondicionesresaltaBlock();
    }

}
