
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_ParametrostiendaBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
public class IcmParametrostiendaBlock {

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
     * Gets the value of the fechafin property.
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
     * Sets the value of the fechafin property.
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
     * Gets the value of the idestado property.
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
     * Sets the value of the idestado property.
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
     * Gets the value of the fechainicio property.
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
     * Sets the value of the fechainicio property.
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
     * Gets the value of the idestadomtu property.
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
     * Sets the value of the idestadomtu property.
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
     * Gets the value of the idlugartrabajo property.
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
     * Sets the value of the idlugartrabajo property.
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

}
