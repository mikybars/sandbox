
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

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
 *         &lt;element name="GETPLANTILLACONDICIONESReturn" type="{http://schemas.meta4.com/}GetplantillacondicionesOutput"/&gt;
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
    "getplantillacondicionesReturn"
})
@XmlRootElement(name = "GETPLANTILLACONDICIONESResponse")
public class GETPLANTILLACONDICIONESResponse {

    @XmlElement(name = "GETPLANTILLACONDICIONESReturn", required = true)
    protected GetplantillacondicionesOutput getplantillacondicionesReturn;

    /**
     * Obtiene el valor de la propiedad getplantillacondicionesReturn.
     * 
     * @return
     *     possible object is
     *     {@link GetplantillacondicionesOutput }
     *     
     */
    public GetplantillacondicionesOutput getGETPLANTILLACONDICIONESReturn() {
        return getplantillacondicionesReturn;
    }

    /**
     * Define el valor de la propiedad getplantillacondicionesReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link GetplantillacondicionesOutput }
     *     
     */
    public void setGETPLANTILLACONDICIONESReturn(GetplantillacondicionesOutput value) {
        this.getplantillacondicionesReturn = value;
    }

}
