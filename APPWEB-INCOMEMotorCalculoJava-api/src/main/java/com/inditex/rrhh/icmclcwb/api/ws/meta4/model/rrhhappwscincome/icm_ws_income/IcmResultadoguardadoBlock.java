
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_ResultadoguardadoBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_ResultadoguardadoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_ResultadoguardadoRecordSet" type="{http://schemas.meta4.com/}Icm_ResultadoguardadoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ResultadoguardadoBlock", propOrder = {
    "icmResultadoguardadoRecordSet"
})
public class IcmResultadoguardadoBlock {

    @XmlElement(name = "Icm_ResultadoguardadoRecordSet", nillable = true)
    protected List<IcmResultadoguardadoRecord> icmResultadoguardadoRecordSet;

    /**
     * Gets the value of the icmResultadoguardadoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmResultadoguardadoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmResultadoguardadoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmResultadoguardadoRecord }
     * 
     * 
     */
    public List<IcmResultadoguardadoRecord> getIcmResultadoguardadoRecordSet() {
        if (icmResultadoguardadoRecordSet == null) {
            icmResultadoguardadoRecordSet = new ArrayList<IcmResultadoguardadoRecord>();
        }
        return this.icmResultadoguardadoRecordSet;
    }

}
