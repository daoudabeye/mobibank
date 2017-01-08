package org.wallet.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pays database table.
 * 
 */
@Entity
@Table(name="pays")
@NamedQuery(name="Pay.findAll", query="SELECT p FROM Pays p")
public class Pays implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Boolean actuel;

	@Column(name="code_iso")
	private String codeIso;

	private Boolean disponible;

	private String name;

	@Column(name="tarrif_fixe")
	private double tarrifFixe;

	//bi-directional many-to-one association to Api
	@OneToMany(mappedBy="pays")
	private List<Api> apis;

	//bi-directional many-to-one association to Entite
	@OneToMany(mappedBy="pays")
	private List<Entite> entites;

	public Pays() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getActuel() {
		return this.actuel;
	}

	public void setActuel(Boolean actuel) {
		this.actuel = actuel;
	}

	public String getCodeIso() {
		return this.codeIso;
	}

	public void setCodeIso(String codeIso) {
		this.codeIso = codeIso;
	}

	public Boolean getDisponible() {
		return this.disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTarrifFixe() {
		return this.tarrifFixe;
	}

	public void setTarrifFixe(double tarrifFixe) {
		this.tarrifFixe = tarrifFixe;
	}

	public List<Api> getApis() {
		return this.apis;
	}

	public void setApis(List<Api> apis) {
		this.apis = apis;
	}

	public Api addApi(Api api) {
		getApis().add(api);
		api.setPays(this);

		return api;
	}

	public Api removeApi(Api api) {
		getApis().remove(api);
		api.setPays(null);

		return api;
	}

	public List<Entite> getEntites() {
		return this.entites;
	}

	public void setEntites(List<Entite> entites) {
		this.entites = entites;
	}

	public Entite addEntite(Entite entite) {
		getEntites().add(entite);
		entite.setPays(this);

		return entite;
	}

	public Entite removeEntite(Entite entite) {
		getEntites().remove(entite);
		entite.setPays(null);

		return entite;
	}

}