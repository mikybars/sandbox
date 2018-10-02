
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
 *         &lt;element name="ICM_PRESENCIAMANUAL" type="{http://schemas.meta4.com/}Icm_PresenciamanualBlock"/>
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
    "icmpresenciamanual"
})
@XmlRootElement(name = "SAVEPRESENCIASTIENDA")
public class SAVEPRESENCIASTIENDA {

    @XmlElement(name = "ICM_PRESENCIAMANUAL", required = true)
    protected IcmPresenciamanualBlock icmpresenciamanual;

    /**
     * Gets the value of the icmpresenciamanual property.
     * 
     * @return
     *     possible object is
     *     {@link IcmPresenciamanualBlock }
     *     
     */
    public IcmPresenciamanualBlock getICMPRESENCIAMANUAL() {
        return icmpresenciamanual;
    }

    /**
     * Sets the value of the icmpresenciamanual property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPresenciamanualBlock }
     *     
     */
    public void setICMPRESENCIAMANUAL(IcmPresenciamanualBlock value) {
        this.icmpresenciamanual = value;
    }

}
