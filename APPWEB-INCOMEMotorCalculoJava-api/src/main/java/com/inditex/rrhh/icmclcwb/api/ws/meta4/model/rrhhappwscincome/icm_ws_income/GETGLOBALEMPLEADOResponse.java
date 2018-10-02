
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
 *         &lt;element name="GETGLOBALEMPLEADOReturn" type="{http://schemas.meta4.com/}GetglobalempleadoOutput"/>
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
    "getglobalempleadoReturn"
})
@XmlRootElement(name = "GETGLOBALEMPLEADOResponse")
public class GETGLOBALEMPLEADOResponse {

    @XmlElement(name = "GETGLOBALEMPLEADOReturn", required = true)
    protected GetglobalempleadoOutput getglobalempleadoReturn;

    /**
     * Gets the value of the getglobalempleadoReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetglobalempleadoOutput }
     *     
     */
    public GetglobalempleadoOutput getGETGLOBALEMPLEADOReturn() {
        return getglobalempleadoReturn;
    }

    /**
     * Sets the value of the getglobalempleadoReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetglobalempleadoOutput }
     *     
     */
    public void setGETGLOBALEMPLEADOReturn(GetglobalempleadoOutput value) {
        this.getglobalempleadoReturn = value;
    }

}
