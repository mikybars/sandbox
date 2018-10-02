
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
 *         &lt;element name="ICM_ESTADOSTIENDASECCION" type="{http://schemas.meta4.com/}Icm_EstadostiendaseccionBlock"/>
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
    "icmestadostiendaseccion"
})
@XmlRootElement(name = "SAVEESTADOSTIENDASECCION")
public class SAVEESTADOSTIENDASECCION {

    @XmlElement(name = "ICM_ESTADOSTIENDASECCION", required = true)
    protected IcmEstadostiendaseccionBlock icmestadostiendaseccion;

    /**
     * Gets the value of the icmestadostiendaseccion property.
     * 
     * @return
     *     possible object is
     *     {@link IcmEstadostiendaseccionBlock }
     *     
     */
    public IcmEstadostiendaseccionBlock getICMESTADOSTIENDASECCION() {
        return icmestadostiendaseccion;
    }

    /**
     * Sets the value of the icmestadostiendaseccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEstadostiendaseccionBlock }
     *     
     */
    public void setICMESTADOSTIENDASECCION(IcmEstadostiendaseccionBlock value) {
        this.icmestadostiendaseccion = value;
    }

}
