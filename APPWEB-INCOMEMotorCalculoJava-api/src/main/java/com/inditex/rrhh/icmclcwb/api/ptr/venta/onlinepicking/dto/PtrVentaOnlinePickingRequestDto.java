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

    @XmlElement(name="fechaDesde")
    @NotNull
    private String fechaDesde;
    
    @XmlElement(name="fechaHasta")
    @NotNull
    private String fechaHasta;

    @XmlElement(name="pais")
    private Integer pais;

    @XmlElement(name="cadena")
    private Integer cadena;
    
    @XmlElement(name="empresa")
    private Integer empresa;
    
    @XmlElement(name = "tiendaOnline")
    private List<String> tiendaOnline;

    @XmlElement(name="tienda")
    private List<Integer> tienda = new ArrayList<>();
    
    @XmlElement(name="seccion")
    private Integer seccion;
    
    @XmlElement(name="agrupacion")
    private PtrGroupTypeEnum agrupacion;
}
