
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
 *         &lt;element name="ICM_PARAMETROSEMPLEADO" type="{http://schemas.meta4.com/}Icm_ParametrosempleadoBlock"/>
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
    "icmparametrosempleado"
})
@XmlRootElement(name = "GETEMPLEADOESTRUCTURA")
public class GETEMPLEADOESTRUCTURA {

    @XmlElement(name = "ICM_PARAMETROSEMPLEADO", required = true)
    protected IcmParametrosempleadoBlock icmparametrosempleado;

    /**
     * Gets the value of the icmparametrosempleado property.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosempleadoBlock }
     *     
     */
    public IcmParametrosempleadoBlock getICMPARAMETROSEMPLEADO() {
        return icmparametrosempleado;
    }

    /**
     * Sets the value of the icmparametrosempleado property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosempleadoBlock }
     *     
     */
    public void setICMPARAMETROSEMPLEADO(IcmParametrosempleadoBlock value) {
        this.icmparametrosempleado = value;
    }

}
