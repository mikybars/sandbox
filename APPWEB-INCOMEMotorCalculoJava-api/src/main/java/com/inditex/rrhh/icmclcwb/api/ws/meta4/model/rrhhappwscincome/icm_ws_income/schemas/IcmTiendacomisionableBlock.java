
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_TiendacomisionableBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_TiendacomisionableBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_TiendacomisionableRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_TiendacomisionableRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_TiendacomisionableBlock", propOrder = {
    "icmTiendacomisionableRecordSet"
})
public class IcmTiendacomisionableBlock {

    @XmlElement(name = "Icm_TiendacomisionableRecordSet", required = true, nillable = true)
    protected ArrayOfIcmTiendacomisionableRecord icmTiendacomisionableRecordSet;

    /**
     * Obtiene el valor de la propiedad icmTiendacomisionableRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmTiendacomisionableRecord }
     *     
     */
    public ArrayOfIcmTiendacomisionableRecord getIcmTiendacomisionableRecordSet() {
        return icmTiendacomisionableRecordSet;
    }

    /**
     * Define el valor de la propiedad icmTiendacomisionableRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmTiendacomisionableRecord }
     *     
     */
    public void setIcmTiendacomisionableRecordSet(ArrayOfIcmTiendacomisionableRecord value) {
        this.icmTiendacomisionableRecordSet = value;
    }

}
