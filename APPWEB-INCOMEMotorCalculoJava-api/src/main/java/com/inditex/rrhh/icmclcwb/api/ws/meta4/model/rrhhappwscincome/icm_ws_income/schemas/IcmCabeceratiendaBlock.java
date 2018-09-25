
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_CabeceratiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_CabeceratiendaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_CabeceratiendaRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_CabeceratiendaRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_CabeceratiendaBlock", propOrder = {
    "icmCabeceratiendaRecordSet"
})
public class IcmCabeceratiendaBlock {

    @XmlElement(name = "Icm_CabeceratiendaRecordSet", required = true, nillable = true)
    protected ArrayOfIcmCabeceratiendaRecord icmCabeceratiendaRecordSet;

    /**
     * Obtiene el valor de la propiedad icmCabeceratiendaRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmCabeceratiendaRecord }
     *     
     */
    public ArrayOfIcmCabeceratiendaRecord getIcmCabeceratiendaRecordSet() {
        return icmCabeceratiendaRecordSet;
    }

    /**
     * Define el valor de la propiedad icmCabeceratiendaRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmCabeceratiendaRecord }
     *     
     */
    public void setIcmCabeceratiendaRecordSet(ArrayOfIcmCabeceratiendaRecord value) {
        this.icmCabeceratiendaRecordSet = value;
    }

}
