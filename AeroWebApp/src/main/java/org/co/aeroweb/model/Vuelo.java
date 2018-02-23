package org.co.aeroweb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "vuelo")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v"),
		@NamedQuery(name = "Vuelo.findByIdvuelo", query = "SELECT v FROM Vuelo v WHERE v.idvuelo = :idvuelo"),
		@NamedQuery(name = "Vuelo.findByObservaciones", query = "SELECT v FROM Vuelo v WHERE v.observaciones = :observaciones") })
public class Vuelo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idvuelo")
	private Integer idvuelo;
	@Column(name = "observaciones")
	private String observaciones;
	@JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
	@ManyToOne(optional = false)
	private Cliente idcliente;
	@JoinColumn(name = "iddestino", referencedColumnName = "iddestino")
	@ManyToOne(optional = false)
	private Destino iddestino;

	public Vuelo() {
	}

	public Vuelo(Integer idvuelo) {
		this.idvuelo = idvuelo;
	}

	public Integer getIdvuelo() {
		return idvuelo;
	}

	public void setIdvuelo(Integer idvuelo) {
		this.idvuelo = idvuelo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Cliente getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Cliente idcliente) {
		this.idcliente = idcliente;
	}

	public Destino getIddestino() {
		return iddestino;
	}

	public void setIddestino(Destino iddestino) {
		this.iddestino = iddestino;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idvuelo != null ? idvuelo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Vuelo)) {
			return false;
		}
		Vuelo other = (Vuelo) object;
		if ((this.idvuelo == null && other.idvuelo != null)
				|| (this.idvuelo != null && !this.idvuelo.equals(other.idvuelo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Vuelo [idvuelo=" + idvuelo + ", observaciones=" + observaciones + ", idcliente=" + idcliente
				+ ", iddestino=" + iddestino + "]";
	}

}
