
package com.inditex.rrhh.icmclcwb.model.meta4.icm_ws_income.entity;

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
 *         &lt;element name="ICM_WS_TOOLS" type="{http://schemas.meta4.com/}Icm_Ws_ToolsBlock"/>
 *         &lt;element name="ICM_VENTAMANUAL" type="{http://schemas.meta4.com/}Icm_VentamanualBlock"/>
 *         &lt;element name="ICM_GLOBALTIENDA" type="{http://schemas.meta4.com/}Icm_GlobaltiendaBlock"/>
 *         &lt;element name="ICM_PRESUPUESTOS" type="{http://schemas.meta4.com/}Icm_PresupuestosBlock"/>
 *         &lt;element name="ICM_BUSCADORTIENDA" type="{http://schemas.meta4.com/}Icm_BuscadortiendaBlock"/>
 *         &lt;element name="ICM_CABECERATIENDA" type="{http://schemas.meta4.com/}Icm_CabeceratiendaBlock"/>
 *         &lt;element name="ICM_DATOSGENTIENDA" type="{http://schemas.meta4.com/}Icm_DatosgentiendaBlock"/>
 *         &lt;element name="ICM_GLOBALEMPLEADO" type="{http://schemas.meta4.com/}Icm_GlobalempleadoBlock"/>
 *         &lt;element name="ICM_WS_OPERACIONES" type="{http://schemas.meta4.com/}Icm_Ws_OperacionesBlock"/>
 *         &lt;element name="ICM_EMPLEADOSTIENDA" type="{http://schemas.meta4.com/}Icm_EmpleadostiendaBlock"/>
 *         &lt;element name="ICM_PARAMETROSEXCEL" type="{http://schemas.meta4.com/}Icm_ParametrosexcelBlock"/>
 *         &lt;element name="ICM_PRESENCIAMANUAL" type="{http://schemas.meta4.com/}Icm_PresenciamanualBlock"/>
 *         &lt;element name="ICM_CABECERAEMPLEADO" type="{http://schemas.meta4.com/}Icm_CabeceraempleadoBlock"/>
 *         &lt;element name="ICM_CALENDARIOTIENDA" type="{http://schemas.meta4.com/}Icm_CalendariotiendaBlock"/>
 *         &lt;element name="ICM_CONDICIONESVENTA" type="{http://schemas.meta4.com/}Icm_CondicionesventaBlock"/>
 *         &lt;element name="ICM_DATOSGENEMPLEADO" type="{http://schemas.meta4.com/}Icm_DatosgenempleadoBlock"/>
 *         &lt;element name="ICM_EMPLEADOSDESPENT" type="{http://schemas.meta4.com/}Icm_EmpleadosdespentBlock"/>
 *         &lt;element name="ICM_EMPLEADOSDESPSAL" type="{http://schemas.meta4.com/}Icm_EmpleadosdespsalBlock"/>
 *         &lt;element name="ICM_PARAMETROSTIENDA" type="{http://schemas.meta4.com/}Icm_ParametrostiendaBlock"/>
 *         &lt;element name="ICM_RESULTADOGUARDADO" type="{http://schemas.meta4.com/}Icm_ResultadoguardadoBlock"/>
 *         &lt;element name="ICM_BANDASPRESUPUESTOS" type="{http://schemas.meta4.com/}Icm_BandaspresupuestosBlock"/>
 *         &lt;element name="ICM_CALENDARIOEMPLEADO" type="{http://schemas.meta4.com/}Icm_CalendarioempleadoBlock"/>
 *         &lt;element name="ICM_PARAMETROSEMPLEADO" type="{http://schemas.meta4.com/}Icm_ParametrosempleadoBlock"/>
 *         &lt;element name="ICM_TIENDACOMISIONABLE" type="{http://schemas.meta4.com/}Icm_TiendacomisionableBlock"/>
 *         &lt;element name="ICM_EMPLEADOSESTRUCTURA" type="{http://schemas.meta4.com/}Icm_EmpleadosestructuraBlock"/>
 *         &lt;element name="ICM_PARAMETROSPLANTILLA" type="{http://schemas.meta4.com/}Icm_ParametrosplantillaBlock"/>
 *         &lt;element name="ICM_TPCALCULOPAISCADENA" type="{http://schemas.meta4.com/}Icm_TpcalculopaiscadenaBlock"/>
 *         &lt;element name="ICM_ESTADOSTIENDASECCION" type="{http://schemas.meta4.com/}Icm_EstadostiendaseccionBlock"/>
 *         &lt;element name="ICM_PARAMETROSPAGINACION" type="{http://schemas.meta4.com/}Icm_ParametrospaginacionBlock"/>
 *         &lt;element name="ICM_PARAMETROSPAISCADENA" type="{http://schemas.meta4.com/}Icm_ParametrospaiscadenaBlock"/>
 *         &lt;element name="ICM_PLANTILLACONDICIONES" type="{http://schemas.meta4.com/}Icm_PlantillacondicionesBlock"/>
 *         &lt;element name="ICM_PARAMETROSPRESUPUESTO" type="{http://schemas.meta4.com/}Icm_ParametrospresupuestoBlock"/>
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
    "icmwstools",
    "icmventamanual",
    "icmglobaltienda",
    "icmpresupuestos",
    "icmbuscadortienda",
    "icmcabeceratienda",
    "icmdatosgentienda",
    "icmglobalempleado",
    "icmwsoperaciones",
    "icmempleadostienda",
    "icmparametrosexcel",
    "icmpresenciamanual",
    "icmcabeceraempleado",
    "icmcalendariotienda",
    "icmcondicionesventa",
    "icmdatosgenempleado",
    "icmempleadosdespent",
    "icmempleadosdespsal",
    "icmparametrostienda",
    "icmresultadoguardado",
    "icmbandaspresupuestos",
    "icmcalendarioempleado",
    "icmparametrosempleado",
    "icmtiendacomisionable",
    "icmempleadosestructura",
    "icmparametrosplantilla",
    "icmtpcalculopaiscadena",
    "icmestadostiendaseccion",
    "icmparametrospaginacion",
    "icmparametrospaiscadena",
    "icmplantillacondiciones",
    "icmparametrospresupuesto"
})
@XmlRootElement(name = "M4LoadObject")
public class M4LoadObject implements Cloneable, CopyTo2, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ICM_WS_TOOLS", required = true)
    protected IcmWsToolsBlock icmwstools;
    @XmlElement(name = "ICM_VENTAMANUAL", required = true)
    protected IcmVentamanualBlock icmventamanual;
    @XmlElement(name = "ICM_GLOBALTIENDA", required = true)
    protected IcmGlobaltiendaBlock icmglobaltienda;
    @XmlElement(name = "ICM_PRESUPUESTOS", required = true)
    protected IcmPresupuestosBlock icmpresupuestos;
    @XmlElement(name = "ICM_BUSCADORTIENDA", required = true)
    protected IcmBuscadortiendaBlock icmbuscadortienda;
    @XmlElement(name = "ICM_CABECERATIENDA", required = true)
    protected IcmCabeceratiendaBlock icmcabeceratienda;
    @XmlElement(name = "ICM_DATOSGENTIENDA", required = true)
    protected IcmDatosgentiendaBlock icmdatosgentienda;
    @XmlElement(name = "ICM_GLOBALEMPLEADO", required = true)
    protected IcmGlobalempleadoBlock icmglobalempleado;
    @XmlElement(name = "ICM_WS_OPERACIONES", required = true)
    protected IcmWsOperacionesBlock icmwsoperaciones;
    @XmlElement(name = "ICM_EMPLEADOSTIENDA", required = true)
    protected IcmEmpleadostiendaBlock icmempleadostienda;
    @XmlElement(name = "ICM_PARAMETROSEXCEL", required = true)
    protected IcmParametrosexcelBlock icmparametrosexcel;
    @XmlElement(name = "ICM_PRESENCIAMANUAL", required = true)
    protected IcmPresenciamanualBlock icmpresenciamanual;
    @XmlElement(name = "ICM_CABECERAEMPLEADO", required = true)
    protected IcmCabeceraempleadoBlock icmcabeceraempleado;
    @XmlElement(name = "ICM_CALENDARIOTIENDA", required = true)
    protected IcmCalendariotiendaBlock icmcalendariotienda;
    @XmlElement(name = "ICM_CONDICIONESVENTA", required = true)
    protected IcmCondicionesventaBlock icmcondicionesventa;
    @XmlElement(name = "ICM_DATOSGENEMPLEADO", required = true)
    protected IcmDatosgenempleadoBlock icmdatosgenempleado;
    @XmlElement(name = "ICM_EMPLEADOSDESPENT", required = true)
    protected IcmEmpleadosdespentBlock icmempleadosdespent;
    @XmlElement(name = "ICM_EMPLEADOSDESPSAL", required = true)
    protected IcmEmpleadosdespsalBlock icmempleadosdespsal;
    @XmlElement(name = "ICM_PARAMETROSTIENDA", required = true)
    protected IcmParametrostiendaBlock icmparametrostienda;
    @XmlElement(name = "ICM_RESULTADOGUARDADO", required = true)
    protected IcmResultadoguardadoBlock icmresultadoguardado;
    @XmlElement(name = "ICM_BANDASPRESUPUESTOS", required = true)
    protected IcmBandaspresupuestosBlock icmbandaspresupuestos;
    @XmlElement(name = "ICM_CALENDARIOEMPLEADO", required = true)
    protected IcmCalendarioempleadoBlock icmcalendarioempleado;
    @XmlElement(name = "ICM_PARAMETROSEMPLEADO", required = true)
    protected IcmParametrosempleadoBlock icmparametrosempleado;
    @XmlElement(name = "ICM_TIENDACOMISIONABLE", required = true)
    protected IcmTiendacomisionableBlock icmtiendacomisionable;
    @XmlElement(name = "ICM_EMPLEADOSESTRUCTURA", required = true)
    protected IcmEmpleadosestructuraBlock icmempleadosestructura;
    @XmlElement(name = "ICM_PARAMETROSPLANTILLA", required = true)
    protected IcmParametrosplantillaBlock icmparametrosplantilla;
    @XmlElement(name = "ICM_TPCALCULOPAISCADENA", required = true)
    protected IcmTpcalculopaiscadenaBlock icmtpcalculopaiscadena;
    @XmlElement(name = "ICM_ESTADOSTIENDASECCION", required = true)
    protected IcmEstadostiendaseccionBlock icmestadostiendaseccion;
    @XmlElement(name = "ICM_PARAMETROSPAGINACION", required = true)
    protected IcmParametrospaginacionBlock icmparametrospaginacion;
    @XmlElement(name = "ICM_PARAMETROSPAISCADENA", required = true)
    protected IcmParametrospaiscadenaBlock icmparametrospaiscadena;
    @XmlElement(name = "ICM_PLANTILLACONDICIONES", required = true)
    protected IcmPlantillacondicionesBlock icmplantillacondiciones;
    @XmlElement(name = "ICM_PARAMETROSPRESUPUESTO", required = true)
    protected IcmParametrospresupuestoBlock icmparametrospresupuesto;

    /**
     * Obtiene el valor de la propiedad icmwstools.
     * 
     * @return
     *     possible object is
     *     {@link IcmWsToolsBlock }
     *     
     */
    public IcmWsToolsBlock getICMWSTOOLS() {
        return icmwstools;
    }

    /**
     * Define el valor de la propiedad icmwstools.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmWsToolsBlock }
     *     
     */
    public void setICMWSTOOLS(IcmWsToolsBlock value) {
        this.icmwstools = value;
    }

    /**
     * Obtiene el valor de la propiedad icmventamanual.
     * 
     * @return
     *     possible object is
     *     {@link IcmVentamanualBlock }
     *     
     */
    public IcmVentamanualBlock getICMVENTAMANUAL() {
        return icmventamanual;
    }

    /**
     * Define el valor de la propiedad icmventamanual.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmVentamanualBlock }
     *     
     */
    public void setICMVENTAMANUAL(IcmVentamanualBlock value) {
        this.icmventamanual = value;
    }

    /**
     * Obtiene el valor de la propiedad icmglobaltienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmGlobaltiendaBlock }
     *     
     */
    public IcmGlobaltiendaBlock getICMGLOBALTIENDA() {
        return icmglobaltienda;
    }

    /**
     * Define el valor de la propiedad icmglobaltienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmGlobaltiendaBlock }
     *     
     */
    public void setICMGLOBALTIENDA(IcmGlobaltiendaBlock value) {
        this.icmglobaltienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmpresupuestos.
     * 
     * @return
     *     possible object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public IcmPresupuestosBlock getICMPRESUPUESTOS() {
        return icmpresupuestos;
    }

    /**
     * Define el valor de la propiedad icmpresupuestos.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPresupuestosBlock }
     *     
     */
    public void setICMPRESUPUESTOS(IcmPresupuestosBlock value) {
        this.icmpresupuestos = value;
    }

    /**
     * Obtiene el valor de la propiedad icmbuscadortienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmBuscadortiendaBlock }
     *     
     */
    public IcmBuscadortiendaBlock getICMBUSCADORTIENDA() {
        return icmbuscadortienda;
    }

    /**
     * Define el valor de la propiedad icmbuscadortienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmBuscadortiendaBlock }
     *     
     */
    public void setICMBUSCADORTIENDA(IcmBuscadortiendaBlock value) {
        this.icmbuscadortienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmcabeceratienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmCabeceratiendaBlock }
     *     
     */
    public IcmCabeceratiendaBlock getICMCABECERATIENDA() {
        return icmcabeceratienda;
    }

    /**
     * Define el valor de la propiedad icmcabeceratienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCabeceratiendaBlock }
     *     
     */
    public void setICMCABECERATIENDA(IcmCabeceratiendaBlock value) {
        this.icmcabeceratienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmdatosgentienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmDatosgentiendaBlock }
     *     
     */
    public IcmDatosgentiendaBlock getICMDATOSGENTIENDA() {
        return icmdatosgentienda;
    }

    /**
     * Define el valor de la propiedad icmdatosgentienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmDatosgentiendaBlock }
     *     
     */
    public void setICMDATOSGENTIENDA(IcmDatosgentiendaBlock value) {
        this.icmdatosgentienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmglobalempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmGlobalempleadoBlock }
     *     
     */
    public IcmGlobalempleadoBlock getICMGLOBALEMPLEADO() {
        return icmglobalempleado;
    }

    /**
     * Define el valor de la propiedad icmglobalempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmGlobalempleadoBlock }
     *     
     */
    public void setICMGLOBALEMPLEADO(IcmGlobalempleadoBlock value) {
        this.icmglobalempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmwsoperaciones.
     * 
     * @return
     *     possible object is
     *     {@link IcmWsOperacionesBlock }
     *     
     */
    public IcmWsOperacionesBlock getICMWSOPERACIONES() {
        return icmwsoperaciones;
    }

    /**
     * Define el valor de la propiedad icmwsoperaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmWsOperacionesBlock }
     *     
     */
    public void setICMWSOPERACIONES(IcmWsOperacionesBlock value) {
        this.icmwsoperaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad icmempleadostienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadostiendaBlock }
     *     
     */
    public IcmEmpleadostiendaBlock getICMEMPLEADOSTIENDA() {
        return icmempleadostienda;
    }

    /**
     * Define el valor de la propiedad icmempleadostienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadostiendaBlock }
     *     
     */
    public void setICMEMPLEADOSTIENDA(IcmEmpleadostiendaBlock value) {
        this.icmempleadostienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrosexcel.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosexcelBlock }
     *     
     */
    public IcmParametrosexcelBlock getICMPARAMETROSEXCEL() {
        return icmparametrosexcel;
    }

    /**
     * Define el valor de la propiedad icmparametrosexcel.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosexcelBlock }
     *     
     */
    public void setICMPARAMETROSEXCEL(IcmParametrosexcelBlock value) {
        this.icmparametrosexcel = value;
    }

    /**
     * Obtiene el valor de la propiedad icmpresenciamanual.
     * 
     * @return
     *     possible object is
     *     {@link IcmPresenciamanualBlock }
     *     
     */
    public IcmPresenciamanualBlock getICMPRESENCIAMANUAL() {
        return icmpresenciamanual;
    }

    /**
     * Define el valor de la propiedad icmpresenciamanual.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPresenciamanualBlock }
     *     
     */
    public void setICMPRESENCIAMANUAL(IcmPresenciamanualBlock value) {
        this.icmpresenciamanual = value;
    }

    /**
     * Obtiene el valor de la propiedad icmcabeceraempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmCabeceraempleadoBlock }
     *     
     */
    public IcmCabeceraempleadoBlock getICMCABECERAEMPLEADO() {
        return icmcabeceraempleado;
    }

    /**
     * Define el valor de la propiedad icmcabeceraempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCabeceraempleadoBlock }
     *     
     */
    public void setICMCABECERAEMPLEADO(IcmCabeceraempleadoBlock value) {
        this.icmcabeceraempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmcalendariotienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmCalendariotiendaBlock }
     *     
     */
    public IcmCalendariotiendaBlock getICMCALENDARIOTIENDA() {
        return icmcalendariotienda;
    }

    /**
     * Define el valor de la propiedad icmcalendariotienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCalendariotiendaBlock }
     *     
     */
    public void setICMCALENDARIOTIENDA(IcmCalendariotiendaBlock value) {
        this.icmcalendariotienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmcondicionesventa.
     * 
     * @return
     *     possible object is
     *     {@link IcmCondicionesventaBlock }
     *     
     */
    public IcmCondicionesventaBlock getICMCONDICIONESVENTA() {
        return icmcondicionesventa;
    }

    /**
     * Define el valor de la propiedad icmcondicionesventa.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCondicionesventaBlock }
     *     
     */
    public void setICMCONDICIONESVENTA(IcmCondicionesventaBlock value) {
        this.icmcondicionesventa = value;
    }

    /**
     * Obtiene el valor de la propiedad icmdatosgenempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmDatosgenempleadoBlock }
     *     
     */
    public IcmDatosgenempleadoBlock getICMDATOSGENEMPLEADO() {
        return icmdatosgenempleado;
    }

    /**
     * Define el valor de la propiedad icmdatosgenempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmDatosgenempleadoBlock }
     *     
     */
    public void setICMDATOSGENEMPLEADO(IcmDatosgenempleadoBlock value) {
        this.icmdatosgenempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmempleadosdespent.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadosdespentBlock }
     *     
     */
    public IcmEmpleadosdespentBlock getICMEMPLEADOSDESPENT() {
        return icmempleadosdespent;
    }

    /**
     * Define el valor de la propiedad icmempleadosdespent.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadosdespentBlock }
     *     
     */
    public void setICMEMPLEADOSDESPENT(IcmEmpleadosdespentBlock value) {
        this.icmempleadosdespent = value;
    }

    /**
     * Obtiene el valor de la propiedad icmempleadosdespsal.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadosdespsalBlock }
     *     
     */
    public IcmEmpleadosdespsalBlock getICMEMPLEADOSDESPSAL() {
        return icmempleadosdespsal;
    }

    /**
     * Define el valor de la propiedad icmempleadosdespsal.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadosdespsalBlock }
     *     
     */
    public void setICMEMPLEADOSDESPSAL(IcmEmpleadosdespsalBlock value) {
        this.icmempleadosdespsal = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrostienda.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrostiendaBlock }
     *     
     */
    public IcmParametrostiendaBlock getICMPARAMETROSTIENDA() {
        return icmparametrostienda;
    }

    /**
     * Define el valor de la propiedad icmparametrostienda.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrostiendaBlock }
     *     
     */
    public void setICMPARAMETROSTIENDA(IcmParametrostiendaBlock value) {
        this.icmparametrostienda = value;
    }

    /**
     * Obtiene el valor de la propiedad icmresultadoguardado.
     * 
     * @return
     *     possible object is
     *     {@link IcmResultadoguardadoBlock }
     *     
     */
    public IcmResultadoguardadoBlock getICMRESULTADOGUARDADO() {
        return icmresultadoguardado;
    }

    /**
     * Define el valor de la propiedad icmresultadoguardado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmResultadoguardadoBlock }
     *     
     */
    public void setICMRESULTADOGUARDADO(IcmResultadoguardadoBlock value) {
        this.icmresultadoguardado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmbandaspresupuestos.
     * 
     * @return
     *     possible object is
     *     {@link IcmBandaspresupuestosBlock }
     *     
     */
    public IcmBandaspresupuestosBlock getICMBANDASPRESUPUESTOS() {
        return icmbandaspresupuestos;
    }

    /**
     * Define el valor de la propiedad icmbandaspresupuestos.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmBandaspresupuestosBlock }
     *     
     */
    public void setICMBANDASPRESUPUESTOS(IcmBandaspresupuestosBlock value) {
        this.icmbandaspresupuestos = value;
    }

    /**
     * Obtiene el valor de la propiedad icmcalendarioempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmCalendarioempleadoBlock }
     *     
     */
    public IcmCalendarioempleadoBlock getICMCALENDARIOEMPLEADO() {
        return icmcalendarioempleado;
    }

    /**
     * Define el valor de la propiedad icmcalendarioempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmCalendarioempleadoBlock }
     *     
     */
    public void setICMCALENDARIOEMPLEADO(IcmCalendarioempleadoBlock value) {
        this.icmcalendarioempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrosempleado.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosempleadoBlock }
     *     
     */
    public IcmParametrosempleadoBlock getICMPARAMETROSEMPLEADO() {
        return icmparametrosempleado;
    }

    /**
     * Define el valor de la propiedad icmparametrosempleado.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosempleadoBlock }
     *     
     */
    public void setICMPARAMETROSEMPLEADO(IcmParametrosempleadoBlock value) {
        this.icmparametrosempleado = value;
    }

    /**
     * Obtiene el valor de la propiedad icmtiendacomisionable.
     * 
     * @return
     *     possible object is
     *     {@link IcmTiendacomisionableBlock }
     *     
     */
    public IcmTiendacomisionableBlock getICMTIENDACOMISIONABLE() {
        return icmtiendacomisionable;
    }

    /**
     * Define el valor de la propiedad icmtiendacomisionable.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmTiendacomisionableBlock }
     *     
     */
    public void setICMTIENDACOMISIONABLE(IcmTiendacomisionableBlock value) {
        this.icmtiendacomisionable = value;
    }

    /**
     * Obtiene el valor de la propiedad icmempleadosestructura.
     * 
     * @return
     *     possible object is
     *     {@link IcmEmpleadosestructuraBlock }
     *     
     */
    public IcmEmpleadosestructuraBlock getICMEMPLEADOSESTRUCTURA() {
        return icmempleadosestructura;
    }

    /**
     * Define el valor de la propiedad icmempleadosestructura.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEmpleadosestructuraBlock }
     *     
     */
    public void setICMEMPLEADOSESTRUCTURA(IcmEmpleadosestructuraBlock value) {
        this.icmempleadosestructura = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrosplantilla.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrosplantillaBlock }
     *     
     */
    public IcmParametrosplantillaBlock getICMPARAMETROSPLANTILLA() {
        return icmparametrosplantilla;
    }

    /**
     * Define el valor de la propiedad icmparametrosplantilla.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrosplantillaBlock }
     *     
     */
    public void setICMPARAMETROSPLANTILLA(IcmParametrosplantillaBlock value) {
        this.icmparametrosplantilla = value;
    }

    /**
     * Obtiene el valor de la propiedad icmtpcalculopaiscadena.
     * 
     * @return
     *     possible object is
     *     {@link IcmTpcalculopaiscadenaBlock }
     *     
     */
    public IcmTpcalculopaiscadenaBlock getICMTPCALCULOPAISCADENA() {
        return icmtpcalculopaiscadena;
    }

    /**
     * Define el valor de la propiedad icmtpcalculopaiscadena.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmTpcalculopaiscadenaBlock }
     *     
     */
    public void setICMTPCALCULOPAISCADENA(IcmTpcalculopaiscadenaBlock value) {
        this.icmtpcalculopaiscadena = value;
    }

    /**
     * Obtiene el valor de la propiedad icmestadostiendaseccion.
     * 
     * @return
     *     possible object is
     *     {@link IcmEstadostiendaseccionBlock }
     *     
     */
    public IcmEstadostiendaseccionBlock getICMESTADOSTIENDASECCION() {
        return icmestadostiendaseccion;
    }

    /**
     * Define el valor de la propiedad icmestadostiendaseccion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmEstadostiendaseccionBlock }
     *     
     */
    public void setICMESTADOSTIENDASECCION(IcmEstadostiendaseccionBlock value) {
        this.icmestadostiendaseccion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrospaginacion.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public IcmParametrospaginacionBlock getICMPARAMETROSPAGINACION() {
        return icmparametrospaginacion;
    }

    /**
     * Define el valor de la propiedad icmparametrospaginacion.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaginacionBlock }
     *     
     */
    public void setICMPARAMETROSPAGINACION(IcmParametrospaginacionBlock value) {
        this.icmparametrospaginacion = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrospaiscadena.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospaiscadenaBlock }
     *     
     */
    public IcmParametrospaiscadenaBlock getICMPARAMETROSPAISCADENA() {
        return icmparametrospaiscadena;
    }

    /**
     * Define el valor de la propiedad icmparametrospaiscadena.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospaiscadenaBlock }
     *     
     */
    public void setICMPARAMETROSPAISCADENA(IcmParametrospaiscadenaBlock value) {
        this.icmparametrospaiscadena = value;
    }

    /**
     * Obtiene el valor de la propiedad icmplantillacondiciones.
     * 
     * @return
     *     possible object is
     *     {@link IcmPlantillacondicionesBlock }
     *     
     */
    public IcmPlantillacondicionesBlock getICMPLANTILLACONDICIONES() {
        return icmplantillacondiciones;
    }

    /**
     * Define el valor de la propiedad icmplantillacondiciones.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmPlantillacondicionesBlock }
     *     
     */
    public void setICMPLANTILLACONDICIONES(IcmPlantillacondicionesBlock value) {
        this.icmplantillacondiciones = value;
    }

    /**
     * Obtiene el valor de la propiedad icmparametrospresupuesto.
     * 
     * @return
     *     possible object is
     *     {@link IcmParametrospresupuestoBlock }
     *     
     */
    public IcmParametrospresupuestoBlock getICMPARAMETROSPRESUPUESTO() {
        return icmparametrospresupuesto;
    }

    /**
     * Define el valor de la propiedad icmparametrospresupuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link IcmParametrospresupuestoBlock }
     *     
     */
    public void setICMPARAMETROSPRESUPUESTO(IcmParametrospresupuestoBlock value) {
        this.icmparametrospresupuesto = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final M4LoadObject that = ((M4LoadObject) object);
        {
            IcmWsToolsBlock lhsICMWSTOOLS;
            lhsICMWSTOOLS = this.getICMWSTOOLS();
            IcmWsToolsBlock rhsICMWSTOOLS;
            rhsICMWSTOOLS = that.getICMWSTOOLS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmwstools", lhsICMWSTOOLS), LocatorUtils.property(thatLocator, "icmwstools", rhsICMWSTOOLS), lhsICMWSTOOLS, rhsICMWSTOOLS, (this.icmwstools!= null), (that.icmwstools!= null))) {
                return false;
            }
        }
        {
            IcmVentamanualBlock lhsICMVENTAMANUAL;
            lhsICMVENTAMANUAL = this.getICMVENTAMANUAL();
            IcmVentamanualBlock rhsICMVENTAMANUAL;
            rhsICMVENTAMANUAL = that.getICMVENTAMANUAL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmventamanual", lhsICMVENTAMANUAL), LocatorUtils.property(thatLocator, "icmventamanual", rhsICMVENTAMANUAL), lhsICMVENTAMANUAL, rhsICMVENTAMANUAL, (this.icmventamanual!= null), (that.icmventamanual!= null))) {
                return false;
            }
        }
        {
            IcmGlobaltiendaBlock lhsICMGLOBALTIENDA;
            lhsICMGLOBALTIENDA = this.getICMGLOBALTIENDA();
            IcmGlobaltiendaBlock rhsICMGLOBALTIENDA;
            rhsICMGLOBALTIENDA = that.getICMGLOBALTIENDA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmglobaltienda", lhsICMGLOBALTIENDA), LocatorUtils.property(thatLocator, "icmglobaltienda", rhsICMGLOBALTIENDA), lhsICMGLOBALTIENDA, rhsICMGLOBALTIENDA, (this.icmglobaltienda!= null), (that.icmglobaltienda!= null))) {
                return false;
            }
        }
        {
            IcmPresupuestosBlock lhsICMPRESUPUESTOS;
            lhsICMPRESUPUESTOS = this.getICMPRESUPUESTOS();
            IcmPresupuestosBlock rhsICMPRESUPUESTOS;
            rhsICMPRESUPUESTOS = that.getICMPRESUPUESTOS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmpresupuestos", lhsICMPRESUPUESTOS), LocatorUtils.property(thatLocator, "icmpresupuestos", rhsICMPRESUPUESTOS), lhsICMPRESUPUESTOS, rhsICMPRESUPUESTOS, (this.icmpresupuestos!= null), (that.icmpresupuestos!= null))) {
                return false;
            }
        }
        {
            IcmBuscadortiendaBlock lhsICMBUSCADORTIENDA;
            lhsICMBUSCADORTIENDA = this.getICMBUSCADORTIENDA();
            IcmBuscadortiendaBlock rhsICMBUSCADORTIENDA;
            rhsICMBUSCADORTIENDA = that.getICMBUSCADORTIENDA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmbuscadortienda", lhsICMBUSCADORTIENDA), LocatorUtils.property(thatLocator, "icmbuscadortienda", rhsICMBUSCADORTIENDA), lhsICMBUSCADORTIENDA, rhsICMBUSCADORTIENDA, (this.icmbuscadortienda!= null), (that.icmbuscadortienda!= null))) {
                return false;
            }
        }
        {
            IcmCabeceratiendaBlock lhsICMCABECERATIENDA;
            lhsICMCABECERATIENDA = this.getICMCABECERATIENDA();
            IcmCabeceratiendaBlock rhsICMCABECERATIENDA;
            rhsICMCABECERATIENDA = that.getICMCABECERATIENDA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmcabeceratienda", lhsICMCABECERATIENDA), LocatorUtils.property(thatLocator, "icmcabeceratienda", rhsICMCABECERATIENDA), lhsICMCABECERATIENDA, rhsICMCABECERATIENDA, (this.icmcabeceratienda!= null), (that.icmcabeceratienda!= null))) {
                return false;
            }
        }
        {
            IcmDatosgentiendaBlock lhsICMDATOSGENTIENDA;
            lhsICMDATOSGENTIENDA = this.getICMDATOSGENTIENDA();
            IcmDatosgentiendaBlock rhsICMDATOSGENTIENDA;
            rhsICMDATOSGENTIENDA = that.getICMDATOSGENTIENDA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmdatosgentienda", lhsICMDATOSGENTIENDA), LocatorUtils.property(thatLocator, "icmdatosgentienda", rhsICMDATOSGENTIENDA), lhsICMDATOSGENTIENDA, rhsICMDATOSGENTIENDA, (this.icmdatosgentienda!= null), (that.icmdatosgentienda!= null))) {
                return false;
            }
        }
        {
            IcmGlobalempleadoBlock lhsICMGLOBALEMPLEADO;
            lhsICMGLOBALEMPLEADO = this.getICMGLOBALEMPLEADO();
            IcmGlobalempleadoBlock rhsICMGLOBALEMPLEADO;
            rhsICMGLOBALEMPLEADO = that.getICMGLOBALEMPLEADO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmglobalempleado", lhsICMGLOBALEMPLEADO), LocatorUtils.property(thatLocator, "icmglobalempleado", rhsICMGLOBALEMPLEADO), lhsICMGLOBALEMPLEADO, rhsICMGLOBALEMPLEADO, (this.icmglobalempleado!= null), (that.icmglobalempleado!= null))) {
                return false;
            }
        }
        {
            IcmWsOperacionesBlock lhsICMWSOPERACIONES;
            lhsICMWSOPERACIONES = this.getICMWSOPERACIONES();
            IcmWsOperacionesBlock rhsICMWSOPERACIONES;
            rhsICMWSOPERACIONES = that.getICMWSOPERACIONES();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmwsoperaciones", lhsICMWSOPERACIONES), LocatorUtils.property(thatLocator, "icmwsoperaciones", rhsICMWSOPERACIONES), lhsICMWSOPERACIONES, rhsICMWSOPERACIONES, (this.icmwsoperaciones!= null), (that.icmwsoperaciones!= null))) {
                return false;
            }
        }
        {
            IcmEmpleadostiendaBlock lhsICMEMPLEADOSTIENDA;
            lhsICMEMPLEADOSTIENDA = this.getICMEMPLEADOSTIENDA();
            IcmEmpleadostiendaBlock rhsICMEMPLEADOSTIENDA;
            rhsICMEMPLEADOSTIENDA = that.getICMEMPLEADOSTIENDA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmempleadostienda", lhsICMEMPLEADOSTIENDA), LocatorUtils.property(thatLocator, "icmempleadostienda", rhsICMEMPLEADOSTIENDA), lhsICMEMPLEADOSTIENDA, rhsICMEMPLEADOSTIENDA, (this.icmempleadostienda!= null), (that.icmempleadostienda!= null))) {
                return false;
            }
        }
        {
            IcmParametrosexcelBlock lhsICMPARAMETROSEXCEL;
            lhsICMPARAMETROSEXCEL = this.getICMPARAMETROSEXCEL();
            IcmParametrosexcelBlock rhsICMPARAMETROSEXCEL;
            rhsICMPARAMETROSEXCEL = that.getICMPARAMETROSEXCEL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrosexcel", lhsICMPARAMETROSEXCEL), LocatorUtils.property(thatLocator, "icmparametrosexcel", rhsICMPARAMETROSEXCEL), lhsICMPARAMETROSEXCEL, rhsICMPARAMETROSEXCEL, (this.icmparametrosexcel!= null), (that.icmparametrosexcel!= null))) {
                return false;
            }
        }
        {
            IcmPresenciamanualBlock lhsICMPRESENCIAMANUAL;
            lhsICMPRESENCIAMANUAL = this.getICMPRESENCIAMANUAL();
            IcmPresenciamanualBlock rhsICMPRESENCIAMANUAL;
            rhsICMPRESENCIAMANUAL = that.getICMPRESENCIAMANUAL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmpresenciamanual", lhsICMPRESENCIAMANUAL), LocatorUtils.property(thatLocator, "icmpresenciamanual", rhsICMPRESENCIAMANUAL), lhsICMPRESENCIAMANUAL, rhsICMPRESENCIAMANUAL, (this.icmpresenciamanual!= null), (that.icmpresenciamanual!= null))) {
                return false;
            }
        }
        {
            IcmCabeceraempleadoBlock lhsICMCABECERAEMPLEADO;
            lhsICMCABECERAEMPLEADO = this.getICMCABECERAEMPLEADO();
            IcmCabeceraempleadoBlock rhsICMCABECERAEMPLEADO;
            rhsICMCABECERAEMPLEADO = that.getICMCABECERAEMPLEADO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmcabeceraempleado", lhsICMCABECERAEMPLEADO), LocatorUtils.property(thatLocator, "icmcabeceraempleado", rhsICMCABECERAEMPLEADO), lhsICMCABECERAEMPLEADO, rhsICMCABECERAEMPLEADO, (this.icmcabeceraempleado!= null), (that.icmcabeceraempleado!= null))) {
                return false;
            }
        }
        {
            IcmCalendariotiendaBlock lhsICMCALENDARIOTIENDA;
            lhsICMCALENDARIOTIENDA = this.getICMCALENDARIOTIENDA();
            IcmCalendariotiendaBlock rhsICMCALENDARIOTIENDA;
            rhsICMCALENDARIOTIENDA = that.getICMCALENDARIOTIENDA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmcalendariotienda", lhsICMCALENDARIOTIENDA), LocatorUtils.property(thatLocator, "icmcalendariotienda", rhsICMCALENDARIOTIENDA), lhsICMCALENDARIOTIENDA, rhsICMCALENDARIOTIENDA, (this.icmcalendariotienda!= null), (that.icmcalendariotienda!= null))) {
                return false;
            }
        }
        {
            IcmCondicionesventaBlock lhsICMCONDICIONESVENTA;
            lhsICMCONDICIONESVENTA = this.getICMCONDICIONESVENTA();
            IcmCondicionesventaBlock rhsICMCONDICIONESVENTA;
            rhsICMCONDICIONESVENTA = that.getICMCONDICIONESVENTA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmcondicionesventa", lhsICMCONDICIONESVENTA), LocatorUtils.property(thatLocator, "icmcondicionesventa", rhsICMCONDICIONESVENTA), lhsICMCONDICIONESVENTA, rhsICMCONDICIONESVENTA, (this.icmcondicionesventa!= null), (that.icmcondicionesventa!= null))) {
                return false;
            }
        }
        {
            IcmDatosgenempleadoBlock lhsICMDATOSGENEMPLEADO;
            lhsICMDATOSGENEMPLEADO = this.getICMDATOSGENEMPLEADO();
            IcmDatosgenempleadoBlock rhsICMDATOSGENEMPLEADO;
            rhsICMDATOSGENEMPLEADO = that.getICMDATOSGENEMPLEADO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmdatosgenempleado", lhsICMDATOSGENEMPLEADO), LocatorUtils.property(thatLocator, "icmdatosgenempleado", rhsICMDATOSGENEMPLEADO), lhsICMDATOSGENEMPLEADO, rhsICMDATOSGENEMPLEADO, (this.icmdatosgenempleado!= null), (that.icmdatosgenempleado!= null))) {
                return false;
            }
        }
        {
            IcmEmpleadosdespentBlock lhsICMEMPLEADOSDESPENT;
            lhsICMEMPLEADOSDESPENT = this.getICMEMPLEADOSDESPENT();
            IcmEmpleadosdespentBlock rhsICMEMPLEADOSDESPENT;
            rhsICMEMPLEADOSDESPENT = that.getICMEMPLEADOSDESPENT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmempleadosdespent", lhsICMEMPLEADOSDESPENT), LocatorUtils.property(thatLocator, "icmempleadosdespent", rhsICMEMPLEADOSDESPENT), lhsICMEMPLEADOSDESPENT, rhsICMEMPLEADOSDESPENT, (this.icmempleadosdespent!= null), (that.icmempleadosdespent!= null))) {
                return false;
            }
        }
        {
            IcmEmpleadosdespsalBlock lhsICMEMPLEADOSDESPSAL;
            lhsICMEMPLEADOSDESPSAL = this.getICMEMPLEADOSDESPSAL();
            IcmEmpleadosdespsalBlock rhsICMEMPLEADOSDESPSAL;
            rhsICMEMPLEADOSDESPSAL = that.getICMEMPLEADOSDESPSAL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmempleadosdespsal", lhsICMEMPLEADOSDESPSAL), LocatorUtils.property(thatLocator, "icmempleadosdespsal", rhsICMEMPLEADOSDESPSAL), lhsICMEMPLEADOSDESPSAL, rhsICMEMPLEADOSDESPSAL, (this.icmempleadosdespsal!= null), (that.icmempleadosdespsal!= null))) {
                return false;
            }
        }
        {
            IcmParametrostiendaBlock lhsICMPARAMETROSTIENDA;
            lhsICMPARAMETROSTIENDA = this.getICMPARAMETROSTIENDA();
            IcmParametrostiendaBlock rhsICMPARAMETROSTIENDA;
            rhsICMPARAMETROSTIENDA = that.getICMPARAMETROSTIENDA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrostienda", lhsICMPARAMETROSTIENDA), LocatorUtils.property(thatLocator, "icmparametrostienda", rhsICMPARAMETROSTIENDA), lhsICMPARAMETROSTIENDA, rhsICMPARAMETROSTIENDA, (this.icmparametrostienda!= null), (that.icmparametrostienda!= null))) {
                return false;
            }
        }
        {
            IcmResultadoguardadoBlock lhsICMRESULTADOGUARDADO;
            lhsICMRESULTADOGUARDADO = this.getICMRESULTADOGUARDADO();
            IcmResultadoguardadoBlock rhsICMRESULTADOGUARDADO;
            rhsICMRESULTADOGUARDADO = that.getICMRESULTADOGUARDADO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmresultadoguardado", lhsICMRESULTADOGUARDADO), LocatorUtils.property(thatLocator, "icmresultadoguardado", rhsICMRESULTADOGUARDADO), lhsICMRESULTADOGUARDADO, rhsICMRESULTADOGUARDADO, (this.icmresultadoguardado!= null), (that.icmresultadoguardado!= null))) {
                return false;
            }
        }
        {
            IcmBandaspresupuestosBlock lhsICMBANDASPRESUPUESTOS;
            lhsICMBANDASPRESUPUESTOS = this.getICMBANDASPRESUPUESTOS();
            IcmBandaspresupuestosBlock rhsICMBANDASPRESUPUESTOS;
            rhsICMBANDASPRESUPUESTOS = that.getICMBANDASPRESUPUESTOS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmbandaspresupuestos", lhsICMBANDASPRESUPUESTOS), LocatorUtils.property(thatLocator, "icmbandaspresupuestos", rhsICMBANDASPRESUPUESTOS), lhsICMBANDASPRESUPUESTOS, rhsICMBANDASPRESUPUESTOS, (this.icmbandaspresupuestos!= null), (that.icmbandaspresupuestos!= null))) {
                return false;
            }
        }
        {
            IcmCalendarioempleadoBlock lhsICMCALENDARIOEMPLEADO;
            lhsICMCALENDARIOEMPLEADO = this.getICMCALENDARIOEMPLEADO();
            IcmCalendarioempleadoBlock rhsICMCALENDARIOEMPLEADO;
            rhsICMCALENDARIOEMPLEADO = that.getICMCALENDARIOEMPLEADO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmcalendarioempleado", lhsICMCALENDARIOEMPLEADO), LocatorUtils.property(thatLocator, "icmcalendarioempleado", rhsICMCALENDARIOEMPLEADO), lhsICMCALENDARIOEMPLEADO, rhsICMCALENDARIOEMPLEADO, (this.icmcalendarioempleado!= null), (that.icmcalendarioempleado!= null))) {
                return false;
            }
        }
        {
            IcmParametrosempleadoBlock lhsICMPARAMETROSEMPLEADO;
            lhsICMPARAMETROSEMPLEADO = this.getICMPARAMETROSEMPLEADO();
            IcmParametrosempleadoBlock rhsICMPARAMETROSEMPLEADO;
            rhsICMPARAMETROSEMPLEADO = that.getICMPARAMETROSEMPLEADO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrosempleado", lhsICMPARAMETROSEMPLEADO), LocatorUtils.property(thatLocator, "icmparametrosempleado", rhsICMPARAMETROSEMPLEADO), lhsICMPARAMETROSEMPLEADO, rhsICMPARAMETROSEMPLEADO, (this.icmparametrosempleado!= null), (that.icmparametrosempleado!= null))) {
                return false;
            }
        }
        {
            IcmTiendacomisionableBlock lhsICMTIENDACOMISIONABLE;
            lhsICMTIENDACOMISIONABLE = this.getICMTIENDACOMISIONABLE();
            IcmTiendacomisionableBlock rhsICMTIENDACOMISIONABLE;
            rhsICMTIENDACOMISIONABLE = that.getICMTIENDACOMISIONABLE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmtiendacomisionable", lhsICMTIENDACOMISIONABLE), LocatorUtils.property(thatLocator, "icmtiendacomisionable", rhsICMTIENDACOMISIONABLE), lhsICMTIENDACOMISIONABLE, rhsICMTIENDACOMISIONABLE, (this.icmtiendacomisionable!= null), (that.icmtiendacomisionable!= null))) {
                return false;
            }
        }
        {
            IcmEmpleadosestructuraBlock lhsICMEMPLEADOSESTRUCTURA;
            lhsICMEMPLEADOSESTRUCTURA = this.getICMEMPLEADOSESTRUCTURA();
            IcmEmpleadosestructuraBlock rhsICMEMPLEADOSESTRUCTURA;
            rhsICMEMPLEADOSESTRUCTURA = that.getICMEMPLEADOSESTRUCTURA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmempleadosestructura", lhsICMEMPLEADOSESTRUCTURA), LocatorUtils.property(thatLocator, "icmempleadosestructura", rhsICMEMPLEADOSESTRUCTURA), lhsICMEMPLEADOSESTRUCTURA, rhsICMEMPLEADOSESTRUCTURA, (this.icmempleadosestructura!= null), (that.icmempleadosestructura!= null))) {
                return false;
            }
        }
        {
            IcmParametrosplantillaBlock lhsICMPARAMETROSPLANTILLA;
            lhsICMPARAMETROSPLANTILLA = this.getICMPARAMETROSPLANTILLA();
            IcmParametrosplantillaBlock rhsICMPARAMETROSPLANTILLA;
            rhsICMPARAMETROSPLANTILLA = that.getICMPARAMETROSPLANTILLA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrosplantilla", lhsICMPARAMETROSPLANTILLA), LocatorUtils.property(thatLocator, "icmparametrosplantilla", rhsICMPARAMETROSPLANTILLA), lhsICMPARAMETROSPLANTILLA, rhsICMPARAMETROSPLANTILLA, (this.icmparametrosplantilla!= null), (that.icmparametrosplantilla!= null))) {
                return false;
            }
        }
        {
            IcmTpcalculopaiscadenaBlock lhsICMTPCALCULOPAISCADENA;
            lhsICMTPCALCULOPAISCADENA = this.getICMTPCALCULOPAISCADENA();
            IcmTpcalculopaiscadenaBlock rhsICMTPCALCULOPAISCADENA;
            rhsICMTPCALCULOPAISCADENA = that.getICMTPCALCULOPAISCADENA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmtpcalculopaiscadena", lhsICMTPCALCULOPAISCADENA), LocatorUtils.property(thatLocator, "icmtpcalculopaiscadena", rhsICMTPCALCULOPAISCADENA), lhsICMTPCALCULOPAISCADENA, rhsICMTPCALCULOPAISCADENA, (this.icmtpcalculopaiscadena!= null), (that.icmtpcalculopaiscadena!= null))) {
                return false;
            }
        }
        {
            IcmEstadostiendaseccionBlock lhsICMESTADOSTIENDASECCION;
            lhsICMESTADOSTIENDASECCION = this.getICMESTADOSTIENDASECCION();
            IcmEstadostiendaseccionBlock rhsICMESTADOSTIENDASECCION;
            rhsICMESTADOSTIENDASECCION = that.getICMESTADOSTIENDASECCION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmestadostiendaseccion", lhsICMESTADOSTIENDASECCION), LocatorUtils.property(thatLocator, "icmestadostiendaseccion", rhsICMESTADOSTIENDASECCION), lhsICMESTADOSTIENDASECCION, rhsICMESTADOSTIENDASECCION, (this.icmestadostiendaseccion!= null), (that.icmestadostiendaseccion!= null))) {
                return false;
            }
        }
        {
            IcmParametrospaginacionBlock lhsICMPARAMETROSPAGINACION;
            lhsICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            IcmParametrospaginacionBlock rhsICMPARAMETROSPAGINACION;
            rhsICMPARAMETROSPAGINACION = that.getICMPARAMETROSPAGINACION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrospaginacion", lhsICMPARAMETROSPAGINACION), LocatorUtils.property(thatLocator, "icmparametrospaginacion", rhsICMPARAMETROSPAGINACION), lhsICMPARAMETROSPAGINACION, rhsICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null), (that.icmparametrospaginacion!= null))) {
                return false;
            }
        }
        {
            IcmParametrospaiscadenaBlock lhsICMPARAMETROSPAISCADENA;
            lhsICMPARAMETROSPAISCADENA = this.getICMPARAMETROSPAISCADENA();
            IcmParametrospaiscadenaBlock rhsICMPARAMETROSPAISCADENA;
            rhsICMPARAMETROSPAISCADENA = that.getICMPARAMETROSPAISCADENA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrospaiscadena", lhsICMPARAMETROSPAISCADENA), LocatorUtils.property(thatLocator, "icmparametrospaiscadena", rhsICMPARAMETROSPAISCADENA), lhsICMPARAMETROSPAISCADENA, rhsICMPARAMETROSPAISCADENA, (this.icmparametrospaiscadena!= null), (that.icmparametrospaiscadena!= null))) {
                return false;
            }
        }
        {
            IcmPlantillacondicionesBlock lhsICMPLANTILLACONDICIONES;
            lhsICMPLANTILLACONDICIONES = this.getICMPLANTILLACONDICIONES();
            IcmPlantillacondicionesBlock rhsICMPLANTILLACONDICIONES;
            rhsICMPLANTILLACONDICIONES = that.getICMPLANTILLACONDICIONES();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmplantillacondiciones", lhsICMPLANTILLACONDICIONES), LocatorUtils.property(thatLocator, "icmplantillacondiciones", rhsICMPLANTILLACONDICIONES), lhsICMPLANTILLACONDICIONES, rhsICMPLANTILLACONDICIONES, (this.icmplantillacondiciones!= null), (that.icmplantillacondiciones!= null))) {
                return false;
            }
        }
        {
            IcmParametrospresupuestoBlock lhsICMPARAMETROSPRESUPUESTO;
            lhsICMPARAMETROSPRESUPUESTO = this.getICMPARAMETROSPRESUPUESTO();
            IcmParametrospresupuestoBlock rhsICMPARAMETROSPRESUPUESTO;
            rhsICMPARAMETROSPRESUPUESTO = that.getICMPARAMETROSPRESUPUESTO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "icmparametrospresupuesto", lhsICMPARAMETROSPRESUPUESTO), LocatorUtils.property(thatLocator, "icmparametrospresupuesto", rhsICMPARAMETROSPRESUPUESTO), lhsICMPARAMETROSPRESUPUESTO, rhsICMPARAMETROSPRESUPUESTO, (this.icmparametrospresupuesto!= null), (that.icmparametrospresupuesto!= null))) {
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
            IcmWsToolsBlock theICMWSTOOLS;
            theICMWSTOOLS = this.getICMWSTOOLS();
            strategy.appendField(locator, this, "icmwstools", buffer, theICMWSTOOLS, (this.icmwstools!= null));
        }
        {
            IcmVentamanualBlock theICMVENTAMANUAL;
            theICMVENTAMANUAL = this.getICMVENTAMANUAL();
            strategy.appendField(locator, this, "icmventamanual", buffer, theICMVENTAMANUAL, (this.icmventamanual!= null));
        }
        {
            IcmGlobaltiendaBlock theICMGLOBALTIENDA;
            theICMGLOBALTIENDA = this.getICMGLOBALTIENDA();
            strategy.appendField(locator, this, "icmglobaltienda", buffer, theICMGLOBALTIENDA, (this.icmglobaltienda!= null));
        }
        {
            IcmPresupuestosBlock theICMPRESUPUESTOS;
            theICMPRESUPUESTOS = this.getICMPRESUPUESTOS();
            strategy.appendField(locator, this, "icmpresupuestos", buffer, theICMPRESUPUESTOS, (this.icmpresupuestos!= null));
        }
        {
            IcmBuscadortiendaBlock theICMBUSCADORTIENDA;
            theICMBUSCADORTIENDA = this.getICMBUSCADORTIENDA();
            strategy.appendField(locator, this, "icmbuscadortienda", buffer, theICMBUSCADORTIENDA, (this.icmbuscadortienda!= null));
        }
        {
            IcmCabeceratiendaBlock theICMCABECERATIENDA;
            theICMCABECERATIENDA = this.getICMCABECERATIENDA();
            strategy.appendField(locator, this, "icmcabeceratienda", buffer, theICMCABECERATIENDA, (this.icmcabeceratienda!= null));
        }
        {
            IcmDatosgentiendaBlock theICMDATOSGENTIENDA;
            theICMDATOSGENTIENDA = this.getICMDATOSGENTIENDA();
            strategy.appendField(locator, this, "icmdatosgentienda", buffer, theICMDATOSGENTIENDA, (this.icmdatosgentienda!= null));
        }
        {
            IcmGlobalempleadoBlock theICMGLOBALEMPLEADO;
            theICMGLOBALEMPLEADO = this.getICMGLOBALEMPLEADO();
            strategy.appendField(locator, this, "icmglobalempleado", buffer, theICMGLOBALEMPLEADO, (this.icmglobalempleado!= null));
        }
        {
            IcmWsOperacionesBlock theICMWSOPERACIONES;
            theICMWSOPERACIONES = this.getICMWSOPERACIONES();
            strategy.appendField(locator, this, "icmwsoperaciones", buffer, theICMWSOPERACIONES, (this.icmwsoperaciones!= null));
        }
        {
            IcmEmpleadostiendaBlock theICMEMPLEADOSTIENDA;
            theICMEMPLEADOSTIENDA = this.getICMEMPLEADOSTIENDA();
            strategy.appendField(locator, this, "icmempleadostienda", buffer, theICMEMPLEADOSTIENDA, (this.icmempleadostienda!= null));
        }
        {
            IcmParametrosexcelBlock theICMPARAMETROSEXCEL;
            theICMPARAMETROSEXCEL = this.getICMPARAMETROSEXCEL();
            strategy.appendField(locator, this, "icmparametrosexcel", buffer, theICMPARAMETROSEXCEL, (this.icmparametrosexcel!= null));
        }
        {
            IcmPresenciamanualBlock theICMPRESENCIAMANUAL;
            theICMPRESENCIAMANUAL = this.getICMPRESENCIAMANUAL();
            strategy.appendField(locator, this, "icmpresenciamanual", buffer, theICMPRESENCIAMANUAL, (this.icmpresenciamanual!= null));
        }
        {
            IcmCabeceraempleadoBlock theICMCABECERAEMPLEADO;
            theICMCABECERAEMPLEADO = this.getICMCABECERAEMPLEADO();
            strategy.appendField(locator, this, "icmcabeceraempleado", buffer, theICMCABECERAEMPLEADO, (this.icmcabeceraempleado!= null));
        }
        {
            IcmCalendariotiendaBlock theICMCALENDARIOTIENDA;
            theICMCALENDARIOTIENDA = this.getICMCALENDARIOTIENDA();
            strategy.appendField(locator, this, "icmcalendariotienda", buffer, theICMCALENDARIOTIENDA, (this.icmcalendariotienda!= null));
        }
        {
            IcmCondicionesventaBlock theICMCONDICIONESVENTA;
            theICMCONDICIONESVENTA = this.getICMCONDICIONESVENTA();
            strategy.appendField(locator, this, "icmcondicionesventa", buffer, theICMCONDICIONESVENTA, (this.icmcondicionesventa!= null));
        }
        {
            IcmDatosgenempleadoBlock theICMDATOSGENEMPLEADO;
            theICMDATOSGENEMPLEADO = this.getICMDATOSGENEMPLEADO();
            strategy.appendField(locator, this, "icmdatosgenempleado", buffer, theICMDATOSGENEMPLEADO, (this.icmdatosgenempleado!= null));
        }
        {
            IcmEmpleadosdespentBlock theICMEMPLEADOSDESPENT;
            theICMEMPLEADOSDESPENT = this.getICMEMPLEADOSDESPENT();
            strategy.appendField(locator, this, "icmempleadosdespent", buffer, theICMEMPLEADOSDESPENT, (this.icmempleadosdespent!= null));
        }
        {
            IcmEmpleadosdespsalBlock theICMEMPLEADOSDESPSAL;
            theICMEMPLEADOSDESPSAL = this.getICMEMPLEADOSDESPSAL();
            strategy.appendField(locator, this, "icmempleadosdespsal", buffer, theICMEMPLEADOSDESPSAL, (this.icmempleadosdespsal!= null));
        }
        {
            IcmParametrostiendaBlock theICMPARAMETROSTIENDA;
            theICMPARAMETROSTIENDA = this.getICMPARAMETROSTIENDA();
            strategy.appendField(locator, this, "icmparametrostienda", buffer, theICMPARAMETROSTIENDA, (this.icmparametrostienda!= null));
        }
        {
            IcmResultadoguardadoBlock theICMRESULTADOGUARDADO;
            theICMRESULTADOGUARDADO = this.getICMRESULTADOGUARDADO();
            strategy.appendField(locator, this, "icmresultadoguardado", buffer, theICMRESULTADOGUARDADO, (this.icmresultadoguardado!= null));
        }
        {
            IcmBandaspresupuestosBlock theICMBANDASPRESUPUESTOS;
            theICMBANDASPRESUPUESTOS = this.getICMBANDASPRESUPUESTOS();
            strategy.appendField(locator, this, "icmbandaspresupuestos", buffer, theICMBANDASPRESUPUESTOS, (this.icmbandaspresupuestos!= null));
        }
        {
            IcmCalendarioempleadoBlock theICMCALENDARIOEMPLEADO;
            theICMCALENDARIOEMPLEADO = this.getICMCALENDARIOEMPLEADO();
            strategy.appendField(locator, this, "icmcalendarioempleado", buffer, theICMCALENDARIOEMPLEADO, (this.icmcalendarioempleado!= null));
        }
        {
            IcmParametrosempleadoBlock theICMPARAMETROSEMPLEADO;
            theICMPARAMETROSEMPLEADO = this.getICMPARAMETROSEMPLEADO();
            strategy.appendField(locator, this, "icmparametrosempleado", buffer, theICMPARAMETROSEMPLEADO, (this.icmparametrosempleado!= null));
        }
        {
            IcmTiendacomisionableBlock theICMTIENDACOMISIONABLE;
            theICMTIENDACOMISIONABLE = this.getICMTIENDACOMISIONABLE();
            strategy.appendField(locator, this, "icmtiendacomisionable", buffer, theICMTIENDACOMISIONABLE, (this.icmtiendacomisionable!= null));
        }
        {
            IcmEmpleadosestructuraBlock theICMEMPLEADOSESTRUCTURA;
            theICMEMPLEADOSESTRUCTURA = this.getICMEMPLEADOSESTRUCTURA();
            strategy.appendField(locator, this, "icmempleadosestructura", buffer, theICMEMPLEADOSESTRUCTURA, (this.icmempleadosestructura!= null));
        }
        {
            IcmParametrosplantillaBlock theICMPARAMETROSPLANTILLA;
            theICMPARAMETROSPLANTILLA = this.getICMPARAMETROSPLANTILLA();
            strategy.appendField(locator, this, "icmparametrosplantilla", buffer, theICMPARAMETROSPLANTILLA, (this.icmparametrosplantilla!= null));
        }
        {
            IcmTpcalculopaiscadenaBlock theICMTPCALCULOPAISCADENA;
            theICMTPCALCULOPAISCADENA = this.getICMTPCALCULOPAISCADENA();
            strategy.appendField(locator, this, "icmtpcalculopaiscadena", buffer, theICMTPCALCULOPAISCADENA, (this.icmtpcalculopaiscadena!= null));
        }
        {
            IcmEstadostiendaseccionBlock theICMESTADOSTIENDASECCION;
            theICMESTADOSTIENDASECCION = this.getICMESTADOSTIENDASECCION();
            strategy.appendField(locator, this, "icmestadostiendaseccion", buffer, theICMESTADOSTIENDASECCION, (this.icmestadostiendaseccion!= null));
        }
        {
            IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            strategy.appendField(locator, this, "icmparametrospaginacion", buffer, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null));
        }
        {
            IcmParametrospaiscadenaBlock theICMPARAMETROSPAISCADENA;
            theICMPARAMETROSPAISCADENA = this.getICMPARAMETROSPAISCADENA();
            strategy.appendField(locator, this, "icmparametrospaiscadena", buffer, theICMPARAMETROSPAISCADENA, (this.icmparametrospaiscadena!= null));
        }
        {
            IcmPlantillacondicionesBlock theICMPLANTILLACONDICIONES;
            theICMPLANTILLACONDICIONES = this.getICMPLANTILLACONDICIONES();
            strategy.appendField(locator, this, "icmplantillacondiciones", buffer, theICMPLANTILLACONDICIONES, (this.icmplantillacondiciones!= null));
        }
        {
            IcmParametrospresupuestoBlock theICMPARAMETROSPRESUPUESTO;
            theICMPARAMETROSPRESUPUESTO = this.getICMPARAMETROSPRESUPUESTO();
            strategy.appendField(locator, this, "icmparametrospresupuesto", buffer, theICMPARAMETROSPRESUPUESTO, (this.icmparametrospresupuesto!= null));
        }
        return buffer;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            IcmWsToolsBlock theICMWSTOOLS;
            theICMWSTOOLS = this.getICMWSTOOLS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmwstools", theICMWSTOOLS), currentHashCode, theICMWSTOOLS, (this.icmwstools!= null));
        }
        {
            IcmVentamanualBlock theICMVENTAMANUAL;
            theICMVENTAMANUAL = this.getICMVENTAMANUAL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmventamanual", theICMVENTAMANUAL), currentHashCode, theICMVENTAMANUAL, (this.icmventamanual!= null));
        }
        {
            IcmGlobaltiendaBlock theICMGLOBALTIENDA;
            theICMGLOBALTIENDA = this.getICMGLOBALTIENDA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmglobaltienda", theICMGLOBALTIENDA), currentHashCode, theICMGLOBALTIENDA, (this.icmglobaltienda!= null));
        }
        {
            IcmPresupuestosBlock theICMPRESUPUESTOS;
            theICMPRESUPUESTOS = this.getICMPRESUPUESTOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmpresupuestos", theICMPRESUPUESTOS), currentHashCode, theICMPRESUPUESTOS, (this.icmpresupuestos!= null));
        }
        {
            IcmBuscadortiendaBlock theICMBUSCADORTIENDA;
            theICMBUSCADORTIENDA = this.getICMBUSCADORTIENDA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmbuscadortienda", theICMBUSCADORTIENDA), currentHashCode, theICMBUSCADORTIENDA, (this.icmbuscadortienda!= null));
        }
        {
            IcmCabeceratiendaBlock theICMCABECERATIENDA;
            theICMCABECERATIENDA = this.getICMCABECERATIENDA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmcabeceratienda", theICMCABECERATIENDA), currentHashCode, theICMCABECERATIENDA, (this.icmcabeceratienda!= null));
        }
        {
            IcmDatosgentiendaBlock theICMDATOSGENTIENDA;
            theICMDATOSGENTIENDA = this.getICMDATOSGENTIENDA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmdatosgentienda", theICMDATOSGENTIENDA), currentHashCode, theICMDATOSGENTIENDA, (this.icmdatosgentienda!= null));
        }
        {
            IcmGlobalempleadoBlock theICMGLOBALEMPLEADO;
            theICMGLOBALEMPLEADO = this.getICMGLOBALEMPLEADO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmglobalempleado", theICMGLOBALEMPLEADO), currentHashCode, theICMGLOBALEMPLEADO, (this.icmglobalempleado!= null));
        }
        {
            IcmWsOperacionesBlock theICMWSOPERACIONES;
            theICMWSOPERACIONES = this.getICMWSOPERACIONES();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmwsoperaciones", theICMWSOPERACIONES), currentHashCode, theICMWSOPERACIONES, (this.icmwsoperaciones!= null));
        }
        {
            IcmEmpleadostiendaBlock theICMEMPLEADOSTIENDA;
            theICMEMPLEADOSTIENDA = this.getICMEMPLEADOSTIENDA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmempleadostienda", theICMEMPLEADOSTIENDA), currentHashCode, theICMEMPLEADOSTIENDA, (this.icmempleadostienda!= null));
        }
        {
            IcmParametrosexcelBlock theICMPARAMETROSEXCEL;
            theICMPARAMETROSEXCEL = this.getICMPARAMETROSEXCEL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrosexcel", theICMPARAMETROSEXCEL), currentHashCode, theICMPARAMETROSEXCEL, (this.icmparametrosexcel!= null));
        }
        {
            IcmPresenciamanualBlock theICMPRESENCIAMANUAL;
            theICMPRESENCIAMANUAL = this.getICMPRESENCIAMANUAL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmpresenciamanual", theICMPRESENCIAMANUAL), currentHashCode, theICMPRESENCIAMANUAL, (this.icmpresenciamanual!= null));
        }
        {
            IcmCabeceraempleadoBlock theICMCABECERAEMPLEADO;
            theICMCABECERAEMPLEADO = this.getICMCABECERAEMPLEADO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmcabeceraempleado", theICMCABECERAEMPLEADO), currentHashCode, theICMCABECERAEMPLEADO, (this.icmcabeceraempleado!= null));
        }
        {
            IcmCalendariotiendaBlock theICMCALENDARIOTIENDA;
            theICMCALENDARIOTIENDA = this.getICMCALENDARIOTIENDA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmcalendariotienda", theICMCALENDARIOTIENDA), currentHashCode, theICMCALENDARIOTIENDA, (this.icmcalendariotienda!= null));
        }
        {
            IcmCondicionesventaBlock theICMCONDICIONESVENTA;
            theICMCONDICIONESVENTA = this.getICMCONDICIONESVENTA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmcondicionesventa", theICMCONDICIONESVENTA), currentHashCode, theICMCONDICIONESVENTA, (this.icmcondicionesventa!= null));
        }
        {
            IcmDatosgenempleadoBlock theICMDATOSGENEMPLEADO;
            theICMDATOSGENEMPLEADO = this.getICMDATOSGENEMPLEADO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmdatosgenempleado", theICMDATOSGENEMPLEADO), currentHashCode, theICMDATOSGENEMPLEADO, (this.icmdatosgenempleado!= null));
        }
        {
            IcmEmpleadosdespentBlock theICMEMPLEADOSDESPENT;
            theICMEMPLEADOSDESPENT = this.getICMEMPLEADOSDESPENT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmempleadosdespent", theICMEMPLEADOSDESPENT), currentHashCode, theICMEMPLEADOSDESPENT, (this.icmempleadosdespent!= null));
        }
        {
            IcmEmpleadosdespsalBlock theICMEMPLEADOSDESPSAL;
            theICMEMPLEADOSDESPSAL = this.getICMEMPLEADOSDESPSAL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmempleadosdespsal", theICMEMPLEADOSDESPSAL), currentHashCode, theICMEMPLEADOSDESPSAL, (this.icmempleadosdespsal!= null));
        }
        {
            IcmParametrostiendaBlock theICMPARAMETROSTIENDA;
            theICMPARAMETROSTIENDA = this.getICMPARAMETROSTIENDA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrostienda", theICMPARAMETROSTIENDA), currentHashCode, theICMPARAMETROSTIENDA, (this.icmparametrostienda!= null));
        }
        {
            IcmResultadoguardadoBlock theICMRESULTADOGUARDADO;
            theICMRESULTADOGUARDADO = this.getICMRESULTADOGUARDADO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmresultadoguardado", theICMRESULTADOGUARDADO), currentHashCode, theICMRESULTADOGUARDADO, (this.icmresultadoguardado!= null));
        }
        {
            IcmBandaspresupuestosBlock theICMBANDASPRESUPUESTOS;
            theICMBANDASPRESUPUESTOS = this.getICMBANDASPRESUPUESTOS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmbandaspresupuestos", theICMBANDASPRESUPUESTOS), currentHashCode, theICMBANDASPRESUPUESTOS, (this.icmbandaspresupuestos!= null));
        }
        {
            IcmCalendarioempleadoBlock theICMCALENDARIOEMPLEADO;
            theICMCALENDARIOEMPLEADO = this.getICMCALENDARIOEMPLEADO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmcalendarioempleado", theICMCALENDARIOEMPLEADO), currentHashCode, theICMCALENDARIOEMPLEADO, (this.icmcalendarioempleado!= null));
        }
        {
            IcmParametrosempleadoBlock theICMPARAMETROSEMPLEADO;
            theICMPARAMETROSEMPLEADO = this.getICMPARAMETROSEMPLEADO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrosempleado", theICMPARAMETROSEMPLEADO), currentHashCode, theICMPARAMETROSEMPLEADO, (this.icmparametrosempleado!= null));
        }
        {
            IcmTiendacomisionableBlock theICMTIENDACOMISIONABLE;
            theICMTIENDACOMISIONABLE = this.getICMTIENDACOMISIONABLE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmtiendacomisionable", theICMTIENDACOMISIONABLE), currentHashCode, theICMTIENDACOMISIONABLE, (this.icmtiendacomisionable!= null));
        }
        {
            IcmEmpleadosestructuraBlock theICMEMPLEADOSESTRUCTURA;
            theICMEMPLEADOSESTRUCTURA = this.getICMEMPLEADOSESTRUCTURA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmempleadosestructura", theICMEMPLEADOSESTRUCTURA), currentHashCode, theICMEMPLEADOSESTRUCTURA, (this.icmempleadosestructura!= null));
        }
        {
            IcmParametrosplantillaBlock theICMPARAMETROSPLANTILLA;
            theICMPARAMETROSPLANTILLA = this.getICMPARAMETROSPLANTILLA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrosplantilla", theICMPARAMETROSPLANTILLA), currentHashCode, theICMPARAMETROSPLANTILLA, (this.icmparametrosplantilla!= null));
        }
        {
            IcmTpcalculopaiscadenaBlock theICMTPCALCULOPAISCADENA;
            theICMTPCALCULOPAISCADENA = this.getICMTPCALCULOPAISCADENA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmtpcalculopaiscadena", theICMTPCALCULOPAISCADENA), currentHashCode, theICMTPCALCULOPAISCADENA, (this.icmtpcalculopaiscadena!= null));
        }
        {
            IcmEstadostiendaseccionBlock theICMESTADOSTIENDASECCION;
            theICMESTADOSTIENDASECCION = this.getICMESTADOSTIENDASECCION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmestadostiendaseccion", theICMESTADOSTIENDASECCION), currentHashCode, theICMESTADOSTIENDASECCION, (this.icmestadostiendaseccion!= null));
        }
        {
            IcmParametrospaginacionBlock theICMPARAMETROSPAGINACION;
            theICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrospaginacion", theICMPARAMETROSPAGINACION), currentHashCode, theICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null));
        }
        {
            IcmParametrospaiscadenaBlock theICMPARAMETROSPAISCADENA;
            theICMPARAMETROSPAISCADENA = this.getICMPARAMETROSPAISCADENA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrospaiscadena", theICMPARAMETROSPAISCADENA), currentHashCode, theICMPARAMETROSPAISCADENA, (this.icmparametrospaiscadena!= null));
        }
        {
            IcmPlantillacondicionesBlock theICMPLANTILLACONDICIONES;
            theICMPLANTILLACONDICIONES = this.getICMPLANTILLACONDICIONES();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmplantillacondiciones", theICMPLANTILLACONDICIONES), currentHashCode, theICMPLANTILLACONDICIONES, (this.icmplantillacondiciones!= null));
        }
        {
            IcmParametrospresupuestoBlock theICMPARAMETROSPRESUPUESTO;
            theICMPARAMETROSPRESUPUESTO = this.getICMPARAMETROSPRESUPUESTO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "icmparametrospresupuesto", theICMPARAMETROSPRESUPUESTO), currentHashCode, theICMPARAMETROSPRESUPUESTO, (this.icmparametrospresupuesto!= null));
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
        if (draftCopy instanceof M4LoadObject) {
            final M4LoadObject copy = ((M4LoadObject) draftCopy);
            {
                Boolean icmwstoolsShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmwstools!= null));
                if (icmwstoolsShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmWsToolsBlock sourceICMWSTOOLS;
                    sourceICMWSTOOLS = this.getICMWSTOOLS();
                    IcmWsToolsBlock copyICMWSTOOLS = ((IcmWsToolsBlock) strategy.copy(LocatorUtils.property(locator, "icmwstools", sourceICMWSTOOLS), sourceICMWSTOOLS, (this.icmwstools!= null)));
                    copy.setICMWSTOOLS(copyICMWSTOOLS);
                } else {
                    if (icmwstoolsShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmwstools = null;
                    }
                }
            }
            {
                Boolean icmventamanualShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmventamanual!= null));
                if (icmventamanualShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmVentamanualBlock sourceICMVENTAMANUAL;
                    sourceICMVENTAMANUAL = this.getICMVENTAMANUAL();
                    IcmVentamanualBlock copyICMVENTAMANUAL = ((IcmVentamanualBlock) strategy.copy(LocatorUtils.property(locator, "icmventamanual", sourceICMVENTAMANUAL), sourceICMVENTAMANUAL, (this.icmventamanual!= null)));
                    copy.setICMVENTAMANUAL(copyICMVENTAMANUAL);
                } else {
                    if (icmventamanualShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmventamanual = null;
                    }
                }
            }
            {
                Boolean icmglobaltiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmglobaltienda!= null));
                if (icmglobaltiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmGlobaltiendaBlock sourceICMGLOBALTIENDA;
                    sourceICMGLOBALTIENDA = this.getICMGLOBALTIENDA();
                    IcmGlobaltiendaBlock copyICMGLOBALTIENDA = ((IcmGlobaltiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmglobaltienda", sourceICMGLOBALTIENDA), sourceICMGLOBALTIENDA, (this.icmglobaltienda!= null)));
                    copy.setICMGLOBALTIENDA(copyICMGLOBALTIENDA);
                } else {
                    if (icmglobaltiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmglobaltienda = null;
                    }
                }
            }
            {
                Boolean icmpresupuestosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmpresupuestos!= null));
                if (icmpresupuestosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmPresupuestosBlock sourceICMPRESUPUESTOS;
                    sourceICMPRESUPUESTOS = this.getICMPRESUPUESTOS();
                    IcmPresupuestosBlock copyICMPRESUPUESTOS = ((IcmPresupuestosBlock) strategy.copy(LocatorUtils.property(locator, "icmpresupuestos", sourceICMPRESUPUESTOS), sourceICMPRESUPUESTOS, (this.icmpresupuestos!= null)));
                    copy.setICMPRESUPUESTOS(copyICMPRESUPUESTOS);
                } else {
                    if (icmpresupuestosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmpresupuestos = null;
                    }
                }
            }
            {
                Boolean icmbuscadortiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmbuscadortienda!= null));
                if (icmbuscadortiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmBuscadortiendaBlock sourceICMBUSCADORTIENDA;
                    sourceICMBUSCADORTIENDA = this.getICMBUSCADORTIENDA();
                    IcmBuscadortiendaBlock copyICMBUSCADORTIENDA = ((IcmBuscadortiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmbuscadortienda", sourceICMBUSCADORTIENDA), sourceICMBUSCADORTIENDA, (this.icmbuscadortienda!= null)));
                    copy.setICMBUSCADORTIENDA(copyICMBUSCADORTIENDA);
                } else {
                    if (icmbuscadortiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmbuscadortienda = null;
                    }
                }
            }
            {
                Boolean icmcabeceratiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmcabeceratienda!= null));
                if (icmcabeceratiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmCabeceratiendaBlock sourceICMCABECERATIENDA;
                    sourceICMCABECERATIENDA = this.getICMCABECERATIENDA();
                    IcmCabeceratiendaBlock copyICMCABECERATIENDA = ((IcmCabeceratiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmcabeceratienda", sourceICMCABECERATIENDA), sourceICMCABECERATIENDA, (this.icmcabeceratienda!= null)));
                    copy.setICMCABECERATIENDA(copyICMCABECERATIENDA);
                } else {
                    if (icmcabeceratiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmcabeceratienda = null;
                    }
                }
            }
            {
                Boolean icmdatosgentiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmdatosgentienda!= null));
                if (icmdatosgentiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmDatosgentiendaBlock sourceICMDATOSGENTIENDA;
                    sourceICMDATOSGENTIENDA = this.getICMDATOSGENTIENDA();
                    IcmDatosgentiendaBlock copyICMDATOSGENTIENDA = ((IcmDatosgentiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmdatosgentienda", sourceICMDATOSGENTIENDA), sourceICMDATOSGENTIENDA, (this.icmdatosgentienda!= null)));
                    copy.setICMDATOSGENTIENDA(copyICMDATOSGENTIENDA);
                } else {
                    if (icmdatosgentiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmdatosgentienda = null;
                    }
                }
            }
            {
                Boolean icmglobalempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmglobalempleado!= null));
                if (icmglobalempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmGlobalempleadoBlock sourceICMGLOBALEMPLEADO;
                    sourceICMGLOBALEMPLEADO = this.getICMGLOBALEMPLEADO();
                    IcmGlobalempleadoBlock copyICMGLOBALEMPLEADO = ((IcmGlobalempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmglobalempleado", sourceICMGLOBALEMPLEADO), sourceICMGLOBALEMPLEADO, (this.icmglobalempleado!= null)));
                    copy.setICMGLOBALEMPLEADO(copyICMGLOBALEMPLEADO);
                } else {
                    if (icmglobalempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmglobalempleado = null;
                    }
                }
            }
            {
                Boolean icmwsoperacionesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmwsoperaciones!= null));
                if (icmwsoperacionesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmWsOperacionesBlock sourceICMWSOPERACIONES;
                    sourceICMWSOPERACIONES = this.getICMWSOPERACIONES();
                    IcmWsOperacionesBlock copyICMWSOPERACIONES = ((IcmWsOperacionesBlock) strategy.copy(LocatorUtils.property(locator, "icmwsoperaciones", sourceICMWSOPERACIONES), sourceICMWSOPERACIONES, (this.icmwsoperaciones!= null)));
                    copy.setICMWSOPERACIONES(copyICMWSOPERACIONES);
                } else {
                    if (icmwsoperacionesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmwsoperaciones = null;
                    }
                }
            }
            {
                Boolean icmempleadostiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmempleadostienda!= null));
                if (icmempleadostiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEmpleadostiendaBlock sourceICMEMPLEADOSTIENDA;
                    sourceICMEMPLEADOSTIENDA = this.getICMEMPLEADOSTIENDA();
                    IcmEmpleadostiendaBlock copyICMEMPLEADOSTIENDA = ((IcmEmpleadostiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmempleadostienda", sourceICMEMPLEADOSTIENDA), sourceICMEMPLEADOSTIENDA, (this.icmempleadostienda!= null)));
                    copy.setICMEMPLEADOSTIENDA(copyICMEMPLEADOSTIENDA);
                } else {
                    if (icmempleadostiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmempleadostienda = null;
                    }
                }
            }
            {
                Boolean icmparametrosexcelShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrosexcel!= null));
                if (icmparametrosexcelShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosexcelBlock sourceICMPARAMETROSEXCEL;
                    sourceICMPARAMETROSEXCEL = this.getICMPARAMETROSEXCEL();
                    IcmParametrosexcelBlock copyICMPARAMETROSEXCEL = ((IcmParametrosexcelBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrosexcel", sourceICMPARAMETROSEXCEL), sourceICMPARAMETROSEXCEL, (this.icmparametrosexcel!= null)));
                    copy.setICMPARAMETROSEXCEL(copyICMPARAMETROSEXCEL);
                } else {
                    if (icmparametrosexcelShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrosexcel = null;
                    }
                }
            }
            {
                Boolean icmpresenciamanualShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmpresenciamanual!= null));
                if (icmpresenciamanualShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmPresenciamanualBlock sourceICMPRESENCIAMANUAL;
                    sourceICMPRESENCIAMANUAL = this.getICMPRESENCIAMANUAL();
                    IcmPresenciamanualBlock copyICMPRESENCIAMANUAL = ((IcmPresenciamanualBlock) strategy.copy(LocatorUtils.property(locator, "icmpresenciamanual", sourceICMPRESENCIAMANUAL), sourceICMPRESENCIAMANUAL, (this.icmpresenciamanual!= null)));
                    copy.setICMPRESENCIAMANUAL(copyICMPRESENCIAMANUAL);
                } else {
                    if (icmpresenciamanualShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmpresenciamanual = null;
                    }
                }
            }
            {
                Boolean icmcabeceraempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmcabeceraempleado!= null));
                if (icmcabeceraempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmCabeceraempleadoBlock sourceICMCABECERAEMPLEADO;
                    sourceICMCABECERAEMPLEADO = this.getICMCABECERAEMPLEADO();
                    IcmCabeceraempleadoBlock copyICMCABECERAEMPLEADO = ((IcmCabeceraempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmcabeceraempleado", sourceICMCABECERAEMPLEADO), sourceICMCABECERAEMPLEADO, (this.icmcabeceraempleado!= null)));
                    copy.setICMCABECERAEMPLEADO(copyICMCABECERAEMPLEADO);
                } else {
                    if (icmcabeceraempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmcabeceraempleado = null;
                    }
                }
            }
            {
                Boolean icmcalendariotiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmcalendariotienda!= null));
                if (icmcalendariotiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmCalendariotiendaBlock sourceICMCALENDARIOTIENDA;
                    sourceICMCALENDARIOTIENDA = this.getICMCALENDARIOTIENDA();
                    IcmCalendariotiendaBlock copyICMCALENDARIOTIENDA = ((IcmCalendariotiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmcalendariotienda", sourceICMCALENDARIOTIENDA), sourceICMCALENDARIOTIENDA, (this.icmcalendariotienda!= null)));
                    copy.setICMCALENDARIOTIENDA(copyICMCALENDARIOTIENDA);
                } else {
                    if (icmcalendariotiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmcalendariotienda = null;
                    }
                }
            }
            {
                Boolean icmcondicionesventaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmcondicionesventa!= null));
                if (icmcondicionesventaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmCondicionesventaBlock sourceICMCONDICIONESVENTA;
                    sourceICMCONDICIONESVENTA = this.getICMCONDICIONESVENTA();
                    IcmCondicionesventaBlock copyICMCONDICIONESVENTA = ((IcmCondicionesventaBlock) strategy.copy(LocatorUtils.property(locator, "icmcondicionesventa", sourceICMCONDICIONESVENTA), sourceICMCONDICIONESVENTA, (this.icmcondicionesventa!= null)));
                    copy.setICMCONDICIONESVENTA(copyICMCONDICIONESVENTA);
                } else {
                    if (icmcondicionesventaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmcondicionesventa = null;
                    }
                }
            }
            {
                Boolean icmdatosgenempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmdatosgenempleado!= null));
                if (icmdatosgenempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmDatosgenempleadoBlock sourceICMDATOSGENEMPLEADO;
                    sourceICMDATOSGENEMPLEADO = this.getICMDATOSGENEMPLEADO();
                    IcmDatosgenempleadoBlock copyICMDATOSGENEMPLEADO = ((IcmDatosgenempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmdatosgenempleado", sourceICMDATOSGENEMPLEADO), sourceICMDATOSGENEMPLEADO, (this.icmdatosgenempleado!= null)));
                    copy.setICMDATOSGENEMPLEADO(copyICMDATOSGENEMPLEADO);
                } else {
                    if (icmdatosgenempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmdatosgenempleado = null;
                    }
                }
            }
            {
                Boolean icmempleadosdespentShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmempleadosdespent!= null));
                if (icmempleadosdespentShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEmpleadosdespentBlock sourceICMEMPLEADOSDESPENT;
                    sourceICMEMPLEADOSDESPENT = this.getICMEMPLEADOSDESPENT();
                    IcmEmpleadosdespentBlock copyICMEMPLEADOSDESPENT = ((IcmEmpleadosdespentBlock) strategy.copy(LocatorUtils.property(locator, "icmempleadosdespent", sourceICMEMPLEADOSDESPENT), sourceICMEMPLEADOSDESPENT, (this.icmempleadosdespent!= null)));
                    copy.setICMEMPLEADOSDESPENT(copyICMEMPLEADOSDESPENT);
                } else {
                    if (icmempleadosdespentShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmempleadosdespent = null;
                    }
                }
            }
            {
                Boolean icmempleadosdespsalShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmempleadosdespsal!= null));
                if (icmempleadosdespsalShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEmpleadosdespsalBlock sourceICMEMPLEADOSDESPSAL;
                    sourceICMEMPLEADOSDESPSAL = this.getICMEMPLEADOSDESPSAL();
                    IcmEmpleadosdespsalBlock copyICMEMPLEADOSDESPSAL = ((IcmEmpleadosdespsalBlock) strategy.copy(LocatorUtils.property(locator, "icmempleadosdespsal", sourceICMEMPLEADOSDESPSAL), sourceICMEMPLEADOSDESPSAL, (this.icmempleadosdespsal!= null)));
                    copy.setICMEMPLEADOSDESPSAL(copyICMEMPLEADOSDESPSAL);
                } else {
                    if (icmempleadosdespsalShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmempleadosdespsal = null;
                    }
                }
            }
            {
                Boolean icmparametrostiendaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrostienda!= null));
                if (icmparametrostiendaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrostiendaBlock sourceICMPARAMETROSTIENDA;
                    sourceICMPARAMETROSTIENDA = this.getICMPARAMETROSTIENDA();
                    IcmParametrostiendaBlock copyICMPARAMETROSTIENDA = ((IcmParametrostiendaBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrostienda", sourceICMPARAMETROSTIENDA), sourceICMPARAMETROSTIENDA, (this.icmparametrostienda!= null)));
                    copy.setICMPARAMETROSTIENDA(copyICMPARAMETROSTIENDA);
                } else {
                    if (icmparametrostiendaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrostienda = null;
                    }
                }
            }
            {
                Boolean icmresultadoguardadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmresultadoguardado!= null));
                if (icmresultadoguardadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmResultadoguardadoBlock sourceICMRESULTADOGUARDADO;
                    sourceICMRESULTADOGUARDADO = this.getICMRESULTADOGUARDADO();
                    IcmResultadoguardadoBlock copyICMRESULTADOGUARDADO = ((IcmResultadoguardadoBlock) strategy.copy(LocatorUtils.property(locator, "icmresultadoguardado", sourceICMRESULTADOGUARDADO), sourceICMRESULTADOGUARDADO, (this.icmresultadoguardado!= null)));
                    copy.setICMRESULTADOGUARDADO(copyICMRESULTADOGUARDADO);
                } else {
                    if (icmresultadoguardadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmresultadoguardado = null;
                    }
                }
            }
            {
                Boolean icmbandaspresupuestosShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmbandaspresupuestos!= null));
                if (icmbandaspresupuestosShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmBandaspresupuestosBlock sourceICMBANDASPRESUPUESTOS;
                    sourceICMBANDASPRESUPUESTOS = this.getICMBANDASPRESUPUESTOS();
                    IcmBandaspresupuestosBlock copyICMBANDASPRESUPUESTOS = ((IcmBandaspresupuestosBlock) strategy.copy(LocatorUtils.property(locator, "icmbandaspresupuestos", sourceICMBANDASPRESUPUESTOS), sourceICMBANDASPRESUPUESTOS, (this.icmbandaspresupuestos!= null)));
                    copy.setICMBANDASPRESUPUESTOS(copyICMBANDASPRESUPUESTOS);
                } else {
                    if (icmbandaspresupuestosShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmbandaspresupuestos = null;
                    }
                }
            }
            {
                Boolean icmcalendarioempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmcalendarioempleado!= null));
                if (icmcalendarioempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmCalendarioempleadoBlock sourceICMCALENDARIOEMPLEADO;
                    sourceICMCALENDARIOEMPLEADO = this.getICMCALENDARIOEMPLEADO();
                    IcmCalendarioempleadoBlock copyICMCALENDARIOEMPLEADO = ((IcmCalendarioempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmcalendarioempleado", sourceICMCALENDARIOEMPLEADO), sourceICMCALENDARIOEMPLEADO, (this.icmcalendarioempleado!= null)));
                    copy.setICMCALENDARIOEMPLEADO(copyICMCALENDARIOEMPLEADO);
                } else {
                    if (icmcalendarioempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmcalendarioempleado = null;
                    }
                }
            }
            {
                Boolean icmparametrosempleadoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrosempleado!= null));
                if (icmparametrosempleadoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosempleadoBlock sourceICMPARAMETROSEMPLEADO;
                    sourceICMPARAMETROSEMPLEADO = this.getICMPARAMETROSEMPLEADO();
                    IcmParametrosempleadoBlock copyICMPARAMETROSEMPLEADO = ((IcmParametrosempleadoBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrosempleado", sourceICMPARAMETROSEMPLEADO), sourceICMPARAMETROSEMPLEADO, (this.icmparametrosempleado!= null)));
                    copy.setICMPARAMETROSEMPLEADO(copyICMPARAMETROSEMPLEADO);
                } else {
                    if (icmparametrosempleadoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrosempleado = null;
                    }
                }
            }
            {
                Boolean icmtiendacomisionableShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmtiendacomisionable!= null));
                if (icmtiendacomisionableShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmTiendacomisionableBlock sourceICMTIENDACOMISIONABLE;
                    sourceICMTIENDACOMISIONABLE = this.getICMTIENDACOMISIONABLE();
                    IcmTiendacomisionableBlock copyICMTIENDACOMISIONABLE = ((IcmTiendacomisionableBlock) strategy.copy(LocatorUtils.property(locator, "icmtiendacomisionable", sourceICMTIENDACOMISIONABLE), sourceICMTIENDACOMISIONABLE, (this.icmtiendacomisionable!= null)));
                    copy.setICMTIENDACOMISIONABLE(copyICMTIENDACOMISIONABLE);
                } else {
                    if (icmtiendacomisionableShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmtiendacomisionable = null;
                    }
                }
            }
            {
                Boolean icmempleadosestructuraShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmempleadosestructura!= null));
                if (icmempleadosestructuraShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEmpleadosestructuraBlock sourceICMEMPLEADOSESTRUCTURA;
                    sourceICMEMPLEADOSESTRUCTURA = this.getICMEMPLEADOSESTRUCTURA();
                    IcmEmpleadosestructuraBlock copyICMEMPLEADOSESTRUCTURA = ((IcmEmpleadosestructuraBlock) strategy.copy(LocatorUtils.property(locator, "icmempleadosestructura", sourceICMEMPLEADOSESTRUCTURA), sourceICMEMPLEADOSESTRUCTURA, (this.icmempleadosestructura!= null)));
                    copy.setICMEMPLEADOSESTRUCTURA(copyICMEMPLEADOSESTRUCTURA);
                } else {
                    if (icmempleadosestructuraShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmempleadosestructura = null;
                    }
                }
            }
            {
                Boolean icmparametrosplantillaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrosplantilla!= null));
                if (icmparametrosplantillaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrosplantillaBlock sourceICMPARAMETROSPLANTILLA;
                    sourceICMPARAMETROSPLANTILLA = this.getICMPARAMETROSPLANTILLA();
                    IcmParametrosplantillaBlock copyICMPARAMETROSPLANTILLA = ((IcmParametrosplantillaBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrosplantilla", sourceICMPARAMETROSPLANTILLA), sourceICMPARAMETROSPLANTILLA, (this.icmparametrosplantilla!= null)));
                    copy.setICMPARAMETROSPLANTILLA(copyICMPARAMETROSPLANTILLA);
                } else {
                    if (icmparametrosplantillaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrosplantilla = null;
                    }
                }
            }
            {
                Boolean icmtpcalculopaiscadenaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmtpcalculopaiscadena!= null));
                if (icmtpcalculopaiscadenaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmTpcalculopaiscadenaBlock sourceICMTPCALCULOPAISCADENA;
                    sourceICMTPCALCULOPAISCADENA = this.getICMTPCALCULOPAISCADENA();
                    IcmTpcalculopaiscadenaBlock copyICMTPCALCULOPAISCADENA = ((IcmTpcalculopaiscadenaBlock) strategy.copy(LocatorUtils.property(locator, "icmtpcalculopaiscadena", sourceICMTPCALCULOPAISCADENA), sourceICMTPCALCULOPAISCADENA, (this.icmtpcalculopaiscadena!= null)));
                    copy.setICMTPCALCULOPAISCADENA(copyICMTPCALCULOPAISCADENA);
                } else {
                    if (icmtpcalculopaiscadenaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmtpcalculopaiscadena = null;
                    }
                }
            }
            {
                Boolean icmestadostiendaseccionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmestadostiendaseccion!= null));
                if (icmestadostiendaseccionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmEstadostiendaseccionBlock sourceICMESTADOSTIENDASECCION;
                    sourceICMESTADOSTIENDASECCION = this.getICMESTADOSTIENDASECCION();
                    IcmEstadostiendaseccionBlock copyICMESTADOSTIENDASECCION = ((IcmEstadostiendaseccionBlock) strategy.copy(LocatorUtils.property(locator, "icmestadostiendaseccion", sourceICMESTADOSTIENDASECCION), sourceICMESTADOSTIENDASECCION, (this.icmestadostiendaseccion!= null)));
                    copy.setICMESTADOSTIENDASECCION(copyICMESTADOSTIENDASECCION);
                } else {
                    if (icmestadostiendaseccionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmestadostiendaseccion = null;
                    }
                }
            }
            {
                Boolean icmparametrospaginacionShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrospaginacion!= null));
                if (icmparametrospaginacionShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospaginacionBlock sourceICMPARAMETROSPAGINACION;
                    sourceICMPARAMETROSPAGINACION = this.getICMPARAMETROSPAGINACION();
                    IcmParametrospaginacionBlock copyICMPARAMETROSPAGINACION = ((IcmParametrospaginacionBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrospaginacion", sourceICMPARAMETROSPAGINACION), sourceICMPARAMETROSPAGINACION, (this.icmparametrospaginacion!= null)));
                    copy.setICMPARAMETROSPAGINACION(copyICMPARAMETROSPAGINACION);
                } else {
                    if (icmparametrospaginacionShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrospaginacion = null;
                    }
                }
            }
            {
                Boolean icmparametrospaiscadenaShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrospaiscadena!= null));
                if (icmparametrospaiscadenaShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospaiscadenaBlock sourceICMPARAMETROSPAISCADENA;
                    sourceICMPARAMETROSPAISCADENA = this.getICMPARAMETROSPAISCADENA();
                    IcmParametrospaiscadenaBlock copyICMPARAMETROSPAISCADENA = ((IcmParametrospaiscadenaBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrospaiscadena", sourceICMPARAMETROSPAISCADENA), sourceICMPARAMETROSPAISCADENA, (this.icmparametrospaiscadena!= null)));
                    copy.setICMPARAMETROSPAISCADENA(copyICMPARAMETROSPAISCADENA);
                } else {
                    if (icmparametrospaiscadenaShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrospaiscadena = null;
                    }
                }
            }
            {
                Boolean icmplantillacondicionesShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmplantillacondiciones!= null));
                if (icmplantillacondicionesShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmPlantillacondicionesBlock sourceICMPLANTILLACONDICIONES;
                    sourceICMPLANTILLACONDICIONES = this.getICMPLANTILLACONDICIONES();
                    IcmPlantillacondicionesBlock copyICMPLANTILLACONDICIONES = ((IcmPlantillacondicionesBlock) strategy.copy(LocatorUtils.property(locator, "icmplantillacondiciones", sourceICMPLANTILLACONDICIONES), sourceICMPLANTILLACONDICIONES, (this.icmplantillacondiciones!= null)));
                    copy.setICMPLANTILLACONDICIONES(copyICMPLANTILLACONDICIONES);
                } else {
                    if (icmplantillacondicionesShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmplantillacondiciones = null;
                    }
                }
            }
            {
                Boolean icmparametrospresupuestoShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, (this.icmparametrospresupuesto!= null));
                if (icmparametrospresupuestoShouldBeCopiedAndSet == Boolean.TRUE) {
                    IcmParametrospresupuestoBlock sourceICMPARAMETROSPRESUPUESTO;
                    sourceICMPARAMETROSPRESUPUESTO = this.getICMPARAMETROSPRESUPUESTO();
                    IcmParametrospresupuestoBlock copyICMPARAMETROSPRESUPUESTO = ((IcmParametrospresupuestoBlock) strategy.copy(LocatorUtils.property(locator, "icmparametrospresupuesto", sourceICMPARAMETROSPRESUPUESTO), sourceICMPARAMETROSPRESUPUESTO, (this.icmparametrospresupuesto!= null)));
                    copy.setICMPARAMETROSPRESUPUESTO(copyICMPARAMETROSPRESUPUESTO);
                } else {
                    if (icmparametrospresupuestoShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.icmparametrospresupuesto = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new M4LoadObject();
    }

}
