package gestionEleves.controllerForm;

import org.hibernate.validator.constraints.NotEmpty;

public class ClasseForm {
	private Integer id = null;
	private Integer idProf = null;
	
	@NotEmpty
	private String nom;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getIdProf() {
		return idProf;
	}
	public void setIdProf(Integer idProf) {
		this.idProf = idProf;
	}
}
