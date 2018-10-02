
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login;

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
 *         &lt;element name="loginReturn" type="{http://schemas.meta4.com/}M4loginOutput"/>
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
    "loginReturn"
})
@XmlRootElement(name = "loginResponse")
public class LoginResponse {

    @XmlElement(required = true)
    protected M4LoginOutput loginReturn;

    /**
     * Gets the value of the loginReturn property.
     * 
     * @return
     *     possible object is
     *     {@link M4LoginOutput }
     *     
     */
    public M4LoginOutput getLoginReturn() {
        return loginReturn;
    }

    /**
     * Sets the value of the loginReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link M4LoginOutput }
     *     
     */
    public void setLoginReturn(M4LoginOutput value) {
        this.loginReturn = value;
    }

}
