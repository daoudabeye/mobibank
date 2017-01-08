package org.wallet.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the coridor database table.
 * 
 */
@Entity
@NamedQuery(name="Coridor.findAll", query="SELECT c FROM Coridor c")
public class Coridor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="code_promo")
	private String codePromo;

	@Column(name="pays_dst")
	private String paysDst;

	@Column(name="pays_src")
	private String paysSrc;

	@Column(name="zone_dst")
	private String zoneDst;

	@Column(name="zone_src")
	private String zoneSrc;

	//bi-directional many-to-one association to Palier
	@OneToMany(mappedBy="coridor")
	private List<Palier> paliers;

	public Coridor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodePromo() {
		return this.codePromo;
	}

	public void setCodePromo(String codePromo) {
		this.codePromo = codePromo;
	}

	public String getPaysDst() {
		return this.paysDst;
	}

	public void setPaysDst(String paysDst) {
		this.paysDst = paysDst;
	}

	public String getPaysSrc() {
		return this.paysSrc;
	}

	public void setPaysSrc(String paysSrc) {
		this.paysSrc = paysSrc;
	}

	public String getZoneDst() {
		return this.zoneDst;
	}

	public void setZoneDst(String zoneDst) {
		this.zoneDst = zoneDst;
	}

	public String getZoneSrc() {
		return this.zoneSrc;
	}

	public void setZoneSrc(String zoneSrc) {
		this.zoneSrc = zoneSrc;
	}

	public List<Palier> getPaliers() {
		return this.paliers;
	}

	public void setPaliers(List<Palier> paliers) {
		this.paliers = paliers;
	}

	public Palier addPalier(Palier palier) {
		getPaliers().add(palier);
		palier.setCoridor(this);

		return palier;
	}

	public Palier removePalier(Palier palier) {
		getPaliers().remove(palier);
		palier.setCoridor(null);

		return palier;
	}

}