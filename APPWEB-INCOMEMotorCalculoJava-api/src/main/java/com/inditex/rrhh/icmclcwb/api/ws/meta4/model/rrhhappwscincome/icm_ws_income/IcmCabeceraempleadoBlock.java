
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_CabeceraempleadoBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CabeceraempleadoBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_CabeceraempleadoRecordSet" type="{http://schemas.meta4.com/}Icm_CabeceraempleadoRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
