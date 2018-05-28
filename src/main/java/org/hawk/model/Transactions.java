package org.hawk.model;

import java.util.*;

public class Transactions {
	
	private double total;
	private double creditTotal;
	private double debitTotal;
	private int creditsCount;
	private int debitsCount;
	private List<Transaction> trans;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getCreditTotal() {
		return creditTotal;
	}
	public void setCreditTotal(double creditTotal) {
		this.creditTotal = creditTotal;
	}
	public double getDebitTotal() {
		return debitTotal;
	}
	public void setDebitTotal(double debitTotal) {
		this.debitTotal = debitTotal;
	}
	public int getCreditsCount() {
		return creditsCount;
	}
	public void setCreditsCount(int creditsCount) {
		this.creditsCount = creditsCount;
	}
	public int getDebitsCount() {
		return debitsCount;
	}
	public void setDebitsCount(int debitsCount) {
		this.debitsCount = debitsCount;
	}
	public List<Transaction> getTrans() {
		return trans;
	}
	public void setTrans(List<Transaction> trans) {
		this.trans = trans;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(creditTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + creditsCount;
		temp = Double.doubleToLongBits(debitTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + debitsCount;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((trans == null) ? 0 : trans.hashCode());
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
		Transactions other = (Transactions) obj;
		if (Double.doubleToLongBits(creditTotal) != Double.doubleToLongBits(other.creditTotal))
			return false;
		if (creditsCount != other.creditsCount)
			return false;
		if (Double.doubleToLongBits(debitTotal) != Double.doubleToLongBits(other.debitTotal))
			return false;
		if (debitsCount != other.debitsCount)
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (trans == null) {
			if (other.trans != null)
				return false;
		} else if (!trans.equals(other.trans))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transactions [total=" + total + ", creditTotal=" + creditTotal + ", debitTotal=" + debitTotal
				+ ", creditsCount=" + creditsCount + ", debitsCount=" + debitsCount + ", trans=" + trans + "]";
	}
	
	
	
}
