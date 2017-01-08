package org.wallet.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="agent_id")
	private BigInteger agentId;

	@Column(name="agent_numero")
	private String agentNumero;

	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_operation")
	private Date dateOperation;

	private String details;

	private double frais;

	private double montant;

	private String statut;

	@Column(name="statut_code")
	private String statutCode;

	private String type;

	@Column(name="validation_required")
	private Boolean validationRequired;

	@Column(name="valider_par")
	private String validerPar;

	//bi-directional many-to-one association to Compte
	@ManyToOne
	@JoinColumn(name="numero_compte")
	private Compte compte;

	public Transaction() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getAgentId() {
		return this.agentId;
	}

	public void setAgentId(BigInteger agentId) {
		this.agentId = agentId;
	}

	public String getAgentNumero() {
		return this.agentNumero;
	}

	public void setAgentNumero(String agentNumero) {
		this.agentNumero = agentNumero;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateOperation() {
		return this.dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public double getFrais() {
		return this.frais;
	}

	public void setFrais(double frais) {
		this.frais = frais;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getStatutCode() {
		return this.statutCode;
	}

	public void setStatutCode(String statutCode) {
		this.statutCode = statutCode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getValidationRequired() {
		return this.validationRequired;
	}

	public void setValidationRequired(Boolean validationRequired) {
		this.validationRequired = validationRequired;
	}

	public String getValiderPar() {
		return this.validerPar;
	}

	public void setValiderPar(String validerPar) {
		this.validerPar = validerPar;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}