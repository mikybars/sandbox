
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_GlobaltiendaBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_GlobaltiendaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sys_Param_A" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sys_Sentence_A" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_GlobaltiendaRecordSet" type="{http://schemas.meta4.com/}Icm_GlobaltiendaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
    @XmlElement(name = "Icm_GlobaltiendaRecordSet", nillable = true)
    protected List<IcmGlobaltiendaRecord> icmGlobaltiendaRecordSet;

    /**
     * Gets the value of the sysParamA property.
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
     * Sets the value of the sysParamA property.
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
     * Gets the value of the sysSentenceA property.
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
     * Sets the value of the sysSentenceA property.
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
     * Gets the value of the icmGlobaltiendaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmGlobaltiendaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmGlobaltiendaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmGlobaltiendaRecord }
     * 
     * 
     */
    public List<IcmGlobaltiendaRecord> getIcmGlobaltiendaRecordSet() {
        if (icmGlobaltiendaRecordSet == null) {
            icmGlobaltiendaRecordSet = new ArrayList<IcmGlobaltiendaRecord>();
        }
        return this.icmGlobaltiendaRecordSet;
    }

}
