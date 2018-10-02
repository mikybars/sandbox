
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="retrieveM4SessionReturn" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "retrieveM4SessionReturn"
})
@XmlRootElement(name = "retrieveM4SessionResponse")
public class RetrieveM4SessionResponse {

    protected int retrieveM4SessionReturn;

    /**
     * Gets the value of the retrieveM4SessionReturn property.
     * 
     */
    public int getRetrieveM4SessionReturn() {
        return retrieveM4SessionReturn;
    }

    /**
     * Sets the value of the retrieveM4SessionReturn property.
     * 
     */
    public void setRetrieveM4SessionReturn(int value) {
        this.retrieveM4SessionReturn = value;
    }

}
