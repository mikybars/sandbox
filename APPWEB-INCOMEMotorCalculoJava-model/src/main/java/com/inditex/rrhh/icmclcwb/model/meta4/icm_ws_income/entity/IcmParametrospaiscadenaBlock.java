
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
 * <p>Clase Java para Icm_ParametrospaiscadenaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrospaiscadenaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechafin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idcadena" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechainicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechafindesde" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechafinhasta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechainiciodesde" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechainiciohasta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ParametrospaiscadenaRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrospaiscadenaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParametrospaiscadenaBlock", propOrder = {
    "fechafin",
    "idcadena",
    "fechainicio",
    "fechafindesde",
    "fechafinhasta",
    "fechainiciodesde",
    "fechainiciohasta",
    "icmParametrospaiscadenaRecordSet"
})
public class IcmParametrospaiscadenaBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String fechafin;
    @XmlElement(required = true, nillable = true)
    protected String idcadena;
    @XmlElement(required = true, nillable = true)
    protected String fechainicio;
    @XmlElement(required = true, nillable = true)
    protected String fechafindesde;
    @XmlElement(required = true, nillable = true)
    protected String fechafinhasta;
    @XmlElement(required = true, nillable = true)
    protected String fechainiciodesde;
    @XmlElement(required = true, nillable = true)
    protected String fechainiciohasta;
    @XmlElement(name = "Icm_ParametrospaiscadenaRecordSet", nillable = true)
    protected List<IcmParametrospaiscadenaRecord> icmParametrospaiscadenaRecordSet;

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
     * Obtiene el valor de la propiedad fechafindesde.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechafindesde() {
        return fechafindesde;
    }

    /**
     * Define el valor de la propiedad fechafindesde.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechafindesde(String value) {
        this.fechafindesde = value;
    }

    /**
     * Obtiene el valor de la propiedad fechafinhasta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechafinhasta() {
        return fechafinhasta;
    }

    /**
     * Define el valor de la propiedad fechafinhasta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechafinhasta(String value) {
        this.fechafinhasta = value;
    }

    /**
     * Obtiene el valor de la propiedad fechainiciodesde.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechainiciodesde() {
        return fechainiciodesde;
    }

    /**
     * Define el valor de la propiedad fechainiciodesde.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechainiciodesde(String value) {
        this.fechainiciodesde = value;
    }

    /**
     * Obtiene el valor de la propiedad fechainiciohasta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechainiciohasta() {
        return fechainiciohasta;
    }

    /**
     * Define el valor de la propiedad fechainiciohasta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechainiciohasta(String value) {
        this.fechainiciohasta = value;
    }

    /**
     * Gets the value of the icmParametrospaiscadenaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParametrospaiscadenaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParametrospaiscadenaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParametrospaiscadenaRecord }
     * 
     * 
     */
    public List<IcmParametrospaiscadenaRecord> getIcmParametrospaiscadenaRecordSet() {
        if (icmParametrospaiscadenaRecordSet == null) {
            icmParametrospaiscadenaRecordSet = new ArrayList<IcmParametrospaiscadenaRecord>();
        }
        return this.icmParametrospaiscadenaRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParametrospaiscadenaBlock that = ((IcmParametrospaiscadenaBlock) object);
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
            String lhsIdcadena;
            lhsIdcadena = this.getIdcadena();
            String rhsIdcadena;
            rhsIdcadena = that.getIdcadena();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idcadena", lhsIdcadena), LocatorUtils.property(thatLocator, "idcadena", rhsIdcadena), lhsIdcadena, rhsIdcadena, (this.idcadena!= null), (that.idcadena!= null))) {
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
            String lhsFechafindesde;
            lhsFechafindesde = this.getFechafindesde();
            String rhsFechafindesde;
            rhsFechafindesde = that.getFechafindesde();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fechafindesde", lhsFechafindesde), LocatorUtils.property(thatLocator, "fechafindesde", rhsFechafindesde), lhsFechafindesde, rhsFechafindesde, (this.fechafindesde!= null), (that.fechafindesde!= null))) {
                return false;
            }
        }
        {
            String lhsFechafinhasta;
            lhsFechafinhasta = this.getFechafinhasta();
            String rhsFechafinhasta;
            rhsFechafinhasta = that.getFechafinhasta();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fechafinhasta", lhsFechafinhasta), LocatorUtils.property(thatLocator, "fechafinhasta", rhsFechafinhasta), lhsFechafinhasta, rhsFechafinhasta, (this.fechafinhasta!= null), (that.fechafinhasta!= null))) {
                return false;
            }
        }
        {
            String lhsFechainiciodesde;
            lhsFechainiciodesde = this.getFechainiciodesde();
            String rhsFechainiciodesde;
            rhsFechainiciodesde = that.getFechainiciodesde();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fechainiciodesde", lhsFechainiciodesde), LocatorUtils.property(thatLocator, "fechainiciodesde", rhsFechainiciodesde), lhsFechainiciodesde, rhsFechainiciodesde, (this.fechainiciodesde!= null), (that.fechainiciodesde!= null))) {
                return false;
            }
        }
        {
            String lhsFechainiciohasta;
            lhsFechainiciohasta = this.getFechainiciohasta();
            String rhsFechainiciohasta;
            rhsFechainiciohasta = that.getFechainiciohasta();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fechainiciohasta", lhsFechainiciohasta), LocatorUtils.property(thatLocator, "fechainiciohasta", rhsFechainiciohasta), lhsFechainiciohasta, rhsFechainiciohasta, (this.fechainiciohasta!= null), (that.fechainiciohasta!= null))) {
                return false;
            }
        }
        {
            List<IcmParametrospaiscadenaRecord> lhsIcmParametrospaiscadenaRecordSet;
            lhsIcmParametrospaiscadenaRecordSet = (((this.icmParametrospaiscadenaRecordSet!= null)&&(!this.icmParametrospaiscadenaRecordSet.isEmpty()))?this.getIcmParametrospaiscadenaRecordSet():null);
            List<IcmParametrospaiscadenaRecord> rhsIcmParametrospaiscadenaRecordSet;
            rhsIcmParametrospaiscadenaRecordSet = (((that.icmParametrospaiscadenaRecordSet!= null)&&(!that.icmParametrospaiscadenaRecordSet.isEmpty()))?that.getIcmParametrospaiscadenaRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrospaiscadenaRecordSet", lhsIcmParametrospaiscadenaRecordSet), LocatorUtils.property(thatLocator, "icmParametrospaiscadenaRecordSet", rhsIcmParametrospaiscadenaRecordSet), lhsIcmParametrospaiscadenaRecordSet, rhsIcmParametrospaiscadenaRecordSet, ((this.icmParametrospaiscadenaRecordSet!= null)&&(!this.icmParametrospaiscadenaRecordSet.isEmpty())), ((that.icmParametrospaiscadenaRecordSet!= null)&&(!that.icmParametrospaiscadenaRecordSet.isEmpty())))) {
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
            String theIdcadena;
            theIdcadena = this.getIdcadena();
            strategy.appendField(locator, this, "idcadena", buffer, theIdcadena, (this.idcadena!= null));
        }
        {
            String theFechainicio;
            theFechainicio = this.getFechainicio();
            strategy.appendField(locator, this, "fechainicio", buffer, theFechainicio, (this.fechainicio!= null));
        }
        {
            String theFechafindesde;
            theFechafindesde = this.getFechafindesde();
            strategy.appendField(locator, this, "fechafindesde", buffer, theFechafindesde, (this.fechafindesde!= null));
        }
        {
            String theFechafinhasta;
            theFechafinhasta = this.getFechafinhasta();
            strategy.appendField(locator, this, "fechafinhasta", buffer, theFechafinhasta, (this.fechafinhasta!= null));
        }
        {
            String theFechainiciodesde;
            theFechainiciodesde = this.getFechainiciodesde();
            strategy.appendField(locator, this, "fechainiciodesde", buffer, theFechainiciodesde, (this.fechainiciodesde!= null));
        }
        {
            String theFechainiciohasta;
            theFechainiciohasta = this.getFechainiciohasta();
            strategy.appendField(locator, this, "fechainiciohasta", buffer, theFechainiciohasta, (this.fechainiciohasta!= null));
        }
        {
            List<IcmParametrospaiscadenaRecord> theIcmParametrospaiscadenaRecordSet;
            theIcmParametrospaiscadenaRecordSet = (((this.icmParametrospaiscadenaRecordSet!= null)&&(!this.icmParametrospaiscadenaRecordSet.isEmpty()))?this.getIcmParametrospaiscadenaRecordSet():null);
            strategy.appendField(locator, this, "icmParametrospaiscadenaRecordSet", buffer, theIcmParametrospaiscadenaRecordSet, ((this.icmParametrospaiscadenaRecordSet!= null)&&(!this.icmParametrospaiscadenaRecordSet.isEmpty())));
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
            String theIdcadena;
            theIdcadena = this.getIdcadena();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idcadena", theIdcadena), currentHashCode, theIdcadena, (this.idcadena!= null));
        }
        {
            String theFechainicio;
            theFechainicio = this.getFechainicio();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechainicio", theFechainicio), currentHashCode, theFechainicio, (this.fechainicio!= null));
        }
        {
            String theFechafindesde;
            theFechafindesde = this.getFechafindesde();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechafindesde", theFechafindesde), currentHashCode, theFechafindesde, (this.fechafindesde!= null));
        }
        {
            String theFechafinhasta;
            theFechafinhasta = this.getFechafinhasta();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechafinhasta", theFechafinhasta), currentHashCode, theFechafinhasta, (this.fechafinhasta!= null));
        }
        {
            String theFechainiciodesde;
            theFechainiciodesde = this.getFechainiciodesde();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechainiciodesde", theFechainiciodesde), currentHashCode, theFechainiciodesde, (this.fechainiciodesde!= null));
        }
        {
            String theFechainiciohasta;
            theFechainiciohasta = this.getFechainiciohasta();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fechainiciohasta", theFechainiciohasta), currentHashCode, theFechainiciohasta, (this.fechainiciohasta!= null));
        }
        {
            List<IcmParametrospaiscadenaRecord> theIcmParametrospaiscadenaRecordSet;
            theIcmParametrospaiscadenaRecordSet = (((this.icmParametrospaiscadenaRecordSet!= null)&&(!this.icmParametrospaiscadenaRecordSet.isEmpty()))?this.getIcmParametrospaiscadenaRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrospaiscadenaRecordSet", theIcmParametrospaiscadenaRecordSet), currentHashCode, theIcmParametrospaiscadenaRecordSet, ((this.icmParametrospaiscadenaRecordSet!= null)&&(!this.icmParametrospaiscadenaRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParametrospaiscadenaBlock) {
            final IcmParametrospaiscadenaBlock copy = ((IcmParametrospaiscadenaBlock) draftCopy);
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
                Boolean fechafindesdeShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.fechafindesde!= null));
                if (fechafindesdeShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceFechafindesde;
                    sourceFechafindesde = this.getFechafindesde();
                    String copyFechafindesde = ((String) strategy.copy(LocatorUtils.property(locator, "fechafindesde", sourceFechafindesde), sourceFechafindesde, (this.fechafindesde!= null)));
                    copy.setFechafindesde(copyFechafindesde);
                } else {
                    if (fechafindesdeShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.fechafindesde = null;
                    }
                }
            }
            {
                Boolean fechafinhastaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.fechafinhasta!= null));
                if (fechafinhastaShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceFechafinhasta;
                    sourceFechafinhasta = this.getFechafinhasta();
                    String copyFechafinhasta = ((String) strategy.copy(LocatorUtils.property(locator, "fechafinhasta", sourceFechafinhasta), sourceFechafinhasta, (this.fechafinhasta!= null)));
                    copy.setFechafinhasta(copyFechafinhasta);
                } else {
                    if (fechafinhastaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.fechafinhasta = null;
                    }
                }
            }
            {
                Boolean fechainiciodesdeShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.fechainiciodesde!= null));
                if (fechainiciodesdeShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceFechainiciodesde;
                    sourceFechainiciodesde = this.getFechainiciodesde();
                    String copyFechainiciodesde = ((String) strategy.copy(LocatorUtils.property(locator, "fechainiciodesde", sourceFechainiciodesde), sourceFechainiciodesde, (this.fechainiciodesde!= null)));
                    copy.setFechainiciodesde(copyFechainiciodesde);
                } else {
                    if (fechainiciodesdeShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.fechainiciodesde = null;
                    }
                }
            }
            {
                Boolean fechainiciohastaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.fechainiciohasta!= null));
                if (fechainiciohastaShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceFechainiciohasta;
                    sourceFechainiciohasta = this.getFechainiciohasta();
                    String copyFechainiciohasta = ((String) strategy.copy(LocatorUtils.property(locator, "fechainiciohasta", sourceFechainiciohasta), sourceFechainiciohasta, (this.fechainiciohasta!= null)));
                    copy.setFechainiciohasta(copyFechainiciohasta);
                } else {
                    if (fechainiciohastaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.fechainiciohasta = null;
                    }
                }
            }
            {
                Boolean icmParametrospaiscadenaRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParametrospaiscadenaRecordSet!= null)&&(!this.icmParametrospaiscadenaRecordSet.isEmpty())));
                if (icmParametrospaiscadenaRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParametrospaiscadenaRecord> sourceIcmParametrospaiscadenaRecordSet;
                    sourceIcmParametrospaiscadenaRecordSet = (((this.icmParametrospaiscadenaRecordSet!= null)&&(!this.icmParametrospaiscadenaRecordSet.isEmpty()))?this.getIcmParametrospaiscadenaRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParametrospaiscadenaRecord> copyIcmParametrospaiscadenaRecordSet = ((List<IcmParametrospaiscadenaRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParametrospaiscadenaRecordSet", sourceIcmParametrospaiscadenaRecordSet), sourceIcmParametrospaiscadenaRecordSet, ((this.icmParametrospaiscadenaRecordSet!= null)&&(!this.icmParametrospaiscadenaRecordSet.isEmpty()))));
                    copy.icmParametrospaiscadenaRecordSet = null;
                    if (copyIcmParametrospaiscadenaRecordSet!= null) {
                        List<IcmParametrospaiscadenaRecord> uniqueIcmParametrospaiscadenaRecordSetl = copy.getIcmParametrospaiscadenaRecordSet();
                        uniqueIcmParametrospaiscadenaRecordSetl.addAll(copyIcmParametrospaiscadenaRecordSet);
                    }
                } else {
                    if (icmParametrospaiscadenaRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrospaiscadenaRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParametrospaiscadenaBlock();
    }

}
