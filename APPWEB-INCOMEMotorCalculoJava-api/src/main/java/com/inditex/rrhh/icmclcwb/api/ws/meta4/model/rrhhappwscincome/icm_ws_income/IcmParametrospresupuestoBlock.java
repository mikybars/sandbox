
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="Icm_ParametrospresupuestoRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrospresupuestoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
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

}
