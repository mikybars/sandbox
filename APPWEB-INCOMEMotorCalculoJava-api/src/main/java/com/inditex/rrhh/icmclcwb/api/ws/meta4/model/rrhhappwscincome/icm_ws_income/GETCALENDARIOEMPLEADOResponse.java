
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
 *         &lt;element name="GETCALENDARIOEMPLEADOReturn" type="{http://schemas.meta4.com/}GetcalendarioempleadoOutput"/>
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
    "getcalendarioempleadoReturn"
})
@XmlRootElement(name = "GETCALENDARIOEMPLEADOResponse")
public class GETCALENDARIOEMPLEADOResponse {

    @XmlElement(name = "GETCALENDARIOEMPLEADOReturn", required = true)
    protected GetcalendarioempleadoOutput getcalendarioempleadoReturn;

    /**
     * Gets the value of the getcalendarioempleadoReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetcalendarioempleadoOutput }
     *     
     */
    public GetcalendarioempleadoOutput getGETCALENDARIOEMPLEADOReturn() {
        return getcalendarioempleadoReturn;
    }

    /**
     * Sets the value of the getcalendarioempleadoReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetcalendarioempleadoOutput }
     *     
     */
    public void setGETCALENDARIOEMPLEADOReturn(GetcalendarioempleadoOutput value) {
        this.getcalendarioempleadoReturn = value;
    }

}
