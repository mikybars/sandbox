
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
 *         &lt;element name="ICM_PARAMETROSPRESUPUESTO" type="{http://schemas.meta4.com/}Icm_ParametrospresupuestoBlock"/>
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
    "icmparametrospresupuesto"
})
@XmlRootElement(name = "GETBANDASPRESUPUESTOS")
public class GETBANDASPRESUPUESTOS {

    @XmlElement(name = "ICM_PARAMETROSPRESUPUESTO", required = true)
    protected IcmParametrospresupuestoBlock icmparametrospresupuesto;

    /**
     * Gets the value of the icmparametrospresupuesto property.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospresupuestoBlock }
     *     
     */
    public IcmParametrospresupuestoBlock getICMPARAMETROSPRESUPUESTO() {
        return icmparametrospresupuesto;
    }

    /**
     * Sets the value of the icmparametrospresupuesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospresupuestoBlock }
     *     
     */
    public void setICMPARAMETROSPRESUPUESTO(IcmParametrospresupuestoBlock value) {
        this.icmparametrospresupuesto = value;
    }

}
