
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
 * <p>Clase Java para Icm_ParametrospresupuestoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrospresupuestoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idcadena" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejercicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idlugartrabajo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ParametrospresupuestoRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrospresupuestoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParametrospresupuestoBlock", propOrder = {
    "idcadena",
    "ejercicio",
    "idlugartrabajo",
    "icmParametrospresupuestoRecordSet"
})
public class IcmParametrospresupuestoBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String idcadena;
    @XmlElement(required = true, nillable = true)
    protected String ejercicio;
    @XmlElement(required = true, nillable = true)
    protected String idlugartrabajo;
    @XmlElement(name = "Icm_ParametrospresupuestoRecordSet", nillable = true)
    protected List<IcmParametrospresupuestoRecord> icmParametrospresupuestoRecordSet;

    /**
     * Obtiene el valor de la propiedad idcadena.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdcadena() {
        return idcadena;
    }

    /**
     * Define el valor de la propiedad idcadena.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdcadena(String value) {
        this.idcadena = value;
    }

    /**
     * Obtiene el valor de la propiedad ejercicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEjercicio() {
        return ejercicio;
    }

    /**
     * Define el valor de la propiedad ejercicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEjercicio(String value) {
        this.ejercicio = value;
    }

    /**
     * Obtiene el valor de la propiedad idlugartrabajo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdlugartrabajo() {
        return idlugartrabajo;
    }

    /**
     * Define el valor de la propiedad idlugartrabajo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdlugartrabajo(String value) {
        this.idlugartrabajo = value;
    }

    /**
     * Gets the value of the icmParametrospresupuestoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParametrospresupuestoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParametrospresupuestoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParametrospresupuestoRecord }
     * 
     * 
     */
    public List<IcmParametrospresupuestoRecord> getIcmParametrospresupuestoRecordSet() {
        if (icmParametrospresupuestoRecordSet == null) {
            icmParametrospresupuestoRecordSet = new ArrayList<IcmParametrospresupuestoRecord>();
        }
        return this.icmParametrospresupuestoRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParametrospresupuestoBlock that = ((IcmParametrospresupuestoBlock) object);
        {
            String lhsIdcadena;
            lhsIdcadena = this.getIdcadena();
            String rhsIdcadena;
            rhsIdcadena = that.getIdcadena();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idcadena", lhsIdcadena), LocatorUtils.property(thatLocator, "idcadena", rhsIdcadena), lhsIdcadena, rhsIdcadena, (this.idcadena!= null), (that.idcadena!= null))) {
                return false;
            }
        }
        {
            String lhsEjercicio;
            lhsEjercicio = this.getEjercicio();
            String rhsEjercicio;
            rhsEjercicio = that.getEjercicio();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ejercicio", lhsEjercicio), LocatorUtils.property(thatLocator, "ejercicio", rhsEjercicio), lhsEjercicio, rhsEjercicio, (this.ejercicio!= null), (that.ejercicio!= null))) {
                return false;
            }
        }
        {
            String lhsIdlugartrabajo;
            lhsIdlugartrabajo = this.getIdlugartrabajo();
            String rhsIdlugartrabajo;
            rhsIdlugartrabajo = that.getIdlugartrabajo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idlugartrabajo", lhsIdlugartrabajo), LocatorUtils.property(thatLocator, "idlugartrabajo", rhsIdlugartrabajo), lhsIdlugartrabajo, rhsIdlugartrabajo, (this.idlugartrabajo!= null), (that.idlugartrabajo!= null))) {
                return false;
            }
        }
        {
            List<IcmParametrospresupuestoRecord> lhsIcmParametrospresupuestoRecordSet;
            lhsIcmParametrospresupuestoRecordSet = (((this.icmParametrospresupuestoRecordSet!= null)&&(!this.icmParametrospresupuestoRecordSet.isEmpty()))?this.getIcmParametrospresupuestoRecordSet():null);
            List<IcmParametrospresupuestoRecord> rhsIcmParametrospresupuestoRecordSet;
            rhsIcmParametrospresupuestoRecordSet = (((that.icmParametrospresupuestoRecordSet!= null)&&(!that.icmParametrospresupuestoRecordSet.isEmpty()))?that.getIcmParametrospresupuestoRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrospresupuestoRecordSet", lhsIcmParametrospresupuestoRecordSet), LocatorUtils.property(thatLocator, "icmParametrospresupuestoRecordSet", rhsIcmParametrospresupuestoRecordSet), lhsIcmParametrospresupuestoRecordSet, rhsIcmParametrospresupuestoRecordSet, ((this.icmParametrospresupuestoRecordSet!= null)&&(!this.icmParametrospresupuestoRecordSet.isEmpty())), ((that.icmParametrospresupuestoRecordSet!= null)&&(!that.icmParametrospresupuestoRecordSet.isEmpty())))) {
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
            String theIdcadena;
            theIdcadena = this.getIdcadena();
            strategy.appendField(locator, this, "idcadena", buffer, theIdcadena, (this.idcadena!= null));
        }
        {
            String theEjercicio;
            theEjercicio = this.getEjercicio();
            strategy.appendField(locator, this, "ejercicio", buffer, theEjercicio, (this.ejercicio!= null));
        }
        {
            String theIdlugartrabajo;
            theIdlugartrabajo = this.getIdlugartrabajo();
            strategy.appendField(locator, this, "idlugartrabajo", buffer, theIdlugartrabajo, (this.idlugartrabajo!= null));
        }
        {
            List<IcmParametrospresupuestoRecord> theIcmParametrospresupuestoRecordSet;
            theIcmParametrospresupuestoRecordSet = (((this.icmParametrospresupuestoRecordSet!= null)&&(!this.icmParametrospresupuestoRecordSet.isEmpty()))?this.getIcmParametrospresupuestoRecordSet():null);
            strategy.appendField(locator, this, "icmParametrospresupuestoRecordSet", buffer, theIcmParametrospresupuestoRecordSet, ((this.icmParametrospresupuestoRecordSet!= null)&&(!this.icmParametrospresupuestoRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theIdcadena;
            theIdcadena = this.getIdcadena();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idcadena", theIdcadena), currentHashCode, theIdcadena, (this.idcadena!= null));
        }
        {
            String theEjercicio;
            theEjercicio = this.getEjercicio();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ejercicio", theEjercicio), currentHashCode, theEjercicio, (this.ejercicio!= null));
        }
        {
            String theIdlugartrabajo;
            theIdlugartrabajo = this.getIdlugartrabajo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idlugartrabajo", theIdlugartrabajo), currentHashCode, theIdlugartrabajo, (this.idlugartrabajo!= null));
        }
        {
            List<IcmParametrospresupuestoRecord> theIcmParametrospresupuestoRecordSet;
            theIcmParametrospresupuestoRecordSet = (((this.icmParametrospresupuestoRecordSet!= null)&&(!this.icmParametrospresupuestoRecordSet.isEmpty()))?this.getIcmParametrospresupuestoRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrospresupuestoRecordSet", theIcmParametrospresupuestoRecordSet), currentHashCode, theIcmParametrospresupuestoRecordSet, ((this.icmParametrospresupuestoRecordSet!= null)&&(!this.icmParametrospresupuestoRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParametrospresupuestoBlock) {
            final IcmParametrospresupuestoBlock copy = ((IcmParametrospresupuestoBlock) draftCopy);
            {
                Boolean idcadenaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idcadena!= null));
                if (idcadenaShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdcadena;
                    sourceIdcadena = this.getIdcadena();
                    String copyIdcadena = ((String) strategy.copy(LocatorUtils.property(locator, "idcadena", sourceIdcadena), sourceIdcadena, (this.idcadena!= null)));
                    copy.setIdcadena(copyIdcadena);
                } else {
                    if (idcadenaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idcadena = null;
                    }
                }
            }
            {
                Boolean ejercicioShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.ejercicio!= null));
                if (ejercicioShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceEjercicio;
                    sourceEjercicio = this.getEjercicio();
                    String copyEjercicio = ((String) strategy.copy(LocatorUtils.property(locator, "ejercicio", sourceEjercicio), sourceEjercicio, (this.ejercicio!= null)));
                    copy.setEjercicio(copyEjercicio);
                } else {
                    if (ejercicioShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.ejercicio = null;
                    }
                }
            }
            {
                Boolean idlugartrabajoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idlugartrabajo!= null));
                if (idlugartrabajoShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdlugartrabajo;
                    sourceIdlugartrabajo = this.getIdlugartrabajo();
                    String copyIdlugartrabajo = ((String) strategy.copy(LocatorUtils.property(locator, "idlugartrabajo", sourceIdlugartrabajo), sourceIdlugartrabajo, (this.idlugartrabajo!= null)));
                    copy.setIdlugartrabajo(copyIdlugartrabajo);
                } else {
                    if (idlugartrabajoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idlugartrabajo = null;
                    }
                }
            }
            {
                Boolean icmParametrospresupuestoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParametrospresupuestoRecordSet!= null)&&(!this.icmParametrospresupuestoRecordSet.isEmpty())));
                if (icmParametrospresupuestoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParametrospresupuestoRecord> sourceIcmParametrospresupuestoRecordSet;
                    sourceIcmParametrospresupuestoRecordSet = (((this.icmParametrospresupuestoRecordSet!= null)&&(!this.icmParametrospresupuestoRecordSet.isEmpty()))?this.getIcmParametrospresupuestoRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParametrospresupuestoRecord> copyIcmParametrospresupuestoRecordSet = ((List<IcmParametrospresupuestoRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParametrospresupuestoRecordSet", sourceIcmParametrospresupuestoRecordSet), sourceIcmParametrospresupuestoRecordSet, ((this.icmParametrospresupuestoRecordSet!= null)&&(!this.icmParametrospresupuestoRecordSet.isEmpty()))));
                    copy.icmParametrospresupuestoRecordSet = null;
                    if (copyIcmParametrospresupuestoRecordSet!= null) {
                        List<IcmParametrospresupuestoRecord> uniqueIcmParametrospresupuestoRecordSetl = copy.getIcmParametrospresupuestoRecordSet();
                        uniqueIcmParametrospresupuestoRecordSetl.addAll(copyIcmParametrospresupuestoRecordSet);
                    }
                } else {
                    if (icmParametrospresupuestoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrospresupuestoRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParametrospresupuestoBlock();
    }

}
