package gestionEleves.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_trimestre")
public class Trimestre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtrimestre;
	
	@Column(name="nom", length = 10, nullable = false)
	private Integer nom;

	@Column(name="date", nullable=false)
	private Date date;

	public Integer getId() {
		return idtrimestre;
	}

	public void setId(Integer id) {
		this.idtrimestre = id;
	}

	public Integer getNom() {
		return nom;
	}

	public void setNom(Integer nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
