
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
 *         &lt;element name="GETEMPLEADOSDESPENTReturn" type="{http://schemas.meta4.com/}GetempleadosdespentOutput"/>
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
    "getempleadosdespentReturn"
})
@XmlRootElement(name = "GETEMPLEADOSDESPENTResponse")
public class GETEMPLEADOSDESPENTResponse {

    @XmlElement(name = "GETEMPLEADOSDESPENTReturn", required = true)
    protected GetempleadosdespentOutput getempleadosdespentReturn;

    /**
     * Gets the value of the getempleadosdespentReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetempleadosdespentOutput }
     *     
     */
    public GetempleadosdespentOutput getGETEMPLEADOSDESPENTReturn() {
        return getempleadosdespentReturn;
    }

    /**
     * Sets the value of the getempleadosdespentReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetempleadosdespentOutput }
     *     
     */
    public void setGETEMPLEADOSDESPENTReturn(GetempleadosdespentOutput value) {
        this.getempleadosdespentReturn = value;
    }

}
