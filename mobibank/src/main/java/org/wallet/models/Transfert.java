package org.wallet.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the transfert database table.
 * 
 */
@Entity
@NamedQuery(name="Transfert.findAll", query="SELECT t FROM Transfert t")
public class Transfert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String code;

	@Column(name="commission_fixe")
	private double commissionFixe;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String devise;

	@Column(name="folio_number")
	private String folioNumber;

	private double frais;

	@Column(name="methode_livraison")
	private String methodeLivraison;

	private BigDecimal montant;

	private String mtn;

	private String note;

	@Column(name="numero_agent")
	private String numeroAgent;

	@Column(name="numero_receiver")
	private String numeroReceiver;

	@Column(name="numero_sender")
	private String numeroSender;

	private Boolean payer;

	@Column(name="receiving_contry")
	private String receivingContry;

	@Column(name="reference_envoi")
	private BigInteger referenceEnvoi;

	@Column(name="reference_reception")
	private BigInteger referenceReception;

	@Column(name="sending_contry")
	private String sendingContry;

	@Column(name="sending_date")
	private String sendingDate;

	private String statut;

	@Column(name="statut_code")
	private String statutCode;

	@Column(name="tcp_statut")
	private String tcpStatut;

	@Column(name="user_id_agent")
	private String userIdAgent;

	@Column(name="user_id_receiver")
	private BigInteger userIdReceiver;

	@Column(name="user_id_sender")
	private BigInteger userIdSender;

	public Transfert() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getCommissionFixe() {
		return this.commissionFixe;
	}

	public void setCommissionFixe(double commissionFixe) {
		this.commissionFixe = commissionFixe;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDevise() {
		return this.devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public String getFolioNumber() {
		return this.folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}

	public double getFrais() {
		return this.frais;
	}

	public void setFrais(double frais) {
		this.frais = frais;
	}

	public String getMethodeLivraison() {
		return this.methodeLivraison;
	}

	public void setMethodeLivraison(String methodeLivraison) {
		this.methodeLivraison = methodeLivraison;
	}

	public BigDecimal getMontant() {
		return this.montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public String getMtn() {
		return this.mtn;
	}

	public void setMtn(String mtn) {
		this.mtn = mtn;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNumeroAgent() {
		return this.numeroAgent;
	}

	public void setNumeroAgent(String numeroAgent) {
		this.numeroAgent = numeroAgent;
	}

	public String getNumeroReceiver() {
		return this.numeroReceiver;
	}

	public void setNumeroReceiver(String numeroReceiver) {
		this.numeroReceiver = numeroReceiver;
	}

	public String getNumeroSender() {
		return this.numeroSender;
	}

	public void setNumeroSender(String numeroSender) {
		this.numeroSender = numeroSender;
	}

	public Boolean getPayer() {
		return this.payer;
	}

	public void setPayer(Boolean payer) {
		this.payer = payer;
	}

	public String getReceivingContry() {
		return this.receivingContry;
	}

	public void setReceivingContry(String receivingContry) {
		this.receivingContry = receivingContry;
	}

	public BigInteger getReferenceEnvoi() {
		return this.referenceEnvoi;
	}

	public void setReferenceEnvoi(BigInteger referenceEnvoi) {
		this.referenceEnvoi = referenceEnvoi;
	}

	public BigInteger getReferenceReception() {
		return this.referenceReception;
	}

	public void setReferenceReception(BigInteger referenceReception) {
		this.referenceReception = referenceReception;
	}

	public String getSendingContry() {
		return this.sendingContry;
	}

	public void setSendingContry(String sendingContry) {
		this.sendingContry = sendingContry;
	}

	public String getSendingDate() {
		return this.sendingDate;
	}

	public void setSendingDate(String sendingDate) {
		this.sendingDate = sendingDate;
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

	public String getTcpStatut() {
		return this.tcpStatut;
	}

	public void setTcpStatut(String tcpStatut) {
		this.tcpStatut = tcpStatut;
	}

	public String getUserIdAgent() {
		return this.userIdAgent;
	}

	public void setUserIdAgent(String userIdAgent) {
		this.userIdAgent = userIdAgent;
	}

	public BigInteger getUserIdReceiver() {
		return this.userIdReceiver;
	}

	public void setUserIdReceiver(BigInteger userIdReceiver) {
		this.userIdReceiver = userIdReceiver;
	}

	public BigInteger getUserIdSender() {
		return this.userIdSender;
	}

	public void setUserIdSender(BigInteger userIdSender) {
		this.userIdSender = userIdSender;
	}

}