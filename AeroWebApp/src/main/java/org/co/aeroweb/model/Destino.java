package org.co.aeroweb.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "destino")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Destino.findAll", query = "SELECT d FROM Destino d"),
		@NamedQuery(name = "Destino.findByIddestino", query = "SELECT d FROM Destino d WHERE d.iddestino = :iddestino"),
		@NamedQuery(name = "Destino.findByOrigen", query = "SELECT d FROM Destino d WHERE d.origen = :origen"),
		@NamedQuery(name = "Destino.findByDestino", query = "SELECT d FROM Destino d WHERE d.destino = :destino"),
		@NamedQuery(name = "Destino.findByEsidayvuelta", query = "SELECT d FROM Destino d WHERE d.esidayvuelta = :esidayvuelta"),
		@NamedQuery(name = "Destino.findByEsinternacional", query = "SELECT d FROM Destino d WHERE d.esinternacional = :esinternacional") })
public class Destino implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "iddestino")
	private Integer iddestino;
	@Basic(optional = false)
	@Column(name = "origen")
	private String origen;
	@Basic(optional = false)
	@Column(name = "destino")
	private String destino;
	@Column(name = "esidayvuelta")
	private String esidayvuelta;
	@Column(name = "esinternacional")
	private String esinternacional;
	@Column(name = "idtarifa")
	private Integer idtarifa;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "iddestino")
	private Collection<Vuelo> vueloCollection;

	public Destino() {
	}

	public Destino(Integer iddestino) {
		this.iddestino = iddestino;
	}

	public Integer getIdtarifa() {
		return idtarifa;
	}

	public void setIdtarifa(Integer idtarifa) {
		this.idtarifa = idtarifa;
	}

	public Destino(Integer iddestino, String origen, String destino) {
		this.iddestino = iddestino;
		this.origen = origen;
		this.destino = destino;
	}

	public Integer getIddestino() {
		return iddestino;
	}

	public void setIddestino(Integer iddestino) {
		this.iddestino = iddestino;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getEsidayvuelta() {
		return esidayvuelta;
	}

	public void setEsidayvuelta(String esidayvuelta) {
		this.esidayvuelta = esidayvuelta;
	}

	public String getEsinternacional() {
		return esinternacional;
	}

	public void setEsinternacional(String esinternacional) {
		this.esinternacional = esinternacional;
	}

	@XmlTransient
	public Collection<Vuelo> getVueloCollection() {
		return vueloCollection;
	}

	public void setVueloCollection(Collection<Vuelo> vueloCollection) {
		this.vueloCollection = vueloCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (iddestino != null ? iddestino.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Destino)) {
			return false;
		}
		Destino other = (Destino) object;
		if ((this.iddestino == null && other.iddestino != null)
				|| (this.iddestino != null && !this.iddestino.equals(other.iddestino))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Destino [iddestino=" + iddestino + ", origen=" + origen + ", destino=" + destino + ", esidayvuelta="
				+ esidayvuelta + ", esinternacional=" + esinternacional + ", idtarifa=" + idtarifa
				+ ", vueloCollection=" + vueloCollection + "]";
	}

}
