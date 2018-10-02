
package com.inditex.rrhh.icmclcwb.api.ws.meta4.model.rrhhappwscincome.icm_ws_income;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SAVEPRESENCIASTIENDAReturn" type="{http://schemas.meta4.com/}SavepresenciastiendaOutput"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "savepresenciastiendaReturn"
})
@XmlRootElement(name = "SAVEPRESENCIASTIENDAResponse")
public class SAVEPRESENCIASTIENDAResponse implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "SAVEPRESENCIASTIENDAReturn", required = true)
    protected SavepresenciastiendaOutput savepresenciastiendaReturn;

    /**
     * Obtiene el valor de la propiedad savepresenciastiendaReturn.
     * 
     * @return
     *     possible object is
     *     {@link SavepresenciastiendaOutput }
     *     
     */
    public SavepresenciastiendaOutput getSAVEPRESENCIASTIENDAReturn() {
        return savepresenciastiendaReturn;
    }

    /**
     * Define el valor de la propiedad savepresenciastiendaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link SavepresenciastiendaOutput }
     *     
     */
    public void setSAVEPRESENCIASTIENDAReturn(SavepresenciastiendaOutput value) {
        this.savepresenciastiendaReturn = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SAVEPRESENCIASTIENDAResponse that = ((SAVEPRESENCIASTIENDAResponse) object);
        {
            SavepresenciastiendaOutput lhsSAVEPRESENCIASTIENDAReturn;
            lhsSAVEPRESENCIASTIENDAReturn = this.getSAVEPRESENCIASTIENDAReturn();
            SavepresenciastiendaOutput rhsSAVEPRESENCIASTIENDAReturn;
            rhsSAVEPRESENCIASTIENDAReturn = that.getSAVEPRESENCIASTIENDAReturn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "savepresenciastiendaReturn", lhsSAVEPRESENCIASTIENDAReturn), LocatorUtils.property(thatLocator, "savepresenciastiendaReturn", rhsSAVEPRESENCIASTIENDAReturn), lhsSAVEPRESENCIASTIENDAReturn, rhsSAVEPRESENCIASTIENDAReturn, (this.savepresenciastiendaReturn!= null), (that.savepresenciastiendaReturn!= null))) {
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
            SavepresenciastiendaOutput theSAVEPRESENCIASTIENDAReturn;
            theSAVEPRESENCIASTIENDAReturn = this.getSAVEPRESENCIASTIENDAReturn();
            strategy.appendField(locator, this, "savepresenciastiendaReturn", buffer, theSAVEPRESENCIASTIENDAReturn, (this.savepresenciastiendaReturn!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            SavepresenciastiendaOutput theSAVEPRESENCIASTIENDAReturn;
            theSAVEPRESENCIASTIENDAReturn = this.getSAVEPRESENCIASTIENDAReturn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "savepresenciastiendaReturn", theSAVEPRESENCIASTIENDAReturn), currentHashCode, theSAVEPRESENCIASTIENDAReturn, (this.savepresenciastiendaReturn!= null));
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
        if (draftCopy instanceof SAVEPRESENCIASTIENDAResponse) {
            final SAVEPRESENCIASTIENDAResponse copy = ((SAVEPRESENCIASTIENDAResponse) draftCopy);
            {
                Boolean savepresenciastiendaReturnShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.savepresenciastiendaReturn!= null));
                if (savepresenciastiendaReturnShouldBeCopiedAndSet == Boolean.TRUE) {
                    SavepresenciastiendaOutput sourceSAVEPRESENCIASTIENDAReturn;
                    sourceSAVEPRESENCIASTIENDAReturn = this.getSAVEPRESENCIASTIENDAReturn();
                    SavepresenciastiendaOutput copySAVEPRESENCIASTIENDAReturn = ((SavepresenciastiendaOutput) strategy.copy(LocatorUtils.property(locator, "savepresenciastiendaReturn", sourceSAVEPRESENCIASTIENDAReturn), sourceSAVEPRESENCIASTIENDAReturn, (this.savepresenciastiendaReturn!= null)));
                    copy.setSAVEPRESENCIASTIENDAReturn(copySAVEPRESENCIASTIENDAReturn);
                } else {
                    if (savepresenciastiendaReturnShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.savepresenciastiendaReturn = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SAVEPRESENCIASTIENDAResponse();
    }

}
