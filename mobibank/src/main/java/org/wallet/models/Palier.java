package org.wallet.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the palier database table.
 * 
 */
@Entity
@NamedQuery(name="Palier.findAll", query="SELECT p FROM Palier p")
public class Palier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double frais;

	@Column(name="montant_max")
	private double montantMax;

	@Column(name="montant_min")
	private double montantMin;

	//bi-directional many-to-one association to Coridor
	@ManyToOne
	private Coridor coridor;

	public Palier() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFrais() {
		return this.frais;
	}

	public void setFrais(double frais) {
		this.frais = frais;
	}

	public double getMontantMax() {
		return this.montantMax;
	}

	public void setMontantMax(double montantMax) {
		this.montantMax = montantMax;
	}

	public double getMontantMin() {
		return this.montantMin;
	}

	public void setMontantMin(double montantMin) {
		this.montantMin = montantMin;
	}

	public Coridor getCoridor() {
		return this.coridor;
	}

	public void setCoridor(Coridor coridor) {
		this.coridor = coridor;
	}

}