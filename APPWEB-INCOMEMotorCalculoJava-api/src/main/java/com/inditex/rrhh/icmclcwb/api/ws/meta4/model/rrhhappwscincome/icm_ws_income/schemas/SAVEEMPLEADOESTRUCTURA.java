
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
 *         &lt;element name="ICM_EMPLEADOSESTRUCTURA" type="{http://schemas.meta4.com/}Icm_EmpleadosestructuraBlock"/&gt;
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
    "icmempleadosestructura"
})
@XmlRootElement(name = "SAVEEMPLEADOESTRUCTURA")
public class SAVEEMPLEADOESTRUCTURA {

    @XmlElement(name = "ICM_EMPLEADOSESTRUCTURA", required = true)
    protected IcmEmpleadosestructuraBlock icmempleadosestructura;

    /**
     * Obtiene el valor de la propiedad icmempleadosestructura.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadosestructuraBlock }
     *     
     */
    public IcmEmpleadosestructuraBlock getICMEMPLEADOSESTRUCTURA() {
        return icmempleadosestructura;
    }

    /**
     * Define el valor de la propiedad icmempleadosestructura.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadosestructuraBlock }
     *     
     */
    public void setICMEMPLEADOSESTRUCTURA(IcmEmpleadosestructuraBlock value) {
        this.icmempleadosestructura = value;
    }

}
