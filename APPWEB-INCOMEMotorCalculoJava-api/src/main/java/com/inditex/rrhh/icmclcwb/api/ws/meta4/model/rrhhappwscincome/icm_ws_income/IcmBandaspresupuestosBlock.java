
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_BandaspresupuestosBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_BandaspresupuestosBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_BandaspresupuestosRecordSet" type="{http://schemas.meta4.com/}Icm_BandaspresupuestosRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_BandaspresupuestosBlock", propOrder = {
    "icmBandaspresupuestosRecordSet"
})
public class IcmBandaspresupuestosBlock {

    @XmlElement(name = "Icm_BandaspresupuestosRecordSet", nillable = true)
    protected List<IcmBandaspresupuestosRecord> icmBandaspresupuestosRecordSet;

    /**
     * Gets the value of the icmBandaspresupuestosRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmBandaspresupuestosRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmBandaspresupuestosRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmBandaspresupuestosRecord }
     * 
     * 
     */
    public List<IcmBandaspresupuestosRecord> getIcmBandaspresupuestosRecordSet() {
        if (icmBandaspresupuestosRecordSet == null) {
            icmBandaspresupuestosRecordSet = new ArrayList<IcmBandaspresupuestosRecord>();
        }
        return this.icmBandaspresupuestosRecordSet;
    }

}
