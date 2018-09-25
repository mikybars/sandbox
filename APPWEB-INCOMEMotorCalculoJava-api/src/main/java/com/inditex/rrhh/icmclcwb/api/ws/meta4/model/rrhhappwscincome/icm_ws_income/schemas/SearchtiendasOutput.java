
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SearchtiendasOutput complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SearchtiendasOutput"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="logMessage" type="{http://schemas.meta4.com/}ArrayOfLogMessage"/&gt;
 *         &lt;element name="Icm_Buscadortienda" type="{http://schemas.meta4.com/}Icm_BuscadortiendaBlock"/&gt;
 *         &lt;element name="Icm_Parametrospaginacion" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchtiendasOutput", propOrder = {
    "_return",
    "logMessage",
    "icmBuscadortienda",
    "icmParametrospaginacion"
})
public class SearchtiendasOutput {

    @XmlElement(name = "return")
    protected double _return;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfLogMessage logMessage;
    @XmlElement(name = "Icm_Buscadortienda", required = true, nillable = true)
    protected IcmBuscadortiendaBlock icmBuscadortienda;
    @XmlElement(name = "Icm_Parametrospaginacion", required = true, nillable = true)
    protected IcmParametrospaginacionBlock icmParametrospaginacion;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     */
    public double getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     */
    public void setReturn(double value) {
        this._return = value;
    }

    /**
     * Obtiene el valor de la propiedad logMessage.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLogMessage }
     *     
     */
    public ArrayOfLogMessage getLogMessage() {
        return logMessage;
    }

    /**
     * Define el valor de la propiedad logMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLogMessage }
     *     
     */
    public void setLogMessage(ArrayOfLogMessage value) {
        this.logMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad icmBuscadortienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmBuscadortiendaBlock }
     *     
     */
    public IcmBuscadortiendaBlock getIcmBuscadortienda() {
        return icmBuscadortienda;
    }

    /**
     * Define el valor de la propiedad icmBuscadortienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmBuscadortiendaBlock }
     *     
     */
    public void setIcmBuscadortienda(IcmBuscadortiendaBlock value) {
        this.icmBuscadortienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmParametrospaginacion.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public IcmParametrospaginacionBlock getIcmParametrospaginacion() {
        return icmParametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmParametrospaginacion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public void setIcmParametrospaginacion(IcmParametrospaginacionBlock value) {
        this.icmParametrospaginacion = value;
    }

}
