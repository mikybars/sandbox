
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
 *         &lt;element name="ICM_PRESUPUESTOS" type="{http://schemas.meta4.com/}Icm_PresupuestosBlock"/&gt;
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
    "icmpresupuestos"
})
@XmlRootElement(name = "SAVEPRESUPUESTOS")
public class SAVEPRESUPUESTOS {

    @XmlElement(name = "ICM_PRESUPUESTOS", required = true)
    protected IcmPresupuestosBlock icmpresupuestos;

    /**
     * Obtiene el valor de la propiedad icmpresupuestos.
     * 
     * @return
     *     possible object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public IcmPresupuestosBlock getICMPRESUPUESTOS() {
        return icmpresupuestos;
    }

    /**
     * Define el valor de la propiedad icmpresupuestos.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public void setICMPRESUPUESTOS(IcmPresupuestosBlock value) {
        this.icmpresupuestos = value;
    }

}
