
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
 *         &lt;element name="ICM_TIENDACOMISIONABLE" type="{http://schemas.meta4.com/}Icm_TiendacomisionableBlock"/&gt;
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
    "icmtiendacomisionable"
})
@XmlRootElement(name = "SAVETIENDACOMISIONABLE")
public class SAVETIENDACOMISIONABLE {

    @XmlElement(name = "ICM_TIENDACOMISIONABLE", required = true)
    protected IcmTiendacomisionableBlock icmtiendacomisionable;

    /**
     * Obtiene el valor de la propiedad icmtiendacomisionable.
     * 
     * @return
     *     possible object is
     *     {@link IcmTiendacomisionableBlock }
     *     
     */
    public IcmTiendacomisionableBlock getICMTIENDACOMISIONABLE() {
        return icmtiendacomisionable;
    }

    /**
     * Define el valor de la propiedad icmtiendacomisionable.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmTiendacomisionableBlock }
     *     
     */
    public void setICMTIENDACOMISIONABLE(IcmTiendacomisionableBlock value) {
        this.icmtiendacomisionable = value;
    }

}
