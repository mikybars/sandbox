
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
 *         &lt;element name="SAVEPRESUPUESTOXLSReturn" type="{http://schemas.meta4.com/}SavepresupuestoxlsOutput"/&gt;
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
    "savepresupuestoxlsReturn"
})
@XmlRootElement(name = "SAVEPRESUPUESTOXLSResponse")
public class SAVEPRESUPUESTOXLSResponse {

    @XmlElement(name = "SAVEPRESUPUESTOXLSReturn", required = true)
    protected SavepresupuestoxlsOutput savepresupuestoxlsReturn;

    /**
     * Obtiene el valor de la propiedad savepresupuestoxlsReturn.
     * 
     * @return
     *     possible object is
     *     {@link SavepresupuestoxlsOutput }
     *     
     */
    public SavepresupuestoxlsOutput getSAVEPRESUPUESTOXLSReturn() {
        return savepresupuestoxlsReturn;
    }

    /**
     * Define el valor de la propiedad savepresupuestoxlsReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link SavepresupuestoxlsOutput }
     *     
     */
    public void setSAVEPRESUPUESTOXLSReturn(SavepresupuestoxlsOutput value) {
        this.savepresupuestoxlsReturn = value;
    }

}
