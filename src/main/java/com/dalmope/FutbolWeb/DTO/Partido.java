package com.dalmope.FutbolWeb.DTO;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "partido")
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_fecha")
    private Short numeroFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "goles_local")
    private short golesLocal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "goles_visitante")
    private short golesVisitante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "arbitro")
    private String arbitro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estadio")
    private String estadio;
    @JoinColumn(name = "equipo_local", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Equipo equipoLocal;
    @JoinColumn(name = "equipo_visitante", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Equipo equipoVisitante;

    public Partido() {
    }

    public Partido(Short numeroFecha) {
        this.numeroFecha = numeroFecha;
    }

    public Partido(Short numeroFecha, short golesLocal, short golesVisitante, String ciudad, String arbitro, String estadio) {
        this.numeroFecha = numeroFecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.ciudad = ciudad;
        this.arbitro = arbitro;
        this.estadio = estadio;
    }

    public Short getNumeroFecha() {
        return numeroFecha;
    }

    public void setNumeroFecha(Short numeroFecha) {
        this.numeroFecha = numeroFecha;
    }

    public short getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(short golesLocal) {
        this.golesLocal = golesLocal;
    }

    public short getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(short golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroFecha != null ? numeroFecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.numeroFecha == null && other.numeroFecha != null) || (this.numeroFecha != null && !this.numeroFecha.equals(other.numeroFecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.resources.datos.Partido[ numeroFecha=" + numeroFecha + " ]";
    }
    
}

