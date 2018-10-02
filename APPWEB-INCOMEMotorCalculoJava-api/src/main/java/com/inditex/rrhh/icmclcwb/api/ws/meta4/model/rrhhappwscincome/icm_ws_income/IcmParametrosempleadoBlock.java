
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_ParametrosempleadoBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
public class IcmParametrosempleadoBlock {

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
     * Gets the value of the idempleado property.
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
     * Sets the value of the idempleado property.
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
     * Gets the value of the orempleado property.
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
     * Sets the value of the orempleado property.
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
     * Gets the value of the idorigenpresencia property.
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
     * Sets the value of the idorigenpresencia property.
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

}
