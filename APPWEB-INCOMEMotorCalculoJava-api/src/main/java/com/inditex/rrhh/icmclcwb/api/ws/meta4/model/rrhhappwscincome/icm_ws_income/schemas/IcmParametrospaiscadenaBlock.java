
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_ParametrospaiscadenaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrospaiscadenaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fechafin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idcadena" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechainicio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechafindesde" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechafinhasta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechainiciodesde" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechainiciohasta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParametrospaiscadenaRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_ParametrospaiscadenaRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
public class IcmParametrospaiscadenaBlock {

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
    @XmlElement(name = "Icm_ParametrospaiscadenaRecordSet", required = true, nillable = true)
    protected ArrayOfIcmParametrospaiscadenaRecord icmParametrospaiscadenaRecordSet;

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
     * Obtiene el valor de la propiedad icmParametrospaiscadenaRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmParametrospaiscadenaRecord }
     *     
     */
    public ArrayOfIcmParametrospaiscadenaRecord getIcmParametrospaiscadenaRecordSet() {
        return icmParametrospaiscadenaRecordSet;
    }

    /**
     * Define el valor de la propiedad icmParametrospaiscadenaRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmParametrospaiscadenaRecord }
     *     
     */
    public void setIcmParametrospaiscadenaRecordSet(ArrayOfIcmParametrospaiscadenaRecord value) {
        this.icmParametrospaiscadenaRecordSet = value;
    }

}
