
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
 *         &lt;element name="ICM_VENTAMANUAL" type="{http://schemas.meta4.com/}Icm_VentamanualBlock"/&gt;
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
    "icmventamanual"
})
@XmlRootElement(name = "SAVEVENTAMANUAL")
public class SAVEVENTAMANUAL {

    @XmlElement(name = "ICM_VENTAMANUAL", required = true)
    protected IcmVentamanualBlock icmventamanual;

    /**
     * Obtiene el valor de la propiedad icmventamanual.
     * 
     * @return
     *     possible object is
     *     {@link IcmVentamanualBlock }
     *     
     */
    public IcmVentamanualBlock getICMVENTAMANUAL() {
        return icmventamanual;
    }

    /**
     * Define el valor de la propiedad icmventamanual.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmVentamanualBlock }
     *     
     */
    public void setICMVENTAMANUAL(IcmVentamanualBlock value) {
        this.icmventamanual = value;
    }

}
