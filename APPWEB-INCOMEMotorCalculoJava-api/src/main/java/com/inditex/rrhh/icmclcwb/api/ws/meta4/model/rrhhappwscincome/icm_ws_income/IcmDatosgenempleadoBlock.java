
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Icm_DatosgenempleadoBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icm_DatosgenempleadoBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Icm_DatosgenempleadoRecordSet" type="{http://schemas.meta4.com/}Icm_DatosgenempleadoRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_DatosgenempleadoBlock", propOrder = {
    "icmDatosgenempleadoRecordSet"
})
public class IcmDatosgenempleadoBlock {

    @XmlElement(name = "Icm_DatosgenempleadoRecordSet", nillable = true)
    protected List<IcmDatosgenempleadoRecord> icmDatosgenempleadoRecordSet;

    /**
     * Gets the value of the icmDatosgenempleadoRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmDatosgenempleadoRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmDatosgenempleadoRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmDatosgenempleadoRecord }
     * 
     * 
     */
    public List<IcmDatosgenempleadoRecord> getIcmDatosgenempleadoRecordSet() {
        if (icmDatosgenempleadoRecordSet == null) {
            icmDatosgenempleadoRecordSet = new ArrayList<IcmDatosgenempleadoRecord>();
        }
        return this.icmDatosgenempleadoRecordSet;
    }

}
