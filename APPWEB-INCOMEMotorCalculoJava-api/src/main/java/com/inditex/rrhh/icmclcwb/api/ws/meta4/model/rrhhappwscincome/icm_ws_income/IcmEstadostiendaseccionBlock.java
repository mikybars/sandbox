
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_EstadostiendaseccionBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_EstadostiendaseccionBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_EstadostiendaseccionRecordSet" type="{http://schemas.meta4.com/}Icm_EstadostiendaseccionRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_EstadostiendaseccionBlock", propOrder = {
    "icmEstadostiendaseccionRecordSet"
})
public class IcmEstadostiendaseccionBlock {

    @XmlElement(name = "Icm_EstadostiendaseccionRecordSet", nillable = true)
    protected List<IcmEstadostiendaseccionRecord> icmEstadostiendaseccionRecordSet;

    /**
     * Gets the value of the icmEstadostiendaseccionRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmEstadostiendaseccionRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmEstadostiendaseccionRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmEstadostiendaseccionRecord }
     * 
     * 
     */
    public List<IcmEstadostiendaseccionRecord> getIcmEstadostiendaseccionRecordSet() {
        if (icmEstadostiendaseccionRecordSet == null) {
            icmEstadostiendaseccionRecordSet = new ArrayList<IcmEstadostiendaseccionRecord>();
        }
        return this.icmEstadostiendaseccionRecordSet;
    }

}
