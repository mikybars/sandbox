
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_ParametrostiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrostiendaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fechafin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idestado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechainicio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idestadomtu" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idlugartrabajo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParametrostiendaRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_ParametrostiendaRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
    @XmlElement(name = "Icm_ParametrostiendaRecordSet", required = true, nillable = true)
    protected ArrayOfIcmParametrostiendaRecord icmParametrostiendaRecordSet;

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
     * Obtiene el valor de la propiedad icmParametrostiendaRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmParametrostiendaRecord }
     *     
     */
    public ArrayOfIcmParametrostiendaRecord getIcmParametrostiendaRecordSet() {
        return icmParametrostiendaRecordSet;
    }

    /**
     * Define el valor de la propiedad icmParametrostiendaRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmParametrostiendaRecord }
     *     
     */
    public void setIcmParametrostiendaRecordSet(ArrayOfIcmParametrostiendaRecord value) {
        this.icmParametrostiendaRecordSet = value;
    }

}
