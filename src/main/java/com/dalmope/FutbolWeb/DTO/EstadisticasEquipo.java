package com.dalmope.FutbolWeb.DTO;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estadisticas_equipo")
// @NamedQueries({
//     @NamedQuery(name = "EstadisticasEquipo.findAll", query = "SELECT e FROM EstadisticasEquipo e"),
//     @NamedQuery(name = "EstadisticasEquipo.findByEquipo", query = "SELECT e FROM EstadisticasEquipo e WHERE e.equipo = :equipo"),
//     @NamedQuery(name = "EstadisticasEquipo.findByGolesFavor", query = "SELECT e FROM EstadisticasEquipo e WHERE e.golesFavor = :golesFavor"),
//     @NamedQuery(name = "EstadisticasEquipo.findByGolesContra", query = "SELECT e FROM EstadisticasEquipo e WHERE e.golesContra = :golesContra"),
//     @NamedQuery(name = "EstadisticasEquipo.findByDiferenciaGoles", query = "SELECT e FROM EstadisticasEquipo e WHERE e.diferenciaGoles = :diferenciaGoles"),
//     @NamedQuery(name = "EstadisticasEquipo.findByPartidosJugados", query = "SELECT e FROM EstadisticasEquipo e WHERE e.partidosJugados = :partidosJugados"),
//     @NamedQuery(name = "EstadisticasEquipo.findByPartidosGanados", query = "SELECT e FROM EstadisticasEquipo e WHERE e.partidosGanados = :partidosGanados"),
//     @NamedQuery(name = "EstadisticasEquipo.findByPartidosPerdidos", query = "SELECT e FROM EstadisticasEquipo e WHERE e.partidosPerdidos = :partidosPerdidos"),
//     @NamedQuery(name = "EstadisticasEquipo.findByPuntos", query = "SELECT e FROM EstadisticasEquipo e WHERE e.puntos = :puntos"),
//     @NamedQuery(name = "EstadisticasEquipo.findByPromedio", query = "SELECT e FROM EstadisticasEquipo e WHERE e.promedio = :promedio")})
public class EstadisticasEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "equipo")
    private Integer equipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "goles_favor")
    private short golesFavor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "goles_contra")
    private short golesContra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diferencia_goles")
    private short diferenciaGoles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partidos_jugados")
    private short partidosJugados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partidos_ganados")
    private short partidosGanados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partidos_perdidos")
    private short partidosPerdidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partidos_empatados")
    private short partidosEmpatados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private short puntos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "promedio")
    private short promedio;
    @JoinColumn(name = "equipo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Equipo equipo1;

    public EstadisticasEquipo() {
    }

    public EstadisticasEquipo(Integer equipo) {
        this.equipo = equipo;
    }

    public EstadisticasEquipo(Integer equipo, short golesFavor, short golesContra, short diferenciaGoles, short partidosJugados, short partidosGanados, short partidosPerdidos, short puntos, short promedio) {
        this.equipo = equipo;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.diferenciaGoles = diferenciaGoles;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.puntos = puntos;
        this.promedio = promedio;
    }

    public Integer getEquipo() {
        return equipo;
    }

    public void setEquipo(Integer equipo) {
        this.equipo = equipo;
    }

    public short getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(short golesFavor) {
        this.golesFavor = golesFavor;
    }

    public short getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(short golesContra) {
        this.golesContra = golesContra;
    }

    public short getDiferenciaGoles() {
        return diferenciaGoles;
    }

    public void setDiferenciaGoles(short diferenciaGoles) {
        this.diferenciaGoles = diferenciaGoles;
    }

    public short getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(short partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public short getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(short partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public short getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(short partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public short getPuntos() {
        return puntos;
    }

    public void setPuntos(short puntos) {
        this.puntos = puntos;
    }

    public short getPromedio() {
        return promedio;
    }

    public void setPromedio(short promedio) {
        this.promedio = promedio;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipo != null ? equipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticasEquipo)) {
            return false;
        }
        EstadisticasEquipo other = (EstadisticasEquipo) object;
        if ((this.equipo == null && other.equipo != null) || (this.equipo != null && !this.equipo.equals(other.equipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.resources.datos.EstadisticasEquipo[ equipo=" + equipo + " ]";
    }
    
}
