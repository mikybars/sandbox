
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_PlantillacondicionesBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_PlantillacondicionesBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_PlantillacondicionesRecordSet" type="{http://schemas.meta4.com/}Icm_PlantillacondicionesRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_PlantillacondicionesBlock", propOrder = {
    "icmPlantillacondicionesRecordSet"
})
public class IcmPlantillacondicionesBlock {

    @XmlElement(name = "Icm_PlantillacondicionesRecordSet", nillable = true)
    protected List<IcmPlantillacondicionesRecord> icmPlantillacondicionesRecordSet;

    /**
     * Gets the value of the icmPlantillacondicionesRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmPlantillacondicionesRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmPlantillacondicionesRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmPlantillacondicionesRecord }
     * 
     * 
     */
    public List<IcmPlantillacondicionesRecord> getIcmPlantillacondicionesRecordSet() {
        if (icmPlantillacondicionesRecordSet == null) {
            icmPlantillacondicionesRecordSet = new ArrayList<IcmPlantillacondicionesRecord>();
        }
        return this.icmPlantillacondicionesRecordSet;
    }

}
