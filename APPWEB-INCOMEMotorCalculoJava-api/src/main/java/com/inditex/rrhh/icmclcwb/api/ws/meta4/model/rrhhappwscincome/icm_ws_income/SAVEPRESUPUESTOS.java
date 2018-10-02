
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
 *         &lt;element name="ICM_PRESUPUESTOS" type="{http://schemas.meta4.com/}Icm_PresupuestosBlock"/>
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
    "icmpresupuestos"
})
@XmlRootElement(name = "SAVEPRESUPUESTOS")
public class SAVEPRESUPUESTOS {

    @XmlElement(name = "ICM_PRESUPUESTOS", required = true)
    protected IcmPresupuestosBlock icmpresupuestos;

    /**
     * Gets the value of the icmpresupuestos property.
     * 
     * @return
     *     possible object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public IcmPresupuestosBlock getICMPRESUPUESTOS() {
        return icmpresupuestos;
    }

    /**
     * Sets the value of the icmpresupuestos property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public void setICMPRESUPUESTOS(IcmPresupuestosBlock value) {
        this.icmpresupuestos = value;
    }

}
