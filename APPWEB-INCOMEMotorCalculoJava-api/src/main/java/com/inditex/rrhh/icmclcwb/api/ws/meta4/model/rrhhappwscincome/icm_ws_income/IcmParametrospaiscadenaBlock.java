
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_ParametrospaiscadenaBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
    @XmlElement(name = "Icm_ParametrospaiscadenaRecordSet", nillable = true)
    protected List<IcmParametrospaiscadenaRecord> icmParametrospaiscadenaRecordSet;

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
     * Gets the value of the fechafindesde property.
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
     * Sets the value of the fechafindesde property.
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
     * Gets the value of the fechafinhasta property.
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
     * Sets the value of the fechafinhasta property.
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
     * Gets the value of the fechainiciodesde property.
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
     * Sets the value of the fechainiciodesde property.
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
     * Gets the value of the fechainiciohasta property.
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
     * Sets the value of the fechainiciohasta property.
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

}
