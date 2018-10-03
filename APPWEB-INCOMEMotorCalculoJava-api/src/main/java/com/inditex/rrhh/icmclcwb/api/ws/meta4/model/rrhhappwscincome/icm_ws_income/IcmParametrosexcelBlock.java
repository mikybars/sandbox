
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.CopyTo2;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Clase Java para Icm_ParametrosexcelBlock complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Icm_ParametrosexcelBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blob" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="blobvacio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombrefichero" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Icm_ParametrosexcelRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrosexcelRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
public class IcmParametrosexcelBlock implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final IcmParametrosexcelBlock that = ((IcmParametrosexcelBlock) object);
        {
            String lhsBlob;
            lhsBlob = this.getBlob();
            String rhsBlob;
            rhsBlob = that.getBlob();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "blob", lhsBlob), LocatorUtils.property(thatLocator, "blob", rhsBlob), lhsBlob, rhsBlob, (this.blob!= null), (that.blob!= null))) {
                return false;
            }
        }
        {
            String lhsBlobvacio;
            lhsBlobvacio = this.getBlobvacio();
            String rhsBlobvacio;
            rhsBlobvacio = that.getBlobvacio();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "blobvacio", lhsBlobvacio), LocatorUtils.property(thatLocator, "blobvacio", rhsBlobvacio), lhsBlobvacio, rhsBlobvacio, (this.blobvacio!= null), (that.blobvacio!= null))) {
                return false;
            }
        }
        {
            String lhsExtension;
            lhsExtension = this.getExtension();
            String rhsExtension;
            rhsExtension = that.getExtension();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extension", lhsExtension), LocatorUtils.property(thatLocator, "extension", rhsExtension), lhsExtension, rhsExtension, (this.extension!= null), (that.extension!= null))) {
                return false;
            }
        }
        {
            String lhsNombrefichero;
            lhsNombrefichero = this.getNombrefichero();
            String rhsNombrefichero;
            rhsNombrefichero = that.getNombrefichero();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nombrefichero", lhsNombrefichero), LocatorUtils.property(thatLocator, "nombrefichero", rhsNombrefichero), lhsNombrefichero, rhsNombrefichero, (this.nombrefichero!= null), (that.nombrefichero!= null))) {
                return false;
            }
        }
        {
            List<IcmParametrosexcelRecord> lhsIcmParametrosexcelRecordSet;
            lhsIcmParametrosexcelRecordSet = (((this.icmParametrosexcelRecordSet!= null)&&(!this.icmParametrosexcelRecordSet.isEmpty()))?this.getIcmParametrosexcelRecordSet():null);
            List<IcmParametrosexcelRecord> rhsIcmParametrosexcelRecordSet;
            rhsIcmParametrosexcelRecordSet = (((that.icmParametrosexcelRecordSet!= null)&&(!that.icmParametrosexcelRecordSet.isEmpty()))?that.getIcmParametrosexcelRecordSet():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrosexcelRecordSet", lhsIcmParametrosexcelRecordSet), LocatorUtils.property(thatLocator, "icmParametrosexcelRecordSet", rhsIcmParametrosexcelRecordSet), lhsIcmParametrosexcelRecordSet, rhsIcmParametrosexcelRecordSet, ((this.icmParametrosexcelRecordSet!= null)&&(!this.icmParametrosexcelRecordSet.isEmpty())), ((that.icmParametrosexcelRecordSet!= null)&&(!that.icmParametrosexcelRecordSet.isEmpty())))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        {
            String theBlob;
            theBlob = this.getBlob();
            strategy.appendField(locator, this, "blob", buffer, theBlob, (this.blob!= null));
        }
        {
            String theBlobvacio;
            theBlobvacio = this.getBlobvacio();
            strategy.appendField(locator, this, "blobvacio", buffer, theBlobvacio, (this.blobvacio!= null));
        }
        {
            String theExtension;
            theExtension = this.getExtension();
            strategy.appendField(locator, this, "extension", buffer, theExtension, (this.extension!= null));
        }
        {
            String theNombrefichero;
            theNombrefichero = this.getNombrefichero();
            strategy.appendField(locator, this, "nombrefichero", buffer, theNombrefichero, (this.nombrefichero!= null));
        }
        {
            List<IcmParametrosexcelRecord> theIcmParametrosexcelRecordSet;
            theIcmParametrosexcelRecordSet = (((this.icmParametrosexcelRecordSet!= null)&&(!this.icmParametrosexcelRecordSet.isEmpty()))?this.getIcmParametrosexcelRecordSet():null);
            strategy.appendField(locator, this, "icmParametrosexcelRecordSet", buffer, theIcmParametrosexcelRecordSet, ((this.icmParametrosexcelRecordSet!= null)&&(!this.icmParametrosexcelRecordSet.isEmpty())));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theBlob;
            theBlob = this.getBlob();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "blob", theBlob), currentHashCode, theBlob, (this.blob!= null));
        }
        {
            String theBlobvacio;
            theBlobvacio = this.getBlobvacio();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "blobvacio", theBlobvacio), currentHashCode, theBlobvacio, (this.blobvacio!= null));
        }
        {
            String theExtension;
            theExtension = this.getExtension();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extension", theExtension), currentHashCode, theExtension, (this.extension!= null));
        }
        {
            String theNombrefichero;
            theNombrefichero = this.getNombrefichero();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nombrefichero", theNombrefichero), currentHashCode, theNombrefichero, (this.nombrefichero!= null));
        }
        {
            List<IcmParametrosexcelRecord> theIcmParametrosexcelRecordSet;
            theIcmParametrosexcelRecordSet = (((this.icmParametrosexcelRecordSet!= null)&&(!this.icmParametrosexcelRecordSet.isEmpty()))?this.getIcmParametrosexcelRecordSet():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmParametrosexcelRecordSet", theIcmParametrosexcelRecordSet), currentHashCode, theIcmParametrosexcelRecordSet, ((this.icmParametrosexcelRecordSet!= null)&&(!this.icmParametrosexcelRecordSet.isEmpty())));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof IcmParametrosexcelBlock) {
            final IcmParametrosexcelBlock copy = ((IcmParametrosexcelBlock) draftCopy);
            {
                Boolean blobShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.blob!= null));
                if (blobShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceBlob;
                    sourceBlob = this.getBlob();
                    String copyBlob = ((String) strategy.copy(LocatorUtils.property(locator, "blob", sourceBlob), sourceBlob, (this.blob!= null)));
                    copy.setBlob(copyBlob);
                } else {
                    if (blobShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.blob = null;
                    }
                }
            }
            {
                Boolean blobvacioShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.blobvacio!= null));
                if (blobvacioShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceBlobvacio;
                    sourceBlobvacio = this.getBlobvacio();
                    String copyBlobvacio = ((String) strategy.copy(LocatorUtils.property(locator, "blobvacio", sourceBlobvacio), sourceBlobvacio, (this.blobvacio!= null)));
                    copy.setBlobvacio(copyBlobvacio);
                } else {
                    if (blobvacioShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.blobvacio = null;
                    }
                }
            }
            {
                Boolean extensionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.extension!= null));
                if (extensionShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceExtension;
                    sourceExtension = this.getExtension();
                    String copyExtension = ((String) strategy.copy(LocatorUtils.property(locator, "extension", sourceExtension), sourceExtension, (this.extension!= null)));
                    copy.setExtension(copyExtension);
                } else {
                    if (extensionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.extension = null;
                    }
                }
            }
            {
                Boolean nombreficheroShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.nombrefichero!= null));
                if (nombreficheroShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceNombrefichero;
                    sourceNombrefichero = this.getNombrefichero();
                    String copyNombrefichero = ((String) strategy.copy(LocatorUtils.property(locator, "nombrefichero", sourceNombrefichero), sourceNombrefichero, (this.nombrefichero!= null)));
                    copy.setNombrefichero(copyNombrefichero);
                } else {
                    if (nombreficheroShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.nombrefichero = null;
                    }
                }
            }
            {
                Boolean icmParametrosexcelRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, ((this.icmParametrosexcelRecordSet!= null)&&(!this.icmParametrosexcelRecordSet.isEmpty())));
                if (icmParametrosexcelRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
                    List<IcmParametrosexcelRecord> sourceIcmParametrosexcelRecordSet;
                    sourceIcmParametrosexcelRecordSet = (((this.icmParametrosexcelRecordSet!= null)&&(!this.icmParametrosexcelRecordSet.isEmpty()))?this.getIcmParametrosexcelRecordSet():null);
                    @SuppressWarnings("unchecked")
                    List<IcmParametrosexcelRecord> copyIcmParametrosexcelRecordSet = ((List<IcmParametrosexcelRecord> ) strategy.copy(LocatorUtils.property(locator, "icmParametrosexcelRecordSet", sourceIcmParametrosexcelRecordSet), sourceIcmParametrosexcelRecordSet, ((this.icmParametrosexcelRecordSet!= null)&&(!this.icmParametrosexcelRecordSet.isEmpty()))));
                    copy.icmParametrosexcelRecordSet = null;
                    if (copyIcmParametrosexcelRecordSet!= null) {
                        List<IcmParametrosexcelRecord> uniqueIcmParametrosexcelRecordSetl = copy.getIcmParametrosexcelRecordSet();
                        uniqueIcmParametrosexcelRecordSetl.addAll(copyIcmParametrosexcelRecordSet);
                    }
                } else {
                    if (icmParametrosexcelRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmParametrosexcelRecordSet = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new IcmParametrosexcelBlock();
    }

}
