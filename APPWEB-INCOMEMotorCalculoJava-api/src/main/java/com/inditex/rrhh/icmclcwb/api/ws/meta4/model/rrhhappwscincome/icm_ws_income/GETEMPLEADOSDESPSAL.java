
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
 *         &lt;element name="ICM_PARAMETROSTIENDA" type="{http://schemas.meta4.com/}Icm_ParametrostiendaBlock"/>
 *         &lt;element name="ICM_PARAMETROSPAGINACION" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/>
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
    "icmparametrostienda",
    "icmparametrospaginacion"
})
@XmlRootElement(name = "GETEMPLEADOSDESPSAL")
public class GETEMPLEADOSDESPSAL {

    @XmlElement(name = "ICM_PARAMETROSTIENDA", required = true)
    protected IcmParametrostiendaBlock icmparametrostienda;
    @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
    protected IcmParametrospaginacionBlock icmparametrospaginacion;

    /**
     * Gets the value of the icmparametrostienda property.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrostiendaBlock }
     *     
     */
    public IcmParametrostiendaBlock getICMPARAMETROSTIENDA() {
        return icmparametrostienda;
    }

    /**
     * Sets the value of the icmparametrostienda property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrostiendaBlock }
     *     
     */
    public void setICMPARAMETROSTIENDA(IcmParametrostiendaBlock value) {
        this.icmparametrostienda = value;
    }

    /**
     * Gets the value of the icmparametrospaginacion property.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public IcmParametrospaginacionBlock getICMPARAMETROSPAGINACION() {
        return icmparametrospaginacion;
    }

    /**
     * Sets the value of the icmparametrospaginacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public void setICMPARAMETROSPAGINACION(IcmParametrospaginacionBlock value) {
        this.icmparametrospaginacion = value;
    }

}
