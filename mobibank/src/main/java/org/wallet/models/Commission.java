package org.wallet.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the commissions database table.
 * 
 */
@Entity
@Table(name="commissions")
@NamedQuery(name="Commission.findAll", query="SELECT c FROM Commission c")
public class Commission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String designation;

	@Column(name="quote_part")
	private int quotePart;

	//bi-directional many-to-one association to Operation
	@ManyToOne
	private Operation operation;

	public Commission() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getQuotePart() {
		return this.quotePart;
	}

	public void setQuotePart(int quotePart) {
		this.quotePart = quotePart;
	}

	public Operation getOperation() {
		return this.operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}