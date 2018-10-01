
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="loginReturn" type="{http://schemas.meta4.com/}M4loginOutput"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     * Obtiene el valor de la propiedad loginReturn.
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
     * Define el valor de la propiedad loginReturn.
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
