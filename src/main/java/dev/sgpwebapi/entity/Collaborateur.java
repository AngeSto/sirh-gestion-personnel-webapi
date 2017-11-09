package dev.sgpwebapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Collaborateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ID_Departement")
	private Departement departement;
	
	@Column
	private String matricule;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@ManyToOne
	@JoinColumn(name="ID_banque")
	private Banque banque;

	public Collaborateur(){
		
	}
	
	public Collaborateur(Departement departement, String matricule, String nom, String prenom) {
		super();
		this.departement = departement;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	

	public Collaborateur(Departement departement, String matricule, String nom, String prenom, Banque banque) {
		super();
		this.departement = departement;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.banque = banque;
	}

	/**Getter for id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Getter for departement
	 * @return departement
	 */
	public Departement getDepartement() {
		return departement;
	}

	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	/**Getter for matricule
	 * @return matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**Getter for nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**Getter for prenom
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**Getter for banque
	 * @return banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	
}
