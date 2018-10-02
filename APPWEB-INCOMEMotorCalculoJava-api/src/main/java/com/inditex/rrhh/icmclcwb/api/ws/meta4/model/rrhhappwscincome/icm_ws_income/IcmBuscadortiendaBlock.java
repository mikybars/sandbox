
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_BuscadortiendaBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_BuscadortiendaBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_BuscadortiendaRecordSet" type="{http://schemas.meta4.com/}Icm_BuscadortiendaRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_BuscadortiendaBlock", propOrder = {
    "icmBuscadortiendaRecordSet"
})
public class IcmBuscadortiendaBlock {

    @XmlElement(name = "Icm_BuscadortiendaRecordSet", nillable = true)
    protected List<IcmBuscadortiendaRecord> icmBuscadortiendaRecordSet;

    /**
     * Gets the value of the icmBuscadortiendaRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmBuscadortiendaRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmBuscadortiendaRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmBuscadortiendaRecord }
     * 
     * 
     */
    public List<IcmBuscadortiendaRecord> getIcmBuscadortiendaRecordSet() {
        if (icmBuscadortiendaRecordSet == null) {
            icmBuscadortiendaRecordSet = new ArrayList<IcmBuscadortiendaRecord>();
        }
        return this.icmBuscadortiendaRecordSet;
    }

}
