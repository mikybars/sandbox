
package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity;

import java.io.Serializable;
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
 * <p>Clase Java para Icm_ParametrospaginacionBlock complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="Icm_ParametrospaginacionBlock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipoorden" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="campoorden" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idbusqueda" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numeropagina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numerototalpaginas" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numeroregistrospagina" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numerototalresultados" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Icm_ParametrospaginacionRecordSet" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icm_ParametrospaginacionBlock", propOrder = {
    "tipoorden",
    "campoorden",
    "idbusqueda",
    "numeropagina",
    "numerototalpaginas",
    "numeroregistrospagina",
    "numerototalresultados",
    "icmParametrospaginacionRecordSet"
})
public class IcmParametrospaginacionBlock implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

  @XmlElement(required = true, nillable = true)
  protected String tipoorden;

  @XmlElement(required = true, nillable = true)
  protected String campoorden;

  @XmlElement(required = true, nillable = true)
  protected String idbusqueda;

  @XmlElement(required = true, nillable = true)
  protected String numeropagina;

  @XmlElement(required = true, nillable = true)
  protected String numerototalpaginas;

  @XmlElement(required = true, nillable = true)
  protected String numeroregistrospagina;

  @XmlElement(required = true, nillable = true)
  protected String numerototalresultados;

  @XmlElement(name = "Icm_ParametrospaginacionRecordSet", nillable = true)
  protected List<IcmParametrospaginacionRecord> icmParametrospaginacionRecordSet;

  /**
   * Obtiene el valor de la propiedad tipoorden.
   *
   * @return possible object is {@link String }
   *
   */
  public String getTipoorden() {
    return tipoorden;
  }

  /**
   * Define el valor de la propiedad tipoorden.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setTipoorden(String value) {
    this.tipoorden = value;
  }

  /**
   * Obtiene el valor de la propiedad campoorden.
   *
   * @return possible object is {@link String }
   *
   */
  public String getCampoorden() {
    return campoorden;
  }

  /**
   * Define el valor de la propiedad campoorden.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setCampoorden(String value) {
    this.campoorden = value;
  }

  /**
   * Obtiene el valor de la propiedad idbusqueda.
   *
   * @return possible object is {@link String }
   *
   */
  public String getIdbusqueda() {
    return idbusqueda;
  }

  /**
   * Define el valor de la propiedad idbusqueda.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setIdbusqueda(String value) {
    this.idbusqueda = value;
  }

  /**
   * Obtiene el valor de la propiedad numeropagina.
   *
   * @return possible object is {@link String }
   *
   */
  public String getNumeropagina() {
    return numeropagina;
  }

  /**
   * Define el valor de la propiedad numeropagina.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setNumeropagina(String value) {
    this.numeropagina = value;
  }

  /**
   * Obtiene el valor de la propiedad numerototalpaginas.
   *
   * @return possible object is {@link String }
   *
   */
  public String getNumerototalpaginas() {
    return numerototalpaginas;
  }

  /**
   * Define el valor de la propiedad numerototalpaginas.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setNumerototalpaginas(String value) {
    this.numerototalpaginas = value;
  }

  /**
   * Obtiene el valor de la propiedad numeroregistrospagina.
   *
   * @return possible object is {@link String }
   *
   */
  public String getNumeroregistrospagina() {
    return numeroregistrospagina;
  }

  /**
   * Define el valor de la propiedad numeroregistrospagina.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setNumeroregistrospagina(String value) {
    this.numeroregistrospagina = value;
  }

  /**
   * Obtiene el valor de la propiedad numerototalresultados.
   *
   * @return possible object is {@link String }
   *
   */
  public String getNumerototalresultados() {
    return numerototalresultados;
  }

  /**
   * Define el valor de la propiedad numerototalresultados.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setNumerototalresultados(String value) {
    this.numerototalresultados = value;
  }

  /**
   * Gets the value of the icmParametrospaginacionRecordSet property.
   *
   * <p> This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list
   * will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the icmParametrospaginacionRecordSet
   * property.
   *
   * <p> For example, to add a new item, do as follows:
   * 
   * <pre>
   * getIcmParametrospaginacionRecordSet().add(newItem);
   * </pre>
   *
   *
   * <p> Objects of the following type(s) are allowed in the list {@link IcmParametrospaginacionRecord }
   *
   *
   */
  public List<IcmParametrospaginacionRecord> getIcmParametrospaginacionRecordSet() {
    if (icmParametrospaginacionRecordSet == null) {
      icmParametrospaginacionRecordSet = new ArrayList<IcmParametrospaginacionRecord>();
    }
    return this.icmParametrospaginacionRecordSet;
  }

  public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final IcmParametrospaginacionBlock that = ((IcmParametrospaginacionBlock) object);
    {
      String lhsTipoorden;
      lhsTipoorden = this.getTipoorden();
      String rhsTipoorden;
      rhsTipoorden = that.getTipoorden();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "tipoorden", lhsTipoorden),
          LocatorUtils.property(thatLocator, "tipoorden", rhsTipoorden), lhsTipoorden, rhsTipoorden, (this.tipoorden != null),
          (that.tipoorden != null))) {
        return false;
      }
    }
    {
      String lhsCampoorden;
      lhsCampoorden = this.getCampoorden();
      String rhsCampoorden;
      rhsCampoorden = that.getCampoorden();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "campoorden", lhsCampoorden),
          LocatorUtils.property(thatLocator, "campoorden", rhsCampoorden), lhsCampoorden, rhsCampoorden, (this.campoorden != null),
          (that.campoorden != null))) {
        return false;
      }
    }
    {
      String lhsIdbusqueda;
      lhsIdbusqueda = this.getIdbusqueda();
      String rhsIdbusqueda;
      rhsIdbusqueda = that.getIdbusqueda();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "idbusqueda", lhsIdbusqueda),
          LocatorUtils.property(thatLocator, "idbusqueda", rhsIdbusqueda), lhsIdbusqueda, rhsIdbusqueda, (this.idbusqueda != null),
          (that.idbusqueda != null))) {
        return false;
      }
    }
    {
      String lhsNumeropagina;
      lhsNumeropagina = this.getNumeropagina();
      String rhsNumeropagina;
      rhsNumeropagina = that.getNumeropagina();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "numeropagina", lhsNumeropagina),
          LocatorUtils.property(thatLocator, "numeropagina", rhsNumeropagina), lhsNumeropagina, rhsNumeropagina,
          (this.numeropagina != null), (that.numeropagina != null))) {
        return false;
      }
    }
    {
      String lhsNumerototalpaginas;
      lhsNumerototalpaginas = this.getNumerototalpaginas();
      String rhsNumerototalpaginas;
      rhsNumerototalpaginas = that.getNumerototalpaginas();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "numerototalpaginas", lhsNumerototalpaginas),
          LocatorUtils.property(thatLocator, "numerototalpaginas", rhsNumerototalpaginas), lhsNumerototalpaginas, rhsNumerototalpaginas,
          (this.numerototalpaginas != null), (that.numerototalpaginas != null))) {
        return false;
      }
    }
    {
      String lhsNumeroregistrospagina;
      lhsNumeroregistrospagina = this.getNumeroregistrospagina();
      String rhsNumeroregistrospagina;
      rhsNumeroregistrospagina = that.getNumeroregistrospagina();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "numeroregistrospagina", lhsNumeroregistrospagina),
          LocatorUtils.property(thatLocator, "numeroregistrospagina", rhsNumeroregistrospagina), lhsNumeroregistrospagina,
          rhsNumeroregistrospagina, (this.numeroregistrospagina != null), (that.numeroregistrospagina != null))) {
        return false;
      }
    }
    {
      String lhsNumerototalresultados;
      lhsNumerototalresultados = this.getNumerototalresultados();
      String rhsNumerototalresultados;
      rhsNumerototalresultados = that.getNumerototalresultados();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "numerototalresultados", lhsNumerototalresultados),
          LocatorUtils.property(thatLocator, "numerototalresultados", rhsNumerototalresultados), lhsNumerototalresultados,
          rhsNumerototalresultados, (this.numerototalresultados != null), (that.numerototalresultados != null))) {
        return false;
      }
    }
    {
      List<IcmParametrospaginacionRecord> lhsIcmParametrospaginacionRecordSet;
      lhsIcmParametrospaginacionRecordSet =
          (((this.icmParametrospaginacionRecordSet != null) && (!this.icmParametrospaginacionRecordSet.isEmpty()))
              ? this.getIcmParametrospaginacionRecordSet()
              : null);
      List<IcmParametrospaginacionRecord> rhsIcmParametrospaginacionRecordSet;
      rhsIcmParametrospaginacionRecordSet =
          (((that.icmParametrospaginacionRecordSet != null) && (!that.icmParametrospaginacionRecordSet.isEmpty()))
              ? that.getIcmParametrospaginacionRecordSet()
              : null);
      if (!strategy.equals(LocatorUtils.property(thisLocator, "icmParametrospaginacionRecordSet", lhsIcmParametrospaginacionRecordSet),
          LocatorUtils.property(thatLocator, "icmParametrospaginacionRecordSet", rhsIcmParametrospaginacionRecordSet),
          lhsIcmParametrospaginacionRecordSet, rhsIcmParametrospaginacionRecordSet,
          ((this.icmParametrospaginacionRecordSet != null) && (!this.icmParametrospaginacionRecordSet.isEmpty())),
          ((that.icmParametrospaginacionRecordSet != null) && (!that.icmParametrospaginacionRecordSet.isEmpty())))) {
        return false;
      }
    }
    return true;
  }

  public boolean equals(Object object) {
    final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
    return equals(null, null, object, strategy);
  }

  public String toString() {
    final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
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
      String theTipoorden;
      theTipoorden = this.getTipoorden();
      strategy.appendField(locator, this, "tipoorden", buffer, theTipoorden, (this.tipoorden != null));
    }
    {
      String theCampoorden;
      theCampoorden = this.getCampoorden();
      strategy.appendField(locator, this, "campoorden", buffer, theCampoorden, (this.campoorden != null));
    }
    {
      String theIdbusqueda;
      theIdbusqueda = this.getIdbusqueda();
      strategy.appendField(locator, this, "idbusqueda", buffer, theIdbusqueda, (this.idbusqueda != null));
    }
    {
      String theNumeropagina;
      theNumeropagina = this.getNumeropagina();
      strategy.appendField(locator, this, "numeropagina", buffer, theNumeropagina, (this.numeropagina != null));
    }
    {
      String theNumerototalpaginas;
      theNumerototalpaginas = this.getNumerototalpaginas();
      strategy.appendField(locator, this, "numerototalpaginas", buffer, theNumerototalpaginas, (this.numerototalpaginas != null));
    }
    {
      String theNumeroregistrospagina;
      theNumeroregistrospagina = this.getNumeroregistrospagina();
      strategy.appendField(locator, this, "numeroregistrospagina", buffer, theNumeroregistrospagina, (this.numeroregistrospagina != null));
    }
    {
      String theNumerototalresultados;
      theNumerototalresultados = this.getNumerototalresultados();
      strategy.appendField(locator, this, "numerototalresultados", buffer, theNumerototalresultados, (this.numerototalresultados != null));
    }
    {
      List<IcmParametrospaginacionRecord> theIcmParametrospaginacionRecordSet;
      theIcmParametrospaginacionRecordSet =
          (((this.icmParametrospaginacionRecordSet != null) && (!this.icmParametrospaginacionRecordSet.isEmpty()))
              ? this.getIcmParametrospaginacionRecordSet()
              : null);
      strategy.appendField(locator, this, "icmParametrospaginacionRecordSet", buffer, theIcmParametrospaginacionRecordSet,
          ((this.icmParametrospaginacionRecordSet != null) && (!this.icmParametrospaginacionRecordSet.isEmpty())));
    }
    return buffer;
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      String theTipoorden;
      theTipoorden = this.getTipoorden();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tipoorden", theTipoorden), currentHashCode, theTipoorden,
          (this.tipoorden != null));
    }
    {
      String theCampoorden;
      theCampoorden = this.getCampoorden();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "campoorden", theCampoorden), currentHashCode, theCampoorden,
          (this.campoorden != null));
    }
    {
      String theIdbusqueda;
      theIdbusqueda = this.getIdbusqueda();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "idbusqueda", theIdbusqueda), currentHashCode, theIdbusqueda,
          (this.idbusqueda != null));
    }
    {
      String theNumeropagina;
      theNumeropagina = this.getNumeropagina();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numeropagina", theNumeropagina), currentHashCode, theNumeropagina,
          (this.numeropagina != null));
    }
    {
      String theNumerototalpaginas;
      theNumerototalpaginas = this.getNumerototalpaginas();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numerototalpaginas", theNumerototalpaginas), currentHashCode,
          theNumerototalpaginas, (this.numerototalpaginas != null));
    }
    {
      String theNumeroregistrospagina;
      theNumeroregistrospagina = this.getNumeroregistrospagina();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numeroregistrospagina", theNumeroregistrospagina),
          currentHashCode, theNumeroregistrospagina, (this.numeroregistrospagina != null));
    }
    {
      String theNumerototalresultados;
      theNumerototalresultados = this.getNumerototalresultados();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "numerototalresultados", theNumerototalresultados),
          currentHashCode, theNumerototalresultados, (this.numerototalresultados != null));
    }
    {
      List<IcmParametrospaginacionRecord> theIcmParametrospaginacionRecordSet;
      theIcmParametrospaginacionRecordSet =
          (((this.icmParametrospaginacionRecordSet != null) && (!this.icmParametrospaginacionRecordSet.isEmpty()))
              ? this.getIcmParametrospaginacionRecordSet()
              : null);
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "icmParametrospaginacionRecordSet", theIcmParametrospaginacionRecordSet),
              currentHashCode, theIcmParametrospaginacionRecordSet,
              ((this.icmParametrospaginacionRecordSet != null) && (!this.icmParametrospaginacionRecordSet.isEmpty())));
    }
    return currentHashCode;
  }

  public int hashCode() {
    final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
    return this.hashCode(null, strategy);
  }

  public Object clone() {
    return copyTo(createNewInstance());
  }

  public Object copyTo(Object target) {
    final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
    return copyTo(null, target, strategy);
  }

  public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
    final Object draftCopy = ((target == null) ? createNewInstance() : target);
    if (draftCopy instanceof IcmParametrospaginacionBlock) {
      final IcmParametrospaginacionBlock copy = ((IcmParametrospaginacionBlock) draftCopy);
      {
        Boolean tipoordenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.tipoorden != null));
        if (tipoordenShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceTipoorden;
          sourceTipoorden = this.getTipoorden();
          String copyTipoorden = ((String) strategy.copy(LocatorUtils.property(locator, "tipoorden", sourceTipoorden), sourceTipoorden,
              (this.tipoorden != null)));
          copy.setTipoorden(copyTipoorden);
        } else {
          if (tipoordenShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.tipoorden = null;
          }
        }
      }
      {
        Boolean campoordenShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.campoorden != null));
        if (campoordenShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceCampoorden;
          sourceCampoorden = this.getCampoorden();
          String copyCampoorden = ((String) strategy.copy(LocatorUtils.property(locator, "campoorden", sourceCampoorden), sourceCampoorden,
              (this.campoorden != null)));
          copy.setCampoorden(copyCampoorden);
        } else {
          if (campoordenShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.campoorden = null;
          }
        }
      }
      {
        Boolean idbusquedaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.idbusqueda != null));
        if (idbusquedaShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceIdbusqueda;
          sourceIdbusqueda = this.getIdbusqueda();
          String copyIdbusqueda = ((String) strategy.copy(LocatorUtils.property(locator, "idbusqueda", sourceIdbusqueda), sourceIdbusqueda,
              (this.idbusqueda != null)));
          copy.setIdbusqueda(copyIdbusqueda);
        } else {
          if (idbusquedaShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.idbusqueda = null;
          }
        }
      }
      {
        Boolean numeropaginaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.numeropagina != null));
        if (numeropaginaShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceNumeropagina;
          sourceNumeropagina = this.getNumeropagina();
          String copyNumeropagina = ((String) strategy.copy(LocatorUtils.property(locator, "numeropagina", sourceNumeropagina),
              sourceNumeropagina, (this.numeropagina != null)));
          copy.setNumeropagina(copyNumeropagina);
        } else {
          if (numeropaginaShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.numeropagina = null;
          }
        }
      }
      {
        Boolean numerototalpaginasShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.numerototalpaginas != null));
        if (numerototalpaginasShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceNumerototalpaginas;
          sourceNumerototalpaginas = this.getNumerototalpaginas();
          String copyNumerototalpaginas =
              ((String) strategy.copy(LocatorUtils.property(locator, "numerototalpaginas", sourceNumerototalpaginas),
                  sourceNumerototalpaginas, (this.numerototalpaginas != null)));
          copy.setNumerototalpaginas(copyNumerototalpaginas);
        } else {
          if (numerototalpaginasShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.numerototalpaginas = null;
          }
        }
      }
      {
        Boolean numeroregistrospaginaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.numeroregistrospagina != null));
        if (numeroregistrospaginaShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceNumeroregistrospagina;
          sourceNumeroregistrospagina = this.getNumeroregistrospagina();
          String copyNumeroregistrospagina =
              ((String) strategy.copy(LocatorUtils.property(locator, "numeroregistrospagina", sourceNumeroregistrospagina),
                  sourceNumeroregistrospagina, (this.numeroregistrospagina != null)));
          copy.setNumeroregistrospagina(copyNumeroregistrospagina);
        } else {
          if (numeroregistrospaginaShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.numeroregistrospagina = null;
          }
        }
      }
      {
        Boolean numerototalresultadosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.numerototalresultados != null));
        if (numerototalresultadosShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceNumerototalresultados;
          sourceNumerototalresultados = this.getNumerototalresultados();
          String copyNumerototalresultados =
              ((String) strategy.copy(LocatorUtils.property(locator, "numerototalresultados", sourceNumerototalresultados),
                  sourceNumerototalresultados, (this.numerototalresultados != null)));
          copy.setNumerototalresultados(copyNumerototalresultados);
        } else {
          if (numerototalresultadosShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.numerototalresultados = null;
          }
        }
      }
      {
        Boolean icmParametrospaginacionRecordSetShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator,
            ((this.icmParametrospaginacionRecordSet != null) && (!this.icmParametrospaginacionRecordSet.isEmpty())));
        if (icmParametrospaginacionRecordSetShouldBeCopiedAndSet == Boolean.TRUE) {
          List<IcmParametrospaginacionRecord> sourceIcmParametrospaginacionRecordSet;
          sourceIcmParametrospaginacionRecordSet =
              (((this.icmParametrospaginacionRecordSet != null) && (!this.icmParametrospaginacionRecordSet.isEmpty()))
                  ? this.getIcmParametrospaginacionRecordSet()
                  : null);
          @SuppressWarnings("unchecked")
          List<IcmParametrospaginacionRecord> copyIcmParametrospaginacionRecordSet = ((List<IcmParametrospaginacionRecord>) strategy.copy(
              LocatorUtils.property(locator, "icmParametrospaginacionRecordSet", sourceIcmParametrospaginacionRecordSet),
              sourceIcmParametrospaginacionRecordSet,
              ((this.icmParametrospaginacionRecordSet != null) && (!this.icmParametrospaginacionRecordSet.isEmpty()))));
          copy.icmParametrospaginacionRecordSet = null;
          if (copyIcmParametrospaginacionRecordSet != null) {
            List<IcmParametrospaginacionRecord> uniqueIcmParametrospaginacionRecordSetl = copy.getIcmParametrospaginacionRecordSet();
            uniqueIcmParametrospaginacionRecordSetl.addAll(copyIcmParametrospaginacionRecordSet);
          }
        } else {
          if (icmParametrospaginacionRecordSetShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.icmParametrospaginacionRecordSet = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new IcmParametrospaginacionBlock();
  }

}
