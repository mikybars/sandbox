
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
 *         &lt;element name="ICM_PRESENCIAMANUAL" type="{http://schemas.meta4.com/}Icm_PresenciamanualBlock"/&gt;
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
    "icmpresenciamanual"
})
@XmlRootElement(name = "SAVEPRESENCIASEMPLEADO")
public class SAVEPRESENCIASEMPLEADO {

    @XmlElement(name = "ICM_PRESENCIAMANUAL", required = true)
    protected IcmPresenciamanualBlock icmpresenciamanual;

    /**
     * Obtiene el valor de la propiedad icmpresenciamanual.
     * 
     * @return
     *     possible object is
     *     {@link IcmPresenciamanualBlock }
     *     
     */
    public IcmPresenciamanualBlock getICMPRESENCIAMANUAL() {
        return icmpresenciamanual;
    }

    /**
     * Define el valor de la propiedad icmpresenciamanual.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPresenciamanualBlock }
     *     
     */
    public void setICMPRESENCIAMANUAL(IcmPresenciamanualBlock value) {
        this.icmpresenciamanual = value;
    }

}
