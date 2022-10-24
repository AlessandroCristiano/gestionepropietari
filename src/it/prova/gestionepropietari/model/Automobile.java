package it.prova.gestionepropietari.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "automobile")
public class Automobile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modello")
	private String modello;
	@Column(name = "targa")
	private String targa;
	@Column(name = "annoImmatricolazione")
	private Date annoImmatricolazione;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proprietario_id")
	private Propietario proprietario;
	
	
	public Automobile() {
		super();
	}

	
	public Automobile(Long id, String marca, String modello, String targa, Date annoImmatricolazione,
			Propietario proprietario) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.annoImmatricolazione = annoImmatricolazione;
		this.proprietario = proprietario;
	}


	public Automobile(Long id, String marca, String modello, String targa, Date annoImmatricolazione) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.annoImmatricolazione = annoImmatricolazione;
	}


	public Automobile(String marca, String modello, String targa, Date annoImmatricolazione) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.annoImmatricolazione = annoImmatricolazione;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModello() {
		return modello;
	}


	public void setModello(String modello) {
		this.modello = modello;
	}


	public String getTarga() {
		return targa;
	}


	public void setTarga(String targa) {
		this.targa = targa;
	}


	public Date getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}


	public void setAnnoImmatricolazione(Date annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}


	public Propietario getProprietario() {
		return proprietario;
	}


	public void setProprietario(Propietario proprietario) {
		this.proprietario = proprietario;
	}


	@Override
	public String toString() {
		return "Automobile [id=" + id + ", marca=" + marca + ", modello=" + modello + ", targa=" + targa
				+ ", annoImmatricolazione=" + annoImmatricolazione + ", proprietario=" + proprietario + "]";
	}
}
