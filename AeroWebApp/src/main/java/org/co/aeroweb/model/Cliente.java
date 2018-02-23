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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
		@NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
		@NamedQuery(name = "Cliente.findByTipodocumento", query = "SELECT c FROM Cliente c WHERE c.tipodocumento = :tipodocumento"),
		@NamedQuery(name = "Cliente.findByNrodocumento", query = "SELECT c FROM Cliente c WHERE c.nrodocumento = :nrodocumento"),
		@NamedQuery(name = "Cliente.findByNombrescliente", query = "SELECT c FROM Cliente c WHERE c.nombrescliente = :nombrescliente"),
		@NamedQuery(name = "Cliente.findByApellidoscliente", query = "SELECT c FROM Cliente c WHERE c.apellidoscliente = :apellidoscliente"),
		@NamedQuery(name = "Cliente.findByEmailcliente", query = "SELECT c FROM Cliente c WHERE c.emailcliente = :emailcliente"),
		@NamedQuery(name = "Cliente.findByMovilcliente", query = "SELECT c FROM Cliente c WHERE c.movilcliente = :movilcliente"),
		@NamedQuery(name = "Cliente.findByTelefonocliente", query = "SELECT c FROM Cliente c WHERE c.telefonocliente = :telefonocliente") })
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idcliente")
	private Integer idcliente;
	@Basic(optional = false)
	@Column(name = "tipodocumento")
	private String tipodocumento;
	@Basic(optional = false)
	@Column(name = "nrodocumento")
	private String nrodocumento;
	@Basic(optional = false)
	@Column(name = "nombrescliente")
	private String nombrescliente;
	@Basic(optional = false)
	@Column(name = "apellidoscliente")
	private String apellidoscliente;
	@Column(name = "emailcliente")
	private String emailcliente;
	@Column(name = "movilcliente")
	private String movilcliente;
	@Column(name = "telefonocliente")
	private String telefonocliente;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
	private Collection<Vuelo> vueloCollection;

	public Cliente() {
	}

	public Cliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public Cliente(Integer idcliente, String tipodocumento, String nrodocumento, String nombrescliente,
			String apellidoscliente) {
		this.idcliente = idcliente;
		this.tipodocumento = tipodocumento;
		this.nrodocumento = nrodocumento;
		this.nombrescliente = nombrescliente;
		this.apellidoscliente = apellidoscliente;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNrodocumento() {
		return nrodocumento;
	}

	public void setNrodocumento(String nrodocumento) {
		this.nrodocumento = nrodocumento;
	}

	public String getNombrescliente() {
		return nombrescliente;
	}

	public void setNombrescliente(String nombrescliente) {
		this.nombrescliente = nombrescliente;
	}

	public String getApellidoscliente() {
		return apellidoscliente;
	}

	public void setApellidoscliente(String apellidoscliente) {
		this.apellidoscliente = apellidoscliente;
	}

	public String getEmailcliente() {
		return emailcliente;
	}

	public void setEmailcliente(String emailcliente) {
		this.emailcliente = emailcliente;
	}

	public String getMovilcliente() {
		return movilcliente;
	}

	public void setMovilcliente(String movilcliente) {
		this.movilcliente = movilcliente;
	}

	public String getTelefonocliente() {
		return telefonocliente;
	}

	public void setTelefonocliente(String telefonocliente) {
		this.telefonocliente = telefonocliente;
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
		hash += (idcliente != null ? idcliente.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) object;
		if ((this.idcliente == null && other.idcliente != null)
				|| (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", tipodocumento=" + tipodocumento + ", nrodocumento=" + nrodocumento
				+ ", nombrescliente=" + nombrescliente + ", apellidoscliente=" + apellidoscliente + ", emailcliente="
				+ emailcliente + ", movilcliente=" + movilcliente + ", telefonocliente=" + telefonocliente
				+ ", vueloCollection=" + vueloCollection + "]";
	}

}
