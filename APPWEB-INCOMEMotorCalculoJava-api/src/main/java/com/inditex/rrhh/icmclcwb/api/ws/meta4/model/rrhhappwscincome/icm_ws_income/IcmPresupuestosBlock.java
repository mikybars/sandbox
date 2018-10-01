
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_PresupuestosBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_PresupuestosBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_PresupuestosRecordSet" type="{http://schemas.meta4.com/}Icm_PresupuestosRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_PresupuestosBlock", propOrder = {
    "icmPresupuestosRecordSet"
})
public class IcmPresupuestosBlock {

    @XmlElement(name = "Icm_PresupuestosRecordSet", nillable = true)
    protected List<IcmPresupuestosRecord> icmPresupuestosRecordSet;

    /**
     * Gets the value of the icmPresupuestosRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmPresupuestosRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmPresupuestosRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmPresupuestosRecord }
     * 
     * 
     */
    public List<IcmPresupuestosRecord> getIcmPresupuestosRecordSet() {
        if (icmPresupuestosRecordSet == null) {
            icmPresupuestosRecordSet = new ArrayList<IcmPresupuestosRecord>();
        }
        return this.icmPresupuestosRecordSet;
    }

}
