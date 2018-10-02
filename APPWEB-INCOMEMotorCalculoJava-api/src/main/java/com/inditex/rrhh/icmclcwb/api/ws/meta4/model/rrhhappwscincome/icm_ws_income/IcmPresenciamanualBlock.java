
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_PresenciamanualBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_PresenciamanualBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_PresenciamanualRecordSet" type="{http://schemas.meta4.com/}Icm_PresenciamanualRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_PresenciamanualBlock", propOrder = {
    "icmPresenciamanualRecordSet"
})
public class IcmPresenciamanualBlock {

    @XmlElement(name = "Icm_PresenciamanualRecordSet", nillable = true)
    protected List<IcmPresenciamanualRecord> icmPresenciamanualRecordSet;

    /**
     * Gets the value of the icmPresenciamanualRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmPresenciamanualRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmPresenciamanualRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmPresenciamanualRecord }
     * 
     * 
     */
    public List<IcmPresenciamanualRecord> getIcmPresenciamanualRecordSet() {
        if (icmPresenciamanualRecordSet == null) {
            icmPresenciamanualRecordSet = new ArrayList<IcmPresenciamanualRecord>();
        }
        return this.icmPresenciamanualRecordSet;
    }

}
