
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

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
 * <p>Clase Java para Icm_ParamcalprocesoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParamcalprocesoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idambito" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idorigen" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idusuario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idestadoejec" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idorganization" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ParamcalprocesoRecordSet" type="{http://schemas.meta4.com/}Icm_ParamcalprocesoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParamcalprocesoBlock", propOrder = {
    "idambito",
    "idorigen",
    "idusuario",
    "idestadoejec",
    "idorganization",
    "icmParamcalprocesoRecordSet"
})
public class IcmParamcalprocesoBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(required = true, nillable = true)
    protected String idambito;
    @XmlElement(required = true, nillable = true)
    protected String idorigen;
    @XmlElement(required = true, nillable = true)
    protected String idusuario;
    @XmlElement(required = true, nillable = true)
    protected String idestadoejec;
    @XmlElement(required = true, nillable = true)
    protected String idorganization;
    @XmlElement(name = "Icm_ParamcalprocesoRecordSet", nillable = true)
    protected List<IcmParamcalprocesoRecord> icmParamcalprocesoRecordSet;

    /**
     * Obtiene el valor de la propiedad idambito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdambito() {
        return idambito;
    }

    /**
     * Define el valor de la propiedad idambito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdambito(String value) {
        this.idambito = value;
    }

    /**
     * Obtiene el valor de la propiedad idorigen.
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
     * Define el valor de la propiedad idorigen.
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
     * Obtiene el valor de la propiedad idusuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdusuario() {
        return idusuario;
    }

    /**
     * Define el valor de la propiedad idusuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdusuario(String value) {
        this.idusuario = value;
    }

    /**
     * Obtiene el valor de la propiedad idestadoejec.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdestadoejec() {
        return idestadoejec;
    }

    /**
     * Define el valor de la propiedad idestadoejec.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdestadoejec(String value) {
        this.idestadoejec = value;
    }

    /**
     * Obtiene el valor de la propiedad idorganization.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdorganization() {
        return idorganization;
    }

    /**
     * Define el valor de la propiedad idorganization.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdorganization(String value) {
        this.idorganization = value;
    }

    /**
     * Gets the value of the icmParamcalprocesoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParamcalprocesoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParamcalprocesoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParamcalprocesoRecord }
     * 
     * 
     */
    public List<IcmParamcalprocesoRecord> getIcmParamcalprocesoRecordSet() {
        if (icmParamcalprocesoRecordSet == null) {
            icmParamcalprocesoRecordSet = new ArrayList<IcmParamcalprocesoRecord>();
        }
        return this.icmParamcalprocesoRecordSet;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParamcalprocesoBlock that = ((IcmParamcalprocesoBlock) object);
        {
            String lhsIdambito;
            lhsIdambito = this.getIdambito();
            String rhsIdambito;
            rhsIdambito = that.getIdambito();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idambito", lhsIdambito), LocatorUtils.property(thatLocator, "idambito", rhsIdambito), lhsIdambito, rhsIdambito, (this.idambito!= null), (that.idambito!= null))) {
                return false;
            }
        }
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
            String lhsIdusuario;
            lhsIdusuario = this.getIdusuario();
            String rhsIdusuario;
            rhsIdusuario = that.getIdusuario();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idusuario", lhsIdusuario), LocatorUtils.property(thatLocator, "idusuario", rhsIdusuario), lhsIdusuario, rhsIdusuario, (this.idusuario!= null), (that.idusuario!= null))) {
                return false;
            }
        }
        {
            String lhsIdestadoejec;
            lhsIdestadoejec = this.getIdestadoejec();
            String rhsIdestadoejec;
            rhsIdestadoejec = that.getIdestadoejec();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idestadoejec", lhsIdestadoejec), LocatorUtils.property(thatLocator, "idestadoejec", rhsIdestadoejec), lhsIdestadoejec, rhsIdestadoejec, (this.idestadoejec!= null), (that.idestadoejec!= null))) {
                return false;
            }
        }
        {
            String lhsIdorganization;
            lhsIdorganization = this.getIdorganization();
            String rhsIdorganization;
            rhsIdorganization = that.getIdorganization();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "idorganization", lhsIdorganization), LocatorUtils.property(thatLocator, "idorganization", rhsIdorganization), lhsIdorganization, rhsIdorganization, (this.idorganization!= null), (that.idorganization!= null))) {
                return false;
            }
        }
        {
            List<IcmParamcalprocesoRecord> lhsIcmParamcalprocesoRecordSet;
            lhsIcmParamcalprocesoRecordSet = (((this.icmParamcalprocesoRecordSet!= null)&&(!this.icmParamcalprocesoRecordSet.isEmpty()))?this.getIcmParamcalprocesoRecordSet():null);
            List<IcmParamcalprocesoRecord> rhsIcmParamcalprocesoRecordSet;
            rhsIcmParamcalprocesoRecordSet = (((that.icmParamcalprocesoRecordSet!= null)&&(!that.icmParamcalprocesoRecordSet.isEmpty()))?that.getIcmParamcalprocesoRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParamcalprocesoRecordSet", lhsIcmParamcalprocesoRecordSet), LocatorUtils.property(thatLocator, "icmParamcalprocesoRecordSet", rhsIcmParamcalprocesoRecordSet), lhsIcmParamcalprocesoRecordSet, rhsIcmParamcalprocesoRecordSet, ((this.icmParamcalprocesoRecordSet!= null)&&(!this.icmParamcalprocesoRecordSet.isEmpty())), ((that.icmParamcalprocesoRecordSet!= null)&&(!that.icmParamcalprocesoRecordSet.isEmpty())))) {
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
            String theIdambito;
            theIdambito = this.getIdambito();
            strategy.appendField(locator, this, "idambito", buffer, theIdambito, (this.idambito!= null));
        }
        {
            String theIdorigen;
            theIdorigen = this.getIdorigen();
            strategy.appendField(locator, this, "idorigen", buffer, theIdorigen, (this.idorigen!= null));
        }
        {
            String theIdusuario;
            theIdusuario = this.getIdusuario();
            strategy.appendField(locator, this, "idusuario", buffer, theIdusuario, (this.idusuario!= null));
        }
        {
            String theIdestadoejec;
            theIdestadoejec = this.getIdestadoejec();
            strategy.appendField(locator, this, "idestadoejec", buffer, theIdestadoejec, (this.idestadoejec!= null));
        }
        {
            String theIdorganization;
            theIdorganization = this.getIdorganization();
            strategy.appendField(locator, this, "idorganization", buffer, theIdorganization, (this.idorganization!= null));
        }
        {
            List<IcmParamcalprocesoRecord> theIcmParamcalprocesoRecordSet;
            theIcmParamcalprocesoRecordSet = (((this.icmParamcalprocesoRecordSet!= null)&&(!this.icmParamcalprocesoRecordSet.isEmpty()))?this.getIcmParamcalprocesoRecordSet():null);
            strategy.appendField(locator, this, "icmParamcalprocesoRecordSet", buffer, theIcmParamcalprocesoRecordSet, ((this.icmParamcalprocesoRecordSet!= null)&&(!this.icmParamcalprocesoRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theIdambito;
            theIdambito = this.getIdambito();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idambito", theIdambito), currentHashCode, theIdambito, (this.idambito!= null));
        }
        {
            String theIdorigen;
            theIdorigen = this.getIdorigen();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idorigen", theIdorigen), currentHashCode, theIdorigen, (this.idorigen!= null));
        }
        {
            String theIdusuario;
            theIdusuario = this.getIdusuario();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idusuario", theIdusuario), currentHashCode, theIdusuario, (this.idusuario!= null));
        }
        {
            String theIdestadoejec;
            theIdestadoejec = this.getIdestadoejec();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idestadoejec", theIdestadoejec), currentHashCode, theIdestadoejec, (this.idestadoejec!= null));
        }
        {
            String theIdorganization;
            theIdorganization = this.getIdorganization();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idorganization", theIdorganization), currentHashCode, theIdorganization, (this.idorganization!= null));
        }
        {
            List<IcmParamcalprocesoRecord> theIcmParamcalprocesoRecordSet;
            theIcmParamcalprocesoRecordSet = (((this.icmParamcalprocesoRecordSet!= null)&&(!this.icmParamcalprocesoRecordSet.isEmpty()))?this.getIcmParamcalprocesoRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParamcalprocesoRecordSet", theIcmParamcalprocesoRecordSet), currentHashCode, theIcmParamcalprocesoRecordSet, ((this.icmParamcalprocesoRecordSet!= null)&&(!this.icmParamcalprocesoRecordSet.isEmpty())));
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
        if (draftCopy instanceof IcmParamcalprocesoBlock) {
            final IcmParamcalprocesoBlock copy = ((IcmParamcalprocesoBlock) draftCopy);
            {
                Boolean idambitoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idambito!= null));
                if (idambitoShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdambito;
                    sourceIdambito = this.getIdambito();
                    String copyIdambito = ((String) strategy.copy(LocatorUtils.property(locator, "idambito", sourceIdambito), sourceIdambito, (this.idambito!= null)));
                    copy.setIdambito(copyIdambito);
                } else {
                    if (idambitoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idambito = null;
                    }
                }
            }
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
                Boolean idusuarioShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idusuario!= null));
                if (idusuarioShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdusuario;
                    sourceIdusuario = this.getIdusuario();
                    String copyIdusuario = ((String) strategy.copy(LocatorUtils.property(locator, "idusuario", sourceIdusuario), sourceIdusuario, (this.idusuario!= null)));
                    copy.setIdusuario(copyIdusuario);
                } else {
                    if (idusuarioShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idusuario = null;
                    }
                }
            }
            {
                Boolean idestadoejecShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idestadoejec!= null));
                if (idestadoejecShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdestadoejec;
                    sourceIdestadoejec = this.getIdestadoejec();
                    String copyIdestadoejec = ((String) strategy.copy(LocatorUtils.property(locator, "idestadoejec", sourceIdestadoejec), sourceIdestadoejec, (this.idestadoejec!= null)));
                    copy.setIdestadoejec(copyIdestadoejec);
                } else {
                    if (idestadoejecShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idestadoejec = null;
                    }
                }
            }
            {
                Boolean idorganizationShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idorganization!= null));
                if (idorganizationShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceIdorganization;
                    sourceIdorganization = this.getIdorganization();
                    String copyIdorganization = ((String) strategy.copy(LocatorUtils.property(locator, "idorganization", sourceIdorganization), sourceIdorganization, (this.idorganization!= null)));
                    copy.setIdorganization(copyIdorganization);
                } else {
                    if (idorganizationShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.idorganization = null;
                    }
                }
            }
            {
                Boolean icmParamcalprocesoRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParamcalprocesoRecordSet!= null)&&(!this.icmParamcalprocesoRecordSet.isEmpty())));
                if (icmParamcalprocesoRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParamcalprocesoRecord> sourceIcmParamcalprocesoRecordSet;
                    sourceIcmParamcalprocesoRecordSet = (((this.icmParamcalprocesoRecordSet!= null)&&(!this.icmParamcalprocesoRecordSet.isEmpty()))?this.getIcmParamcalprocesoRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParamcalprocesoRecord> copyIcmParamcalprocesoRecordSet = ((List<IcmParamcalprocesoRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParamcalprocesoRecordSet", sourceIcmParamcalprocesoRecordSet), sourceIcmParamcalprocesoRecordSet, ((this.icmParamcalprocesoRecordSet!= null)&&(!this.icmParamcalprocesoRecordSet.isEmpty()))));
                    copy.icmParamcalprocesoRecordSet = null;
                    if (copyIcmParamcalprocesoRecordSet!= null) {
                        List<IcmParamcalprocesoRecord> uniqueIcmParamcalprocesoRecordSetl = copy.getIcmParamcalprocesoRecordSet();
                        uniqueIcmParamcalprocesoRecordSetl.addAll(copyIcmParamcalprocesoRecordSet);
                    }
                } else {
                    if (icmParamcalprocesoRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParamcalprocesoRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParamcalprocesoBlock();
    }

}
