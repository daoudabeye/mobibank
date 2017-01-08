package org.wallet.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private String userId;

	private String adresse;

	@Column(name="creer_par")
	private String creerPar;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_creation")
	private Date dateCreation;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;

	private String email;

	private String genre;

	private String nom;

	@Column(name="numero_carte_identite")
	private String numeroCarteIdentite;

	private String pays;

	private String prenom;

	private String profile;

	private String region;

	@Column(name="telephone_p")
	private String telephoneP;

	@Column(name="telephone_s")
	private String telephoneS;

	@Column(name="type_carte_identite")
	private String typeCarteIdentite;

	@Column(name="valide_par")
	private String validePar;

	private String ville;

	//bi-directional many-to-one association to Compte
	@OneToMany(mappedBy="utilisateur")
	private List<Compte> comptes;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="utilisateur")
	private List<User> users;

	//bi-directional many-to-one association to Entite
	@ManyToOne
	private Entite entite;

	public Utilisateur() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCreerPar() {
		return this.creerPar;
	}

	public void setCreerPar(String creerPar) {
		this.creerPar = creerPar;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumeroCarteIdentite() {
		return this.numeroCarteIdentite;
	}

	public void setNumeroCarteIdentite(String numeroCarteIdentite) {
		this.numeroCarteIdentite = numeroCarteIdentite;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTelephoneP() {
		return this.telephoneP;
	}

	public void setTelephoneP(String telephoneP) {
		this.telephoneP = telephoneP;
	}

	public String getTelephoneS() {
		return this.telephoneS;
	}

	public void setTelephoneS(String telephoneS) {
		this.telephoneS = telephoneS;
	}

	public String getTypeCarteIdentite() {
		return this.typeCarteIdentite;
	}

	public void setTypeCarteIdentite(String typeCarteIdentite) {
		this.typeCarteIdentite = typeCarteIdentite;
	}

	public String getValidePar() {
		return this.validePar;
	}

	public void setValidePar(String validePar) {
		this.validePar = validePar;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Compte addCompte(Compte compte) {
		getComptes().add(compte);
		compte.setUtilisateur(this);

		return compte;
	}

	public Compte removeCompte(Compte compte) {
		getComptes().remove(compte);
		compte.setUtilisateur(null);

		return compte;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUtilisateur(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUtilisateur(null);

		return user;
	}

	public Entite getEntite() {
		return this.entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

}