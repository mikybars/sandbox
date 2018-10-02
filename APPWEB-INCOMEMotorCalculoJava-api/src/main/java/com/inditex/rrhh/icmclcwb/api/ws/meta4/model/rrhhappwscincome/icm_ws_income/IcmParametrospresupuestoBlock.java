
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_ParametrospresupuestoBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrospresupuestoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idcadena" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ejercicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idlugartrabajo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ParametrospresupuestoRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrospresupuestoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
     * Gets the value of the idcadena property.
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
     * Sets the value of the idcadena property.
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
     * Gets the value of the ejercicio property.
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
     * Sets the value of the ejercicio property.
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
