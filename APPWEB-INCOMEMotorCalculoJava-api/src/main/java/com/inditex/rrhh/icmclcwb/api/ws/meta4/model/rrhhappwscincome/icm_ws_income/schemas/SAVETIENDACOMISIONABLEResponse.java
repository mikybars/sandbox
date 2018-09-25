
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

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
 *         &lt;element name="SAVETIENDACOMISIONABLEReturn" type="{http://schemas.meta4.com/}SavetiendacomisionableOutput"/&gt;
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
    "savetiendacomisionableReturn"
})
@XmlRootElement(name = "SAVETIENDACOMISIONABLEResponse")
public class SAVETIENDACOMISIONABLEResponse {

    @XmlElement(name = "SAVETIENDACOMISIONABLEReturn", required = true)
    protected SavetiendacomisionableOutput savetiendacomisionableReturn;

    /**
     * Obtiene el valor de la propiedad savetiendacomisionableReturn.
     * 
     * @return
     *     possible object is
     *     {@link SavetiendacomisionableOutput }
     *     
     */
    public SavetiendacomisionableOutput getSAVETIENDACOMISIONABLEReturn() {
        return savetiendacomisionableReturn;
    }

    /**
     * Define el valor de la propiedad savetiendacomisionableReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link SavetiendacomisionableOutput }
     *     
     */
    public void setSAVETIENDACOMISIONABLEReturn(SavetiendacomisionableOutput value) {
        this.savetiendacomisionableReturn = value;
    }

}
