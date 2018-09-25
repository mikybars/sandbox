
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ICM_PLANTILLACONDICIONES" type="{http://schemas.meta4.com/}Icm_PlantillacondicionesBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "icmplantillacondiciones"
})
@XmlRootElement(name = "SAVEPLANTILLACONDICIONES")
public class SAVEPLANTILLACONDICIONES {

    @XmlElement(name = "ICM_PLANTILLACONDICIONES", required = true)
    protected IcmPlantillacondicionesBlock icmplantillacondiciones;

    /**
     * Obtiene el valor de la propiedad icmplantillacondiciones.
     * 
     * @return
     *     possible object is
     *     {@link IcmPlantillacondicionesBlock }
     *     
     */
    public IcmPlantillacondicionesBlock getICMPLANTILLACONDICIONES() {
        return icmplantillacondiciones;
    }

    /**
     * Define el valor de la propiedad icmplantillacondiciones.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPlantillacondicionesBlock }
     *     
     */
    public void setICMPLANTILLACONDICIONES(IcmPlantillacondicionesBlock value) {
        this.icmplantillacondiciones = value;
    }

}
