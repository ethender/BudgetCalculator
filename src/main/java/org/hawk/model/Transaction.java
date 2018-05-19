package org.hawk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MONEYTRANSACTION")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transid;
	@Column(name="userid")
	private int userid;
	@Column(name="amount")
	private float amount;
	@Column(name="transtype")
	private String transtype;
	@Column(name="description")
	private String desc;
	@Column(name="transtime")
	private Date transtime;
	@Column(name="category")
	private String category;
	public int getTransid() {
		return transid;
	}
	public void setTransid(int transid) {
		this.transid = transid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getTranstype() {
		return transtype;
	}
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTranstime() {
		return transtime;
	}
	public void setTranstime(Date transtime) {
		this.transtime = transtime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + transid;
		result = prime * result + ((transtime == null) ? 0 : transtime.hashCode());
		result = prime * result + ((transtype == null) ? 0 : transtype.hashCode());
		result = prime * result + userid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (transid != other.transid)
			return false;
		if (transtime == null) {
			if (other.transtime != null)
				return false;
		} else if (!transtime.equals(other.transtime))
			return false;
		if (transtype == null) {
			if (other.transtype != null)
				return false;
		} else if (!transtype.equals(other.transtype))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [transid=" + transid + ", userid=" + userid + ", amount=" + amount + ", transtype="
				+ transtype + ", desc=" + desc + ", transtime=" + transtime + ", category=" + category + "]";
	}
	
	
	
	

}
