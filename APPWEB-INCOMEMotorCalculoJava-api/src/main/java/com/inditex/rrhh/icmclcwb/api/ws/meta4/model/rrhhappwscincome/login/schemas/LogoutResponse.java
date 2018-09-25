
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.login.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="logoutReturn" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "logoutReturn"
})
@XmlRootElement(name = "logoutResponse")
public class LogoutResponse {

    protected int logoutReturn;

    /**
     * Obtiene el valor de la propiedad logoutReturn.
     * 
     */
    public int getLogoutReturn() {
        return logoutReturn;
    }

    /**
     * Define el valor de la propiedad logoutReturn.
     * 
     */
    public void setLogoutReturn(int value) {
        this.logoutReturn = value;
    }

}
