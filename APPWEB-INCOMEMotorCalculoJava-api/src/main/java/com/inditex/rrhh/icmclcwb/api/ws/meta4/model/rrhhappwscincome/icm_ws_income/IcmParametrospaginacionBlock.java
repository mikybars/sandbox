
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_ParametrospaginacionBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrospaginacionBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipoorden" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="campoorden" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idbusqueda" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numeropagina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numerototalpaginas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numeroregistrospagina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numerototalresultados" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParametrospaginacionRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     * Obtiene el valor de la propiedad tipoorden.
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
     * Define el valor de la propiedad tipoorden.
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
     * Obtiene el valor de la propiedad campoorden.
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
     * Define el valor de la propiedad campoorden.
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
     * Obtiene el valor de la propiedad idbusqueda.
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
     * Define el valor de la propiedad idbusqueda.
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
     * Obtiene el valor de la propiedad numeropagina.
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
     * Define el valor de la propiedad numeropagina.
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
     * Obtiene el valor de la propiedad numerototalpaginas.
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
     * Define el valor de la propiedad numerototalpaginas.
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
     * Obtiene el valor de la propiedad numeroregistrospagina.
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
     * Define el valor de la propiedad numeroregistrospagina.
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
     * Obtiene el valor de la propiedad numerototalresultados.
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
     * Define el valor de la propiedad numerototalresultados.
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
