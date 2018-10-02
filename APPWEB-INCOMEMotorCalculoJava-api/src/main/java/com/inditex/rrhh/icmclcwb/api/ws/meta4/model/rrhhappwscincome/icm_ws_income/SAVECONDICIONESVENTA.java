
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ICM_CONDICIONESVENTA" type="{http://schemas.meta4.com/}Icm_CondicionesventaBlock"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
     * Gets the value of the icmcondicionesventa property.
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
     * Sets the value of the icmcondicionesventa property.
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
