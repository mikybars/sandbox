
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_ParametrospaginacionBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrospaginacionBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoorden" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="campoorden" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idbusqueda" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeropagina" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numerototalpaginas" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroregistrospagina" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numerototalresultados" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ParametrospaginacionRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParametrospaginacionBlock", propOrder = {
    "tipoorden",
    "campoorden",
    "idbusqueda",
    "numeropagina",
    "numerototalpaginas",
    "numeroregistrospagina",
    "numerototalresultados",
    "icmParametrospaginacionRecordSet"
})
public class IcmParametrospaginacionBlock {

    @XmlElement(required = true, nillable = true)
    protected String tipoorden;
    @XmlElement(required = true, nillable = true)
    protected String campoorden;
    @XmlElement(required = true, nillable = true)
    protected String idbusqueda;
    @XmlElement(required = true, nillable = true)
    protected String numeropagina;
    @XmlElement(required = true, nillable = true)
    protected String numerototalpaginas;
    @XmlElement(required = true, nillable = true)
    protected String numeroregistrospagina;
    @XmlElement(required = true, nillable = true)
    protected String numerototalresultados;
    @XmlElement(name = "Icm_ParametrospaginacionRecordSet", nillable = true)
    protected List<IcmParametrospaginacionRecord> icmParametrospaginacionRecordSet;

    /**
     * Gets the value of the tipoorden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoorden() {
        return tipoorden;
    }

    /**
     * Sets the value of the tipoorden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoorden(String value) {
        this.tipoorden = value;
    }

    /**
     * Gets the value of the campoorden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampoorden() {
        return campoorden;
    }

    /**
     * Sets the value of the campoorden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampoorden(String value) {
        this.campoorden = value;
    }

    /**
     * Gets the value of the idbusqueda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdbusqueda() {
        return idbusqueda;
    }

    /**
     * Sets the value of the idbusqueda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdbusqueda(String value) {
        this.idbusqueda = value;
    }

    /**
     * Gets the value of the numeropagina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeropagina() {
        return numeropagina;
    }

    /**
     * Sets the value of the numeropagina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeropagina(String value) {
        this.numeropagina = value;
    }

    /**
     * Gets the value of the numerototalpaginas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumerototalpaginas() {
        return numerototalpaginas;
    }

    /**
     * Sets the value of the numerototalpaginas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumerototalpaginas(String value) {
        this.numerototalpaginas = value;
    }

    /**
     * Gets the value of the numeroregistrospagina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroregistrospagina() {
        return numeroregistrospagina;
    }

    /**
     * Sets the value of the numeroregistrospagina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroregistrospagina(String value) {
        this.numeroregistrospagina = value;
    }

    /**
     * Gets the value of the numerototalresultados property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumerototalresultados() {
        return numerototalresultados;
    }

    /**
     * Sets the value of the numerototalresultados property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumerototalresultados(String value) {
        this.numerototalresultados = value;
    }

    /**
     * Gets the value of the icmParametrospaginacionRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParametrospaginacionRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParametrospaginacionRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParametrospaginacionRecord }
     * 
     * 
     */
    public List<IcmParametrospaginacionRecord> getIcmParametrospaginacionRecordSet() {
        if (icmParametrospaginacionRecordSet == null) {
            icmParametrospaginacionRecordSet = new ArrayList<IcmParametrospaginacionRecord>();
        }
        return this.icmParametrospaginacionRecordSet;
    }

}
