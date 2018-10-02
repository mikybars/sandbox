
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_CabeceraempleadoBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_CabeceraempleadoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_CabeceraempleadoRecordSet" type="{http://schemas.meta4.com/}Icm_CabeceraempleadoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CabeceraempleadoBlock", propOrder = {
    "icmCabeceraempleadoRecordSet"
})
public class IcmCabeceraempleadoBlock {

    @XmlElement(name = "Icm_CabeceraempleadoRecordSet", nillable = true)
    protected List<IcmCabeceraempleadoRecord> icmCabeceraempleadoRecordSet;

    /**
     * Gets the value of the icmCabeceraempleadoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmCabeceraempleadoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmCabeceraempleadoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmCabeceraempleadoRecord }
     * 
     * 
     */
    public List<IcmCabeceraempleadoRecord> getIcmCabeceraempleadoRecordSet() {
        if (icmCabeceraempleadoRecordSet == null) {
            icmCabeceraempleadoRecordSet = new ArrayList<IcmCabeceraempleadoRecord>();
        }
        return this.icmCabeceraempleadoRecordSet;
    }

}
