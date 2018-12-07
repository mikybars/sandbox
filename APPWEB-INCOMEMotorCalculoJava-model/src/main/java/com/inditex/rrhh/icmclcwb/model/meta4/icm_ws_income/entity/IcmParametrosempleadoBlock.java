
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
 * <p>Clase Java para Icm_ParametrosempleadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrosempleadoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechafin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idempleado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="orempleado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechainicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idlugartrabajo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idorigenpresencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ParametrosempleadoRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrosempleadoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParametrosempleadoBlock", propOrder = {
    "fechafin",
    "idempleado",
    "orempleado",
    "fechainicio",
    "idlugartrabajo",
    "idorigenpresencia",
    "icmParametrosempleadoRecordSet"
})
public class IcmParametrosempleadoBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String fechafin;
    @XmlElement(required = true, nillable = true)
    protected String idempleado;
    @XmlElement(required = true, nillable = true)
    protected String orempleado;
    @XmlElement(required = true, nillable = true)
    protected String fechainicio;
    @XmlElement(required = true, nillable = true)
    protected String idlugartrabajo;
    @XmlElement(required = true, nillable = true)
    protected String idorigenpresencia;
    @XmlElement(name = "Icm_ParametrosempleadoRecordSet", nillable = true)
    protected List<IcmParametrosempleadoRecord> icmParametrosempleadoRecordSet;

    /**
     * Obtiene el valor de la propiedad fechafin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechafin() {
        return fechafin;
    }

    /**
     * Define el valor de la propiedad fechafin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechafin(String value) {
        this.fechafin = value;
    }

    /**
     * Obtiene el valor de la propiedad idempleado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdempleado() {
        return idempleado;
    }

    /**
     * Define el valor de la propiedad idempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdempleado(String value) {
        this.idempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad orempleado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrempleado() {
        return orempleado;
    }

    /**
     * Define el valor de la propiedad orempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrempleado(String value) {
        this.orempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechainicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechainicio() {
        return fechainicio;
    }

    /**
     * Define el valor de la propiedad fechainicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechainicio(String value) {
        this.fechainicio = value;
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
     * Obtiene el valor de la propiedad idorigenpresencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdorigenpresencia() {
        return idorigenpresencia;
    }

    /**
     * Define el valor de la propiedad idorigenpresencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdorigenpresencia(String value) {
        this.idorigenpresencia = value;
    }

    /**
     * Gets the value of the icmParametrosempleadoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParametrosempleadoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParametrosempleadoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParametrosempleadoRecord }
     * 
     * 
     */
    public List<IcmParametrosempleadoRecord> getIcmParametrosempleadoRecordSet() {
        if (icmParametrosempleadoRecordSet == null) {
            icmParametrosempleadoRecordSet = new ArrayList<IcmParametrosempleadoRecord>();
        }
        return this.icmParametrosempleadoRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParametrosempleadoBlock that = ((IcmParametrosempleadoBlock) object);
        {
            String lhsFechafin;
            lhsFechafin = this.getFechafin();
            String rhsFechafin;
            rhsFechafin = that.getFechafin();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fechafin", lhsFechafin), LocatorUtils.property(thatLocator, "fechafin", rhsFechafin), lhsFechafin, rhsFechafin, (this.fechafin!= null), (that.fechafin!= null))) {
                return false;
            }
        }
        {
            String lhsIdempleado;
            lhsIdempleado = this.getIdempleado();
            String rhsIdempleado;
            rhsIdempleado = that.getIdempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idempleado", lhsIdempleado), LocatorUtils.property(thatLocator, "idempleado", rhsIdempleado), lhsIdempleado, rhsIdempleado, (this.idempleado!= null), (that.idempleado!= null))) {
                return false;
            }
        }
        {
            String lhsOrempleado;
            lhsOrempleado = this.getOrempleado();
            String rhsOrempleado;
            rhsOrempleado = that.getOrempleado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "orempleado", lhsOrempleado), LocatorUtils.property(thatLocator, "orempleado", rhsOrempleado), lhsOrempleado, rhsOrempleado, (this.orempleado!= null), (that.orempleado!= null))) {
                return false;
            }
        }
        {
            String lhsFechainicio;
            lhsFechainicio = this.getFechainicio();
            String rhsFechainicio;
            rhsFechainicio = that.getFechainicio();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fechainicio", lhsFechainicio), LocatorUtils.property(thatLocator, "fechainicio", rhsFechainicio), lhsFechainicio, rhsFechainicio, (this.fechainicio!= null), (that.fechainicio!= null))) {
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
            String lhsIdorigenpresencia;
            lhsIdorigenpresencia = this.getIdorigenpresencia();
            String rhsIdorigenpresencia;
            rhsIdorigenpresencia = that.getIdorigenpresencia();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idorigenpresencia", lhsIdorigenpresencia), LocatorUtils.property(thatLocator, "idorigenpresencia", rhsIdorigenpresencia), lhsIdorigenpresencia, rhsIdorigenpresencia, (this.idorigenpresencia!= null), (that.idorigenpresencia!= null))) {
                return false;
            }
        }
        {
            List<IcmParametrosempleadoRecord> lhsIcmParametrosempleadoRecordSet;
            lhsIcmParametrosempleadoRecordSet = (((this.icmParametrosempleadoRecordSet!= null)&&(!this.icmParametrosempleadoRecordSet.isEmpty()))?this.getIcmParametrosempleadoRecordSet():null);
            List<IcmParametrosempleadoRecord> rhsIcmParametrosempleadoRecordSet;
            rhsIcmParametrosempleadoRecordSet = (((that.icmParametrosempleadoRecordSet!= null)&&(!that.icmParametrosempleadoRecordSet.isEmpty()))?that.getIcmParametrosempleadoRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrosempleadoRecordSet", lhsIcmParametrosempleadoRecordSet), LocatorUtils.property(thatLocator, "icmParametrosempleadoRecordSet", rhsIcmParametrosempleadoRecordSet), lhsIcmParametrosempleadoRecordSet, rhsIcmParametrosempleadoRecordSet, ((this.icmParametrosempleadoRecordSet!= null)&&(!this.icmParametrosempleadoRecordSet.isEmpty())), ((that.icmParametrosempleadoRecordSet!= null)&&(!that.icmParametrosempleadoRecordSet.isEmpty())))) {
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
            String theFechafin;
            theFechafin = this.getFechafin();
            strategy.appendField(locator, this, "fechafin", buffer, theFechafin, (this.fechafin!= null));
        }
        {
            String theIdempleado;
            theIdempleado = this.getIdempleado();
            strategy.appendField(locator, this, "idempleado", buffer, theIdempleado, (this.idempleado!= null));
        }
        {
            String theOrempleado;
            theOrempleado = this.getOrempleado();
            strategy.appendField(locator, this, "orempleado", buffer, theOrempleado, (this.orempleado!= null));
        }
        {
            String theFechainicio;
            theFechainicio = this.getFechainicio();
            strategy.appendField(locator, this, "fechainicio", buffer, theFechainicio, (this.fechainicio!= null));
        }
        {
            String theIdlugartrabajo;
            theIdlugartrabajo = this.getIdlugartrabajo();
            strategy.appendField(locator, this, "idlugartrabajo", buffer, theIdlugartrabajo, (this.idlugartrabajo!= null));
        }
        {
            String theIdorigenpresencia;
            theIdorigenpresencia = this.getIdorigenpresencia();
            strategy.appendField(locator, this, "idorigenpresencia", buffer, theIdorigenpresencia, (this.idorigenpresencia!= null));
        }
        {
            List<IcmParametrosempleadoRecord> theIcmParametrosempleadoRecordSet;
            theIcmParametrosempleadoRecordSet = (((this.icmParametrosempleadoRecordSet!= null)&&(!this.icmParametrosempleadoRecordSet.isEmpty()))?this.getIcmParametrosempleadoRecordSet():null);
            strategy.appendField(locator, this, "icmParametrosempleadoRecordSet", buffer, theIcmParametrosempleadoRecordSet, ((this.icmParametrosempleadoRecordSet!= null)&&(!this.icmParametrosempleadoRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theFechafin;
            theFechafin = this.getFechafin();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechafin", theFechafin), currentHashCode, theFechafin, (this.fechafin!= null));
        }
        {
            String theIdempleado;
            theIdempleado = this.getIdempleado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idempleado", theIdempleado), currentHashCode, theIdempleado, (this.idempleado!= null));
        }
        {
            String theOrempleado;
            theOrempleado = this.getOrempleado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "orempleado", theOrempleado), currentHashCode, theOrempleado, (this.orempleado!= null));
        }
        {
            String theFechainicio;
            theFechainicio = this.getFechainicio();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechainicio", theFechainicio), currentHashCode, theFechainicio, (this.fechainicio!= null));
        }
        {
            String theIdlugartrabajo;
            theIdlugartrabajo = this.getIdlugartrabajo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idlugartrabajo", theIdlugartrabajo), currentHashCode, theIdlugartrabajo, (this.idlugartrabajo!= null));
        }
        {
            String theIdorigenpresencia;
            theIdorigenpresencia = this.getIdorigenpresencia();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idorigenpresencia", theIdorigenpresencia), currentHashCode, theIdorigenpresencia, (this.idorigenpresencia!= null));
        }
        {
            List<IcmParametrosempleadoRecord> theIcmParametrosempleadoRecordSet;
            theIcmParametrosempleadoRecordSet = (((this.icmParametrosempleadoRecordSet!= null)&&(!this.icmParametrosempleadoRecordSet.isEmpty()))?this.getIcmParametrosempleadoRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrosempleadoRecordSet", theIcmParametrosempleadoRecordSet), currentHashCode, theIcmParametrosempleadoRecordSet, ((this.icmParametrosempleadoRecordSet!= null)&&(!this.icmParametrosempleadoRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParametrosempleadoBlock) {
            final IcmParametrosempleadoBlock copy = ((IcmParametrosempleadoBlock) draftCopy);
            {
                Boolean fechafinShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.fechafin!= null));
                if (fechafinShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceFechafin;
                    sourceFechafin = this.getFechafin();
                    String copyFechafin = ((String) strategy.copy(LocatorUtils.property(locator, "fechafin", sourceFechafin), sourceFechafin, (this.fechafin!= null)));
                    copy.setFechafin(copyFechafin);
                } else {
                    if (fechafinShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.fechafin = null;
                    }
                }
            }
            {
                Boolean idempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idempleado!= null));
                if (idempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdempleado;
                    sourceIdempleado = this.getIdempleado();
                    String copyIdempleado = ((String) strategy.copy(LocatorUtils.property(locator, "idempleado", sourceIdempleado), sourceIdempleado, (this.idempleado!= null)));
                    copy.setIdempleado(copyIdempleado);
                } else {
                    if (idempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idempleado = null;
                    }
                }
            }
            {
                Boolean orempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.orempleado!= null));
                if (orempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceOrempleado;
                    sourceOrempleado = this.getOrempleado();
                    String copyOrempleado = ((String) strategy.copy(LocatorUtils.property(locator, "orempleado", sourceOrempleado), sourceOrempleado, (this.orempleado!= null)));
                    copy.setOrempleado(copyOrempleado);
                } else {
                    if (orempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.orempleado = null;
                    }
                }
            }
            {
                Boolean fechainicioShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.fechainicio!= null));
                if (fechainicioShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceFechainicio;
                    sourceFechainicio = this.getFechainicio();
                    String copyFechainicio = ((String) strategy.copy(LocatorUtils.property(locator, "fechainicio", sourceFechainicio), sourceFechainicio, (this.fechainicio!= null)));
                    copy.setFechainicio(copyFechainicio);
                } else {
                    if (fechainicioShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.fechainicio = null;
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
                Boolean idorigenpresenciaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idorigenpresencia!= null));
                if (idorigenpresenciaShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdorigenpresencia;
                    sourceIdorigenpresencia = this.getIdorigenpresencia();
                    String copyIdorigenpresencia = ((String) strategy.copy(LocatorUtils.property(locator, "idorigenpresencia", sourceIdorigenpresencia), sourceIdorigenpresencia, (this.idorigenpresencia!= null)));
                    copy.setIdorigenpresencia(copyIdorigenpresencia);
                } else {
                    if (idorigenpresenciaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idorigenpresencia = null;
                    }
                }
            }
            {
                Boolean icmParametrosempleadoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParametrosempleadoRecordSet!= null)&&(!this.icmParametrosempleadoRecordSet.isEmpty())));
                if (icmParametrosempleadoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParametrosempleadoRecord> sourceIcmParametrosempleadoRecordSet;
                    sourceIcmParametrosempleadoRecordSet = (((this.icmParametrosempleadoRecordSet!= null)&&(!this.icmParametrosempleadoRecordSet.isEmpty()))?this.getIcmParametrosempleadoRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParametrosempleadoRecord> copyIcmParametrosempleadoRecordSet = ((List<IcmParametrosempleadoRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParametrosempleadoRecordSet", sourceIcmParametrosempleadoRecordSet), sourceIcmParametrosempleadoRecordSet, ((this.icmParametrosempleadoRecordSet!= null)&&(!this.icmParametrosempleadoRecordSet.isEmpty()))));
                    copy.icmParametrosempleadoRecordSet = null;
                    if (copyIcmParametrosempleadoRecordSet!= null) {
                        List<IcmParametrosempleadoRecord> uniqueIcmParametrosempleadoRecordSetl = copy.getIcmParametrosempleadoRecordSet();
                        uniqueIcmParametrosempleadoRecordSetl.addAll(copyIcmParametrosempleadoRecordSet);
                    }
                } else {
                    if (icmParametrosempleadoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrosempleadoRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParametrosempleadoBlock();
    }

}
