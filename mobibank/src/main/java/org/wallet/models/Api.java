package org.wallet.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the api database table.
 * 
 */
@Entity
@NamedQuery(name="Api.findAll", query="SELECT a FROM Api a")
public class Api implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int cost;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private String designation;

	private String name;

	@Column(name="niveau_acces")
	private int niveauAcces;

	private String password;

	private String prefixe;

	//bi-directional many-to-one association to Pay
	@ManyToOne
	@JoinColumn(name="pays_id")
	private Pays pays;

	public Api() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNiveauAcces() {
		return this.niveauAcces;
	}

	public void setNiveauAcces(int niveauAcces) {
		this.niveauAcces = niveauAcces;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrefixe() {
		return this.prefixe;
	}

	public void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}

	public Pays getPays() {
		return this.pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

}