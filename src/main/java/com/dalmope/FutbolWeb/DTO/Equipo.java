package com.dalmope.FutbolWeb.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "equipo")
// @NamedQueries({
    // @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    // @NamedQuery(name = "Equipo.findByCodigo", query = "SELECT e FROM Equipo e WHERE e.codigo = :codigo"),
    // @NamedQuery(name = "Equipo.findByNombre", query = "SELECT e FROM Equipo e WHERE e.nombre = :nombre"),
    // @NamedQuery(name = "Equipo.findByFechaCreacion", query = "SELECT e FROM Equipo e WHERE e.fechaCreacion = :fechaCreacion"),
    // @NamedQuery(name = "Equipo.findByTecnico", query = "SELECT e FROM Equipo e WHERE e.tecnico = :tecnico")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tecnico")
    private String tecnico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<Jugador> jugadores;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "equipo1")
    private EstadisticasEquipo estadisticasEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoLocal")
    private List<Partido> partidosLocal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoVisitante")
    private List<Partido> partidosVisitante;

    public Equipo() {
    }

    public Equipo(Integer codigo) {
        this.codigo = codigo;
    }

    public Equipo(Integer codigo, String nombre, Date fechaCreacion, String tecnico) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.tecnico = tecnico;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public EstadisticasEquipo getEstadisticasEquipo() {
        return estadisticasEquipo;
    }

    public void setEstadisticasEquipo(EstadisticasEquipo estadisticasEquipo) {
        this.estadisticasEquipo = estadisticasEquipo;
    }

    public List<Partido> getPartidosLocal() {
        return partidosLocal;
    }

    public void setPartidosLocal(List<Partido> partidosLocal) {
        this.partidosLocal = partidosLocal;
    }

    public List<Partido> getPartidoVisitante() {
        return partidosVisitante;
    }

    public void setPartidoCollection1(List<Partido> partidosVisitante) {
        this.partidosVisitante = partidosVisitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.resources.datos.Equipo[ codigo=" + codigo + " ]";
    }
    
}

