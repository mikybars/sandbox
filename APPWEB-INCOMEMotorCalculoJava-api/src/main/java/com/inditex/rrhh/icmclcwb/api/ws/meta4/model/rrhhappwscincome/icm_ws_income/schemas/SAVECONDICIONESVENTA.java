
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
 *         &lt;element name="ICM_CONDICIONESVENTA" type="{http://schemas.meta4.com/}Icm_CondicionesventaBlock"/&gt;
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
    "icmcondicionesventa"
})
@XmlRootElement(name = "SAVECONDICIONESVENTA")
public class SAVECONDICIONESVENTA {

    @XmlElement(name = "ICM_CONDICIONESVENTA", required = true)
    protected IcmCondicionesventaBlock icmcondicionesventa;

    /**
     * Obtiene el valor de la propiedad icmcondicionesventa.
     * 
     * @return
     *     possible object is
     *     {@link IcmCondicionesventaBlock }
     *     
     */
    public IcmCondicionesventaBlock getICMCONDICIONESVENTA() {
        return icmcondicionesventa;
    }

    /**
     * Define el valor de la propiedad icmcondicionesventa.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCondicionesventaBlock }
     *     
     */
    public void setICMCONDICIONESVENTA(IcmCondicionesventaBlock value) {
        this.icmcondicionesventa = value;
    }

}
