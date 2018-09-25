
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_GlobaltiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_GlobaltiendaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sys_Param_A" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sys_Sentence_A" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_GlobaltiendaRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_GlobaltiendaRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_GlobaltiendaBlock", propOrder = {
    "sysParamA",
    "sysSentenceA",
    "icmGlobaltiendaRecordSet"
})
public class IcmGlobaltiendaBlock {

    @XmlElement(name = "sys_Param_A", required = true, nillable = true)
    protected String sysParamA;
    @XmlElement(name = "sys_Sentence_A", required = true, nillable = true)
    protected String sysSentenceA;
    @XmlElement(name = "Icm_GlobaltiendaRecordSet", required = true, nillable = true)
    protected ArrayOfIcmGlobaltiendaRecord icmGlobaltiendaRecordSet;

    /**
     * Obtiene el valor de la propiedad sysParamA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysParamA() {
        return sysParamA;
    }

    /**
     * Define el valor de la propiedad sysParamA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysParamA(String value) {
        this.sysParamA = value;
    }

    /**
     * Obtiene el valor de la propiedad sysSentenceA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysSentenceA() {
        return sysSentenceA;
    }

    /**
     * Define el valor de la propiedad sysSentenceA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysSentenceA(String value) {
        this.sysSentenceA = value;
    }

    /**
     * Obtiene el valor de la propiedad icmGlobaltiendaRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmGlobaltiendaRecord }
     *     
     */
    public ArrayOfIcmGlobaltiendaRecord getIcmGlobaltiendaRecordSet() {
        return icmGlobaltiendaRecordSet;
    }

    /**
     * Define el valor de la propiedad icmGlobaltiendaRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmGlobaltiendaRecord }
     *     
     */
    public void setIcmGlobaltiendaRecordSet(ArrayOfIcmGlobaltiendaRecord value) {
        this.icmGlobaltiendaRecordSet = value;
    }

}
