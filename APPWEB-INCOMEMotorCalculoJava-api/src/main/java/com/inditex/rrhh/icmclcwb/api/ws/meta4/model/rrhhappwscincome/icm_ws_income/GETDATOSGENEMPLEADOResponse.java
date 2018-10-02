
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
 *         &lt;element name="GETDATOSGENEMPLEADOReturn" type="{http://schemas.meta4.com/}GetdatosgenempleadoOutput"/>
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
    "getdatosgenempleadoReturn"
})
@XmlRootElement(name = "GETDATOSGENEMPLEADOResponse")
public class GETDATOSGENEMPLEADOResponse {

    @XmlElement(name = "GETDATOSGENEMPLEADOReturn", required = true)
    protected GetdatosgenempleadoOutput getdatosgenempleadoReturn;

    /**
     * Gets the value of the getdatosgenempleadoReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetdatosgenempleadoOutput }
     *     
     */
    public GetdatosgenempleadoOutput getGETDATOSGENEMPLEADOReturn() {
        return getdatosgenempleadoReturn;
    }

    /**
     * Sets the value of the getdatosgenempleadoReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetdatosgenempleadoOutput }
     *     
     */
    public void setGETDATOSGENEMPLEADOReturn(GetdatosgenempleadoOutput value) {
        this.getdatosgenempleadoReturn = value;
    }

}
