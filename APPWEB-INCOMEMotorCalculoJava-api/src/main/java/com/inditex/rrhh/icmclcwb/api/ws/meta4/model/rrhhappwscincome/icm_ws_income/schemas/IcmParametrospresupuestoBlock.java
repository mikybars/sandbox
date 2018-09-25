
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_ParametrospresupuestoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrospresupuestoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idcadena" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ejercicio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idlugartrabajo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParametrospresupuestoRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_ParametrospresupuestoRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
public class IcmParametrospresupuestoBlock {

    @XmlElement(required = true, nillable = true)
    protected String idcadena;
    @XmlElement(required = true, nillable = true)
    protected String ejercicio;
    @XmlElement(required = true, nillable = true)
    protected String idlugartrabajo;
    @XmlElement(name = "Icm_ParametrospresupuestoRecordSet", required = true, nillable = true)
    protected ArrayOfIcmParametrospresupuestoRecord icmParametrospresupuestoRecordSet;

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
     * Obtiene el valor de la propiedad icmParametrospresupuestoRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmParametrospresupuestoRecord }
     *     
     */
    public ArrayOfIcmParametrospresupuestoRecord getIcmParametrospresupuestoRecordSet() {
        return icmParametrospresupuestoRecordSet;
    }

    /**
     * Define el valor de la propiedad icmParametrospresupuestoRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmParametrospresupuestoRecord }
     *     
     */
    public void setIcmParametrospresupuestoRecordSet(ArrayOfIcmParametrospresupuestoRecord value) {
        this.icmParametrospresupuestoRecordSet = value;
    }

}
