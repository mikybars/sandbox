
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_ErroresguardadoBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_ErroresguardadoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ErroresguardadoRecordSet" type="{http://schemas.meta4.com/}Icm_ErroresguardadoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ErroresguardadoBlock", propOrder = {
    "resultado",
    "icmErroresguardadoRecordSet"
})
public class IcmErroresguardadoBlock {

    @XmlElement(required = true, nillable = true)
    protected String resultado;
    @XmlElement(name = "Icm_ErroresguardadoRecordSet", nillable = true)
    protected List<IcmErroresguardadoRecord> icmErroresguardadoRecordSet;

    /**
     * Gets the value of the resultado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Sets the value of the resultado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultado(String value) {
        this.resultado = value;
    }

    /**
     * Gets the value of the icmErroresguardadoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmErroresguardadoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmErroresguardadoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmErroresguardadoRecord }
     * 
     * 
     */
    public List<IcmErroresguardadoRecord> getIcmErroresguardadoRecordSet() {
        if (icmErroresguardadoRecordSet == null) {
            icmErroresguardadoRecordSet = new ArrayList<IcmErroresguardadoRecord>();
        }
        return this.icmErroresguardadoRecordSet;
    }

}
