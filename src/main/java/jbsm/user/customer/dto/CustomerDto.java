package jbsm.user.customer.dto;

import java.util.Date;

public class CustomerDto {
	
	private int customerNo;
	private int customerMno;
	private String customerQue; 
	private String customerAns;
	private Date customerQdate ;
	private Date customerAdate;

	
	public CustomerDto() {
		super();
	}

	public CustomerDto(int customerNo, int customerMno, String customerQue, String customerAns, Date customerQdate,
			Date customerAdate) {
		super();
		this.customerNo = customerNo;
		this.customerMno = customerMno;
		this.customerQue = customerQue;
		this.customerAns = customerAns;
		this.customerQdate = customerQdate;
		this.customerAdate = customerAdate;
	}
	
	public CustomerDto(String customerQue, String customerAns, Date customerQdate,
			Date customerAdate) {
		super();
		this.customerQue = customerQue;
		this.customerAns = customerAns;
		this.customerQdate = customerQdate;
		this.customerAdate = customerAdate;
	}
	

	public CustomerDto(int customerNo, String customerQue, String customerAns, Date customerQdate,
			Date customerAdate) {
		// TODO Auto-generated constructor stub
		this.customerNo = customerNo;
		this.customerQue = customerQue;
		this.customerAns = customerAns;
		this.customerQdate = customerQdate;
		this.customerAdate = customerAdate;
	}

	public int getCustomerNo() {
		return customerNo;
	}


	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}


	public int getCustomerMno() {
		return customerMno;
	}


	public void setCustomerMno(int customerMno) {
		this.customerMno = customerMno;
	}

	public String getCustomerQue() {
		return customerQue;
	}


	public void setCustomerQue(String customerQue) {
		this.customerQue = customerQue;
	}

	public String getCustomerAns() {
		return customerAns;
	}


	public void setCustomerAns(String customerAns) {
		this.customerAns = customerAns;
	}


	public Date getCustomerQdate() {
		return customerQdate;
	}


	public void setCustomerQdate(Date customerQdate) {
		this.customerQdate = customerQdate;
	}


	public Date getCustomerAdate() {
		return customerAdate;
	}


	public void setCustomerAdate(Date customerAdate) {
		this.customerAdate = customerAdate;
	}



	@Override
	public String toString() {
		return "adminDto [customerNo=" + customerNo + ", customerMno=" + customerMno + ", customerQue=" + customerQue
				+ ", customerAns=" + customerAns + ", customerQdate=" + customerQdate + ", customerAdate="
				+ customerAdate + "]";
	}
	
	
	
	
}
