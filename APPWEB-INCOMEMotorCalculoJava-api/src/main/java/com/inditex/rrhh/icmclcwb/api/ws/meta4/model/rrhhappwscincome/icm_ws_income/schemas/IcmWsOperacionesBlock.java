
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_Ws_OperacionesBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_Ws_OperacionesBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Icm_Ws_OperacionesRecordSet" type="{http://schemas.meta4.com/}ArrayOfIcm_Ws_OperacionesRecord"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_Ws_OperacionesBlock", propOrder = {
    "icmWsOperacionesRecordSet"
})
public class IcmWsOperacionesBlock {

    @XmlElement(name = "Icm_Ws_OperacionesRecordSet", required = true, nillable = true)
    protected ArrayOfIcmWsOperacionesRecord icmWsOperacionesRecordSet;

    /**
     * Obtiene el valor de la propiedad icmWsOperacionesRecordSet.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIcmWsOperacionesRecord }
     *     
     */
    public ArrayOfIcmWsOperacionesRecord getIcmWsOperacionesRecordSet() {
        return icmWsOperacionesRecordSet;
    }

    /**
     * Define el valor de la propiedad icmWsOperacionesRecordSet.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIcmWsOperacionesRecord }
     *     
     */
    public void setIcmWsOperacionesRecordSet(ArrayOfIcmWsOperacionesRecord value) {
        this.icmWsOperacionesRecordSet = value;
    }

}
