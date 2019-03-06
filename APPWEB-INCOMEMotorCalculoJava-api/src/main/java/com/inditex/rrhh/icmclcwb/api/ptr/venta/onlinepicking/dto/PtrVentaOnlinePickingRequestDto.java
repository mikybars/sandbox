package com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.PtrGroupTypeEnum;

import lombok.Data;

@XmlRootElement(name="ventaOnlineTiendaRequest")
@XmlAccessorType(XmlAccessType.NONE)
@Data
public class PtrVentaOnlinePickingRequestDto implements Serializable {
    
    private static final long serialVersionUID = 7536621533080093360L;

    @XmlElement(name="fechaDesde", nillable = true, defaultValue = "")
    @NotNull
    private String fechaDesde;
    
    @XmlElement(name="fechaHasta", nillable = true, defaultValue = "")
    @NotNull
    private String fechaHasta;

    @XmlElement(name="pais", nillable = true, defaultValue = "")
    private Integer pais;

    @XmlElement(name="cadena", nillable = true, defaultValue = "")
    private Integer cadena;
    
    @XmlElement(name="empresa", nillable = true, defaultValue = "")
    private Integer empresa;
    
    @XmlElement(name="tiendaOnline", nillable = true, defaultValue = "")
    private List<Integer> tiendaOnline = new ArrayList<>();

    @XmlElement(name="tienda", nillable = true, defaultValue = "")
    private List<Integer> tienda = new ArrayList<>();
    
    @XmlElement(name="seccion", nillable = true, defaultValue = "")
    private Integer seccion;
    
    @XmlElement(name="agrupacion", nillable = true, defaultValue = "")
    private PtrGroupTypeEnum agrupacion;
}
