
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_CabeceratiendaBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_CabeceratiendaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_CabeceratiendaRecordSet" type="{http://schemas.meta4.com/}Icm_CabeceratiendaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CabeceratiendaBlock", propOrder = {
    "icmCabeceratiendaRecordSet"
})
public class IcmCabeceratiendaBlock {

    @XmlElement(name = "Icm_CabeceratiendaRecordSet", nillable = true)
    protected List<IcmCabeceratiendaRecord> icmCabeceratiendaRecordSet;

    /**
     * Gets the value of the icmCabeceratiendaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCabeceratiendaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCabeceratiendaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCabeceratiendaRecord }
     * 
     * 
     */
    public List<IcmCabeceratiendaRecord> getIcmCabeceratiendaRecordSet() {
        if (icmCabeceratiendaRecordSet == null) {
            icmCabeceratiendaRecordSet = new ArrayList<IcmCabeceratiendaRecord>();
        }
        return this.icmCabeceratiendaRecordSet;
    }

}
