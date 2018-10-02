
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
 *         &lt;element name="GETGLOBALTIENDAReturn" type="{http://schemas.meta4.com/}GetglobaltiendaOutput"/>
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
    "getglobaltiendaReturn"
})
@XmlRootElement(name = "GETGLOBALTIENDAResponse")
public class GETGLOBALTIENDAResponse {

    @XmlElement(name = "GETGLOBALTIENDAReturn", required = true)
    protected GetglobaltiendaOutput getglobaltiendaReturn;

    /**
     * Gets the value of the getglobaltiendaReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetglobaltiendaOutput }
     *     
     */
    public GetglobaltiendaOutput getGETGLOBALTIENDAReturn() {
        return getglobaltiendaReturn;
    }

    /**
     * Sets the value of the getglobaltiendaReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetglobaltiendaOutput }
     *     
     */
    public void setGETGLOBALTIENDAReturn(GetglobaltiendaOutput value) {
        this.getglobaltiendaReturn = value;
    }

}
