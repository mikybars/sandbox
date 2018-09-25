
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

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
 *         &lt;element name="Icm_PlantillacondicionesRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_PlantillacondicionesRecord"/&gt;
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

    @XmlElement(name = "Icm_PlantillacondicionesRecordSet", required = true, nillable = true)
    protected ArrayOfIcmPlantillacondicionesRecord icmPlantillacondicionesRecordSet;

    /**
     * Obtiene el valor de la propiedad icmPlantillacondicionesRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmPlantillacondicionesRecord }
     *     
     */
    public ArrayOfIcmPlantillacondicionesRecord getIcmPlantillacondicionesRecordSet() {
        return icmPlantillacondicionesRecordSet;
    }

    /**
     * Define el valor de la propiedad icmPlantillacondicionesRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmPlantillacondicionesRecord }
     *     
     */
    public void setIcmPlantillacondicionesRecordSet(ArrayOfIcmPlantillacondicionesRecord value) {
        this.icmPlantillacondicionesRecordSet = value;
    }

}
