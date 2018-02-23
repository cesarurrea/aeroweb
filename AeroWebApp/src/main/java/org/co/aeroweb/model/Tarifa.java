package org.co.aeroweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tarifa")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Tarifa.findAll", query = "SELECT t FROM Tarifa t"),
		@NamedQuery(name = "Tarifa.findByIdtarifa", query = "SELECT t FROM Tarifa t WHERE t.idtarifa = :idtarifa"),
		@NamedQuery(name = "Tarifa.findByValor", query = "SELECT t FROM Tarifa t WHERE t.valor = :valor"),
		@NamedQuery(name = "Tarifa.findByObservaciones", query = "SELECT t FROM Tarifa t WHERE t.observaciones = :observaciones") })
public class Tarifa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idtarifa")
	private Integer idtarifa;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "valor")
	private BigDecimal valor;
	@Column(name = "observaciones")
	private String observaciones;
	@JsonIgnore
	@OneToMany(mappedBy = "idtarifa")
	private Collection<Destino> destinoCollection;

	public Tarifa() {
	}

	public Tarifa(Integer idtarifa) {
		this.idtarifa = idtarifa;
	}

	public Tarifa(Integer idtarifa, BigDecimal valor) {
		this.idtarifa = idtarifa;
		this.valor = valor;
	}

	public Integer getIdtarifa() {
		return idtarifa;
	}

	public void setIdtarifa(Integer idtarifa) {
		this.idtarifa = idtarifa;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@XmlTransient
	public Collection<Destino> getDestinoCollection() {
		return destinoCollection;
	}

	public void setDestinoCollection(Collection<Destino> destinoCollection) {
		this.destinoCollection = destinoCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idtarifa != null ? idtarifa.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Tarifa)) {
			return false;
		}
		Tarifa other = (Tarifa) object;
		if ((this.idtarifa == null && other.idtarifa != null)
				|| (this.idtarifa != null && !this.idtarifa.equals(other.idtarifa))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Tarifa [idtarifa=" + idtarifa + ", valor=" + valor + ", observaciones=" + observaciones
				+ ", destinoCollection=" + destinoCollection + "]";
	}

}
