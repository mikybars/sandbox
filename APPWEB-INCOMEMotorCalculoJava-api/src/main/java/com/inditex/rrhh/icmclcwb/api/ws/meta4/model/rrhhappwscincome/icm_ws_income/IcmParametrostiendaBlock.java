
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
 * <p>Clase Java para Icm_ParametrostiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrostiendaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechafin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idestado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechainicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idestadomtu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idlugartrabajo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ParametrostiendaRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrostiendaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParametrostiendaBlock", propOrder = {
    "fechafin",
    "idestado",
    "fechainicio",
    "idestadomtu",
    "idlugartrabajo",
    "icmParametrostiendaRecordSet"
})
public class IcmParametrostiendaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String fechafin;
    @XmlElement(required = true, nillable = true)
    protected String idestado;
    @XmlElement(required = true, nillable = true)
    protected String fechainicio;
    @XmlElement(required = true, nillable = true)
    protected String idestadomtu;
    @XmlElement(required = true, nillable = true)
    protected String idlugartrabajo;
    @XmlElement(name = "Icm_ParametrostiendaRecordSet", nillable = true)
    protected List<IcmParametrostiendaRecord> icmParametrostiendaRecordSet;

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
     * Obtiene el valor de la propiedad idestado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdestado() {
        return idestado;
    }

    /**
     * Define el valor de la propiedad idestado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdestado(String value) {
        this.idestado = value;
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
     * Obtiene el valor de la propiedad idestadomtu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdestadomtu() {
        return idestadomtu;
    }

    /**
     * Define el valor de la propiedad idestadomtu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdestadomtu(String value) {
        this.idestadomtu = value;
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
     * Gets the value of the icmParametrostiendaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParametrostiendaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParametrostiendaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParametrostiendaRecord }
     * 
     * 
     */
    public List<IcmParametrostiendaRecord> getIcmParametrostiendaRecordSet() {
        if (icmParametrostiendaRecordSet == null) {
            icmParametrostiendaRecordSet = new ArrayList<IcmParametrostiendaRecord>();
        }
        return this.icmParametrostiendaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParametrostiendaBlock that = ((IcmParametrostiendaBlock) object);
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
            String lhsIdestado;
            lhsIdestado = this.getIdestado();
            String rhsIdestado;
            rhsIdestado = that.getIdestado();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idestado", lhsIdestado), LocatorUtils.property(thatLocator, "idestado", rhsIdestado), lhsIdestado, rhsIdestado, (this.idestado!= null), (that.idestado!= null))) {
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
            String lhsIdestadomtu;
            lhsIdestadomtu = this.getIdestadomtu();
            String rhsIdestadomtu;
            rhsIdestadomtu = that.getIdestadomtu();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idestadomtu", lhsIdestadomtu), LocatorUtils.property(thatLocator, "idestadomtu", rhsIdestadomtu), lhsIdestadomtu, rhsIdestadomtu, (this.idestadomtu!= null), (that.idestadomtu!= null))) {
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
            List<IcmParametrostiendaRecord> lhsIcmParametrostiendaRecordSet;
            lhsIcmParametrostiendaRecordSet = (((this.icmParametrostiendaRecordSet!= null)&&(!this.icmParametrostiendaRecordSet.isEmpty()))?this.getIcmParametrostiendaRecordSet():null);
            List<IcmParametrostiendaRecord> rhsIcmParametrostiendaRecordSet;
            rhsIcmParametrostiendaRecordSet = (((that.icmParametrostiendaRecordSet!= null)&&(!that.icmParametrostiendaRecordSet.isEmpty()))?that.getIcmParametrostiendaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrostiendaRecordSet", lhsIcmParametrostiendaRecordSet), LocatorUtils.property(thatLocator, "icmParametrostiendaRecordSet", rhsIcmParametrostiendaRecordSet), lhsIcmParametrostiendaRecordSet, rhsIcmParametrostiendaRecordSet, ((this.icmParametrostiendaRecordSet!= null)&&(!this.icmParametrostiendaRecordSet.isEmpty())), ((that.icmParametrostiendaRecordSet!= null)&&(!that.icmParametrostiendaRecordSet.isEmpty())))) {
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
            String theIdestado;
            theIdestado = this.getIdestado();
            strategy.appendField(locator, this, "idestado", buffer, theIdestado, (this.idestado!= null));
        }
        {
            String theFechainicio;
            theFechainicio = this.getFechainicio();
            strategy.appendField(locator, this, "fechainicio", buffer, theFechainicio, (this.fechainicio!= null));
        }
        {
            String theIdestadomtu;
            theIdestadomtu = this.getIdestadomtu();
            strategy.appendField(locator, this, "idestadomtu", buffer, theIdestadomtu, (this.idestadomtu!= null));
        }
        {
            String theIdlugartrabajo;
            theIdlugartrabajo = this.getIdlugartrabajo();
            strategy.appendField(locator, this, "idlugartrabajo", buffer, theIdlugartrabajo, (this.idlugartrabajo!= null));
        }
        {
            List<IcmParametrostiendaRecord> theIcmParametrostiendaRecordSet;
            theIcmParametrostiendaRecordSet = (((this.icmParametrostiendaRecordSet!= null)&&(!this.icmParametrostiendaRecordSet.isEmpty()))?this.getIcmParametrostiendaRecordSet():null);
            strategy.appendField(locator, this, "icmParametrostiendaRecordSet", buffer, theIcmParametrostiendaRecordSet, ((this.icmParametrostiendaRecordSet!= null)&&(!this.icmParametrostiendaRecordSet.isEmpty())));
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
            String theIdestado;
            theIdestado = this.getIdestado();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestado", theIdestado), currentHashCode, theIdestado, (this.idestado!= null));
        }
        {
            String theFechainicio;
            theFechainicio = this.getFechainicio();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechainicio", theFechainicio), currentHashCode, theFechainicio, (this.fechainicio!= null));
        }
        {
            String theIdestadomtu;
            theIdestadomtu = this.getIdestadomtu();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestadomtu", theIdestadomtu), currentHashCode, theIdestadomtu, (this.idestadomtu!= null));
        }
        {
            String theIdlugartrabajo;
            theIdlugartrabajo = this.getIdlugartrabajo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idlugartrabajo", theIdlugartrabajo), currentHashCode, theIdlugartrabajo, (this.idlugartrabajo!= null));
        }
        {
            List<IcmParametrostiendaRecord> theIcmParametrostiendaRecordSet;
            theIcmParametrostiendaRecordSet = (((this.icmParametrostiendaRecordSet!= null)&&(!this.icmParametrostiendaRecordSet.isEmpty()))?this.getIcmParametrostiendaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrostiendaRecordSet", theIcmParametrostiendaRecordSet), currentHashCode, theIcmParametrostiendaRecordSet, ((this.icmParametrostiendaRecordSet!= null)&&(!this.icmParametrostiendaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParametrostiendaBlock) {
            final IcmParametrostiendaBlock copy = ((IcmParametrostiendaBlock) draftCopy);
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
                Boolean idestadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idestado!= null));
                if (idestadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdestado;
                    sourceIdestado = this.getIdestado();
                    String copyIdestado = ((String) strategy.copy(LocatorUtils.property(locator, "idestado", sourceIdestado), sourceIdestado, (this.idestado!= null)));
                    copy.setIdestado(copyIdestado);
                } else {
                    if (idestadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idestado = null;
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
                Boolean idestadomtuShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idestadomtu!= null));
                if (idestadomtuShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdestadomtu;
                    sourceIdestadomtu = this.getIdestadomtu();
                    String copyIdestadomtu = ((String) strategy.copy(LocatorUtils.property(locator, "idestadomtu", sourceIdestadomtu), sourceIdestadomtu, (this.idestadomtu!= null)));
                    copy.setIdestadomtu(copyIdestadomtu);
                } else {
                    if (idestadomtuShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idestadomtu = null;
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
                Boolean icmParametrostiendaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParametrostiendaRecordSet!= null)&&(!this.icmParametrostiendaRecordSet.isEmpty())));
                if (icmParametrostiendaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParametrostiendaRecord> sourceIcmParametrostiendaRecordSet;
                    sourceIcmParametrostiendaRecordSet = (((this.icmParametrostiendaRecordSet!= null)&&(!this.icmParametrostiendaRecordSet.isEmpty()))?this.getIcmParametrostiendaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParametrostiendaRecord> copyIcmParametrostiendaRecordSet = ((List<IcmParametrostiendaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParametrostiendaRecordSet", sourceIcmParametrostiendaRecordSet), sourceIcmParametrostiendaRecordSet, ((this.icmParametrostiendaRecordSet!= null)&&(!this.icmParametrostiendaRecordSet.isEmpty()))));
                    copy.icmParametrostiendaRecordSet = null;
                    if (copyIcmParametrostiendaRecordSet!= null) {
                        List<IcmParametrostiendaRecord> uniqueIcmParametrostiendaRecordSetl = copy.getIcmParametrostiendaRecordSet();
                        uniqueIcmParametrostiendaRecordSetl.addAll(copyIcmParametrostiendaRecordSet);
                    }
                } else {
                    if (icmParametrostiendaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrostiendaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParametrostiendaBlock();
    }

}
