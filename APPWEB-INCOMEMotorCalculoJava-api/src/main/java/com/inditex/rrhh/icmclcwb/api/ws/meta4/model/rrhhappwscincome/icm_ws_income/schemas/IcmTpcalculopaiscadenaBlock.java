
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_TpcalculopaiscadenaBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_TpcalculopaiscadenaBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_TpcalculopaiscadenaRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_TpcalculopaiscadenaRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_TpcalculopaiscadenaBlock", propOrder = {
    "icmTpcalculopaiscadenaRecordSet"
})
public class IcmTpcalculopaiscadenaBlock {

    @XmlElement(name = "Icm_TpcalculopaiscadenaRecordSet", required = true, nillable = true)
    protected ArrayOfIcmTpcalculopaiscadenaRecord icmTpcalculopaiscadenaRecordSet;

    /**
     * Obtiene el valor de la propiedad icmTpcalculopaiscadenaRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmTpcalculopaiscadenaRecord }
     *     
     */
    public ArrayOfIcmTpcalculopaiscadenaRecord getIcmTpcalculopaiscadenaRecordSet() {
        return icmTpcalculopaiscadenaRecordSet;
    }

    /**
     * Define el valor de la propiedad icmTpcalculopaiscadenaRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmTpcalculopaiscadenaRecord }
     *     
     */
    public void setIcmTpcalculopaiscadenaRecordSet(ArrayOfIcmTpcalculopaiscadenaRecord value) {
        this.icmTpcalculopaiscadenaRecordSet = value;
    }

}
