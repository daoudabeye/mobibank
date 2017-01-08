package org.wallet.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the operation database table.
 * 
 */
@Entity
@NamedQuery(name="Operation.findAll", query="SELECT o FROM Operation o")
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="frais_fixe")
	private double fraisFixe;

	@Column(name="montant_jours")
	private double montantJours;

	@Column(name="montant_max")
	private double montantMax;

	@Column(name="montant_min")
	private double montantMin;

	@Column(name="nbr_max")
	private int nbrMax;

	private String type;

	//bi-directional many-to-one association to Commission
	@OneToMany(mappedBy="operation")
	private List<Commission> commissions;

	public Operation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFraisFixe() {
		return this.fraisFixe;
	}

	public void setFraisFixe(double fraisFixe) {
		this.fraisFixe = fraisFixe;
	}

	public double getMontantJours() {
		return this.montantJours;
	}

	public void setMontantJours(double montantJours) {
		this.montantJours = montantJours;
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

	public int getNbrMax() {
		return this.nbrMax;
	}

	public void setNbrMax(int nbrMax) {
		this.nbrMax = nbrMax;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Commission> getCommissions() {
		return this.commissions;
	}

	public void setCommissions(List<Commission> commissions) {
		this.commissions = commissions;
	}

	public Commission addCommission(Commission commission) {
		getCommissions().add(commission);
		commission.setOperation(this);

		return commission;
	}

	public Commission removeCommission(Commission commission) {
		getCommissions().remove(commission);
		commission.setOperation(null);

		return commission;
	}

}