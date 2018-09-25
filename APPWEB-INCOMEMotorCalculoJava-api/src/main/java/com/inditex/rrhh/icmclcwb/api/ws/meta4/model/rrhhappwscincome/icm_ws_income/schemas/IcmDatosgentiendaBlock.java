
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_DatosgentiendaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_DatosgentiendaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_DatosgentiendaRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_DatosgentiendaRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_DatosgentiendaBlock", propOrder = {
    "icmDatosgentiendaRecordSet"
})
public class IcmDatosgentiendaBlock {

    @XmlElement(name = "Icm_DatosgentiendaRecordSet", required = true, nillable = true)
    protected ArrayOfIcmDatosgentiendaRecord icmDatosgentiendaRecordSet;

    /**
     * Obtiene el valor de la propiedad icmDatosgentiendaRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmDatosgentiendaRecord }
     *     
     */
    public ArrayOfIcmDatosgentiendaRecord getIcmDatosgentiendaRecordSet() {
        return icmDatosgentiendaRecordSet;
    }

    /**
     * Define el valor de la propiedad icmDatosgentiendaRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmDatosgentiendaRecord }
     *     
     */
    public void setIcmDatosgentiendaRecordSet(ArrayOfIcmDatosgentiendaRecord value) {
        this.icmDatosgentiendaRecordSet = value;
    }

}
