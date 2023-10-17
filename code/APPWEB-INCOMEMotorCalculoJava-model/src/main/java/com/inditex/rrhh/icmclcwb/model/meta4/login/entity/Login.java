
package com.inditex.rrhh.icmclcwb.model.meta4.login.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Getter;
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
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ai_sUser" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ai_sPassword" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ai_sLanguage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aiSUser",
    "aiSPassword",
    "aiSLanguage"
})
@XmlRootElement(name = "login")
public class Login implements Serializable, Cloneable, CopyTo2, Equals2, HashCode2, ToString2 {

  private final static long serialVersionUID = 1L;

    /**
     * -- GETTER --
     *  Gets the value of the aiSUser property.
     *
     * @return possible object is {@link String }
     */
    @XmlElement(name = "ai_sUser", required = true)
  protected String aiSUser;

    /**
     * -- GETTER --
     *  Gets the value of the aiSPassword property.
     *
     * @return possible object is {@link String }
     */
    @XmlElement(name = "ai_sPassword", required = true)
  protected String aiSPassword;

    /**
     * -- GETTER --
     *  Gets the value of the aiSLanguage property.
     *
     * @return possible object is {@link String }
     */
    @XmlElement(name = "ai_sLanguage", required = true)
  protected String aiSLanguage;

    /**
   * Sets the value of the aiSUser property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSUser(final String value) {
    this.aiSUser = value;
  }

    /**
   * Sets the value of the aiSPassword property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSPassword(final String value) {
    this.aiSPassword = value;
  }

    /**
   * Sets the value of the aiSLanguage property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAiSLanguage(final String value) {
    this.aiSLanguage = value;
  }

  public boolean equals(final ObjectLocator thisLocator, final ObjectLocator thatLocator, final Object object, final EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    final Login that = ((Login) object);
    {
      final String lhsAiSUser;
      lhsAiSUser = this.getAiSUser();
      final String rhsAiSUser;
      rhsAiSUser = that.getAiSUser();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "aiSUser", lhsAiSUser),
          LocatorUtils.property(thatLocator, "aiSUser", rhsAiSUser), lhsAiSUser, rhsAiSUser, (this.aiSUser != null),
          (that.aiSUser != null))) {
        return false;
      }
    }
    {
      final String lhsAiSPassword;
      lhsAiSPassword = this.getAiSPassword();
      final String rhsAiSPassword;
      rhsAiSPassword = that.getAiSPassword();
      if (!strategy.equals(LocatorUtils.property(thisLocator, "aiSPassword", lhsAiSPassword),
          LocatorUtils.property(thatLocator, "aiSPassword", rhsAiSPassword), lhsAiSPassword, rhsAiSPassword, (this.aiSPassword != null),
          (that.aiSPassword != null))) {
        return false;
      }
    }
    {
      final String lhsAiSLanguage;
      lhsAiSLanguage = this.getAiSLanguage();
      final String rhsAiSLanguage;
      rhsAiSLanguage = that.getAiSLanguage();
      return strategy.equals(LocatorUtils.property(thisLocator, "aiSLanguage", lhsAiSLanguage),
          LocatorUtils.property(thatLocator, "aiSLanguage", rhsAiSLanguage), lhsAiSLanguage, rhsAiSLanguage, (this.aiSLanguage != null),
          (that.aiSLanguage != null));
    }
  }

  public boolean equals(final Object object) {
    final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
    return this.equals(null, null, object, strategy);
  }

  public String toString() {
    final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE2;
    final StringBuilder buffer = new StringBuilder();
    this.append(null, buffer, strategy);
    return buffer.toString();
  }

  public StringBuilder append(final ObjectLocator locator, final StringBuilder buffer, final ToStringStrategy2 strategy) {
    strategy.appendStart(locator, this, buffer);
    this.appendFields(locator, buffer, strategy);
    strategy.appendEnd(locator, this, buffer);
    return buffer;
  }

  public StringBuilder appendFields(final ObjectLocator locator, final StringBuilder buffer, final ToStringStrategy2 strategy) {
    {
      final String theAiSUser;
      theAiSUser = this.getAiSUser();
      strategy.appendField(locator, this, "aiSUser", buffer, theAiSUser, (this.aiSUser != null));
    }
    {
      final String theAiSPassword;
      theAiSPassword = this.getAiSPassword();
      strategy.appendField(locator, this, "aiSPassword", buffer, theAiSPassword, (this.aiSPassword != null));
    }
    {
      final String theAiSLanguage;
      theAiSLanguage = this.getAiSLanguage();
      strategy.appendField(locator, this, "aiSLanguage", buffer, theAiSLanguage, (this.aiSLanguage != null));
    }
    return buffer;
  }

  public int hashCode(final ObjectLocator locator, final HashCodeStrategy2 strategy) {
    int currentHashCode = 1;
    {
      final String theAiSUser;
      theAiSUser = this.getAiSUser();
      currentHashCode =
          strategy.hashCode(LocatorUtils.property(locator, "aiSUser", theAiSUser), currentHashCode, theAiSUser, (this.aiSUser != null));
    }
    {
      final String theAiSPassword;
      theAiSPassword = this.getAiSPassword();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aiSPassword", theAiSPassword), currentHashCode, theAiSPassword,
          (this.aiSPassword != null));
    }
    {
      final String theAiSLanguage;
      theAiSLanguage = this.getAiSLanguage();
      currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "aiSLanguage", theAiSLanguage), currentHashCode, theAiSLanguage,
          (this.aiSLanguage != null));
    }
    return currentHashCode;
  }

  public int hashCode() {
    final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
    return this.hashCode(null, strategy);
  }

  public Object clone() {
    return this.copyTo(this.createNewInstance());
  }

  public Object copyTo(final Object target) {
    final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE2;
    return this.copyTo(null, target, strategy);
  }

  public Object copyTo(final ObjectLocator locator, final Object target, final CopyStrategy2 strategy) {
    final Object draftCopy = ((target == null) ? this.createNewInstance() : target);
    if (draftCopy instanceof Login) {
      final Login copy = ((Login) draftCopy);
      {
        final Boolean aiSUserShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSUser != null));
        if (aiSUserShouldBeCopiedAndSet == Boolean.TRUE) {
          final String sourceAiSUser;
          sourceAiSUser = this.getAiSUser();
          final String copyAiSUser =
              ((String) strategy.copy(LocatorUtils.property(locator, "aiSUser", sourceAiSUser), sourceAiSUser, (this.aiSUser != null)));
          copy.setAiSUser(copyAiSUser);
        } else {
          if (aiSUserShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.aiSUser = null;
          }
        }
      }
      {
        final Boolean aiSPasswordShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSPassword != null));
        if (aiSPasswordShouldBeCopiedAndSet == Boolean.TRUE) {
          final String sourceAiSPassword;
          sourceAiSPassword = this.getAiSPassword();
          final String copyAiSPassword = ((String) strategy.copy(LocatorUtils.property(locator, "aiSPassword", sourceAiSPassword),
              sourceAiSPassword, (this.aiSPassword != null)));
          copy.setAiSPassword(copyAiSPassword);
        } else {
          if (aiSPasswordShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.aiSPassword = null;
          }
        }
      }
      {
        final Boolean aiSLanguageShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.aiSLanguage != null));
        if (aiSLanguageShouldBeCopiedAndSet == Boolean.TRUE) {
          final String sourceAiSLanguage;
          sourceAiSLanguage = this.getAiSLanguage();
          final String copyAiSLanguage = ((String) strategy.copy(LocatorUtils.property(locator, "aiSLanguage", sourceAiSLanguage),
              sourceAiSLanguage, (this.aiSLanguage != null)));
          copy.setAiSLanguage(copyAiSLanguage);
        } else {
          if (aiSLanguageShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.aiSLanguage = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new Login();
  }

}
