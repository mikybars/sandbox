
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icm_ParametrosexcelBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrosexcelBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="blob" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="blobvacio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nombrefichero" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParametrosexcelRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrosexcelRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParametrosexcelBlock", propOrder = {
    "blob",
    "blobvacio",
    "extension",
    "nombrefichero",
    "icmParametrosexcelRecordSet"
})
public class IcmParametrosexcelBlock {

    @XmlElement(required = true, nillable = true)
    protected String blob;
    @XmlElement(required = true, nillable = true)
    protected String blobvacio;
    @XmlElement(required = true, nillable = true)
    protected String extension;
    @XmlElement(required = true, nillable = true)
    protected String nombrefichero;
    @XmlElement(name = "Icm_ParametrosexcelRecordSet", nillable = true)
    protected List<IcmParametrosexcelRecord> icmParametrosexcelRecordSet;

    /**
     * Obtiene el valor de la propiedad blob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlob() {
        return blob;
    }

    /**
     * Define el valor de la propiedad blob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlob(String value) {
        this.blob = value;
    }

    /**
     * Obtiene el valor de la propiedad blobvacio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlobvacio() {
        return blobvacio;
    }

    /**
     * Define el valor de la propiedad blobvacio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlobvacio(String value) {
        this.blobvacio = value;
    }

    /**
     * Obtiene el valor de la propiedad extension.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Define el valor de la propiedad extension.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtension(String value) {
        this.extension = value;
    }

    /**
     * Obtiene el valor de la propiedad nombrefichero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrefichero() {
        return nombrefichero;
    }

    /**
     * Define el valor de la propiedad nombrefichero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrefichero(String value) {
        this.nombrefichero = value;
    }

    /**
     * Gets the value of the icmParametrosexcelRecordSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the icmParametrosexcelRecordSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIcmParametrosexcelRecordSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IcmParametrosexcelRecord }
     * 
     * 
     */
    public List<IcmParametrosexcelRecord> getIcmParametrosexcelRecordSet() {
        if (icmParametrosexcelRecordSet == null) {
            icmParametrosexcelRecordSet = new ArrayList<IcmParametrosexcelRecord>();
        }
        return this.icmParametrosexcelRecordSet;
    }

}
