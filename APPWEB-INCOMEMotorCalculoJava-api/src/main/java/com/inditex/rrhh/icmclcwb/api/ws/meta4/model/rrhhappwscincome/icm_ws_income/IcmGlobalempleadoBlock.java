
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_GlobalempleadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_GlobalempleadoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sys_Param_A" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sys_Sentence_A" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_GlobalempleadoRecordSet" type="{http://schemas.meta4.com/}Icm_GlobalempleadoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_GlobalempleadoBlock", propOrder = {
    "sysParamA",
    "sysSentenceA",
    "icmGlobalempleadoRecordSet"
})
public class IcmGlobalempleadoBlock {

    @XmlElement(name = "sys_Param_A", required = true, nillable = true)
    protected String sysParamA;
    @XmlElement(name = "sys_Sentence_A", required = true, nillable = true)
    protected String sysSentenceA;
    @XmlElement(name = "Icm_GlobalempleadoRecordSet", nillable = true)
    protected List<IcmGlobalempleadoRecord> icmGlobalempleadoRecordSet;

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
     * Gets the value of the icmGlobalempleadoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmGlobalempleadoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmGlobalempleadoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmGlobalempleadoRecord }
     * 
     * 
     */
    public List<IcmGlobalempleadoRecord> getIcmGlobalempleadoRecordSet() {
        if (icmGlobalempleadoRecordSet == null) {
            icmGlobalempleadoRecordSet = new ArrayList<IcmGlobalempleadoRecord>();
        }
        return this.icmGlobalempleadoRecordSet;
    }

}
